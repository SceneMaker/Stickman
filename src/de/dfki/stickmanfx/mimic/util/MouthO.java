package de.dfki.stickmanfx.mimic.util;

import de.dfki.stickmanfx.animationlogic.AnimatorFX;
import javafx.scene.shape.TriangleMesh;

public class MouthO {
	
	public static TriangleMesh modifyUpperLip(TriangleMesh currentUpperLipMesh, float step, String sign)
	{
		int sig;
		
		if(sign.equalsIgnoreCase("PLUS"))
			sig = 1;
		else
			sig = -1;
		
		float xMovement0;
		float yMovement1;
		float yMovement2;
		float yMovement3;
		float yMovement4;
		float yMovement5;
		
		float xMovement11;
		float yMovement12;
		float yMovement13;
		float yMovement14;
		float yMovement15;
		
		xMovement0 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0052f;
		yMovement1 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0105f;
		yMovement2 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0158f;
		yMovement3 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0210f;
		yMovement4 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0263f;
		yMovement5 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0368f;
		
		xMovement11 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0052f;
		yMovement12 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0210f;
		yMovement13 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0316f;
		yMovement14 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0368f;
		yMovement15 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0368f;

		
		currentUpperLipMesh.getPoints().set(0, currentUpperLipMesh.getPoints().get(0) + xMovement0);
		currentUpperLipMesh.getPoints().set(4, currentUpperLipMesh.getPoints().get(4) - yMovement1);
		currentUpperLipMesh.getPoints().set(7, currentUpperLipMesh.getPoints().get(7) - yMovement2);
		currentUpperLipMesh.getPoints().set(10, currentUpperLipMesh.getPoints().get(10) - yMovement3);
		currentUpperLipMesh.getPoints().set(13, currentUpperLipMesh.getPoints().get(13) - yMovement4);
		currentUpperLipMesh.getPoints().set(16, currentUpperLipMesh.getPoints().get(16) - yMovement5);
		currentUpperLipMesh.getPoints().set(19, currentUpperLipMesh.getPoints().get(19) - yMovement4);
		currentUpperLipMesh.getPoints().set(22, currentUpperLipMesh.getPoints().get(22) - yMovement3);
		currentUpperLipMesh.getPoints().set(25, currentUpperLipMesh.getPoints().get(25) - yMovement2);
		currentUpperLipMesh.getPoints().set(28, currentUpperLipMesh.getPoints().get(28) - yMovement1);
		currentUpperLipMesh.getPoints().set(30, currentUpperLipMesh.getPoints().get(30) - xMovement0);
		
		currentUpperLipMesh.getPoints().set(33, currentUpperLipMesh.getPoints().get(33) - xMovement11);
		currentUpperLipMesh.getPoints().set(37, currentUpperLipMesh.getPoints().get(37) - yMovement12);
		currentUpperLipMesh.getPoints().set(40, currentUpperLipMesh.getPoints().get(40) - yMovement13);
		currentUpperLipMesh.getPoints().set(43, currentUpperLipMesh.getPoints().get(43) - yMovement14);
		
		currentUpperLipMesh.getPoints().set(46, currentUpperLipMesh.getPoints().get(46) - yMovement15);
		currentUpperLipMesh.getPoints().set(49, currentUpperLipMesh.getPoints().get(49) - yMovement14);
		currentUpperLipMesh.getPoints().set(52, currentUpperLipMesh.getPoints().get(52) - yMovement13);
		currentUpperLipMesh.getPoints().set(55, currentUpperLipMesh.getPoints().get(55) - yMovement12);
		currentUpperLipMesh.getPoints().set(57, currentUpperLipMesh.getPoints().get(57) + xMovement11);
		
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
		float yMovement1;
		float yMovement2;
		float yMovement3;
		float yMovement4;
		float yMovement5;
		
		float xMovement11;
		float yMovement12;
		float yMovement13;
		float yMovement14;
		float yMovement15;
		
		xMovement0 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0052f;
		yMovement1 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0105f;
		yMovement2 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0158f;
		yMovement3 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0210f;
		yMovement4 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0263f;
		yMovement5 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0368f;
		
		xMovement11 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0052f;
		yMovement12 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0210f;
		yMovement13 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0316f;
		yMovement14 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0368f;
		yMovement15 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0368f;

		
		currentDownLipMesh.getPoints().set(0, currentDownLipMesh.getPoints().get(0) + xMovement0);
		currentDownLipMesh.getPoints().set(4, currentDownLipMesh.getPoints().get(4) + yMovement1);
		currentDownLipMesh.getPoints().set(7, currentDownLipMesh.getPoints().get(7) + yMovement2);
		currentDownLipMesh.getPoints().set(10, currentDownLipMesh.getPoints().get(10) + yMovement3);
		currentDownLipMesh.getPoints().set(13, currentDownLipMesh.getPoints().get(13) + yMovement4);
		currentDownLipMesh.getPoints().set(16, currentDownLipMesh.getPoints().get(16) + yMovement5);
		currentDownLipMesh.getPoints().set(19, currentDownLipMesh.getPoints().get(19) + yMovement4);
		currentDownLipMesh.getPoints().set(22, currentDownLipMesh.getPoints().get(22) + yMovement3);
		currentDownLipMesh.getPoints().set(25, currentDownLipMesh.getPoints().get(25) + yMovement2);
		currentDownLipMesh.getPoints().set(28, currentDownLipMesh.getPoints().get(28) + yMovement1);
		currentDownLipMesh.getPoints().set(30, currentDownLipMesh.getPoints().get(30) - xMovement0);
		
		currentDownLipMesh.getPoints().set(33, currentDownLipMesh.getPoints().get(33) - xMovement11);
		currentDownLipMesh.getPoints().set(37, currentDownLipMesh.getPoints().get(37) + yMovement12);
		currentDownLipMesh.getPoints().set(40, currentDownLipMesh.getPoints().get(40) + yMovement13);
		currentDownLipMesh.getPoints().set(43, currentDownLipMesh.getPoints().get(43) + yMovement14);
		
		currentDownLipMesh.getPoints().set(46, currentDownLipMesh.getPoints().get(46) + yMovement15);
		currentDownLipMesh.getPoints().set(49, currentDownLipMesh.getPoints().get(49) + yMovement14);
		currentDownLipMesh.getPoints().set(52, currentDownLipMesh.getPoints().get(52) + yMovement13);
		currentDownLipMesh.getPoints().set(55, currentDownLipMesh.getPoints().get(55) + yMovement12);
		currentDownLipMesh.getPoints().set(57, currentDownLipMesh.getPoints().get(57) + xMovement11);
		
		return currentDownLipMesh;
	}

}
