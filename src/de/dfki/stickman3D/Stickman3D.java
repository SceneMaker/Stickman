package de.dfki.stickman3D;

import de.dfki.stickman3D.body.MaleHairFX;
import de.dfki.stickman3D.body.LeftWrist;
import de.dfki.stickman3D.body.FemaleHairFX;
import de.dfki.stickman3D.body.RightUpperLegFX;
import de.dfki.stickman3D.body.LeftFinger3;
import de.dfki.stickman3D.body.RightForeLegFX;
import de.dfki.stickman3D.body.RightEyeFX;
import de.dfki.stickman3D.body.LeftEar;
import de.dfki.stickman3D.body.LeftFinger1;
import de.dfki.stickman3D.body.LeftFootFX;
import de.dfki.stickman3D.body.RightFootFX;
import de.dfki.stickman3D.body.RightFinger1;
import de.dfki.stickman3D.body.RightForeArmFX;
import de.dfki.stickman3D.body.LeftFinger2;
import de.dfki.stickman3D.body.RightFinger4;
import de.dfki.stickman3D.body.LeftForeLegFX;
import de.dfki.stickman3D.body.LeftFinger4;
import de.dfki.stickman3D.body.HeadFX;
import de.dfki.stickman3D.body.RightFinger3;
import de.dfki.stickman3D.body.FaceWrinkleFX;
import de.dfki.stickman3D.body.StarsFX;
import de.dfki.stickman3D.body.DownBody;
import de.dfki.stickman3D.body.RightWrist;
import de.dfki.stickman3D.body.RightUpperArmFX;
import de.dfki.stickman3D.body.LeftUpperLegFX;
import de.dfki.stickman3D.body.NoseFX;
import de.dfki.stickman3D.body.MouthFX;
import de.dfki.stickman3D.body.UpperBody;
import de.dfki.stickman3D.body.LeftForeArmFX;
import de.dfki.stickman3D.body.RightEyebrowFX;
import de.dfki.stickman3D.body.LeftEyebrowFX;
import de.dfki.stickman3D.body.RightFinger2;
import de.dfki.stickman3D.body.LeftUpperArmFX;
import de.dfki.stickman3D.body.NeckFX;
import de.dfki.stickman3D.body.LeftEyeFX;
import de.dfki.stickman3D.body.RightEar;
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
import de.dfki.stickman3D.body.UpperBodyAndHead;
import de.dfki.stickman3D.environment.SpeechBubbleFX;
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
 *
 * @author Beka Aptsiauri
 *
 * This work is inspired by the stickmans drawn by Sarah Johnson
 * (www.sarah-johnson.com) in the Valentine music video from Kina Grannis shot
 * by Ross Ching in 2012
 *
 */
public class Stickman3D extends Pane implements Stickman {
    // general stuff

    public static enum ORIENTATION {
        FRONT, LEFT, RIGHT
    };

    static public final Color sFOREGROUND = Color.rgb(188, 188, 188, (128 * 100 / 255) / 100f);
    public Gender.TYPE mType = Gender.TYPE.FEMALE;
    public String mName = "StickmanSwing";
    public ORIENTATION mOrientation = ORIENTATION.FRONT;
    public float mScale = 1.0f;
    public boolean mShowBackground = true;
    public boolean mShowStage = true;
    public boolean mShowName = true;
    public float mGeneralXTranslation = 0;
    public float mGeneralYTranslation = 0;
    Text nameText = new Text();
    public double stageHeight;
    public boolean isFullScreen = false;
    
    public static String mbackground = null;

    public static Dimension mDefaultSize = new Dimension(300, 800);
    public static Dimension mSize = new Dimension(mDefaultSize);

    //steuert leaveSpeed von GoDown und ComeUp 
    public double leaveSpeed = 0;
    // leaving
    public boolean starShowControler = false;
    // star appear or not
    public boolean starShowC = false;
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
//	public SimplexNoise simplexNoise; // Perlin noise

    // amimation stuff
    public Semaphore mAnimationLaunchControl = new Semaphore(1);
    public AnimationScheduler3D mAnimationSchedulerFX;
    private final List<AnimationListener> mAnimationListeners = new CopyOnWriteArrayList<AnimationListener>();

    // body parts
    public HeadFX mHeadFX;
    public NoseFX mNoseFX;
    public MaleHairFX mMaleHairFX;
    public FemaleHairFX mFemaleHairFX;
    public LeftEyebrowFX mLeftEyebrowFX;
    public LeftEyeFX mLeftEyeFX;
    public LeftEar mLeftEar;
    public RightEar mRightEar;
    public RightEyebrowFX mRightEyebrowFX;
    public RightEyeFX mRightEyeFX;
    public MouthFX mMouthFX;
    public NeckFX mNeckFX;
    public FaceWrinkleFX mFaceWrinkleFX; // added by Robbie FaceWrinkle
    public UpperBody mUpperBody;
    public DownBody mDownBody;
    public LeftUpperArmFX mLeftUpperArmFX;
    public LeftForeArmFX mLeftForeArmFX;
    public LeftWrist mLeftWrist;
    public LeftFinger1 mLeftFinger1;
    public LeftFinger2 mLeftFinger2;
    public LeftFinger3 mLeftFinger3;
    public LeftFinger4 mLeftFinger4;
    public RightUpperArmFX mRightUpperArmFX;
    public RightForeArmFX mRightForeArmFX;
    public RightWrist mRightWrist;
    public RightFinger1 mRightFinger1;
    public RightFinger2 mRightFinger2;
    public RightFinger3 mRightFinger3;
    public RightFinger4 mRightFinger4;
    public LeftUpperLegFX mLeftUpperLegFX;
    public LeftForeLegFX mLeftForeLegFX;
    public LeftFootFX mLeftFootFX;
    public StarsFX mStarsFX;
    public RightUpperLegFX mRightUpperLegFX;
    public RightForeLegFX mRightForeLegFX;
    public RightFootFX mRightFootFX;
    public UpperBodyAndHead mUpperBodyAndHead;
    // environment
    public SpeechBubbleFX mSpeechBubbleFX;
    private StageRoom stageController;
    // logging
    public final Logger mLogger = Logger.getAnonymousLogger();
    // id
    private long mID = 0;

    public Stickman3D(String name, Gender.TYPE gender, float scale, Dimension size) {
        mSize = size;
        mScale = scale;
        isFullScreen = true;
        mName = name;
        mType = gender;

        mHeadFX = new HeadFX(this);
        mMaleHairFX = new MaleHairFX(this);
        mFemaleHairFX = new FemaleHairFX(this);
        mLeftEyebrowFX = new LeftEyebrowFX(mHeadFX);
        mLeftEyeFX = new LeftEyeFX(mHeadFX);
        mLeftEar = new LeftEar(mHeadFX);
        mRightEar = new RightEar(mHeadFX);
        mRightEyebrowFX = new RightEyebrowFX(mHeadFX);
        mRightEyeFX = new RightEyeFX(mHeadFX);
        mNoseFX = new NoseFX(mHeadFX);
        mMouthFX = new MouthFX(mHeadFX);
        mFaceWrinkleFX = new FaceWrinkleFX(mHeadFX); /// added by Robbie
        mNeckFX = new NeckFX(mHeadFX);
        mUpperBody = new UpperBody(mNeckFX);
        mDownBody = new DownBody(mUpperBody);
        mLeftUpperArmFX = new LeftUpperArmFX(mUpperBody);
        mLeftForeArmFX = new LeftForeArmFX(mLeftUpperArmFX);
        mLeftWrist = new LeftWrist(mLeftForeArmFX);
        mLeftFinger1 = new LeftFinger1(mLeftWrist);
        mLeftFinger2 = new LeftFinger2(mLeftWrist);
        mLeftFinger3 = new LeftFinger3(mLeftWrist);
        mLeftFinger4 = new LeftFinger4(mLeftWrist);
        mRightUpperArmFX = new RightUpperArmFX(mUpperBody);
        mRightForeArmFX = new RightForeArmFX(mRightUpperArmFX);
        mRightWrist = new RightWrist(mRightForeArmFX);
        mRightFinger1 = new RightFinger1(mRightWrist);
        mRightFinger2 = new RightFinger2(mRightWrist);
        mRightFinger3 = new RightFinger3(mRightWrist);
        mRightFinger4 = new RightFinger4(mRightWrist);
        mLeftUpperLegFX = new LeftUpperLegFX(mDownBody);
        mLeftForeLegFX = new LeftForeLegFX(mLeftUpperLegFX);
        mLeftFootFX = new LeftFootFX(mLeftForeLegFX);
        mStarsFX = new StarsFX(mUpperBody); /// added by Robbie
        mRightUpperLegFX = new RightUpperLegFX(mDownBody);
        mRightForeLegFX = new RightForeLegFX(mRightUpperLegFX);
        mRightFootFX = new RightFootFX(mRightForeLegFX);
        mUpperBodyAndHead = new UpperBodyAndHead(mHeadFX, mUpperBody, mNeckFX);

        mSpeechBubbleFX = new SpeechBubbleFX(mHeadFX);
        init();
        this.addAllParts();
        update();
    }

    public Stickman3D(String name, Gender.TYPE gender, float scale, double height) {
        mScale = scale;
        isFullScreen = false;
        this.stageHeight = height;
        mName = name;
        mType = gender;

        mHeadFX = new HeadFX(this);
        mMaleHairFX = new MaleHairFX(this);
        mFemaleHairFX = new FemaleHairFX(this);
        mLeftEyebrowFX = new LeftEyebrowFX(mHeadFX);
        mLeftEyeFX = new LeftEyeFX(mHeadFX);
        mLeftEar = new LeftEar(mHeadFX);
        mRightEar = new RightEar(mHeadFX);
        mRightEyebrowFX = new RightEyebrowFX(mHeadFX);
        mRightEyeFX = new RightEyeFX(mHeadFX);
        mNoseFX = new NoseFX(mHeadFX);
        mMouthFX = new MouthFX(mHeadFX);
        mFaceWrinkleFX = new FaceWrinkleFX(mHeadFX); /// added by Robbie
        mNeckFX = new NeckFX(mHeadFX);
        mUpperBody = new UpperBody(mNeckFX);
        mDownBody = new DownBody(mUpperBody);
        mLeftUpperArmFX = new LeftUpperArmFX(mUpperBody);
        mLeftForeArmFX = new LeftForeArmFX(mLeftUpperArmFX);
        mLeftWrist = new LeftWrist(mLeftForeArmFX);
        mLeftFinger1 = new LeftFinger1(mLeftWrist);
        mLeftFinger2 = new LeftFinger2(mLeftWrist);
        mLeftFinger3 = new LeftFinger3(mLeftWrist);
        mLeftFinger4 = new LeftFinger4(mLeftWrist);
        mRightUpperArmFX = new RightUpperArmFX(mUpperBody);
        mRightForeArmFX = new RightForeArmFX(mRightUpperArmFX);
        mRightWrist = new RightWrist(mRightForeArmFX);
        mRightFinger1 = new RightFinger1(mRightWrist);
        mRightFinger2 = new RightFinger2(mRightWrist);
        mRightFinger3 = new RightFinger3(mRightWrist);
        mRightFinger4 = new RightFinger4(mRightWrist);
        mLeftUpperLegFX = new LeftUpperLegFX(mDownBody);
        mLeftForeLegFX = new LeftForeLegFX(mLeftUpperLegFX);
        mLeftFootFX = new LeftFootFX(mLeftForeLegFX);
        mStarsFX = new StarsFX(mUpperBody); /// added by Robbie
        mRightUpperLegFX = new RightUpperLegFX(mDownBody);
        mRightForeLegFX = new RightForeLegFX(mRightUpperLegFX);
        mRightFootFX = new RightFootFX(mRightForeLegFX);
        mUpperBodyAndHead = new UpperBodyAndHead(mHeadFX, mUpperBody, mNeckFX);

        mSpeechBubbleFX = new SpeechBubbleFX(mHeadFX);
        init();
        this.addAllParts();
        update();
    }

    public Stickman3D(String name, Gender.TYPE gender) {
        mName = name;
        mType = gender;

        isFullScreen = true;
        mHeadFX = new HeadFX(this);
        mMaleHairFX = new MaleHairFX(this);
        mFemaleHairFX = new FemaleHairFX(this);
        mLeftEyebrowFX = new LeftEyebrowFX(mHeadFX);
        mLeftEyeFX = new LeftEyeFX(mHeadFX);
        mLeftEar = new LeftEar(mHeadFX);
        mRightEar = new RightEar(mHeadFX);
        mRightEyebrowFX = new RightEyebrowFX(mHeadFX);
        mRightEyeFX = new RightEyeFX(mHeadFX);
        mNoseFX = new NoseFX(mHeadFX);
        mMouthFX = new MouthFX(mHeadFX);
        mFaceWrinkleFX = new FaceWrinkleFX(mHeadFX); /// added by Robbie
        mNeckFX = new NeckFX(mHeadFX);
        mUpperBody = new UpperBody(mNeckFX);
        mDownBody = new DownBody(mUpperBody);
        mLeftUpperArmFX = new LeftUpperArmFX(mUpperBody);
        mLeftForeArmFX = new LeftForeArmFX(mLeftUpperArmFX);
        mLeftWrist = new LeftWrist(mLeftForeArmFX);
        mLeftFinger1 = new LeftFinger1(mLeftWrist);
        mLeftFinger2 = new LeftFinger2(mLeftWrist);
        mLeftFinger3 = new LeftFinger3(mLeftWrist);
        mLeftFinger4 = new LeftFinger4(mLeftWrist);
        mRightUpperArmFX = new RightUpperArmFX(mUpperBody);
        mRightForeArmFX = new RightForeArmFX(mRightUpperArmFX);
        mRightWrist = new RightWrist(mRightForeArmFX);
        mRightFinger1 = new RightFinger1(mRightWrist);
        mRightFinger2 = new RightFinger2(mRightWrist);
        mRightFinger3 = new RightFinger3(mRightWrist);
        mRightFinger4 = new RightFinger4(mRightWrist);
        mLeftUpperLegFX = new LeftUpperLegFX(mDownBody);
        mLeftForeLegFX = new LeftForeLegFX(mLeftUpperLegFX);
        mLeftFootFX = new LeftFootFX(mLeftForeLegFX);
        mStarsFX = new StarsFX(mUpperBody); /// added by Robbie
        mRightUpperLegFX = new RightUpperLegFX(mDownBody);
        mRightForeLegFX = new RightForeLegFX(mRightUpperLegFX);
        mRightFootFX = new RightFootFX(mRightForeLegFX);
        mUpperBodyAndHead = new UpperBodyAndHead(mHeadFX, mUpperBody, mNeckFX);

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

        nameText.setEffect(is);
        nameText.setX(20);
        nameText.setY(100);
        nameText.setText(mName);
        nameText.setFill(Color.YELLOW);
        nameText.setFont(Font.font(null, FontWeight.BOLD, 30));

        if (this.mType == Gender.TYPE.MALE) {
            nameText.setTranslateX(-80);
            nameText.setTranslateY(350);
        } else {
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

    public Animation3D doEventFeedbackAnimation(String name, int duration, WordTimeMarkSequence wts, boolean block) {
        EventAnimation3D a = AnimationLoader3D.getInstance().loadEventAnimation(this, name, duration, block);

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

    public Animation3D doAnimation(String name, int duration, boolean block) {
        return doAnimation(name, duration, "", block);
    }

    public Animation3D doAnimation(String name, int frequent, int actionDuration, boolean block) {
        Animation3D a = AnimationLoader3D.getInstance().loadAnimation(this, name, frequent, actionDuration, block);

        try {
            mAnimationLaunchControl.acquire();
            a.start();
        } catch (InterruptedException ex) {
            mLogger.severe(ex.getMessage());
        }

        return a;
    }

    public Animation3D doAnimation(String name, Object param, boolean block) {
        return doAnimation(name, -1, param, block);
    }

    public Animation3D doAnimation(String name, boolean block) {
        return doAnimation(name, -1, "", block);
    }

    public Animation3D doAnimation(String name, int duration, Object param, boolean block) {
        Animation3D a = AnimationLoader3D.getInstance().loadAnimation(this, name, duration, block);

        a.setParameter(param); // this is for now only used by the Speech Bubble

        try {
            mAnimationLaunchControl.acquire();
            a.start();
        } catch (InterruptedException ex) {
            mLogger.severe(ex.getMessage());
        }

        return a;
    }

    public void playAnimation(Animation3D a) {
        try {
            mAnimationLaunchControl.acquire();
            a.start();
        } catch (InterruptedException ex) {
            mLogger.severe(ex.getMessage());
        }
    }

    public void update() {

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        double StickmanHeight = this.mHeadFX.mHeadMeshView.getBoundsInParent().getHeight()
                + this.mNeckFX.neckMeshView.getBoundsInParent().getHeight()
                + this.mUpperBody.mBodyMeshView.getBoundsInParent().getHeight()
                + this.mDownBody.mBodyMeshView.getBoundsInParent().getHeight()
                + this.mLeftUpperLegFX.mLeftUpperLegMesh.getBoundsInParent().getHeight()
                + this.mLeftForeLegFX.mLeftForeLegMesh.getBoundsInParent().getHeight()
                + this.mLeftFootFX.mLeftFootMeshView.getBoundsInParent().getHeight();

        Affine af = new Affine();
        int shiftFactor = (int) (StickmanHeight - (StickmanHeight * mScale));
        if (isFullScreen) {
            mGeneralYTranslation = (int) ((dim.getHeight() - StickmanHeight) + shiftFactor + 40);
            mGeneralXTranslation = 0;
        } else {
            mGeneralYTranslation = (int) ((this.stageHeight - StickmanHeight) + shiftFactor-350);
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
        mScale =  scale;
    }

    private static class StickmanLogFormatter extends Formatter {

        @Override
        public String format(LogRecord record) {
            return ((new StringBuffer()).append(record.getLevel()).append(": ").append(record.getMessage())
                    .append("\n")).toString();
        }
    }

    private void addAllParts() {

        this.getChildren().addAll(mNeckFX, mHeadFX,
                mUpperBody, mDownBody, mRightUpperArmFX, mLeftUpperLegFX, mLeftForeLegFX,
                mLeftFootFX, mRightUpperLegFX, mRightForeLegFX, mRightFootFX, mFaceWrinkleFX,
                mStarsFX, mSpeechBubbleFX, nameText, mLeftEar, mRightEar, mUpperBodyAndHead);

    }

    public void hideAllPartsWithout(Pane p) {
        this.getChildren().forEach(child
                -> {
            if (!child.equals(p)) {
                child.setVisible(false);
            }
        });
    }

    public void showAllParts() {
        this.getChildren().forEach(child
                -> {
            child.setVisible(true);
        });
    }
}
