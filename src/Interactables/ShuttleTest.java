package Interactables;

import Colors.Text;
import Items.Component;
import World.Player;
import World.World;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for shuttle
 */
class ShuttleTest {

    /**
     * Tests interact() method with a player with and without a power cell, and after player fixed the core
     */
    @Test
    void interact() {

        Player player = new Player();
        World world = new World("world.txt", player);
        Shuttle shuttle = new Shuttle(player, world);

        assertEquals(Text.color("You need a power cell for the shuttle", 'y'), shuttle.interact());

        player.addItem(new Component("Power cell"));
        assertEquals(Text.color("Emergency power only, can't open hangar door", 'o'), shuttle.interact());

        player.setFixedCore(true);

        ArrayList<String> result = new ArrayList<>();
        result.add(Text.color("Moved to Alien Spaceship", 'g'));
        result.add(Text.color("Moved to Alien Spaceship", 'g') + Text.color("\nTHERE IS AN ALIEN! QUICK, SHOOT HIM!", 'p'));
        assertTrue(result.contains(shuttle.interact()));
    }
}