package Command;

import Colors.Text;
import Items.LaserGun;
import World.Player;
import World.World;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for the shoot command
 */
class ShootCommTest {

    /**
     * Tests execute() outputs with the laser gun, when the player doesn't have it, if it's low on power or if the player shoots normally
     */
    @Test
    void execute() {
        Player player = new Player();
        World world = new World("world.txt", player);

        ShootComm sc = new ShootComm(world, player);

        assertEquals(Text.color("You don't have anything to shoot with", 'y'), sc.execute());

        player.addItem(new LaserGun());
        assertEquals(Text.color("Phew!\n", 'o') + Text.color("Laser gun power is now 80/100\n", 'o'), sc.execute());

        for(int i = 0; i < 6; i++){
            player.getGun().use();
        }

        assertEquals(Text.color("Not enough power!", 'r'), sc.execute());
    }
}