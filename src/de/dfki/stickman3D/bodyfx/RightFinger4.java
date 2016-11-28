/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.bodyfx;

import com.interactivemesh.jfx.importer.col.ColModelImporter;
import de.dfki.stickman3D.Stickman3D;
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
public class RightFinger4 extends BodyPartFX
{

	public static enum SHAPE {
		DEFAULT, FADEIN, FADEOUT
	};
	
	public RightFinger4.SHAPE mShape = RightFinger4.SHAPE.DEFAULT;

    RightWrist mRightWrist;
    int mArmLength = 80;
    Dimension mSize = new Dimension(mArmLength, mArmLength);

    URL url;
	ColModelImporter imorter;
	MeshView mRightFinger4;
    PhongMaterial material;

    public RightFinger4(RightWrist rightWrist) {
    	mRightWrist = rightWrist;

    	imorter = new ColModelImporter();
        mColor = Color.rgb(242, 227, 217, 1);

        url = getClass().getClassLoader().getResource("BodyParts/Finger2_3_4_2.dae");

        mDefaultRotation = -20;
        mZRotation = 0;
        mToDegreeX = mDefaultRotation;

        imorter.read(url);
        mRightFinger4 = (MeshView) imorter.getImport()[0];

        material = new PhongMaterial();
		material.setDiffuseColor(mColor);
		mRightFinger4.setMaterial(material);


		mRightWrist.rightWristGroup.getChildren().add(mRightFinger4);

        init();
    }

    @Override
	public void setShape(String s) {
		SHAPE shape = SHAPE.valueOf(s);
		mShape = (shape != null) ? shape : SHAPE.DEFAULT;
	}

	@Override
	public void resetShape() {
		mShape = RightFinger4.SHAPE.DEFAULT;
	}

    @Override
    public void calculate(int step) 
    {
		Rotate rx = new Rotate(mXRotation,  Rotate.X_AXIS);
		Rotate ry = new Rotate(mYRotation,  Rotate.Y_AXIS);
		Rotate rz = new Rotate(mZRotation,  Rotate.Z_AXIS);
		
		if(mRightWrist.mRightForeArmFX.mUpperArmFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.mType == Stickman3D.TYPE.MALE)
		{
			mRightFinger4.setTranslateX(mStart.x - 6);
			mRightFinger4.setTranslateY(mStart.y + 17);
			mRightFinger4.setTranslateZ(0);
		}
		else
		{
			mRightFinger4.setTranslateX(mStart.x - 6);
			mRightFinger4.setTranslateY(mStart.y + 17);
			mRightFinger4.setTranslateZ(0);
		}
		
		mRightFinger4.getTransforms().clear();
		mRightFinger4.getTransforms().addAll(rx, ry, rz);
		
		switch(mShape)
		{
		case FADEIN:
			if(step == 2)
			{
				mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), 0.0);
				update();
				mRightFinger4.setVisible(false);
			}
			else if(mColor.getOpacity() != 0.0)
			{
				mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), mColor.getOpacity() - 0.052);
				update();
			}
			break;
			
		case FADEOUT:
			mRightFinger4.setVisible(true);
			
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
    	mRightFinger4.setMaterial(material);
    }

}
