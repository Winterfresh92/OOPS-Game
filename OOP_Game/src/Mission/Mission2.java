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
import java.util.ArrayList;
import java.util.LinkedList;


// Handles data for Missions, child classes are actual missions. Constructs mission.
public class Mission2 extends Mission{
    
    

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
        //make then offer
        queueQueue = new LinkedList<>();
        queueQueue.offer(textBoxQueue);
        textBoxQueue = new LinkedList<>();
    }
    
    @Override
    public LinkedList<TextBox> getTextBoxQueue(){
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
    public boolean levelOver(){
        return queueQueue.isEmpty();
    }

}
