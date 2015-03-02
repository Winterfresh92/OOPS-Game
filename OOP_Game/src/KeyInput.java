/* Kevin Stubblefield
 * Last Updated: February 25, 2015
 * Known Bugs: None
*/
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyInput implements KeyListener {
    
    private static boolean right = false;
    private static boolean left = false;
    private static boolean up = false;
    private static boolean down = false;
    
    private GameData gameData;
    
    public KeyInput(GameData gameData){
        this.gameData = gameData;
    }
    
    @Override
    public void keyPressed(KeyEvent e)
    {
        if(gameData.getGameStates().peek() == GameState.MENU_STATE) {
            if(e.getKeyCode() == KeyEvent.VK_ENTER) { // Select menu item
                if(gameData.getMenu().getSelected() == MenuScreen.START_GAME_SELECTED) {
                    gameData.getGameStates().pop();
                    gameData.getGameStates().push(GameState.MISSION_01_STATE);
                    //gameData.getGameStates().push(GameState.MISSION_TEST_STATE);
                } else if(gameData.getMenu().getSelected() == MenuScreen.CONTINUE_SELECTED) {
                    
                } else if(gameData.getMenu().getSelected() == MenuScreen.OPTIONS_SELECTED) {
                    
                } else if(gameData.getMenu().getSelected() == MenuScreen.EXIT_SELECTED) {
                    System.exit(0);
                }
            } else if(e.getKeyCode() == KeyEvent.VK_UP) { // Navigate up menu
                if(gameData.getMenu().getSelected() == MenuScreen.START_GAME_SELECTED) {
                    gameData.getMenu().setSelected(MenuScreen.EXIT_SELECTED);
                } else if(gameData.getMenu().getSelected() == MenuScreen.CONTINUE_SELECTED) {
                    gameData.getMenu().setSelected(MenuScreen.START_GAME_SELECTED);
                } else if(gameData.getMenu().getSelected() == MenuScreen.OPTIONS_SELECTED) {
                    gameData.getMenu().setSelected(MenuScreen.CONTINUE_SELECTED);
                } else if(gameData.getMenu().getSelected() == MenuScreen.EXIT_SELECTED) {
                    gameData.getMenu().setSelected(MenuScreen.OPTIONS_SELECTED);
                }
            } else if(e.getKeyCode() == KeyEvent.VK_DOWN) { // Navigate down menu
                if(gameData.getMenu().getSelected() == MenuScreen.START_GAME_SELECTED) {
                    gameData.getMenu().setSelected(MenuScreen.CONTINUE_SELECTED);
                } else if(gameData.getMenu().getSelected() == MenuScreen.CONTINUE_SELECTED) {
                    gameData.getMenu().setSelected(MenuScreen.OPTIONS_SELECTED);
                } else if(gameData.getMenu().getSelected() == MenuScreen.OPTIONS_SELECTED) {
                    gameData.getMenu().setSelected(MenuScreen.EXIT_SELECTED);
                } else if(gameData.getMenu().getSelected() == MenuScreen.EXIT_SELECTED) {
                    gameData.getMenu().setSelected(MenuScreen.START_GAME_SELECTED);
                }
            }
        } else {
            if(e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_RIGHT){
                if(gameData.getTextBoxQueue().isEmpty() || !gameData.getTextBoxQueue().peek().isPriority()) {
                    gameData.getPlayer().setRight(true);
                }
            } 
            if(e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_LEFT){
                if(gameData.getTextBoxQueue().isEmpty() || !gameData.getTextBoxQueue().peek().isPriority()) {
                    gameData.getPlayer().setLeft(true);
                }
            }
            if(e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_UP){
                if(gameData.getTextBoxQueue().isEmpty() || !gameData.getTextBoxQueue().peek().isPriority()) {
                    gameData.getPlayer().setUp(true);
                }
            }
            if(e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_DOWN){
                if(gameData.getTextBoxQueue().isEmpty() || !gameData.getTextBoxQueue().peek().isPriority()) {
                    gameData.getPlayer().setDown(true);
                }
            }
            if(e.getKeyCode() == KeyEvent.VK_SPACE) {
                if(!gameData.getTextBoxQueue().isEmpty()) {
                    gameData.getTextBoxQueue().poll();
                }
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        if(e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            gameData.getPlayer().setRight(false);
        }
        if(e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_LEFT)
        {
            gameData.getPlayer().setLeft(false);
        }
        if(e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_UP){
          gameData.getPlayer().setUp(false);
       }
       if(e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_DOWN){
          gameData.getPlayer().setDown(false);
       }
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        
    }
    
}
