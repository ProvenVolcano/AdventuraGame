package Interactables;

import Colors.Text;
import World.Player;

import java.util.HashMap;
import java.util.Scanner;

public class Core extends Interactable {

    private Player player;
    private Scanner sc;
    private int errors;

    public Core(Player player) {
        this.player = player;
        errors = 0;
        sc = new Scanner(System.in);
        name = "Power Core";
    }

    @Override
    public String interact() {
        if(!player.isHasEngineerItems()){
            return Text.color("You don't have all the items needed for repair!", 'r');
        }

        if(screws()){
            player.setAlive(false);
            return Text.color("You blew up the ship and died", 'd');
        }

        if(cables()){
            player.setAlive(false);
            return Text.color("You blew up the ship and died", 'd');
        }

        if(chip()){
            player.setAlive(false);
            return Text.color("You blew up the ship and died", 'd');
        }

        player.setFixedCore(true);
        System.out.println(Text.color("Power core running, restoring power...", 'g'));
        return "Engineer:\nYou did it! Amazing! We have full power again, most systems should start working now!";
    }

    private boolean screws() {
        System.out.println("""
                Engineer:
                Okay, listen very carefully, we only have one shot at this, if you mess up, it could blow up the whole ship.
                In front of you there should be a panel with nine screws with numbers next to them.
                You need to screw out only those I tell you, in the exact order I tell you.""");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("""
                23 X           88 X           51 X
                
                61 X           60 X           97 X
                
                39 X           69 X           11 X
                """);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.print("First, take out the one with the highest number whose digits are the same.\n> ");
        String screw1;

        do {
            screw1 = sc.nextLine();

            if(!screw1.equals("88")) {
                errors++;
                if(errors == 3){
                    return true;
                }
                System.out.println("Errors: " + errors + "/3");
            }

        } while (!screw1.equals("88"));

        System.out.print("Great! Next, the one next to the previous one, whose number is furthest away it.\n> ");

        String screw2;

        do {
            screw2 = sc.nextLine();

            if(!screw2.equals("23")) {
                errors++;
                if(errors == 3){
                    return true;
                }
                System.out.println("Errors: " + errors + "/3");
            }
        } while (!screw2.equals("23"));

        System.out.print("Just 2 more to go! Now, screw out the one on the opposite column, but on the same row as the previous one.\n> ");

        String screw3;

        do {
            screw3 = sc.nextLine();

            if(!screw3.equals("51")) {
                errors++;
                if(errors == 3){
                    return true;
                }
                System.out.println("Errors: " + errors + "/3");
            }
        } while (!screw3.equals("51"));

        System.out.println("Last one! Screw out the one whose number is divisible by 10.\n> ");

        String screw4;

        do {
            screw4 = sc.nextLine();

            if(!screw4.equals("60")) {
                errors++;
                if(errors == 3){
                    return true;
                }
                System.out.println("Errors: " + errors + "/3");
            }
        } while (!screw4.equals("60"));

        System.out.println("You did it! Now we can move on to the next part.");
        return false;
    }

    private boolean cables() {

        HashMap<String, String> cables = new HashMap<>();
        cables.put("1-3", "blue");
        cables.put("2-4", "red");
        cables.put("3-1", "yellow");

        StringBuilder scheme = new StringBuilder();
        scheme.append("""
                                       42  :1
                
                1: 1B                  225 :2
                
                2: F1                  27  :3
                
                3: 2A                  240 :4
                
                                       32  :5
                """);

        System.out.println("You should see 3 ports for cables on the left and 5 on the right");
        System.out.println(scheme);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("""
                Your task is fairly simple, just connect the ports on the left, which are marked in hexadecimal,\s
                with the ones on the right, which are in the normal decimal system.
                """);

        System.out.print("For the input, write the number of the ports, first the left one, separated by a dash, for example: 3-5");

        String input;
        while(!cables.isEmpty()) {
            System.out.print("> ");
            input = sc.nextLine();

            if(cables.remove(input) == null){
                errors++;
                if(errors == 3){
                    return true;
                }
                System.out.println("Errors: " + errors + "/3");
            } else {
                scheme.append(cables.get(input));
            }
        }

        System.out.println("Wonderful! The last step remains now.");
        return false;
    }

    private boolean chip() {
        // Will add later (maybe)
        return false;
    }
}
