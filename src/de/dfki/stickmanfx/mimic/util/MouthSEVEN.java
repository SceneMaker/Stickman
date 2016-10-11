package de.dfki.stickmanfx.mimic.util;

import de.dfki.stickmanfx.animationlogic.AnimatorFX;
import javafx.scene.shape.TriangleMesh;

public class MouthSEVEN {
	
	public static TriangleMesh modifyUpperLip(TriangleMesh currentUpperLipMesh, float step, String sign)
	{
		int sig;
		
		if(sign.equalsIgnoreCase("PLUS"))
			sig = 1;
		else
			sig = -1;
		
		float xMovement0;
		float xMovement1;
		float xMovement2;
		float yMovement2;
		float xMovement3;
		float yMovement3;
		float xMovement4;
		float yMovement4;
		float yMovement5;
		
		xMovement0 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0368f;
		xMovement1 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0316f;
		xMovement2 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0263f;
		yMovement2 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0052f;
		xMovement3 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0210f;
		yMovement3 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0052f;
		xMovement4 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0052f;
		yMovement4 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0052f;
		yMovement5 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0052f;
		
		currentUpperLipMesh.getPoints().set(0, currentUpperLipMesh.getPoints().get(0) + xMovement0);
		currentUpperLipMesh.getPoints().set(3, currentUpperLipMesh.getPoints().get(3) + xMovement1);
		currentUpperLipMesh.getPoints().set(6, currentUpperLipMesh.getPoints().get(6) + xMovement2);
		currentUpperLipMesh.getPoints().set(7, currentUpperLipMesh.getPoints().get(7) + yMovement2);
		currentUpperLipMesh.getPoints().set(9, currentUpperLipMesh.getPoints().get(9) + xMovement3);
		currentUpperLipMesh.getPoints().set(10, currentUpperLipMesh.getPoints().get(10) + yMovement3);
		currentUpperLipMesh.getPoints().set(12, currentUpperLipMesh.getPoints().get(12) + xMovement4);
		currentUpperLipMesh.getPoints().set(13, currentUpperLipMesh.getPoints().get(13) + yMovement4);
		
		currentUpperLipMesh.getPoints().set(16, currentUpperLipMesh.getPoints().get(16) - yMovement5);
		
		currentUpperLipMesh.getPoints().set(19, currentUpperLipMesh.getPoints().get(19) + yMovement4);
		currentUpperLipMesh.getPoints().set(18, currentUpperLipMesh.getPoints().get(18) - xMovement4);
		currentUpperLipMesh.getPoints().set(22, currentUpperLipMesh.getPoints().get(22) + yMovement3);
		currentUpperLipMesh.getPoints().set(21, currentUpperLipMesh.getPoints().get(21) - xMovement3);
		currentUpperLipMesh.getPoints().set(25, currentUpperLipMesh.getPoints().get(25) + yMovement2);
		currentUpperLipMesh.getPoints().set(24, currentUpperLipMesh.getPoints().get(24) - xMovement2);
		currentUpperLipMesh.getPoints().set(27, currentUpperLipMesh.getPoints().get(27) - xMovement1);
		currentUpperLipMesh.getPoints().set(30, currentUpperLipMesh.getPoints().get(30) - xMovement0);
		
		return currentUpperLipMesh;
	}
	
	public static TriangleMesh modifyDownLip(TriangleMesh currentDownLipMesh, float step, String sign)
	{
		
		int sig;
		
		if(sign.equalsIgnoreCase("PLUS"))
			sig = 1;
		else
			sig = -1;
		
		float xMovement0;
		float xMovement1;
		float xMovement2;
		float yMovement2;
		float xMovement3;
		float yMovement3;
		float xMovement4;
		float yMovement4;
		float yMovement5;
		
		xMovement0 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0368f;
		xMovement1 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0316f;
		xMovement2 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0263f;
		yMovement2 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0052f;
		xMovement3 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0210f;
		yMovement3 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0052f;
		xMovement4 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0052f;
		yMovement4 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0052f;
		yMovement5 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0052f;
		
		currentDownLipMesh.getPoints().set(0, currentDownLipMesh.getPoints().get(0) + xMovement0);
		currentDownLipMesh.getPoints().set(3, currentDownLipMesh.getPoints().get(3) + xMovement1);
		currentDownLipMesh.getPoints().set(6, currentDownLipMesh.getPoints().get(6) + xMovement2);
		currentDownLipMesh.getPoints().set(7, currentDownLipMesh.getPoints().get(7) - yMovement2);
		currentDownLipMesh.getPoints().set(9, currentDownLipMesh.getPoints().get(9) + xMovement3);
		currentDownLipMesh.getPoints().set(10, currentDownLipMesh.getPoints().get(10) - yMovement3);
		currentDownLipMesh.getPoints().set(12, currentDownLipMesh.getPoints().get(12) + xMovement4);
		currentDownLipMesh.getPoints().set(13, currentDownLipMesh.getPoints().get(13) - yMovement4);
		
		currentDownLipMesh.getPoints().set(16, currentDownLipMesh.getPoints().get(16) + yMovement5);
		
		currentDownLipMesh.getPoints().set(19, currentDownLipMesh.getPoints().get(19) - yMovement4);
		currentDownLipMesh.getPoints().set(18, currentDownLipMesh.getPoints().get(18) - xMovement4);
		currentDownLipMesh.getPoints().set(22, currentDownLipMesh.getPoints().get(22) - yMovement3);
		currentDownLipMesh.getPoints().set(21, currentDownLipMesh.getPoints().get(21) - xMovement3);
		currentDownLipMesh.getPoints().set(25, currentDownLipMesh.getPoints().get(25) - yMovement2);
		currentDownLipMesh.getPoints().set(24, currentDownLipMesh.getPoints().get(24) - xMovement2);
		currentDownLipMesh.getPoints().set(27, currentDownLipMesh.getPoints().get(27) - xMovement1);
		currentDownLipMesh.getPoints().set(30, currentDownLipMesh.getPoints().get(30) - xMovement0);
		
		return currentDownLipMesh;
	}

}
