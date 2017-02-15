package de.dfki.reeti;

import de.dfki.reeti.animationlogic.AnimationLoaderReeti;
import de.dfki.reeti.animationlogic.AnimationSchedulerReeti;
import de.dfki.reeti.body.LeftEye;
import de.dfki.reeti.body.HeadFX;
import de.dfki.reeti.body.NoseFX;
import de.dfki.reeti.body.MouthFX;
import de.dfki.reeti.body.Body;
import de.dfki.reeti.body.RightEyelid;
import de.dfki.reeti.body.LeftEyelid;
import de.dfki.reeti.body.NeckFX;
import de.dfki.reeti.body.RightEye;
import de.dfki.action.sequence.WordTimeMarkSequence;
import de.dfki.common.Gender;
import de.dfki.common.interfaces.StageRoom;
import de.dfki.common.interfaces.Stickman;
import de.dfki.reeti.animation.environment.Blinking;
import de.dfki.stickmanSwing.animationlogic.listener.AnimationListener;
import de.dfki.reeti.animationlogic.AnimationReeti;
import de.dfki.reeti.animationlogic.EventAnimationReeti;
import de.dfki.reeti.body.LeftEar;
import de.dfki.reeti.body.RightEar;
import de.dfki.reeti.environment.SpeechBubbleFX;
import java.awt.Dimension;
import java.awt.Toolkit;
import javafx.scene.effect.InnerShadow;
import javafx.scene.layout.Pane;
import javafx.scene.transform.Affine;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Semaphore;
import java.util.logging.ConsoleHandler;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

/**
 *
 * @author Beka Aptsiauri
 *
 * This work is inspired by the stickmans drawn by Sarah Johnson
 * (www.sarah-johnson.com) in the Valentine music video from Kina Grannis shot
 * by Ross Ching in 2012
 *
 */
public class Reeti extends Pane implements Stickman {
    
    public Gender.TYPE mType = Gender.TYPE.FEMALE;
    public String mName = "StickmanSwing";
    public float mScale = 1.0f;
    public float mGeneralXTranslation = 0;
    public float mGeneralYTranslation = 0;
    public double stageHeight;
    public boolean isFullScreen = false;

    public static String mbackground = null;

    public static Dimension mDefaultSize = new Dimension(300, 800);
    public static Dimension mSize = new Dimension(mDefaultSize);


    public Blinking mBlinking;

    // amimation stuff
    public Semaphore mAnimationLaunchControl = new Semaphore(1);
    public AnimationSchedulerReeti mAnimationSchedulerFX;
    private final List<AnimationListener> mAnimationListeners = new CopyOnWriteArrayList<AnimationListener>();

    // body parts
    public HeadFX mHeadFX;
    public NoseFX mNoseFX;
    public LeftEyelid mLeftEyebrowFX;
    public LeftEye mLeftEye;
    public RightEye mRightEye;
    public LeftEar mLeftEar;
    public RightEar mRightEar;
    public RightEyelid mRightEyebrowFX;
    public MouthFX mMouthFX;
    public NeckFX mNeckFX;
    public Body mUpperBody;
    // environment
    public SpeechBubbleFX mSpeechBubbleFX;
    private StageRoom stageController;
    // logging
    public final Logger mLogger = Logger.getAnonymousLogger();
    // id
    private long mID = 0;

    public Reeti(String name, Gender.TYPE gender, float scale, Dimension size) {
        mSize = size;
        mScale = scale;
        isFullScreen = true;
        mName = name;
        mType = gender;

        mHeadFX = new HeadFX(this);
        mLeftEyebrowFX = new LeftEyelid(mHeadFX);
        mLeftEye = new LeftEye(mHeadFX);
        mRightEye = new RightEye(mHeadFX);
        mLeftEar = new LeftEar(mHeadFX);
        mRightEar = new RightEar(mHeadFX);
        mRightEyebrowFX = new RightEyelid(mHeadFX);
        mNoseFX = new NoseFX(mHeadFX);
        mMouthFX = new MouthFX(mHeadFX);
        mNeckFX = new NeckFX(mHeadFX);
        mUpperBody = new Body(mNeckFX);

        mSpeechBubbleFX = new SpeechBubbleFX(mHeadFX);
        init();
        this.addAllParts();
        update();
    }

    public Reeti(String name, Gender.TYPE gender, float scale, double height) {
        mScale = scale;
        isFullScreen = false;
        this.stageHeight = height;
        mName = name;
        mType = gender;

        mHeadFX = new HeadFX(this);
        mLeftEyebrowFX = new LeftEyelid(mHeadFX);
        mLeftEye = new LeftEye(mHeadFX);
        mRightEye = new RightEye(mHeadFX);
        mLeftEar = new LeftEar(mHeadFX);
        mRightEar = new RightEar(mHeadFX);
        mRightEyebrowFX = new RightEyelid(mHeadFX);
        mNoseFX = new NoseFX(mHeadFX);
        mMouthFX = new MouthFX(mHeadFX);
        mNeckFX = new NeckFX(mHeadFX);
        mUpperBody = new Body(mNeckFX);

        mSpeechBubbleFX = new SpeechBubbleFX(mHeadFX);
        init();
        this.addAllParts();
        update();
    }

    public Reeti(String name, Gender.TYPE gender) {
        mName = name;
        mType = gender;

        isFullScreen = true;
        mHeadFX = new HeadFX(this);
        mLeftEyebrowFX = new LeftEyelid(mHeadFX);
        mLeftEye = new LeftEye(mHeadFX);
        mRightEye = new RightEye(mHeadFX);
        mLeftEar = new LeftEar(mHeadFX);
        mRightEar = new RightEar(mHeadFX);
        mRightEyebrowFX = new RightEyelid(mHeadFX);
        mNoseFX = new NoseFX(mHeadFX);
        mMouthFX = new MouthFX(mHeadFX);
        mNeckFX = new NeckFX(mHeadFX);
        mUpperBody = new Body(mNeckFX);

        mSpeechBubbleFX = new SpeechBubbleFX(mHeadFX);
        init();
        this.addAllParts();
        update();
    }

    private void init() {
        this.setPrefHeight(mSize.height);
        this.setPrefWidth(mSize.width);
        this.setMinHeight(mSize.height);
        this.setMinWidth(mSize.width);

        InnerShadow is = new InnerShadow();
        is.setOffsetX(4.0f);
        is.setOffsetY(4.0f);

        ConsoleHandler ch = new ConsoleHandler();
        ch.setFormatter(new StickmanLogFormatter());

        mLogger.addHandler(ch);
        mLogger.setUseParentHandlers(false);

        mAnimationSchedulerFX = new AnimationSchedulerReeti(this);
        mAnimationSchedulerFX.start();
    }

    public void addListener(AnimationListener al) {
        mAnimationListeners.add(al);
    }

    public void removeListener(AnimationListener al) {
        synchronized (mAnimationListeners) {
            if (mAnimationListeners.contains(al)) {
                mAnimationListeners.remove(al);
            }
        }
    }

    public void notifyListeners(String animationId) {
        synchronized (mAnimationListeners) {
            mAnimationListeners.stream().forEach((al) -> {
                al.update(animationId);
            });
        }
    }

    public String getID() {
        return (new StringBuffer()).append(mName).append(" AnimationSwing ").append(mID++).toString();
    }

    public AnimationReeti doEventFeedbackAnimation(String name, int duration, WordTimeMarkSequence wts, boolean block) {
        EventAnimationReeti a = AnimationLoaderReeti.getInstance().loadEventAnimation(this, name, duration, block);

        a.setParameter(wts);

        try {
            mAnimationLaunchControl.acquire();
            a.start();
        } catch (InterruptedException ex) {
            mLogger.severe(ex.getMessage());
        }

        return a;
    }

    @Override
    public StageRoom getStickmanStageController() {
        return stageController;
    }

    @Override
    public void setStageController(StageRoom s) {
        stageController = s;
    }

    @Override
    public void setShowName(boolean show) {

    }

    @Override
    public boolean isShowName() {
        return false;
    }

    @Override
    public void endAnimationScheduler() {

    }

    @Override
    public Gender.TYPE getType() {
        return null;
    }

    public AnimationReeti doAnimation(String name, int duration, boolean block) {
        return doAnimation(name, duration, "", block);
    }

    public AnimationReeti doAnimation(String name, int frequent, int actionDuration, boolean block) {
        AnimationReeti a = AnimationLoaderReeti.getInstance().loadAnimation(this, name, frequent, actionDuration, block);

        try {
            mAnimationLaunchControl.acquire();
            a.start();
        } catch (InterruptedException ex) {
            mLogger.severe(ex.getMessage());
        }

        return a;
    }

    public AnimationReeti doAnimation(String name, Object param, boolean block) {
        return doAnimation(name, -1, param, block);
    }

    public AnimationReeti doAnimation(String name, boolean block) {
        return doAnimation(name, -1, "", block);
    }

    public AnimationReeti doAnimation(String name, int duration, Object param, boolean block) {
        AnimationReeti a = AnimationLoaderReeti.getInstance().loadAnimation(this, name, duration, block);

        a.setParameter(param); // this is for now only used by the Speech Bubble

        try {
            mAnimationLaunchControl.acquire();
            a.start();
        } catch (InterruptedException ex) {
            mLogger.severe(ex.getMessage());
        }

        return a;
    }

    public void playAnimation(AnimationReeti a) {
        try {
            mAnimationLaunchControl.acquire();
            a.start();
        } catch (InterruptedException ex) {
            mLogger.severe(ex.getMessage());
        }
    }

    public void update() {

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        double StickmanHeight = 500;
        Affine af = new Affine();
        int shiftFactor = (int) (StickmanHeight - (StickmanHeight * mScale));
        if (isFullScreen) {
            mGeneralYTranslation = (int) ((dim.getHeight() - StickmanHeight) + shiftFactor + 100);
            mGeneralXTranslation = 0;
        } else {
            mGeneralYTranslation = (int) ((this.stageHeight - StickmanHeight) + shiftFactor - 350);
            mGeneralXTranslation = 100;
        }
        af.appendTranslation(mGeneralXTranslation, mGeneralYTranslation);
        af.appendScale(mScale, mScale);
        this.getTransforms().clear();
        this.getTransforms().add(af);
    }

    public void setScale(float scale) {
        mScale = scale;
    }

    private static class StickmanLogFormatter extends Formatter {

        @Override
        public String format(LogRecord record) {
            return ((new StringBuffer()).append(record.getLevel()).append(": ").append(record.getMessage())
                    .append("\n")).toString();
        }
    }

    private void addAllParts() {

        this.getChildren().addAll(mNeckFX, mHeadFX, mUpperBody, mSpeechBubbleFX);

    }
}
