package Items;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * The scheme of the alien spaceship
 */
public class Scheme extends Item {

    private StringBuilder map;

    /**
     * Loads the scheme from file
     */
    public Scheme() {
        oneTimeUse = false;
        name = "Map";
        color = 'b';
        map = new StringBuilder();

        String line;
        try {
            BufferedReader br = new BufferedReader(new FileReader("res\\alienShipScheme.txt"));
            while((line = br.readLine()) != null) {
                map.append(line + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Returns the scheme
     * @return - the scheme as a String
     */
    @Override
    public String use() {
        return map.toString();
    }
}
