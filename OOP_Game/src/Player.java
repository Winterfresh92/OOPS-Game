/* Kevin Stubblefield
 * Last Updated: February 12, 2015
 * Known Bugs: None
 */

import java.awt.Color;
import java.awt.Graphics;


public class Player extends GameObject {

    private float velX, velY;
    
    public Player(float x, float y, float width, float height) {
        super(x, y, width, height);
        velX = velY = 5;
    }
    
    @Override
    public void update() {
        if(KeyInput.isRight()){
            x += velX;
        }
        if(KeyInput.isLeft()){
            x -= velX;
        }
        if(KeyInput.isUp()){
            y -= velY;
        }
        if(KeyInput.isDown()){
            y += velY;
        }
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect((int)x, (int)y, (int)width, (int)height);
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
    
}
