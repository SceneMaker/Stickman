package de.dfki.common.agent;

import de.dfki.common.LogFormatter;
import de.dfki.common.animationlogic.Animation;
import de.dfki.common.animationlogic.AnimationListener;
import de.dfki.common.animationlogic.AnimationScheduler;
import de.dfki.common.animationlogic.IAnimation;
import de.dfki.common.enums.Gender;
import de.dfki.common.interfaces.StageRoom;
import de.dfki.common.part.Part;
import de.dfki.common.util.Preferences;
import javafx.geometry.*;
import javafx.geometry.Insets;
import javafx.scene.control.Control;
import javafx.scene.layout.Pane;

import java.awt.*;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Semaphore;
import java.util.logging.ConsoleHandler;
import java.util.logging.Logger;

/**
 * Created by EmpaT on 27.07.2017.
 */
public abstract class Agent extends Pane implements IAgent
{
    public static Dimension mDefaultSize = new Dimension(300, 800);
    public static Dimension mSize = new Dimension(mDefaultSize);
    public final List<AnimationListener> mAnimationListeners = new CopyOnWriteArrayList<AnimationListener>();
    public final Logger mLogger = Logger.getAnonymousLogger();
    public Gender.TYPE mType = Gender.TYPE.FEMALE;
    public String mName = "Agent";
    public float mScale = 1.0f;
    public Semaphore mAnimationLaunchControl = new Semaphore(1);
    public AnimationScheduler animationScheduler;
    public StageRoom stageRoom;
    public long mID = 0;
    public boolean mShowName = true;

    @Override
    public String getName()
    {
        return this.mName;
    }

    @Override
    public void setName(String name)
    {
        this.mName = name;
    }

    public void init()
    {
        this.setMaxHeight(Preferences.MALE_HEIGHT);
        this.setMinHeight(Preferences.MALE_HEIGHT);
        this.setPrefWidth(Control.USE_COMPUTED_SIZE);

        ConsoleHandler ch = new ConsoleHandler();
        ch.setFormatter(new LogFormatter());

        mLogger.addHandler(ch);
        mLogger.setUseParentHandlers(false);
    }

    public String getID()
    {
        return (new StringBuffer()).append(mName).append(" AnimationSwing ").append(mID++).toString();
    }

    public void addListener(AnimationListener al)
    {
        mAnimationListeners.add(al);
    }

    public void removeListener(AnimationListener al)
    {
        synchronized (mAnimationListeners)
        {
            if (mAnimationListeners.contains(al))
            {
                mAnimationListeners.remove(al);
            }
        }
    }

    public void notifyListeners(String animationId)
    {
        synchronized (mAnimationListeners)
        {
            mAnimationListeners.stream().forEach((al) ->
            {
                al.update(animationId);
            });
        }
    }

    public void playAnimation(Animation animation)
    {
        try
        {
            mAnimationLaunchControl.acquire();
            animation.start();
        } catch (InterruptedException ex)
        {
            mLogger.severe(ex.getMessage());
        }
    }

    public abstract Part getSpeechBubble();

    public abstract void setSpeechBubble(Part speechBubble);

    @Override
    public StageRoom getStageRoom()
    {
        return stageRoom;
    }

    @Override
    public void setStageRoom(StageRoom s)
    {
        stageRoom = s;
    }

    @Override
    public boolean isShowName()
    {
        return mShowName;
    }

    @Override
    public void setShowName(boolean show)
    {
        mShowName = show;
    }

    @Override
    public void endAnimationScheduler()
    {
        animationScheduler.end();
    }

    @Override
    public Gender.TYPE getType()
    {
        return mType;
    }

    public IAnimation doAnimation(String name, int duration, boolean block)
    {
        return doAnimation(name, duration, "", block);
    }

    public IAnimation doAnimation(String name, Object param, boolean block)
    {
        return doAnimation(name, -1, param, block);
    }

    public IAnimation doAnimation(String name, boolean block)
    {
        return doAnimation(name, -1, "", block);
    }
}
