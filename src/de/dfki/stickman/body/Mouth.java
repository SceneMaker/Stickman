package de.dfki.stickman.body;

import de.dfki.stickman.Stickman;
import de.dfki.stickman.animationlogic.Animator;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.geom.GeneralPath;

/**
 *
 * @author Patrick Gebhard
 *
 */
public class Mouth extends BodyPart {

	public static enum SHAPE {

		DEFAULT, SMILE, SAD, ANGRY, SURPRISED, HAPPY, DISGUSTED, CONTEMPT, EXCITED, EMBARRASSED, O, FEAR, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, ELEVEN, TWELVE, THIRTEEN, FOURTEEN,NINETEEN, TWENTY
	};

	Head mHead;

	public Mouth.SHAPE mShape = Mouth.SHAPE.DEFAULT;

	public Mouth(Head head) {
		mHead = head;
		mLength = 20;
		mSize = new Dimension(mLength * 2, 5);
		mDefaultRotationPoint = mHead.mDefaultRotationPoint;
		mColor = new Color(mHead.mStickman.mType == Stickman.TYPE.FEMALE ? 64 : 32, 0, 0, 128);

		init();
	}

	@Override
	public void setShape(String s) {
		Mouth.SHAPE shape = Mouth.SHAPE.valueOf(s);
		mShape = (shape != null) ? shape : Mouth.SHAPE.DEFAULT;
	}

	@Override
	public void resetShape() {
		mShape = Mouth.SHAPE.DEFAULT;
	}

	@Override
	public void createShape() {
//		mStart:middle
//		mEnd:right side
		mStart = mHead.getMouthPostion();
		mEnd = new Point(mStart.x + mLength / 2, mStart.y);

		double movement;

		clearDrawObjects();
		GeneralPath gp = new GeneralPath();

		switch (mShape) {
			case DEFAULT:
				gp.moveTo(mStart.x - mLength / 2, mStart.y);
				gp.quadTo(mStart.x, mStart.y + 1, mEnd.x, mEnd.y);
				break;

			case SMILE:
				movement = mLength / 2 + (Animator.sMAX_ANIM_STEPS - mShapeAnimationStep) / 3;

				gp.moveTo(mStart.x - mLength / 2 - movement, mStart.y - mLength / 2 - movement / 4 + 5);
				gp.quadTo(mStart.x, mStart.y + movement, mEnd.x + movement, mStart.y - mLength / 2 - movement / 4 + 5);
				break;

			case SAD:
				movement = Animator.sMAX_ANIM_STEPS - mShapeAnimationStep;

				gp.moveTo(mStart.x - mLength/2 - movement/2, mStart.y + movement/4);
				gp.quadTo(mStart.x, mStart.y - movement, mEnd.x + movement/2, mEnd.y + movement/4);
				break;

			case ANGRY:
				movement = mLength / 2 + (Animator.sMAX_ANIM_STEPS - mShapeAnimationStep) / 3;
				
				gp.moveTo(mStart.x - mLength/2 - movement/10, mStart.y + movement/10);
				gp.quadTo(mStart.x, mStart.y - mLength/3, mEnd.x + movement/10, mStart.y + movement/10);
				
				break;
			
			case SURPRISED:
				movement = Animator.sMAX_ANIM_STEPS - mShapeAnimationStep;

				gp.moveTo(mStart.x - mLength / 2, mStart.y);
				gp.quadTo(mStart.x-movement/4-4, mStart.y - movement/2, mStart.x, mStart.y - movement/2-1);
				gp.quadTo(mStart.x+movement/4+4, mStart.y - movement/2, mEnd.x, mStart.y);
				gp.quadTo(mStart.x+movement/4+4, mStart.y + movement/2, mStart.x, mStart.y + movement/2+1);
				gp.quadTo(mStart.x-movement/4-4, mStart.y + movement/2, mStart.x - mLength / 2, mStart.y);
				break;
				
			case HAPPY:
				movement = Animator.sMAX_ANIM_STEPS - mShapeAnimationStep;

				gp.moveTo(mStart.x - mLength/2 - movement/2, mStart.y - movement/4);
				gp.quadTo(mStart.x, mStart.y + 1 + movement, mEnd.x + movement/2, mStart.y - movement/4);
				gp.lineTo(mStart.x - mLength/2 - movement/2, mStart.y- movement/4);
				break;		
				
			case DISGUSTED:
				movement = Animator.sMAX_ANIM_STEPS - mShapeAnimationStep;

				gp.moveTo(mStart.x - movement, mStart.y);
				gp.quadTo(mStart.x - movement*2/3, mStart.y - movement/4 , mStart.x - movement/3, mStart.y);
				gp.quadTo(mStart.x, mStart.y + movement/4 , mStart.x + movement/3, mStart.y);
				gp.quadTo(mStart.x + movement*2/3, mStart.y - movement/4 ,mStart.x + movement, mEnd.y);
				
				break;	
		
			case CONTEMPT:		
				movement = Animator.sMAX_ANIM_STEPS - mShapeAnimationStep;
				
				gp.moveTo(mStart.x - mLength / 2, mStart.y);
				gp.quadTo(mStart.x, mStart.y - movement/1.5, mEnd.x + movement/2, mEnd.y-movement/2);
	
				break;	
				
			case FEAR:
				movement = Animator.sMAX_ANIM_STEPS - mShapeAnimationStep;
				
				gp.moveTo(mStart.x - mLength / 2-movement/4, mStart.y);
				gp.quadTo(mStart.x, mStart.y - movement/2, mEnd.x+movement/4, mEnd.y);
				gp.quadTo(mStart.x, mStart.y -1, mStart.x - mLength / 2-movement/4, mStart.y);
				break;	
				
			case EXCITED:
				movement = Animator.sMAX_ANIM_STEPS - mShapeAnimationStep;
		
				gp.moveTo(mStart.x - mLength / 2 - movement, mStart.y - movement / 2);
				gp.quadTo(mStart.x, mStart.y + movement+2, mEnd.x + movement, mStart.y- movement / 2);
				gp.lineTo(mStart.x - mLength / 2 - movement, mStart.y - movement / 2);			
				break;	
				
			case EMBARRASSED:
				movement = (Animator.sMAX_ANIM_STEPS - mShapeAnimationStep);
				
				gp.moveTo(mStart.x - mLength/2 + movement/10*7, mStart.y + movement/20);
				gp.quadTo((mStart.x - mLength/2 + mEnd.x + movement/10*3)/2, mStart.y+1, mEnd.x + movement/10*3, mEnd.y + movement/20);
				break;
				
			case O:
				gp.moveTo(mStart.x - mLength / 2, mStart.y);
				gp.quadTo(mStart.x, mStart.y - mLength / 2, mEnd.x, mStart.y);
				gp.quadTo(mStart.x, mStart.y + mLength / 2, mStart.x - mLength / 2, mStart.y);
				break;
                                
            case ONE:
			case SIX:
			case FOURTEEN:
			case NINETEEN:
				gp.moveTo(mStart.x - mLength / 2, mStart.y);
				gp.quadTo(mStart.x, mStart.y - mLength / 5, mEnd.x, mStart.y);
				gp.quadTo(mStart.x, mStart.y + mLength / 5, mStart.x - mLength / 2, mStart.y);
				break;

			case TWO:
				gp.moveTo(mStart.x - mLength / 2.8, mStart.y);
				gp.quadTo(mStart.x, mStart.y - mLength / 1.6, mEnd.x - mLength / 6, mStart.y);
				gp.quadTo(mStart.x, mStart.y + mLength / 1.6, mStart.x - mLength / 2.8, mStart.y);
				break;


			case THREE:
			case TWENTY:
				gp.moveTo(mStart.x - mLength / 2.8, mStart.y);
				gp.quadTo(mStart.x, mStart.y - mLength / 2.5, mEnd.x - mLength / 6, mStart.y);
				gp.quadTo(mStart.x, mStart.y + mLength / 2.5, mStart.x - mLength / 2.8, mStart.y);
				break;

			case FOUR:
				gp.moveTo(mStart.x - mLength / 2, mStart.y);
				gp.quadTo(mStart.x, mStart.y - 3, mEnd.x, mStart.y);
				gp.quadTo(mStart.x, mStart.y + mLength / 2, mStart.x - mLength / 2, mStart.y);
				break;



			case FIVE:
			case EIGHT:
				gp.moveTo(mStart.x - mLength / 2.8, mStart.y);
				gp.quadTo(mStart.x, mStart.y - mLength / 2, mEnd.x - mLength / 6, mStart.y);
				gp.quadTo(mStart.x, mStart.y + mLength / 2, mStart.x - mLength / 2.8, mStart.y);
				break;

			case SEVEN:
				gp.moveTo(mStart.x - mLength / 3, mStart.y);
				gp.quadTo(mStart.x, mStart.y -  3, mEnd.x - mLength / 5, mStart.y);
				gp.quadTo(mStart.x, mStart.y + 3, mStart.x - mLength / 3, mStart.y);
				break;


			case NINE:
				gp.moveTo(mStart.x - mLength / 3, mStart.y);
				gp.quadTo(mStart.x, mStart.y - mLength / 2.8, mEnd.x - mLength / 5, mStart.y);
				gp.quadTo(mStart.x, mStart.y + mLength / 1.6, mStart.x - mLength / 3, mStart.y);
				break;

			case TEN:
				gp.moveTo(mStart.x - mLength / 2.8, mStart.y);
				gp.quadTo(mStart.x, mStart.y - mLength / 2.8, mEnd.x - mLength / 6, mStart.y);
				gp.quadTo(mStart.x, mStart.y + mLength / 2, mStart.x - mLength / 2.8, mStart.y);
				break;

		
		}

		addToDrawObjects(gp);
	}
}