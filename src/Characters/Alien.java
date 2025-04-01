package Characters;

import java.util.Random;

/**
 * Class for an enemy alien that fights with the player
 */
public class Alien extends Character {

    private int hp;
    private Random rd;

    public Alien() {
        super("");
        name = "Alien";
        rd = new Random();
        hp = rd.nextInt(40) + 60;
    }

    /**
     * Decreases hp
     * @param dmg - how much to decrease hp
     * @return - true if hp > 0
     */
    public boolean damage(int dmg) {
        hp -= dmg;
        return hp > 0;
    }

    @Override
    public String talk() {
        return "";
    }
}
