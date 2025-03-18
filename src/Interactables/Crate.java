package Interactables;

import java.util.ArrayList;
import java.util.Scanner;

import Items.*;
import World.Player;

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

    @Override
    public String interact() {
        if(items.isEmpty()) {
            return "Crate empty";
        }

        System.out.println(name + " contains:" + "\n" + this);
        System.out.print("Item to pick: ");

        String item = sc.nextLine();

        String ret;
        try {
            if(!player.inventoryFree()){
                return "Inventory full";
            }
            ret = player.addItem(items.get(Integer.parseInt(item) - 1));
        } catch (NumberFormatException e) {
            return "Enter only the number of the item";
        }
        items.remove(Integer.parseInt(item) - 1);
        return ret;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < items.size(); i++) {
            sb.append("    " + (i + 1) + ". " + items.get(i).getName() + "\n");
        }
        return sb.toString();
    }
}
