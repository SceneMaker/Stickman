package de.dfki.stickmanfx.bodyfx;

import de.dfki.stickmanfx.animationlogic.AnimatorFX;
import javafx.scene.shape.TriangleMesh;

public class MouthANGRY {
	
	public static TriangleMesh modifyUpperLip(TriangleMesh currentUpperLipMesh, float step, String sign)
	{
		float yMovement0;
		float yMovement5;
		
		if(sign.equalsIgnoreCase("PLUS"))
		{
			yMovement5 = (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0105f;
			yMovement0 = (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0210f;
			yMovement5 = (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0158f;

		}
		else
		{
			yMovement5 = -(AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0105f;
			yMovement0 = -(AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0210f;
			yMovement5 = -(AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0158f;
		}
		
		currentUpperLipMesh.getPoints().set(16, currentUpperLipMesh.getPoints().get(16) - yMovement5);
		currentUpperLipMesh.getPoints().set(1, currentUpperLipMesh.getPoints().get(1) + yMovement0);
		currentUpperLipMesh.getPoints().set(31, currentUpperLipMesh.getPoints().get(31) + yMovement0);
		
		return currentUpperLipMesh;
	}
	
	public static TriangleMesh modifyDownLip(TriangleMesh currentDownLipMesh, float step, String sign)
	{
		float yMovement0;
		float yMovement2;
		float yMovement3;
		float yMovement4;
		float yMovement5;
		if(sign.equalsIgnoreCase("PLUS"))
		{
			yMovement5 = (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0105f;
			yMovement0 = (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0210f;
			yMovement2 = (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0158f;
			yMovement3 = (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0263f;
			yMovement4 = (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0263f;
			yMovement5 = (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0158f;
		}
		else
		{
			yMovement5 = -(AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0105f;
			yMovement0 = -(AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0210f;
			yMovement2 = -(AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0158f;
			yMovement3 = -(AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0263f;
			yMovement4 = -(AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0263f;
			yMovement5 = -(AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0158f;
		}
		
		currentDownLipMesh.getPoints().set(1, currentDownLipMesh.getPoints().get(1) + yMovement0);
		currentDownLipMesh.getPoints().set(7, currentDownLipMesh.getPoints().get(7) - yMovement2);
		currentDownLipMesh.getPoints().set(10, currentDownLipMesh.getPoints().get(10) - yMovement3);
		currentDownLipMesh.getPoints().set(13, currentDownLipMesh.getPoints().get(13) - yMovement4);
		currentDownLipMesh.getPoints().set(16, currentDownLipMesh.getPoints().get(16) - yMovement5);
		currentDownLipMesh.getPoints().set(19, currentDownLipMesh.getPoints().get(19) - yMovement4);
		currentDownLipMesh.getPoints().set(22, currentDownLipMesh.getPoints().get(22) - yMovement3);
		currentDownLipMesh.getPoints().set(25, currentDownLipMesh.getPoints().get(25) - yMovement2);
		currentDownLipMesh.getPoints().set(31, currentDownLipMesh.getPoints().get(31) + yMovement0);
		
		return currentDownLipMesh;
	}

}
