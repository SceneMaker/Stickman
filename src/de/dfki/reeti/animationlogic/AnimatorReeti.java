package de.dfki.reeti.animationlogic;

import de.dfki.action.sequence.Entry;
import de.dfki.action.sequence.WordTimeMarkSequence;
import de.dfki.reeti.Reeti;
import de.dfki.reeti.body.Parts;
import de.dfki.stickmanSwing.util.TimingInfo;

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
    private final Reeti mReeti;
    private final AnimationReeti mAnimation;
    private ArrayList<AnimationContentReeti> mAnimationComponents = new ArrayList<AnimationContentReeti>();
    private String mDescription = "";
    public WordTimeMarkSequence mWTS;
    private int mRenderPauseDuration = 0;
    public Semaphore mRenderingPause = new Semaphore(0);

    public static String sCurrentAction;

    //private long mPreparationTime = 0;
    public AnimatorReeti(Reeti reeti, AnimationReeti a, ArrayList<AnimationContentReeti> animComps) {
        mReeti = reeti;
        mAnimation = a;
        mAnimationComponents = animComps;
        mDescription = mAnimation.getClass().getSimpleName() + " (" + mAnimation.mID + "), " + mAnimation.toString();
        mRenderPauseDuration = 40; // 40 milliseconds equals 25fps - resulting that by default an animation takes 500ms

        render();
    }

    public AnimatorReeti(Reeti reeti, AnimationReeti a, ArrayList<AnimationContentReeti> animComps, int duration) {
        mReeti = reeti;
        mAnimation = a;
        mAnimationComponents = animComps;
        mDescription = mAnimation.getClass().getSimpleName() + " (" + mAnimation.mID + "), " + mAnimation.toString();

        mRenderPauseDuration = new Float(duration / sMAX_ANIM_STEPS).intValue();
        mRenderPauseDuration = (mRenderPauseDuration < 1) ? 1 : mRenderPauseDuration; // minimum delay is 1 millisecond
        render();
    }

    public AnimatorReeti(Reeti reeti, AnimationReeti a, ArrayList<AnimationContentReeti> animComps, int duration, int step) {
        mReeti = reeti;
        mAnimation = a;
        mAnimationComponents = animComps;
        mDescription = mAnimation.getClass().getSimpleName() + " (" + mAnimation.mID + "), " + mAnimation.toString();

        mRenderPauseDuration = new Float(duration / sMAX_ANIM_STEPS).intValue();
        mRenderPauseDuration = (mRenderPauseDuration < 1) ? 1 : mRenderPauseDuration; // minimum delay is 1 millisecond
        render(step);
    }

    public AnimatorReeti(Reeti reeti, AnimationReeti a, ArrayList<AnimationContentReeti> animComps, WordTimeMarkSequence wts) {
        mReeti = reeti;
        mAnimation = a;
        mAnimationComponents = animComps;
        mWTS = wts;
        mDescription = mAnimation.getClass().getSimpleName() + " (" + mAnimation.mID + "), " + mAnimation.toString();

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

                mReeti.mSpeechBubble.mText = allText;
                //mReeti.mSpeechBubble.mCurrentlySpokenText = currentlySpokenText;

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

                    mReeti.getStageController().sendTimeMarkInformation(e.mContent);
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
                    Parts bodyPart = comp.mBodyPart;
                    String action = comp.mAction;
                    sCurrentAction = action;
                    int param = comp.mParam;
                    String paramString = comp.mParamString;
                    if (action.equalsIgnoreCase("rotate")) {
                        bodyPart.set_X_Rotation(param);
                    }
                    if (action.equalsIgnoreCase("yRotate")) {
                        bodyPart.set_Y_Rotation(param);
                    }
                    if (action.equalsIgnoreCase("zRotate")) {
                        bodyPart.set_Z_Rotation(param);
                    }
                    if (action.equalsIgnoreCase("tilt")) {
                        bodyPart.setTilt(param);
                    }
                    if (action.equalsIgnoreCase("translate")) {
                        bodyPart.set_X_Translation(param);
                    }
                    if (action.equalsIgnoreCase("ytranslate")) {
                        bodyPart.set_Y_Translation(param);
                    }
                    if (action.equalsIgnoreCase("ztranslate")) {
                        bodyPart.set_Z_Translation(param);
                    }
                    if (action.equalsIgnoreCase("shape")) {
                        bodyPart.setShape(paramString);
                    }
                });
            }

            if (mCurrentStep > 1) {
                for (AnimationContentReeti acr : mAnimationComponents) {
                    Parts bodypart = acr.mBodyPart;
                    String action = acr.mAction;

                    if (action.equalsIgnoreCase("rotate")) {
                        bodypart.calculate_X_Rotation(mCurrentStep);
                    }
                    if (action.equalsIgnoreCase("yrotate")) {
                        bodypart.calculate_Y_Rotation(mCurrentStep);
                    }
                    if (action.equalsIgnoreCase("zrotate")) {
                        bodypart.calculate_Z_Rotation(mCurrentStep);
                    }
                    if (action.equalsIgnoreCase("tilt")) {
                        bodypart.calculate_X_Rotation(mCurrentStep);
                    }

                    if (action.equalsIgnoreCase("translate")) {
                        bodypart.calculate_X_Translation(mCurrentStep);
                    }
                    if (action.equalsIgnoreCase("ytranslate")) {
                        bodypart.calculate_Y_Translation(mCurrentStep);
                    }
                    if (action.equalsIgnoreCase("ztranslate")) {
                        bodypart.calculate_Z_Translation(mCurrentStep);
                    }
                    if (action.equalsIgnoreCase("shape")) {
                        bodypart.calculateShape(mCurrentStep);
                    }
                }

                new WaitThread(mRenderPauseDuration).start();
                // block this until WaitThread will unblock
                try {
                    mRenderingPause.acquire(1);
                } catch (InterruptedException ex) {
                    mReeti.mLogger.severe(ex.getMessage());
                }
            }

            if (mCurrentStep == 1) {
                for (AnimationContentReeti acr : mAnimationComponents) {
                    String action = acr.mAction;
                    Parts bodypart = acr.mBodyPart;

                    if (action.equalsIgnoreCase("rotate")) {
                        bodypart.reset_X_Rotation();
                    }
                    if (action.equalsIgnoreCase("yrotate")) {
                        bodypart.reset_Y_Rotation();
                    }
                    if (action.equalsIgnoreCase("zrotate")) {
                        bodypart.reset_Z_Rotation();
                    }
                    if (action.equalsIgnoreCase("tilt")) {
                        bodypart.resetRotation();
                    }

                    if (action.equalsIgnoreCase("translate")) {
                        bodypart.resetTranslation();
                    }
                }

                new WaitThread(mRenderPauseDuration).start();
                // block this until WaitThread will unblock
                try {
                    mRenderingPause.acquire(1);
                } catch (InterruptedException ex) {
                    mReeti.mLogger.severe(ex.getMessage());
                }
                mAnimation.mAnimationPartStart.release();
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
                    Parts bodypart = comp.mBodyPart;
                    String action = comp.mAction;
                    sCurrentAction = action;
                    int param = comp.mParam;
                    String paramString = comp.mParamString;
                    if (action.equalsIgnoreCase("rotate")) {
                        bodypart.set_X_Rotation(param);
                    }
                    if (action.equalsIgnoreCase("yRotate")) {
                        bodypart.set_Y_Rotation(param);
                    }
                    if (action.equalsIgnoreCase("zRotate")) {
                        bodypart.set_Z_Rotation(param);
                    }
                    if (action.equalsIgnoreCase("tilt")) {
                        bodypart.setTilt(param);
                    }
                    if (action.equalsIgnoreCase("translate")) {
                        bodypart.set_X_Translation(param);
                    }
                    if (action.equalsIgnoreCase("ytranslate")) {
                        bodypart.set_Y_Translation(param);
                    }
                    if (action.equalsIgnoreCase("ztranslate")) {
                        bodypart.set_Z_Translation(param);
                    }
                    if (action.equalsIgnoreCase("shape")) {
                        bodypart.setShape(paramString);
                    }
                });
            }

            if (mCurrentStep > 1) {
                for (AnimationContentReeti acr : mAnimationComponents) {
                    Parts bodypart = acr.mBodyPart;
                    String action = acr.mAction;

                    if (action.equalsIgnoreCase("rotate")) {
                        bodypart.calculate_X_Rotation(mCurrentStep);
                    }
                    if (action.equalsIgnoreCase("yrotate")) {
                        bodypart.calculate_Y_Rotation(mCurrentStep);
                    }
                    if (action.equalsIgnoreCase("zrotate")) {
                        bodypart.calculate_Z_Rotation(mCurrentStep);
                    }
                    if (action.equalsIgnoreCase("tilt")) {
                        bodypart.calculate_X_Rotation(mCurrentStep);
                    }

                    if (action.equalsIgnoreCase("translate")) {
                        bodypart.calculate_X_Translation(mCurrentStep);
                    }
                    if (action.equalsIgnoreCase("ytranslate")) {
                        bodypart.calculate_Y_Translation(mCurrentStep);
                    }
                    if (action.equalsIgnoreCase("ztranslate")) {
                        bodypart.calculate_Z_Translation(mCurrentStep);
                    }
                    if (action.equalsIgnoreCase("shape")) {
                        bodypart.calculateShape(mCurrentStep);
                    }
                }

                new WaitThread(mRenderPauseDuration).start();
                // block this until WaitThread will unblock
                try {
                    mRenderingPause.acquire(1);
                } catch (InterruptedException ex) {
                    mReeti.mLogger.severe(ex.getMessage());
                }
            }

            if (mCurrentStep == 1) {
                for (AnimationContentReeti acr : mAnimationComponents) {
                    String action = acr.mAction;
                    Parts bodypart = acr.mBodyPart;

                    if (action.equalsIgnoreCase("rotate")) {
                        bodypart.resetRotation();
                    }
                    if (action.equalsIgnoreCase("yrotate")) {
                        bodypart.resetRotation();
                    }
                    if (action.equalsIgnoreCase("zrotate")) {
                        bodypart.resetRotation();
                    }
                    if (action.equalsIgnoreCase("tilt")) {
                        bodypart.resetRotation();
                    }

                    if (action.equalsIgnoreCase("translate")) {
                        bodypart.resetTranslation();
                    }
                }

                new WaitThread(mRenderPauseDuration).start();
                // block this until WaitThread will unblock
                try {
                    mRenderingPause.acquire(1);
                } catch (InterruptedException ex) {
                    mReeti.mLogger.severe(ex.getMessage());
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
                mReeti.mLogger.severe(ex.getMessage());
            }
            // release sempahore
            mRenderingPause.release();
        }
    }
}
