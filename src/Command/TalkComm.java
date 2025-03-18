package Command;

import World.*;

import java.util.Scanner;

public class TalkComm extends Command {

    private World world;
    private Player player;
    private Scanner sc;

    public TalkComm(World world, Player player) {
        this.world = world;
        this.player = player;
        sc = new Scanner(System.in);
    }

    @Override
    public String execute() {
        if(player.isFighting()){
            return "Can't execute command while fighting an enemy\n" + player.damage(15);
        }

        if(world.getCurrentRoom().getCharactersString().isEmpty()){
            return "No one to talk to in this room";
        }

        System.out.println(world.getCurrentRoom().getCharactersString());
        String name = sc.nextLine();

        return world.getCurrentRoom().talkToCharacter(name);
    }

    @Override
    public boolean exit() {
        return false;
    }
}