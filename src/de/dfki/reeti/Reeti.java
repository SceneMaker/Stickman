package de.dfki.reeti;

import de.dfki.reeti.animationlogic.AnimationLoaderReeti;
import de.dfki.reeti.animationlogic.AnimationSchedulerReeti;
import de.dfki.reeti.body.LeftEye;
import de.dfki.reeti.body.Head;
import de.dfki.reeti.body.Mouth;
import de.dfki.reeti.body.Body;
import de.dfki.reeti.body.RightEyelid;
import de.dfki.reeti.body.LeftEyelid;
import de.dfki.reeti.body.Neck;
import de.dfki.reeti.body.RightEye;
import de.dfki.action.sequence.WordTimeMarkSequence;
import de.dfki.common.Gender;
import de.dfki.common.interfaces.StageRoom;
import de.dfki.common.interfaces.Stickman;
import de.dfki.reeti.animation.environment.Blinking;
import de.dfki.stickmanSwing.animationlogic.listener.AnimationListener;
import de.dfki.reeti.animationlogic.AnimationReeti;
import de.dfki.reeti.animationlogic.EventAnimationReeti;
import de.dfki.reeti.body.LeftCheek;
import de.dfki.reeti.body.LeftEar;
import de.dfki.reeti.body.MouthDownLip;
import de.dfki.reeti.body.MouthLeftCorner;
import de.dfki.reeti.body.MouthRightCorner;
import de.dfki.reeti.body.MouthUpperLip;
import de.dfki.reeti.body.RightCheek;
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
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;

/**
 *
 * @author Beka Aptsiauri
 *
 * This work is inspired by the stickmans drawn by Sarah Johnson
 * (www.sarah-johnson.com) in the Valentine music video from Kina Grannis shot
 * by Ross Ching in 2012
 *
 */
public class Reeti extends Pane implements Stickman
{

    public enum LED
    {
        LEFTLED, RIGHTLED, BOTHLED
    }

    public Gender.TYPE mType = Gender.TYPE.FEMALE;
    public String mName = "StickmanSwing";
    public float mScale = 1.0f;
    public double stageHeight;
    public boolean isFullScreen = false;

    public static String mbackground = null;

    private static Dimension mDefaultSize = new Dimension(300, 800);
    public static Dimension mSize = new Dimension(mDefaultSize);

    public Blinking mBlinking;

    // amimation stuff
    public Semaphore mAnimationLaunchControl = new Semaphore(1);
    public AnimationSchedulerReeti mAnimationSchedulerReeti;
    private final List<AnimationListener> mAnimationListeners = new CopyOnWriteArrayList<AnimationListener>();

    // body parts
    public Head mHead;
    public LeftEyelid mLeftEyelid;
    public LeftEye mLeftEye;
    public RightEye mRightEye;
    public LeftEar mLeftEar;
    public RightEar mRightEar;
    public RightEyelid mRightEyelid;
    public LeftCheek mLeftCheek;
    public RightCheek mRightCheek;
    public Mouth mMouth;
    public MouthLeftCorner mMouthLeftCorner;
    public MouthRightCorner mMouthRightCorner;
    public MouthUpperLip mMouthUpperLip;
    public MouthDownLip mMouthDownLip;
    public Neck mNeck;
    public Body mBody;
    // environment
    public SpeechBubbleFX mSpeechBubble;
    private StageRoom stageController;
    // logging
    public final Logger mLogger = Logger.getAnonymousLogger();
    // id
    private long mID = 0;

    //Movement
    private double mUpperLipOldPos = 0;
    private double mDownLipOldPos = 20;
    private double mLeftCornerOldPos = 8;
    private double mRightCornerOldPos = 8;
    private double mLeftEyelidOldPos = 100;
    private double mRightEyelidOldPos = 100;
    private double mLeftEye_X_OldPos = 40;
    private double mLeftEye_Y_OldPos = 42;
    private double mRightEye_X_OldPos = 60;
    private double mRightEye_Y_OldPos = 42;
    private double mLeftEarOldPos = 80;
    private double mRightEarOldPos = 80;
    private double mNeckRotatOldPos = 50;
    private double mNeckPanOldPos = 50;
    private double mNeckTiltOldPos = 50;

    public Reeti(String name, Gender.TYPE gender, float scale, Dimension size)
    {
        mSize = size;
        mScale = scale;
        isFullScreen = true;
        mName = name;
        mType = gender;

        mHead = new Head(this);
        mLeftEyelid = new LeftEyelid(mHead);
        mLeftEye = new LeftEye(mHead);
        mRightEye = new RightEye(mHead);
        mLeftEar = new LeftEar(mHead);
        mRightEar = new RightEar(mHead);
        mRightEyelid = new RightEyelid(mHead);
        mLeftCheek = new LeftCheek(mHead);
        mRightCheek = new RightCheek(mHead);
        mMouth = new Mouth(mHead);
        mMouthLeftCorner = new MouthLeftCorner(mMouth);
        mMouthRightCorner = new MouthRightCorner(mMouth);
        mMouthUpperLip = new MouthUpperLip(mMouth);
        mMouthDownLip = new MouthDownLip(mMouth);
        mNeck = new Neck(mHead);
        mBody = new Body(mNeck);

        mSpeechBubble = new SpeechBubbleFX(mHead);
        init();
        this.addAllParts();
        update();
    }

    public Reeti(String name, Gender.TYPE gender, float scale, double height)
    {
        mScale = scale;
        isFullScreen = false;
        this.stageHeight = height;
        mName = name;
        mType = gender;

        mHead = new Head(this);
        mLeftEyelid = new LeftEyelid(mHead);
        mLeftEye = new LeftEye(mHead);
        mRightEye = new RightEye(mHead);
        mLeftEar = new LeftEar(mHead);
        mRightEar = new RightEar(mHead);
        mRightEyelid = new RightEyelid(mHead);
        mLeftCheek = new LeftCheek(mHead);
        mRightCheek = new RightCheek(mHead);
        mMouth = new Mouth(mHead);
        mMouthLeftCorner = new MouthLeftCorner(mMouth);
        mMouthRightCorner = new MouthRightCorner(mMouth);
        mMouthUpperLip = new MouthUpperLip(mMouth);
        mMouthDownLip = new MouthDownLip(mMouth);
        mNeck = new Neck(mHead);
        mBody = new Body(mNeck);

        mSpeechBubble = new SpeechBubbleFX(mHead);
        init();
        this.addAllParts();
        update();
    }

    public Reeti(String name, Gender.TYPE gender)
    {
        mName = name;
        mType = gender;

        isFullScreen = true;
        mHead = new Head(this);
        mLeftEyelid = new LeftEyelid(mHead);
        mLeftEye = new LeftEye(mHead);
        mRightEye = new RightEye(mHead);
        mLeftEar = new LeftEar(mHead);
        mRightEar = new RightEar(mHead);
        mRightEyelid = new RightEyelid(mHead);
        mLeftCheek = new LeftCheek(mHead);
        mRightCheek = new RightCheek(mHead);
        mMouth = new Mouth(mHead);
        mMouthLeftCorner = new MouthLeftCorner(mMouth);
        mMouthRightCorner = new MouthRightCorner(mMouth);
        mMouthUpperLip = new MouthUpperLip(mMouth);
        mMouthDownLip = new MouthDownLip(mMouth);
        mNeck = new Neck(mHead);
        mBody = new Body(mNeck);

        mSpeechBubble = new SpeechBubbleFX(mHead);
        init();
        this.addAllParts();
        update();
    }

    private void init()
    {
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

        mAnimationSchedulerReeti = new AnimationSchedulerReeti(this);
        mAnimationSchedulerReeti.start();
    }

    public void addListener(AnimationListener al)
    {
        mAnimationListeners.add(al);
    }

    public void removeListener(AnimationListener al)
    {
        synchronized (mAnimationListeners)
        {
            if (mAnimationListeners.contains(al))
            {
                mAnimationListeners.remove(al);
            }
        }
    }

    public void notifyListeners(String animationId)
    {
        synchronized (mAnimationListeners)
        {
            mAnimationListeners.stream().forEach((al) ->
            {
                al.update(animationId);
            });
        }
    }

    public String getID()
    {
        return (new StringBuffer()).append(mName).append(" AnimationSwing ").append(mID++).toString();
    }

    public AnimationReeti doEventFeedbackAnimation(String name, int duration, WordTimeMarkSequence wts, boolean block)
    {
        EventAnimationReeti a = AnimationLoaderReeti.getInstance().loadEventAnimation(this, name, duration, block);

        a.setParameter(wts);

        try
        {
            mAnimationLaunchControl.acquire();
            a.start();
        }
        catch (InterruptedException ex)
        {
            mLogger.severe(ex.getMessage());
        }

        return a;
    }

    @Override
    public StageRoom getStageController()
    {
        return stageController;
    }

    @Override
    public void setStageController(StageRoom s)
    {
        stageController = s;
    }

    @Override
    public void setShowName(boolean show)
    {

    }

    @Override
    public boolean isShowName()
    {
        return false;
    }

    @Override
    public void endAnimationScheduler()
    {

    }

    @Override
    public Gender.TYPE getType()
    {
        return null;
    }

    public AnimationReeti doAnimation(String name, int duration, boolean block)
    {
        return doAnimation(name, duration, "", block);
    }

    public AnimationReeti doAnimation(String name, int frequent, int actionDuration, boolean block)
    {
        AnimationReeti a = AnimationLoaderReeti.getInstance().loadAnimation(this, name, frequent, actionDuration, block);

        try
        {
            mAnimationLaunchControl.acquire();
            a.start();
        }
        catch (InterruptedException ex)
        {
            mLogger.severe(ex.getMessage());
        }

        return a;
    }

    public AnimationReeti doAnimation(String name, Object param, boolean block)
    {
        return doAnimation(name, -1, param, block);
    }

    public AnimationReeti doAnimation(String name, boolean block)
    {
        return doAnimation(name, -1, "", block);
    }

    public AnimationReeti doAnimation(String name, int duration, Object param, boolean block)
    {
        AnimationReeti a = AnimationLoaderReeti.getInstance().loadAnimation(this, name, duration, block);

        a.setParameter(param); // this is for now only used by the Speech Bubble

        try
        {
            mAnimationLaunchControl.acquire();
            a.start();
        }
        catch (InterruptedException ex)
        {
            mLogger.severe(ex.getMessage());
        }

        return a;
    }

    public void playAnimation(AnimationReeti a)
    {
        try
        {
            mAnimationLaunchControl.acquire();
            a.start();
        }
        catch (InterruptedException ex)
        {
            mLogger.severe(ex.getMessage());
        }
    }

    public void update()
    {
        float mGeneralXTranslation;
        float mGeneralYTranslation;
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        double StickmanHeight = 500;
        Affine af = new Affine();
        int shiftFactor = (int) (StickmanHeight - (StickmanHeight * mScale));
        if (isFullScreen)
        {
            mGeneralYTranslation = (int) ((dim.getHeight() - StickmanHeight) + shiftFactor + 100);
            mGeneralXTranslation = 0;
        }
        else
        {
            mGeneralYTranslation = (int) ((this.stageHeight - StickmanHeight) + shiftFactor - 350);
            mGeneralXTranslation = 100;
        }
//        Scale s = new Scale(0.5, 0.5, 0.5, 50, 50, 50);
        af.appendTranslation(mGeneralXTranslation, mGeneralYTranslation);
        af.appendScale(mScale, mScale);
        this.getTransforms().clear();
        this.getTransforms().add(af);
//        this.getTransforms().add(af);
    }

    public void setScale(float scale)
    {
        mScale = scale;
    }

    private static class StickmanLogFormatter extends Formatter
    {

        @Override
        public String format(LogRecord record)
        {
            return ((new StringBuffer()).append(record.getLevel()).append(": ").append(record.getMessage())
                    .append("\n")).toString();
        }
    }

    private void addAllParts()
    {
        this.getChildren().addAll(mNeck, mHead, mBody, mSpeechBubble);
    }

    /**
     *
     * @param color red, green, lightGreen, blue, darkBlue, turquoise, yellow, violer, white, swop
     *
     */
    public void setLedColor(String color)
    {
        Color ledColor = checkColor(color);
        if (ledColor.equals(Color.BLACK))
        {
            ledOFF("B");
        }
        else
        {
            ledON(ledColor, ledColor, ledColor, 0.3f, 0.9f, 0.1f, "B");
        }
    }

    /**
     *
     * @param color red, green, lightGreen, blue, darkBlue, turquoise, yellow, violer, white, swop
     * @param led left, right, both
     */
    public void setLedColor(String color, LED led)
    {
        Color ledColor = checkColor(color);
        if (ledColor.equals(Color.BLACK))
        {
            switch (led)
            {
                case LEFTLED:
                    ledOFF("L");
                    break;
                case RIGHTLED:
                    ledOFF("R");
                    break;
                default:
                    ledOFF("B");
                    break;
            }
        }
        else
        {
            switch (led)
            {
                case LEFTLED:
                    ledON(ledColor, ledColor, ledColor, 0.3f, 0.9f, 0.1f, "L");
                    break;
                case RIGHTLED:
                    ledON(ledColor, ledColor, ledColor, 0.3f, 0.9f, 0.1f, "R");
                    break;
                default:
                    ledON(ledColor, ledColor, ledColor, 0.3f, 0.9f, 0.1f, "B");
                    break;
            }
        }

    }

    public void setLedColor(Color color, LED led)
    {
        switch (led)
        {
            case LEFTLED:
                ledON(color, color, color, 0.3f, 0.9f, 0.1f, "L");
                break;
            case RIGHTLED:
                ledON(color, color, color, 0.3f, 0.9f, 0.1f, "R");
                break;
            default:
                ledON(color, color, color, 0.3f, 0.9f, 0.1f, "B");
                break;
        }
    }

    public void ledON(Color color1, Color color2, Color color3,
            float intensityForColor1,
            float intensityForColor2,
            float intensitiForColor3,
            String cheek)
    {

        int size = mLeftCheek.getSize();

        InnerShadow ledOnShadow = new InnerShadow(BlurType.TWO_PASS_BOX, color3, 0.05 * size, intensityForColor1, 0, 0);
        ledOnShadow.setInput(new DropShadow(BlurType.TWO_PASS_BOX, color2, 0.05 * size, intensityForColor2, 0, 0));

        RadialGradient highlightGradient = new RadialGradient(0, 0,
                0.3 * size, 0.3 * size,
                0.29 * size,
                false, CycleMethod.NO_CYCLE,
                new Stop(intensitiForColor3, color1),
                new Stop(1.0, Color.TRANSPARENT));

        if (cheek.equalsIgnoreCase("L"))
        {
            mLeftCheek.getLed().setEffect(ledOnShadow);
            mLeftCheek.getLed().setFill(highlightGradient);
            mLeftCheek.getLedGroup().setVisible(true);
        }
        else if (cheek.equalsIgnoreCase("R"))
        {
            mRightCheek.getLed().setEffect(ledOnShadow);
            mRightCheek.getLed().setFill(highlightGradient);
            mRightCheek.getLedGroup().setVisible(true);
        }
        else if (cheek.equalsIgnoreCase("B"))
        {
            mLeftCheek.getLed().setEffect(ledOnShadow);
            mLeftCheek.getLed().setFill(highlightGradient);
            mRightCheek.getLed().setEffect(ledOnShadow);
            mRightCheek.getLed().setFill(highlightGradient);
            mLeftCheek.getLedGroup().setVisible(true);
            mRightCheek.getLedGroup().setVisible(true);
        }
    }

    public void ledOFF(String cheek)
    {
        if (cheek.equalsIgnoreCase("R"))
        {
            mRightCheek.getLedGroup().setVisible(false);
        }
        else if (cheek.equalsIgnoreCase("L"))
        {
            mLeftCheek.getLedGroup().setVisible(false);
        }
        else if (cheek.equalsIgnoreCase("B"))
        {
            mRightCheek.getLedGroup().setVisible(false);
            mLeftCheek.getLedGroup().setVisible(false);
        }
    }

    /**
     *
     * @param pos a int between 0 and 100 (default value is 50)
     *
     */

    public void rightLC(int pos, double...duration)
    {
        double dur = (duration.length==0)? 500 : duration[0];
        if (pos > 100)
        {
            pos = 100;
        }
        pos = (pos * 16) / 100;
        double distance = mRightCornerOldPos - pos;
        this.mMouthRightCorner.setRightCornerRegulator(distance);
        mRightCornerOldPos = pos;
        AnimationReeti a = AnimationLoaderReeti.getInstance().loadAnimation(this, "RightLC", (int) dur, pos, false);
        try
        {
            mAnimationLaunchControl.acquire();
            a.start();
        }
        catch (InterruptedException ex)
        {
            mLogger.severe(ex.getMessage());
        }
    }

    /**
     *
     * @param pos a int between 0 and 100 (default value is 50)
     */
    public void leftLC(int pos, double...duration)
    {
        if(pos == -1)
            return;
        double dur = (duration.length==0)? 500 : duration[0];
        if (pos > 100)
        {
            pos = 100;
        }
        pos = (pos * 16) / 100;
        double distance = mLeftCornerOldPos - pos;
        this.mMouthLeftCorner.setLeftCornerRegulator(distance);
        mLeftCornerOldPos = pos;
        AnimationReeti a = AnimationLoaderReeti.getInstance().loadAnimation(this, "LeftLC", (int)dur, pos, false);
        try
        {
            mAnimationLaunchControl.acquire();
            a.start();
        }
        catch (InterruptedException ex)
        {
            mLogger.severe(ex.getMessage());
        }
    }

    /**
     *
     * @param pos a int between 0 and 100 (default value is 0)
     */
    public void topLip(int pos, double...duration)
    {
        if(pos == -1)
            return;
        double dur = (duration.length==0)? 500 : duration[0];
        if (pos > 100)
        {
            pos = 100;
        }

        pos = (pos * 25) / 100;

        double distance = mUpperLipOldPos - pos;
        this.mMouthUpperLip.setUpperLipRegulator(distance);
        mUpperLipOldPos = pos;

        AnimationReeti a = AnimationLoaderReeti.getInstance().loadAnimation(this, "UpperLip", (int) dur, pos, false);
        try
        {
            mAnimationLaunchControl.acquire();
            a.start();
        }
        catch (InterruptedException ex)
        {
            mLogger.severe(ex.getMessage());
        }
    }

    /**
     *
     * @param pos a int between 0 and 100 (default value is 100)
     */
    public void bottomLip(int pos, double...duration)
    {
        if(pos == -1)
            return;
        double dur = (duration.length==0)? 500 : duration[0];
        if (pos > 100)
        {
            pos = 100;
        }

        pos = (pos * 20) / 100;

        double distance = pos - mDownLipOldPos;
        this.mMouthDownLip.setDownLipRegulator(-distance);
        mDownLipOldPos = pos;

        AnimationReeti a = AnimationLoaderReeti.getInstance().loadAnimation(this, "DownLip", (int) dur, pos, false);
        try
        {
            mAnimationLaunchControl.acquire();
            a.start();
        }
        catch (InterruptedException ex)
        {
            mLogger.severe(ex.getMessage());
        }
    }

    /**
     *
     * @param pos a int between 0 and 100 (default value is 30)
     */
    public void leftEyeTilt(int pos, double...duration)
    {
        if(pos == -1)
            return;
        double dur = (duration.length==0)? 500 : duration[0];

        if (pos > 100)
            pos = 100;
        else if(pos < 20)
            pos = 20;

        double rot = mLeftEye_Y_OldPos - pos;
        mLeftEye_Y_OldPos = pos;

        AnimationReeti a = AnimationLoaderReeti.getInstance().loadAnimation(this, "LeftEye_X", (int) dur, (int) rot, false);
        try
        {
            mAnimationLaunchControl.acquire();
            a.start();
        }
        catch (InterruptedException ex)
        {
            mLogger.severe(ex.getMessage());
        }
    }

    /**
     *
     * @param pos a int between 0 and 100 (default value is 40)
     */
    public void leftEyePan(int pos, double...duration)
    {
        if(pos == -1)
            return;
        double dur = (duration.length==0)? 500 : duration[0];
        if (pos > 100)
        {
            pos = 100;
        }
        double rot = mLeftEye_X_OldPos - pos;
        mLeftEye_X_OldPos = pos;

        AnimationReeti a = AnimationLoaderReeti.getInstance().loadAnimation(this, "LeftEye_Y", (int) dur, (int) rot, false);
        try
        {
            mAnimationLaunchControl.acquire();
            a.start();
        }
        catch (InterruptedException ex)
        {
            mLogger.severe(ex.getMessage());
        }
    }

    /**
     *
     * @param pos a int between 0 and 100 (default value is 30)
     */
    public void rightEyeTilt(int pos, double...duration)
    {
        if(pos == -1)
            return;
        double dur = (duration.length==0)? 500 : duration[0];

        if (pos > 100)
            pos = 100;
        else if(pos < 23)
            pos = 23;

        double rot = mRightEye_Y_OldPos - pos;
        mRightEye_Y_OldPos = pos;

        AnimationReeti a = AnimationLoaderReeti.getInstance().loadAnimation(this, "RightEye_X", (int) dur, (int) rot, false);
        try
        {
            mAnimationLaunchControl.acquire();
            a.start();
        }
        catch (InterruptedException ex)
        {
            mLogger.severe(ex.getMessage());
        }
    }

    /**
     *
     * @param pos a int between 0 and 100 (default value is 60)
     */
    public void rightEyePan(int pos, double...duration)
    {
        if(pos == -1)
            return;
        double dur = (duration.length==0)? 500 : duration[0];
        if (pos > 100)
        {
            pos = 100;
        }
        double rot = mRightEye_X_OldPos - pos;
        mRightEye_X_OldPos = pos;

        AnimationReeti a = AnimationLoaderReeti.getInstance().loadAnimation(this, "RightEye_Y", (int) dur, (int) rot, false);
        try
        {
            mAnimationLaunchControl.acquire();
            a.start();
        }
        catch (InterruptedException ex)
        {
            mLogger.severe(ex.getMessage());
        }
    }

    /**
     *
     * @param pos a int between 0 and 100 (default value is 100)
     */
    public void leftEyeLid(int pos, double...duration)
    {
        if(pos == -1)
            return;
        double dur = (duration.length==0)? 500 : duration[0];
        if (pos > 100)
        {
            pos = 100;
        }
        double rot = mLeftEyelidOldPos - pos;
        mLeftEyelidOldPos = pos;

        AnimationReeti a = AnimationLoaderReeti.getInstance().loadAnimation(this, "BlinkLeftEyelid", (int)dur, (int) rot, false);
        try
        {
            mAnimationLaunchControl.acquire();
            a.start();
        }
        catch (InterruptedException ex)
        {
            mLogger.severe(ex.getMessage());
        }
    }

    /**
     *
     * @param pos a int between 0 and 100 (default value is 100)
     */
    public void rightEyeLid(int pos, double...duration)
    {
        if(pos == -1)
            return;
        double dur = (duration.length==0)? 500 : duration[0];
        if (pos > 100)
        {
            pos = 100;
        }
        double rot = mRightEyelidOldPos - pos;
        mRightEyelidOldPos = pos;

        AnimationReeti a = AnimationLoaderReeti.getInstance().loadAnimation(this, "BlinkRightEyelid", (int) dur, (int) rot, false);
        try
        {
            mAnimationLaunchControl.acquire();
            a.start();
        }
        catch (InterruptedException ex)
        {
            mLogger.severe(ex.getMessage());
        }
    }

    /**
     *
     * @param pos a int between 0 and 100 (default value is 50)
     */
    public void leftEar(int pos, double...duration)
    {
        if(pos == -1)
            return;
        double dur = (duration.length==0)? 500 : duration[0];
        if (pos > 100)
        {
            pos = 100;
        }
        double rot = mLeftEarOldPos - pos;
        mLeftEarOldPos = pos;

        AnimationReeti a = AnimationLoaderReeti.getInstance().loadAnimation(this, "LeftEarMovement", (int) dur, (int) rot, false);
        try
        {
            mAnimationLaunchControl.acquire();
            a.start();
        }
        catch (InterruptedException ex)
        {
            mLogger.severe(ex.getMessage());
        }
    }

    /**
     *
     * @param pos a int between 0 and 100 (default value is 50)
     */
    public void rightEar(int pos, double...duration)
    {
        if(pos == -1)
            return;
        double dur = (duration.length==0)? 500 : duration[0];
        if (pos > 100)
        {
            pos = 100;
        }
        double rot = mRightEarOldPos - pos;
        mRightEarOldPos = pos;

        AnimationReeti a = AnimationLoaderReeti.getInstance().loadAnimation(this, "RightEarMovement", (int) dur, (int) -rot, false);
        try
        {
            mAnimationLaunchControl.acquire();
            a.start();
        }
        catch (InterruptedException ex)
        {
            mLogger.severe(ex.getMessage());
        }
    }

    /**
     *
     * @param pos a int between 0 and 100 (default value is 50)
     */
    public void neckRotat(int pos, double...duration)
    {
        if(pos == -1)
            return;
        double dur = (duration.length==0)? 500 : duration[0];
        if (pos > 100)
        {
            pos = 100;
        }
        double rot = mNeckRotatOldPos - pos;
        mNeckRotatOldPos = pos;

        AnimationReeti a = AnimationLoaderReeti.getInstance().loadAnimation(this, "NeckRotation", (int) dur, (int) rot, false);
        try
        {
            mAnimationLaunchControl.acquire();
            a.start();
        }
        catch (InterruptedException ex)
        {
            mLogger.severe(ex.getMessage());
        }
    }

    /**
     *
     * @param pos a int between 0 and 100 (default value is 50)
     */
    public void neckTilt(int pos, double...duration)
    {
        if(pos == -1)
        return;

        double dur = (duration.length==0)? 500 : duration[0];
        if (pos > 100)
        {
            pos = 100;
        }
        
        double rot = mNeckPanOldPos - pos;
        rot = (rot * 40) / 100;
        mNeckPanOldPos = pos;

        AnimationReeti a = AnimationLoaderReeti.getInstance().loadAnimation(this, "NeckPan", (int) dur, (int) rot, false);
        try
        {
            mAnimationLaunchControl.acquire();
            a.start();
        }
        catch (InterruptedException ex)
        {
            mLogger.severe(ex.getMessage());
        }
    }

    /**
     *
     * @param pos a int between 0 and 100 (default value is 50)
     */
    public void neckPan(int pos, double...duration)
    {
        if(pos == -1)
            return;
        double dur = (duration.length==0)? 500 : duration[0];
        if (pos > 100)
        {
            pos = 100;
        }
        double rot = mNeckTiltOldPos - pos;
        rot = (rot * 40) / 100;
        mNeckTiltOldPos = pos;

        AnimationReeti a = AnimationLoaderReeti.getInstance().loadAnimation(this, "NeckTilt", (int) dur, (int) -rot, false);
        try
        {
            mAnimationLaunchControl.acquire();
            a.start();
        }
        catch (InterruptedException ex)
        {
            mLogger.severe(ex.getMessage());
        }
    }

    public void defaultPose()
    {
        AnimationReeti a = AnimationLoaderReeti.getInstance().loadAnimation(this, "Default", 100, false);
        try
        {
            mAnimationLaunchControl.acquire();
            a.start();
        }
        catch (InterruptedException ex)
        {
            mLogger.severe(ex.getMessage());
        }
    }

    private Color checkColor(String color)
    {
        Color ledColor = null;
        switch (color)
        {
            case "red":
                ledColor = Color.RED;
                break;
            case "green":
                ledColor = Color.GREEN;
                break;
            case "lightGreen":
                ledColor = Color.LIGHTGREEN;
                break;
            case "blue":
                ledColor = Color.BLUE;
                break;
            case "darkBlue":
                ledColor = Color.DARKBLUE;
                break;
            case "turquoise":
                ledColor = Color.TURQUOISE;
                break;
            case "yellow":
                ledColor = Color.YELLOW;
                break;
            case "violet":
                ledColor = Color.VIOLET;
                break;
            case "white":
                ledColor = Color.WHITE;
                break;
            case "stop":
                ledColor = Color.BLACK;
                break;
        }
        return ledColor;
    }

    public double getmUpperLipOldPos()
    {
        return mUpperLipOldPos;
    }

    public double getmLeftCornerOldPos()
    {
        return mLeftCornerOldPos;
    }

    public double getmLeftEyelidOldPos()
    {
        return mLeftEyelidOldPos;
    }

    public double getmRightEyelidOldPos()
    {
        return mRightEyelidOldPos;
    }

    public double getmLeftEye_X_OldPos()
    {
        return mLeftEye_X_OldPos;
    }

    public double getmLeftEye_Y_OldPos()
    {
        return mLeftEye_Y_OldPos;
    }

    public double getmRightEye_X_OldPos()
    {
        return mRightEye_X_OldPos;
    }

    public double getmRightEye_Y_OldPos()
    {
        return mRightEye_Y_OldPos;
    }

    public double getmLeftEarOldPos()
    {
        return mLeftEarOldPos;
    }

    public double getmRightEarOldPos()
    {
        return mRightEarOldPos;
    }

    public double getmNeckRotatOldPos()
    {
        return mNeckRotatOldPos;
    }

    public double getmNeckPanOldPos()
    {
        return mNeckPanOldPos;
    }

    public double getmNeckTiltOldPos()
    {
        return mNeckTiltOldPos;
    }

    public double getmDownLipOldPos()
    {
        return mDownLipOldPos;
    }

    public double getmRightCornerOldPos()
    {
        return mRightCornerOldPos;
    }
    
    
    
    
}
