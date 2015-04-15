/* Kevin Stubblefield
 * Last Updated: April 4, 2015
 * Known Bugs: None
 * Changed to the static loading screen image.
 */

package Engine;

import Sprite.Sprite;
import Sprite.SpriteCache;
import java.awt.Graphics;

public class IntroScreen {
    
    private Sprite image;
    private int x;
    private int y;
    private int timer;
    
    public IntroScreen() {
        image = SpriteCache.getSpriteCache().getSprite("res\\sprites/StarWarsALLTAIAGFFA(transparent).png");
        this.x = 40;
        this.y = 550;
        timer = 0;
    }
    
    public void update() {
        timer ++;
        if(timer >=2){
            y -= 1;
            timer = 0;
        }
    }
    
    public void render(Graphics g) {
        image.render(g, x, y);
    }
    
    public boolean finished(){
        return this.y < -1640;
    }
    
}
