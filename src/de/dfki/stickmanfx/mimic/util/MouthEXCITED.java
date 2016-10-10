package de.dfki.stickmanfx.mimic.util;

import de.dfki.stickmanfx.animationlogic.AnimatorFX;
import javafx.scene.shape.TriangleMesh;

public class MouthEXCITED {
	////////////////////////////////
	public static TriangleMesh modifyUpperLip(TriangleMesh currentUpperLipMesh, float step, String sign)
	{
		int sig;
		
		if(sign.equalsIgnoreCase("PLUS"))
			sig = 1;
		else
			sig = -1;
		
		float xMovement0;
		float yMovement0;
		float yMovement1;
		float yMovement2;
		float yMovement3;
		float yMovement4;
		float yMovement5;
		float yMovement6;
		float yMovement7;
		float yMovement8;
		float yMovement9;
		float yMovement10;
		
		float xMovement10;
		float yMovement12;
		float yMovement13;
		float yMovement14;
		float yMovement15;
		float yMovement16;
		float yMovement17;
		float yMovement18;
		
		xMovement0 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0158f;
		yMovement0 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0210f;
		yMovement1 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0052f;
		yMovement2 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0105f;
		yMovement3 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0210f;
		yMovement4 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0263f;
		yMovement5 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0158f;
		yMovement6 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0263f;
		yMovement7 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0210f;
		yMovement8 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0105f;
		yMovement9 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0052f;
		yMovement10 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0210f;
		
		xMovement10 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0158f;
		yMovement12 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0158f;
		yMovement13 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0210f;
		yMovement14 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0263f;
		yMovement15 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0263f;
		yMovement16 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0263f;
		yMovement17 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0210f;
		yMovement18 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0158f;
		
		currentUpperLipMesh.getPoints().set(0, currentUpperLipMesh.getPoints().get(0) - xMovement0);
		currentUpperLipMesh.getPoints().set(1, currentUpperLipMesh.getPoints().get(1) - yMovement0);
		currentUpperLipMesh.getPoints().set(4, currentUpperLipMesh.getPoints().get(4) - yMovement1);
		currentUpperLipMesh.getPoints().set(7, currentUpperLipMesh.getPoints().get(7) + yMovement2);
		currentUpperLipMesh.getPoints().set(10, currentUpperLipMesh.getPoints().get(10) + yMovement3);
		currentUpperLipMesh.getPoints().set(13, currentUpperLipMesh.getPoints().get(13) + yMovement4);
		currentUpperLipMesh.getPoints().set(16, currentUpperLipMesh.getPoints().get(16) + yMovement5);
		currentUpperLipMesh.getPoints().set(19, currentUpperLipMesh.getPoints().get(19) + yMovement6);
		currentUpperLipMesh.getPoints().set(22, currentUpperLipMesh.getPoints().get(22) + yMovement7);
		currentUpperLipMesh.getPoints().set(25, currentUpperLipMesh.getPoints().get(25) + yMovement8);
		currentUpperLipMesh.getPoints().set(28, currentUpperLipMesh.getPoints().get(28) - yMovement9);
		currentUpperLipMesh.getPoints().set(31, currentUpperLipMesh.getPoints().get(31) - yMovement10);
		
		currentUpperLipMesh.getPoints().set(30, currentUpperLipMesh.getPoints().get(30) + xMovement10);
		currentUpperLipMesh.getPoints().set(37, currentUpperLipMesh.getPoints().get(37) + yMovement12);
		currentUpperLipMesh.getPoints().set(40, currentUpperLipMesh.getPoints().get(40) + yMovement13);
		currentUpperLipMesh.getPoints().set(43, currentUpperLipMesh.getPoints().get(43) + yMovement14);
		currentUpperLipMesh.getPoints().set(46, currentUpperLipMesh.getPoints().get(46) + yMovement15);
		currentUpperLipMesh.getPoints().set(49, currentUpperLipMesh.getPoints().get(49) + yMovement16);
		currentUpperLipMesh.getPoints().set(52, currentUpperLipMesh.getPoints().get(52) + yMovement17);
		currentUpperLipMesh.getPoints().set(55, currentUpperLipMesh.getPoints().get(55) + yMovement18);
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
		float yMovement18;
		float yMovement17;
		float yMovement16;
		float yMovement15;
		float yMovement14;
		float yMovement13;
		float yMovement12;
		float xMovement10;
		float yMovement10;
		float yMovement9;
		float yMovement8;
		float yMovement7;
		float yMovement6;
		float yMovement5;
		float yMovement4;
		float yMovement3;
		float yMovement2;
		float yMovement1;
		
		xMovement0 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0158f;
		yMovement0 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0210f;
		
		yMovement18 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0316f;
		yMovement17 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0474f;
		yMovement16 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0579f;
		yMovement15 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0579f;
		yMovement14 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0579f;
		yMovement13 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0474f;
		yMovement12 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0316f;
		xMovement10 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0158f;
		yMovement10 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0210f;
		yMovement9 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0316f;
		yMovement8 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0368f;
		yMovement7 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0421f;
		yMovement6 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0526f;
		yMovement5 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0659f;
		yMovement4 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0526f;
		yMovement3 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0421f;
		yMovement2 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0368f;
		yMovement1 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0316f;
		
		currentDownLipMesh.getPoints().set(0, currentDownLipMesh.getPoints().get(0) - xMovement0);
		currentDownLipMesh.getPoints().set(1, currentDownLipMesh.getPoints().get(1) - yMovement0);
		
		currentDownLipMesh.getPoints().set(55, currentDownLipMesh.getPoints().get(55) + yMovement18);
		currentDownLipMesh.getPoints().set(52, currentDownLipMesh.getPoints().get(52) + yMovement17);
		currentDownLipMesh.getPoints().set(49, currentDownLipMesh.getPoints().get(49) + yMovement16);
		currentDownLipMesh.getPoints().set(46, currentDownLipMesh.getPoints().get(46) + yMovement15);
		currentDownLipMesh.getPoints().set(43, currentDownLipMesh.getPoints().get(43) + yMovement14);
		currentDownLipMesh.getPoints().set(40, currentDownLipMesh.getPoints().get(40) + yMovement13);
		currentDownLipMesh.getPoints().set(37, currentDownLipMesh.getPoints().get(37) + yMovement12);
		currentDownLipMesh.getPoints().set(30, currentDownLipMesh.getPoints().get(30) + xMovement10);
		currentDownLipMesh.getPoints().set(31, currentDownLipMesh.getPoints().get(31) - yMovement10);
		currentDownLipMesh.getPoints().set(28, currentDownLipMesh.getPoints().get(28) + yMovement9);
		currentDownLipMesh.getPoints().set(25, currentDownLipMesh.getPoints().get(25) + yMovement8);
		currentDownLipMesh.getPoints().set(22, currentDownLipMesh.getPoints().get(22) + yMovement7);
		currentDownLipMesh.getPoints().set(19, currentDownLipMesh.getPoints().get(19) + yMovement6);
		currentDownLipMesh.getPoints().set(16, currentDownLipMesh.getPoints().get(16) + yMovement5);
		currentDownLipMesh.getPoints().set(13, currentDownLipMesh.getPoints().get(13) + yMovement4);
		currentDownLipMesh.getPoints().set(10, currentDownLipMesh.getPoints().get(10) + yMovement3);
		currentDownLipMesh.getPoints().set(7, currentDownLipMesh.getPoints().get(7) + yMovement2);
		currentDownLipMesh.getPoints().set(4, currentDownLipMesh.getPoints().get(4) + yMovement1);
		
		return currentDownLipMesh;
	}

}
