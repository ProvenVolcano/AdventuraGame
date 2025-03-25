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
    protected int password;

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
                    dialog.append(line.substring(2)).append("\n");
                } else {
                    dialogs.add(dialog.toString());
                    prevNum = line.charAt(0);
                    dialog = new StringBuilder();
                    dialog.append(line.substring(2));
                }

            }
            br.close();
            dialogs.add(dialog.toString());

        } catch (IOException _){
        }
    }

    public abstract String talk();

    public String getName() {
        return name;
    }

    public void setPassword(int pass) {
        this.password = pass;

        for(int i = 0; i < dialogs.size(); i++) {
            if(dialogs.get(i).contains("#")){
                dialogs.set(i, dialogs.get(i).replace("#", pass + ""));
            }
        }
    }

    public static Character factory(String name, Player player) {
        return switch (name){
            case "doctor" -> new Doctor(name, player);
            case "engineer" -> new Engineer(name, player);
            case "captain" -> new Captain(name, player);
            case "firstOfficer" -> new FirstOfficer(name, player);
            case "alienCaptain" -> new AlienCaptain(name);
            default -> null;
        };
    }
}
