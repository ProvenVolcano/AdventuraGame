package Interactables;

public class ControlStation extends Interactable {

    public ControlStation() {
        name = "Control Station";
    }

    @Override
    public String interact() {
        return name;
    }
}
