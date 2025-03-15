package World;

import Items.*;

import java.util.ArrayList;

public class Player {

    private int health;
    private ArrayList<Item> items;
    private final int INVENTORY_CAP;

    public Player() {
        health = 100;
        items = new ArrayList<>();
        INVENTORY_CAP = 7;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health += health;
        if (this.health > 100) {
            this.health = 100;
        }
    }

    public String addItem(Item item){

        if(item == null){
            return "No such item";
        }

        if(items.size() < INVENTORY_CAP){
            items.add(item);
            return item.getName() + " added to inventory";
        }
        return "Inventory full";
    }

    public String itemsString() {
        StringBuilder sb = new StringBuilder();

        for(Item item : items){
            sb.append("    " + item.getName() + "\n");
        }
        return sb.toString();
    }

    public String useItem(String item){
        for(Item item1 : items){
            if(item1.getName().equals(item)){
                items.remove(item1);
                return item1.use();
            }
        }
        return "No such item in your inventory";
    }
}
