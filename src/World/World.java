package World;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class World {

    private HashMap<Integer, Room> rooms;
    private int currentRoom;

    public World(String filename) {
        rooms = new HashMap<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));

            String line;
            while((line = br.readLine()) != null) {
                Room room = new Room(line);
                rooms.put(room.getID(), room);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        currentRoom = 1;
    }

    public String neighbouringRooms(){
        StringBuilder result = new StringBuilder();
        ArrayList<Integer> idk = rooms.get(currentRoom).getConnections();

        for(int i = 0; i < idk.size(); i++){
            result.append(rooms.get(idk.get(i)).getID() + ". ").append(rooms.get(idk.get(i)).getName() + "\n");
        }

        return result.toString();
    }

    public String moveToRoom(int roomID) {
        if(rooms.get(currentRoom).getConnections().contains(roomID) && rooms.containsKey(roomID)) {
            currentRoom = roomID;
            return "Moved to " + rooms.get(currentRoom).getName();
        }
        return "Can't move to that room";

    }

    public HashMap<Integer, Room> getRooms() {
        return rooms;
    }

    public void setRooms(HashMap<Integer, Room> rooms) {
        this.rooms = rooms;
    }

    public Room getCurrentRoom() {
        return rooms.get(currentRoom);
    }

    public void setCurrentRoom(int currentRoom) {
        this.currentRoom = currentRoom;
    }
}
