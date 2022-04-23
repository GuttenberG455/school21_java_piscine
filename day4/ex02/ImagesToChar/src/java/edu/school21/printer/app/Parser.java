package edu.school21.printer.app;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

@Parameters(separators = "=")

public class Parser {

    @Parameter(names = {"--whitePixel", "--white"})
    private String whitePixel;
    @Parameter(names = {"--blackPixel", "--black"})
    private String blackPixel;


    public String getWhitePixel() {
        return whitePixel;
    }

    public String getBlackPixel() {
        return blackPixel;
    }
}
