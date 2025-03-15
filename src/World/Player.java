package World;

import Items.*;

import java.util.HashMap;

public class Player {

    private int health;
    private HashMap<String, Item> items;
    private final int INVENTORY_CAP;

    public Player() {
        health = 100;
        items = new HashMap<>();
        INVENTORY_CAP = 7;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String addItem(Item item){

        if(item == null){
            return "No such item";
        }

        if(items.size() < INVENTORY_CAP){
            items.put(item.getName(), item);
            return item.getName() + " added to inventory";
        }
        return "Inventory full";
    }

    public HashMap<String, Item> getItems() {
        return items;
    }
}
