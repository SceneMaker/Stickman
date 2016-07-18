/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman.body;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;

/**
 *
 * @author Beka Aptsiauri
 *
 */
public class RightHandFinger_4 extends BodyPart 
{
	RightForeArm mRightForeArm;
        int animationsStep = 0;
        
	public RightHandFinger_4(RightForeArm rfa) 
        {
		mRightForeArm = rfa;
		mLength = 10;
		mSize = new Dimension(mLength, mLength);

		mColor = new Color(80, 80, 80);
		mStroke = new BasicStroke(2.5f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);

		setDefaulRotation(-30);
                
		init();
	}
        
         @Override
	public void createShape() 
        {
            mStart = mRightForeArm.getHandStartPosition();
            
            if(mRightForeArm.mUpperArm.mRightShoulder.mBody.mNeck.mHead.mStickman.mRightFinger4LengthController)
            {
                mLength-=animationsStep;
                if(mLength<5)
                    mLength = 4;
                mEnd = new Point(mStart.x, mStart.y + mLength);
            }
            else
            {
                mLength = 10;
                mEnd = new Point(mStart.x, mStart.y + mLength);
            }
            

            clearDrawObjects();
		
            if(mRightForeArm.mUpperArm.mRightShoulder.mBody.mNeck.mHead.mStickman.setCharacterInvisible == true)
            {
                if(mRightForeArm.mUpperArm.mRightShoulder.mBody.mNeck.mHead.mStickman.fadeControler==true)             //Added by Robbie
		{
                    int fadeFactor = mRightForeArm.mUpperArm.mRightShoulder.mBody.mNeck.mHead.mStickman.mMouth.mShapeAnimationStep*12;
                    if(fadeFactor<=24) fadeFactor=0;
                    mColor = new Color(80, 80, 80, fadeFactor);
		}
                else
		{
                    int fadeFactor = (20-mRightForeArm.mUpperArm.mRightShoulder.mBody.mNeck.mHead.mStickman.mMouth.mShapeAnimationStep)*12;
                    if(fadeFactor >= 216) fadeFactor=255;
                    mColor = new Color(80, 80, 80, fadeFactor);
                }
            }

		GeneralPath gp = new GeneralPath();
		gp.moveTo(mStart.x - 1, mStart.y);
		gp.lineTo(mEnd.x-3, mEnd.y - 2);

		addToDrawObjects(gp);
	}
        
         @Override
	public void calculate(int step) {
		animationsStep = step;
		createShape();

                AffineTransform t = new AffineTransform();
                if (mRotation  < -60) {
			t.scale(-1.0, 1.0);
			t.translate(-mStart.x * 2, 0);
		}
                
                t.rotate(Math.toRadians(mRotation), mStart.x, mStart.y);
                for (GeneralPath g : mGraphicPaths) 
                {
                    g.transform(t);
                }
	}
        
        
}
