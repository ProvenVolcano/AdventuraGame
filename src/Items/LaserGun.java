package Items;

import Colors.*;

/**
 * The Laser Gun which the player uses to defend himself
 */
public class LaserGun extends Item {

    private int power;

    public LaserGun() {
        power = 100;
        name = "Laser Gun";
        color = 'r';
        oneTimeUse = false;
    }

    public int getPower() {
        return power;
    }

    /**
     * Changes the power to 100
     */
    public void reload() {
        power = 100;
    }

    /**
     * Decreases the laser gun power
     * @return - message about the charge of the laser gun
     */
    @Override
    public String use() {
        power -= 20;
        return Text.color("Laser gun power is now " + power + "/100\n", 'o');
    }

}
