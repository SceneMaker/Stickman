package de.dfki.stickmanfx.bodyfx;

import java.awt.Dimension;

import de.dfki.stickmanfx.mimic.util.MouthANGRY;
import de.dfki.stickmanfx.mimic.util.MouthANGRYSMALLMOUTH;
import de.dfki.stickmanfx.mimic.util.MouthCONTEMPT;
import de.dfki.stickmanfx.mimic.util.MouthDEFAULT;
import de.dfki.stickmanfx.mimic.util.MouthDISGUSTED;
import de.dfki.stickmanfx.mimic.util.MouthEMBARRASSED;
import de.dfki.stickmanfx.mimic.util.MouthEXCITED;
import de.dfki.stickmanfx.mimic.util.MouthFEAR;
import de.dfki.stickmanfx.mimic.util.MouthFIVE;
import de.dfki.stickmanfx.mimic.util.MouthFOUR;
import de.dfki.stickmanfx.mimic.util.MouthHAPPY;
import de.dfki.stickmanfx.mimic.util.MouthO;
import de.dfki.stickmanfx.mimic.util.MouthONE;
import de.dfki.stickmanfx.mimic.util.MouthSAD;
import de.dfki.stickmanfx.mimic.util.MouthSEVEN;
import de.dfki.stickmanfx.mimic.util.MouthSMILE;
import de.dfki.stickmanfx.mimic.util.MouthSURPRISED;
import de.dfki.stickmanfx.mimic.util.MouthTREE;
import de.dfki.stickmanfx.mimic.util.MouthTWO;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
/**
 *
 * @author Beka Aptsiauri
 *
 */
public class MouthFX extends BodyPartFX {

	public static enum SHAPE {
		DEFAULT, FADEIN, FADEOUT, SMILE, SMILEEND, SAD, SADEND, ANGRY, ANGRYEND, ANGRYSMALLMOUTH, ANGRYSMALLMOUTHEND, SURPRISED, SURPRISEDEND, HAPPY, HAPPYEND, DISGUSTED, DISGUSTEDEND, CONTEMPT, CONTEMPTEND, EXCITED, EXCITEDEND, EMBARRASSED, EMBARRASSEDEND, FEAR, FEAREND, O, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, ELEVEN, TWELVE, THIRTEEN, FOURTEEN, NINETEEN, TWENTY,
	};

	HeadFX mHeadFX;
	
	Polygon currentDownLipPolygon;
	Polygon currentUpperLipPolygon;
	
	public MouthFX.SHAPE mShape = MouthFX.SHAPE.DEFAULT;

	public MouthFX(HeadFX head) {
		mHeadFX = head;
		mSize = new Dimension(mLength * 2, 5);

		mColor = Color.rgb(230, 174, 161, 1.0);
		
		currentUpperLipPolygon = new Polygon();
		currentDownLipPolygon = new Polygon();
		mStart = mHeadFX.getMouthPostion();
		
		init();
		
		mHeadFX.mHead.getChildren().addAll(currentUpperLipPolygon, currentDownLipPolygon);
	}

	@Override
	public void init()
	{
		super.init();
		currentUpperLipPolygon.setTranslateX(mStart.x-15);
		currentUpperLipPolygon.setTranslateY(mStart.y+95);
		currentUpperLipPolygon.setTranslateZ(-17);
		
		currentDownLipPolygon.setTranslateX(mStart.x-15);
		currentDownLipPolygon.setTranslateY(mStart.y+94);
		currentDownLipPolygon.setTranslateZ(-17);
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
		
		boolean isFadeIn = false;
		
		switch (mShape) {
		case DEFAULT:
			currentUpperLipPolygon = MouthDEFAULT.modifyUpperLip(currentUpperLipPolygon, step);
			currentDownLipPolygon = MouthDEFAULT.modifyDownLip(currentDownLipPolygon, step);
			currentUpperLipPolygon.setFill(mColor);
			currentDownLipPolygon.setFill(mColor);
			break;
			
		case FADEIN:
			if(step == 2)
			{
				mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), 0.0);
				currentUpperLipPolygon.setVisible(false);
		    	currentDownLipPolygon.setVisible(false);
			}
			else if(mColor.getOpacity() != 0.0)
				mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), mColor.getOpacity() - 0.052);
			break;
			
		case FADEOUT:
			currentUpperLipPolygon.setVisible(true);
	    	currentDownLipPolygon.setVisible(true);
	    	
			if(step == 2)
			{
				mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), 1.0);
				isFadeIn = true;
			}
			else if(mColor.getOpacity() != 1.0)
				mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), mColor.getOpacity() + 0.052);
			break;

		case SMILE:
			currentUpperLipPolygon = MouthSMILE.modifyUpperLip(currentUpperLipPolygon, step, "plus");
			currentDownLipPolygon = MouthSMILE.modifyDownLip(currentDownLipPolygon, step, "plus");
			break;
			
		case SMILEEND:
			if(step == 2)
			{
				currentDownLipPolygon = MouthDEFAULT.modifyDownLip(currentDownLipPolygon, 0);
				currentUpperLipPolygon = MouthDEFAULT.modifyUpperLip(currentUpperLipPolygon, 0);
			}
			else
			{
				currentUpperLipPolygon = MouthSMILE.modifyUpperLip(currentUpperLipPolygon,step, "minus");
				currentDownLipPolygon = MouthSMILE.modifyDownLip(currentDownLipPolygon, step, "minus");
			}
			break;

		case SAD:
			currentUpperLipPolygon = MouthSAD.modifyUpperLip(currentUpperLipPolygon, step, "plus");
			currentDownLipPolygon = MouthSAD.modifyDownLip(currentDownLipPolygon, step, "plus");
			break;
		case SADEND:
			if(step == 2)
			{
				currentDownLipPolygon = MouthDEFAULT.modifyDownLip(currentDownLipPolygon, 0);
				currentUpperLipPolygon = MouthDEFAULT.modifyUpperLip(currentUpperLipPolygon, 0);
			}
			else
			{
				currentUpperLipPolygon = MouthSAD.modifyUpperLip(currentUpperLipPolygon, step, "minus");
				currentDownLipPolygon = MouthSAD.modifyDownLip(currentDownLipPolygon, step, "minus");
			}
			break;
		case ANGRY:
			System.out.println(step);
			currentUpperLipPolygon = MouthANGRY.modifyUpperLip(currentUpperLipPolygon, step, "plus");
			currentDownLipPolygon = MouthANGRY.modifyDownLip(currentDownLipPolygon, step, "plus");
			break;
		case ANGRYEND:
			if(step == 2)
			{
				currentDownLipPolygon = MouthDEFAULT.modifyDownLip(currentDownLipPolygon, 0);
				currentUpperLipPolygon = MouthDEFAULT.modifyUpperLip(currentUpperLipPolygon, 0);
			}
			else
			{
				currentUpperLipPolygon = MouthANGRY.modifyUpperLip(currentUpperLipPolygon, step, "minus");
				currentDownLipPolygon = MouthANGRY.modifyDownLip(currentDownLipPolygon, step, "minus");
			}
			break;
		case ANGRYSMALLMOUTH:
			currentUpperLipPolygon = MouthANGRYSMALLMOUTH.modifyUpperLip(currentUpperLipPolygon, step, "plus");
			currentDownLipPolygon = MouthANGRYSMALLMOUTH.modifyDownLip(currentDownLipPolygon, step, "plus");
			break;
		case ANGRYSMALLMOUTHEND:
			if(step == 2)
			{
				currentDownLipPolygon = MouthDEFAULT.modifyDownLip(currentDownLipPolygon, 0);
				currentUpperLipPolygon = MouthDEFAULT.modifyUpperLip(currentUpperLipPolygon, 0);
			}
			else
			{
				currentUpperLipPolygon = MouthANGRYSMALLMOUTH.modifyUpperLip(currentUpperLipPolygon, step, "minus");
				currentDownLipPolygon = MouthANGRYSMALLMOUTH.modifyDownLip(currentDownLipPolygon, step, "minus");
			}
			break;
		case SURPRISED:
			currentUpperLipPolygon = MouthSURPRISED.modifyUpperLip(currentUpperLipPolygon, step, "plus");
			currentDownLipPolygon = MouthSURPRISED.modifyDownLip(currentDownLipPolygon, step, "plus");
			break;
		case SURPRISEDEND:
			if(step == 2)
			{
				currentDownLipPolygon = MouthDEFAULT.modifyDownLip(currentDownLipPolygon, 0);
				currentUpperLipPolygon = MouthDEFAULT.modifyUpperLip(currentUpperLipPolygon, 0);
			}
			else
			{
				currentUpperLipPolygon = MouthSURPRISED.modifyUpperLip(currentUpperLipPolygon, step, "minus");
				currentDownLipPolygon = MouthSURPRISED.modifyDownLip(currentDownLipPolygon, step, "minus");
			}
			break;
			
		case HAPPY:
			currentUpperLipPolygon = MouthHAPPY.modifyUpperLip(currentUpperLipPolygon, step, "plus");
			currentDownLipPolygon = MouthHAPPY.modifyDownLip(currentDownLipPolygon, step, "plus");
			break;

		case HAPPYEND:
			if(step == 2)
			{
				currentDownLipPolygon = MouthDEFAULT.modifyDownLip(currentDownLipPolygon, 0);
				currentUpperLipPolygon = MouthDEFAULT.modifyUpperLip(currentUpperLipPolygon, 0);
			}
			else
			{
				currentUpperLipPolygon = MouthHAPPY.modifyUpperLip(currentUpperLipPolygon, step, "minus");
				currentDownLipPolygon = MouthHAPPY.modifyDownLip(currentDownLipPolygon, step, "minus");
			}
			break;
		case DISGUSTED:
			currentUpperLipPolygon = MouthDISGUSTED.modifyUpperLip(currentUpperLipPolygon, step, "plus");
			currentDownLipPolygon = MouthDISGUSTED.modifyDownLip(currentDownLipPolygon, step, "plus");
			break;

		case DISGUSTEDEND:
			if(step == 2)
			{
				currentDownLipPolygon = MouthDEFAULT.modifyDownLip(currentDownLipPolygon, 0);
				currentUpperLipPolygon = MouthDEFAULT.modifyUpperLip(currentUpperLipPolygon, 0);
			}
			else
			{
				currentUpperLipPolygon = MouthDISGUSTED.modifyUpperLip(currentUpperLipPolygon, step, "minus");
				currentDownLipPolygon = MouthDISGUSTED.modifyDownLip(currentDownLipPolygon, step, "minus");
			}
			break;
		case CONTEMPT:
			currentUpperLipPolygon = MouthCONTEMPT.modifyUpperLip(currentUpperLipPolygon, step, "plus");
			currentDownLipPolygon = MouthCONTEMPT.modifyDownLip(currentDownLipPolygon, step, "plus");
			break;

		case CONTEMPTEND:
			if(step == 2)
			{
				currentDownLipPolygon = MouthDEFAULT.modifyDownLip(currentDownLipPolygon, 0);
				currentUpperLipPolygon = MouthDEFAULT.modifyUpperLip(currentUpperLipPolygon, 0);
			}
			else
			{
				currentUpperLipPolygon = MouthCONTEMPT.modifyUpperLip(currentUpperLipPolygon, step, "minus");
				currentDownLipPolygon = MouthCONTEMPT.modifyDownLip(currentDownLipPolygon, step, "minus");
			}
			break;

		case FEAR:
			currentUpperLipPolygon = MouthFEAR.modifyUpperLip(currentUpperLipPolygon, step, "plus");
			currentDownLipPolygon = MouthFEAR.modifyDownLip(currentDownLipPolygon, step, "plus");
			break;

		case FEAREND:
			if(step == 2)
			{
				currentDownLipPolygon = MouthDEFAULT.modifyDownLip(currentDownLipPolygon, 0);
				currentUpperLipPolygon = MouthDEFAULT.modifyUpperLip(currentUpperLipPolygon, 0);
			}
			else
			{
				currentUpperLipPolygon = MouthFEAR.modifyUpperLip(currentUpperLipPolygon, step, "minus");
				currentDownLipPolygon = MouthFEAR.modifyDownLip(currentDownLipPolygon, step, "minus");
			}
			break;
		case EXCITED:
			currentUpperLipPolygon = MouthEXCITED.modifyUpperLip(currentUpperLipPolygon, step, "plus");
			currentDownLipPolygon = MouthEXCITED.modifyDownLip(currentDownLipPolygon, step, "plus");
			break;

		case EXCITEDEND:
			if(step == 2)
			{
				currentDownLipPolygon = MouthDEFAULT.modifyDownLip(currentDownLipPolygon, 0);
				currentUpperLipPolygon = MouthDEFAULT.modifyUpperLip(currentUpperLipPolygon, 0);
			}
			else
			{
				currentUpperLipPolygon = MouthEXCITED.modifyUpperLip(currentUpperLipPolygon, step, "minus");
				currentDownLipPolygon = MouthEXCITED.modifyDownLip(currentDownLipPolygon, step, "minus");
			}
			break;

		case EMBARRASSED:
			currentUpperLipPolygon = MouthEMBARRASSED.modifyUpperLip(currentUpperLipPolygon, step, "plus");
			currentDownLipPolygon = MouthEMBARRASSED.modifyDownLip(currentDownLipPolygon, step, "plus");
			break;
		case EMBARRASSEDEND:
			if(step == 2)
			{
				currentDownLipPolygon = MouthDEFAULT.modifyDownLip(currentDownLipPolygon, 0);
				currentUpperLipPolygon = MouthDEFAULT.modifyUpperLip(currentUpperLipPolygon, 0);
			}
			else
			{
				currentUpperLipPolygon = MouthEMBARRASSED.modifyUpperLip(currentUpperLipPolygon, step, "minus");
				currentDownLipPolygon = MouthEMBARRASSED.modifyDownLip(currentDownLipPolygon, step, "minus");
			}
			break;
		case O:
			currentUpperLipPolygon = MouthO.modifyUpperLip(currentUpperLipPolygon, step, "plus");
			currentDownLipPolygon = MouthO.modifyDownLip(currentDownLipPolygon, step, "plus");
			break;

		case ONE:
			currentUpperLipPolygon = MouthONE.modifyUpperLip(currentUpperLipPolygon, step, "plus");
			currentDownLipPolygon = MouthONE.modifyDownLip(currentDownLipPolygon, step, "plus");
		case SIX:
		case FOURTEEN:
		case NINETEEN:
			break;

		case TWO:
			currentUpperLipPolygon = MouthTWO.modifyUpperLip(currentUpperLipPolygon, step, "plus");
			currentDownLipPolygon = MouthTWO.modifyDownLip(currentDownLipPolygon, step, "plus");
			break;

		case THREE:
			currentUpperLipPolygon = MouthTREE.modifyUpperLip(currentUpperLipPolygon, step, "plus");
			currentDownLipPolygon = MouthTREE.modifyDownLip(currentDownLipPolygon, step, "plus");
		case TWENTY:
			break;

		case FOUR:
			currentUpperLipPolygon = MouthFOUR.modifyUpperLip(currentUpperLipPolygon, step, "plus");
			currentDownLipPolygon = MouthFOUR.modifyDownLip(currentDownLipPolygon, step, "plus");
			break;

		case FIVE:
			currentUpperLipPolygon = MouthFIVE.modifyUpperLip(currentUpperLipPolygon, step, "plus");
			currentDownLipPolygon = MouthFIVE.modifyDownLip(currentDownLipPolygon, step, "plus");
		case EIGHT:
			currentUpperLipPolygon = MouthFIVE.modifyUpperLip(currentUpperLipPolygon, step, "plus");
			currentDownLipPolygon = MouthFIVE.modifyDownLip(currentDownLipPolygon, step, "plus");
			break;

		case SEVEN:
			currentUpperLipPolygon = MouthSEVEN.modifyUpperLip(currentUpperLipPolygon, step, "plus");
			currentDownLipPolygon = MouthSEVEN.modifyDownLip(currentDownLipPolygon, step, "plus");
			break;

		case NINE:
			currentUpperLipPolygon = MouthFOUR.modifyUpperLip(currentUpperLipPolygon, step, "plus");
			currentDownLipPolygon = MouthFOUR.modifyDownLip(currentDownLipPolygon, step, "plus");
			break;

		case TEN:
			currentUpperLipPolygon = MouthFOUR.modifyUpperLip(currentUpperLipPolygon, step, "plus");
			currentDownLipPolygon = MouthFOUR.modifyDownLip(currentDownLipPolygon, step, "plus");
			break;

		}
	}
	
	@Override
	public void update()
	{
		currentUpperLipPolygon.setFill(mColor);
		currentDownLipPolygon.setFill(mColor);
	}
	@Override
	protected void recordColor() {
		if (mHeadFX.mStickmanFX.setCharacterInvisible == false)
			mColorRecorder = mColor;
	}
}
