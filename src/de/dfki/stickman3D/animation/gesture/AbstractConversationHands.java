package de.dfki.stickman3D.animation.gesture;

import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.animationlogic.Animation3D;
import de.dfki.stickman3D.animationlogic.AnimationContent3D;

import java.util.HashMap;

/**
 * Created by alvaro on 1/20/17.
 */
public abstract class AbstractConversationHands extends Animation3D {
    public static final int MAXIMUM = 10;
    protected   boolean movementFinished = false;

    public static final int START_LEFT_FORE_ARM_POSITION = 39;
    public static final int START_RIGHT_FORE_ARM_POSITION = -29;

    protected int intensity;
    public boolean keepMoving = true;
    protected boolean moveDown;
    protected int leftForeArmZ;
    protected int rightForeArmZ;

    public AbstractConversationHands() {
        mAnimType = ANIMTYPE.ON;
    }

    public AbstractConversationHands(Stickman3D sm, int duration, boolean block) {
        super(sm, duration, block);
        intensity = 10;
    }
    public AbstractConversationHands(Stickman3D sm, int duration, boolean block,  HashMap<String, String> extraParams) {
        super(sm, duration, block);
        this.intensity = 10;
        if(extraParams.containsKey("intensity")){
            String  intensityVal =  extraParams.get("intensity");
            this.intensity = Integer.parseInt(intensityVal);
        }
    }

    abstract  protected int getLeftArmMovement();
    abstract protected int getRightArmMovement();

    protected void moveConversationHands(){
        leftForeArmZ = getLeftArmMovement();
        rightForeArmZ = getRightArmMovement();
        moveArms(new AnimationContent3D(mStickmanFX.mRightForeArm, "zrotate", rightForeArmZ), new AnimationContent3D(mStickmanFX.mLeftForeArm, "zrotate", leftForeArmZ));
    }

    protected int getMaximumPermitedMovement(){
        return MAXIMUM * intensity/10;
    }

    protected int getMinumumPermittedMovemnt(){
        return 1;
    }

    protected int getMovementDistance(){
        return getMaximumPermitedMovement();

    }

    protected void moveArms(AnimationContent3D zrotate, AnimationContent3D zrotate2) {
        mAnimationPartFX.add(zrotate);
        mAnimationPartFX.add(zrotate2);
    }



}
