package Interactables;

import Colors.Text;
import World.Player;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Class for the spaceships power core
 */
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

    /**
     * Interaction method, calls the individual fixing methods and controls number of mistakes
     * @return - message about the interaction
     */
    @Override
    public String interact() {
        if(player.isFixedCore()){
            return Text.color("The core is running", 'y');
        }

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

    /**
     * First step to fix the core, makes the player enter numbers based on a text
     * @return - if the player has done more than 2 mistakes
     */
    private boolean screws() {
        System.out.println("""
                Engineer:
                Okay, listen very carefully, we only have one shot at this, if you mess up, it could blow up the whole ship.
                In front of you there should be a panel with nine screws with numbers next to them.
                You need to screw out only those I tell you, in the exact order I tell you.\n
                """);

        System.out.println("""
                23 X           88 X           51 X
                
                61 X           60 X           97 X
                
                39 X           69 X           11 X
                """);

        System.out.println("First, take out the one with the highest number whose digits are the same.");
        String screw1;

        do {
            System.out.print("> ");
            screw1 = sc.nextLine();

            if(!screw1.equals("88")) {
                errors++;
                if(errors == 3){
                    return true;
                }
                System.out.println("Errors: " + errors + "/3");
            }

        } while (!screw1.equals("88"));

        System.out.println("Great! Next, the one next to the previous one, whose number is furthest away it.");

        String screw2;

        do {
            System.out.print("> ");
            screw2 = sc.nextLine();

            if(!screw2.equals("23")) {
                errors++;
                if(errors == 3){
                    return true;
                }
                System.out.println("Errors: " + errors + "/3");
            }
        } while (!screw2.equals("23"));

        System.out.println("Just 2 more to go! Now, screw out the one on the opposite column, but on the same row as the previous one.");

        String screw3;

        do {
            System.out.print("> ");
            screw3 = sc.nextLine();

            if(!screw3.equals("51")) {
                errors++;
                if(errors == 3){
                    return true;
                }
                System.out.println("Errors: " + errors + "/3");
            }
        } while (!screw3.equals("51"));

        System.out.println("Last one! Screw out the one whose number is divisible by 10.");

        String screw4;

        do {
            System.out.print("> ");
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

    /**
     * Second method to fix the core, makes the player convert hexadecimal numbers to decimal
     * @return - if the player has done more than 2 mistakes
     */
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

        System.out.println("You should see 3 ports for cables on the left and 5 on the right\n");
        System.out.println(scheme);

        System.out.println("""
                Your task is fairly simple, just connect the ports on the left, which are marked in hexadecimal,\s
                with the ones on the right, which are in the normal decimal system.
                """);

        System.out.println("(For the input, write the number of the ports, first the left one, separated by a dash, for example: 3-5)");

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

    /**
     * Last method to fix the core, makes the player change a number based on logical operators
     * @return - if the player has done more than 2 mistakes
     */
    private boolean chip() {
        System.out.println("""    
                        We need to calibrate the chip, from the top and bottom is coming the input,
                        from the left the operation that should be done with the numbers, and from the right comes the output.
                        """);

        System.out.println("""
                         |    |    |    |
                         1    0    1    1
                       __|____|____|____|____
                      |  A    B    C    D  A |___ ?
                      |      __________      |
                      |     |          |   B |___ ?
                __OR__|     |          |     |
                      |     |          |   C |___ ?
                      |     |__________|     |
                      |                    D |___ ?
                      |______________________|
                        |     |     |    |
                        0     1     1    0
                        |     |     |    |
                """);

        String output1;
        do {
            System.out.print("> ");
            output1 = sc.nextLine();

            if(!output1.equals("1111")) {
                errors++;
                if(errors == 3){
                    return true;
                }
                System.out.println("Errors: " + errors + "/3");
            }
        } while (!output1.equals("1111"));

        System.out.println("""
                         |    |    |    |
                         0    1    0    0
                       __|____|____|____|____
                      |  A    B    C    D  A |___ ?
                      |      __________      |
                      |     |          |   B |___ ?
                __AND_|     |          |     |
                      |     |          |   C |___ ?
                      |     |__________|     |
                      |                    D |___ ?
                      |______________________|
                        |     |     |    |
                        0     1     1    0
                        |     |     |    |
                """);

        String output2;
        do {
            System.out.print("> ");
            output2 = sc.nextLine();

            if(!output2.equals("0100")) {
                errors++;
                if(errors == 3){
                    return true;
                }
                System.out.println("Errors: " + errors + "/3");
            }
        } while (!output2.equals("0100"));

        System.out.println("""
                         |    |    |    |
                         1    0    0    1
                       __|____|____|____|____
                      |  A    B    C    D  A |___ ?
                      |      __________      |
                      |     |          |   B |___ ?
                __XOR_|     |          |     |
                      |     |          |   C |___ ?
                      |     |__________|     |
                      |                    D |___ ?
                      |______________________|
                        |     |     |    |
                        1     1     0    0
                        |     |     |    |
                """);

        String output3;
        do {
            System.out.print("> ");
            output3 = sc.nextLine();

            if(!output3.equals("0101")) {
                errors++;
                if(errors == 3){
                    return true;
                }
                System.out.println("Errors: " + errors + "/3");
            }
        } while (!output3.equals("0101"));

        return false;
    }
}
