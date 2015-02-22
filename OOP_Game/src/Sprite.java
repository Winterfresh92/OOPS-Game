/* Kevin Stubblefield
 * Last Updated: February 22, 2015
 * Known Bugs: None
 */

import java.awt.Image;

public class Sprite {
    
    private Image image;
    private int width, height;
    
    public Sprite(Image image) {
        this.image = image;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
    
}
