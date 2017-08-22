package de.dfki.stickman3D.mimic.util;

import javafx.scene.shape.Polygon;

public class MouthEMBARRASSED
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

        double y2;
        double y8;

        y2 = sig * (20 - step) * 0.00526315789473684;
        y8 = sig * (20 - step) * 0.01052631578947368;

        currentUpperLipMesh.getPoints().set(5, currentUpperLipMesh.getPoints().get(5) + y2);
        currentUpperLipMesh.getPoints().set(9, currentUpperLipMesh.getPoints().get(9) + y2);
        currentUpperLipMesh.getPoints().set(15, currentUpperLipMesh.getPoints().get(15) - y2);
        currentUpperLipMesh.getPoints().set(17, currentUpperLipMesh.getPoints().get(17) - y8);
        currentUpperLipMesh.getPoints().set(19, currentUpperLipMesh.getPoints().get(19) - y2);
        currentUpperLipMesh.getPoints().set(21, currentUpperLipMesh.getPoints().get(21) - y2);

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

        double y2;

        y2 = sig * (20 - step) * 0.00526315789473684;

        currentDownLipMesh.getPoints().set(5, currentDownLipMesh.getPoints().get(5) - y2);
        currentDownLipMesh.getPoints().set(9, currentDownLipMesh.getPoints().get(9) - y2);
        currentDownLipMesh.getPoints().set(11, currentDownLipMesh.getPoints().get(11) - y2);
        currentDownLipMesh.getPoints().set(17, currentDownLipMesh.getPoints().get(17) + y2);
        currentDownLipMesh.getPoints().set(19, currentDownLipMesh.getPoints().get(19) + y2);

        return currentDownLipMesh;
    }

}
