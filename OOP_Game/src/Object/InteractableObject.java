package Object;

/* Chris Graff
 * Last Updated: March 10, 2015
 * Known Bugs: None
 */
import java.awt.Color;
import java.awt.Graphics;

public class InteractableObject extends CollidableObject {

    private boolean interacted;
    private String defaultText;

    public InteractableObject(String ref, float x, float y) {
        super(ref, x, y);
        this.width = 64;
        this.height = 64;
        this.solid = true;
        this.mobile = false;
        interacted = true;
        defaultText = "";
    }

    public InteractableObject(String ref, float x, float y, boolean solid, boolean mobile, String defaultText) {
        super(ref, x, y);
        this.width = 64;
        this.height = 64;
        this.solid = solid;
        this.mobile = mobile;
        interacted = false;
        this.defaultText = defaultText;
    }

    public InteractableObject(String ref, float x, float y, boolean solid, boolean mobile, String defaultText, boolean interacted) {
        super(ref, x, y);
        this.width = 64;
        this.height = 64;
        this.solid = solid;
        this.mobile = mobile;
        this.interacted = interacted;
        this.defaultText = defaultText;
    }

    @Override
    public void update() {
    }

    @Override
    public void render(Graphics g) {
        if (super.sprite != null) {
            sprite.render(g, x, y);
        } else {
            g.setColor(Color.BLUE);
            g.fillRect((int) x, (int) y, (int) width, (int) height);
        }
    }

    public void interacted() {
        this.interacted = true;
    }

    public boolean interact() {
        return !interacted;
    }

    public String getDefaultText() {
        return this.defaultText;
    }

}
