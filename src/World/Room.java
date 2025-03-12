package World;

import java.util.ArrayList;

public class Room {

    private final int ID;
    private String name;
    private ArrayList<Integer> connections;

    public Room(String roomString) {

        connections = new ArrayList<>();

        String[] tokens = roomString.split(";");
        ID = Integer.parseInt(tokens[0]);
        name = tokens[1];

        String[] connectionString = tokens[2].split(",");
        for (int i = 0; i < connectionString.length; i++) {
            try {
                connections.add(Integer.parseInt(connectionString[i]));
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Integer> getConnections() {
        return connections;
    }

    public void setConnections(ArrayList<Integer> connections) {
        this.connections = connections;
    }
}
