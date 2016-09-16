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

import de.dfki.stickmanfx.animationlogic.AnimatorFX;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.paint.Color;
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
public class RightFinger4 extends BodyPartFX 
{

    RightWrist mRightWrist;
    int mArmLength = 80;
    Dimension mSize = new Dimension(mArmLength, mArmLength);

	MeshView RightFinger_4;

    public RightFinger4(RightWrist rightWrist) {
    	mRightWrist = rightWrist;
        mColor = Color.rgb(80, 80, 80);
        mDefaultRotation = -20;
        mXRotation = 7;
        mYRotation = 6;
        mZRotation = 200;
        mToDegree = mDefaultRotation;
        
        RightFinger_4 = (MeshView) mRightWrist.rightWrist.getChildren().get(4);
        
        init();
        calculate(0);
    }


    @Override
    public void calculate(int step) 
    {
		Rotate rx = new Rotate(mXRotation, Rotate.X_AXIS);
		Rotate ry = new Rotate(mYRotation, Rotate.Y_AXIS);
		Rotate rz = new Rotate(mZRotation, Rotate.Z_AXIS);
		
		
		Translate translate = (Translate) RightFinger_4.getTransforms().get(0);
		Scale scale = (Scale) RightFinger_4.getTransforms().get(4);
		RightFinger_4.getTransforms().clear();
		RightFinger_4.getTransforms().addAll(translate, rx, ry, rz, scale);

		mRightWrist.mRightForeArmFX.mUpperArmFX.mBodyFX.updateAfterRotation();
		
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
