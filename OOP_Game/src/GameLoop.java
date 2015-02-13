/* Kevin Stubblefield
 * Last Updated: February 12, 2015
 * Known Bugs: None
 */

// This class updates the game every frame.
public class GameLoop implements Runnable {
    
    private boolean running;
    private Thread t;
    
    private Display display = null;
    private GameData gameData = null;
    
    public GameLoop() {
    }
    
    public void startGame() {
        t = new Thread(this);
        running = true;
        t.start();
    }
    
    public void setRenderer(Display display) {
        this.display = display;
    }
    
    public void setGameData(GameData gameData) {
        this.gameData = gameData;
    }
    
    @Override
    public void run() {
        long lastTime = System.nanoTime();
        long timer = System.currentTimeMillis();
        final double ns = 1000000000.0 / 60.0;
        double delta = 0;
        int frames = 0;
        int updates = 0;
        while(running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta >= 1) {
                gameData.update();
                updates++;
                delta--;
            }
            display.renderGame();
            frames++;
            
            if(System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println(updates + " ups, " + frames + " fps");
                updates = 0;
                frames = 0;
            }
        }
        stop();
    }
    
    public void stop() {
        running = false;
        try {
            t.join();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
}
