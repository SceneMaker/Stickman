package de.dfki.stickmanfx.bodyfx;

import java.awt.Point;
import java.net.URL;
import java.util.ArrayList;

import com.interactivemesh.jfx.importer.col.ColModelImporter;
import com.interactivemesh.jfx.importer.stl.StlMeshImporter;
import com.sun.scenario.effect.ColorAdjust;

import static de.dfki.stickman.animationlogic.util.Interpolator.linear;
import de.dfki.stickmanfx.StickmanFX;
import de.dfki.stickmanfx.animationlogic.AnimatorFX;
import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.scene.DepthTest;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Circle;
import javafx.scene.shape.DrawMode;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.Mesh;
import javafx.scene.shape.MeshView;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.QuadCurveTo;
import javafx.scene.shape.Shape;
import javafx.scene.shape.TriangleMesh;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

/**
 *
 * @author Beka Aptsiauri
 *
 */
public class LeftEyeFX extends BodyPartFX {


	public static enum SHAPE {
		DEFAULT, BLINK, BLINKEND, LOOKLEFT, LOOKRIGHT, ANGRY, ANGRYEND, SURPRISED, SURPRISEDEND, HAPPY, HAPPYEND, DISGUSTED, DISGUSTEDEND, LOVED, LOVEDEND, LOVED1, CONTEMPT, CONTEMPTEND, EXCITED, EXCITEDEND, EMBARRASSED, EMBARRASSEDEND
	};

	HeadFX mHeadFX;
	
	TriangleMesh currentEyeTriangleMesh;
	TriangleMesh currentPupileTriangleMesh;
	MeshView eyeMesh;
	MeshView pupileMesh;
	
	URL url;
	ColModelImporter imorter;
	MeshView defaultLeftEye;
	MeshView blink;
	Group lookLeft;
	Group lookRight;
	MeshView angry;
	MeshView surprised;
	MeshView happy;
	MeshView disgusted;
	MeshView loved;
	MeshView contempt;
	MeshView excited;
	MeshView embarrassed;

	int mZTranslate = -120;

	public LeftEyeFX.SHAPE mShape = LeftEyeFX.SHAPE.DEFAULT;

	public LeftEyeFX(HeadFX head) {
		mHeadFX = head;
		
		imorter = new ColModelImporter();

		mColor = Color.rgb(mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.FEMALE ? 22 : 0,
				mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.FEMALE ? 40 : 0,
				mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.FEMALE ? 65 : 0, (144 * 100 / 255) / 100f);
		
		url = getClass().getClassLoader().getResource("BodyParts/LeftEye/defaultLeftEye.dae");
		imorter.read(url);
		defaultLeftEye = (MeshView) imorter.getImport()[0];
		
		url = getClass().getClassLoader().getResource("BodyParts/LeftEye/blink.dae");
		imorter.read(url);
		blink = (MeshView) imorter.getImport()[0];
		
		url = getClass().getClassLoader().getResource("BodyParts/LeftEye/lookLeft1.dae");
		imorter.read(url);
		lookLeft = (Group) imorter.getImport()[0];
		
		url = getClass().getClassLoader().getResource("BodyParts/LeftEye/lookRight.dae");
		imorter.read(url);
		lookRight = (Group) imorter.getImport()[0];
		
		url = getClass().getClassLoader().getResource("BodyParts/LeftEye/angry.dae");
		imorter.read(url);
		angry = (MeshView) imorter.getImport()[0];
		
		url = getClass().getClassLoader().getResource("BodyParts/LeftEye/surprised.dae");
		imorter.read(url);
		surprised = (MeshView) imorter.getImport()[0];
		
		url = getClass().getClassLoader().getResource("BodyParts/LeftEye/happy.dae");
		imorter.read(url);
		happy = (MeshView) imorter.getImport()[0];
		
		init();
	}

	@Override
	public void setShape(String s) {
		SHAPE shape = SHAPE.valueOf(s);
		mShape = (shape != null) ? shape : SHAPE.DEFAULT;
	}

	@Override
	public void resetShape() {
		mShape = LeftEyeFX.SHAPE.DEFAULT;
	}

	@Override
	public void calculate(int step) {
		mStart = mHeadFX.getLeftEyePostion();

		clearChildren(this);

		switch (mShape) {
		case DEFAULT:
			if (mHeadFX.mStickmanFX.setCharacterInvisible == true) {
				if (mHeadFX.mStickmanFX.fadeControler == true) // Added by
																// Robbie
				{
					int fadeFactor = mHeadFX.mStickmanFX.mMouthFX.mShapeAnimationStep * 7;
					if (fadeFactor <= 14) {
						fadeFactor = 0;
					}
					mColor = Color.rgb(mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.FEMALE ? 22 : 0,
							mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.FEMALE ? 40 : 0,
							mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.FEMALE ? 65 : 0,
							(fadeFactor * 100 / 255) / 100f);
				} else {
					int fadeFactor = (20 - mHeadFX.mStickmanFX.mMouthFX.mShapeAnimationStep) * 7;

					if (fadeFactor >= 118) {
						mColor = mColorRecorder;
					} else
						mColor = Color.rgb(mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.FEMALE ? 22 : 0,
								mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.FEMALE ? 40 : 0,
								mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.FEMALE ? 65 : 0,
								(fadeFactor * 100 / 255) / 100f);
				}
			}
			
			currentEyeTriangleMesh = createEye();
			currentPupileTriangleMesh = createPupile();
			break;

		case BLINK:
			float yMovement_10 = (AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0158f;
			float yMovement_9 = (AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0368f;
			float yMovement_8 = (AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0368f;
			float yMovement_7 = (AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0158f;
			float yMovement_2 = (AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0158f;
			float yMovement_3 = (AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0368f;
			float yMovement_4 = (AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0368f;
			float yMovement_5 = (AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0158f;
			
			currentEyeTriangleMesh.getPoints().set(31, currentEyeTriangleMesh.getPoints().get(31) + yMovement_10);
			currentEyeTriangleMesh.getPoints().set(28, currentEyeTriangleMesh.getPoints().get(28) + yMovement_9);
			currentEyeTriangleMesh.getPoints().set(25, currentEyeTriangleMesh.getPoints().get(25) + yMovement_8);
			currentEyeTriangleMesh.getPoints().set(22, currentEyeTriangleMesh.getPoints().get(22) + yMovement_7);
			
			currentEyeTriangleMesh.getPoints().set(7, currentEyeTriangleMesh.getPoints().get(7) - yMovement_2);
			currentEyeTriangleMesh.getPoints().set(10, currentEyeTriangleMesh.getPoints().get(10) - yMovement_3);
			currentEyeTriangleMesh.getPoints().set(13, currentEyeTriangleMesh.getPoints().get(13) - yMovement_4);
			currentEyeTriangleMesh.getPoints().set(16, currentEyeTriangleMesh.getPoints().get(16) - yMovement_5);
			break;
		case BLINKEND:
			float yEndMovement_10 = -(AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0158f;
			float yEndMovement_9 = -(AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0368f;
			float yEndMovement_8 = -(AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0368f;
			float yEndMovement_7 = -(AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0158f;
			float yEndMovement_2 = -(AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0158f;
			float yEndMovement_3 = -(AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0368f;
			float yEndMovement_4 = -(AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0368f;
			float yEndMovement_5 = -(AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0158f;
			
			currentEyeTriangleMesh.getPoints().set(31, currentEyeTriangleMesh.getPoints().get(31) + yEndMovement_10);
			currentEyeTriangleMesh.getPoints().set(28, currentEyeTriangleMesh.getPoints().get(28) + yEndMovement_9);
			currentEyeTriangleMesh.getPoints().set(25, currentEyeTriangleMesh.getPoints().get(25) + yEndMovement_8);
			currentEyeTriangleMesh.getPoints().set(22, currentEyeTriangleMesh.getPoints().get(22) + yEndMovement_7);
			
			currentEyeTriangleMesh.getPoints().set(7, currentEyeTriangleMesh.getPoints().get(7) - yEndMovement_2);
			currentEyeTriangleMesh.getPoints().set(10, currentEyeTriangleMesh.getPoints().get(10) - yEndMovement_3);
			currentEyeTriangleMesh.getPoints().set(13, currentEyeTriangleMesh.getPoints().get(13) - yEndMovement_4);
			currentEyeTriangleMesh.getPoints().set(16, currentEyeTriangleMesh.getPoints().get(16) - yEndMovement_5);
			break;
		case LOOKLEFT:
			lookLeft.setTranslateX(mStart.x);
			lookLeft.setTranslateY(mStart.y);

			if (!mHeadFX.mHead.getChildren().get(4).equals(lookLeft)) {
				mHeadFX.mHead.getChildren().set(4, lookLeft);
			}
			break;

		case LOOKRIGHT:
			lookRight.setTranslateX(mStart.x);
			lookRight.setTranslateY(mStart.y);

			if (!mHeadFX.mHead.getChildren().get(4).equals(lookRight)) {
				mHeadFX.mHead.getChildren().set(4, lookRight);
			}
			break;

		case ANGRY:
			angry.setTranslateX(mStart.x);
			angry.setTranslateY(mStart.y);

			if (!mHeadFX.mHead.getChildren().get(4).equals(angry)) {
				mHeadFX.mHead.getChildren().set(4, angry);
			}
			break;

		case SURPRISED:
			surprised.setTranslateX(mStart.x);
			surprised.setTranslateY(mStart.y);

			if (!mHeadFX.mHead.getChildren().get(4).equals(surprised)) {
				mHeadFX.mHead.getChildren().set(4, surprised);
			}
			break;

		case HAPPY:
			happy.setTranslateX(mStart.x);
			happy.setTranslateY(mStart.y);

			if (!mHeadFX.mHead.getChildren().get(4).equals(happy)) {
				mHeadFX.mHead.getChildren().set(4, happy);
			}
			break;

		case DISGUSTED:
			break;

		case LOVED:
			break;
//		case LOVED1:
//			movement = AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep;
//			xMovement = movement / 10 * 6;
//			yMovement1 = movement / 10 * 6;
//			yMovement2 = movement / 10 * 3;
//
//			showHearts(mHeadFX, xMovement, yMovement1, yMovement2);
//
//			mPath.getElements().add(new MoveTo(mStart.x, mStart.y));
//			mPath.getElements()
//					.add(new QuadCurveTo(mStart.x - xMovement, mEnd.y - yMovement2, mStart.x, mEnd.y + yMovement1));
//			mPath.getElements().add(new MoveTo(mStart.x, mStart.y));
//			mPath.getElements()
//					.add(new QuadCurveTo(mStart.x + xMovement, mEnd.y - yMovement2, mStart.x, mEnd.y + yMovement1));
//
//			break;

		case CONTEMPT:
			break;

		case CONTEMPTEND:
			break;

		case EXCITED:
			break;

		case EMBARRASSED:
			break;

		}
		
		eyeMesh = new MeshView(currentEyeTriangleMesh);
		eyeMesh.setDrawMode(DrawMode.FILL);
	    PhongMaterial mat = new PhongMaterial();
	    mat.setDiffuseColor(Color.BLACK);
		eyeMesh.setMaterial(mat);
		
		eyeMesh.setTranslateX(mStart.x + 22);
		eyeMesh.setTranslateY(mStart.y + 42);
		eyeMesh.setTranslateZ(-17);
		
		if (step == 0) 
			mHeadFX.mHead.getChildren().add(eyeMesh);
		else
			mHeadFX.mHead.getChildren().set(3, eyeMesh);
		
		//Pupile
		pupileMesh = new MeshView(currentPupileTriangleMesh);
		pupileMesh.setDrawMode(DrawMode.FILL);
		PhongMaterial pupileMat = new PhongMaterial();
		pupileMat.setDiffuseColor(Color.WHITE);
		pupileMesh.setMaterial(pupileMat);
		
		pupileMesh.setTranslateX(mStart.x + 22);
		pupileMesh.setTranslateY(mStart.y+43);
		pupileMesh.setTranslateZ(-18);
		
		if (step == 0) 
			mHeadFX.mHead.getChildren().add(pupileMesh);
		else
			mHeadFX.mHead.getChildren().set(4, pupileMesh);
		
	}

	protected void recordColor() {
		if (mHeadFX.mStickmanFX.setCharacterInvisible == false)
			mColorRecorder = mColor;
	}
	
	private TriangleMesh createPupile()
	{
		TriangleMesh tMesh = new TriangleMesh();
		tMesh.getTexCoords().addAll(0,0);
		
		tMesh.getPoints().addAll(
				0,	0,	0,		// Point 0
				-6,	0,	0,		// Point 1
				-4,	4,	0,		// Point 2
				-1,	5,	0,		// Point 3
				1,	5,	0,		// Point 4
				4,	4,	0,		// Point 5
				6,	0,	0,		// Point 6
				4,	-4,	0,		// Point 7
				1,	-5,	0,		// Point 8
				-1,	-5,	0,		// Point 9
				-4,	-4,	0		// Point 10
				);
		
		tMesh.getFaces().addAll(
				0,0,	1,0,	2,0,	//Sector 1
				2,0,	3,0,	0,0,	//Sector 2
				0,0,	3,0,	4,0,	//Sector 3
				4,0,	5,0,	0,0,	//Sector 4
				0,0,	5,0,	6,0,	//Sector 5
				6,0,	7,0,	0,0,	//Sector 6
				0,0,	7,0,	8,0,	//Sector 7
				8,0,	9,0,	0,0,	//Sector 8
				0,0,	9,0,	10,0,	//Sector 9
				10,0,	1,0,	0,0		//Sector 10
				);
		
		return tMesh;
	}
	
	private TriangleMesh createEye()
	{
		TriangleMesh tMesh = new TriangleMesh();
		tMesh.getTexCoords().addAll(0,0);
		
		tMesh.getPoints().addAll(
				0,	0,	0,		// Point 0
				-8,	0,	0,		// Point 1
				-6,	5,	0,		// Point 2
				-2,	8,	0,		// Point 3
				3,	8,	0,		// Point 4
				7,	5,	0,		// Point 5
				9,	0,	0,		// Point 6
				7,	-5,	0,		// Point 7
				3,	-8,	0,		// Point 8
				-2,	-8,	0,		// Point 9
				-6,	-5,	0		// Point 10
				);
		
		tMesh.getFaces().addAll(
				0,0,	1,0,	2,0,	//Sector 1
				2,0,	3,0,	0,0,	//Sector 2
				0,0,	3,0,	4,0,	//Sector 3
				4,0,	5,0,	0,0,	//Sector 4
				0,0,	5,0,	6,0,	//Sector 5
				6,0,	7,0,	0,0,	//Sector 6
				0,0,	7,0,	8,0,	//Sector 7
				8,0,	9,0,	0,0,	//Sector 8
				0,0,	9,0,	10,0,	//Sector 9
				10,0,	1,0,	0,0		//Sector 10
				);
		return tMesh;
	}

}
