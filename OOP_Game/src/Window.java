/* Kevin Stubblefield
 * Last Updated: February 12, 2015
 * Known Bugs: None
 */
import java.awt.*;
import javax.swing.*;

public class Window extends JFrame {
    
    private final int WIDTH = 800;
    private final int HEIGHT = 600;
    
    public Window(JPanel p) {
        Container c = getContentPane();
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Star Wars: Exsul's Wrath");
        setVisible(true);
        setResizable(false);
        setFocusable(true);
        c.add(p, "Center");
    }
    
}
