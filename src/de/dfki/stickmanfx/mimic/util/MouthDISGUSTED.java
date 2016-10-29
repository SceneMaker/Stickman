package de.dfki.stickmanfx.mimic.util;

import de.dfki.stickmanfx.animationlogic.AnimatorFX;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.TriangleMesh;

public class MouthDISGUSTED {
	
	public static Polygon modifyUpperLip(Polygon currentUpperLipMesh, float step, String sign)
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
		currentUpperLipMesh.getPoints().set(5, currentUpperLipMesh.getPoints().get(5) - upYMovement2);
		currentUpperLipMesh.getPoints().set(7, currentUpperLipMesh.getPoints().get(7) - upYMovement3);
		currentUpperLipMesh.getPoints().set(9, currentUpperLipMesh.getPoints().get(9) - upYMovement4);
		currentUpperLipMesh.getPoints().set(11, currentUpperLipMesh.getPoints().get(11) - upYMovement5);
		currentUpperLipMesh.getPoints().set(13, currentUpperLipMesh.getPoints().get(13) - upYMovement4);
		currentUpperLipMesh.getPoints().set(15, currentUpperLipMesh.getPoints().get(15) - upYMovement3);
		currentUpperLipMesh.getPoints().set(17, currentUpperLipMesh.getPoints().get(17) - upYMovement2);
		currentUpperLipMesh.getPoints().set(21, currentUpperLipMesh.getPoints().get(21) + upYMovement0);
		
		currentUpperLipMesh.getPoints().set(39, currentUpperLipMesh.getPoints().get(39) + upYMovement19);
		currentUpperLipMesh.getPoints().set(37, currentUpperLipMesh.getPoints().get(37) - upYMovement18);
		currentUpperLipMesh.getPoints().set(35, currentUpperLipMesh.getPoints().get(35) - upYMovement17);
		currentUpperLipMesh.getPoints().set(33, currentUpperLipMesh.getPoints().get(33) - upYMovement16);
		currentUpperLipMesh.getPoints().set(31, currentUpperLipMesh.getPoints().get(31) - upYMovement15);
		currentUpperLipMesh.getPoints().set(29, currentUpperLipMesh.getPoints().get(29) - upYMovement16);
		currentUpperLipMesh.getPoints().set(27, currentUpperLipMesh.getPoints().get(27) - upYMovement17);
		currentUpperLipMesh.getPoints().set(25, currentUpperLipMesh.getPoints().get(25) - upYMovement18);
		currentUpperLipMesh.getPoints().set(23, currentUpperLipMesh.getPoints().get(23) + upYMovement19);
		
		return currentUpperLipMesh;
	}
	
	public static Polygon modifyDownLip(Polygon currentDownLipMesh, float step, String sign)
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
		currentDownLipMesh.getPoints().set(3, currentDownLipMesh.getPoints().get(3) + yMovement1);
		currentDownLipMesh.getPoints().set(5, currentDownLipMesh.getPoints().get(5) + yMovement2);
		currentDownLipMesh.getPoints().set(11, currentDownLipMesh.getPoints().get(11) + yMovement5);
		currentDownLipMesh.getPoints().set(17, currentDownLipMesh.getPoints().get(17) + yMovement8);
		currentDownLipMesh.getPoints().set(19, currentDownLipMesh.getPoints().get(19) + yMovement9);
		currentDownLipMesh.getPoints().set(21, currentDownLipMesh.getPoints().get(21) + yMovement10);
		
		currentDownLipMesh.getPoints().set(39, currentDownLipMesh.getPoints().get(39) + yMovement19);
		currentDownLipMesh.getPoints().set(37, currentDownLipMesh.getPoints().get(37) + yMovement18);
		currentDownLipMesh.getPoints().set(35, currentDownLipMesh.getPoints().get(35) + yMovement17);
		currentDownLipMesh.getPoints().set(33, currentDownLipMesh.getPoints().get(33) + yMovement16);
		currentDownLipMesh.getPoints().set(31, currentDownLipMesh.getPoints().get(31) + yMovement15);
		currentDownLipMesh.getPoints().set(29, currentDownLipMesh.getPoints().get(29) + yMovement14);
		currentDownLipMesh.getPoints().set(27, currentDownLipMesh.getPoints().get(27) + yMovement13);
		currentDownLipMesh.getPoints().set(25, currentDownLipMesh.getPoints().get(25) + yMovement12);
		currentDownLipMesh.getPoints().set(23, currentDownLipMesh.getPoints().get(23) + yMovement11);
		
		return currentDownLipMesh;
	}

}
