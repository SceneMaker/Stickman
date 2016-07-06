package de.dfki.stickman.animationlogic;

import de.dfki.stickman.Stickman;
import de.dfki.stickman.animation.environment.SimplexNoise;

/**
 *
 * @author Patrick Gebhard
 *
 */
public class UnconsciouslyAction extends Thread {
	private Stickman mStickman;	
	private SimplexNoise mSimplexNoise;  // generate perlin noise Array 2d
	private int count1 = 1;    // index of perlin noise Array
	private int count2 = 1;    // index of perlin noise Array
	private int count3 = 0;
	private int NoiseNumber;
	private int mSleepTime;
	private GESTURE mGesture;
	
	public static enum GESTURE {

		DEFAULT, TouchHead, CoverMouth
	};
		
	public UnconsciouslyAction(Stickman s, SimplexNoise noise, String g){
		mStickman = s;
		mSimplexNoise=noise;
		mSleepTime=10;
		GESTURE gesture = GESTURE.valueOf(g);
		mGesture = (gesture != null) ? gesture : GESTURE.DEFAULT;
	}

    @Override
    public void run() {
    	while(mStickman.mIdleRun){
    		count1++;
    		if(count1 == 200){ 
    			count1 = 0;
    			count2++;
    		}
    		if(count2 == 200)
    			count2 =1;
        
    		NoiseNumber = (int) (mSimplexNoise.getNoise(count2,count1)*100);
    		
    		if (NoiseNumber == 5){
    			count3++;
    			if(count3==100){
    				
    				switch (mGesture) {
    	    			case DEFAULT:
    	    				try {
    	                        sleep(mSleepTime, 0);
    	                 } catch (InterruptedException ex) {
    	                        mStickman.mLogger.severe(ex.getMessage());
    	                   }     
    	    			break;
    	    				
    	    			case CoverMouth:
    	    				mStickman.doAnimation("CoverMouth", 500, true);
    	    				count3=0;
    	    				break;
    	    				
    	    			case TouchHead:
    	    				mStickman.doAnimation("TouchHead", 500, true);
    	    				count3=0;
    	    				break;
    			}
    			
    		}
    		else
    			try {
                    sleep(mSleepTime, 0);
             } catch (InterruptedException ex) {
                    mStickman.mLogger.severe(ex.getMessage());
               }     		
    	}
    	else
    		try {
                 sleep(mSleepTime, 0);
            } catch (InterruptedException ex) {
            	mStickman.mLogger.severe(ex.getMessage());
            	}     		
        	
    	}
    }
}
