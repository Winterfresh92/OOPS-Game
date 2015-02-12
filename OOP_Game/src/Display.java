
import javax.swing.*;
import java.awt.*;


public class Display extends JFrame{

    void setDefaultCloseOperation() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void setLocalRelativeTo(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public JPanel gp = (JPanel) getGlassPane();
    public Images i;
    public Keying k;
    
    public Display(){
        i = new Images();
        gp.setVisible(true);
        k = new Keying(this, i);
        
        gp.setLayout(new GridLayout(1,1,0,0));
        this.setLayout(new GridLayout());
        
        gp.add(k);
        this.add(i);
        
    }
}
