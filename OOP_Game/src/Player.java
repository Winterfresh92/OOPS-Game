/* Kevin Stubblefield
 * Last Updated: February 22, 2015
 * Known Bugs: None
 */

import java.awt.Graphics;
import java.util.Map;


public class Player extends GameObject {

    private float velX, velY;
    private boolean left, right, up, down;
    private int playerSpeed = 5;
    private int health;
    
    private GameData gameData;
    
    private Inventory inventory;
    
    public Player(String ref, float x, float y) {
        super(ref, x, y);

        velX = velY = playerSpeed;
        health = 10;
        velX = velY = 0;
        inventory = new Inventory();
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
        
        if(gameData.isLoaded()) {
            checkCollisions();
        }
    }

    public void hit()
    {
        this.health -= 2;
    }
    
    
    @Override
    public void render(Graphics g) {
        sprite.render(g, x, y);
        
        for(Map.Entry<String, Item> item : inventory.getItems().entrySet()) {
            item.getValue().getSprite().render(g, x + width / 2, y + item.getValue().getHeight() + 5);
        }
    }
    
    public void checkCollisions() {
        for(GameObject object : gameData.getObjects()) {
            if(object instanceof Item) {
                if(this.getCollision(object)) {
                    Item item = (Item) object;
                    inventory.add(item);
                    item.setCollected(true);
                }
            }
            
            if(object instanceof CollidableObject) {
                if(getBoundsTop().intersects(object.getBounds())) {
                    y = object.getY() + object.getHeight();
                }
                if(getBoundsBottom().intersects(object.getBounds())) {
                    y = object.getY() - height;
                }
                if(getBoundsRight().intersects(object.getBounds())) {
                    x = object.getX() - width;
                }
                if(getBoundsLeft().intersects(object.getBounds())) {
                    x = object.getX() + object.getWidth();
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
    
}
