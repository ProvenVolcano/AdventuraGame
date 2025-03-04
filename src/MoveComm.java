import java.util.Scanner;

public class MoveComm extends Command {

    private World world;
    private Scanner sc;

    public MoveComm(World world) {
        this.world = world;
        sc = new Scanner(System.in);
    }

    @Override
    public String execute() {
        System.out.print("You can move to:\n" + world.neighbouringRooms() + "\n> ");
        int newRoom = sc.nextInt();
        return world.moveToRoom(newRoom);
    }

    @Override
    public boolean exit() {
        return false;
    }
}
