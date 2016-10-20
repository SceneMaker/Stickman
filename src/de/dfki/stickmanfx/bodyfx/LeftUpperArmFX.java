/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanfx.bodyfx;

import java.awt.Dimension;
import java.awt.Point;
import java.net.URL;

import javafx.application.Platform;
import javafx.geometry.Point3D;
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

import javax.swing.text.html.CSS;

import com.interactivemesh.jfx.importer.col.ColModelImporter;

import de.dfki.stickmanfx.StickmanFX;
import de.dfki.stickmanfx.animationlogic.AnimatorFX;

/**
 *
 * @author Beka
 *
 */
public class LeftUpperArmFX extends BodyPartFX {

	UpperBody mBodyFX;

	int mArmLength = 70;
	Dimension mSize = new Dimension(mArmLength, mArmLength);

	PhongMaterial material;

	Group leftUpperArmGroup;
	Cylinder leftUpperArm;
	Sphere leftUpperArmSphere;

	public LeftUpperArmFX(UpperBody bodyFX) {
		mBodyFX = bodyFX;
		
		mColor = Color.rgb(242, 227, 217, 1);
		if(mBodyFX.mNeckFX.mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.MALE)
			mDefaultRotation = -30;
		else
			mDefaultRotation = -35;
		mZRotation = mDefaultRotation;
		mToDegree = mDefaultRotation;
		mRotationStep = 0.0f;
		
		leftUpperArm = new Cylinder(5, mArmLength);
		leftUpperArmSphere = new Sphere(6);
		
		material = new PhongMaterial();
		material.setDiffuseColor(mColor);
		
		leftUpperArm.setMaterial(material);
		leftUpperArmSphere.setMaterial(material);
		
		leftUpperArmGroup = new Group();
		leftUpperArmGroup.setId("leftUpperArmGroup");
		leftUpperArmGroup.getChildren().add(leftUpperArm);
		leftUpperArmSphere.setTranslateY(39);
		leftUpperArmGroup.getChildren().add(leftUpperArmSphere);
		
		mBodyFX.mUpperBodyGroup.getChildren().add(leftUpperArmGroup);
		
		init();
	}

	@Override
	public void calculate(int step) {
		mStart = mBodyFX.getLeftArmStartPostion();
		
		Rotate rx = new Rotate(mXRotation, 0, -leftUpperArm.getHeight()/2, 0, Rotate.X_AXIS);
		Rotate ry = new Rotate(mYRotation, 0, -leftUpperArm.getHeight()/2, 0, Rotate.Y_AXIS);
		Rotate rz = new Rotate(mZRotation, 0, -leftUpperArm.getHeight()/2, 0, Rotate.Z_AXIS);
		
		if(mBodyFX.mNeckFX.mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.MALE)
		{
			leftUpperArmGroup.setTranslateX(mStart.x);
			leftUpperArmGroup.setTranslateY(mStart.y - 50);
			leftUpperArmGroup.setTranslateZ(0);
		}
		else
		{
			leftUpperArmGroup.setTranslateX(mStart.x-10);
			leftUpperArmGroup.setTranslateY(mStart.y - 57);
			leftUpperArmGroup.setTranslateZ(0);
		}
		leftUpperArmGroup.getTransforms().clear();
		leftUpperArmGroup.getTransforms().addAll(rx, ry, rz);
		
//		if (step == 0) 
//		{
//			mBodyFX.mBodyModel.getChildren().add(leftUpperArmGroup);
//		}
//		else
//			mBodyFX.mBodyModel.getChildren().set(1, leftUpperArmGroup);

		// update();
	}

	@Override
	public void update() {
		material.setDiffuseColor(mColor);
		leftUpperArm.setMaterial(material);
		// draw outlines
//		if (mLeftShoulderFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.setCharacterInvisible == false)
//			mColorRecorder = mColor;
//		if (mLeftShoulderFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.setCharacterInvisible == true) {
//			if (mLeftShoulderFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.fadeControler == true) {
//				int fadeFactor = mLeftShoulderFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.mMouthFX.mShapeAnimationStep * 12;
//				if (fadeFactor <= 24) {
//					fadeFactor = 0;
//				}
//				mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(),
//						(fadeFactor * 100 / 255) / 100f);
//			} else {
//				int fadeFactor = (20 - mLeftShoulderFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.mMouthFX.mShapeAnimationStep)
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
