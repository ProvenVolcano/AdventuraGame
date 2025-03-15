package Items;

public class Component extends Item {

    public Component(String name) {
        this.name = name;
        oneTimeUse = false;
    }

    @Override
    public String use() {
        return name;
    }
}
