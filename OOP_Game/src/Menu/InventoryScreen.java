/* Kevin Stubblefield
 * Last Updated: March 17, 2015
 * Known Bugs: None
 * Created class and implemented working inventory screen
 */

package Menu;

import Object.Item;
import Object.Player;
import Sprite.Sprite;
import Sprite.SpriteCache;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Map;

public class InventoryScreen {
    
    private Sprite background;
    private Player player;
    private Item[] items;
    private int columns = 8;
    private int rows = 3;
    private int count = 0;
    private int selected = 0;
    private int position;
    
    public InventoryScreen(Player player) {
        this.player = player;
        background = SpriteCache.getSpriteCache().getSprite("res\\sprites\\background/inventorybackground.png");
        items = new Item[columns * rows];
        for(Map.Entry<String, Item> item : player.getInventory().getItems().entrySet()) {
            items[count] = item.getValue();
            count++;
        }
    }
    
    public void update() {
        if(selected < 0) {
            selected = 23;
        }
        if(selected > 23) {
            selected = 0;
        }
    }
    
    public void render(Graphics g) {
        background.render(g, 0, 0);
        g.setFont(new Font("Sans Serif", Font.PLAIN, 14));
        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < columns; col++) {
                position = row * columns + col;
                if(selected == position) {
                    g.setColor(Color.green);
                } else {
                    g.setColor(Color.gray);
                }
                g.fillRect(col * 32 + 8 + (8 * col),
                            row * 32 + (row * 8) + 6, 32, 32);
                if(items[position] != null) {
                    items[position].getSprite().render(
                            g, (position) * 32 + 8 + (8 * col), row * 32 + (row * 8) + 8);
                    g.setColor(Color.white);
                    g.drawString(Integer.toString(items[position].getQuantity()),
                            (position) * 32 + 32 + (8 * col), row * 32 + (row * 8) + 40);
                }
            }
        }
        
        if(selected >= 0 && selected < items.length) {
            if(items[selected] != null) {
                g.setColor(Color.white);
                g.setFont(new Font("Sans Serif", Font.PLAIN, 32));
                g.drawString(items[selected].getName(), 13, 4 * 40 + 10);
            }
        }
    }

    public int getSelected() {
        return selected;
    }

    public void setSelected(int selected) {
        this.selected = selected;
    }

    public Item[] getItems() {
        return items;
    }

    public void setItems(Item[] items) {
        this.items = items;
    }
    
}
