package edu.school21.printer.app;

import com.beust.jcommander.JCommander;
import edu.school21.printer.logic.Logic;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class Main {

    private static BufferedImage image;
    private static final String IMAGE_PATH = "/resources/image.bmp";

    public static void main(String[] args) {

        Parser colors = new Parser();
        JCommander.newBuilder().addObject(colors).build().parse(args);

        try {
            image = ImageIO.read(File.class.getResource(IMAGE_PATH));
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        Logic logic = new Logic(colors.getWhitePixel(), colors.getBlackPixel());
        logic.printImage(image);
    }
}
