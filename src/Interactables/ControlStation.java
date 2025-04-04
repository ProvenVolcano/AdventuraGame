package Interactables;

import Characters.AlienCaptain;
import Colors.Text;
import Items.Scheme;
import World.Player;

import java.util.Scanner;

/**
 * The spaceship control station, where the player can interact with the outside
 */
public class ControlStation extends Interactable {

    private Scanner sc;
    private AlienCaptain alienCaptain;
    private Player player;
    private Scheme scheme;

    public ControlStation(Player player) {
        sc = new Scanner(System.in);
        this.player = player;
        alienCaptain = new AlienCaptain("alienCaptain", player);
        name = "Control Station";
        scheme = new Scheme();
    }

    /**
     * Method to interact with the control station
     * Player can enter 1 to talk with the alien captain or 2 to scan the alien ship
     * @return - the message about the interaction or the alien captain dialog
     */
    @Override
    public String interact() {

        System.out.print("1. Call alien ship\n2. Scan alien ship\n> ");
        String action = sc.nextLine();
        switch (action) {
            case "1":
                return alienCaptain.talk();
            case "2":
                if (player.isFixedCore()) {
                    return player.addItem(scheme);
                }
                return Text.color("Cannot begin scan, emergency power only", 'y');
            default:
                return Text.color("No such option", 'r');
        }
    }

    @Override
    public void setPassword(int password) {
        super.setPassword(password);
        alienCaptain.setPassword(password);
    }
}
