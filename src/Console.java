import Command.*;
import World.*;

import java.util.HashMap;
import java.util.Scanner;

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
        commands.put("move", new MoveComm(world));
        commands.put("exit", new ExitComm());
        commands.put("help", new HelpComm(commands));
        commands.put("pick", new PickComm(world, player));
        commands.put("interact", new InteractComm(world));
        commands.put("use", new UseComm(player));
        commands.put("shoot", new ShootComm(world, player));
        commands.put("talk", new TalkComm(world));
        commands.put("throw", new ThrowComm(player, world));
        commands.put("reload", new ChangeComm(player));
    }

    public void start(){

        do {

            System.out.print("> ");
            String command = sc.nextLine();

            if(commands.containsKey(command)){
                System.out.println(commands.get(command).execute());
                exit = commands.get(command).exit();
            } else {
                System.out.println("No such command");
            }

        } while (!exit);
    }
}
