package de.dfki.stickmanfx.mimic.util;

import de.dfki.stickmanfx.animationlogic.AnimatorFX;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.TriangleMesh;

public class MouthHAPPY {

	public static Polygon modifyUpperLip(Polygon currentUpperLipMesh, float step, String sign) {
		int sig;

		if (sign.equalsIgnoreCase("PLUS"))
			sig = 1;
		else
			sig = -1;

		float yMovement16;
		float yMovement17;
		float yMovement18;
		float yMovement19;

		yMovement16 = sig * (20 - step) * 0.0105f;
		yMovement17 = sig * (20 - step) * 0.0105f;
		yMovement18 = sig * (20 - step) * 0.0079f;
		yMovement19 = sig * (20 - step) * 0.0026f;

		currentUpperLipMesh.getPoints().set(11, currentUpperLipMesh.getPoints().get(11) - yMovement16);
		currentUpperLipMesh.getPoints().set(31, currentUpperLipMesh.getPoints().get(31) - yMovement17);
		currentUpperLipMesh.getPoints().set(33, currentUpperLipMesh.getPoints().get(33) - yMovement18);
		currentUpperLipMesh.getPoints().set(29, currentUpperLipMesh.getPoints().get(29) - yMovement18);
		currentUpperLipMesh.getPoints().set(35, currentUpperLipMesh.getPoints().get(35) - yMovement19);
		currentUpperLipMesh.getPoints().set(27, currentUpperLipMesh.getPoints().get(27) - yMovement19);

		return currentUpperLipMesh;
	}

	public static Polygon modifyDownLip(Polygon currentDownLipMesh, float step, String sign) {
		int sig;

		if (sign.equalsIgnoreCase("PLUS"))
			sig = 1;
		else
			sig = -1;

		float yMovement5;
		float yMovement2;
		float yMovement3;
		float yMovement4;
		float yMovement6;
		float yMovement7;
		float yMovement8;
		float yMovement9;
		float yMovement10;
		float yMovement11;
		float yMovement12;
		float yMovement13;
		float yMovement14;
		float yMovement15;

		yMovement2 = sig * (20 - step) * 0.0053f;
		yMovement3 = sig * (20 - step) * 0.0105f;
		yMovement4 = sig * (20 - step) * 0.0210f;
		yMovement5 = sig * (20 - step) * 0.0368f;
		yMovement6 = sig * (20 - step) * 0.0210f;
		yMovement7 = sig * (20 - step) * 0.0105f;
		yMovement8 = sig * (20 - step) * 0.0053f;

		yMovement9 = sig * (20 - step) * 0.0105f;
		yMovement10 = sig * (20 - step) * 0.0210f;
		yMovement11 = sig * (20 - step) * 0.0315f;
		yMovement12 = sig * (20 - step) * 0.0368f;
		yMovement13 = sig * (20 - step) * 0.0315f;
		yMovement14 = sig * (20 - step) * 0.0210f;
		yMovement15 = sig * (20 - step) * 0.0105f;

		currentDownLipMesh.getPoints().set(5, currentDownLipMesh.getPoints().get(5) + yMovement2);
		currentDownLipMesh.getPoints().set(7, currentDownLipMesh.getPoints().get(7) + yMovement3);
		currentDownLipMesh.getPoints().set(9, currentDownLipMesh.getPoints().get(9) + yMovement4);
		currentDownLipMesh.getPoints().set(11, currentDownLipMesh.getPoints().get(11) + yMovement5);
		currentDownLipMesh.getPoints().set(13, currentDownLipMesh.getPoints().get(13) + yMovement6);
		currentDownLipMesh.getPoints().set(15, currentDownLipMesh.getPoints().get(15) + yMovement7);
		currentDownLipMesh.getPoints().set(17, currentDownLipMesh.getPoints().get(17) + yMovement8);

		currentDownLipMesh.getPoints().set(37, currentDownLipMesh.getPoints().get(37) + yMovement9);
		currentDownLipMesh.getPoints().set(35, currentDownLipMesh.getPoints().get(35) + yMovement10);
		currentDownLipMesh.getPoints().set(33, currentDownLipMesh.getPoints().get(33) + yMovement11);
		currentDownLipMesh.getPoints().set(31, currentDownLipMesh.getPoints().get(31) + yMovement12);
		currentDownLipMesh.getPoints().set(29, currentDownLipMesh.getPoints().get(29) + yMovement13);
		currentDownLipMesh.getPoints().set(27, currentDownLipMesh.getPoints().get(27) + yMovement14);
		currentDownLipMesh.getPoints().set(25, currentDownLipMesh.getPoints().get(25) + yMovement15);

		return currentDownLipMesh;
	}

}
