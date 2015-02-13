
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JPanel;

// This class renders all graphics on the screen.
public class Display extends JPanel {
    
    // Width and height of panel
    public static final int PWIDTH = Game.WIDTH;
    public static final int PHEIGHT = Game.HEIGHT;
    
    private Graphics graphics;
    private Image dbImage = null;
    
    private Game game;
    private GameLoop gameLoop;
    private GameData gameData;
    
    public Display(Game game, GameLoop gameLoop, GameData gameData) {
        this.game = game;
        this.gameLoop = gameLoop;
        this.gameData = gameData;
    }
    
    public void renderGame() {
        if(dbImage == null) {
            dbImage = createImage(PWIDTH, PHEIGHT);
            if(dbImage == null) {
                System.out.println("dbImage is null");
                return;
            } else {
                graphics = dbImage.getGraphics();
            }
        }
        
        graphics.clearRect(0, 0, PWIDTH, PHEIGHT); // Clears the screen
        //All object rendering should go between these two lines and
        //should come from the gameData instance
        /*****************************************************************/
        gameData.getPlayer().render(graphics);
        gameData.getTree().render(graphics);
        if(!gameData.getTextBoxQueue().isEmpty()) {
            gameData.getTextBoxQueue().peek().render(graphics);
        }
        /*****************************************************************/
        
        Graphics g;
        try {
            g = this.getGraphics();
            if((g != null) && (dbImage != null)) {
                g.drawImage(dbImage, 0, 0, null);
            }
            Toolkit.getDefaultToolkit().sync(); // sync the display on some systems
            g.dispose();
        } catch (Exception e) {
            System.out.println("Graphics error: " + e);
        }
    }
    
}
