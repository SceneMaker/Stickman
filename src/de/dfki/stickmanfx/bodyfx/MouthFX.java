package de.dfki.stickmanfx.bodyfx;

import de.dfki.stickmanfx.StickmanFX;
import de.dfki.stickmanfx.animationlogic.AnimatorFX;
import java.awt.Dimension;
import java.awt.Point;
import java.net.URL;

import com.interactivemesh.jfx.importer.col.ColModelImporter;

import javafx.application.Platform;
import javafx.scene.paint.Color;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MeshView;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.QuadCurveTo;
import javafx.scene.transform.Rotate;

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
	Path mPath;

	URL url;
	ColModelImporter imorter;
	MeshView mouthMeshView;

	public MouthFX.SHAPE mShape = MouthFX.SHAPE.DEFAULT;

	public MouthFX(HeadFX head) {
		mHeadFX = head;
		mLength = 20;
		mSize = new Dimension(mLength * 2, 5);

		mYRotation = mHeadFX.mYRotation;

		mColor = Color.rgb(mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.FEMALE ? 64 : 32, 0, 0,
				(128 * 100 / 255) / 100f);
		mPath = new Path();
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
	public void createShape() {
		mStart = mHeadFX.getMouthPostion();
		
		imorter = new ColModelImporter();

		double movement;

		clearChildren(this);

		mPath = new Path();

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
			
			url = getClass().getClassLoader().getResource("BodyParts/Mouth/defaultMouth.dae");
			imorter.read(url);
			mouthMeshView = (MeshView) imorter.getImport()[0];
			
			mouthMeshView.setTranslateX(mStart.x);
			mouthMeshView.setTranslateY(mStart.y);
			
			if (!mHeadFX.mHead.getChildren().get(6).equals(mouthMeshView)) {
				mHeadFX.mHead.getChildren().set(6, mouthMeshView);
			}

			break;

		case SMILE:
			url = getClass().getClassLoader().getResource("BodyParts/Mouth/smileMouth.dae");
			imorter.read(url);
			mouthMeshView = (MeshView) imorter.getImport()[0];
			
			mouthMeshView.setTranslateX(mStart.x);
			mouthMeshView.setTranslateY(mStart.y);
			
			if (!mHeadFX.mHead.getChildren().get(6).equals(mouthMeshView)) {
				mHeadFX.mHead.getChildren().set(6, mouthMeshView);
			}
			break;

		case SAD:
			url = getClass().getClassLoader().getResource("BodyParts/Mouth/sadMouth.dae");
			imorter.read(url);
			mouthMeshView = (MeshView) imorter.getImport()[0];
			
			mouthMeshView.setTranslateX(mStart.x);
			mouthMeshView.setTranslateY(mStart.y+5);
			
			if (!mHeadFX.mHead.getChildren().get(6).equals(mouthMeshView)) {
				mHeadFX.mHead.getChildren().set(6, mouthMeshView);
			}
			break;
		case ANGRY:
			url = getClass().getClassLoader().getResource("BodyParts/Mouth/angryMouth.dae");
			imorter.read(url);
			mouthMeshView = (MeshView) imorter.getImport()[0];
			
			mouthMeshView.setTranslateX(mStart.x);
			mouthMeshView.setTranslateY(mStart.y+5);
			
			if (!mHeadFX.mHead.getChildren().get(6).equals(mouthMeshView)) {
				mHeadFX.mHead.getChildren().set(6, mouthMeshView);
			}
			break;

		case ANGRYSMALLMOUTH:
			url = getClass().getClassLoader().getResource("BodyParts/Mouth/angrySmallMouth.dae");
			imorter.read(url);
			mouthMeshView = (MeshView) imorter.getImport()[0];
			
			mouthMeshView.setTranslateX(mStart.x);
			mouthMeshView.setTranslateY(mStart.y+5);
			
			if (!mHeadFX.mHead.getChildren().get(6).equals(mouthMeshView)) {
				mHeadFX.mHead.getChildren().set(6, mouthMeshView);
			}
			break;

		case SURPRISED:
			url = getClass().getClassLoader().getResource("BodyParts/Mouth/surprisedMouth.dae");
			imorter.read(url);
			mouthMeshView = (MeshView) imorter.getImport()[0];
			
			mouthMeshView.setTranslateX(mStart.x);
			mouthMeshView.setTranslateY(mStart.y+5);
			
			if (!mHeadFX.mHead.getChildren().get(6).equals(mouthMeshView)) {
				mHeadFX.mHead.getChildren().set(6, mouthMeshView);
			}
			break;
		case HAPPY:
			url = getClass().getClassLoader().getResource("BodyParts/Mouth/happyMouth.dae");
			imorter.read(url);
			mouthMeshView = (MeshView) imorter.getImport()[0];
			
			mouthMeshView.setTranslateX(mStart.x);
			mouthMeshView.setTranslateY(mStart.y);
			
			if (!mHeadFX.mHead.getChildren().get(6).equals(mouthMeshView)) {
				mHeadFX.mHead.getChildren().set(6, mouthMeshView);
			}
			break;

		case HAPPYEND:
			movement = mShapeAnimationStep - 1;
			if (movement <= 1) {
				mPath.getElements().add(new MoveTo(mStart.x - mLength / 2, mStart.y));
				mPath.getElements().add(new QuadCurveTo(mStart.x, mStart.y + 1, mEnd.x, mEnd.y));
			} else {
				mPath.getElements().add(new MoveTo(mStart.x - mLength / 2 - movement / 2, mStart.y - movement / 4));
				mPath.getElements().add(new QuadCurveTo(mStart.x, mStart.y + 1 + movement, mEnd.x + movement / 2,
						mStart.y - movement / 4));
				mPath.getElements().add(new LineTo(mStart.x - mLength / 2 - movement / 2, mStart.y - movement / 4));
			}
			break;

		case DISGUSTED:
			movement = mLength / 2 + (AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) / 2;

			mPath.getElements().add(new MoveTo(mStart.x - movement, mStart.y));
			mPath.getElements().add(new QuadCurveTo(mStart.x - movement * 2 / 3, mStart.y - movement / 4,
					mStart.x - movement / 3, mStart.y));
			mPath.getElements()
					.add(new QuadCurveTo(mStart.x, mStart.y + movement / 4, mStart.x + movement / 3, mStart.y));
			mPath.getElements().add(
					new QuadCurveTo(mStart.x + movement * 2 / 3, mStart.y - movement / 4, mStart.x + movement, mEnd.y));
			break;

		case DISGUSTEDEND:
			movement = mLength / 2 + mShapeAnimationStep / 2;

			if (mShapeAnimationStep - 1 <= 1) {
				mPath.getElements().add(new MoveTo(mStart.x - mLength / 2, mStart.y));
				mPath.getElements().add(new QuadCurveTo(mStart.x, mStart.y + 1, mEnd.x, mEnd.y));
			} else {
				mPath.getElements().add(new MoveTo(mStart.x - movement, mStart.y));
				mPath.getElements().add(new QuadCurveTo(mStart.x - movement * 2 / 3, mStart.y - movement / 4,
						mStart.x - movement / 3, mStart.y));
				mPath.getElements()
						.add(new QuadCurveTo(mStart.x, mStart.y + movement / 4, mStart.x + movement / 3, mStart.y));
				mPath.getElements().add(new QuadCurveTo(mStart.x + movement * 2 / 3, mStart.y - movement / 4,
						mStart.x + movement, mEnd.y));
			}
			break;

		case CONTEMPT:
			movement = AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep;

			mPath.getElements().add(new MoveTo(mStart.x - mLength / 2, mStart.y));
			mPath.getElements().add(
					new QuadCurveTo(mStart.x, mStart.y - movement / 1.5, mEnd.x + movement / 2, mEnd.y - movement / 2));
			break;

		case CONTEMPTEND:
			movement = mShapeAnimationStep - 1;

			if (movement <= 1) {
				mPath.getElements().add(new MoveTo(mStart.x - mLength / 2, mStart.y));
				mPath.getElements().add(new QuadCurveTo(mStart.x, mStart.y + 1, mEnd.x, mEnd.y));
			} else {
				mPath.getElements().add(new MoveTo(mStart.x - mLength / 2, mStart.y));
				mPath.getElements().add(new QuadCurveTo(mStart.x, mStart.y - movement / 1.5, mEnd.x + movement / 2,
						mEnd.y - movement / 2));
			}
			break;

		case FEAR:
			movement = AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep;

			mPath.getElements().add(new MoveTo(mStart.x - mLength / 2 - movement / 4, mStart.y));
			mPath.getElements().add(new QuadCurveTo(mStart.x, mStart.y - movement / 2, mEnd.x + movement / 4, mEnd.y));
			mPath.getElements()
					.add(new QuadCurveTo(mStart.x, mStart.y - 1, mStart.x - mLength / 2 - movement / 4, mStart.y));
			break;

		case FEAREND:
			movement = mShapeAnimationStep - 1;

			if (movement <= 1) {
				mPath.getElements().add(new MoveTo(mStart.x - mLength / 2, mStart.y));
				mPath.getElements().add(new QuadCurveTo(mStart.x, mStart.y + 1, mEnd.x, mEnd.y));
			} else {
				mPath.getElements().add(new MoveTo(mStart.x - mLength / 2 - movement / 4, mStart.y));
				mPath.getElements()
						.add(new QuadCurveTo(mStart.x, mStart.y - movement / 2, mEnd.x + movement / 4, mEnd.y));
				mPath.getElements()
						.add(new QuadCurveTo(mStart.x, mStart.y - 1, mStart.x - mLength / 2 - movement / 4, mStart.y));
			}
			break;

		case EXCITED:
			movement = AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep;

			mPath.getElements().add(new MoveTo(mStart.x - mLength / 2 - movement / 3 * 2, mStart.y - movement / 2));
			mPath.getElements().add(
					new QuadCurveTo(mStart.x, mStart.y + movement, mEnd.x + movement / 3 * 2, mStart.y - movement / 2));
			mPath.getElements().add(new LineTo(mStart.x - mLength / 2 - movement / 3 * 2, mStart.y - movement / 2));
			break;

		case EXCITEDEND:
			movement = mShapeAnimationStep - 1;

			if (movement <= 1) {
				mPath.getElements().add(new MoveTo(mStart.x - mLength / 2, mStart.y));
				mPath.getElements().add(new QuadCurveTo(mStart.x, mStart.y + 1, mEnd.x, mEnd.y));
			} else {
				mPath.getElements().add(new MoveTo(mStart.x - mLength / 2 - movement / 3 * 2, mStart.y - movement / 2));
				mPath.getElements().add(new QuadCurveTo(mStart.x, mStart.y + movement, mEnd.x + movement / 3 * 2,
						mStart.y - movement / 2));
				mPath.getElements().add(new LineTo(mStart.x - mLength / 2 - movement / 3 * 2, mStart.y - movement / 2));
			}
			break;

		case EMBARRASSED:
			movement = (AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep);

			mPath.getElements().add(new MoveTo(mStart.x - mLength / 2 + movement / 10 * 7, mStart.y + movement / 20));
			mPath.getElements().add(new QuadCurveTo((mStart.x - mLength / 2 + mEnd.x + movement / 10 * 3) / 2,
					mStart.y + 1, mEnd.x + movement / 10 * 3, mEnd.y + movement / 20));
			break;

		case EMBARRASSEDEND:
			movement = mShapeAnimationStep - 1;

			if (movement <= 1) {
				mPath.getElements().add(new MoveTo(mStart.x - mLength / 2, mStart.y));
				mPath.getElements().add(new QuadCurveTo(mStart.x, mStart.y + 1, mEnd.x, mEnd.y));
			} else {
				mPath.getElements()
						.add(new MoveTo(mStart.x - mLength / 2 + movement / 10 * 7, mStart.y + movement / 20));
				mPath.getElements().add(new QuadCurveTo((mStart.x - mLength / 2 + mEnd.x + movement / 10 * 3) / 2,
						mStart.y + 1, mEnd.x + movement / 10 * 3, mEnd.y + movement / 20));
			}
			break;
		case O:
			mPath.getElements().add(new MoveTo(mStart.x - mLength / 2, mStart.y));
			mPath.getElements().add(new QuadCurveTo(mStart.x, mStart.y - mLength / 2, mEnd.x, mStart.y));
			mPath.getElements()
					.add(new QuadCurveTo(mStart.x, mStart.y + mLength / 2, mStart.x - mLength / 2, mStart.y));
			break;

		case ONE:
		case SIX:
		case FOURTEEN:
		case NINETEEN:
			mPath.getElements().add(new MoveTo(mStart.x - mLength / 2, mStart.y));
			mPath.getElements().add(new QuadCurveTo(mStart.x, mStart.y - mLength / 5, mEnd.x, mStart.y));
			mPath.getElements()
					.add(new QuadCurveTo(mStart.x, mStart.y + mLength / 5, mStart.x - mLength / 2, mStart.y));
			break;

		case TWO:
			mPath.getElements().add(new MoveTo(mStart.x - mLength / 2.8, mStart.y));
			mPath.getElements()
					.add(new QuadCurveTo(mStart.x, mStart.y - mLength / 1.6, mEnd.x - mLength / 6, mStart.y));
			mPath.getElements()
					.add(new QuadCurveTo(mStart.x, mStart.y + mLength / 1.6, mStart.x - mLength / 2.8, mStart.y));
			break;

		case THREE:
		case TWENTY:
			mPath.getElements().add(new MoveTo(mStart.x - mLength / 2.8, mStart.y));
			mPath.getElements()
					.add(new QuadCurveTo(mStart.x, mStart.y - mLength / 2.5, mEnd.x - mLength / 6, mStart.y));
			mPath.getElements()
					.add(new QuadCurveTo(mStart.x, mStart.y + mLength / 2.5, mStart.x - mLength / 2.8, mStart.y));
			break;

		case FOUR:
			mPath.getElements().add(new MoveTo(mStart.x - mLength / 2, mStart.y));
			mPath.getElements().add(new QuadCurveTo(mStart.x, mStart.y - 3, mEnd.x, mStart.y));
			mPath.getElements()
					.add(new QuadCurveTo(mStart.x, mStart.y + mLength / 2, mStart.x - mLength / 2, mStart.y));
			break;

		case FIVE:
		case EIGHT:
			mPath.getElements().add(new MoveTo(mStart.x - mLength / 2.8, mStart.y));
			mPath.getElements().add(new QuadCurveTo(mStart.x, mStart.y - mLength / 2, mEnd.x - mLength / 6, mStart.y));
			mPath.getElements()
					.add(new QuadCurveTo(mStart.x, mStart.y + mLength / 2, mStart.x - mLength / 2.8, mStart.y));
			break;

		case SEVEN:
			mPath.getElements().add(new MoveTo(mStart.x - mLength / 3, mStart.y));
			mPath.getElements().add(new QuadCurveTo(mStart.x, mStart.y - 3, mEnd.x - mLength / 5, mStart.y));
			mPath.getElements().add(new QuadCurveTo(mStart.x, mStart.y + 3, mStart.x - mLength / 3, mStart.y));
			break;

		case NINE:
			mPath.getElements().add(new MoveTo(mStart.x - mLength / 3, mStart.y));
			mPath.getElements()
					.add(new QuadCurveTo(mStart.x, mStart.y - mLength / 2.8, mEnd.x - mLength / 5, mStart.y));
			mPath.getElements()
					.add(new QuadCurveTo(mStart.x, mStart.y + mLength / 1.6, mStart.x - mLength / 3, mStart.y));
			break;

		case TEN:
			mPath.getElements().add(new MoveTo(mStart.x - mLength / 2.8, mStart.y));
			mPath.getElements()
					.add(new QuadCurveTo(mStart.x, mStart.y - mLength / 2.8, mEnd.x - mLength / 6, mStart.y));
			mPath.getElements()
					.add(new QuadCurveTo(mStart.x, mStart.y + mLength / 2, mStart.x - mLength / 2.8, mStart.y));
			break;

		}
		// getChildren().add(mouthMeshView);
		// addToDrawObjects(mPath);
		// this.update();
	}

	protected void recordColor() {
		if (mHeadFX.mStickmanFX.setCharacterInvisible == false)
			mColorRecorder = mColor;
	}
}
