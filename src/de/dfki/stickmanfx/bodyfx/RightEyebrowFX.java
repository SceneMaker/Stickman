package de.dfki.stickmanfx.bodyfx;

import java.awt.Dimension;

import de.dfki.stickmanfx.StickmanFX;
import de.dfki.stickmanfx.mimic.util.LeftBrowEMBARRASSED;
import de.dfki.stickmanfx.mimic.util.RightBrowANGRY;
import de.dfki.stickmanfx.mimic.util.RightBrowDEFAULT;
import de.dfki.stickmanfx.mimic.util.RightBrowDISGUSTED;
import de.dfki.stickmanfx.mimic.util.RightBrowEXCITED;
import de.dfki.stickmanfx.mimic.util.RightBrowHAPPY;
import de.dfki.stickmanfx.mimic.util.RightBrowSAD;
import de.dfki.stickmanfx.mimic.util.RightBrowSURPRISED;
import de.dfki.util.XMLParser;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

/**
 *
 * @author Beka Aptsiauri
 *
 */
public class RightEyebrowFX extends BodyPartFX {
	public static enum SHAPE {
		DEFAULT, FADEIN, FADEOUT, ANGRY, HAPPY, HAPPYEND, ANGRYEND, DISGUSTED, DISGUSTEDEND, SURPRISED, SURPRISEDEND, EXCITED, EXCITEDEND, EMBARRASSED, EMBARRASSEDEND, SAD, SADEND
	};

	HeadFX mHeadFX;
	
	Polygon currentPolygon;

	public RightEyebrowFX.SHAPE mShape = RightEyebrowFX.SHAPE.DEFAULT;

	public RightEyebrowFX(HeadFX head) {
		mHeadFX = head;
		mSize = new Dimension(mLength, 5);
		
		if(mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.MALE)
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
	public void init()
	{
		super.init();
		currentPolygon.setTranslateX(mStart.x - 9);
		currentPolygon.setTranslateY(mStart.y + 38);
		currentPolygon.setTranslateZ(-17);
	}
	
	private void activateConfigColor()
   	{
   		if(mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.FEMALE)
   		{
   			if(!XMLParser.femaleColor.isEmpty())
   			{
   				if(XMLParser.femaleColor.containsKey("BrowColor"))
   					this.mColor = XMLParser.femaleColor.get("BrowColor");
   			}
   		}
   		else
   		{
   			if(!XMLParser.maleColor.isEmpty())
   			{
   				if(XMLParser.maleColor.containsKey("BrowColor"))
   					this.mColor = XMLParser.maleColor.get("BrowColor");
   			}
   		}
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
	public void calculate(int step) {
		

		switch (mShape) {
		case DEFAULT:
			if(mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.MALE)
				currentPolygon = RightBrowDEFAULT.createMaleBrow(currentPolygon, step);
			else
				currentPolygon = RightBrowDEFAULT.createFemaleBrow(currentPolygon, step);
			currentPolygon.setFill(mColor);
			break;
			
		case FADEIN:
			if(step == 2)
				mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), 0.0);
			else if(mColor.getOpacity() != 0.0)
				mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), mColor.getOpacity() - 0.052);
			currentPolygon.setFill(mColor);
			break;
			
		case FADEOUT:
			if(step == 2)
				mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), 1.0);
			else if(mColor.getOpacity() != 1.0)
				mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), mColor.getOpacity() + 0.052);
			currentPolygon.setFill(mColor);
			break;

		case ANGRY:
			currentPolygon = RightBrowANGRY.getANGRY(currentPolygon, step, "PLUS");
			break;
			
		case ANGRYEND:
			currentPolygon = RightBrowANGRY.getANGRY(currentPolygon, step, "MINUS");
			break;
			
		case DISGUSTED:
			currentPolygon = RightBrowDISGUSTED.getANGRY(currentPolygon, step, "PLUS");
			break;
			
		case DISGUSTEDEND:
			currentPolygon = RightBrowDISGUSTED.getANGRY(currentPolygon, step, "MINUS");
			break;
			
		case SURPRISED:
			currentPolygon = RightBrowSURPRISED.getANGRY(currentPolygon, step, "PLUS");
			break;
			
		case SURPRISEDEND:
			currentPolygon = RightBrowSURPRISED.getANGRY(currentPolygon, step, "MINUS");
			break;
			
		case EXCITED:
			currentPolygon = RightBrowEXCITED.getANGRY(currentPolygon, step, "PLUS");
			break;
			
		case EXCITEDEND:
			currentPolygon = RightBrowEXCITED.getANGRY(currentPolygon, step, "MINUS");
			break;
			
		case EMBARRASSED:
			if(mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.MALE)
				currentPolygon = LeftBrowEMBARRASSED.getEMBARRASSED(currentPolygon, step, "PLUS", true);
			else
				currentPolygon = LeftBrowEMBARRASSED.getEMBARRASSED(currentPolygon, step, "PLUS", false);
			break;
			
		case EMBARRASSEDEND:
			if(mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.MALE)
				currentPolygon = LeftBrowEMBARRASSED.getEMBARRASSED(currentPolygon, step, "minus", true);
			else
				currentPolygon = LeftBrowEMBARRASSED.getEMBARRASSED(currentPolygon, step, "minus", false);
			break;
			
		case HAPPY:
			currentPolygon = RightBrowHAPPY.getANGRY(currentPolygon, step, "PLUS");
			break;
			
		case HAPPYEND:
			currentPolygon = RightBrowHAPPY.getANGRY(currentPolygon, step, "MINUS");
			break;
			
		case SAD:
			currentPolygon = RightBrowSAD.getANGRY(currentPolygon, step, "PLUS");
			break;
			
		case SADEND:
			currentPolygon = RightBrowSAD.getANGRY(currentPolygon, step, "MINUS");
			break;

		}
	}
	
	@Override
	public void update()
	{
		currentPolygon.setFill(mColor);
	}

	@Override
	protected void recordColor() {
		if (mHeadFX.mStickmanFX.setCharacterInvisible == false)
			mColorRecorder = mColor;
	}
}
