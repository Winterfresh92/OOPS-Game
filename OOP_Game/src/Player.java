/* Kevin Stubblefield
 * Last Updated: February 22, 2015
 * Known Bugs: None
 */

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;


public class Player extends GameObject {

    private float velX, velY;
    private boolean left, right, up, down;
    private int playerSpeed = 5;
    private int health;
    
    public Player(String ref, float x, float y) {
        super(ref, x, y);
        velX = velY = playerSpeed;
        health = 10;
    }
    
    @Override
    public void update() {
        if(right){
            x += velX;
        }
        if(left){
            x -= velX;
        }
        if(up){
            y -= velY;
        }
        if(down){
            y += velY;
        }
    }

    public void hit()
    {
        this.health -= 2;
    }
    
    
    @Override
    public void render(Graphics g) {
        sprite.render(g, x, y);
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
    
}
