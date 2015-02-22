
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import javax.imageio.ImageIO;

/* Kevin Stubblefield
 * Last Updated: February 22, 2015
 * Known Bugs: None
 */
public class SpriteCache {
    
    private static SpriteCache cache = new SpriteCache();
    
    public static SpriteCache getSpriteCache() {
        return cache;
    }
    
    private HashMap<String, Sprite> sprites = new HashMap<>();
    
    public Sprite getSprite(String ref) {
        if(sprites.get(ref) != null) {
            return sprites.get(ref);
        }
        
        BufferedImage sourceImage = null;
        
        try {
            URL url = this.getClass().getClassLoader().getResource(ref);
            if(url == null) {
                System.err.println("Can't find resource: " + ref);
            }
            sourceImage = ImageIO.read(url);
        } catch(IOException e) {
            System.err.println("Failed to load: " + ref);
        }
        GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
        Image image = gc.createCompatibleImage(sourceImage.getWidth(), sourceImage.getHeight(), Transparency.BITMASK);
        image.getGraphics().drawImage(sourceImage, 0, 0, null);
        Sprite sprite = new Sprite(image);
        return sprite;
    }
    
}
