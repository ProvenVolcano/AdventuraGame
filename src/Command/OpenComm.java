package Command;

import World.World;

import java.util.Scanner;

public class OpenComm extends Command {

    private World world;
    private Scanner sc;

    public OpenComm(World world) {
        this.world = world;
        sc = new Scanner(System.in);
    }

    @Override
    public String execute() {
        System.out.println(world.getCurrentRoom().cratesString());
        System.out.print("Crate to open: ");
        String crate = sc.nextLine();

        String ret;
        try {
            ret = world.getCurrentRoom().getCrates().get(Integer.parseInt(crate) - 1).interact();
        } catch (Exception e) {
            return "Enter only the number of the crate";
        }
        return ret;
    }

    @Override
    public boolean exit() {
        return false;
    }
}