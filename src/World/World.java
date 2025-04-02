package World;

import Colors.*;
import Interactables.PassPanel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Class for the world, contains all the rooms and the players location
 */
public class World {

    private HashMap<Integer, Room> rooms;
    private Player player;
    private int currentRoom;

    /**
     * Loads the world, creates all rooms
     * @param filename - name of the world file
     * @param player - player object
     */
    public World(String filename, Player player) {
        rooms = new HashMap<>();
        this.player = player;
        ArrayList<Room> lockedRooms = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));

            String line;
            while((line = br.readLine()) != null) {
                Room room = new Room(line, player, this);
                rooms.put(room.getID(), room);

                if(!room.isOpen()) {
                    lockedRooms.add(room);
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (Room lockedRoom : lockedRooms) {
            rooms.get(lockedRoom.getPassPanelLocID()).getInteractables().put("Password Panel", new PassPanel(lockedRoom));
        }
        rooms.get(6).getCharacters().get("First Officer").setPassword(lockedRooms.get(0).getPassword());
        rooms.get(5).getInteractables().get("Control Station").setPassword(lockedRooms.get(1).getPassword());

        currentRoom = 1;
    }

    /**
     * Returns IDs and names of neighbouring rooms to the room the player is currently in
     * @return - the string of neighboring rooms
     */
    public String neighbouringRooms(){
        StringBuilder result = new StringBuilder();
        ArrayList<Integer> idk = rooms.get(currentRoom).getConnections();

        for(int i = 0; i < idk.size(); i++){
            result.append("    " + rooms.get(idk.get(i)).getID() + ". ").append(rooms.get(idk.get(i)).getName() + "\n");
        }

        return result.toString();
    }

    /**
     * Moves player to another room by changing currentRoom
     * @param roomID - ID of the room to move to
     * @return - message if the move was successful or not
     */
    public String moveToRoom(int roomID, boolean bypass) {
        if(bypass) {
            currentRoom = roomID;
            return rooms.get(currentRoom).entered();
        }

        if(roomID == 7 && player.isSavedCaptain()) {
            player.setAlive(false);
            return Text.color("Congratulations! You completed the game", 'c');
        }

        if(rooms.get(currentRoom).getConnections().contains(roomID) && rooms.containsKey(roomID) && rooms.get(roomID).isOpen()) {
            currentRoom = roomID;
            return rooms.get(currentRoom).entered();
        }
        return Text.color("Can't move to that room", 'r');

    }

    public Room getCurrentRoom() {
        return rooms.get(currentRoom);
    }
}
