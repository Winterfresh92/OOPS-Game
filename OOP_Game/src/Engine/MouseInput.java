/* Kevin Stubblefield
 * Last Updated: March 3, 2015
 * Known Bugs: None
 */
package Engine;

import Menu.MenuScreen;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

class MouseInput implements MouseListener, MouseMotionListener {

    private GameData gameData;
    
    public MouseInput(GameData gameData) {
        this.gameData = gameData;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getX() >= 223 && e.getX() <= 577
                && e.getY() >= 233 && e.getY() <= 290) {
            gameData.getMenu().setSelected(MenuScreen.START_GAME_SELECTED);
            gameData.getGameStates().push(GameState.MISSION_01_STATE);
        }
        if(e.getX() >= 263 && e.getX() <= 541
                && e.getY() >= 317 && e.getY() <= 380) {
            gameData.getMenu().setSelected(MenuScreen.CONTINUE_SELECTED);
        }
        if(e.getX() >= 280 && e.getX() <= 521
                && e.getY() >= 410 && e.getY() <= 462) {
            gameData.getMenu().setSelected(MenuScreen.OPTIONS_SELECTED);
        }
        if(e.getX() >= 332 && e.getX() <= 470
                && e.getY() >= 495 && e.getY() <= 550) {
            gameData.getMenu().setSelected(MenuScreen.EXIT_SELECTED);
            System.exit(0);
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        if(e.getX() >= 223 && e.getX() <= 577
                && e.getY() >= 233 && e.getY() <= 290) {
            gameData.getMenu().setSelected(MenuScreen.START_GAME_SELECTED);
        }
        if(e.getX() >= 263 && e.getX() <= 541
                && e.getY() >= 317 && e.getY() <= 380) {
            gameData.getMenu().setSelected(MenuScreen.CONTINUE_SELECTED);
        }
        if(e.getX() >= 280 && e.getX() <= 521
                && e.getY() >= 410 && e.getY() <= 462) {
            gameData.getMenu().setSelected(MenuScreen.OPTIONS_SELECTED);
        }
        if(e.getX() >= 332 && e.getX() <= 470
                && e.getY() >= 495 && e.getY() <= 550) {
            gameData.getMenu().setSelected(MenuScreen.EXIT_SELECTED);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }

    @Override
    public void mouseDragged(MouseEvent e) {
       
    }
    
}
