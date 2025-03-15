package Interactables;

public class PassPanel extends Interactable {

    public PassPanel() {
        name = "Password Panel";
    }

    @Override
    public String interact() {
        return name;
    }
}
