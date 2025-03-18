package Command;

import World.*;

import java.util.Scanner;

public class OpenComm extends Command {

    private World world;
    private Scanner sc;
    private Player player;

    public OpenComm(World world, Player player) {
        this.player = player;
        this.world = world;
        sc = new Scanner(System.in);
    }

    @Override
    public String execute() {
        if(player.isFighting()){
            return "Can't execute command while fighting an enemy\n" + player.damage(15);
        }

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