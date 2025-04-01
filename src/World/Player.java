package World;

import Colors.Text;
import Items.*;

import java.util.ArrayList;

/**
 * Class of the player, contains the inventory and values about the player's progress in the game
 */
public class Player {

    private int health;
    private ArrayList<Item> items;
    private LaserGun gun;
    private boolean hasEngineerItems;
    private boolean fixedCore;
    private boolean fighting;
    private boolean alive;
    private boolean savedCaptain;
    private final int INVENTORY_CAP;

    public Player() {
        health = 100;
        hasEngineerItems = false;
        fixedCore = false;
        fighting = false;
        savedCaptain = false;
        alive = true;
        items = new ArrayList<>();
        INVENTORY_CAP = 8;
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

    /**
     * Adds an item to the player's inventory
     * @param item - the item to add
     * @return - message if item was added or not
     */
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
        return Text.color("Cannot take " + item.getName() + " - inventory is full", 'y');
    }

    /**
     * Returns string of items in the player's inventory and it's capacity
     * @return - the string
     */
    public String itemsString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Inventory (" + items.size() + "/" + INVENTORY_CAP + "):\n");

        for(Item item : items){
            sb.append("    " + Text.color(item.getName(), item.getColor()) + "\n");
        }
        return sb.toString();
    }

    /**
     * Uses an item in the inventory
     * @param item - the item to use
     * @return - message about the use of the item
     */
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

    /**
     * Checks if the player has an item of a given name
     * @param item - name of the item
     * @return - true if player has the item, otherwise false
     */
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

    /**
     * Checks if there is space in the inventory
     * @return - true of there is space for at least one item, otherwise false
     */
    public boolean inventoryFree(){
        return items.size() < INVENTORY_CAP;
    }

    /**
     * Removes an item of a given name from the players inventory
     * @param item - name of the item to return
     * @return - true if there was such item, otherwise false
     */
    public boolean remove(String item) {
        for(int i = 0; i < items.size(); i++) {
            if (items.get(i).getName().equals(item)) {
                return items.remove(items.get(i));
            }
        }
        return false;
    }

    /**
     * Lowers the player's health
     * @param dmg - the amount of damage to take
     * @return - message about the player's state, his remaining health or a death message
     */
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

    public boolean isFixedCore() {
        return fixedCore;
    }

    public void setFixedCore(boolean fixedCore) {
        this.fixedCore = fixedCore;
    }

    public boolean isHasEngineerItems() {
        return hasEngineerItems;
    }

    public void setHasEngineerItems(boolean hasEngineerItems) {
        this.hasEngineerItems = hasEngineerItems;
    }

    public boolean isSavedCaptain() {
        return savedCaptain;
    }

    public void setSavedCaptain(boolean savedCaptain) {
        this.savedCaptain = savedCaptain;
    }
}
