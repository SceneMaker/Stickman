package de.dfki.stickman.bodyfx;

import de.dfki.stickman.body.*;
import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.geom.GeneralPath;

import de.dfki.stickman.animationlogic.Animator;
import javafx.scene.paint.Color;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.QuadCurveTo;

/**
 *
 * @author Patrick Gebhard
 *
 */
public class RightEyebrowFX extends BodyPartFX {

	public static enum SHAPE {

		DEFAULT, ANGRY, ANGRYEND, DISGUSTED, DISGUSTEDEND, SURPRISED, SURPRISEDEND, EXCITED, EXCITEDEND, EMBARRASSED, EMBARRASSEDEND
	};

	HeadFX mHeadFX;
	public RightEyebrowFX.SHAPE mShape = RightEyebrowFX.SHAPE.DEFAULT;

	public RightEyebrowFX(HeadFX head) {
		mHeadFX = head;
		mLength = 16;
		mSize = new Dimension(mLength, 5);
		mDefaultRotationPoint = mHeadFX.mDefaultRotationPoint;
		mColor = Color.rgb(0, 0, 0, (64*100/255)/100f);
		mStroke = new BasicStroke(2.5f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);

		init();
	}

	@Override
	public void setShape(String s) {
		RightEyebrowFX.SHAPE shape = RightEyebrowFX.SHAPE.valueOf(s);
		mShape = (shape != null) ? shape : RightEyebrowFX.SHAPE.DEFAULT;
	}

	@Override
	public void resetShape() {
		mShape = RightEyebrowFX.SHAPE.DEFAULT;
	}

	@Override
	public void createShape() 
        {
//		mStart: right side
//		mEnd: left side
            mStart = mHeadFX.getRightEyebrowPostion();
            mEnd = new Point(mStart.x - mLength, mStart.y);

            double movement;

            clearDrawObjects();
            Path gp = new Path();

            switch (mShape) 
            {
                case DEFAULT:

                    if(mHeadFX.mStickmanFX.setCharacterInvisible == true)
                    {
                            if(mHeadFX.mStickmanFX.fadeControler==true)             //Added by Robbie
                            {
                                    int fadeFactor = (int) (mHeadFX.mStickmanFX.mMouthFX.mShapeAnimationStep*3.2);
                                    if(fadeFactor<=6) fadeFactor=0;
                                    mColor = Color.rgb(0, 0, 0, (fadeFactor*100/255)/100f);
                            }
                            else
                            {
                                int fadeFactor = (int)((20-mHeadFX.mStickmanFX.mMouthFX.mShapeAnimationStep)*3.2);
                                if(fadeFactor >= 57) fadeFactor=0;
                                if(fadeFactor >= 54) fadeFactor=64;
                                mColor = new Color(0, 0, 0, (fadeFactor*100/255)/100f);
                            }
                    }

                    gp = new Path();
                    gp.getElements().add(new MoveTo(mStart.x, mStart.y));
                    gp.getElements().add(new QuadCurveTo((mStart.x + mEnd.x) / 2, mStart.y - 3, mEnd.x, mEnd.y));
                    this.getChildren().add(gp);
                    break;

                case ANGRY:	
                        movement = Animator.sMAX_ANIM_STEPS - mShapeAnimationStep;

                        gp.getElements().add(new MoveTo(mStart.x + movement/4, mStart.y + movement/4));
                        gp.getElements().add(new QuadCurveTo((mStart.x + movement/4 + mEnd.x + movement/3) / 2, mStart.y + movement/4 - 3, mEnd.x + movement/4, mEnd.y));
                        this.getChildren().add(gp);
                        break;

                case ANGRYEND:	
                        movement = mShapeAnimationStep - 1;
                        if(movement<=1)
                        {
                            gp.getElements().add(new MoveTo(mStart.x, mStart.y));
                            gp.getElements().add(new QuadCurveTo((mStart.x + mEnd.x) / 2, mStart.y - 3, mEnd.x, mEnd.y));
                        }
                        else
                        {
                            gp.getElements().add(new MoveTo(mStart.x + movement/4, mStart.y + movement/4));
                            gp.getElements().add(new QuadCurveTo((mStart.x + movement/4 + mEnd.x + movement/3) / 2, mStart.y + movement/4 - 3, mEnd.x + movement/4, mEnd.y));
                        }
                        this.getChildren().add(gp);
                        break;

                case DISGUSTED:			
                        movement = Animator.sMAX_ANIM_STEPS - mShapeAnimationStep;

                        gp.getElements().add(new MoveTo(mStart.x, mStart.y - movement/4));
                        gp.getElements().add(new QuadCurveTo((mStart.x + mEnd.x) / 2, mStart.y - 3 + movement/7 , mEnd.x + movement/10, mEnd.y));
                        this.getChildren().add(gp);
                        break;

                case DISGUSTEDEND:			
                        movement = mShapeAnimationStep - 1;
                        if(movement<=1)
                        {
                            gp.getElements().add(new MoveTo(mStart.x, mStart.y));
                            gp.getElements().add(new QuadCurveTo((mStart.x + mEnd.x) / 2, mStart.y - 3, mEnd.x, mEnd.y));
                        }
                        else
                        {
                            gp.getElements().add(new MoveTo(mStart.x, mStart.y - movement/4));
                            gp.getElements().add(new QuadCurveTo((mStart.x + mEnd.x) / 2, mStart.y - 3 + movement/7 , mEnd.x + movement/10, mEnd.y));
                        }
                        this.getChildren().add(gp);
                        break;

                case SURPRISED:
                        movement = Animator.sMAX_ANIM_STEPS - mShapeAnimationStep;

                        gp.getElements().add(new MoveTo(mStart.x, mStart.y-movement/7));
                        gp.getElements().add(new QuadCurveTo((mStart.x + mEnd.x) / 2, mStart.y-3-movement/7 , mEnd.x, mEnd.y-movement/7));
                        this.getChildren().add(gp);
                        break;

                case SURPRISEDEND:
                        movement = mShapeAnimationStep - 1;
                        if(movement<=1)
                        {
                            gp.getElements().add(new MoveTo(mStart.x, mStart.y));
                            gp.getElements().add(new QuadCurveTo((mStart.x + mEnd.x) / 2, mStart.y - 3, mEnd.x, mEnd.y));
                        }
                        else
                        {
                            gp.getElements().add(new MoveTo(mStart.x, mStart.y-movement/7));
                            gp.getElements().add(new QuadCurveTo((mStart.x + mEnd.x) / 2, mStart.y-3-movement/7 , mEnd.x, mEnd.y-movement/7));
                        }
                        this.getChildren().add(gp);
                        break;

                case EXCITED:
                        movement = Animator.sMAX_ANIM_STEPS - mShapeAnimationStep;

                        gp.getElements().add(new MoveTo(mStart.x, mStart.y-movement/4));
                        gp.getElements().add(new QuadCurveTo((mStart.x + mEnd.x) / 2, mStart.y-3 -movement/5 , mEnd.x, mEnd.y-movement/4));
                        this.getChildren().add(gp);
                        break;

                case EXCITEDEND:
                        movement = mShapeAnimationStep - 1;
                        if(movement<=1)
                        {
                            gp.getElements().add(new MoveTo(mStart.x, mStart.y));
                            gp.getElements().add(new QuadCurveTo((mStart.x + mEnd.x) / 2, mStart.y - 3, mEnd.x, mEnd.y));
                        }
                        else
                        {
                            gp.getElements().add(new MoveTo(mStart.x, mStart.y-movement/4));
                            gp.getElements().add(new QuadCurveTo((mStart.x + mEnd.x) / 2, mStart.y-3 -movement/5 , mEnd.x, mEnd.y-movement/4));
                        }
                        this.getChildren().add(gp);
                        break;

                case EMBARRASSED:
                        movement = Animator.sMAX_ANIM_STEPS - mShapeAnimationStep;

                        gp.getElements().add(new MoveTo(mStart.x + movement/2, mStart.y + movement/3));
                        gp.getElements().add(new QuadCurveTo((mStart.x + movement/2 + mEnd.x + movement/2) / 2, mStart.y - 3 + movement/10*7, mEnd.x + movement/2, mEnd.y + movement/2));
                        this.getChildren().add(gp);
                        break;

                case EMBARRASSEDEND:
                        movement = mShapeAnimationStep - 1;
                        if(movement<=1)
                        {
                                gp.getElements().add(new MoveTo(mStart.x, mStart.y));
                                gp.getElements().add(new QuadCurveTo((mStart.x + mEnd.x) / 2, mStart.y - 3, mEnd.x, mEnd.y));
                        }
                        else
                        {
                                gp.getElements().add(new MoveTo(mStart.x + movement/2, mStart.y + movement/3));
                                gp.getElements().add(new QuadCurveTo((mStart.x + movement/2 + mEnd.x + movement/2) / 2, mStart.y - 3 + movement/10*7, mEnd.x + movement/2, mEnd.y + movement/2));
                        }
                        this.getChildren().add(gp);
                        break;
            }

		addToDrawObjects(gp);
	}

}
