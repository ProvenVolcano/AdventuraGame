package Items;

import Colors.Text;
import World.Player;

/**
 * Class for the battery item
 */
public class Battery extends Item {

    private Player player;

    public Battery(Player player) {
        this.player = player;
        oneTimeUse = true;
        name = "Battery";
        color = 'y';
    }

    /**
     * Recharges the Laser Gun if the player has it
     * @return - message about the Laser Gun power
     */
    @Override
    public String use() {
        oneTimeUse = true;

        if(player.getGun() == null){
            oneTimeUse = false;
            return Text.color("Can't use this item now", 'y');
        }

        if(player.getGun().getPower() == 100) {
            oneTimeUse = false;
            return Text.color("Laser Gun power already full", 'y');
        }

        player.getGun().reload();
        return Text.color("Laser Gun battery changed", 'g');
    }
}
