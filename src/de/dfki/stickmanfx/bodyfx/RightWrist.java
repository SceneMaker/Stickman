/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanfx.bodyfx;

import java.awt.Dimension;
import java.awt.Point;
import java.net.URL;

import com.interactivemesh.jfx.importer.col.ColModelImporter;

import de.dfki.stickmanfx.StickmanFX;
import de.dfki.stickmanfx.animationlogic.AnimatorFX;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Cylinder;
import javafx.scene.shape.MeshView;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.QuadCurveTo;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.shape.StrokeLineJoin;
import javafx.scene.transform.Affine;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;
import javafx.scene.transform.Translate;

/**
 *
 * @author Beka
 *
 */
public class RightWrist extends BodyPartFX 
{

    RightForeArmFX mRightForeArmFX;
    int mArmLength = 80;
    Dimension mSize = new Dimension(mArmLength, mArmLength);

    PhongMaterial material;

	Group rightWristGroup;
	Cylinder rightWrist;

    public RightWrist(RightForeArmFX rightForeArmFX) {
    	mRightForeArmFX = rightForeArmFX;
        mColor = Color.rgb(242, 227, 217, 1);
        mDefaultRotation = -20;
        mToDegree = mDefaultRotation;
        
        rightWrist = new Cylinder(9, 7);
        rightWristGroup = new Group();
        rightWristGroup.setId("LeftWrist");
        
        rightWristGroup.getChildren().add(rightWrist);
        
        material = new PhongMaterial();
		material.setDiffuseColor(mColor);
		
		rightWrist.setMaterial(material);
		
		rightWrist.setRotationAxis(Rotate.X_AXIS);
		rightWrist.setRotate(90);
		
		mRightForeArmFX.rightForeArmGroup.getChildren().add(rightWristGroup);
		
		
        init();
    }


    @Override
    public void calculate(int step) 
    {
    	Rotate rx = new Rotate(mXRotation, 0, -rightWrist.getHeight(), 0, Rotate.X_AXIS);
		Rotate ry = new Rotate(mYRotation, 0, -rightWrist.getHeight(), 0, Rotate.Y_AXIS);
		Rotate rz = new Rotate(mZRotation, 0, -rightWrist.getHeight(), 0, Rotate.Z_AXIS);
		
		if(mRightForeArmFX.mUpperArmFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.MALE)
		{
			rightWristGroup.setTranslateX(mStart.x);
			rightWristGroup.setTranslateY(mStart.y+47);
			rightWristGroup.setTranslateZ(0);
		}
		else
		{
			rightWristGroup.setTranslateX(mStart.x);
			rightWristGroup.setTranslateY(mStart.y + 47);
			rightWristGroup.setTranslateZ(0);
		}
		
		rightWristGroup.getTransforms().clear();
		rightWristGroup.getTransforms().addAll(rx, ry, rz);
//        update();
    }

    @Override
    public void update() {
//        Color currentColor = Color.rgb(80, 80, 80);
        // draw outlines
//    	if (mUpperArmFX.mLeftShoulderFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.setCharacterInvisible == false) {
//    		mColorRecorder = mColor;
//    	}
//        if (mUpperArmFX.mLeftShoulderFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.setCharacterInvisible == true) {
//            if (mUpperArmFX.mLeftShoulderFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.fadeControler == true) //Added by Robbie
//            {
//                int fadeFactor = mUpperArmFX.mLeftShoulderFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.mMouthFX.mShapeAnimationStep * 12;
//                if (fadeFactor <= 24) {
//                    fadeFactor = 0;
//                }
//                mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), (fadeFactor * 100 / 255) / 100f);
//                //mColor = Color.rgb(80, 80, 80, (fadeFactor * 100 / 255) / 100f);
//                //g2.setColor(new Color(80, 80, 80,fadeFactor));
//            } else {
//                int fadeFactor = (20 - mUpperArmFX.mLeftShoulderFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.mMouthFX.mShapeAnimationStep) * 12;
//                if (fadeFactor >= 216) {
//                	mColor = mColorRecorder;
//                }
//                else
//                	mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), (fadeFactor * 100 / 255) / 100f);
//                //mColor = Color.rgb(80, 80, 80, (fadeFactor * 100 / 255) / 100f);
//                //g2.setColor(new Color(80, 80, 80,fadeFactor));
//            }
//        }

//		g2.setStroke(new BasicStroke(3, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
//
//		g2.draw(mArm);
    }

}
