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
public class LeftWrist extends BodyPartFX 
{
	
	public static enum SHAPE {
		DEFAULT, FADEIN, FADEOUT
	};
	
	public LeftWrist.SHAPE mShape = LeftWrist.SHAPE.DEFAULT;

    LeftForeArmFX mLeftForeArmFX;
    int mArmLength = 80;
    Dimension mSize = new Dimension(mArmLength, mArmLength);

    URL url;
	ColModelImporter imorter;
	MeshView mLeftWristMesh;
    PhongMaterial material;

	Group leftWristGroup;

    public LeftWrist(LeftForeArmFX leftForeArmFX) {
        mLeftForeArmFX = leftForeArmFX;

        imorter = new ColModelImporter();
        mColor = Color.rgb(242, 227, 217, 1);

        url = getClass().getClassLoader().getResource("BodyParts/LeftWrist.dae");

        mToDegreeX = mDefaultRotation;
        mZRotation = 0;

        imorter.read(url);
        mLeftWristMesh = (MeshView) imorter.getImport()[0];

        material = new PhongMaterial();
		material.setDiffuseColor(mColor);
		mLeftWristMesh.setMaterial(material);

        leftWristGroup = new Group();
        leftWristGroup.setId("LeftWrist");

        leftWristGroup.getChildren().add(mLeftWristMesh);

		mLeftForeArmFX.leftForeArmGroup.getChildren().add(leftWristGroup);

        init();
    }

    @Override
	public void setShape(String s) {
		SHAPE shape = SHAPE.valueOf(s);
		mShape = (shape != null) ? shape : SHAPE.DEFAULT;
	}

	@Override
	public void resetShape() {
		mShape = LeftWrist.SHAPE.DEFAULT;
	}

    @Override
    public void calculate(int step) 
    {
		Rotate rx = new Rotate(mXRotation,  Rotate.X_AXIS);
		Rotate ry = new Rotate(mYRotation,  Rotate.Y_AXIS);
		Rotate rz = new Rotate(mZRotation,  Rotate.Z_AXIS);
		
		if(mLeftForeArmFX.mUpperArmFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.mType == Gender.TYPE.MALE)
		{
			leftWristGroup.setTranslateX(mStart.x);
			leftWristGroup.setTranslateY(mStart.y+70);
			leftWristGroup.setTranslateZ(0);
		}
		else
		{
			leftWristGroup.setTranslateX(mStart.x);
			leftWristGroup.setTranslateY(mStart.y + 70);
			leftWristGroup.setTranslateZ(0);
		}
		
		leftWristGroup.getTransforms().clear();
		leftWristGroup.getTransforms().addAll(rx, ry, rz);
		
		switch(mShape)
		{
		case FADEIN:
			if(step == 2)
			{
				mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), 0.0);
				update();
				mLeftWristMesh.setVisible(false);
			}
			else if(mColor.getOpacity() != 0.0)
			{
				mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), mColor.getOpacity() - 0.052);
				update();
			}
			break;
			
		case FADEOUT:
			mLeftWristMesh.setVisible(true);
			
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
    	mLeftWristMesh.setMaterial(material);
    }

}
