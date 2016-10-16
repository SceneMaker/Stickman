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
public class LeftFootFX extends BodyPartFX {

	LeftForeLegFX mLeftForeLegFX;

	PhongMaterial material;

	Cylinder leftFoot;

	public LeftFootFX(LeftForeLegFX leftForeLeg) {
		mLeftForeLegFX = leftForeLeg;
		mLength = 20;
		mColor = Color.rgb(242, 227, 217, 1);
		setDefaulRotation(0);
//		mYRotation = -135;
		mXRotation = 10;
		mZRotation = 5;

		leftFoot = new Cylinder(7, mLength);
	        
        material = new PhongMaterial();
		material.setDiffuseColor(mColor);
		
		leftFoot.setMaterial(material);
		
		leftFoot.setRotationAxis(Rotate.Z_AXIS);
		leftFoot.setRotate(90);
		
		mLeftForeLegFX.leftForeLegGroup.getChildren().add(leftFoot);
        
        init();
	}

	@Override
	public void calculate(int step) {
		Rotate rx = new Rotate(mXRotation, 0, leftFoot.getHeight()/2, 0, Rotate.X_AXIS);
		Rotate ry = new Rotate(mYRotation, 0, leftFoot.getHeight()/2, 0,  Rotate.Y_AXIS);
		Rotate rz = new Rotate(mZRotation, 0, leftFoot.getHeight()/2, 0,  Rotate.Z_AXIS);
		
		if(mLeftForeLegFX.mUpperLegFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.MALE)
		{
			leftFoot.setTranslateX(mStart.x+10);
			leftFoot.setTranslateY(mStart.y+38);
			leftFoot.setTranslateZ(0);
		}
		else
		{
			leftFoot.setTranslateX(mStart.x + 10);
			leftFoot.setTranslateY(mStart.y + 34);
			leftFoot.setTranslateZ(0);
		}
		
		leftFoot.getTransforms().clear();
		leftFoot.getTransforms().addAll(rx, ry, rz);

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
