package Command;

import Colors.Text;
import World.*;

import java.util.Scanner;

/**
 * Command to open crates
 */
public class OpenComm extends Command {

    private World world;
    private Scanner sc;
    private Player player;

    public OpenComm(World world, Player player) {
        this.player = player;
        this.world = world;
        sc = new Scanner(System.in);
    }

    /**
     * Lists available crates and asks for a crate to open
     * @return - crate interaction
     */
    @Override
    public String execute() {
        if(player.isFighting()){
            return Text.color("Can't execute command while fighting an enemy\n" + player.damage(15), 'r');
        }

        if(world.getCurrentRoom().getCrates().isEmpty()) {
            return Text.color("No crates in this room", 'y');
        }
        System.out.println(world.getCurrentRoom().cratesString());
        System.out.print("Crate to open: ");
        String crate = sc.nextLine();

        String ret;
        try {
            ret = world.getCurrentRoom().getCrates().get(Integer.parseInt(crate) - 1).interact();
        } catch (Exception e) {
            return Text.color("Enter only the number of the crate", 'r');
        }
        return ret;
    }

    @Override
    public boolean exit() {
        return false;
    }
}