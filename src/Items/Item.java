package Items;

import World.*;

/**
 * Class for items, all items that the player can pick up inherit this class
 */
public abstract class Item {

    protected String name;
    protected boolean oneTimeUse;
    protected char color;

    /**
     * Handles the function of an item, is called when a player uses an item
     * @return - a message about the use of the item
     */
    public abstract String use();

    public String getName() {
        return name;
    }

    public char getColor() {
        return color;
    }

    public boolean isOneTimeUse() {
        return oneTimeUse;
    }

    /**
     * Factory method for creating individual items
     * @param name - name of the item
     * @param player - the player
     * @return - the appropriate item
     */
    public static Item factory(String name, Player player){

        return switch (name) {
            case "Laser Gun" -> new LaserGun();
            case "Battery" -> new Battery(player);
            case "Bandages" -> new Bandages(player);
            default -> new Component(name);
        };
    }
}
