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
    private Music music = GameData.background;
    
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
                    music.Menu = false;
                    music.Pause();
                    music.play();
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
        } else if(gameData.getGameStates().peek() == GameState.PAUSE_STATE) {
            if(e.getKeyCode() == KeyEvent.VK_ENTER) { //Select item
                if(gameData.getPause().getSelect() == PauseScreen.ResumeSelected) {
                    gameData.getGame().getGameLoop().resume();
                    gameData.getGameStates().pop();
                    music.play();
                }
                else if (gameData.getPause().getSelect() == PauseScreen.OptionsSelected) {
                    
                }                
                else if(gameData.getPause().getSelect() == PauseScreen.ExitSelected) {
                    System.exit(0);
                }
            }
            else if(e.getKeyCode() == KeyEvent.VK_UP) { //up navigation
                if(gameData.getPause().getSelect() == PauseScreen.ResumeSelected) {
                    gameData.getPause().setSelect(PauseScreen.ExitSelected);
                }
                else if(gameData.getPause().getSelect() == PauseScreen.OptionsSelected) {
                    gameData.getPause().setSelect(PauseScreen.ResumeSelected);
                }
                else if(gameData.getPause().getSelect() == PauseScreen.ExitSelected) {
                    gameData.getPause().setSelect(PauseScreen.OptionsSelected);
                }
            }
            else if(e.getKeyCode() == KeyEvent.VK_DOWN) { //down navigation
                if(gameData.getPause().getSelect() == PauseScreen.ResumeSelected) {
                    gameData.getPause().setSelect(PauseScreen.OptionsSelected);
                }
                else if(gameData.getPause().getSelect() == PauseScreen.OptionsSelected) {
                    gameData.getPause().setSelect(PauseScreen.ExitSelected);
                }
                else if(gameData.getPause().getSelect() == PauseScreen.ExitSelected) {
                    gameData.getPause().setSelect(PauseScreen.ResumeSelected);
                }
            } 
        } else {
            if(e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_RIGHT){
                if(gameData.getTextBoxQueue().isEmpty() || !gameData.getTextBoxQueue().peek().isPriority()) {
                    gameData.getPlayer().setRight(true);
                    gameData.getPlayer().setVelX(gameData.getPlayer().getPlayerSpeed());
                }
            } 
            if(e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_LEFT){
                if(gameData.getTextBoxQueue().isEmpty() || !gameData.getTextBoxQueue().peek().isPriority()) {
                    gameData.getPlayer().setLeft(true);
                    gameData.getPlayer().setVelX(-gameData.getPlayer().getPlayerSpeed());
                }
            }
            if(e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_UP){
                if(gameData.getTextBoxQueue().isEmpty() || !gameData.getTextBoxQueue().peek().isPriority()) {
                    gameData.getPlayer().setUp(true);
                    gameData.getPlayer().setVelY(-gameData.getPlayer().getPlayerSpeed());
                }
            }
            if(e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_DOWN){
                if(gameData.getTextBoxQueue().isEmpty() || !gameData.getTextBoxQueue().peek().isPriority()) {
                    gameData.getPlayer().setDown(true);
                    gameData.getPlayer().setVelY(gameData.getPlayer().getPlayerSpeed());
                }
            }
            if(e.getKeyCode() == KeyEvent.VK_SPACE) {
                if(!gameData.getTextBoxQueue().isEmpty()) {
                    gameData.getTextBoxQueue().poll();
                }
            }
            if(e.getKeyCode() == KeyEvent.VK_M) {
                if(Music.volume != Music.Volume.Mute) {
                    music.Mute();
                }
                else {
                    Music.volume = Music.Volume.Medium;
                    music.play();
                }
            }
            if(e.getKeyCode() == KeyEvent.VK_N) {
                music.next();
            }
            if(e.getKeyCode() == KeyEvent.VK_P) {
                gameData.getGameStates().push(GameState.PAUSE_STATE);
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        if(e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            gameData.getPlayer().setRight(false);
            gameData.getPlayer().setVelX(0);
        }
        if(e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_LEFT)
        {
            gameData.getPlayer().setLeft(false);
            gameData.getPlayer().setVelX(0);
        }
        if(e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_UP){
          gameData.getPlayer().setUp(false);
          gameData.getPlayer().setVelY(0);
       }
       if(e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_DOWN){
          gameData.getPlayer().setDown(false);
          gameData.getPlayer().setVelY(0);
       }
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        
    }
    
}
