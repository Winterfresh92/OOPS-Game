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
    
    @Override
    public void use(Player player) {
        player.setHealth(player.getHealth() + 1);
    }
    
}
