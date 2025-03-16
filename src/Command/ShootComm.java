package Command;

import World.*;

public class ShootComm extends Command {

    private World world;
    private Player player;

    public ShootComm(World world, Player player) {
        this.world = world;
        this.player = player;
    }

    @Override
    public String execute() {
        if(player.getGun() == null){
            return "You don't have anything to shoot with";
        }
        return player.getGun().use();
    }

    @Override
    public boolean exit() {
        return false;
    }
}