package Characters;

import World.Player;

/**
 * Class for the captain of the aliens
 */
public class AlienCaptain extends Character {

    Player player;

    public AlienCaptain(String fileName, Player player) {
        super(fileName);
        this.player = player;
    }

    @Override
    public String talk() {
        switch (dialogIndex){
            case 0:
                dialogIndex++;
                return dialogs.get(0);
            case 1:
                if(player.containsItem("Files")){
                    dialogIndex++;
                    return dialogs.get(1) + "\n" + dialogs.get(2);
                }
                return dialogs.get(0);
            case 2:
                return dialogs.get(2);
            default:
                return "";
        }

    }
}
