package Command;

import World.World;

import java.util.Scanner;

public class InteractComm extends Command {

    private World world;
    private Scanner sc;

    public InteractComm(World world) {
        this.world = world;
        sc = new Scanner(System.in);
    }

    @Override
    public String execute() {
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
