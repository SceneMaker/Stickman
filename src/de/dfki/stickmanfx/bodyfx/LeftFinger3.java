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
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.MeshView;
import javafx.scene.transform.Rotate;
/**
 *
 * @author Beka
 *
 */
public class LeftFinger3 extends BodyPartFX 
{

	public static enum SHAPE {
		DEFAULT, FADEIN, FADEOUT
	};
	
	public LeftFinger3.SHAPE mShape = LeftFinger3.SHAPE.DEFAULT;
	
    LeftWrist mLeftWrist;
    int mArmLength = 80;
    Dimension mSize = new Dimension(mArmLength, mArmLength);
    
    URL url;
   	ColModelImporter imorter;
   	MeshView mLeftFinger3;
    PhongMaterial material;

    public LeftFinger3(LeftWrist leftWrist) {
    	mLeftWrist = leftWrist;
    	
    	imorter = new ColModelImporter();
        mColor = Color.rgb(242, 227, 217, 1);
        activateConfigColor();
        
        url = getClass().getClassLoader().getResource("BodyParts/Finger2_3_4_2.dae");
        
        mDefaultRotation = -20;
        mZRotation = 0;
        mToDegreeX = mDefaultRotation;
        
        imorter.read(url);
        mLeftFinger3 = (MeshView) imorter.getImport()[0];
        
        material = new PhongMaterial();
		material.setDiffuseColor(mColor);
		mLeftFinger3.setMaterial(material);
		
		mLeftWrist.leftWristGroup.getChildren().add(mLeftFinger3);
        
        init();
    }

    private void activateConfigColor()
   	{
   		if(mLeftWrist.mLeftForeArmFX.mUpperArmFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.FEMALE)
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
		mShape = LeftFinger3.SHAPE.DEFAULT;
	}
    
    @Override
    public void calculate(int step) 
    {
    	Rotate rx = new Rotate(mXRotation,  Rotate.X_AXIS);
		Rotate ry = new Rotate(mYRotation,  Rotate.Y_AXIS);
		Rotate rz = new Rotate(mZRotation,  Rotate.Z_AXIS);
		
		if(mLeftWrist.mLeftForeArmFX.mUpperArmFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.MALE)
		{
			mLeftFinger3.setTranslateX(mStart.x+1);
			mLeftFinger3.setTranslateY(mStart.y + 17);
			mLeftFinger3.setTranslateZ(0);
		}
		else
		{
			mLeftFinger3.setTranslateX(mStart.x + 1);
			mLeftFinger3.setTranslateY(mStart.y + 17);
			mLeftFinger3.setTranslateZ(0);
		}
		
		mLeftFinger3.getTransforms().clear();
		mLeftFinger3.getTransforms().addAll(rx, ry, rz);
		
		switch(mShape)
		{
		case FADEIN:
			if(step == 2)
			{
				mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), 0.0);
				update();
				mLeftFinger3.setVisible(false);
			}
			else if(mColor.getOpacity() != 0.0)
			{
				mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), mColor.getOpacity() - 0.052);
				update();
			}
			break;
			
		case FADEOUT:
			mLeftFinger3.setVisible(true);
			
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
    	mLeftFinger3.setMaterial(material);
    }

}
