/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanfx.bodyfx;

import java.awt.Dimension;
import java.awt.Point;
import java.net.URL;

import javafx.application.Platform;
import javafx.scene.paint.Color;
import javafx.scene.shape.MeshView;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.QuadCurveTo;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.shape.StrokeLineJoin;
import javafx.scene.transform.Affine;
import javafx.scene.transform.Rotate;

import javax.swing.text.html.CSS;

import com.interactivemesh.jfx.importer.col.ColModelImporter;

/**
 *
 * @author Beka
 *
 */
public class LeftUpperArmFX extends BodyPartFX 
{
    LeftShoulderFX mLeftShoulderFX;

    int mArmLength = 70;
    Dimension mSize = new Dimension(mArmLength, mArmLength);

    Point mStart;
    Point mEnd;

    Path mArm;
    
    URL url;
	ColModelImporter imorter;
	MeshView leftUpperArmMesh;

    public LeftUpperArmFX(LeftShoulderFX shoulder) {
        mLeftShoulderFX = shoulder;
        mColor = Color.rgb(80, 80, 80);
//        mDefaultRotation = -23;
        mZRotation = mDefaultRotation;
        mRotation = -30;
        mToDegree = mDefaultRotation;
        mRotationStep = 0.0f;
        
        url = getClass().getClassLoader().getResource("BodyParts/leftUpperArm1.dae");
		imorter = new ColModelImporter();
		imorter.read(url);
		leftUpperArmMesh = (MeshView) imorter.getImport()[0];
		
        mArm = new Path();
        this.getChildren().add(mArm);
        init();

        calculate(0);
    }

    public Point getLeftUpperArmEndPosition() 
    {
        //return (mArm != null) ? new Point((int) mArm.boundsInParentProperty().get().getMaxX(), (int) mArm.boundsInParentProperty().get().getMaxY()) : new Point(0, 0);
    	if(mRotation >= 0 && mRotation <= 90)
    		return (mArm != null) ? new Point((int) (mArm.boundsInParentProperty().get().getMinX()), (int) mArm.boundsInParentProperty().get().getMaxY()) : new Point(0, 0);
    	else if(mRotation>90 && mRotation<= 180)
    		return (mArm != null) ? new Point((int) (mArm.boundsInParentProperty().get().getMinX()), (int) mArm.boundsInParentProperty().get().getMinY()) : new Point(0, 0);
    	else if(mRotation < 0 && mRotation >= -90)
    		return (mArm != null) ? new Point((int) (mArm.boundsInParentProperty().get().getMaxX()-1), (int) mArm.boundsInParentProperty().get().getMaxY()-1) : new Point(0, 0);
    	else 
    		return (mArm != null) ? new Point((int) (mArm.boundsInParentProperty().get().getMaxX()), (int) mArm.boundsInParentProperty().get().getMinY()) : new Point(0, 0);
    }

    @Override

    public void calculate(int step) 
    {
    	mStart = mLeftShoulderFX.getLeftShoulderEndPosition();
    	clearChildren(this);
    	
    	leftUpperArmMesh.setTranslateX(mStart.x);
    	leftUpperArmMesh.setTranslateY(mStart.y);
    	leftUpperArmMesh.setTranslateZ(-100);

		Rotate rx = new Rotate(mRotation, Rotate.X_AXIS);
		Rotate ry = new Rotate(mYRotation, Rotate.Y_AXIS);
		Rotate rz = new Rotate(mZRotation, Rotate.Z_AXIS);

		leftUpperArmMesh.getTransforms().clear();
		leftUpperArmMesh.getTransforms().addAll(rx, ry, rz);
    	
//    	mArm = new Path();
//        mStart = mLeftShoulderFX.getLeftShoulderEndPosition();
//        mEnd = new Point(mStart.x, mStart.y + mArmLength);
//
//        mArm.getElements().add(new MoveTo(mStart.x, mStart.y + 2));
//        mArm.getElements().add(new QuadCurveTo(mStart.x + 5, (mStart.y + mEnd.y) / 2, mEnd.x, mEnd.y));
//
//        Affine af = new Affine();
//        af.appendRotation(mRotation, mStart.x, mStart.y);
//        mArm.getTransforms().clear();
//        mArm.getTransforms().add(af);


        this.getChildren().add(leftUpperArmMesh);

//         update();
    }

    @Override
    public void update() {
//        Color currentColor = Color.rgb(80, 80, 80);
        // draw outlines
    	if (mLeftShoulderFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.setCharacterInvisible == false)
    		mColorRecorder = mColor;
        if (mLeftShoulderFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.setCharacterInvisible == true) {
            if (mLeftShoulderFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.fadeControler == true) //Added by Robbie
            {
                int fadeFactor = mLeftShoulderFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.mMouthFX.mShapeAnimationStep * 12;
                if (fadeFactor <= 24) {
                    fadeFactor = 0;
                }
                mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), (fadeFactor * 100 / 255) / 100f);
                //mColor = Color.rgb(80, 80, 80, (fadeFactor * 100 / 255) / 100f);

            } else {
                int fadeFactor = (20 - mLeftShoulderFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.mMouthFX.mShapeAnimationStep) * 12;
                if (fadeFactor >= 216) {
                	mColor = mColorRecorder;
                }
                else
                	mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), (fadeFactor * 100 / 255) / 100f);
                //mColor = Color.rgb(80, 80, 80, (fadeFactor * 100 / 255) / 100f);

            }
        }

        mArm.setStroke(mColor);
        mArm.setStrokeWidth(3);
        mArm.setStrokeLineCap(StrokeLineCap.ROUND);
        mArm.setStrokeLineJoin(StrokeLineJoin.ROUND);
    }
}
