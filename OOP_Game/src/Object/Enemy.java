/**
 *
 * @author Zain
 * 
 * Kevin Stubblefield
 * Last Updated: April 4, 2015
 * Known Bugs: None
 * Removed hitBy method, it was not used. Changed inheritance to GameObject
 * Added collision functions, gameData member, and health member
 */

package Object;


import Engine.GameData;
import java.awt.Graphics;

public class Enemy extends GameObject {
    
    protected GameData gameData;
    protected boolean isColliding;
    protected int health;
    
    Enemy(String ref, float x, float y, GameData gameData)
    {
        super(ref,x,y);
        this.gameData = gameData;
        this.solid = true;
    }
    
     public Enemy(String ref, float x, float y, boolean solid, boolean mobile, GameData gameData) {
        super(ref, x, y);
        this.gameData = gameData;
        this.width = 64;
        this.height = 64;
        this.solid = solid;
        this.mobile = mobile;
    }

    @Override
    public void update() {
    }

    @Override
    public void render(Graphics g) {
        sprite.render(g, x, y);
    }
    
    public void checkCollisions() {
        int counter = 0;
        for(GameObject object : gameData.getObjects()) {
            if(object instanceof CollidableObject) {
                CollidableObject temp = (CollidableObject) object;
                if(temp.isSolid()) {
                    if(getBoundsTop().intersects(temp.getBounds())) {
                        isColliding  = true;
                        y = temp.getY() + temp.getHeight();
                    }
                    else if(getBoundsBottom().intersects(temp.getBounds())) {
                        isColliding  = true;
                        y = temp.getY() - height;
                    }
                    else if(getBoundsRight().intersects(temp.getBounds())) {
                        isColliding  = true;
                        x = temp.getX() - width;
                    }
                    else if(getBoundsLeft().intersects(temp.getBounds())) {
                        isColliding  = true;
                        x = temp.getX() + temp.getWidth();
                    }
                    else 
                    {
                        isColliding = false;
                       
                    }
                }   
            }
        }
    }
     
}
