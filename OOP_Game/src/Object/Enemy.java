/**
 *
 * @author Zain
 *
 * Kevin Stubblefield Last Updated: April 4, 2015 Known Bugs: None Removed hitBy
 * method, it was not used. Changed inheritance to GameObject Added collision
 * functions, gameData member, and health member
 *
 * Carlos Peña Last Updated: April 9, 2015 Known Bugs: None Added Attack(), and
 * Fire(), modified update() for enemy movement
 */
package Object;

import Engine.GameData;
import Sprite.SpriteCache;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Enemy extends GameObject {

    protected GameData gameData;
    protected boolean isColliding;
    protected int health;
    protected Player player;
    protected float velX, velY;
    protected int enemyspeed = 3;
    protected float start;
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

    public Enemy(String ref, float x, float y, boolean solid, boolean mobile, GameData gameData) {
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
        if (!Attack() && aggressor) {
            x += velX;
        }
        if (x < start - 250 && !Attack() && aggressor) {
            velX = enemyspeed;
        } else if (x > start + 250 && !Attack() && aggressor) {
            velX = -enemyspeed;
        }
        checkCollisions();
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
        float boltx = x;
        float bolty = y;
        bolt = new Rectangle((int) boltx, (int) bolty, 32, 32);
    }

    @Override
    public void render(Graphics g) {
        sprite.render(g, x, y);
        g.setColor(Color.green);
        g.fillRect((int) this.x, (int) this.y - 20, (health * 100) / 10, 10);
    }

    public void checkCollisions() {
        int counter = 0;
        for (GameObject object : gameData.getObjects()) {
            if (object instanceof CollidableObject) {
                CollidableObject temp = (CollidableObject) object;
                if (temp.isSolid()) {
                    if (getBoundsTop().intersects(temp.getBounds())) {
                        isColliding = true;
                        y = temp.getY() + temp.getHeight();
                    } else if (getBoundsBottom().intersects(temp.getBounds())) {
                        isColliding = true;
                        y = temp.getY() - height;
                    } else if (getBoundsRight().intersects(temp.getBounds())) {
                        isColliding = true;
                        x = temp.getX() - width;
                    } else if (getBoundsLeft().intersects(temp.getBounds())) {
                        isColliding = true;
                        x = temp.getX() + temp.getWidth();
                    } else {
                        isColliding = false;
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
