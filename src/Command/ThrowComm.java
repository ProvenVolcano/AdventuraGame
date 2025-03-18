package Command;

import Items.Item;
import World.*;

import java.util.Scanner;

public class ThrowComm extends Command {

    private Player player;
    private World world;
    private Scanner sc;

    public ThrowComm(Player player, World world) {
        this.player = player;
        this.world = world;
        sc = new Scanner(System.in);
    }

    @Override
    public String execute() {
        if(player.itemsString().isEmpty()){
            return "No items in inventory";
        }

        System.out.println("Inventory:\n" + player.itemsString());
        System.out.print("Item to remove: ");
        String item = sc.nextLine();
        if(player.remove(item)){
            world.getCurrentRoom().getItems().add(Item.factory(item, player));
            return item + " removed from inventory";
        }
        return "Not such item in your inventory";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
