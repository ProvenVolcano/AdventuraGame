package Items;

import Colors.*;

/**
 * Class for items needed for the repair of the power core
 */
public class Component extends Item {

    public Component(String name) {
        this.name = name;
        color = 'o';
        oneTimeUse = false;
    }

    /**
     * Items of this class don't have any special use functionality
     * @return - message that the item can't be used
     */
    @Override
    public String use() {
        return Text.color("Can't use this item now", 'y');
    }
}
