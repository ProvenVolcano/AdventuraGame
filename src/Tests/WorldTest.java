package Tests;

import Colors.Text;
import World.Player;
import World.World;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for World
 */
class WorldTest {

    /**
     * Test moveToRoom() by inputting different room IDs
     */
    @Test
    void moveToRoom() {
        Player player = new Player();
        World world = new World("res\\world.txt", player);

        assertEquals(Text.color("Can't move to that room", 'r'), world.moveToRoom(999, false));
        assertEquals(Text.color("Can't move to that room", 'r'), world.moveToRoom(-999, false));
        assertEquals(Text.color("Moved to Hallway", 'g'), world.moveToRoom(3, false));
        assertEquals(Text.color("Can't move to that room", 'r'), world.moveToRoom(2, false));
        assertEquals(Text.color("Moved to Captain's room", 'g'), world.moveToRoom(2, true));

        player.setSavedCaptain(true);
        assertEquals(Text.color("Congratulations! You completed the game", 'c'), world.moveToRoom(7, false));

    }
}