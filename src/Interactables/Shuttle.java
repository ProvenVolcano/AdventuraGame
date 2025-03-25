package Interactables;

import Colors.Text;
import World.*;

public class Shuttle extends Interactable {

    private Player player;
    private World world;
    private boolean fixed;

    public Shuttle(Player player, World world) {
        this.player = player;
        this.world = world;
        fixed = false;
        name = "Shuttle";
    }

    @Override
    public String interact() {
        if(!fixed){
            if(player.containsItem("Power cell")){
                player.remove("Power cell");
                fixed = true;
            } else return Text.color("You need a power cell for the shuttle", 'y');
        }

        if(!player.isFixedCore()){
            return Text.color("Emergency power only, can't open hangar door", 'o');
        }
        return world.moveToRoom(8);
    }
}
