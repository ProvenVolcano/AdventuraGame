package Items;

import Colors.*;
import World.Player;

/**
 * Class of the bandages item
 */
public class Bandages extends Item {

    private Player player;

    public Bandages(Player player) {
        this.player = player;
        oneTimeUse = true;
        name = "Bandages";
        color = 'p';
    }

    /**
     * Increases player's health
     * @return - message about the player's current health
     */
    @Override
    public String use() {
        player.setHealth(player.getHealth() + 25);
        return Text.color("Health now " + player.getHealth() + "/100", 'g');
    }
}
