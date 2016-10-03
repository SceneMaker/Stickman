package de.dfki.stickmanfx.bodyfx;

import java.awt.Point;
import java.net.URL;
import java.util.ArrayList;

import com.interactivemesh.jfx.importer.col.ColModelImporter;
import com.interactivemesh.jfx.importer.stl.StlMeshImporter;

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
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.Mesh;
import javafx.scene.shape.MeshView;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.QuadCurveTo;
import javafx.scene.shape.Shape;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

/**
 *
 * @author Beka Aptsiauri
 *
 */
public class LeftEyeFX extends BodyPartFX {


	public static enum SHAPE {
		DEFAULT, BLINK, LOOKLEFT, LOOKRIGHT, ANGRY, ANGRYEND, SURPRISED, SURPRISEDEND, HAPPY, HAPPYEND, DISGUSTED, DISGUSTEDEND, LOVED, LOVEDEND, LOVED1, CONTEMPT, CONTEMPTEND, EXCITED, EXCITEDEND, EMBARRASSED, EMBARRASSEDEND
	};

	HeadFX mHeadFX;

	URL url;
	ColModelImporter imorter;
	MeshView defaultLeftEye;
	MeshView blink;
	MeshView lookLeft;
	MeshView lookRight;
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
	public void createShape() {
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
			
			defaultLeftEye.setTranslateX(mStart.x);
			defaultLeftEye.setTranslateY(mStart.y);

			if (!mHeadFX.mHead.getChildren().get(4).equals(defaultLeftEye)) {
				mHeadFX.mHead.getChildren().set(4, defaultLeftEye);
			}

			break;

		case BLINK:
			break;

		case LOOKLEFT:
			break;

		case LOOKRIGHT:
			break;

		case ANGRY:
			break;

		case SURPRISED:
			break;

		case HAPPY:
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

	}

	protected void recordColor() {
		if (mHeadFX.mStickmanFX.setCharacterInvisible == false)
			mColorRecorder = mColor;
	}

}
