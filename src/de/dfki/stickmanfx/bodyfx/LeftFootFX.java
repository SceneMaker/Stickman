/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanfx.bodyfx;

import de.dfki.stickman.body.*;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.geom.GeneralPath;
import java.net.URL;

import com.interactivemesh.jfx.importer.col.ColModelImporter;

import javafx.scene.paint.Color;
import javafx.scene.shape.MeshView;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.QuadCurveTo;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.shape.StrokeLineJoin;
import javafx.scene.transform.Affine;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;
import javafx.scene.transform.Translate;

/**
 *
 * @author Beka
 *
 */
public class LeftFootFX extends BodyPartFX {

	LeftForeLegFX mLeftForeLegFX;

	MeshView leftFoot;

	public LeftFootFX(LeftForeLegFX leftForeLeg) {
		mLeftForeLegFX = leftForeLeg;
		mLength = 10;
		mColor = Color.rgb(80, 80, 80);
		setDefaulRotation(0);

		leftFoot = (MeshView) mLeftForeLegFX.leftForeLeg.getChildren().get(1);

		mYRotation = -135;
		mXRotation = 10;

		init();

		calculate(0);
	}

	@Override
	public void calculate(int step) {

		Rotate rx = new Rotate(mXRotation, Rotate.X_AXIS);
		Rotate ry = new Rotate(mYRotation, Rotate.Y_AXIS);
		Rotate rz = new Rotate(mZRotation, Rotate.Z_AXIS);

		Translate translate = (Translate) leftFoot.getTransforms().get(0);
		Scale scale = (Scale) leftFoot.getTransforms().get(4);
		leftFoot.getTransforms().clear();
		leftFoot.getTransforms().addAll(translate, rx, ry, rz, scale);

		// this.update();
	}

	@Override
	public void update() {
		if (mLeftForeLegFX.mUpperLegFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.setCharacterInvisible == false)
			mColorRecorder = mColor;

		if (mLeftForeLegFX.mUpperLegFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.setCharacterInvisible == true) {
			if (mLeftForeLegFX.mUpperLegFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.fadeControler == true) // Added
																										// by
																										// Robbie
			{
				int fadeFactor = mLeftForeLegFX.mUpperLegFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.mMouthFX.mShapeAnimationStep
						* 12;
				if (fadeFactor <= 24) {
					fadeFactor = 0;
				}
				mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(),
						(fadeFactor * 100 / 255) / 100f);
				// mColor = Color.rgb(80, 80, 80, (fadeFactor*100/255)/100f);
			} else {
				int fadeFactor = (20
						- mLeftForeLegFX.mUpperLegFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.mMouthFX.mShapeAnimationStep)
						* 12;
				if (fadeFactor >= 216) {
					mColor = mColorRecorder;
				} else
					mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(),
							(fadeFactor * 100 / 255) / 100f);
				// mColor = Color.rgb(80, 80, 80, (fadeFactor*100/255)/100f);
			}
		}
	}
}
