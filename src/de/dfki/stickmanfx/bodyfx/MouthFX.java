package de.dfki.stickmanfx.bodyfx;

import de.dfki.stickman.animation.face.Mouth_THREE;
import de.dfki.stickmanfx.StickmanFX;
import de.dfki.stickmanfx.animationlogic.AnimatorFX;
import de.dfki.stickmanfx.mimic.util.MouthANGRY;
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
import javafx.scene.shape.TriangleMesh;
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
	
	TriangleMesh currentDownLipMesh;
	TriangleMesh currentUpperLipMesh;
	MeshView downLip;
	MeshView upperLip;
	PhongMaterial mat;

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
			
			currentUpperLipMesh = createUpperLip();
			currentDownLipMesh = createDownLip();
			break;

		case SMILE:
			String a = "b";
			currentUpperLipMesh = MouthSMILE.modifyUpperLip(currentUpperLipMesh, mShapeAnimationStep, "plus");
			currentDownLipMesh = MouthSMILE.modifyDownLip(currentDownLipMesh, mShapeAnimationStep, "plus");
			break;
			
		case SMILEEND:
			currentUpperLipMesh = MouthSMILE.modifyUpperLip(currentUpperLipMesh,mShapeAnimationStep, "minus");
			currentDownLipMesh = MouthSMILE.modifyDownLip(currentDownLipMesh, mShapeAnimationStep, "minus");
			break;

		case SAD:
			currentUpperLipMesh = MouthSAD.modifyUpperLip(currentUpperLipMesh, mShapeAnimationStep, "plus");
			currentDownLipMesh = MouthSAD.modifyDownLip(currentDownLipMesh, mShapeAnimationStep, "plus");
			break;
		case SADEND:
			currentUpperLipMesh = MouthSAD.modifyUpperLip(currentUpperLipMesh, mShapeAnimationStep, "minus");
			currentDownLipMesh = MouthSAD.modifyDownLip(currentDownLipMesh, mShapeAnimationStep, "minus");
			break;
		case ANGRY:
			currentUpperLipMesh = MouthANGRY.modifyUpperLip(currentUpperLipMesh, mShapeAnimationStep, "plus");
			currentDownLipMesh = MouthANGRY.modifyDownLip(currentDownLipMesh, mShapeAnimationStep, "plus");
			break;
		case ANGRYEND:
			currentUpperLipMesh = MouthANGRY.modifyUpperLip(currentUpperLipMesh, mShapeAnimationStep, "minus");
			currentDownLipMesh = MouthANGRY.modifyDownLip(currentDownLipMesh, mShapeAnimationStep, "minus");
			break;
		case SURPRISED:
			currentUpperLipMesh = MouthSURPRISED.modifyUpperLip(currentUpperLipMesh, mShapeAnimationStep, "plus");
			currentDownLipMesh = MouthSURPRISED.modifyDownLip(currentDownLipMesh, mShapeAnimationStep, "plus");
			break;
		case SURPRISEDEND:
			currentUpperLipMesh = MouthSURPRISED.modifyUpperLip(currentUpperLipMesh, mShapeAnimationStep, "minus");
			currentDownLipMesh = MouthSURPRISED.modifyDownLip(currentDownLipMesh, mShapeAnimationStep, "minus");
			break;
			
		case HAPPY:
			currentUpperLipMesh = MouthHAPPY.modifyUpperLip(currentUpperLipMesh, mShapeAnimationStep, "plus");
			currentDownLipMesh = MouthHAPPY.modifyDownLip(currentDownLipMesh, mShapeAnimationStep, "plus");
			break;

		case HAPPYEND:
			currentUpperLipMesh = MouthHAPPY.modifyUpperLip(currentUpperLipMesh, mShapeAnimationStep, "minus");
			currentDownLipMesh = MouthHAPPY.modifyDownLip(currentDownLipMesh, mShapeAnimationStep, "minus");
			break;
		case DISGUSTED:
			currentUpperLipMesh = MouthDISGUSTED.modifyUpperLip(currentUpperLipMesh, mShapeAnimationStep, "plus");
			currentDownLipMesh = MouthDISGUSTED.modifyDownLip(currentDownLipMesh, mShapeAnimationStep, "plus");
			break;

		case DISGUSTEDEND:
			currentUpperLipMesh = MouthDISGUSTED.modifyUpperLip(currentUpperLipMesh, mShapeAnimationStep, "minus");
			currentDownLipMesh = MouthDISGUSTED.modifyDownLip(currentDownLipMesh, mShapeAnimationStep, "minus");
			break;
		case CONTEMPT:
			currentUpperLipMesh = MouthCONTEMPT.modifyUpperLip(currentUpperLipMesh, mShapeAnimationStep, "plus");
			currentDownLipMesh = MouthCONTEMPT.modifyDownLip(currentDownLipMesh, mShapeAnimationStep, "plus");
			break;

		case CONTEMPTEND:
			currentUpperLipMesh = MouthCONTEMPT.modifyUpperLip(currentUpperLipMesh, mShapeAnimationStep, "minus");
			currentDownLipMesh = MouthCONTEMPT.modifyDownLip(currentDownLipMesh, mShapeAnimationStep, "minus");
			break;

		case FEAR:
			currentUpperLipMesh = MouthFEAR.modifyUpperLip(currentUpperLipMesh, mShapeAnimationStep, "plus");
			currentDownLipMesh = MouthFEAR.modifyDownLip(currentDownLipMesh, mShapeAnimationStep, "plus");
			break;

		case FEAREND:
			currentUpperLipMesh = MouthFEAR.modifyUpperLip(currentUpperLipMesh, mShapeAnimationStep, "minus");
			currentDownLipMesh = MouthFEAR.modifyDownLip(currentDownLipMesh, mShapeAnimationStep, "minus");
			break;
		case EXCITED:
			currentUpperLipMesh = MouthEXCITED.modifyUpperLip(currentUpperLipMesh, mShapeAnimationStep, "plus");
			currentDownLipMesh = MouthEXCITED.modifyDownLip(currentDownLipMesh, mShapeAnimationStep, "plus");
			break;

		case EXCITEDEND:
			currentUpperLipMesh = MouthEXCITED.modifyUpperLip(currentUpperLipMesh, mShapeAnimationStep, "minus");
			currentDownLipMesh = MouthEXCITED.modifyDownLip(currentDownLipMesh, mShapeAnimationStep, "minus");
			break;

		case EMBARRASSED:
			currentUpperLipMesh = MouthEMBARRASSED.modifyUpperLip(currentUpperLipMesh, mShapeAnimationStep, "plus");
			currentDownLipMesh = MouthEMBARRASSED.modifyDownLip(currentDownLipMesh, mShapeAnimationStep, "plus");
			break;
		case EMBARRASSEDEND:
			currentUpperLipMesh = MouthEMBARRASSED.modifyUpperLip(currentUpperLipMesh, mShapeAnimationStep, "minus");
			currentDownLipMesh = MouthEMBARRASSED.modifyDownLip(currentDownLipMesh, mShapeAnimationStep, "minus");
			break;
		case O:
			currentUpperLipMesh = MouthO.modifyUpperLip(currentUpperLipMesh, mShapeAnimationStep, "plus");
			currentDownLipMesh = MouthO.modifyDownLip(currentDownLipMesh, mShapeAnimationStep, "plus");
			break;

		case ONE:
			currentUpperLipMesh = MouthONE.modifyUpperLip(currentUpperLipMesh, mShapeAnimationStep, "plus");
			currentDownLipMesh = MouthONE.modifyDownLip(currentDownLipMesh, mShapeAnimationStep, "plus");
		case SIX:
		case FOURTEEN:
		case NINETEEN:
			break;

		case TWO:
			currentUpperLipMesh = MouthTWO.modifyUpperLip(currentUpperLipMesh, mShapeAnimationStep, "plus");
			currentDownLipMesh = MouthTWO.modifyDownLip(currentDownLipMesh, mShapeAnimationStep, "plus");
			break;

		case THREE:
			currentUpperLipMesh = MouthTREE.modifyUpperLip(currentUpperLipMesh, mShapeAnimationStep, "plus");
			currentDownLipMesh = MouthTREE.modifyDownLip(currentDownLipMesh, mShapeAnimationStep, "plus");
		case TWENTY:
			break;

		case FOUR:
			currentUpperLipMesh = MouthFOUR.modifyUpperLip(currentUpperLipMesh, mShapeAnimationStep, "plus");
			currentDownLipMesh = MouthFOUR.modifyDownLip(currentDownLipMesh, mShapeAnimationStep, "plus");
			break;

		case FIVE:
			currentUpperLipMesh = MouthFIVE.modifyUpperLip(currentUpperLipMesh, mShapeAnimationStep, "plus");
			currentDownLipMesh = MouthFIVE.modifyDownLip(currentDownLipMesh, mShapeAnimationStep, "plus");
		case EIGHT:
			currentUpperLipMesh = MouthFIVE.modifyUpperLip(currentUpperLipMesh, mShapeAnimationStep, "plus");
			currentDownLipMesh = MouthFIVE.modifyDownLip(currentDownLipMesh, mShapeAnimationStep, "plus");
			break;

		case SEVEN:
			currentUpperLipMesh = MouthSEVEN.modifyUpperLip(currentUpperLipMesh, mShapeAnimationStep, "plus");
			currentDownLipMesh = MouthSEVEN.modifyDownLip(currentDownLipMesh, mShapeAnimationStep, "plus");
			break;

		case NINE:
			currentUpperLipMesh = MouthFOUR.modifyUpperLip(currentUpperLipMesh, mShapeAnimationStep, "plus");
			currentDownLipMesh = MouthFOUR.modifyDownLip(currentDownLipMesh, mShapeAnimationStep, "plus");
			break;

		case TEN:
			currentUpperLipMesh = MouthFOUR.modifyUpperLip(currentUpperLipMesh, mShapeAnimationStep, "plus");
			currentDownLipMesh = MouthFOUR.modifyDownLip(currentDownLipMesh, mShapeAnimationStep, "plus");
			break;

		}
		
		upperLip = new MeshView(currentUpperLipMesh);
		upperLip.setId("UpperLip");
		upperLip.setDrawMode(DrawMode.FILL);
	    mat = new PhongMaterial();
	    
	    if(mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.MALE)
	    	mat.setDiffuseColor(mColor);
	    else 
	    	mat.setDiffuseColor(mColor);
	    
	    upperLip.setMaterial(mat);
	    
	    upperLip.setTranslateX(mStart.x-14);
	    upperLip.setTranslateY(mStart.y+95);
	    upperLip.setTranslateZ(-17);
		if (step == 0) 
			mHeadFX.mHead.getChildren().add(upperLip);
		else
			mHeadFX.mHead.getChildren().set(6, upperLip);
		
		downLip = new MeshView(currentDownLipMesh);
		downLip.setId("DownLip");
		downLip.setDrawMode(DrawMode.FILL);
		downLip.setMaterial(mat);
		downLip.setTranslateX(mStart.x-14);
		downLip.setTranslateY(mStart.y+95);
		downLip.setTranslateZ(-17);
	    if (step == 0) 
			mHeadFX.mHead.getChildren().add(downLip);
		else
			mHeadFX.mHead.getChildren().set(7, downLip);
	}
	
	public void update()
	{
		mat.setDiffuseColor(mColor);
		upperLip.setMaterial(mat);
		downLip.setMaterial(mat);
	}
	protected void recordColor() {
		if (mHeadFX.mStickmanFX.setCharacterInvisible == false)
			mColorRecorder = mColor;
	}
	
	private TriangleMesh createUpperLip()
	{
		TriangleMesh tMesh = new TriangleMesh();
		tMesh.getTexCoords().addAll(0,0);
		
		tMesh.getPoints().addAll(
				//  x   y   z	
					0,	0,	0,			//Point 0
					3,	-2, 0,			//Point 1
					6,	-4,	0,			//Point 2
					9,	-5,	0,			//Point 3
					13,	-5,	0,			//Point 4
					16,	-3,	0,			//Point 5
					19,	-5,	0,			//Point 6
					23,	-5,	0,			//Point 7
					26,	-4,	0,			//Point 8
					29,	-2,	0,			//Point 9
					32,	0,	0,			//Point 10
					29,	0,	0,			//Point 11
					26,	0,	0,			//Point 12
					23,	0,	0,			//Point 13
					19,	0,	0,			//Point 14
					16,	0,	0,			//Point 15
					13,	0,	0,			//Point 16
					9,	0,	0,			//Point 17
					6,	0,	0,			//Point 18
					3,	0,	0			//Point 19
					);	
		
		tMesh.getFaces().addAll(
				0,0,	19,0,	1,0,
				1,0,	19,0,	18,0,
				18,0,	2,0,	1,0,
				2,0,	18,0,	17,0,
				17,0,	3,0,	2,0,
				3,0,	17,0,	16,0,
				16,0,	4,0,	3,0,
				4,0,	16,0,	15,0,
				15,0,	5,0,	4,0,
				5,0,	15,0,	14,0,
				14,0,	6,0,	5,0,
				6,0,	14,0,	13,0,
				13,0,	7,0,	6,0,
				7,0,	13,0,	12,0,
				12,0,	8,0,	7,0,
				8,0,	12,0,	11,0,
				11,0,	9,0,	8,0,
				11,0,	10,0,	9,0
		);
		return tMesh;
	}
	
	private TriangleMesh createDownLip()
	{
		TriangleMesh tMesh = new TriangleMesh();
		tMesh.getTexCoords().addAll(0,0);
		
		tMesh.getPoints().addAll(
				//  x   y   z	
					0,	0,	0,			//Point 0
					3,	2, 0,			//Point 1
					6,	4,	0,			//Point 2
					9,	5,	0,			//Point 3
					13,	5,	0,			//Point 4
					16,	3,	0,			//Point 5
					19,	5,	0,			//Point 6
					23,	5,	0,			//Point 7
					26,	4,	0,			//Point 8
					29,	2,	0,			//Point 9
					32,	0,	0,			//Point 10
					29,	0,	0,			//Point 11
					26,	0,	0,			//Point 12
					23,	0,	0,			//Point 13
					19,	0,	0,			//Point 14
					16,	0,	0,			//Point 15
					13,	0,	0,			//Point 16
					9,	0,	0,			//Point 17
					6,	0,	0,			//Point 18
					3,	0,	0			//Point 19
					);	
		
		tMesh.getFaces().addAll(
				0,0,	1,0,	19,0,
				1,0,	2,0,	18,0,
				18,0,	19,0,	1,0,
				2,0,	3,0,	17,0,
				17,0,	18,0,	2,0,
				3,0,	4,0,	16,0,
				16,0,	17,0,	3,0,
				4,0,	5,0,	15,0,
				15,0,	16,0,	4,0,
				5,0,	6,0,	14,0,
				14,0,	15,0,	5,0,
				6,0,	7,0,	13,0,
				13,0,	14,0,	6,0,
				7,0,	8,0,	12,0,
				12,0,	13,0,	7,0,
				8,0,	9,0,	11,0,
				11,0,	12,0,	8,0,
				9,0,	10,0,	11,0
		);
		return tMesh;
	}
}
