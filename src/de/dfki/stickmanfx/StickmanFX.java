package de.dfki.stickmanfx;

import de.dfki.action.sequence.WordTimeMarkSequence;
import de.dfki.stickman.animationlogic.Animation;
import de.dfki.stickman.animationlogic.listener.AnimationListener;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.font.TextAttribute;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Semaphore;
import java.util.logging.ConsoleHandler;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

import de.dfki.stickman.animation.environment.IdleBehavior;
import de.dfki.stickman.animation.environment.SimplexNoise;
import de.dfki.stickmanfx.animationlogic.AnimationFX;
import de.dfki.stickmanfx.animationlogic.AnimationLoaderFX;
import de.dfki.stickmanfx.animationlogic.AnimationSchedulerFX;
import de.dfki.stickmanfx.animationlogic.EventAnimationFX;
import de.dfki.stickmanfx.bodyfx.BodyFX;
import de.dfki.stickmanfx.bodyfx.HeadFX;
import de.dfki.stickmanfx.bodyfx.LeftEyeFX;
import de.dfki.stickmanfx.bodyfx.LeftEyebrowFX;
import de.dfki.stickmanfx.bodyfx.LeftForeArmFX;
import de.dfki.stickmanfx.bodyfx.LeftHandFX;
import de.dfki.stickmanfx.bodyfx.LeftLegFX;
import de.dfki.stickmanfx.bodyfx.LeftShoulderFX;
import de.dfki.stickmanfx.bodyfx.LeftUpperArmFX;
import de.dfki.stickmanfx.bodyfx.MouthFX;
import de.dfki.stickmanfx.bodyfx.NeckFX;
import de.dfki.stickmanfx.bodyfx.RightEyeFX;
import de.dfki.stickmanfx.bodyfx.RightEyebrowFX;
import de.dfki.stickmanfx.bodyfx.RightForeArmFX;
import de.dfki.stickmanfx.bodyfx.RightHandFX;
import de.dfki.stickmanfx.bodyfx.RightLegFX;
import de.dfki.stickmanfx.bodyfx.RightShoulderFX;
import de.dfki.stickmanfx.bodyfx.RightUpperArmFX;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.transform.Affine;
import javafx.stage.Screen;
import javafx.util.Duration;

/**
 *
 * @author Beka Aptsiauri
 *
 * This work is inspired by the stickmans drawn by Sarah Johnson
 * (www.sarah-johnson.com) in the Valentine music video from Kina Grannis shot
 * by Ross Ching in 2012
 *
 */
public class StickmanFX extends Pane 
{
    // general stuff
    public static enum ORIENTATION 
    {
        FRONT, LEFT, RIGHT
    };

    public static enum TYPE 
    {
        FEMALE, MALE
    };

    static public final Color sFOREGROUND = Color.rgb(188, 188, 188, (128*100/255)/100f);
    public TYPE mType = TYPE.FEMALE;
    public String mName = "Stickman";
    public ORIENTATION mOrientation = ORIENTATION.FRONT;
    public float mScale = 1.0f;
    public boolean mShowBackground = true;
    public boolean mShowStage = true;
    public boolean mShowName = true;
    public float mGeneralXTranslation = 0;
    public float mGeneralYTranslation = 0;

//    public static Dimension mDefaultSize = new Dimension(400, 400); // 400
    public static Dimension mDefaultSize = new Dimension(300, 800); // 400
    public static Dimension mSize = new Dimension(mDefaultSize);
    FontMetrics mFontMetrics;
    Font mFont;

    public double leaveSpeed = 0;                  //Added by Robbie, to control the speed of leaving
    public boolean starShowControler = false;     //Added by Robbie,  to control the star appear or not
    public boolean starShowC = false; 				//Added by Robbie,  star with character appear at the same time or not
    public boolean fadeControler = false;         //Added by Robbie,  to control the character to fade out or fade in. true: Fade out
    public boolean setCharacterInvisible = false; //Added by Robbie, to control the character to fade out. 
    //True: visible False:invisible
    public double mWobble = 0;
    public Boolean mIdleRun = false;                        // the shared variable to decide the while loop in IdleBehavior break or not
    public IdleBehavior mIdleBehavior;
    public SimplexNoise simplexNoise;             // Perlin noise

    // amimation stuff
    public Semaphore mAnimationLaunchControl = new Semaphore(1);
    public AnimationSchedulerFX mAnimationSchedulerFX;
    private final List<AnimationListener> mAnimationListeners = new CopyOnWriteArrayList<AnimationListener>();

    // body parts
    public HeadFX mHeadFX;
    public LeftEyebrowFX mLeftEyebrowFX;
//    public FaceWrinkle mFaceWrinkle;  // added by Robbie FaceWrinkle 
    public LeftEyeFX mLeftEyeFX;
    public RightEyebrowFX mRightEyebrowFX;
    public RightEyeFX mRightEyeFX;
    public MouthFX mMouthFX;
    public NeckFX mNeckFX;
    public BodyFX mBodyFX;
    public LeftShoulderFX mLeftShoulderFX;
    public LeftUpperArmFX mLeftUpperArmFX;
    public LeftForeArmFX mLeftForeArmFX;
    public LeftHandFX mLeftHandFX;
    public RightShoulderFX mRightShoulderFX;
    public RightUpperArmFX mRightUpperArmFX;
    public RightForeArmFX mRightForeArmFX;
    public RightHandFX mRightHandFX;
    public LeftLegFX mLeftLegFX;
//    public Stars mStars;         // added by Robbie Create Say bye or hi
    public RightLegFX mRightLegFX;
    // environment
    //public SpeechBubble mSpeechBubble;

    // logging
    public final Logger mLogger = Logger.getAnonymousLogger();
    // id
    private long mID = 0;
    
    public StickmanFX(String name, TYPE gender, float scale, Dimension size) 
    {
        mSize = size;
        mScale = scale;

        mName = name;
        mType = gender;

        mHeadFX = new HeadFX(this);
        mLeftEyebrowFX = new LeftEyebrowFX(mHeadFX);
        mLeftEyeFX = new LeftEyeFX(mHeadFX);
        mRightEyebrowFX = new RightEyebrowFX(mHeadFX);
        mRightEyeFX = new RightEyeFX(mHeadFX);
        //mFaceWrinkle = new FaceWrinkle(mHeadFX);                 /// added by Robbie
        mMouthFX = new MouthFX(mHeadFX);
        mNeckFX = new NeckFX(mHeadFX);
        mBodyFX = new BodyFX(mNeckFX);
        mLeftShoulderFX = new LeftShoulderFX(mBodyFX);
        mLeftUpperArmFX = new LeftUpperArmFX(mLeftShoulderFX);
        mLeftForeArmFX = new LeftForeArmFX(mLeftUpperArmFX);
        mLeftHandFX = new LeftHandFX(mLeftForeArmFX);
        mRightShoulderFX = new RightShoulderFX(mBodyFX);
        mRightUpperArmFX = new RightUpperArmFX(mRightShoulderFX);
        mRightForeArmFX = new RightForeArmFX(mRightUpperArmFX);
        mRightHandFX = new RightHandFX(mRightForeArmFX);
        mLeftLegFX = new LeftLegFX(mBodyFX);
//        mStars = new Stars(mBody);                   /// added by Robbie
        mRightLegFX = new RightLegFX(mBodyFX);

        //mSpeechBubble = new SpeechBubble(mHeadFX);
        init();
        this.addAllParts();
        update();

        simplexNoise = new SimplexNoise(8, 0.1, (int) (Math.random() * 100));
        //mIdleBehavior = new IdleBehavior(this,simplexNoise);
    }

    public StickmanFX(String name, TYPE gender, float scale) 
    {
        mScale = scale;

        mName = name;
        mType = gender;

        mHeadFX = new HeadFX(this);
        mLeftEyebrowFX = new LeftEyebrowFX(mHeadFX);
        mLeftEyeFX = new LeftEyeFX(mHeadFX);
        mRightEyebrowFX = new RightEyebrowFX(mHeadFX);
        mRightEyeFX = new RightEyeFX(mHeadFX);
        //mFaceWrinkle = new FaceWrinkle(mHeadFX);    /// added by Robbie
        mMouthFX = new MouthFX(mHeadFX);
        mNeckFX = new NeckFX(mHeadFX);
        mBodyFX = new BodyFX(mNeckFX);
        mLeftShoulderFX = new LeftShoulderFX(mBodyFX);
        mLeftUpperArmFX = new LeftUpperArmFX(mLeftShoulderFX);
        mLeftForeArmFX = new LeftForeArmFX(mLeftUpperArmFX);
        mLeftHandFX = new LeftHandFX(mLeftForeArmFX);
        mRightShoulderFX = new RightShoulderFX(mBodyFX);
        mRightUpperArmFX = new RightUpperArmFX(mRightShoulderFX);
        mRightForeArmFX = new RightForeArmFX(mRightUpperArmFX);
        mRightHandFX = new RightHandFX(mRightForeArmFX);
        mLeftLegFX = new LeftLegFX(mBodyFX);
//        mStars = new Stars(mBody);                /// added by Robbie
        mRightLegFX = new RightLegFX(mBodyFX);

        //mSpeechBubble = new SpeechBubble(mHeadFX);
        init();
        this.addAllParts();
        update();
        simplexNoise = new SimplexNoise(8, 0.1, (int) (Math.random() * 100));
    }

    public StickmanFX(String name, TYPE gender) 
    {
        mName = name;
        mType = gender;

        mHeadFX = new HeadFX(this);
        mLeftEyebrowFX = new LeftEyebrowFX(mHeadFX);
        mLeftEyeFX = new LeftEyeFX(mHeadFX);
        mRightEyebrowFX = new RightEyebrowFX(mHeadFX);
        mRightEyeFX = new RightEyeFX(mHeadFX);
        //mFaceWrinkle = new FaceWrinkle(mHeadFX);    /// added by Robbie
        mMouthFX = new MouthFX(mHeadFX);
        mNeckFX = new NeckFX(mHeadFX);
        mBodyFX = new BodyFX(mNeckFX);
        mLeftShoulderFX = new LeftShoulderFX(mBodyFX);
        mLeftUpperArmFX = new LeftUpperArmFX(mLeftShoulderFX);
        mLeftForeArmFX = new LeftForeArmFX(mLeftUpperArmFX);
        mLeftHandFX = new LeftHandFX(mLeftForeArmFX);
        mRightShoulderFX = new RightShoulderFX(mBodyFX);
        mRightUpperArmFX = new RightUpperArmFX(mRightShoulderFX);
        mRightForeArmFX = new RightForeArmFX(mRightUpperArmFX);
        mRightHandFX = new RightHandFX(mRightForeArmFX);
        mLeftLegFX = new LeftLegFX(mBodyFX);
//        mStars = new Stars(mBody);           /// added by Robbie
        mRightLegFX = new RightLegFX(mBodyFX);

        //mSpeechBubble = new SpeechBubble(mHeadFX);
        init();
        this.addAllParts();
        update();
        
        simplexNoise = new SimplexNoise(8, 0.1, (int) (Math.random() * 100));
    }

    private void init() 
    {
        this.setPrefHeight(mSize.height);
        this.setPrefWidth(mSize.width);
        this.setMinHeight(mSize.height);
        this.setMinWidth(mSize.width);
        //this.setStyle("-fx-border-color: black");

        // font stuff
        Map<TextAttribute, Object> map = new HashMap<>();
        map.put(TextAttribute.KERNING, TextAttribute.KERNING_ON);
        map.put(TextAttribute.FAMILY, Font.SANS_SERIF);
        //map.put(TextAttribute.POSTURE, TextAttribute.POSTURE_OBLIQUE);
        map.put(TextAttribute.WEIGHT, TextAttribute.WEIGHT_DEMIBOLD);
        map.put(TextAttribute.SIZE, 14);

//        mFont = Font.getFont(map);
//        mFontMetrics = getFontMetrics(mFont);
//        setFont(mFont);

        ConsoleHandler ch = new ConsoleHandler();
        ch.setFormatter(new StickmanLogFormatter());

        mLogger.addHandler(ch);
        mLogger.setUseParentHandlers(false);

        mAnimationSchedulerFX = new AnimationSchedulerFX(this);
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
            mAnimationListeners.stream().forEach((al) -> {al.update(animationId);});
        }
    }

    public String getID() 
    {
        return (new StringBuffer()).append(mName).append(" Animation ").append(mID++).toString();
    }

//    @Override
//    public String getName() {
//        return mName;
//    }

    // Sets the orientation of the character, allowed values are: LEFT, RIGHT, FRONT
    public void setOrientation(String orientation) 
    {
        if (orientation.equalsIgnoreCase(ORIENTATION.LEFT.toString())) 
        {
            mOrientation = ORIENTATION.LEFT;
        } 
        else if (orientation.equalsIgnoreCase(ORIENTATION.RIGHT.toString())) 
        {
            mOrientation = ORIENTATION.RIGHT;
        } 
        else 
        {
            mOrientation = ORIENTATION.FRONT;
        }
    }

    public AnimationFX doEventFeedbackAnimation(String name, int duration, WordTimeMarkSequence wts, boolean block) 
    {
        EventAnimationFX a = AnimationLoaderFX.getInstance().loadEventAnimation(this, name, duration, block);

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
    public AnimationFX doAnimation(String name, int duration, boolean block) 
    {
        return doAnimation(name, duration, "", block);
    }

    public AnimationFX doAnimation(String name, Object param, boolean block) 
    {
        return doAnimation(name, -1, param, block);
    }

    public AnimationFX doAnimation(String name, boolean block) 
    {
        return doAnimation(name, -1, "", block);
    }
    public AnimationFX doAnimation(String name, int duration, Object param, boolean block) 
    {
        AnimationFX a = AnimationLoaderFX.getInstance().loadAnimation(this, name, duration, block);

        a.setParameter(param); // this is for now only used by the Speech Bubble

        try 
        {
            mAnimationLaunchControl.acquire();
            Platform.runLater(() -> a.start());
        } catch (InterruptedException ex) 
        {
            mLogger.severe(ex.getMessage());
        }

        return a;
    }
    public void playAnimation(AnimationFX a) 
    {
        try {
            mAnimationLaunchControl.acquire();
            a.start();
        } 
        catch (InterruptedException ex) 
        {
            mLogger.severe(ex.getMessage());
        }
    }

    // Control IdleBehavior start(mStart == true) or not(mStart == false).
    
    private static boolean isAnimationTimerStartet = false;
    public void update() 
    {
        Color currColor = sFOREGROUND;
        int width = new Float(mSize.width).intValue();
        int height = new Float(mSize.height).intValue();

        

        // draw everthing in the middle and scaled
        Affine af = new Affine();
        mGeneralXTranslation = mSize.width / 2 - mHeadFX.mSize.width * mScale;
//        mGeneralYTranslation = (float) (Screen.getPrimary().getVisualBounds().getHeight() - 477 * mScale);
        mGeneralYTranslation = (float) (Screen.getPrimary().getVisualBounds().getHeight() - 700 * mScale);

        af.appendTranslation(mGeneralXTranslation, mGeneralYTranslation);

        //at.rotate(Math.toRadians(mWobble), (mBody.getRightLegStartPostion().x + mBody.getLeftLegStartPostion().x)/2, mBody.getRightLegStartPostion().y+mLeftLeg.mLength);
        af.appendScale(mScale, mScale);
        af.appendTranslation(0, leaveSpeed);   // Added by Robbie, GoDown

        this.getTransforms().add(af);
        updateAll();
        
        
    }

    private static class StickmanLogFormatter extends Formatter {

        @Override
        public String format(LogRecord record) {
            return ((new StringBuffer()).append(record.getLevel()).append(": ").append(record.getMessage()).append("\n")).toString();
        }
    }
    
    private void addAllParts()
    {
        this.getChildren().addAll(mHeadFX, mLeftEyebrowFX, mLeftEyeFX, mRightEyebrowFX, mRightEyeFX, 
                                mMouthFX, mNeckFX, mBodyFX, mLeftShoulderFX, mLeftUpperArmFX, 
                                mLeftForeArmFX, mLeftHandFX, mRightShoulderFX, mRightUpperArmFX, 
                                mRightForeArmFX, mRightHandFX, mLeftLegFX, mRightLegFX);
    }
    
    private void updateAll()
    {
        // draw body parts
        if (starShowControler == true) {
            //mStars.update(g);     // Added by Robbie, to show stars or words here.
        } else {
//        	if(starShowC == true)
//            	mStars.update(g);   	
            mHeadFX.update();
            mLeftEyebrowFX.update();
            mLeftEyeFX.update();
            mRightEyebrowFX.update();
//	        mFaceWrinkle.update(g);      // added by Robbie
            mRightEyeFX.update();
            mMouthFX.update();
            mNeckFX.update();
            mBodyFX.update();
            mLeftShoulderFX.update();
            mLeftUpperArmFX.update();
            mLeftForeArmFX.update();
            mLeftHandFX.update();
            mRightShoulderFX.update();
            mRightUpperArmFX.update();
            mRightForeArmFX.update();
            mRightHandFX.update();
            mLeftLegFX.update();
            mRightLegFX.update();

//	        if(starShowC == true)
//            	mStars.update(g);     // Added by Robbie, to show stars or words here.
        }

        // draw environment
        //mSpeechBubble.update(g);
    }
}
