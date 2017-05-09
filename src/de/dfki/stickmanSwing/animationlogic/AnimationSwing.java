/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanSwing.animationlogic;

import de.dfki.action.sequence.WordTimeMarkSequence;
import de.dfki.common.interfaces.Animation;
import de.dfki.stickmanSwing.StickmanSwing;
import de.dfki.util.ios.IOSIndentWriter;
import de.dfki.util.xml.XMLParseAction;
import de.dfki.util.xml.XMLParseError;
import de.dfki.util.xml.XMLParseable;
import de.dfki.util.xml.XMLWriteError;
import de.dfki.util.xml.XMLWriteable;
import java.util.ArrayList;
import java.util.concurrent.Semaphore;
import org.w3c.dom.Element;

/**
 *
 * @author Patrick Gebhard
 *
 */
public class AnimationSwing extends Thread implements XMLParseable, XMLWriteable, Animation {

    public enum ANIMTYPE {
        EmotionExpression, Gesture
    }
    public String mName = "";
    public ArrayList<AnimationContentSwing> mAnimationPart = new ArrayList<>();
    public Semaphore mAnimationPartStart = new Semaphore(0);
    public Semaphore mAnimationStart = new Semaphore(1);
    public AnimatorSwing mAnimator;
    public AnimationPause mAnimationPause;
    public StickmanSwing mStickman;
    public String mStickmanName;
    public boolean mBlocking = false;
    public int mDuration = -1;
    public String mID;
    public Object mParameter = "";

    public ANIMTYPE mAnimType = null;

    public AnimationSwing() {

    }

    public String getmID() {
        return mID;
    }

    public AnimationSwing(StickmanSwing sm, int duration, boolean block) {
        mName = getClass().getSimpleName();
        mStickman = sm;
        mStickmanName = mStickman.mName;
        setName(mStickmanName + "'s AnimationSwing " + mName);
        mID = mStickman.getID(); // default ID;
        mBlocking = block;
        mDuration = duration;
    }

    public void setParameter(Object p) {
        mParameter = p;
    }

    public void setID(String id) {
        mID = id;
    }

    public void setStickmanName(String stickmanName) {
        mStickmanName = stickmanName;
        //mStickman = StickmanStageSwing.getStickman(mReetiName);
        setName(mStickmanName + "'s AnimationSwing " + mName);
    }

    public void setAnimationName(String animationName) {
        mName = animationName;
    }

    public void setDuration(int duration) {
        mDuration = duration;
    }

    public void setBlocking(boolean blocking) {
        mBlocking = blocking;
    }

    public void waitForClearance() {
        //mStickman.mLogger.info("Introducing " + this.toString() + " to Animationcheduler");
        mStickman.mAnimationScheduler.introduce(this);
        //mStickman.mLogger.info("\tdone.");

        // block this animation for animation - AnimationSheduler will unblock 
        try {
            //mStickman.mLogger.info("Block - give AnimationSwing Scheduler control when to start the animation" + this.toString());
            mAnimationStart.acquire(1);
        } catch (InterruptedException ex) {
            mStickman.mLogger.severe(ex.getMessage());
        }

        // tell StickmanSwing this animation has been scheduled and a next one can come
        //mStickman.mLogger.info("Releasing launch for next animations");
        mStickman.mAnimationLaunchControl.release();
    }

    public void play() {
        // wait until AnimationScheduler says go!
        try {
            mAnimationStart.acquire(1);
        } catch (InterruptedException ex) {
            mStickman.mLogger.severe(ex.getMessage());
        }

        playAnimation();
    }

    public void playAnimation() {
        // place animation code here
    }

    public void playAnimationPart(int duration) {
        mAnimator = new AnimatorSwing(mStickman, this, mAnimationPart, duration);

        try {
            mAnimationPartStart.acquire();
        } catch (InterruptedException ex) {
            mStickman.mLogger.severe(ex.getMessage());
        }

    }

    public void pauseAnimation(int duration) {
        mAnimationPause = new AnimationPause(mStickman, this, duration);

        try {
            mAnimationPartStart.acquire();
        } catch (InterruptedException ex) {
            mStickman.mLogger.severe(ex.getMessage());
        }
    }

    public void finalizeAnimation() {
        //mStickman.mLogger.info(mStickman.mName + "'s AnimationSwing " + getClass().getSimpleName() + " with id " + mID + " has ended - notify Listeners!");
        // unblock AnimationScheduler if animation is a blocking animation
        if (mBlocking) {
            //mStickman.mLogger.info("unblocking AnimationScheduler");
            mStickman.mAnimationScheduler.proceed(this);
        } else {
            mStickman.mAnimationScheduler.removeAnimation(this);
        }
        // send event that AnimationSwing is ended

        // send event that AnimationSwing is ended - if there is a recipient
        if (mStickman.getStageController() != null) {
            // API or TCP-Interface
            if (!mStickman.getStageController().ismNetwork()) {
                mStickman.notifyListeners(mID);
            } else {
                mStickman.getStageController().sendAnimationUpdate("end", getmID());
            }
        }
    }

    @Override
    public void writeXML(IOSIndentWriter out) throws XMLWriteError {
        out.println("<StickmanAnimation stickmanname = \"" + mStickmanName + "\" name=\"" + mName + "\" id=\"" + mID + "\" duration=\"" + mDuration + "\" blocking=\"" + mBlocking + "\">").push();
        if (mParameter != null) {

            if (mParameter instanceof WordTimeMarkSequence) {
                ((WordTimeMarkSequence) mParameter).writeXML(out);
            }

            if (mParameter instanceof String) {
                out.println((String) mParameter);
            }
        }
        out.pop().println("</StickmanAnimation>");
    }

    @Override
    public void parseXML(final Element element) throws XMLParseError {

        mStickmanName = element.getAttribute("stickmanname");
        mName = element.getAttribute("name");
        mID = element.getAttribute("id");
        mDuration = Integer.parseInt(element.getAttribute("duration"));
        mBlocking = Boolean.parseBoolean(element.getAttribute("blocking"));

        // Process The Child Nodes
        XMLParseAction.processChildNodes(element, new XMLParseAction() {
            @Override
            public void run(final Element element) throws XMLParseError {

                // Get The Child Tag Name
                final String name = element.getTagName();

                if (name.equalsIgnoreCase("WordTimeMarkSequence")) {
                    mParameter = new WordTimeMarkSequence();

                    ((WordTimeMarkSequence) mParameter).parseXML(element);
                } else {
                    mParameter = (String) element.getTextContent();
                }
            }
        });
    }

    @Override
    public void run() {
        //mStickman.mLogger.info(mStickman.mName + "'s AnimationSwing " + getClass().getSimpleName() + " wait for clearance.");
        waitForClearance();

        //mStickman.mLogger.info(mStickman.mName + "'s AnimationSwing " + getClass().getSimpleName() + " play.");
        play();

        //mStickman.mLogger.info(mStickman.mName + "'s AnimationSwing " + getClass().getSimpleName() + " finalize.");
        finalizeAnimation();
    }

    @Override
    public String toString() {
        return mName + ", " + getName();
    }
}
