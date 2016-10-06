/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanfx.bodyfx;

import de.dfki.stickmanfx.animationlogic.AnimatorFX;
import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.Point;
import java.net.URL;

import com.interactivemesh.jfx.importer.col.ColModelImporter;
import com.interactivemesh.jfx.importer.stl.StlMeshImporter;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.DrawMode;
import javafx.scene.shape.MeshView;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.QuadCurveTo;
import javafx.scene.shape.TriangleMesh;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

/**
 *
 * @author Beka Aptsiauri
 *
 */
public class LeftEyebrowFX extends BodyPartFX 
{
	public static enum SHAPE 
	{
		DEFAULT, ANGRY, ANGRYEND, HAPPY, DISGUSTED, DISGUSTEDEND, SURPRISED, SURPRISEDEND, EXCITED, EXCITEDEND, EMBARRASSED, EMBARRASSEDEND
	};

	HeadFX mHeadFX;
	
	private float angryXMovement;
	TriangleMesh currentMesh;

	URL url;
	ColModelImporter imorter;
	
	StlMeshImporter stlImporter;
	TriangleMesh defaultLeftBrowTriangleMesh;
	MeshView defaultLeftBrow;
	
	TriangleMesh angryLeftBrowTriangleMesh;
	MeshView angryLeftBrow;
	
	MeshView disgustedLeftBrow;
	MeshView surprisedLeftBrow;
	MeshView embarrassedLeftBrow;
	MeshView happyLeftBrow;
	
	int mZTranslate = -120;

	public LeftEyebrowFX.SHAPE mShape = LeftEyebrowFX.SHAPE.DEFAULT;

	public LeftEyebrowFX(HeadFX head) 
	{
		mHeadFX = head;
		mSize = new Dimension(mLength, mLength);
		
		imorter = new ColModelImporter();
		stlImporter = new StlMeshImporter();

		mColor = Color.rgb(0, 0, 0, (64 * 100 / 255) / 100f);
		
		url = getClass().getClassLoader().getResource("BodyParts/LeftBrow/defaultLeftBrow.stl");
		stlImporter.read(url);
		defaultLeftBrowTriangleMesh = stlImporter.getImport();
		
		url = getClass().getClassLoader().getResource("BodyParts/LeftBrow/defaultLeftBrow.stl");
		stlImporter.read(url);
		currentMesh = stlImporter.getImport();
		
		url = getClass().getClassLoader().getResource("BodyParts/LeftBrow/angryleftBrow.stl");
		stlImporter.read(url);
		angryLeftBrowTriangleMesh = stlImporter.getImport();
		
		url = getClass().getClassLoader().getResource("BodyParts/LeftBrow/disgustedleftBrow.dae");
		imorter.read(url);
		disgustedLeftBrow = (MeshView) imorter.getImport()[0];
		
		url = getClass().getClassLoader().getResource("BodyParts/LeftBrow/surprisedleftBrow.dae");
		imorter.read(url);
		surprisedLeftBrow = (MeshView) imorter.getImport()[0];
		
		url = getClass().getClassLoader().getResource("BodyParts/LeftBrow/embarrassedleftBrow.dae");
		imorter.read(url);
		embarrassedLeftBrow = (MeshView) imorter.getImport()[0];
		
		url = getClass().getClassLoader().getResource("BodyParts/LeftBrow/happyleftBrow.dae");
		imorter.read(url);
		happyLeftBrow = (MeshView) imorter.getImport()[0];
		
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
		
		float xmovement_1;
		float xmovement_2;
		float ymovement_1;
		float ymovement_2;
		float ymovement_3;
		PhongMaterial mat;
		
		clearChildren(this);

		switch (mShape) 
		{
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
			
			currentMesh = new TriangleMesh();
			currentMesh.getTexCoords().addAll(0,0);
			
			currentMesh.getPoints().addAll(
					0,	0,	0,			//Point 0
					0,	-3,	0,			//Point 1
					0,	-3,	3,			//Point 2
					0,	0,	3,			//Point 3 ------->11
					
					6,	-5,	0,			//Point 4
					6,	-8,	0,			//Point 5
					6,	-8,	3,			//Point 6
					6,	-5, 3,			//Point 7 -------->23
					
					20,	-7,	 0,			//Point 8
					20,	-11, 0,		    //Point 9
					20,	-11, 3,		    //Point 10
					20,	-7,	3,			//Point 11 -------->35
					 
					30, 	0,	0,		//Point 12
					30,	-3,	0,			//Point 13
					30,	-3,	3,			//Point 14
					30, 	0,	3		//Point 15
					);
			
			currentMesh.getFaces().addAll(
					0,0,	1,0,	2,0,
					2,0,	3,0,	0,0,
					
					0,0,	4,0,	5,0,
					5,0,	1,0,	0,0,
					
					0,0,	3,0,	7,0,
					7,0,	4,0,	0,0,
					
					3,0,	7,0,	6,0,
					6,0,	2,0,	3,0,
					
					2,0,	6,0,	5,0,
					5,0,	1,0,	2,0,
					
					1,0,	0,0,	4,0,
					4,0,	5,0,	1,0,
					
					7,0,	11,0,	8,0,
					8,0,	4,0,	7,0,
					
					7,0,	11,0,	10,0,
					10,0,	6,0,	7,0,
					
					6,0,	10,0,	9,0,
					9,0,	5,0,	6,0,
					
					4,0,	8,0,	9,0,
					9,0,	5,0,	4,0,
					
					11,0,	15,0,	12,0,
					12,0,	8,0,	11,0,
					
					11,0,	15,0,	14,0,
					14,0,	10,0,	11,0,
					
					10,0,	14,0,	13,0,
					13,0,	9,0,	10,0,
					
					8,0,	12,0,	13,0,
					13,0,	9,0,	8,0
					);
			
			angryLeftBrow = new MeshView(currentMesh);
			angryLeftBrow.setDrawMode(DrawMode.FILL);
		    mat = new PhongMaterial();
		    mat.setDiffuseColor(Color.BLACK);
			angryLeftBrow.setMaterial(mat);
			
			angryLeftBrow.setTranslateX(mStart.x + 9);
			angryLeftBrow.setTranslateY(mStart.y + 23);
			angryLeftBrow.setTranslateZ(-17);

			if (!mHeadFX.mHead.getChildren().get(2).equals(angryLeftBrow)) {
				mHeadFX.mHead.getChildren().set(2, angryLeftBrow);
			}

			
			break;

		case ANGRY:
			xmovement_2 = (AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0421f;
			ymovement_1 = (AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0158f;
			ymovement_3 = (AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0105f;
			
			//Block 1
			currentMesh.getPoints().set(1, currentMesh.getPoints().get(1) + ymovement_1);
			currentMesh.getPoints().set(4, currentMesh.getPoints().get(4) + ymovement_1);
			currentMesh.getPoints().set(7, currentMesh.getPoints().get(7) + ymovement_1);
			currentMesh.getPoints().set(10, currentMesh.getPoints().get(10) + ymovement_1);
			
			//Block 2
			currentMesh.getPoints().set(12, currentMesh.getPoints().get(12) + xmovement_2);
			currentMesh.getPoints().set(15, currentMesh.getPoints().get(15) + xmovement_2);
			currentMesh.getPoints().set(18, currentMesh.getPoints().get(18) + xmovement_2);
			currentMesh.getPoints().set(21, currentMesh.getPoints().get(21) + xmovement_2);
			
			//Block 3
			currentMesh.getPoints().set(25, currentMesh.getPoints().get(25) + ymovement_3);
			currentMesh.getPoints().set(28, currentMesh.getPoints().get(28) + ymovement_3);
			currentMesh.getPoints().set(31, currentMesh.getPoints().get(31) + ymovement_3);
			currentMesh.getPoints().set(34, currentMesh.getPoints().get(34) + ymovement_3);
			
			angryLeftBrow = new MeshView(currentMesh);
			angryLeftBrow.setDrawMode(DrawMode.FILL);
			
			mat = new PhongMaterial();
			mat.setDiffuseColor(Color.BLACK);
			angryLeftBrow.setMaterial(mat);
			
			angryLeftBrow.setTranslateX(mStart.x + 9);
			angryLeftBrow.setTranslateY(mStart.y + 23);
			angryLeftBrow.setTranslateZ(-17);

			if (!mHeadFX.mHead.getChildren().get(2).equals(angryLeftBrow)) {
				mHeadFX.mHead.getChildren().set(2, angryLeftBrow);
			}
			break;
		case ANGRYEND:
			xmovement_2 = (AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0421f;
			ymovement_1 = (AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0158f;
			ymovement_3 = (AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) * 0.0105f;
			
			//Block 1
			currentMesh.getPoints().set(1, currentMesh.getPoints().get(1) - ymovement_1);
			currentMesh.getPoints().set(4, currentMesh.getPoints().get(4) - ymovement_1);
			currentMesh.getPoints().set(7, currentMesh.getPoints().get(7) - ymovement_1);
			currentMesh.getPoints().set(10, currentMesh.getPoints().get(10) - ymovement_1);
			
			//Block 2
			currentMesh.getPoints().set(12, currentMesh.getPoints().get(12) - xmovement_2);
			currentMesh.getPoints().set(15, currentMesh.getPoints().get(15) - xmovement_2);
			currentMesh.getPoints().set(18, currentMesh.getPoints().get(18) - xmovement_2);
			currentMesh.getPoints().set(21, currentMesh.getPoints().get(21) - xmovement_2);
			
			//Block 3
			currentMesh.getPoints().set(25, currentMesh.getPoints().get(25) - ymovement_3);
			currentMesh.getPoints().set(28, currentMesh.getPoints().get(28) - ymovement_3);
			currentMesh.getPoints().set(31, currentMesh.getPoints().get(31) - ymovement_3);
			currentMesh.getPoints().set(34, currentMesh.getPoints().get(34) - ymovement_3);
			
			angryLeftBrow = new MeshView(currentMesh);
			angryLeftBrow.setDrawMode(DrawMode.FILL);
			
			mat = new PhongMaterial();
			mat.setDiffuseColor(Color.BLACK);
			angryLeftBrow.setMaterial(mat);
			
			angryLeftBrow.setTranslateX(mStart.x + 9);
			angryLeftBrow.setTranslateY(mStart.y + 23);
			angryLeftBrow.setTranslateZ(-17);

			if (!mHeadFX.mHead.getChildren().get(2).equals(angryLeftBrow)) {
				mHeadFX.mHead.getChildren().set(2, angryLeftBrow);
			}
			break;

		case DISGUSTED:
			disgustedLeftBrow.setTranslateX(mStart.x);
			disgustedLeftBrow.setTranslateY(mStart.y);

			if (!mHeadFX.mHead.getChildren().get(2).equals(disgustedLeftBrow)) {
				mHeadFX.mHead.getChildren().set(2, disgustedLeftBrow);
			}
			break;

		case SURPRISED:
			surprisedLeftBrow.setTranslateX(mStart.x);
			surprisedLeftBrow.setTranslateY(mStart.y);

			if (!mHeadFX.mHead.getChildren().get(2).equals(surprisedLeftBrow)) {
				mHeadFX.mHead.getChildren().set(2, surprisedLeftBrow);
			}
			break;

		case EXCITED:
			break;

		case EMBARRASSED:
			embarrassedLeftBrow.setTranslateX(mStart.x);
			embarrassedLeftBrow.setTranslateY(mStart.y);

			if (!mHeadFX.mHead.getChildren().get(2).equals(embarrassedLeftBrow)) {
				mHeadFX.mHead.getChildren().set(2, embarrassedLeftBrow);
			}
			break;

		case EMBARRASSEDEND:
			break;
			
		case HAPPY:
			happyLeftBrow.setTranslateX(mStart.x);
			happyLeftBrow.setTranslateY(mStart.y);

			if (!mHeadFX.mHead.getChildren().get(2).equals(happyLeftBrow)) {
				mHeadFX.mHead.getChildren().set(2, happyLeftBrow);
			}
			break;
		}
	}

	protected void recordColor() {
		if (mHeadFX.mStickmanFX.setCharacterInvisible == false)
			mColorRecorder = mColor;
	}
}
