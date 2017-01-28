package de.dfki.stickman3D.dynamic.classes; 
import java.util.ArrayList;
import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.StickmanStageController;
import de.dfki.stickman3D.animationlogic.AnimationContent3D;
import de.dfki.stickman3D.animationlogic.Animation3D;public class d extends Animation3D{ 
public d(){ 
mAnimType = ANIMTYPE.ON; 
} 
public d(Stickman3D sm, int duration, boolean block) { 
super(sm, duration, block); 
} 
@Override 
public void playAnimation() { 
mAnimationPartFX = new ArrayList<>(); 
mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftUpperArmFX,"rotate",-92)); 
mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftUpperArmFX,"yrotate",0)); 
mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftUpperArmFX,"zrotate",-10)); 
playAnimationPart(mDuration);
mAnimationPartFX = new ArrayList<>(); 
mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftUpperArmFX,"rotate",59)); 
mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftUpperArmFX,"yrotate",0)); 
mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftUpperArmFX,"zrotate",0)); 
playAnimationPart(mDuration);
mAnimationPartFX = new ArrayList<>(); 
mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftUpperArmFX,"rotate",-45)); 
mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftUpperArmFX,"yrotate",0)); 
mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftUpperArmFX,"zrotate",0)); 
playAnimationPart(mDuration);
mAnimationPartFX = new ArrayList<>(); 
mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftUpperArmFX,"rotate",68)); 
mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftUpperArmFX,"yrotate",0)); 
mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftUpperArmFX,"zrotate",0)); 
playAnimationPart(mDuration);
mAnimationPartFX = new ArrayList<>(); 
mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftForeArmFX,"rotate",-129)); 
mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftForeArmFX,"yrotate",0)); 
mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftForeArmFX,"zrotate",10)); 
playAnimationPart(mDuration);
mAnimationPartFX = new ArrayList<>(); 
mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftForeArmFX,"rotate",0)); 
mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftForeArmFX,"yrotate",50)); 
mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftForeArmFX,"zrotate",0)); 
playAnimationPart(mDuration);
mAnimationPartFX = new ArrayList<>(); 
mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftForeArmFX,"rotate",0)); 
mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftForeArmFX,"yrotate",0)); 
mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftForeArmFX,"zrotate",-56)); 
playAnimationPart(mDuration);
mAnimationPartFX = new ArrayList<>(); 
mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftForeArmFX,"rotate",0)); 
mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftForeArmFX,"yrotate",0)); 
mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftForeArmFX,"zrotate",94)); 
playAnimationPart(mDuration);
mAnimationPartFX = new ArrayList<>(); 
mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftForeArmFX,"rotate",0)); 
mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftForeArmFX,"yrotate",0)); 
mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftForeArmFX,"zrotate",-91)); 
playAnimationPart(mDuration);
mAnimationPartFX = new ArrayList<>(); 
mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftForeArmFX,"rotate",0)); 
mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftForeArmFX,"yrotate",0)); 
mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftForeArmFX,"zrotate",107)); 
playAnimationPart(mDuration);
} 
} 
