package de.dfki.common;

import de.dfki.stickman.Stickman;

/**
 * Created by alvaro on 9/4/16.
 */
public interface CommonStickman {
    StageStickmanController getStickmanStageController();

    void setStickmanStageController(StageStickmanController s);

    void setShowName(boolean show);

    boolean isShowName();

    void endAnimationScheduler();
    Stickman.TYPE getType();
}
