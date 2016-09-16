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

	LeftShoulderFX mLeftShoulderFX;
	BodyFX mBodyFX;

	int mArmLength = 70;
	Dimension mSize = new Dimension(mArmLength, mArmLength);

	Point mStart;

	Group leftUpperArmMesh;

	public LeftUpperArmFX(BodyFX bodyFX) {
		mBodyFX = bodyFX;
		mColor = Color.rgb(80, 80, 80);
		if(mBodyFX.mNeckFX.mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.MALE)
			mDefaultRotation = -30;
		else
			mDefaultRotation = -35;
		mZRotation = mDefaultRotation;
		mToDegree = mDefaultRotation;
		mRotationStep = 0.0f;

		leftUpperArmMesh = (Group) mBodyFX.maleBodyModel.getChildren().get(1);

		init();
		calculate(0);
	}

	@Override
	public void calculate(int step) {
		Rotate rx = new Rotate(mRotation, Rotate.X_AXIS);
		Rotate ry = new Rotate(mYRotation, Rotate.Y_AXIS);
		Rotate rz = new Rotate(mZRotation, Rotate.Z_AXIS);

		Translate translate = (Translate) leftUpperArmMesh.getTransforms().get(0);
		Scale scale = (Scale) leftUpperArmMesh.getTransforms().get(4);
		leftUpperArmMesh.getTransforms().clear();
		leftUpperArmMesh.getTransforms().addAll(translate, rx, ry, rz, scale);

		mBodyFX.updateAfterRotation();

		// update();
	}

	@Override
	public void update() {
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
