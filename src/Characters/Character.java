package Characters;

import World.Player;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public abstract class Character {

    protected String name;
    protected ArrayList<String> dialogs;
    protected int dialogIndex;

    public Character(String fileName) {
        dialogs = new ArrayList<>();
        dialogIndex = 0;

        try{
            BufferedReader br = new BufferedReader(new FileReader("characters\\" + fileName + ".txt"));
            name = br.readLine();

            String line;
            char prevNum = '1';
            StringBuilder dialog = new StringBuilder();
            while((line = br.readLine()) != null) {

                if(line.charAt(0) == prevNum) {
                    dialog.append(line.substring(2) + "\n");
                } else {
                    dialogs.add(dialog.toString());
                    prevNum = line.charAt(0);
                    dialog = new StringBuilder();
                    dialog.append(line.substring(2));
                }

            }
            dialogs.add(dialog.toString());

        } catch (IOException _){
        }
    }

    public abstract String talk();

    public String getName() {
        return name;
    }

    public static Character factory(String name, Player player) {
        return switch (name){
            case "doctor" -> new Doctor(name, player);
            case "engineer" -> new Engineer(name, player);
            case "captain" -> new Captain(name);
            case "firstOfficer" -> new FirstOfficer(name);
            case "alienCaptain" -> new AlienCaptain(name);
            default -> null;
        };
    }
}
