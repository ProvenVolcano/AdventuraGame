package Command;

import World.Player;

import java.util.Scanner;

public class UseComm extends Command {

    private Player player;
    private Scanner sc;

    public UseComm(Player player) {
        this.player = player;
        sc = new Scanner(System.in);
    }

    @Override
    public String execute() {

        if(player.getItems().isEmpty()){
            return "No items in inventory";
        }

        System.out.println(player.itemsString());
        String item = sc.nextLine();
        return player.useItem(item);
    }

    @Override
    public boolean exit() {
        return false;
    }
}
