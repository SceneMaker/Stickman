/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman.body;

import de.dfki.stickman.Stickman;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Stroke;
import java.awt.geom.GeneralPath;
import javafx.beans.binding.Bindings;

/**
 *
 * @author Patrick Gebhard
 */
public class LeftLeg extends BodyPart {

	Body mBody;
        GeneralPath mLeftLeg;
        GeneralPath mLeftShoe;

	public LeftLeg(Body body) {
		mBody = body;
                if(mBody.mNeck.mHead.mStickman.mType == Stickman.TYPE.FEMALE)
                    mLength = 150;
                else
                    mLength = 100;
		mSize = new Dimension(10, mLength);
		mColor = new Color(80, 80, 80);
		init();
	}

	@Override
	public void createShape() {
		mStart = mBody.getLeftLegStartPostion();
		mEnd = new Point(mStart.x, mStart.y + mLength);

		clearDrawObjects();
		
		if(mBody.mNeck.mHead.mStickman.setCharacterInvisible == true)
		{
			if(mBody.mNeck.mHead.mStickman.fadeControler==true)             //Added by Robbie
			{
				int fadeFactor = mBody.mNeck.mHead.mStickman.mMouth.mShapeAnimationStep*12;
				if(fadeFactor<=24) fadeFactor=0;
				mColor = new Color(80, 80, 80, fadeFactor);
			}
			else
			{
				int fadeFactor = (20-mBody.mNeck.mHead.mStickman.mMouth.mShapeAnimationStep)*12;
				if(fadeFactor >= 216) fadeFactor=255;
				mColor = new Color(80, 80, 80, fadeFactor);
			}
		}

		mLeftLeg = new GeneralPath();
                if(mBody.mNeck.mHead.mStickman.mType == Stickman.TYPE.FEMALE)
                {
                    mLeftLeg.moveTo(mStart.x, mStart.y + 2);
                    mLeftLeg.quadTo(mStart.x + 5, (mStart.y + mEnd.y) / 2, mEnd.x, mEnd.y);
                } 
                else
                {
                    mStart.x -= 14;
                    mStart.y += 4;
                    mLeftLeg.moveTo(mStart.x, mStart.y);
                    mLeftLeg.curveTo(mStart.x, mStart.y, mStart.x, mStart.y+8, mStart.x + 3, mStart.y + 20);
                    mLeftLeg.lineTo(mStart.x+4, mStart.y+19);
                    
                    mLeftLeg.curveTo(mStart.x+2, mStart.y+19, mStart.x-1, mStart.y + 40, mStart.x + 4, mStart.y + 80);
                    mLeftLeg.lineTo(mStart.x + 20, mStart.y + 80);
                    
                    mLeftLeg.curveTo(mStart.x + 20, mStart.y + 82, mStart.x +26, mStart.y + 40, mStart.x + 20, mStart.y + 19);
                    mLeftLeg.lineTo(mStart.x + 19, mStart.y + 20);
                    
                    mLeftLeg.curveTo(mStart.x + 19, mStart.y + 20, mStart.x + 23, mStart.y + 8, mStart.x + 22, mStart.y);
                    //mLeftLeg.closePath(); ///?????
                }
                
		//addToDrawObjects(gp);

		mLeftShoe = new GeneralPath();
                if(mBody.mNeck.mHead.mStickman.mType == Stickman.TYPE.FEMALE)
                {
                    mLeftShoe.moveTo(mEnd.x - 5, mEnd.y + 4);
                    mLeftShoe.quadTo(mEnd.x, mEnd.y + 2, mEnd.x + 5, mEnd.y + 4);
                    mLeftShoe.quadTo(mEnd.x, mEnd.y + 2, mEnd.x + 5, mEnd.y + 4);
                    addToDrawObjects(mLeftShoe);
                }
                else
                {
                    mEnd = new Point(mStart.x, mStart.y + mLength - 20);
                    mLeftShoe.moveTo(mEnd.x+2, mEnd.y);
                    //gp.curveTo(mEnd.x + 4, mEnd.y, mEnd.x - 6, mEnd.y +3, mEnd.x -10, mEnd.y+15);
                    mLeftShoe.curveTo(mEnd.x + 2, mEnd.y, mEnd.x - 3, mEnd.y +3, mEnd.x -1, mEnd.y+10);
                    mLeftShoe.lineTo(mEnd.x + 23, mEnd.y + 10);
                    mLeftShoe.curveTo(mEnd.x + 23, mEnd.y + 10, mEnd.x  + 23, mEnd.y +3, mEnd.x +20, mEnd.y);
                }
		
		//addToDrawObjects(gp);
	}
        
       @Override
        protected void paintComponent(Graphics g) 
        {
            super.paintComponent(g);
            
            Graphics2D g2 = (Graphics2D) g;
            if(mBody.mNeck.mHead.mStickman.mType == Stickman.TYPE.MALE)
            {
               Stroke s = new BasicStroke(2.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND); 
               g2.setColor(new Color(242, 227, 217));
               g2.fill(mLeftLeg);
               g2.setStroke(s);
               g2.setPaint(Color.BLACK);
               g2.draw(mLeftLeg);
               
               g2.setColor(Color.BLACK);
               g2.fill(mLeftShoe);
            }
            else
            {
               Stroke s = new BasicStroke(3.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);  
               g2.setStroke(s);
               g2.setPaint(mColor);
               g2.draw(mLeftLeg);
            }
        }
}
