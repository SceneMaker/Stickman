package de.dfki.stickmanfx.bodyfx;

import de.dfki.stickmanfx.StickmanFX;
import java.awt.Dimension;
import java.net.URL;

import com.interactivemesh.jfx.importer.col.ColModelImporter;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.MeshView;

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

	URL url;
	ColModelImporter imorter;
	MeshView mouthMesh;

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
	public void createShape() {
		mStart = mHeadFX.getMouthPostion();

		imorter = new ColModelImporter();

		clearChildren(this);

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
			mouthMesh = (MeshView) imorter.getImport()[0];

			mouthMesh.setTranslateX(mStart.x);
			mouthMesh.setTranslateY(mStart.y);

			if (!mHeadFX.mHead.getChildren().get(6).equals(mouthMesh)) {
				mHeadFX.mHead.getChildren().set(6, mouthMesh);
			}

			break;

		case SMILE:
			url = getClass().getClassLoader().getResource("BodyParts/Mouth/smileMouth1.dae");
			imorter.read(url);
			Group smileMouth = (Group) imorter.getImport()[0];

			smileMouth.setTranslateX(mStart.x);
			smileMouth.setTranslateY(mStart.y);

			if (!mHeadFX.mHead.getChildren().get(6).equals(smileMouth)) {
				mHeadFX.mHead.getChildren().set(6, smileMouth);
			}
			break;

		case SAD:
			url = getClass().getClassLoader().getResource("BodyParts/Mouth/sadMouth.dae");
			imorter.read(url);
			mouthMesh = (MeshView) imorter.getImport()[0];

			mouthMesh.setTranslateX(mStart.x);
			mouthMesh.setTranslateY(mStart.y + 5);

			if (!mHeadFX.mHead.getChildren().get(6).equals(mouthMesh)) {
				mHeadFX.mHead.getChildren().set(6, mouthMesh);
			}
			break;
		case ANGRY:
			url = getClass().getClassLoader().getResource("BodyParts/Mouth/angryMouth1.dae");
			imorter.read(url);
			Group angryMouth = (Group) imorter.getImport()[0];

			angryMouth.setTranslateX(mStart.x);
			angryMouth.setTranslateY(mStart.y + 5);

			if (!mHeadFX.mHead.getChildren().get(6).equals(angryMouth)) {
				mHeadFX.mHead.getChildren().set(6, angryMouth);
			}
			break;

		case ANGRYSMALLMOUTH:
			url = getClass().getClassLoader().getResource("BodyParts/Mouth/angrySmallMouth.dae");
			imorter.read(url);
			mouthMesh = (MeshView) imorter.getImport()[0];

			mouthMesh.setTranslateX(mStart.x);
			mouthMesh.setTranslateY(mStart.y + 5);

			if (!mHeadFX.mHead.getChildren().get(6).equals(mouthMesh)) {
				mHeadFX.mHead.getChildren().set(6, mouthMesh);
			}
			break;

		case SURPRISED:
			url = getClass().getClassLoader().getResource("BodyParts/Mouth/surprisedMouth.dae");
			imorter.read(url);
			mouthMesh = (MeshView) imorter.getImport()[0];

			mouthMesh.setTranslateX(mStart.x);
			mouthMesh.setTranslateY(mStart.y + 5);

			if (!mHeadFX.mHead.getChildren().get(6).equals(mouthMesh)) {
				mHeadFX.mHead.getChildren().set(6, mouthMesh);
			}
			break;
		case HAPPY:
			url = getClass().getClassLoader().getResource("BodyParts/Mouth/happyMouth1.dae");
			imorter.read(url);
			Group happyMouth = (Group) imorter.getImport()[0];
			happyMouth.setTranslateX(mStart.x);
			happyMouth.setTranslateY(mStart.y + 5);

			if (!mHeadFX.mHead.getChildren().get(6).equals(happyMouth)) {
				mHeadFX.mHead.getChildren().set(6, happyMouth);
			}
			break;

		case DISGUSTED:
			url = getClass().getClassLoader().getResource("BodyParts/Mouth/disgustedMouth1.dae");
			imorter.read(url);
			Group disgustedMouth = (Group) imorter.getImport()[0];

			disgustedMouth.setTranslateX(mStart.x);
			disgustedMouth.setTranslateY(mStart.y);

			if (!mHeadFX.mHead.getChildren().get(6).equals(disgustedMouth)) {
				mHeadFX.mHead.getChildren().set(6, disgustedMouth);
			}
			break;

		case CONTEMPT:
			break;

		case CONTEMPTEND:
			break;

		case FEAR:
			url = getClass().getClassLoader().getResource("BodyParts/Mouth/angryMouth.dae");
			imorter.read(url);
			mouthMesh = (MeshView) imorter.getImport()[0];

			mouthMesh.setTranslateX(mStart.x);
			mouthMesh.setTranslateY(mStart.y + 5);

			if (!mHeadFX.mHead.getChildren().get(6).equals(mouthMesh)) {
				mHeadFX.mHead.getChildren().set(6, mouthMesh);
			}
			break;

		case EXCITED:
			break;

		case EXCITEDEND:
			break;

		case EMBARRASSED:
			url = getClass().getClassLoader().getResource("BodyParts/Mouth/embarrassedMouth1.dae");
			imorter.read(url);
			Group embarrassedMouth = (Group) imorter.getImport()[0];

			embarrassedMouth.setTranslateX(mStart.x);
			embarrassedMouth.setTranslateY(mStart.y + 5);

			if (!mHeadFX.mHead.getChildren().get(6).equals(embarrassedMouth)) {
				mHeadFX.mHead.getChildren().set(6, embarrassedMouth);
			}
			break;
		case O:
			url = getClass().getClassLoader().getResource("BodyParts/Mouth/oMouth1.dae");
			imorter.read(url);
			Group oMouth = (Group) imorter.getImport()[0];

			oMouth.setTranslateX(mStart.x);
			oMouth.setTranslateY(mStart.y);

			if (!mHeadFX.mHead.getChildren().get(6).equals(oMouth)) {
				mHeadFX.mHead.getChildren().set(6, oMouth);
			}
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
	}

	protected void recordColor() {
		if (mHeadFX.mStickmanFX.setCharacterInvisible == false)
			mColorRecorder = mColor;
	}
}
