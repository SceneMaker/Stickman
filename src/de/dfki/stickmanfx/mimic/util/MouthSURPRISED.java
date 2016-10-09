package de.dfki.stickmanfx.mimic.util;

import de.dfki.stickmanfx.animationlogic.AnimatorFX;
import javafx.scene.shape.TriangleMesh;

public class MouthSURPRISED {
	
	public static TriangleMesh modifyUpperLip(TriangleMesh currentUpperLipMesh, float step, String sign)
	{
		float yMovement5;
		float yMovement2;
		float yMovement3;
		float yMovement4;
		float yMovement6;
		float yMovement7;
		float yMovement8;
		float yMovement9;
		float yMovement11;
		float yMovement12;
		float yMovement13;
		float yMovement14;
		float yMovement15;
		float yMovement16;
		float yMovement17;
		
		if(sign.equalsIgnoreCase("PLUS"))
		{
			yMovement2 = (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0158f;
			yMovement3 = (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0263f;
			yMovement4 = (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0368f;
			yMovement5 = (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0526f;
			yMovement6 = (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0368f;
			yMovement7 = (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0263f;
			yMovement8 = (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0158f;
			yMovement9 = (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0105f;
			
			yMovement11 = (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0158f;
			yMovement12 = (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0263f;
			yMovement13 = (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0421f;
			yMovement14 = (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0473f;
			yMovement15 = (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0421f;
			yMovement16 = (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0263f;
			yMovement17 = (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0158f;

		}
		else
		{
			yMovement2 = -(AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0158f;
			yMovement3 = -(AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0263f;
			yMovement4 = -(AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0368f;
			yMovement5 = -(AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0526f;
			yMovement6 = -(AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0368f;
			yMovement7 = -(AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0263f;
			yMovement8 = -(AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0158f;
			yMovement9 = -(AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0105f;
			
			yMovement11 = -(AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0158f;
			yMovement12 = -(AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0263f;
			yMovement13 = -(AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0421f;
			yMovement14 = -(AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0473f;
			yMovement15 = -(AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0421f;
			yMovement16 = -(AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0263f;
			yMovement17 = -(AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0158f;
		}
		
		currentUpperLipMesh.getPoints().set(7, currentUpperLipMesh.getPoints().get(7) - yMovement2);
		currentUpperLipMesh.getPoints().set(10, currentUpperLipMesh.getPoints().get(10) - yMovement3);
		currentUpperLipMesh.getPoints().set(13, currentUpperLipMesh.getPoints().get(13) - yMovement4);
		currentUpperLipMesh.getPoints().set(16, currentUpperLipMesh.getPoints().get(16) - yMovement5);
		currentUpperLipMesh.getPoints().set(19, currentUpperLipMesh.getPoints().get(19) - yMovement6);
		currentUpperLipMesh.getPoints().set(22, currentUpperLipMesh.getPoints().get(22) - yMovement7);
		currentUpperLipMesh.getPoints().set(25, currentUpperLipMesh.getPoints().get(25) - yMovement8);
		currentUpperLipMesh.getPoints().set(18, currentUpperLipMesh.getPoints().get(18) - yMovement9);
		
		currentUpperLipMesh.getPoints().set(55, currentUpperLipMesh.getPoints().get(55) - yMovement11);
		currentUpperLipMesh.getPoints().set(52, currentUpperLipMesh.getPoints().get(52) - yMovement12);
		currentUpperLipMesh.getPoints().set(49, currentUpperLipMesh.getPoints().get(49) - yMovement13);
		currentUpperLipMesh.getPoints().set(46, currentUpperLipMesh.getPoints().get(46) - yMovement14);
		currentUpperLipMesh.getPoints().set(43, currentUpperLipMesh.getPoints().get(43) - yMovement15);
		currentUpperLipMesh.getPoints().set(40, currentUpperLipMesh.getPoints().get(40) - yMovement16);
		currentUpperLipMesh.getPoints().set(37, currentUpperLipMesh.getPoints().get(37) - yMovement17);		
		return currentUpperLipMesh;
	}
	
	public static TriangleMesh modifyDownLip(TriangleMesh currentDownLipMesh, float step, String sign)
	{
		float yMovement2;
		float yMovement3;
		float yMovement4;
		float yMovement5;
		float yMovement6;
		float yMovement7;
		float yMovement8;
		float yMovement9;
		float yMovement11;
		float yMovement12;
		float yMovement13;
		float yMovement14;
		float yMovement15;
		float yMovement16;
		float yMovement17;
		
		if(sign.equalsIgnoreCase("PLUS"))
		{
			yMovement2 = (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0158f;
			yMovement3 = (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0263f;
			yMovement4 = (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0368f;
			yMovement5 = (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0526f;
			yMovement6 = (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0368f;
			yMovement7 = (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0263f;
			yMovement8 = (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0158f;
			yMovement9 = (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0105f;
			
			yMovement11 = (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0158f;
			yMovement12 = (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0263f;
			yMovement13 = (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0421f;
			yMovement14 = (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0473f;
			yMovement15 = (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0421f;
			yMovement16 = (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0263f;
			yMovement17 = (AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0158f;
		}
		else
		{
			yMovement2 = -(AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0158f;
			yMovement3 = -(AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0263f;
			yMovement4 = -(AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0368f;
			yMovement5 = -(AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0526f;
			yMovement6 = -(AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0368f;
			yMovement7 = -(AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0263f;
			yMovement8 = -(AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0158f;
			yMovement9 = -(AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0105f;
			
			yMovement11 = -(AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0158f;
			yMovement12 = -(AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0263f;
			yMovement13 = -(AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0421f;
			yMovement14 = -(AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0473f;
			yMovement15 = -(AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0421f;
			yMovement16 = -(AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0263f;
			yMovement17 = -(AnimatorFX.sMAX_ANIM_STEPS - step) * 0.0158f;
		}
		
		currentDownLipMesh.getPoints().set(7, currentDownLipMesh.getPoints().get(7) + yMovement2);
		currentDownLipMesh.getPoints().set(10, currentDownLipMesh.getPoints().get(10) + yMovement3);
		currentDownLipMesh.getPoints().set(13, currentDownLipMesh.getPoints().get(13) + yMovement4);
		currentDownLipMesh.getPoints().set(16, currentDownLipMesh.getPoints().get(16) + yMovement5);
		currentDownLipMesh.getPoints().set(19, currentDownLipMesh.getPoints().get(19) + yMovement6);
		currentDownLipMesh.getPoints().set(22, currentDownLipMesh.getPoints().get(22) + yMovement7);
		currentDownLipMesh.getPoints().set(25, currentDownLipMesh.getPoints().get(25) + yMovement8);
		currentDownLipMesh.getPoints().set(18, currentDownLipMesh.getPoints().get(18) + yMovement9);
		
		currentDownLipMesh.getPoints().set(55, currentDownLipMesh.getPoints().get(55) + yMovement11);
		currentDownLipMesh.getPoints().set(52, currentDownLipMesh.getPoints().get(52) + yMovement12);
		currentDownLipMesh.getPoints().set(49, currentDownLipMesh.getPoints().get(49) + yMovement13);
		currentDownLipMesh.getPoints().set(46, currentDownLipMesh.getPoints().get(46) + yMovement14);
		currentDownLipMesh.getPoints().set(43, currentDownLipMesh.getPoints().get(43) + yMovement15);
		currentDownLipMesh.getPoints().set(40, currentDownLipMesh.getPoints().get(40) + yMovement16);
		currentDownLipMesh.getPoints().set(37, currentDownLipMesh.getPoints().get(37) + yMovement17);		
		return currentDownLipMesh;
	}

}
