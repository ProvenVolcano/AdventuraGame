package Items;

public class Component extends Item {

    public Component(String name) {
        this.name = name;
    }

    @Override
    public String use() {
        return name;
    }
}
