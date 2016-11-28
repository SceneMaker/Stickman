package de.dfki.common.interfaces;

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
    CommonAnimation doAnimation(String name, int duration, boolean block);
    CommonAnimation doAnimation(String name, Object param, boolean block);
    CommonAnimation doAnimation(String name, int duration, Object param, boolean block);
}
