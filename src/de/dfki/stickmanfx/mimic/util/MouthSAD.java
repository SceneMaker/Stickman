package de.dfki.stickmanfx.mimic.util;

import de.dfki.stickmanfx.animationlogic.AnimatorFX;
import javafx.scene.shape.TriangleMesh;

public class MouthSAD {
	
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
		float yMovement1;
		float xMovement19;
		float yMovement19;
		
		float xMovement10;
		float yMovement10;
		float xMovement9;
		float yMovement9;
		float xMovement11;
		float yMovement11;
		
		xMovement0 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0263f;
		yMovement0 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0421f;
		xMovement1 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0158f;
		yMovement1 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0105f;
		xMovement19 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0158f;
		yMovement19 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0105f;
		
		xMovement10 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0263f;
		yMovement10 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0421f;
		xMovement9 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0158f;
		yMovement9 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0105f;
		xMovement11 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0158f;
		yMovement11 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0105f;

		currentUpperLipMesh.getPoints().set(0, currentUpperLipMesh.getPoints().get(0) - xMovement0);
		currentUpperLipMesh.getPoints().set(1, currentUpperLipMesh.getPoints().get(1) + yMovement0);
		currentUpperLipMesh.getPoints().set(57, currentUpperLipMesh.getPoints().get(57) - xMovement1);
		currentUpperLipMesh.getPoints().set(58, currentUpperLipMesh.getPoints().get(58) + yMovement1);
		currentUpperLipMesh.getPoints().set(3, currentUpperLipMesh.getPoints().get(3) - xMovement19);
		currentUpperLipMesh.getPoints().set(4, currentUpperLipMesh.getPoints().get(4) + yMovement19);
		currentUpperLipMesh.getPoints().set(30, currentUpperLipMesh.getPoints().get(30) + xMovement10);
		currentUpperLipMesh.getPoints().set(31, currentUpperLipMesh.getPoints().get(31) + yMovement10);
		currentUpperLipMesh.getPoints().set(36, currentUpperLipMesh.getPoints().get(36) + xMovement9);
		currentUpperLipMesh.getPoints().set(37, currentUpperLipMesh.getPoints().get(37) + yMovement9);
		currentUpperLipMesh.getPoints().set(27, currentUpperLipMesh.getPoints().get(27) + xMovement11);
		currentUpperLipMesh.getPoints().set(28, currentUpperLipMesh.getPoints().get(28) + yMovement11);
		
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
		float yMovement2;
		float yMovement3;
		float yMovement4;
		float yMovement5;
		float yMovement6;
		float yMovement7;
		float yMovement8;
		float xMovement19;
		float yMovement19;
		float xMovement10;
		float yMovement10;
		float xMovement9;
		float yMovement9;
		float xMovement11;
		float yMovement11;

		xMovement0 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0263f;
		yMovement0 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0421f;
		xMovement1 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0158f;
		yMovement1 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0105f;
		xMovement19 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0158f;
		yMovement19 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0105f;
		yMovement2 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0053f;
		yMovement3 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0105f;
		yMovement4 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0158f;
		yMovement5 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0053f;
		
		xMovement10 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0263f;
		yMovement10 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0421f;
		xMovement9 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0158f;
		yMovement9 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0105f;
		xMovement11 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0158f;
		yMovement11 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0105f;
		yMovement8 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0053f;
		yMovement7 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0105f;
		yMovement6 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0158f;
		
		currentDownLipMesh.getPoints().set(0, currentDownLipMesh.getPoints().get(0) - xMovement0);
		currentDownLipMesh.getPoints().set(1, currentDownLipMesh.getPoints().get(1) + yMovement0);
		currentDownLipMesh.getPoints().set(3, currentDownLipMesh.getPoints().get(3) - xMovement1);
		currentDownLipMesh.getPoints().set(4, currentDownLipMesh.getPoints().get(4) + yMovement1);
		currentDownLipMesh.getPoints().set(57, currentDownLipMesh.getPoints().get(57) - xMovement19);
		currentDownLipMesh.getPoints().set(58, currentDownLipMesh.getPoints().get(58) + yMovement19);
		currentDownLipMesh.getPoints().set(7, currentDownLipMesh.getPoints().get(7) - yMovement2);
		currentDownLipMesh.getPoints().set(10, currentDownLipMesh.getPoints().get(10) - yMovement3);
		currentDownLipMesh.getPoints().set(13, currentDownLipMesh.getPoints().get(13) - yMovement4);
		currentDownLipMesh.getPoints().set(16, currentDownLipMesh.getPoints().get(16) - yMovement5);
		//------------------------------//
		currentDownLipMesh.getPoints().set(30, currentDownLipMesh.getPoints().get(30) + xMovement10);
		currentDownLipMesh.getPoints().set(31, currentDownLipMesh.getPoints().get(31) + yMovement10);
		currentDownLipMesh.getPoints().set(27, currentDownLipMesh.getPoints().get(27) + xMovement9);
		currentDownLipMesh.getPoints().set(28, currentDownLipMesh.getPoints().get(28) + yMovement9);
		currentDownLipMesh.getPoints().set(33, currentDownLipMesh.getPoints().get(33) + xMovement11);
		currentDownLipMesh.getPoints().set(34, currentDownLipMesh.getPoints().get(34) + yMovement11);
		currentDownLipMesh.getPoints().set(25, currentDownLipMesh.getPoints().get(25) - yMovement8);
		currentDownLipMesh.getPoints().set(22, currentDownLipMesh.getPoints().get(22) - yMovement7);
		currentDownLipMesh.getPoints().set(19, currentDownLipMesh.getPoints().get(19) - yMovement6);
		
		return currentDownLipMesh;
	}

}
