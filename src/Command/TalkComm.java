package Command;

import Colors.Text;
import World.*;

import java.util.Scanner;

/**
 * Command to talk to other characters
 */
public class TalkComm extends Command {

    private World world;
    private Player player;
    private Scanner sc;

    public TalkComm(World world, Player player) {
        this.world = world;
        this.player = player;
        sc = new Scanner(System.in);
    }

    /**
     * Lists characters in a room and talks with one that the player says
     * @return - dialog of the character
     */
    @Override
    public String execute() {
        if(player.isFighting()){
            return Text.color("Can't execute command while fighting an enemy\n" + player.damage(15), 'r');
        }

        if(world.getCurrentRoom().getCharactersString().isEmpty()){
            return Text.color("No one to talk to in this room", 'y');
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