package de.dfki.stickmanfx.mimic.util;

import de.dfki.stickmanfx.animationlogic.AnimatorFX;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.TriangleMesh;

public class MouthFOUR {
	
	public static Polygon modifyUpperLip(Polygon currentUpperLipMesh, float step, String sign)
	{
		int sig;
		
		if(sign.equalsIgnoreCase("PLUS"))
			sig = 1;
		else
			sig = -1;
		
		float yMovement18;

		yMovement18 = sig * (20 - step) * 0.0052f;
		
		currentUpperLipMesh.getPoints().set(35, currentUpperLipMesh.getPoints().get(35) - yMovement18);
		currentUpperLipMesh.getPoints().set(33, currentUpperLipMesh.getPoints().get(33) - yMovement18);
		currentUpperLipMesh.getPoints().set(31, currentUpperLipMesh.getPoints().get(31) - yMovement18);
		currentUpperLipMesh.getPoints().set(29, currentUpperLipMesh.getPoints().get(29) - yMovement18);
		currentUpperLipMesh.getPoints().set(27, currentUpperLipMesh.getPoints().get(27) - yMovement18);
		
		
		return currentUpperLipMesh;
	}
	
	public static Polygon modifyDownLip(Polygon currentDownLipMesh, float step, String sign)
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
		float yMovement17;
		float yMovement16;
		float yMovement15;
		
		yMovement2 = sig * (20 - step) * 0.0052f;
		yMovement3 = sig * (20 - step) * 0.0158f;
		yMovement4 = sig * (20 - step) * 0.0263f;
		yMovement5 = sig * (20 - step) * 0.0368f;
		yMovement17 = sig * (20 - step) * 0.0263f;
		yMovement16 = sig * (20 - step) * 0.0316f;
		yMovement15 = sig * (20 - step) * 0.0316f;
		
		currentDownLipMesh.getPoints().set(5, currentDownLipMesh.getPoints().get(5) + yMovement2);
		currentDownLipMesh.getPoints().set(7, currentDownLipMesh.getPoints().get(7) + yMovement3);
		currentDownLipMesh.getPoints().set(9, currentDownLipMesh.getPoints().get(9) + yMovement4);
		currentDownLipMesh.getPoints().set(11, currentDownLipMesh.getPoints().get(11) + yMovement5);
		currentDownLipMesh.getPoints().set(13, currentDownLipMesh.getPoints().get(13) + yMovement4);
		currentDownLipMesh.getPoints().set(15, currentDownLipMesh.getPoints().get(15) + yMovement3);
		currentDownLipMesh.getPoints().set(17, currentDownLipMesh.getPoints().get(17) + yMovement2);
		
		currentDownLipMesh.getPoints().set(35, currentDownLipMesh.getPoints().get(35) + yMovement17);
		currentDownLipMesh.getPoints().set(33, currentDownLipMesh.getPoints().get(33) + yMovement16);
		currentDownLipMesh.getPoints().set(31, currentDownLipMesh.getPoints().get(31) + yMovement15);
		currentDownLipMesh.getPoints().set(29, currentDownLipMesh.getPoints().get(29) + yMovement16);
		currentDownLipMesh.getPoints().set(27, currentDownLipMesh.getPoints().get(27) + yMovement17);
		
		return currentDownLipMesh;
	}

}
