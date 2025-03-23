package Interactables;

import World.Player;

public abstract class Interactable {

    protected String name;
    public abstract String interact();

    public static Interactable factory(String name, Player player) {
        return switch (name) {
            case "CS" -> new ControlStation();
            case "Core" -> new Core(player);
            case "Shuttle" -> new Shuttle(player);
            default -> new Crate(name, player);
        };
    }

    public String getName() {
        return name;
    }
}
