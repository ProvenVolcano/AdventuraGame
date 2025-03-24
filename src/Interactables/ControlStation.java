package Interactables;

import Characters.AlienCaptain;
import Colors.Text;
import World.Player;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ControlStation extends Interactable {

    private Scanner sc;
    private AlienCaptain alienCaptain;
    private Player player;
    private StringBuilder scheme;

    public ControlStation(Player player) {
        sc = new Scanner(System.in);
        this.player = player;
        alienCaptain = new AlienCaptain("alienCaptain");
        name = "Control Station";

        scheme = new StringBuilder();
        String line;
        try {
            BufferedReader br = new BufferedReader(new FileReader("alienShipScheme.txt"));
            while((line = br.readLine()) != null) {
                scheme.append(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String interact() {

        System.out.print("1. Call alien ship\n2. Scan alien ship\n> ");
        String action = sc.nextLine();
        switch (action) {
            case "1":
                return alienCaptain.talk();
            case "2":
                if(player.isFixedCore()){
                    return scheme.toString();
                }
                return Text.color("Cannot begin scan, emergency power only", 'y');
            default:
                return Text.color("No such option", 'r');
        }
    }
}
