/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanfx.bodyfx;

import java.awt.Dimension;

import de.dfki.stickmanfx.StickmanFX;
import de.dfki.stickmanfx.mimic.util.LeftBrowANGRY;
import de.dfki.stickmanfx.mimic.util.LeftBrowDEFAULT;
import de.dfki.stickmanfx.mimic.util.LeftBrowDISGUSTED;
import de.dfki.stickmanfx.mimic.util.LeftBrowEMBARRASSED;
import de.dfki.stickmanfx.mimic.util.LeftBrowEXCITED;
import de.dfki.stickmanfx.mimic.util.LeftBrowHAPPY;
import de.dfki.stickmanfx.mimic.util.LeftBrowSAD;
import de.dfki.stickmanfx.mimic.util.LeftBrowSURPRISED;
import de.dfki.util.XMLParser;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

/**
 *
 * @author Beka Aptsiauri
 *
 */
public class LeftEyebrowFX extends BodyPartFX 
{
	public static enum SHAPE 
	{
		DEFAULT, FADEIN, FADEOUT, ANGRY, ANGRYEND, HAPPY, HAPPYEND, DISGUSTED, DISGUSTEDEND, SURPRISED, SURPRISEDEND, EXCITED, EXCITEDEND, EMBARRASSED, EMBARRASSEDEND, SAD, SADEND
	};

	HeadFX mHeadFX;
	
	Polygon currentPolygon;
	
	public LeftEyebrowFX.SHAPE mShape = LeftEyebrowFX.SHAPE.DEFAULT;

	public LeftEyebrowFX(HeadFX head) 
	{
		mHeadFX = head;
		mSize = new Dimension(mLength, mLength);
		
		if(mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.MALE)
			mColor = Color.rgb(88, 44, 13, 1);
		else
			mColor = Color.rgb(204, 163, 0, 1);
		activateConfigColor();
		
		currentPolygon = new Polygon();
		
		mStart = mHeadFX.getLeftEyebrowPostion();
		
		init();
		
		mHeadFX.mHead.getChildren().add(currentPolygon);
	}

	@Override
	public void init()
	{
		super.init();
		currentPolygon.setTranslateX(mStart.x + 9);
		currentPolygon.setTranslateY(mStart.y + 85);
		currentPolygon.setTranslateZ(-17);
	}
	
	private void activateConfigColor()
   	{
		String stickmanName = mHeadFX.mStickmanFX.mName;
   		
		if(XMLParser.getColorMap(stickmanName) != null)
		{
			if(XMLParser.getColorMap(stickmanName).containsKey("BrowColor"))
				this.mColor = XMLParser.getColorMap(stickmanName).get("BrowColor");
		}
   	}
	
	@Override
	public void setShape(String s) {
		SHAPE shape = LeftEyebrowFX.SHAPE.valueOf(s);
		mShape = (shape != null) ? shape : LeftEyebrowFX.SHAPE.DEFAULT;
	}

	@Override
	public void resetShape() {
		mShape = LeftEyebrowFX.SHAPE.DEFAULT;
	}

	@Override
	public void calculate(int step) {

		switch (mShape) 
		{
		case DEFAULT:
			
			if(mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.MALE)
				currentPolygon = LeftBrowDEFAULT.createMaleBrow(currentPolygon, step);
			else
				currentPolygon = LeftBrowDEFAULT.createFemaleBrow(currentPolygon, step);
			currentPolygon.setFill(mColor);
			break;

		case ANGRY:
			currentPolygon = LeftBrowANGRY.getANGRY(currentPolygon, step, "PLUS");
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
			
		case ANGRYEND:
			currentPolygon = LeftBrowANGRY.getANGRY(currentPolygon, step, "MINUS");
			break;

		case DISGUSTED:
			currentPolygon = LeftBrowDISGUSTED.getANGRY(currentPolygon, step, "PLUS");
			break;
			
		case DISGUSTEDEND:
			currentPolygon = LeftBrowDISGUSTED.getANGRY(currentPolygon, step, "MINUS");
			break;
			
		case SURPRISED:
			currentPolygon = LeftBrowSURPRISED.getANGRY(currentPolygon, step, "PLUS");
			break;
			
		case SURPRISEDEND:
			currentPolygon = LeftBrowSURPRISED.getANGRY(currentPolygon, step, "MINUS");
			break;
			
		case EXCITED:
			currentPolygon = LeftBrowEXCITED.getANGRY(currentPolygon, step, "PLUS");
			break;
			
		case EXCITEDEND:
			currentPolygon = LeftBrowEXCITED.getANGRY(currentPolygon, step, "MINUS");
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
			currentPolygon = LeftBrowHAPPY.getANGRY(currentPolygon, step, "PLUS");
			break;
			
		case HAPPYEND:
			currentPolygon = LeftBrowHAPPY.getANGRY(currentPolygon, step, "MINUS");
			break;
			
		case SAD:
			currentPolygon = LeftBrowSAD.getANGRY(currentPolygon, step, "PLUS");
			break;
			
		case SADEND:
			currentPolygon = LeftBrowSAD.getANGRY(currentPolygon, step, "MINUS");
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

