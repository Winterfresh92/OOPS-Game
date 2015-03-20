package Object;

/* Kevin Stubblefield
 * Last Updated: March 19, 2015
 * Known Bugs: None
 * Updated add and remove functions to check for existing items and increment/decrement
 * Updated remove function and use item function
 */

import java.util.HashMap;

public class Inventory {
    
    private HashMap<String, Item> items;
    private Player player;
    
    public Inventory(Player player) {
        items = new HashMap<>();
        this.player = player;
    }
    
    public void add(Item item) {
        if(items.containsKey(item.getName())) {
            items.get(item.getName()).increment();
        } else {
            items.put(item.getName(), item);
            items.get(item.getName()).increment();
        }
    }
    
    public void remove(Item item) {
        if(item != null) {
            if(items.containsKey(item.getName())) {
                items.get(item.getName()).decrement();
                if(item.getQuantity() == 0) {
                    items.remove(item.getName());
                }
            }
        }
    }
    
    public void useItem(Item item) {
        remove(item);
        item.use(player);
    }

    public HashMap<String, Item> getItems() {
        return items;
    }

    public void setItems(HashMap<String, Item> items) {
        this.items = items;
    }
    
}
