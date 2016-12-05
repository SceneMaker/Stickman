package de.dfki.stickman3D.mimic.util;

import javafx.scene.shape.Polygon;

public class MouthCONTEMPT {

    public static Polygon modifyUpperLip(Polygon currentUpperLipMesh, float step, String sign) {
        int sig;

        if (sign.equalsIgnoreCase("PLUS")) {
            sig = 1;
        } else {
            sig = -1;
        }

        double x0;
        double y0;
        double y2;
        double y5;
        double x6;
        double y6;
        double y7;

        x0 = sig * (20 - step) * 0.01052631578947368;
        y0 = sig * (20 - step) * 0.00526315789473684;
        y2 = sig * (20 - step) * 0.01052631578947368;
        y5 = sig * (20 - step) * 0.01578947368421053;
        x6 = sig * (20 - step) * 0.01578947368421053;
        y6 = sig * (20 - step) * 0.03157894736842105;
        y7 = sig * (20 - step) * 0.01578947368421053;

        currentUpperLipMesh.getPoints().set(0, currentUpperLipMesh.getPoints().get(0) - x0);
        currentUpperLipMesh.getPoints().set(1, currentUpperLipMesh.getPoints().get(1) + y0);
        currentUpperLipMesh.getPoints().set(3, currentUpperLipMesh.getPoints().get(3) + y0);
        currentUpperLipMesh.getPoints().set(5, currentUpperLipMesh.getPoints().get(5) + y2);
        currentUpperLipMesh.getPoints().set(7, currentUpperLipMesh.getPoints().get(7) - y0);
        currentUpperLipMesh.getPoints().set(11, currentUpperLipMesh.getPoints().get(11) - y5);
        currentUpperLipMesh.getPoints().set(12, currentUpperLipMesh.getPoints().get(12) + x6);
        currentUpperLipMesh.getPoints().set(13, currentUpperLipMesh.getPoints().get(13) - y6);
        currentUpperLipMesh.getPoints().set(15, currentUpperLipMesh.getPoints().get(15) - y7);
        currentUpperLipMesh.getPoints().set(17, currentUpperLipMesh.getPoints().get(17) - y2);
        currentUpperLipMesh.getPoints().set(19, currentUpperLipMesh.getPoints().get(19) - y0);

        return currentUpperLipMesh;
    }

    public static Polygon modifyDownLip(Polygon currentDownLipMesh, float step, String sign) {
        int sig;

        if (sign.equalsIgnoreCase("PLUS")) {
            sig = 1;
        } else {
            sig = -1;
        }

        double x0;
        double y0;
        double y2;
        double y3;
        double y6;
        double y8;

        x0 = sig * (20 - step) * 0.01052631578947368;
        y0 = sig * (20 - step) * 0.00526315789473684;
        y2 = sig * (20 - step) * 0.02631578947368421;
        y3 = sig * (20 - step) * 0.01578947368421053;
        y6 = sig * (20 - step) * 0.03157894736842105;
        y6 = sig * (20 - step) * 0.03157894736842105;

        currentDownLipMesh.getPoints().set(0, currentDownLipMesh.getPoints().get(0) - x0);
        currentDownLipMesh.getPoints().set(1, currentDownLipMesh.getPoints().get(1) + y0);
        currentDownLipMesh.getPoints().set(3, currentDownLipMesh.getPoints().get(3) - y0);
        currentDownLipMesh.getPoints().set(5, currentDownLipMesh.getPoints().get(5) - y2);
        currentDownLipMesh.getPoints().set(7, currentDownLipMesh.getPoints().get(7) - y3);
        currentDownLipMesh.getPoints().set(9, currentDownLipMesh.getPoints().get(9) - y2);
        currentDownLipMesh.getPoints().set(11, currentDownLipMesh.getPoints().get(11) - y2);
        currentDownLipMesh.getPoints().set(12, currentDownLipMesh.getPoints().get(12) + y3);
        currentDownLipMesh.getPoints().set(13, currentDownLipMesh.getPoints().get(13) - y6);
        currentDownLipMesh.getPoints().set(15, currentDownLipMesh.getPoints().get(15) - y3);
        currentDownLipMesh.getPoints().set(17, currentDownLipMesh.getPoints().get(17) - x0);
        currentDownLipMesh.getPoints().set(19, currentDownLipMesh.getPoints().get(19) - x0);
        currentDownLipMesh.getPoints().set(21, currentDownLipMesh.getPoints().get(21) - x0);

        return currentDownLipMesh;
    }

}
