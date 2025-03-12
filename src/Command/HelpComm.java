package Command;

import java.util.HashMap;

public class HelpComm extends Command {

    private HashMap<String, Command> commands;

    public HelpComm(HashMap<String, Command> commands) {
        this.commands = commands;
    }

    @Override
    public String execute() {

        StringBuilder string = new StringBuilder();

        for (String name : commands.keySet()){
            string.append(name + "\n");
        }

        return string.toString();
    }

    @Override
    public boolean exit() {
        return false;
    }
}
