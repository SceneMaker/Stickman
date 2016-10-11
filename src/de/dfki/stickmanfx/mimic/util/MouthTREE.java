package de.dfki.stickmanfx.mimic.util;

import de.dfki.stickmanfx.animationlogic.AnimatorFX;
import javafx.scene.shape.TriangleMesh;

public class MouthTREE {
	
	public static TriangleMesh modifyUpperLip(TriangleMesh currentUpperLipMesh, float step, String sign)
	{
		int sig;
		
		if(sign.equalsIgnoreCase("PLUS"))
			sig = 1;
		else
			sig = -1;
		
		float xMovement0;
		float xMovement1;
		float yMovement3;
		float yMovement4;
		float yMovement5;
		float yMovement18;
		float yMovement17;
		float yMovement16;
		float yMovement15;
		float xMovement18;
		float xMovement19;
		
		xMovement0 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0263f;
		xMovement1 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0105f;
		yMovement3 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0052f;
		yMovement4 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0158f;
		yMovement5 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0263f;
		yMovement18 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0052f;
		xMovement18 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0105f;
		yMovement17 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0158f;
		yMovement16 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0263f;
		yMovement15 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0263f;
		xMovement19 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0263f;
		
		
		
		currentUpperLipMesh.getPoints().set(0, currentUpperLipMesh.getPoints().get(0) + xMovement0);	//0
		currentUpperLipMesh.getPoints().set(3, currentUpperLipMesh.getPoints().get(3) + xMovement1);	//1
		currentUpperLipMesh.getPoints().set(10, currentUpperLipMesh.getPoints().get(10) - yMovement3);	//3
		currentUpperLipMesh.getPoints().set(13, currentUpperLipMesh.getPoints().get(13) - yMovement4);	//4
		currentUpperLipMesh.getPoints().set(16, currentUpperLipMesh.getPoints().get(16) - yMovement5);	//5
		currentUpperLipMesh.getPoints().set(19, currentUpperLipMesh.getPoints().get(19) - yMovement4);	//6
		currentUpperLipMesh.getPoints().set(22, currentUpperLipMesh.getPoints().get(22) - yMovement3);	//7
		currentUpperLipMesh.getPoints().set(27, currentUpperLipMesh.getPoints().get(27) - xMovement1);	//9
		currentUpperLipMesh.getPoints().set(30, currentUpperLipMesh.getPoints().get(30) - xMovement0);	//10
		currentUpperLipMesh.getPoints().set(33, currentUpperLipMesh.getPoints().get(33) - xMovement19);	//11
		currentUpperLipMesh.getPoints().set(36, currentUpperLipMesh.getPoints().get(36) - xMovement18);	//12
		currentUpperLipMesh.getPoints().set(37, currentUpperLipMesh.getPoints().get(37) - yMovement18);	//12
		currentUpperLipMesh.getPoints().set(40, currentUpperLipMesh.getPoints().get(40) - yMovement17);	//13
		currentUpperLipMesh.getPoints().set(43, currentUpperLipMesh.getPoints().get(43) - yMovement16);	//14
		currentUpperLipMesh.getPoints().set(46, currentUpperLipMesh.getPoints().get(46) - yMovement15);	//15
		currentUpperLipMesh.getPoints().set(49, currentUpperLipMesh.getPoints().get(49) - yMovement16);	//16
		currentUpperLipMesh.getPoints().set(52, currentUpperLipMesh.getPoints().get(52) - yMovement17);	//17
		currentUpperLipMesh.getPoints().set(54, currentUpperLipMesh.getPoints().get(54) + xMovement18);	//18
		currentUpperLipMesh.getPoints().set(55, currentUpperLipMesh.getPoints().get(55) - yMovement18);	//18
		currentUpperLipMesh.getPoints().set(57, currentUpperLipMesh.getPoints().get(57) + xMovement19);	//19
		
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
		float xMovement1;
		float yMovement3;
		float yMovement4;
		float yMovement5;
		float yMovement18;
		float yMovement17;
		float yMovement16;
		float yMovement15;
		float xMovement18;
		float xMovement19;
		
		xMovement0 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0263f;
		xMovement1 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0105f;
		yMovement3 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0052f;
		yMovement4 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0158f;
		yMovement5 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0263f;
		yMovement18 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0052f;
		xMovement18 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0105f;
		yMovement17 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0158f;
		yMovement16 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0263f;
		yMovement15 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0263f;
		xMovement19 = sig * (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0263f;
		
		
		
		currentDownLipMesh.getPoints().set(0, currentDownLipMesh.getPoints().get(0) + xMovement0);	//0
		currentDownLipMesh.getPoints().set(3, currentDownLipMesh.getPoints().get(3) + xMovement1);	//1
		currentDownLipMesh.getPoints().set(10, currentDownLipMesh.getPoints().get(10) + yMovement3);	//3
		currentDownLipMesh.getPoints().set(13, currentDownLipMesh.getPoints().get(13) + yMovement4);	//4
		currentDownLipMesh.getPoints().set(16, currentDownLipMesh.getPoints().get(16) + yMovement5);	//5
		currentDownLipMesh.getPoints().set(19, currentDownLipMesh.getPoints().get(19) + yMovement4);	//6
		currentDownLipMesh.getPoints().set(22, currentDownLipMesh.getPoints().get(22) + yMovement3);	//7
		currentDownLipMesh.getPoints().set(27, currentDownLipMesh.getPoints().get(27) - xMovement1);	//9
		currentDownLipMesh.getPoints().set(30, currentDownLipMesh.getPoints().get(30) - xMovement0);	//10
		currentDownLipMesh.getPoints().set(33, currentDownLipMesh.getPoints().get(33) - xMovement19);	//11
		currentDownLipMesh.getPoints().set(36, currentDownLipMesh.getPoints().get(36) - xMovement18);	//12
		currentDownLipMesh.getPoints().set(37, currentDownLipMesh.getPoints().get(37) + yMovement18);	//12
		currentDownLipMesh.getPoints().set(40, currentDownLipMesh.getPoints().get(40) + yMovement17);	//13
		currentDownLipMesh.getPoints().set(43, currentDownLipMesh.getPoints().get(43) + yMovement16);	//14
		currentDownLipMesh.getPoints().set(46, currentDownLipMesh.getPoints().get(46) + yMovement15);	//15
		currentDownLipMesh.getPoints().set(49, currentDownLipMesh.getPoints().get(49) + yMovement16);	//16
		currentDownLipMesh.getPoints().set(52, currentDownLipMesh.getPoints().get(52) + yMovement17);	//17
		currentDownLipMesh.getPoints().set(54, currentDownLipMesh.getPoints().get(54) + xMovement18);	//18
		currentDownLipMesh.getPoints().set(55, currentDownLipMesh.getPoints().get(55) + yMovement18);	//18
		currentDownLipMesh.getPoints().set(57, currentDownLipMesh.getPoints().get(57) + xMovement19);	//19
		
		
		return currentDownLipMesh;
	}

}
