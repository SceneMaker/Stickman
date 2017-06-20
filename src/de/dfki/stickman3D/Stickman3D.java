package de.dfki.stickman3D;

import de.dfki.stickman3D.body.*;
import de.dfki.stickman3D.body.Head3D;
import de.dfki.action.sequence.WordTimeMarkSequence;
import de.dfki.common.Gender;
import de.dfki.common.interfaces.StageRoom;
import de.dfki.common.interfaces.Stickman;
import de.dfki.stickman3D.animation.environment.Blinking;
import de.dfki.stickman3D.animation.environment.Breathing;
import de.dfki.stickman3D.animation.environment.IdleBehavior;
import de.dfki.stickman3D.animationlogic.*;
import de.dfki.stickmanSwing.animationlogic.listener.AnimationListener;
import de.dfki.stickman3D.animationlogic.Animation3D;
import de.dfki.stickman3D.animationlogic.EventAnimation3D;
import de.dfki.stickman3D.environment.SpeechBubble3D;
import javafx.scene.effect.InnerShadow;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.transform.Affine;

import java.awt.*;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Semaphore;
import java.util.logging.ConsoleHandler;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

/**
 * @author Beka Aptsiauri
 *         <p>
 *         This work is inspired by the stickmans drawn by Sarah Johnson
 *         (www.sarah-johnson.com) in the Valentine music video from Kina Grannis shot
 *         by Ross Ching in 2012
 */
public class Stickman3D extends Pane implements Stickman
{
    // general stuff
    public enum ORIENTATION
    {
        FRONT, LEFT, RIGHT
    }

    public Gender.TYPE mType = Gender.TYPE.FEMALE;
    public String mName = "StickmanSwing";
    public ORIENTATION mOrientation = ORIENTATION.FRONT;
    public float mScale = 1.0f;
    private Text nameText = new Text();
    private double stageHeight;
    public boolean isFullScreen = false;
    public static String sbackground = null;
    private static Dimension mDefaultSize = new Dimension(300, 800);
    public  Dimension mSize = new Dimension(mDefaultSize);

    //steuert leaveSpeed von GoDown und ComeUp 
    public double leaveSpeed = 0;
    // leaving
    public boolean starShowControler = false;
    // appear at the same time or not
    public boolean fadeControler = false;
    // character to fade out or fade in.
    // true: Fade out
    public boolean setCharacterInvisible = false; // Added by Robbie, to control
    // the character to fade
    // out.
    // True: visible False:invisible
    public double mWobble = 0;
    public Boolean mIdleRun = false; // the shared variable to decide the while
    // loop in IdleBehavior break or not
    public IdleBehavior mIdleBehavior;
    public Breathing mBreathing;
    public Blinking mBlinking;
    // amimation stuff
    public Semaphore mAnimationLaunchControl = new Semaphore(1);
    public AnimationScheduler3D mAnimationSchedulerFX;
    private final List<AnimationListener> mAnimationListeners = new CopyOnWriteArrayList<AnimationListener>();

    // body parts
    public Head3D mHead;
    public Nose3D mNose;
    public MaleHair3D mMaleHair;
    public FemaleHair3D mFemaleHair;
    public LeftEyebrow3D mLeftEyebrow;
    public LeftEye3D mLeftEye;
    public LeftEar3D mLeftEar;
    public RightEar3D mRightEar;
    public RightEyebrow3D mRightEyebrow;
    public RightEye3D mRightEye;
    public Mouth3D mMouth;
    public Neck3D mNeck;
    public FaceWrinkle3D mFaceWrinkle; // added by Robbie FaceWrinkle
    public UpperBody3D mUpperBody;
    public DownBody3D mDownBody;
    public LeftUpperArm3D mLeftUpperArm;
    public LeftForeArm3D mLeftForeArm;
    public LeftWrist3D mLeftWrist;
    public LeftFinger1 mLeftFinger1;
    public LeftFinger2 mLeftFinger2;
    public LeftFinger3 mLeftFinger3;
    public LeftFinger4 mLeftFinger4;
    public RightUpperArm3D mRightUpperArm;
    public RightForeArm3D mRightForeArm;
    public RightWrist3D mRightWrist;
    public RightFinger1 mRightFinger1;
    public RightFinger2 mRightFinger2;
    public RightFinger3 mRightFinger3;
    public RightFinger4 mRightFinger4;
    public LeftUpperLeg3D mLeftUpperLeg;
    public LeftForeLeg3D mLeftForeLeg;
    public LeftFoot3D mLeftFoot;
    public Stars3D mStars;
    public RightUpperLeg3D mRightUpperLeg;
    public RightForeLeg3D mRightForeLeg;
    public RightFoot3D mRightFoot;
    public UpperBodyAndHead3D mUpperBodyAndHead;
    // environment
    public SpeechBubble3D mSpeechBubble;
    private StageRoom stageController;
    // logging
    public final Logger mLogger = Logger.getAnonymousLogger();
    // id
    private long mID = 0;

    public Stickman3D(String name, Gender.TYPE gender, float scale, Dimension size)
    {
        mSize = size;
        mScale = scale;
        isFullScreen = true;
        mName = name;
        mType = gender;

        mHead = new Head3D(this);
        if (gender == Gender.TYPE.MALE)
            mMaleHair = new MaleHair3D(this);
        else
            mFemaleHair = new FemaleHair3D(this);
        mLeftEyebrow = new LeftEyebrow3D(mHead);
        mLeftEye = new LeftEye3D(mHead);
        mLeftEar = new LeftEar3D(mHead);
        mRightEar = new RightEar3D(mHead);
        mRightEyebrow = new RightEyebrow3D(mHead);
        mRightEye = new RightEye3D(mHead);
        mNose = new Nose3D(mHead);
        mMouth = new Mouth3D(mHead);
        mFaceWrinkle = new FaceWrinkle3D(mHead);
        mNeck = new Neck3D(mHead);
        mUpperBody = new UpperBody3D(mNeck);
        mDownBody = new DownBody3D(mUpperBody);
        mLeftUpperArm = new LeftUpperArm3D(mUpperBody);
        mLeftForeArm = new LeftForeArm3D(mLeftUpperArm);
        mLeftWrist = new LeftWrist3D(mLeftForeArm);
        mLeftFinger1 = new LeftFinger1(mLeftWrist);
        mLeftFinger2 = new LeftFinger2(mLeftWrist);
        mLeftFinger3 = new LeftFinger3(mLeftWrist);
        mLeftFinger4 = new LeftFinger4(mLeftWrist);
        mRightUpperArm = new RightUpperArm3D(mUpperBody);
        mRightForeArm = new RightForeArm3D(mRightUpperArm);
        mRightWrist = new RightWrist3D(mRightForeArm);
        mRightFinger1 = new RightFinger1(mRightWrist);
        mRightFinger2 = new RightFinger2(mRightWrist);
        mRightFinger3 = new RightFinger3(mRightWrist);
        mRightFinger4 = new RightFinger4(mRightWrist);
        mLeftUpperLeg = new LeftUpperLeg3D(mDownBody);
        mLeftForeLeg = new LeftForeLeg3D(mLeftUpperLeg);
        mLeftFoot = new LeftFoot3D(mLeftForeLeg);
        mStars = new Stars3D(mUpperBody);
        mRightUpperLeg = new RightUpperLeg3D(mDownBody);
        mRightForeLeg = new RightForeLeg3D(mRightUpperLeg);
        mRightFoot = new RightFoot3D(mRightForeLeg);
        mUpperBodyAndHead = new UpperBodyAndHead3D(mHead, mUpperBody, mNeck);

        mSpeechBubble = new SpeechBubble3D(mHead);
        init();
        this.addAllParts();
        update();
    }

    public Stickman3D(String name, Gender.TYPE gender, float scale, double height)
    {
        mScale = scale;
        isFullScreen = false;
        this.stageHeight = height;
        mName = name;
        mType = gender;

        mHead = new Head3D(this);
        if (gender == Gender.TYPE.MALE)
            mMaleHair = new MaleHair3D(this);
        else
            mFemaleHair = new FemaleHair3D(this);
        mLeftEyebrow = new LeftEyebrow3D(mHead);
        mLeftEye = new LeftEye3D(mHead);
        mLeftEar = new LeftEar3D(mHead);
        mRightEar = new RightEar3D(mHead);
        mRightEyebrow = new RightEyebrow3D(mHead);
        mRightEye = new RightEye3D(mHead);
        mNose = new Nose3D(mHead);
        mMouth = new Mouth3D(mHead);
        mFaceWrinkle = new FaceWrinkle3D(mHead);
        mNeck = new Neck3D(mHead);
        mUpperBody = new UpperBody3D(mNeck);
        mDownBody = new DownBody3D(mUpperBody);
        mLeftUpperArm = new LeftUpperArm3D(mUpperBody);
        mLeftForeArm = new LeftForeArm3D(mLeftUpperArm);
        mLeftWrist = new LeftWrist3D(mLeftForeArm);
        mLeftFinger1 = new LeftFinger1(mLeftWrist);
        mLeftFinger2 = new LeftFinger2(mLeftWrist);
        mLeftFinger3 = new LeftFinger3(mLeftWrist);
        mLeftFinger4 = new LeftFinger4(mLeftWrist);
        mRightUpperArm = new RightUpperArm3D(mUpperBody);
        mRightForeArm = new RightForeArm3D(mRightUpperArm);
        mRightWrist = new RightWrist3D(mRightForeArm);
        mRightFinger1 = new RightFinger1(mRightWrist);
        mRightFinger2 = new RightFinger2(mRightWrist);
        mRightFinger3 = new RightFinger3(mRightWrist);
        mRightFinger4 = new RightFinger4(mRightWrist);
        mLeftUpperLeg = new LeftUpperLeg3D(mDownBody);
        mLeftForeLeg = new LeftForeLeg3D(mLeftUpperLeg);
        mLeftFoot = new LeftFoot3D(mLeftForeLeg);
        mStars = new Stars3D(mUpperBody);
        mRightUpperLeg = new RightUpperLeg3D(mDownBody);
        mRightForeLeg = new RightForeLeg3D(mRightUpperLeg);
        mRightFoot = new RightFoot3D(mRightForeLeg);
        mUpperBodyAndHead = new UpperBodyAndHead3D(mHead, mUpperBody, mNeck);

        mSpeechBubble = new SpeechBubble3D(mHead);
        init();
        this.addAllParts();
        update();
    }

    public Stickman3D(String name, Gender.TYPE gender)
    {
        mName = name;
        mType = gender;

        isFullScreen = true;
        mHead = new Head3D(this);
        if (gender == Gender.TYPE.MALE)
            mMaleHair = new MaleHair3D(this);
        else
            mFemaleHair = new FemaleHair3D(this);
        mLeftEyebrow = new LeftEyebrow3D(mHead);
        mLeftEye = new LeftEye3D(mHead);
        mLeftEar = new LeftEar3D(mHead);
        mRightEar = new RightEar3D(mHead);
        mRightEyebrow = new RightEyebrow3D(mHead);
        mRightEye = new RightEye3D(mHead);
        mNose = new Nose3D(mHead);
        mMouth = new Mouth3D(mHead);
        mFaceWrinkle = new FaceWrinkle3D(mHead);
        mNeck = new Neck3D(mHead);
        mUpperBody = new UpperBody3D(mNeck);
        mDownBody = new DownBody3D(mUpperBody);
        mLeftUpperArm = new LeftUpperArm3D(mUpperBody);
        mLeftForeArm = new LeftForeArm3D(mLeftUpperArm);
        mLeftWrist = new LeftWrist3D(mLeftForeArm);
        mLeftFinger1 = new LeftFinger1(mLeftWrist);
        mLeftFinger2 = new LeftFinger2(mLeftWrist);
        mLeftFinger3 = new LeftFinger3(mLeftWrist);
        mLeftFinger4 = new LeftFinger4(mLeftWrist);
        mRightUpperArm = new RightUpperArm3D(mUpperBody);
        mRightForeArm = new RightForeArm3D(mRightUpperArm);
        mRightWrist = new RightWrist3D(mRightForeArm);
        mRightFinger1 = new RightFinger1(mRightWrist);
        mRightFinger2 = new RightFinger2(mRightWrist);
        mRightFinger3 = new RightFinger3(mRightWrist);
        mRightFinger4 = new RightFinger4(mRightWrist);
        mLeftUpperLeg = new LeftUpperLeg3D(mDownBody);
        mLeftForeLeg = new LeftForeLeg3D(mLeftUpperLeg);
        mLeftFoot = new LeftFoot3D(mLeftForeLeg);
        mStars = new Stars3D(mUpperBody);
        mRightUpperLeg = new RightUpperLeg3D(mDownBody);
        mRightForeLeg = new RightForeLeg3D(mRightUpperLeg);
        mRightFoot = new RightFoot3D(mRightForeLeg);
        mUpperBodyAndHead = new UpperBodyAndHead3D(mHead, mUpperBody, mNeck);

        mSpeechBubble = new SpeechBubble3D(mHead);
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

        nameText.setEffect(is);
        nameText.setX(20);
        nameText.setY(100);
        nameText.setText(mName);
        nameText.setFill(Color.YELLOW);
        nameText.setFont(Font.font(null, FontWeight.BOLD, 30));

        if (this.mType == Gender.TYPE.MALE)
        {
            nameText.setTranslateX(-80);
            nameText.setTranslateY(350);
        } else
        {
            nameText.setTranslateX(-90);
            nameText.setTranslateY(350);
        }
        nameText.setTranslateZ(-120);

        ConsoleHandler ch = new ConsoleHandler();
        ch.setFormatter(new StickmanLogFormatter());

        mLogger.addHandler(ch);
        mLogger.setUseParentHandlers(false);

        mAnimationSchedulerFX = new AnimationScheduler3D(this);
        mAnimationSchedulerFX.start();
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

    public Animation3D doEventFeedbackAnimation(String name, int duration, WordTimeMarkSequence wts, boolean block)
    {
        EventAnimation3D a = AnimationLoader3D.getInstance().loadEventAnimation(this, name, duration, block);

        a.setParameter(wts);

        try
        {
            mAnimationLaunchControl.acquire();
            a.start();
        } catch (InterruptedException ex)
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

    public Animation3D doAnimation(String name, int duration, boolean block)
    {
        return doAnimation(name, duration, "", block);
    }

    public Animation3D doAnimation(String name, int frequent, int actionDuration, boolean block)
    {
        Animation3D a = AnimationLoader3D.getInstance().loadAnimation(this, name, frequent, actionDuration, block);

        try
        {
            mAnimationLaunchControl.acquire();
            a.start();
        } catch (InterruptedException ex)
        {
            mLogger.severe(ex.getMessage());
        }

        return a;
    }

    public Animation3D doAnimation(String name, Object param, boolean block)
    {
        return doAnimation(name, -1, param, block);
    }

    public Animation3D doAnimation(String name, boolean block)
    {
        return doAnimation(name, -1, "", block);
    }

    public Animation3D doAnimation(String name, int duration, Object param, boolean block)
    {
        Animation3D a = AnimationLoader3D.getInstance().loadAnimation(this, name, duration, block);

        a.setParameter(param); // this is for now only used by the Speech Bubble

        try
        {
            mAnimationLaunchControl.acquire();
            a.start();
        } catch (InterruptedException ex)
        {
            mLogger.severe(ex.getMessage());
        }

        return a;
    }

    public void playAnimation(Animation3D a)
    {
        try
        {
            mAnimationLaunchControl.acquire();
            a.start();
        } catch (InterruptedException ex)
        {
            mLogger.severe(ex.getMessage());
        }
    }

    public void update()
    {
        float mGeneralXTranslation;
        float mGeneralYTranslation;
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        double StickmanHeight = this.mHead.getHeadMeshView().getBoundsInParent().getHeight()
                + this.mNeck.getNeckMeshView().getBoundsInParent().getHeight()
                + this.mUpperBody.getBodyMeshView().getBoundsInParent().getHeight()
                + this.mDownBody.getBodyMeshView().getBoundsInParent().getHeight()
                + this.mLeftUpperLeg.getLeftUpperLegMesh().getBoundsInParent().getHeight()
                + this.mLeftForeLeg.getLeftForeLegMesh().getBoundsInParent().getHeight()
                + this.mLeftFoot.getLeftFootMeshView().getBoundsInParent().getHeight();

        Affine af = new Affine();
        int shiftFactor = (int) (StickmanHeight - (StickmanHeight * mScale));
        if (isFullScreen)
        {
            mGeneralYTranslation = (int) ((dim.getHeight() - StickmanHeight) + shiftFactor + 40);
            mGeneralXTranslation = 150;
        } else
        {
            mGeneralYTranslation = (int) ((this.stageHeight - StickmanHeight) + shiftFactor - 350);
            mGeneralXTranslation = 100;
        }
        af.appendTranslation(mGeneralXTranslation, mGeneralYTranslation);
        af.appendScale(mScale, mScale);
        af.appendTranslation(0, leaveSpeed); // Added by Robbie, GoDown
        this.getTransforms().clear();
        this.getTransforms().add(af);
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

        this.getChildren().addAll(
                mDownBody, mStars, mSpeechBubble, nameText, mUpperBodyAndHead);

    }

    public void hideAllPartsWithout(Pane p)
    {
        this.getChildren().forEach(child
                ->
        {
            if (!child.equals(p))
            {
                child.setVisible(false);
            }
        });
    }

    public void showAllParts()
    {
        this.getChildren().forEach(child
                ->
        {
            child.setVisible(true);
        });
    }
}
