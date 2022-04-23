package edu.school21.printer.logic;

import java.awt.Color;
import com.diogonunes.jcdp.color.api.Ansi;
import com.diogonunes.jcdp.color.ColoredPrinter;
import java.awt.image.BufferedImage;

public class Logic {
    private final Ansi.BColor whitePixel;
    private final Ansi.BColor blackPixel;

    public Ansi.BColor getColorByStr(String colorStr) {
        switch (colorStr) {
            case "BLACK":
                return Ansi.BColor.BLACK;
            case "RED":
                return Ansi.BColor.RED;
            case "GREEN":
                return Ansi.BColor.GREEN;
            case "YELLOW":
                return Ansi.BColor.YELLOW;
            case "BLUE":
                return Ansi.BColor.BLUE;
            case "MAGENTA":
                return Ansi.BColor.MAGENTA;
            case "CYAN":
                return Ansi.BColor.CYAN;
            case "WHITE":
                return Ansi.BColor.WHITE;
            default:
                throw new IllegalStateException("Unexpected value: " + colorStr);
        }
    }

    public Logic(String whitePixel, String blackPixel) {
        this.whitePixel = getColorByStr(whitePixel);
        this.blackPixel = getColorByStr(blackPixel);
    }

    public void printImage(BufferedImage image)	{

        ColoredPrinter printer = new ColoredPrinter.Builder(1, false)
                .foreground(Ansi.FColor.WHITE).background(this.whitePixel)
                .build();

        for (int i = 0; i < image.getHeight(); i++) {
            for (int j = 0; j < image.getWidth(); j++) {
                int pixel = image.getRGB(j, i);
                if (pixel == Color.BLACK.getRGB())	{
                    printer.print(" ", Ansi.Attribute.NONE, Ansi.FColor.NONE,  this.blackPixel);
                } else if (pixel == Color.WHITE.getRGB()) {
                    printer.print(" ", Ansi.Attribute.NONE, Ansi.FColor.NONE,  this.whitePixel);
                }
            }
            System.out.println();
        }
    }
}