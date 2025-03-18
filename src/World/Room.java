package World;

import Characters.Character;
import Interactables.*;
import Items.*;

import java.util.ArrayList;
import java.util.HashMap;

public class Room {

    private final int ID;
    private String name;
    private HashMap<String, Characters.Character> characters;
    private ArrayList<Integer> connections;
    private ArrayList<Item> items;
    private HashMap<String, Interactable> interactables;
    private Player player;

    public Room(String roomString, Player player) {

        connections = new ArrayList<>();
        characters = new HashMap<>();
        items = new ArrayList<>();
        interactables = new HashMap<>();
        this.player = player;

        String[] tokens = roomString.split(";");
        ID = Integer.parseInt(tokens[0]);
        name = tokens[1];

        createConnections(tokens);
        createItems(tokens);
        createInteractables(tokens);
        createCharacters(tokens);
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

    private void createItems(String[] tokens) {
        if(tokens[3].isBlank()){
            return;
        }

        String[] itemString = tokens[3].split(",");
        for (int i = 0; i < itemString.length; i++) {
            try {
                items.add(Item.factory(itemString[i], player));
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    private void createInteractables(String[] tokens) {
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

    private void createCharacters(String[] tokens) {
        if(tokens[5].isBlank()){
            return;
        }

        String[] characterString = tokens[5].split(",");
        for (int i = 0; i < characterString.length; i++) {
            Characters.Character c = Character.factory(characterString[i], player);
            if(c != null){
                characters.put(c.getName(), c);
            }
        }
    }

    public String talkToCharacter(String name) {
        if(characters.containsKey(name)){
            return characters.get(name).talk();
        }
        return "No such person in this room";
    }

    public String getCharactersString() {
        StringBuilder string = new StringBuilder();

        for (String name : characters.keySet()){
            string.append("    " + name + "\n");
        }

        return string.toString();
    }

    public void setCharacters(HashMap<String, Character> characters) {
        this.characters = characters;
    }

    public String getItemsString() {

        StringBuilder string = new StringBuilder();

        for (Item item : items) {
            string.append("    " + item.getName() + "\n");
        }

        return string.toString();
    }

    public Item getItem(String item) {
        for(Item item1 : items){
            if(item1.getName().equals(item)) {
                if(player.inventoryFree()){
                    items.remove(item1);
                }
                return item1;
            }
        }
        return null;
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
