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
	MeshView defaultMouth;
	Group angryMouth;
	Group disgustedMouth;
	Group embarrassedMouth;
	Group happyMouth;
	Group oMouth;
	Group sadMouth;
	Group smileMouth;
	Group surprisedMouth;

	public MouthFX.SHAPE mShape = MouthFX.SHAPE.DEFAULT;

	public MouthFX(HeadFX head) {
		mHeadFX = head;
		mSize = new Dimension(mLength * 2, 5);

		mColor = Color.rgb(mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.FEMALE ? 64 : 32, 0, 0,
				(128 * 100 / 255) / 100f);
		
		imorter = new ColModelImporter();
		
		url = getClass().getClassLoader().getResource("BodyParts/Mouth/defaultMouth.dae");
		imorter.read(url);
		this.defaultMouth = (MeshView) imorter.getImport()[0];
		
		url = getClass().getClassLoader().getResource("BodyParts/Mouth/smileMouth1.dae");
		imorter.read(url);
		this.smileMouth = (Group) imorter.getImport()[0];
		
		url = getClass().getClassLoader().getResource("BodyParts/Mouth/sadMouth1.dae");
		imorter.read(url);
		this.sadMouth = (Group) imorter.getImport()[0];
		
		url = getClass().getClassLoader().getResource("BodyParts/Mouth/angryMouth1.dae");
		imorter.read(url);
		this.angryMouth = (Group) imorter.getImport()[0];

		url = getClass().getClassLoader().getResource("BodyParts/Mouth/surprisedMouth1.dae");
		imorter.read(url);
		this.surprisedMouth = (Group) imorter.getImport()[0];
		
		url = getClass().getClassLoader().getResource("BodyParts/Mouth/happyMouth1.dae");
		imorter.read(url);
		this.happyMouth = (Group) imorter.getImport()[0];
		
		url = getClass().getClassLoader().getResource("BodyParts/Mouth/disgustedMouth1.dae");
		imorter.read(url);
		this.disgustedMouth = (Group) imorter.getImport()[0];
		
		url = getClass().getClassLoader().getResource("BodyParts/Mouth/embarrassedMouth1.dae");
		imorter.read(url);
		this.embarrassedMouth = (Group) imorter.getImport()[0];
		
		url = getClass().getClassLoader().getResource("BodyParts/Mouth/oMouth1.dae");
		imorter.read(url);
		this.oMouth = (Group) imorter.getImport()[0];
		
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

			this.defaultMouth.setTranslateX(mStart.x);
			this.defaultMouth.setTranslateY(mStart.y);

			if (!mHeadFX.mHead.getChildren().get(6).equals(defaultMouth)) {
				mHeadFX.mHead.getChildren().set(6, defaultMouth);
			}
			break;

		case SMILE:
			System.out.println("Beka");
			this.smileMouth.setTranslateX(mStart.x);
			this.smileMouth.setTranslateY(mStart.y);

			if (!mHeadFX.mHead.getChildren().get(6).equals(smileMouth)) {
				mHeadFX.mHead.getChildren().set(6, smileMouth);
			}
			break;

		case SAD:

			this.sadMouth.setTranslateX(mStart.x);
			this.sadMouth.setTranslateY(mStart.y);

			if (!mHeadFX.mHead.getChildren().get(6).equals(sadMouth)) {
				mHeadFX.mHead.getChildren().set(6, sadMouth);
			}
			break;
		case ANGRY:

			this.angryMouth.setTranslateX(mStart.x);
			this.angryMouth.setTranslateY(mStart.y + 5);

			if (!mHeadFX.mHead.getChildren().get(6).equals(angryMouth)) {
				mHeadFX.mHead.getChildren().set(6, angryMouth);
			}
			break;

		case ANGRYSMALLMOUTH:
			break;

		case SURPRISED:

			this.surprisedMouth.setTranslateX(mStart.x);
			this.surprisedMouth.setTranslateY(mStart.y);

			if (!mHeadFX.mHead.getChildren().get(6).equals(surprisedMouth)) {
				mHeadFX.mHead.getChildren().set(6, surprisedMouth);
			}
			break;
		case HAPPY:
			
			this.happyMouth.setTranslateX(mStart.x);
			this.happyMouth.setTranslateY(mStart.y + 5);

			if (!mHeadFX.mHead.getChildren().get(6).equals(happyMouth)) {
				mHeadFX.mHead.getChildren().set(6, happyMouth);
			}
			break;

		case DISGUSTED:

			this.disgustedMouth.setTranslateX(mStart.x);
			this.disgustedMouth.setTranslateY(mStart.y);

			if (!mHeadFX.mHead.getChildren().get(6).equals(disgustedMouth)) {
				mHeadFX.mHead.getChildren().set(6, disgustedMouth);
			}
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

			this.embarrassedMouth.setTranslateX(mStart.x);
			this.embarrassedMouth.setTranslateY(mStart.y + 5);

			if (!mHeadFX.mHead.getChildren().get(6).equals(embarrassedMouth)) {
				mHeadFX.mHead.getChildren().set(6, embarrassedMouth);
			}
			break;
		case O:

			this.oMouth.setTranslateX(mStart.x);
			this.oMouth.setTranslateY(mStart.y);

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
