
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Keying extends JPanel {
   
    public Rectangle character;
    
    public int charW = 24;
    public int charH = 24;
    
    public boolean right = false;
    public boolean left = false;
    public boolean up = false;
    public boolean down = false;
    
    
    public Keying(Display f, Images i){
        character = new Rectangle(180,180,charW,charH);
        f.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e)
            {
               if(e.getKeyCode() == KeyEvent.VK_D){
                   right  = true;
                   character.x += 1;
               } 
               if(e.getKeyCode() == KeyEvent.VK_A){
                  left = true;
                  character.x -= 1;
               }
               if(e.getKeyCode() == KeyEvent.VK_W){
                  up = true;
                  character.y -= 1;
               }
               if(e.getKeyCode() == KeyEvent.VK_S){
                  down = true;
                  character.y += 1;
               }
            }
            
            public void keyReleased(KeyEvent e)
            {
                if(e.getKeyCode() == KeyEvent.VK_D)
                {
                    right = false;
                }
                if(e.getKeyCode() == KeyEvent.VK_A)
                {
                    left = false;
                }
                if(e.getKeyCode() == KeyEvent.VK_W){
                  up = false;
               }
               if(e.getKeyCode() == KeyEvent.VK_S){
                  down = false;
                  
               }
            }
        });
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        this.setBackground(Color.WHITE);
        g.setColor(Color.RED);
        g.fillRect(character.x, character.y, character.width, character.height);
    
        if(right){
            character.x += 1;
        }
        if(left){
            character.x -= 1;
        }
        if(up){
            character.y -= 1;
        }
        if(down){
            character.y += 1;
        }
        repaint(); 
    }
}
