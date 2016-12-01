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
public class LeftForeArmFX extends BodyPartFX 
{
	
	public static enum SHAPE {
		DEFAULT, FADEIN, FADEOUT
	};
	
	public LeftForeArmFX.SHAPE mShape = LeftForeArmFX.SHAPE.DEFAULT;

    LeftUpperArmFX mUpperArmFX;
    int mArmLength = 80;
    Dimension mSize = new Dimension(mArmLength, mArmLength);

    URL url;
	ColModelImporter imorter;
	MeshView mLeftForeArmMesh;
    PhongMaterial material;

	Group leftForeArmGroup;

    public LeftForeArmFX(LeftUpperArmFX arm) {
        mUpperArmFX = arm;

        imorter = new ColModelImporter();
        mColor = Color.rgb(242, 227, 217, 1);

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

    @Override
	public void setShape(String s) {
		SHAPE shape = SHAPE.valueOf(s);
		mShape = (shape != null) ? shape : SHAPE.DEFAULT;
	}

	@Override
	public void resetShape() {
		mShape = LeftForeArmFX.SHAPE.DEFAULT;
	}

    @Override
    public void calculate(int step) 
    {
		Rotate rx = new Rotate(mXRotation,  Rotate.X_AXIS);
		Rotate ry = new Rotate(mYRotation,  Rotate.Y_AXIS);
		Rotate rz = new Rotate(mZRotation,  Rotate.Z_AXIS);

		if(mUpperArmFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.mType == Gender.TYPE.MALE)
		{
			leftForeArmGroup.setTranslateX(mStart.x);
			leftForeArmGroup.setTranslateY(mStart.y+60);
			leftForeArmGroup.setTranslateZ(0);
		}
		else
		{
			leftForeArmGroup.setTranslateX(mStart.x);
			leftForeArmGroup.setTranslateY(mStart.y + 60);
			leftForeArmGroup.setTranslateZ(0);
		}
		
		leftForeArmGroup.getTransforms().clear();
		leftForeArmGroup.getTransforms().addAll(rx, ry, rz);
		
		switch(mShape)
		{
		case FADEIN:
			if(step == 2)
			{
				mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), 0.0);
				update();
				mLeftForeArmMesh.setVisible(false);
			}
			else if(mColor.getOpacity() != 0.0)
			{
				mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), mColor.getOpacity() - 0.052);
				update();
			}
			break;
			
		case FADEOUT:
			mLeftForeArmMesh.setVisible(true);
			
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
    	mLeftForeArmMesh.setMaterial(material);
    }

}
