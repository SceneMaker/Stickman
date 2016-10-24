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
public class LeftUpperLegFX extends BodyPartFX {
	DownBody mDownBody;

	URL url;
	ColModelImporter imorter;
	MeshView mLeftUpperLegMesh;
	PhongMaterial material;

	Group leftUpperLegGroup;

	public LeftUpperLegFX(DownBody downBody) {
		mDownBody = downBody;
		if(mDownBody.mUpperBody.mNeckFX.mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.MALE)
		{
			mLength = 60;
			url = getClass().getClassLoader().getResource("BodyParts/MaleUpperLeg.dae");
		}
		else
		{
			mLength = 50;
			url = getClass().getClassLoader().getResource("BodyParts/FemaleUpperLeg.dae");
		}
		
		imorter = new ColModelImporter();
		mSize = new Dimension(10, mLength);
		mColor = Color.rgb(242, 227, 217, 1);

		mDefaultRotation = 0;
		mXRotation = mDefaultRotation;
		mToDegreeX = mDefaultRotation;
		mXRotationStep = 0.0f;
		
		imorter.read(url);
		mLeftUpperLegMesh = (MeshView) imorter.getImport()[0];
		
		material = new PhongMaterial();
		material.setDiffuseColor(mColor);
		mLeftUpperLegMesh.setMaterial(material);
		
		leftUpperLegGroup = new Group();
		leftUpperLegGroup.setId("leftUpperLegGroup");
		leftUpperLegGroup.getChildren().add(mLeftUpperLegMesh);
		
		mDownBody.mDownBodyGroup.getChildren().add(leftUpperLegGroup);
		
		init();
	}


	@Override
	public void calculate(int step) {
		mStart = mDownBody.mUpperBody.getLeftLegStartPostion();
		
		Rotate rx = new Rotate(mXRotation,  Rotate.X_AXIS);
		Rotate ry = new Rotate(mYRotation,  Rotate.Y_AXIS);
		Rotate rz = new Rotate(mZRotation,  Rotate.Z_AXIS);
		
		if(mDownBody.mUpperBody.mNeckFX.mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.MALE)
		{
			leftUpperLegGroup.setTranslateX(mStart.x - 58);
			leftUpperLegGroup.setTranslateY(mStart.y - 256);
			leftUpperLegGroup.setTranslateZ(0);
		}
		else
		{
			leftUpperLegGroup.setTranslateX(mStart.x-60);
			leftUpperLegGroup.setTranslateY(mStart.y - 243);
			leftUpperLegGroup.setTranslateZ(0);
		}
		leftUpperLegGroup.getTransforms().clear();
		leftUpperLegGroup.getTransforms().addAll(rx, ry, rz);
	}

	@Override
	public void update() {
		material.setDiffuseColor(mColor);
		mLeftUpperLegMesh.setMaterial(material);
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
