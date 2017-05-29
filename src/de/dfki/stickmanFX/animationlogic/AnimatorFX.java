package de.dfki.stickmanFX.animationlogic;

import de.dfki.action.sequence.Entry;
import de.dfki.action.sequence.WordTimeMarkSequence;
import de.dfki.stickmanSwing.util.TimingInfo;
import de.dfki.stickmanFX.StickmanFX;
import de.dfki.stickmanFX.bodyfx.BodyPartFX;
import de.dfki.util.observers.AnimationObserver;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.Semaphore;
import static java.lang.Thread.sleep;

/**
 *
 * @author Beka Aptsiauri
 *
 */
public class AnimatorFX {

    public static int sMAX_ANIM_STEPS = 20;
    public int mCurrentStep = sMAX_ANIM_STEPS;
    private final StickmanFX mStickmanFX;
    private final AnimationFX mAnimationFX;
    private ArrayList<AnimationContentFX> mAnimationComponents = new ArrayList<AnimationContentFX>();
    private String mDescription = "";
    public WordTimeMarkSequence mWTS;
    private int mRenderPauseDuration = 0;
    public Semaphore mRenderingPause = new Semaphore(0);
    private static LinkedList<AnimationObserver> observers = new LinkedList<>();

    //private long mPreparationTime = 0;
    public AnimatorFX(StickmanFX sm, AnimationFX a, ArrayList<AnimationContentFX> animComps) {
        mStickmanFX = sm;
        mAnimationFX = a;
        mAnimationComponents = animComps;
        mDescription = mAnimationFX.getClass().getSimpleName() + " (" + mAnimationFX.getmID() + "), " + mAnimationFX.toString();
        mRenderPauseDuration = 40; // 40 milliseconds equals 25fps - resulting that by default an animation takes 500ms

        render();
    }

    public AnimatorFX(StickmanFX sm, AnimationFX a, ArrayList<AnimationContentFX> animComps, int duration) {
        mStickmanFX = sm;
        mAnimationFX = a;
        mAnimationComponents = animComps;
        mDescription = mAnimationFX.getClass().getSimpleName() + " (" + mAnimationFX.getmID() + "), " + mAnimationFX.toString();

        mRenderPauseDuration = new Float(duration / sMAX_ANIM_STEPS).intValue();
        mRenderPauseDuration = (mRenderPauseDuration < 1) ? 1 : mRenderPauseDuration; // minimum delay is 1 millisecond
        render();
    }

    public AnimatorFX(StickmanFX sm, AnimationFX a, ArrayList<AnimationContentFX> animComps, WordTimeMarkSequence wts) {
        mStickmanFX = sm;
        mAnimationFX = a;
        mAnimationComponents = animComps;
        mWTS = wts;
        mDescription = mAnimationFX.getClass().getSimpleName() + " (" + mAnimationFX.getmID() + "), " + mAnimationFX.toString();

        renderEventAnimation();
    }

    private void renderEventAnimation() {
        for (ArrayList<Entry> cluster : mWTS.getClusters()) {
            if (WordTimeMarkSequence.getClusterType(cluster) == Entry.TYPE.WORD) {
                String text = "";

                for (Entry e : cluster) {
                    text += e.mContent + " ";
                }
                text = text.trim();

                String currentlySpokenText = "";
                currentlySpokenText = text.replace("oe", "ö").replace("ae", "ä").replace("ue", "ü").replace("Oe", "Ö").replace("Ae", "Ä").replace("Ue", "Ü").replace("ss", "ß").replace("\n", " ").replace("   ", " ").replace("  ", " ");

                String allText = "";
                allText = mWTS.getText().replace("oe", "ö").replace("ae", "ä").replace("ue", "ü").replace("Oe", "Ö").replace("Ae", "Ä").replace("Ue", "Ü").replace("ss", "ß").replace("\n", " ").replace("   ", " ").replace("  ", " ");

                mStickmanFX.mSpeechBubbleFX.mText = allText;
                //mStickman.mSpeechBubble.mCurrentlySpokenText = currentlySpokenText;

                // do the rendering ...
                int duration = TimingInfo.spokenStringDuration(text);

                mRenderPauseDuration = new Float(duration / sMAX_ANIM_STEPS).intValue();
                mRenderPauseDuration = (mRenderPauseDuration < 1) ? 1 : mRenderPauseDuration; // minimum delay is 1 millisecond

                render();
            }

            if (WordTimeMarkSequence.getClusterType(cluster) == Entry.TYPE.TIMEMARK) {
                // here we have to spread the word that a specific timemark has been reached
                // the interface is the runActionAtTimemark method in the EventActionPlayer
                for (Entry e : cluster) {
                    // we have 2 options!
                    // 1) API Call
                    // 2) send to Player
                    mStickmanFX.getStageController().sendTimeMarkInformation(e.mContent);
                }
            }
        }
    }

    private void render() {
        mCurrentStep = sMAX_ANIM_STEPS;
        while (mCurrentStep > 0) {
            if (mCurrentStep == sMAX_ANIM_STEPS) {
                // renderEventAnimatione animation components
                mAnimationComponents.stream().forEach((comp)
                        -> {
                    BodyPartFX bodypartFX = comp.mBodyPartFX;
                    String action = comp.mAction;
                    int param = comp.mParam;
                    String paramString = comp.mParamString;
                    if (action.equalsIgnoreCase("rotate")) {
                        bodypartFX.setRotation(param);
                    }
                    if (action.equalsIgnoreCase("tilt")) {
                        bodypartFX.setTilt(param);
                    }
                    if (action.equalsIgnoreCase("translate")) {
                        bodypartFX.setTranslation(param);
                    }
                    if (action.equalsIgnoreCase("shape")) {
                        bodypartFX.setShape(paramString);
                    }
                });
            }

            if (mCurrentStep > 1) {
                for (AnimationContentFX ba : mAnimationComponents) {
                    BodyPartFX bodypartFX = ba.mBodyPartFX;
                    String action = ba.mAction;

                    if (action.equalsIgnoreCase("rotate")) {
                        bodypartFX.calculateRotation(mCurrentStep);
                    }

                    if (action.equalsIgnoreCase("tilt")) {
                        bodypartFX.calculateRotation(mCurrentStep);
                    }

                    if (action.equalsIgnoreCase("translate")) {
                        bodypartFX.calculateTranslation(mCurrentStep);
                    }

                    if (action.equalsIgnoreCase("shape")) {
                        bodypartFX.calculateShape(mCurrentStep);
                    }
                }

                new WaitThread(mRenderPauseDuration).start();
                // block this until WaitThread will unblock 
                try {
                    mRenderingPause.acquire(1);
                } catch (InterruptedException ex) {
                    mStickmanFX.mLogger.severe(ex.getMessage());
                }
            }

            if (mCurrentStep == 1) {
                for (AnimationContentFX ba : mAnimationComponents) {
                    String action = ba.mAction;
                    BodyPartFX bodypartFX = ba.mBodyPartFX;

                    if (action.equalsIgnoreCase("rotate")) {
                        bodypartFX.resetRotation();
                    }

                    if (action.equalsIgnoreCase("tilt")) {
                        bodypartFX.resetRotation();
                    }

                    if (action.equalsIgnoreCase("translate")) {
                        bodypartFX.resetTranslation();
                    }
                }

                new WaitThread(mRenderPauseDuration).start();
                // block this until WaitThread will unblock 
                try {
                    mRenderingPause.acquire(1);
                } catch (InterruptedException ex) {
                    mStickmanFX.mLogger.severe(ex.getMessage());
                }
                mAnimationFX.mAnimationPartStart.release();
                if (mAnimationFX.mParameter instanceof AnimationObserver) {
                    try {
                        BufferedImage image = mStickmanFX.getStageController().getStageAsImage();
                        notifyAllObservers(image);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
                return;
            }

            mCurrentStep -= 1;
        }
    }

    public void notifyOnIdentifier(String image) {
        notifyAllObservers(image);
    }

    public static void register(AnimationObserver obj) {
        observers.add(obj);
    }

    public static void unregister(AnimationObserver obj) {
        observers.remove(obj);
    }

    public static void notifyAllObservers(Object obj) {
        for (AnimationObserver observer : observers) {
            observer.update(obj);
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
