package Object;

/* Kevin Stubblefield
 * Last Updated: March 19, 2015
 * Known Bugs: When changing directions, the last frame from the previous animation
 *             renders briefly. If two directional buttons are pressed at the
 *             same time, both animations play (will likely require adjusting
 *             animation class to account for direction rather than player class.
 * Implemented knockback a la A Link to the Past for visual feedback upon hit (besides heart decrease) 
 * Made Player class work with new Enemy implementation
 *
 /* Zain Chishti
 * Last Updated: March 19, 2015
 * Known Bugs: None
 * Added clipping boolean, press K to toggle!
 * Implemented Animation
 *
 * Carlos Pena
 * Added 2 classes, PowerSelected() to determine which power to use
 * Force() to use the choosen power
 * 
 *
 */
import Engine.Game;
import Sprite.Sprite;
import Sprite.SpriteCache;
import Engine.GameData;
import Music.SoundEffects;
import Sprite.Animation;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Player extends GameObject {

    private float power = 64;
    private int dir = 0; // direction up: 0, down: 1, right: 2, left: 3
    private boolean left, right, up, down;
    private int playerSpeed = 5;
    private int health;
    private boolean clipping;
    private boolean push, pull;
    private boolean knockBack;
    private int mission;
    private boolean swing;
    private Sprite h;
    private Animation walkingUp;
    private Animation walkingDown;
    private Animation walkingRight;
    private Animation walkingLeft;
    private Animation fightingRight;
    private Animation fightingLeft;
    private Animation fightingDown;
    private Animation fightingUp;
    private float lastX;
    private float lastY;
    private boolean hasSaber;
    private boolean isColliding;
    private boolean lastCollison;
    private boolean playerHit;
    private String direction;
    private String facing;
    private int forcePowers;
    private GameData gameData;
    private Inventory inventory;

    public Player(String ref, float x, float y) {
        super(ref, x, y);
        this.width = 64;
        this.height = 64;
        lastX = x;
        lastY = y;
        mission = 0;
        isColliding = false;
        lastCollison = false;
        knockBack = false;
        playerHit = false;
        clipping = true;
        swing = false;
        health = 10;
        velX = velY = 0;
        inventory = new Inventory(this);
        this.h = SpriteCache.getSpriteCache().getSprite("res\\sprites\\hud/player_health_0.png");
        walkingUp = new Animation(150);
        walkingDown = new Animation(150);
        walkingRight = new Animation(300);
        walkingLeft = new Animation(300);
        fightingRight = new Animation(300);
        fightingLeft = new Animation(300);
        fightingDown = new Animation(150);
        fightingUp = new Animation(150);
        walkingUp.add(SpriteCache.getSpriteCache().getSprite("res\\sprites\\player\\back/player_back_0.png"));
        walkingUp.add(SpriteCache.getSpriteCache().getSprite("res\\sprites\\player\\back/player_back_1.png"));
        walkingUp.add(SpriteCache.getSpriteCache().getSprite("res\\sprites\\player\\back/player_back_2.png"));
        walkingUp.add(SpriteCache.getSpriteCache().getSprite("res\\sprites\\player\\back/player_back_3.png"));
        walkingDown.add(SpriteCache.getSpriteCache().getSprite("res\\sprites\\player\\front/player_front_0.png"));
        walkingDown.add(SpriteCache.getSpriteCache().getSprite("res\\sprites\\player\\front/player_front_1.png"));
        walkingDown.add(SpriteCache.getSpriteCache().getSprite("res\\sprites\\player\\front/player_front_2.png"));
        walkingDown.add(SpriteCache.getSpriteCache().getSprite("res\\sprites\\player\\front/player_front_3.png"));
        walkingRight.add(SpriteCache.getSpriteCache().getSprite("res\\sprites\\player\\right/player_right_0.png"));
        walkingRight.add(SpriteCache.getSpriteCache().getSprite("res\\sprites\\player\\right/player_right_1.png"));
        walkingLeft.add(SpriteCache.getSpriteCache().getSprite("res\\sprites\\player\\left/player_left_0.png"));
        walkingLeft.add(SpriteCache.getSpriteCache().getSprite("res\\sprites\\player\\left/player_left_1.png"));
        fightingRight.add(SpriteCache.getSpriteCache().getSprite("res\\sprites\\player\\right/player_fighting_right_0.png"));
        fightingRight.add(SpriteCache.getSpriteCache().getSprite("res\\sprites\\player\\right/player_fighting_right_1.png"));
        fightingLeft.add(SpriteCache.getSpriteCache().getSprite("res\\sprites\\player\\left/player_fighting_left_0.png"));
        fightingLeft.add(SpriteCache.getSpriteCache().getSprite("res\\sprites\\player\\left/player_fighting_left_1.png"));
        fightingDown.add(SpriteCache.getSpriteCache().getSprite("res\\sprites\\player\\front/player_fighting_down_0.png"));
        fightingDown.add(SpriteCache.getSpriteCache().getSprite("res\\sprites\\player\\front/player_fighting_down_1.png"));
        fightingDown.add(SpriteCache.getSpriteCache().getSprite("res\\sprites\\player\\front/player_fighting_down_2.png"));
        fightingDown.add(SpriteCache.getSpriteCache().getSprite("res\\sprites\\player\\front/player_fighting_down_3.png"));
        fightingUp.add(SpriteCache.getSpriteCache().getSprite("res\\sprites\\player\\back/player_fighting_up_0.png"));
        fightingUp.add(SpriteCache.getSpriteCache().getSprite("res\\sprites\\player\\back/player_fighting_up_1.png"));
        fightingUp.add(SpriteCache.getSpriteCache().getSprite("res\\sprites\\player\\back/player_fighting_up_2.png"));
        fightingUp.add(SpriteCache.getSpriteCache().getSprite("res\\sprites\\player\\back/player_fighting_up_3.png"));
        inventory.add(new Heart(0, 0, true));
        inventory.add(new Heart(0, 0, true));
        inventory.add(new Heart(0, 0, true));
        inventory.add(new HalfHeart(0, 0, true));
        inventory.add(new HalfHeart(0, 0, true));
        direction = "";
        facing = "";
        hasSaber = false;
        this.h = SpriteCache.getSpriteCache().getSprite("res\\sprites\\hud/player_health_0.png");
        forcePowers = 0;
    }

    @Override
    public void update() {

        lastX = x;
        lastY = y;

        x += velX;
        y += velY;

        if (!up && !down && !right && !left) {
            checkDirection();
        }
        if (up) {
            dir = 0;
            walkingUp.update();
            direction = "up";
        }
        if (down) {
            dir = 1;
            walkingDown.update();
            direction = "down";
        }
        if (right) {
            dir = 2;
            walkingRight.update();
            direction = "right";
        }
        if (left) {
            dir = 3;
            walkingLeft.update();
            direction = "left";
        }

        if (swing && (direction == "right")) {
            fightingRight.update();
        }
        if (swing && (direction == "left")) {
            fightingLeft.update();
        }
        if (swing && (direction == "down")) {
            fightingDown.update();
        }
        if (swing && (direction == "up")) {
            fightingUp.update();
        }

        if (gameData.isLoaded() && clipping) {
            checkCollisions();
            //     System.out.println(isColliding + "  " + lastCollison);
            if (lastCollison == false && isColliding == true) {
                playerHit = true;
            }
            lastCollison = isColliding;
        }

        //System.out.println("PLAYER HEALTH: " + health);
    }

    public static int counter = 1;

    public void hit(GameObject g) {
        // This is implemented only for demo purposes. It will be implemented fully later when the enemy will be implemented

        if (g instanceof Enemy && g.isSolid()) {
            Enemy badGuy = (Enemy) g;
            health -= badGuy.getDamage();
            if (health < 0) {
                health = 0;
            }
            h = SpriteCache.getSpriteCache().getSprite("res\\sprites\\hud/player_health_" + (10 - health) + ".png");
        }

        if (g instanceof InteractableObject) {
            InteractableObject interact = (InteractableObject) g;
            if (interact.interact()) {
                gameData.getNextQueue();
                interact.interacted();
                if (g instanceof InteractableSlip) {
                    InteractableSlip slip = (InteractableSlip) g;
                    if ("You already have your lightsaber.".equals(slip.getDefaultText())) {
                        hasSaber = true;
                        g.setSprite(SpriteCache.getSpriteCache().getSprite("res\\sprites/stand_0.png"));
                    } else {
                        forcePowers += 1;
                        gameData.removeObject(interact);
                    }
                }
            } else {
                gameData.addToQueue(new TextBox("res\\sprites/text_box_0.png", Game.WIDTH / 10, (Game.HEIGHT - Game.HEIGHT / 3) - 40, interact.getDefaultText(), true));
            }

            /*   if (playerHit == true)
             {
             this.health -= 2;
             System.out.println("health : " + this.health);
             } */
        }
    }

    @Override
    public void render(Graphics g) {
        if (!up && !down && !right && !left) {
            if (sprite != null) {
                sprite.render(g, x, y);
            } else {
                g.fillRect((int) this.x - 230, (int) this.y - 200, (health * 100) / 10, 10);
            }
        }

        if (up) {
            walkingUp.render(g, x, y);
        }
        if (down) {
            walkingDown.render(g, x, y);
        }
        if (right) {
            walkingRight.render(g, x, y);
        }
        if (left) {
            walkingLeft.render(g, x, y);
        }

        if (swing && (direction == "right")) {
            fightingRight.render(g, x, y);
        }
        if (swing && (direction == "left")) {
            fightingLeft.render(g, x, y);
        }
        if (swing && (direction == "down")) {
            fightingDown.render(g, x, y);
        }
        if (swing && (direction == "up")) {
            fightingUp.render(g, x, y);
        }

        g.setColor(Color.green);
        // 
        h.render(g, (int) this.x - 300, (int) this.y - 220);
    }

    public void toggleClipping() {
        clipping = !clipping;
    }

    public Rectangle lookAround(int x) throws InterruptedException {
        Rectangle rect;
        if (direction == "up") {
            if (x == 0) {
                rect = new Rectangle((int) this.getX(), (int) this.getY() - 64, 64, 64);
                return rect;
            } else if (x == 1) {
                rect = new Rectangle((int) this.getX(), (int) this.getY() - 64, 64, 64);
                swing = true;

                TimeUnit.MILLISECONDS.sleep(500);

                swing = false;

                return rect;
            } else {
                return new Rectangle(0, 0, 0, 0);
            }

        } else if (direction == "right") {
            if (x == 0) {
                rect = new Rectangle((int) this.getX() + (int) this.getWidth(), (int) this.getY(), 64, 64);
                return rect;
            } else if (x == 1) {
                rect = new Rectangle((int) this.getX() + (int) this.getWidth(), (int) this.getY(), 64, 64);
                swing = true;

                TimeUnit.MILLISECONDS.sleep(150);

                swing = false;

                return rect;
            } else {
                return new Rectangle(0, 0, 0, 0);
            }
        } else if (direction == "down") {
            if (x == 0) {
                rect = new Rectangle((int) this.getX(), (int) this.getY() + (int) this.getHeight(), 64, 64);
                return rect;
            } else if (x == 1) {
                rect = new Rectangle((int) this.getX(), (int) this.getY() + (int) this.getHeight(), 64, 64);
                swing = true;

                TimeUnit.MILLISECONDS.sleep(500);

                swing = false;

                return rect;
            } else {
                return new Rectangle(0, 0, 0, 0);
            }

        } else if (direction == "left") {
            if (x == 0) {
                rect = new Rectangle((int) this.getX() - 64, (int) this.getY(), 64, 64);
                return rect;
            } else if (x == 1) {
                rect = new Rectangle((int) this.getX() - 64, (int) this.getY(), 64, 64);
                swing = true;

                TimeUnit.MILLISECONDS.sleep(150);

                swing = false;

                return rect;
            } else {
                return new Rectangle(0, 0, 0, 0);
            }

        } else // else returns the default rect for "up" direction 
        {
            rect = new Rectangle((int) this.getX(), (int) this.getY() - 64, 64, 64);
            return rect;
        }
    }

    public Rectangle lookAround() {
        Rectangle rect;
        if (direction == "up") {
            rect = new Rectangle((int) this.getX(), (int) this.getY() - 64, 64, 64);
            return rect;
        } else if (direction == "right") {
            rect = new Rectangle((int) this.getX() + (int) this.getWidth(), (int) this.getY(), 64, 64);
            return rect;
        } else if (direction == "down") {
            rect = new Rectangle((int) this.getX(), (int) this.getY() + (int) this.getHeight(), 64, 64);
            return rect;
        } else if (direction == "left") {
            rect = new Rectangle((int) this.getX() - 64, (int) this.getY(), 64, 64);
            return rect;
        } else // else returns the default rect for "up" direction 
        {
            rect = new Rectangle((int) this.getX(), (int) this.getY() - 64, 64, 64);
            return rect;
        }
    }

    public void checkCollisions() {
        int counter = 0;
        for (GameObject object : gameData.getObjects()) {
            if (object instanceof Item) {
                if (this.getCollision(object)) {
                    Item item = (Item) object;
                    inventory.add(item);
                    item.setCollected(true);
                }
            }

            if (object instanceof CollidableObject) {
                CollidableObject temp = (CollidableObject) object;
                if (temp.isSolid()) {
                    if (getBoundsTop().intersects(temp.getBounds())) {
                        isColliding = true;
                        y = temp.getY() + temp.getHeight();
                        this.hit(temp);
                    } else if (getBoundsBottom().intersects(temp.getBounds())) {
                        isColliding = true;
                        y = temp.getY() - height;
                        this.hit(temp);
                    } else if (getBoundsRight().intersects(temp.getBounds())) {
                        isColliding = true;
                        x = temp.getX() - width;
                        this.hit(temp);
                    } else if (getBoundsLeft().intersects(temp.getBounds())) {
                        isColliding = true;
                        x = temp.getX() + temp.getWidth();
                        this.hit(temp);
                    } else {
                        isColliding = false;

                    }
                }
            }

            if (object instanceof Enemy) {
                Enemy enemy = (Enemy) object;
                if (enemy.getAggressor()) {
                    if (!knockBack) {
                        if (getBoundsTop().intersects(enemy.getBounds())) {
                            velY = playerSpeed * 2;
                            this.hit(enemy);
                            knockBack = true;
                            while (knockBack && y < enemy.getY() + enemy.getHeight() + 32) {
                                y += velY;
                            }
                            knockBack = false;
                        } else if (getBoundsBottom().intersects(enemy.getBounds())) {
                            velY = -playerSpeed * 2;
                            this.hit(enemy);
                            knockBack = true;
                            while (knockBack && y + height >= enemy.getY() - 32) {
                                y += velY;
                            }
                            knockBack = false;
                        } else if (getBoundsRight().intersects(enemy.getBounds())) {
                            velX = -playerSpeed * 2;
                            this.hit(enemy);
                            knockBack = true;
                            while (knockBack && x + width >= enemy.getX() - 32) {
                                x += velX;
                            }
                            knockBack = false;
                        } else if (getBoundsLeft().intersects(enemy.getBounds())) {
                            velX = playerSpeed * 2;
                            this.hit(enemy);
                            knockBack = true;
                            while (knockBack && x < enemy.getX() + enemy.getWidth() + 32) {
                                x += velX;
                            }
                            knockBack = false;
                        }
                    }
                }else{
                    Enemy temp = (Enemy) object;
                if (temp.isSolid()) {
                    if (getBoundsTop().intersects(temp.getBounds())) {
                        isColliding = true;
                        y = temp.getY() + temp.getHeight();
                        this.hit(temp);
                    } else if (getBoundsBottom().intersects(temp.getBounds())) {
                        isColliding = true;
                        y = temp.getY() - height;
                        this.hit(temp);
                    } else if (getBoundsRight().intersects(temp.getBounds())) {
                        isColliding = true;
                        x = temp.getX() - width;
                        this.hit(temp);
                    } else if (getBoundsLeft().intersects(temp.getBounds())) {
                        isColliding = true;
                        x = temp.getX() + temp.getWidth();
                        this.hit(temp);
                    } else {
                        isColliding = false;

                    }
                }
                }
            }

        }

    }

    public void powerSelected(int selected) {
        switch (selected) {
            case 0:
                push = true;
                pull = false;
                Force();
                break;
            case 1:
                push = false;
                pull = true;
                Force();
                break;
        }
    }

    public void Force() {
        boolean move = true;
        if (push) {
            if (forcePowers < 2) {
                return;
            }
            System.out.println("Force Push activated");
            for (GameObject object : gameData.getObjects()) {
                if (object instanceof CollidableObject) {
                    CollidableObject temp = (CollidableObject) object;
                    if (temp.isSolid() && temp.isMobile()) {
                        if (y + 64 == temp.getY() && facing.equals("down")) {   //down
                            if (temp.getX() <= x + 63 && temp.getX() >= x - 63) {
                                for (GameObject object2 : gameData.getObjects()) {
                                    if (object2 instanceof CollidableObject) {
                                        CollidableObject next = (CollidableObject) object2;
                                        if (next.isSolid()) {
                                            if (temp.y + 64 == next.getY()) {
                                                if (next.getX() <= temp.x + 10 && next.getX() >= temp.x - 10) {
                                                    move = false;
                                                    break;
                                                }
                                            } else {
                                                move = true;
                                            }
                                        }
                                    }
                                }
                                if (move) {
                                    SoundEffects.ForcePush.play();
                                    temp.y += power;
                                }
                            }
                        } else if (y - 64 == temp.getY() && facing.equals("up")) { //up
                            if (temp.getX() <= x + 63 && temp.getX() >= x - 63) {
                                for (GameObject object2 : gameData.getObjects()) {
                                    if (object2 instanceof CollidableObject) {
                                        CollidableObject next = (CollidableObject) object2;
                                        if (next.isSolid()) {
                                            if (temp.y - 64 == next.getY()) {
                                                if (next.getX() <= temp.x + 10 && next.getX() >= temp.x - 10) {
                                                    move = false;
                                                    break;
                                                }
                                            } else {
                                                move = true;
                                            }
                                        }
                                    }
                                }
                                if (move) {
                                    SoundEffects.ForcePush.play();
                                    temp.y -= power;
                                }
                            }
                        } else if (x + 64 == temp.getX() && facing.equals("right")) {   //right
                            if (temp.getY() <= y + 63 && temp.getY() >= y - 63) {
                                for (GameObject object3 : gameData.getObjects()) {
                                    if (object3 instanceof CollidableObject) {
                                        CollidableObject next = (CollidableObject) object3;
                                        if (next.isSolid() && !next.isMobile()) {
                                            if (next.getX() <= temp.x + 70 && next.getX() >= temp.x - 70) {
                                                if (next.getY() <= temp.y + 10 && next.getY() >= temp.y - 10) {
                                                    move = false;
                                                    break;
                                                }
                                            } else {
                                                move = true;
                                            }
                                        }
                                    }
                                }
                                if (move) {
                                    SoundEffects.ForcePush.play();
                                    temp.x += power;
                                }
                            }
                        } else if (x - 64 == temp.getX() && facing.equals("left")) {    //left
                            if (temp.getY() <= y + 63 && temp.getY() >= y - 63) {
                                for (GameObject object4 : gameData.getObjects()) {
                                    if (object4 instanceof CollidableObject) {
                                        CollidableObject next = (CollidableObject) object4;
                                        if (next.isSolid() && !next.isMobile()) {
                                            if (next.getX() <= temp.x + 70 && next.getX() >= temp.x - 70) {
                                                if (next.getY() <= temp.y + 10 && next.getY() >= temp.y - 10) {
                                                    move = false;
                                                    break;
                                                }
                                            } else {
                                                move = true;
                                            }
                                        }
                                    }
                                }
                                if (move) {
                                    SoundEffects.ForcePush.play();
                                    temp.x -= power;
                                }
                            }
                        }
                    }
                }
            }
        } else if (pull) {
            if (forcePowers < 1) {
                return;
            }
            System.out.println("Force Pull activated");
            for (GameObject object : gameData.getObjects()) {
                if (object instanceof CollidableObject) {
                    CollidableObject temp = (CollidableObject) object;
                    if (temp.isSolid() && temp.isMobile()) {
                        if (y + 128 >= temp.getY() && temp.getY() >= y - 128 && facing.equals("down")) { //down
                            if (temp.getX() <= x + 10 && temp.getX() >= x - 10) {
                                SoundEffects.ForcePull.play();
                                temp.y -= power;
                            }
                        } else if (y - 128 <= temp.getY() && y + 128 >= temp.getY() && facing.equals("up")) { //up
                            if (temp.getX() <= x + 63 && temp.getX() >= x - 63) {
                                SoundEffects.ForcePull.play();
                                temp.y += power;
                            }
                        } else if (x + 128 >= temp.getX() && temp.getX() >= x - 128 && facing.equals("right")) { //right
                            if (temp.getY() <= y + 63 && temp.getY() >= y - 63) {
                                SoundEffects.ForcePull.play();
                                temp.x -= power;
                            }
                        } else if (x - 128 <= temp.getX() && x + 128 >= temp.getX() && facing.equals("left")) { //left
                            if (temp.getY() <= y + 63 && temp.getY() >= y - 63) {
                                SoundEffects.ForcePull.play();
                                temp.x += power;
                            }
                        }
                    }
                }
            }
        }
    }

    private void checkDirection() {
        switch (dir) {
            case 0: // up
                sprite = SpriteCache.getSpriteCache().getSprite(
                        "res\\sprites\\player\\back/player_back_0.png"
                );
                break;
            case 1: // down
                sprite = SpriteCache.getSpriteCache().getSprite(
                        "res\\sprites\\player\\front/player_front_0.png"
                );
                break;
            case 2: // right
                sprite = SpriteCache.getSpriteCache().getSprite(
                        "res\\sprites\\player\\right/player_right_0.png"
                );
                break;
            case 3:
                sprite = SpriteCache.getSpriteCache().getSprite(
                        "res\\sprites\\player\\left/player_left_0.png"
                );
                break;
        }
    }

    public boolean isLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public boolean isUp() {
        return up;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public boolean isDown() {
        return down;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

    public boolean hasSaber() {
        return this.hasSaber;
    }

    public int getPlayerSpeed() {
        return playerSpeed;
    }

    public void setPlayerSpeed(int playerSpeed) {
        this.playerSpeed = playerSpeed;
    }

    public GameData getGameData() {
        return gameData;
    }

    public void setGameData(GameData gameData) {
        this.gameData = gameData;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public boolean isClipping() {
        return clipping;
    }

    public void setClipping(boolean clipping) {
        this.clipping = clipping;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public float getLastX() {
        return lastX;
    }

    public float getLastY() {
        return lastY;
    }

    public void setLastX(float lastX) {
        this.lastX = lastX;
    }

    public void setLastY(float lastY) {
        this.lastY = lastY;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getFacing() {
        return facing;
    }

    public void setFacing(String facing) {
        this.facing = facing;
    }

    public int getMission() {
        return mission;
    }

    public void setMission(int mission) {
        this.mission = mission;
    }

    public boolean getSwing() {
        return swing;
    }

    public void setSwing(boolean swing) {
        this.swing = swing;
    }

}
