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
import javafx.scene.shape.MeshView;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.QuadCurveTo;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

/**
 *
 * @author Beka Aptsiauri
 *
 */
public class RightEyebrowFX extends BodyPartFX {
	public static enum SHAPE {
		DEFAULT, ANGRY, HAPPY, ANGRYEND, DISGUSTED, DISGUSTEDEND, SURPRISED, SURPRISEDEND, EXCITED, EXCITEDEND, EMBARRASSED, EMBARRASSEDEND
	};

	HeadFX mHeadFX;

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
		mEnd = new Point(mStart.x - mLength, mStart.y);

//		clearDrawObjects();
		clearChildren(this);

		switch (mShape) {
		case DEFAULT:
			// if (mHeadFX.mStickmanFX.setCharacterInvisible == false)
			// mColorRecorder = mColor;

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

			defaultRightBrow.setTranslateX(mStart.x);
			defaultRightBrow.setTranslateY(mStart.y);

			if (!mHeadFX.mHead.getChildren().get(3).equals(defaultRightBrow)) {
				mHeadFX.mHead.getChildren().set(3, defaultRightBrow);
			}
			
			break;

		case ANGRY:
			angryRightBrow.setTranslateX(mStart.x);
			angryRightBrow.setTranslateY(mStart.y);

			if (!mHeadFX.mHead.getChildren().get(3).equals(angryRightBrow)) {
				mHeadFX.mHead.getChildren().set(3, angryRightBrow);
			}
			break;

		case DISGUSTED:
			disgustedRightBrow.setTranslateX(mStart.x);
			disgustedRightBrow.setTranslateY(mStart.y);

			if (!mHeadFX.mHead.getChildren().get(3).equals(disgustedRightBrow)) {
				mHeadFX.mHead.getChildren().set(3, disgustedRightBrow);
			}
			break;

		case SURPRISED:
			surprisedRightBrow.setTranslateX(mStart.x);
			surprisedRightBrow.setTranslateY(mStart.y);

			if (!mHeadFX.mHead.getChildren().get(3).equals(surprisedRightBrow)) {
				mHeadFX.mHead.getChildren().set(3, surprisedRightBrow);
			}
			break;

		case EMBARRASSED:
			embarrassedRightBrow.setTranslateX(mStart.x);
			embarrassedRightBrow.setTranslateY(mStart.y);

			if (!mHeadFX.mHead.getChildren().get(3).equals(embarrassedRightBrow)) {
				mHeadFX.mHead.getChildren().set(3, embarrassedRightBrow);
			}
			break;
			
		case HAPPY:
			happyRightBrow.setTranslateX(mStart.x);
			happyRightBrow.setTranslateY(mStart.y);

			if (!mHeadFX.mHead.getChildren().get(3).equals(happyRightBrow)) {
				mHeadFX.mHead.getChildren().set(3, happyRightBrow);
			}
			break;

		}
	}

	protected void recordColor() {
		if (mHeadFX.mStickmanFX.setCharacterInvisible == false)
			mColorRecorder = mColor;
	}
}
