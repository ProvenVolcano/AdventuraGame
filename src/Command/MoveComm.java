package Command;

import java.util.Scanner;

import Colors.Text;
import World.*;

/**
 * Command to move between rooms
 */
public class MoveComm extends Command {

    private World world;
    private Player player;
    private Scanner sc;

    public MoveComm(World world, Player player) {
        this.world = world;
        this.player = player;
        sc = new Scanner(System.in);
    }

    /**
     * Lists neighbouring rooms, asks for a room to move to and moves the player to that room if it's possible
     * @return - message about the move
     */
    @Override
    public String execute() {
        if(player.isFighting()){
            System.out.println(player.damage(10));

            if(!player.isAlive()){
                return "";
            }
        }

        System.out.print("You can move to:\n" + world.neighbouringRooms() + "\nRoom to move to: ");
        String newRoom = sc.nextLine();

        try {
            return world.moveToRoom(Integer.parseInt(newRoom));
        } catch (NumberFormatException e) {
            return Text.color("Invalid input, write only the number of the room you want to move to.", 'r');
        }

    }

    @Override
    public boolean exit() {
        return false;
    }
}
