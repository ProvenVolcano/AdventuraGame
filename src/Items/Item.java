package Items;

public abstract class Item {

    protected String name;

    public abstract String use();

    public String getName() {
        return name;
    }
}
