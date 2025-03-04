import java.util.HashMap;
import java.util.Scanner;

public class Console {

    private World world;
    private HashMap<String, Command> commands;
    private boolean exit;
    private Scanner sc;

    public Console() {

        world = new World("world.txt");

        exit = false;
        sc = new Scanner(System.in);

        commands = new HashMap<>();
        commands.put("move", new MoveComm(world));
    }

    public void start(){

        do {

            System.out.print("> ");
            String command = sc.next();

            if(commands.containsKey(command)){
                System.out.println(commands.get(command).execute());
                exit = commands.get(command).exit();
            } else {
                System.out.println("No such command");
            }

        } while (!exit);
    }
}
