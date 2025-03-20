package Command;

import Colors.Text;
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
        if(player.isFighting()){
            return Text.color("Can't execute command while fighting an enemy\n" + player.damage(15), 'r');
        }

        if(world.getCurrentRoom().getItemsString().isEmpty()){
            return Text.color("No items in this room", 'r');
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
