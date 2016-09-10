/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanfx.bodyfx;

import de.dfki.stickman.body.*;
import de.dfki.stickmanfx.StickmanFX;
import de.dfki.stickmanfx.animationlogic.AnimatorFX;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.geom.GeneralPath;
import java.net.URL;

import com.interactivemesh.jfx.importer.col.ColModelImporter;

import javafx.scene.paint.Color;
import javafx.scene.shape.MeshView;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.QuadCurveTo;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.shape.StrokeLineJoin;
import javafx.scene.transform.Affine;
import javafx.scene.transform.Rotate;

/**
 *
 * @author Beka
 *
 */
public class LeftForeLegFX extends BodyPartFX {

    LeftUpperLegFX mUpperLegFX;
    int mLegLength;
    Dimension mSize = new Dimension(10, mLegLength);
    
    Point mStart;
    Point mEnd;
    
    Path mLeg;
    
    URL url;
	ColModelImporter imorter;
	MeshView leftForeLeg;

    public LeftForeLegFX(LeftUpperLegFX leftUpperLegFX) 
    {
        mUpperLegFX = leftUpperLegFX;
        if(mUpperLegFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.MALE)
        	mLegLength = 90;
        else
        	mLegLength = 92;
        mDefaultRotation = -2;
		mRotation = mDefaultRotation;
		mToDegree = mDefaultRotation;
		 mColor = Color.rgb(80, 80, 80);
		mLeg = new Path();
		this.getChildren().add(mLeg);
		
		url = getClass().getClassLoader().getResource("BodyParts/RightForeLeg.dae");
		imorter = new ColModelImporter();
		imorter.read(url);
		leftForeLeg = (MeshView) imorter.getImport()[0];

        init();
        
        calculate(0);
    }
    
    public Point getLegStartPosition() 
    {
    	if (AnimatorFX.sCurrentAction == null || AnimatorFX.sCurrentAction.equals("rotate")) 
		{
				if(mRotation>=0 && mRotation <=90)
				{
					if(mZRotation >=0 && mZRotation <= 90)
					{
						int minX = (int) (leftForeLeg.boundsInParentProperty().get().getMinX() + 4);
						int maxY = (int) (leftForeLeg.boundsInParentProperty().get().getMaxY() - 5);
						return new Point(minX, maxY);
					}
					else if(mZRotation > 90 && mZRotation <=180)
					{
						int minX = (int) (leftForeLeg.boundsInParentProperty().get().getMinX() + 4); /////////////
						int minY = (int) (leftForeLeg.boundsInParentProperty().get().getMinY() + 5);
						return new Point(minX, minY);
					}
					else if(mZRotation <0 && mZRotation >= -90)//////////////
					{
						int maxX = (int) (leftForeLeg.boundsInParentProperty().get().getMaxX() - 4);
						int maxY = (int) (leftForeLeg.boundsInParentProperty().get().getMaxY() - 5);
						return new Point(maxX, maxY);
					}
					else if(mZRotation < -90 && mZRotation >= -180)
					{
						int maxX = (int) (leftForeLeg.boundsInParentProperty().get().getMaxX() - 4);//////////////////
						int minY = (int) (leftForeLeg.boundsInParentProperty().get().getMinY() + 5);//<-------
						return new Point(maxX, minY);
					}
				}
				else if (mRotation > 90 && mRotation <= 180)
				{
					if(mZRotation >=0 && mZRotation <= 90)
					{
						int minX = (int) (leftForeLeg.boundsInParentProperty().get().getMinX() + 4);
						int minY = (int) (leftForeLeg.boundsInParentProperty().get().getMinY() + 5);
						return new Point(minX, minY);
					}
					else if(mZRotation > 90 && mZRotation <=180)
					{
						int minX = (int) (leftForeLeg.boundsInParentProperty().get().getMinX() + 4);
						int maxY = (int) (leftForeLeg.boundsInParentProperty().get().getMaxY() - 5);
						return new Point(minX, maxY);
					}
					else if(mZRotation <0 && mZRotation >= -90)
					{
						int maxX = (int) (leftForeLeg.boundsInParentProperty().get().getMaxX() - 4);
						int minY = (int) (leftForeLeg.boundsInParentProperty().get().getMinY() + 5);
						return new Point(maxX, minY);
					}
					else if(mZRotation < -90 && mZRotation >= -180)
					{
						int maxX = (int) (leftForeLeg.boundsInParentProperty().get().getMaxX() - 4);
						int maxY = (int) (leftForeLeg.boundsInParentProperty().get().getMaxY() - 5);
						return new Point(maxX, maxY);
					}
				}
				else if (mRotation < 0 && mRotation >= -90)
				{
					if(mZRotation >=0 && mZRotation <= 90)
					{
						int minX = (int) (leftForeLeg.boundsInParentProperty().get().getMinX() + 4);
						int maxY = (int) (leftForeLeg.boundsInParentProperty().get().getMaxY() - 5);
						return new Point(minX, maxY);
					}
					else if(mZRotation > 90 && mZRotation <=180)
					{
						int minX = (int) (leftForeLeg.boundsInParentProperty().get().getMinX() + 4);
						int minY = (int) (leftForeLeg.boundsInParentProperty().get().getMinY() + 5);
						return new Point(minX, minY);
					}
					else if(mZRotation <0 && mZRotation >= -90)
					{
						int maxX = (int) (leftForeLeg.boundsInParentProperty().get().getMaxX() - 4);
						int maxY = (int) (leftForeLeg.boundsInParentProperty().get().getMaxY() - 5);
						return new Point(maxX, maxY);
					}
					else if(mZRotation < -90 && mZRotation >= -180)
					{
						int maxX = (int) (leftForeLeg.boundsInParentProperty().get().getMaxX() - 4);
						int minY = (int) (leftForeLeg.boundsInParentProperty().get().getMinY() + 5);
						return new Point(maxX, minY);
					}
				}
				else if (mRotation < -90 && mRotation >= -180)
				{
					if(mZRotation >=0 && mZRotation <= 90)
					{
						int minX = (int) (leftForeLeg.boundsInParentProperty().get().getMinX() + 4);
						int minY = (int) (leftForeLeg.boundsInParentProperty().get().getMinY() + 5);
						return new Point(minX, minY);
					}
					else if(mZRotation > 90 && mZRotation <=180)
					{
						int minX = (int) (leftForeLeg.boundsInParentProperty().get().getMinX() + 4);
						int maxY = (int) (leftForeLeg.boundsInParentProperty().get().getMaxY() - 5);
						return new Point(minX, maxY);
					}
					else if(mZRotation <0 && mZRotation >= -90)
					{
						int maxX = (int) (leftForeLeg.boundsInParentProperty().get().getMaxX() - 4);
						int minY = (int) (leftForeLeg.boundsInParentProperty().get().getMinY() + 5);
						return new Point(maxX, minY);
					}
					else if(mZRotation < -90 && mZRotation >= -180)
					{
						int maxX = (int) (leftForeLeg.boundsInParentProperty().get().getMaxX() - 4);
						int maxY = (int) (leftForeLeg.boundsInParentProperty().get().getMaxY() - 5);
						return new Point(maxX, maxY);
					}
				}
		} 
		else if (AnimatorFX.sCurrentAction.equals("zrotate")) 
		{
			if(mZRotation>=0 && mZRotation <=90)
			{
				if(mRotation >=0 && mRotation <= 90)
				{
					int minX = (int) (leftForeLeg.boundsInParentProperty().get().getMinX() + 4);
					int maxY = (int) (leftForeLeg.boundsInParentProperty().get().getMaxY() - 5);
					return new Point(minX, maxY);
				}
				else if(mRotation > 90 && mRotation <=180)
				{
					int minX = (int) (leftForeLeg.boundsInParentProperty().get().getMinX() + 4);
					int minY = (int) (leftForeLeg.boundsInParentProperty().get().getMinY() + 5);
					return new Point(minX, minY);
				}
				else if(mRotation <0 && mRotation >= -90)
				{
					int minX = (int) (leftForeLeg.boundsInParentProperty().get().getMinX() + 4);
					int maxY = (int) (leftForeLeg.boundsInParentProperty().get().getMaxY() - 5);
					return new Point(minX, maxY);
				}
				else if(mRotation < -90 && mRotation >= -180)
				{
					int maxX = (int) (leftForeLeg.boundsInParentProperty().get().getMinX() + 4);
					int minY = (int) (leftForeLeg.boundsInParentProperty().get().getMinY() + 5);
					return new Point(maxX, minY);
				}
			}
			else if (mZRotation > 90 && mZRotation <= 180)
			{
				if(mRotation >=	0 && mRotation <= 90)
				{
					int minX = (int) (leftForeLeg.boundsInParentProperty().get().getMinX() + 4);
					int minY = (int) (leftForeLeg.boundsInParentProperty().get().getMinY() + 5);
					return new Point(minX, minY);
				}
				else if(mRotation > 90 && mRotation <=180)
				{
					int maxX = (int) (leftForeLeg.boundsInParentProperty().get().getMinX() + 4);
					int maxY = (int) (leftForeLeg.boundsInParentProperty().get().getMaxY() - 5);
					return new Point(maxX, maxY);
				}
				else if(mRotation <0 && mRotation >= -90)
				{
					int minX = (int) (leftForeLeg.boundsInParentProperty().get().getMinX() + 4);
					int minY = (int) (leftForeLeg.boundsInParentProperty().get().getMinY() + 5);
					return new Point(minX, minY);
				}
				else if(mRotation < -90 && mRotation >= -180)
				{
					int maxX = (int) (leftForeLeg.boundsInParentProperty().get().getMinX() + 4);
					int maxY = (int) (leftForeLeg.boundsInParentProperty().get().getMaxY() - 5);
					return new Point(maxX, maxY);
				}
			}
			else if (mZRotation < 0 && mZRotation >= -90)
			{
				if(mRotation >=0 && mRotation <= 90)
				{
					int maxX = (int) (leftForeLeg.boundsInParentProperty().get().getMaxX() - 4);
					int maxY = (int) (leftForeLeg.boundsInParentProperty().get().getMaxY() - 5);
					return new Point(maxX, maxY);
				}
				else if(mRotation > 90 && mRotation <=180)
				{
					int minX = (int) (leftForeLeg.boundsInParentProperty().get().getMaxX() - 4);
					int minY = (int) (leftForeLeg.boundsInParentProperty().get().getMinY() + 5);
					return new Point(minX, minY);
				}
				else if(mRotation <0 && mRotation >= -90)
				{
					int maxX = (int) (leftForeLeg.boundsInParentProperty().get().getMaxX() - 4);
					int maxY = (int) (leftForeLeg.boundsInParentProperty().get().getMaxY() - 5);
					return new Point(maxX, maxY);
				}
				else if(mRotation < -90 && mRotation >= -180)
				{
					int minX = (int) (leftForeLeg.boundsInParentProperty().get().getMaxX() - 4);
					int minY = (int) (leftForeLeg.boundsInParentProperty().get().getMinY() + 5);
					return new Point(minX, minY);
				}
			}
			else if (mZRotation < -90 && mZRotation >= -180)
			{
				if(mRotation >=0 && mRotation <= 90)
				{
					int maxX = (int) (leftForeLeg.boundsInParentProperty().get().getMaxX() - 4);
					int minY = (int) (leftForeLeg.boundsInParentProperty().get().getMinY() + 5);
					return new Point(maxX, minY);
				}
				else if(mRotation > 90 && mRotation <=180)
				{
					int minX = (int) (leftForeLeg.boundsInParentProperty().get().getMaxX() - 4);
					int maxY = (int) (leftForeLeg.boundsInParentProperty().get().getMaxY() - 5);
					return new Point(minX, maxY);
				}
				else if(mRotation <0 && mRotation >= -90)
				{
					int maxX = (int) (leftForeLeg.boundsInParentProperty().get().getMaxX() - 4);
					int minY = (int) (leftForeLeg.boundsInParentProperty().get().getMinY() + 5);
					return new Point(maxX, minY);
				}
				else if(mRotation < -90 && mRotation >= -180)
				{
					int minX = (int) (leftForeLeg.boundsInParentProperty().get().getMaxX() - 4);
					int maxY = (int) (leftForeLeg.boundsInParentProperty().get().getMaxY() - 5);
					return new Point(minX, maxY);
				}
			}
			
		} 
		return new Point(0, 0);
    }
    
    @Override
    public void calculate(int step)
    {
    	mStart = mUpperLegFX.getLeftUpperLegEndPosition();
    	clearChildren(this);
    	
    	leftForeLeg.setTranslateX(mStart.x);
    	leftForeLeg.setTranslateY(mStart.y);
    	leftForeLeg.setTranslateZ(-100);

		Rotate rx = new Rotate(mRotation, Rotate.X_AXIS);
		Rotate ry = new Rotate(mYRotation, Rotate.Y_AXIS);
		Rotate rz = new Rotate(mZRotation, Rotate.Z_AXIS);

		leftForeLeg.getTransforms().clear();
		leftForeLeg.getTransforms().addAll(rx, ry, rz);

    	
//    	mLeg = new Path();
//    	
//    	mStart = mUpperLegFX.getLeftUpperLegEndPosition();
//    	mEnd = new Point(mStart.x, mStart.y + mLegLength);
//    	
//    	mLeg.getElements().add(new MoveTo(mStart.x, mStart.y + 1));
//    	mLeg.getElements().add(new QuadCurveTo(mStart.x + 2, (mStart.y + mEnd.y) / 2, mEnd.x, mEnd.y));
//    	
//    	Affine af = new Affine();
//    	af.appendRotation(mRotation, mStart.x, mStart.y);
//    	af.appendTranslation(mTranslation, 0);
//    	mLeg.getTransforms().clear();
//    	mLeg.getTransforms().add(af);
    	
		if(mUpperLegFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.mLeftFootFX != null)
			mUpperLegFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.mLeftFootFX.calculate(step);
    	this.getChildren().add(leftForeLeg);
//    	this.update();
    }
    
    @Override
	public void update() 
	{
    	if (mUpperLegFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.setCharacterInvisible == false) 
    		mColorRecorder = mColor;
    	if (mUpperLegFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.setCharacterInvisible == true) 
        {
            if (mUpperLegFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.fadeControler == true) //Added by Robbie
            {
                int fadeFactor = mUpperLegFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.mMouthFX.mShapeAnimationStep * 12;
                if (fadeFactor <= 24) 
                {
                    fadeFactor = 0;
                }
                mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), (fadeFactor * 100 / 255) / 100f);
                //mColor = Color.rgb(80, 80, 80, (fadeFactor*100/255)/100f);
            } 
            else 
            {
                int fadeFactor = (20 - mUpperLegFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.mMouthFX.mShapeAnimationStep) * 12;
                if (fadeFactor >= 216) 
                {
                	mColor = mColorRecorder;
                }
                else
                	mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), (fadeFactor * 100 / 255) / 100f);
                //mColor = Color.rgb(80, 80, 80, (fadeFactor*100/255)/100f);
            }
        }
    	
    	mLeg.setStroke(mColor);
    	mLeg.setStrokeWidth(3);
    	mLeg.setStrokeLineCap(StrokeLineCap.ROUND);
    	mLeg.setStrokeLineJoin(StrokeLineJoin.ROUND);
	}
}
