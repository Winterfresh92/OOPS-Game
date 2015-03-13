/* Kevin Stubblefield
 * Last Updated: March 10, 2015
 * Known Bugs: None
 * Created class to implement loading screen
 */

package Engine;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

public class LoadingScreen {
    
    private long lastUpdate;
    private int delay;
    private ArrayList<String> loadingStrings;
    private int currentString;
    
    public LoadingScreen() {
        delay = 500;
        lastUpdate = System.currentTimeMillis();
        loadingStrings = new ArrayList<>();
        loadingStrings.add("Loading");
        loadingStrings.add("Loading.");
        loadingStrings.add("Loading..");
        loadingStrings.add("Loading...");
    }
    
    public void update() {
        if(System.currentTimeMillis() - lastUpdate >= delay) {
            currentString++;
            if(currentString >= loadingStrings.size()) {
                currentString = 0;
            }
            lastUpdate = System.currentTimeMillis();
        }
    }
    
    public void render(Graphics g) {
        g.setColor(Color.black);
        g.drawRect(0, 0, Game.WIDTH, Game.HEIGHT);
        g.setColor(Color.white);
        g.setFont(new Font("Serif", Font.ITALIC, 48));
        g.drawString(loadingStrings.get(currentString), 15, Game.HEIGHT - 60);
    }
    
}
