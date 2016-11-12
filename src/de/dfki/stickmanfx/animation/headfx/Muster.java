/*
100 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanfx.animation.headfx;

import java.util.ArrayList;

import de.dfki.stickmanfx.StickmanFX;
import de.dfki.stickmanfx.animationlogic.AnimationContentFX;
import de.dfki.stickmanfx.animationlogic.AnimationFX;
import javafx.scene.Group;

/**
 *
 * @author Beka Aptsiauri
 *
 */
public class Muster extends AnimationFX 
{

	private static boolean isInteriorElemtnLoaded = false;
	Group table;
	Group laptop;
   
	public Muster(StickmanFX sm, int duration, boolean block) 
        {
		super(sm, duration, block);
	}

	@Override
	public void playAnimation() 
	{
		//Lade die InteriorElemente nur einmal
//		if(!isInteriorElemtnLoaded)
//		{
//			isInteriorElemtnLoaded = true;
//			table = Interior.createTable();
//            laptop = Interior.createLaptop();
//            
//            table.setTranslateY(461);
//    		table.setTranslateZ(-300);
//    		laptop.setTranslateZ(-280);
//    		laptop.setTranslateY(286);
//    		laptop.setTranslateX(-20);
//    		laptop.setRotationAxis(Rotate.Y_AXIS);
//    		laptop.setRotate(30);
//    		Platform.runLater(() -> 
//    		{
//    			mStickmanFX.getChildren().addAll(table, laptop);
//    		});
//		}
//            
//    		
//            
//            mAnimationPartFX = new ArrayList<>();
//            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mUpperBody, "ytranslate", 50));
//            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mDownBody, "ytranslate", 50));
//            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mNeckFX, "ytranslate", 50));
//            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mHeadFX, "ytranslate", 50));
//            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftUpperLegFX, "rotate", -80));
//            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftForeLegFX, "rotate", 90));
//            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightUpperLegFX, "rotate", -80));
//            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightForeLegFX, "rotate", 90));
//            
//            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftUpperArmFX, "rotate", 45));
//            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftForeArmFX, "rotate", -120));
//            playAnimationPart(500);
//            
//            mAnimationPartFX = new ArrayList<>();
//            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftUpperArmFX, "rotate", -45));
//            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftForeArmFX, "rotate", 30));
//            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mUpperBody, "rotate", 10));
//            playAnimationPart(500);
//            
//            
//            pauseAnimation(1000);
//            
//            mAnimationPartFX = new ArrayList<>();
//            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mUpperBody, "ytranslate", -50));
//            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mDownBody, "ytranslate", -50));
//            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mNeckFX, "ytranslate", -50));
//            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mHeadFX, "ytranslate", -50));
//            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftUpperLegFX, "rotate", 80));
//            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftForeLegFX, "rotate", -90));
//            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightUpperLegFX, "rotate", 80));
//            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightForeLegFX, "rotate", -90));
//            
//            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftUpperArmFX, "rotate", -45));
//            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftForeArmFX, "rotate", 120));
//            playAnimationPart(500);
//            
//            mAnimationPartFX = new ArrayList<>();
//            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftUpperArmFX, "rotate", 45));
//            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftForeArmFX, "rotate", -30));
//            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mUpperBody, "rotate", -10));
//            playAnimationPart(500);
		mAnimationPartFX = new ArrayList<>();
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mUpperBodyAndHand, "ytranslate", 20));
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mDownBody, "ytranslate", 20));
      playAnimationPart(1000);
      pauseAnimation(1000);
		mAnimationPartFX = new ArrayList<>();
      mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mUpperBodyAndHand, "rotate", 90));
      playAnimationPart(3000);
      
      mAnimationPartFX = new ArrayList<>();
      mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mUpperBodyAndHand, "rotate", -90));
      playAnimationPart(3000);
      pauseAnimation(1000);
      mAnimationPartFX = new ArrayList<>();
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mUpperBodyAndHand, "ytranslate", -20));
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mDownBody, "ytranslate", -20));
    playAnimationPart(1000);
            

	}
}
