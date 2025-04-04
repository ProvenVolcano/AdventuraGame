package Characters;

import Items.Bandages;
import World.Player;

import java.util.Scanner;

/**
 * Class for the doctor which gives the player bandages
 */
public class Doctor extends Character {

    Player player;
    Scanner sc;

    public Doctor(String file, Player player) {
        super(file);
        this.player = player;
        sc = new Scanner(System.in);
    }

    /**
     * Asks the player if they want bandages, if they answer yes, bandages are added in the players inventory
     * @return - the doctor's dialog
     */
    @Override
    public String talk() {
        switch (dialogIndex) {
            case 1:
                System.out.println(dialogs.get(1));
                String answer = sc.nextLine();
                if(answer.equalsIgnoreCase("yes")){
                    return player.addItem(new Bandages(player));
                } else return "";
            default:
                if (dialogIndex != dialogs.size() - 1) {
                    dialogIndex++;
                }
                return dialogs.get(dialogIndex - 1);
        }
    }
}
