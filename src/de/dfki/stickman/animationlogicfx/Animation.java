/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman.animationlogicfx;

import de.dfki.action.sequence.WordTimeMarkSequence;
import de.dfki.stickmanfx.*;
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
public class Animation extends Thread implements XMLParseable, XMLWriteable {

	public enum ANIMTYPE { EmotionExpression, Gesture}	
	public String mName = "";
	public ArrayList<AnimationContent> mAnimationPart = new ArrayList<>();
	public Semaphore mAnimationPartStart = new Semaphore(0);
	public Semaphore mAnimationStart = new Semaphore(1);
	public Animator mAnimator;
	public AnimationPause mAnimationPause;
	public StickmanFX mStickmanFX;
	public String mStickmanFXName;
	public boolean mBlocking = false;
	public int mDuration = -1;
	public String mID;
	public Object mParameter = "";
	
	public ANIMTYPE mAnimType = null;
	
	public Animation() {
		
	}


	public Animation(StickmanFX sm, int duration, boolean block) {
		mName = getClass().getSimpleName();
		mStickmanFX = sm;
		mStickmanFXName = mStickmanFX.mName;
		setName(mStickmanFXName + "'s Animation " + mName);
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

	public void setStickmanFXName(String StickmanFXName) {
		mStickmanFXName = StickmanFXName;
		mStickmanFX = StickmanStageFX.getStickmanFX(mStickmanFXName);
		setName(mStickmanFXName + "'s Animation " + mName);
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
		//mStickmanFX.mLogger.info("Introducing " + this.toString() + " to Animationcheduler");
		mStickmanFX.mAnimationScheduler.introduce(this);
		//mStickmanFX.mLogger.info("\tdone.");

		// block this animation for animation - AnimationSheduler will unblock 
		try {
			//mStickmanFX.mLogger.info("Block - give Animation Scheduler control when to start the animation" + this.toString());
			mAnimationStart.acquire(1);
		} catch (InterruptedException ex) {
			mStickmanFX.mLogger.severe(ex.getMessage());
		}

		// tell StickmanFX this animation has been scheduled and a next one can come
		//mStickmanFX.mLogger.info("Releasing launch for next animations");
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
		mAnimator = new Animator(mStickmanFX, this, mAnimationPart, duration);
//		System.out.println("test1");

		try {
			mAnimationPartStart.acquire();
		} catch (InterruptedException ex) {
			mStickmanFX.mLogger.severe(ex.getMessage());
		}

	}

	public void pauseAnimation(int duration) {
		mAnimationPause = new AnimationPause(mStickmanFX, this, duration);

		try {
			mAnimationPartStart.acquire();
		} catch (InterruptedException ex) {
			mStickmanFX.mLogger.severe(ex.getMessage());
		}
	}

	public void finalizeAnimation() {
		//mStickmanFX.mLogger.info(mStickmanFX.mName + "'s Animation " + getClass().getSimpleName() + " with id " + mID + " has ended - notify Listeners!");
		// unblock AnimationScheduler if animation is a blocking animation
		if (mBlocking) {
			//mStickmanFX.mLogger.info("unblocking AnimationScheduler");
			mStickmanFX.mAnimationScheduler.proceed(this);
		} else {
			mStickmanFX.mAnimationScheduler.removeAnimation(this);
		}
		// send event that Animation is ended

		// API or TCP-Interface
		if (!StickmanStageFX.mUseNetwork) {
			mStickmanFX.notifyListeners(mID);
		} else {
			StickmanStageFX.sendAnimationUpdate("end", mID);
		}
	}

	@Override
	public void writeXML(IOSIndentWriter out) throws XMLWriteError {
		out.println("<StickmanFXAnimation StickmanFXname = \"" + mStickmanFXName + "\" name=\"" + mName + "\" id=\"" + mID + "\" duration=\"" + mDuration + "\" blocking=\"" + mBlocking + "\">").push();
		if (mParameter != null) {

			if (mParameter instanceof WordTimeMarkSequence) {
				((WordTimeMarkSequence) mParameter).writeXML(out);
			}

			if (mParameter instanceof String) {
				out.println((String) mParameter);
			}
		}
		out.pop().println("</StickmanFXAnimation>");
	}

	@Override
	public void parseXML(final Element element) throws XMLParseError {

		mStickmanFXName = element.getAttribute("StickmanFXname");
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
		//mStickmanFX.mLogger.info(mStickmanFX.mName + "'s Animation " + getClass().getSimpleName() + " wait for clearance.");
		waitForClearance();

		//mStickmanFX.mLogger.info(mStickmanFX.mName + "'s Animation " + getClass().getSimpleName() + " play.");
		play();

		//mStickmanFX.mLogger.info(mStickmanFX.mName + "'s Animation " + getClass().getSimpleName() + " finalize.");
		finalizeAnimation();
	}

	@Override
	public String toString() {
		return mName + ", " + getName();
	}
}
