/* Chris Graff
 * Last Updated: March 1, 2015
 * Known Bugs: None
 */

import java.util.ArrayList;
import java.util.LinkedList;

// Handles data for Missions, child classes are actual missions. Constructs mission.
public class Mission{

    protected TextBox textBox;
    protected LinkedList<TextBox> textBoxQueue;
    protected Player player;
    protected ArrayList<GameObject> objects;
    
    public Mission(Player player) {
        this.player = player;
    }
    
    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public TextBox getTextBox() {
        return textBox;
    }

    public void setTextBox(TextBox textBox) {
        this.textBox = textBox;
    }

    public LinkedList<TextBox> getTextBoxQueue() {
        return textBoxQueue;
    }

    public void setTextBoxQueue(LinkedList<TextBox> textBoxQueue) {
        this.textBoxQueue = textBoxQueue;
    }

    public ArrayList<GameObject> getObjects() {
        return objects;
    }

    public void setObjects(ArrayList<GameObject> objects) {
        this.objects = objects;
    }
    
}
