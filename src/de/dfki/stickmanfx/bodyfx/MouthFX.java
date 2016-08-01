package de.dfki.stickmanfx.bodyfx;

import de.dfki.stickmanfx.StickmanFX;
import de.dfki.stickmanfx.animationlogic.AnimatorFX;
import java.awt.Dimension;
import java.awt.Point;

import javafx.application.Platform;
import javafx.scene.paint.Color;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.QuadCurveTo;

/**
 *
 * @author Beka Aptsiauri
 *
 */
public class MouthFX extends BodyPartFX 
{

	public static enum SHAPE 
	{
		DEFAULT, SMILE, SMILEEND, SAD, SADEND, ANGRY, ANGRYEND, ANGRYSMALLMOUTH, ANGRYSMALLMOUTHEND, SURPRISED, SURPRISEDEND, HAPPY, HAPPYEND, DISGUSTED, DISGUSTEDEND, CONTEMPT, CONTEMPTEND, EXCITED, EXCITEDEND, EMBARRASSED, EMBARRASSEDEND, FEAR, FEAREND, O, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, ELEVEN, TWELVE, THIRTEEN, FOURTEEN, NINETEEN, TWENTY,
	};

	HeadFX mHeadFX;
	Path mPath;
	public MouthFX.SHAPE mShape = MouthFX.SHAPE.DEFAULT;

	public MouthFX(HeadFX head) 
	{
		mHeadFX = head;
		mLength = 20;
		mSize = new Dimension(mLength * 2, 5);
		mDefaultRotationPoint = mHeadFX.mDefaultRotationPoint;
		mColor = Color.rgb(mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.FEMALE ? 64 : 32, 0, 0, (128 * 100 / 255) / 100f);
		mPath = new Path();
		this.getChildren().add(mPath);
		init();
	}

	@Override
	public void setShape(String s) 
	{
		MouthFX.SHAPE shape = MouthFX.SHAPE.valueOf(s);
		mShape = (shape != null) ? shape : MouthFX.SHAPE.DEFAULT;
	}

	@Override
	public void resetShape() 
	{
		mShape = MouthFX.SHAPE.DEFAULT;
	}

	@Override
	public void createShape() 
	{
		mStart = mHeadFX.getMouthPostion();
		mEnd = new Point(mStart.x + mLength / 2, mStart.y);

		double movement;

		clearDrawObjects();
		Platform.runLater(() -> clearChildren(this));
		
		mPath = new Path();

		switch (mShape) 
		{
		case DEFAULT:
			if (mHeadFX.mStickmanFX.setCharacterInvisible == true) 
			{
				if (mHeadFX.mStickmanFX.fadeControler == true) // Added by Robbie
				{
					int fadeFactor = mHeadFX.mStickmanFX.mMouthFX.mShapeAnimationStep * 6;
					if (fadeFactor <= 12) 
					{
						fadeFactor = 0;
					}
					mColor = Color.rgb(mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.FEMALE ? 64 : 32, 0, 0,
							(fadeFactor * 100 / 255) / 100f);
				} 
				else 
				{
					int fadeFactor = (20 - mHeadFX.mStickmanFX.mMouthFX.mShapeAnimationStep) * 6;
					if (fadeFactor >= 107) 
					{
						fadeFactor = 128;
					}
					mColor = new Color(mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.FEMALE ? 64 : 32, 0, 0, (fadeFactor * 100 / 255) / 100f);
				}
			}

			mPath = new Path();
			mPath.getElements().add(new MoveTo(mStart.x - mLength / 2, mStart.y));
			mPath.getElements().add(new QuadCurveTo(mStart.x, mStart.y + 1, mEnd.x, mEnd.y));
			break;

		case SMILE:
			mPath = new Path();
			movement = AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep;

			mPath.getElements().add(new MoveTo(mStart.x - mLength / 2 - movement / 3 * 2, mStart.y - movement / 2));
			mPath.getElements().add(new QuadCurveTo(mStart.x, mStart.y + 1 + movement / 3 * 2, mEnd.x + movement / 3 * 2, mStart.y - movement / 2));
			break;

		case SMILEEND:
			mPath = new Path();
			movement = mShapeAnimationStep - 1;
			if (movement <= 1) 
			{
				mPath.getElements().add(new MoveTo(mStart.x - mLength / 2, mStart.y));
				mPath.getElements().add(new QuadCurveTo(mStart.x, mStart.y + 1, mEnd.x, mEnd.y));
			} 
			else 
			{
				mPath.getElements().add(new MoveTo(mStart.x - mLength / 2 - movement / 3 * 2, mStart.y - movement / 2));
				mPath.getElements().add(new QuadCurveTo(mStart.x, mStart.y + 1 + movement / 3 * 2,
						mEnd.x + movement / 3 * 2, mStart.y - movement / 2));
			}
			break;

		case SAD:
			mPath = new Path();
			movement = AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep;

			mPath.getElements().add(new MoveTo(mStart.x - mLength / 2 - movement / 2, mStart.y + movement / 4));
			mPath.getElements().add(new QuadCurveTo(mStart.x, mStart.y - movement, mEnd.x + movement / 2, mEnd.y + movement / 4));
			break;

		case SADEND:
			mPath = new Path();
			movement = mShapeAnimationStep - 1;
			if (movement <= 1) 
			{
				mPath.getElements().add(new MoveTo(mStart.x - mLength / 2, mStart.y));
				mPath.getElements().add(new QuadCurveTo(mStart.x, mStart.y + 1, mEnd.x, mEnd.y));
			} 
			else 
			{
				mPath.getElements().add(new MoveTo(mStart.x - mLength / 2 - movement / 2, mStart.y + movement / 4));
				mPath.getElements().add(new QuadCurveTo(mStart.x, mStart.y - movement, mEnd.x + movement / 2, mEnd.y + movement / 4));
			}
			break;

		case ANGRY:

			mPath = new Path();
			movement = AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep;

			mPath.getElements().add(new MoveTo(mStart.x - mLength / 2 - movement / 4, mStart.y + movement / 10));
			mPath.getElements().add(new QuadCurveTo(mStart.x, mStart.y + 1 - movement / 3 * 2, mEnd.x + movement / 4, mStart.y + movement / 10));

			break;

		case ANGRYEND:
			mPath = new Path();
			movement = mShapeAnimationStep - 1;
			
			if (movement <= 1) 
			{
				mPath.getElements().add(new MoveTo(mStart.x - mLength / 2, mStart.y));
				mPath.getElements().add(new QuadCurveTo(mStart.x, mStart.y + 1, mEnd.x, mEnd.y));
			} 
			else 
			{
				mPath.getElements().add(new MoveTo(mStart.x - mLength / 2 - movement / 4, mStart.y + movement / 10));
				mPath.getElements().add(new QuadCurveTo(mStart.x, mStart.y + 1 - movement / 3 * 2, mEnd.x + movement / 4, mStart.y + movement / 10));
			}
			break;

		case ANGRYSMALLMOUTH:
			mPath = new Path();
			movement = AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep;

			mPath.getElements().add(new MoveTo(mStart.x - mLength / 2 + movement / 10, mStart.y + movement / 10));
			mPath.getElements().add(new QuadCurveTo(mStart.x, mStart.y + 1 - movement / 4, mEnd.x - movement / 10, mStart.y + movement / 10));
			break;

		case ANGRYSMALLMOUTHEND:
			mPath = new Path();
			movement = mShapeAnimationStep - 1;
			
			if (movement <= 1) 
			{
				mPath.getElements().add(new MoveTo(mStart.x - mLength / 2, mStart.y));
				mPath.getElements().add(new QuadCurveTo(mStart.x, mStart.y + 1, mEnd.x, mEnd.y));
			} 
			else 
			{
				mPath.getElements().add(new MoveTo(mStart.x - mLength / 2 + movement / 10, mStart.y + movement / 10));
				mPath.getElements().add(new QuadCurveTo(mStart.x, mStart.y + 1 - movement / 4, mEnd.x - movement / 10, mStart.y + movement / 10));
			}
			break;

		case SURPRISED:
			mPath = new Path();
			movement = AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep;

			mPath.getElements().add(new MoveTo(mStart.x - mLength / 2, mStart.y));
			mPath.getElements().add(new QuadCurveTo(mStart.x - movement / 4 - 4, mStart.y - movement / 2, mStart.x, mStart.y - movement / 2 - 1));
			mPath.getElements().add(new QuadCurveTo(mStart.x + movement / 4 + 4, mStart.y - movement / 2, mEnd.x, mStart.y));
			mPath.getElements().add(new QuadCurveTo(mStart.x + movement / 4 + 4, mStart.y + movement / 2, mStart.x, mStart.y + movement / 2 + 1));
			mPath.getElements().add(new QuadCurveTo(mStart.x - movement / 4 - 4, mStart.y + movement / 2, mStart.x - mLength / 2, mStart.y));
			break;

		case SURPRISEDEND:
			mPath = new Path();
			movement = mShapeAnimationStep - 1;
			
			if (movement <= 1) 
			{
				mPath.getElements().add(new MoveTo(mStart.x - mLength / 2, mStart.y));
				mPath.getElements().add(new QuadCurveTo(mStart.x, mStart.y + 1, mEnd.x, mEnd.y));
			} 
			else 
			{
				mPath.getElements().add(new MoveTo(mStart.x - mLength / 2, mStart.y));
				mPath.getElements().add(new QuadCurveTo(mStart.x - movement / 4 - 4, mStart.y - movement / 2, mStart.x, mStart.y - movement / 2 - 1));
				mPath.getElements().add(new QuadCurveTo(mStart.x + movement / 4 + 4, mStart.y - movement / 2, mEnd.x, mStart.y));
				mPath.getElements().add(new QuadCurveTo(mStart.x + movement / 4 + 4, mStart.y + movement / 2, mStart.x, mStart.y + movement / 2 + 1));
				mPath.getElements().add(new QuadCurveTo(mStart.x - movement / 4 - 4, mStart.y + movement / 2, mStart.x - mLength / 2, mStart.y));
			}
			break;

		case HAPPY:
			mPath = new Path();
			movement = AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep;

			mPath.getElements().add(new MoveTo(mStart.x - mLength / 2 - movement / 2, mStart.y - movement / 4));
			mPath.getElements().add(new QuadCurveTo(mStart.x, mStart.y + 1 + movement, mEnd.x + movement / 2, mStart.y - movement / 4));
			mPath.getElements().add(new LineTo(mStart.x - mLength / 2 - movement / 2, mStart.y - movement / 4));
			break;

		case HAPPYEND:
			mPath = new Path();
			movement = mShapeAnimationStep - 1;
			if (movement <= 1) 
			{
				mPath.getElements().add(new MoveTo(mStart.x - mLength / 2, mStart.y));
				mPath.getElements().add(new QuadCurveTo(mStart.x, mStart.y + 1, mEnd.x, mEnd.y));
			} 
			else 
			{
				mPath.getElements().add(new MoveTo(mStart.x - mLength / 2 - movement / 2, mStart.y - movement / 4));
				mPath.getElements().add(new QuadCurveTo(mStart.x, mStart.y + 1 + movement, mEnd.x + movement / 2, mStart.y - movement / 4));
				mPath.getElements().add(new LineTo(mStart.x - mLength / 2 - movement / 2, mStart.y - movement / 4));
			}
			break;

		case DISGUSTED:
			mPath = new Path();
			movement = mLength / 2 + (AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) / 2;

			mPath.getElements().add(new MoveTo(mStart.x - movement, mStart.y));
			mPath.getElements().add(new QuadCurveTo(mStart.x - movement * 2 / 3, mStart.y - movement / 4, mStart.x - movement / 3, mStart.y));
			mPath.getElements().add(new QuadCurveTo(mStart.x, mStart.y + movement / 4, mStart.x + movement / 3, mStart.y));
			mPath.getElements().add(new QuadCurveTo(mStart.x + movement * 2 / 3, mStart.y - movement / 4, mStart.x + movement, mEnd.y));
			break;

		case DISGUSTEDEND:
			mPath = new Path();
			movement = mLength / 2 + mShapeAnimationStep / 2;
			
			if (mShapeAnimationStep - 1 <= 1) 
			{
				mPath.getElements().add(new MoveTo(mStart.x - mLength / 2, mStart.y));
				mPath.getElements().add(new QuadCurveTo(mStart.x, mStart.y + 1, mEnd.x, mEnd.y));
			} 
			else 
			{
				mPath.getElements().add(new MoveTo(mStart.x - movement, mStart.y));
				mPath.getElements().add(new QuadCurveTo(mStart.x - movement * 2 / 3, mStart.y - movement / 4, mStart.x - movement / 3, mStart.y));
				mPath.getElements().add(new QuadCurveTo(mStart.x, mStart.y + movement / 4, mStart.x + movement / 3, mStart.y));
				mPath.getElements().add(new QuadCurveTo(mStart.x + movement * 2 / 3, mStart.y - movement / 4, mStart.x + movement, mEnd.y));
			}
			break;

		case CONTEMPT:
			mPath = new Path();
			movement = AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep;

			mPath.getElements().add(new MoveTo(mStart.x - mLength / 2, mStart.y));
			mPath.getElements().add(new QuadCurveTo(mStart.x, mStart.y - movement / 1.5, mEnd.x + movement / 2, mEnd.y - movement / 2));
			break;

		case CONTEMPTEND:
			mPath = new Path();
			movement = mShapeAnimationStep - 1;

			if (movement <= 1) 
			{
				mPath.getElements().add(new MoveTo(mStart.x - mLength / 2, mStart.y));
				mPath.getElements().add(new QuadCurveTo(mStart.x, mStart.y + 1, mEnd.x, mEnd.y));
			} 
			else 
			{
				mPath.getElements().add(new MoveTo(mStart.x - mLength / 2, mStart.y));
				mPath.getElements().add(new QuadCurveTo(mStart.x, mStart.y - movement / 1.5, mEnd.x + movement / 2, mEnd.y - movement / 2));
			}
			break;

		case FEAR:
			mPath = new Path();
			movement = AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep;

			mPath.getElements().add(new MoveTo(mStart.x - mLength / 2 - movement / 4, mStart.y));
			mPath.getElements().add(new QuadCurveTo(mStart.x, mStart.y - movement / 2, mEnd.x + movement / 4, mEnd.y));
			mPath.getElements().add(new QuadCurveTo(mStart.x, mStart.y - 1, mStart.x - mLength / 2 - movement / 4, mStart.y));
			break;

		case FEAREND:
			mPath = new Path();
			movement = mShapeAnimationStep - 1;

			if (movement <= 1) 
			{
				mPath.getElements().add(new MoveTo(mStart.x - mLength / 2, mStart.y));
				mPath.getElements().add(new QuadCurveTo(mStart.x, mStart.y + 1, mEnd.x, mEnd.y));
			} 
			else 
			{
				mPath.getElements().add(new MoveTo(mStart.x - mLength / 2 - movement / 4, mStart.y));
				mPath.getElements().add(new QuadCurveTo(mStart.x, mStart.y - movement / 2, mEnd.x + movement / 4, mEnd.y));
				mPath.getElements().add(new QuadCurveTo(mStart.x, mStart.y - 1, mStart.x - mLength / 2 - movement / 4, mStart.y));
			}
			break;

		case EXCITED:
			mPath = new Path();
			movement = AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep;

			mPath.getElements().add(new MoveTo(mStart.x - mLength / 2 - movement / 3 * 2, mStart.y - movement / 2));
			mPath.getElements().add(new QuadCurveTo(mStart.x, mStart.y + movement, mEnd.x + movement / 3 * 2, mStart.y - movement / 2));
			mPath.getElements().add(new LineTo(mStart.x - mLength / 2 - movement / 3 * 2, mStart.y - movement / 2));
			break;

		case EXCITEDEND:
			mPath = new Path();
			movement = mShapeAnimationStep - 1;

			if (movement <= 1) 
			{
				mPath.getElements().add(new MoveTo(mStart.x - mLength / 2, mStart.y));
				mPath.getElements().add(new QuadCurveTo(mStart.x, mStart.y + 1, mEnd.x, mEnd.y));
			} 
			else 
			{
				mPath.getElements().add(new MoveTo(mStart.x - mLength / 2 - movement / 3 * 2, mStart.y - movement / 2));
				mPath.getElements().add(new QuadCurveTo(mStart.x, mStart.y + movement, mEnd.x + movement / 3 * 2, mStart.y - movement / 2));
				mPath.getElements().add(new LineTo(mStart.x - mLength / 2 - movement / 3 * 2, mStart.y - movement / 2));
			}
			break;

		case EMBARRASSED:
			mPath = new Path();
			movement = (AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep);

			mPath.getElements().add(new MoveTo(mStart.x - mLength / 2 + movement / 10 * 7, mStart.y + movement / 20));
			mPath.getElements().add(new QuadCurveTo((mStart.x - mLength / 2 + mEnd.x + movement / 10 * 3) / 2, mStart.y + 1, mEnd.x + movement / 10 * 3, mEnd.y + movement / 20));
			Platform.runLater(() -> this.getChildren().add(mPath));
			break;

		case EMBARRASSEDEND:
			mPath = new Path();
			movement = mShapeAnimationStep - 1;

			if (movement <= 1) 
			{
				mPath.getElements().add(new MoveTo(mStart.x - mLength / 2, mStart.y));
				mPath.getElements().add(new QuadCurveTo(mStart.x, mStart.y + 1, mEnd.x, mEnd.y));
			} 
			else 
			{
				mPath.getElements().add(new MoveTo(mStart.x - mLength / 2 + movement / 10 * 7, mStart.y + movement / 20));
				mPath.getElements().add(new QuadCurveTo((mStart.x - mLength / 2 + mEnd.x + movement / 10 * 3) / 2, mStart.y + 1, mEnd.x + movement / 10 * 3, mEnd.y + movement / 20));
			}
			break;

		case O:
			mPath = new Path();
			mPath.getElements().add(new MoveTo(mStart.x - mLength / 2, mStart.y));
			mPath.getElements().add(new QuadCurveTo(mStart.x, mStart.y - mLength / 2, mEnd.x, mStart.y));
			mPath.getElements().add(new QuadCurveTo(mStart.x, mStart.y + mLength / 2, mStart.x - mLength / 2, mStart.y));
			break;

		case ONE:
		case SIX:
		case FOURTEEN:
		case NINETEEN:
			mPath = new Path();
			mPath.getElements().add(new MoveTo(mStart.x - mLength / 2, mStart.y));
			mPath.getElements().add(new QuadCurveTo(mStart.x, mStart.y - mLength / 5, mEnd.x, mStart.y));
			mPath.getElements().add(new QuadCurveTo(mStart.x, mStart.y + mLength / 5, mStart.x - mLength / 2, mStart.y));
			break;

		case TWO:
			mPath = new Path();
			mPath.getElements().add(new MoveTo(mStart.x - mLength / 2.8, mStart.y));
			mPath.getElements().add(new QuadCurveTo(mStart.x, mStart.y - mLength / 1.6, mEnd.x - mLength / 6, mStart.y));
			mPath.getElements().add(new QuadCurveTo(mStart.x, mStart.y + mLength / 1.6, mStart.x - mLength / 2.8, mStart.y));
			break;

		case THREE:
		case TWENTY:
			mPath = new Path();
			mPath.getElements().add(new MoveTo(mStart.x - mLength / 2.8, mStart.y));
			mPath.getElements().add(new QuadCurveTo(mStart.x, mStart.y - mLength / 2.5, mEnd.x - mLength / 6, mStart.y));
			mPath.getElements().add(new QuadCurveTo(mStart.x, mStart.y + mLength / 2.5, mStart.x - mLength / 2.8, mStart.y));
			break;

		case FOUR:
			mPath = new Path();
			mPath.getElements().add(new MoveTo(mStart.x - mLength / 2, mStart.y));
			mPath.getElements().add(new QuadCurveTo(mStart.x, mStart.y - 3, mEnd.x, mStart.y));
			mPath.getElements().add(new QuadCurveTo(mStart.x, mStart.y + mLength / 2, mStart.x - mLength / 2, mStart.y));
			break;

		case FIVE:
		case EIGHT:
			mPath = new Path();
			mPath.getElements().add(new MoveTo(mStart.x - mLength / 2.8, mStart.y));
			mPath.getElements().add(new QuadCurveTo(mStart.x, mStart.y - mLength / 2, mEnd.x - mLength / 6, mStart.y));
			mPath.getElements().add(new QuadCurveTo(mStart.x, mStart.y + mLength / 2, mStart.x - mLength / 2.8, mStart.y));
			break;

		case SEVEN:
			mPath = new Path();
			mPath.getElements().add(new MoveTo(mStart.x - mLength / 3, mStart.y));
			mPath.getElements().add(new QuadCurveTo(mStart.x, mStart.y - 3, mEnd.x - mLength / 5, mStart.y));
			mPath.getElements().add(new QuadCurveTo(mStart.x, mStart.y + 3, mStart.x - mLength / 3, mStart.y));
			break;

		case NINE:
			mPath = new Path();
			mPath.getElements().add(new MoveTo(mStart.x - mLength / 3, mStart.y));
			mPath.getElements().add(new QuadCurveTo(mStart.x, mStart.y - mLength / 2.8, mEnd.x - mLength / 5, mStart.y));
			mPath.getElements().add(new QuadCurveTo(mStart.x, mStart.y + mLength / 1.6, mStart.x - mLength / 3, mStart.y));
			break;

		case TEN:
			mPath = new Path();
			mPath.getElements().add(new MoveTo(mStart.x - mLength / 2.8, mStart.y));
			mPath.getElements().add(new QuadCurveTo(mStart.x, mStart.y - mLength / 2.8, mEnd.x - mLength / 6, mStart.y));
			mPath.getElements().add(new QuadCurveTo(mStart.x, mStart.y + mLength / 2, mStart.x - mLength / 2.8, mStart.y));
			break;

		}
		Platform.runLater(() -> this.getChildren().add(mPath));
		addToDrawObjects(mPath);
		this.update();
	}
}
