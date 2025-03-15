package Interactables;

import World.Player;

public class Shuttle extends Interactable {

    private Player player;

    public Shuttle(Player player) {
        this.player = player;
        name = "Shuttle";
    }

    @Override
    public String interact() {
        return name;
    }
}
