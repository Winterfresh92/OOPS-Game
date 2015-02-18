/* Kevin Stubblefield
 * Last Updated: 2/7/2015
 * Known Issues: None
 * 
 * Future Functionality: Make the text automatically insert a new line
 *      when the text reaches the end of the textbox for ease of
 *      programming (low priority).
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Text extends GameObject {
    
    private String text;
    private boolean italicized;
    
    public Text(float x, float y, float width, float height, String text) {
        super(x, y, width, height);
        this.text = text;
        this.italicized = false;
    }
    
    public Text(float x, float y, float width, float height, String text, boolean italicized) {
        super(x, y, width, height);
        this.text = text;
        this.italicized = italicized;
    }
    
    @Override
    public void update() {
        
    }
    
    @Override
    public void render(Graphics g) {
        if(italicized) {
            g.setFont(new Font("Sans Serif", Font.ITALIC, 18));
        } else {
            g.setFont(new Font("Sans Serif", Font.PLAIN, 18));
        }
        g.setColor(Color.WHITE);
        drawString(g, text, (int)x, (int)y);
    }
    
    public void drawString(Graphics g, String text, int x, int y) {
        int lineNum = 0;
        for(String line : text.split("\n")) {
            if(lineNum == 0) {
                g.drawString(line, x, y);
            } else {
                g.drawString(line, x, y += g.getFontMetrics().getHeight());
            }
            lineNum++;
        }
    }
    
    public String getText() {
        return this.text;
    }
    
    public void setText(String text) {
        this.text = text;
    }
    
}
