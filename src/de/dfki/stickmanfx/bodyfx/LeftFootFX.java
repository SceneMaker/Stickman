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
import com.interactivemesh.jfx.importer.stl.StlMeshImporter;

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
import javafx.scene.shape.TriangleMesh;
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

	MeshView mLeftFootMeshView;
	PhongMaterial material;
	
	URL url;
	ColModelImporter im;

	public LeftFootFX(LeftForeLegFX leftForeLeg) {
		mLeftForeLegFX = leftForeLeg;
		mLength = 20;
		if(mLeftForeLegFX.mUpperLegFX.mDownBody.mUpperBody.mNeckFX.mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.MALE)
			mColor = Color.rgb(80,80,80, 1);
		else
			mColor = Color.rgb(154, 83, 198, 1);
		setDefaulRotation(0);
		mYRotation = 50;
		mXRotation = 10;

		url = getClass().getClassLoader().getResource("BodyParts/foot.dae");
		im = new ColModelImporter();
		im.read(url);
		mLeftFootMeshView = (MeshView) im.getImport()[0];
		
		mLeftFootMeshView.setId("mLeftFootMeshView");
		material = new PhongMaterial();
		material.setDiffuseColor(mColor.darker());
		mLeftFootMeshView.setMaterial(material);
		
		mLeftForeLegFX.leftForeLegGroup.getChildren().add(mLeftFootMeshView);
        
        init();
	}

	@Override
	public void calculate(int step) {
		Rotate rx = new Rotate(mXRotation, 	Rotate.X_AXIS);
		Rotate ry = new Rotate(mYRotation,  Rotate.Y_AXIS);
		Rotate rz = new Rotate(mZRotation,  Rotate.Z_AXIS);
		
		if(mLeftForeLegFX.mUpperLegFX.mDownBody.mUpperBody.mNeckFX.mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.MALE)
		{
			mLeftFootMeshView.setTranslateX(mStart.x+3);
			mLeftFootMeshView.setTranslateY(mStart.y+40);
			mLeftFootMeshView.setTranslateZ(-1);
		}
		else
		{
			mLeftFootMeshView.setTranslateX(mStart.x + 3);
			mLeftFootMeshView.setTranslateY(mStart.y + 36);
			mLeftFootMeshView.setTranslateZ(-1);
		}
		
		mLeftFootMeshView.getTransforms().clear();
		mLeftFootMeshView.getTransforms().addAll(rx, ry, rz);

		// this.update();
	}

	@Override
	public void update() {
		material.setDiffuseColor(mColor);
		mLeftFootMeshView.setMaterial(material);
//		if (mLeftForeLegFX.mUpperLegFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.setCharacterInvisible == false)
//			mColorRecorder = mColor;
//
//		if (mLeftForeLegFX.mUpperLegFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.setCharacterInvisible == true) {
//			if (mLeftForeLegFX.mUpperLegFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.fadeControler == true) // Added
//																										// by
//																										// Robbie
//			{
//				int fadeFactor = mLeftForeLegFX.mUpperLegFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.mMouthFX.mShapeAnimationStep
//						* 12;
//				if (fadeFactor <= 24) {
//					fadeFactor = 0;
//				}
//				mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(),
//						(fadeFactor * 100 / 255) / 100f);
//				// mColor = Color.rgb(80, 80, 80, (fadeFactor*100/255)/100f);
//			} else {
//				int fadeFactor = (20
//						- mLeftForeLegFX.mUpperLegFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.mMouthFX.mShapeAnimationStep)
//						* 12;
//				if (fadeFactor >= 216) {
//					mColor = mColorRecorder;
//				} else
//					mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(),
//							(fadeFactor * 100 / 255) / 100f);
//				// mColor = Color.rgb(80, 80, 80, (fadeFactor*100/255)/100f);
//			}
//		}
	}
}
