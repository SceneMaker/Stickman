package de.dfki.stickmanfx.mimic.util;

import de.dfki.stickmanfx.animationlogic.AnimatorFX;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.TriangleMesh;

public class MouthONE {
	
	public static Polygon modifyUpperLip(Polygon currentUpperLipMesh, float step, String sign)
	{
		int sig;
		
		if(sign.equalsIgnoreCase("PLUS"))
			sig = 1;
		else
			sig = -1;
		
		float yMovement18;
		float yMovement17;
		float yMovement16;
		float yMovement15;
		
		yMovement18 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0052f;
		yMovement17 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0105f;
		yMovement16 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0105f;
		yMovement15 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0105f;
		
		currentUpperLipMesh.getPoints().set(37, currentUpperLipMesh.getPoints().get(37) - yMovement18);
		currentUpperLipMesh.getPoints().set(35, currentUpperLipMesh.getPoints().get(35) - yMovement17);
		currentUpperLipMesh.getPoints().set(33, currentUpperLipMesh.getPoints().get(33) - yMovement16);
		currentUpperLipMesh.getPoints().set(31, currentUpperLipMesh.getPoints().get(31) - yMovement15);
		currentUpperLipMesh.getPoints().set(29, currentUpperLipMesh.getPoints().get(29) - yMovement16);
		currentUpperLipMesh.getPoints().set(27, currentUpperLipMesh.getPoints().get(27) - yMovement17);
		currentUpperLipMesh.getPoints().set(25, currentUpperLipMesh.getPoints().get(25) - yMovement18);
		
		return currentUpperLipMesh;
	}
	
	public static Polygon modifyDownLip(Polygon currentDownLipMesh, float step, String sign)
	{
		
		int sig;
		
		if(sign.equalsIgnoreCase("PLUS"))
			sig = 1;
		else
			sig = -1;
		
		float yMovement18;
		float yMovement17;
		float yMovement16;
		float yMovement15;
		
		yMovement18 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0052f;
		yMovement17 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0105f;
		yMovement16 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0105f;
		yMovement15 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0105f;
		
		currentDownLipMesh.getPoints().set(37, currentDownLipMesh.getPoints().get(37) + yMovement18);
		currentDownLipMesh.getPoints().set(35, currentDownLipMesh.getPoints().get(35) + yMovement17);
		currentDownLipMesh.getPoints().set(33, currentDownLipMesh.getPoints().get(33) + yMovement16);
		currentDownLipMesh.getPoints().set(31, currentDownLipMesh.getPoints().get(31) + yMovement15);
		currentDownLipMesh.getPoints().set(29, currentDownLipMesh.getPoints().get(29) + yMovement16);
		currentDownLipMesh.getPoints().set(27, currentDownLipMesh.getPoints().get(27) + yMovement17);
		currentDownLipMesh.getPoints().set(25, currentDownLipMesh.getPoints().get(25) + yMovement18);
		
		
		return currentDownLipMesh;
	}

}
