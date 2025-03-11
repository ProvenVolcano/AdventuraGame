package Interactables;

import java.util.HashMap;
import Items.*;
import World.Player;

public class Crate extends Interactable {

    private HashMap<String, Item> items;
    private Player player;

    @Override
    public String interact() {
        return "";
    }
}
