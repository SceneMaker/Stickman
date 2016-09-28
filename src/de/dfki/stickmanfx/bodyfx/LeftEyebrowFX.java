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

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.scene.paint.Color;
import javafx.scene.shape.MeshView;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.QuadCurveTo;
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
		DEFAULT, ANGRY, ANGRYEND, DISGUSTED, DISGUSTEDEND, SURPRISED, SURPRISEDEND, EXCITED, EXCITEDEND, EMBARRASSED, EMBARRASSEDEND
	};

	HeadFX mHeadFX;

	URL url;
	ColModelImporter imorter;
	MeshView defaultLeftBrow;
	MeshView angryLeftBrow;
	MeshView disgustedLeftBrow;
	
	int mZTranslate = -120;

	public LeftEyebrowFX.SHAPE mShape = LeftEyebrowFX.SHAPE.DEFAULT;

	public LeftEyebrowFX(HeadFX head) 
	{
		mHeadFX = head;
		mSize = new Dimension(mLength, mLength);
		
		imorter = new ColModelImporter();

		mColor = Color.rgb(0, 0, 0, (64 * 100 / 255) / 100f);
		
		url = getClass().getClassLoader().getResource("BodyParts/LeftBrow/defaultLeftBrow.dae");
		imorter.read(url);
		defaultLeftBrow = (MeshView) imorter.getImport()[0];
		
		url = getClass().getClassLoader().getResource("BodyParts/LeftBrow/angryleftBrow.dae");
		imorter.read(url);
		angryLeftBrow = (MeshView) imorter.getImport()[0];
		
		url = getClass().getClassLoader().getResource("BodyParts/LeftBrow/disgustedleftBrow.dae");
		imorter.read(url);
		disgustedLeftBrow = (MeshView) imorter.getImport()[0];
		
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
	public void createShape() {
		mStart = mHeadFX.getLeftEyebrowPostion();
		
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
			
			defaultLeftBrow.setTranslateX(mStart.x);
			defaultLeftBrow.setTranslateY(mStart.y);

			if (!mHeadFX.mHead.getChildren().get(2).equals(defaultLeftBrow)) {
				mHeadFX.mHead.getChildren().set(2, defaultLeftBrow);
			}
			
			break;

		case ANGRY:
			
			angryLeftBrow.setTranslateX(mStart.x);
			angryLeftBrow.setTranslateY(mStart.y);

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

		case DISGUSTEDEND:
			break;

		case SURPRISED:
			break;

		case SURPRISEDEND:
			break;

		case EXCITED:
			break;

		case EXCITEDEND:
			break;

		case EMBARRASSED:
			break;

		case EMBARRASSEDEND:
			break;
		}
	}

	protected void recordColor() {
		if (mHeadFX.mStickmanFX.setCharacterInvisible == false)
			mColorRecorder = mColor;
	}
}
