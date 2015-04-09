/* Kevin Stubblefield
 * Last Updated: April 9, 2015
 * Known Bugs: None
 * Added support for images
 */

package HUD;

import Sprite.Sprite;
import Sprite.SpriteCache;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class ForcePowerSelector {
    
    private ArrayList<Sprite> forcePowers;
    private int selected;
    private float x, y;
    
    public ForcePowerSelector() {
        forcePowers = new ArrayList<>();
        forcePowers.add(SpriteCache.getSpriteCache().getSprite("res\\sprites\\hud/force_push_0.png"));//new Rectangle(32, 500, 32, 32));
        forcePowers.add(SpriteCache.getSpriteCache().getSprite("res\\sprites\\hud/force_pull_0.png"));//new Rectangle(32 + 40, 500, 32, 32));
        //forcePowers.add(new Rectangle(32 + 80, 500, 32, 32));
        
        x = 32;
        y = 500;
    }
    
    public void update() {
        if(selected < 0) {
            selected = 1;
        }
        if(selected > 1) {
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
            g.fillRect((int)(x + 40 * i), (int)y, 36, 36);
            forcePowers.get(i).render(g, (x + 40 * i), y);
        }
    }

    public int getSelected() {
        return selected;
    }

    public void setSelected(int selected) {
        this.selected = selected;
    }
    
}
