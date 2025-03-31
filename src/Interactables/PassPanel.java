package Interactables;

import World.Room;
import Colors.*;

import java.util.Scanner;

/**
 * Password panel that can unlock a room if given the right password
 */
public class PassPanel extends Interactable {

    private Room room;
    private Scanner sc;

    public PassPanel(Room room) {
        this.room = room;
        sc = new Scanner(System.in);
        name = "Password Panel";
    }

    /**
     * Makes the player enter a password, if it's correct it opens a room
     * @return
     */
    @Override
    public String interact() {
        System.out.print("Enter password: ");
        String pass = sc.nextLine();

        if(pass.equals(String.valueOf(room.getPassword()))) {
            room.setOpen(true);
            return Text.color(room.getName() + " unlocked", 'g');
        }
        return Text.color("Invalid Password", 'r');
    }
}
