package Command;

import Colors.Text;
import World.*;

import java.util.Random;

public class ShootComm extends Command {

    private World world;
    private Player player;
    private Random rd;

    public ShootComm(World world, Player player) {
        this.world = world;
        this.player = player;
        rd = new Random();
    }

    @Override
    public String execute() {
        if(player.getGun() == null){
            return Text.color("You don't have anything to shoot with", 'y');
        }

        String ret = "";
        if(player.getGun().getPower() < 20){
            ret += Text.color("Not enough power!", 'r');
            if(player.isFighting()){
                ret += player.damage(15);
            }
            return ret;
        }
        ret += world.getCurrentRoom().shootAlien(rd.nextInt(15) + 20);
        ret += player.getGun().use();
        if(player.isFighting()){
            ret += player.damage(15);
        }
        return ret;
    }

    @Override
    public boolean exit() {
        return false;
    }
}