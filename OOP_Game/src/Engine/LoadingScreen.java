/* Kevin Stubblefield
 * Last Updated: April 4, 2015
 * Known Bugs: None
 * Changed to the static loading screen image.
 */

package Engine;

import Sprite.Sprite;
import Sprite.SpriteCache;
import java.awt.Graphics;

public class LoadingScreen {
    
    private Sprite image;
    
    public LoadingScreen() {
        image = SpriteCache.getSpriteCache().getSprite("res\\sprites\\background/loading.png");
    }
    
    public void update() {
    }
    
    public void render(Graphics g) {
        image.render(g, 0, 0);
    }
    
}
