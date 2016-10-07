package de.dfki.stickmanfx.bodyfx;

import de.dfki.stickmanfx.animationlogic.AnimatorFX;
import java.awt.Dimension;
import java.awt.Point;
import java.net.URL;

import com.interactivemesh.jfx.importer.col.ColModelImporter;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.DrawMode;
import javafx.scene.shape.MeshView;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.QuadCurveTo;
import javafx.scene.shape.TriangleMesh;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

/**
 *
 * @author Beka Aptsiauri
 *
 */
public class RightEyebrowFX extends BodyPartFX {
	public static enum SHAPE {
		DEFAULT, ANGRY, HAPPY, HAPPYEND, ANGRYEND, DISGUSTED, DISGUSTEDEND, SURPRISED, SURPRISEDEND, EXCITED, EXCITEDEND, EMBARRASSED, EMBARRASSEDEND
	};

	HeadFX mHeadFX;
	
	TriangleMesh currentMesh;
	MeshView browMesh;

	URL url;
	ColModelImporter imorter;
	MeshView defaultRightBrow;
	MeshView angryRightBrow;
	MeshView disgustedRightBrow;
	MeshView surprisedRightBrow;
	MeshView embarrassedRightBrow;
	MeshView happyRightBrow;

	public RightEyebrowFX.SHAPE mShape = RightEyebrowFX.SHAPE.DEFAULT;

	public RightEyebrowFX(HeadFX head) {
		mHeadFX = head;
		mSize = new Dimension(mLength, 5);
		
		imorter = new ColModelImporter();

		mColor = Color.rgb(0, 0, 0, (64 * 100 / 255) / 100f);
		
		url = getClass().getClassLoader().getResource("BodyParts/RightBrow/defaultRightBrow.dae");
		imorter.read(url);
		defaultRightBrow = (MeshView) imorter.getImport()[0];
		
		url = getClass().getClassLoader().getResource("BodyParts/RightBrow/angryRightBrow1.dae");
		imorter.read(url);
		angryRightBrow = (MeshView) imorter.getImport()[0];
		
		url = getClass().getClassLoader().getResource("BodyParts/RightBrow/disgustedRightBrow.dae");
		imorter.read(url);
		disgustedRightBrow = (MeshView) imorter.getImport()[0];
		
		url = getClass().getClassLoader().getResource("BodyParts/RightBrow/surprisedRightBrow.dae");
		imorter.read(url);
		surprisedRightBrow = (MeshView) imorter.getImport()[0];
		
		url = getClass().getClassLoader().getResource("BodyParts/RightBrow/embarrassedRightBrow.dae");
		imorter.read(url);
		embarrassedRightBrow = (MeshView) imorter.getImport()[0];
		
		url = getClass().getClassLoader().getResource("BodyParts/RightBrow/happyRightBrow.dae");
		imorter.read(url);
		happyRightBrow = (MeshView) imorter.getImport()[0];
		
		init();
	}

	@Override
	public void setShape(String s) {
		RightEyebrowFX.SHAPE shape = RightEyebrowFX.SHAPE.valueOf(s);
		mShape = (shape != null) ? shape : RightEyebrowFX.SHAPE.DEFAULT;
	}

	@Override
	public void resetShape() {
		mShape = RightEyebrowFX.SHAPE.DEFAULT;
	}

	@Override
	public void createShape() {
		mStart = mHeadFX.getRightEyebrowPostion();
		
		float xmovement_1;
		float xmovement_2;
		float xmovement_3;
		float xmovement_4;
		
		float ymovement_1;
		float ymovement_2;
		float ymovement_3;
		float ymovement_4;
		
		PhongMaterial mat;

		clearChildren(this);

		switch (mShape) {
		case DEFAULT:
			if (mHeadFX.mStickmanFX.setCharacterInvisible == true) {
				if (mHeadFX.mStickmanFX.fadeControler == true) // Added by
																// Robbie
				{
					int fadeFactor = (int) (mHeadFX.mStickmanFX.mMouthFX.mShapeAnimationStep * 3.2);
					if (fadeFactor <= 6) {
						fadeFactor = 0;
					}
					mColor = Color.rgb(0, 0, 0, (fadeFactor * 100 / 255) / 100f);
				} else {
					int fadeFactor = (int) ((20 - mHeadFX.mStickmanFX.mMouthFX.mShapeAnimationStep) * 3.2);

					if (fadeFactor >= 54) {
						mColor = mColorRecorder;
					} else
						mColor = Color.rgb(0, 0, 0, (fadeFactor * 100 / 255) / 100f);
				}
			}

			currentMesh = new TriangleMesh();
			currentMesh.getTexCoords().addAll(0,0);
			
			currentMesh.getPoints().addAll(
				//  x   y   z	
					0,	0,	0,			//Point 0
					0,	-3,	0,			//Point 1
					0,	-3,	3,			//Point 2
					0,	0,	3,			//Point 3 ------->11
				//  x    y  z
					-6,	-5,	0,			//Point 4
					-6,	-8,	0,			//Point 5
					-6,	-8,	3,			//Point 6
					-6,	-5, 3,			//Point 7 -------->23
				 //  x    y   z
					-20, -7,  0,		//Point 8
					-20, -11, 0,		//Point 9
					-20, -11, 3,		//Point 10
					-20, -7,  3,		//Point 11 -------->35
				 //  x    y  z  	 
					-30,  0, 0,			//Point 12
					-30, -3, 0,			//Point 13
					-30, -3, 3,			//Point 14
					-30,  0, 3			//Point 15
					);
			
			currentMesh.getFaces().addAll(
					0,0,	3,0,	2,0,
					2,0,	1,0,	0,0,
					
					0,0,	1,0,	5,0,
					5,0,	4,0,	0,0,
					
					0,0,	4,0,	7,0,
					7,0,	3,0,	0,0,
					
					3,0,	2,0,	6,0,
					6,0,	7,0,	3,0,
					
					2,0,	1,0,	5,0,
					5,0,	6,0,	2,0,
					
					1,0,	5,0,	4,0,
					4,0,	0,0,	1,0,
					
					7,0,	4,0,	8,0,
					8,0,	11,0,	7,0,
					
					7,0,	6,0,	10,0,
					10,0,	11,0,	7,0,
					
					6,0,	5,0,	9,0,
					9,0,	10,0,	6,0,
					
					4,0,	5,0,	9,0,
					9,0,	8,0,	4,0,
					
					11,0,	8,0,	12,0,
					12,0,	15,0,	11,0,
					
					11,0,	10,0,	14,0,
					14,0,	15,0,	11,0,
					
					10,0,	9,0,	13,0,
					13,0,	14,0,	10,0,
					
					8,0,	9,0,	13,0,
					13,0,	12,0,	8,0
					);
			break;

		case ANGRY:
			xmovement_2 = -(AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0421f;
			ymovement_1 = (AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0158f;
			ymovement_3 = (AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0105f;
			
			//Block 1
			currentMesh.getPoints().set(1, currentMesh.getPoints().get(1) + ymovement_1);
			currentMesh.getPoints().set(4, currentMesh.getPoints().get(4) + ymovement_1);
			currentMesh.getPoints().set(7, currentMesh.getPoints().get(7) + ymovement_1);
			currentMesh.getPoints().set(10, currentMesh.getPoints().get(10) + ymovement_1);
			//Block 2
			currentMesh.getPoints().set(12, currentMesh.getPoints().get(12) + xmovement_2);
			currentMesh.getPoints().set(15, currentMesh.getPoints().get(15) + xmovement_2);
			currentMesh.getPoints().set(18, currentMesh.getPoints().get(18) + xmovement_2);
			currentMesh.getPoints().set(21, currentMesh.getPoints().get(21) + xmovement_2);
			//Block 3
			currentMesh.getPoints().set(25, currentMesh.getPoints().get(25) + ymovement_3);
			currentMesh.getPoints().set(28, currentMesh.getPoints().get(28) + ymovement_3);
			currentMesh.getPoints().set(31, currentMesh.getPoints().get(31) + ymovement_3);
			currentMesh.getPoints().set(34, currentMesh.getPoints().get(34) + ymovement_3);
			break;
		case ANGRYEND:
			xmovement_2 = (AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0421f;
			ymovement_1 = -(AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0158f;
			ymovement_3 = -(AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0105f;
			
			//Block 1
			currentMesh.getPoints().set(1, currentMesh.getPoints().get(1) + ymovement_1);
			currentMesh.getPoints().set(4, currentMesh.getPoints().get(4) + ymovement_1);
			currentMesh.getPoints().set(7, currentMesh.getPoints().get(7) + ymovement_1);
			currentMesh.getPoints().set(10, currentMesh.getPoints().get(10) + ymovement_1);
			//Block 2
			currentMesh.getPoints().set(12, currentMesh.getPoints().get(12) + xmovement_2);
			currentMesh.getPoints().set(15, currentMesh.getPoints().get(15) + xmovement_2);
			currentMesh.getPoints().set(18, currentMesh.getPoints().get(18) + xmovement_2);
			currentMesh.getPoints().set(21, currentMesh.getPoints().get(21) + xmovement_2);
			//Block 3
			currentMesh.getPoints().set(25, currentMesh.getPoints().get(25) + ymovement_3);
			currentMesh.getPoints().set(28, currentMesh.getPoints().get(28) + ymovement_3);
			currentMesh.getPoints().set(31, currentMesh.getPoints().get(31) + ymovement_3);
			currentMesh.getPoints().set(34, currentMesh.getPoints().get(34) + ymovement_3);
			break;
		case DISGUSTED:
			ymovement_1 = (AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0368f;
			xmovement_1 = -(AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0210f;
			ymovement_2 = (AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0105f;
			ymovement_3 = (AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0210f;
			ymovement_4 = (AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0210f;
			xmovement_4 = -(AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0158f;
			
			//Block 1
			currentMesh.getPoints().set(1, currentMesh.getPoints().get(1) - ymovement_1);
			currentMesh.getPoints().set(4, currentMesh.getPoints().get(4) - ymovement_1);
			currentMesh.getPoints().set(7, currentMesh.getPoints().get(7) - ymovement_1);
			currentMesh.getPoints().set(10, currentMesh.getPoints().get(10) - ymovement_1);
			//Block 1
			currentMesh.getPoints().set(0, currentMesh.getPoints().get(0) + xmovement_1);
			currentMesh.getPoints().set(3, currentMesh.getPoints().get(3) + xmovement_1);
			currentMesh.getPoints().set(6, currentMesh.getPoints().get(6) + xmovement_1);
			currentMesh.getPoints().set(9, currentMesh.getPoints().get(9) + xmovement_1);
			//Block 2
			currentMesh.getPoints().set(13, currentMesh.getPoints().get(13) - ymovement_2);
			currentMesh.getPoints().set(16, currentMesh.getPoints().get(16) - ymovement_2);
			currentMesh.getPoints().set(19, currentMesh.getPoints().get(19) - ymovement_2);
			currentMesh.getPoints().set(22, currentMesh.getPoints().get(22) - ymovement_2);
			//Block 3
			currentMesh.getPoints().set(25, currentMesh.getPoints().get(25) + ymovement_3);
			currentMesh.getPoints().set(28, currentMesh.getPoints().get(28) + ymovement_3);
			currentMesh.getPoints().set(31, currentMesh.getPoints().get(31) + ymovement_3);
			currentMesh.getPoints().set(34, currentMesh.getPoints().get(34) + ymovement_3);
			//Block 4
			currentMesh.getPoints().set(37, currentMesh.getPoints().get(37) + ymovement_4);
			currentMesh.getPoints().set(40, currentMesh.getPoints().get(40) + ymovement_4);
			currentMesh.getPoints().set(43, currentMesh.getPoints().get(43) + ymovement_4);
			currentMesh.getPoints().set(46, currentMesh.getPoints().get(46) + ymovement_4);
			//Block 4
			currentMesh.getPoints().set(36, currentMesh.getPoints().get(36) - xmovement_4);
			currentMesh.getPoints().set(39, currentMesh.getPoints().get(39) - xmovement_4);
			currentMesh.getPoints().set(42, currentMesh.getPoints().get(42) - xmovement_4);
			currentMesh.getPoints().set(45, currentMesh.getPoints().get(45) - xmovement_4);
			break;
		case DISGUSTEDEND:
			ymovement_1 = -(AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0368f;
			xmovement_1 = (AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0210f;
			ymovement_2 = -(AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0105f;
			ymovement_3 = -(AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0210f;
			ymovement_4 = -(AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0210f;
			xmovement_4 = (AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0158f;
			
			//Block 1
			currentMesh.getPoints().set(1, currentMesh.getPoints().get(1) - ymovement_1);
			currentMesh.getPoints().set(4, currentMesh.getPoints().get(4) - ymovement_1);
			currentMesh.getPoints().set(7, currentMesh.getPoints().get(7) - ymovement_1);
			currentMesh.getPoints().set(10, currentMesh.getPoints().get(10) - ymovement_1);
			//Block 1
			currentMesh.getPoints().set(0, currentMesh.getPoints().get(0) + xmovement_1);
			currentMesh.getPoints().set(3, currentMesh.getPoints().get(3) + xmovement_1);
			currentMesh.getPoints().set(6, currentMesh.getPoints().get(6) + xmovement_1);
			currentMesh.getPoints().set(9, currentMesh.getPoints().get(9) + xmovement_1);
			//Block 2
			currentMesh.getPoints().set(13, currentMesh.getPoints().get(13) - ymovement_2);
			currentMesh.getPoints().set(16, currentMesh.getPoints().get(16) - ymovement_2);
			currentMesh.getPoints().set(19, currentMesh.getPoints().get(19) - ymovement_2);
			currentMesh.getPoints().set(22, currentMesh.getPoints().get(22) - ymovement_2);
			//Block 3
			currentMesh.getPoints().set(25, currentMesh.getPoints().get(25) + ymovement_3);
			currentMesh.getPoints().set(28, currentMesh.getPoints().get(28) + ymovement_3);
			currentMesh.getPoints().set(31, currentMesh.getPoints().get(31) + ymovement_3);
			currentMesh.getPoints().set(34, currentMesh.getPoints().get(34) + ymovement_3);
			//Block 4
			currentMesh.getPoints().set(37, currentMesh.getPoints().get(37) + ymovement_4);
			currentMesh.getPoints().set(40, currentMesh.getPoints().get(40) + ymovement_4);
			currentMesh.getPoints().set(43, currentMesh.getPoints().get(43) + ymovement_4);
			currentMesh.getPoints().set(46, currentMesh.getPoints().get(46) + ymovement_4);
			//Block 4
			currentMesh.getPoints().set(36, currentMesh.getPoints().get(36) - xmovement_4);
			currentMesh.getPoints().set(39, currentMesh.getPoints().get(39) - xmovement_4);
			currentMesh.getPoints().set(42, currentMesh.getPoints().get(42) - xmovement_4);
			currentMesh.getPoints().set(45, currentMesh.getPoints().get(45) - xmovement_4);
			break;
		case SURPRISED:
			ymovement_1 = (AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0158f;
			xmovement_2 = -(AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0105f;
			ymovement_2 = (AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0210f;
			xmovement_3 = -(AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0105f;
			xmovement_4 = -(AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0105f;
			
			//Block 1
			currentMesh.getPoints().set(1, currentMesh.getPoints().get(1) - ymovement_1);
			currentMesh.getPoints().set(4, currentMesh.getPoints().get(4) - ymovement_1);
			currentMesh.getPoints().set(7, currentMesh.getPoints().get(7) - ymovement_1);
			currentMesh.getPoints().set(10, currentMesh.getPoints().get(10) - ymovement_1);
			
			//Block 2
			currentMesh.getPoints().set(13, currentMesh.getPoints().get(13) - ymovement_2);
			currentMesh.getPoints().set(16, currentMesh.getPoints().get(16) - ymovement_2);
			currentMesh.getPoints().set(19, currentMesh.getPoints().get(19) - ymovement_2);
			currentMesh.getPoints().set(22, currentMesh.getPoints().get(22) - ymovement_2);
			
			//Block 2
			currentMesh.getPoints().set(12, currentMesh.getPoints().get(12) + xmovement_2);
			currentMesh.getPoints().set(15, currentMesh.getPoints().get(15) + xmovement_2);
			currentMesh.getPoints().set(18, currentMesh.getPoints().get(18) + xmovement_2);
			currentMesh.getPoints().set(21, currentMesh.getPoints().get(21) + xmovement_2);
			
			//Block 3
			currentMesh.getPoints().set(24, currentMesh.getPoints().get(24) - xmovement_3);
			currentMesh.getPoints().set(27, currentMesh.getPoints().get(27) - xmovement_3);
			currentMesh.getPoints().set(30, currentMesh.getPoints().get(30) - xmovement_3);
			currentMesh.getPoints().set(30, currentMesh.getPoints().get(30) - xmovement_3);
			
			//Block 4
			currentMesh.getPoints().set(36, currentMesh.getPoints().get(36) - xmovement_4);
			currentMesh.getPoints().set(39, currentMesh.getPoints().get(39) - xmovement_4);
			currentMesh.getPoints().set(42, currentMesh.getPoints().get(42) - xmovement_4);
			currentMesh.getPoints().set(45, currentMesh.getPoints().get(45) - xmovement_4);
			break;
		case SURPRISEDEND:
			ymovement_1 = -(AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0158f;
			xmovement_2 = (AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0105f;
			ymovement_2 = -(AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0210f;
			xmovement_3 = (AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0105f;
			xmovement_4 = (AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0105f;
			
			//Block 1
			currentMesh.getPoints().set(1, currentMesh.getPoints().get(1) - ymovement_1);
			currentMesh.getPoints().set(4, currentMesh.getPoints().get(4) - ymovement_1);
			currentMesh.getPoints().set(7, currentMesh.getPoints().get(7) - ymovement_1);
			currentMesh.getPoints().set(10, currentMesh.getPoints().get(10) - ymovement_1);
			
			//Block 2
			currentMesh.getPoints().set(13, currentMesh.getPoints().get(13) - ymovement_2);
			currentMesh.getPoints().set(16, currentMesh.getPoints().get(16) - ymovement_2);
			currentMesh.getPoints().set(19, currentMesh.getPoints().get(19) - ymovement_2);
			currentMesh.getPoints().set(22, currentMesh.getPoints().get(22) - ymovement_2);
			
			//Block 2
			currentMesh.getPoints().set(12, currentMesh.getPoints().get(12) + xmovement_2);
			currentMesh.getPoints().set(15, currentMesh.getPoints().get(15) + xmovement_2);
			currentMesh.getPoints().set(18, currentMesh.getPoints().get(18) + xmovement_2);
			currentMesh.getPoints().set(21, currentMesh.getPoints().get(21) + xmovement_2);
			
			//Block 3
			currentMesh.getPoints().set(24, currentMesh.getPoints().get(24) - xmovement_3);
			currentMesh.getPoints().set(27, currentMesh.getPoints().get(27) - xmovement_3);
			currentMesh.getPoints().set(30, currentMesh.getPoints().get(30) - xmovement_3);
			currentMesh.getPoints().set(30, currentMesh.getPoints().get(30) - xmovement_3);
			
			//Block 4
			currentMesh.getPoints().set(36, currentMesh.getPoints().get(36) - xmovement_4);
			currentMesh.getPoints().set(39, currentMesh.getPoints().get(39) - xmovement_4);
			currentMesh.getPoints().set(42, currentMesh.getPoints().get(42) - xmovement_4);
			currentMesh.getPoints().set(45, currentMesh.getPoints().get(45) - xmovement_4);
			break;
		case EMBARRASSED:
			ymovement_1 = (AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0526f;
			xmovement_1 = -(AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0105f;
			ymovement_2 = (AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.00526f;
			ymovement_3 = (AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0210f;
			ymovement_4 = (AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0315f;
			
			//Block 1
			currentMesh.getPoints().set(1, currentMesh.getPoints().get(1) - ymovement_1);
			currentMesh.getPoints().set(4, currentMesh.getPoints().get(4) - ymovement_1);
			currentMesh.getPoints().set(7, currentMesh.getPoints().get(7) - ymovement_1);
			currentMesh.getPoints().set(10, currentMesh.getPoints().get(10) - ymovement_1);
			
			//Block 1
			currentMesh.getPoints().set(0, currentMesh.getPoints().get(0) + xmovement_1);
			currentMesh.getPoints().set(3, currentMesh.getPoints().get(3) + xmovement_1);
			currentMesh.getPoints().set(6, currentMesh.getPoints().get(6) + xmovement_1);
			currentMesh.getPoints().set(9, currentMesh.getPoints().get(9) + xmovement_1);
			
			//Block 2
			currentMesh.getPoints().set(13, currentMesh.getPoints().get(13) - ymovement_2);
			currentMesh.getPoints().set(16, currentMesh.getPoints().get(16) - ymovement_2);
			currentMesh.getPoints().set(19, currentMesh.getPoints().get(19) - ymovement_2);
			currentMesh.getPoints().set(22, currentMesh.getPoints().get(22) - ymovement_2);
			
			//Block 3
			currentMesh.getPoints().set(25, currentMesh.getPoints().get(25) + ymovement_3);
			currentMesh.getPoints().set(28, currentMesh.getPoints().get(28) + ymovement_3);
			currentMesh.getPoints().set(31, currentMesh.getPoints().get(31) + ymovement_3);
			currentMesh.getPoints().set(34, currentMesh.getPoints().get(34) + ymovement_3);
			
			//Block 4
			currentMesh.getPoints().set(37, currentMesh.getPoints().get(37) - ymovement_4);
			currentMesh.getPoints().set(40, currentMesh.getPoints().get(40) - ymovement_4);
			currentMesh.getPoints().set(43, currentMesh.getPoints().get(43) - ymovement_4);
			currentMesh.getPoints().set(46, currentMesh.getPoints().get(46) - ymovement_4);
			break;
		case EMBARRASSEDEND:
			ymovement_1 = -(AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0526f;
			xmovement_1 = (AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0105f;
			ymovement_2 = -(AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.00526f;
			ymovement_3 = -(AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0210f;
			ymovement_4 = -(AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0315f;
			
			//Block 1
			currentMesh.getPoints().set(1, currentMesh.getPoints().get(1) - ymovement_1);
			currentMesh.getPoints().set(4, currentMesh.getPoints().get(4) - ymovement_1);
			currentMesh.getPoints().set(7, currentMesh.getPoints().get(7) - ymovement_1);
			currentMesh.getPoints().set(10, currentMesh.getPoints().get(10) - ymovement_1);
			
			//Block 1
			currentMesh.getPoints().set(0, currentMesh.getPoints().get(0) + xmovement_1);
			currentMesh.getPoints().set(3, currentMesh.getPoints().get(3) + xmovement_1);
			currentMesh.getPoints().set(6, currentMesh.getPoints().get(6) + xmovement_1);
			currentMesh.getPoints().set(9, currentMesh.getPoints().get(9) + xmovement_1);
			
			//Block 2
			currentMesh.getPoints().set(13, currentMesh.getPoints().get(13) - ymovement_2);
			currentMesh.getPoints().set(16, currentMesh.getPoints().get(16) - ymovement_2);
			currentMesh.getPoints().set(19, currentMesh.getPoints().get(19) - ymovement_2);
			currentMesh.getPoints().set(22, currentMesh.getPoints().get(22) - ymovement_2);
			
			//Block 3
			currentMesh.getPoints().set(25, currentMesh.getPoints().get(25) + ymovement_3);
			currentMesh.getPoints().set(28, currentMesh.getPoints().get(28) + ymovement_3);
			currentMesh.getPoints().set(31, currentMesh.getPoints().get(31) + ymovement_3);
			currentMesh.getPoints().set(34, currentMesh.getPoints().get(34) + ymovement_3);
			
			//Block 4
			currentMesh.getPoints().set(37, currentMesh.getPoints().get(37) - ymovement_4);
			currentMesh.getPoints().set(40, currentMesh.getPoints().get(40) - ymovement_4);
			currentMesh.getPoints().set(43, currentMesh.getPoints().get(43) - ymovement_4);
			currentMesh.getPoints().set(46, currentMesh.getPoints().get(46) - ymovement_4);
			break;
		case HAPPY:
			ymovement_1 = (AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0158f;
			xmovement_1 = -(AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0105f;
			xmovement_2 = -(AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0210f;
			ymovement_2 = (AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0210f;
			xmovement_3 = -(AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0105f;
			xmovement_4 = -(AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0210f;
			
			//Block 1
			currentMesh.getPoints().set(1, currentMesh.getPoints().get(1) - ymovement_1);
			currentMesh.getPoints().set(4, currentMesh.getPoints().get(4) - ymovement_1);
			currentMesh.getPoints().set(7, currentMesh.getPoints().get(7) - ymovement_1);
			currentMesh.getPoints().set(10, currentMesh.getPoints().get(10) - ymovement_1);
			
			//Block 1
			currentMesh.getPoints().set(0, currentMesh.getPoints().get(0) + xmovement_1);
			currentMesh.getPoints().set(3, currentMesh.getPoints().get(3) + xmovement_1);
			currentMesh.getPoints().set(6, currentMesh.getPoints().get(6) + xmovement_1);
			currentMesh.getPoints().set(9, currentMesh.getPoints().get(9) + xmovement_1);
			
			//Block 2
			currentMesh.getPoints().set(13, currentMesh.getPoints().get(13) - ymovement_2);
			currentMesh.getPoints().set(16, currentMesh.getPoints().get(16) - ymovement_2);
			currentMesh.getPoints().set(19, currentMesh.getPoints().get(19) - ymovement_2);
			currentMesh.getPoints().set(22, currentMesh.getPoints().get(22) - ymovement_2);
			
			//Block 2
			currentMesh.getPoints().set(12, currentMesh.getPoints().get(12) + xmovement_2);
			currentMesh.getPoints().set(15, currentMesh.getPoints().get(15) + xmovement_2);
			currentMesh.getPoints().set(18, currentMesh.getPoints().get(18) + xmovement_2);
			currentMesh.getPoints().set(21, currentMesh.getPoints().get(21) + xmovement_2);
			
			//Block 3
			currentMesh.getPoints().set(24, currentMesh.getPoints().get(24) - xmovement_3);
			currentMesh.getPoints().set(27, currentMesh.getPoints().get(27) - xmovement_3);
			currentMesh.getPoints().set(30, currentMesh.getPoints().get(30) - xmovement_3);
			currentMesh.getPoints().set(30, currentMesh.getPoints().get(30) - xmovement_3);
			
			//Block 4
			currentMesh.getPoints().set(36, currentMesh.getPoints().get(36) - xmovement_4);
			currentMesh.getPoints().set(39, currentMesh.getPoints().get(39) - xmovement_4);
			currentMesh.getPoints().set(42, currentMesh.getPoints().get(42) - xmovement_4);
			currentMesh.getPoints().set(45, currentMesh.getPoints().get(45) - xmovement_4);
			break;
			
		case HAPPYEND:
			ymovement_1 = -(AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0158f;
			xmovement_1 = (AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0105f;
			xmovement_2 = (AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0210f;
			ymovement_2 = -(AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0210f;
			xmovement_3 = (AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0105f;
			xmovement_4 = (AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0210f;
			
			//Block 1
			currentMesh.getPoints().set(1, currentMesh.getPoints().get(1) - ymovement_1);
			currentMesh.getPoints().set(4, currentMesh.getPoints().get(4) - ymovement_1);
			currentMesh.getPoints().set(7, currentMesh.getPoints().get(7) - ymovement_1);
			currentMesh.getPoints().set(10, currentMesh.getPoints().get(10) - ymovement_1);
			
			//Block 1
			currentMesh.getPoints().set(0, currentMesh.getPoints().get(0) + xmovement_1);
			currentMesh.getPoints().set(3, currentMesh.getPoints().get(3) + xmovement_1);
			currentMesh.getPoints().set(6, currentMesh.getPoints().get(6) + xmovement_1);
			currentMesh.getPoints().set(9, currentMesh.getPoints().get(9) + xmovement_1);
			
			//Block 2
			currentMesh.getPoints().set(13, currentMesh.getPoints().get(13) - ymovement_2);
			currentMesh.getPoints().set(16, currentMesh.getPoints().get(16) - ymovement_2);
			currentMesh.getPoints().set(19, currentMesh.getPoints().get(19) - ymovement_2);
			currentMesh.getPoints().set(22, currentMesh.getPoints().get(22) - ymovement_2);
			
			//Block 2
			currentMesh.getPoints().set(12, currentMesh.getPoints().get(12) + xmovement_2);
			currentMesh.getPoints().set(15, currentMesh.getPoints().get(15) + xmovement_2);
			currentMesh.getPoints().set(18, currentMesh.getPoints().get(18) + xmovement_2);
			currentMesh.getPoints().set(21, currentMesh.getPoints().get(21) + xmovement_2);
			
			//Block 3
			currentMesh.getPoints().set(24, currentMesh.getPoints().get(24) - xmovement_3);
			currentMesh.getPoints().set(27, currentMesh.getPoints().get(27) - xmovement_3);
			currentMesh.getPoints().set(30, currentMesh.getPoints().get(30) - xmovement_3);
			currentMesh.getPoints().set(30, currentMesh.getPoints().get(30) - xmovement_3);
			
			//Block 4
			currentMesh.getPoints().set(36, currentMesh.getPoints().get(36) - xmovement_4);
			currentMesh.getPoints().set(39, currentMesh.getPoints().get(39) - xmovement_4);
			currentMesh.getPoints().set(42, currentMesh.getPoints().get(42) - xmovement_4);
			currentMesh.getPoints().set(45, currentMesh.getPoints().get(45) - xmovement_4);
			break;

		}
		
		browMesh = new MeshView(currentMesh);
		browMesh.setDrawMode(DrawMode.FILL);
	    mat = new PhongMaterial();
	    mat.setDiffuseColor(Color.BLACK);
		browMesh.setMaterial(mat);
		
		browMesh.setTranslateX(mStart.x - 9);
		browMesh.setTranslateY(mStart.y - 23);
		browMesh.setTranslateZ(-17);
		
		if (!mHeadFX.mHead.getChildren().get(3).equals(browMesh)) {
			mHeadFX.mHead.getChildren().set(3, browMesh);
		}
	}

	protected void recordColor() {
		if (mHeadFX.mStickmanFX.setCharacterInvisible == false)
			mColorRecorder = mColor;
	}
}
