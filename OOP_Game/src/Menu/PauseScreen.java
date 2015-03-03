package Menu;

/* Carlos Peña III
 * Last Updated: March 2, 2015
 * Known Bugs: None
 */

import Sprite.Sprite;
import Sprite.SpriteCache;
import Engine.Game;
import java.util.ArrayList;
import java.awt.Graphics;

public class PauseScreen {
    
    public final static int ResumeSelected = 1000;
    public final static int OptionsSelected = 1001;
    public final static int ExitSelected = 1002;
    
    private Game game;
    private int selected;
    private long lastDisplay;
    
    private ArrayList<Sprite>PauseImages;
    
    public PauseScreen(Game game) {
        this.game = game;
        lastDisplay = System.currentTimeMillis();
        selected = ResumeSelected;
        PauseImages = new ArrayList<>();
        PauseImages.add(SpriteCache.getSpriteCache().getSprite("res\\sprites/ResumeSelected.png"));
        PauseImages.add(SpriteCache.getSpriteCache().getSprite("res\\sprites/OptionsSelected.png"));
        PauseImages.add(SpriteCache.getSpriteCache().getSprite("res\\sprites/ExitSelected.png"));
    }
    
    public void update() {
        if(System.currentTimeMillis() - lastDisplay >= 5000) {
            System.out.println("SELECTED = " + selected);
            lastDisplay = System.currentTimeMillis();
        }
    }
    
    public void render(Graphics g) {
        if(selected == ResumeSelected) {
            PauseImages.get(0).render(g, 200, 100);
        }
        else if(selected == OptionsSelected) {
            PauseImages.get(1).render(g, 200, 100);
        }
        else if(selected == ExitSelected) {
            PauseImages.get(2).render(g, 200, 100);
        }
    }
    
    public void setSelect(int selected) {
        this.selected = selected;
    }
    
    public int getSelect() {
        return selected;
    }
}
