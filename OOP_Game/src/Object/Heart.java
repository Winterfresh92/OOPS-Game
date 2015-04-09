/* Kevin Stubblefield
 * Last Updated: April 8, 2015
 * Known Bugs: None
 * Created class and implemented.
 * Took out the string ref in constructor since all hearts will look the same
 */

package Object;

public class Heart extends Item {

    public Heart(float x, float y, boolean collected) {
        super("res\\sprites\\items/heart_item_0.png", x, y, collected);
        this.name = "Heart";
    }
    
    @Override
    public void use(Player player) {
        player.setHealth(player.getHealth() + 2);
    }
    
}
