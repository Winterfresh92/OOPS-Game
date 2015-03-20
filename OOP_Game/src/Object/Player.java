package Object;

/* Kevin Stubblefield
 * Last Updated: March 19, 2015
 * Known Bugs: When changing directions, the last frame from the previous animation
 *             renders briefly. If two directional buttons are pressed at the
 *             same time, both animations play (will likely require adjusting
 *             animation class to account for direction rather than player class.
 * Added clipping boolean, press K to toggle!
 * Implemented Animation
 */

import Sprite.Sprite;
import Sprite.SpriteCache;
import Engine.GameData;
import Sprite.Animation;
import java.awt.Color;
import java.awt.Graphics;


public class Player extends GameObject {

    private int dir = 0; // direction up: 0, down: 1, right: 2, left: 3
    private boolean left, right, up, down;
    private int playerSpeed = 5;
    private int health;
    private boolean clipping;
    private Sprite h;
    private Animation walkingUp;
    private Animation walkingDown;
    private Animation walkingRight;
    private Animation walkingLeft;
    
    private GameData gameData;
    
    private Inventory inventory;
    
    public Player(String ref, float x, float y) {
        super(ref, x, y);
        this.width = 64;
        this.height = 64;
        clipping = true;
        velX = velY = playerSpeed;
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
    }
    
    @Override
    public void update() {
        x += velX;
        y += velY;
        
        if(!up && !down && !right && !left) {
            checkDirection();
        }
        
        if(up){
            dir = 0;
            velY = -playerSpeed;
            walkingUp.update();
        }
        if(down){
            dir = 1;
            velY = playerSpeed;
            walkingDown.update();
        }
        if(right){
            dir = 2;
            velX = playerSpeed;
            walkingRight.update();
        }
        if(left){
            dir = 3;
            velX = -playerSpeed;
            walkingLeft.update();
        }
        
        if(gameData.isLoaded() && clipping) {
            checkCollisions();
        }
        
        System.out.println("PLAYER HEALTH: " + health);
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
    
}
