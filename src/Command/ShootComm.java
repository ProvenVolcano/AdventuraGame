package Command;

import World.*;

public class ShootComm extends Command {

    private World world;
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