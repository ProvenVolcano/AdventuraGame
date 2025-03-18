package Items;

public class LaserGun extends Item {

    private int power;

    public LaserGun() {
        power = 100;
        name = "Laser Gun";
        oneTimeUse = false;
    }

    public int getPower() {
        return power;
    }

    public void reload() {
        power = 100;
    }

    @Override
    public String use() {
        power -= 20;
        return "Laser gun power is now " + power + "/100\n";
    }

}
