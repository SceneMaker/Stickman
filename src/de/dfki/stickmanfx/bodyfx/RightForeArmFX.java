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
public class RightForeArmFX extends BodyPartFX 
{

	public static enum SHAPE {
		DEFAULT, FADEIN, FADEOUT
	};
	
	public RightForeArmFX.SHAPE mShape = RightForeArmFX.SHAPE.DEFAULT;
	
	RightUpperArmFX mUpperArmFX;
	int mArmLength = 80;
	Dimension mSize = new Dimension(mArmLength, mArmLength);
	
	URL url;
	ColModelImporter imorter;
	MeshView mRightForeArmMesh;
	PhongMaterial material;

	Group rightForeArmGroup;

	public RightForeArmFX(RightUpperArmFX arm) 
	{
		mUpperArmFX = arm;
		
		imorter = new ColModelImporter();
		mColor = Color.rgb(242, 227, 217, 1);
		activateConfigColor();
		
		url = getClass().getClassLoader().getResource("BodyParts/ForeArm1.dae");
		
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

	
	private void activateConfigColor()
   	{
   		if(mUpperArmFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.FEMALE)
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
		mShape = RightForeArmFX.SHAPE.DEFAULT;
	}
	
	@Override
	public void calculate(int step) 
	{
		Rotate rx = new Rotate(mXRotation,  Rotate.X_AXIS);
		Rotate ry = new Rotate(mYRotation,  Rotate.Y_AXIS);
		Rotate rz = new Rotate(mZRotation,  Rotate.Z_AXIS);
		
		if(mUpperArmFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.MALE)
		{
			rightForeArmGroup.setTranslateX(mStart.x);
			rightForeArmGroup.setTranslateY(mStart.y+60);
			rightForeArmGroup.setTranslateZ(0);
		}
		else
		{
			rightForeArmGroup.setTranslateX(mStart.x);
			rightForeArmGroup.setTranslateY(mStart.y + 60);
			rightForeArmGroup.setTranslateZ(0);
		}
		
		rightForeArmGroup.getTransforms().clear();
		rightForeArmGroup.getTransforms().addAll(rx, ry, rz);
		
		switch(mShape)
		{
		case FADEIN:
			if(step == 2)
			{
				mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), 0.0);
				update();
				mRightForeArmMesh.setVisible(false);
			}
			else if(mColor.getOpacity() != 0.0)
			{
				mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), mColor.getOpacity() - 0.052);
				update();
			}
			break;
			
		case FADEOUT:
			mRightForeArmMesh.setVisible(true);
			
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
		mRightForeArmMesh.setMaterial(material);
	}
}
