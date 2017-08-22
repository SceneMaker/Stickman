package de.dfki.common.animationlogic;

import de.dfki.common.agent.Agent;
import de.dfki.common.agent.IAgent;
import de.dfki.util.ios.IOSIndentWriter;
import de.dfki.util.xml.XMLParseError;
import de.dfki.util.xml.XMLParseable;
import de.dfki.util.xml.XMLWriteError;
import de.dfki.util.xml.XMLWriteable;
import org.w3c.dom.Element;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.Semaphore;

/**
 * Created by EmpaT on 30.07.2017.
 */
public abstract class Animation extends Thread implements XMLParseable, XMLWriteable, IAnimation
{
    public Agent agent;
    public Animator animator;
    public AnimationPause animationPause;
    public String mName = "";
    public String mAgentName;
    public boolean mBlocking = false;
    public int mDuration = -1;
    public int actionDuration = -1;
    public String mID;
    public Object mParameter = "";
    public ArrayList<AnimationContent> mAnimationPart = new ArrayList<>();
    public Semaphore mAnimationPartStart = new Semaphore(0);
    public Semaphore mAnimationStart = new Semaphore(1);
    public ANIMTYPE mAnimType = null;
    protected HashMap<String, String> extraParams = new HashMap<>();

    public Animation()
    {
        mAnimType = null;
    }

    public Animation(IAgent iAgent, int duration, boolean block)
    {
        mName = getClass().getSimpleName();
        agent = (Agent) iAgent;
        mAgentName = agent.mName;
        setName(mAgentName + "'s AnimationSwing " + mName);
        mID = agent.getID(); // default ID;
        mBlocking = block;
        mDuration = duration;
    }

    @Override
    public void setParameter(Object p)
    {
        mParameter = p;
    }

    @Override
    public String getID()
    {
        return mID;
    }

    public void setID(String id)
    {
        mID = id;
    }

    public void setAgentName(String stickmanName)
    {
        mAgentName = stickmanName;
        setName(mAgentName + "'s AnimationSwing " + mName);
    }

    public void setAnimationName(String animationName)
    {
        mName = animationName;
    }

    public void setDuration(int duration)
    {
        mDuration = duration;
    }

    public void setBlocking(boolean blocking)
    {
        mBlocking = blocking;
    }

    public void waitForClearance()
    {
        agent.animationScheduler.introduce(this);
        // block this animation for animation - AnimationSheduler will unblock
        try
        {
            mAnimationStart.acquire(1);
        } catch (InterruptedException ex)
        {
            agent.mLogger.severe(ex.getMessage());
        }

        // tell StickmanSwing this animation has been scheduled and a next one can come
        agent.mAnimationLaunchControl.release();
    }

    public void play()
    {
        // wait until AnimationScheduler says go!
        try
        {
            mAnimationStart.acquire(1);
        } catch (InterruptedException ex)
        {
            agent.mLogger.severe(ex.getMessage());
        }

        playAnimation();
    }

    public void playAnimation()
    {
        // place animation code here
    }

    public void playAnimationPart(int duration)
    {

    }

    public void pauseAnimation(int duration)
    {
        animationPause = new AnimationPause(agent, this, duration);

        try
        {
            mAnimationPartStart.acquire();
        } catch (InterruptedException ex)
        {
            agent.mLogger.severe(ex.getMessage());
        }
    }

    public void finalizeAnimation()
    {
        // unblock AnimationScheduler if animation is a blocking animation
        if (mBlocking)
        {
            agent.animationScheduler.proceed(this);
        } else
        {
            agent.animationScheduler.removeAnimation(this);
        }
        // send event that AnimationReeti is ended

        // API or TCP-Interface
        if (!agent.getStageRoom().ismNetwork())
        {
            agent.notifyListeners(getID());
        } else
        {
            agent.getStageRoom().sendAnimationUpdate("end", getID());
        }
    }

    @Override
    public void writeXML(IOSIndentWriter writer) throws XMLWriteError
    {

    }

    @Override
    public void parseXML(Element element) throws XMLParseError
    {

    }

    public enum ANIMTYPE
    {
        ON, OFF, EmotionExpression, Gesture
    }
}
