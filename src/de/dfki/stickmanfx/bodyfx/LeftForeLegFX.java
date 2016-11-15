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
public class LeftForeLegFX extends BodyPartFX {

	public static enum SHAPE {
		DEFAULT, FADEIN, FADEOUT
	};
	
	public LeftForeLegFX.SHAPE mShape = LeftForeLegFX.SHAPE.DEFAULT;
	
    LeftUpperLegFX mUpperLegFX;
    int mLegLength;
    Dimension mSize = new Dimension(10, mLegLength);
    
    URL url;
	ColModelImporter imorter;
	MeshView mLeftForeLegMesh;
    PhongMaterial material;

	Group leftForeLegGroup;

    public LeftForeLegFX(LeftUpperLegFX leftUpperLegFX) 
    {
    	mUpperLegFX = leftUpperLegFX;
        mDefaultRotation = -2;
		mXRotation = mDefaultRotation;
		mToDegreeX = mDefaultRotation;
		
		if(mUpperLegFX.mDownBody.mUpperBody.mNeckFX.mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.MALE)
		{
			mLegLength = 90;
			url = getClass().getClassLoader().getResource("BodyParts/MaleForeLeg.dae");
		}
		else
		{
			mLegLength = 80;
			url = getClass().getClassLoader().getResource("BodyParts/FemaleForeLeg.dae");
		}
		
		mColor = Color.rgb(242, 227, 217, 1);
		activateConfigColor();
		imorter = new ColModelImporter();
		
		imorter.read(url);
		mLeftForeLegMesh = (MeshView) imorter.getImport()[0];
		
		material = new PhongMaterial();
		material.setDiffuseColor(mColor);
		mLeftForeLegMesh.setMaterial(material);
		
		leftForeLegGroup = new Group();
		leftForeLegGroup.setId("leftForeLegGroup");
		leftForeLegGroup.getChildren().add(mLeftForeLegMesh);
        
		mUpperLegFX.leftUpperLegGroup.getChildren().add(leftForeLegGroup);
        
        init();
    }
    
    private void activateConfigColor()
   	{
   		if(mUpperLegFX.mDownBody.mUpperBody.mNeckFX.mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.FEMALE)
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
		mShape = LeftForeLegFX.SHAPE.DEFAULT;
	}
	
    @Override
	public void calculate(int step)
    {
		Rotate rx = new Rotate(mXRotation,  Rotate.X_AXIS);
		Rotate ry = new Rotate(mYRotation,  Rotate.Y_AXIS);
		Rotate rz = new Rotate(mZRotation,  Rotate.Z_AXIS);
		
		if(mUpperLegFX.mDownBody.mUpperBody.mNeckFX.mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.MALE)
		{
			leftForeLegGroup.setTranslateX(mStart.x);
			leftForeLegGroup.setTranslateY(mStart.y+59);
			leftForeLegGroup.setTranslateZ(0);
		}
		else
		{
			leftForeLegGroup.setTranslateX(mStart.x);
			leftForeLegGroup.setTranslateY(mStart.y + 49);
			leftForeLegGroup.setTranslateZ(0);
		}
		
		leftForeLegGroup.getTransforms().clear();
		leftForeLegGroup.getTransforms().addAll(rx, ry, rz);

		switch(mShape)
		{
		case FADEIN:
			if(step == 2)
			{
				mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), 0.0);
				update();
				mLeftForeLegMesh.setVisible(false);
			}
			else if(mColor.getOpacity() != 0.0)
			{
				mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), mColor.getOpacity() - 0.052);
				update();
			}
			break;
			
		case FADEOUT:
			mLeftForeLegMesh.setVisible(true);
			
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
	public void update() 
	{
    	material.setDiffuseColor(mColor);
    	mLeftForeLegMesh.setMaterial(material);
	}
}
