import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class World {

    private HashMap<Integer, Room> rooms;
    private int startingRoom;
    private int currentRoom;

    public World(String filename) {
        rooms = new HashMap<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));

            while((br.readLine()) != null) {
                String line = br.readLine();
                Room room = new Room(line);
                rooms.put(room.getID(), room);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        startingRoom = 1;
        currentRoom = startingRoom;

    }
}
