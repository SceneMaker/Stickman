package de.dfki.stickman3D.mimic.util;

import javafx.scene.shape.Polygon;

public class FaceWrinkleANGRY
{

    public static Polygon getLeftANGRY(Polygon currentPolygon, int step)
    {
        if (step == 20)
        {
            currentPolygon.getPoints().addAll(
                    0.0, 0.0,
                    1.0, 0.0,
                    0.3, -2.0,
                    0.0, -4.0,
                    -0.4, -6.0,
                    0.0, -8.0,
                    0.3, -10.0,
                    1.0, -12.0,
                    0.0, -12.0,
                    -0.5, -10.0,
                    -1.0, -8.0,
                    -1.3, -6.0,
                    -1.0, -4.0,
                    -0.5, -2.0
            );
        }
        return currentPolygon;
    }

    public static Polygon getRightANGRY(Polygon currentPolygon, int step)
    {
        if (step == 20)
        {
            currentPolygon.getPoints().addAll(
                    -1.0, 0.0,
                    0.0, 0.0,
                    0.5, -2.0,
                    1.0, -4.0,
                    1.3, -6.0,
                    1.0, -8.0,
                    0.5, -10.0,
                    0.0, -12.0,
                    -1.0, -12.0,
                    -0.3, -10.0,
                    0.0, -8.0,
                    0.4, -6.0,
                    0.0, -4.0,
                    -0.3, -2.0
            );
        }
        return currentPolygon;
    }

}
