package Command;

import Colors.*;
import Items.Item;
import World.*;

import java.util.Scanner;

/**
 * Command to drop an item from the inventory
 */
public class ThrowComm extends Command {

    private Player player;
    private World world;
    private Scanner sc;

    public ThrowComm(Player player, World world) {
        this.player = player;
        this.world = world;
        sc = new Scanner(System.in);
    }

    /**
     * Lists items in the inventory asks for which one to remove, removes the item from the inventory
     * and adds it into player's current room
     * @return - message about the removal of an item
     */
    @Override
    public String execute() {
        if(player.isFighting()){
            return Text.color("Can't execute command while fighting an enemy\n" + player.damage(15), 'r');
        }

        if(player.getItems().isEmpty()){
            return Text.color("No items in inventory", 'r');
        }

        System.out.println(player.itemsString());
        System.out.print("Item to remove: ");
        String item = sc.nextLine();
        if(player.remove(item)){
            world.getCurrentRoom().getItems().add(Item.factory(item, player));
            return item + " removed from inventory";
        }
        return Text.color("Not such item in your inventory", 'r');
    }

    @Override
    public boolean exit() {
        return false;
    }
}
