package de.dfki.stickmanfx.mimic.util;

import de.dfki.stickmanfx.animationlogic.AnimatorFX;
import javafx.scene.shape.TriangleMesh;

public class MouthDISGUSTED {
	
	public static TriangleMesh modifyUpperLip(TriangleMesh currentUpperLipMesh, float step, String sign)
	{
		int sig;
		
		if(sign.equalsIgnoreCase("PLUS"))
			sig = 1;
		else
			sig = -1;
		
		float upYMovement0;
		float upYMovement2;
		float upYMovement3;
		float upYMovement4;
		float upYMovement5;
		float upYMovement19;
		float upYMovement18;
		float upYMovement17;
		float upYMovement16;
		float upYMovement15;
		
		 upYMovement0 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0421f;
		 upYMovement2 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0052f;
		 upYMovement3 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0052f;
		 upYMovement4 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0105f;
		 upYMovement5 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0210f;
		 upYMovement19 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0210f;
		 upYMovement18 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0105f;
		 upYMovement17 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0158f;
		 upYMovement16 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0210f;
		 upYMovement15 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0210f;
			 
		currentUpperLipMesh.getPoints().set(1, currentUpperLipMesh.getPoints().get(1) + upYMovement0);
		currentUpperLipMesh.getPoints().set(7, currentUpperLipMesh.getPoints().get(7) - upYMovement2);
		currentUpperLipMesh.getPoints().set(10, currentUpperLipMesh.getPoints().get(10) - upYMovement3);
		currentUpperLipMesh.getPoints().set(13, currentUpperLipMesh.getPoints().get(13) - upYMovement4);
		currentUpperLipMesh.getPoints().set(16, currentUpperLipMesh.getPoints().get(16) - upYMovement5);
		currentUpperLipMesh.getPoints().set(19, currentUpperLipMesh.getPoints().get(19) - upYMovement4);
		currentUpperLipMesh.getPoints().set(22, currentUpperLipMesh.getPoints().get(22) - upYMovement3);
		currentUpperLipMesh.getPoints().set(25, currentUpperLipMesh.getPoints().get(25) - upYMovement2);
		currentUpperLipMesh.getPoints().set(31, currentUpperLipMesh.getPoints().get(31) + upYMovement0);
		
		currentUpperLipMesh.getPoints().set(58, currentUpperLipMesh.getPoints().get(58) + upYMovement19);
		currentUpperLipMesh.getPoints().set(55, currentUpperLipMesh.getPoints().get(55) - upYMovement18);
		currentUpperLipMesh.getPoints().set(52, currentUpperLipMesh.getPoints().get(52) - upYMovement17);
		currentUpperLipMesh.getPoints().set(49, currentUpperLipMesh.getPoints().get(49) - upYMovement16);
		currentUpperLipMesh.getPoints().set(46, currentUpperLipMesh.getPoints().get(46) - upYMovement15);
		currentUpperLipMesh.getPoints().set(43, currentUpperLipMesh.getPoints().get(43) - upYMovement16);
		currentUpperLipMesh.getPoints().set(40, currentUpperLipMesh.getPoints().get(40) - upYMovement17);
		currentUpperLipMesh.getPoints().set(37, currentUpperLipMesh.getPoints().get(37) - upYMovement18);
		currentUpperLipMesh.getPoints().set(34, currentUpperLipMesh.getPoints().get(34) + upYMovement19);
		
		return currentUpperLipMesh;
	}
	
	public static TriangleMesh modifyDownLip(TriangleMesh currentDownLipMesh, float step, String sign)
	{
		int sig;
		
		if(sign.equalsIgnoreCase("PLUS"))
			sig = 1;
		else
			sig = -1;
		
		float yMovement16;
		float yMovement17;
		float yMovement18;
		float yMovement19;
		float yMovement1;
		float yMovement0;
		float yMovement2;
		float yMovement5;
		float yMovement8;
		float yMovement9;
		float yMovement10;
		float yMovement15;
		float yMovement14;
		float yMovement13;
		float yMovement12;
		float yMovement11;
		
		yMovement0 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0421f;
		yMovement1 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0263f;
		yMovement2 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0105f;
		yMovement5 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0052f;
		yMovement8 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0105f;
		yMovement9 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0263f;
		yMovement10 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0421f;
		
		yMovement19 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0210f;
		yMovement18 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0158f;
		yMovement17 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0105f;
		yMovement16 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0052f;
		yMovement15 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0052f;
		yMovement14 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0052f;
		yMovement13 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0105f;
		yMovement12 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0158f;
		yMovement11 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0210f;
		
		currentDownLipMesh.getPoints().set(1, currentDownLipMesh.getPoints().get(1) + yMovement0);
		currentDownLipMesh.getPoints().set(4, currentDownLipMesh.getPoints().get(4) + yMovement1);
		currentDownLipMesh.getPoints().set(7, currentDownLipMesh.getPoints().get(7) + yMovement2);
		currentDownLipMesh.getPoints().set(16, currentDownLipMesh.getPoints().get(16) + yMovement5);
		currentDownLipMesh.getPoints().set(25, currentDownLipMesh.getPoints().get(25) + yMovement8);
		currentDownLipMesh.getPoints().set(28, currentDownLipMesh.getPoints().get(28) + yMovement9);
		currentDownLipMesh.getPoints().set(31, currentDownLipMesh.getPoints().get(31) + yMovement10);
		
		currentDownLipMesh.getPoints().set(58, currentDownLipMesh.getPoints().get(58) + yMovement19);
		currentDownLipMesh.getPoints().set(55, currentDownLipMesh.getPoints().get(55) + yMovement18);
		currentDownLipMesh.getPoints().set(52, currentDownLipMesh.getPoints().get(52) + yMovement17);
		currentDownLipMesh.getPoints().set(49, currentDownLipMesh.getPoints().get(49) + yMovement16);
		currentDownLipMesh.getPoints().set(46, currentDownLipMesh.getPoints().get(46) + yMovement15);
		currentDownLipMesh.getPoints().set(43, currentDownLipMesh.getPoints().get(43) + yMovement14);
		currentDownLipMesh.getPoints().set(40, currentDownLipMesh.getPoints().get(40) + yMovement13);
		currentDownLipMesh.getPoints().set(37, currentDownLipMesh.getPoints().get(37) + yMovement12);
		currentDownLipMesh.getPoints().set(34, currentDownLipMesh.getPoints().get(34) + yMovement11);
		
		return currentDownLipMesh;
	}

}
