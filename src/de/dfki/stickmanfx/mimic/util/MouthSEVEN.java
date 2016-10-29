package de.dfki.stickmanfx.mimic.util;

import de.dfki.stickmanfx.animationlogic.AnimatorFX;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.TriangleMesh;

public class MouthSEVEN {
	
	public static Polygon modifyUpperLip(Polygon currentUpperLipMesh, float step, String sign)
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
		currentUpperLipMesh.getPoints().set(2, currentUpperLipMesh.getPoints().get(2) + xMovement1);
		currentUpperLipMesh.getPoints().set(4, currentUpperLipMesh.getPoints().get(4) + xMovement2);
		currentUpperLipMesh.getPoints().set(5, currentUpperLipMesh.getPoints().get(5) + yMovement2);
		currentUpperLipMesh.getPoints().set(6, currentUpperLipMesh.getPoints().get(6) + xMovement3);
		currentUpperLipMesh.getPoints().set(7, currentUpperLipMesh.getPoints().get(7) + yMovement3);
		currentUpperLipMesh.getPoints().set(8, currentUpperLipMesh.getPoints().get(8) + xMovement4);
		currentUpperLipMesh.getPoints().set(9, currentUpperLipMesh.getPoints().get(9) + yMovement4);
		
		currentUpperLipMesh.getPoints().set(11, currentUpperLipMesh.getPoints().get(11) - yMovement5);
		
		currentUpperLipMesh.getPoints().set(13, currentUpperLipMesh.getPoints().get(13) + yMovement4);
		currentUpperLipMesh.getPoints().set(12, currentUpperLipMesh.getPoints().get(12) - xMovement4);
		currentUpperLipMesh.getPoints().set(15, currentUpperLipMesh.getPoints().get(15) + yMovement3);
		currentUpperLipMesh.getPoints().set(14, currentUpperLipMesh.getPoints().get(14) - xMovement3);
		currentUpperLipMesh.getPoints().set(17, currentUpperLipMesh.getPoints().get(17) + yMovement2);
		currentUpperLipMesh.getPoints().set(16, currentUpperLipMesh.getPoints().get(16) - xMovement2);
		currentUpperLipMesh.getPoints().set(18, currentUpperLipMesh.getPoints().get(18) - xMovement1);
		currentUpperLipMesh.getPoints().set(20, currentUpperLipMesh.getPoints().get(20) - xMovement0);
		
		return currentUpperLipMesh;
	}
	
	public static Polygon modifyDownLip(Polygon currentDownLipMesh, float step, String sign)
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
		currentDownLipMesh.getPoints().set(2, currentDownLipMesh.getPoints().get(2) + xMovement1);
		currentDownLipMesh.getPoints().set(4, currentDownLipMesh.getPoints().get(4) + xMovement2);
		currentDownLipMesh.getPoints().set(5, currentDownLipMesh.getPoints().get(5) - yMovement2);
		currentDownLipMesh.getPoints().set(6, currentDownLipMesh.getPoints().get(6) + xMovement3);
		currentDownLipMesh.getPoints().set(7, currentDownLipMesh.getPoints().get(7) - yMovement3);
		currentDownLipMesh.getPoints().set(8, currentDownLipMesh.getPoints().get(8) + xMovement4);
		currentDownLipMesh.getPoints().set(9, currentDownLipMesh.getPoints().get(9) - yMovement4);
		
		currentDownLipMesh.getPoints().set(11, currentDownLipMesh.getPoints().get(11) + yMovement5);
		
		currentDownLipMesh.getPoints().set(13, currentDownLipMesh.getPoints().get(13) - yMovement4);
		currentDownLipMesh.getPoints().set(12, currentDownLipMesh.getPoints().get(12) - xMovement4);
		currentDownLipMesh.getPoints().set(15, currentDownLipMesh.getPoints().get(15) - yMovement3);
		currentDownLipMesh.getPoints().set(14, currentDownLipMesh.getPoints().get(14) - xMovement3);
		currentDownLipMesh.getPoints().set(17, currentDownLipMesh.getPoints().get(17) - yMovement2);
		currentDownLipMesh.getPoints().set(16, currentDownLipMesh.getPoints().get(16) - xMovement2);
		currentDownLipMesh.getPoints().set(18, currentDownLipMesh.getPoints().get(18) - xMovement1);
		currentDownLipMesh.getPoints().set(20, currentDownLipMesh.getPoints().get(20) - xMovement0);
		
		return currentDownLipMesh;
	}

}
