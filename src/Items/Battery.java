package Items;

import World.Player;

public class Battery extends Item {

    private Player player;

    public Battery(Player player) {
        this.player = player;
        oneTimeUse = true;
        name = "Battery";
    }

    @Override
    public String use() {
        oneTimeUse = true;

        if(player.getGun() == null){
            oneTimeUse = false;
            return "Can't use this item now";
        }

        if(player.getGun().getPower() == 100) {
            oneTimeUse = false;
            return "Laser Gun power already full";
        }

        player.getGun().reload();
        return "Laser Gun battery changed";
    }
}
