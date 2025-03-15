package Interactables;

import World.Player;

public class Core extends Interactable {

    private Player player;

    public Core(Player player) {
        this.player = player;
    }

    @Override
    public String interact() {
        return "";
    }
}
