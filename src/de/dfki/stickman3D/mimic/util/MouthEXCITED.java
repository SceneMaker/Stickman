package de.dfki.stickman3D.mimic.util;

import javafx.scene.shape.Polygon;

public class MouthEXCITED
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

        double y3;

        y3 = sig * (20 - step) * 0.01052631578947368;

        currentUpperLipMesh.getPoints().set(7, currentUpperLipMesh.getPoints().get(7) - y3);
        currentUpperLipMesh.getPoints().set(17, currentUpperLipMesh.getPoints().get(17) - y3);
        currentUpperLipMesh.getPoints().set(19, currentUpperLipMesh.getPoints().get(19) - y3);
        currentUpperLipMesh.getPoints().set(21, currentUpperLipMesh.getPoints().get(21) - y3);
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
        double y3;
        double y8;

        y2 = sig * (20 - step) * 0.02105263157894737;
        y3 = sig * (20 - step) * 0.03684210526315789;
        y8 = sig * (20 - step) * 0.03157894736842105;

        currentDownLipMesh.getPoints().set(5, currentDownLipMesh.getPoints().get(5) + y2);
        currentDownLipMesh.getPoints().set(7, currentDownLipMesh.getPoints().get(7) + y3);
        currentDownLipMesh.getPoints().set(9, currentDownLipMesh.getPoints().get(9) + y2);
        currentDownLipMesh.getPoints().set(17, currentDownLipMesh.getPoints().get(17) + y8);
        currentDownLipMesh.getPoints().set(19, currentDownLipMesh.getPoints().get(19) + y3);
        currentDownLipMesh.getPoints().set(21, currentDownLipMesh.getPoints().get(21) + y8);

        return currentDownLipMesh;
    }

}
