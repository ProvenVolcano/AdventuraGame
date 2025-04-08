package Command;

import Colors.*;
import World.Player;

import java.util.Scanner;

/**
 * Command to use an item
 */
public class UseComm extends Command {

    private Player player;
    private Scanner sc;

    public UseComm(Player player) {
        this.player = player;
        sc = new Scanner(System.in);
    }

    /**
     * Lists items in the inventory and uses an item that the player inputs
     * @return - message about the use of an item
     */
    @Override
    public String execute() {

        if(player.getItems().isEmpty()){
            return Text.color("No items in inventory", 'r');
        }

        System.out.println(player.itemsString());
        System.out.println("Item to use: ");
        String item = sc.nextLine();
        return player.useItem(item);
    }

    @Override
    public boolean exit() {
        return false;
    }
}
