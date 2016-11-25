package de.dfki.stickman3D.animationlogic;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

import de.dfki.stickman3D.Stickman3D;

/**
 *
 * @author Beka Aptsiauri
 *
 */
public class EventAnimationScheduler extends Thread {
	Stickman3D mStickmanFX;
	boolean mRunning = true;
	public LinkedBlockingQueue<Animation> mAnimationQueue = new LinkedBlockingQueue<>();
	public Semaphore mTheBlockOfHell = new Semaphore(1);

	public EventAnimationScheduler(Stickman3D s) {
		setName(s.mName + "'s Event AnimationScheduler");
		mStickmanFX = s;
	}

	public void introduce(Animation a) {
		try {
			mStickmanFX.mLogger.info("Animation " + a + " added to event animation scheduler");

			mAnimationQueue.put(a);
		} catch (InterruptedException ex) {
			mStickmanFX.mLogger.severe(ex.getMessage());
		}
	}

	public void proceed(Animation a) {
		removeAnimation(a);
		mTheBlockOfHell.release();
	}

	public void removeAnimation(Animation a) {
		mAnimationQueue.remove(a);
	}

	public synchronized void end() {
		mRunning = false;

		// throw in a last animationFX that unblocks the scheduler letting him
		// end
		try {
			mAnimationQueue.put(new Animation(mStickmanFX, 1, false) {
			});
		} catch (InterruptedException ex) {
			Logger.getLogger(EventAnimationScheduler.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	@Override
	public void run() {
		while (mRunning) {
			try {
				// serialize all animations here ...
				mTheBlockOfHell.acquire(1);

				// get the next animationFX in the animationFX queue
				Animation animationFX = mAnimationQueue.take();

				// tell the animationFX to render itself
				animationFX.mAnimationStart.release();

				// unblock the scheduler if animationFX is not blocking
				if (!animationFX.mBlocking) {
					mTheBlockOfHell.release();
					removeAnimation(animationFX);
				}
			} catch (InterruptedException ex) {
				mStickmanFX.mLogger.severe(ex.getMessage());
			}
		}
	}
}
