package de.dfki.common.agent;

import de.dfki.action.sequence.WordTimeMarkSequence;
import de.dfki.common.animationlogic.IAnimation;
import de.dfki.common.enums.Gender;
import de.dfki.common.interfaces.StageRoom;

/**
 * Created by alvaro on 9/4/16.
 */
public interface IAgent
{
    StageRoom getStageRoom();

    void setStageRoom(StageRoom s);

    boolean isShowName();

    void setShowName(boolean show);

    void endAnimationScheduler();

    Gender.TYPE getType();

    String getName();

    void setName(String name);

    IAnimation doAnimation(String name, int duration, boolean block);

    IAnimation doAnimation(String name, int frequent, int actionDuration, boolean block);

    IAnimation doAnimation(String name, Object param, boolean block);

    IAnimation doAnimation(String name, int duration, Object param, boolean block);

    IAnimation doEventFeedbackAnimation(String name, int duration, WordTimeMarkSequence wts, boolean block);
}
