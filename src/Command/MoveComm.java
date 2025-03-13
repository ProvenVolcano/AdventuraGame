package Command;

import java.util.Scanner;
import World.World;

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
        String newRoom = sc.nextLine();

        try {
            return world.moveToRoom(Integer.parseInt(newRoom));
        } catch (Exception e) {
            return "Invalid input, write only the number of the room you want to move to.";
        }

    }

    @Override
    public boolean exit() {
        return false;
    }
}
