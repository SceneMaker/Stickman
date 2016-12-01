package de.dfki.stickman3D.mimic.util;

import javafx.scene.shape.Polygon;

public class MouthO {

	public static Polygon modifyUpperLip(Polygon currentUpperLipPolygon, float step) {
		if (step == 20 || step == 0) {
			currentUpperLipPolygon.getPoints().clear();
			currentUpperLipPolygon.getPoints().addAll(
					// x y z
					0.0, 0.0, // Point 0
					3.0, -2.0, // Point 1
					6.0, -7.0, // Point 2
					9.0, -8.0, // Point 3
					13.0, -9.0, // Point 4
					16.0, -9.0, // Point 5
					19.0, -9.0, // Point 6
					23.0, -8.0, // Point 7
					26.0, -7.0, // Point 8
					29.0, -2.0, // Point 9
					32.0, 0.0, // Point 10
					29.0, 0.0, // Point 11
					26.0, -3.0, // Point 12
					23.0, -5.0, // Point 13
					19.0, -6.0, // Point 14
					16.0, -6.0, // Point 15
					13.0, -6.0, // Point 16
					9.0, -5.0, // Point 17
					6.0, -3.0, // Point 18
					3.0, 0.0 // Point 19
			);
		}
		return currentUpperLipPolygon;
	}

	public static Polygon modifyDownLip(Polygon currentDownLipPolygone, float step) {
		if (step == 20 || step == 0) {
			currentDownLipPolygone.getPoints().clear();
			currentDownLipPolygone.getPoints().addAll(
					// x y z
					0.0, 0.0, // Point 0
					3.0, 2.0, // Point 1
					6.0, 7.0, // Point 2
					9.0, 8.0, // Point 3
					13.0, 9.0, // Point 4
					16.0, 9.0, // Point 5
					19.0, 9.0, // Point 6
					23.0, 8.0, // Point 7
					26.0, 7.0, // Point 8
					29.0, 2.0, // Point 9
					32.0, 0.0, // Point 10
					29.0, 0.0, // Point 11
					26.0, 3.0, // Point 12
					23.0, 5.0, // Point 13
					19.0, 6.0, // Point 14
					16.0, 6.0, // Point 15
					13.0, 6.0, // Point 16
					9.0, 5.0, // Point 17
					6.0, 3.0, // Point 18
					3.0, 0.0 // Point 19
			);
		}
		return currentDownLipPolygone;
	}

}
