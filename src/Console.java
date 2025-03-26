import Colors.Text;
import Command.*;
import World.*;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Main class, handles the whole game and commands input
 */
public class Console {

    private World world;
    private Player player;
    private HashMap<String, Command> commands;
    private boolean exit;
    private Scanner sc;

    public Console() {

        player = new Player();
        world = new World("world.txt", player);

        exit = false;
        sc = new Scanner(System.in);

        commands = new HashMap<>();
        commands.put("move", new MoveComm(world, player));
        commands.put("exit", new ExitComm());
        commands.put("help", new HelpComm(commands));
        commands.put("pick", new PickComm(world, player));
        commands.put("interact", new InteractComm(world, player));
        commands.put("use", new UseComm(player));
        commands.put("shoot", new ShootComm(world, player));
        commands.put("talk", new TalkComm(world, player));
        commands.put("throw", new ThrowComm(player, world));
        commands.put("reload", new ChangeComm(player));
        commands.put("open", new OpenComm(world, player));
    }

    /**
     * Starts the game, loops command input until player exits, wins or dies
     */
    public void start(){

        do {

            System.out.print("> ");
            String command = sc.nextLine();

            if(commands.containsKey(command)){
                System.out.println(commands.get(command).execute());
                exit = commands.get(command).exit();
            } else {
                System.out.println(Text.color("No such command", 'r'));
            }

        } while (!exit && player.isAlive());
        sc.close();
    }
}
