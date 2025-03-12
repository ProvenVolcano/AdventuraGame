package Commands;

public class ExitComm extends Command {

    @Override
    public String execute() {
        return "Exited";
    }

    @Override
    public boolean exit() {
        return true;
    }
}