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
public class LeftForeArmFX extends BodyPartFX 
{

    LeftUpperArmFX mUpperArmFX;
    int mArmLength = 80;
    Dimension mSize = new Dimension(mArmLength, mArmLength);
    
    PhongMaterial material;

	Group leftForeArmGroup;
	Cylinder leftForeArm;

    public LeftForeArmFX(LeftUpperArmFX arm) {
        mUpperArmFX = arm;
        mColor = Color.rgb(242, 227, 217, 1);
        mDefaultRotation = -20;
        mXRotation = -30;
        mZRotation = 60;
        mToDegree = mDefaultRotation;
        
        leftForeArm = new Cylinder(5, mArmLength);
        
        leftForeArmGroup = new Group();
        leftForeArmGroup.setId("leftForeArmGroup");
        leftForeArmGroup.getChildren().add(leftForeArm);
        
        material = new PhongMaterial();
		material.setDiffuseColor(mColor);
		
		leftForeArm.setMaterial(material);
		
		mUpperArmFX.leftUpperArmGroup.getChildren().add(leftForeArmGroup);
        
        init();
    }


    @Override
    public void calculate(int step) 
    {
		Rotate rx = new Rotate(mXRotation, 0, -leftForeArm.getHeight()/2, 0, Rotate.X_AXIS);
		Rotate ry = new Rotate(mYRotation, 0, -leftForeArm.getHeight()/2, 0, Rotate.Y_AXIS);
		Rotate rz = new Rotate(mZRotation, 0, -leftForeArm.getHeight()/2, 0, Rotate.Z_AXIS);
		
		if(mUpperArmFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.MALE)
		{
			leftForeArmGroup.setTranslateX(mStart.x);
			leftForeArmGroup.setTranslateY(mStart.y+81);
			leftForeArmGroup.setTranslateZ(0);
		}
		else
		{
			leftForeArmGroup.setTranslateX(mStart.x);
			leftForeArmGroup.setTranslateY(mStart.y + 81);
			leftForeArmGroup.setTranslateZ(0);
		}
		
		leftForeArmGroup.getTransforms().clear();
		leftForeArmGroup.getTransforms().addAll(rx, ry, rz);
		
//		if (step == 0) 
//		{
//			mUpperArmFX.leftUpperArmGroup.getChildren().add(leftForeArmGroup);
//			System.out.println(mUpperArmFX.leftUpperArmGroup.getChildren());
//		}
//		else
//			mUpperArmFX.leftUpperArmGroup.getChildren().set(2, leftForeArmGroup);
		
//		
//		
//		Translate translate = (Translate) leftForeArmMesh.getTransforms().get(0);
//		Scale scale = (Scale) leftForeArmMesh.getTransforms().get(4);
//		leftForeArmMesh.getTransforms().clear();
//		leftForeArmMesh.getTransforms().addAll(translate, rx, ry, rz, scale);
//
//		mUpperArmFX.mBodyFX.updateAfterRotation();
		
//        update();
    }

    @Override
    public void update() {
    	material.setDiffuseColor(mColor);
    	leftForeArm.setMaterial(material);
////        Color currentColor = Color.rgb(80, 80, 80);
//        // draw outlines
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
//
////		g2.setStroke(new BasicStroke(3, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
////
////		g2.draw(mArm);
    }

}
