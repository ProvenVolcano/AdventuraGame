package Items;

import Colors.*;

public class Component extends Item {

    public Component(String name) {
        this.name = name;
        color = 'o';
        oneTimeUse = false;
    }

    @Override
    public String use() {
        return Text.color("Can't use this item now", 'y');
    }
}
