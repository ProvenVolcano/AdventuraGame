package Items;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Scheme extends Item {

    private StringBuilder map;

    public Scheme() {
        oneTimeUse = false;
        name = "Map";
        color = 'b';
        map = new StringBuilder();

        String line;
        try {
            BufferedReader br = new BufferedReader(new FileReader("alienShipScheme.txt"));
            while((line = br.readLine()) != null) {
                map.append(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String use() {
        return map.toString();
    }
}
