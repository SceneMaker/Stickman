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
import javafx.scene.shape.Sphere;
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
public class RightUpperLegFX extends BodyPartFX {

	BodyFX mBodyFX;

	PhongMaterial material;

	Group rightUpperLegGroup;
	Cylinder rightUpperLeg;
	Sphere rightUpperLegSphere;

	public RightUpperLegFX(BodyFX body) {
		mBodyFX = body;
		if(mBodyFX.mNeckFX.mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.MALE)
			mLength = 60;
		else
			mLength = 51;
		
		mSize = new Dimension(10, mLength);
		mColor = Color.rgb(242, 227, 217, 1);

		mDefaultRotation = 0;
		mXRotation = mDefaultRotation;
		mToDegree = mDefaultRotation;
		mRotationStep = 0.0f;
		
		rightUpperLeg = new Cylinder(7, mLength);
		rightUpperLegSphere = new Sphere(8);
		
		material = new PhongMaterial();
		material.setDiffuseColor(mColor);
		
		rightUpperLeg.setMaterial(material);
		rightUpperLegSphere.setMaterial(material);
		
		rightUpperLegGroup = new Group();
		rightUpperLegGroup.setId("rightUpperLegGroup");
		rightUpperLegGroup.getChildren().add(rightUpperLeg);
		if(mBodyFX.mNeckFX.mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.MALE)
			rightUpperLegSphere.setTranslateY(34);
		else
			rightUpperLegSphere.setTranslateY(28);
		rightUpperLegGroup.getChildren().add(rightUpperLegSphere);
		
		mBodyFX.mBodyModel.getChildren().add(rightUpperLegGroup);
		
		init();

	}

	@Override
	public void calculate(int step) {
		mStart = mBodyFX.getRightLegStartPostion();
		
		Rotate rx = new Rotate(mXRotation, 0, -rightUpperLeg.getHeight()/2, 0, Rotate.X_AXIS);
		Rotate ry = new Rotate(mYRotation, 0, -rightUpperLeg.getHeight()/2, 0, Rotate.Y_AXIS);
		Rotate rz = new Rotate(mZRotation, 0, -rightUpperLeg.getHeight()/2, 0, Rotate.Z_AXIS);
		
		if(mBodyFX.mNeckFX.mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.MALE)
		{
			rightUpperLegGroup.setTranslateX(mStart.x - 70);
			rightUpperLegGroup.setTranslateY(mStart.y - 176);
			rightUpperLegGroup.setTranslateZ(-53);
		}
		else
		{
			rightUpperLegGroup.setTranslateX(mStart.x-70);
			rightUpperLegGroup.setTranslateY(mStart.y - 181);
			rightUpperLegGroup.setTranslateZ(-40);
		}
		rightUpperLegGroup.getTransforms().clear();
		rightUpperLegGroup.getTransforms().addAll(rx, ry, rz);

		// this.update();
	}

	@Override
	public void update() {
		material.setDiffuseColor(mColor);
		rightUpperLeg.setMaterial(material);
//		if (mBodyFX.mNeckFX.mHeadFX.mStickmanFX.setCharacterInvisible == false)
//			mColorRecorder = mColor;
//		if (mBodyFX.mNeckFX.mHeadFX.mStickmanFX.setCharacterInvisible == true) {
//			if (mBodyFX.mNeckFX.mHeadFX.mStickmanFX.fadeControler == true) // Added
//																			// by
//																			// Robbie
//			{
//				int fadeFactor = mBodyFX.mNeckFX.mHeadFX.mStickmanFX.mMouthFX.mShapeAnimationStep * 12;
//				if (fadeFactor <= 24) {
//					fadeFactor = 0;
//				}
//				mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(),
//						(fadeFactor * 100 / 255) / 100f);
//			} else {
//				int fadeFactor = (20 - mBodyFX.mNeckFX.mHeadFX.mStickmanFX.mMouthFX.mShapeAnimationStep) * 12;
//				if (fadeFactor >= 216) {
//					mColor = mColorRecorder;
//				} else
//					mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(),
//							(fadeFactor * 100 / 255) / 100f);
//			}
//		}
	}
}
