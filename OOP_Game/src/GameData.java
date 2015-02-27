/* Kevin Stubblefield
 * Last Updated: February 22, 2015
 * Known Bugs: None
 */

import java.util.LinkedList;
import java.util.Stack;

// Handles all updates in the game and holds all data
public class GameData {
    
    private Game game;
    private TextBox textBox;
    private LinkedList<TextBox> textBoxQueue;
    private Stack<GameState> gameStates;
    private Player player;
    private Tree tree;
    
    private boolean collided = false;
    
    public GameData(Game game) {
        this.game = game;
        player = new Player("res\\sprites/player_front_0.png", 100, 100);
        tree = new Tree(null, 500, 500);
        textBoxQueue = new LinkedList<>();
        gameStates = new Stack<>();
        gameStates.push(GameState.MENU_STATE);
        textBox = new TextBox(null, Game.WIDTH / 10, Game.HEIGHT - Game.HEIGHT / 3, "this is a textbox\nnew line");
        textBoxQueue.offer(textBox);
        textBox = new TextBox(null, Game.WIDTH / 10, Game.HEIGHT - Game.HEIGHT / 3, "this is a textbox2\nnew");
        textBox.setPriority(false);
        textBoxQueue.offer(textBox);
        textBox = new TextBox(null, Game.WIDTH / 10, Game.HEIGHT - Game.HEIGHT / 3, "this is a textbox3\nnew bite line", true);
        textBoxQueue.offer(textBox);
        textBox = new TextBox(null, Game.WIDTH / 10, Game.HEIGHT - Game.HEIGHT / 3, "this is a textbox4\nnew abitger line");
        textBoxQueue.offer(textBox);
    }
    
    // All updates will go here
    public void update() {
        if(gameStates.peek() == GameState.MENU_STATE) {
            
        } else {
            textBox.update();
            player.update();
            tree.update();
            if(player.getCollision(tree) && !collided) {
                textBox = new TextBox(null, Game.WIDTH / 10, Game.HEIGHT - Game.HEIGHT / 3, "YOU HAVE COLLI\nDED!!", true);
                textBox.setPriority(false);
                textBoxQueue.offer(textBox);
                collided = true;
            }
        }
    }
    
    public Tree getTree() {
        return tree;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public TextBox getTextBox() {
        return textBox;
    }

    public void setTextBox(TextBox textBox) {
        this.textBox = textBox;
    }

    public LinkedList<TextBox> getTextBoxQueue() {
        return textBoxQueue;
    }

    public void setTextBoxQueue(LinkedList<TextBox> textBoxQueue) {
        this.textBoxQueue = textBoxQueue;
    }

    public Stack<GameState> getGameStates() {
        return gameStates;
    }

    public void setGameStates(Stack<GameState> gameStates) {
        this.gameStates = gameStates;
    }
    
}

