/* Kevin Stubblefield
 * Last Updated: March 17, 2015
 * Known Bugs: None
 * Created class
 */

package HUD;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

public class ForcePowerSelector {
    
    private ArrayList<Rectangle> forcePowers;
    private int selected;
    
    public ForcePowerSelector() {
        forcePowers = new ArrayList<>();
        forcePowers.add(new Rectangle(32, 500, 32, 32));
        forcePowers.add(new Rectangle(32 + 40, 500, 32, 32));
        forcePowers.add(new Rectangle(32 + 80, 500, 32, 32));
    }
    
    public void update() {
        if(selected < 0) {
            selected = 2;
        }
        if(selected > 2) {
            selected = 0;
        }
    }
    
    public void render(Graphics g) {
        for(int i = 0; i < forcePowers.size(); i++) {
            if(selected == i) {
                g.setColor(Color.green);
            } else {
                g.setColor(Color.red);
            }
            g.fillRect(forcePowers.get(i).x, forcePowers.get(i).y, forcePowers.get(i).width, forcePowers.get(i).height);
        }
    }

    public int getSelected() {
        return selected;
    }

    public void setSelected(int selected) {
        this.selected = selected;
    }
    
}
