package World;

import Colors.Text;
import Items.*;

import java.util.ArrayList;

public class Player {

    private int health;
    private ArrayList<Item> items;
    private LaserGun gun;
    private boolean fighting;
    private boolean alive;
    private final int INVENTORY_CAP;

    public Player() {
        health = 100;
        fighting = false;
        alive = true;
        items = new ArrayList<>();
        INVENTORY_CAP = 15;
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
            return Text.color("No such item", 'r');
        }

        if(item.getName().equals("Laser Gun")){
            gun = new LaserGun();
            return Text.color("You now have a Laser Gun!", 'g');
        }

        if(items.size() < INVENTORY_CAP){
            items.add(item);
            return Text.color(item.getName() + " added to inventory", 'g');
        }
        return Text.color("Cannot take \" + item.getName() + \" - inventory is full", 'y');
    }

    public String itemsString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Inventory (" + items.size() + "/" + INVENTORY_CAP + "):\n");

        for(Item item : items){
            sb.append("    " + Text.color(item.getName(), item.getColor()) + "\n");
        }
        return sb.toString();
    }

    public String useItem(String item){
        for(Item item1 : items){
            if(item1.getName().equals(item)) {

                String useMessage = item1.use();
                if(item1.isOneTimeUse()){
                    items.remove(item1);
                }
                return useMessage;
            }
        }
        return Text.color("No such item in your inventory", 'r');
    }

    public boolean containsItem(String item){
        for(Item item1 : items) {
            if (item1.getName().equalsIgnoreCase(item)) {
                return true;
            }
        } return false;
    }

    public LaserGun getGun() {
        return gun;
    }

    public boolean inventoryFree(){
        return items.size() < INVENTORY_CAP;
    }

    public boolean remove(String item) {
        for(int i = 0; i < items.size(); i++) {
            if (items.get(i).getName().equals(item)) {
                return items.remove(items.get(i));
            }
        }
        return false;
    }

    public String damage(int dmg) {
        health -= dmg;
        alive = health > 0;
        String ret = Text.color("The alien shot you!\n", 'p');
        if(alive){
            return ret + Text.color("Your health is now " + health + "/100!", 'o');
        } else return ret + Text.color("\nYou died...", 'd');
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public boolean isFighting() {
        return fighting;
    }

    public void setFighting(boolean fighting) {
        this.fighting = fighting;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }
}
