/* Kevin Stubblefield
 * Last Updated: April 8, 2015
 * Known Bugs: None
 * Created class and implemented.
 * Took out string ref since all half hearts will look the same.
 */

package Object;

public class HalfHeart extends Item {

    public HalfHeart(float x, float y, boolean collected) {
        super("res\\sprites\\items/heart_item_1.png", x, y, collected);
        this.name = "Half-Heart";
    }

    HalfHeart(String resspritesitemsheart_item_1png, int i, int i0, boolean b) {
        super(resspritesitemsheart_item_1png, i, i0, b);
        this.name = "Half-Heart";
    }
    
    @Override
    public void use(Player player) {
        player.setHealth(player.getHealth() + 1);
    }
    
}
