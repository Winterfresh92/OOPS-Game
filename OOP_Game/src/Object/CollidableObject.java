package Object;

/* Kevin Stubblefield
 * Last Updated: February 22, 2015
 * Known Bugs: None
 */

import java.awt.Color;
import java.awt.Graphics;

public class CollidableObject extends GameObject {

    public CollidableObject(String ref, float x, float y) {
        super(ref, x, y);
        this.width = 64;
        this.height = 64;
        this.solid = true;
    }
    
    public CollidableObject(String ref, float x, float y, boolean solid, boolean mobile) {
        super(ref, x, y);
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
        if (super.sprite != null) {
            sprite.render(g, x, y);
        } else {
            g.setColor(Color.BLUE);
            g.fillRect((int) x, (int) y, (int) width, (int) height);
        }
    }

}
