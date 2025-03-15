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

    public Room(String roomString, Player player) {

        connections = new ArrayList<>();
        characters = new HashMap<>();
        items = new HashMap<>();
        interactables = new HashMap<>();

        String[] tokens = roomString.split(";");
        ID = Integer.parseInt(tokens[0]);
        name = tokens[1];

        createConnections(tokens);
        createItems(tokens, player);
        createInteractables(tokens, player);
    }

    private void createConnections(String[] tokens) {
        if(tokens[2].isBlank()){
            return;
        }

        String[] connectionString = tokens[2].split(",");
        for (int i = 0; i < connectionString.length; i++) {
            try {
                connections.add(Integer.parseInt(connectionString[i]));
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void createItems(String[] tokens, Player player) {
        if(tokens[3].isBlank()){
            return;
        }

        String[] itemString = tokens[3].split(",");
        for (int i = 0; i < itemString.length; i++) {
            try {
                items.put(itemString[i], Item.factory(itemString[i], player));
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    private void createInteractables(String[] tokens, Player player) {
        if(tokens[4].isBlank()){
            return;
        }

        String[] interactableString = tokens[4].split(",");
        for (int i = 0; i < interactableString.length; i++) {
            try {
                Interactable temp = Interactable.factory(interactableString[i], player);
                interactables.put(temp.getName(), temp);
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    public HashMap<String, Character> getCharacters() {
        return characters;
    }

    public void setCharacters(HashMap<String, Character> characters) {
        this.characters = characters;
    }

    public String getItemsString() {

        StringBuilder string = new StringBuilder();

        for (String name : items.keySet()){
            string.append("    " + name + "\n");
        }

        return string.toString();
    }

    public Item getItem(String item) {
        Item i = items.get(item);
        items.remove(item);
        return i;
    }

    public void setItems(HashMap<String, Item> items) {
        this.items = items;
    }

    public String getInteractablesString() {
        StringBuilder string = new StringBuilder();

        for (String name : interactables.keySet()){
            string.append("    " + name + "\n");
        }

        return string.toString();
    }

    public HashMap<String, Interactable> getInteractables() {
        return interactables;
    }

    public void setInteractables(HashMap<String, Interactable> interactables) {
        this.interactables = interactables;
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
