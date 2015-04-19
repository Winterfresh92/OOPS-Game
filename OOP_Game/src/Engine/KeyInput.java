package Engine;

/* Kevin Stubblefield
 * Last Updated: April 13, 2015
 * Known Bugs: None
 * Added O to go into test mission for testing new features.
 * Added call to loadGameFromFile
 * 
 * Carlos Pena
 * Last Updated: March 25, 2015
 * Known Bugs: None
 * Press J to use Force Power selected
 */
import Menu.MenuScreen;
import Menu.PauseScreen;
import Music.*;
import Object.Enemy;
import Object.GameObject;
import Sprite.Sprite;
import Sprite.SpriteCache;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class KeyInput implements KeyListener {

    private static boolean right = false;
    private static boolean left = false;
    private static boolean up = false;
    private static boolean down = false;
    private boolean save = true;

    private GameData gameData;
    private Music music = GameData.background;

    public KeyInput(GameData gameData) {
        this.gameData = gameData;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // DEBUGGING STUFF
        if (e.getKeyCode() == KeyEvent.VK_O) {
            System.out.println("O pressed!");
            gameData.setLoaded(false);
            gameData.getGameStates().push(GameState.MISSION_TEST_STATE);
        }
        if(e.getKeyCode() == KeyEvent.VK_Y) {
            gameData.getSaveFileHandler().saveGame();
        }
        if(e.getKeyCode() == KeyEvent.VK_L) {
            System.out.println("mission skip activated");
            gameData.missionSkip();
        }
        if (gameData.getGameStates().peek() == GameState.MENU_STATE) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) { // Select menu item
                if (gameData.getMenu().getSelected() == MenuScreen.START_GAME_SELECTED) {
                    gameData.getGameStates().pop();
                    gameData.getGameStates().push(GameState.LOADING_STATE);
                    //gameData.getGameStates().push(GameState.MISSION_TEST_STATE);
                    music.Menu = false;
                    music.Pause();
                    music.play();
                } else if(gameData.getMenu().getSelected() == MenuScreen.CONTINUE_SELECTED) {
                    gameData.getGameStates().pop();
                    gameData.loadGameFromFile();
                } else if(gameData.getMenu().getSelected() == MenuScreen.OPTIONS_SELECTED) {
                    if(Music.volume != Music.Volume.Mute) {
//                    SoundEffects.volume = SoundEffects.Volume.Mute;
                    music.Mute();
                    }
                    else {
                        Music.volume = Music.Volume.Medium;
                        SoundEffects.volume = SoundEffects.Volume.High;
                        music.play();
                    }
                } else if(gameData.getMenu().getSelected() == MenuScreen.EXIT_SELECTED) {
                    System.exit(0);
                }
            } else if (e.getKeyCode() == KeyEvent.VK_UP) { // Navigate up menu
                if (gameData.getMenu().getSelected() == MenuScreen.START_GAME_SELECTED) {
                    gameData.getMenu().setSelected(MenuScreen.EXIT_SELECTED);
                } else if (gameData.getMenu().getSelected() == MenuScreen.CONTINUE_SELECTED) {
                    gameData.getMenu().setSelected(MenuScreen.START_GAME_SELECTED);
                } else if (gameData.getMenu().getSelected() == MenuScreen.OPTIONS_SELECTED) {
                    gameData.getMenu().setSelected(MenuScreen.CONTINUE_SELECTED);
                } else if (gameData.getMenu().getSelected() == MenuScreen.EXIT_SELECTED) {
                    gameData.getMenu().setSelected(MenuScreen.OPTIONS_SELECTED);
                }
            } else if (e.getKeyCode() == KeyEvent.VK_DOWN) { // Navigate down menu
                if (gameData.getMenu().getSelected() == MenuScreen.START_GAME_SELECTED) {
                    gameData.getMenu().setSelected(MenuScreen.CONTINUE_SELECTED);
                } else if (gameData.getMenu().getSelected() == MenuScreen.CONTINUE_SELECTED) {
                    gameData.getMenu().setSelected(MenuScreen.OPTIONS_SELECTED);
                } else if (gameData.getMenu().getSelected() == MenuScreen.OPTIONS_SELECTED) {
                    gameData.getMenu().setSelected(MenuScreen.EXIT_SELECTED);
                } else if (gameData.getMenu().getSelected() == MenuScreen.EXIT_SELECTED) {
                    gameData.getMenu().setSelected(MenuScreen.START_GAME_SELECTED);
                }
            }
        } else if (gameData.getGameStates().peek() == GameState.PAUSE_STATE) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) { //Select item
                if (gameData.getPause().getSelect() == PauseScreen.ResumeSelected) {
                    gameData.getGame().getGameLoop().resume();
                    gameData.getGameStates().pop();
                    music.play();
                } else if (gameData.getPause().getSelect() == PauseScreen.OptionsSelected) {

                } else if (gameData.getPause().getSelect() == PauseScreen.ExitSelected) {
                    System.exit(0);
                }
            } else if (e.getKeyCode() == KeyEvent.VK_UP) { //up navigation
                if (gameData.getPause().getSelect() == PauseScreen.ResumeSelected) {
                    gameData.getPause().setSelect(PauseScreen.ExitSelected);
                } else if (gameData.getPause().getSelect() == PauseScreen.OptionsSelected) {
                    gameData.getPause().setSelect(PauseScreen.ResumeSelected);
                } else if (gameData.getPause().getSelect() == PauseScreen.ExitSelected) {
                    gameData.getPause().setSelect(PauseScreen.OptionsSelected);
                }
            } else if (e.getKeyCode() == KeyEvent.VK_DOWN) { //down navigation
                if (gameData.getPause().getSelect() == PauseScreen.ResumeSelected) {
                    gameData.getPause().setSelect(PauseScreen.OptionsSelected);
                } else if (gameData.getPause().getSelect() == PauseScreen.OptionsSelected) {
                    gameData.getPause().setSelect(PauseScreen.ExitSelected);
                } else if (gameData.getPause().getSelect() == PauseScreen.ExitSelected) {
                    gameData.getPause().setSelect(PauseScreen.ResumeSelected);
                }
            }
        } else if (gameData.getGameStates().peek() == GameState.INVENTORY_STATE) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                gameData.getPlayer().getInventory().useItem(gameData.getInventory().getItems()[gameData.getInventory().getSelected()]);
            }
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                gameData.getInventory().setSelected(gameData.getInventory().getSelected() - 1);
            }
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                gameData.getInventory().setSelected(gameData.getInventory().getSelected() + 1);
            }
            if (e.getKeyCode() == KeyEvent.VK_UP) {
                gameData.getInventory().setSelected(gameData.getInventory().getSelected() - 8);
            }
            if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                gameData.getInventory().setSelected(gameData.getInventory().getSelected() + 8);
            }
            if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                gameData.getGame().getGameLoop().resume();
                gameData.getGameStates().pop();
            }
        } else {
            if (e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_RIGHT) {
                if (gameData.getTextBoxQueue().isEmpty() || !gameData.getTextBoxQueue().peek().isPriority()) {
                    gameData.getPlayer().setRight(true);
                    gameData.getPlayer().setVelX(gameData.getPlayer().getPlayerSpeed());
                    gameData.getPlayer().setFacing("right");
                }
            }
            if (e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_LEFT) {
                if (gameData.getTextBoxQueue().isEmpty() || !gameData.getTextBoxQueue().peek().isPriority()) {
                    gameData.getPlayer().setLeft(true);
                    gameData.getPlayer().setVelX(-gameData.getPlayer().getPlayerSpeed());
                    gameData.getPlayer().setFacing("left");
                }
            }
            if (e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_UP) {
                if (gameData.getTextBoxQueue().isEmpty() || !gameData.getTextBoxQueue().peek().isPriority()) {
                    gameData.getPlayer().setUp(true);
                    gameData.getPlayer().setVelY(-gameData.getPlayer().getPlayerSpeed());
                    gameData.getPlayer().setFacing("up");
                }
            }
            if (e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_DOWN) {
                if (gameData.getTextBoxQueue().isEmpty() || !gameData.getTextBoxQueue().peek().isPriority()) {
                    gameData.getPlayer().setDown(true);
                    gameData.getPlayer().setVelY(gameData.getPlayer().getPlayerSpeed());
                    gameData.getPlayer().setFacing("down");
                }
            }
            if (e.getKeyCode() == KeyEvent.VK_F) {
                try {
                    if (!gameData.getTextBoxQueue().isEmpty()) {
                        gameData.getTextBoxQueue().poll();
                    }
                    Rectangle rect = gameData.getPlayer().lookAround(0);
                    ArrayList<GameObject> allObjects = gameData.getObjects();
                    for (GameObject go : allObjects) {
                        if (go.getId() == "door") {
                            if (rect.contains(go.getX() + 32, go.getY() + 32)) {
                                if (go.getSolid() == true) {
                                    Sprite s = SpriteCache.getSpriteCache().getSprite("res\\sprites/door-open-h.png");
                                    go.setSprite(s);
                                    go.setSolid(false);
                                } else if (go.getSolid() == false) {
                                    Sprite s = SpriteCache.getSpriteCache().getSprite("res\\sprites/door-close-h.png");
                                    go.setSprite(s);
                                    go.setSolid(true);
                                }
                            }
                        }
                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(KeyInput.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (e.getKeyCode() == KeyEvent.VK_SPACE && gameData.getPlayer().hasSaber()) {
                try {
                    Rectangle rect = gameData.getPlayer().lookAround(1);
                    ArrayList<GameObject> allObjects = gameData.getObjects();
                    for (GameObject go : allObjects) {
                        if (go instanceof Enemy) {
                            if (rect.contains(go.getX() + 32, go.getY() + 32)) {
                                Enemy badGuy = (Enemy) go;
                                System.out.println("Enemy Hit");
                                badGuy.hit();
                                System.out.println(badGuy.getHeath());
                            }
                        }
                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(KeyInput.class.getName()).log(Level.SEVERE, null, ex);
                }
                //  gameData.getPlayer().setSwing(false);
                System.out.println("Swing Sword");
            }
            if (e.getKeyCode() == KeyEvent.VK_M) {
                if (Music.volume != Music.Volume.Mute) {
//                    SoundEffects.volume = SoundEffects.Volume.Mute;
                    music.Mute();
                } else {
                    Music.volume = Music.Volume.Medium;
                    SoundEffects.volume = SoundEffects.Volume.High;
                    music.play();
                }
            }
            if (e.getKeyCode() == KeyEvent.VK_N) {
                music.next();
            }
            if (e.getKeyCode() == KeyEvent.VK_P) {
                gameData.getGameStates().push(GameState.PAUSE_STATE);
            }
            if (e.getKeyCode() == KeyEvent.VK_I) {
                gameData.getGameStates().push(GameState.INVENTORY_STATE);
            }
            if (e.getKeyCode() == KeyEvent.VK_K) {
                gameData.getPlayer().toggleClipping();
            }
            if (e.getKeyCode() == KeyEvent.VK_Z) {
                gameData.getHud().getSelector().setSelected(gameData.getHud().getSelector().getSelected() - 1);
            } else if (e.getKeyCode() == KeyEvent.VK_X) {
                gameData.getHud().getSelector().setSelected(gameData.getHud().getSelector().getSelected() + 1);
            }
            if (e.getKeyCode() == KeyEvent.VK_J) {
                gameData.getPlayer().powerSelected(gameData.getHud().getSelector().getSelected());
            }

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_RIGHT) {
            gameData.getPlayer().setRight(false);
            gameData.getPlayer().setVelX(0);
        }
        if (e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_LEFT) {
            gameData.getPlayer().setLeft(false);
            gameData.getPlayer().setVelX(0);
        }
        if (e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_UP) {
            gameData.getPlayer().setUp(false);
            gameData.getPlayer().setVelY(0);
        }
        if (e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_DOWN) {
            gameData.getPlayer().setDown(false);
            gameData.getPlayer().setVelY(0);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

}
