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
public class LeftUpperLeg extends BodyPart 
{

	Body mBody;
        
        Point mStart;
        Point mEnd;
        
        GeneralPath mLeg;

	public LeftUpperLeg(Body body) 
        {
		mBody = body;
		mLength = 60;
		mSize = new Dimension(10, mLength);
		mColor = new Color(80, 80, 80);
                
                mDefaultRotation = 0;
		mRotation = mDefaultRotation;
		mToDegree = mDefaultRotation;
		mRotationStep = 0.0f;

		init();
                
                calculate(0);
	}
        
        @Override
	public void calculate(int step) 
        {  
            mStart = mBody.getLeftLegStartPostion();
            mEnd = new Point(mStart.x, mStart.y + mLength);

            mLeg = new GeneralPath();
            mLeg.moveTo(mStart.x, mStart.y + 2);
            mLeg.quadTo(mStart.x + 2, (mStart.y + mEnd.y) / 2, mEnd.x, mEnd.y);
                
            AffineTransform t = new AffineTransform();
            t.rotate(Math.toRadians(mRotation), mStart.x, mStart.y);
            mLeg.transform(t);
	}
        
        public Point getLeftUpperLegEndPosition() 
        {
		return (mLeg != null) ? new Point((int) mLeg.getCurrentPoint().getX(), (int) mLeg.getCurrentPoint().getY()) : new Point(0, 0);
	}

                //Terfi
//		gp = new GeneralPath();
//		gp.moveTo(mEnd.x - 5, mEnd.y + 4);
//		gp.quadTo(mEnd.x, mEnd.y + 2, mEnd.x + 5, mEnd.y + 4);
//		addToDrawObjects(gp);
//	}
        
        @Override
	protected void paintComponent(Graphics g) 
        {
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		// draw outlines
		g2.setColor(new Color(80, 80, 80));
		
		if(mBody.mNeck.mHead.mStickman.setCharacterInvisible == true)
		{
			if(mBody.mNeck.mHead.mStickman.fadeControler==true)             //Added by Robbie
			{
				int fadeFactor = mBody.mNeck.mHead.mStickman.mMouth.mShapeAnimationStep*12;
				if(fadeFactor<=24) fadeFactor=0;
				g2.setColor(new Color(80, 80, 80,fadeFactor));
			}
			else
			{
				int fadeFactor = (20-mBody.mNeck.mHead.mStickman.mMouth.mShapeAnimationStep)*12;
				if(fadeFactor >= 216) fadeFactor=255;
				g2.setColor(new Color(80, 80, 80,fadeFactor));
			}
		}
		
		g2.setStroke(new BasicStroke(3, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));

		g2.draw(mLeg);
	}
}
