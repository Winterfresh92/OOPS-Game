package Mission;

/* Chris Graff
 * Last Updated: March 1, 2015
 * Known Bugs: None
 */

import Sprite.Sprite;
import Object.GameObject;
import Object.Player;
import Object.CollidableObject;
import Object.TextBox;
import java.util.ArrayList;
import java.util.LinkedList;

// Handles data for Missions, child classes are actual missions. Constructs mission.
public class Mission{

    protected TextBox textBox;
    protected LinkedList<TextBox> textBoxQueue;
    protected Player player;
    protected ArrayList<GameObject> objects;
    protected Sprite bg;
    
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
    
    public Sprite getBackground(){
        return bg;
    }
    
    public ArrayList<GameObject> makeWalls(String name, int x, int y, int pieces, boolean horizontal){//generates walls on a lesser to greater basis every 64px.
        ArrayList<GameObject> walls = new ArrayList<>();
        for(int count = 0; count < pieces; count++){
            if(horizontal){
                walls.add(new CollidableObject(name, (x + (count*64)), y, true, false));
            }else{
                walls.add(new CollidableObject(name, x, (y + (count*64)), true, false));
            }
        }
        return walls;
    }
}
