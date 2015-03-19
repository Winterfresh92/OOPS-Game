package Object;

/* Zain Chishti
 * Last Updated: March 19, 2015
 * Known Bugs: None
 * Added clipping boolean, press K to toggle!
 */

import Sprite.Sprite;
import Sprite.SpriteCache;
import Engine.GameData;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Map;


public class Player extends GameObject {

    private float velX, velY;
    private boolean left, right, up, down;
    private int playerSpeed = 5;
    private int health;
    private boolean clipping;
    private Sprite h;
    
    private float lastX;
    private float lastY;
    
    private boolean isColliding;
    
    private boolean lastCollison;
    
    private boolean playerHit;
    
    private String direction;
    
    private GameData gameData;
    
    private Inventory inventory;
    
    public Player(String ref, float x, float y) {
        super(ref, x, y);
        lastX = x;
        lastY = y;
        isColliding = false;
        lastCollison = false;
        playerHit = false;
        clipping = true;
        velX = velY = playerSpeed;
        health = 10;
        velX = velY = 0;
        direction = "";
        inventory = new Inventory();
        this.h = SpriteCache.getSpriteCache().getSprite("res\\sprites\\hud/player_health_0.png"); 
    }
    
    @Override
    public void update() {
        
        lastX = x;
        lastY = y;
        
        x += velX;
        y += velY;
        
        if(right){
            velX = playerSpeed;
            direction = "right"; 
        }
        if(left){
            velX = -playerSpeed;
            direction = "left";
        }
        if(up){
            velY = -playerSpeed;
            direction = "up";
        }
        if(down){
            velY = playerSpeed;
            direction = "down";
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
    }
    
    
    @Override
    public void render(Graphics g) {
        sprite.render(g, x, y);
        g.setColor(Color.green);
       // g.fillRect((int)this.x-230,(int)this.y-200,(health*100)/10,10);
        h.render(g, (int)this.x-300,(int)this.y-220);
        for(Map.Entry<String, Item> item : inventory.getItems().entrySet()) {
            item.getValue().getSprite().render(g, x + width / 2, y + item.getValue().getHeight() + 5);
        }
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

    public float getVelX() {
        return velX;
    }

    public void setVelX(float velX) {
        this.velX = velX;
    }

    public float getVelY() {
        return velY;
    }

    public void setVelY(float velY) {
        this.velY = velY;
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
    
    
    
}
