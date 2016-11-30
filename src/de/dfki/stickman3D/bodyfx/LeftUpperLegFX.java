/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.bodyfx;

import com.interactivemesh.jfx.importer.col.ColModelImporter;
import de.dfki.common.Gender;
import de.dfki.stickman3D.Stickman3D;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.MeshView;
import javafx.scene.transform.Rotate;

import java.awt.*;
import java.net.URL;

/**
 *
 * @author Beka
 *
 */
public class LeftUpperLegFX extends BodyPartFX {
	
	public static enum SHAPE {
		DEFAULT, FADEIN, FADEOUT
	};
	
	public LeftUpperLegFX.SHAPE mShape = LeftUpperLegFX.SHAPE.DEFAULT;

	DownBody mDownBody;

	URL url;
	ColModelImporter imorter;
	MeshView mLeftUpperLegMesh;
	PhongMaterial material;

	Group leftUpperLegGroup;

	public LeftUpperLegFX(DownBody downBody) {
		mDownBody = downBody;
		if(mDownBody.mUpperBody.mNeckFX.mHeadFX.mStickmanFX.mType == Gender.TYPE.MALE)
		{
			mLength = 60;
			url = getClass().getClassLoader().getResource("BodyParts/MaleUpperLeg.dae");
		}
		else
		{
			mLength = 50;
			url = getClass().getClassLoader().getResource("BodyParts/FemaleUpperLeg.dae");
		}

		imorter = new ColModelImporter();
		mSize = new Dimension(10, mLength);
		mColor = Color.rgb(242, 227, 217, 1);

		mDefaultRotation = 0;
		mXRotation = mDefaultRotation;
		mToDegreeX = mDefaultRotation;
		mXRotationStep = 0.0f;

		imorter.read(url);
		mLeftUpperLegMesh = (MeshView) imorter.getImport()[0];

		material = new PhongMaterial();
		material.setDiffuseColor(mColor);
		mLeftUpperLegMesh.setMaterial(material);

		leftUpperLegGroup = new Group();
		leftUpperLegGroup.setId("leftUpperLegGroup");
		leftUpperLegGroup.getChildren().add(mLeftUpperLegMesh);

		mDownBody.mDownBodyGroup.getChildren().add(leftUpperLegGroup);

		init();
	}

	@Override
	public void setShape(String s) {
		SHAPE shape = SHAPE.valueOf(s);
		mShape = (shape != null) ? shape : SHAPE.DEFAULT;
	}

	@Override
	public void resetShape() {
		mShape = LeftUpperLegFX.SHAPE.DEFAULT;
	}
	
	@Override
	public void calculate(int step) {
		mStart = mDownBody.mUpperBody.getLeftLegStartPostion();
		
		Rotate rx = new Rotate(mXRotation,  Rotate.X_AXIS);
		Rotate ry = new Rotate(mYRotation,  Rotate.Y_AXIS);
		Rotate rz = new Rotate(mZRotation,  Rotate.Z_AXIS);
		
		if(mDownBody.mUpperBody.mNeckFX.mHeadFX.mStickmanFX.mType == Gender.TYPE.MALE)
		{
			leftUpperLegGroup.setTranslateX(mStart.x - 58);
			leftUpperLegGroup.setTranslateY(mStart.y - 256);
			leftUpperLegGroup.setTranslateZ(0);
		}
		else
		{
			leftUpperLegGroup.setTranslateX(mStart.x-60);
			leftUpperLegGroup.setTranslateY(mStart.y - 243);
			leftUpperLegGroup.setTranslateZ(0);
		}
		leftUpperLegGroup.getTransforms().clear();
		leftUpperLegGroup.getTransforms().addAll(rx, ry, rz);
		
		switch(mShape)
		{
		case FADEIN:
			if(step == 2)
			{
				mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), 0.0);
				update();
				mLeftUpperLegMesh.setVisible(false);
			}
			else if(mColor.getOpacity() != 0.0)
			{
				mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), mColor.getOpacity() - 0.052);
				update();
			}
			break;
			
		case FADEOUT:
			mLeftUpperLegMesh.setVisible(true);
			
			if(step == 2)
			{
				mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), 1.0);
				update();
			}
			else if(mColor.getOpacity() != 1.0)
			{
				mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), mColor.getOpacity() + 0.052);
				update();
			}
			break;
		}
		
	}

	@Override
	public void update() {
		material.setDiffuseColor(mColor);
		mLeftUpperLegMesh.setMaterial(material);
	}
}
