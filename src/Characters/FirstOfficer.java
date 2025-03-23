package Characters;

import World.Player;

public class FirstOfficer extends Character {

    private Player player;

    public FirstOfficer(String fileName, Player player) {
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
                if (player.containsItem("Pills")) {
                    dialogIndex++;
                } else return dialogs.get(1);
            case 2:
                dialogIndex++;
                return dialogs.get(2);
            case 3:
                if (player.containsItem("Files")) {
                    dialogIndex++;
                } else return dialogs.get(3);
            case 4:
                dialogIndex++;
                return dialogs.get(4);
            case 5:
                return dialogs.get(5);
            default:
                return "";
        }
    }
}
