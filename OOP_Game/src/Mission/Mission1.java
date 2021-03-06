package Mission;

/* Chris Graff
 * Last Updated: March 10, 2015
 * Known Bugs: None
 *
 * Kevin Stubblefield
 * Last Updated: April 13, 2015
 * Known Bugs: None
 * Added field for gameData
 * Added constructor for when loading from file
 */
import Sprite.SpriteCache;
import Object.TextBox;
import Object.Player;
//import Object.Enemy; Not needed in Mission 1
import Object.InteractableObject;
import Object.GameObject;
import Object.CollidableObject;
import Engine.*;
import Object.*;
import Object.InteractableSlip;
import java.util.ArrayList;
import java.util.LinkedList;

// Handles data for Missions, child classes are actual missions. Constructs mission.
public class Mission1 extends Mission {

    public Mission1(Player player, GameData gameData) {
        super(player, gameData);
        this.player = player;
        this.player.setX(1344);
        this.player.setY(1536);
        bg = SpriteCache.getSpriteCache().getSprite("res\\sprites\\background/Mission1-bg-v4.png");
        textBoxSetup();
    }
    
    public Mission1(Player player, GameData gameData, float x, float y) {
        super(player, gameData);
        this.player = player;
        this.player.setX(x);
        this.player.setY(y);
        bg = SpriteCache.getSpriteCache().getSprite("res\\sprites\\background/Mission1-bg-v4.png");
        textBoxSetup();
    }
    
    private void textBoxSetup() {
        textBoxQueue = new LinkedList<>();

        textBox = new TextBox("res\\sprites/text_box_0.png", Game.WIDTH / 10, (Game.HEIGHT - Game.HEIGHT / 3) - 40, "Master Dorak: Congratulations padawan,"
                + "\nyour day of testing has come. ");
        textBoxQueue.offer(textBox);
        textBox = new TextBox("res\\sprites/text_box_0.png", Game.WIDTH / 10, (Game.HEIGHT - Game.HEIGHT / 3) - 40, "I have put your name forth to"
                + "\nbecome a full-fledged Jedi Knight.");
        textBoxQueue.offer(textBox);
        textBox = new TextBox("res\\sprites/text_box_0.png", Game.WIDTH / 10, (Game.HEIGHT - Game.HEIGHT / 3) - 40, "This test has been designed to"
                + "\ntest your discipline.", true);
        textBoxQueue.offer(textBox);
        textBox = new TextBox("res\\sprites/text_box_0.png", Game.WIDTH / 10, (Game.HEIGHT - Game.HEIGHT / 3) - 40, "It is not particularly difficult"
                + "\nor long, but it has certain rules"
                + "\nthat must be followed.");
        textBoxQueue.offer(textBox);
        textBox = new TextBox("res\\sprites/text_box_0.png", Game.WIDTH / 10, (Game.HEIGHT - Game.HEIGHT / 3) - 40, "The first rule is that you are not"
                + "\nallowed to use any force powers not"
                + "\nspecifically told to.");
        textBoxQueue.offer(textBox);
        textBox = new TextBox("res\\sprites/text_box_0.png", Game.WIDTH / 10, (Game.HEIGHT - Game.HEIGHT / 3) - 40, "You will pick up permission slips"
                + "\nthat will allow you to use certain"
                + "\npowers as you progress through the test.");
        textBoxQueue.offer(textBox);
        textBox = new TextBox("res\\sprites/text_box_0.png", Game.WIDTH / 10, (Game.HEIGHT - Game.HEIGHT / 3) - 40, "You: What force powers am I allowed"
                + "\nto use Master Dorak?");
        textBoxQueue.offer(textBox);
        textBox = new TextBox("res\\sprites/text_box_0.png", Game.WIDTH / 10, (Game.HEIGHT - Game.HEIGHT / 3) - 40, "Master Dorak: Rule number two is"
                + "\nthat you aren’t allowed to use any powers"
                + "\nuntil you receive a permission slip.");
        textBoxQueue.offer(textBox);
        textBox = new TextBox("res\\sprites/text_box_0.png", Game.WIDTH / 10, (Game.HEIGHT - Game.HEIGHT / 3) - 40, "You: Ah, that clears things up.");
        textBoxQueue.offer(textBox);
        textBox = new TextBox("res\\sprites/text_box_0.png", Game.WIDTH / 10, (Game.HEIGHT - Game.HEIGHT / 3) - 40, "Master Dorak: Rule three is that"
                + "\nyou pass as soon as you retrieve your"
                + "\nlightsaber at the end of the test.");
        textBoxQueue.offer(textBox);
        textBox = new TextBox("res\\sprites/text_box_0.png", Game.WIDTH / 10, (Game.HEIGHT - Game.HEIGHT / 3) - 40, "Most puzzles only have one answer,"
                + "\ngood luck.");
        textBoxQueue.offer(textBox);
        textBox = new TextBox("res\\sprites/text_box_0.png", Game.WIDTH / 10, (Game.HEIGHT - Game.HEIGHT / 3) - 40, "You: Thank you for your wisdom and"
                + "\nguidance through the years that I"
                + "\nhave trained under you. ");
        textBoxQueue.offer(textBox);
        textBox = new TextBox("res\\sprites/text_box_0.png", Game.WIDTH / 10, (Game.HEIGHT - Game.HEIGHT / 3) - 40, "I shall greet you as a Knight on"
                + "\nthe other side.");
        textBoxQueue.offer(textBox);
        queueQueue = new LinkedList<>();
        queueQueue.offer(textBoxQueue);
        textBoxQueue = new LinkedList<>();
        textBox = new TextBox("res\\sprites/text_box_0.png", Game.WIDTH / 10, (Game.HEIGHT - Game.HEIGHT / 3) - 40, "Note: You are now allowed to"
                + "\nuse the Force power PULL.", true);
        textBoxQueue.offer(textBox);
        queueQueue.offer(textBoxQueue);
        textBoxQueue = new LinkedList<>();
        textBox = new TextBox("res\\sprites/text_box_0.png", Game.WIDTH / 10, (Game.HEIGHT - Game.HEIGHT / 3) - 40, "Note: You are now allowed to"
                + "\nuse the Force power PUSH.", true);
        textBoxQueue.offer(textBox);
        queueQueue.offer(textBoxQueue);
        textBoxQueue = new LinkedList<>();
        textBox = new TextBox("res\\sprites/text_box_0.png", Game.WIDTH / 10, (Game.HEIGHT - Game.HEIGHT / 3) - 40, "You: Great, now to proceed to"
                + "\nthe end of the test and become a"
                + "\nJedi Knight at last.");
        textBoxQueue.offer(textBox);
        queueQueue.offer(textBoxQueue);
        textBoxQueue = new LinkedList<>();
        textBox = new TextBox("res\\sprites/text_box_0.png", Game.WIDTH / 10, (Game.HEIGHT - Game.HEIGHT / 3) - 40, "Master Dorak: Great, you made it!"
                + "\nI told you it wasn’t too difficult, and"
                + "\nI had faith the force would guide you.");
        textBoxQueue.offer(textBox);
        textBox = new TextBox("res\\sprites/text_box_0.png", Game.WIDTH / 10, (Game.HEIGHT - Game.HEIGHT / 3) - 40, "You: You were correct Master. Thank"
                + "\nyou for nominating me to take the test. ");
        textBoxQueue.offer(textBox);
        textBox = new TextBox("res\\sprites/text_box_0.png", Game.WIDTH / 10, (Game.HEIGHT - Game.HEIGHT / 3) - 40, "Master Dorak: Of course. Now please"
                + "\nexcuse me, I must prepare for"
                + "\nthe ceremony.");
        textBoxQueue.offer(textBox);
        queueQueue.offer(textBoxQueue);
        textBoxQueue = new LinkedList<>();
    }

    @Override
    public LinkedList<TextBox> getTextBoxQueue() {
        return queueQueue.pop();
    }

    @Override
    public ArrayList<GameObject> getObjects() {
        return objects;
    }

    @Override
    public void generateObjects() {
        objects = new ArrayList<>();
        //objects.add(player);
        //objects for the level go here
        objects.add(new CollidableObject("res\\sprites/rock2.png", 448, 256, true, true));//puzzle stones
        objects.add(new CollidableObject("res\\sprites/rock2.png", 384, 320, true, true));
        objects.add(new CollidableObject("res\\sprites/rock2.png", 576, 256, true, true));
        objects.add(new CollidableObject("res\\sprites/rock2.png", 512, 320, true, true));
        objects.add(new CollidableObject("res\\sprites/rock2.png", 640, 320, true, true));
        objects.add(new CollidableObject("res\\sprites/rock2.png", 448, 384, true, true));
        objects.add(new CollidableObject("res\\sprites/rock2.png", 576, 384, true, true));
        objects.add(new CollidableObject("res\\sprites/rock2.png", 384, 448, true, true));
        objects.add(new CollidableObject("res\\sprites/rock2.png", 512, 448, true, true));
        objects.add(new CollidableObject("res\\sprites/rock2.png", 640, 448, true, true));
        objects.add(new CollidableObject("res\\sprites/rock2.png", 448, 512, true, true));
        objects.add(new CollidableObject("res\\sprites/rock2.png", 576, 512, true, true));
        objects.add(new CollidableObject("res\\sprites/rock2.png", 384, 832, true, true));
        objects.add(new CollidableObject("res\\sprites/rock2.png", 704, 832, true, true));
        objects.add(new CollidableObject("res\\sprites/rock2.png", 448, 1536, true, true));
        objects.add(new CollidableObject("res\\sprites/rock2.png", 512, 1536, true, true));
        objects.add(new CollidableObject("res\\sprites/rock2.png", 832, 1280, true, true));
        objects.add(new CollidableObject("res\\sprites/rock2.png", 1856, 960, true, true));
        objects.add(new CollidableObject("res\\sprites/door-close-h.png", 256, 704, true, false));//openable doors
        objects.add(new CollidableObject("res\\sprites/door-close-h.png", 1024, 192, true, false));
        objects.add(new Enemy("res\\sprites/cut_away_bar_1.png", "res\\sprites/cut_away_bar_4.png", 1280, 576, true, false, gameData, 1, 0, false));
        objects.add(new CollidableObject("res\\sprites/door-close-h.png", 1216, 1216, true, false));
        objects.add(new CollidableObject("res\\sprites/door-close-h.png", 1728, 128, true, false));
        objects.add(new CollidableObject("res\\sprites/door-close-h.png", 2048, 512, true, false));//decorative doors
        objects.add(new CollidableObject("res\\sprites/door-close-h.png", 1664, 1664, true, false));
        objects.add(new InteractableObject("res\\sprites/dorak_down_0.png", 1344, 1470, true, false, "Hurry along now.", true));
        objects.add(new InteractableObject("res\\sprites/dorak_down_0.png", 1728, 320, true, false, "Hurry along now."));
        InteractableObject object = new InteractableSlip("res\\sprites/slip_0.png", 640, 1088, true, false, "You can already use this power.");
        objects.add(object);
        object = new InteractableSlip("res\\sprites/slip_0.png", 1600, 1152, true, false, "You can already use this power.");
        objects.add(object);
        object = new InteractableSlip("res\\sprites/stand_1.png", 898, 448, true, false, "You already have your lightsaber.");
        objects.add(object);
        objects.addAll(makeWalls("res\\sprites/wall.png", 512, 0, 9, true));//horizontal walls
        objects.addAll(makeWalls("res\\sprites/wall.png", 576, 128, 7, true));
        objects.addAll(makeWalls("res\\sprites/wall.png", 640, 192, 6, true));
        objects.addAll(makeWalls("res\\sprites/wall.png", 1088, 192, 2, true));
        objects.addAll(makeWalls("res\\sprites/wall.png", 1408, 128, 5, true));
        objects.addAll(makeWalls("res\\sprites/wall.png", 1792, 128, 5, true));
        objects.addAll(makeWalls("res\\sprites/wall.png", 1152, 512, 5, true));
        objects.addAll(makeWalls("res\\sprites/wall.png", 192, 576, 4, true));
        objects.add(new CollidableObject("res\\sprites/wall.png", 384, 768, true, false));
        objects.add(new CollidableObject("res\\sprites/wall.png", 512, 576, true, false));
        objects.add(new CollidableObject("res\\sprites/wall.png", 640, 576, true, false));
        objects.addAll(makeWalls("res\\sprites/wall.png", 768, 640, 22, true));
        objects.addAll(makeWalls("res\\sprites/wall.png", 320, 704, 7, true));
        objects.addAll(makeWalls("res\\sprites/wall.png", 960, 832, 4, true));
        objects.addAll(makeWalls("res\\sprites/wall.png", 256, 896, 2, true));
        objects.add(new CollidableObject("res\\sprites/wall.png", 448, 896, true, false));
        objects.addAll(makeWalls("res\\sprites/wall.png", 576, 896, 2, true));
        objects.addAll(makeWalls("res\\sprites/wall.png", 768, 896, 2, true));
        objects.add(new CollidableObject("res\\sprites/wall.png", 320, 1024, true, false));
        objects.addAll(makeWalls("res\\sprites/wall.png", 1216, 960, 10, true));
        objects.addAll(makeWalls("res\\sprites/wall.png", 1920, 960, 3, true));
        objects.addAll(makeWalls("res\\sprites/wall.png", 320, 1088, 3, true));
        objects.addAll(makeWalls("res\\sprites/wall.png", 768, 1152, 2, true));
        objects.addAll(makeWalls("res\\sprites/wall.png", 576, 1280, 4, true));
        objects.addAll(makeWalls("res\\sprites/wall.png", 1024, 1216, 3, true));
        objects.addAll(makeWalls("res\\sprites/wall.png", 1280, 1216, 14, true));
        objects.add(new CollidableObject("res\\sprites/wall.png", 704, 1536, true, false));
        objects.addAll(makeWalls("res\\sprites/wall.png", 192, 1600, 12, true));
        objects.addAll(makeWalls("res\\sprites/wall.png", 1024, 1792, 10, true));
        objects.addAll(makeWalls("res\\sprites/wall.png", 448, 0, 3, false));//vertical walls
        objects.addAll(makeWalls("res\\sprites/wall.png", 1088, 0, 4, false));
        objects.addAll(makeWalls("res\\sprites/wall.png", 384, 128, 2, false));
        objects.addAll(makeWalls("res\\sprites/wall.png", 320, 192, 6, false));
        objects.addAll(makeWalls("res\\sprites/wall.png", 704, 256, 7, false));
        //objects.addAll(makeWalls("res\\sprites/wall.png", 768, 256, 7, false));
        objects.addAll(makeWalls("res\\sprites/wall.png", 1152, 256, 4, false));
        objects.addAll(makeWalls("res\\sprites/wall.png", 2048, 192, 5, false));
        objects.addAll(makeWalls("res\\sprites/wall.png", 1408, 192, 5, false));
        objects.add(new CollidableObject("res\\sprites/wall.png", 2048, 576, true, false));
        objects.addAll(makeWalls("res\\sprites/wall.png", 192, 640, 15, false));
        objects.addAll(makeWalls("res\\sprites/wall.png", 512, 768, 12, false));
        objects.addAll(makeWalls("res\\sprites/wall.png", 896, 832, 12, false));
        objects.addAll(makeWalls("res\\sprites/wall.png", 1152, 896, 6, false));
        objects.addAll(makeWalls("res\\sprites/wall.png", 2112, 704, 8, false));
        objects.addAll(makeWalls("res\\sprites/wall.png", 1024, 1280, 8, false));
        objects.addAll(makeWalls("res\\sprites/wall.png", 1664, 1280, 6, false));
        objects.addAll(makeWalls("res\\sprites/wall.png", 1664, 1728, 2, false));
        objects.add(player);
    }

    public boolean levelOver() {
        return queueQueue.isEmpty();
    }

}
