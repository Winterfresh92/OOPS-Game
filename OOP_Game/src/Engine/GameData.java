package Engine;

/* Kevin Stubblefield
 * Last Updated: March 11, 2015
 * Known Bugs: None
 */

import HUD.HUD;
import Menu.InventoryScreen;
import Sprite.Sprite;
import Menu.PauseScreen;
import Menu.MenuScreen;
import Music.Music;
import Object.Player;
import Object.GameObject;
import Object.TextBox;
import Mission.Mission;
import Mission.Mission1;
import Mission.Mission2;
import Music.SoundEffects;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

// Handles all updates in the game and holds all data
public class GameData {
    
    Game game;
    private int mission;
    private int time;
    private TextBox textBox;
    private TextBox nullBox;
    private HUD hud;
    private LinkedList<TextBox> textBoxQueue;
    private Stack<GameState> gameStates;
    private Player player;
    private MenuScreen menu;
    private PauseScreen pause;
    private InventoryScreen inventory;
    public static Music background;
    private ArrayList<GameObject> objects;
    private Mission active;
    private boolean loaded;
    private Sprite bg;
    
    public GameData(Game game) {
        this.game = game;
        //bg = SpriteCache.getSpriteCache().getSprite("res\\sprites/2400x1800px Checkered board.png");
        init();
        load();
    }
    
    private void init() {
        mission = 0;
        time = 120;
        menu = game.getMenuScreen();
        pause = game.getPauseScreen();
        background = new Music(false);
        objects = new ArrayList<>();
        gameStates = new Stack<>();
        gameStates.push(GameState.MENU_STATE);
        loaded = false;
        player = new Player("res\\sprites/player_front_0.png", 0, 0);
        player.setGameData(this);
        textBoxQueue = new LinkedList<>();
        objects = new ArrayList<>();
        nullBox = new TextBox(null, -500, -500, "");
        textBox = nullBox;
        hud = new HUD(player);
        inventory = new InventoryScreen(player);
    }
    
    // Give mission number as parameter, initial load is 0
    private void load() {
        gameStates.push(GameState.LOADING_STATE);
        switch(mission) {
            case 0:
                ResourceLoader.loadImages();
                ResourceLoader.loadMusic();
                ResourceLoader.loadSoundEffects();
                mission++;
                return;
            case 1:
                active = new Mission1(player);
                active.generateObjects();
                objects = active.getObjects();
                textBoxQueue = active.getTextBoxQueue();
                player = active.getPlayer();
                bg = active.getBackground();
                loaded = true;
                mission++;
                gameStates.pop();
                gameStates.push(GameState.MENU_STATE);
                return;
            case 2:
                gameStates.pop();
                gameStates.push(GameState.MISSION_01_STATE);
                mission++;
                return;
            default:
                return;
        }
    }
    
    // All updates will go here
    public void update() {
        if(gameStates.peek() == GameState.MENU_STATE) {
            background.Menu = true;
            background.MenuPlay();
        } if(gameStates.peek() == GameState.LOADING_STATE) {
            game.getLoadingScreen().update();
            time--;
            if(time <= 0) {
                load();
                time = 120;
            }
        } if(gameStates.peek() == GameState.PAUSE_STATE) {
            game.getGameLoop().pause();
            pause = game.getPauseScreen();
            background.Pause();
            SoundEffects.volume = SoundEffects.Volume.Mute;
        } if(gameStates.peek() == GameState.INVENTORY_STATE) {
            inventory.update();
        } if(gameStates.peek() == GameState.MISSION_01_STATE){
            textBox.update();
            background.update();
            game.getCamera().update(player);
            hud.update();
            for(GameObject object : objects) {
                object.update();
            }
            if(active.levelOver()){
                loaded = false;
                gameStates.pop();
                gameStates.push(GameState.MISSION_02_STATE);
            }
        }
        else if(gameStates.peek() == GameState.MISSION_02_STATE){
            if(!loaded){
                active = new Mission2(player);
                objects = active.getObjects();
                textBoxQueue = active.getTextBoxQueue();
                player = active.getPlayer();
                bg = active.getBackground();
                loaded = true;
            }
            textBox.update();
            background.update();
            game.getCamera().update(player);
            for(GameObject object : objects) {
                object.update();
            }
            if(active.levelOver()){
                loaded = false;
                gameStates.pop();
                gameStates.push(GameState.MISSION_02_STATE);
            }
        }
    }
    
    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
    
    public void getNextQueue(){
        textBoxQueue = active.getTextBoxQueue();
    }
    
    public void addToQueue(TextBox toAdd){
        for(TextBox t: textBoxQueue){
            TextBox toCheck = (TextBox) t;
            if(t.getText().equals(toAdd.getText()))
                return;
        }
        textBoxQueue.offer(toAdd);
    }
    
    public ArrayList<GameObject> getObjects() {
        return objects;
    }
    
    public LinkedList<TextBox> getTextBoxQueue() {
        return textBoxQueue;
    }

    public TextBox getTextBox() {
        return textBox;
    }

    public void setTextBox(TextBox textBox) {
        this.textBox = textBox;
    }

    public Stack<GameState> getGameStates() {
        return gameStates;
    }

    public void setGameStates(Stack<GameState> gameStates) {
        this.gameStates = gameStates;
    }

    public MenuScreen getMenu() {
        return menu;
    }

    public void setMenu(MenuScreen menu) {
        this.menu = menu;
    }
    
    public void setPause(PauseScreen pause) {
        this.pause = pause;
    }
    
    public PauseScreen getPause() {
        return pause;
    }
    
    public Game getGame() {
        return this.game;
    }
    
    public Sprite getBackground(){
        return bg;
    }

    public boolean isLoaded() {
        return loaded;
    }

    public void setLoaded(boolean loaded) {
        this.loaded = loaded;
    }

    public HUD getHud() {
        return hud;
    }

    public void setHud(HUD hud) {
        this.hud = hud;
    }

    public InventoryScreen getInventory() {
        return inventory;
    }

    public void setInventory(InventoryScreen inventory) {
        this.inventory = inventory;
    }
    
}

