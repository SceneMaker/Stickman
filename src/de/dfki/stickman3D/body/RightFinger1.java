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
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.MeshView;
import javafx.scene.transform.Rotate;

/**
 *
 * @author Beka
 *
 */
public class RightFinger1 extends BodyPart {
	public static enum SHAPE {
		DEFAULT, FADEIN, FADEOUT
	};

	public RightFinger1.SHAPE mShape = RightFinger1.SHAPE.DEFAULT;

	RightWrist mRightWrist;
	int mArmLength = 80;
	Dimension mSize = new Dimension(mArmLength, mArmLength);

	URL url;
	ColModelImporter imorter;
	public MeshView mRightFinger1;
	PhongMaterial material;

	public RightFinger1(RightWrist rightWrist) {
		mRightWrist = rightWrist;

		imorter = new ColModelImporter();
		mColor = Color.rgb(242, 227, 217, 1);
		activateConfigColor();

		url = getClass().getClassLoader().getResource("BodyParts/Finger1.dae");

		mDefaultRotation = -20;
		mZRotation = -20;
		mToDegreeX = mDefaultRotation;

		imorter.read(url);
		mRightFinger1 = (MeshView) imorter.getImport()[0];

		material = new PhongMaterial();
		material.setDiffuseColor(mColor);
		mRightFinger1.setMaterial(material);

		mRightWrist.rightWristGroup.getChildren().add(mRightFinger1);

		init();
	}

	private void activateConfigColor() {
		String stickmanName = mRightWrist.mRightForeArmFX.mUpperArmFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.mName;
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
		mShape = RightFinger1.SHAPE.DEFAULT;
	}

	@Override
	public void calculate(int step) {
		Rotate rx = new Rotate(mXRotation, Rotate.X_AXIS);
		Rotate ry = new Rotate(mYRotation, Rotate.Y_AXIS);
		Rotate rz = new Rotate(mZRotation, Rotate.Z_AXIS);

		if (mRightWrist.mRightForeArmFX.mUpperArmFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.mType == Stickman3D.TYPE.MALE) {
			mRightFinger1.setTranslateX(mStart.x + 9);
			mRightFinger1.setTranslateY(mStart.y + 7);
			mRightFinger1.setTranslateZ(0);
		} else {
			mRightFinger1.setTranslateX(mStart.x + 9);
			mRightFinger1.setTranslateY(mStart.y + 7);
			mRightFinger1.setTranslateZ(0);
		}

		mRightFinger1.getTransforms().clear();
		mRightFinger1.getTransforms().addAll(rx, ry, rz);

		switch (mShape) {
		case FADEIN:
			if (step == 2) {
				mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), 0.0);
				update();
				mRightFinger1.setVisible(false);
			} else if (mColor.getOpacity() != 0.0) {
				mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), mColor.getOpacity() - 0.052);
				update();
			}
			break;

		case FADEOUT:
			mRightFinger1.setVisible(true);

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
		mRightFinger1.setMaterial(material);
	}

}
