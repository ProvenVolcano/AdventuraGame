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
        if(power < 20){
            return "Not enough power";
        }
        power -= 20;
        return name;
    }

}
