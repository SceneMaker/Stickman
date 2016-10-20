/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanfx.bodyfx;

import de.dfki.stickman.body.*;
import de.dfki.stickmanfx.StickmanFX;
import de.dfki.stickmanfx.animationlogic.AnimatorFX;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.geom.GeneralPath;
import java.net.URL;

import com.interactivemesh.jfx.importer.col.ColModelImporter;

import javafx.scene.Group;
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
public class RightForeLegFX extends BodyPartFX {

	RightUpperLegFX mUpperLegFX;
	int mLegLength = 90;
	Dimension mSize = new Dimension(10, mLegLength);

	PhongMaterial material;

	Group rightForeLegGroup;
	Cylinder rightForeLeg;

	public RightForeLegFX(RightUpperLegFX rightUpperLegFX) {
		mUpperLegFX = rightUpperLegFX;

		mDefaultRotation = -2;
		mXRotation = mDefaultRotation;
		mToDegree = mDefaultRotation;
		mColor = Color.rgb(242, 227, 217, 1);
		if(mUpperLegFX.mDownBody.mUpperBody.mNeckFX.mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.MALE)
			mLegLength = 90;
		else
			mLegLength = 80;
		
		rightForeLeg = new Cylinder(7, mLegLength);
        
		rightForeLegGroup = new Group();
		rightForeLegGroup.setId("rightForeLegGroup");
		rightForeLegGroup.getChildren().add(rightForeLeg);
        
        material = new PhongMaterial();
		material.setDiffuseColor(mColor);
		
		rightForeLeg.setMaterial(material);
		
		mUpperLegFX.rightUpperLegGroup.getChildren().add(rightForeLegGroup);
        
        init();
	}

	@Override
	public void calculate(int step) {

		Rotate rx = new Rotate(mXRotation, 0, -rightForeLeg.getHeight()/2, 0, Rotate.X_AXIS);
		Rotate ry = new Rotate(mYRotation, 0, -rightForeLeg.getHeight()/2, 0, Rotate.Y_AXIS);
		Rotate rz = new Rotate(mZRotation, 0, -rightForeLeg.getHeight()/2, 0, Rotate.Z_AXIS);
		
		if(mUpperLegFX.mDownBody.mUpperBody.mNeckFX.mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.MALE)
		{
			rightForeLegGroup.setTranslateX(mStart.x);
			rightForeLegGroup.setTranslateY(mStart.y+81);
			rightForeLegGroup.setTranslateZ(0);
		}
		else
		{
			rightForeLegGroup.setTranslateX(mStart.x);
			rightForeLegGroup.setTranslateY(mStart.y + 70);
			rightForeLegGroup.setTranslateZ(0);
		}
		
		rightForeLegGroup.getTransforms().clear();
		rightForeLegGroup.getTransforms().addAll(rx, ry, rz);
		// this.update();
	}

	@Override
	public void update() {
		material.setDiffuseColor(mColor);
		rightForeLeg.setMaterial(material);
//		if (mUpperLegFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.setCharacterInvisible == false)
//			mColorRecorder = mColor;
//		if (mUpperLegFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.setCharacterInvisible == true) {
//			if (mUpperLegFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.fadeControler == true) // Added
//																						// by
//																						// Robbie
//			{
//				int fadeFactor = mUpperLegFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.mMouthFX.mShapeAnimationStep * 12;
//				if (fadeFactor <= 24) {
//					fadeFactor = 0;
//				}
//				mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(),
//						(fadeFactor * 100 / 255) / 100f);
//			} else {
//				int fadeFactor = (20 - mUpperLegFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.mMouthFX.mShapeAnimationStep)
//						* 12;
//				if (fadeFactor >= 216) {
//					mColor = mColorRecorder;
//				} else
//					mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(),
//							(fadeFactor * 100 / 255) / 100f);
//			}
//		}
	}
}
