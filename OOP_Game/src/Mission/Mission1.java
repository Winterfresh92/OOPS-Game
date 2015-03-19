package Mission;

/* Chris Graff
 * Last Updated: March 1, 2015
 * Known Bugs: None
 */

import Sprite.SpriteCache;
import Object.TextBox;
import Object.Player;
import Object.Enemy;
import Object.GameObject;
import Object.CollidableObject;
import Engine.*;
import java.util.ArrayList;
import java.util.LinkedList;


// Handles data for Missions, child classes are actual missions. Constructs mission.
public class Mission1 extends Mission{
    
    

    public Mission1(Player player) {
        super(player);
        this.player = player;
        this.player.setX(1344);
        this.player.setY(1472);
        bg = SpriteCache.getSpriteCache().getSprite("res\\sprites\\background/Mission1-bg.png");
    }

    @Override
    public LinkedList<TextBox> getTextBoxQueue() {
        textBoxQueue = new LinkedList<>();/*

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
        textBox = new TextBox("res\\sprites/text_box_0.png", Game.WIDTH / 10, (Game.HEIGHT - Game.HEIGHT / 3) - 40, "Note: You are now allowed to"
                                                                                + "\nuse the Force power PULL.", true);
        textBox.setPriority(false);
        textBoxQueue.offer(textBox);
        textBox = new TextBox("res\\sprites/text_box_0.png", Game.WIDTH / 10, (Game.HEIGHT - Game.HEIGHT / 3) - 40, "Note: You are now allowed to"
                                                                                + "\nuse the Force power PUSH.", true);
        textBox.setPriority(false);
        textBoxQueue.offer(textBox);
        textBox = new TextBox("res\\sprites/text_box_0.png", Game.WIDTH / 10, (Game.HEIGHT - Game.HEIGHT / 3) - 40, "You: Great, now to proceed to"
                                                                                + "\nthe end of the test and become a"
                                                                                + "\nJedi Knight at last.");
        textBox.setPriority(false);
        textBoxQueue.offer(textBox);
        textBox = new TextBox("res\\sprites/text_box_0.png", Game.WIDTH / 10, (Game.HEIGHT - Game.HEIGHT / 3) - 40, "Master Dorak: Great, you made it!"
                                                                                + "\nI told you it wasn’t too difficult, and"
                                                                                + "\nI had faith the force would guide you.");
        textBoxQueue.offer(textBox);
        textBox = new TextBox("res\\sprites/text_box_0.png", Game.WIDTH / 10, (Game.HEIGHT - Game.HEIGHT / 3) - 40, "You: You were correct Master. Thank"
                                                                                + "\nyou for nominating me to take the test. ");
        textBoxQueue.offer(textBox);*/
        textBox = new TextBox("res\\sprites/text_box_0.png", Game.WIDTH / 10, (Game.HEIGHT - Game.HEIGHT / 3) - 40, "Master Dorak: Of course. Now please"
                                                                                + "\nexcuse me, I must prepare for"
                                                                                + "\nthe ceremony.");
        textBoxQueue.offer(textBox);
        return textBoxQueue;
    }

    @Override
    public ArrayList<GameObject> getObjects() {
        objects = new ArrayList<>();
        //objects.add(player);
        //objects for the level go here        
        objects.add(new CollidableObject("res\\sprites/rock2.png", 448, 306, true, true));//puzzle stones
        objects.add(new CollidableObject("res\\sprites/rock2.png", 384, 370, true, true));
        objects.add(new CollidableObject("res\\sprites/rock2.png", 576, 306, true, true));
        objects.add(new CollidableObject("res\\sprites/rock2.png", 512, 370, true, true));
        objects.add(new CollidableObject("res\\sprites/rock2.png", 640, 370, true, true));
        objects.add(new CollidableObject("res\\sprites/rock2.png", 448, 434, true, true));
        objects.add(new CollidableObject("res\\sprites/rock2.png", 576, 434, true, true));
        objects.add(new CollidableObject("res\\sprites/rock2.png", 384, 498, true, true));
        objects.add(new CollidableObject("res\\sprites/rock2.png", 512, 498, true, true));
        objects.add(new CollidableObject("res\\sprites/rock2.png", 640, 498, true, true));
        objects.add(new CollidableObject("res\\sprites/rock2.png", 448, 562, true, true));
        objects.add(new CollidableObject("res\\sprites/rock2.png", 576, 562, true, true));
        objects.add(new CollidableObject("res\\sprites/rock2.png", 384, 882, true, true));
        objects.add(new CollidableObject("res\\sprites/rock2.png", 704, 882, true, true));
        objects.add(new CollidableObject("res\\sprites/rock2.png", 448, 1586, true, true));
        objects.add(new CollidableObject("res\\sprites/rock2.png", 512, 1586, true, true));
        objects.add(new CollidableObject("res\\sprites/rock2.png", 832, 1266, true, true));
        objects.add(new CollidableObject("res\\sprites/rock2.png", 1856, 946, true, true));
        objects.add(new CollidableObject("res\\sprites/door-close-h.png", 260, 690, false, false));//openable doors
        objects.add(new CollidableObject("res\\sprites/door-close-h.png", 1028, 178, false, false));
        objects.add(new CollidableObject("res\\sprites/door-close-h.png", 1156, 818, false, false));
        objects.add(new CollidableObject("res\\sprites/door-close-h.png", 1220, 1202, false, false));
        objects.add(new CollidableObject("res\\sprites/door-close-h.png", 1732, 114, false, false));
        objects.add(new CollidableObject("res\\sprites/door-close-h.png", 2053, 498, true, false));//decorative doors
        objects.add(new CollidableObject("res\\sprites/door-close-h.png", 1668, 1650, true, false));
        objects.add(new Enemy("res\\sprites/sith_soldier_left_0.png", 1444, 1572, true, false));
        
        objects.addAll(makeWalls("res\\sprites/wall.png", 516, 50, 9, true));//horizontal walls
        objects.addAll(makeWalls("res\\sprites/wall.png", 580, 178, 7, true));
        objects.addAll(makeWalls("res\\sprites/wall.png", 644, 242, 6, true));
        objects.addAll(makeWalls("res\\sprites/wall.png", 1412, 114, 5, true));
        objects.addAll(makeWalls("res\\sprites/wall.png", 1796, 114, 5, true));
        objects.addAll(makeWalls("res\\sprites/wall.png", 1156, 434, 5, true));
        objects.addAll(makeWalls("res\\sprites/wall.png", 196, 626, 4, true));
        objects.addAll(makeWalls("res\\sprites/wall.png", 1156, 562, 15, true));
        objects.add(new CollidableObject("res\\sprites/wall.png", 325, 1074, true, false));
        objects.add(new CollidableObject("res\\sprites/wall.png", 516, 626, true, false));
        objects.add(new CollidableObject("res\\sprites/wall.png", 646, 626, true, false));
        objects.addAll(makeWalls("res\\sprites/wall.png", 1156, 626, 16, true));
        objects.addAll(makeWalls("res\\sprites/wall.png", 326, 754, 14, true));
        objects.addAll(makeWalls("res\\sprites/wall.png", 964, 882, 4, true));
        objects.addAll(makeWalls("res\\sprites/wall.png", 772, 690, 7, true));
        objects.addAll(makeWalls("res\\sprites/wall.png", 260, 946, 2, true));
        objects.add(new CollidableObject("res\\sprites/wall.png", 452, 946, true, false));
        objects.addAll(makeWalls("res\\sprites/wall.png", 580, 946, 2, true));
        objects.addAll(makeWalls("res\\sprites/wall.png", 772, 946, 2, true));        
        objects.addAll(makeWalls("res\\sprites/wall.png", 1220, 946, 10, true));
        objects.addAll(makeWalls("res\\sprites/wall.png", 1924, 946, 3, true));
        objects.addAll(makeWalls("res\\sprites/wall.png", 324, 1138, 3, true));
        objects.addAll(makeWalls("res\\sprites/wall.png", 772, 1202, 2, true));
        objects.addAll(makeWalls("res\\sprites/wall.png", 580, 1330, 4, true));
        objects.addAll(makeWalls("res\\sprites/wall.png", 1028, 1202, 3, true));
        objects.addAll(makeWalls("res\\sprites/wall.png", 1284, 1202, 14, true));
        objects.add(new CollidableObject("res\\sprites/wall.png", 708, 1586, true, false));
        objects.addAll(makeWalls("res\\sprites/wall.png", 196, 1650, 12, true));
        objects.addAll(makeWalls("res\\sprites/wall.png", 1028, 1778, 10, true));
        objects.addAll(makeWalls("res\\sprites/wall.png", 452, 50, 3, false));//vertical walls
        objects.addAll(makeWalls("res\\sprites/wall.png", 1092, 50, 4, false));
        objects.addAll(makeWalls("res\\sprites/wall.png", 388, 178, 2, false));
        objects.addAll(makeWalls("res\\sprites/wall.png", 324, 242, 6, false));
        objects.addAll(makeWalls("res\\sprites/wall.png", 708, 306, 7, false));        
        objects.addAll(makeWalls("res\\sprites/wall.png", 1156, 242, 4, false));
        objects.addAll(makeWalls("res\\sprites/wall.png", 2053, 178, 5, false));
        objects.addAll(makeWalls("res\\sprites/wall.png", 1412, 178, 4, false));
        objects.addAll(makeWalls("res\\sprites/wall.png", 197, 690, 15, false));
        objects.addAll(makeWalls("res\\sprites/wall.png", 517, 818, 12, false));
        objects.addAll(makeWalls("res\\sprites/wall.png", 900, 882, 12, false));
        objects.addAll(makeWalls("res\\sprites/wall.png", 1156, 946, 4, false));
        objects.addAll(makeWalls("res\\sprites/wall.png", 2116, 690, 8, false));
        objects.addAll(makeWalls("res\\sprites/wall.png", 1028, 1266, 8, false));
        objects.addAll(makeWalls("res\\sprites/wall.png", 1668, 1266, 6, false));
        objects.addAll(makeWalls("res\\sprites/wall.png", 1668, 1714, 2, false));
        objects.add(player);
        return objects;
    }

}
