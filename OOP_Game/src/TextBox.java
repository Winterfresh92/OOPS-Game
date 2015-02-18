/* Kevin Stubblefield
 * Last Updated: 2/7/2015
 * Known Issues: None
 * This class will display a textbox on the screen that will hold text.
*/

import java.awt.Color;
import java.awt.Graphics;

public class TextBox extends GameObject {

    private Text text;
    private boolean priority;
    int delay = 0;
    
    public TextBox(float x, float y, float width, float height, String text) {
        super(x, y, width, height);
        this.text = new Text(x + 10, y + 25, 0, 0, text);
        this.width = Game.WIDTH * 0.78f;
        this.height = Game.HEIGHT / 6;
        priority = true;
    }
    
    public TextBox(float x, float y, float width, float height, String text, boolean italicized) {
        super(x, y, width, height);
        this.text = new Text(x + 10, y + 25, 0, 0, text, italicized);
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
