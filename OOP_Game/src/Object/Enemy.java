/**
 *
 * @author Zain
 * 
 * Kevin Stubblefield
 * Last Updated: April 4, 2015
 * Known Bugs: None
 * Removed hitBy method, it was not used. Changed inheritance to GameObject
 * Added collision functions, gameData member, and health member
 * 
 * Carlos Peña
 * Last Updated: April 16, 2015
 * Known Bugs: Some Mechanics may not work completely right
 * Added Attack(), and Fire(), modified update() for enemy movement. Added Fight(), direction()
 */
package Object;

import Engine.GameData;
import Sprite.Sprite;
import Sprite.SpriteCache;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Enemy extends GameObject {

    protected GameData gameData;
    protected boolean isColliding;
    protected boolean lastCollision;
    protected int health;
    protected Player player;
    protected float velX, velY;
    protected float boltx;
    protected float bolty;
    protected int enemyspeed = 3;
    protected float boltVelX;
    protected int boltspeed = 3;
    protected float start;
    protected boolean ranged;
    protected boolean fired;
    protected boolean swing;
    protected String direction;
    protected Sprite bullet;
    private boolean aggressor;
    private String dead;
    private int damage;
    Rectangle bolt;

    Enemy(String ref, float x, float y, GameData gameData) {
        super(ref, x, y);
        this.gameData = gameData;
        this.solid = true;
        this.aggressor = true;
        damage = 1;
    }
    
     public Enemy(String ref, float x, float y, boolean solid, boolean mobile, GameData gameData, boolean ranged) {
        super(ref, x, y);
        this.gameData = gameData;
        this.width = 64;
        this.height = 64;
        this.solid = solid;
        this.mobile = mobile;
        velX = velY = enemyspeed;
        start = x;
        player = gameData.getPlayer();
        health = 3;
        this.ranged = ranged;
        damage = 1;
        this.aggressor = true;
    }

    public Enemy(String ref, String dead, float x, float y, boolean solid, boolean mobile, GameData gameData, int health, int damage, boolean aggressor) {
        super(ref, x, y);
        this.gameData = gameData;
        this.width = 64;
        this.height = 64;
        this.solid = solid;
        this.mobile = mobile;
        if (aggressor) {
            velX = velY = enemyspeed;
        } else {
            velX = velY = 0;
        }
        start = x;
        player = gameData.getPlayer();
        this.health = health;
        this.aggressor = aggressor;
        this.dead = dead;
    }

    @Override
    public void update() {
        if(!Attack()) {
            if(lastCollision) {
                System.out.println("collision detected");
                if(velX == enemyspeed) {
                    System.out.println("positive called");
                    start = x-254;
                    System.out.println(start + ", " + x);
                    lastCollision = false;
                    x -= velX;
                    System.out.println(start + ", " + x);
                }
                else if(velX == -enemyspeed) {
                    System.out.println("negative called");
                    start = x+254;
                    System.out.println(start + ", " + x);
                    lastCollision = false;
                    x -= velX;
                    System.out.println(start + ", " + x);
                }
            }
            else {
                x += velX;
            }
        }
        
        if(x < start-250 && !Attack()) {
            System.out.println("2 movement called");
                velX = enemyspeed;
        }
        else if(x > start+250 && !Attack()) { 
            System.out.println("3 movement called");
                velX = -enemyspeed;
        }
        else if(Attack() && ranged) {
            if(fired) {
                boltx += boltVelX;
            }
            else{
                boltx = x;
                bolty = y;
            }
            Fire();               
        }
        else if(Attack() && !ranged) {
            if(swing) {
                System.out.println("swing called");
            }
            Fight();
        }
        else if(fired) {
            boltx += boltVelX;
            Fire();
        }
        checkCollisions();
        if(lastCollision == true && isColliding == false) {
            lastCollision = false;
        }
    }

    public boolean Attack() {
        if (player.x >= x && player.x <= x + 128 && aggressor) { //right side of enemy
            if (player.y <= y && player.y >= y - 128) { //top of enemy
                return true;
            } else if (player.y >= y && player.y <= y + 128) { //bottom of enemy
                return true;
            }
        } else if (player.x <= x && player.x >= x - 128 && aggressor) { //left of enemy
            if (player.y <= y && player.y >= y - 128) {
                return true;
            } else if (player.y >= y && player.y <= y + 128) {
                return true;
            }
        }
        return false;
    }

    public void Fire() {
        if(!fired) {
            fired = true;
            boltx = x+10;
            bolty = y+32;
            bullet = SpriteCache.getSpriteCache().getSprite("res\\sprites/enemies/bullet.png");
            if(player.getX() > x) {
                boltVelX = boltspeed;
            }
            else if(player.getX() < x) {
                boltVelX = -boltspeed;
            }
            else if(player.getY() > y) {
               
            }
            else if(player.getY() < y) {
                
            }
        }
        for (GameObject object : gameData.getObjects()) {
            if (object instanceof Player) {
                if (object.x <= boltx && object.x+64 >= boltx) {
                    if (object.y >= bolty && object.y <= y+25) {
                        System.out.println("Collision");
                        fired = false;
                        player.hit(this);
                    } 
                    else if (object.y <= bolty && object.y >= y-25) {
                        System.out.println("Collision");
                        fired = false;
                        player.hit(this);
                    }
                }
            } 
            else if (object instanceof CollidableObject) {
                if (object.isSolid()) {
                    if (object.x <= boltx && object.x+64 >= boltx) {
                        if (object.y <= bolty && object.y >= y-70) {
                            fired = false;
                            System.out.println("collision");
                        } else if (object.y >= bolty && object.y <= y+70) {
                            System.out.println("collision");
                            fired = false;
                        }
                        if (object instanceof Enemy) {
                            fired = true;
                        }
                    }
                } 
                else if (object.x <= boltx && object.x >= x-64) {
                    if (object.y >= bolty && object.y <= y+64) {
                        System.out.println("collision");
                        fired = false;
                        if (object instanceof Enemy) {
                            fired = true;
                        }
                    }
                } 
                else if (object.x >= boltx && object.x <= x-64) {
                    if (object.y <= bolty && object.y >= y-64) {
                        System.out.println("collision");
                        fired = false;
                        if (object instanceof Enemy) {
                            fired = true;
                        }
                    }
                } 
                else if (object.x <= boltx && object.x >= x-64) {
                    if (object.y >= bolty && object.y <= y+64) {
                        System.out.println("collision");
                        fired = false;
                        if (object instanceof Enemy) {
                            fired = true;
                        }
                    }
                }
            }
        }
        if(boltx > 1000) {
            fired = false;
        }
        
        if(boltx < -1000) {
            fired = false;
        }
    }
    
    public void Fight() {
        for(GameObject object : gameData.getObjects()) {
            if(object instanceof Player) {
                if(y < object.y) { //player below
                    if(object.x < x+64 && object.x > x-64) {
                        direction = "down";
                        try {
                            Rectangle rect = direction(1, direction);
                            System.out.println("down swing");
                            if(rect.contains(object.getX()+32, object.getY()+32)) {
                                player.hit(this);
                            }
                        
                        } catch (InterruptedException ex) {
                        }
                    }
                }
                else if(x < object.x) { //right
                    if(object.y < y+64 && object.y > y-64) {
                        direction = "right";
                        try {
                            Rectangle rect = direction(1, direction);
                            System.out.println("right swing");
                            if(rect.contains(object.getX()+32, object.getY()+32)) {
                                player.hit(this);
                            }
                        
                        } catch (InterruptedException ex) {
                        }
                    }
                }
                else if(y > object.y) { //up
                    if(object.x < x+64 && object.x > x-64) {
                        direction = "up";
                        try {
                            Rectangle rect = direction(1, direction);
                            System.out.println("up swing");
                            if(rect.contains(object.getX()+32, object.getY()+32)) {
                                player.hit(this);
                            }
                        
                        } catch (InterruptedException ex) {
                        }
                    }
                }
                else if(x > object.x) { //left
                    if(object.y < y+64 && object.y > y-64) {
                        direction = "left";
                        try {
                            Rectangle rect = direction(1, direction);
                            System.out.println("left swing");
                            if(rect.contains(object.getX()+32, object.getY()+32)) {
                                player.hit(this);
                            }
                        
                        } catch (InterruptedException ex) {
                        }
                    }
                }
            }
        }
        
    }
    
    public Rectangle direction(int x, String dir) throws InterruptedException {
        Rectangle rect;
        if(dir == "up") {
            if(x == 0) {
                rect = new Rectangle((int)this.getX(), (int)this.getY()-64, 64, 64);
                return rect;
            }
            else if(x == 1) {
                rect = new Rectangle((int)this.getX(), (int)this.getY()-64, 64, 64);
                swing = true;
                //TimeUnit.MILLISECONDS.sleep(50);
                swing = false;
                return rect;
            }
            else {
                return new Rectangle(0,0,0,0);
            }
        }
        else if(dir == "right") {
            if(x == 0) {
                rect = new Rectangle((int)this.getX()+(int)this.getWidth(), (int)this.getY(),64,64);
                return rect;
            }
            else if(x == 1) {
                rect = new Rectangle((int)this.getX()+(int)this.getWidth(), (int)this.getY(),64,64);
                swing = true;
                //TimeUnit.MILLISECONDS.sleep(150);
                swing = false;
                return rect;
            }
            else {
                return new Rectangle(0,0,0,0);
            }
        }
        else if(dir == "down") {
            if(x == 0) {
                rect = new Rectangle((int)this.getX(), (int)this.getY() + (int)this.getHeight(),64,64);
                return rect;
            }
            else if(x == 1) {
                rect = new Rectangle((int)this.getX(), (int)this.getY() + (int)this.getHeight(),64,64);
                swing = true;
               // TimeUnit.MILLISECONDS.sleep(500);
                swing = false;
                return rect;
            }
            else { 
                return new Rectangle(0,0,0,0);
            }
        }
        else if(dir == "left") {
            if(x == 0) {
                rect = new Rectangle((int)this.getX()-64, (int)this.getY(), 64,64);
                return rect;
            }
            if(x == 1) {
                rect = new Rectangle((int)this.getX()-64, (int)this.getY(),64,64);
                swing = true;
               // TimeUnit.MILLISECONDS.sleep(150);
                swing = false;
                return rect;
            }
            else {
                return new Rectangle(0,0,0,0);
            }
        }
        else {
            rect = new Rectangle((int)this.getX(), (int)this.getY()-64,64,64);
            return rect;
        }
    }

    @Override
    public void render(Graphics g) {
        sprite.render(g, x, y);
        if(fired) {
            bullet.render(g, boltx, bolty);
        }
        g.setColor(Color.green);
        g.fillRect((int) this.x, (int) this.y - 20, (health * 100) / 10, 10);
    }

    public void checkCollisions() {
        int counter = 0;
        for (GameObject object : gameData.getObjects()) {
            if (object instanceof CollidableObject) {
                CollidableObject temp = (CollidableObject) object;
                if(temp.isSolid()) {
                    if(getBoundsTop().intersects(temp.getBounds())) {
                        isColliding  = true;
                        lastCollision = true;
                        y = temp.getY() + temp.getHeight();
                    }
                    else if(getBoundsBottom().intersects(temp.getBounds())) {
                        isColliding  = true;
                        lastCollision = true;
                        y = temp.getY() - height;
                    }
                    else if(getBoundsRight().intersects(temp.getBounds())) {
                        isColliding  = true;
                        lastCollision = true;
                        x = temp.getX() - width;
                    }
                    else if(getBoundsLeft().intersects(temp.getBounds())) {
                        isColliding  = true;
                        lastCollision = true;
                        x = temp.getX() + temp.getWidth();
                    } else {
                        isColliding = false;
                    }
                    if(isColliding == true) {
                        lastCollision = true;
                    }
                }   
            }
        }
    }

    public void hit() {
        this.health -= 1;
        if (health < 0) {
            this.health = 0;
            this.aggressor = false;
            this.solid = false;
            this.mobile = false;
            this.sprite = SpriteCache.getSpriteCache().getSprite(this.dead);
        }
    }

    public int getHeath() {
        return this.health;
    }

    public void setHealth(int h) {
        this.health = h;
    }

    public String getDead() {
        return this.dead;
    }

    public void setDead(String dead) {
        this.dead = dead;
    }

    public int getDamage() {
        return this.damage;
    }

    public void setDamate(int damage) {
        this.damage = damage;
    }

    public void switchAggressor() {
        this.aggressor = !this.aggressor;
    }

    public boolean getAggressor() {
        return aggressor;
    }
}
