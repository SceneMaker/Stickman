package de.dfki.reeti.timeline;

import org.jetbrains.annotations.Contract;

/**
 * Created by EmpaT on 20.04.2017.
 */
public class Converter {

    //Pixelanzahl zwischen jeden 2 Sekunden beträgt 200 pixel
    private static final int PIXEL_INTERVAL = 200;
    private static final int SECOND_INTERVAL = 2;

    public static int SecondToPixel(double sec)
    {
        double pixel = (sec * PIXEL_INTERVAL)/SECOND_INTERVAL;
        return (int) pixel;
    }
}
