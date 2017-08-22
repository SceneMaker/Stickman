package de.dfki.stickman3D.mimic.util;

import javafx.scene.shape.Polygon;

public class MouthFIVE
{

    public static Polygon modifyUpperLip(Polygon currentUpperLipPolygone, float step)
    {
        if (step == 20 || step == 0)
        {
            currentUpperLipPolygone.getPoints().clear();
            currentUpperLipPolygone.getPoints().addAll(
                    // x 	y 
                    0.0, 0.0, // Point 0
                    4.5, -3.0, // Point 1
                    11.0, -6.0, // Point 2
                    16.0, -7.0, // Point 3
                    21.0, -6.0, // Point 4
                    27.5, -3.0, // Point 5
                    32.0, 0.0, // Point 6
                    27.5, 0.0, // Point 7
                    21.0, -3.0, // Point 8
                    16.0, -4.0, // Point 9
                    11.0, -3.0, // Point 10
                    4.5, 0.0 // Point 11
            );
        }
        return currentUpperLipPolygone;
    }

    public static Polygon modifyDownLip(Polygon currentDownLipPolygon, float step)
    {

        if (step == 20 || step == 0)
        {
            currentDownLipPolygon.getPoints().clear();
            currentDownLipPolygon.getPoints().addAll(
                    // x 	y 
                    0.0, 0.0, // Point 0
                    4.5, 3.0, // Point 1
                    11.0, 6.0, // Point 2
                    16.0, 7.0, // Point 3
                    21.0, 6.0, // Point 4
                    27.5, 3.0, // Point 5
                    32.0, 0.0, // Point 6
                    27.5, 0.0, // Point 7
                    21.0, 3.0, // Point 8
                    16.0, 4.0, // Point 9
                    11.0, 3.0, // Point 10
                    4.5, 0.0 // Point 11
            );
        }
        return currentDownLipPolygon;
    }

}
