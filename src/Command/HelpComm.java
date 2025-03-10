package Command;

import java.util.HashMap;

public class HelpComm extends Command {

    private HashMap<String, Command> commands;

    @Override
    public String execute() {
        return "";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
