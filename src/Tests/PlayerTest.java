package Tests;

import Colors.Text;
import Items.Component;
import Items.LaserGun;
import World.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for Player
 */
class PlayerTest {

    /**
     * Test addItem() by giving it null, a laser gun and 9 other items
     */
    @Test
    void addItem() {
        Player player = new Player();

        assertEquals(Text.color("No such item", 'r'), player.addItem(null));
        assertEquals(Text.color("You now have a Laser Gun!", 'g'), player.addItem(new LaserGun()));

        for(int i = 0; i < 8; i++) {
            assertEquals(Text.color("test item added to inventory", 'g'), player.addItem(new Component("test item")));
        }

        assertEquals(Text.color("Cannot take test item - inventory is full", 'y'), player.addItem(new Component("test item")));
    }

    /**
     * Checks output of damage() method by damaging player by 1 and then by 100, which should kill the player
     */
    @Test
    void damage() {
        Player player = new Player();

        assertEquals(Text.color("The alien shot you!\n", 'p') + Text.color("Your health is now 99/100!", 'o'), player.damage(1));
        assertEquals(Text.color("The alien shot you!\n", 'p') + Text.color("\nYou died...", 'd'), player.damage(100));
    }
}