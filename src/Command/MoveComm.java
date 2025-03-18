package Command;

import java.util.Scanner;
import World.*;

public class MoveComm extends Command {

    private World world;
    private Player player;
    private Scanner sc;

    public MoveComm(World world, Player player) {
        this.world = world;
        this.player = player;
        sc = new Scanner(System.in);
    }

    @Override
    public String execute() {
        if(player.isFighting()){
            System.out.println(player.damage(10));
        }

        System.out.print("You can move to:\n" + world.neighbouringRooms() + "\nRoom to move to: ");
        String newRoom = sc.nextLine();

        try {
            return world.moveToRoom(Integer.parseInt(newRoom));
        } catch (NumberFormatException e) {
            return "Invalid input, write only the number of the room you want to move to.";
        }

    }

    @Override
    public boolean exit() {
        return false;
    }
}
