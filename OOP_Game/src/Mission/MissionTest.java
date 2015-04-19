package Mission;

/* Chris Graff
 * Last Updated: March 1, 2015
 * Known Bugs: None
 *
 * Kevin Stubblefield
 * Last Updated: April 4, 2015
 * Known Bugs: None
 * Added an enemy, making use of this as an actual test mission.
 */

import Sprite.SpriteCache;
import Object.CollidableObject;
import Object.Player;
import Object.GameObject;
import Object.TextBox;
import Engine.Game;
import Engine.GameData;
import Object.Enemy;
import java.util.ArrayList;
import java.util.LinkedList;


// Handles data for Missions, child classes are actual missions. Constructs mission.
public class MissionTest extends Mission{
    
    private CollidableObject tree;

    public MissionTest(Player player, GameData gameData) {
        super(player, gameData);
        this.player = player;
        this.player.setX(100);
        this.player.setY(100);
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
        tree = new CollidableObject(null, player.getX() + 500, player.getY() + 500);
        Enemy enemy = new Enemy("res\\sprites\\enemies\\sith soldier\\down/sith_soldier_down_0.png", player.getX() + 250, player.getY() + 250, true, true, gameData, true);
        objects.add(tree);
        objects.add(enemy);
        return objects;
    }


}
