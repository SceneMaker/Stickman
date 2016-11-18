package de.dfki.stickmanfx.mimic.util;

import de.dfki.stickmanfx.animationlogic.AnimatorFX;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.TriangleMesh;

public class MouthTREE {

	public static Polygon modifyUpperLip(Polygon currentUpperLipMesh, float step, String sign) {
		int sig;

		if (sign.equalsIgnoreCase("PLUS"))
			sig = 1;
		else
			sig = -1;

		float xMovement0;
		float xMovement1;
		float yMovement3;
		float yMovement4;
		float yMovement5;
		float yMovement18;
		float yMovement17;
		float yMovement16;
		float yMovement15;
		float xMovement18;
		float xMovement19;

		xMovement0 = sig * (20 - step) * 0.0263f;
		xMovement1 = sig * (20 - step) * 0.0105f;
		yMovement3 = sig * (20 - step) * 0.0052f;
		yMovement4 = sig * (20 - step) * 0.0158f;
		yMovement5 = sig * (20 - step) * 0.0263f;
		yMovement18 = sig * (20 - step) * 0.0052f;
		xMovement18 = sig * (20 - step) * 0.0105f;
		yMovement17 = sig * (20 - step) * 0.0158f;
		yMovement16 = sig * (20 - step) * 0.0263f;
		yMovement15 = sig * (20 - step) * 0.0263f;
		xMovement19 = sig * (20 - step) * 0.0263f;

		currentUpperLipMesh.getPoints().set(0, currentUpperLipMesh.getPoints().get(0) + xMovement0); // 0
		currentUpperLipMesh.getPoints().set(2, currentUpperLipMesh.getPoints().get(2) + xMovement1); // 1
		currentUpperLipMesh.getPoints().set(7, currentUpperLipMesh.getPoints().get(7) - yMovement3); // 3
		currentUpperLipMesh.getPoints().set(9, currentUpperLipMesh.getPoints().get(9) - yMovement4); // 4
		currentUpperLipMesh.getPoints().set(11, currentUpperLipMesh.getPoints().get(11) - yMovement5); // 5
		currentUpperLipMesh.getPoints().set(13, currentUpperLipMesh.getPoints().get(13) - yMovement4); // 6
		currentUpperLipMesh.getPoints().set(15, currentUpperLipMesh.getPoints().get(15) - yMovement3); // 7
		currentUpperLipMesh.getPoints().set(18, currentUpperLipMesh.getPoints().get(18) - xMovement1); // 9
		currentUpperLipMesh.getPoints().set(20, currentUpperLipMesh.getPoints().get(20) - xMovement0); // 10
		currentUpperLipMesh.getPoints().set(22, currentUpperLipMesh.getPoints().get(22) - xMovement19); // 11
		currentUpperLipMesh.getPoints().set(24, currentUpperLipMesh.getPoints().get(24) - xMovement18); // 12
		currentUpperLipMesh.getPoints().set(25, currentUpperLipMesh.getPoints().get(25) - yMovement18); // 12
		currentUpperLipMesh.getPoints().set(27, currentUpperLipMesh.getPoints().get(27) - yMovement17); // 13
		currentUpperLipMesh.getPoints().set(29, currentUpperLipMesh.getPoints().get(29) - yMovement16); // 14
		currentUpperLipMesh.getPoints().set(31, currentUpperLipMesh.getPoints().get(31) - yMovement15); // 15
		currentUpperLipMesh.getPoints().set(33, currentUpperLipMesh.getPoints().get(33) - yMovement16); // 16
		currentUpperLipMesh.getPoints().set(35, currentUpperLipMesh.getPoints().get(35) - yMovement17); // 17
		currentUpperLipMesh.getPoints().set(36, currentUpperLipMesh.getPoints().get(36) + xMovement18); // 18
		currentUpperLipMesh.getPoints().set(37, currentUpperLipMesh.getPoints().get(37) - yMovement18); // 18
		currentUpperLipMesh.getPoints().set(38, currentUpperLipMesh.getPoints().get(38) + xMovement19); // 19

		return currentUpperLipMesh;
	}

	public static Polygon modifyDownLip(Polygon currentDownLipMesh, float step, String sign) {

		int sig;

		if (sign.equalsIgnoreCase("PLUS"))
			sig = 1;
		else
			sig = -1;

		float xMovement0;
		float xMovement1;
		float yMovement3;
		float yMovement4;
		float yMovement5;
		float yMovement18;
		float yMovement17;
		float yMovement16;
		float yMovement15;
		float xMovement18;
		float xMovement19;

		xMovement0 = sig * (20 - step) * 0.0263f;
		xMovement1 = sig * (20 - step) * 0.0105f;
		yMovement3 = sig * (20 - step) * 0.0052f;
		yMovement4 = sig * (20 - step) * 0.0158f;
		yMovement5 = sig * (20 - step) * 0.0263f;
		yMovement18 = sig * (20 - step) * 0.0052f;
		xMovement18 = sig * (20 - step) * 0.0105f;
		yMovement17 = sig * (20 - step) * 0.0158f;
		yMovement16 = sig * (20 - step) * 0.0263f;
		yMovement15 = sig * (20 - step) * 0.0263f;
		xMovement19 = sig * (20 - step) * 0.0263f;

		currentDownLipMesh.getPoints().set(0, currentDownLipMesh.getPoints().get(0) + xMovement0); // 0
		currentDownLipMesh.getPoints().set(2, currentDownLipMesh.getPoints().get(2) + xMovement1); // 1
		currentDownLipMesh.getPoints().set(7, currentDownLipMesh.getPoints().get(7) + yMovement3); // 3
		currentDownLipMesh.getPoints().set(9, currentDownLipMesh.getPoints().get(9) + yMovement4); // 4
		currentDownLipMesh.getPoints().set(11, currentDownLipMesh.getPoints().get(11) + yMovement5); // 5
		currentDownLipMesh.getPoints().set(13, currentDownLipMesh.getPoints().get(13) + yMovement4); // 6
		currentDownLipMesh.getPoints().set(15, currentDownLipMesh.getPoints().get(15) + yMovement3); // 7
		currentDownLipMesh.getPoints().set(18, currentDownLipMesh.getPoints().get(18) - xMovement1); // 9
		currentDownLipMesh.getPoints().set(20, currentDownLipMesh.getPoints().get(20) - xMovement0); // 10
		currentDownLipMesh.getPoints().set(22, currentDownLipMesh.getPoints().get(22) - xMovement19); // 11
		currentDownLipMesh.getPoints().set(24, currentDownLipMesh.getPoints().get(24) - xMovement18); // 12
		currentDownLipMesh.getPoints().set(25, currentDownLipMesh.getPoints().get(25) + yMovement18); // 12
		currentDownLipMesh.getPoints().set(27, currentDownLipMesh.getPoints().get(27) + yMovement17); // 13
		currentDownLipMesh.getPoints().set(29, currentDownLipMesh.getPoints().get(29) + yMovement16); // 14
		currentDownLipMesh.getPoints().set(31, currentDownLipMesh.getPoints().get(31) + yMovement15); // 15
		currentDownLipMesh.getPoints().set(33, currentDownLipMesh.getPoints().get(33) + yMovement16); // 16
		currentDownLipMesh.getPoints().set(35, currentDownLipMesh.getPoints().get(35) + yMovement17); // 17
		currentDownLipMesh.getPoints().set(36, currentDownLipMesh.getPoints().get(36) + xMovement18); // 18
		currentDownLipMesh.getPoints().set(37, currentDownLipMesh.getPoints().get(37) + yMovement18); // 18
		currentDownLipMesh.getPoints().set(38, currentDownLipMesh.getPoints().get(38) + xMovement19); // 19

		return currentDownLipMesh;
	}

}
