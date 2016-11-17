package de.dfki.stickman3D.mimic.util;

import javafx.scene.shape.Polygon;

public class MouthSMILE {
	
	
	private float optimateValue(float movement, float movementFactor)
	{
		if(movement > movementFactor * 18)
		{
			movement = movement * 18;
		}
		return movement;
	}
	public static Polygon modifyUpperLip(Polygon currentUpperLipPolygon, float step, String sign)
	{
		int sig;
		
		if(sign.equalsIgnoreCase("PLUS"))
			sig = 1;
		else
			sig = -1;
		
		float xMovement0 = 0;
		float yMovement0 = 0;
		float xMovement1 = 0;
		float yMovement1;
		float xMovement19;
		float yMovement19;
		float yMovement2;
		float yMovement3;
		float yMovement4;
		float yMovement5;
		
		float xMovement10;
		float yMovement10;
		float xMovement9;
		float yMovement9;
		float xMovement11;
		float yMovement11;
		float yMovement8;
		float yMovement7;
		float yMovement6;
		
		 xMovement0 = sig * (20 - step) * 0.0263f;
		 yMovement0 = sig *  (20 - step) * 0.0316f;
		 xMovement1 = sig *  (20 - step) * 0.0158f;
		 yMovement1 = sig * (20 - step) * 0.0105f;
		 xMovement19 = sig * (20 - step) * 0.0158f;
		 yMovement19 = sig * (20 - step) * 0.0105f;
		 yMovement2 = sig * (20 - step) * 0.0053f;
		 yMovement3 = sig * (20 - step) * 0.0105f;
		 yMovement4 = sig * (20 - step) * 0.0158f;
		 yMovement5 = sig * (20 - step) * 0.0053f;
		
		 xMovement10 = sig * (20 - step) * 0.0263f;
		 yMovement10 = sig * (20 - step) * 0.0316f;
		 xMovement9 = sig * (20 - step) * 0.0158f;
		 yMovement9 = sig * (20 - step) * 0.0105f;
		 xMovement11 = sig * (20 - step) * 0.0158f;
		 yMovement11 = sig * (20 - step) * 0.0105f;
		 yMovement8 = sig * (20 - step) * 0.0053f;
		 yMovement7 = sig * (20 - step) * 0.0105f;
		 yMovement6 = sig * (20 - step) * 0.0158f;
		
		currentUpperLipPolygon.getPoints().set(0, currentUpperLipPolygon.getPoints().get(0) - xMovement0);
		currentUpperLipPolygon.getPoints().set(1, currentUpperLipPolygon.getPoints().get(1) - yMovement0);
		currentUpperLipPolygon.getPoints().set(2, currentUpperLipPolygon.getPoints().get(2) - xMovement1);
		currentUpperLipPolygon.getPoints().set(3, currentUpperLipPolygon.getPoints().get(3) - yMovement1);
		currentUpperLipPolygon.getPoints().set(38, currentUpperLipPolygon.getPoints().get(38) - xMovement19);
		currentUpperLipPolygon.getPoints().set(39, currentUpperLipPolygon.getPoints().get(39) - yMovement19);
		currentUpperLipPolygon.getPoints().set(5, currentUpperLipPolygon.getPoints().get(5) + yMovement2);
		currentUpperLipPolygon.getPoints().set(7, currentUpperLipPolygon.getPoints().get(7) + yMovement3);
		currentUpperLipPolygon.getPoints().set(9, currentUpperLipPolygon.getPoints().get(9) + yMovement4);
		currentUpperLipPolygon.getPoints().set(11, currentUpperLipPolygon.getPoints().get(11) + yMovement5);
//		//------------------------------//
		currentUpperLipPolygon.getPoints().set(20, currentUpperLipPolygon.getPoints().get(20) + xMovement10);
		currentUpperLipPolygon.getPoints().set(21, currentUpperLipPolygon.getPoints().get(21) - yMovement10);
		currentUpperLipPolygon.getPoints().set(18, currentUpperLipPolygon.getPoints().get(18) + xMovement9);
		currentUpperLipPolygon.getPoints().set(19, currentUpperLipPolygon.getPoints().get(19) - yMovement9);
		currentUpperLipPolygon.getPoints().set(22, currentUpperLipPolygon.getPoints().get(22) + xMovement11);
		currentUpperLipPolygon.getPoints().set(23, currentUpperLipPolygon.getPoints().get(23) - yMovement11);
		currentUpperLipPolygon.getPoints().set(17, currentUpperLipPolygon.getPoints().get(17) + yMovement8);
		currentUpperLipPolygon.getPoints().set(15, currentUpperLipPolygon.getPoints().get(15) + yMovement7);
		currentUpperLipPolygon.getPoints().set(13, currentUpperLipPolygon.getPoints().get(13) + yMovement6);
		
		return currentUpperLipPolygon;
	}
	
	public static Polygon modifyDownLip(Polygon currentDownLipMesh, float step, String sign)
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
		float xMovement19;
		float yMovement19;
		float xMovement10;
		float yMovement10;
		float xMovement9;
		float yMovement9;
		float xMovement11;
		float yMovement11;

		xMovement0 = sig * (20 - step) * 0.0263f;
		yMovement0 = sig * (20 - step) * 0.0316f;
		xMovement1 = sig * (20 - step) * 0.0158f;
		yMovement1 = sig * (20 - step) * 0.0105f;
		xMovement19 = sig * (20 - step) * 0.0158f;
		yMovement19 = sig * (20 - step) * 0.0105f;
		xMovement10 = sig * (20 - step) * 0.0263f;
		yMovement10 = sig * (20 - step) * 0.0316f;
		xMovement9 = sig * (20 - step) * 0.0158f;
		yMovement9 = sig * (20 - step) * 0.0105f;
		xMovement11 = sig * (20 - step) * 0.0158f;
		yMovement11 = sig * (20 - step) * 0.0105f;
		
		currentDownLipMesh.getPoints().set(0, currentDownLipMesh.getPoints().get(0) - xMovement0);
		currentDownLipMesh.getPoints().set(1, currentDownLipMesh.getPoints().get(1) - yMovement0);
		currentDownLipMesh.getPoints().set(38, currentDownLipMesh.getPoints().get(38) - xMovement1);
		currentDownLipMesh.getPoints().set(39, currentDownLipMesh.getPoints().get(39) - yMovement1);
		currentDownLipMesh.getPoints().set(2, currentDownLipMesh.getPoints().get(2) - xMovement19);
		currentDownLipMesh.getPoints().set(3, currentDownLipMesh.getPoints().get(3) - yMovement19);
		currentDownLipMesh.getPoints().set(20, currentDownLipMesh.getPoints().get(20) + xMovement10);
		currentDownLipMesh.getPoints().set(21, currentDownLipMesh.getPoints().get(21) - yMovement10);
		currentDownLipMesh.getPoints().set(24, currentDownLipMesh.getPoints().get(24) + xMovement9);
		currentDownLipMesh.getPoints().set(25, currentDownLipMesh.getPoints().get(25) - yMovement9);
		currentDownLipMesh.getPoints().set(18, currentDownLipMesh.getPoints().get(18) + xMovement11);
		currentDownLipMesh.getPoints().set(19, currentDownLipMesh.getPoints().get(19) - yMovement11);
		
		return currentDownLipMesh;
	}

}
