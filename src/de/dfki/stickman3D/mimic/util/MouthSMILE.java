package de.dfki.stickman3D.mimic.util;

import javafx.scene.shape.Polygon;

public class MouthSMILE
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

        double x0;
        double y0;
        double y1;
        double y2;

        x0 = sig * (20 - step) * 0.01578947368421053;
        y0 = sig * (20 - step) * 0.03157894736842105;
        y1 = sig * (20 - step) * 0.00526315789473684;
        y2 = sig * (20 - step) * 0.01052631578947368;

        currentUpperLipPolygon.getPoints().set(0, currentUpperLipPolygon.getPoints().get(0) - x0);
        currentUpperLipPolygon.getPoints().set(1, currentUpperLipPolygon.getPoints().get(1) - y0);
        currentUpperLipPolygon.getPoints().set(3, currentUpperLipPolygon.getPoints().get(3) - y1);
        currentUpperLipPolygon.getPoints().set(5, currentUpperLipPolygon.getPoints().get(5) + y2);
        currentUpperLipPolygon.getPoints().set(9, currentUpperLipPolygon.getPoints().get(9) + y2);
        currentUpperLipPolygon.getPoints().set(11, currentUpperLipPolygon.getPoints().get(11) - y1);
        currentUpperLipPolygon.getPoints().set(12, currentUpperLipPolygon.getPoints().get(12) + x0);
        currentUpperLipPolygon.getPoints().set(13, currentUpperLipPolygon.getPoints().get(13) - y0);

        return currentUpperLipPolygon;
    }

    public static Polygon modifyDownLip(Polygon currentDownLipMesh, float step, String sign)
    {
        int sig;

        if (sign.equalsIgnoreCase("PLUS"))
        {
            sig = 1;
        } else
        {
            sig = -1;
        }

        double x0;
        double y0;
        double y1;
        double y2;

        x0 = sig * (20 - step) * 0.01578947368421053;
        y0 = sig * (20 - step) * 0.03157894736842105;
        y1 = sig * (20 - step) * 0.01052631578947368;
        y2 = sig * (20 - step) * 0.00526315789473684;

        currentDownLipMesh.getPoints().set(0, currentDownLipMesh.getPoints().get(0) - x0);
        currentDownLipMesh.getPoints().set(1, currentDownLipMesh.getPoints().get(1) - y0);
        currentDownLipMesh.getPoints().set(12, currentDownLipMesh.getPoints().get(12) + x0);
        currentDownLipMesh.getPoints().set(13, currentDownLipMesh.getPoints().get(13) - y0);
        currentDownLipMesh.getPoints().set(3, currentDownLipMesh.getPoints().get(3) - y1);
        currentDownLipMesh.getPoints().set(11, currentDownLipMesh.getPoints().get(11) - y1);
        currentDownLipMesh.getPoints().set(5, currentDownLipMesh.getPoints().get(5) - y2);
        currentDownLipMesh.getPoints().set(9, currentDownLipMesh.getPoints().get(9) - y2);

        return currentDownLipMesh;
    }

}
