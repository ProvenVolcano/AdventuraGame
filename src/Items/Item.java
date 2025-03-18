package Items;

import World.*;

public abstract class Item {

    protected String name;
    protected boolean oneTimeUse;

    public abstract String use();

    public String getName() {
        return name;
    }

    public boolean isOneTimeUse() {
        return oneTimeUse;
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
