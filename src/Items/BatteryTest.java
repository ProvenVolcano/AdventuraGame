package Items;

import Colors.Text;
import World.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for Battery item
 */
class BatteryTest {

    /**
     * Tests use() method by using the player's laser gun
     */
    @Test
    void use() {
        Player player = new Player();
        Battery battery = new Battery(player);

        assertEquals(Text.color("Can't use this item now", 'y'), battery.use());

        player.addItem(new LaserGun());
        assertEquals(Text.color("Laser Gun power already full", 'y'), battery.use());

        player.getGun().use();
        assertEquals(Text.color("Laser Gun battery changed", 'g'), battery.use());

    }
}