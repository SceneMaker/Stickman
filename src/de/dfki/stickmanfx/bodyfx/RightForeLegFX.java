/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanfx.bodyfx;

import java.awt.Dimension;
import java.net.URL;

import com.interactivemesh.jfx.importer.col.ColModelImporter;

import de.dfki.stickmanfx.StickmanFX;
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
public class RightForeLegFX extends BodyPartFX {

	public static enum SHAPE {
		DEFAULT, FADEIN, FADEOUT
	};

	public RightForeLegFX.SHAPE mShape = RightForeLegFX.SHAPE.DEFAULT;

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

		if (mUpperLegFX.mDownBody.mUpperBody.mNeckFX.mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.MALE) {
			mLegLength = 90;
			url = getClass().getClassLoader().getResource("BodyParts/MaleForeLeg.dae");
		} else {
			mLegLength = 80;
			url = getClass().getClassLoader().getResource("BodyParts/FemaleForeLeg.dae");
		}

		imorter = new ColModelImporter();
		mColor = Color.rgb(242, 227, 217, 1);
		activateConfigColor();

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

	private void activateConfigColor() {
		String stickmanName = mUpperLegFX.mDownBody.mUpperBody.mNeckFX.mHeadFX.mStickmanFX.mName;
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
		mShape = RightForeLegFX.SHAPE.DEFAULT;
	}

	@Override
	public void calculate(int step) {

		Rotate rx = new Rotate(mXRotation, Rotate.X_AXIS);
		Rotate ry = new Rotate(mYRotation, Rotate.Y_AXIS);
		Rotate rz = new Rotate(mZRotation, Rotate.Z_AXIS);

		if (mUpperLegFX.mDownBody.mUpperBody.mNeckFX.mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.MALE) {
			rightForeLegGroup.setTranslateX(mStart.x);
			rightForeLegGroup.setTranslateY(mStart.y + 59);
			rightForeLegGroup.setTranslateZ(0);
		} else {
			rightForeLegGroup.setTranslateX(mStart.x);
			rightForeLegGroup.setTranslateY(mStart.y + 49);
			rightForeLegGroup.setTranslateZ(0);
		}

		rightForeLegGroup.getTransforms().clear();
		rightForeLegGroup.getTransforms().addAll(rx, ry, rz);

		switch (mShape) {
		case FADEIN:
			if (step == 2) {
				mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), 0.0);
				update();
				mRightForeLegMesh.setVisible(false);
			} else if (mColor.getOpacity() != 0.0) {
				mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), mColor.getOpacity() - 0.052);
				update();
			}
			break;

		case FADEOUT:
			mRightForeLegMesh.setVisible(true);

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
		mRightForeLegMesh.setMaterial(material);
	}
}
