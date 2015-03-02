/* Kevin Stubblefield
 * Last Updated: February 22, 2015
 * Known Bugs: None
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

// Handles all updates in the game and holds all data
public class GameData {
    
    Game game;
    private TextBox textBox;
    private TextBox nullBox;
    private LinkedList<TextBox> textBoxQueue;
    private Stack<GameState> gameStates;
    private Player player;
    private MenuScreen menu;
    private PauseScreen pause;
    public static Music background;
    private ArrayList<GameObject> objects;
    private Mission active;
    private boolean loaded;
    
    private boolean collided = false;
    
    public GameData(Game game) {
        this.game = game;
        menu = game.getMenuScreen();
        pause = game.getPauseScreen();
        background = new Music(false);
        objects = new ArrayList<>();
        gameStates = new Stack<>();
        gameStates.push(GameState.MENU_STATE);
        loaded = false;
        player = new Player("res\\sprites/player_front_0.png", 0, 0);
        textBoxQueue = new LinkedList<>();
        objects = new ArrayList<>();
        nullBox = new TextBox(null, -500, -500, "");
        textBox = nullBox;
    }
    
    // All updates will go here
    public void update() {
        if(gameStates.peek() == GameState.MENU_STATE) {
            background.Menu = true;
            background.MenuPlay();
        } else if(gameStates.peek() == GameState.PAUSE_STATE) {
            game.getGameLoop().pause();
            pause = game.getPauseScreen();
            background.Pause();
            SoundEffects.volume = SoundEffects.Volume.Mute;
        } else if(gameStates.peek() == GameState.MISSION_01_STATE){
            if(!loaded){
                active = new Mission1(player);
                objects = active.getObjects();
                textBoxQueue = active.getTextBoxQueue();
                player = active.getPlayer();
                loaded = true;
            }
            textBox.update();
            background.update();
            game.getCamera().update(player);
            for(GameObject object : objects) {
                object.update();
            }
        }
    }
    
    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
    
    public ArrayList<GameObject> getObjects() {
        return objects;
    }
    
    public LinkedList<TextBox> getTextBoxQueue() {
        return textBoxQueue;
    }

    public TextBox getTextBox() {
        return textBox;
    }

    public void setTextBox(TextBox textBox) {
        this.textBox = textBox;
    }

    public Stack<GameState> getGameStates() {
        return gameStates;
    }

    public void setGameStates(Stack<GameState> gameStates) {
        this.gameStates = gameStates;
    }

    public MenuScreen getMenu() {
        return menu;
    }

    public void setMenu(MenuScreen menu) {
        this.menu = menu;
    }
    
    public void setPause(PauseScreen pause) {
        this.pause = pause;
    }
    
    public PauseScreen getPause() {
        return pause;
    }
    
    public Game getGame() {
        return this.game;
    }
}

