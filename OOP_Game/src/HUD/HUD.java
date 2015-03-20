package HUD;

/* Kevin Stubblefield
 * Last Updated: March 17, 2015
 * Known Bugs: None
 * Added ForcePowerSelector to the class
 */

import Object.Player;
import java.awt.Graphics;

public class HUD {
    
    private Player player;
    private ForcePowerSelector selector;
    
    public HUD(Player player) {
        this.player = player;
        selector = new ForcePowerSelector();
    }
    
    public void update() {
        selector.update();
    }
    
    public void render(Graphics g) {
        selector.render(g);
    }
    
    public ForcePowerSelector getSelector() {
        return selector;
    }

    public void setSelector(ForcePowerSelector selector) {
        this.selector = selector;
    }
    
}
