package Mission;

/**
 * Hanye Wu
 * April 16, 2015
 * Cannot skip to Mission3, don't know how actually objects set. 
 */

import Sprite.SpriteCache;
//import Object.TextBox;
import Object.Player;
//import Object.Enemy;
//import Object.InteractableObject;
import Object.GameObject;
import Object.CollidableObject;
import Engine.*;
import Object.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class Mission3 extends Mission{
    
    public Mission3(Player player, GameData gameData) {
        super(player, gameData);
        this.player = player;
        this.player.setX(4);
        this.player.setY(250);
        bg = SpriteCache.getSpriteCache().getSprite("res\\sprites\\background/Mission3-bg-v2.png");        
        //textBoxSetup();
    }
    
    @Override
    public ArrayList<GameObject> getObjects() {
        objects = new ArrayList<>();
        objects.add(player);
        //objects for the level go here
        //door implements later
        //walls horizontal
        objects.addAll(makeWalls("res\\sprites/mission3-wall.png", getX(0), getY(2), 3, true));
        objects.addAll(makeWalls("res\\sprites/mission3-wall.png", getX(0), getY(5), 3, true));
        objects.addAll(makeWalls("res\\sprites/mission3-wall.png", getX(2), getY(1), 5, true));
        objects.addAll(makeWalls("res\\sprites/mission3-wall.png", getX(6), getY(2), 2, true));
        objects.addAll(makeWalls("res\\sprites/mission3-wall.png", getX(7), getY(3), 2, true));
        objects.addAll(makeWalls("res\\sprites/mission3-wall.png", getX(2), getY(6), 2, true));
        objects.addAll(makeWalls("res\\sprites/mission3-wall.png", getX(3), getY(7), 2, true));
        
        objects.addAll(makeWalls("res\\sprites/mission3-wall.png", getX(2), getY(22), 5, true));
        objects.addAll(makeWalls("res\\sprites/mission3-wall.png", getX(6), getY(23), 6, true));
        objects.addAll(makeWalls("res\\sprites/mission3-wall.png", getX(9), getY(18), 7, true));
        objects.addAll(makeWalls("res\\sprites/mission3-wall.png", getX(11), getY(19), 2, true));
        objects.addAll(makeWalls("res\\sprites/mission3-wall.png", getX(11), getY(22), 4, true));
        objects.addAll(makeWalls("res\\sprites/mission3-wall.png", getX(14), getY(21), 6, true));
        objects.addAll(makeWalls("res\\sprites/mission3-wall.png", getX(15), getY(17), 2, true));
        
        objects.addAll(makeWalls("res\\sprites/mission3-wall.png", getX(18), getY(12), 2, true));
        objects.addAll(makeWalls("res\\sprites/mission3-wall.png", getX(19), getY(22), 2, true));
        objects.addAll(makeWalls("res\\sprites/mission3-wall.png", getX(20), getY(23), 2, true));
        objects.addAll(makeWalls("res\\sprites/mission3-wall.png", getX(21), getY(24), 1, true));
        objects.addAll(makeWalls("res\\sprites/mission3-wall.png", getX(21), getY(25), 5, true));
        objects.addAll(makeWalls("res\\sprites/mission3-wall.png", getX(25), getY(24), 4, true));
        objects.addAll(makeWalls("res\\sprites/mission3-wall.png", getX(22), getY(19), 7, true));
        
        objects.addAll(makeWalls("res\\sprites/mission3-wall.png", getX(21), getY(14), 3, true));
        objects.addAll(makeWalls("res\\sprites/mission3-wall.png", getX(23), getY(15), 11, true));
        objects.addAll(makeWalls("res\\sprites/mission3-wall.png", getX(24), getY(17), 4, true));
        objects.addAll(makeWalls("res\\sprites/mission3-wall.png", getX(27), getY(18), 3, true));
        
        objects.addAll(makeWalls("res\\sprites/mission3-wall.png", getX(25), getY(0), 6, true));
        objects.addAll(makeWalls("res\\sprites/mission3-wall.png", getX(24), getY(1), 2, true));
        objects.addAll(makeWalls("res\\sprites/mission3-wall.png", getX(24), getY(2), 2, true));
        objects.addAll(makeWalls("res\\sprites/mission3-wall.png", getX(24), getY(4), 2, true));
        objects.addAll(makeWalls("res\\sprites/mission3-wall.png", getX(25), getY(5), 2, true));
        objects.addAll(makeWalls("res\\sprites/mission3-wall.png", getX(26), getY(6), 5, true));
        
        objects.addAll(makeWalls("res\\sprites/mission3-wall.png", getX(30), getY(1), 3, true));
        objects.addAll(makeWalls("res\\sprites/mission3-wall.png", getX(32), getY(10), 6, true));
        objects.addAll(makeWalls("res\\sprites/mission3-wall.png", getX(37), getY(1), 2, true));
        objects.addAll(makeWalls("res\\sprites/mission3-wall.png", getX(30), getY(3), 2, true));
        objects.addAll(makeWalls("res\\sprites/mission3-wall.png", getX(30), getY(4), 2, true));
        objects.addAll(makeWalls("res\\sprites/mission3-wall.png", getX(29), getY(5), 2, true));
        
        objects.addAll(makeWalls("res\\sprites/mission3-wall.png", getX(25), getY(9), 5, true));
        objects.addAll(makeWalls("res\\sprites/mission3-wall.png", getX(24), getY(10), 2, true));
        objects.addAll(makeWalls("res\\sprites/mission3-wall.png", getX(27), getY(11), 2, true));
        objects.addAll(makeWalls("res\\sprites/mission3-wall.png", getX(28), getY(12), 2, true));
        objects.addAll(makeWalls("res\\sprites/mission3-wall.png", getX(28), getY(13), 2, true));
        
        objects.addAll(makeWalls("res\\sprites/mission3-wall.png", getX(30), getY(11), 2, true));
        objects.addAll(makeWalls("res\\sprites/mission3-wall.png", getX(32), getY(10), 3, true));
        objects.addAll(makeWalls("res\\sprites/mission3-wall.png", getX(34), getY(9), 3, true));
        objects.addAll(makeWalls("res\\sprites/mission3-wall.png", getX(36), getY(7), 2, true));
        objects.addAll(makeWalls("res\\sprites/mission3-wall.png", getX(36), getY(8), 1, true));
        objects.addAll(makeWalls("res\\sprites/mission3-wall.png", getX(33), getY(12), 2, true));
        objects.addAll(makeWalls("res\\sprites/mission3-wall.png", getX(31), getY(13), 8, true));
        objects.addAll(makeWalls("res\\sprites/mission3-wall.png", getX(35), getY(14), 2, true));
        
        objects.addAll(makeWalls("res\\sprites/mission3-wall.png", getX(32), getY(19), 2, true));
        objects.addAll(makeWalls("res\\sprites/mission3-wall.png", getX(33), getY(20), 2, true));
        objects.addAll(makeWalls("res\\sprites/mission3-wall.png", getX(33), getY(21), 2, true));
        objects.addAll(makeWalls("res\\sprites/mission3-wall.png", getX(33), getY(22), 2, true));
        objects.addAll(makeWalls("res\\sprites/mission3-wall.png", getX(33), getY(23), 5, true));
        objects.addAll(makeWalls("res\\sprites/mission3-wall.png", getX(33), getY(26), 2, true));
        objects.addAll(makeWalls("res\\sprites/mission3-wall.png", getX(32), getY(27), 4, true));
              
        //vertical wall
        
        objects.addAll(makeWalls("res\\sprites/mission3-wall.png", getX(4), getY(8), 2, false));
        objects.addAll(makeWalls("res\\sprites/mission3-wall.png", getX(8), getY(4), 9, false));
        objects.addAll(makeWalls("res\\sprites/mission3-wall.png", getX(5), getY(10), 6, false));
        objects.addAll(makeWalls("res\\sprites/mission3-wall.png", getX(9), getY(12), 6, false));
        objects.addAll(makeWalls("res\\sprites/mission3-wall.png", getX(2), getY(17), 5, false));
        objects.addAll(makeWalls("res\\sprites/mission3-wall.png", getX(3), getY(16), 2, false));
        objects.addAll(makeWalls("res\\sprites/mission3-wall.png", getX(4), getY(15), 2, false));
        
        objects.addAll(makeWalls("res\\sprites/mission3-wall.png", getX(15), getY(4), 4, false));
        objects.addAll(makeWalls("res\\sprites/mission3-wall.png", getX(16), getY(3), 2, false));
        objects.addAll(makeWalls("res\\sprites/mission3-wall.png", getX(17), getY(2), 2, false));
        objects.addAll(makeWalls("res\\sprites/mission3-wall.png", getX(20), getY(2), 2, false));
        objects.addAll(makeWalls("res\\sprites/mission3-wall.png", getX(21), getY(3), 2, false));
        objects.addAll(makeWalls("res\\sprites/mission3-wall.png", getX(22), getY(3), 4, false));
        objects.addAll(makeWalls("res\\sprites/mission3-wall.png", getX(16), getY(7), 10, false));
        objects.addAll(makeWalls("res\\sprites/mission3-wall.png", getX(21), getY(7), 2, false));
        objects.addAll(makeWalls("res\\sprites/mission3-wall.png", getX(20), getY(8), 10, false));
        
        objects.addAll(makeWalls("res\\sprites/mission3-wall.png", getX(22), getY(11), 3, false));
        objects.addAll(makeWalls("res\\sprites/mission3-wall.png", getX(23), getY(10), 2, false));
        objects.addAll(makeWalls("res\\sprites/mission3-wall.png", getX(29), getY(7), 2, false));
        
        objects.addAll(makeWalls("res\\sprites/mission3-wall.png", getX(28), getY(21), 2, false));
        objects.addAll(makeWalls("res\\sprites/mission3-wall.png", getX(29), getY(21), 7, false));
        objects.addAll(makeWalls("res\\sprites/mission3-wall.png", getX(30), getY(20), 4, false));
        objects.addAll(makeWalls("res\\sprites/mission3-wall.png", getX(30), getY(16), 1, false));
        
        objects.addAll(makeWalls("res\\sprites/mission3-wall.png", getX(34), getY(16), 2, false));
        objects.addAll(makeWalls("res\\sprites/mission3-wall.png", getX(35), getY(16), 1, false));
        objects.addAll(makeWalls("res\\sprites/mission3-wall.png", getX(36), getY(18), 3, false));
        objects.addAll(makeWalls("res\\sprites/mission3-wall.png", getX(37), getY(14), 5, false));
        objects.addAll(makeWalls("res\\sprites/mission3-wall.png", getX(37), getY(20), 3, false));
        
        objects.addAll(makeWalls("res\\sprites/mission3-wall.png", getX(38), getY(2), 6, false));
        objects.addAll(makeWalls("res\\sprites/mission3-wall.png", getX(37), getY(9), 2, false));
        objects.addAll(makeWalls("res\\sprites/mission3-wall.png", getX(38), getY(10), 3, false));
        
        return objects;
    }
    
    public int getX(int n){
        return n*64+5;
    }
    public int getY(int m){
        return m*64+49;
    }

    @Override
    public boolean levelOver() {
        return queueQueue.isEmpty();
    }
    
}