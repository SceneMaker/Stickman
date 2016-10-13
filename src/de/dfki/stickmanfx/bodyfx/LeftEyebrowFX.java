/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanfx.bodyfx;

import de.dfki.stickmanfx.mimic.util.LeftBrowANGRY;
import de.dfki.stickmanfx.mimic.util.LeftBrowDISGUSTED;
import de.dfki.stickmanfx.mimic.util.LeftBrowEMBARRASSED;
import de.dfki.stickmanfx.mimic.util.LeftBrowEXCITED;
import de.dfki.stickmanfx.mimic.util.LeftBrowHAPPY;
import de.dfki.stickmanfx.mimic.util.LeftBrowSAD;
import de.dfki.stickmanfx.mimic.util.LeftBrowSURPRISED;
import java.awt.Dimension;
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
		DEFAULT, ANGRY, ANGRYEND, HAPPY, HAPPYEND, DISGUSTED, DISGUSTEDEND, SURPRISED, SURPRISEDEND, EXCITED, EXCITEDEND, EMBARRASSED, EMBARRASSEDEND, SAD, SADEND
	};

	HeadFX mHeadFX;
	
	Polygon currentPolygon;
	
	public LeftEyebrowFX.SHAPE mShape = LeftEyebrowFX.SHAPE.DEFAULT;

	public LeftEyebrowFX(HeadFX head) 
	{
		mHeadFX = head;
		mSize = new Dimension(mLength, mLength);
		
		mColor = Color.rgb(0, 0, 0, (64 * 100 / 255) / 100f);
		
		init();
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
		mStart = mHeadFX.getLeftEyebrowPostion();
		
		switch (mShape) 
		{
		case DEFAULT:
			if (mHeadFX.mStickmanFX.setCharacterInvisible == true) {
				if (mHeadFX.mStickmanFX.fadeControler == true)
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
			
			currentPolygon = new Polygon();
			
			currentPolygon.getPoints().addAll(
				//  x   	y   	
					0.0,	0.0,			//Point 0
					0.0,	-5.0,			//Point 1
					3.0,	-7.0,			//Point 2
					6.0,	-8.0,			//Point 3 
					13.0,	-10.0,			//Point 4
					20.0,	-11.0,			//Point 5
					25.0,	-7.0,			//Point 6
					30.0,	-3.0,			//Point 7
					30.0,	0.0,			//Point 8
					25.0,	-3.0,		    //Point 9
					20.0,	-7.0,		    //Point 10
					13.0,	-6.0,			//Point 11
					6.0,  	-5.0,			//Point 12
					3.0,	-3.0			//Point 13
					);
			break;

		case ANGRY:
			currentPolygon = LeftBrowANGRY.getANGRY(currentPolygon, step, "PLUS");
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
			currentPolygon = LeftBrowEMBARRASSED.getANGRY(currentPolygon, step, "PLUS");
			break;

		case EMBARRASSEDEND:
			currentPolygon = LeftBrowEMBARRASSED.getANGRY(currentPolygon, step, "minus");
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
		
		currentPolygon.setId("LeftBrow");
		currentPolygon.setFill(Color.BLACK);
		
		currentPolygon.setTranslateX(mStart.x + 9);
		currentPolygon.setTranslateY(mStart.y + 85);
		currentPolygon.setTranslateZ(-17);
		
		if (step == 0) 
			mHeadFX.mHead.getChildren().add(currentPolygon);
		else
			mHeadFX.mHead.getChildren().set(2, currentPolygon);
	}

	protected void recordColor() {
		if (mHeadFX.mStickmanFX.setCharacterInvisible == false)
			mColorRecorder = mColor;
	}
}

