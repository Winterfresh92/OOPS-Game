/* Kevin Stubblefield
 * Last Updated: February 12, 2015
 * Known Bugs: None
 * This is only a class to demo collision and will be removed in the future
 */

import java.awt.Color;
import java.awt.Graphics;

public class Tree extends GameObject {

    public Tree(float x, float y, float width, float height) {
        super(x, y, width, height);
    }

    @Override
    public void update() {
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect((int)x, (int)y, (int)width, (int)height);
    }    
    
}
