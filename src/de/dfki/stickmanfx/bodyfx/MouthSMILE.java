package de.dfki.stickmanfx.bodyfx;

import de.dfki.stickmanfx.animationlogic.AnimatorFX;
import javafx.scene.shape.TriangleMesh;

public class MouthSMILE {
	
	public static TriangleMesh modifyUpperLip(TriangleMesh currentUpperLipMesh, float step, String sign)
	{
		float xMovement0;
		float yMovement0;
		float xMovement1;
		float yMovement1;
		float xMovement19;
		float yMovement19;
		float yMovement2;
		float yMovement3;
		float yMovement4;
		float yMovement5;
		
		float xMovement10;
		float yMovement10;
		float xMovement9;
		float yMovement9;
		float xMovement11;
		float yMovement11;
		float yMovement8;
		float yMovement7;
		float yMovement6;
		if(sign.equalsIgnoreCase("PLUS"))
		{
			 xMovement0 = (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0263f;
			 yMovement0 = (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0316f;
			 xMovement1 = (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0158f;
			 yMovement1 = (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0105f;
			 xMovement19 = (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0158f;
			 yMovement19 = (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0105f;
			 yMovement2 = (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0053f;
			 yMovement3 = (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0105f;
			 yMovement4 = (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0158f;
			 yMovement5 = (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0053f;
			
			 xMovement10 = (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0263f;
			 yMovement10 = (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0316f;
			 xMovement9 = (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0158f;
			 yMovement9 = (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0105f;
			 xMovement11 = (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0158f;
			 yMovement11 = (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0105f;
			 yMovement8 = (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0053f;
			 yMovement7 = (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0105f;
			 yMovement6 = (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0158f;
		}
		else
		{
			xMovement0 = -(AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0263f;
			 yMovement0 = -(AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0316f;
			 xMovement1 = -(AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0158f;
			 yMovement1 = -(AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0105f;
			 xMovement19 = -(AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0158f;
			 yMovement19 = -(AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0105f;
			 yMovement2 = -(AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0053f;
			 yMovement3 = -(AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0105f;
			 yMovement4 = -(AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0158f;
			 yMovement5 = -(AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0053f;
			
			 xMovement10 = -(AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0263f;
			 yMovement10 = -(AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0316f;
			 xMovement9 = -(AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0158f;
			 yMovement9 = -(AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0105f;
			 xMovement11 = -(AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0158f;
			 yMovement11 = -(AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0105f;
			 yMovement8 = -(AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0053f;
			 yMovement7 = -(AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0105f;
			 yMovement6 = -(AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0158f;
		}
		
		currentUpperLipMesh.getPoints().set(0, currentUpperLipMesh.getPoints().get(0) - xMovement0);
		currentUpperLipMesh.getPoints().set(1, currentUpperLipMesh.getPoints().get(1) - yMovement0);
		currentUpperLipMesh.getPoints().set(3, currentUpperLipMesh.getPoints().get(3) - xMovement1);
		currentUpperLipMesh.getPoints().set(4, currentUpperLipMesh.getPoints().get(4) - yMovement1);
		currentUpperLipMesh.getPoints().set(57, currentUpperLipMesh.getPoints().get(57) - xMovement19);
		currentUpperLipMesh.getPoints().set(58, currentUpperLipMesh.getPoints().get(58) - yMovement19);
		currentUpperLipMesh.getPoints().set(7, currentUpperLipMesh.getPoints().get(7) + yMovement2);
		currentUpperLipMesh.getPoints().set(10, currentUpperLipMesh.getPoints().get(10) + yMovement3);
		currentUpperLipMesh.getPoints().set(13, currentUpperLipMesh.getPoints().get(13) + yMovement4);
		currentUpperLipMesh.getPoints().set(16, currentUpperLipMesh.getPoints().get(16) + yMovement5);
		//------------------------------//
		currentUpperLipMesh.getPoints().set(30, currentUpperLipMesh.getPoints().get(30) + xMovement10);
		currentUpperLipMesh.getPoints().set(31, currentUpperLipMesh.getPoints().get(31) - yMovement10);
		currentUpperLipMesh.getPoints().set(27, currentUpperLipMesh.getPoints().get(27) + xMovement9);
		currentUpperLipMesh.getPoints().set(28, currentUpperLipMesh.getPoints().get(28) - yMovement9);
		currentUpperLipMesh.getPoints().set(33, currentUpperLipMesh.getPoints().get(33) + xMovement11);
		currentUpperLipMesh.getPoints().set(34, currentUpperLipMesh.getPoints().get(34) - yMovement11);
		currentUpperLipMesh.getPoints().set(25, currentUpperLipMesh.getPoints().get(25) + yMovement8);
		currentUpperLipMesh.getPoints().set(22, currentUpperLipMesh.getPoints().get(22) + yMovement7);
		currentUpperLipMesh.getPoints().set(19, currentUpperLipMesh.getPoints().get(19) + yMovement6);
		
		return currentUpperLipMesh;
	}
	
	public static TriangleMesh modifyDownLip(TriangleMesh currentDownLipMesh, float step, String sign)
	{
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
		if(sign.equalsIgnoreCase("PLUS"))
		{
			xMovement0 = (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0263f;
			yMovement0 = (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0316f;
			xMovement1 = (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0158f;
			yMovement1 = (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0105f;
			xMovement19 = (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0158f;
			yMovement19 = (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0105f;
			xMovement10 = (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0263f;
			yMovement10 = (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0316f;
			xMovement9 = (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0158f;
			yMovement9 = (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0105f;
			xMovement11 = (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0158f;
			yMovement11 = (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0105f;
		}
		else
		{
			xMovement0 = -(AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0263f;
			yMovement0 = -(AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0316f;
			xMovement1 = -(AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0158f;
			yMovement1 = -(AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0105f;
			xMovement19 = -(AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0158f;
			yMovement19 = -(AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0105f;
			xMovement10 = -(AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0263f;
			yMovement10 = -(AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0316f;
			xMovement9 = -(AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0158f;
			yMovement9 = -(AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0105f;
			xMovement11 = -(AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0158f;
			yMovement11 = -(AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0105f;
		}
		
		currentDownLipMesh.getPoints().set(0, currentDownLipMesh.getPoints().get(0) - xMovement0);
		currentDownLipMesh.getPoints().set(1, currentDownLipMesh.getPoints().get(1) - yMovement0);
		currentDownLipMesh.getPoints().set(57, currentDownLipMesh.getPoints().get(57) - xMovement1);
		currentDownLipMesh.getPoints().set(58, currentDownLipMesh.getPoints().get(58) - yMovement1);
		currentDownLipMesh.getPoints().set(3, currentDownLipMesh.getPoints().get(3) - xMovement19);
		currentDownLipMesh.getPoints().set(4, currentDownLipMesh.getPoints().get(4) - yMovement19);
		currentDownLipMesh.getPoints().set(30, currentDownLipMesh.getPoints().get(30) + xMovement10);
		currentDownLipMesh.getPoints().set(31, currentDownLipMesh.getPoints().get(31) - yMovement10);
		currentDownLipMesh.getPoints().set(36, currentDownLipMesh.getPoints().get(36) + xMovement9);
		currentDownLipMesh.getPoints().set(37, currentDownLipMesh.getPoints().get(37) - yMovement9);
		currentDownLipMesh.getPoints().set(27, currentDownLipMesh.getPoints().get(27) + xMovement11);
		currentDownLipMesh.getPoints().set(28, currentDownLipMesh.getPoints().get(28) - yMovement11);
		
		return currentDownLipMesh;
	}

}
