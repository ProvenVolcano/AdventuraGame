package Characters;

import World.Player;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Class for the engineer
 */
public class Engineer extends Character {

    private Player player;
    private ArrayList<String> neededItems;

    public Engineer(String file, Player player) {
        super(file);
        this.player = player;
        neededItems = new ArrayList<>();
        Collections.addAll(neededItems, "Screwdriver", "Blue cable", "Chip", "Yellow cable", "Red cable");
    }

    /**
     * Asks the player for bandages, when the player gives them to him, he'll give the player a list of items to bring to him
     * @return - the engineer's dialog
     */
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
                    player.setHasEngineerItems(true);
                } else return dialogs.get(3) + neededItemsString() + ".";
            case 4:
                return dialogs.get(4);
        }
        return "idk";
    }

    /**
     * Checks if the player has all the items needed for the repair of the core
     * @return - true if all items have been collected
     */
    private boolean hasAll() {
        for (int i = 0; i < neededItems.size(); i++) {
            if (player.containsItem(neededItems.get(i))) {
                player.remove(neededItems.get(i));
                neededItems.remove(neededItems.get(i));
            }
        }
        return neededItems.isEmpty();
    }

    /**
     * Returns a string of the needed items
     * @return - the needed items in a string
     */
    private String neededItemsString() {
        StringBuilder string = new StringBuilder();
        for(int i = 0; i < neededItems.size() - 1; i++) {
            string.append(neededItems.get(i) + ", ");
        }
        string.append(neededItems.get(neededItems.size() - 1));
        return string.toString();
    }

}
