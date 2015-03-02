/* Chris Graff
 * Last Updated: March 1, 2015
 * Known Bugs: None
 */

import java.util.ArrayList;
import java.util.LinkedList;


// Handles data for Missions, child classes are actual missions. Constructs mission.
public class Mission1 extends Mission{
    
    

    public Mission1(Player player) {
        super(player);
        this.player = player;
        this.player.x = 100;
        this.player.y = 100;
    }

    @Override
    public Player getPlayer() {
        return this.player;
    }

    @Override
    public void setPlayer(Player player) {
        this.player = player;
    }

    @Override
    public TextBox getTextBox() {
        return textBox;
    }

    @Override
    public void setTextBox(TextBox textBox) {
        this.textBox = textBox;
        textBoxQueue.offer(textBox);
    }

    @Override
    public LinkedList<TextBox> getTextBoxQueue() {
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
        textBoxQueue.offer(textBox);
        textBox = new TextBox("res\\sprites/text_box_0.png", Game.WIDTH / 10, (Game.HEIGHT - Game.HEIGHT / 3) - 40, "Master Dorak: Of course. Now please"
                                                                                + "\nexcuse me, I must prepare for"
                                                                                + "\nthe ceremony.");
        textBoxQueue.offer(textBox);
        return textBoxQueue;
    }

    @Override
    public void setTextBoxQueue(LinkedList<TextBox> textBoxQueue) {
        this.textBoxQueue = textBoxQueue;
    }

    @Override
    public ArrayList<GameObject> getObjects() {
        objects = new ArrayList<>();
        objects.add(player);
        //objects for the level go here
        return objects;
    }

    @Override
    public void setObjects(ArrayList<GameObject> objects) {
        this.objects = objects;
    }

}
