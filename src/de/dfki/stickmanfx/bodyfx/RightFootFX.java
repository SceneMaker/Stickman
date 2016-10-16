/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanfx.bodyfx;

import de.dfki.stickman.body.*;
import de.dfki.stickmanfx.StickmanFX;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.geom.GeneralPath;
import java.net.URL;

import com.interactivemesh.jfx.importer.col.ColModelImporter;

import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Cylinder;
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
public class RightFootFX extends BodyPartFX {

	RightForeLegFX mRightForeLegFX;

	PhongMaterial material;

	Cylinder rightFoot;

	public RightFootFX(RightForeLegFX rightForeLeg) {
		mRightForeLegFX = rightForeLeg;
		mLength = 20;
		mColor = Color.rgb(242, 227, 217, 1);
		setDefaulRotation(0);
		mXRotation = 170;
		mZRotation = 5;

		rightFoot = new Cylinder(7, mLength);
        
        material = new PhongMaterial();
		material.setDiffuseColor(mColor);
		
		rightFoot.setMaterial(material);
		
		rightFoot.setRotationAxis(Rotate.Z_AXIS);
		rightFoot.setRotate(90);
		
		mRightForeLegFX.rightForeLegGroup.getChildren().add(rightFoot);
        
        init();
	}

	@Override
	public void calculate(int step) {

		Rotate rx = new Rotate(mXRotation, 0, rightFoot.getHeight()/2, 0, Rotate.X_AXIS);
		Rotate ry = new Rotate(mYRotation, 0, rightFoot.getHeight()/2, 0,  Rotate.Y_AXIS);
		Rotate rz = new Rotate(mZRotation, 0, rightFoot.getHeight()/2, 0,  Rotate.Z_AXIS);
		
		if(mRightForeLegFX.mUpperLegFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.MALE)
		{
			rightFoot.setTranslateX(mStart.x+10);
			rightFoot.setTranslateY(mStart.y+38);
			rightFoot.setTranslateZ(0);
		}
		else
		{
			rightFoot.setTranslateX(mStart.x + 10);
			rightFoot.setTranslateY(mStart.y + 34);
			rightFoot.setTranslateZ(0);
		}
		
		rightFoot.getTransforms().clear();
		rightFoot.getTransforms().addAll(rx, ry, rz);
		
		// this.update();
	}

	@Override
	public void update() {
		if (mRightForeLegFX.mUpperLegFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.setCharacterInvisible == false)
			mColorRecorder = mColor;
		if (mRightForeLegFX.mUpperLegFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.setCharacterInvisible == true) {
			if (mRightForeLegFX.mUpperLegFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.fadeControler == true) // Added
																										// by
																										// Robbie
			{
				int fadeFactor = mRightForeLegFX.mUpperLegFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.mMouthFX.mShapeAnimationStep
						* 12;
				if (fadeFactor <= 24) {
					fadeFactor = 0;
				}
				mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(),
						(fadeFactor * 100 / 255) / 100f);
			} else {
				int fadeFactor = (20
						- mRightForeLegFX.mUpperLegFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.mMouthFX.mShapeAnimationStep)
						* 12;
				if (fadeFactor >= 216) {
					mColor = mColorRecorder;
				} else
					mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(),
							(fadeFactor * 100 / 255) / 100f);
			}
		}
	}
}
