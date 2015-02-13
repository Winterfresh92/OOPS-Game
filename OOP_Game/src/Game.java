/* This will be a basic framework for the Software Design and Development
** team OOPs. This will contain the necessities for the game based on Dr.
** Sung's framework provided for OOP. Primary class names will be changed
** where deemed relevant and notated for ease of use. Code will be cleaned
** up slightly as well.
** Kevin Stubblefield
** Last Updated: February 12, 2015
** Known Bugs: None
*/

import java.awt.Container;
import javax.swing.JFrame;

// Game is the "main" class that creates the display window
public class Game extends JFrame {
    
    private GameData gameData;
    private Display display;
    private GameLoop gameLoop;
    
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    
    public Game() {
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        Container c = getContentPane();
        gameLoop = new GameLoop();
        gameData = new GameData(this);
        display = new Display(this, gameLoop, gameData);
        gameLoop.setRenderer(display);
        gameLoop.setGameData(gameData);
        gameLoop.startGame();
        c.add(display, "Center");
        
        display.setFocusable(true);
        display.addKeyListener(new KeyInput(gameData));
    }

    public static void main(String[] args) {
        JFrame game = new Game();
        game.setTitle("OOPS");
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.setVisible(true);
    }

}
