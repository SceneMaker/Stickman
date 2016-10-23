package de.dfki.stickmanfx.mimic.util;

import de.dfki.stickmanfx.animationlogic.AnimatorFX;
import javafx.scene.shape.TriangleMesh;

public class MouthANGRYSMALLMOUTH {
	
	public static TriangleMesh modifyUpperLip(TriangleMesh currentUpperLipMesh, float step, String sign)
	{
		int sig;
		
		if(sign.equalsIgnoreCase("PLUS"))
			sig = 1;
		else
			sig = -1;
		
		float xMovement0;
		float yMovement0;
		float xMovement1;
		float xMovement2;
		float xMovement3;
		float xMovement4;
		float yMovement4;
		float yMovement5;
		float xMovement11;
		float xMovement12;
		float yMovement12;
		float xMovement13;
		float yMovement13;
		float xMovement14;
		float yMovement14;
		float yMovement15;
		
		xMovement0 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0210f;
		yMovement0 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0158f;
		xMovement1 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0210f;
		xMovement2 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0263f;
		xMovement3 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0210f;
		xMovement4 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0052f;
		yMovement4 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0026f;
		yMovement5 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0142f;
		xMovement11 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0210f;
		xMovement12 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0263f;
		yMovement12 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0105f;
		xMovement13 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0210f;
		yMovement13 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0158f;
		xMovement14 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0052f;
		yMovement14 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0184f;
		yMovement15 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0184f;
		
		currentUpperLipMesh.getPoints().set(0, currentUpperLipMesh.getPoints().get(0) + xMovement0);
		currentUpperLipMesh.getPoints().set(1, currentUpperLipMesh.getPoints().get(1) + yMovement0);
		currentUpperLipMesh.getPoints().set(3, currentUpperLipMesh.getPoints().get(3) + xMovement1);
		currentUpperLipMesh.getPoints().set(6, currentUpperLipMesh.getPoints().get(6) + xMovement2);
		currentUpperLipMesh.getPoints().set(9, currentUpperLipMesh.getPoints().get(9) + xMovement3);
		currentUpperLipMesh.getPoints().set(12, currentUpperLipMesh.getPoints().get(12) + xMovement4);
		currentUpperLipMesh.getPoints().set(13, currentUpperLipMesh.getPoints().get(13) - yMovement4);
		currentUpperLipMesh.getPoints().set(16, currentUpperLipMesh.getPoints().get(16) - yMovement5);
		currentUpperLipMesh.getPoints().set(19, currentUpperLipMesh.getPoints().get(19) - yMovement4);
		currentUpperLipMesh.getPoints().set(18, currentUpperLipMesh.getPoints().get(18) - xMovement4);
		currentUpperLipMesh.getPoints().set(21, currentUpperLipMesh.getPoints().get(21) - xMovement3);
		currentUpperLipMesh.getPoints().set(24, currentUpperLipMesh.getPoints().get(24) - xMovement2);
		currentUpperLipMesh.getPoints().set(27, currentUpperLipMesh.getPoints().get(27) - xMovement1);
		currentUpperLipMesh.getPoints().set(30, currentUpperLipMesh.getPoints().get(30) - xMovement0);
		currentUpperLipMesh.getPoints().set(31, currentUpperLipMesh.getPoints().get(31) + yMovement0);
		
		currentUpperLipMesh.getPoints().set(33, currentUpperLipMesh.getPoints().get(33) - xMovement11);
		currentUpperLipMesh.getPoints().set(36, currentUpperLipMesh.getPoints().get(36) - xMovement12);
		currentUpperLipMesh.getPoints().set(37, currentUpperLipMesh.getPoints().get(37) - yMovement12);
		currentUpperLipMesh.getPoints().set(39, currentUpperLipMesh.getPoints().get(39) - xMovement13);
		currentUpperLipMesh.getPoints().set(40, currentUpperLipMesh.getPoints().get(40) - yMovement13);
		currentUpperLipMesh.getPoints().set(42, currentUpperLipMesh.getPoints().get(42) - xMovement14);
		currentUpperLipMesh.getPoints().set(43, currentUpperLipMesh.getPoints().get(43) - yMovement14);
		currentUpperLipMesh.getPoints().set(46, currentUpperLipMesh.getPoints().get(46) - yMovement15);
		currentUpperLipMesh.getPoints().set(49, currentUpperLipMesh.getPoints().get(49) - yMovement14);
		currentUpperLipMesh.getPoints().set(48, currentUpperLipMesh.getPoints().get(48) + xMovement14);
		currentUpperLipMesh.getPoints().set(52, currentUpperLipMesh.getPoints().get(52) - yMovement13);
		currentUpperLipMesh.getPoints().set(51, currentUpperLipMesh.getPoints().get(51) + xMovement13);
		currentUpperLipMesh.getPoints().set(55, currentUpperLipMesh.getPoints().get(55) - yMovement12);
		currentUpperLipMesh.getPoints().set(54, currentUpperLipMesh.getPoints().get(54) + xMovement12);
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
		float yMovement0;
		float xMovement1;
		float yMovement1;
		float xMovement2;
		float yMovement2;
		float xMovement3;
		float yMovement3;
		float xMovement4;
		float yMovement4;
		float yMovement5;
		float xMovement11;
		float xMovement12;
		float yMovement12;
		float xMovement13;
		float yMovement13;
		float xMovement14;
		float yMovement14;
		float yMovement15;
		
		xMovement0 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0210f;
		yMovement0 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0158f;
		xMovement1 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0210f;
		yMovement1 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0026f;
		xMovement2 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0263f;
		yMovement2 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0210f;
		xMovement3 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0210f;
		yMovement3 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0318f;
		xMovement4 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0052f;
		yMovement4 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0342f;
		yMovement5 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0237f;
		xMovement11 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0210f;
		xMovement12 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0263f;
		yMovement12 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0105f;
		xMovement13 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0210f;
		yMovement13 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0158f;
		xMovement14 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0052f;
		yMovement14 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0184f;
		yMovement15 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0184f;
		
		currentDownLipMesh.getPoints().set(0, currentDownLipMesh.getPoints().get(0) + xMovement0);
		currentDownLipMesh.getPoints().set(1, currentDownLipMesh.getPoints().get(1) + yMovement0);
		currentDownLipMesh.getPoints().set(3, currentDownLipMesh.getPoints().get(3) + xMovement1);
		currentDownLipMesh.getPoints().set(4, currentDownLipMesh.getPoints().get(4) - yMovement1);
		currentDownLipMesh.getPoints().set(6, currentDownLipMesh.getPoints().get(6) + xMovement2);
		currentDownLipMesh.getPoints().set(7, currentDownLipMesh.getPoints().get(7) - yMovement2);
		currentDownLipMesh.getPoints().set(9, currentDownLipMesh.getPoints().get(9) + xMovement3);
		currentDownLipMesh.getPoints().set(10, currentDownLipMesh.getPoints().get(10) - yMovement3);
		currentDownLipMesh.getPoints().set(12, currentDownLipMesh.getPoints().get(12) + xMovement4);
		currentDownLipMesh.getPoints().set(13, currentDownLipMesh.getPoints().get(13) - yMovement4);
		currentDownLipMesh.getPoints().set(16, currentDownLipMesh.getPoints().get(16) - yMovement5);
		currentDownLipMesh.getPoints().set(19, currentDownLipMesh.getPoints().get(19) - yMovement4);
		currentDownLipMesh.getPoints().set(18, currentDownLipMesh.getPoints().get(18) - xMovement4);
		currentDownLipMesh.getPoints().set(22, currentDownLipMesh.getPoints().get(22) - yMovement3);
		currentDownLipMesh.getPoints().set(21, currentDownLipMesh.getPoints().get(21) - xMovement3);
		currentDownLipMesh.getPoints().set(25, currentDownLipMesh.getPoints().get(25) - yMovement2);
		currentDownLipMesh.getPoints().set(24, currentDownLipMesh.getPoints().get(24) - xMovement2);
		currentDownLipMesh.getPoints().set(28, currentDownLipMesh.getPoints().get(28) - yMovement1);
		currentDownLipMesh.getPoints().set(27, currentDownLipMesh.getPoints().get(27) - xMovement1);
		currentDownLipMesh.getPoints().set(31, currentDownLipMesh.getPoints().get(31) + yMovement0);
		currentDownLipMesh.getPoints().set(30, currentDownLipMesh.getPoints().get(30) - xMovement0);
		currentDownLipMesh.getPoints().set(33, currentDownLipMesh.getPoints().get(33) - xMovement11);
		currentDownLipMesh.getPoints().set(36, currentDownLipMesh.getPoints().get(36) - xMovement12);
		currentDownLipMesh.getPoints().set(37, currentDownLipMesh.getPoints().get(37) - yMovement12);
		currentDownLipMesh.getPoints().set(39, currentDownLipMesh.getPoints().get(39) - xMovement13);
		currentDownLipMesh.getPoints().set(40, currentDownLipMesh.getPoints().get(40) - yMovement13);
		currentDownLipMesh.getPoints().set(42, currentDownLipMesh.getPoints().get(42) - xMovement14);
		currentDownLipMesh.getPoints().set(43, currentDownLipMesh.getPoints().get(43) - yMovement14);
		currentDownLipMesh.getPoints().set(46, currentDownLipMesh.getPoints().get(46) - yMovement15);
		currentDownLipMesh.getPoints().set(49, currentDownLipMesh.getPoints().get(49) - yMovement14);
		currentDownLipMesh.getPoints().set(48, currentDownLipMesh.getPoints().get(48) + xMovement14);
		currentDownLipMesh.getPoints().set(52, currentDownLipMesh.getPoints().get(52) - yMovement13);
		currentDownLipMesh.getPoints().set(51, currentDownLipMesh.getPoints().get(51) + xMovement13);
		currentDownLipMesh.getPoints().set(55, currentDownLipMesh.getPoints().get(55) - yMovement12);
		currentDownLipMesh.getPoints().set(54, currentDownLipMesh.getPoints().get(54) + xMovement12);
		currentDownLipMesh.getPoints().set(57, currentDownLipMesh.getPoints().get(57) + xMovement11);
		
		
		return currentDownLipMesh;
	}

}
