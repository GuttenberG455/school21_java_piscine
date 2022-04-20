package ex00;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
public class Main {

    private static final String SIGNATURES = "/Users/majacqua/Documents/Day2_IJ/src/ex00/signatures.txt";
    private static final String OUTFILE = "output.txt";

    public static void main(String[] args) throws IOException {

        FileInputStream inputStream = new FileInputStream(SIGNATURES);
        FileOutputStream outputStream = new FileOutputStream(OUTFILE);

        MapParser mapParser = new MapParser(new File(SIGNATURES));

        Map<short[], String> signaturesMap = mapParser.parseInput();

        List<String> resultList = new FileSignatureParser().getResultingTypes(signaturesMap);

        for (String line : resultList) {
            outputStream.write((line + '\n').getBytes(StandardCharsets.UTF_8));
        }
    }
}
