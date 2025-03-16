package World;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Character {

    private String name;
    private ArrayList<String> dialogs;
    private int dialogIndex;

    public Character(String fileName) {
        dialogs = new ArrayList<>();
        dialogIndex = 0;

        try{
            BufferedReader br = new BufferedReader(new FileReader("characters\\" + fileName + ".txt"));
            name = br.readLine();

            String line;
            while((line = br.readLine()) != null) {
                dialogs.add(line);
            }

        }catch (IOException e){
            System.out.println("Error reading character file");
        }
    }

    public String talk(){
        return name + ":\n" + dialogs.get(dialogIndex);
    }

    public String getName() {
        return name;
    }
}
