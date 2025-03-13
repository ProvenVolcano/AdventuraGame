package Command;

import World.*;

import java.util.Scanner;

public class PickComm extends Command {

    private World world;
    private Player player;
    private Scanner sc;

    public PickComm(World world, Player player) {
        this.world = world;
        this.player = player;
        sc = new Scanner(System.in);
    }

    @Override
    public String execute() {

        if(world.getCurrentRoom().getItemsString().isEmpty()){
            return "No items in this room";
        }

        System.out.println(world.getCurrentRoom().getItemsString());
        String item = sc.nextLine();

        return player.addItem(world.getCurrentRoom().getItem(item));
    }

    @Override
    public boolean exit() {
        return false;
    }
}
