package World;

import Characters.Alien;
import Characters.Character;
import Colors.Text;
import Interactables.*;
import Items.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * Class for a room, contains all the stuff that's in a room
 */
public class Room {

    private final int ID;
    private String name;
    private boolean open;
    private int password;
    private int passPanelLocID;
    private HashMap<String, Characters.Character> characters;
    private ArrayList<Integer> connections;
    private ArrayList<Item> items;
    private HashMap<String, Interactable> interactables;
    private ArrayList<Crate> crates;
    private Player player;
    private World world;
    private Alien alien;
    private Random rd;
    private int chance;

    public Room(String roomString, Player player, World world) {

        connections = new ArrayList<>();
        characters = new HashMap<>();
        items = new ArrayList<>();
        interactables = new HashMap<>();
        crates = new ArrayList<>();
        this.player = player;
        this.world = world;
        rd = new Random();

        String[] tokens = roomString.split(";");
        ID = Integer.parseInt(tokens[0]);
        name = tokens[1];
        open = Boolean.parseBoolean(tokens[7]);
        chance = Integer.parseInt(tokens[8]);

        if(!open) {
            password = rd.nextInt(9000)+1000;
            passPanelLocID = Integer.parseInt(tokens[7]);
        }

        createConnections(tokens);
        createItems(tokens);
        createInteractables(tokens);
        createCharacters(tokens);
        createCrates(tokens);
    }

    /**
     * Adds IDs of rooms connecting to this room
     * @param tokens - the values of the room
     */
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

    /**
     * Adds items in the room
     * @param tokens - the values of the room
     */
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

    /**
     * Adds interactable objects in the room
     * @param tokens - the values of the room
     */
    private void createInteractables(String[] tokens) {
        if(tokens[4].isBlank()){
            return;
        }

        String[] interactableString = tokens[4].split(",");
        for (int i = 0; i < interactableString.length; i++) {
            try {
                Interactable temp = Interactable.factory(interactableString[i], player, world);
                interactables.put(temp.getName(), temp);
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    /**
     * Adds characters to the room
     * @param tokens - the values of the room
     */
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

    /**
     * Adds crates to the room
     * @param tokens - the values of the room
     */
    private void createCrates(String[] tokens) {
        if(tokens[6].isBlank()){
            return;
        }

        String[] cratesString = tokens[6].split(",");
        for (int i = 0; i < cratesString.length; i++) {
            try {
                crates.add(new Crate(cratesString[i], player));
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Returns the names of the crates in this room
     * @return - the names string
     */
    public String cratesString() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < crates.size(); i++) {
            sb.append((i + 1) + ". " + crates.get(i).getName() + "\n");
        }
        return sb.toString();
    }

    public ArrayList<Crate> getCrates() {
        return crates;
    }

    /**
     * Returns the dialog of a character
     * @param name - the name of the character to talk to
     * @return - the character's dialog
     */
    public String talkToCharacter(String name) {
        if(characters.containsKey(name)){
            return characters.get(name).talk();
        }
        return Text.color("No such person in this room", 'r');
    }

    /**
     * Returns names of characters in the room
     * @return - the names string
     */
    public String getCharactersString() {
        StringBuilder string = new StringBuilder();

        for (String name : characters.keySet()){
            string.append("    " + name + "\n");
        }

        return string.toString();
    }

    /**
     * Returns items in this room
     * @return - the items string
     */
    public String getItemsString() {

        StringBuilder string = new StringBuilder();

        for (Item item : items) {
            string.append("    " + Text.color(item.getName(), item.getColor()) + "\n");
        }

        return string.toString();
    }

    /**
     * Returns an item object from the inventory and removes it from the inventory
     * @param item - name of the item
     * @return - the item object
     */
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

    /**
     * Returns names of interactable objects in the room
     * @return - the objects string
     */
    public String getInteractablesString() {
        StringBuilder string = new StringBuilder();

        for (String name : interactables.keySet()){
            string.append("    " + name + "\n");
        }

        return string.toString();
    }

    /**
     * Gets called when player moves in a room, handles the spawning of aliens
     * @return - move message and whether an alien spawned.
     */
    public String entered(){
        player.setFighting(alien != null);
        String ret = moveMessage();

        if(alien != null){
            return ret + Text.color("\nTHERE IS AN ALIEN! QUICK, SHOOT HIM!", 'p');
        }

        if(rd.nextInt(10) < chance) {
            alien = new Alien();
            player.setFighting(true);
            ret += Text.color("\nTHERE IS AN ALIEN! QUICK, SHOOT HIM!", 'p');
        }

        return ret;
    }

    /**
     * Returns a move message which is displayed when player enters a room
     * @return
     */
    private String moveMessage() {
        return Text.color("Moved to " + name, 'g');
    }

    public String shootAlien(int dmg) {
        if(alien == null){
            return Text.color("Phew!\n", 'o');
        }

        if(alien.damage(dmg)){
            return Text.color("You shot the alien, it's still alive!\n", 'y');
        }
        player.setFighting(false);
        alien = null;
        return Text.color("You shot the alien, he died!\n", 'g');
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public HashMap<String, Interactable> getInteractables() {
        return interactables;
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

    public void setOpen(boolean open) {
        this.open = open;
    }

    public boolean isOpen() {
        return open;
    }

    public HashMap<String, Character> getCharacters() {
        return characters;
    }

    public int getPassword() {
        return password;
    }

    public int getPassPanelLocID() {
        return passPanelLocID;
    }
}
