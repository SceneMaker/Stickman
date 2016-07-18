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
public class RightFoot extends BodyPart {

	RightForeLeg mRightForeLeg;
        
        GeneralPath mLeg;
        
        Point mStart;
        Point mEnd;

	public RightFoot(RightForeLeg rightForeLeg) {
		mRightForeLeg = rightForeLeg;
                System.out.println("de.dfki.stickman.body.RightFoot.<init>() " + mRightForeLeg); 
		mLength = 10;
		//mSize = new Dimension(10, 80);

		mColor = new Color(80, 80, 80);
		mStroke = new BasicStroke(2.5f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);

		setDefaulRotation(0);

		init();
                calculate(0);
	}

	
        @Override
	public void calculate(int step) {
		mStart = mRightForeLeg.getLegStartPosition();
		mEnd = new Point(mStart.x, mStart.y);

      		mLeg = new GeneralPath();
		mLeg.moveTo(mEnd.x - 10, mEnd.y + 4);
		mLeg.quadTo(mEnd.x, mEnd.y + 2, mEnd.x + 5, mEnd.y + 4);
		
		AffineTransform t = new AffineTransform();
		t.rotate(Math.toRadians(mRotation), mStart.x, mStart.y);
		mLeg.transform(t);
	}
        
        @Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.

		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		// draw outlines
		g2.setColor(new Color(80, 80, 80));
		
		if(mRightForeLeg.mUpperLeg.mBody.mNeck.mHead.mStickman.setCharacterInvisible == true)
		{
			if(mRightForeLeg.mUpperLeg.mBody.mNeck.mHead.mStickman.fadeControler==true)             //Added by Robbie
			{
				int fadeFactor = mRightForeLeg.mUpperLeg.mBody.mNeck.mHead.mStickman.mMouth.mShapeAnimationStep*12;
				if(fadeFactor<=24) fadeFactor=0;
				g2.setColor(new Color(80, 80, 80,fadeFactor));
			}
			else
			{
				int fadeFactor = (20-mRightForeLeg.mUpperLeg.mBody.mNeck.mHead.mStickman.mMouth.mShapeAnimationStep)*12;
				if(fadeFactor >= 216) fadeFactor=255;
				g2.setColor(new Color(80, 80, 80,fadeFactor));
			}
		}
	
		g2.setStroke(new BasicStroke(3, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));

		g2.draw(mLeg);
	}
	
}
