package Interactables;

import World.*;

/**
 * Abstract class for object that the player can interact with but not pick up
 */
public abstract class Interactable {

    protected String name;
    protected int password;

    public abstract String interact();

    /**
     * Factory method, creates the appropriate object
     * @param name - name of the object
     * @param player - the player
     * @param world - the world
     * @return - the created Interactable object
     */
    public static Interactable factory(String name, Player player, World world) {
        return switch (name) {
            case "CS" -> new ControlStation(player);
            case "Core" -> new Core(player);
            case "Shuttle" -> new Shuttle(player, world);
            default -> new Crate(name, player);
        };
    }

    public String getName() {
        return name;
    }

    public void setPassword(int password) {
        this.password = password;
    }
}
