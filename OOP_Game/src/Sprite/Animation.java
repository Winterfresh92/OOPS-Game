/* Kevin Stubblefield
 * Last Updated: March 10, 2015
 * Known Bugs: None
 * Created class and implemented slightly crude animation
 */
package Sprite;

import java.awt.Graphics;
import java.util.ArrayList;

public class Animation {
    
    // Delay is the time in milliseconds between frames
    private int delay;
    // lastUpdate is the last time a frame was switched
    private long lastUpdate;
    // currentFrame keeps track of which frame in the array is currently being
    // displayed
    private int currentFrame;
    // direction may keep track of direction, possible fix for bugs in
    // displaying player animation
    private int direction;
    private ArrayList<Sprite> sprites;
    
    public Animation(int delay) {
        this.delay = delay;
        currentFrame = 0;
        lastUpdate = System.currentTimeMillis();
        sprites = new ArrayList<>();
    }
    
    public void update() {
        if(System.currentTimeMillis() - lastUpdate >= delay) {
            currentFrame++;
            if(currentFrame >= sprites.size()) {
                currentFrame = 0;
            }
            lastUpdate = System.currentTimeMillis();
        }
    }
    
    public void render(Graphics g, float x, float y) {
        sprites.get(currentFrame).render(g, (int)x, (int)y);
    }
    
    public void add(Sprite sprite) {
        sprites.add(sprite);
    }
}
