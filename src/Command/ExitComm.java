package Command;

/**
 * Command to exit the game
 */
public class ExitComm extends Command {

    @Override
    public String execute() {
        return "Game exited";
    }

    @Override
    public boolean exit() {
        return true;
    }
}