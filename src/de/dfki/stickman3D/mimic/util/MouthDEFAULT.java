package de.dfki.stickman3D.mimic.util;

import javafx.scene.shape.Polygon;

public class MouthDEFAULT
{

    public static Polygon modifyUpperLip(Polygon currentUpperLipPolygon, float step)
    {
        if (step == 20 || step == 0)
        {
            currentUpperLipPolygon.getPoints().clear();
            currentUpperLipPolygon.getPoints().addAll(
                    //x 	y 
                    0.0, 0.0, // Point 0
                    4.5, -3.0, // Point 1
                    11.0, -5.0, // Point 2
                    16.0, -3.0, // Point 3
                    21.0, -5.0, // Point 4
                    27.5, -3.0, // Point 5
                    32.0, 0.0, // Point 6
                    27.5, 0.0, // Point 7
                    21.0, 0.0, // Point 8
                    16.0, 0.0, // Point 9
                    11.0, 0.0, // Point 10
                    4.5, 0.0 // Point 11
            );
        }
        return currentUpperLipPolygon;
    }

    public static Polygon modifyDownLip(Polygon currentDownLipPolygon, float step)
    {
        if (step == 20 || step == 0)
        {
            currentDownLipPolygon.getPoints().clear();
            currentDownLipPolygon.getPoints().addAll(
                    //x 	y 
                    0.0, 0.0, // Point 0
                    4.5, 3.0, // Point 1
                    13.0, 5.0, // Point 2
                    16.0, 3.0, // Point 3
                    19.0, 5.0, // Point 4
                    27.5, 3.0, // Point 5
                    32.0, 0.0, // Point 6
                    27.5, 0.0, // Point 7
                    19.0, 0.0, // Point 8
                    16.0, 0.0, // Point 9
                    13.0, 0.0, // Point 10
                    4.5, 0.0 // Point 11
            );
        }
        return currentDownLipPolygon;
    }

}
