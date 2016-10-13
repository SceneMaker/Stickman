package de.dfki.stickmanfx.mimic.util;

import de.dfki.stickmanfx.animationlogic.AnimatorFX;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.TriangleMesh;

public class LeftBrowEMBARRASSED {
	
	public static Polygon getANGRY(Polygon currentPolygon, float step, String sign)
	{
		int sig;
		
		if(sign.equalsIgnoreCase("PLUS"))
			sig = 1;
		else
			sig = -1;
		
		currentPolygon.getPoints().set(0, currentPolygon.getPoints().get(0) + (sig * 0.105));
		currentPolygon.getPoints().set(1, currentPolygon.getPoints().get(1) + (sig * 0.052));
		currentPolygon.getPoints().set(2, currentPolygon.getPoints().get(2) + (sig * 0.105));
		currentPolygon.getPoints().set(3, currentPolygon.getPoints().get(3) + (sig * 0.105));
		currentPolygon.getPoints().set(4, currentPolygon.getPoints().get(4) + (sig * 0.105));
		currentPolygon.getPoints().set(5, currentPolygon.getPoints().get(5) + (sig * 0.158));
		currentPolygon.getPoints().set(6, currentPolygon.getPoints().get(6) + (sig * 0.105));
		currentPolygon.getPoints().set(7, currentPolygon.getPoints().get(7) + (sig * 0.105));
		currentPolygon.getPoints().set(9, currentPolygon.getPoints().get(9) + (sig * 0.158));
		currentPolygon.getPoints().set(11, currentPolygon.getPoints().get(11) + (sig * 0.210));
		currentPolygon.getPoints().set(13, currentPolygon.getPoints().get(13) + (sig * 0.105));
		currentPolygon.getPoints().set(19, currentPolygon.getPoints().get(19) + (sig * 0.105));
		currentPolygon.getPoints().set(21, currentPolygon.getPoints().get(21) + (sig * 0.158));
		currentPolygon.getPoints().set(23, currentPolygon.getPoints().get(23) + (sig * 0.105));
		currentPolygon.getPoints().set(24, currentPolygon.getPoints().get(24) + (sig * 0.105));
		currentPolygon.getPoints().set(25, currentPolygon.getPoints().get(25) + (sig * 0.105));
		currentPolygon.getPoints().set(26, currentPolygon.getPoints().get(26) + (sig * 0.105));
		currentPolygon.getPoints().set(27, currentPolygon.getPoints().get(27) + (sig * 0.158));
		
		
		return currentPolygon;
	}

}
