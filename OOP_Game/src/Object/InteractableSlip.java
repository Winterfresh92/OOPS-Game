package Object;

/* Chris Graff
 * Last Updated: March 10, 2015
 * Known Bugs: None
 */
import java.awt.Color;
import java.awt.Graphics;

public class InteractableSlip extends InteractableObject {

    private boolean interacted;
    private String defaultText;

    public InteractableSlip(String ref, float x, float y) {
        super(ref, x, y);
        this.width = 64;
        this.height = 64;
        this.solid = true;
        this.mobile = false;
        interacted = true;
        defaultText = "You have already collected this Permission.";
    }

    public InteractableSlip(String ref, float x, float y, boolean solid, boolean mobile, String defaultText) {
        super(ref, x, y);
        this.width = 64;
        this.height = 64;
        this.solid = solid;
        this.mobile = mobile;
        interacted = false;
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

    @Override
    public void interacted() {
        this.interacted = true;

    }

    @Override
    public boolean interact() {
        return !interacted;
    }

    @Override
    public String getDefaultText() {
        return this.defaultText;
    }

}
