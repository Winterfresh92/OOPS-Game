/* Kevin Stubblefield
 * Last Updated: 2/22/2015
 * Known Issues: None
 * This class will display a textbox on the screen that will hold text.
*/

import java.awt.Color;
import java.awt.Graphics;

public class TextBox extends GameObject {

    private Text text;
    private boolean priority;
    int delay = 0;
    
    public TextBox(String ref, float x, float y, String text) {
        super(ref, x, y);
        this.text = new Text(null, x + 10, y + 25, text);
        this.width = Game.WIDTH * 0.78f;
        this.height = Game.HEIGHT / 6;
        priority = true;
    }
    
    public TextBox(String ref, float x, float y, String text, boolean italicized) {
        super(ref, x, y);
        this.text = new Text(null, x + 10, y + 25, text, italicized);
        this.width = Game.WIDTH * 0.78f;
        this.height = Game.HEIGHT / 6;
        priority = true;
    }
    
    @Override
    public void update() {
        
    }
    
    @Override
    public void render(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect((int)x, (int)y, (int)width, (int)height);
        text.render(g);
    }

    public boolean isPriority() {
        return priority;
    }

    public void setPriority(boolean priority) {
        this.priority = priority;
    }
    
}
