package de.dfki.stickmanfx.bodyfx;

import de.dfki.stickmanfx.StickmanFX;
import de.dfki.stickmanfx.animationlogic.AnimatorFX;

import java.awt.Dimension;
import java.net.URL;

import com.interactivemesh.jfx.importer.col.ColModelImporter;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.DrawMode;
import javafx.scene.shape.MeshView;
import javafx.scene.shape.TriangleMesh;
/**
 *
 * @author Beka Aptsiauri
 *
 */
public class MouthFX extends BodyPartFX {

	public static enum SHAPE {
		DEFAULT, SMILE, SMILEEND, SAD, SADEND, ANGRY, ANGRYEND, ANGRYSMALLMOUTH, ANGRYSMALLMOUTHEND, SURPRISED, SURPRISEDEND, HAPPY, HAPPYEND, DISGUSTED, DISGUSTEDEND, CONTEMPT, CONTEMPTEND, EXCITED, EXCITEDEND, EMBARRASSED, EMBARRASSEDEND, FEAR, FEAREND, O, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, ELEVEN, TWELVE, THIRTEEN, FOURTEEN, NINETEEN, TWENTY,
	};

	HeadFX mHeadFX;
	
	TriangleMesh currentDownLipMesh;
	TriangleMesh currentUpperLipMesh;
	MeshView downLip;
	MeshView upperLip;
	PhongMaterial mat;
////////////////////////
	public MouthFX.SHAPE mShape = MouthFX.SHAPE.DEFAULT;

	public MouthFX(HeadFX head) {
		mHeadFX = head;
		mSize = new Dimension(mLength * 2, 5);

		mColor = Color.rgb(mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.FEMALE ? 64 : 32, 0, 0,
				(128 * 100 / 255) / 100f);
		
		init();
	}

	@Override
	public void setShape(String s) {
		MouthFX.SHAPE shape = MouthFX.SHAPE.valueOf(s);
		mShape = (shape != null) ? shape : MouthFX.SHAPE.DEFAULT;
	}

	@Override
	public void resetShape() {
		mShape = MouthFX.SHAPE.DEFAULT;
	}

	@Override
	public void calculate(int step) {
		mStart = mHeadFX.getMouthPostion();
		
		float xMovement0;
		float xMovement1;
		float xMovement9;
		float xMovement10;
		float xMovement11;
		float xMovement19;
		
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
		float yMovement11;
		float yMovement12;
		float yMovement13;
		float yMovement14;
		float yMovement15;
		float yMovement16;
		float yMovement17;
		float yMovement18;
		float yMovement19;
		
		switch (mShape) {
		case DEFAULT:
			if (mHeadFX.mStickmanFX.setCharacterInvisible == true) {
				if (mHeadFX.mStickmanFX.fadeControler == true) {
					int fadeFactor = mHeadFX.mStickmanFX.mMouthFX.mShapeAnimationStep * 6;
					if (fadeFactor <= 12) {
						fadeFactor = 0;
					}
					mColor = Color.rgb(mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.FEMALE ? 64 : 32, 0, 0,
							(fadeFactor * 100 / 255) / 100f);
				} else {
					int fadeFactor = (20 - mHeadFX.mStickmanFX.mMouthFX.mShapeAnimationStep) * 6;
					if (fadeFactor >= 107) {
						mColor = mColorRecorder;
					} else
						mColor = Color.rgb(mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.FEMALE ? 64 : 32, 0, 0,
								(fadeFactor * 100 / 255) / 100f);
				}
			}
			
			currentUpperLipMesh = createUpperLip();
			currentDownLipMesh = createDownLip();
			break;

		case SMILE:
			String a = "b";
			currentUpperLipMesh = MouthSMILE.modifyUpperLip(currentUpperLipMesh, mShapeAnimationStep, "plus");
			currentDownLipMesh = MouthSMILE.modifyDownLip(currentDownLipMesh, mShapeAnimationStep, "plus");
			break;
			
		case SMILEEND:
			currentUpperLipMesh = MouthSMILE.modifyUpperLip(currentUpperLipMesh,mShapeAnimationStep, "minus");
			currentDownLipMesh = MouthSMILE.modifyDownLip(currentDownLipMesh, mShapeAnimationStep, "minus");
			break;

		case SAD:
			currentUpperLipMesh = MouthSAD.modifyUpperLip(currentUpperLipMesh, mShapeAnimationStep, "plus");
			currentDownLipMesh = MouthSAD.modifyDownLip(currentDownLipMesh, mShapeAnimationStep, "plus");
			break;
		case SADEND:
			currentUpperLipMesh = MouthSAD.modifyUpperLip(currentUpperLipMesh, mShapeAnimationStep, "minus");
			currentDownLipMesh = MouthSAD.modifyDownLip(currentDownLipMesh, mShapeAnimationStep, "minus");
			break;
		case ANGRY:
			currentUpperLipMesh = MouthANGRY.modifyUpperLip(currentUpperLipMesh, mShapeAnimationStep, "plus");
			currentDownLipMesh = MouthANGRY.modifyDownLip(currentDownLipMesh, mShapeAnimationStep, "plus");
			break;
		case ANGRYEND:
			currentUpperLipMesh = MouthANGRY.modifyUpperLip(currentUpperLipMesh, mShapeAnimationStep, "minus");
			currentDownLipMesh = MouthANGRY.modifyDownLip(currentDownLipMesh, mShapeAnimationStep, "minus");
			break;
		case SURPRISED:
			yMovement1 = (AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0105f;
			yMovement2 = (AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0158f;
			yMovement3 = (AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0263f;
			yMovement4 = (AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0368f;
			yMovement5 = (AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0526f;
			yMovement6 = (AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0368f;
			yMovement7 = (AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0263f;
			yMovement8 = (AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0158f;
			yMovement9 = (AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0105f;
			
			yMovement11 = (AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0158f;
			yMovement12 = (AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0263f;
			yMovement13 = (AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0421f;
			yMovement14 = (AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0473f;
			yMovement15 = (AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0421f;
			yMovement16 = (AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0263f;
			yMovement17 = (AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0158f;
			
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
			break;
		case SURPRISEDEND:
			yMovement1 = -(AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0105f;
			yMovement2 = -(AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0158f;
			yMovement3 = -(AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0263f;
			yMovement4 = -(AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0368f;
			yMovement5 = -(AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0526f;
			yMovement6 = -(AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0368f;
			yMovement7 = -(AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0263f;
			yMovement8 = -(AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0158f;
			yMovement9 = -(AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0105f;
			
			yMovement11 = -(AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0158f;
			yMovement12 = -(AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0263f;
			yMovement13 = -(AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0421f;
			yMovement14 = -(AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0473f;
			yMovement15 = -(AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0421f;
			yMovement16 = -(AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0263f;
			yMovement17 = -(AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0158f;
			
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
			break;
			
		case HAPPY:
			yMovement2 = (AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0053f;
			yMovement3 = (AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0105f;
			yMovement4 = (AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0210f;
			yMovement5 = (AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0368f;
			yMovement6 = (AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0210f;
			yMovement7 = (AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0105f;
			yMovement8 = (AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0053f;
			
			yMovement9 = (AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0105f;
			yMovement10 = (AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0210f;
			yMovement11 = (AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0315f;
			yMovement12 = (AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0368f;
			yMovement13 = (AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0315f;
			yMovement14 = (AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0210f;
			yMovement15 = (AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0105f;
			
			yMovement16 = (AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0105f;
			yMovement17 = (AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0105f;
			yMovement18 = (AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0079f;
			yMovement19 = (AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0026f;
			
			currentUpperLipMesh.getPoints().set(16, currentUpperLipMesh.getPoints().get(16) - yMovement16);
			currentUpperLipMesh.getPoints().set(46, currentUpperLipMesh.getPoints().get(46) - yMovement17);
			currentUpperLipMesh.getPoints().set(49, currentUpperLipMesh.getPoints().get(49) - yMovement18);
			currentUpperLipMesh.getPoints().set(43, currentUpperLipMesh.getPoints().get(43) - yMovement18);
			currentUpperLipMesh.getPoints().set(52, currentUpperLipMesh.getPoints().get(52) - yMovement19);
			currentUpperLipMesh.getPoints().set(40, currentUpperLipMesh.getPoints().get(40) - yMovement19);
			
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
			break;

		case HAPPYEND:
			yMovement2 = -(AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0053f;
			yMovement3 = -(AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0105f;
			yMovement4 = -(AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0210f;
			yMovement5 = -(AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0368f;
			yMovement6 = -(AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0210f;
			yMovement7 = -(AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0105f;
			yMovement8 = -(AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0053f;
			
			yMovement9 = -(AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0105f;
			yMovement10 = -(AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0210f;
			yMovement11 = -(AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0315f;
			yMovement12 = -(AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0368f;
			yMovement13 = -(AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0315f;
			yMovement14 = -(AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0210f;
			yMovement15 = -(AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0105f;
			
			yMovement16 = -(AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0105f;
			yMovement17 = -(AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0105f;
			yMovement18 = -(AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0079f;
			yMovement19 = -(AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0026f;
			
			currentUpperLipMesh.getPoints().set(16, currentUpperLipMesh.getPoints().get(16) - yMovement16);
			currentUpperLipMesh.getPoints().set(46, currentUpperLipMesh.getPoints().get(46) - yMovement17);
			currentUpperLipMesh.getPoints().set(49, currentUpperLipMesh.getPoints().get(49) - yMovement18);
			currentUpperLipMesh.getPoints().set(43, currentUpperLipMesh.getPoints().get(43) - yMovement18);
			currentUpperLipMesh.getPoints().set(52, currentUpperLipMesh.getPoints().get(52) - yMovement19);
			currentUpperLipMesh.getPoints().set(40, currentUpperLipMesh.getPoints().get(40) - yMovement19);
			
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
			break;
		case DISGUSTED:
			yMovement0 = (AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0421f;
			yMovement1 = (AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0263f;
			yMovement2 = (AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0105f;
			yMovement5 = (AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0052f;
			yMovement8 = (AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0105f;
			yMovement9 = (AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0263f;
			yMovement10 = (AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0421f;
			
			yMovement19 = (AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0210f;
			yMovement18 = (AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0158f;
			yMovement17 = (AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0105f;
			yMovement16 = (AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0052f;
			yMovement15 = (AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0052f;
			yMovement14 = (AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0052f;
			yMovement13 = (AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0105f;
			yMovement12 = (AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0158f;
			yMovement11 = (AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0210f;
			
			float upYMovement0 = (AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0421f;
			float upYMovement2 = (AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0052f;
			float upYMovement3 = (AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0052f;
			float upYMovement4 = (AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0105f;
			float upYMovement5 = (AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0210f;
			float upYMovement19 = (AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0210f;
			float upYMovement18 = (AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0105f;
			float upYMovement17 = (AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0158f;
			float upYMovement16 = (AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0210f;
			float upYMovement15 = (AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0210f;
			
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
			break;

		case DISGUSTEDEND:
			yMovement0 = -(AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0421f;
			yMovement1 = -(AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0263f;
			yMovement2 = -(AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0105f;
			yMovement5 = -(AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0052f;
			yMovement8 = -(AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0105f;
			yMovement9 = -(AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0263f;
			yMovement10 = -(AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0421f;
			
			yMovement19 = -(AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0210f;
			yMovement18 = -(AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0158f;
			yMovement17 = -(AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0105f;
			yMovement16 = -(AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0052f;
			yMovement15 = -(AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0052f;
			yMovement14 = -(AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0052f;
			yMovement13 = -(AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0105f;
			yMovement12 = -(AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0158f;
			yMovement11 = -(AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0210f;
			
			float uppYMovement0 = -(AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0421f;
			float uppYMovement2 = -(AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0052f;
			float uppYMovement3 = -(AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0052f;
			float uppYMovement4 = -(AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0105f;
			float uppYMovement5 = -(AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0210f;
			float uppYMovement19 = -(AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0210f;
			float uppYMovement18 = -(AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0105f;
			float uppYMovement17 = -(AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0158f;
			float uppYMovement16 = -(AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0210f;
			float uppYMovement15 = -(AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0210f;
			
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
			
			
			currentUpperLipMesh.getPoints().set(1, currentUpperLipMesh.getPoints().get(1) + uppYMovement0);
			currentUpperLipMesh.getPoints().set(7, currentUpperLipMesh.getPoints().get(7) - uppYMovement2);
			currentUpperLipMesh.getPoints().set(10, currentUpperLipMesh.getPoints().get(10) - uppYMovement3);
			currentUpperLipMesh.getPoints().set(13, currentUpperLipMesh.getPoints().get(13) - uppYMovement4);
			currentUpperLipMesh.getPoints().set(16, currentUpperLipMesh.getPoints().get(16) - uppYMovement5);
			currentUpperLipMesh.getPoints().set(19, currentUpperLipMesh.getPoints().get(19) - uppYMovement4);
			currentUpperLipMesh.getPoints().set(22, currentUpperLipMesh.getPoints().get(22) - uppYMovement3);
			currentUpperLipMesh.getPoints().set(25, currentUpperLipMesh.getPoints().get(25) - uppYMovement2);
			currentUpperLipMesh.getPoints().set(31, currentUpperLipMesh.getPoints().get(31) + uppYMovement0);
			
			currentUpperLipMesh.getPoints().set(58, currentUpperLipMesh.getPoints().get(58) + uppYMovement19);
			currentUpperLipMesh.getPoints().set(55, currentUpperLipMesh.getPoints().get(55) - uppYMovement18);
			currentUpperLipMesh.getPoints().set(52, currentUpperLipMesh.getPoints().get(52) - uppYMovement17);
			currentUpperLipMesh.getPoints().set(49, currentUpperLipMesh.getPoints().get(49) - uppYMovement16);
			currentUpperLipMesh.getPoints().set(46, currentUpperLipMesh.getPoints().get(46) - uppYMovement15);
			currentUpperLipMesh.getPoints().set(43, currentUpperLipMesh.getPoints().get(43) - uppYMovement16);
			currentUpperLipMesh.getPoints().set(40, currentUpperLipMesh.getPoints().get(40) - uppYMovement17);
			currentUpperLipMesh.getPoints().set(37, currentUpperLipMesh.getPoints().get(37) - uppYMovement18);
			currentUpperLipMesh.getPoints().set(34, currentUpperLipMesh.getPoints().get(34) + uppYMovement19);
			break;
		case CONTEMPT:
			break;

		case CONTEMPTEND:
			break;

		case FEAR:
			break;

		case EXCITED:
			break;

		case EXCITEDEND:
			break;

		case EMBARRASSED:
			break;
		case O:
			break;

		case ONE:
		case SIX:
		case FOURTEEN:
		case NINETEEN:
			break;

		case TWO:
			break;

		case THREE:
		case TWENTY:
			break;

		case FOUR:
			break;

		case FIVE:
		case EIGHT:
			break;

		case SEVEN:
			break;

		case NINE:
			break;

		case TEN:
			break;

		}
		
		upperLip = new MeshView(currentUpperLipMesh);
		upperLip.setDrawMode(DrawMode.FILL);
	    mat = new PhongMaterial();
	    mat.setDiffuseColor(Color.BLACK);
	    upperLip.setMaterial(mat);
	    
	    upperLip.setTranslateX(mStart.x-14);
	    upperLip.setTranslateY(mStart.y+95);
	    upperLip.setTranslateZ(-17);
		
		if (step == 0) 
			mHeadFX.mHead.getChildren().add(upperLip);
		else
			mHeadFX.mHead.getChildren().set(6, upperLip);
		
		downLip = new MeshView(currentDownLipMesh);
		downLip.setDrawMode(DrawMode.FILL);
		downLip.setMaterial(mat);
		downLip.setTranslateX(mStart.x-14);
		downLip.setTranslateY(mStart.y+95);
		downLip.setTranslateZ(-17);
	    
	    if (step == 0) 
			mHeadFX.mHead.getChildren().add(downLip);
		else
			mHeadFX.mHead.getChildren().set(7, downLip);
	}

	protected void recordColor() {
		if (mHeadFX.mStickmanFX.setCharacterInvisible == false)
			mColorRecorder = mColor;
	}
	
	private TriangleMesh createUpperLip()
	{
		TriangleMesh tMesh = new TriangleMesh();
		tMesh.getTexCoords().addAll(0,0);
		
		tMesh.getPoints().addAll(
				//  x   y   z	
					0,	0,	0,			//Point 0
					3,	-2, 0,			//Point 1
					6,	-4,	0,			//Point 2
					9,	-5,	0,			//Point 3
					13,	-5,	0,			//Point 4
					16,	-3,	0,			//Point 5
					19,	-5,	0,			//Point 6
					23,	-5,	0,			//Point 7
					26,	-4,	0,			//Point 8
					29,	-2,	0,			//Point 9
					32,	0,	0,			//Point 10
					29,	0,	0,			//Point 11
					26,	0,	0,			//Point 12
					23,	0,	0,			//Point 13
					19,	0,	0,			//Point 14
					16,	0,	0,			//Point 15
					13,	0,	0,			//Point 16
					9,	0,	0,			//Point 17
					6,	0,	0,			//Point 18
					3,	0,	0			//Point 19
					);	
		
		tMesh.getFaces().addAll(
				0,0,	19,0,	1,0,
				1,0,	19,0,	18,0,
				18,0,	2,0,	1,0,
				2,0,	18,0,	17,0,
				17,0,	3,0,	2,0,
				3,0,	17,0,	16,0,
				16,0,	4,0,	3,0,
				4,0,	16,0,	15,0,
				15,0,	5,0,	4,0,
				5,0,	15,0,	14,0,
				14,0,	6,0,	5,0,
				6,0,	14,0,	13,0,
				13,0,	7,0,	6,0,
				7,0,	13,0,	12,0,
				12,0,	8,0,	7,0,
				8,0,	12,0,	11,0,
				11,0,	9,0,	8,0,
				11,0,	10,0,	9,0
		);
		return tMesh;
	}
	
	private TriangleMesh createDownLip()
	{
		TriangleMesh tMesh = new TriangleMesh();
		tMesh.getTexCoords().addAll(0,0);
		
		tMesh.getPoints().addAll(
				//  x   y   z	
					0,	0,	0,			//Point 0
					3,	2, 0,			//Point 1
					6,	4,	0,			//Point 2
					9,	5,	0,			//Point 3
					13,	5,	0,			//Point 4
					16,	3,	0,			//Point 5
					19,	5,	0,			//Point 6
					23,	5,	0,			//Point 7
					26,	4,	0,			//Point 8
					29,	2,	0,			//Point 9
					32,	0,	0,			//Point 10
					29,	0,	0,			//Point 11
					26,	0,	0,			//Point 12
					23,	0,	0,			//Point 13
					19,	0,	0,			//Point 14
					16,	0,	0,			//Point 15
					13,	0,	0,			//Point 16
					9,	0,	0,			//Point 17
					6,	0,	0,			//Point 18
					3,	0,	0			//Point 19
					);	
		
		tMesh.getFaces().addAll(
				0,0,	1,0,	19,0,
				1,0,	2,0,	18,0,
				18,0,	19,0,	1,0,
				2,0,	3,0,	17,0,
				17,0,	18,0,	2,0,
				3,0,	4,0,	16,0,
				16,0,	17,0,	3,0,
				4,0,	5,0,	15,0,
				15,0,	16,0,	4,0,
				5,0,	6,0,	14,0,
				14,0,	15,0,	5,0,
				6,0,	7,0,	13,0,
				13,0,	14,0,	6,0,
				7,0,	8,0,	12,0,
				12,0,	13,0,	7,0,
				8,0,	9,0,	11,0,
				11,0,	12,0,	8,0,
				9,0,	10,0,	11,0
		);
		return tMesh;
	}
}
