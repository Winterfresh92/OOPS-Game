package Engine;

/* This will be a basic framework for the Software Design and Development
** team OOPs. This will contain the necessities for the game based on Dr.
** Sung's framework provided for OOP. Primary class names will be changed
** where deemed relevant and notated for ease of use. Code will be cleaned
** up slightly as well.
** Kevin Stubblefield
** Last Updated: February 24, 2015
** Known Bugs: None
*/

import Menu.MenuScreen;
import Menu.PauseScreen;
import java.awt.Container;
import javax.swing.JFrame;

// Game is the "main" class that creates the display window
public class Game extends JFrame {
    
    private GameData gameData;
    private Display display;
    private GameLoop gameLoop;
    private Camera camera;
    private MenuScreen menuScreen;
    private LoadingScreen loadingScreen;
    private PauseScreen pauseScreen;
    private MouseInput mouseInput;
    
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    
    public Game() {
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        Container c = getContentPane();
        menuScreen = new MenuScreen(this);
        loadingScreen = new LoadingScreen();
        pauseScreen = new PauseScreen(this);
        gameLoop = new GameLoop();
        gameData = new GameData(this);
        camera = new Camera(0, 0);
        display = new Display(this, gameLoop, gameData);
        gameLoop.setRenderer(display);
        gameLoop.setGameData(gameData);
        gameLoop.startGame();
        c.add(display, "Center");
        
        display.setFocusable(true);
        display.addKeyListener(new KeyInput(gameData));
        
        mouseInput = new MouseInput(gameData);
        display.addMouseListener(mouseInput);
        display.addMouseMotionListener(mouseInput);
    }

    public static void main(String[] args) {
        JFrame game = new Game();
        game.setTitle("OOPS");
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.setVisible(true);
    }

    public Camera getCamera() {
        return camera;
    }

    public void setCamera(Camera camera) {
        this.camera = camera;
    }

    public MenuScreen getMenuScreen() {
        return menuScreen;
    }

    public void setMenuScreen(MenuScreen menuScreen) {
        this.menuScreen = menuScreen;
    }
    
    public void setPauseScreen(PauseScreen pauseScreen) {
        this.pauseScreen = pauseScreen;
    }
    
    public PauseScreen getPauseScreen() {
        return this.pauseScreen;
    }
    
    public GameLoop getGameLoop() {
        return this.gameLoop;
    }

    public LoadingScreen getLoadingScreen() {
        return loadingScreen;
    }

    public void setLoadingScreen(LoadingScreen loadingScreen) {
        this.loadingScreen = loadingScreen;
    }
    
}
