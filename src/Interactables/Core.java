package Interactables;

import Colors.Text;
import World.Player;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Class for the spaceships power core
 */
public class Core extends Interactable {

    private Player player;
    private Scanner sc;
    private int errors;
    private ArrayList<String> dialog;
    private String screws;
    private String cable;
    private ArrayList<String> chips;

    public Core(Player player) {
        this.player = player;
        errors = 0;
        sc = new Scanner(System.in);
        name = "Power Core";
        dialog = loadDialogs();
        screws = loadFile("screws.txt");
        cable = loadFile("cables.txt");
        chips = loadChips();
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
        return Text.color("Power core running, restoring power...\n", 'g') + dialog.get(12);
    }

    /**
     * First step to fix the core, makes the player enter numbers based on a text
     * @return - if the player has done more than 2 mistakes
     */
    private boolean screws() {

        System.out.println(dialog.get(0) + "\n" + dialog.get(1) + "\n" + dialog.get(2) + "\n" + dialog.get(3));
        System.out.println(screws);
        System.out.println(dialog.get(4));

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

        System.out.println(dialog.get(5));

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

        System.out.println(dialog.get(6));

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

        System.out.println(dialog.get(7));

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

        System.out.println(dialog.get(8));
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

        System.out.println(dialog.get(9));
        System.out.println(cable);

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
                System.out.println(Text.color("Correct!", 'g'));
            }
        }

        System.out.println(dialog.get(10));
        return false;
    }

    /**
     * Last method to fix the core, makes the player change a number based on logical operators
     * @return - if the player has done more than 2 mistakes
     */
    private boolean chip() {
        System.out.println(dialog.get(11));
        System.out.println(chips.get(0));

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

        System.out.println(chips.get(1));

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

        System.out.println(chips.get(2));

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

    /**
     * Loads dialogs from a file
     * @return - ArrayList of dialogs
     */
    private ArrayList<String> loadDialogs() {
        try {
            ArrayList<String> dialogs = new ArrayList<>();
            String line;
            BufferedReader br = new BufferedReader(new FileReader("res/coreRepair/dialog.txt"));
            while ((line = br.readLine()) != null) {
                dialogs.add(line);
            }
            return dialogs;

        } catch (IOException e) {
            return null;
        }
    }

    /**
     * Loads String from a file
     * @param fileName - name of the file
     * @return - the loaded String
     */
    private String loadFile(String fileName) {
        try {
            String ret = "";
            String line;
            BufferedReader br = new BufferedReader(new FileReader("res/coreRepair/" + fileName));
            while ((line = br.readLine()) != null) {
                ret += line + "\n";
            }
            return ret;

        } catch (IOException e) {
            return "";
        }
    }

    /**
     * Loads chip images
     * @return - ArrayList of the string chip images
     */
    private ArrayList<String> loadChips() {
        try {
            ArrayList<String> chips = new ArrayList<>();
            String line;
            String chip = "";
            BufferedReader br = new BufferedReader(new FileReader("res/coreRepair/chip.txt"));
            while ((line = br.readLine()) != null) {
                chip += line + "\n";

                if(line.isEmpty()) {
                    chips.add(chip);
                    chip = "";
                }
            }
            chips.add(chip);
            return chips;

        } catch (IOException e) {
            return null;
        }
    }
}
