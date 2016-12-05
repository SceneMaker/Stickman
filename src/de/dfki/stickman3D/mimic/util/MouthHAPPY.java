package de.dfki.stickman3D.mimic.util;

import javafx.scene.shape.Polygon;

public class MouthHAPPY {

    public static Polygon modifyUpperLip(Polygon currentUpperLipPolygon, float step, String sign) {
        int sig;

        if (sign.equalsIgnoreCase("PLUS")) {
            sig = 1;
        } else {
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
        currentUpperLipPolygon.getPoints().set(15, currentUpperLipPolygon.getPoints().get(15) - y1);
        currentUpperLipPolygon.getPoints().set(23, currentUpperLipPolygon.getPoints().get(23) - y1);

        return currentUpperLipPolygon;
    }

    public static Polygon modifyDownLip(Polygon currentDownLipPolygon, float step, String sign) {
        int sig;

        if (sign.equalsIgnoreCase("PLUS")) {
            sig = 1;
        } else {
            sig = -1;
        }

        double x0;
        double y0;
        double y3;

        x0 = sig * (20 - step) * 0.01578947368421053;
        y0 = sig * (20 - step) * 0.03157894736842105;
        y3 = sig * (20 - step) * 0.01052631578947368;

        currentDownLipPolygon.getPoints().set(0, currentDownLipPolygon.getPoints().get(0) - x0);
        currentDownLipPolygon.getPoints().set(1, currentDownLipPolygon.getPoints().get(1) - y0);
        currentDownLipPolygon.getPoints().set(12, currentDownLipPolygon.getPoints().get(12) + x0);
        currentDownLipPolygon.getPoints().set(13, currentDownLipPolygon.getPoints().get(13) - y0);

        currentDownLipPolygon.getPoints().set(7, currentDownLipPolygon.getPoints().get(7) + y3);
        currentDownLipPolygon.getPoints().set(17, currentDownLipPolygon.getPoints().get(17) + y3);
        currentDownLipPolygon.getPoints().set(19, currentDownLipPolygon.getPoints().get(19) + y3);
        currentDownLipPolygon.getPoints().set(21, currentDownLipPolygon.getPoints().get(21) + y3);

        return currentDownLipPolygon;

    }

}
