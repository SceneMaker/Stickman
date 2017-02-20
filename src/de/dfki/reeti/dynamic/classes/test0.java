package de.dfki.reeti.dynamic.classes;

import java.util.ArrayList;
import de.dfki.reeti.Reeti;
import de.dfki.reeti.ReetiStageController;
import de.dfki.reeti.animationlogic.AnimationContentReeti;
import de.dfki.reeti.animationlogic.AnimationReeti;

public class test0 extends AnimationReeti {

    public test0() {
        mAnimType = ANIMTYPE.ON;
    }

    public test0(Reeti sm, int duration, boolean block) {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation() {
        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContentReeti(mReeti.mHead, "rotate", 0));
        mAnimationPartFX.add(new AnimationContentReeti(mReeti.mHead, "yrotate", 57));
        mAnimationPartFX.add(new AnimationContentReeti(mReeti.mHead, "zrotate", 0));
        playAnimationPart(mDuration);
        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContentReeti(mReeti.mHead, "rotate", 0));
        mAnimationPartFX.add(new AnimationContentReeti(mReeti.mHead, "yrotate", -104));
        mAnimationPartFX.add(new AnimationContentReeti(mReeti.mHead, "zrotate", 0));
        playAnimationPart(mDuration);
        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContentReeti(mReeti.mHead, "rotate", 0));
        mAnimationPartFX.add(new AnimationContentReeti(mReeti.mHead, "yrotate", 112));
        mAnimationPartFX.add(new AnimationContentReeti(mReeti.mHead, "zrotate", 0));
        playAnimationPart(mDuration);
        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContentReeti(mReeti.mHead, "rotate", 0));
        mAnimationPartFX.add(new AnimationContentReeti(mReeti.mHead, "yrotate", -119));
        mAnimationPartFX.add(new AnimationContentReeti(mReeti.mHead, "zrotate", 0));
        playAnimationPart(mDuration);
    }
}
