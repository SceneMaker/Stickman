/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanfx.animation.headfx;

import de.dfki.stickman.animationlogic.AnimationContent;
import de.dfki.stickmanfx.StickmanFX;
import de.dfki.stickmanfx.animationlogic.AnimationContentFX;
import de.dfki.stickmanfx.animationlogic.AnimationFX;
import java.util.ArrayList;
import javafx.application.Platform;

/**
 *
 * @author Beka Aptsiauri
 *
 */
public class Muster extends AnimationFX 
{

   
	public Muster(StickmanFX sm, int duration, boolean block) 
        {
		super(sm, duration, block);
	}

	@Override
	public void playAnimation() {
            int rotationUnit = 10;
//            for(int i = 0; i<8; i++)
//            {
                mAnimationPartFX = new ArrayList<>();
                mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mHeadFX, "yrotate", 30));
                mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mBodyFX, "yrotate", 30));
                playAnimationPart(500);
                
                pauseAnimation(500);
                
                mAnimationPartFX = new ArrayList<>();
                mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mHeadFX, "yrotate", -30));
                mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mBodyFX, "yrotate", -30));
                playAnimationPart(500);
                
                
//            }
                 

	}
}
