package de.dfki.stickman.animation.environment;

import de.dfki.stickman.Stickman;

/**
 *
 * @author Robbie
 *
 */
public class StartIdle{
	public StartIdle(Stickman sm) {
		mStickman = sm;
	}

	Stickman mStickman;
	
	public void startIdleBehavior() {
		
	    if(!mStickman.mIdleBehavior.isAlive()){
	    	mStickman.mIdleRun=true;
	    	mStickman.mIdleBehavior = new IdleBehavior(mStickman, mStickman.simplexNoise);
	    	mStickman.mIdleBehavior.start();
	    }
	}
}
