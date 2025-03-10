package Command;

import World.World;

public class TalkComm extends Command {

    private World world;

    public TalkComm() {
    }

    @Override
    public String execute() {
        return "";
    }

    @Override
    public boolean exit() {
        return false;
    }
}