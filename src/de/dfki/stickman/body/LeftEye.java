package de.dfki.stickman.body;

import de.dfki.stickman.Stickman;
import java.awt.Color;
import java.awt.Point;
import java.awt.geom.GeneralPath;
import static de.dfki.stickman.animationlogic.util.Interpolator.linear;
import java.awt.BasicStroke;

/**
 *
 * @author Patrick Gebhard
 *
 */
public class LeftEye extends BodyPart {

	public static enum SHAPE {

		DEFAULT, BLINK, LOOKLEFT, LOOKRIGHT, ANGRY, SURPRIESD, HAPPY, DISGUSTED, LOVED
	};

	Head mHead;
	int adjustFactor = 3; // Used to adjust the movement of the eye
	public LeftEye.SHAPE mShape = LeftEye.SHAPE.DEFAULT;

	public LeftEye(Head head) {
		mHead = head;
		mLength = 5;
		mDefaultRotationPoint = mHead.mDefaultRotationPoint;
		mColor = new Color(mHead.mStickman.mType == Stickman.TYPE.FEMALE ? 22 : 0,
		  mHead.mStickman.mType == Stickman.TYPE.FEMALE ? 40 : 0,
		  mHead.mStickman.mType == Stickman.TYPE.FEMALE ? 65 : 0, 144);
		mStroke = new BasicStroke(2.5f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);

		init();
	}

	@Override
	public void setShape(String s) {
		SHAPE shape = SHAPE.valueOf(s);
		mShape = (shape != null) ? shape : SHAPE.DEFAULT;
	}

	@Override
	public void resetShape() {
		mShape = LeftEye.SHAPE.DEFAULT;
	}

	@Override
	public void createShape() {
		mStart = mHead.getLeftEyePostion();
		mEnd = new Point(mStart.x - mLength, mStart.y);

		clearDrawObjects();
		GeneralPath gp = new GeneralPath();

		switch (mShape) {
			case DEFAULT:
				gp = new GeneralPath();
				gp.moveTo(mStart.x, mStart.y);
				gp.quadTo((mStart.x + mEnd.x) / 2, mStart.y - 3, mEnd.x, mEnd.y);
				break;

			case BLINK:
				gp = new GeneralPath();
				gp.moveTo(mStart.x, mStart.y);
				gp.lineTo(mEnd.x, mEnd.y);
				break;
			case LOOKLEFT:
				gp = new GeneralPath();
				gp.moveTo(mStart.x, mStart.y);
				gp.quadTo(linear((mStart.x + mEnd.x) / 2, mStart.x, mShapeAnimationStep), mStart.y - 3, mEnd.x, mEnd.y);
				break;
			case LOOKRIGHT:
				gp = new GeneralPath();
				gp.moveTo(mStart.x, mStart.y);
				gp.quadTo(linear((mStart.x + mEnd.x) / 2, mEnd.x, mShapeAnimationStep), mStart.y - 3, mEnd.x, mEnd.y);
				break;
				
			case ANGRY:
				gp.moveTo(mStart.x, mStart.y - adjustFactor);
				gp.moveTo(mStart.x-2, mStart.y);
				gp.quadTo((mStart.x-2 + mEnd.x) / 2, mStart.y - 2, mEnd.x-2, mStart.y);
				gp.quadTo((mStart.x-2 + mEnd.x) / 2, mStart.y + 2, mStart.x-2, mStart.y);
				
				gp.lineTo(mEnd.x, mEnd.y);
				break;
			
			case SURPRIESD:
				gp.moveTo(mStart.x+2, mStart.y);
				gp.quadTo(mStart.x - 2, mStart.y - 5, mEnd.x-2, mStart.y);
				gp.quadTo(mStart.x - 2, mStart.y + 5, mStart.x+2, mStart.y);
				break;
				
			case HAPPY:
				gp.moveTo(mStart.x+2, mStart.y);
				gp.quadTo((mStart.x+2 + mEnd.x-2) / 2, mStart.y - 3, mEnd.x-2, mEnd.y);
				break;		
				
			case DISGUSTED:
				gp.moveTo(mStart.x+5, mStart.y-5);
				gp.lineTo(mEnd.x-3, mEnd.y+3);
				gp.lineTo(mStart.x+5, mEnd.y+3);
				break;
			
			case LOVED:
				gp.moveTo(mStart.x, mStart.y);
				gp.quadTo(mStart.x-12, mEnd.y-6,mStart.x, mEnd.y+12);
				gp.moveTo(mStart.x, mStart.y);
				gp.quadTo(mStart.x+12, mEnd.y-6,mStart.x, mEnd.y+12);
				break;
				
		}

		addToDrawObjects(gp);
	}
}
