package Mission;

/* Chris Graff
 * Last Updated: March 10, 2015
 * Known Bugs: None
 */

import Sprite.SpriteCache;
import Object.TextBox;
import Object.Player;
//import Object.Enemy; Not needed in Mission 1
import Object.InteractableObject;
import Object.GameObject;
import Object.CollidableObject;
import Engine.*;
import Object.InteractableSlip;
import java.util.ArrayList;
import java.util.LinkedList;


// Handles data for Missions, child classes are actual missions. Constructs mission.
public class MissionIntro extends Mission{
    
    

    public MissionIntro(Player player, GameData gameData) {
        super(player, gameData);
        this.player = player;
        this.player.setX(-500);
        this.player.setY(-500);
        
        bg = null;//no background
        textBoxSetup();
    }
    
    private void textBoxSetup() {
    }
    
    @Override
    public LinkedList<TextBox> getTextBoxQueue(){
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
        CollidableObject myIntro = new CollidableObject("res\\sprites/StarWarsALLTAIAGFFA(transparent).png", 0, 0, true, true);
        myIntro.setVelY(20);
        objects.add(myIntro);//intro graphic
    }
    
    public boolean levelOver(){
        return queueQueue.isEmpty();
    }

}
