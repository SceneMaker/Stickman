package de.dfki.stickman.body;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.geom.GeneralPath;

import de.dfki.stickman.animationlogic.Animator;

/**
 *
 * @author Patrick Gebhard
 *
 */
public class RightEyebrow extends BodyPart {

	public static enum SHAPE {

		DEFAULT, ANGRY, DISGUSTED, SURPRISED, EXCITED, EMBARRASSED
	};

	Head mHead;
	int adjustFactor = 5; // Used to adjust the movement of the eyebrow
	public RightEyebrow.SHAPE mShape = RightEyebrow.SHAPE.DEFAULT;

	public RightEyebrow(Head head) {
		mHead = head;
		mLength = 16;
		mSize = new Dimension(mLength, 5);
		mDefaultRotationPoint = mHead.mDefaultRotationPoint;
		mColor = new Color(0, 0, 0, 64);
		mStroke = new BasicStroke(2.5f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);

		init();
	}

	@Override
	public void setShape(String s) {
		RightEyebrow.SHAPE shape = RightEyebrow.SHAPE.valueOf(s);
		mShape = (shape != null) ? shape : RightEyebrow.SHAPE.DEFAULT;
	}

	@Override
	public void resetShape() {
		mShape = RightEyebrow.SHAPE.DEFAULT;
	}

	@Override
	public void createShape() {
//		mStart: right side
//		mEnd: left side
		mStart = mHead.getRightEyebrowPostion();
		mEnd = new Point(mStart.x - mLength, mStart.y);

		double movement;
		
		clearDrawObjects();
		GeneralPath gp = new GeneralPath();

		switch (mShape) {
			case DEFAULT:
				gp = new GeneralPath();
				gp.moveTo(mStart.x, mStart.y);
				gp.quadTo((mStart.x + mEnd.x) / 2, mStart.y - 3, mEnd.x, mEnd.y);
				break;
				
			case ANGRY:		
				movement = Animator.sMAX_ANIM_STEPS - mShapeAnimationStep;
				
				gp.moveTo(mStart.x + movement/4, mStart.y + movement/4);
				gp.quadTo((mStart.x + movement/4 + mEnd.x + movement/3) / 2, mStart.y + movement/4 - 3, mEnd.x + movement/4, mEnd.y);
				
//				Add wrinkle for angry face:
				int angryColorChange = (int)(movement/4*16);
				mColor = new Color(0, 0, 0, angryColorChange);
				gp.moveTo(mStart.x + 10, mStart.y + 7);
				gp.lineTo(mStart.x + 10, mStart.y - 1);
				gp.moveTo(mStart.x + 17, mStart.y + 9);
				gp.lineTo(mStart.x + 17, mStart.y);
				gp.moveTo(mStart.x + 24, mStart.y + 7);
				gp.lineTo(mStart.x + 24, mStart.y - 1);
				
				break;
				
			case DISGUSTED:			
				movement = Animator.sMAX_ANIM_STEPS - mShapeAnimationStep;
				
				gp.moveTo(mStart.x, mStart.y - movement/4);
				gp.quadTo((mStart.x + mEnd.x) / 2, mStart.y - 3 + movement/7 , mEnd.x + movement/10, mEnd.y);
				break;
				
			case SURPRISED:
				movement = Animator.sMAX_ANIM_STEPS - mShapeAnimationStep;

				gp.moveTo(mStart.x, mStart.y-movement/7);
				gp.quadTo((mStart.x + mEnd.x) / 2, mStart.y-3-movement/7 , mEnd.x, mEnd.y-movement/7);
				break;
				
			case EXCITED:
				movement = Animator.sMAX_ANIM_STEPS - mShapeAnimationStep;
				
				gp.moveTo(mStart.x, mStart.y-movement/4);
				gp.quadTo((mStart.x + mEnd.x) / 2, mStart.y-3 -movement/5 , mEnd.x, mEnd.y-movement/4);
				break;
				
			case EMBARRASSED:
				movement = Animator.sMAX_ANIM_STEPS - mShapeAnimationStep;

				gp.moveTo(mStart.x + movement/2, mStart.y + movement/3);
				gp.quadTo((mStart.x + movement/2 + mEnd.x + movement/2) / 2, mStart.y - 3 + movement/10*7, mEnd.x + movement/2, mEnd.y + movement/2);

//				Add wrinkles for embarrassed face:
				int embarrassedColorChange = (int)(movement/4*16);
				mColor = new Color(0, 0, 0, embarrassedColorChange);
				gp.moveTo(mStart.x - 15, mStart.y);
				gp.lineTo(mStart.x - 15, mStart.y + 10);			
				gp.moveTo(mStart.x - 25, mStart.y + 5);
				gp.lineTo(mStart.x - 25, mStart.y + 20);				
				break;
		}

		addToDrawObjects(gp);
	}

}
