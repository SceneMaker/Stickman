package de.dfki.stickman3D.animation.gesture;

import de.dfki.common.animationlogic.AnimationContent;
import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.animationlogic.AnimationStickman3D;

import java.util.HashMap;

/**
 * Created by alvaro on 1/20/17.
 */
public abstract class AbstractConversationHands extends AnimationStickman3D
{
    public static final int MAXIMUM = 10;
    public static final int START_LEFT_FORE_ARM_POSITION = 39;
    public static final int START_RIGHT_FORE_ARM_POSITION = -29;
    public boolean keepMoving = true;
    protected boolean movementFinished = false;
    protected int intensity;
    protected boolean moveDown;
    protected int leftForeArmZ;
    protected int rightForeArmZ;

    public AbstractConversationHands()
    {
        mAnimType = ANIMTYPE.ON;
    }

    public AbstractConversationHands(Stickman3D sm, int duration, boolean block)
    {
        super(sm, duration, block);
        intensity = 10;
    }

    public AbstractConversationHands(Stickman3D sm, int duration, boolean block, HashMap<String, String> extraParams)
    {
        super(sm, duration, block);
        this.intensity = 10;
        if (extraParams.containsKey("intensity"))
        {
            String intensityVal = extraParams.get("intensity");
            this.intensity = Integer.parseInt(intensityVal);
        }
    }

    abstract protected int getLeftArmMovement();

    abstract protected int getRightArmMovement();

    protected void moveConversationHands()
    {
        leftForeArmZ = getLeftArmMovement();
        rightForeArmZ = getRightArmMovement();
        moveArms(new AnimationContent(((Stickman3D) agent).mRightForeArm, "zrotate", rightForeArmZ), new AnimationContent(((Stickman3D) agent).mLeftForeArm, "zrotate", leftForeArmZ));
    }

    protected int getMaximumPermitedMovement()
    {
        return MAXIMUM * intensity / 10;
    }

    protected int getMinumumPermittedMovemnt()
    {
        return 1;
    }

    protected int getMovementDistance()
    {
        return getMaximumPermitedMovement();

    }

    protected void moveArms(AnimationContent zrotate, AnimationContent zrotate2)
    {
        mAnimationPart.add(zrotate);
        mAnimationPart.add(zrotate2);
    }


}
