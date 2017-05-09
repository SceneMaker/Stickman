package de.dfki.stickmanSwing.animationlogic;

import de.dfki.action.sequence.Entry;
import de.dfki.action.sequence.WordTimeMarkSequence;
import de.dfki.stickmanSwing.StickmanSwing;
import de.dfki.stickmanSwing.body.BodyPart;
import de.dfki.stickmanSwing.util.TimingInfo;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.concurrent.Semaphore;

/**
 *
 * @author Patrick Gebhard
 *
 */
public class AnimatorSwing {

    public static int sMAX_ANIM_STEPS = 20;
    public int mCurrentStep = sMAX_ANIM_STEPS;
    private final StickmanSwing mStickman;
    private final AnimationSwing mAnimation;
    private ArrayList<AnimationContentSwing> mAnimationComponents = new ArrayList<>();
    private String mDescription = "";
    public WordTimeMarkSequence mWTS;
    private int mRenderPauseDuration = 0;
    public Semaphore mRenderingPause = new Semaphore(0);

    //private long mPreparationTime = 0;
    public AnimatorSwing(StickmanSwing sm, AnimationSwing a, ArrayList<AnimationContentSwing> animComps) {
        mStickman = sm;
        mAnimation = a;
        mAnimationComponents = animComps;
        mDescription = mAnimation.getClass().getSimpleName() + " (" + mAnimation.mID + "), " + mAnimation.toString();
        mRenderPauseDuration = 40; // 40 milliseconds equals 25fps - resulting that by default an animation takes 500ms

        render();
    }

    public AnimatorSwing(StickmanSwing sm, AnimationSwing a, ArrayList<AnimationContentSwing> animComps, int duration) {
        //mPreparationTime = System.currentTimeMillis();
        mStickman = sm;
        mAnimation = a;
        mAnimationComponents = animComps;
        mDescription = mAnimation.getClass().getSimpleName() + " (" + mAnimation.mID + "), " + mAnimation.toString();

        mRenderPauseDuration = new Float(duration / sMAX_ANIM_STEPS).intValue();
        mRenderPauseDuration = (mRenderPauseDuration < 1) ? 1 : mRenderPauseDuration; // minimum delay is 1 millisecond
        render();
    }

    public AnimatorSwing(StickmanSwing sm, AnimationSwing a, ArrayList<AnimationContentSwing> animComps, WordTimeMarkSequence wts) {
        //mPreparationTime = System.currentTimeMillis();
        mStickman = sm;
        mAnimation = a;
        mAnimationComponents = animComps;
        mWTS = wts;
        mDescription = mAnimation.getClass().getSimpleName() + " (" + mAnimation.mID + "), " + mAnimation.toString();

        renderEventAnimation();
    }

    private void renderEventAnimation() {
        for (ArrayList<Entry> cluster : mWTS.getClusters()) {
            //mStickman.mLogger.info("Cluster is a " + WordTimeMarkSequence.getClusterType(cluster).name());
            if (WordTimeMarkSequence.getClusterType(cluster) == Entry.TYPE.WORD) {
                String text = "";

                for (Entry e : cluster) {
                    //mStickman.mLogger.info("entry " + e.mContent);
                    text += e.mContent + " ";
                }
                text = text.trim();

                String currentlySpokenText = "";
                currentlySpokenText = text.replace("oe", "ö").replace("ae", "ä").replace("ue", "ü").replace("Oe", "Ö").replace("Ae", "Ä").replace("Ue", "Ü").replace("ss", "ß").replace("\n", " ").replace("   ", " ").replace("  ", " ");

                String allText = "";
                allText = mWTS.getText().replace("oe", "ö").replace("ae", "ä").replace("ue", "ü").replace("Oe", "Ö").replace("Ae", "Ä").replace("Ue", "Ü").replace("ss", "ß").replace("\n", " ").replace("   ", " ").replace("  ", " ");

                mStickman.mSpeechBubble.mText = allText;
                mStickman.mSpeechBubble.mCurrentlySpokenText = currentlySpokenText;

                //clusterTiming.add(TimingInfo.spokenStringDuration(text));
                //mStickman.mLogger.info("utterance " + text);
                // do the rendering ...
                int duration = TimingInfo.spokenStringDuration(text);

                mRenderPauseDuration = new Float(duration / sMAX_ANIM_STEPS).intValue();
                mRenderPauseDuration = (mRenderPauseDuration < 1) ? 1 : mRenderPauseDuration; // minimum delay is 1 millisecond

                //mStickman.mLogger.info("AnimatorSwing - animation " + mAnimation + " render pause " + mRenderPauseDuration + " duration " + duration);
                render();
            }

            if (WordTimeMarkSequence.getClusterType(cluster) == Entry.TYPE.TIMEMARK) {
                // here we have to spread the word that a specific timemark has been reached
                // the interface is the runActionAtTimemark method in the EventActionPlayer
                for (Entry e : cluster) {
                    // we have 2 options!
                    // 1) API Call
                    // 2) send to Player
                    mStickman.getStageController().sendTimeMarkInformation(e.mContent);

                }
            }
        }
    }

    private void render() {
        mCurrentStep = sMAX_ANIM_STEPS;
        while (mCurrentStep > 0) {
            //for (mCurrentStep = sMAX_ANIM_STEPS; mCurrentStep > 0; mCurrentStep--) {
            // DEBUG mStickman.mLogger.info("currentstep " + mCurrentStep + " max steps " + sMAX_ANIM_STEPS);
            if (mCurrentStep == sMAX_ANIM_STEPS) {
                //mStickman.mLogger.info("\t\t\tpreparing " + mDescription);
                // renderEventAnimatione animation components
                mAnimationComponents.stream().forEach((comp) -> {
                    BodyPart bodypart = comp.mBodyPart;
                    String action = comp.mAction;
                    int param = comp.mParam;
                    String paramString = comp.mParamString;
                    if (action.equalsIgnoreCase("rotate")) {
                        bodypart.setRotation(param);
                    }
                    if (action.equalsIgnoreCase("tilt")) {
                        bodypart.setTilt(param);
                    }
                    if (action.equalsIgnoreCase("translate")) {
                        bodypart.setTranslation(param);
                    }
                    if (action.equalsIgnoreCase("shape")) {
                        bodypart.setShape(paramString);
                    }
                });
            }

            if (mCurrentStep > 1) {
                for (AnimationContentSwing ba : mAnimationComponents) {
                    BodyPart bodypart = ba.mBodyPart;
                    String action = ba.mAction;

                    if (action.equalsIgnoreCase("rotate")) {
                        bodypart.calculateRotation(mCurrentStep);
                    }

                    if (action.equalsIgnoreCase("tilt")) {
                        bodypart.calculateRotation(mCurrentStep);
                    }

                    if (action.equalsIgnoreCase("translate")) {
                        bodypart.calculateTranslation(mCurrentStep);
                    }

                    if (action.equalsIgnoreCase("shape")) {
                        bodypart.calculateShape(mCurrentStep);
                    }
                }

                mStickman.repaint();

                new WaitThread(mRenderPauseDuration).start();
                // block this until WaitThread will unblock 
                try {
                    mRenderingPause.acquire(1);
                } catch (InterruptedException ex) {
                    mStickman.mLogger.severe(ex.getMessage());
                }
            }

            if (mCurrentStep == 1) {
                for (AnimationContentSwing ba : mAnimationComponents) {
                    String action = ba.mAction;
                    BodyPart bodypart = ba.mBodyPart;

                    if (action.equalsIgnoreCase("rotate")) {
                        bodypart.resetRotation();
                    }

                    if (action.equalsIgnoreCase("tilt")) {
                        bodypart.resetRotation();
                    }

                    if (action.equalsIgnoreCase("translate")) {
                        bodypart.resetTranslation();
                    }
                }

                mStickman.repaint();

                new WaitThread(mRenderPauseDuration).start();
                // block this until WaitThread will unblock 
                try {
                    mRenderingPause.acquire(1);
                } catch (InterruptedException ex) {
                    mStickman.mLogger.severe(ex.getMessage());
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
                mStickman.mLogger.severe(ex.getMessage());
            }
            // release sempahore
            mRenderingPause.release();
        }
    }
}
