package de.dfki.stickman.animation.environment;

import de.dfki.stickman.Stickman;

/**
 *
 * @author Robbie
 *
 */
public class StopIdle {

    public StopIdle(Stickman sm) {
        mStickman = sm;
    }

    Stickman mStickman;

    public void stopIdleBehavior() {

        mStickman.mIdleRun = false;
        while (mStickman.mIdleBehavior.isAlive());

    }
}
