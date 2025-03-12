package Items;

public class LaserGun extends Item {

    private int power;

    public LaserGun() {
        power = 100;
        name = "Laser Gun";
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public String use() {
        return "";
    }

}
