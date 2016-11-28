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
public class RightForeArm extends BodyPart {

	public static enum SHAPE {
		DEFAULT, FADEIN, FADEOUT
	};

	public RightForeArm.SHAPE mShape = RightForeArm.SHAPE.DEFAULT;

	RightUpperArm mUpperArmFX;
	int mArmLength = 80;
	Dimension mSize = new Dimension(mArmLength, mArmLength);

	URL url;
	ColModelImporter imorter;
	public MeshView mRightForeArmMesh;
	PhongMaterial material;

	Group rightForeArmGroup;

	public RightForeArm(RightUpperArm arm) {
		mUpperArmFX = arm;

		imorter = new ColModelImporter();
		mColor = Color.rgb(242, 227, 217, 1);
		activateConfigColor();

		url = getClass().getClassLoader().getResource("BodyParts/ForeArm.dae");

		mXRotation = -15;
		mZRotation = -10;
		mToDegreeX = mDefaultRotation;

		imorter.read(url);
		mRightForeArmMesh = (MeshView) imorter.getImport()[0];

		material = new PhongMaterial();
		material.setDiffuseColor(mColor);
		mRightForeArmMesh.setMaterial(material);

		rightForeArmGroup = new Group();
		rightForeArmGroup.setId("rightForeArmGroup");
		rightForeArmGroup.getChildren().add(mRightForeArmMesh);

		mUpperArmFX.rightUpperArmGroup.getChildren().add(rightForeArmGroup);

		init();
	}

	private void activateConfigColor() {
		String stickmanName = mUpperArmFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.mName;
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
		mShape = RightForeArm.SHAPE.DEFAULT;
	}

	@Override
	public void calculate(int step) {
		Rotate rx = new Rotate(mXRotation, Rotate.X_AXIS);
		Rotate ry = new Rotate(mYRotation, Rotate.Y_AXIS);
		Rotate rz = new Rotate(mZRotation, Rotate.Z_AXIS);

		if (mUpperArmFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.mType == Stickman3D.TYPE.MALE) {
			rightForeArmGroup.setTranslateX(mStart.x);
			rightForeArmGroup.setTranslateY(mStart.y + 60);
			rightForeArmGroup.setTranslateZ(0);
		} else {
			rightForeArmGroup.setTranslateX(mStart.x);
			rightForeArmGroup.setTranslateY(mStart.y + 60);
			rightForeArmGroup.setTranslateZ(0);
		}

		rightForeArmGroup.getTransforms().clear();
		rightForeArmGroup.getTransforms().addAll(rx, ry, rz);

		switch (mShape) {
		case FADEIN:
			if (step == 2) {
				mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), 0.0);
				update();
				mRightForeArmMesh.setVisible(false);
			} else if (mColor.getOpacity() != 0.0) {
				mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), mColor.getOpacity() - 0.052);
				update();
			}
			break;

		case FADEOUT:
			mRightForeArmMesh.setVisible(true);

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
		mRightForeArmMesh.setMaterial(material);
	}
}
