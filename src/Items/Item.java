package Items;

import World.Player;

public abstract class Item {

    protected String name;

    public abstract String use();

    public String getName() {
        return name;
    }

    public static Item factory(String name, Player player){

        return switch (name) {
            case "Laser Gun" -> new LaserGun();
            case "Battery" -> new Battery(player);
            case "Bandages" -> new Bandages(player);
            default -> new Component(name);
        };
    }
}
