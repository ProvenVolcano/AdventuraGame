package Command;

import Colors.Text;
import World.Player;

/**
 * Command to replace a battery in the laser gun
 */
public class ChangeComm extends Command {

    private Player player;

    public ChangeComm(Player player) {
        this.player = player;
    }

    /**
     * If the player has a battery, laser gun will be recharged
     * @return - message about if the laser gun has been recharged or if the player doesn't have one
     */
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
