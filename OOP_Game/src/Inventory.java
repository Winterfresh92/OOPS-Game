/* Kevin Stubblefield
 * Last Updated: March 2, 2015
 * Known Bugs: None
 */

import java.util.HashMap;

public class Inventory {
    
    private HashMap<String, Item> items;
    
    public Inventory() {
        items = new HashMap<>();
    }
    
    public void add(Item item) {
        items.put(item.getName(), item);
    }
    
    public void remove(Item item) {
        items.remove(item.getName());
    }

    public HashMap<String, Item> getItems() {
        return items;
    }

    public void setItems(HashMap<String, Item> items) {
        this.items = items;
    }
    
}
