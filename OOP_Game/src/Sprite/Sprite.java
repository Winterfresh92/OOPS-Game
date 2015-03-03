package Sprite;

/* Kevin Stubblefield
 * Last Updated: February 22, 2015
 * Known Bugs: None
 */

import java.awt.Graphics;
import java.awt.Image;

public class Sprite {
    
    private Image image;
    
    public Sprite(Image image) {
        this.image = image;
    }
    
    public void render(Graphics g, float x, float y) {
        g.drawImage(image, (int)x, (int)y, null);
    }

    public int getWidth() {
        return image.getWidth(null);
    }

    public int getHeight() {
        return image.getHeight(null);
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
    
}
