package Characters;

import java.util.Random;

public class Alien extends Character {

    private int hp;
    private Random rd;

    public Alien() {
        super("");
        name = "Alien";
        rd = new Random();
        hp = rd.nextInt(40) + 60;
    }

    public boolean damage(int dmg) {
        hp -= dmg;
        return hp > 0;
    }

    @Override
    public String talk() {
        return "";
    }
}
