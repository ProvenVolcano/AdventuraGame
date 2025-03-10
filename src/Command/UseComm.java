package Command;

import World.Player;

public class UseComm extends Command {

    private Player player;

    @Override
    public String execute() {
        return "";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
