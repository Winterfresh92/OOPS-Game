package Mission;

/* Chris Graff
 * Last Updated: March 10, 2015
 * Known Bugs: Can't move. No input for some reason.
 */
import Sprite.SpriteCache;
import Object.TextBox;
import Object.Player;
//import Object.Enemy; Not needed in Mission 1
import Object.InteractableObject;
import Object.GameObject;
import Object.CollidableObject;
import Engine.*;
import java.util.ArrayList;
import java.util.LinkedList;

// Handles data for Missions, child classes are actual missions. Constructs mission.
public class Mission2 extends Mission {

    public Mission2(Player player) {
        super(player);
        this.player = player;
        this.player.setX(640);
        this.player.setY(1408);
        bg = SpriteCache.getSpriteCache().getSprite("res\\sprites\\background/Mission2.png");
        textBoxSetup();
    }

    private void textBoxSetup() {
        textBoxQueue = new LinkedList<>();
        textBox = new TextBox("res\\sprites/text_box_0.png", Game.WIDTH / 10, (Game.HEIGHT - Game.HEIGHT / 3) - 40,
                "Master Dorak: Congratulations padawans, "
                + "\nor should I say, Jedi Knights.");
        textBoxQueue.offer(textBox);
        textBox = new TextBox("res\\sprites/text_box_0.png", Game.WIDTH / 10, (Game.HEIGHT - Game.HEIGHT / 3) - 40,
                "Master Dorak: You have spent at least the "
                + "\nlast 10 years training your skills, discipline, "
                + "\nand minds to fulfill the code of the Jedi. ,");
        textBoxQueue.offer(textBox);
        textBox = new TextBox("res\\sprites/text_box_0.png", Game.WIDTH / 10, (Game.HEIGHT - Game.HEIGHT / 3) - 40,
                "You have made the decision to choose an arduous "
                + "\npath to protect the galaxy from the dark side "
                + "\nof the Force.");
        textBoxQueue.offer(textBox);
        textBox = new TextBox("res\\sprites/text_box_0.png", Game.WIDTH / 10, (Game.HEIGHT - Game.HEIGHT / 3) - 40,
                "I applaud you for your years "
                + "\nof dedication and patience.");
        textBoxQueue.offer(textBox);
        textBox = new TextBox("res\\sprites/text_box_0.png", Game.WIDTH / 10, (Game.HEIGHT - Game.HEIGHT / 3) - 40,
                "As a full member of the Jedi Order, "
                + "\nyou must understand that your actions do not reflect "
                + "\njust upon yourself, but upon all of us. ");
        textBoxQueue.offer(textBox);
        textBox = new TextBox("res\\sprites/text_box_0.png", Game.WIDTH / 10, (Game.HEIGHT - Game.HEIGHT / 3) - 40,
                "Go forth and protect us all. "
                + "\nGood luck Knights.");
        textBoxQueue.offer(textBox);
        textBox = new TextBox("res\\sprites/text_box_0.png", Game.WIDTH / 10, (Game.HEIGHT - Game.HEIGHT / 3) - 40, 
                "Player: Congratulations Aeron, glad to see "
                + "\nthat you got nominated. I would congratulate "
                        + "\nyou on the test, but it wasn’t too terribly difficult.");
        textBoxQueue.offer(textBox);
        textBox = new TextBox("res\\sprites/text_box_0.png", Game.WIDTH / 10, (Game.HEIGHT - Game.HEIGHT / 3) - 40, 
                "Aeron Zeiss: Yeah, I’m happy for you too. "
                        + "\nI remember way back when we wer----");
        textBoxQueue.offer(textBox);
        textBox = new TextBox("res\\sprites/text_box_0.png", Game.WIDTH / 10, (Game.HEIGHT - Game.HEIGHT / 3) - 40, 
                "*An explosion shakes the room*");
        textBoxQueue.offer(textBox);
        textBox = new TextBox("res\\sprites/text_box_0.png", Game.WIDTH / 10, (Game.HEIGHT - Game.HEIGHT / 3) - 40, 
                "Aeron Zeiss: What was that?!");
        textBoxQueue.offer(textBox);
        textBox = new TextBox("res\\sprites/text_box_0.png", Game.WIDTH / 10, (Game.HEIGHT - Game.HEIGHT / 3) - 40, 
                "Player: I don’t know! Sounds like it"
                        + "\n came from inside the temple though.");
        textBoxQueue.offer(textBox);
        textBox = new TextBox("res\\sprites/text_box_0.png", Game.WIDTH / 10, (Game.HEIGHT - Game.HEIGHT / 3) - 40, 
                "Aeron Zeiss: Think we should check it out?");
        textBoxQueue.offer(textBox);
        textBox = new TextBox("res\\sprites/text_box_0.png", Game.WIDTH / 10, (Game.HEIGHT - Game.HEIGHT / 3) - 40, 
                "Master Dorak: Everyone remain calm! Knights, "
                        + "\nbe on guard. Expect anything. I must go to "
                        + "\nthe other Masters and decide what is to be done");
        textBoxQueue.offer(textBox);
        textBox = new TextBox(null, Game.WIDTH / 10, (Game.HEIGHT - Game.HEIGHT / 3) - 40, 
                "");//Dorak Leaves, pop automatically after he is gone.
        textBoxQueue.offer(textBox);
        textBox = new TextBox("res\\sprites/text_box_0.png", Game.WIDTH / 10, (Game.HEIGHT - Game.HEIGHT / 3) - 40, 
                "Player: Okay…Calm. I can do calm.");
        textBoxQueue.offer(textBox);
        textBox = new TextBox("res\\sprites/text_box_0.png", Game.WIDTH / 10, (Game.HEIGHT - Game.HEIGHT / 3) - 40, 
                "Aeron Zeiss: How are we supposed to remain "
                        + "\ncalm while things are exploding?");
        textBoxQueue.offer(textBox);
        textBox = new TextBox("res\\sprites/text_box_0.png", Game.WIDTH / 10, (Game.HEIGHT - Game.HEIGHT / 3) - 40, 
                "Player: The Force my friend");
        textBoxQueue.offer(textBox);
        textBox = new TextBox(null, Game.WIDTH / 10, (Game.HEIGHT - Game.HEIGHT / 3) - 40, 
                "");//door opens, 3 sith soldies run in, pop automatically after they stop moving.
        textBoxQueue.offer(textBox);
        textBox = new TextBox("res\\sprites/text_box_0.png", Game.WIDTH / 10, (Game.HEIGHT - Game.HEIGHT / 3) - 40, 
                "Sith Soldier 1: Looks like we got the wrong room.");
        textBoxQueue.offer(textBox);
        textBox = new TextBox("res\\sprites/text_box_0.png", Game.WIDTH / 10, (Game.HEIGHT - Game.HEIGHT / 3) - 40, 
                "Sith Soldier 2: No kidding. If the Masters "
                        + "\naren't here, what do we do?");
        textBoxQueue.offer(textBox);
        textBox = new TextBox("res\\sprites/text_box_0.png", Game.WIDTH / 10, (Game.HEIGHT - Game.HEIGHT / 3) - 40, 
                "Sith Soldier 3: Well, I guess we could "
                        + "\nkill some of those stupid Jedi kids "
                        + "\nover there....");
        textBoxQueue.offer(textBox);
        textBox = new TextBox("res\\sprites/text_box_0.png", Game.WIDTH / 10, (Game.HEIGHT - Game.HEIGHT / 3) - 40, 
                "Sith Soldier 1: Yeah, let's get 'em");
        textBoxQueue.offer(textBox);
        textBox = new TextBox("res\\sprites/text_box_0.png", Game.WIDTH / 10, (Game.HEIGHT - Game.HEIGHT / 3) - 40, 
                "Aeron Zeiss: Shall we?");
        textBoxQueue.offer(textBox);
        textBox = new TextBox("res\\sprites/text_box_0.png", Game.WIDTH / 10, (Game.HEIGHT - Game.HEIGHT / 3) - 40, 
                "Player: Please, I got this. Go get a "
                        + "\nNeon Twilek with a little unmbrella in it, "
                        + "\nand sip on it while you watch.");
        textBoxQueue.offer(textBox);
        queueQueue = new LinkedList<>();
        queueQueue.offer(textBoxQueue);
        textBoxQueue = new LinkedList<>();
        textBox = new TextBox("res\\sprites/text_box_0.png", Game.WIDTH / 10, (Game.HEIGHT - Game.HEIGHT / 3) - 40, 
                "Aeron Zeiss: Well done indeed. Well, "
                        + "\nsince you got them, the rest of us will"
                        + "\ngo in that direction and clean house.");
        textBoxQueue.offer(textBox);
        textBox = new TextBox("res\\sprites/text_box_0.png", Game.WIDTH / 10, (Game.HEIGHT - Game.HEIGHT / 3) - 40, 
                "Aeron Zeiss: Fellow Knights?");
        textBoxQueue.offer(textBox);
        textBox = new TextBox(null, Game.WIDTH / 10, (Game.HEIGHT - Game.HEIGHT / 3) - 40, 
                "");// all except player leave. Auto pop when they are gone.
        textBoxQueue.offer(textBox);
        textBox = new TextBox("res\\sprites/text_box_0.png", Game.WIDTH / 10, (Game.HEIGHT - Game.HEIGHT / 3) - 40, 
                "Player: Well now, I guess I'll"
                        + "\ngo see what Master Dorak got up to.");
        textBoxQueue.offer(textBox);
        textBox = new TextBox(null, Game.WIDTH / 10, (Game.HEIGHT - Game.HEIGHT / 3) - 40, 
                "");//three sith enter from top. pop when motion done
        textBoxQueue.offer(textBox);
        textBox = new TextBox("res\\sprites/text_box_0.png", Game.WIDTH / 10, (Game.HEIGHT - Game.HEIGHT / 3) - 40, 
                "Player: Or, you know, fight some more Sith.");
        textBoxQueue.offer(textBox);
        queueQueue.offer(textBoxQueue);
        textBoxQueue = new LinkedList<>();
        textBox = new TextBox("res\\sprites/text_box_0.png", Game.WIDTH / 10, (Game.HEIGHT - Game.HEIGHT / 3) - 40, 
                "Sith: *Sigh* Such a shame that they were "
                        + "/nsealed in the council chambers. ");
        textBoxQueue.offer(textBox);
        textBox = new TextBox("res\\sprites/text_box_0.png", Game.WIDTH / 10, (Game.HEIGHT - Game.HEIGHT / 3) - 40, 
                "I’m sure that the sleeping gas will make "
                        + "\nit much easier to apprehend them now.");
        textBoxQueue.offer(textBox);
        textBox = new TextBox("res\\sprites/text_box_0.png", Game.WIDTH / 10, (Game.HEIGHT - Game.HEIGHT / 3) - 40, 
                "Player: Well, you must be behind the attack on the temple");
        textBoxQueue.offer(textBox);
        textBox = new TextBox("res\\sprites/text_box_0.png", Game.WIDTH / 10, (Game.HEIGHT - Game.HEIGHT / 3) - 40, 
                "Sith: That’s right. I am Shunongg. Pleased"
                        + "\nto beat you. I am an Apprentice to the great "
                        + "\nDarth Exsul. Now, if you please, die for me.");
        textBoxQueue.offer(textBox);
        textBox = new TextBox("res\\sprites/text_box_0.png", Game.WIDTH / 10, (Game.HEIGHT - Game.HEIGHT / 3) - 40, 
                "Player: I’m sure that you would like that, "
                        + "\nbut that is not going to happen.");
        textBoxQueue.offer(textBox);
        textBoxQueue.offer(textBox);
        queueQueue.offer(textBoxQueue);
        textBoxQueue = new LinkedList<>();
        textBox = new TextBox("res\\sprites/text_box_0.png", Game.WIDTH / 10, (Game.HEIGHT - Game.HEIGHT / 3) - 40, 
                "Shunongg: Damn, didn't expect that *Dies*");
        textBoxQueue.offer(textBox);
        textBox = new TextBox("res\\sprites/text_box_0.png", Game.WIDTH / 10, (Game.HEIGHT - Game.HEIGHT / 3) - 40, 
                "Player: “Please, die for me,” What a crappy "
                        + "\nmonologue. Oh well. Time to wake up "
                        + "\nthe Masters then.");
        textBoxQueue.offer(textBox);
        textBox = new TextBox(null, Game.WIDTH / 10, (Game.HEIGHT - Game.HEIGHT / 3) - 40, 
                "");//masters open door and come into the hallway. pop when movement over.
        textBoxQueue.offer(textBox);
        textBox = new TextBox("res\\sprites/text_box_0.png", Game.WIDTH / 10, (Game.HEIGHT - Game.HEIGHT / 3) - 40, 
                "Master Vrook: I swear, when I catch that ruffian, "
                        + "\nI’m going to teach him to respect his elders.");
        textBoxQueue.offer(textBox);
        textBox = new TextBox("res\\sprites/text_box_0.png", Game.WIDTH / 10, (Game.HEIGHT - Game.HEIGHT / 3) - 40, 
                "Master Zhar: We will deal with him appropriately "
                        + "\nin the Jedi way. According to the Code.");
        textBoxQueue.offer(textBox);
        textBox = new TextBox("res\\sprites/text_box_0.png", Game.WIDTH / 10, (Game.HEIGHT - Game.HEIGHT / 3) - 40, 
                "Master Tokare: I don’t believe that this will be "
                        + "\nnecessary, specifically speaking. It "
                        + "\nwould appear that this Padawan has taken "
                        + "\ncare of the situation all on his own.");
        textBoxQueue.offer(textBox);
        textBox = new TextBox("res\\sprites/text_box_0.png", Game.WIDTH / 10, (Game.HEIGHT - Game.HEIGHT / 3) - 40, 
                "Master Dorak: Jedi Knight, actually. He just completed "
                        + "\nhis testing when the attack happened. It "
                        + "\nappears he might have been a bit extreme "
                        + "\nin dealing with it, however.");
        textBoxQueue.offer(textBox);
        textBox = new TextBox("res\\sprites/text_box_0.png", Game.WIDTH / 10, (Game.HEIGHT - Game.HEIGHT / 3) - 40, 
                "Master Zhar: Yes. Did you really have to kill him? "
                        + "\nSeems as though you need to spend more "
                        + "\ntime meditating on the Code.");
        textBoxQueue.offer(textBox);
        textBox = new TextBox("res\\sprites/text_box_0.png", Game.WIDTH / 10, (Game.HEIGHT - Game.HEIGHT / 3) - 40, 
                "Master Vrook: I would agree with you, but the lightsaber "
                        + "\nin the Sith’s hands and the scorch-marks on "
                        + "\nthe walls say enough.");
        textBoxQueue.offer(textBox);
        textBox = new TextBox("res\\sprites/text_box_0.png", Game.WIDTH / 10, (Game.HEIGHT - Game.HEIGHT / 3) - 40, 
                "Master Tokare: I agree. It would seem that you "
                        + "\nhandled the situation appropriately. "
                        + "\nWell done, Knight.");
        textBoxQueue.offer(textBox);
        textBox = new TextBox("res\\sprites/text_box_0.png", Game.WIDTH / 10, (Game.HEIGHT - Game.HEIGHT / 3) - 40, 
                "Master Zhar: Yes. After this mess has been cleaned "
                        + "\nup and things are back in order, we will "
                        + "\nwant to see you in our chambers.");
        textBoxQueue.offer(textBox);
        textBox = new TextBox("res\\sprites/text_box_0.png", Game.WIDTH / 10, (Game.HEIGHT - Game.HEIGHT / 3) - 40, 
                "We will send for you when ready. Go rest, Knight."
                        + "\nYou have done well this day.");
        textBoxQueue.offer(textBox);
        textBox = new TextBox(null, Game.WIDTH / 10, (Game.HEIGHT - Game.HEIGHT / 3) - 40, 
                "");//holding space for screen loading and movement
        textBoxQueue.offer(textBox);
        textBox = new TextBox("res\\sprites/text_box_0.png", Game.WIDTH / 10, (Game.HEIGHT - Game.HEIGHT / 3) - 40, 
                "Master Vrook: Thank you for coming.");
        textBoxQueue.offer(textBox);
        textBox = new TextBox("res\\sprites/text_box_0.png", Game.WIDTH / 10, (Game.HEIGHT - Game.HEIGHT / 3) - 40, 
                "Master Tokare: Yes, and thank you again for your "
                        + "\nassistance with the matter a few days earlier.");
        textBoxQueue.offer(textBox);
        textBox = new TextBox("res\\sprites/text_box_0.png", Game.WIDTH / 10, (Game.HEIGHT - Game.HEIGHT / 3) - 40, 
                "Player: No problem. Just out of curiosity, the Sith, "
                        + "\nShunongg, said that he had gassed you. How "
                        + "\ndid you wake up in time to come out when you did?");
        textBoxQueue.offer(textBox);textBox = new TextBox("res\\sprites/text_box_0.png", Game.WIDTH / 10, (Game.HEIGHT - Game.HEIGHT / 3) - 40, 
                "Master Zhar: The poor Sith failed to recognize that he "
                        + "\nwas dealing with Masters of the Force. We have "
                        + "\nstudied ways to protect the body with the "
                        + "\nForce as our guide.");
        textBoxQueue.offer(textBox);
        textBox = new TextBox("res\\sprites/text_box_0.png", Game.WIDTH / 10, (Game.HEIGHT - Game.HEIGHT / 3) - 40, 
                "Master Dorak: We did not fall asleep, but, with Zhar’s "
                        + "\nurging, had decided to wait and catch the hapless "
                        + "\nfool by surprise when we came out of the chambers. ");
        textBoxQueue.offer(textBox);textBox = new TextBox("res\\sprites/text_box_0.png", Game.WIDTH / 10, (Game.HEIGHT - Game.HEIGHT / 3) - 40, 
                "Master Tokare: As informative as this all is, we do have other "
                        + "\nmatters to deal with.");
        textBoxQueue.offer(textBox);
        textBoxQueue.offer(textBox);textBox = new TextBox("res\\sprites/text_box_0.png", Game.WIDTH / 10, (Game.HEIGHT - Game.HEIGHT / 3) - 40, 
                "Master Vrook: Indeed. We want you to investigate "
                        + "\nthis Darth Exsul character. We found a map "
                        + "\non the Sith Apprentice’s person. We would like "
                        + "\nyou to investigate the area.");
        textBoxQueue.offer(textBox);
        textBoxQueue.offer(textBox);textBox = new TextBox("res\\sprites/text_box_0.png", Game.WIDTH / 10, (Game.HEIGHT - Game.HEIGHT / 3) - 40, 
                "It is north of here, in the valleys. It simply shows "
                        + "\na rough sketch of an area. When you get "
                        + "\nthere, investigate fully until you have "
                        + "\nfound their base.");
        textBoxQueue.offer(textBox);
        textBoxQueue.offer(textBox);textBox = new TextBox("res\\sprites/text_box_0.png", Game.WIDTH / 10, (Game.HEIGHT - Game.HEIGHT / 3) - 40, 
                "Master Dorak: Yes, and take some measure of care. "
                        + "\nThere are many wild Kath Hounds in that area. "
                        + "\nThey will attack on sight for your trespassing. .");
        textBoxQueue.offer(textBox);
        textBoxQueue.offer(textBox);textBox = new TextBox("res\\sprites/text_box_0.png", Game.WIDTH / 10, (Game.HEIGHT - Game.HEIGHT / 3) - 40, 
                "Player: Very well, I shall attend to this at once.");
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
        objects = new ArrayList<>();
        //objects.add(player);
        //objects for the level go here
        objects.add(new CollidableObject("res\\sprites/door-close-h.png", 2112, 256, false, false));//openable doors
        objects.add(new CollidableObject("res\\sprites/door-close-h.png", 2368, 576, false, false));
        objects.add(new CollidableObject("res\\sprites/door-close-h.png", 1664, 512, false, false));
        objects.add(new CollidableObject("res\\sprites/door-close-h.png", 2112, 896, false, false));
        objects.add(new CollidableObject("res\\sprites/door-close-h.png", 1536, 1152, false, false));
        objects.add(new CollidableObject("res\\sprites/door-close-h.png", 512, 1280, false, false));
        objects.add(new CollidableObject("res\\sprites/door-close-h.png", 2368, 0, true, false));//decorative doors
        objects.add(new CollidableObject("res\\sprites/door-close-h.png", 1664, 64, true, false));
        objects.add(new CollidableObject("res\\sprites/door-close-h.png", 2688, 256, true, false));
        objects.add(new CollidableObject("res\\sprites/door-close-h.png", 512, 1088, true, false));
        objects.add(new CollidableObject("res\\sprites/door-close-h.png", 2560, 1152, true, false));
        objects.add(new CollidableObject("res\\sprites/door-close-h.png", 832, 1536, true, false));
        objects.add(new InteractableObject("res\\sprites/dorak_down_0.png", 1344, 1470, true, false, "Hurry along now."));

        objects.addAll(makeWalls("res\\sprites/wall.png", 2240, 1088, 4, true));//container lines
        objects.addAll(makeWalls("res\\sprites/wall.png", 1984, 1408, 5, true));
        objects.addAll(makeWalls("res\\sprites/wall.png", 1664, 0, 4, true));//horizontal walls
        objects.addAll(makeWalls("res\\sprites/wall.png", 2176, 0, 3, true));
        objects.addAll(makeWalls("res\\sprites/wall.png", 2496, 0, 4, true));
        objects.addAll(makeWalls("res\\sprites/wall.png", 1920, 192, 4, true));
        objects.addAll(makeWalls("res\\sprites/wall.png", 1024, 256, 10, true));
        objects.addAll(makeWalls("res\\sprites/wall.png", 1856, 448, 4, true));
        objects.addAll(makeWalls("res\\sprites/wall.png", 2112, 576, 4, true));
        objects.addAll(makeWalls("res\\sprites/wall.png", 2496, 576, 3, true));
        objects.addAll(makeWalls("res\\sprites/wall.png", 1664, 640, 3, true));
        objects.addAll(makeWalls("res\\sprites/wall.png", 2112, 768, 4, true));
        objects.addAll(makeWalls("res\\sprites/wall.png", 960, 832, 11, true));
        objects.addAll(makeWalls("res\\sprites/wall.png", 1600, 896, 8, true));
        objects.addAll(makeWalls("res\\sprites/wall.png", 2240, 896, 6, true));
        objects.addAll(makeWalls("res\\sprites/wall.png", 256, 1088, 4, true));
        objects.addAll(makeWalls("res\\sprites/wall.png", 576, 1088, 16, true));
        objects.addAll(makeWalls("res\\sprites/wall.png", 256, 1344, 4, true));
        objects.addAll(makeWalls("res\\sprites/wall.png", 576, 1344, 15, true));
        objects.addAll(makeWalls("res\\sprites/wall.png", 1536, 1600, 16, true));
        objects.addAll(makeWalls("res\\sprites/wall.png", 192, 1728, 11, true));

        objects.add(new CollidableObject("res\\sprites/wall.png", 2304, 640, true, false));//single wall piece

        objects.addAll(makeWalls("res\\sprites/wall.png", 2112, 0, 3, false));//vertical walls
        objects.addAll(makeWalls("res\\sprites/wall.png", 2688, 64, 3, false));
        objects.addAll(makeWalls("res\\sprites/wall.png", 1856, 64, 3, false));
        objects.addAll(makeWalls("res\\sprites/wall.png", 1664, 256, 5, false));
        objects.addAll(makeWalls("res\\sprites/wall.png", 960, 320, 9, false));
        objects.addAll(makeWalls("res\\sprites/wall.png", 2112, 448, 3, false));
        objects.addAll(makeWalls("res\\sprites/wall.png", 2688, 448, 4, false));
        objects.addAll(makeWalls("res\\sprites/wall.png", 1856, 512, 4, false));
        objects.addAll(makeWalls("res\\sprites/wall.png", 2496, 704, 4, false));
        objects.addAll(makeWalls("res\\sprites/wall.png", 1664, 768, 3, false));
        objects.addAll(makeWalls("res\\sprites/wall.png", 2048, 768, 3, false));
        objects.addAll(makeWalls("res\\sprites/wall.png", 1536, 896, 3, false));
        objects.addAll(makeWalls("res\\sprites/wall.png", 2560, 960, 3, false));
        objects.addAll(makeWalls("res\\sprites/wall.png", 192, 1088, 10, false));
        objects.addAll(makeWalls("res\\sprites/wall.png", 1536, 1280, 5, false));
        objects.addAll(makeWalls("res\\sprites/wall.png", 2560, 1280, 6, false));
        objects.addAll(makeWalls("res\\sprites/wall.png", 832, 1344, 3, false));

        return objects;
    }

    @Override
    public boolean levelOver() {
        return queueQueue.isEmpty();
    }

}
