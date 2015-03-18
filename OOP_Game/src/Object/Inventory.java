package Object;

/* Kevin Stubblefield
 * Last Updated: March 17, 2015
 * Known Bugs: None
 * Updated add and remove functions to check for existing items and increment/decrement
 */

import java.util.HashMap;

public class Inventory {
    
    private HashMap<String, Item> items;
    
    public Inventory() {
        items = new HashMap<>();
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
        if(items.containsKey(item.getName())) {
            items.get(item.getName()).decrement();
        } else {
            items.remove(item.getName());
            items.get(item.getName()).decrement();
        }
    }
    
    public void useItem(Player player, Item item) {
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
