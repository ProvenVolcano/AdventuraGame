package World;

import Colors.Text;
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
        World world = new World("world.txt", player);

        assertEquals(Text.color("Can't move to that room", 'r'), world.moveToRoom(999));
        assertEquals(Text.color("Can't move to that room", 'r'), world.moveToRoom(-999));
        assertEquals(Text.color("Moved to Hallway", 'g'), world.moveToRoom(3));
        assertEquals(Text.color("Can't move to that room", 'r'), world.moveToRoom(2));

        player.setSavedCaptain(true);
        assertEquals(Text.color("Congratulations! You completed the game", 'c'), world.moveToRoom(7));

    }
}