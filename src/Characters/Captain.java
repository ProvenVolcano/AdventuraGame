package Characters;

import World.Player;

/**
 * Class for the captain that the player rescues
 */
public class Captain extends Character {

    Player player;

    public Captain(String fileName, Player player) {
        super(fileName);
        this.player = player;
    }

    @Override
    public String talk() {
        player.setSavedCaptain(true);
        return dialogs.get(0);
    }
}
