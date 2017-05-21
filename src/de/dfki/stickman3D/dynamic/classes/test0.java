package de.dfki.stickman3D.dynamic.classes; 
import java.util.ArrayList;
import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.StickmanStageController;
import de.dfki.stickman3D.animationlogic.AnimationContent3D;
import de.dfki.stickman3D.animationlogic.Animation3D;public class test0 extends Animation3D{ 
public test0(){ 
mAnimType = ANIMTYPE.ON; 
} 
public test0(Stickman3D sm, int duration, boolean block) { 
super(sm, duration, block); 
} 
@Override 
public void playAnimation() { 
mAnimationPartFX = new ArrayList<>(); 
mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mHeadFX,"rotate",0)); 
mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mHeadFX,"yrotate",57)); 
mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mHeadFX,"zrotate",0)); 
playAnimationPart(mDuration);
mAnimationPartFX = new ArrayList<>(); 
mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mHeadFX,"rotate",0)); 
mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mHeadFX,"yrotate",-104)); 
mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mHeadFX,"zrotate",0)); 
playAnimationPart(mDuration);
mAnimationPartFX = new ArrayList<>(); 
mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mHeadFX,"rotate",0)); 
mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mHeadFX,"yrotate",112)); 
mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mHeadFX,"zrotate",0)); 
playAnimationPart(mDuration);
mAnimationPartFX = new ArrayList<>(); 
mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mHeadFX,"rotate",0)); 
mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mHeadFX,"yrotate",-119)); 
mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mHeadFX,"zrotate",0)); 
playAnimationPart(mDuration);
} 
} 
