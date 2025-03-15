package Interactables;

import World.Player;

public class Shuttle extends Interactable {

    private Player player;

    public Shuttle(Player player) {
        this.player = player;
    }

    @Override
    public String interact() {
        return "";
    }
}
