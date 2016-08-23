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
		DEFAULT, ANGRY, ANGRYEND, DISGUSTED, DISGUSTEDEND, SURPRISED, SURPRISEDEND, EXCITED, EXCITEDEND, EMBARRASSED, EMBARRASSEDEND
	};

	HeadFX mHeadFX;
	Path mPath;

	URL url;
	ColModelImporter imorter;
	MeshView rightBrowMeshView;

	public RightEyebrowFX.SHAPE mShape = RightEyebrowFX.SHAPE.DEFAULT;

	public RightEyebrowFX(HeadFX head) {
		mHeadFX = head;
		mLength = 16;
		mSize = new Dimension(mLength, 5);

		url = getClass().getClassLoader().getResource("BodyParts/rightBrow.dae");
		imorter = new ColModelImporter();
		imorter.read(url);
		rightBrowMeshView = (MeshView) imorter.getImport()[0];

		mYRotation = mHeadFX.mYRotation;

		mColor = Color.rgb(0, 0, 0, (64 * 100 / 255) / 100f);
		mPath = new Path();
		this.getChildren().add(mPath);
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

		double movement;

		clearDrawObjects();
		clearChildren(this);

		mPath = new Path();

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

			rightBrowMeshView.setTranslateX(mStart.x);
			rightBrowMeshView.setTranslateY(mStart.y);
			rightBrowMeshView.setTranslateZ(-105);

			Rotate rx = new Rotate(mRotation, Rotate.X_AXIS);
			Rotate ry = new Rotate(mYRotation, Rotate.Y_AXIS);
			Rotate rz = new Rotate(mZRotation, Rotate.Z_AXIS);

			rightBrowMeshView.getTransforms().clear();
			rightBrowMeshView.getTransforms().addAll(rx, ry, rz);
			// mPath.getElements().add(new MoveTo(mStart.x, mStart.y));
			// mPath.getElements().add(new QuadCurveTo((mStart.x + mEnd.x) / 2,
			// mStart.y - 3, mEnd.x, mEnd.y));
			break;

		case ANGRY:
			movement = AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep;

			mPath.getElements().add(new MoveTo(mStart.x + movement / 4, mStart.y + movement / 4));
			mPath.getElements().add(new QuadCurveTo((mStart.x + movement / 4 + mEnd.x + movement / 3) / 2,
					mStart.y + movement / 4 - 3, mEnd.x + movement / 4, mEnd.y));
			break;

		case ANGRYEND:
			movement = mShapeAnimationStep - 1;

			if (movement <= 1) {
				mPath.getElements().add(new MoveTo(mStart.x, mStart.y));
				mPath.getElements().add(new QuadCurveTo((mStart.x + mEnd.x) / 2, mStart.y - 3, mEnd.x, mEnd.y));
			} else {
				mPath.getElements().add(new MoveTo(mStart.x + movement / 4, mStart.y + movement / 4));
				mPath.getElements().add(new QuadCurveTo((mStart.x + movement / 4 + mEnd.x + movement / 3) / 2,
						mStart.y + movement / 4 - 3, mEnd.x + movement / 4, mEnd.y));
			}

			break;

		case DISGUSTED:
			movement = AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep;
			mPath.getElements().add(new MoveTo(mStart.x, mStart.y - movement / 4));
			mPath.getElements().add(new QuadCurveTo((mStart.x + mEnd.x) / 2, mStart.y - 3 + movement / 7,
					mEnd.x + movement / 10, mEnd.y));
			break;

		case DISGUSTEDEND:
			movement = mShapeAnimationStep - 1;
			if (movement <= 1) {
				mPath.getElements().add(new MoveTo(mStart.x, mStart.y));
				mPath.getElements().add(new QuadCurveTo((mStart.x + mEnd.x) / 2, mStart.y - 3, mEnd.x, mEnd.y));
			} else {
				mPath.getElements().add(new MoveTo(mStart.x, mStart.y - movement / 4));
				mPath.getElements().add(new QuadCurveTo((mStart.x + mEnd.x) / 2, mStart.y - 3 + movement / 7,
						mEnd.x + movement / 10, mEnd.y));
			}
			break;

		case SURPRISED:
			movement = AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep;
			mPath.getElements().add(new MoveTo(mStart.x, mStart.y - movement / 7));
			mPath.getElements().add(new QuadCurveTo((mStart.x + mEnd.x) / 2, mStart.y - 3 - movement / 7, mEnd.x,
					mEnd.y - movement / 7));
			break;

		case SURPRISEDEND:
			movement = mShapeAnimationStep - 1;
			if (movement <= 1) {
				mPath.getElements().add(new MoveTo(mStart.x, mStart.y));
				mPath.getElements().add(new QuadCurveTo((mStart.x + mEnd.x) / 2, mStart.y - 3, mEnd.x, mEnd.y));
			} else {
				mPath.getElements().add(new MoveTo(mStart.x, mStart.y - movement / 7));
				mPath.getElements().add(new QuadCurveTo((mStart.x + mEnd.x) / 2, mStart.y - 3 - movement / 7, mEnd.x,
						mEnd.y - movement / 7));
			}
			break;

		case EXCITED:
			movement = AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep;
			mPath.getElements().add(new MoveTo(mStart.x, mStart.y - movement / 4));
			mPath.getElements().add(new QuadCurveTo((mStart.x + mEnd.x) / 2, mStart.y - 3 - movement / 5, mEnd.x,
					mEnd.y - movement / 4));
			break;

		case EXCITEDEND:
			movement = mShapeAnimationStep - 1;
			if (movement <= 1) {
				mPath.getElements().add(new MoveTo(mStart.x, mStart.y));
				mPath.getElements().add(new QuadCurveTo((mStart.x + mEnd.x) / 2, mStart.y - 3, mEnd.x, mEnd.y));
			} else {
				mPath.getElements().add(new MoveTo(mStart.x, mStart.y - movement / 4));
				mPath.getElements().add(new QuadCurveTo((mStart.x + mEnd.x) / 2, mStart.y - 3 - movement / 5, mEnd.x,
						mEnd.y - movement / 4));
			}
			break;

		case EMBARRASSED:
			movement = AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep;
			mPath.getElements().add(new MoveTo(mStart.x + movement / 2, mStart.y + movement / 3));
			mPath.getElements().add(new QuadCurveTo((mStart.x + movement / 2 + mEnd.x + movement / 2) / 2,
					mStart.y - 3 + movement / 10 * 7, mEnd.x + movement / 2, mEnd.y + movement / 2));
			break;

		case EMBARRASSEDEND:
			movement = mShapeAnimationStep - 1;
			if (movement <= 1) {
				mPath.getElements().add(new MoveTo(mStart.x, mStart.y));
				mPath.getElements().add(new QuadCurveTo((mStart.x + mEnd.x) / 2, mStart.y - 3, mEnd.x, mEnd.y));
			} else {
				mPath.getElements().add(new MoveTo(mStart.x + movement / 2, mStart.y + movement / 3));
				mPath.getElements().add(new QuadCurveTo((mStart.x + movement / 2 + mEnd.x + movement / 2) / 2,
						mStart.y - 3 + movement / 10 * 7, mEnd.x + movement / 2, mEnd.y + movement / 2));
			}
			break;
		}

		this.getChildren().add(rightBrowMeshView);
		// addToDrawObjects(mPath);
		// this.update();
	}

	protected void recordColor() {
		if (mHeadFX.mStickmanFX.setCharacterInvisible == false)
			mColorRecorder = mColor;
	}
}
