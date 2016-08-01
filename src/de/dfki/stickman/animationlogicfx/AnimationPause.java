package de.dfki.stickman.animationlogicfx;

import de.dfki.stickman.Stickman;
import de.dfki.stickmanfx.StickmanFX;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Patrick Gebhard
 *
 */
public class AnimationPause  {

	private final StickmanFX mStickmanFX;
	private final Animation mAnimation;
	public Semaphore mPauseEnd = new Semaphore(0);
	//private long mPreparationTime = 0;

	public AnimationPause(StickmanFX sm, Animation a, int duration) {
		mStickmanFX = sm;
		mAnimation = a;

		new WaitThread(duration).start();

		// block this until WaitThread will unblock 
		try {
			mPauseEnd.acquire(1);
		} catch (InterruptedException ex) {
			mStickmanFX.mLogger.severe(ex.getMessage());
		}

		// tell animation to proceed
		mAnimation.mAnimationPartStart.release();
	}

	private class WaitThread extends Thread {

		int mSleepTime = 0;

		public WaitThread(int time) {
			mSleepTime = time;
		}

		@Override
		public void run() {
			// directly go to sleep
			try {
				sleep(mSleepTime);
			} catch (InterruptedException ex) {
				mStickmanFX.mLogger.severe(ex.getMessage());
			}
			// release sempahore
			mPauseEnd.release();
		}
	}
}
