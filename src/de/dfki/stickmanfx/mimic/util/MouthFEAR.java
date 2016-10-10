package de.dfki.stickmanfx.mimic.util;

import de.dfki.stickmanfx.animationlogic.AnimatorFX;
import javafx.scene.shape.TriangleMesh;

public class MouthFEAR {
	
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
		float yMovement3;
		float yMovement5;
		float yMovement7;
		float xMovement8;
		float yMovement8;
		float xMovement9;
		float xMovement10;
		float xMovement11;
		float xMovement12;
		float yMovement12;
		float yMovement13;
		float yMovement14;
		float yMovement15;
		float yMovement16;
		float yMovement17;
		float xMovement18;
		
		xMovement0 = sig*(AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0105f;
		xMovement1 = sig*(AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0105f;
		xMovement2 = sig*(AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0105f;
		yMovement2 = sig*(AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0052f;
		yMovement3 = sig*(AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0052f;
		yMovement5 = sig*(AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0052f;
		yMovement7 = sig*(AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0052f;
		xMovement8 = sig*(AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0105f;
		yMovement8 = sig*(AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0052f;
		xMovement9 = sig*(AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0158f;
		xMovement10 = sig*(AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0158f;
		xMovement11 = sig*(AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0158f;
		xMovement12 = sig*(AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0105f;
		yMovement12 = sig*(AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0052f;
		yMovement13 = sig*(AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0105f;
		yMovement14 = sig*(AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0105f;
		yMovement15 = sig*(AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0052f;
		yMovement16 = sig*(AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0052f;
		yMovement17 = sig*(AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0052f;
		xMovement18 = sig*(AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0105f;
		
		
		currentUpperLipMesh.getPoints().set(0, currentUpperLipMesh.getPoints().get(0) - xMovement0);
		currentUpperLipMesh.getPoints().set(3, currentUpperLipMesh.getPoints().get(3) - xMovement1);
		currentUpperLipMesh.getPoints().set(6, currentUpperLipMesh.getPoints().get(6) - xMovement2);
		currentUpperLipMesh.getPoints().set(7, currentUpperLipMesh.getPoints().get(7) + yMovement2);
		currentUpperLipMesh.getPoints().set(10, currentUpperLipMesh.getPoints().get(10) + yMovement3);
		currentUpperLipMesh.getPoints().set(16, currentUpperLipMesh.getPoints().get(16) - yMovement5);
		currentUpperLipMesh.getPoints().set(22, currentUpperLipMesh.getPoints().get(22) + yMovement7);
		currentUpperLipMesh.getPoints().set(24, currentUpperLipMesh.getPoints().get(24) + xMovement8);
		currentUpperLipMesh.getPoints().set(25, currentUpperLipMesh.getPoints().get(25) + yMovement8);
		currentUpperLipMesh.getPoints().set(27, currentUpperLipMesh.getPoints().get(27) + xMovement9);
		currentUpperLipMesh.getPoints().set(30, currentUpperLipMesh.getPoints().get(30) + xMovement10);
		currentUpperLipMesh.getPoints().set(33, currentUpperLipMesh.getPoints().get(33) + xMovement11);
		currentUpperLipMesh.getPoints().set(36, currentUpperLipMesh.getPoints().get(36) + xMovement12);
		currentUpperLipMesh.getPoints().set(37, currentUpperLipMesh.getPoints().get(37) - yMovement12);
		currentUpperLipMesh.getPoints().set(40, currentUpperLipMesh.getPoints().get(40) - yMovement13);
		currentUpperLipMesh.getPoints().set(43, currentUpperLipMesh.getPoints().get(43) - yMovement14);
		currentUpperLipMesh.getPoints().set(46, currentUpperLipMesh.getPoints().get(46) - yMovement15);
		currentUpperLipMesh.getPoints().set(49, currentUpperLipMesh.getPoints().get(49) - yMovement16);
		currentUpperLipMesh.getPoints().set(52, currentUpperLipMesh.getPoints().get(52) - yMovement17);
		currentUpperLipMesh.getPoints().set(54, currentUpperLipMesh.getPoints().get(54) - xMovement18);
		
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
		float xMovement19;
		float xMovement18;
		float yMovement16;
		float yMovement15;
		float yMovement14;
		float yMovement13;
		float xMovement12;
		float yMovement12;
		float xMovement11;
		float xMovement10;
		float xMovement9;
		float xMovement8;
		float yMovement8;
		float yMovement7;
		float yMovement6;
		float yMovement5;
		float yMovement4;
		float yMovement3;
		float xMovement2;
		float yMovement2;
		float xMovement1;
		
		xMovement0 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0105f;
		xMovement19 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0105f;
		xMovement18 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0105f;
		yMovement16 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0052f;
		yMovement15 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0052f;
		yMovement14 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0052f;
		yMovement13 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0052f;
		xMovement12 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0105f;
		yMovement12 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0052f;
		xMovement11 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0158f;
		xMovement10 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0158f;
		xMovement9 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0158f;
		xMovement8 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0105f;
		yMovement8 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0052f;
		yMovement7 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0052f;
		yMovement6 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0052f;
		yMovement5 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0052f;
		yMovement4 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0052f;
		yMovement3 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0052f;
		xMovement2 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0105f;
		yMovement2 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0052f;
		xMovement1 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0105f;
		
		currentDownLipMesh.getPoints().set(0, currentDownLipMesh.getPoints().get(0) - xMovement0);
		currentDownLipMesh.getPoints().set(57, currentDownLipMesh.getPoints().get(57) - xMovement19);
		currentDownLipMesh.getPoints().set(54, currentDownLipMesh.getPoints().get(54) - xMovement18);
		currentDownLipMesh.getPoints().set(49, currentDownLipMesh.getPoints().get(49) + yMovement16);
		currentDownLipMesh.getPoints().set(46, currentDownLipMesh.getPoints().get(46) + yMovement15);
		currentDownLipMesh.getPoints().set(43, currentDownLipMesh.getPoints().get(43) + yMovement14);
		currentDownLipMesh.getPoints().set(40, currentDownLipMesh.getPoints().get(40) + yMovement13);
		currentDownLipMesh.getPoints().set(36, currentDownLipMesh.getPoints().get(36) + xMovement12);
		currentDownLipMesh.getPoints().set(37, currentDownLipMesh.getPoints().get(37) + yMovement12);
		currentDownLipMesh.getPoints().set(33, currentDownLipMesh.getPoints().get(33) + xMovement11);
		currentDownLipMesh.getPoints().set(30, currentDownLipMesh.getPoints().get(30) + xMovement10);
		currentDownLipMesh.getPoints().set(27, currentDownLipMesh.getPoints().get(27) + xMovement9);
		currentDownLipMesh.getPoints().set(24, currentDownLipMesh.getPoints().get(24) + xMovement8);
		currentDownLipMesh.getPoints().set(25, currentDownLipMesh.getPoints().get(25) - yMovement8);
		currentDownLipMesh.getPoints().set(22, currentDownLipMesh.getPoints().get(22) - yMovement7);
		currentDownLipMesh.getPoints().set(19, currentDownLipMesh.getPoints().get(19) - yMovement6);
		currentDownLipMesh.getPoints().set(16, currentDownLipMesh.getPoints().get(16) - yMovement5);
		currentDownLipMesh.getPoints().set(13, currentDownLipMesh.getPoints().get(13) - yMovement4);
		currentDownLipMesh.getPoints().set(10, currentDownLipMesh.getPoints().get(10) - yMovement3);
		currentDownLipMesh.getPoints().set(6, currentDownLipMesh.getPoints().get(6) - xMovement2);
		currentDownLipMesh.getPoints().set(7, currentDownLipMesh.getPoints().get(7) - yMovement2);
		currentDownLipMesh.getPoints().set(3, currentDownLipMesh.getPoints().get(3) - xMovement1);
		
		return currentDownLipMesh;
	}

}
