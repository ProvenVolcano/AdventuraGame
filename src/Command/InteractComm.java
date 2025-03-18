package Command;

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
            return "Can't execute command while fighting an enemy\n" + player.damage(15);
        }

        if(world.getCurrentRoom().getInteractablesString().isEmpty()){
            return "Nothing to interact with in this room";
        }

        System.out.println(world.getCurrentRoom().getInteractablesString());
        String obj = sc.nextLine();

        try {
            return world.getCurrentRoom().getInteractables().get(obj).interact();
        } catch (Exception e) {
            return "No such object";
        }
    }

    @Override
    public boolean exit() {
        return false;
    }
}
