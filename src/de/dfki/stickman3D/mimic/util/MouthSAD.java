package de.dfki.stickman3D.mimic.util;

import de.dfki.stickman3D.animationlogic.Animator;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.TriangleMesh;

public class MouthSAD {

	public static Polygon modifyUpperLip(Polygon currentUpperLipPolygon, float step, String sign) {
		int sig;

		if (sign.equalsIgnoreCase("PLUS"))
			sig = 1;
		else
			sig = -1;

		float xMovement0;
		float yMovement0;
		float xMovement1;
		float yMovement1;
		float xMovement19;
		float yMovement19;

		float xMovement10;
		float yMovement10;
		float xMovement9;
		float yMovement9;
		float xMovement11;
		float yMovement11;

		xMovement0 = sig * (20 - step) * 0.0263f;
		yMovement0 = sig * (20 - step) * 0.0421f;
		xMovement1 = sig * (20 - step) * 0.0158f;
		yMovement1 = sig * (20 - step) * 0.0105f;
		xMovement19 = sig * (20 - step) * 0.0158f;
		yMovement19 = sig * (20 - step) * 0.0105f;

		xMovement10 = sig * (20 - step) * 0.0263f;
		yMovement10 = sig * (20 - step) * 0.0421f;
		xMovement9 = sig * (20 - step) * 0.0158f;
		yMovement9 = sig * (20 - step) * 0.0105f;
		xMovement11 = sig * (20 - step) * 0.0158f;
		yMovement11 = sig * (20 - step) * 0.0105f;

		currentUpperLipPolygon.getPoints().set(0, currentUpperLipPolygon.getPoints().get(0) - xMovement0);
		currentUpperLipPolygon.getPoints().set(1, currentUpperLipPolygon.getPoints().get(1) + yMovement0);
		currentUpperLipPolygon.getPoints().set(38, currentUpperLipPolygon.getPoints().get(38) - xMovement1);
		currentUpperLipPolygon.getPoints().set(39, currentUpperLipPolygon.getPoints().get(39) + yMovement1);
		currentUpperLipPolygon.getPoints().set(2, currentUpperLipPolygon.getPoints().get(2) - xMovement19);
		currentUpperLipPolygon.getPoints().set(3, currentUpperLipPolygon.getPoints().get(3) + yMovement19);
		currentUpperLipPolygon.getPoints().set(20, currentUpperLipPolygon.getPoints().get(20) + xMovement10);
		currentUpperLipPolygon.getPoints().set(21, currentUpperLipPolygon.getPoints().get(21) + yMovement10);
		currentUpperLipPolygon.getPoints().set(24, currentUpperLipPolygon.getPoints().get(24) + xMovement9);
		currentUpperLipPolygon.getPoints().set(25, currentUpperLipPolygon.getPoints().get(25) + yMovement9);
		currentUpperLipPolygon.getPoints().set(18, currentUpperLipPolygon.getPoints().get(18) + xMovement11);
		currentUpperLipPolygon.getPoints().set(19, currentUpperLipPolygon.getPoints().get(19) + yMovement11);

		return currentUpperLipPolygon;
	}

	public static Polygon modifyDownLip(Polygon currentDownLipPolygon, float step, String sign) {
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
		float yMovement5;
		float yMovement6;
		float yMovement7;
		float yMovement8;
		float xMovement19;
		float yMovement19;
		float xMovement10;
		float yMovement10;
		float xMovement9;
		float yMovement9;
		float xMovement11;
		float yMovement11;

		xMovement0 = sig * (20 - step) * 0.0263f;
		yMovement0 = sig * (20 - step) * 0.0421f;
		xMovement1 = sig * (20 - step) * 0.0158f;
		yMovement1 = sig * (20 - step) * 0.0105f;
		xMovement19 = sig * (20 - step) * 0.0158f;
		yMovement19 = sig * (20 - step) * 0.0105f;
		yMovement2 = sig * (20 - step) * 0.0053f;
		yMovement3 = sig * (20 - step) * 0.0105f;
		yMovement4 = sig * (20 - step) * 0.0158f;
		yMovement5 = sig * (20 - step) * 0.0053f;

		xMovement10 = sig * (20 - step) * 0.0263f;
		yMovement10 = sig * (20 - step) * 0.0421f;
		xMovement9 = sig * (20 - step) * 0.0158f;
		yMovement9 = sig * (20 - step) * 0.0105f;
		xMovement11 = sig * (20 - step) * 0.0158f;
		yMovement11 = sig * (20 - step) * 0.0105f;
		yMovement8 = sig * (20 - step) * 0.0053f;
		yMovement7 = sig * (20 - step) * 0.0105f;
		yMovement6 = sig * (20 - step) * 0.0158f;

		currentDownLipPolygon.getPoints().set(0, currentDownLipPolygon.getPoints().get(0) - xMovement0);
		currentDownLipPolygon.getPoints().set(1, currentDownLipPolygon.getPoints().get(1) + yMovement0);
		currentDownLipPolygon.getPoints().set(2, currentDownLipPolygon.getPoints().get(2) - xMovement1);
		currentDownLipPolygon.getPoints().set(3, currentDownLipPolygon.getPoints().get(3) + yMovement1);
		currentDownLipPolygon.getPoints().set(38, currentDownLipPolygon.getPoints().get(38) - xMovement19);
		currentDownLipPolygon.getPoints().set(39, currentDownLipPolygon.getPoints().get(39) + yMovement19);
		currentDownLipPolygon.getPoints().set(5, currentDownLipPolygon.getPoints().get(5) - yMovement2);
		currentDownLipPolygon.getPoints().set(7, currentDownLipPolygon.getPoints().get(7) - yMovement3);
		currentDownLipPolygon.getPoints().set(9, currentDownLipPolygon.getPoints().get(9) - yMovement4);
		currentDownLipPolygon.getPoints().set(11, currentDownLipPolygon.getPoints().get(11) - yMovement5);
		// ------------------------------//
		currentDownLipPolygon.getPoints().set(20, currentDownLipPolygon.getPoints().get(20) + xMovement10);
		currentDownLipPolygon.getPoints().set(21, currentDownLipPolygon.getPoints().get(21) + yMovement10);
		currentDownLipPolygon.getPoints().set(18, currentDownLipPolygon.getPoints().get(18) + xMovement9);
		currentDownLipPolygon.getPoints().set(19, currentDownLipPolygon.getPoints().get(19) + yMovement9);
		currentDownLipPolygon.getPoints().set(22, currentDownLipPolygon.getPoints().get(22) + xMovement11);
		currentDownLipPolygon.getPoints().set(23, currentDownLipPolygon.getPoints().get(23) + yMovement11);
		currentDownLipPolygon.getPoints().set(17, currentDownLipPolygon.getPoints().get(17) - yMovement8);
		currentDownLipPolygon.getPoints().set(15, currentDownLipPolygon.getPoints().get(15) - yMovement7);
		currentDownLipPolygon.getPoints().set(13, currentDownLipPolygon.getPoints().get(13) - yMovement6);

		return currentDownLipPolygon;
	}

}
