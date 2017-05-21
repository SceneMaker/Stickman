package de.dfki.stickman3D.mimic.util;

import javafx.scene.shape.Polygon;

public class RightBrowDEFAULT {

    public static Polygon createMaleBrow(Polygon currentPolygon, float step) {
        if (step == 20 || step == 0) {
            currentPolygon.getPoints().clear();
            currentPolygon.getPoints().addAll(
                    //  x   	y   	
                    0.0, 0.0, //Point 0
                    0.0, -5.0, //Point 1
                    -3.0, -7.0, //Point 2
                    -6.0, -8.0, //Point 3 
                    -13.0, -10.0, //Point 4
                    -20.0, -11.0, //Point 5
                    -25.0, -7.0, //Point 6
                    -30.0, -3.0, //Point 7
                    -30.0, 0.0, //Point 8
                    -25.0, -3.0, //Point 9
                    -20.0, -7.0, //Point 10
                    -13.0, -6.0, //Point 11
                    -6.0, -5.0, //Point 12
                    -3.0, -3.0 //Point 13
            );
        }
        return currentPolygon;
    }

    public static Polygon createFemaleBrow(Polygon currentPolygon, float step) {
        if (step == 20 || step == 0) {
            currentPolygon.getPoints().clear();
            currentPolygon.getPoints().addAll(
                    //  x   	y   	/////
                    0.0, 0.0, //Point 0
                    0.0, -3.0, //Point 1
                    -3.0, -6.0, //Point 2
                    -6.0, -8.0, //Point 3 
                    -13.0, -9.0, //Point 4
                    -20.0, -9.0, //Point 5
                    -25.0, -7.0, //Point 6
                    -30.0, -3.0, //Point 7
                    -30.0, 0.0, //Point 8
                    -25.0, -4.0, //Point 9
                    -20.0, -6.5, //Point 10
                    -13.0, -6.0, //Point 11
                    -6.0, -5.0, //Point 12
                    -3.0, -3.0 //Point 13
            );
        }
        return currentPolygon;
    }

}
