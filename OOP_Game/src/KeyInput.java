
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyInput implements KeyListener {
    
    private static boolean right = false;
    private static boolean left = false;
    private static boolean up = false;
    private static boolean down = false;
    
    private GameData gameData;
    
    public KeyInput(GameData gameData){
        this.gameData = gameData;
    }
    
    @Override
    public void keyPressed(KeyEvent e)
    {
        if(e.getKeyCode() == KeyEvent.VK_D){
            if(gameData.getTextBoxQueue().isEmpty() || !gameData.getTextBoxQueue().peek().isPriority()) {
                right = true;
            }
        } 
        if(e.getKeyCode() == KeyEvent.VK_A){
            if(gameData.getTextBoxQueue().isEmpty() || !gameData.getTextBoxQueue().peek().isPriority()) {
                left = true;
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_W){
            if(gameData.getTextBoxQueue().isEmpty() || !gameData.getTextBoxQueue().peek().isPriority()) {
                up = true;
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_S){
            if(gameData.getTextBoxQueue().isEmpty() || !gameData.getTextBoxQueue().peek().isPriority()) {
                down = true;
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_SPACE) {
            if(!gameData.getTextBoxQueue().isEmpty()) {
                gameData.getTextBoxQueue().poll();
            }
        }
    }

    @Override
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
    
    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    public static boolean isRight() {
        return right;
    }

    public static void setRight(boolean right) {
        KeyInput.right = right;
    }

    public static boolean isLeft() {
        return left;
    }

    public static void setLeft(boolean left) {
        KeyInput.left = left;
    }

    public static boolean isUp() {
        return up;
    }

    public static void setUp(boolean up) {
        KeyInput.up = up;
    }

    public static boolean isDown() {
        return down;
    }

    public static void setDown(boolean down) {
        KeyInput.down = down;
    }
    
}
