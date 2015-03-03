/* Kevin Stubblefield
 * Last Updated: March 2, 2015
 * Known Bugs: None
 * Added a background to the screen
 */

import java.awt.Graphics;
import java.util.ArrayList;

public class MenuScreen {
    
    public final static int START_GAME_SELECTED = 1000;
    public final static int CONTINUE_SELECTED = 1001;
    public final static int OPTIONS_SELECTED = 1002;
    public final static int EXIT_SELECTED = 1003;
    
    private Game game;
    private int selected;
    private long lastDisplay;
    
    private ArrayList<Sprite> menuImages;
    
    public MenuScreen(Game game) {
        this.game = game;
        lastDisplay = System.currentTimeMillis();
        selected = START_GAME_SELECTED;
        
        menuImages = new ArrayList<>();
        menuImages.add(SpriteCache.getSpriteCache().getSprite("res\\sprites\\background/menu_bg_0.jpg"));
        menuImages.add(SpriteCache.getSpriteCache().getSprite("res\\sprites/start_game_selected.png"));
        menuImages.add(SpriteCache.getSpriteCache().getSprite("res\\sprites/continue_selected.png"));
        menuImages.add(SpriteCache.getSpriteCache().getSprite("res\\sprites/options_selected.png"));
        menuImages.add(SpriteCache.getSpriteCache().getSprite("res\\sprites/exit_selected.png"));
    }
    
    public void update() {
        if(System.currentTimeMillis() - lastDisplay >= 5000) {
            System.out.println("SELECTED = " + selected);
            lastDisplay = System.currentTimeMillis();
        }
        if(selected == START_GAME_SELECTED) {
            
        } else if(selected == CONTINUE_SELECTED) {
            
        } else if(selected == OPTIONS_SELECTED) {
            
        } else if(selected == EXIT_SELECTED) {
            
        }
    }
    
    public void render(Graphics g) {
        menuImages.get(0).render(g, 0, 0);
        if(selected == START_GAME_SELECTED) {
            menuImages.get(1).render(g, 0, 0);
        } else if(selected == CONTINUE_SELECTED) {
            menuImages.get(2).render(g, 0, 0);
        } else if(selected == OPTIONS_SELECTED) {
            menuImages.get(3).render(g, 0, 0);
        } else if(selected == EXIT_SELECTED) {
            menuImages.get(4).render(g, 0, 0);
        }
    }

    public int getSelected() {
        return selected;
    }

    public void setSelected(int selected) {
        this.selected = selected;
    }
    
}
