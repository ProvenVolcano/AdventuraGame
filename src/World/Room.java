package World;

import Interactables.*;
import Items.*;

import java.util.ArrayList;
import java.util.HashMap;

public class Room {

    private final int ID;
    private String name;
    private HashMap<String, Character> characters;
    private ArrayList<Integer> connections;
    private HashMap<String, Item> items;
    private HashMap<String, Interactable> interactables;

    public Room(String roomString) {

        connections = new ArrayList<>();
        characters = new HashMap<>();

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

    public HashMap<String, Character> getCharacters() {
        return characters;
    }

    public void setCharacters(HashMap<String, Character> characters) {
        this.characters = characters;
    }

    public ArrayList<Integer> getConnections() {
        return connections;
    }

    public void setConnections(ArrayList<Integer> connections) {
        this.connections = connections;
    }
}
