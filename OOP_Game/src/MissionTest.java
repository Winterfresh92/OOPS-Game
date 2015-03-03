/* Chris Graff
 * Last Updated: March 1, 2015
 * Known Bugs: None
 */

import java.util.ArrayList;
import java.util.LinkedList;


// Handles data for Missions, child classes are actual missions. Constructs mission.
public class MissionTest extends Mission{
    
    private CollidableObject tree;

    public MissionTest(Player player) {
        super(player);
        this.player = player;
        this.player.x = 100;
        this.player.y = 100;
        bg = SpriteCache.getSpriteCache().getSprite("res\\sprites/2400x1800px Checkered board.png");
    }

    @Override
    public LinkedList<TextBox> getTextBoxQueue() {
        textBoxQueue = new LinkedList<>();

        textBox = new TextBox(null, Game.WIDTH / 10, Game.HEIGHT - Game.HEIGHT / 3, "this is a textbox\nnew line");
        textBox.setPriority(false);
        textBoxQueue.offer(textBox);
        textBox = new TextBox(null, Game.WIDTH / 10, Game.HEIGHT - Game.HEIGHT / 3, "this is a textbox2\nnew");
        textBox.setPriority(true);
        textBoxQueue.offer(textBox);
        textBox = new TextBox(null, Game.WIDTH / 10, Game.HEIGHT - Game.HEIGHT / 3, "this is a textbox3\nnew bite line", true);
        textBoxQueue.offer(textBox);
        textBox = new TextBox(null, Game.WIDTH / 10, Game.HEIGHT - Game.HEIGHT / 3, "this is a textbox4\nnew abitger line");
        textBoxQueue.offer(textBox);

        return textBoxQueue;
    }

    @Override
    public ArrayList<GameObject> getObjects() {
        objects = new ArrayList<>();
        objects.add(player);
        tree = new CollidableObject(null, 500, 500);
        objects.add(tree);
        return objects;
    }


}
