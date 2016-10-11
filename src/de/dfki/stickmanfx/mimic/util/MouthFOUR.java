package de.dfki.stickmanfx.mimic.util;

import de.dfki.stickmanfx.animationlogic.AnimatorFX;
import javafx.scene.shape.TriangleMesh;

public class MouthFOUR {
	
	public static TriangleMesh modifyUpperLip(TriangleMesh currentUpperLipMesh, float step, String sign)
	{
		int sig;
		
		if(sign.equalsIgnoreCase("PLUS"))
			sig = 1;
		else
			sig = -1;
		
		float yMovement18;

		yMovement18 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0052f;
		
		currentUpperLipMesh.getPoints().set(52, currentUpperLipMesh.getPoints().get(52) - yMovement18);
		currentUpperLipMesh.getPoints().set(49, currentUpperLipMesh.getPoints().get(49) - yMovement18);
		currentUpperLipMesh.getPoints().set(46, currentUpperLipMesh.getPoints().get(46) - yMovement18);
		currentUpperLipMesh.getPoints().set(43, currentUpperLipMesh.getPoints().get(43) - yMovement18);
		currentUpperLipMesh.getPoints().set(40, currentUpperLipMesh.getPoints().get(40) - yMovement18);
		
		
		return currentUpperLipMesh;
	}
	
	public static TriangleMesh modifyDownLip(TriangleMesh currentDownLipMesh, float step, String sign)
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
		
		yMovement2 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0052f;
		yMovement3 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0158f;
		yMovement4 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0263f;
		yMovement5 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0368f;
		yMovement17 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0263f;
		yMovement16 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0316f;
		yMovement15 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0316f;
		
		currentDownLipMesh.getPoints().set(7, currentDownLipMesh.getPoints().get(7) + yMovement2);
		currentDownLipMesh.getPoints().set(10, currentDownLipMesh.getPoints().get(10) + yMovement3);
		currentDownLipMesh.getPoints().set(13, currentDownLipMesh.getPoints().get(13) + yMovement4);
		currentDownLipMesh.getPoints().set(16, currentDownLipMesh.getPoints().get(16) + yMovement5);
		currentDownLipMesh.getPoints().set(19, currentDownLipMesh.getPoints().get(19) + yMovement4);
		currentDownLipMesh.getPoints().set(22, currentDownLipMesh.getPoints().get(22) + yMovement3);
		currentDownLipMesh.getPoints().set(25, currentDownLipMesh.getPoints().get(25) + yMovement2);
		
		currentDownLipMesh.getPoints().set(52, currentDownLipMesh.getPoints().get(52) + yMovement17);
		currentDownLipMesh.getPoints().set(49, currentDownLipMesh.getPoints().get(49) + yMovement16);
		currentDownLipMesh.getPoints().set(46, currentDownLipMesh.getPoints().get(46) + yMovement15);
		currentDownLipMesh.getPoints().set(43, currentDownLipMesh.getPoints().get(43) + yMovement16);
		currentDownLipMesh.getPoints().set(40, currentDownLipMesh.getPoints().get(40) + yMovement17);
		
		return currentDownLipMesh;
	}

}
