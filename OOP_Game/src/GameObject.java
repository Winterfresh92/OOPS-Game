/* Kevin Stubblefield
 * Last Updated: February 22, 2015
 * Known Issues: None
 */

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GameObject {
    
    protected float x, y;
    protected float width, height;
    protected boolean solid;
    protected Sprite sprite;
    
    public GameObject(String ref, float x, float y) {
        if(ref != null) {
            this.sprite = SpriteCache.getSpriteCache().getSprite(ref);
        }
        this.x = x;
        this.y = y;
        if(sprite != null) {
            this.width = sprite.getWidth();
            this.height = sprite.getHeight();
        }
    }
    
    public abstract void update();
    
    public abstract void render(Graphics g);
    
    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, (int)width, (int)height);
    }
    
    public boolean getCollision(GameObject object) {
        return this.getBounds().intersects(object.getBounds());
    }

    public boolean isSolid() {
        return solid;
    }

    public void setSolid(boolean solid) {
        this.solid = solid;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public Sprite getSprite() {
        return sprite;
    }

    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }
    
}
