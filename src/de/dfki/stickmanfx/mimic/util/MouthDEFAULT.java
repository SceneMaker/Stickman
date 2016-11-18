package de.dfki.stickmanfx.mimic.util;

import de.dfki.stickmanfx.animationlogic.AnimatorFX;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.TriangleMesh;

public class MouthDEFAULT {

	public static Polygon modifyUpperLip(Polygon currentUpperLipPolygon, float step) {
		if (step == 20 || step == 0) {
			currentUpperLipPolygon.getPoints().clear();
			currentUpperLipPolygon.getPoints().addAll(
					// x y z
					0.0, 0.0, // Point 0
					3.0, -2.0, // Point 1
					6.0, -4.0, // Point 2
					9.0, -5.0, // Point 3
					13.0, -5.0, // Point 4
					16.0, -3.0, // Point 5
					19.0, -5.0, // Point 6
					23.0, -5.0, // Point 7
					26.0, -4.0, // Point 8
					29.0, -2.0, // Point 9
					32.0, 0.0, // Point 10
					29.0, 0.0, // Point 11
					26.0, 0.0, // Point 12
					23.0, 0.0, // Point 13
					19.0, 0.0, // Point 14
					16.0, 0.0, // Point 15
					13.0, 0.0, // Point 16
					9.0, 0.0, // Point 17
					6.0, 0.0, // Point 18
					3.0, 0.0 // Point 19
			);
		}
		return currentUpperLipPolygon;
	}

	public static Polygon modifyDownLip(Polygon currentDownLipPolygon, float step) {
		if (step == 20 || step == 0) {
			currentDownLipPolygon.getPoints().clear();
			currentDownLipPolygon.getPoints().addAll(
					// x y z
					0.0, 0.0, // Point 0
					3.0, 2.0, // Point 1
					6.0, 4.0, // Point 2
					9.0, 5.0, // Point 3
					13.0, 5.0, // Point 4
					16.0, 3.0, // Point 5
					19.0, 5.0, // Point 6
					23.0, 5.0, // Point 7
					26.0, 4.0, // Point 8
					29.0, 2.0, // Point 9
					32.0, 0.0, // Point 10
					29.0, 0.0, // Point 11
					26.0, 0.0, // Point 12
					23.0, 0.0, // Point 13
					19.0, 0.0, // Point 14
					16.0, 0.0, // Point 15
					13.0, 0.0, // Point 16
					9.0, 0.0, // Point 17
					6.0, 0.0, // Point 18
					3.0, 0.0 // Point 19
			);
		}
		return currentDownLipPolygon;
	}

}
