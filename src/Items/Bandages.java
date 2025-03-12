package Items;

import World.Player;

public class Bandages extends Item {

    private Player player;

    public Bandages(Player player) {
        this.player = player;
        name = "Bandages";
    }

    @Override
    public String use() {
        return "";
    }
}
