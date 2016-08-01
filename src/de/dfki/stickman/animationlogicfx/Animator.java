package de.dfki.stickman.animationlogicfx;

import de.dfki.action.sequence.Entry;
import de.dfki.action.sequence.WordTimeMarkSequence;
import de.dfki.stickmanfx.*;
import de.dfki.stickman.bodyfx.BodyPartFX;
import de.dfki.stickman.util.TimingInfo;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.concurrent.Semaphore;

/**
 *
 * @author Patrick Gebhard
 *
 */
public class Animator {

    public static int sMAX_ANIM_STEPS = 20;
    public int mCurrentStep = sMAX_ANIM_STEPS;
    private final StickmanFX mStickmanFX;
    private final Animation mAnimation;
    private ArrayList<AnimationContent> mAnimationComponents = new ArrayList<>();
    private String mDescription = "";
    public WordTimeMarkSequence mWTS;
    private int mRenderPauseDuration = 0;
    public Semaphore mRenderingPause = new Semaphore(0);

    //private long mPreparationTime = 0;
    public Animator(StickmanFX sm, Animation a, ArrayList<AnimationContent> animComps) {
        mStickmanFX = sm;
        mAnimation = a;
        mAnimationComponents = animComps;
        mDescription = mAnimation.getClass().getSimpleName() + " (" + mAnimation.mID + "), " + mAnimation.toString();
        mRenderPauseDuration = 40; // 40 milliseconds equals 25fps - resulting that by default an animation takes 500ms

        render();
    }

    public Animator(StickmanFX sm, Animation a, ArrayList<AnimationContent> animComps, int duration) {
        //mPreparationTime = System.currentTimeMillis();
        mStickmanFX = sm;
        mAnimation = a;
        mAnimationComponents = animComps;
        mDescription = mAnimation.getClass().getSimpleName() + " (" + mAnimation.mID + "), " + mAnimation.toString();

        mRenderPauseDuration = new Float(duration / sMAX_ANIM_STEPS).intValue();
        mRenderPauseDuration = (mRenderPauseDuration < 1) ? 1 : mRenderPauseDuration; // minimum delay is 1 millisecond
		
        render();
    }

    public Animator(StickmanFX sm, Animation a, ArrayList<AnimationContent> animComps, WordTimeMarkSequence wts) {
        //mPreparationTime = System.currentTimeMillis();
        mStickmanFX = sm;
        mAnimation = a;
        mAnimationComponents = animComps;
        mWTS = wts;
        mDescription = mAnimation.getClass().getSimpleName() + " (" + mAnimation.mID + "), " + mAnimation.toString();

        renderEventAnimation();
    }

    private void renderEventAnimation() {
        for (ArrayList<Entry> cluster : mWTS.getClusters()) {
            //mStickmanFX.mLogger.info("Cluster is a " + WordTimeMarkSequence.getClusterType(cluster).name());
            if (WordTimeMarkSequence.getClusterType(cluster) == Entry.TYPE.WORD) {
                String text = "";

                for (Entry e : cluster) {
                    //mStickmanFX.mLogger.info("entry " + e.mContent);
                    text += e.mContent + " ";
                }
                text = text.trim();

                String currentlySpokenText = "";
                currentlySpokenText = text.replace("oe", "ö").replace("ae", "ä").replace("ue", "ü").replace("Oe", "Ö").replace("Ae", "Ä").replace("Ue", "Ü").replace("ss", "ß").replace("\n", " ").replace("   ", " ").replace("  ", " ");

                String allText = "";
                allText = mWTS.getText().replace("oe", "ö").replace("ae", "ä").replace("ue", "ü").replace("Oe", "Ö").replace("Ae", "Ä").replace("Ue", "Ü").replace("ss", "ß").replace("\n", " ").replace("   ", " ").replace("  ", " ");

                ///////////////////////////////////////////////////////////////////
                //*******************************************************/////////
                //////////////////////Pay attenetion
                
//                mStickmanFX.mSpeechBubble.mText = allText;
//                mStickmanFX.mSpeechBubble.mCurrentlySpokenText = currentlySpokenText;

                //clusterTiming.add(TimingInfo.spokenStringDuration(text));
                //mStickmanFX.mLogger.info("utterance " + text);
                // do the rendering ...
                int duration = TimingInfo.spokenStringDuration(text);

                mRenderPauseDuration = new Float(duration / sMAX_ANIM_STEPS).intValue();
                mRenderPauseDuration = (mRenderPauseDuration < 1) ? 1 : mRenderPauseDuration; // minimum delay is 1 millisecond

                //mStickmanFX.mLogger.info("Animator - animation " + mAnimation + " render pause " + mRenderPauseDuration + " duration " + duration);
                render();
            }

            if (WordTimeMarkSequence.getClusterType(cluster) == Entry.TYPE.TIMEMARK) {
                // here we have to spread the word that a specific timemark has been reached
                // the interface is the runActionAtTimemark method in the EventActionPlayer
                for (Entry e : cluster) {
                    // we have 2 options!
                    // 1) API Call
                    // 2) send to Player

                    StickmanStageFX.sendTimeMarkInformation(e.mContent);

                }
            }
        }
    }

    private void render() {
        mCurrentStep = sMAX_ANIM_STEPS;
        while (mCurrentStep > 0) {
            //for (mCurrentStep = sMAX_ANIM_STEPS; mCurrentStep > 0; mCurrentStep--) {
            // DEBUG mStickmanFX.mLogger.info("currentstep " + mCurrentStep + " max steps " + sMAX_ANIM_STEPS);
            if (mCurrentStep == sMAX_ANIM_STEPS) {
                //mStickmanFX.mLogger.info("\t\t\tpreparing " + mDescription);
                // renderEventAnimatione animation components
                mAnimationComponents.stream().forEach((comp) -> {
                    BodyPartFX bodypartfx = comp.mBodyPartfx;
                    String action = comp.mAction;
                    int param = comp.mParam;
                    String paramString = comp.mParamString;
                    
                    if (action.equalsIgnoreCase("rotate")) {
                        bodypartfx.setRotation(param);
                    }
                    if (action.equalsIgnoreCase("tilt")) {
                        bodypartfx.setTilt(param);
                    }
                    if (action.equalsIgnoreCase("translate")) {
                        bodypartfx.setTranslation(param);
                    }
                    if (action.equalsIgnoreCase("shape")) {
                        bodypartfx.setShape(paramString);
                    }
                });
            }

            if (mCurrentStep > 1) {
                for (AnimationContent ba : mAnimationComponents) {
                    BodyPartFX bodypartfx = ba.mBodyPartfx;
                    String action = ba.mAction;

                    if (action.equalsIgnoreCase("rotate")) {
                        bodypartfx.calculateRotation(mCurrentStep);
                    }

                    if (action.equalsIgnoreCase("tilt")) {
                        bodypartfx.calculateRotation(mCurrentStep);
                    }

                    if (action.equalsIgnoreCase("translate")) {
                        bodypartfx.calculateTranslation(mCurrentStep);
                    }

                    if (action.equalsIgnoreCase("shape")) {
                        bodypartfx.calculateShape(mCurrentStep);
                    }
                }

                mStickmanFX.update();
                
                new WaitThread(mRenderPauseDuration).start();
                // block this until WaitThread will unblock 
                try {
                    mRenderingPause.acquire(1);
                } catch (InterruptedException ex) {
                    mStickmanFX.mLogger.severe(ex.getMessage());
                }
            }

            if (mCurrentStep == 1) {
                for (AnimationContent ba : mAnimationComponents) {
                    String action = ba.mAction;
                    BodyPartFX bodypartfx = ba.mBodyPartfx;

                    if (action.equalsIgnoreCase("rotate")) {
                        bodypartfx.resetRotation();
                    }

                    if (action.equalsIgnoreCase("tilt")) {
                        bodypartfx.resetRotation();
                    }

                    if (action.equalsIgnoreCase("translate")) {
                        bodypartfx.resetTranslation();
                    }
                }

                mStickmanFX.update();

                new WaitThread(mRenderPauseDuration).start();
                // block this until WaitThread will unblock 
                try {
                    mRenderingPause.acquire(1);
                } catch (InterruptedException ex) {
                    mStickmanFX.mLogger.severe(ex.getMessage());
                }

                mAnimation.mAnimationPartStart.release();
                return;
            }

            mCurrentStep -= 1;
        }
    }

    private class WaitThread extends Thread {

        int mSleepTime = 0;

        public WaitThread(int time) {
            mSleepTime = time;
        }

        @Override
        public void run() {
            // directly go to sleep
            try {
                sleep(mSleepTime, 0);
            } catch (InterruptedException ex) {
                mStickmanFX.mLogger.severe(ex.getMessage());
            }
            // release sempahore
            mRenderingPause.release();
        }
    }
}
