package de.dfki.stickman3D.body;

import java.awt.Dimension;

import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.mimic.util.LeftBrowEMBARRASSED;
import de.dfki.stickman3D.mimic.util.RightBrowANGRY;
import de.dfki.stickman3D.mimic.util.RightBrowDEFAULT;
import de.dfki.stickman3D.mimic.util.RightBrowDISGUSTED;
import de.dfki.stickman3D.mimic.util.RightBrowEXCITED;
import de.dfki.stickman3D.mimic.util.RightBrowHAPPY;
import de.dfki.stickman3D.mimic.util.RightBrowSAD;
import de.dfki.stickman3D.mimic.util.RightBrowSURPRISED;
import de.dfki.util.XMLParser;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

/**
 *
 * @author Beka Aptsiauri
 *
 */
public class RightEyebrow extends BodyPart {
	public static enum SHAPE {
		DEFAULT, FADEIN, FADEOUT, ANGRY, HAPPY, HAPPYEND, ANGRYEND, DISGUSTED, DISGUSTEDEND, SURPRISED, SURPRISEDEND, EXCITED, EXCITEDEND, EMBARRASSED, EMBARRASSEDEND, SAD, SADEND
	};

	Head mHeadFX;

	Polygon currentPolygon;

	public RightEyebrow.SHAPE mShape = RightEyebrow.SHAPE.DEFAULT;

	public RightEyebrow(Head head) {
		mHeadFX = head;
		mSize = new Dimension(mLength, 5);

		if (mHeadFX.mStickmanFX.mType == Stickman3D.TYPE.MALE)
			mColor = Color.rgb(88, 44, 13, 1);
		else
			mColor = Color.rgb(204, 163, 0, 1);
		activateConfigColor();

		currentPolygon = new Polygon();

		mStart = mHeadFX.getRightEyebrowPostion();

		init();

		mHeadFX.mHead.getChildren().add(currentPolygon);
	}

	@Override
	public void init() {
		super.init();
		currentPolygon.setTranslateX(mStart.x - 9);
		currentPolygon.setTranslateY(mStart.y + 38);
		currentPolygon.setTranslateZ(-17);
	}

	private void activateConfigColor() {
		String stickmanName = mHeadFX.mStickmanFX.mName;
		if (XMLParser.getColorMap(stickmanName) != null) {
			if (XMLParser.getColorMap(stickmanName).containsKey("BrowColor"))
				this.mColor = XMLParser.getColorMap(stickmanName).get("BrowColor");
		}
	}

	@Override
	public void setShape(String s) {
		RightEyebrow.SHAPE shape = RightEyebrow.SHAPE.valueOf(s);
		mShape = (shape != null) ? shape : RightEyebrow.SHAPE.DEFAULT;
	}

	@Override
	public void resetShape() {
		mShape = RightEyebrow.SHAPE.DEFAULT;
	}

	@Override
	public void calculate(int step) {

		switch (mShape) {
		case DEFAULT:
			if (mHeadFX.mStickmanFX.mType == Stickman3D.TYPE.MALE)
				currentPolygon = RightBrowDEFAULT.createMaleBrow(currentPolygon, step);
			else
				currentPolygon = RightBrowDEFAULT.createFemaleBrow(currentPolygon, step);
			currentPolygon.setFill(mColor);
			break;

		case FADEIN:
			if (step == 2)
				mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), 0.0);
			else if (mColor.getOpacity() != 0.0)
				mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), mColor.getOpacity() - 0.052);
			currentPolygon.setFill(mColor);
			break;

		case FADEOUT:
			if (step == 2)
				mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), 1.0);
			else if (mColor.getOpacity() != 1.0)
				mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), mColor.getOpacity() + 0.052);
			currentPolygon.setFill(mColor);
			break;

		case ANGRY:
			if(step == 20)
			{
				if (mHeadFX.mStickmanFX.mType == Stickman3D.TYPE.MALE)
					currentPolygon = RightBrowDEFAULT.createMaleBrow(currentPolygon, step);
				else
					currentPolygon = RightBrowDEFAULT.createFemaleBrow(currentPolygon, step);
			}
			currentPolygon = RightBrowANGRY.getANGRY(currentPolygon, step, "PLUS");
			break;

		case ANGRYEND:
			currentPolygon = RightBrowANGRY.getANGRY(currentPolygon, step, "MINUS");
			break;

		case DISGUSTED:
			if(step == 20)
			{
				if (mHeadFX.mStickmanFX.mType == Stickman3D.TYPE.MALE)
					currentPolygon = RightBrowDEFAULT.createMaleBrow(currentPolygon, step);
				else
					currentPolygon = RightBrowDEFAULT.createFemaleBrow(currentPolygon, step);
			}
			currentPolygon = RightBrowDISGUSTED.getANGRY(currentPolygon, step, "PLUS");
			break;

		case DISGUSTEDEND:
			currentPolygon = RightBrowDISGUSTED.getANGRY(currentPolygon, step, "MINUS");
			break;

		case SURPRISED:
			if(step == 20)
			{
				if (mHeadFX.mStickmanFX.mType == Stickman3D.TYPE.MALE)
					currentPolygon = RightBrowDEFAULT.createMaleBrow(currentPolygon, step);
				else
					currentPolygon = RightBrowDEFAULT.createFemaleBrow(currentPolygon, step);
			}
			currentPolygon = RightBrowSURPRISED.getANGRY(currentPolygon, step, "PLUS");
			break;

		case SURPRISEDEND:
			currentPolygon = RightBrowSURPRISED.getANGRY(currentPolygon, step, "MINUS");
			break;

		case EXCITED:
			if(step == 20)
			{
				if (mHeadFX.mStickmanFX.mType == Stickman3D.TYPE.MALE)
					currentPolygon = RightBrowDEFAULT.createMaleBrow(currentPolygon, step);
				else
					currentPolygon = RightBrowDEFAULT.createFemaleBrow(currentPolygon, step);
			}
			currentPolygon = RightBrowEXCITED.getANGRY(currentPolygon, step, "PLUS");
			break;

		case EXCITEDEND:
			currentPolygon = RightBrowEXCITED.getANGRY(currentPolygon, step, "MINUS");
			break;

		case EMBARRASSED:
			if(step == 20)
			{
				if (mHeadFX.mStickmanFX.mType == Stickman3D.TYPE.MALE)
					currentPolygon = RightBrowDEFAULT.createMaleBrow(currentPolygon, step);
				else
					currentPolygon = RightBrowDEFAULT.createFemaleBrow(currentPolygon, step);
			}
			if (mHeadFX.mStickmanFX.mType == Stickman3D.TYPE.MALE)
				currentPolygon = LeftBrowEMBARRASSED.getEMBARRASSED(currentPolygon, step, "PLUS", true);
			else
				currentPolygon = LeftBrowEMBARRASSED.getEMBARRASSED(currentPolygon, step, "PLUS", false);
			break;

		case EMBARRASSEDEND:
			if (mHeadFX.mStickmanFX.mType == Stickman3D.TYPE.MALE)
				currentPolygon = LeftBrowEMBARRASSED.getEMBARRASSED(currentPolygon, step, "minus", true);
			else
				currentPolygon = LeftBrowEMBARRASSED.getEMBARRASSED(currentPolygon, step, "minus", false);
			break;

		case HAPPY:
			if(step == 20)
			{
				if (mHeadFX.mStickmanFX.mType == Stickman3D.TYPE.MALE)
					currentPolygon = RightBrowDEFAULT.createMaleBrow(currentPolygon, step);
				else
					currentPolygon = RightBrowDEFAULT.createFemaleBrow(currentPolygon, step);
			}
			currentPolygon = RightBrowHAPPY.getANGRY(currentPolygon, step, "PLUS");
			break;

		case HAPPYEND:
			currentPolygon = RightBrowHAPPY.getANGRY(currentPolygon, step, "MINUS");
			break;

		case SAD:
			if(step == 20)
			{
				if (mHeadFX.mStickmanFX.mType == Stickman3D.TYPE.MALE)
					currentPolygon = RightBrowDEFAULT.createMaleBrow(currentPolygon, step);
				else
					currentPolygon = RightBrowDEFAULT.createFemaleBrow(currentPolygon, step);
			}
			currentPolygon = RightBrowSAD.getANGRY(currentPolygon, step, "PLUS");
			break;

		case SADEND:
			currentPolygon = RightBrowSAD.getANGRY(currentPolygon, step, "MINUS");
			break;

		}
	}

	@Override
	public void update() {
		currentPolygon.setFill(mColor);
	}

	@Override
	protected void recordColor() {
		if (mHeadFX.mStickmanFX.setCharacterInvisible == false)
			mColorRecorder = mColor;
	}
}
