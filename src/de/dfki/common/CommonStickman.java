package de.dfki.common;

/**
 * Created by alvaro on 9/4/16.
 */
public interface CommonStickman {
    void setStickmanStageController(StageStickmanController s);

    void setShowName(boolean show);

    boolean isShowName();

    void endAnimationScheduler();
}
