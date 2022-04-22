package edu.school21.printer.logic;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class Logic {
    private final char emptyPixel;
    private final char paintedPixel;

    public Logic(char whiteChar, char blackChar) {
        this.emptyPixel = whiteChar;
        this.paintedPixel = blackChar;
    }

    public void printImage(BufferedImage image)	{
        for (int i = 0; i < image.getHeight(); i++) {
            for (int j = 0; j < image.getWidth(); j++) {
                int pixel = image.getRGB(j, i);
                if (pixel == Color.BLACK.getRGB())	{
                    System.out.print(paintedPixel);
                } else if (pixel == Color.WHITE.getRGB()) {
                    System.out.print(emptyPixel);
                }
            }
            System.out.println();
        }
    }
}