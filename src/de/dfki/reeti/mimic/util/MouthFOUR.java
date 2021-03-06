package de.dfki.reeti.mimic.util;

import javafx.scene.shape.Polygon;

public class MouthFOUR {

    public static Polygon modifyUpperLip(Polygon currentDownLipPolygon, float step) {
        System.out.println("dsdsd");
        if (step == 20 || step == 0) {
            currentDownLipPolygon.getPoints().clear();
            currentDownLipPolygon.getPoints().addAll(
                    // x 	y 
                    0.0, 0.0, // Point 0
                    4.5, -3.0, // Point 1
                    11.0, -5.0, // Point 2
                    16.0, -5.0, // Point 3
                    21.0, -5.0, // Point 4
                    27.5, -3.0, // Point 5
                    32.0, 0.0, // Point 6
                    27.5, 0.0, // Point 7
                    21.0, -2.0, // Point 8
                    16.0, -2.0, // Point 9
                    11.0, -2.0, // Point 10
                    4.5, 0.0 // Point 11
            );
        }
        return currentDownLipPolygon;
    }

    public static Polygon modifyDownLip(Polygon currentDownLipPolygon, float step) {

        if (step == 20 || step == 0) {
            currentDownLipPolygon.getPoints().clear();
            currentDownLipPolygon.getPoints().addAll(
                    // x 	y 
                    0.0, 0.0, // Point 0
                    4.5, 3.0, // Point 1
                    11.0, 7.0, // Point 2
                    16.0, 8.0, // Point 3
                    21.0, 7.0, // Point 4
                    27.5, 3.0, // Point 5
                    32.0, 0.0, // Point 6
                    27.5, 0.0, // Point 7
                    21.0, 4.0, // Point 8
                    16.0, 5.0, // Point 9
                    11.0, 4.0, // Point 10
                    4.5, 0.0 // Point 11
            );
        }
        return currentDownLipPolygon;
    }

}
