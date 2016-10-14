package de.dfki.stickmanfx.bodyfx;

import de.dfki.stickmanfx.StickmanFX;
import de.dfki.stickmanfx.animationlogic.AnimatorFX;
import de.dfki.stickmanfx.mimic.util.LeftBrowANGRY;
import de.dfki.stickmanfx.mimic.util.RightBrowANGRY;
import de.dfki.stickmanfx.mimic.util.RightBrowDISGUSTED;
import de.dfki.stickmanfx.mimic.util.RightBrowEMBARRASSED;
import de.dfki.stickmanfx.mimic.util.RightBrowEXCITED;
import de.dfki.stickmanfx.mimic.util.RightBrowHAPPY;
import de.dfki.stickmanfx.mimic.util.RightBrowSAD;
import de.dfki.stickmanfx.mimic.util.RightBrowSURPRISED;

import java.awt.Dimension;
import java.net.URL;

import com.interactivemesh.jfx.importer.col.ColModelImporter;

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
public class RightEyebrowFX extends BodyPartFX {
	public static enum SHAPE {
		DEFAULT, ANGRY, HAPPY, HAPPYEND, ANGRYEND, DISGUSTED, DISGUSTEDEND, SURPRISED, SURPRISEDEND, EXCITED, EXCITEDEND, EMBARRASSED, EMBARRASSEDEND, SAD, SADEND
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
	public void calculate(int step) {
		mStart = mHeadFX.getRightEyebrowPostion();
		

		switch (mShape) {
		case DEFAULT:
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

			currentPolygon = new Polygon();
			
			currentPolygon.getPoints().addAll(
				//  x   	y   	
					0.0,	0.0,			//Point 0
					0.0,	-5.0,			//Point 1
					-3.0,	-7.0,			//Point 2
					-6.0,	-8.0,			//Point 3 
					-13.0,	-10.0,			//Point 4
					-20.0,	-11.0,			//Point 5
					-25.0,	-7.0,			//Point 6
					-30.0,	-3.0,			//Point 7
					-30.0,	0.0,			//Point 8
					-25.0,	-3.0,		    //Point 9
					-20.0,	-7.0,		    //Point 10
					-13.0,	-6.0,			//Point 11
					-6.0,  	-5.0,			//Point 12
					-3.0,	-3.0			//Point 13
					);
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
			currentPolygon = RightBrowEMBARRASSED.getANGRY(currentPolygon, step, "PLUS");
			break;
			
		case EMBARRASSEDEND:
			currentPolygon = RightBrowEMBARRASSED.getANGRY(currentPolygon, step, "MINUS");
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
		
		currentPolygon.setId("RightBrow");
		currentPolygon.setFill(mColor);
		
		currentPolygon.setTranslateX(mStart.x - 9);
		currentPolygon.setTranslateY(mStart.y + 38);
		currentPolygon.setTranslateZ(-17);
		
		if (step == 0) 
			mHeadFX.mHead.getChildren().add(currentPolygon);
		else
			mHeadFX.mHead.getChildren().set(4, currentPolygon);
	}

	protected void recordColor() {
		if (mHeadFX.mStickmanFX.setCharacterInvisible == false)
			mColorRecorder = mColor;
	}
}
