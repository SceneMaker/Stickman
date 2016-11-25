/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.body;

import java.awt.Dimension;
import java.net.URL;

import com.interactivemesh.jfx.importer.col.ColModelImporter;

import de.dfki.stickman3D.Stickman3D;
import de.dfki.util.XMLParser;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.MeshView;
import javafx.scene.transform.Rotate;

/**
 *
 * @author Beka
 *
 */
public class LeftUpperArm extends BodyPart {

	public static enum SHAPE {
		DEFAULT, FADEIN, FADEOUT
	};

	public LeftUpperArm.SHAPE mShape = LeftUpperArm.SHAPE.DEFAULT;

	UpperBody mBodyFX;

	int mArmLength = 70;
	Dimension mSize = new Dimension(mArmLength, mArmLength);

	URL url;
	ColModelImporter imorter;
	MeshView mLeftUpperArmMesh;
	PhongMaterial material;

	Group leftUpperArmGroup;

	public LeftUpperArm(UpperBody bodyFX) {
		mBodyFX = bodyFX;

		imorter = new ColModelImporter();
		mColor = Color.rgb(242, 227, 217, 1);
		activateConfigColor();

		url = getClass().getClassLoader().getResource("BodyParts/UpperArm.dae");

		if (mBodyFX.mNeckFX.mHeadFX.mStickmanFX.mType == Stickman3D.TYPE.MALE)
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

	private void activateConfigColor() {
		String stickmanName = mBodyFX.mNeckFX.mHeadFX.mStickmanFX.mName;
		if (XMLParser.getColorMap(stickmanName) != null) {
			if (XMLParser.getColorMap(stickmanName).containsKey("LimbsColor"))
				this.mColor = XMLParser.getColorMap(stickmanName).get("LimbsColor");
		}
	}

	@Override
	public void setShape(String s) {
		SHAPE shape = SHAPE.valueOf(s);
		mShape = (shape != null) ? shape : SHAPE.DEFAULT;
	}

	@Override
	public void resetShape() {
		mShape = LeftUpperArm.SHAPE.DEFAULT;
	}

	@Override
	public void calculate(int step) {
		mStart = mBodyFX.getLeftArmStartPostion();

		Rotate rx = new Rotate(mXRotation, Rotate.X_AXIS);
		Rotate ry = new Rotate(mYRotation, Rotate.Y_AXIS);
		Rotate rz = new Rotate(mZRotation, Rotate.Z_AXIS);

		if (mBodyFX.mNeckFX.mHeadFX.mStickmanFX.mType == Stickman3D.TYPE.MALE) {
			leftUpperArmGroup.setTranslateX(mStart.x);
			leftUpperArmGroup.setTranslateY(mStart.y - 105);
			leftUpperArmGroup.setTranslateZ(0);
		} else {
			leftUpperArmGroup.setTranslateX(mStart.x - 10);
			leftUpperArmGroup.setTranslateY(mStart.y - 90);
			leftUpperArmGroup.setTranslateZ(0);
		}
		leftUpperArmGroup.getTransforms().clear();
		leftUpperArmGroup.getTransforms().addAll(rx, ry, rz);

		switch (mShape) {
		case FADEIN:
			if (step == 2) {
				mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), 0.0);
				update();
				mLeftUpperArmMesh.setVisible(false);
			} else if (mColor.getOpacity() != 0.0) {
				mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), mColor.getOpacity() - 0.052);
				update();
			}
			break;

		case FADEOUT:
			mLeftUpperArmMesh.setVisible(true);

			if (step == 2) {
				mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), 1.0);
				update();
			} else if (mColor.getOpacity() != 1.0) {
				mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), mColor.getOpacity() + 0.052);
				update();
			}
			break;
		}
	}

	@Override
	public void update() {
		material.setDiffuseColor(mColor);
		mLeftUpperArmMesh.setMaterial(material);
	}
}
