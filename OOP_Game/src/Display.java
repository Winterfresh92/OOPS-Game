/* Kevin Stubblefield
 * Last Updated: February 24, 2015
 * Known Bugs: None
 */

import java.awt.*;
import java.util.ArrayList;
import javax.swing.JPanel;

// This class renders all graphics on the screen.
public class Display extends JPanel {

    // Width and height of panel
    public static final int PWIDTH = Game.WIDTH;
    public static final int PHEIGHT = Game.HEIGHT;

    private Graphics graphics;
    private Image dbImage = null;
    private Graphics2D g2d;
    private Sprite bg = SpriteCache.getSpriteCache().getSprite("res\\sprites/2400x1800px Checkered board.png");
    private Game game;
    private GameLoop gameLoop;
    private GameData gameData;
    private ArrayList<GameObject> objectsToRender;

    public Display(Game game, GameLoop gameLoop, GameData gameData) {
        this.game = game;
        this.gameLoop = gameLoop;
        this.gameData = gameData;
    }

    public void renderGame() {
        if (dbImage == null) {
            dbImage = createImage(PWIDTH, PHEIGHT);
            if (dbImage == null) {
                System.out.println("dbImage is null");
                return;
            } else {
                graphics = dbImage.getGraphics();
                g2d = (Graphics2D) graphics;
            }
        }

        graphics.clearRect(0, 0, PWIDTH, PHEIGHT); // Clears the screen
        //All object rendering should go between these two lines and
        //should come from the gameData instance
        /**
         * **************************************************************
         */
        if (gameData.getGameStates().peek() == GameState.MENU_STATE) {
            game.getMenuScreen().render(graphics);
        } else {
            g2d.translate(this.game.getCamera().getX(), this.game.getCamera().getY());//After this, objects don't move with the character.
            gameData.getBackground().render(graphics, 5, 30);
            gameData.getPlayer().render(graphics);
            objectsToRender = gameData.getObjects();
            for (GameObject object : objectsToRender) {
                object.render(graphics);//After this, objects do move with the character.
            }
            g2d.translate(-this.game.getCamera().getX(), -this.game.getCamera().getY());
            if (!gameData.getTextBoxQueue().isEmpty()) {
                gameData.getTextBoxQueue().peek().render(graphics);
            }
            if (gameData.getGameStates().peek() == GameState.PAUSE_STATE) {
                game.getPauseScreen().render(graphics);
            }

        }

        /**
         * **************************************************************
         */
        Graphics g;
        try {
            g = this.getGraphics();
            if ((g != null) && (dbImage != null)) {
                g.drawImage(dbImage, 0, 0, null);
            }
            Toolkit.getDefaultToolkit().sync(); // sync the display on some systems

            g.dispose();

        } catch (Exception e) {
            System.out.println("Graphics error: " + e);
        }

    }

}
