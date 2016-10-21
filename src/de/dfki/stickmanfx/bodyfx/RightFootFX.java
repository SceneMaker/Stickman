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

	MeshView mRightFootMeshView;
	PhongMaterial material;
	
	URL url;
	ColModelImporter im;

	public RightFootFX(RightForeLegFX rightForeLeg) {
		mRightForeLegFX = rightForeLeg;
		mLength = 20;
		if(mRightForeLegFX.mUpperLegFX.mDownBody.mUpperBody.mNeckFX.mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.MALE)
			mColor = Color.rgb(80, 80, 80, 1);
		else
			mColor = Color.rgb(154, 83, 198, 1);
		setDefaulRotation(0);
		mYRotation = 130;
		mXRotation = 0;

		url = getClass().getClassLoader().getResource("BodyParts/foot.dae");
		im = new ColModelImporter();
		im.read(url);
		mRightFootMeshView = (MeshView) im.getImport()[0];
		
		mRightFootMeshView.setId("mRightFootMeshView");
		material = new PhongMaterial();
		material.setDiffuseColor(mColor.darker());
		mRightFootMeshView.setMaterial(material);
		
		mRightForeLegFX.rightForeLegGroup.getChildren().add(mRightFootMeshView);
        
        init();
	}

	@Override
	public void calculate(int step) {

		Rotate rx = new Rotate(mXRotation, 	Rotate.X_AXIS);
		Rotate ry = new Rotate(mYRotation,  Rotate.Y_AXIS);
		Rotate rz = new Rotate(mZRotation,  Rotate.Z_AXIS);
		
		if(mRightForeLegFX.mUpperLegFX.mDownBody.mUpperBody.mNeckFX.mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.MALE)
		{
			mRightFootMeshView.setTranslateX(mStart.x);
			mRightFootMeshView.setTranslateY(mStart.y+90);
			mRightFootMeshView.setTranslateZ(0);
		}
		else
		{
			mRightFootMeshView.setTranslateX(mStart.x);
			mRightFootMeshView.setTranslateY(mStart.y + 80);
			mRightFootMeshView.setTranslateZ(0);
		}
		
		mRightFootMeshView.getTransforms().clear();
		mRightFootMeshView.getTransforms().addAll(rx, ry, rz);
		
		// this.update();
	}

	@Override
	public void update() {
		material.setDiffuseColor(mColor);
		mRightFootMeshView.setMaterial(material);
//		if (mRightForeLegFX.mUpperLegFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.setCharacterInvisible == false)
//			mColorRecorder = mColor;
//		if (mRightForeLegFX.mUpperLegFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.setCharacterInvisible == true) {
//			if (mRightForeLegFX.mUpperLegFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.fadeControler == true) // Added
//																										// by
//																										// Robbie
//			{
//				int fadeFactor = mRightForeLegFX.mUpperLegFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.mMouthFX.mShapeAnimationStep
//						* 12;
//				if (fadeFactor <= 24) {
//					fadeFactor = 0;
//				}
//				mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(),
//						(fadeFactor * 100 / 255) / 100f);
//			} else {
//				int fadeFactor = (20
//						- mRightForeLegFX.mUpperLegFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.mMouthFX.mShapeAnimationStep)
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
