package de.dfki.stickmanfx.bodyfx;

import de.dfki.stickmanfx.animationlogic.AnimatorFX;
import javafx.scene.shape.TriangleMesh;

public class MouthHAPPY {
	
	public static TriangleMesh modifyUpperLip(TriangleMesh currentUpperLipMesh, float step, String sign)
	{
		float yMovement16;
		float yMovement17;
		float yMovement18;
		float yMovement19;
		
		if(sign.equalsIgnoreCase("PLUS"))
		{
			yMovement16 = (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0105f;
			yMovement17 = (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0105f;
			yMovement18 = (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0079f;
			yMovement19 = (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0026f;

		}
		else
		{
			yMovement16 = -(AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0105f;
			yMovement17 = -(AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0105f;
			yMovement18 = -(AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0079f;
			yMovement19 = -(AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0026f;
		}
		
		currentUpperLipMesh.getPoints().set(16, currentUpperLipMesh.getPoints().get(16) - yMovement16);
		currentUpperLipMesh.getPoints().set(46, currentUpperLipMesh.getPoints().get(46) - yMovement17);
		currentUpperLipMesh.getPoints().set(49, currentUpperLipMesh.getPoints().get(49) - yMovement18);
		currentUpperLipMesh.getPoints().set(43, currentUpperLipMesh.getPoints().get(43) - yMovement18);
		currentUpperLipMesh.getPoints().set(52, currentUpperLipMesh.getPoints().get(52) - yMovement19);
		currentUpperLipMesh.getPoints().set(40, currentUpperLipMesh.getPoints().get(40) - yMovement19);
		
		return currentUpperLipMesh;
	}
	
	public static TriangleMesh modifyDownLip(TriangleMesh currentDownLipMesh, float step, String sign)
	{
		float yMovement5;
		float yMovement2;
		float yMovement3;
		float yMovement4;
		float yMovement6;
		float yMovement7;
		float yMovement8;
		float yMovement9;
		float yMovement10;
		float yMovement11;
		float yMovement12;
		float yMovement13;
		float yMovement14;
		float yMovement15;
		
		if(sign.equalsIgnoreCase("PLUS"))
		{
			yMovement2 = (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0053f;
			yMovement3 = (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0105f;
			yMovement4 = (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0210f;
			yMovement5 = (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0368f;
			yMovement6 = (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0210f;
			yMovement7 = (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0105f;
			yMovement8 = (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0053f;
			
			yMovement9 = (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0105f;
			yMovement10 = (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0210f;
			yMovement11 = (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0315f;
			yMovement12 = (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0368f;
			yMovement13 = (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0315f;
			yMovement14 = (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0210f;
			yMovement15 = (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0105f;
		}
		else
		{
			yMovement2 = -(AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0053f;
			yMovement3 = -(AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0105f;
			yMovement4 = -(AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0210f;
			yMovement5 = -(AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0368f;
			yMovement6 = -(AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0210f;
			yMovement7 = -(AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0105f;
			yMovement8 = -(AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0053f;
			
			yMovement9 = -(AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0105f;
			yMovement10 = -(AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0210f;
			yMovement11 = -(AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0315f;
			yMovement12 = -(AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0368f;
			yMovement13 = -(AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0315f;
			yMovement14 = -(AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0210f;
			yMovement15 = -(AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0105f;
		}
		
		currentDownLipMesh.getPoints().set(7, currentDownLipMesh.getPoints().get(7) + yMovement2);
		currentDownLipMesh.getPoints().set(10, currentDownLipMesh.getPoints().get(10) + yMovement3);
		currentDownLipMesh.getPoints().set(13, currentDownLipMesh.getPoints().get(13) + yMovement4);
		currentDownLipMesh.getPoints().set(16, currentDownLipMesh.getPoints().get(16) + yMovement5);
		currentDownLipMesh.getPoints().set(19, currentDownLipMesh.getPoints().get(19) + yMovement6);
		currentDownLipMesh.getPoints().set(22, currentDownLipMesh.getPoints().get(22) + yMovement7);
		currentDownLipMesh.getPoints().set(25, currentDownLipMesh.getPoints().get(25) + yMovement8);
		
		currentDownLipMesh.getPoints().set(55, currentDownLipMesh.getPoints().get(55) + yMovement9);
		currentDownLipMesh.getPoints().set(52, currentDownLipMesh.getPoints().get(52) + yMovement10);
		currentDownLipMesh.getPoints().set(49, currentDownLipMesh.getPoints().get(49) + yMovement11);
		currentDownLipMesh.getPoints().set(46, currentDownLipMesh.getPoints().get(46) + yMovement12);
		currentDownLipMesh.getPoints().set(43, currentDownLipMesh.getPoints().get(43) + yMovement13);
		currentDownLipMesh.getPoints().set(40, currentDownLipMesh.getPoints().get(40) + yMovement14);
		currentDownLipMesh.getPoints().set(37, currentDownLipMesh.getPoints().get(37) + yMovement15);
		
		return currentDownLipMesh;
	}

}
