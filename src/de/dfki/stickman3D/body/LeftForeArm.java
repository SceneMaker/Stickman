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
public class LeftForeArm extends BodyPart {

	public static enum SHAPE {
		DEFAULT, FADEIN, FADEOUT
	};

	public LeftForeArm.SHAPE mShape = LeftForeArm.SHAPE.DEFAULT;

	LeftUpperArm mUpperArmFX;
	int mArmLength = 80;
	Dimension mSize = new Dimension(mArmLength, mArmLength);

	URL url;
	ColModelImporter imorter;
	public MeshView mLeftForeArmMesh;
	PhongMaterial material;

	Group leftForeArmGroup;

	public LeftForeArm(LeftUpperArm arm) {
		mUpperArmFX = arm;

		imorter = new ColModelImporter();
		mColor = Color.rgb(242, 227, 217, 1);
		activateConfigColor();

		url = getClass().getClassLoader().getResource("BodyParts/ForeArm.dae");

		mXRotation = -15;
		mZRotation = 10;
		mToDegreeX = mDefaultRotation;

		imorter.read(url);
		mLeftForeArmMesh = (MeshView) imorter.getImport()[0];

		material = new PhongMaterial();
		material.setDiffuseColor(mColor);
		mLeftForeArmMesh.setMaterial(material);

		leftForeArmGroup = new Group();
		leftForeArmGroup.setId("leftForeArmGroup");
		leftForeArmGroup.getChildren().add(mLeftForeArmMesh);

		mUpperArmFX.leftUpperArmGroup.getChildren().add(leftForeArmGroup);

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
		mShape = LeftForeArm.SHAPE.DEFAULT;
	}

	@Override
	public void calculate(int step) {
		Rotate rx = new Rotate(mXRotation, Rotate.X_AXIS);
		Rotate ry = new Rotate(mYRotation, Rotate.Y_AXIS);
		Rotate rz = new Rotate(mZRotation, Rotate.Z_AXIS);

		if (mUpperArmFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.mType == Stickman3D.TYPE.MALE) {
			leftForeArmGroup.setTranslateX(mStart.x);
			leftForeArmGroup.setTranslateY(mStart.y + 60);
			leftForeArmGroup.setTranslateZ(0);
		} else {
			leftForeArmGroup.setTranslateX(mStart.x);
			leftForeArmGroup.setTranslateY(mStart.y + 60);
			leftForeArmGroup.setTranslateZ(0);
		}

		leftForeArmGroup.getTransforms().clear();
		leftForeArmGroup.getTransforms().addAll(rx, ry, rz);

		switch (mShape) {
		case FADEIN:
			if (step == 2) {
				mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), 0.0);
				update();
				mLeftForeArmMesh.setVisible(false);
			} else if (mColor.getOpacity() != 0.0) {
				mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), mColor.getOpacity() - 0.052);
				update();
			}
			break;

		case FADEOUT:
			mLeftForeArmMesh.setVisible(true);

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
		mLeftForeArmMesh.setMaterial(material);
	}

}
