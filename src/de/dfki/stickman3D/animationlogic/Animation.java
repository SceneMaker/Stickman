/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.animationlogic;

import de.dfki.action.sequence.WordTimeMarkSequence;
import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.StickmanStage;
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
 * @modified Beka Aptsiauri
 *
 */
public class Animation extends Thread implements XMLParseable, XMLWriteable {
	public String mName = "";
	public ArrayList<AnimationContent> mAnimationPartFX = new ArrayList<>();
	public Semaphore mAnimationPartStart = new Semaphore(0);
	public Semaphore mAnimationStart = new Semaphore(1);
	public Animator mAnimatorFX;
	public AnimationPause mAnimationPauseFX;
	public Stickman3D mStickmanFX;
	public String mStickmanName;
	public boolean mBlocking = false;
	public int mDuration = -1;
	public String mID;
	public Object mParameter = "";

	public enum ANIMTYPE {
		ON, OFF
	}

	public ANIMTYPE mAnimType = null;

	public Animation() {
	}

	public Animation(Stickman3D sm, int duration, boolean block) {
		mName = getClass().getSimpleName();
		mStickmanFX = sm;
		mStickmanName = mStickmanFX.mName;
		setName(mStickmanName + "'s Animation " + mName);
		mID = mStickmanFX.getID(); // default ID;
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
		mStickmanFX = StickmanStage.getStickmanFX(mStickmanName);
		setName(mStickmanName + "'s Animation " + mName);
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
		mStickmanFX.mAnimationSchedulerFX.introduce(this);
		// block this animation for animation - AnimationSheduler will unblock
		try {
			mAnimationStart.acquire(1);
		} catch (InterruptedException ex) {
			mStickmanFX.mLogger.severe(ex.getMessage());
		}

		// tell Stickman this animation has been scheduled and a next one can
		// come
		mStickmanFX.mAnimationLaunchControl.release();
	}

	public void play() {
		// wait until AnimationScheduler says go!
		try {
			mAnimationStart.acquire(1);
		} catch (InterruptedException ex) {
			mStickmanFX.mLogger.severe(ex.getMessage());
		}

		playAnimation();
	}

	public void playAnimation() {
		// place animation code here
	}

	public void playAnimationPart(int duration) {
		mAnimatorFX = new Animator(mStickmanFX, this, mAnimationPartFX, duration);

		try {
			mAnimationPartStart.acquire();
		} catch (InterruptedException ex) {
			mStickmanFX.mLogger.severe(ex.getMessage());
		}

	}

	public void playAnimationPart(int duration, int step) {
		mAnimatorFX = new Animator(mStickmanFX, this, mAnimationPartFX, duration, step);

		try {
			mAnimationPartStart.acquire();
		} catch (InterruptedException ex) {
			mStickmanFX.mLogger.severe(ex.getMessage());
		}

	}

	public void pauseAnimation(int duration) {
		mAnimationPauseFX = new AnimationPause(mStickmanFX, this, duration);

		try {
			mAnimationPartStart.acquire();
		} catch (InterruptedException ex) {
			mStickmanFX.mLogger.severe(ex.getMessage());
		}
	}

	public void finalizeAnimation() {
		// unblock AnimationScheduler if animation is a blocking animation
		if (mBlocking) {
			mStickmanFX.mAnimationSchedulerFX.proceed(this);
		} else {
			mStickmanFX.mAnimationSchedulerFX.removeAnimation(this);
		}
		// send event that Animation is ended

		// API or TCP-Interface
		if (!StickmanStage.mUseNetwork) {
			mStickmanFX.notifyListeners(mID);
		} else {
			StickmanStage.sendAnimationUpdate("end", mID);
		}
	}

	@Override
	public void writeXML(IOSIndentWriter out) throws XMLWriteError {
		out.println("<StickmanAnimation stickmanname = \"" + mStickmanName + "\" name=\"" + mName + "\" id=\"" + mID
				+ "\" duration=\"" + mDuration + "\" blocking=\"" + mBlocking + "\">").push();
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
		waitForClearance();
		play();
		finalizeAnimation();
	}

	@Override
	public String toString() {
		return mName + ", " + getName();
	}
}
