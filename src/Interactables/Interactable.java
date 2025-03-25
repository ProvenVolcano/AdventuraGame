package Interactables;

import World.*;

public abstract class Interactable {

    protected String name;
    protected int password;

    public abstract String interact();

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
