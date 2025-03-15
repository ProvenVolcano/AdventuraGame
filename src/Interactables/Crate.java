package Interactables;

import java.util.ArrayList;
import Items.*;
import World.Player;

public class Crate extends Interactable {

    private ArrayList<Item> items;
    private Player player;

    public Crate(String items, Player player) {
        this.player = player;
        name = "Crate";

        String[] itemsArray = items.split("\\.");
        this.items = new ArrayList<>();
        for (String item : itemsArray) {
            this.items.add(Item.factory(item, player));
        }
    }

    @Override
    public String interact() {
        return items.toString();
    }
}
