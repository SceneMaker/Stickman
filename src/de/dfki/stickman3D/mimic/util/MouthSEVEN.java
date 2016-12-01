package de.dfki.stickman3D.mimic.util;

import javafx.scene.shape.Polygon;

public class MouthSEVEN {

	public static Polygon modifyUpperLip(Polygon currentUpperLipPolygon, float step) {
		if (step == 20 || step == 0) {
			currentUpperLipPolygon.getPoints().clear();
			currentUpperLipPolygon.getPoints().addAll(
					// x y z
					7.0, 0.0, // Point 0
					9.0, -2.0, // Point 1
					11.0, -4.0, // Point 2
					13.0, -5.0, // Point 3
					15.0, -5.0, // Point 4
					16.0, -5.0, // Point 5
					17.0, -5.0, // Point 6
					19.0, -5.0, // Point 7
					21.0, -4.0, // Point 8
					23.0, -2.0, // Point 9
					25.0, 0.0, // Point 10
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
					7.0, 0.0, // Point 0
					9.0, 2.0, // Point 1
					11.0, 4.0, // Point 2
					13.0, 5.0, // Point 3
					15.0, 5.0, // Point 4
					16.0, 5.0, // Point 5
					17.0, 5.0, // Point 6
					19.0, 5.0, // Point 7
					21.0, 4.0, // Point 8
					23.0, 2.0, // Point 9
					25.0, 0.0, // Point 10
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
