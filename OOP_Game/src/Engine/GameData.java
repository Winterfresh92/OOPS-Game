package Engine;

/* Kevin Stubblefield
 * Last Updated: April 13, 2015
 * Known Bugs: None
 * Added mission test for testing purposes
 * Moved loading into loading screen for mission 2 (load() function)
 * Added mission getter/setter and loadGameFromFile method
 *
 * Carlos Pena
 * Last Updated: April 16, 2015
 * Know Bugs: None
 * Added missionSkip(), press L to skip to next mission, adjust the number as more missions are added
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
import Mission.MissionTest;
import Music.SoundEffects;
import Object.Enemy;
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
    private SaveFileHandler saveFileHandler;
    private ArrayList<GameObject> toBeRemoved;
    private boolean loadingFromFile;
    
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
        saveFileHandler = new SaveFileHandler(this);
        toBeRemoved = new ArrayList<>();
        loadingFromFile = false;
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
                mission++;
                gameStates.pop();
                gameStates.push(GameState.MENU_STATE);
                return;
            case 2:
                player.setMission(1);
                if(loadingFromFile) {
                    active = new Mission1(player, this, player.getX(), player.getY());
                    textBoxQueue = active.getTextBoxQueue(); //Skips the intro text so you don't have to read it again.
                    while(!textBoxQueue.isEmpty()) {
                        textBoxQueue.pop();
                    }
                } else {
                    active = new Mission1(player, this);
                    textBoxQueue = active.getTextBoxQueue();
                }
                active.generateObjects();
                objects = active.getObjects();
                player = active.getPlayer();
                bg = active.getBackground();
                loaded = true;
                loadingFromFile = false;
                gameStates.pop();
                gameStates.push(GameState.MISSION_01_STATE);
                mission++;
                return;
            case 3:
                player.setMission(2);
                if(loadingFromFile) {
                    active = new Mission2(player, this, player.getX(), player.getY());
                } else {
                    active = new Mission2(player, this);
                    textBoxQueue = active.getTextBoxQueue();
                }
                objects = active.getObjects();
                player = active.getPlayer();
                bg = active.getBackground();
                loaded = true;
                loadingFromFile = false;
                gameStates.pop();
                gameStates.push(GameState.MISSION_02_STATE);
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
        } if(gameStates.peek() == GameState.INTRO_STATE){
            game.getIntroScreen().update();
            if(game.getIntroScreen().finished()){
                gameStates.pop();
                load();
            }
            //game.getCamera().setX(0);
            //game.getCamera().setY(0);
        }if(gameStates.peek() == GameState.MISSION_01_STATE){
            textBox.update();
            background.update();
            game.getCamera().update(player);
            hud.update();
            for(GameObject object : objects) {
                object.update();
                if(object instanceof Player)
                {
                    Player p = (Player) object;
                    
                    if(p.getHealth() < 1)
                    {
                        gameStates.push(GameState.PAUSE_STATE);
                    }
                }
            }
            if(!toBeRemoved.isEmpty()){
                objects.removeAll(toBeRemoved);
                toBeRemoved = new ArrayList<>();
            }
            if(active.levelOver()&& !textBoxQueue.isEmpty()){
                loaded = false;
                gameStates.pop();
                gameStates.push(GameState.MISSION_02_STATE);
            }
        }
        else if(gameStates.peek() == GameState.MISSION_02_STATE){
            if(!loaded){
                //gameStates.push(GameState.LOADING_STATE);
                load();
            }
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
        else if(gameStates.peek() == GameState.MISSION_TEST_STATE) {
            if(!loaded) {
                active = new MissionTest(player, this);
                objects = active.getObjects();
                textBoxQueue = active.getTextBoxQueue();
                player = active.getPlayer();
                bg = active.getBackground();
                loaded = true;
            }
            textBox.update();
            background.update();
            game.getCamera().update(player);
            hud.update();
            for(GameObject object : objects) {
                object.update();
            }
        }
    }
    
    public void missionSkip() {
        if(mission > 3) { 
            return;
        }
        else { 
            load();
        }
    }
    
    public void loadGameFromFile() {
        saveFileHandler.loadGame();
        System.out.println("MISSION " + mission);
        load();
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
            if(t.getText().equals(toAdd.getText()) && toAdd.getText() != null)
                return;
        }
        textBoxQueue.offer(toAdd);
    }
    
    public ArrayList<GameObject> getObjects() {
        return objects;
    }
    
    public void removeObject(GameObject toRemove){
        for(GameObject object : objects){
            if(object == toRemove){
                toBeRemoved.add(object);
            }
        }
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

    public SaveFileHandler getSaveFileHandler() {
        return saveFileHandler;
    }

    public void setSaveFileHandler(SaveFileHandler saveFileHandler) {
        this.saveFileHandler = saveFileHandler;
    }

    public int getMission() {
        return mission;
    }

    public void setMission(int mission) {
        this.mission = mission;
    }

    public boolean isLoadingFromFile() {
        return loadingFromFile;
    }

    public void setLoadingFromFile(boolean loadingFromFile) {
        this.loadingFromFile = loadingFromFile;
    }
    
}

