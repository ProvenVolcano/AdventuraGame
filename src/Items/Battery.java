package Items;

import World.Player;

public class Battery extends Item {

    private Player player;

    public Battery(Player player) {
        this.player = player;
        name = "Battery";
    }

    @Override
    public String use() {
        return name;
    }
}
