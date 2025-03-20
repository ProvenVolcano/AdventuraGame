package Command;

import Colors.Text;
import World.*;

import java.util.Scanner;

public class InteractComm extends Command {

    private World world;
    private Player player;
    private Scanner sc;

    public InteractComm(World world, Player player) {
        this.world = world;
        this.player = player;
        sc = new Scanner(System.in);
    }

    @Override
    public String execute() {
        if(player.isFighting()){
            return Text.color("Can't execute command while fighting an enemy\n" + player.damage(15), 'r');
        }

        if(world.getCurrentRoom().getInteractablesString().isEmpty()){
            return Text.color("Nothing to interact with in this room", 'y');
        }

        System.out.println(world.getCurrentRoom().getInteractablesString());
        String obj = sc.nextLine();

        try {
            return world.getCurrentRoom().getInteractables().get(obj).interact();
        } catch (Exception e) {
            return Text.color("No such object", 'r');
        }
    }

    @Override
    public boolean exit() {
        return false;
    }
}
