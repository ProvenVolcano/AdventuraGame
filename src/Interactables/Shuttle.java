package Interactables;

import World.*;

public class Shuttle extends Interactable {

    private Player player;
    private World world;

    public Shuttle(Player player, World world) {
        this.player = player;
        this.world = world;
        name = "Shuttle";
    }

    @Override
    public String interact() {

        world.moveToRoom(8);
        return name;
    }
}
