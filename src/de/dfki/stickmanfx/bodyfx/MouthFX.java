package de.dfki.stickmanfx.bodyfx;

import de.dfki.stickman.animation.face.Mouth_THREE;
import de.dfki.stickmanfx.StickmanFX;
import de.dfki.stickmanfx.animationlogic.AnimatorFX;
import de.dfki.stickmanfx.mimic.util.MouthANGRY;
import de.dfki.stickmanfx.mimic.util.MouthANGRYSMALLMOUTH;
import de.dfki.stickmanfx.mimic.util.MouthCONTEMPT;
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

import java.awt.Dimension;
import java.net.URL;

import com.interactivemesh.jfx.importer.col.ColModelImporter;
import com.sun.prism.Material;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.DrawMode;
import javafx.scene.shape.MeshView;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.TriangleMesh;
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
	public void calculate(int step) {
		mStart = mHeadFX.getMouthPostion();
		
		boolean isFadeIn = false;
		
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
			
			currentUpperLipPolygon = createUpperLip();
			currentDownLipPolygon = createDownLip();
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
			currentUpperLipPolygon = MouthSMILE.modifyUpperLip(currentUpperLipPolygon, mShapeAnimationStep, "plus");
			currentDownLipPolygon = MouthSMILE.modifyDownLip(currentDownLipPolygon, mShapeAnimationStep, "plus");
			break;
			
		case SMILEEND:
			currentUpperLipPolygon = MouthSMILE.modifyUpperLip(currentUpperLipPolygon,mShapeAnimationStep, "minus");
			currentDownLipPolygon = MouthSMILE.modifyDownLip(currentDownLipPolygon, mShapeAnimationStep, "minus");
			break;

		case SAD:
			currentUpperLipPolygon = MouthSAD.modifyUpperLip(currentUpperLipPolygon, mShapeAnimationStep, "plus");
			currentDownLipPolygon = MouthSAD.modifyDownLip(currentDownLipPolygon, mShapeAnimationStep, "plus");
			break;
		case SADEND:
			currentUpperLipPolygon = MouthSAD.modifyUpperLip(currentUpperLipPolygon, mShapeAnimationStep, "minus");
			currentDownLipPolygon = MouthSAD.modifyDownLip(currentDownLipPolygon, mShapeAnimationStep, "minus");
			break;
		case ANGRY:
			currentUpperLipPolygon = MouthANGRY.modifyUpperLip(currentUpperLipPolygon, mShapeAnimationStep, "plus");
			currentDownLipPolygon = MouthANGRY.modifyDownLip(currentDownLipPolygon, mShapeAnimationStep, "plus");
			break;
		case ANGRYEND:
			currentUpperLipPolygon = MouthANGRY.modifyUpperLip(currentUpperLipPolygon, mShapeAnimationStep, "minus");
			currentDownLipPolygon = MouthANGRY.modifyDownLip(currentDownLipPolygon, mShapeAnimationStep, "minus");
			break;
		case ANGRYSMALLMOUTH:
			currentUpperLipPolygon = MouthANGRYSMALLMOUTH.modifyUpperLip(currentUpperLipPolygon, mShapeAnimationStep, "plus");
			currentDownLipPolygon = MouthANGRYSMALLMOUTH.modifyDownLip(currentDownLipPolygon, mShapeAnimationStep, "plus");
			break;
		case ANGRYSMALLMOUTHEND:
			currentUpperLipPolygon = MouthANGRYSMALLMOUTH.modifyUpperLip(currentUpperLipPolygon, mShapeAnimationStep, "minus");
			currentDownLipPolygon = MouthANGRYSMALLMOUTH.modifyDownLip(currentDownLipPolygon, mShapeAnimationStep, "minus");
			break;
		case SURPRISED:
			currentUpperLipPolygon = MouthSURPRISED.modifyUpperLip(currentUpperLipPolygon, mShapeAnimationStep, "plus");
			currentDownLipPolygon = MouthSURPRISED.modifyDownLip(currentDownLipPolygon, mShapeAnimationStep, "plus");
			break;
		case SURPRISEDEND:
			currentUpperLipPolygon = MouthSURPRISED.modifyUpperLip(currentUpperLipPolygon, mShapeAnimationStep, "minus");
			currentDownLipPolygon = MouthSURPRISED.modifyDownLip(currentDownLipPolygon, mShapeAnimationStep, "minus");
			break;
			
		case HAPPY:
			currentUpperLipPolygon = MouthHAPPY.modifyUpperLip(currentUpperLipPolygon, mShapeAnimationStep, "plus");
			currentDownLipPolygon = MouthHAPPY.modifyDownLip(currentDownLipPolygon, mShapeAnimationStep, "plus");
			break;

		case HAPPYEND:
			currentUpperLipPolygon = MouthHAPPY.modifyUpperLip(currentUpperLipPolygon, mShapeAnimationStep, "minus");
			currentDownLipPolygon = MouthHAPPY.modifyDownLip(currentDownLipPolygon, mShapeAnimationStep, "minus");
			break;
		case DISGUSTED:
			currentUpperLipPolygon = MouthDISGUSTED.modifyUpperLip(currentUpperLipPolygon, mShapeAnimationStep, "plus");
			currentDownLipPolygon = MouthDISGUSTED.modifyDownLip(currentDownLipPolygon, mShapeAnimationStep, "plus");
			break;

		case DISGUSTEDEND:
			currentUpperLipPolygon = MouthDISGUSTED.modifyUpperLip(currentUpperLipPolygon, mShapeAnimationStep, "minus");
			currentDownLipPolygon = MouthDISGUSTED.modifyDownLip(currentDownLipPolygon, mShapeAnimationStep, "minus");
			break;
		case CONTEMPT:
			currentUpperLipPolygon = MouthCONTEMPT.modifyUpperLip(currentUpperLipPolygon, mShapeAnimationStep, "plus");
			currentDownLipPolygon = MouthCONTEMPT.modifyDownLip(currentDownLipPolygon, mShapeAnimationStep, "plus");
			break;

		case CONTEMPTEND:
			currentUpperLipPolygon = MouthCONTEMPT.modifyUpperLip(currentUpperLipPolygon, mShapeAnimationStep, "minus");
			currentDownLipPolygon = MouthCONTEMPT.modifyDownLip(currentDownLipPolygon, mShapeAnimationStep, "minus");
			break;

		case FEAR:
			currentUpperLipPolygon = MouthFEAR.modifyUpperLip(currentUpperLipPolygon, mShapeAnimationStep, "plus");
			currentDownLipPolygon = MouthFEAR.modifyDownLip(currentDownLipPolygon, mShapeAnimationStep, "plus");
			break;

		case FEAREND:
			currentUpperLipPolygon = MouthFEAR.modifyUpperLip(currentUpperLipPolygon, mShapeAnimationStep, "minus");
			currentDownLipPolygon = MouthFEAR.modifyDownLip(currentDownLipPolygon, mShapeAnimationStep, "minus");
			break;
		case EXCITED:
			currentUpperLipPolygon = MouthEXCITED.modifyUpperLip(currentUpperLipPolygon, mShapeAnimationStep, "plus");
			currentDownLipPolygon = MouthEXCITED.modifyDownLip(currentDownLipPolygon, mShapeAnimationStep, "plus");
			break;

		case EXCITEDEND:
			currentUpperLipPolygon = MouthEXCITED.modifyUpperLip(currentUpperLipPolygon, mShapeAnimationStep, "minus");
			currentDownLipPolygon = MouthEXCITED.modifyDownLip(currentDownLipPolygon, mShapeAnimationStep, "minus");
			break;

		case EMBARRASSED:
			currentUpperLipPolygon = MouthEMBARRASSED.modifyUpperLip(currentUpperLipPolygon, mShapeAnimationStep, "plus");
			currentDownLipPolygon = MouthEMBARRASSED.modifyDownLip(currentDownLipPolygon, mShapeAnimationStep, "plus");
			break;
		case EMBARRASSEDEND:
			currentUpperLipPolygon = MouthEMBARRASSED.modifyUpperLip(currentUpperLipPolygon, mShapeAnimationStep, "minus");
			currentDownLipPolygon = MouthEMBARRASSED.modifyDownLip(currentDownLipPolygon, mShapeAnimationStep, "minus");
			break;
		case O:
			currentUpperLipPolygon = MouthO.modifyUpperLip(currentUpperLipPolygon, mShapeAnimationStep, "plus");
			currentDownLipPolygon = MouthO.modifyDownLip(currentDownLipPolygon, mShapeAnimationStep, "plus");
			break;

		case ONE:
			currentUpperLipPolygon = MouthONE.modifyUpperLip(currentUpperLipPolygon, mShapeAnimationStep, "plus");
			currentDownLipPolygon = MouthONE.modifyDownLip(currentDownLipPolygon, mShapeAnimationStep, "plus");
		case SIX:
		case FOURTEEN:
		case NINETEEN:
			break;

		case TWO:
			currentUpperLipPolygon = MouthTWO.modifyUpperLip(currentUpperLipPolygon, mShapeAnimationStep, "plus");
			currentDownLipPolygon = MouthTWO.modifyDownLip(currentDownLipPolygon, mShapeAnimationStep, "plus");
			break;

		case THREE:
			currentUpperLipPolygon = MouthTREE.modifyUpperLip(currentUpperLipPolygon, mShapeAnimationStep, "plus");
			currentDownLipPolygon = MouthTREE.modifyDownLip(currentDownLipPolygon, mShapeAnimationStep, "plus");
		case TWENTY:
			break;

		case FOUR:
			currentUpperLipPolygon = MouthFOUR.modifyUpperLip(currentUpperLipPolygon, mShapeAnimationStep, "plus");
			currentDownLipPolygon = MouthFOUR.modifyDownLip(currentDownLipPolygon, mShapeAnimationStep, "plus");
			break;

		case FIVE:
			currentUpperLipPolygon = MouthFIVE.modifyUpperLip(currentUpperLipPolygon, mShapeAnimationStep, "plus");
			currentDownLipPolygon = MouthFIVE.modifyDownLip(currentDownLipPolygon, mShapeAnimationStep, "plus");
		case EIGHT:
			currentUpperLipPolygon = MouthFIVE.modifyUpperLip(currentUpperLipPolygon, mShapeAnimationStep, "plus");
			currentDownLipPolygon = MouthFIVE.modifyDownLip(currentDownLipPolygon, mShapeAnimationStep, "plus");
			break;

		case SEVEN:
			currentUpperLipPolygon = MouthSEVEN.modifyUpperLip(currentUpperLipPolygon, mShapeAnimationStep, "plus");
			currentDownLipPolygon = MouthSEVEN.modifyDownLip(currentDownLipPolygon, mShapeAnimationStep, "plus");
			break;

		case NINE:
			currentUpperLipPolygon = MouthFOUR.modifyUpperLip(currentUpperLipPolygon, mShapeAnimationStep, "plus");
			currentDownLipPolygon = MouthFOUR.modifyDownLip(currentDownLipPolygon, mShapeAnimationStep, "plus");
			break;

		case TEN:
			currentUpperLipPolygon = MouthFOUR.modifyUpperLip(currentUpperLipPolygon, mShapeAnimationStep, "plus");
			currentDownLipPolygon = MouthFOUR.modifyDownLip(currentDownLipPolygon, mShapeAnimationStep, "plus");
			break;

		}
		
		currentUpperLipPolygon.setFill(mColor);
		currentDownLipPolygon.setFill(mColor);
	    
		currentUpperLipPolygon.setTranslateX(mStart.x-14);
		currentUpperLipPolygon.setTranslateY(mStart.y+95);
		currentUpperLipPolygon.setTranslateZ(-17);
		
		if (step == 0) 
			mHeadFX.mHead.getChildren().add(currentUpperLipPolygon);
		else
			mHeadFX.mHead.getChildren().set(6, currentUpperLipPolygon);
		
		currentDownLipPolygon.setTranslateX(mStart.x-14);
		currentDownLipPolygon.setTranslateY(mStart.y+94);
		currentDownLipPolygon.setTranslateZ(-17);
		
	    if (step == 0) 
			mHeadFX.mHead.getChildren().add(currentDownLipPolygon);
		else
			mHeadFX.mHead.getChildren().set(7, currentDownLipPolygon);
	}
	
	public void update()
	{
		currentUpperLipPolygon.setFill(mColor);
		currentDownLipPolygon.setFill(mColor);
	}
	protected void recordColor() {
		if (mHeadFX.mStickmanFX.setCharacterInvisible == false)
			mColorRecorder = mColor;
	}
	
	private Polygon createUpperLip()
	{
		Polygon polygon = new Polygon();
		polygon.getPoints().addAll(
				//  x   y   z	
					0.0,	0.0,			//Point 0
					3.0,	-2.0,			//Point 1
					6.0,	-4.0,			//Point 2
					9.0,	-5.0,			//Point 3
					13.0,	-5.0,			//Point 4
					16.0,	-3.0,			//Point 5
					19.0,	-5.0,			//Point 6
					23.0,	-5.0,			//Point 7
					26.0,	-4.0,			//Point 8
					29.0,	-2.0,			//Point 9
					32.0,	0.0,			//Point 10
					29.0,	0.0,			//Point 11
					26.0,	0.0,			//Point 12
					23.0,	0.0,			//Point 13
					19.0,	0.0,			//Point 14
					16.0,	0.0,			//Point 15
					13.0,	0.0,			//Point 16
					9.0,	0.0,			//Point 17
					6.0,	0.0,			//Point 18
					3.0,	0.0			//Point 19
					);	
		return polygon;
	}
	
	private Polygon createDownLip()
	{
		Polygon polygon = new Polygon();
		polygon.getPoints().addAll(
				//  x   y   z	
					0.0,	0.0,			//Point 0
					3.0,	2.0,			//Point 1
					6.0,	4.0,			//Point 2
					9.0,	5.0,			//Point 3
					13.0,	5.0,			//Point 4
					16.0,	3.0,			//Point 5
					19.0,	5.0,			//Point 6
					23.0,	5.0,			//Point 7
					26.0,	4.0,			//Point 8
					29.0,	2.0,			//Point 9
					32.0,	0.0,			//Point 10
					29.0,	0.0,			//Point 11
					26.0,	0.0,			//Point 12
					23.0,	0.0,			//Point 13
					19.0,	0.0,			//Point 14
					16.0,	0.0,			//Point 15
					13.0,	0.0,			//Point 16
					9.0,	0.0,			//Point 17
					6.0,	0.0,			//Point 18
					3.0,	0.0			//Point 19
					);	
		return polygon;
	}
}
