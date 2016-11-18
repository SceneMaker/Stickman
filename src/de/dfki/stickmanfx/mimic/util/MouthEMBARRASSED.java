package de.dfki.stickmanfx.mimic.util;

import de.dfki.stickmanfx.animationlogic.AnimatorFX;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.TriangleMesh;

public class MouthEMBARRASSED {

	public static Polygon modifyUpperLip(Polygon currentUpperLipMesh, float step, String sign) {
		int sig;

		if (sign.equalsIgnoreCase("PLUS"))
			sig = 1;
		else
			sig = -1;

		float xMovement0;
		float yMovement0;
		float xMovement1;
		float yMovement1;
		float yMovement2;
		float yMovement3;
		float yMovement4;
		float yMovement12;
		float yMovement13;
		float yMovement14;
		float yMovement15;
		float yMovement16;
		float xMovement19;
		float yMovement19;

		xMovement0 = sig * (20 - step) * 0.0210f;
		yMovement0 = sig * (20 - step) * 0.0210f;
		xMovement1 = sig * (20 - step) * 0.0052f;
		yMovement1 = sig * (20 - step) * 0.0052f;
		yMovement2 = sig * (20 - step) * 0.0052f;
		yMovement3 = sig * (20 - step) * 0.0052f;
		yMovement4 = sig * (20 - step) * 0.0052f;
		yMovement12 = sig * (20 - step) * 0.0079f;
		yMovement13 = sig * (20 - step) * 0.0105f;
		yMovement14 = sig * (20 - step) * 0.0105f;
		yMovement15 = sig * (20 - step) * 0.0052f;
		yMovement16 = sig * (20 - step) * 0.0105f;
		xMovement19 = sig * (20 - step) * 0.0052f;
		yMovement19 = sig * (20 - step) * 0.0052f;

		currentUpperLipMesh.getPoints().set(0, currentUpperLipMesh.getPoints().get(0) - xMovement0);
		currentUpperLipMesh.getPoints().set(1, currentUpperLipMesh.getPoints().get(1) + yMovement0);
		currentUpperLipMesh.getPoints().set(2, currentUpperLipMesh.getPoints().get(2) - xMovement1);
		currentUpperLipMesh.getPoints().set(3, currentUpperLipMesh.getPoints().get(3) + yMovement1);
		currentUpperLipMesh.getPoints().set(5, currentUpperLipMesh.getPoints().get(5) + yMovement2);
		currentUpperLipMesh.getPoints().set(7, currentUpperLipMesh.getPoints().get(7) + yMovement3);
		currentUpperLipMesh.getPoints().set(9, currentUpperLipMesh.getPoints().get(9) + yMovement4);
		currentUpperLipMesh.getPoints().set(25, currentUpperLipMesh.getPoints().get(25) - yMovement12);
		currentUpperLipMesh.getPoints().set(27, currentUpperLipMesh.getPoints().get(27) - yMovement13);
		currentUpperLipMesh.getPoints().set(29, currentUpperLipMesh.getPoints().get(29) - yMovement14);
		currentUpperLipMesh.getPoints().set(31, currentUpperLipMesh.getPoints().get(31) - yMovement15);
		currentUpperLipMesh.getPoints().set(33, currentUpperLipMesh.getPoints().get(33) - yMovement16);
		currentUpperLipMesh.getPoints().set(38, currentUpperLipMesh.getPoints().get(38) - xMovement19);
		currentUpperLipMesh.getPoints().set(39, currentUpperLipMesh.getPoints().get(39) + yMovement19);

		return currentUpperLipMesh;
	}

	public static Polygon modifyDownLip(Polygon currentDownLipMesh, float step, String sign) {
		int sig;

		if (sign.equalsIgnoreCase("PLUS"))
			sig = 1;
		else
			sig = -1;

		float xMovement0;
		float yMovement0;
		float xMovement19;
		float yMovement19;
		float yMovement16;
		float yMovement14;
		float yMovement13;
		float yMovement12;
		float yMovement4;
		float yMovement3;
		float yMovement2;
		float xMovement1;

		xMovement0 = sig * (20 - step) * 0.0210f;
		yMovement0 = sig * (20 - step) * 0.0210f;
		xMovement19 = sig * (20 - step) * 0.0052f;
		yMovement19 = sig * (20 - step) * 0.0052f;
		yMovement16 = sig * (20 - step) * 0.0052f;
		yMovement14 = sig * (20 - step) * 0.0052f;
		yMovement13 = sig * (20 - step) * 0.0052f;
		yMovement12 = sig * (20 - step) * 0.0052f;
		yMovement4 = sig * (20 - step) * 0.0052f;
		yMovement3 = sig * (20 - step) * 0.0052f;
		yMovement2 = sig * (20 - step) * 0.0052f;
		xMovement1 = sig * (20 - step) * 0.0052f;

		currentDownLipMesh.getPoints().set(0, currentDownLipMesh.getPoints().get(0) - xMovement0);
		currentDownLipMesh.getPoints().set(1, currentDownLipMesh.getPoints().get(1) + yMovement0);
		currentDownLipMesh.getPoints().set(38, currentDownLipMesh.getPoints().get(38) - xMovement19);
		currentDownLipMesh.getPoints().set(39, currentDownLipMesh.getPoints().get(39) + yMovement19);
		currentDownLipMesh.getPoints().set(33, currentDownLipMesh.getPoints().get(33) - yMovement16);
		currentDownLipMesh.getPoints().set(29, currentDownLipMesh.getPoints().get(29) + yMovement14);
		currentDownLipMesh.getPoints().set(27, currentDownLipMesh.getPoints().get(27) + yMovement13);
		currentDownLipMesh.getPoints().set(25, currentDownLipMesh.getPoints().get(25) + yMovement12);
		currentDownLipMesh.getPoints().set(9, currentDownLipMesh.getPoints().get(9) - yMovement4);
		currentDownLipMesh.getPoints().set(7, currentDownLipMesh.getPoints().get(7) - yMovement3);
		currentDownLipMesh.getPoints().set(5, currentDownLipMesh.getPoints().get(5) - yMovement2);
		currentDownLipMesh.getPoints().set(2, currentDownLipMesh.getPoints().get(2) - xMovement1);

		return currentDownLipMesh;
	}

}
