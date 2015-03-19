package Object;

/* Kevin Stubblefield
 * Last Updated: February 22, 2015
 * Known Bugs: None
 * Added clipping boolean, press K to toggle!
 */

import Sprite.Sprite;
import Sprite.SpriteCache;
import Engine.GameData;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Map;


public class Player extends GameObject {

    private float velX, velY;
    private float power = 64;
    private boolean left, right, up, down;
    private String facing;
    private int playerSpeed = 5;
    private int health;
    private boolean clipping;
    private Sprite h;
    
    private GameData gameData;
    
    private Inventory inventory;
    
    public Player(String ref, float x, float y) {
        super(ref, x, y);
        clipping = true;
        velX = velY = playerSpeed;
        health = 10;
        velX = velY = 0;
        inventory = new Inventory();
        this.h = SpriteCache.getSpriteCache().getSprite("res\\sprites\\hud/player_health_0.png"); 
    }
    
    @Override
    public void update() {
        x += velX;
        y += velY;
        
        if(right){
            velX = playerSpeed;
        }
        if(left){
            velX = -playerSpeed;
        }
        if(up){
            velY = -playerSpeed;
        }
        if(down){
            velY = playerSpeed;
        }
        
        if(gameData.isLoaded() && clipping) {
            checkCollisions();
        }
    }

    static int counter = 0;
    
    public void hit(GameObject g)
    {
        // This is implemented only for demo purposes. It will be implemented fully later when the enemy will be implemented
        
        if(g instanceof Enemy)
        {
            if(counter == 0)
            {
                this.health -= 5;
                h = SpriteCache.getSpriteCache().getSprite("res\\sprites\\hud/player_health_5.png");
                System.out.println("Player hit "+ health);
                counter ++;
            }
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
                        y = object.getY() + object.getHeight();
                        if(counter == 0)
                        {
                            this.hit(object);
                        }
                    }
                    if(getBoundsBottom().intersects(object.getBounds())) {
                        y = object.getY() - height;
                        if(counter == 0)
                        {
                            this.hit(object);
                        }
                    }
                    if(getBoundsRight().intersects(object.getBounds())) {
                        x = object.getX() - width;
                        if(counter == 0)
                        {
                            this.hit(object);
                        } 
                    }
                    if(getBoundsLeft().intersects(object.getBounds())) {
                        x = object.getX() + object.getWidth();
                        if(counter == 0)
                        {
                            this.hit(object);
                        }
                    }
                }
            }
           
        }
         
    }
    
    public void ForcePush() {
        System.out.println("Force Push activated");
        for(GameObject object : gameData.getObjects()) {
            if(object instanceof CollidableObject) {
                CollidableObject temp = (CollidableObject) object;
                if(temp.isSolid() && temp.isMobile()) {
                    
                    if (y+64 == temp.getY() && facing.equals("down")) {
                            if (temp.getX() <= x + 63 && temp.getX() >= x - 63) {
                                System.out.println("first if statement called");
                                System.out.println("Player position: " + x + ", " + y);
                                System.out.println("Object Position: " + temp.x + ", " + temp.y);
                                temp.y += power;
                                temp.getCollision(object);
                            }
                    }
                    else if(y-64 == temp.getY() && facing.equals("up")) {
                        if (temp.getX() <= x + 63 && temp.getX() >= x - 63) {
                            System.out.println("second if statement called");
                            temp.y -= power;
                        }
                    }
                    else if(x+64 == temp.getX() && facing.equals("right")) {
                        if (temp.getY() <= y + 63 && temp.getY() >= y - 63) {
                            System.out.println("third if statement called");
                            temp.x += power;
                        }
                  }
                  else if(x-64 == temp.getX() && facing.equals("left")) {
                      if(temp.getY() <= y + 63 && temp.getY() >= y - 63) {
                        System.out.println("fourth if statement called");
                        temp.x -= power;
                      }
                  }
                }
            }
        }
    }
    
    public void ForcePull() {
        System.out.println("Force Pull activated");
        for(GameObject object : gameData.getObjects()) {
            if(object instanceof CollidableObject) {
                CollidableObject temp = (CollidableObject) object;
                if(temp.isSolid() && temp.isMobile()) {
                    if(y+128 >= temp.getY() && facing.equals("down")) {
                        if(temp.getX() <= x+63 && temp.getX() >= x-63) {
                            System.out.println("first if statement called");
                            temp.y -= power;
                        }
                    }
                    else if(y-128 >= temp.getY() && facing.equals("up")) {
                        if(temp.getX() <= x+63 && temp.getX() >= x-63) {
                            System.out.println("second if statement called");
                            temp.y += power;
                        }
                    }
                    else if(x+128 >= temp.getX() && facing.equals("right")) {
                        if(temp.getY() <= y+63 && temp.getY() >= y-63) {
                            System.out.println("third if statement called");
                            temp.x -= power;
                        }
                    }
                    else if(x-128 >= temp.getX() && facing.equals("left")) {
                        if(temp.getY() <= y+63 && temp.getY() >= y-63) {
                            System.out.println("fourth if statement called");
                            temp.x += power;
                        }
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
    
    public void setFacing(String facing) {
        this.facing = facing;
    }
    
    public String getFacing() {
        return facing;
    }
    
    public void setPower(float power) {
        this.power = power;
    }
    
    public float getPower() {
        return power;
    }
}
