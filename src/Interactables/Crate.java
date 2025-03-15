package Interactables;

import java.util.HashMap;
import Items.*;
import World.Player;

public class Crate extends Interactable {

    private HashMap<String, Item> items;
    private Player player;

    public Crate(String items, Player player) {
        this.player = player;
        name = "Crate";

        String[] itemsArray = items.split("\\.");
        this.items = new HashMap<>();
        for (String item : itemsArray) {
            this.items.put(item, Item.factory(item, player));
        }
    }

    @Override
    public String interact() {
        return items.keySet().toString();
    }
}
