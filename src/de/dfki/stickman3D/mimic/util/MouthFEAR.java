package de.dfki.stickman3D.mimic.util;

import javafx.scene.shape.Polygon;

public class MouthFEAR
{

    public static Polygon modifyUpperLip(Polygon currentUpperLipMesh, float step, String sign)
    {

        int sig;

        if (sign.equalsIgnoreCase("PLUS"))
        {
            sig = 1;
        } else
        {
            sig = -1;
        }

        double x1;
        double y1;
        double y2;
        double y8;

        x1 = sig * (20 - step) * 0.00789473684210526;
        y1 = sig * (20 - step) * 0.00526315789473684;
        y2 = sig * (20 - step) * 0.01052631578947368;
        y8 = sig * (20 - step) * 0.02105263157894737;

        currentUpperLipMesh.getPoints().set(2, currentUpperLipMesh.getPoints().get(2) - x1);
        currentUpperLipMesh.getPoints().set(3, currentUpperLipMesh.getPoints().get(3) - y1);
        currentUpperLipMesh.getPoints().set(5, currentUpperLipMesh.getPoints().get(5) - y2);
        currentUpperLipMesh.getPoints().set(7, currentUpperLipMesh.getPoints().get(7) - y2);
        currentUpperLipMesh.getPoints().set(9, currentUpperLipMesh.getPoints().get(9) - y2);
        currentUpperLipMesh.getPoints().set(10, currentUpperLipMesh.getPoints().get(10) + x1);
        currentUpperLipMesh.getPoints().set(11, currentUpperLipMesh.getPoints().get(11) - y1);
        currentUpperLipMesh.getPoints().set(15, currentUpperLipMesh.getPoints().get(15) - y1);
        currentUpperLipMesh.getPoints().set(17, currentUpperLipMesh.getPoints().get(17) - y8);
        currentUpperLipMesh.getPoints().set(19, currentUpperLipMesh.getPoints().get(19) - y8);
        currentUpperLipMesh.getPoints().set(21, currentUpperLipMesh.getPoints().get(21) - y8);
        currentUpperLipMesh.getPoints().set(23, currentUpperLipMesh.getPoints().get(23) - y1);

        return currentUpperLipMesh;
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

        double y1;
        double y2;

        y1 = sig * (20 - step) * 0.00526315789473684;
        y2 = sig * (20 - step) * 0.01052631578947368;

        currentDownLipMesh.getPoints().set(3, currentDownLipMesh.getPoints().get(3) - y1);
        currentDownLipMesh.getPoints().set(5, currentDownLipMesh.getPoints().get(5) - y2);
        currentDownLipMesh.getPoints().set(9, currentDownLipMesh.getPoints().get(9) - y2);
        currentDownLipMesh.getPoints().set(11, currentDownLipMesh.getPoints().get(11) - y1);

        return currentDownLipMesh;
    }

}
