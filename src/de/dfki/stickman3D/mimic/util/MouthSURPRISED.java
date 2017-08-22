package de.dfki.stickman3D.mimic.util;

import javafx.scene.shape.Polygon;

public class MouthSURPRISED
{

    public static Polygon modifyUpperLip(Polygon currentUpperLipPolygon, float step, String sign)
    {
        int sig;

        if (sign.equalsIgnoreCase("PLUS"))
        {
            sig = 1;
        } else
        {
            sig = -1;
        }

        double y1;
        double y2;
        double y3;
        double y8;

        y1 = sig * (20 - step) * 0.01052631578947368;
        y2 = sig * (20 - step) * 0.02105263157894737;
        y3 = sig * (20 - step) * 0.03684210526315789;
        y8 = sig * (20 - step) * 0.03157894736842105;

        currentUpperLipPolygon.getPoints().set(3, currentUpperLipPolygon.getPoints().get(3) - y1);
        currentUpperLipPolygon.getPoints().set(5, currentUpperLipPolygon.getPoints().get(5) - y2);
        currentUpperLipPolygon.getPoints().set(7, currentUpperLipPolygon.getPoints().get(7) - y3);
        currentUpperLipPolygon.getPoints().set(9, currentUpperLipPolygon.getPoints().get(9) - y2);
        currentUpperLipPolygon.getPoints().set(11, currentUpperLipPolygon.getPoints().get(11) - y1);

        currentUpperLipPolygon.getPoints().set(17, currentUpperLipPolygon.getPoints().get(17) - y8);
        currentUpperLipPolygon.getPoints().set(19, currentUpperLipPolygon.getPoints().get(19) - y3);
        currentUpperLipPolygon.getPoints().set(21, currentUpperLipPolygon.getPoints().get(21) - y8);

        return currentUpperLipPolygon;
    }

    public static Polygon modifyDownLip(Polygon currentDownLipPolygon, float step, String sign)
    {
        int sig;

        if (sign.equalsIgnoreCase("PLUS"))
        {
            sig = 1;
        } else
        {
            sig = -1;
        }

        double y1;
        double y2;
        double y3;
        double y8;

        y1 = sig * (20 - step) * 0.01052631578947368;
        y2 = sig * (20 - step) * 0.02105263157894737;
        y3 = sig * (20 - step) * 0.03684210526315789;
        y8 = sig * (20 - step) * 0.03157894736842105;

        currentDownLipPolygon.getPoints().set(3, currentDownLipPolygon.getPoints().get(3) + y1);
        currentDownLipPolygon.getPoints().set(5, currentDownLipPolygon.getPoints().get(5) + y2);
        currentDownLipPolygon.getPoints().set(7, currentDownLipPolygon.getPoints().get(7) + y3);
        currentDownLipPolygon.getPoints().set(9, currentDownLipPolygon.getPoints().get(9) + y2);
        currentDownLipPolygon.getPoints().set(11, currentDownLipPolygon.getPoints().get(11) + y1);

        currentDownLipPolygon.getPoints().set(17, currentDownLipPolygon.getPoints().get(17) + y8);
        currentDownLipPolygon.getPoints().set(19, currentDownLipPolygon.getPoints().get(19) + y3);
        currentDownLipPolygon.getPoints().set(21, currentDownLipPolygon.getPoints().get(21) + y8);

        return currentDownLipPolygon;
    }

}
