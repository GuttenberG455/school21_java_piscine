package ex00;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MapParser {
    private final Scanner scanner;
    private final char COMMA = ',';

    public MapParser(File input) throws FileNotFoundException {
        this.scanner = new Scanner(input);
    }

    public String readLine() {
        if (scanner.hasNextLine()) {
            return scanner.nextLine();
        }
        return "";
    }

    private String getValue(String line) {
        return line.substring(0, line.indexOf(this.COMMA));
    }

    private String getKey(String line) {
        return line.substring(line.indexOf(COMMA) + 2);
    }

    private static int countBytes(String key) {
        int count = 0;

        Scanner keyParser = new Scanner(key).useRadix(16);

        while (keyParser.hasNextShort()) {
            keyParser.nextShort();
            count++;
        }
        keyParser.close();
        return (count);
    }

    private static short[] convertKeyToShort(String key) {
        int count = countBytes(key);
        short[] res = new short[count];

        Scanner keyParser = new Scanner(key).useRadix(16);

        for (int i = 0; i < count; i++) {
            res[i] = keyParser.nextShort();
        }
        return res;
    }

    public Map<short[], String> parseInput() {
        Map<short[], String> res = new HashMap<>();
        String line = this.readLine();

        while (!line.isEmpty()) {
            short[] keys = convertKeyToShort(getKey(line));
            String value = getValue(line);
            if (keys.length > 0 && !value.isEmpty()) {
                res.put(keys, value);
            }
            line = this.readLine();
        }
        return res;
    }
}
