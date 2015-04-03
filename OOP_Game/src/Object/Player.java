package Object;

/* Kevin Stubblefield
 * Last Updated: March 19, 2015
 * Known Bugs: When changing directions, the last frame from the previous animation
 *             renders briefly. If two directional buttons are pressed at the
 *             same time, both animations play (will likely require adjusting
 *             animation class to account for direction rather than player class.
/* Zain Chishti
 * Last Updated: March 19, 2015
 * Known Bugs: None
 * Added clipping boolean, press K to toggle!
 * Implemented Animation
 *
 * Carlos Pena
 * Added 2 classes, PowerSelected() to determine which power to use
 * Force() to use the choosen power
 */

import Engine.Game;
import Sprite.Sprite;
import Sprite.SpriteCache;
import Engine.GameData;
import Music.SoundEffects;
import Sprite.Animation;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Map;


public class Player extends GameObject {

    private float power = 64;
    private int dir = 0; // direction up: 0, down: 1, right: 2, left: 3
    private boolean left, right, up, down;
    private int playerSpeed = 5;
    private int health;
    private boolean clipping;
    private boolean push, pull;
    private Sprite h;
    private Animation walkingUp;
    private Animation walkingDown;
    private Animation walkingRight;
    private Animation walkingLeft;
    
    private float lastX;
    private float lastY;
    
    private boolean isColliding;
    private boolean lastCollison;
    private boolean playerHit;
    private String direction;
    private String facing;
    private GameData gameData;
    private Inventory inventory;
    
    public Player(String ref, float x, float y) {
        super(ref, x, y);
        this.width = 64;
        this.height = 64;
        lastX = x;
        lastY = y;
        isColliding = false;
        lastCollison = false;
        playerHit = false;
        clipping = true;
        health = 10;
        velX = velY = 0;
        inventory = new Inventory(this);
        this.h = SpriteCache.getSpriteCache().getSprite("res\\sprites\\hud/player_health_0.png");
        walkingUp = new Animation(150);
        walkingDown = new Animation(150);
        walkingRight = new Animation(300);
        walkingLeft = new Animation(300);
        walkingUp.add(SpriteCache.getSpriteCache().getSprite("res\\sprites\\player\\back/player_back_0.png"));
        walkingUp.add(SpriteCache.getSpriteCache().getSprite("res\\sprites\\player\\back/player_back_1.png"));
        walkingUp.add(SpriteCache.getSpriteCache().getSprite("res\\sprites\\player\\back/player_back_2.png"));
        walkingUp.add(SpriteCache.getSpriteCache().getSprite("res\\sprites\\player\\back/player_back_3.png"));
        walkingDown.add(SpriteCache.getSpriteCache().getSprite("res\\sprites\\player\\front/player_front_0.png"));
        walkingDown.add(SpriteCache.getSpriteCache().getSprite("res\\sprites\\player\\front/player_front_1.png"));
        walkingDown.add(SpriteCache.getSpriteCache().getSprite("res\\sprites\\player\\front/player_front_2.png"));
        walkingDown.add(SpriteCache.getSpriteCache().getSprite("res\\sprites\\player\\front/player_front_3.png"));
        walkingRight.add(SpriteCache.getSpriteCache().getSprite("res\\sprites\\player\\right/player_right_0.png"));
        walkingRight.add(SpriteCache.getSpriteCache().getSprite("res\\sprites\\player\\right/player_right_1.png"));
        walkingLeft.add(SpriteCache.getSpriteCache().getSprite("res\\sprites\\player\\left/player_left_0.png"));
        walkingLeft.add(SpriteCache.getSpriteCache().getSprite("res\\sprites\\player\\left/player_left_1.png"));
        inventory.add(new Heart("res\\sprites\\items/heart_item_0.png", 0, 0, true));
        inventory.add(new Heart("res\\sprites\\items/heart_item_0.png", 0, 0, true));
        inventory.add(new Heart("res\\sprites\\items/heart_item_0.png", 0, 0, true));
        inventory.add(new HalfHeart("res\\sprites\\items/heart_item_1.png", 0, 0, true));
        inventory.add(new HalfHeart("res\\sprites\\items/heart_item_1.png", 0, 0, true));
        direction = "";
        facing = "";
        this.h = SpriteCache.getSpriteCache().getSprite("res\\sprites\\hud/player_health_0.png"); 
    }
    
    @Override
    public void update() {
        
        lastX = x;
        lastY = y;
        
        x += velX;
        y += velY;
        
        if(!up && !down && !right && !left) {
            checkDirection();
        }
        if(up){
            dir = 0;
            walkingUp.update();
            direction = "up";
        }
        if(down){
            dir = 1;
            walkingDown.update();
            direction = "down";
        }
        if(right){
            dir = 2;
            walkingRight.update();
            direction = "right";
        }
        if(left){
            dir = 3;
            walkingLeft.update();
            direction = "left";
        }
        
        if(gameData.isLoaded() && clipping) {
            checkCollisions();
       //     System.out.println(isColliding + "  " + lastCollison);
            if(lastCollison == false && isColliding == true)
            {
                playerHit = true;
            }
           lastCollison = isColliding;
        }
        
        //System.out.println("PLAYER HEALTH: " + health);
    }

    static int counter = 1;
    
    public void hit(GameObject g)
    {
        // This is implemented only for demo purposes. It will be implemented fully later when the enemy will be implemented
        
        if(g instanceof Enemy)
        {
            if(x != lastX)
            {
                this.health -= 2;
                if(counter <= 9)
                {
                    h = SpriteCache.getSpriteCache().getSprite("res\\sprites\\hud/player_health_"+ counter +".png");
                    counter ++;
                }
            }
            
            
         /*   if (playerHit == true)
            {
                this.health -= 2;
                System.out.println("health : " + this.health);
            } */
        }
        
        if(g instanceof InteractableObject){
            InteractableObject interact = (InteractableObject) g;
            if(interact.interact()){
                gameData.getNextQueue();
            }
            else{

                gameData.addToQueue(new TextBox("res\\sprites/text_box_0.png", Game.WIDTH / 10, (Game.HEIGHT - Game.HEIGHT / 3) - 40, interact.getDefaultText(), true));
            }
        }
    }
    
    
    @Override
    public void render(Graphics g) {
        if(!up && !down && !right && !left) {
            if(sprite != null) {
                sprite.render(g, x, y);
            }
        }
        
        if(up) {
            walkingUp.render(g, x, y);
        }
        if(down) {
            walkingDown.render(g, x, y);
        }
        if(right) {
            walkingRight.render(g, x, y);
        }
        if(left) {
            walkingLeft.render(g, x, y);
        }
        
        g.setColor(Color.green);
       // g.fillRect((int)this.x-230,(int)this.y-200,(health*100)/10,10);
        h.render(g, (int)this.x-300,(int)this.y-220);
    }
    
    public void toggleClipping() {
        clipping = !clipping;
    }
    
    public Rectangle lookAround()
    {
        Rectangle rect;
        if(direction == "up")
        {
            rect = new Rectangle((int)this.getX(),(int)this.getY()-64,64,64);
            return rect;
        }
        else if (direction == "right")
        {
            rect = new Rectangle((int)this.getX()+(int)this.getWidth(),(int)this.getY(),64,64);
            return rect;
        }
        else if (direction == "down")
        {
            rect = new Rectangle((int)this.getX(),(int)this.getY() +(int)this.getHeight(),64,64);
            return rect;
        }
        else if (direction == "left")
        {
            rect = new Rectangle((int)this.getX()-64,(int)this.getY(),64,64);
            return rect;
        }
        else // else returns the default rect for "up" direction 
        {
            rect = new Rectangle((int)this.getX(),(int)this.getY()-64,64,64);
            return rect;
        }
    }
    
    public void checkCollisions() {
        int counter = 0;
        for(GameObject object : gameData.getObjects()) {
            if(object instanceof Item) {
                if(this.getCollision(object)) {
                    Item item = (Item) object;
                    inventory.add(item);
                    item.setCollected(true);
                }
            }
            
            if(object instanceof CollidableObject) {
                CollidableObject temp = (CollidableObject) object;
                if(temp.isSolid()) {
                    if(getBoundsTop().intersects(object.getBounds())) {
                        isColliding  = true;
                        y = object.getY() + object.getHeight(); 
                        this.hit(object);
                        
                    }
                    else if(getBoundsBottom().intersects(object.getBounds())) {
                        isColliding  = true;
                        y = object.getY() - height;
                        this.hit(object);
                        
                    }
                    else if(getBoundsRight().intersects(object.getBounds())) {
                        isColliding  = true;
                        System.out.println(isColliding);
                        x = object.getX() - width;
                        this.hit(object);
                         
                    }
                    else if(getBoundsLeft().intersects(object.getBounds())) {
                        isColliding  = true;
                        x = object.getX() + object.getWidth();
                        this.hit(object);
                    }
                    else 
                    {
                        isColliding = false;
                       
                    }
                }
                
            }
           
        }
         
    }
    
    public void powerSelected(int selected) {
        switch(selected) {
            case 0:
                push = true;
                pull = false;
                Force();
                break;
            case 1:
                push = false;
                pull = true;
                Force();
                break;
        }
    }
    
    public void Force() {
        boolean move = true;
        if (push) {
            System.out.println("Force Push activated");
            for (GameObject object : gameData.getObjects()) {
                if (object instanceof CollidableObject) {
                    CollidableObject temp = (CollidableObject) object;
                    if (temp.isSolid() && temp.isMobile()) {
                        if (y + 64 == temp.getY() && facing.equals("down")) {   //down
                            if (temp.getX() <= x + 63 && temp.getX() >= x - 63) {
                                for (GameObject object2 : gameData.getObjects()) {
                                    if (object2 instanceof CollidableObject) {
                                        CollidableObject next = (CollidableObject) object2;
                                        if (next.isSolid()) {
                                            if (temp.y + 64 == next.getY()) {
                                               if (next.getX() <= temp.x + 10 && next.getX() >= temp.x - 10) {
                                                    move = false;
                                                    break;
                                                } 
                                            } else {
                                                move = true;
                                            }
                                        }
                                    }
                                }
                                if (move) {
                                    SoundEffects.ForcePush.play();
                                    temp.y += power;
                                }
                            }
                        } else if (y - 64 == temp.getY() && facing.equals("up")) { //up
                            if (temp.getX() <= x + 63 && temp.getX() >= x - 63) {
                                for (GameObject object2 : gameData.getObjects()) {
                                    if (object2 instanceof CollidableObject) {
                                        CollidableObject next = (CollidableObject) object2;
                                        if (next.isSolid()) {
                                            if (temp.y - 64 == next.getY()) {
                                               if (next.getX() <= temp.x + 10 && next.getX() >= temp.x - 10) {
                                                    move = false;
                                                    break;
                                                } 
                                            } else {
                                                move = true;
                                            }
                                        }
                                    }
                                }
                                if (move) {
                                    SoundEffects.ForcePush.play();
                                    temp.y -= power;
                                }
                            }
                        } else if (x + 64 == temp.getX() && facing.equals("right")) {   //right
                            if (temp.getY() <= y + 63 && temp.getY() >= y - 63) {
                                for (GameObject object3 : gameData.getObjects()) {
                                    if (object3 instanceof CollidableObject) {
                                        CollidableObject next = (CollidableObject) object3;
                                        if (next.isSolid() && !next.isMobile()) {
                                            if(next.getX() <= temp.x + 70 && next.getX() >= temp.x - 70) {
                                                if (next.getY() <= temp.y + 10 && next.getY() >= temp.y - 10) {
                                                    move = false;
                                                    break;
                                                } 
                                            } else {
                                                move = true;
                                            }
                                        }
                                    }
                                }
                                if (move) {
                                    SoundEffects.ForcePush.play();
                                    temp.x += power;
                                }
                            }
                        } else if (x - 64 == temp.getX() && facing.equals("left")) {    //left
                            if (temp.getY() <= y + 63 && temp.getY() >= y - 63) {
                                for (GameObject object4 : gameData.getObjects()) {
                                    if (object4 instanceof CollidableObject) {
                                        CollidableObject next = (CollidableObject) object4;
                                        if (next.isSolid() && !next.isMobile()) {
                                            if (next.getX() <= temp.x + 70 && next.getX() >= temp.x - 70) {
                                              if (next.getY() <= temp.y + 10 && next.getY() >= temp.y - 10) {
                                                    move = false;
                                                    break;
                                                } 
                                            } else {
                                                move = true;
                                            }
                                        }
                                    }
                                }
                                if (move) {
                                    SoundEffects.ForcePush.play();
                                    temp.x -= power;
                                }
                            }
                        }
                    }
                }
            }
        }
        else if (pull) {
            System.out.println("Force Pull activated");
            for (GameObject object : gameData.getObjects()) {
                if (object instanceof CollidableObject) {
                    CollidableObject temp = (CollidableObject) object;
                    if (temp.isSolid() && temp.isMobile()) {
                        if (y + 128 >= temp.getY() && temp.getY() >= y - 128 && facing.equals("down")) { //down
                            if (temp.getX() <= x + 10 && temp.getX() >= x - 10) {
                                SoundEffects.ForcePull.play();
                                temp.y -= power;
                            }
                        } else if (y - 128 <= temp.getY()&& y + 128 >= temp.getY() && facing.equals("up")) { //up
                            if (temp.getX() <= x + 63 && temp.getX() >= x - 63) {
                                SoundEffects.ForcePull.play();
                                temp.y += power;
                            }
                        } else if (x + 128 >= temp.getX() && temp.getX() >= x - 128 && facing.equals("right")) { //right
                                if (temp.getY() <= y + 63 && temp.getY() >= y - 63) {
                                    SoundEffects.ForcePull.play();
                                    temp.x -= power;
                                }
                        } else if (x - 128 <= temp.getX() && x + 128 >= temp.getX() && facing.equals("left")) { //left
                            if (temp.getY() <= y + 63 && temp.getY() >= y - 63) {
                                SoundEffects.ForcePull.play();
                                temp.x += power;
                            }
                        }
                    }
                }
            }
        }
    }

    private void checkDirection() {
        switch(dir) {
            case 0: // up
                sprite = SpriteCache.getSpriteCache().getSprite(
                        "res\\sprites\\player\\back/player_back_0.png"
                );
                break;
            case 1: // down
                sprite = SpriteCache.getSpriteCache().getSprite(
                        "res\\sprites\\player\\front/player_front_0.png"
                );
                break;
            case 2: // right
                sprite = SpriteCache.getSpriteCache().getSprite(
                        "res\\sprites\\player\\right/player_right_0.png"
                );
                break;
            case 3:
                sprite = SpriteCache.getSpriteCache().getSprite(
                        "res\\sprites\\player\\left/player_left_0.png"
                );
                break;
        }
    }
    
    public boolean isLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public boolean isUp() {
        return up;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public boolean isDown() {
        return down;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

    public int getPlayerSpeed() {
        return playerSpeed;
    }

    public void setPlayerSpeed(int playerSpeed) {
        this.playerSpeed = playerSpeed;
    }

    public GameData getGameData() {
        return gameData;
    }

    public void setGameData(GameData gameData) {
        this.gameData = gameData;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public boolean isClipping() {
        return clipping;
    }

    public void setClipping(boolean clipping) {
        this.clipping = clipping;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public float getLastX() {
        return lastX;
    }

    public float getLastY() {
        return lastY;
    }

    public void setLastX(float lastX) {
        this.lastX = lastX;
    }

    public void setLastY(float lastY) {
        this.lastY = lastY;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getFacing() {
        return facing;
    }

    public void setFacing(String facing) {
        this.facing = facing;
    }
    
}