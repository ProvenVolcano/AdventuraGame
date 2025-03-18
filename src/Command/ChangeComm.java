package Command;

import World.Player;

public class ChangeComm extends Command {

    private Player player;

    public ChangeComm(Player player) {
        this.player = player;
    }

    @Override
    public String execute() {
        if(!player.containsItem("Battery")){
            return "You don't have a battery";
        }
        return player.useItem("Battery");
    }

    @Override
    public boolean exit() {
        return false;
    }
}
