package de.dfki.stickmanfx.mimic.util;

import de.dfki.stickmanfx.animationlogic.AnimatorFX;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.TriangleMesh;

public class MouthO {

	public static Polygon modifyUpperLip(Polygon currentUpperLipMesh, float step, String sign) {
		int sig;

		if (sign.equalsIgnoreCase("PLUS"))
			sig = 1;
		else
			sig = -1;

		float xMovement0;
		float yMovement1;
		float yMovement2;
		float yMovement3;
		float yMovement4;
		float yMovement5;

		float xMovement11;
		float yMovement12;
		float yMovement13;
		float yMovement14;
		float yMovement15;

		xMovement0 = sig * (20 - step) * 0.0052f;
		yMovement1 = sig * (20 - step) * 0.0105f;
		yMovement2 = sig * (20 - step) * 0.0158f;
		yMovement3 = sig * (20 - step) * 0.0210f;
		yMovement4 = sig * (20 - step) * 0.0263f;
		yMovement5 = sig * (20 - step) * 0.0368f;

		xMovement11 = sig * (20 - step) * 0.0052f;
		yMovement12 = sig * (20 - step) * 0.0210f;
		yMovement13 = sig * (20 - step) * 0.0316f;
		yMovement14 = sig * (20 - step) * 0.0368f;
		yMovement15 = sig * (20 - step) * 0.0368f;

		currentUpperLipMesh.getPoints().set(0, currentUpperLipMesh.getPoints().get(0) + xMovement0);
		currentUpperLipMesh.getPoints().set(3, currentUpperLipMesh.getPoints().get(3) - yMovement1);
		currentUpperLipMesh.getPoints().set(5, currentUpperLipMesh.getPoints().get(5) - yMovement2);
		currentUpperLipMesh.getPoints().set(7, currentUpperLipMesh.getPoints().get(7) - yMovement3);
		currentUpperLipMesh.getPoints().set(9, currentUpperLipMesh.getPoints().get(9) - yMovement4);
		currentUpperLipMesh.getPoints().set(11, currentUpperLipMesh.getPoints().get(11) - yMovement5);
		currentUpperLipMesh.getPoints().set(13, currentUpperLipMesh.getPoints().get(13) - yMovement4);
		currentUpperLipMesh.getPoints().set(15, currentUpperLipMesh.getPoints().get(15) - yMovement3);
		currentUpperLipMesh.getPoints().set(17, currentUpperLipMesh.getPoints().get(17) - yMovement2);
		currentUpperLipMesh.getPoints().set(19, currentUpperLipMesh.getPoints().get(19) - yMovement1);
		currentUpperLipMesh.getPoints().set(20, currentUpperLipMesh.getPoints().get(20) - xMovement0);

		currentUpperLipMesh.getPoints().set(22, currentUpperLipMesh.getPoints().get(22) - xMovement11);
		currentUpperLipMesh.getPoints().set(25, currentUpperLipMesh.getPoints().get(25) - yMovement12);
		currentUpperLipMesh.getPoints().set(27, currentUpperLipMesh.getPoints().get(27) - yMovement13);
		currentUpperLipMesh.getPoints().set(29, currentUpperLipMesh.getPoints().get(29) - yMovement14);
		currentUpperLipMesh.getPoints().set(31, currentUpperLipMesh.getPoints().get(31) - yMovement15);
		currentUpperLipMesh.getPoints().set(33, currentUpperLipMesh.getPoints().get(33) - yMovement14);
		currentUpperLipMesh.getPoints().set(35, currentUpperLipMesh.getPoints().get(35) - yMovement13);
		currentUpperLipMesh.getPoints().set(37, currentUpperLipMesh.getPoints().get(37) - yMovement12);
		currentUpperLipMesh.getPoints().set(38, currentUpperLipMesh.getPoints().get(38) + xMovement11);

		return currentUpperLipMesh;
	}

	public static Polygon modifyDownLip(Polygon currentDownLipMesh, float step, String sign) {
		int sig;

		if (sign.equalsIgnoreCase("PLUS"))
			sig = 1;
		else
			sig = -1;

		float xMovement0;
		float yMovement1;
		float yMovement2;
		float yMovement3;
		float yMovement4;
		float yMovement5;

		float xMovement11;
		float yMovement12;
		float yMovement13;
		float yMovement14;
		float yMovement15;

		xMovement0 = sig * (20 - step) * 0.0052f;
		yMovement1 = sig * (20 - step) * 0.0105f;
		yMovement2 = sig * (20 - step) * 0.0158f;
		yMovement3 = sig * (20 - step) * 0.0210f;
		yMovement4 = sig * (20 - step) * 0.0263f;
		yMovement5 = sig * (20 - step) * 0.0368f;

		xMovement11 = sig * (20 - step) * 0.0052f;
		yMovement12 = sig * (20 - step) * 0.0210f;
		yMovement13 = sig * (20 - step) * 0.0316f;
		yMovement14 = sig * (20 - step) * 0.0368f;
		yMovement15 = sig * (20 - step) * 0.0368f;

		currentDownLipMesh.getPoints().set(0, currentDownLipMesh.getPoints().get(0) + xMovement0);
		currentDownLipMesh.getPoints().set(3, currentDownLipMesh.getPoints().get(3) + yMovement1);
		currentDownLipMesh.getPoints().set(5, currentDownLipMesh.getPoints().get(5) + yMovement2);
		currentDownLipMesh.getPoints().set(7, currentDownLipMesh.getPoints().get(7) + yMovement3);
		currentDownLipMesh.getPoints().set(9, currentDownLipMesh.getPoints().get(9) + yMovement4);
		currentDownLipMesh.getPoints().set(11, currentDownLipMesh.getPoints().get(11) + yMovement5);
		currentDownLipMesh.getPoints().set(13, currentDownLipMesh.getPoints().get(13) + yMovement4);
		currentDownLipMesh.getPoints().set(15, currentDownLipMesh.getPoints().get(15) + yMovement3);
		currentDownLipMesh.getPoints().set(17, currentDownLipMesh.getPoints().get(17) + yMovement2);
		currentDownLipMesh.getPoints().set(19, currentDownLipMesh.getPoints().get(19) + yMovement1);
		currentDownLipMesh.getPoints().set(20, currentDownLipMesh.getPoints().get(20) - xMovement0);

		currentDownLipMesh.getPoints().set(21, currentDownLipMesh.getPoints().get(21) - xMovement11);
		currentDownLipMesh.getPoints().set(25, currentDownLipMesh.getPoints().get(25) + yMovement12);
		currentDownLipMesh.getPoints().set(27, currentDownLipMesh.getPoints().get(27) + yMovement13);
		currentDownLipMesh.getPoints().set(29, currentDownLipMesh.getPoints().get(29) + yMovement14);
		currentDownLipMesh.getPoints().set(31, currentDownLipMesh.getPoints().get(31) + yMovement15);
		currentDownLipMesh.getPoints().set(33, currentDownLipMesh.getPoints().get(33) + yMovement14);
		currentDownLipMesh.getPoints().set(35, currentDownLipMesh.getPoints().get(35) + yMovement13);
		currentDownLipMesh.getPoints().set(37, currentDownLipMesh.getPoints().get(37) + yMovement12);
		currentDownLipMesh.getPoints().set(38, currentDownLipMesh.getPoints().get(38) + xMovement11);

		return currentDownLipMesh;
	}

}
