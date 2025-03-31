package Interactables;

import java.util.ArrayList;
import java.util.Scanner;

import Colors.Text;
import Items.*;
import World.Player;

/**
 * Class for a crate which can store items
 */
public class Crate extends Interactable {

    private ArrayList<Item> items;
    private Player player;
    private Scanner sc;

    public Crate(String items, Player player) {
        this.player = player;
        sc = new Scanner(System.in);

        String[] itemsArray = items.split("\\.");
        name = itemsArray[0];
        this.items = new ArrayList<>();
        for (int i = 1; i < itemsArray.length; i++) {
            this.items.add(Item.factory(itemsArray[i], player));
        }
    }

    /**
     * Shows the player the content of the crate and lets him take an item from it
     * @return - message about the picking of an item from the crate
     */
    @Override
    public String interact() {
        if(items.isEmpty()) {
            return Text.color("Crate empty", 'r');
        }

        System.out.println(name + " contains:" + "\n" + this);
        System.out.print("Item to pick: ");

        String item = sc.nextLine();

        String ret;
        try {
            if(!player.inventoryFree()){
                return Text.color("Inventory full", 'o');
            }
            ret = player.addItem(items.get(Integer.parseInt(item) - 1));
        } catch (NumberFormatException e) {
            return Text.color("Enter only the number of the item", 'r');
        }
        items.remove(Integer.parseInt(item) - 1);
        return ret;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < items.size(); i++) {
            sb.append("    " + (i + 1) + ". " + Text.color(items.get(i).getName(), items.get(i).getColor()) + "\n");
        }
        return sb.toString();
    }
}
