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
public class FaceWrinkle extends BodyPart {

	public static enum SHAPE {

		DEFAULT, ANGRY, DISGUSTED, SURPRISED, EXCITED, EMBARRASSED
	};

	Head mHead;
	public FaceWrinkle.SHAPE mShape = FaceWrinkle.SHAPE.DEFAULT;

	public FaceWrinkle(Head head) {
		mHead = head;
		mLength = 16;
		mSize = new Dimension(mLength, 5);
		mDefaultRotationPoint = mHead.mDefaultRotationPoint;
		mStroke = new BasicStroke(2.5f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);

		init();
	}

	@Override
	public void setShape(String s) {
		FaceWrinkle.SHAPE shape = FaceWrinkle.SHAPE.valueOf(s);
		mShape = (shape != null) ? shape : FaceWrinkle.SHAPE.DEFAULT;
	}

	@Override
	public void resetShape() {
		mShape = FaceWrinkle.SHAPE.DEFAULT;
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
				gp.moveTo(mStart.x+5, mStart.y);
				mColor = new Color(0, 0, 0, 0);
				break;
				
			case ANGRY:	
				movement = Animator.sMAX_ANIM_STEPS - mShapeAnimationStep;

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

				break;
				
			case SURPRISED:
				
				break;
				
			case EXCITED:
				
				break;
				
			case EMBARRASSED:
				movement = Animator.sMAX_ANIM_STEPS - mShapeAnimationStep;

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
