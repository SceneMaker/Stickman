package de.dfki.stickman3D.animation.gesture;

import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.animationlogic.Animation3D;
import de.dfki.stickman3D.animationlogic.AnimationContent3D;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by alvaro on 1/20/17.
 */
public class HeadConversation extends Animation3D {

    private int degrees;
    private String axis;
    private static int current_movment = 0;

    public HeadConversation() {
        mAnimType = ANIMTYPE.ON;
    }

    public HeadConversation(Stickman3D sm, int duration, boolean block) {
        super(sm, duration, block);
        degrees = 10;
        axis = "z";
    }

    public HeadConversation(Stickman3D sm, int duration, boolean block, HashMap<String, String> extraParams) {
        super(sm, duration, block);
        this.degrees = 10;
        this.axis = "z";
        this.extraParams = extraParams;
        if(extraParams.containsKey("degrees")){
            String value =  extraParams.get("degrees");
            this.degrees = Integer.parseInt(value);
        }
        if(extraParams.containsKey("axis")){
            this.axis  = (String) extraParams.get("axis");
        }
        block = true;
    }

    @Override
    public void playAnimation() {
        int movement = degrees;
        current_movment+= movement;
        mAnimationPartFX = new ArrayList<>();
        String rotationAxis = getRotationAxisName();
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mHead, rotationAxis, current_movment));
        playAnimationPart(200);
        pauseAnimation(500);
        current_movment = movement * -1;

    }


    private String getRotationAxisName() {
        String rotationAxisName = "rotate";
        if(axis.contains("z")){
            rotationAxisName = "z"+rotationAxisName;
        }else if(axis.contains("y")){
            rotationAxisName = "y"+rotationAxisName;
        }
        return rotationAxisName;
    }



}

