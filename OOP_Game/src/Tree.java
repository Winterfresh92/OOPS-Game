/* Kevin Stubblefield
 * Last Updated: February 22, 2015
 * Known Bugs: None
 * This is only a class to demo collision and will be removed in the future
 */

import java.awt.Color;
import java.awt.Graphics;

public class Tree extends GameObject {

    public Tree(String ref, float x, float y) {
        super(ref, x, y);
        this.width = 48;
        this.height = 48;
    }

    @Override
    public void update() {
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect((int)x, (int)y, (int)48, (int)48);
    }    
    
}
