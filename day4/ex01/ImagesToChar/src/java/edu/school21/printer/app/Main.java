package edu.school21.printer.app;

import edu.school21.printer.logic.Logic;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Main {

    private static BufferedImage image;
    private static final String IMAGE_PATH = "/resources/image.bmp";

    public static void main(String[] args) {

        if (args.length < 2 || args[0].length() > 1 || args[1].length() > 1) {
            System.err.println("Incorrect arguments");
            System.exit(-1);
        }

        char emptyPixel = args[0].charAt(0);
        char paintedPixel = args[1].charAt(0);

        try {
            image = ImageIO.read(File.class.getResource(IMAGE_PATH));
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        Logic logic = new Logic(emptyPixel, paintedPixel);
        logic.printImage(image);
    }
}
