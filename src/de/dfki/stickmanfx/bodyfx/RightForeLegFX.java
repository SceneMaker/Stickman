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

	URL url;
	ColModelImporter imorter;
	MeshView mRightForeLegMesh;
	PhongMaterial material;

	Group rightForeLegGroup;

	public RightForeLegFX(RightUpperLegFX rightUpperLegFX) {
		mUpperLegFX = rightUpperLegFX;

		mDefaultRotation = -2;
		mXRotation = mDefaultRotation;
		mToDegreeX = mDefaultRotation;
		
		if(mUpperLegFX.mDownBody.mUpperBody.mNeckFX.mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.MALE)
		{
			mLegLength = 90;
			url = getClass().getClassLoader().getResource("BodyParts/MaleForeLeg.dae");
		}
		else
		{
			mLegLength = 80;
			url = getClass().getClassLoader().getResource("BodyParts/FemaleForeLeg.dae");
		}
		
		imorter = new ColModelImporter();
		mColor = Color.rgb(242, 227, 217, 1);
		
		imorter.read(url);
		mRightForeLegMesh = (MeshView) imorter.getImport()[0];
		
		material = new PhongMaterial();
		material.setDiffuseColor(mColor);
		mRightForeLegMesh.setMaterial(material);
		
		rightForeLegGroup = new Group();
		rightForeLegGroup.setId("rightForeLegGroup");
		rightForeLegGroup.getChildren().add(mRightForeLegMesh);
		
		mUpperLegFX.rightUpperLegGroup.getChildren().add(rightForeLegGroup);
        
        init();
	}

	@Override
	public void calculate(int step) {

		Rotate rx = new Rotate(mXRotation,  Rotate.X_AXIS);
		Rotate ry = new Rotate(mYRotation,  Rotate.Y_AXIS);
		Rotate rz = new Rotate(mZRotation,  Rotate.Z_AXIS);
		
		if(mUpperLegFX.mDownBody.mUpperBody.mNeckFX.mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.MALE)
		{
			rightForeLegGroup.setTranslateX(mStart.x);
			rightForeLegGroup.setTranslateY(mStart.y+59);
			rightForeLegGroup.setTranslateZ(0);
		}
		else
		{
			rightForeLegGroup.setTranslateX(mStart.x);
			rightForeLegGroup.setTranslateY(mStart.y + 49);
			rightForeLegGroup.setTranslateZ(0);
		}
		
		rightForeLegGroup.getTransforms().clear();
		rightForeLegGroup.getTransforms().addAll(rx, ry, rz);
		// this.update();
	}

	@Override
	public void update() {
		material.setDiffuseColor(mColor);
		mRightForeLegMesh.setMaterial(material);
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
