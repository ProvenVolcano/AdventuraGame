package Characters;

import World.Player;

import java.util.ArrayList;
import java.util.Collections;

public class Engineer extends Character {

    private Player player;
    private ArrayList<String> neededItems;

    public Engineer(String file, Player player) {
        super(file);
        this.player = player;
        neededItems = new ArrayList<>();
        Collections.addAll(neededItems, "Screwdriver", "Blue cable");
    }

    @Override
    public String talk() {
        switch (dialogIndex) {
            case 0:
                dialogIndex++;
                return dialogs.get(0);
            case 1:
                if (player.containsItem("Bandages")) {
                    dialogIndex++;
                } else return dialogs.get(1);
            case 2:
                dialogIndex++;
                return dialogs.get(2) + neededItemsString() + ".";
            case 3:
                if (hasAll()) {
                    dialogIndex++;
                } else return dialogs.get(3) + neededItemsString() + ".";
            case 4:
                return dialogs.get(4);
        }
        return "idk";
    }

    private boolean hasAll() {
        for (int i = 0; i < neededItems.size(); i++) {
            if (player.containsItem(neededItems.get(i))) {
                player.remove(neededItems.get(i));
                neededItems.remove(neededItems.get(i));
            }
        }
        return neededItems.isEmpty();
    }

    private String neededItemsString() {
        StringBuilder string = new StringBuilder();
        for(int i = 0; i < neededItems.size() - 1; i++) {
            string.append(neededItems.get(i) + ", ");
        }
        string.append(neededItems.get(neededItems.size() - 1));
        return string.toString();
    }

}
