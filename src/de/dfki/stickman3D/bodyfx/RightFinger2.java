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
public class RightFinger2 extends BodyPartFX 
{

	public static enum SHAPE {
		DEFAULT, FADEIN, FADEOUT
	};
	
	public RightFinger2.SHAPE mShape = RightFinger2.SHAPE.DEFAULT;

    RightWrist mRightWrist;
    int mArmLength = 80;
    Dimension mSize = new Dimension(mArmLength, mArmLength);

    URL url;
	ColModelImporter imorter;
	MeshView mRightFinger2;
    PhongMaterial material;

    public RightFinger2(RightWrist rightWrist) {
    	mRightWrist = rightWrist;

    	imorter = new ColModelImporter();
        mColor = Color.rgb(242, 227, 217, 1);

        url = getClass().getClassLoader().getResource("BodyParts/Finger2_3_4_2.dae");

        mDefaultRotation = -20;
        mZRotation = 0;
        mToDegreeX = mDefaultRotation;

        imorter.read(url);
        mRightFinger2 = (MeshView) imorter.getImport()[0];

        material = new PhongMaterial();
		material.setDiffuseColor(mColor);
		mRightFinger2.setMaterial(material);

		mRightWrist.rightWristGroup.getChildren().add(mRightFinger2);

        init();
    }

    @Override
	public void setShape(String s) {
		SHAPE shape = SHAPE.valueOf(s);
		mShape = (shape != null) ? shape : SHAPE.DEFAULT;
	}

	@Override
	public void resetShape() {
		mShape = RightFinger2.SHAPE.DEFAULT;
	}

    @Override
    public void calculate(int step) 
    {
		Rotate rx = new Rotate(mXRotation,  Rotate.X_AXIS);
		Rotate ry = new Rotate(mYRotation,  Rotate.Y_AXIS);
		Rotate rz = new Rotate(mZRotation,  Rotate.Z_AXIS);
		
		if(mRightWrist.mRightForeArmFX.mUpperArmFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.mType == Stickman3D.TYPE.MALE)
		{
			mRightFinger2.setTranslateX(mStart.x + 3);
			mRightFinger2.setTranslateY(mStart.y + 17);
			mRightFinger2.setTranslateZ(0);
		}
		else
		{
			mRightFinger2.setTranslateX(mStart.x + 3);
			mRightFinger2.setTranslateY(mStart.y + 17);
			mRightFinger2.setTranslateZ(0);
		}
		
		mRightFinger2.getTransforms().clear();
		mRightFinger2.getTransforms().addAll(rx, ry, rz);
		
		switch(mShape)
		{
		case FADEIN:
			if(step == 2)
			{
				mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), 0.0);
				update();
				mRightFinger2.setVisible(false);
			}
			else if(mColor.getOpacity() != 0.0)
			{
				mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), mColor.getOpacity() - 0.052);
				update();
			}
			break;
			
		case FADEOUT:
			mRightFinger2.setVisible(true);
			
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
    	mRightFinger2.setMaterial(material);
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
