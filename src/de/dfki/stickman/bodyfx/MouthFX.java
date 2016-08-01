package de.dfki.stickman.bodyfx;

import de.dfki.stickmanfx.StickmanFX;
import de.dfki.stickman.animationlogicfx.Animator;
import java.awt.Dimension;
import java.awt.Point;
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
public class MouthFX extends BodyPartFX {

	public static enum SHAPE {

		DEFAULT, SMILE, SMILEEND, SAD, SADEND, ANGRY, ANGRYEND, ANGRYSMALLMOUTH, ANGRYSMALLMOUTHEND, SURPRISED, SURPRISEDEND, 
		HAPPY, HAPPYEND, DISGUSTED, DISGUSTEDEND, CONTEMPT, CONTEMPTEND, EXCITED, EXCITEDEND, 
		EMBARRASSED, EMBARRASSEDEND, FEAR, FEAREND, O, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, 
		EIGHT, NINE, TEN, ELEVEN, TWELVE, THIRTEEN, FOURTEEN,NINETEEN, TWENTY,
	};

	HeadFX mHeadFX;

	public MouthFX.SHAPE mShape = MouthFX.SHAPE.DEFAULT;

	public MouthFX(HeadFX head) {
		mHeadFX = head;
		mLength = 20;
		mSize = new Dimension(mLength * 2, 5);
		mDefaultRotationPoint = mHeadFX.mDefaultRotationPoint;
		mColor = Color.rgb(mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.FEMALE ? 64 : 32, 0, 0, (128*100/255)/100f);

		init();
	}

	@Override
	public void setShape(String s) {
		MouthFX.SHAPE shape = MouthFX.SHAPE.valueOf(s);
		mShape = (shape != null) ? shape : MouthFX.SHAPE.DEFAULT;
	}

	@Override
	public void resetShape() {
		mShape = MouthFX.SHAPE.DEFAULT;
	}

	@Override
	public void createShape() 
        {
//        System.out.println("test");

//          mStart:middle
//          mEnd:right side
            mStart = mHeadFX.getMouthPostion();
            mEnd = new Point(mStart.x + mLength / 2, mStart.y);

            double movement;

            clearDrawObjects();
            
            Path gp = new Path();
            
            switch (mShape) {
                    case DEFAULT:
                        if(mHeadFX.mStickmanFX.setCharacterInvisible == true)
                        {
                            if(mHeadFX.mStickmanFX.fadeControler==true)             //Added by Robbie
                            {
                                int fadeFactor = mHeadFX.mStickmanFX.mMouthFX.mShapeAnimationStep*6;
                                if(fadeFactor<=12) fadeFactor=0;
                                mColor = Color.rgb(mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.FEMALE ? 64 : 32, 0, 0, (fadeFactor*100/255)/100f);
                            }
                            else
                            {
                                int fadeFactor = (20-mHeadFX.mStickmanFX.mMouthFX.mShapeAnimationStep)*6;
                                if(fadeFactor >= 107) fadeFactor=128;
                                mColor = new Color(mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.FEMALE ? 64 : 32, 0, 0, (fadeFactor*100/255)/100f);
                            }
                        }

                            gp.getElements().add(new MoveTo(mStart.x - mLength / 2, mStart.y));
                            gp.getElements().add(new QuadCurveTo(mStart.x, mStart.y + 1, mEnd.x, mEnd.y));							
                            this.getChildren().add(gp);
                            break;

                    case SMILE:
                            movement = Animator.sMAX_ANIM_STEPS - mShapeAnimationStep;

                            gp.getElements().add(new MoveTo(mStart.x - mLength / 2 - movement/3*2, mStart.y - movement/2));
                            gp.getElements().add(new QuadCurveTo(mStart.x, mStart.y + 1 + movement/3*2, mEnd.x + movement/3*2, mStart.y - movement/2));
                            this.getChildren().add(gp);
                            break;

                    case SMILEEND:
                            movement = mShapeAnimationStep-1;
                            if(movement<=1) 
                                    {
                                    gp.getElements().add(new MoveTo(mStart.x - mLength / 2, mStart.y));
                                    gp.getElements().add(new QuadCurveTo(mStart.x, mStart.y + 1, mEnd.x, mEnd.y));
                                    }
                            else{
                                    gp.getElements().add(new MoveTo(mStart.x - mLength / 2 - movement/3*2, mStart.y - movement/2));
                                    gp.getElements().add(new QuadCurveTo(mStart.x, mStart.y + 1 + movement/3*2, mEnd.x + movement/3*2, mStart.y - movement/2));
                                    }
                            this.getChildren().add(gp);
                            break;

                    case SAD:
                            movement = Animator.sMAX_ANIM_STEPS - mShapeAnimationStep;

                            gp.getElements().add(new MoveTo(mStart.x - mLength/2 - movement/2, mStart.y + movement/4));
                            gp.getElements().add(new QuadCurveTo(mStart.x, mStart.y - movement, mEnd.x + movement/2, mEnd.y + movement/4));
                            this.getChildren().add(gp);
                            break;

                    case SADEND:
                            movement = mShapeAnimationStep-1;
                            if(movement<=1) 
                                    {
                                    gp.getElements().add(new MoveTo(mStart.x - mLength / 2, mStart.y));
                                    gp.getElements().add(new QuadCurveTo(mStart.x, mStart.y + 1, mEnd.x, mEnd.y));
                                    }
                            else{
                                    gp.getElements().add(new MoveTo(mStart.x - mLength/2 - movement/2, mStart.y + movement/4));
                                    gp.getElements().add(new QuadCurveTo(mStart.x, mStart.y - movement, mEnd.x + movement/2, mEnd.y + movement/4));
                                    }
                            this.getChildren().add(gp);
                            break;

                    case ANGRY:	
                            movement = Animator.sMAX_ANIM_STEPS - mShapeAnimationStep;                          
                            gp.getElements().add(new MoveTo(mStart.x - mLength/2 - movement/4, mStart.y + movement/10));
                            gp.getElements().add(new QuadCurveTo(mStart.x, mStart.y +1 - movement/3*2, mEnd.x + movement/4, mStart.y + movement/10));                       
                            this.getChildren().add(gp);
                            break;

                    case ANGRYEND:			
                            movement = mShapeAnimationStep-1;
                            if(movement<=1)
                            {
                                    gp.getElements().add(new MoveTo(mStart.x - mLength / 2, mStart.y));
                                    gp.getElements().add(new QuadCurveTo(mStart.x, mStart.y + 1, mEnd.x, mEnd.y));	
                            }
                            else{
                                    gp.getElements().add(new MoveTo(mStart.x - mLength/2 - movement/4, mStart.y + movement/10));
                                    gp.getElements().add(new QuadCurveTo(mStart.x, mStart.y +1 - movement/3*2, mEnd.x + movement/4, mStart.y + movement/10));
                            }
                            this.getChildren().add(gp);
                            break;

                    case ANGRYSMALLMOUTH:				
                            movement = Animator.sMAX_ANIM_STEPS - mShapeAnimationStep;

                            gp.getElements().add(new MoveTo(mStart.x - mLength/2 + movement/10, mStart.y + movement/10));
                            gp.getElements().add(new QuadCurveTo(mStart.x, mStart.y +1 - movement/4, mEnd.x - movement/10, mStart.y + movement/10));
                            this.getChildren().add(gp);
                            break;

                    case ANGRYSMALLMOUTHEND:			
                            movement = mShapeAnimationStep-1;
                            if(movement<=1)
                            {
                                    gp.getElements().add(new MoveTo(mStart.x - mLength / 2, mStart.y));
                                    gp.getElements().add(new QuadCurveTo(mStart.x, mStart.y + 1, mEnd.x, mEnd.y));	
                            }
                            else{
                                    gp.getElements().add(new MoveTo(mStart.x - mLength/2 + movement/10, mStart.y + movement/10));
                                    gp.getElements().add(new QuadCurveTo(mStart.x, mStart.y +1 - movement/4, mEnd.x - movement/10, mStart.y + movement/10));
                            }
                            this.getChildren().add(gp);
                            break;

                    case SURPRISED:
                            movement = Animator.sMAX_ANIM_STEPS - mShapeAnimationStep;

                            gp.getElements().add(new QuadCurveTo(mStart.x-movement/4-4, mStart.y - movement/2, mStart.x, mStart.y - movement/2-1));
                            gp.getElements().add(new QuadCurveTo(mStart.x+movement/4+4, mStart.y - movement/2, mEnd.x, mStart.y));
                            gp.getElements().add(new QuadCurveTo(mStart.x+movement/4+4, mStart.y + movement/2, mStart.x, mStart.y + movement/2+1));
                            gp.getElements().add(new QuadCurveTo(mStart.x-movement/4-4, mStart.y + movement/2, mStart.x - mLength / 2, mStart.y));
                            this.getChildren().add(gp);
                            break;

                    case SURPRISEDEND:
                            movement = mShapeAnimationStep-1;
                            if(movement<=1)
                            {
                                    gp.getElements().add(new MoveTo(mStart.x - mLength / 2, mStart.y));
                                    gp.getElements().add(new QuadCurveTo(mStart.x, mStart.y + 1, mEnd.x, mEnd.y));	
                            }
                            else{
                                    gp.getElements().add(new MoveTo(mStart.x - mLength / 2, mStart.y));
                                    gp.getElements().add(new QuadCurveTo(mStart.x-movement/4-4, mStart.y - movement/2, mStart.x, mStart.y - movement/2-1));
                                    gp.getElements().add(new QuadCurveTo(mStart.x+movement/4+4, mStart.y - movement/2, mEnd.x, mStart.y));
                                    gp.getElements().add(new QuadCurveTo(mStart.x+movement/4+4, mStart.y + movement/2, mStart.x, mStart.y + movement/2+1));
                                    gp.getElements().add(new QuadCurveTo(mStart.x-movement/4-4, mStart.y + movement/2, mStart.x - mLength / 2, mStart.y));
                            }
                            this.getChildren().add(gp);
                            break;

                    case HAPPY:
                            movement = Animator.sMAX_ANIM_STEPS - mShapeAnimationStep;

                            gp.getElements().add(new MoveTo(mStart.x - mLength/2 - movement/2, mStart.y - movement/4));
                            gp.getElements().add(new QuadCurveTo(mStart.x, mStart.y + 1 + movement, mEnd.x + movement/2, mStart.y - movement/4));
                            gp.getElements().add(new LineTo(mStart.x - mLength/2 - movement/2, mStart.y- movement/4));
                            this.getChildren().add(gp);
                            break;	

                    case HAPPYEND:
                            movement = mShapeAnimationStep-1;
                            if(movement<=1)
                            {
                                    gp.getElements().add(new MoveTo(mStart.x - mLength / 2, mStart.y));
                                    gp.getElements().add(new QuadCurveTo(mStart.x, mStart.y + 1, mEnd.x, mEnd.y));	
                            }
                            else{
                                    gp.getElements().add(new MoveTo(mStart.x - mLength/2 - movement/2, mStart.y - movement/4));
                                    gp.getElements().add(new QuadCurveTo(mStart.x, mStart.y + 1 + movement, mEnd.x + movement/2, mStart.y - movement/4));
                                    gp.getElements().add(new LineTo(mStart.x - mLength/2 - movement/2, mStart.y- movement/4));
                            }
                            this.getChildren().add(gp);
                            break;

                    case DISGUSTED:
                            movement = mLength/2 + (Animator.sMAX_ANIM_STEPS - mShapeAnimationStep)/2;

                            gp.getElements().add(new MoveTo(mStart.x - movement, mStart.y));
                            gp.getElements().add(new QuadCurveTo(mStart.x - movement*2/3, mStart.y - movement/4 , mStart.x - movement/3, mStart.y));
                            gp.getElements().add(new QuadCurveTo(mStart.x, mStart.y + movement/4 , mStart.x + movement/3, mStart.y));
                            gp.getElements().add(new QuadCurveTo(mStart.x + movement*2/3, mStart.y - movement/4 ,mStart.x + movement, mEnd.y));	
                            this.getChildren().add(gp);
                            break;	

                    case DISGUSTEDEND:
                            movement = mLength/2 + mShapeAnimationStep/2;
                            if(mShapeAnimationStep-1 <= 1)
                            {	
                                    gp.getElements().add(new MoveTo(mStart.x - mLength / 2, mStart.y));
                                    gp.getElements().add(new QuadCurveTo(mStart.x, mStart.y + 1, mEnd.x, mEnd.y));
                            }
                            else{
                                    gp.getElements().add(new MoveTo(mStart.x - movement, mStart.y));
                                    gp.getElements().add(new QuadCurveTo(mStart.x - movement*2/3, mStart.y - movement/4 , mStart.x - movement/3, mStart.y));
                                    gp.getElements().add(new QuadCurveTo(mStart.x, mStart.y + movement/4 , mStart.x + movement/3, mStart.y));
                                    gp.getElements().add(new QuadCurveTo(mStart.x + movement*2/3, mStart.y - movement/4 ,mStart.x + movement, mEnd.y));			
                            }
                            this.getChildren().add(gp);
                            break;

                    case CONTEMPT:		
                            movement = Animator.sMAX_ANIM_STEPS - mShapeAnimationStep;

                            gp.getElements().add(new MoveTo(mStart.x - mLength / 2, mStart.y));
                            gp.getElements().add(new QuadCurveTo(mStart.x, mStart.y - movement/1.5, mEnd.x + movement/2, mEnd.y-movement/2));	
                            this.getChildren().add(gp);
                            break;	

                    case CONTEMPTEND:	
                            movement = mShapeAnimationStep - 1;

                            if(movement<=1)
                            {
                                    gp.getElements().add(new MoveTo(mStart.x - mLength / 2, mStart.y));
                                    gp.getElements().add(new QuadCurveTo(mStart.x, mStart.y + 1, mEnd.x, mEnd.y));
                            }
                            else
                            {
                                    gp.getElements().add(new MoveTo(mStart.x - mLength / 2, mStart.y));
                                    gp.getElements().add(new QuadCurveTo(mStart.x, mStart.y - movement/1.5, mEnd.x + movement/2, mEnd.y-movement/2));
                            }
                            this.getChildren().add(gp);
                            break;

                    case FEAR:
                            movement = Animator.sMAX_ANIM_STEPS - mShapeAnimationStep;

                            gp.getElements().add(new MoveTo(mStart.x - mLength / 2-movement/4, mStart.y));
                            gp.getElements().add(new QuadCurveTo(mStart.x, mStart.y - movement/2, mEnd.x+movement/4, mEnd.y));
                            gp.getElements().add(new QuadCurveTo(mStart.x, mStart.y -1, mStart.x - mLength / 2-movement/4, mStart.y));
                            this.getChildren().add(gp);
                            break;	

                    case FEAREND:
                            movement = mShapeAnimationStep - 1;

                            if(movement<=1)
                            {
                                    gp.getElements().add(new MoveTo(mStart.x - mLength / 2, mStart.y));
                                    gp.getElements().add(new QuadCurveTo(mStart.x, mStart.y + 1, mEnd.x, mEnd.y));
                            }
                            else
                            {
                                    gp.getElements().add(new MoveTo(mStart.x - mLength / 2-movement/4, mStart.y));
                                    gp.getElements().add(new QuadCurveTo(mStart.x, mStart.y - movement/2, mEnd.x+movement/4, mEnd.y));
                                    gp.getElements().add(new QuadCurveTo(mStart.x, mStart.y -1, mStart.x - mLength / 2-movement/4, mStart.y));
                            }
                            this.getChildren().add(gp);
                            break;

                    case EXCITED:
                            movement = Animator.sMAX_ANIM_STEPS - mShapeAnimationStep;

                            gp.getElements().add(new MoveTo(mStart.x - mLength / 2 - movement/3*2, mStart.y - movement / 2));
                            gp.getElements().add(new QuadCurveTo(mStart.x, mStart.y + movement, mEnd.x + movement/3*2, mStart.y- movement / 2));
                            gp.getElements().add(new LineTo(mStart.x - mLength / 2 - movement/3*2, mStart.y - movement / 2));
                            this.getChildren().add(gp);
                            break;	

                    case EXCITEDEND:
                            movement = mShapeAnimationStep - 1;

                            if(movement<=1)
                            {
                                    gp.getElements().add(new MoveTo(mStart.x - mLength / 2, mStart.y));
                                    gp.getElements().add(new QuadCurveTo(mStart.x, mStart.y + 1, mEnd.x, mEnd.y));
                            }
                            else
                            {
                                    gp.getElements().add(new MoveTo(mStart.x - mLength / 2 - movement/3*2, mStart.y - movement / 2));
                                    gp.getElements().add(new QuadCurveTo(mStart.x, mStart.y + movement, mEnd.x + movement/3*2, mStart.y- movement / 2));
                                    gp.getElements().add(new LineTo(mStart.x - mLength / 2 - movement/3*2, mStart.y - movement / 2));
                            }
                            this.getChildren().add(gp);
                            break;

                    case EMBARRASSED:
                            movement = (Animator.sMAX_ANIM_STEPS - mShapeAnimationStep);

                            gp.getElements().add(new MoveTo(mStart.x - mLength/2 + movement/10*7, mStart.y + movement/20));
                            gp.getElements().add(new QuadCurveTo((mStart.x - mLength/2 + mEnd.x + movement/10*3)/2, mStart.y+1, mEnd.x + movement/10*3, mEnd.y + movement/20));
                            this.getChildren().add(gp);
                            break;

                    case EMBARRASSEDEND:
                            movement = mShapeAnimationStep - 1;

                            if(movement<=1)
                            {
                                    gp.getElements().add(new MoveTo(mStart.x - mLength / 2, mStart.y));
                                    gp.getElements().add(new QuadCurveTo(mStart.x, mStart.y + 1, mEnd.x, mEnd.y));
                            }
                            else
                            {
                                    gp.getElements().add(new MoveTo(mStart.x - mLength/2 + movement/10*7, mStart.y + movement/20));
                                    gp.getElements().add(new QuadCurveTo((mStart.x - mLength/2 + mEnd.x + movement/10*3)/2, mStart.y+1, mEnd.x + movement/10*3, mEnd.y + movement/20));
                            }
                            this.getChildren().add(gp);
                            break;

                    case O:
                            gp.getElements().add(new MoveTo(mStart.x - mLength / 2, mStart.y));
                            gp.getElements().add(new QuadCurveTo(mStart.x, mStart.y - mLength / 2, mEnd.x, mStart.y));
                            gp.getElements().add(new QuadCurveTo(mStart.x, mStart.y + mLength / 2, mStart.x - mLength / 2, mStart.y));
                            this.getChildren().add(gp);
                            break;

        case ONE:
                    case SIX:
                    case FOURTEEN:
                    case NINETEEN:
                            gp.getElements().add(new MoveTo(mStart.x - mLength / 2, mStart.y));
                            gp.getElements().add(new QuadCurveTo(mStart.x, mStart.y - mLength / 5, mEnd.x, mStart.y));
                            gp.getElements().add(new QuadCurveTo(mStart.x, mStart.y + mLength / 5, mStart.x - mLength / 2, mStart.y));
                            this.getChildren().add(gp);
                            break;

                    case TWO:
                            gp.getElements().add(new MoveTo(mStart.x - mLength / 2.8, mStart.y));
                            gp.getElements().add(new QuadCurveTo(mStart.x, mStart.y - mLength / 1.6, mEnd.x - mLength / 6, mStart.y));
                            gp.getElements().add(new QuadCurveTo(mStart.x, mStart.y + mLength / 1.6, mStart.x - mLength / 2.8, mStart.y));
                            this.getChildren().add(gp);
                            break;


                    case THREE:
                    case TWENTY:
                            gp.getElements().add(new MoveTo(mStart.x - mLength / 2.8, mStart.y));
                            gp.getElements().add(new QuadCurveTo(mStart.x, mStart.y - mLength / 2.5, mEnd.x - mLength / 6, mStart.y));
                            gp.getElements().add(new QuadCurveTo(mStart.x, mStart.y + mLength / 2.5, mStart.x - mLength / 2.8, mStart.y));
                            this.getChildren().add(gp);
                            break;

                    case FOUR:
                            gp.getElements().add(new MoveTo(mStart.x - mLength / 2, mStart.y));
                            gp.getElements().add(new QuadCurveTo(mStart.x, mStart.y - 3, mEnd.x, mStart.y));
                            gp.getElements().add(new QuadCurveTo(mStart.x, mStart.y + mLength / 2, mStart.x - mLength / 2, mStart.y));
                            this.getChildren().add(gp);
                            break;



                    case FIVE:
                    case EIGHT:
                            gp.getElements().add(new MoveTo(mStart.x - mLength / 2.8, mStart.y));
                            gp.getElements().add(new QuadCurveTo(mStart.x, mStart.y - mLength / 2, mEnd.x - mLength / 6, mStart.y));
                            gp.getElements().add(new QuadCurveTo(mStart.x, mStart.y + mLength / 2, mStart.x - mLength / 2.8, mStart.y));
                            this.getChildren().add(gp);
                            break;

                    case SEVEN:
                            gp.getElements().add(new MoveTo(mStart.x - mLength / 3, mStart.y));
                            gp.getElements().add(new QuadCurveTo(mStart.x, mStart.y -  3, mEnd.x - mLength / 5, mStart.y));
                            gp.getElements().add(new QuadCurveTo(mStart.x, mStart.y + 3, mStart.x - mLength / 3, mStart.y));
                            this.getChildren().add(gp);
                            break;


                    case NINE:
                            gp.getElements().add(new MoveTo(mStart.x - mLength / 3, mStart.y));
                            gp.getElements().add(new QuadCurveTo(mStart.x, mStart.y - mLength / 2.8, mEnd.x - mLength / 5, mStart.y));
                            gp.getElements().add(new QuadCurveTo(mStart.x, mStart.y + mLength / 1.6, mStart.x - mLength / 3, mStart.y));
                            this.getChildren().add(gp);
                            break;

                    case TEN:
                            gp.getElements().add(new MoveTo(mStart.x - mLength / 2.8, mStart.y));
                            gp.getElements().add(new QuadCurveTo(mStart.x, mStart.y - mLength / 2.8, mEnd.x - mLength / 6, mStart.y));
                            gp.getElements().add(new QuadCurveTo(mStart.x, mStart.y + mLength / 2, mStart.x - mLength / 2.8, mStart.y));
                            break;


            }

		addToDrawObjects(gp);
	}
}