package Command;

import Colors.Text;
import World.Player;

public class ChangeComm extends Command {

    private Player player;

    public ChangeComm(Player player) {
        this.player = player;
    }

    @Override
    public String execute() {
        if(!player.containsItem("Battery")){
            return Text.color("You don't have a battery", 'r');
        }
        return player.useItem("Battery");
    }

    @Override
    public boolean exit() {
        return false;
    }
}
