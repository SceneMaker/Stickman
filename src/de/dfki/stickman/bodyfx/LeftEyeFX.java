package de.dfki.stickman.bodyfx;

import de.dfki.stickman.body.*;
import de.dfki.stickman.Stickman;
import de.dfki.stickman.animationlogic.Animator;

import java.awt.Point;
import java.awt.geom.GeneralPath;
import static de.dfki.stickman.animationlogic.util.Interpolator.linear;
import de.dfki.stickmanfx.StickmanFX;
import java.awt.BasicStroke;
import javafx.scene.paint.Color;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.QuadCurveTo;

/**
 *
 * @author Patrick Gebhard
 *
 */
public class LeftEyeFX extends BodyPartFX 
{

    public static enum SHAPE 
    {
            DEFAULT, BLINK, LOOKLEFT, LOOKRIGHT, ANGRY, ANGRYEND, SURPRISED, SURPRISEDEND, HAPPY, HAPPYEND, DISGUSTED, DISGUSTEDEND, LOVED, LOVEDEND, CONTEMPT, CONTEMPTEND, EXCITED, EXCITEDEND, EMBARRASSED, EMBARRASSEDEND
    };

    HeadFX mHeadFX;
    public LeftEyeFX.SHAPE mShape = LeftEyeFX.SHAPE.DEFAULT;

    public LeftEyeFX(HeadFX head) {
            mHeadFX = head;
            mLength = 5;
            mDefaultRotationPoint = mHeadFX.mDefaultRotationPoint;
            mColor = Color.rgb(mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.FEMALE ? 22 : 0,
              mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.FEMALE ? 40 : 0,
              mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.FEMALE ? 65 : 0, (144*100/255)/100f);
            mStroke = new BasicStroke(2.5f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);

            init();
    }

    @Override
    public void setShape(String s) 
    {
        SHAPE shape = SHAPE.valueOf(s);
        mShape = (shape != null) ? shape : SHAPE.DEFAULT;
    }

    @Override
    public void resetShape() 
    {
        mShape = LeftEyeFX.SHAPE.DEFAULT;
    }

    @Override
    public void createShape() 
    {
//		mStart: right side
//		mEnd:left side
            mStart = mHeadFX.getLeftEyePostion();
            mEnd = new Point(mStart.x - mLength, mStart.y);

            double movement;

            clearDrawObjects();
            Path gp = new Path();

            switch (mShape) {
                case DEFAULT:
                    if(mHeadFX.mStickmanFX.setCharacterInvisible == true)
                    {
                        if(mHeadFX.mStickmanFX.fadeControler==true)             //Added by Robbie
                        {
                                int fadeFactor = mHeadFX.mStickmanFX.mMouthFX.mShapeAnimationStep*7;
                                if(fadeFactor<=14) fadeFactor=0;
                                mColor = new Color(mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.FEMALE ? 22 : 0, 
                                                mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.FEMALE ? 40 : 0,
                                                mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.FEMALE ? 65 : 0, (fadeFactor*100/255)/100f);
                        }
                        else
                        {
                            int fadeFactor = (20-mHeadFX.mStickmanFX.mMouthFX.mShapeAnimationStep)*7;
                            if(fadeFactor==126) fadeFactor=0;
                            if(fadeFactor >= 118) fadeFactor=145;
                            mColor = new Color(mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.FEMALE ? 22 : 0,
                              mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.FEMALE ? 40 : 0,
                                              mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.FEMALE ? 65 : 0, (fadeFactor*100/255)/100f);
                        }
                    }

                    gp = new Path();
                    gp.getElements().add(new MoveTo(mStart.x, mStart.y));
                    gp.getElements().add(new QuadCurveTo((mStart.x + mEnd.x) / 2, mStart.y - 3, mEnd.x, mEnd.y));
                    this.getChildren().add(gp);
                    break;

                case BLINK:
                        gp = new Path();
                        gp.getElements().add(new MoveTo(mStart.x, mStart.y));
                        gp.getElements().add(new LineTo(mEnd.x, mEnd.y));
                        this.getChildren().add(gp);
                        break;

                case LOOKLEFT:
                        gp = new Path();
                        gp.getElements().add(new MoveTo(mStart.x, mStart.y));
                        gp.getElements().add(new QuadCurveTo(linear((mStart.x + mEnd.x) / 2, mStart.x, mShapeAnimationStep), mStart.y - 3, mEnd.x, mEnd.y));
                        this.getChildren().add(gp);
                        break;

                case LOOKRIGHT:
                        gp = new Path();
                        gp.getElements().add(new MoveTo(mStart.x, mStart.y));
                        gp.getElements().add(new QuadCurveTo(linear((mStart.x + mEnd.x) / 2, mEnd.x, mShapeAnimationStep), mStart.y - 3, mEnd.x, mEnd.y));
                        this.getChildren().add(gp);
                        break;

                case ANGRY:
                        movement = Animator.sMAX_ANIM_STEPS - mShapeAnimationStep;

                        gp.getElements().add(new MoveTo(mStart.x - movement/10, mStart.y));
                        gp.getElements().add(new QuadCurveTo((mStart.x - movement/10 + mEnd.x - movement/8) / 2, mStart.y - movement/6, mEnd.x - movement/8, mEnd.y));
                        gp.getElements().add(new QuadCurveTo((mStart.x - movement/10 + mEnd.x - movement/8) / 2, mStart.y + movement/6, mStart.x - movement/10, mStart.y));
                        this.getChildren().add(gp);
                        break;

                case ANGRYEND:
                        movement = mShapeAnimationStep-1;
                        if(movement<=1){
                                gp.getElements().add(new MoveTo(mStart.x, mStart.y));
                                gp.getElements().add(new QuadCurveTo((mStart.x + mEnd.x) / 2, mStart.y - 3, mEnd.x, mEnd.y));
                        }
                        else{
                                gp.getElements().add(new MoveTo(mStart.x - movement/10, mStart.y));
                                gp.getElements().add(new QuadCurveTo((mStart.x - movement/10 + mEnd.x - movement/8) / 2, mStart.y - movement/6, mEnd.x - movement/8, mEnd.y));
                                gp.getElements().add(new QuadCurveTo((mStart.x - movement/10 + mEnd.x - movement/8) / 2, mStart.y + movement/6, mStart.x - movement/10, mStart.y));
                        }
                        this.getChildren().add(gp);
                        break;


                case SURPRISED:
                        movement = Animator.sMAX_ANIM_STEPS - mShapeAnimationStep;

                        gp.getElements().add(new MoveTo(mStart.x + movement/10, mStart.y));
                        gp.getElements().add(new QuadCurveTo((mStart.x + movement/10 + mEnd.x-movement/10)/2, mStart.y - movement/2, mEnd.x-movement/10, mStart.y));
                        gp.getElements().add(new QuadCurveTo((mStart.x + movement/10 + mEnd.x-movement/10)/2, mStart.y + movement/2, mStart.x+movement/10, mStart.y));
                        this.getChildren().add(gp);
                        break;

                case SURPRISEDEND:
                        movement = mShapeAnimationStep -1;
                        if(movement<=1){
                                gp.getElements().add(new MoveTo(mStart.x, mStart.y));
                                gp.getElements().add(new QuadCurveTo((mStart.x + mEnd.x) / 2, mStart.y - 3, mEnd.x, mEnd.y));
                        }
                        else{
                                gp.getElements().add(new MoveTo(mStart.x + movement/10, mStart.y));
                                gp.getElements().add(new QuadCurveTo((mStart.x + movement/10 + mEnd.x-movement/10)/2, mStart.y - movement/2, mEnd.x-movement/10, mStart.y));
                                gp.getElements().add(new QuadCurveTo((mStart.x + movement/10 + mEnd.x-movement/10)/2, mStart.y + movement/2, mStart.x+movement/10, mStart.y));
                        }
                        this.getChildren().add(gp);
                        break;

                case HAPPY:
                        movement = Animator.sMAX_ANIM_STEPS - mShapeAnimationStep;

                        gp.getElements().add(new MoveTo(mStart.x + movement/10, mStart.y));
                        gp.getElements().add(new QuadCurveTo((mStart.x + movement/10 + mEnd.x - movement/10)/2, mStart.y - 3, mEnd.x - movement/10, mEnd.y));
                        this.getChildren().add(gp);
                        break;	

                case HAPPYEND:
                        movement = mShapeAnimationStep -1;
                        if(movement<=1){
                                gp.getElements().add(new MoveTo(mStart.x, mStart.y));
                                gp.getElements().add(new QuadCurveTo((mStart.x + mEnd.x) / 2, mStart.y - 3, mEnd.x, mEnd.y));
                        }
                        else{			
                                gp.getElements().add(new MoveTo(mStart.x + movement/10, mStart.y));
                                gp.getElements().add(new QuadCurveTo((mStart.x + movement/10 + mEnd.x - movement/10)/2, mStart.y - 3, mEnd.x - movement/10, mEnd.y));
                        }
                        this.getChildren().add(gp);
                        break;
                case DISGUSTED:
                        movement = Animator.sMAX_ANIM_STEPS - mShapeAnimationStep;

                        gp.getElements().add(new MoveTo(mStart.x + movement/4, mStart.y - movement/4));
                        gp.getElements().add(new QuadCurveTo((mStart.x + mEnd.x) / 2, mStart.y - 3 + movement/8, mEnd.x - movement/8, mEnd.y + movement/8));
                        gp.getElements().add(new QuadCurveTo((mStart.x + mEnd.x) / 2, mStart.y - 3 + movement/4, mStart.x + movement/4, mStart.y + movement/8));
                        this.getChildren().add(gp);
                        break;

                case DISGUSTEDEND:
                        movement = mShapeAnimationStep -1;
                        if(movement<=1){
                                gp.getElements().add(new MoveTo(mStart.x, mStart.y));
                                gp.getElements().add(new QuadCurveTo((mStart.x + mEnd.x) / 2, mStart.y - 3, mEnd.x, mEnd.y));
                        }
                        else{	
                                gp.getElements().add(new MoveTo(mStart.x + movement/4, mStart.y - movement/4));
                                gp.getElements().add(new QuadCurveTo((mStart.x + mEnd.x) / 2, mStart.y - 3 + movement/8, mEnd.x - movement/8, mEnd.y + movement/8));
                                gp.getElements().add(new QuadCurveTo((mStart.x + mEnd.x) / 2, mStart.y - 3 + movement/4, mStart.x + movement/4, mStart.y + movement/8));
                        }
                        this.getChildren().add(gp);
                        break;

                case LOVED:
                        movement = Animator.sMAX_ANIM_STEPS - mShapeAnimationStep;

                        double xMovement = movement/10*6;
                        double yMovement1 = movement/10*6;
                        double yMovement2 = movement/10*3;

                        gp.getElements().add(new MoveTo(mStart.x, mStart.y));
                        gp.getElements().add(new QuadCurveTo(mStart.x - xMovement, mEnd.y - yMovement2, mStart.x, mEnd.y + yMovement1));
                        gp.getElements().add(new MoveTo(mStart.x, mStart.y));
                        gp.getElements().add(new QuadCurveTo(mStart.x + xMovement, mEnd.y - yMovement2, mStart.x, mEnd.y + yMovement1));
                        this.getChildren().add(gp);
                        break;	

                case LOVEDEND:
                        movement = mShapeAnimationStep -1;
                        if(movement<=1){
                                gp.getElements().add(new MoveTo(mStart.x, mStart.y));
                                gp.getElements().add(new QuadCurveTo((mStart.x + mEnd.x) / 2, mStart.y - 3, mEnd.x, mEnd.y));
                        }
                        else{
                                xMovement = movement/10*6;
                                yMovement1 = movement/10*6;
                                yMovement2 = movement/10*3;

                                gp.getElements().add(new MoveTo(mStart.x, mStart.y));
                                gp.getElements().add(new QuadCurveTo(mStart.x - xMovement, mEnd.y - yMovement2, mStart.x, mEnd.y + yMovement1));
                                gp.getElements().add(new MoveTo(mStart.x, mStart.y));
                                gp.getElements().add(new QuadCurveTo(mStart.x + xMovement, mEnd.y - yMovement2, mStart.x, mEnd.y + yMovement1));
                        }
                        this.getChildren().add(gp);
                        break;	

                case CONTEMPT:
                        movement = Animator.sMAX_ANIM_STEPS - mShapeAnimationStep;

                        gp.getElements().add(new MoveTo(mStart.x, mStart.y));
                        gp.getElements().add(new QuadCurveTo((mStart.x + mEnd.x)/2, mStart.y - movement/10, mEnd.x, mStart.y));
                        gp.getElements().add(new QuadCurveTo((mStart.x + mEnd.x)/2, mStart.y + movement/10, mStart.x, mStart.y));
                        this.getChildren().add(gp);
                        break;

                case CONTEMPTEND:
                        movement = mShapeAnimationStep -1;
                        if(movement<=1){
                                gp.getElements().add(new MoveTo(mStart.x, mStart.y));
                                gp.getElements().add(new QuadCurveTo((mStart.x + mEnd.x) / 2, mStart.y - 3, mEnd.x, mEnd.y));
                        }
                        else{
                                gp.getElements().add(new MoveTo(mStart.x, mStart.y));
                                gp.getElements().add(new QuadCurveTo((mStart.x + mEnd.x)/2, mStart.y - movement/10, mEnd.x, mStart.y));
                                gp.getElements().add(new QuadCurveTo((mStart.x + mEnd.x)/2, mStart.y + movement/10, mStart.x, mStart.y));
                        }
                        this.getChildren().add(gp);
                        break;

                case EXCITED:
                        movement = Animator.sMAX_ANIM_STEPS - mShapeAnimationStep;

                        gp.getElements().add(new MoveTo(mStart.x + movement/10, mStart.y));
                        gp.getElements().add(new QuadCurveTo((mStart.x + mEnd.x) / 2, mStart.y - 3, mEnd.x - movement/10, mEnd.y));
                        this.getChildren().add(gp);
                        break;

                case EXCITEDEND:
                        movement = mShapeAnimationStep -1;
                        if(movement<=1){
                                gp.getElements().add(new MoveTo(mStart.x, mStart.y));
                                gp.getElements().add(new QuadCurveTo((mStart.x + mEnd.x) / 2, mStart.y - 3, mEnd.x, mEnd.y));
                        }
                        else{
                                gp.getElements().add(new MoveTo(mStart.x + movement/10, mStart.y));
                                gp.getElements().add(new QuadCurveTo((mStart.x + mEnd.x) / 2, mStart.y - 3, mEnd.x - movement/10, mEnd.y));
                        }
                        this.getChildren().add(gp);
                        break;		

                case EMBARRASSED:
                        movement = Animator.sMAX_ANIM_STEPS - mShapeAnimationStep;

                        gp.getElements().add(new MoveTo(mStart.x + movement/2, mStart.y + movement/5*2));
                        gp.getElements().add(new QuadCurveTo((mStart.x + movement/2 + mEnd.x + movement/2) / 2, mStart.y - 4 + movement/2, mEnd.x + movement/2, mEnd.y + movement/5*2));			
                        this.getChildren().add(gp);
                        break;

                case EMBARRASSEDEND:
                        movement = mShapeAnimationStep -1;
                        if(movement<=1){
                                gp.getElements().add(new MoveTo(mStart.x, mStart.y));
                                gp.getElements().add(new QuadCurveTo((mStart.x + mEnd.x) / 2, mStart.y - 3, mEnd.x, mEnd.y));
                        }
                        else{
                                gp.getElements().add(new MoveTo(mStart.x + movement/2, mStart.y + movement/5*2));
                                gp.getElements().add(new QuadCurveTo((mStart.x + movement/2 + mEnd.x + movement/2) / 2, mStart.y - 4 + movement/2, mEnd.x + movement/2, mEnd.y + movement/5*2));			
                        }
                        break;

            }
            addToDrawObjects(gp);
    }
}
