package de.dfki.reeti.animationlogic;

import de.dfki.action.sequence.Entry;
import de.dfki.action.sequence.WordTimeMarkSequence;
import de.dfki.reeti.Reeti;
import de.dfki.stickmanSwing.util.TimingInfo;
import de.dfki.reeti.body.BodyPartFX;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

/**
 *
 * @author Beka Aptsiauri
 *
 */
public class AnimatorReeti {

    public static int sMAX_ANIM_STEPS = 20;
    public int mCurrentStep = sMAX_ANIM_STEPS;
    private final Reeti mStickmanFX;
    private final AnimationReeti mAnimationFX;
    private ArrayList<AnimationContentReeti> mAnimationComponents = new ArrayList<AnimationContentReeti>();
    private String mDescription = "";
    public WordTimeMarkSequence mWTS;
    private int mRenderPauseDuration = 0;
    public Semaphore mRenderingPause = new Semaphore(0);

    public static String sCurrentAction;

    //private long mPreparationTime = 0;
    public AnimatorReeti(Reeti sm, AnimationReeti a, ArrayList<AnimationContentReeti> animComps) {
        mStickmanFX = sm;
        mAnimationFX = a;
        mAnimationComponents = animComps;
        mDescription = mAnimationFX.getClass().getSimpleName() + " (" + mAnimationFX.mID + "), " + mAnimationFX.toString();
        mRenderPauseDuration = 40; // 40 milliseconds equals 25fps - resulting that by default an animation takes 500ms

        render();
    }

    public AnimatorReeti(Reeti sm, AnimationReeti a, ArrayList<AnimationContentReeti> animComps, int duration) {
        mStickmanFX = sm;
        mAnimationFX = a;
        mAnimationComponents = animComps;
        mDescription = mAnimationFX.getClass().getSimpleName() + " (" + mAnimationFX.mID + "), " + mAnimationFX.toString();

//        if(duration < 50)
//        	duration = 50;
        mRenderPauseDuration = new Float(duration / sMAX_ANIM_STEPS).intValue();
        mRenderPauseDuration = (mRenderPauseDuration < 1) ? 1 : mRenderPauseDuration; // minimum delay is 1 millisecond
        render();
    }

    public AnimatorReeti(Reeti sm, AnimationReeti a, ArrayList<AnimationContentReeti> animComps, int duration, int step) {
        mStickmanFX = sm;
        mAnimationFX = a;
        mAnimationComponents = animComps;
        mDescription = mAnimationFX.getClass().getSimpleName() + " (" + mAnimationFX.mID + "), " + mAnimationFX.toString();

        mRenderPauseDuration = new Float(duration / sMAX_ANIM_STEPS).intValue();
        mRenderPauseDuration = (mRenderPauseDuration < 1) ? 1 : mRenderPauseDuration; // minimum delay is 1 millisecond
        render(step);
    }

    public AnimatorReeti(Reeti sm, AnimationReeti a, ArrayList<AnimationContentReeti> animComps, WordTimeMarkSequence wts) {
        mStickmanFX = sm;
        mAnimationFX = a;
        mAnimationComponents = animComps;
        mWTS = wts;
        mDescription = mAnimationFX.getClass().getSimpleName() + " (" + mAnimationFX.mID + "), " + mAnimationFX.toString();

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
                //mStickmanFX.mSpeechBubble.mCurrentlySpokenText = currentlySpokenText;

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

                    mStickmanFX.getStickmanStageController().sendTimeMarkInformation(e.mContent);
                }
            }
        }
    }

    private void render() {
        mCurrentStep = sMAX_ANIM_STEPS;
        while (mCurrentStep > 0) {
            if (mCurrentStep == sMAX_ANIM_STEPS) {
                // renderEventAnimatione animation components
                mAnimationComponents.stream().forEach((comp) -> {
                    BodyPartFX bodypartFX = comp.mBodyPartFX;
                    String action = comp.mAction;
                    sCurrentAction = action;
                    int param = comp.mParam;
                    String paramString = comp.mParamString;
                    if (action.equalsIgnoreCase("rotate")) {
                        bodypartFX.set_X_Rotation(param);
                    }
                    if (action.equalsIgnoreCase("yRotate")) {
                        bodypartFX.set_Y_Rotation(param);
                    }
                    if (action.equalsIgnoreCase("zRotate")) {
                        bodypartFX.set_Z_Rotation(param);
                    }
                    if (action.equalsIgnoreCase("tilt")) {
                        bodypartFX.setTilt(param);
                    }
                    if (action.equalsIgnoreCase("translate")) {
                        bodypartFX.set_X_Translation(param);
                    }
                    if (action.equalsIgnoreCase("ytranslate")) {
                        bodypartFX.set_Y_Translation(param);
                    }
                    if (action.equalsIgnoreCase("ztranslate")) {
                        bodypartFX.set_Z_Translation(param);
                    }
                    if (action.equalsIgnoreCase("shape")) {
                        bodypartFX.setShape(paramString);
                    }
                });
            }

            if (mCurrentStep > 1) {
                for (AnimationContentReeti ba : mAnimationComponents) {
                    BodyPartFX bodypartFX = ba.mBodyPartFX;
                    String action = ba.mAction;

                    if (action.equalsIgnoreCase("rotate")) {
                        bodypartFX.calculate_X_Rotation(mCurrentStep);
                    }
                    if (action.equalsIgnoreCase("yrotate")) {
                        bodypartFX.calculate_Y_Rotation(mCurrentStep);
                    }
                    if (action.equalsIgnoreCase("zrotate")) {
                        bodypartFX.calculate_Z_Rotation(mCurrentStep);
                    }
                    if (action.equalsIgnoreCase("tilt")) {
                        bodypartFX.calculate_X_Rotation(mCurrentStep);
                    }

                    if (action.equalsIgnoreCase("translate")) {
                        bodypartFX.calculate_X_Translation(mCurrentStep);
                    }
                    if (action.equalsIgnoreCase("ytranslate")) {
                        bodypartFX.calculate_Y_Translation(mCurrentStep);
                    }
                    if (action.equalsIgnoreCase("ztranslate")) {
                        bodypartFX.calculate_Z_Translation(mCurrentStep);
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
                for (AnimationContentReeti ba : mAnimationComponents) {
                    String action = ba.mAction;
                    BodyPartFX bodypartFX = ba.mBodyPartFX;

                    if (action.equalsIgnoreCase("rotate")) {
                        bodypartFX.reset_X_Rotation();
                    }
                    if (action.equalsIgnoreCase("yrotate")) {
                        bodypartFX.reset_Y_Rotation();
                    }
                    if (action.equalsIgnoreCase("zrotate")) {
                        bodypartFX.reset_Z_Rotation();
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
                return;
            }

            mCurrentStep -= 1;
        }
    }

    private void render(int step) {
        mCurrentStep = step;
        while (mCurrentStep > 0) {
            if (mCurrentStep == step) {
                // renderEventAnimatione animation components
                mAnimationComponents.stream().forEach((comp) -> {
                    BodyPartFX bodypartFX = comp.mBodyPartFX;
                    String action = comp.mAction;
                    sCurrentAction = action;
                    int param = comp.mParam;
                    String paramString = comp.mParamString;
                    if (action.equalsIgnoreCase("rotate")) {
                        bodypartFX.set_X_Rotation(param);
                    }
                    if (action.equalsIgnoreCase("yRotate")) {
                        bodypartFX.set_Y_Rotation(param);
                    }
                    if (action.equalsIgnoreCase("zRotate")) {
                        bodypartFX.set_Z_Rotation(param);
                    }
                    if (action.equalsIgnoreCase("tilt")) {
                        bodypartFX.setTilt(param);
                    }
                    if (action.equalsIgnoreCase("translate")) {
                        bodypartFX.set_X_Translation(param);
                    }
                    if (action.equalsIgnoreCase("ytranslate")) {
                        bodypartFX.set_Y_Translation(param);
                    }
                    if (action.equalsIgnoreCase("ztranslate")) {
                        bodypartFX.set_Z_Translation(param);
                    }
                    if (action.equalsIgnoreCase("shape")) {
                        bodypartFX.setShape(paramString);
                    }
                });
            }

            if (mCurrentStep > 1) {
                for (AnimationContentReeti ba : mAnimationComponents) {
                    BodyPartFX bodypartFX = ba.mBodyPartFX;
                    String action = ba.mAction;

                    if (action.equalsIgnoreCase("rotate")) {
                        bodypartFX.calculate_X_Rotation(mCurrentStep);
                    }
                    if (action.equalsIgnoreCase("yrotate")) {
                        bodypartFX.calculate_Y_Rotation(mCurrentStep);
                    }
                    if (action.equalsIgnoreCase("zrotate")) {
                        bodypartFX.calculate_Z_Rotation(mCurrentStep);
                    }
                    if (action.equalsIgnoreCase("tilt")) {
                        bodypartFX.calculate_X_Rotation(mCurrentStep);
                    }

                    if (action.equalsIgnoreCase("translate")) {
                        bodypartFX.calculate_X_Translation(mCurrentStep);
                    }
                    if (action.equalsIgnoreCase("ytranslate")) {
                        bodypartFX.calculate_Y_Translation(mCurrentStep);
                    }
                    if (action.equalsIgnoreCase("ztranslate")) {
                        bodypartFX.calculate_Z_Translation(mCurrentStep);
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
                for (AnimationContentReeti ba : mAnimationComponents) {
                    String action = ba.mAction;
                    BodyPartFX bodypartFX = ba.mBodyPartFX;

                    if (action.equalsIgnoreCase("rotate")) {
                        bodypartFX.resetRotation();
                    }
                    if (action.equalsIgnoreCase("yrotate")) {
                        bodypartFX.resetRotation();
                    }
                    if (action.equalsIgnoreCase("zrotate")) {
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
