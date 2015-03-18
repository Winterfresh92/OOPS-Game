/* Kevin Stubblefield
 * Last Updated: March 17, 2015
 * Known Bugs: None
 * Created class and implemented
 */

package Object;

public class HalfHeart extends Item {

    public HalfHeart(String ref, float x, float y, boolean collected) {
        super(ref, x, y, collected);
        this.name = "Half-Heart";
    }
    
    public void use(Player player) {
        player.setHealth(player.getHealth() + 1);
    }
    
}
