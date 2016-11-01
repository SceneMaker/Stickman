package de.dfki.stickmanfx.mimic.util;

import de.dfki.stickmanfx.animationlogic.AnimatorFX;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.TriangleMesh;

public class MouthSURPRISED {
	
	public static Polygon modifyUpperLip(Polygon currentUpperLipPolygon, float step, String sign)
	{
		int sig;
		
		if(sign.equalsIgnoreCase("PLUS"))
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
		float yMovement11;
		float yMovement12;
		float yMovement13;
		float yMovement14;
		float yMovement15;
		float yMovement16;
		float yMovement17;
		
		yMovement2 = sig * (20 - step) * 0.0158f;
		yMovement3 = sig * (20 - step) * 0.0263f;
		yMovement4 = sig * (20 - step) * 0.0368f;
		yMovement5 = sig * (20 - step) * 0.0526f;
		yMovement6 = sig * (20 - step) * 0.0368f;
		yMovement7 = sig * (20 - step) * 0.0263f;
		yMovement8 = sig * (20 - step) * 0.0158f;
		yMovement9 = sig * (20 - step) * 0.0105f;
		
		yMovement11 = sig * (20 - step) * 0.0158f;
		yMovement12 = sig * (20 - step) * 0.0263f;
		yMovement13 = sig * (20 - step) * 0.0421f;
		yMovement14 = sig * (20 - step) * 0.0473f;
		yMovement15 = sig * (20 - step) * 0.0421f;
		yMovement16 = sig * (20 - step) * 0.0263f;
		yMovement17 = sig * (20 - step) * 0.0158f;

		
		currentUpperLipPolygon.getPoints().set(5, currentUpperLipPolygon.getPoints().get(5) - yMovement2);
		currentUpperLipPolygon.getPoints().set(7, currentUpperLipPolygon.getPoints().get(7) - yMovement3);
		currentUpperLipPolygon.getPoints().set(9, currentUpperLipPolygon.getPoints().get(9) - yMovement4);
		currentUpperLipPolygon.getPoints().set(11, currentUpperLipPolygon.getPoints().get(11) - yMovement5);
		currentUpperLipPolygon.getPoints().set(13, currentUpperLipPolygon.getPoints().get(13) - yMovement6);
		currentUpperLipPolygon.getPoints().set(15, currentUpperLipPolygon.getPoints().get(15) - yMovement7);
		currentUpperLipPolygon.getPoints().set(17, currentUpperLipPolygon.getPoints().get(17) - yMovement8);
		currentUpperLipPolygon.getPoints().set(12, currentUpperLipPolygon.getPoints().get(12) - yMovement9);
		
		currentUpperLipPolygon.getPoints().set(37, currentUpperLipPolygon.getPoints().get(37) - yMovement11);
		currentUpperLipPolygon.getPoints().set(35, currentUpperLipPolygon.getPoints().get(35) - yMovement12);
		currentUpperLipPolygon.getPoints().set(33, currentUpperLipPolygon.getPoints().get(33) - yMovement13);
		currentUpperLipPolygon.getPoints().set(31, currentUpperLipPolygon.getPoints().get(31) - yMovement14);
		currentUpperLipPolygon.getPoints().set(29, currentUpperLipPolygon.getPoints().get(29) - yMovement15);
		currentUpperLipPolygon.getPoints().set(27, currentUpperLipPolygon.getPoints().get(27) - yMovement16);
		currentUpperLipPolygon.getPoints().set(25, currentUpperLipPolygon.getPoints().get(25) - yMovement17);	
		
		return currentUpperLipPolygon;
	}
	
	public static Polygon modifyDownLip(Polygon currentDownLipPolygon, float step, String sign)
	{
		int sig;
		
		if(sign.equalsIgnoreCase("PLUS"))
			sig = 1;
		else
			sig = -1;
		
		float yMovement2;
		float yMovement3;
		float yMovement4;
		float yMovement5;
		float yMovement6;
		float yMovement7;
		float yMovement8;
		float yMovement9;
		float yMovement11;
		float yMovement12;
		float yMovement13;
		float yMovement14;
		float yMovement15;
		float yMovement16;
		float yMovement17;
		
		yMovement2 = sig * (20 - step) * 0.0158f;
		yMovement3 = sig * (20 - step) * 0.0263f;
		yMovement4 = sig * (20 - step) * 0.0368f;
		yMovement5 = sig * (20 - step) * 0.0526f;
		yMovement6 = sig * (20 - step) * 0.0368f;
		yMovement7 = sig * (20 - step) * 0.0263f;
		yMovement8 = sig * (20 - step) * 0.0158f;
		yMovement9 = sig * (20 - step) * 0.0105f;
		
		yMovement11 = sig * (20 - step) * 0.0158f;
		yMovement12 = sig * (20 - step) * 0.0263f;
		yMovement13 = sig * (20 - step) * 0.0421f;
		yMovement14 = sig * (20 - step) * 0.0473f;
		yMovement15 = sig * (20 - step) * 0.0421f;
		yMovement16 = sig * (20 - step) * 0.0263f;
		yMovement17 = sig * (20 - step) * 0.0158f;
		
		currentDownLipPolygon.getPoints().set(5, currentDownLipPolygon.getPoints().get(5) + yMovement2);
		currentDownLipPolygon.getPoints().set(7, currentDownLipPolygon.getPoints().get(7) + yMovement3);
		currentDownLipPolygon.getPoints().set(9, currentDownLipPolygon.getPoints().get(9) + yMovement4);
		currentDownLipPolygon.getPoints().set(11, currentDownLipPolygon.getPoints().get(11) + yMovement5);
		currentDownLipPolygon.getPoints().set(13, currentDownLipPolygon.getPoints().get(13) + yMovement6);
		currentDownLipPolygon.getPoints().set(15, currentDownLipPolygon.getPoints().get(15) + yMovement7);
		currentDownLipPolygon.getPoints().set(17, currentDownLipPolygon.getPoints().get(17) + yMovement8);
		currentDownLipPolygon.getPoints().set(12, currentDownLipPolygon.getPoints().get(12) + yMovement9);
		
		currentDownLipPolygon.getPoints().set(37, currentDownLipPolygon.getPoints().get(37) + yMovement11);
		currentDownLipPolygon.getPoints().set(35, currentDownLipPolygon.getPoints().get(35) + yMovement12);
		currentDownLipPolygon.getPoints().set(33, currentDownLipPolygon.getPoints().get(33) + yMovement13);
		currentDownLipPolygon.getPoints().set(31, currentDownLipPolygon.getPoints().get(31) + yMovement14);
		currentDownLipPolygon.getPoints().set(29, currentDownLipPolygon.getPoints().get(29) + yMovement15);
		currentDownLipPolygon.getPoints().set(27, currentDownLipPolygon.getPoints().get(27) + yMovement16);
		currentDownLipPolygon.getPoints().set(25, currentDownLipPolygon.getPoints().get(25) + yMovement17);		
		return currentDownLipPolygon;
	}

}
