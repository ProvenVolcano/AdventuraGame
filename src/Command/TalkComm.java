package Command;

import World.World;

import java.util.Scanner;

public class TalkComm extends Command {

    private World world;
    private Scanner sc;

    public TalkComm(World world) {
        this.world = world;
        sc = new Scanner(System.in);
    }

    @Override
    public String execute() {
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