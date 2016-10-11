package de.dfki.stickmanfx.mimic.util;

import de.dfki.stickmanfx.animationlogic.AnimatorFX;
import javafx.scene.shape.TriangleMesh;

public class MouthONE {
	
	public static TriangleMesh modifyUpperLip(TriangleMesh currentUpperLipMesh, float step, String sign)
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
		
		currentUpperLipMesh.getPoints().set(55, currentUpperLipMesh.getPoints().get(55) - yMovement18);
		currentUpperLipMesh.getPoints().set(52, currentUpperLipMesh.getPoints().get(52) - yMovement17);
		currentUpperLipMesh.getPoints().set(49, currentUpperLipMesh.getPoints().get(49) - yMovement16);
		currentUpperLipMesh.getPoints().set(46, currentUpperLipMesh.getPoints().get(46) - yMovement15);
		currentUpperLipMesh.getPoints().set(43, currentUpperLipMesh.getPoints().get(43) - yMovement16);
		currentUpperLipMesh.getPoints().set(40, currentUpperLipMesh.getPoints().get(40) - yMovement17);
		currentUpperLipMesh.getPoints().set(37, currentUpperLipMesh.getPoints().get(37) - yMovement18);
		
		return currentUpperLipMesh;
	}
	
	public static TriangleMesh modifyDownLip(TriangleMesh currentDownLipMesh, float step, String sign)
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
		
		currentDownLipMesh.getPoints().set(55, currentDownLipMesh.getPoints().get(55) + yMovement18);
		currentDownLipMesh.getPoints().set(52, currentDownLipMesh.getPoints().get(52) + yMovement17);
		currentDownLipMesh.getPoints().set(49, currentDownLipMesh.getPoints().get(49) + yMovement16);
		currentDownLipMesh.getPoints().set(46, currentDownLipMesh.getPoints().get(46) + yMovement15);
		currentDownLipMesh.getPoints().set(43, currentDownLipMesh.getPoints().get(43) + yMovement16);
		currentDownLipMesh.getPoints().set(40, currentDownLipMesh.getPoints().get(40) + yMovement17);
		currentDownLipMesh.getPoints().set(37, currentDownLipMesh.getPoints().get(37) + yMovement18);
		
		
		return currentDownLipMesh;
	}

}
