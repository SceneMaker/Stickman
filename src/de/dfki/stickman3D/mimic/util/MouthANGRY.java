package de.dfki.stickman3D.mimic.util;

import javafx.scene.shape.Polygon;

public class MouthANGRY {
	
	public static Polygon modifyUpperLip(Polygon currentUpperLipPolygon, float step, String sign)
	{
		int sig;
		
		if(sign.equalsIgnoreCase("PLUS"))
			sig = 1;
		else
			sig = -1;
		
		float yMovement0;
		float yMovement5;
		
		yMovement5 = sig * (20 - step) * 0.0105f;
		yMovement0 = sig * (20 - step) * 0.0210f;
		yMovement5 = sig * (20 - step) * 0.0158f;

		
		currentUpperLipPolygon.getPoints().set(11, currentUpperLipPolygon.getPoints().get(11) - yMovement5);
		currentUpperLipPolygon.getPoints().set(1, currentUpperLipPolygon.getPoints().get(1) + yMovement0);
		currentUpperLipPolygon.getPoints().set(21, currentUpperLipPolygon.getPoints().get(21) + yMovement0);
		
		return currentUpperLipPolygon;
	}
	
	public static Polygon modifyDownLip(Polygon currentDownLipPolygon, float step, String sign)
	{
		int sig;
		
		if(sign.equalsIgnoreCase("PLUS"))
			sig = 1;
		else
			sig = -1;
		
		float yMovement0;
		float yMovement2;
		float yMovement3;
		float yMovement4;
		float yMovement5;
		
		yMovement5 = sig * (20 - step) * 0.0105f;
		yMovement0 = sig * (20 - step) * 0.0210f;
		yMovement2 = sig * (20 - step) * 0.0158f;
		yMovement3 = sig * (20 - step) * 0.0263f;
		yMovement4 = sig * (20 - step) * 0.0263f;
		yMovement5 = sig * (20 - step) * 0.0158f;
		
		currentDownLipPolygon.getPoints().set(1, currentDownLipPolygon.getPoints().get(1) + yMovement0);
		currentDownLipPolygon.getPoints().set(5, currentDownLipPolygon.getPoints().get(5) - yMovement2);
		currentDownLipPolygon.getPoints().set(7, currentDownLipPolygon.getPoints().get(7) - yMovement3);
		currentDownLipPolygon.getPoints().set(9, currentDownLipPolygon.getPoints().get(9) - yMovement4);
		currentDownLipPolygon.getPoints().set(11, currentDownLipPolygon.getPoints().get(11) - yMovement5);
		currentDownLipPolygon.getPoints().set(13, currentDownLipPolygon.getPoints().get(13) - yMovement4);
		currentDownLipPolygon.getPoints().set(15, currentDownLipPolygon.getPoints().get(15) - yMovement3);
		currentDownLipPolygon.getPoints().set(17, currentDownLipPolygon.getPoints().get(17) - yMovement2);
		currentDownLipPolygon.getPoints().set(21, currentDownLipPolygon.getPoints().get(21) + yMovement0);
		
		return currentDownLipPolygon;
	}

}
