package Object;

/* Chris Graff
 * Last Updated: March 10, 2015
 * Known Bugs: None
 */

import java.awt.Graphics;
public class TriggerBox extends GameObject{

    public TriggerBox(String ref, float x, float y) { //default constructor is useless. Must use Full Constructor
        super(ref, -500, -500);
        super.setHeight(0);
        super.setWidth(0);
    }

    @Override
    public void update() {
        //eh. check for collision?
    }

    @Override
    public void render(Graphics g) {
        //do NOTHING. Does not render.
    }
    
}
