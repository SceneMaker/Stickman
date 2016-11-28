package de.dfki.common.interfaces;

import de.dfki.stickmanSwing.StickmanSwing;

/**
 * Created by alvaro on 9/4/16.
 */
public interface Stickman {
    StageRoom getStickmanStageController();

    void setStickmanStageController(StageRoom s);

    void setShowName(boolean show);

    boolean isShowName();

    void endAnimationScheduler();
    StickmanSwing.TYPE getType();
    Animation doAnimation(String name, int duration, boolean block);
    Animation doAnimation(String name, Object param, boolean block);
    Animation doAnimation(String name, int duration, Object param, boolean block);
}
