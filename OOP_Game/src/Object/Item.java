package Object;

/* Kevin Stubblefield
 * Last Updated: March 17, 2015
 * Known Bugs: None
 * Added quantity member and increment/decrement functions
 */

import java.awt.Graphics;

public class Item extends GameObject {
    
    protected String name;
    protected int quantity;
    protected boolean collected;
    
    public Item(String ref, float x, float y, boolean collected) {
        super(ref, x, y);
        quantity = 0;
        this.collected = collected;
    }
    
    public Item(String ref, float x, float y) {
        super(ref, x, y);
        this.name = name;
        quantity = 0;
        collected = false;
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
    
    public void use(GameObject object) {
        
    }
    
    public void increment() {
        quantity += 1;
    }
    
    public void decrement() {
        quantity -= 1;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
}
