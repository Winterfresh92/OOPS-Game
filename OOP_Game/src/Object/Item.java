package Object;

/* Kevin Stubblefield
 * Last Updated: March 2, 2015
 * Known Bugs: None
 */

import java.awt.Graphics;

public class Item extends GameObject {
    
    private String name;
    boolean collected;
    
    public Item(String ref, float x, float y) {
        super(ref, x, y);
    }

    @Override
    public void update() {
        
    }

    @Override
    public void render(Graphics g) {
        if(!collected) {
            sprite.render(g, x, y);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCollected() {
        return collected;
    }

    public void setCollected(boolean collected) {
        this.collected = collected;
    }
    
}
