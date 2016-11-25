package de.dfki.stickman3D.mimic.util;

import javafx.scene.shape.Polygon;

public class MouthTWO {

	public static Polygon modifyUpperLip(Polygon currentUpperLipMesh, float step, String sign) {
		int sig;

		if (sign.equalsIgnoreCase("PLUS"))
			sig = 1;
		else
			sig = -1;

		float yMovement3;
		float yMovement4;
		float yMovement5;
		float yMovement18;
		float yMovement17;
		float yMovement16;
		float yMovement15;

		yMovement3 = sig * (20 - step) * 0.0052f;
		yMovement4 = sig * (20 - step) * 0.0158f;
		yMovement5 = sig * (20 - step) * 0.0263f;
		yMovement18 = sig * (20 - step) * 0.0052f;
		yMovement17 = sig * (20 - step) * 0.0158f;
		yMovement16 = sig * (20 - step) * 0.0263f;
		yMovement15 = sig * (20 - step) * 0.0263f;

		currentUpperLipMesh.getPoints().set(7, currentUpperLipMesh.getPoints().get(7) - yMovement3);
		currentUpperLipMesh.getPoints().set(9, currentUpperLipMesh.getPoints().get(9) - yMovement4);
		currentUpperLipMesh.getPoints().set(11, currentUpperLipMesh.getPoints().get(11) - yMovement5);
		currentUpperLipMesh.getPoints().set(13, currentUpperLipMesh.getPoints().get(13) - yMovement4);
		currentUpperLipMesh.getPoints().set(15, currentUpperLipMesh.getPoints().get(15) - yMovement3);
		currentUpperLipMesh.getPoints().set(37, currentUpperLipMesh.getPoints().get(37) - yMovement18);
		currentUpperLipMesh.getPoints().set(35, currentUpperLipMesh.getPoints().get(35) - yMovement17);
		currentUpperLipMesh.getPoints().set(33, currentUpperLipMesh.getPoints().get(33) - yMovement16);

		currentUpperLipMesh.getPoints().set(31, currentUpperLipMesh.getPoints().get(31) - yMovement15);
		currentUpperLipMesh.getPoints().set(29, currentUpperLipMesh.getPoints().get(29) - yMovement16);
		currentUpperLipMesh.getPoints().set(27, currentUpperLipMesh.getPoints().get(27) - yMovement17);
		currentUpperLipMesh.getPoints().set(25, currentUpperLipMesh.getPoints().get(25) - yMovement18);

		return currentUpperLipMesh;
	}

	public static Polygon modifyDownLip(Polygon currentDownLipMesh, float step, String sign) {

		int sig;

		if (sign.equalsIgnoreCase("PLUS"))
			sig = 1;
		else
			sig = -1;

		float yMovement3;
		float yMovement4;
		float yMovement5;
		float yMovement18;
		float yMovement17;
		float yMovement16;
		float yMovement15;

		yMovement3 = sig * (20 - step) * 0.0052f;
		yMovement4 = sig * (20 - step) * 0.0158f;
		yMovement5 = sig * (20 - step) * 0.0263f;
		yMovement18 = sig * (20 - step) * 0.0052f;
		yMovement17 = sig * (20 - step) * 0.0158f;
		yMovement16 = sig * (20 - step) * 0.0263f;
		yMovement15 = sig * (20 - step) * 0.0263f;

		currentDownLipMesh.getPoints().set(7, currentDownLipMesh.getPoints().get(7) + yMovement3);
		currentDownLipMesh.getPoints().set(9, currentDownLipMesh.getPoints().get(9) + yMovement4);
		currentDownLipMesh.getPoints().set(11, currentDownLipMesh.getPoints().get(11) + yMovement5);
		currentDownLipMesh.getPoints().set(13, currentDownLipMesh.getPoints().get(13) + yMovement4);
		currentDownLipMesh.getPoints().set(15, currentDownLipMesh.getPoints().get(15) + yMovement3);
		currentDownLipMesh.getPoints().set(37, currentDownLipMesh.getPoints().get(37) + yMovement18);
		currentDownLipMesh.getPoints().set(35, currentDownLipMesh.getPoints().get(35) + yMovement17);
		currentDownLipMesh.getPoints().set(33, currentDownLipMesh.getPoints().get(33) + yMovement16);

		currentDownLipMesh.getPoints().set(31, currentDownLipMesh.getPoints().get(31) + yMovement15);
		currentDownLipMesh.getPoints().set(29, currentDownLipMesh.getPoints().get(29) + yMovement16);
		currentDownLipMesh.getPoints().set(27, currentDownLipMesh.getPoints().get(27) + yMovement17);
		currentDownLipMesh.getPoints().set(25, currentDownLipMesh.getPoints().get(25) + yMovement18);

		return currentDownLipMesh;
	}

}
