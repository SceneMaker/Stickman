/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanfx.bodyfx;

import java.awt.Dimension;
import java.net.URL;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.MeshView;
import javafx.scene.transform.Rotate;
import com.interactivemesh.jfx.importer.col.ColModelImporter;
import de.dfki.stickmanfx.StickmanFX;

/**
 *
 * @author Beka
 *
 */
public class LeftUpperArmFX extends BodyPartFX {

	UpperBody mBodyFX;

	int mArmLength = 70;
	Dimension mSize = new Dimension(mArmLength, mArmLength);

	URL url;
	ColModelImporter imorter;
	MeshView mLeftUpperArmMesh;
	PhongMaterial material;

	Group leftUpperArmGroup;

	public LeftUpperArmFX(UpperBody bodyFX) {
		mBodyFX = bodyFX;

		imorter = new ColModelImporter();
		mColor = Color.rgb(242, 227, 217, 1);

		url = getClass().getClassLoader().getResource("BodyParts/UpperArm1.dae");

		if (mBodyFX.mNeckFX.mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.MALE)
			mDefaultRotation = -10;
		else
			mDefaultRotation = -15;
		mZRotation = mDefaultRotation;
		mToDegreeX = mDefaultRotation;
		mXRotationStep = 0.0f;

		imorter.read(url);
		mLeftUpperArmMesh = (MeshView) imorter.getImport()[0];

		material = new PhongMaterial();
		material.setDiffuseColor(mColor);
		mLeftUpperArmMesh.setMaterial(material);

		leftUpperArmGroup = new Group();
		leftUpperArmGroup.setId("leftUpperArmGroup");
		leftUpperArmGroup.getChildren().add(mLeftUpperArmMesh);

		mBodyFX.mUpperBodyGroup.getChildren().add(leftUpperArmGroup);

		init();
	}

	@Override
	public void calculate(int step) {
		mStart = mBodyFX.getLeftArmStartPostion();

		Rotate rx = new Rotate(mXRotation, Rotate.X_AXIS);
		Rotate ry = new Rotate(mYRotation, Rotate.Y_AXIS);
		Rotate rz = new Rotate(mZRotation, Rotate.Z_AXIS);

		if (mBodyFX.mNeckFX.mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.MALE) {
			leftUpperArmGroup.setTranslateX(mStart.x);
			leftUpperArmGroup.setTranslateY(mStart.y - 85);
			leftUpperArmGroup.setTranslateZ(0);
		} else {
			leftUpperArmGroup.setTranslateX(mStart.x - 10);
			leftUpperArmGroup.setTranslateY(mStart.y - 90);
			leftUpperArmGroup.setTranslateZ(0);
		}
		leftUpperArmGroup.getTransforms().clear();
		leftUpperArmGroup.getTransforms().addAll(rx, ry, rz);

		// if (step == 0)
		// {
		// mBodyFX.mBodyModel.getChildren().add(leftUpperArmGroup);
		// }
		// else
		// mBodyFX.mBodyModel.getChildren().set(1, leftUpperArmGroup);

		// update();
	}

	@Override
	public void update() {
		material.setDiffuseColor(mColor);
		mLeftUpperArmMesh.setMaterial(material);
		// draw outlines
		// if
		// (mLeftShoulderFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.setCharacterInvisible
		// == false)
		// mColorRecorder = mColor;
		// if
		// (mLeftShoulderFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.setCharacterInvisible
		// == true) {
		// if (mLeftShoulderFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.fadeControler
		// == true) {
		// int fadeFactor =
		// mLeftShoulderFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.mMouthFX.mShapeAnimationStep
		// * 12;
		// if (fadeFactor <= 24) {
		// fadeFactor = 0;
		// }
		// mColor = new Color(mColor.getRed(), mColor.getGreen(),
		// mColor.getBlue(),
		// (fadeFactor * 100 / 255) / 100f);
		// } else {
		// int fadeFactor = (20 -
		// mLeftShoulderFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.mMouthFX.mShapeAnimationStep)
		// * 12;
		// if (fadeFactor >= 216) {
		// mColor = mColorRecorder;
		// } else
		// mColor = new Color(mColor.getRed(), mColor.getGreen(),
		// mColor.getBlue(),
		// (fadeFactor * 100 / 255) / 100f);
		// }
		// }
	}
}
