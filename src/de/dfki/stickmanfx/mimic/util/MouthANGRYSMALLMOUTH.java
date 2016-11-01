package de.dfki.stickmanfx.mimic.util;

import de.dfki.stickmanfx.animationlogic.AnimatorFX;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.TriangleMesh;

public class MouthANGRYSMALLMOUTH {
	
	public static Polygon modifyUpperLip(Polygon currentUpperLipPolygon, float step, String sign)
	{
		int sig;
		
		if(sign.equalsIgnoreCase("PLUS"))
			sig = 1;
		else
			sig = -1;
		
		float xMovement0;
		float yMovement0;
		float xMovement1;
		float xMovement2;
		float xMovement3;
		float xMovement4;
		float yMovement4;
		float yMovement5;
		float xMovement11;
		float xMovement12;
		float yMovement12;
		float xMovement13;
		float yMovement13;
		float xMovement14;
		float yMovement14;
		float yMovement15;
		
		xMovement0 = sig * (20 - step) * 0.0210f;
		yMovement0 = sig * (20 - step) * 0.0158f;
		xMovement1 = sig * (20 - step) * 0.0210f;
		xMovement2 = sig * (20 - step) * 0.0263f;
		xMovement3 = sig * (20 - step) * 0.0210f;
		xMovement4 = sig * (20 - step) * 0.0052f;
		yMovement4 = sig * (20 - step) * 0.0026f;
		yMovement5 = sig * (20 - step) * 0.0142f;
		xMovement11 = sig * (20 - step) * 0.0210f;
		xMovement12 = sig * (20 - step) * 0.0263f;
		yMovement12 = sig * (20 - step) * 0.0105f;
		xMovement13 = sig * (20 - step) * 0.0210f;
		yMovement13 = sig * (20 - step) * 0.0158f;
		xMovement14 = sig * (20 - step) * 0.0052f;
		yMovement14 = sig * (20 - step) * 0.0184f;
		yMovement15 = sig * (20 - step) * 0.0184f;
		
		currentUpperLipPolygon.getPoints().set(0, currentUpperLipPolygon.getPoints().get(0) + xMovement0);
		currentUpperLipPolygon.getPoints().set(1, currentUpperLipPolygon.getPoints().get(1) + yMovement0);
		currentUpperLipPolygon.getPoints().set(2, currentUpperLipPolygon.getPoints().get(2) + xMovement1);
		currentUpperLipPolygon.getPoints().set(4, currentUpperLipPolygon.getPoints().get(4) + xMovement2);
		currentUpperLipPolygon.getPoints().set(6, currentUpperLipPolygon.getPoints().get(6) + xMovement3);
		currentUpperLipPolygon.getPoints().set(8, currentUpperLipPolygon.getPoints().get(8) + xMovement4);
		currentUpperLipPolygon.getPoints().set(9, currentUpperLipPolygon.getPoints().get(9) - yMovement4);
		currentUpperLipPolygon.getPoints().set(11, currentUpperLipPolygon.getPoints().get(11) - yMovement5);
		currentUpperLipPolygon.getPoints().set(13, currentUpperLipPolygon.getPoints().get(13) - yMovement4);
		currentUpperLipPolygon.getPoints().set(12, currentUpperLipPolygon.getPoints().get(12) - xMovement4);
		currentUpperLipPolygon.getPoints().set(14, currentUpperLipPolygon.getPoints().get(14) - xMovement3);
		currentUpperLipPolygon.getPoints().set(16, currentUpperLipPolygon.getPoints().get(16) - xMovement2);
		currentUpperLipPolygon.getPoints().set(18, currentUpperLipPolygon.getPoints().get(18) - xMovement1);
		currentUpperLipPolygon.getPoints().set(20, currentUpperLipPolygon.getPoints().get(20) - xMovement0);
		currentUpperLipPolygon.getPoints().set(21, currentUpperLipPolygon.getPoints().get(21) + yMovement0);
		
		currentUpperLipPolygon.getPoints().set(22, currentUpperLipPolygon.getPoints().get(22) - xMovement11);
		currentUpperLipPolygon.getPoints().set(24, currentUpperLipPolygon.getPoints().get(24) - xMovement12);
		currentUpperLipPolygon.getPoints().set(25, currentUpperLipPolygon.getPoints().get(25) - yMovement12);
		currentUpperLipPolygon.getPoints().set(26, currentUpperLipPolygon.getPoints().get(26) - xMovement13);
		currentUpperLipPolygon.getPoints().set(27, currentUpperLipPolygon.getPoints().get(27) - yMovement13);
		currentUpperLipPolygon.getPoints().set(28, currentUpperLipPolygon.getPoints().get(28) - xMovement14);
		currentUpperLipPolygon.getPoints().set(29, currentUpperLipPolygon.getPoints().get(29) - yMovement14);
		currentUpperLipPolygon.getPoints().set(31, currentUpperLipPolygon.getPoints().get(31) - yMovement15);
		currentUpperLipPolygon.getPoints().set(33, currentUpperLipPolygon.getPoints().get(33) - yMovement14);
		currentUpperLipPolygon.getPoints().set(32, currentUpperLipPolygon.getPoints().get(32) + xMovement14);
		currentUpperLipPolygon.getPoints().set(35, currentUpperLipPolygon.getPoints().get(35) - yMovement13);
		currentUpperLipPolygon.getPoints().set(34, currentUpperLipPolygon.getPoints().get(34) + xMovement13);
		currentUpperLipPolygon.getPoints().set(37, currentUpperLipPolygon.getPoints().get(37) - yMovement12);
		currentUpperLipPolygon.getPoints().set(36, currentUpperLipPolygon.getPoints().get(36) + xMovement12);
		currentUpperLipPolygon.getPoints().set(38, currentUpperLipPolygon.getPoints().get(38) + xMovement11);
		
		return currentUpperLipPolygon;
	}
	
	public static Polygon modifyDownLip(Polygon currentDownLipPolygon, float step, String sign)
	{
		int sig;
		
		if(sign.equalsIgnoreCase("PLUS"))
			sig = 1;
		else
			sig = -1;
		
		float xMovement0;
		float yMovement0;
		float xMovement1;
		float yMovement1;
		float xMovement2;
		float yMovement2;
		float xMovement3;
		float yMovement3;
		float xMovement4;
		float yMovement4;
		float yMovement5;
		float xMovement11;
		float xMovement12;
		float yMovement12;
		float xMovement13;
		float yMovement13;
		float xMovement14;
		float yMovement14;
		float yMovement15;
		
		xMovement0 = sig * (20 - step) * 0.0210f;
		yMovement0 = sig * (20 - step) * 0.0158f;
		xMovement1 = sig * (20 - step) * 0.0210f;
		yMovement1 = sig * (20 - step) * 0.0026f;
		xMovement2 = sig * (20 - step) * 0.0263f;
		yMovement2 = sig * (20 - step) * 0.0210f;
		xMovement3 = sig * (20 - step) * 0.0210f;
		yMovement3 = sig * (20 - step) * 0.0318f;
		xMovement4 = sig * (20 - step) * 0.0052f;
		yMovement4 = sig * (20 - step) * 0.0342f;
		yMovement5 = sig * (20 - step) * 0.0237f;
		xMovement11 = sig * (20 - step) * 0.0210f;
		xMovement12 = sig * (20 - step) * 0.0263f;
		yMovement12 = sig * (20 - step) * 0.0105f;
		xMovement13 = sig * (20 - step) * 0.0210f;
		yMovement13 = sig * (20 - step) * 0.0158f;
		xMovement14 = sig * (20 - step) * 0.0052f;
		yMovement14 = sig * (20 - step) * 0.0184f;
		yMovement15 = sig * (20 - step) * 0.0184f;
		
		currentDownLipPolygon.getPoints().set(0, currentDownLipPolygon.getPoints().get(0) + xMovement0);
		currentDownLipPolygon.getPoints().set(1, currentDownLipPolygon.getPoints().get(1) + yMovement0);
		currentDownLipPolygon.getPoints().set(2, currentDownLipPolygon.getPoints().get(3) + xMovement1);
		currentDownLipPolygon.getPoints().set(3, currentDownLipPolygon.getPoints().get(3) - yMovement1);
		currentDownLipPolygon.getPoints().set(4, currentDownLipPolygon.getPoints().get(4) + xMovement2);
		currentDownLipPolygon.getPoints().set(5, currentDownLipPolygon.getPoints().get(5) - yMovement2);
		currentDownLipPolygon.getPoints().set(6, currentDownLipPolygon.getPoints().get(6) + xMovement3);
		currentDownLipPolygon.getPoints().set(7, currentDownLipPolygon.getPoints().get(7) - yMovement3);
		currentDownLipPolygon.getPoints().set(8, currentDownLipPolygon.getPoints().get(8) + xMovement4);
		currentDownLipPolygon.getPoints().set(9, currentDownLipPolygon.getPoints().get(9) - yMovement4);
		currentDownLipPolygon.getPoints().set(11, currentDownLipPolygon.getPoints().get(11) - yMovement5);
		currentDownLipPolygon.getPoints().set(13, currentDownLipPolygon.getPoints().get(13) - yMovement4);
		currentDownLipPolygon.getPoints().set(12, currentDownLipPolygon.getPoints().get(12) - xMovement4);
		currentDownLipPolygon.getPoints().set(15, currentDownLipPolygon.getPoints().get(15) - yMovement3);
		currentDownLipPolygon.getPoints().set(14, currentDownLipPolygon.getPoints().get(14) - xMovement3);
		currentDownLipPolygon.getPoints().set(17, currentDownLipPolygon.getPoints().get(17) - yMovement2);
		currentDownLipPolygon.getPoints().set(16, currentDownLipPolygon.getPoints().get(16) - xMovement2);
		currentDownLipPolygon.getPoints().set(19, currentDownLipPolygon.getPoints().get(19) - yMovement1);
		currentDownLipPolygon.getPoints().set(18, currentDownLipPolygon.getPoints().get(18) - xMovement1);
		currentDownLipPolygon.getPoints().set(21, currentDownLipPolygon.getPoints().get(21) + yMovement0);
		currentDownLipPolygon.getPoints().set(20, currentDownLipPolygon.getPoints().get(20) - xMovement0);
		currentDownLipPolygon.getPoints().set(22, currentDownLipPolygon.getPoints().get(22) - xMovement11);
		currentDownLipPolygon.getPoints().set(24, currentDownLipPolygon.getPoints().get(24) - xMovement12);
		currentDownLipPolygon.getPoints().set(25, currentDownLipPolygon.getPoints().get(25) - yMovement12);
		currentDownLipPolygon.getPoints().set(26, currentDownLipPolygon.getPoints().get(26) - xMovement13);
		currentDownLipPolygon.getPoints().set(27, currentDownLipPolygon.getPoints().get(27) - yMovement13);
		currentDownLipPolygon.getPoints().set(28, currentDownLipPolygon.getPoints().get(28) - xMovement14);
		currentDownLipPolygon.getPoints().set(29, currentDownLipPolygon.getPoints().get(29) - yMovement14);
		currentDownLipPolygon.getPoints().set(31, currentDownLipPolygon.getPoints().get(31) - yMovement15);
		currentDownLipPolygon.getPoints().set(33, currentDownLipPolygon.getPoints().get(33) - yMovement14);
		currentDownLipPolygon.getPoints().set(32, currentDownLipPolygon.getPoints().get(32) + xMovement14);
		currentDownLipPolygon.getPoints().set(35, currentDownLipPolygon.getPoints().get(35) - yMovement13);
		currentDownLipPolygon.getPoints().set(34, currentDownLipPolygon.getPoints().get(34) + xMovement13);
		currentDownLipPolygon.getPoints().set(37, currentDownLipPolygon.getPoints().get(37) - yMovement12);
		currentDownLipPolygon.getPoints().set(36, currentDownLipPolygon.getPoints().get(36) + xMovement12);
		currentDownLipPolygon.getPoints().set(38, currentDownLipPolygon.getPoints().get(38) + xMovement11);
		
		
		return currentDownLipPolygon;
	}

}
