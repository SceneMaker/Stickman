package de.dfki.stickman3D.mimic.util;

import javafx.scene.shape.Polygon;

public class RightBrowSURPRISED {

    public static Polygon getANGRY(Polygon currentPolygon, float step, String sign) {
        int sig;

        if (sign.equalsIgnoreCase("PLUS")) {
            sig = 1;
        } else {
            sig = -1;
        }

        currentPolygon.getPoints().set(5, currentPolygon.getPoints().get(5) - (sig * 0.105));
        currentPolygon.getPoints().set(7, currentPolygon.getPoints().get(7) - (sig * 0.158));
        currentPolygon.getPoints().set(9, currentPolygon.getPoints().get(9) - (sig * 0.105));
        currentPolygon.getPoints().set(13, currentPolygon.getPoints().get(13) - (sig * 0.052));
        currentPolygon.getPoints().set(15, currentPolygon.getPoints().get(15) + (sig * 0.052));
        currentPolygon.getPoints().set(17, currentPolygon.getPoints().get(17) + (sig * 0.052));
        currentPolygon.getPoints().set(19, currentPolygon.getPoints().get(19) - (sig * 0.052));
        currentPolygon.getPoints().set(23, currentPolygon.getPoints().get(23) - (sig * 0.158));
        currentPolygon.getPoints().set(25, currentPolygon.getPoints().get(25) - (sig * 0.158));
        currentPolygon.getPoints().set(27, currentPolygon.getPoints().get(27) - (sig * 0.105));

        return currentPolygon;
    }

}
