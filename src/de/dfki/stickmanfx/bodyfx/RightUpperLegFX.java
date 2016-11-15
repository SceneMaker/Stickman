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
public class RightUpperLegFX extends BodyPartFX {

	public static enum SHAPE {
		DEFAULT, FADEIN, FADEOUT
	};
	
	public RightUpperLegFX.SHAPE mShape = RightUpperLegFX.SHAPE.DEFAULT;
	
	DownBody mDownBody;

	URL url;
	ColModelImporter imorter;
	MeshView mRightUpperLegMesh;
	PhongMaterial material;

	Group rightUpperLegGroup;

	public RightUpperLegFX(DownBody downBody) {
		mDownBody = downBody;
		if(mDownBody.mUpperBody.mNeckFX.mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.MALE)
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
		activateConfigColor();

		mDefaultRotation = 0;
		mXRotation = mDefaultRotation;
		mToDegreeX = mDefaultRotation;
		mXRotationStep = 0.0f;
		
		imorter.read(url);
		mRightUpperLegMesh = (MeshView) imorter.getImport()[0];
		
		material = new PhongMaterial();
		material.setDiffuseColor(mColor);
		mRightUpperLegMesh.setMaterial(material);
		
		rightUpperLegGroup = new Group();
		rightUpperLegGroup.setId("rightUpperLegGroup");
		rightUpperLegGroup.getChildren().add(mRightUpperLegMesh);
		
		mDownBody.mDownBodyGroup.getChildren().add(rightUpperLegGroup);
		
		init();
	}
	
	private void activateConfigColor()
   	{
   		if(mDownBody.mUpperBody.mNeckFX.mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.FEMALE)
   		{
   			if(!XMLParser.femaleColor.isEmpty())
   			{
   				if(XMLParser.femaleColor.containsKey("LimbsColor"))
   					this.mColor = XMLParser.femaleColor.get("LimbsColor");
   			}
   		}
   		else
   		{
   			if(!XMLParser.maleColor.isEmpty())
   			{
   				if(XMLParser.maleColor.containsKey("LimbsColor"))
   					this.mColor = XMLParser.maleColor.get("LimbsColor");
   			}
   		}
   	}
	
	@Override
	public void setShape(String s) {
		SHAPE shape = SHAPE.valueOf(s);
		mShape = (shape != null) ? shape : SHAPE.DEFAULT;
	}

	@Override
	public void resetShape() {
		mShape = RightUpperLegFX.SHAPE.DEFAULT;
	}

	@Override
	public void calculate(int step) {
		mStart = mDownBody.mUpperBody.getRightLegStartPostion();
		
		Rotate rx = new Rotate(mXRotation,  Rotate.X_AXIS);
		Rotate ry = new Rotate(mYRotation,  Rotate.Y_AXIS);
		Rotate rz = new Rotate(mZRotation,  Rotate.Z_AXIS);
		
		if(mDownBody.mUpperBody.mNeckFX.mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.MALE)
		{
			rightUpperLegGroup.setTranslateX(mStart.x - 70);
			rightUpperLegGroup.setTranslateY(mStart.y - 256);
			rightUpperLegGroup.setTranslateZ(0);
		}
		else
		{
			rightUpperLegGroup.setTranslateX(mStart.x-70);
			rightUpperLegGroup.setTranslateY(mStart.y - 246);
			rightUpperLegGroup.setTranslateZ(0);
		}
		rightUpperLegGroup.getTransforms().clear();
		rightUpperLegGroup.getTransforms().addAll(rx, ry, rz);

		switch(mShape)
		{
		case FADEIN:
			if(step == 2)
			{
				mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), 0.0);
				update();
				mRightUpperLegMesh.setVisible(false);
			}
			else if(mColor.getOpacity() != 0.0)
			{
				mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), mColor.getOpacity() - 0.052);
				update();
			}
			break;
			
		case FADEOUT:
			mRightUpperLegMesh.setVisible(true);
			
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
		mRightUpperLegMesh.setMaterial(material);
	}
}
