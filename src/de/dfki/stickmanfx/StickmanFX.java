package de.dfki.stickmanfx;

import de.dfki.stickman.*;
import de.dfki.action.sequence.WordTimeMarkSequence;
import de.dfki.stickman.animationlogic.Animation;
import de.dfki.stickman.animationlogic.listener.AnimationListener;
import de.dfki.stickman.animationlogic.AnimationScheduler;
import de.dfki.stickman.animationlogic.EventAnimation;
import de.dfki.stickman.body.Body;
import de.dfki.stickman.body.Head;
import de.dfki.stickman.body.LeftEye;
import de.dfki.stickman.body.LeftEyebrow;
import de.dfki.stickman.body.FaceWrinkle;
import de.dfki.stickman.body.LeftForeArm;
import de.dfki.stickman.body.LeftHand;
import de.dfki.stickman.body.LeftLeg;
import de.dfki.stickman.body.Stars;
import de.dfki.stickman.body.LeftShoulder;
import de.dfki.stickman.body.LeftUpperArm;
import de.dfki.stickman.body.Mouth;
import de.dfki.stickman.body.Neck;
import de.dfki.stickman.body.RightEye;
import de.dfki.stickman.body.RightEyebrow;
import de.dfki.stickman.body.RightForeArm;
import de.dfki.stickman.body.RightHand;
import de.dfki.stickman.body.RightLeg;
import de.dfki.stickman.body.RightShoulder;
import de.dfki.stickman.body.RightUpperArm;
import de.dfki.stickman.environment.SpeechBubble;
import de.dfki.stickman.animationlogic.AnimationLoader;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.font.TextAttribute;
import java.awt.geom.AffineTransform;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Semaphore;
import java.util.logging.ConsoleHandler;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import javax.swing.JComponent;

import de.dfki.stickman.animation.environment.IdleBehavior;
import de.dfki.stickman.animation.environment.SimplexNoise;
import de.dfki.stickman.bodyfx.BodyFX;
import de.dfki.stickman.bodyfx.HeadFX;
import de.dfki.stickman.bodyfx.LeftEyeFX;
import de.dfki.stickman.bodyfx.LeftEyebrowFX;
import de.dfki.stickman.bodyfx.LeftForeArmFX;
import de.dfki.stickman.bodyfx.LeftHandFX;
import de.dfki.stickman.bodyfx.LeftShoulderFX;
import de.dfki.stickman.bodyfx.LeftUpperArmFX;
import de.dfki.stickman.bodyfx.MouthFX;
import de.dfki.stickman.bodyfx.NeckFX;
import de.dfki.stickman.bodyfx.RightEyeFX;
import de.dfki.stickman.bodyfx.RightEyebrowFX;
import de.dfki.stickman.bodyfx.RightShoulderFX;

/**
 *
 * @author Patrick Gebhard
 *
 * This work is inspired by the stickmans drawn by Sarah Johnson
 * (www.sarah-johnson.com) in the Valentine music video from Kina Grannis shot
 * by Ross Ching in 2012
 *
 */
public class StickmanFX extends JComponent {

    // general stuff
    public static enum ORIENTATION {

        FRONT, LEFT, RIGHT
    };

    public static enum TYPE {

        FEMALE, MALE
    };

    static public final Color sFOREGROUND = new Color(188, 188, 188, 128);
    public TYPE mType = TYPE.FEMALE;
    public String mName = "Stickman";
    public ORIENTATION mOrientation = ORIENTATION.FRONT;
    public float mScale = 1.0f;
    public boolean mShowBackground = true;
    public boolean mShowStage = true;
    public boolean mShowName = true;
    public float mGeneralXTranslation = 0;
    public float mGeneralYTranslation = 0;

    public static Dimension mDefaultSize = new Dimension(400, 600);
    public static Dimension mSize = new Dimension(mDefaultSize);
    FontMetrics mFontMetrics;
    Font mFont;
    
    public double 	leaveSpeed = 0;                  //Added by Robbie, to control the speed of leaving
    public boolean  starShowControler = false;     //Added by Robbie,  to control the star appear or not
    public boolean  starShowC = false; 				//Added by Robbie,  star with character appear at the same time or not
    public boolean  fadeControler = false;         //Added by Robbie,  to control the character to fade out or fade in. true: Fade out
    public boolean  setCharacterInvisible = false; //Added by Robbie, to control the character to fade out. 
    												//True: visible False:invisible
    public double mWobble=0;
    public Boolean mIdleRun = false;                        // the shared variable to decide the while loop in IdleBehavior break or not
    public IdleBehavior mIdleBehavior;
    public SimplexNoise simplexNoise;             // Perlin noise
    
    
    // amimation stuff
    public Semaphore mAnimationLaunchControl = new Semaphore(1);
    public AnimationScheduler mAnimationScheduler;
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
//    public RightUpperArm mRightUpperArm;
//    public RightForeArm mRightForeArm;
//    public RightHand mRightHand;
//    public LeftLeg mLeftLeg;
//    public Stars mStars;         // added by Robbie Create Say bye or hi
//    public RightLeg mRightLeg;
    // environment
    //public SpeechBubble mSpeechBubble;

    // logging
    public final Logger mLogger = Logger.getAnonymousLogger();

    // id
    private long mID = 0;

    public StickmanFX(String name, TYPE gender, float scale, Dimension size) {
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
//        mRightUpperArm = new RightUpperArm(mRightShoulder);
//        mRightForeArm = new RightForeArm(mRightUpperArm);
//        mRightHand = new RightHand(mRightForeArm);
//        mLeftLeg = new LeftLeg(mBody);
//        mStars = new Stars(mBody);                   /// added by Robbie
//        mRightLeg = new RightLeg(mBody);

        //mSpeechBubble = new SpeechBubble(mHeadFX);

        init();
        
        simplexNoise = new SimplexNoise(8,0.1,(int)(Math.random()*100));
        //mIdleBehavior = new IdleBehavior(this,simplexNoise);
    }

    public StickmanFX(String name, TYPE gender, float scale) {
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
//        mRightUpperArm = new RightUpperArm(mRightShoulder);
//        mRightForeArm = new RightForeArm(mRightUpperArm);
//        mRightHand = new RightHand(mRightForeArm);
//        mLeftLeg = new LeftLeg(mBody);
//        mStars = new Stars(mBody);                /// added by Robbie
//        mRightLeg = new RightLeg(mBody);

        //mSpeechBubble = new SpeechBubble(mHeadFX);

        init();
        simplexNoise = new SimplexNoise(8,0.1,(int)(Math.random()*100));
    }

    public StickmanFX(String name, TYPE gender) {
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
//        mRightUpperArm = new RightUpperArm(mRightShoulder);
//        mRightForeArm = new RightForeArm(mRightUpperArm);
//        mRightHand = new RightHand(mRightForeArm);
//        mLeftLeg = new LeftLeg(mBody);
//        mStars = new Stars(mBody);           /// added by Robbie
//        mRightLeg = new RightLeg(mBody);

        //mSpeechBubble = new SpeechBubble(mHeadFX);

        init();
        simplexNoise = new SimplexNoise(8,0.1,(int)(Math.random()*100));
    }

    private void init() {
        setLayout(null);
        setPreferredSize(mSize);
        setMinimumSize(mSize);
        setSize(mSize);
    
        // font stuff
        Map<TextAttribute, Object> map = new HashMap<>();
        map.put(TextAttribute.KERNING, TextAttribute.KERNING_ON);
        map.put(TextAttribute.FAMILY, Font.SANS_SERIF);
        //map.put(TextAttribute.POSTURE, TextAttribute.POSTURE_OBLIQUE);
        map.put(TextAttribute.WEIGHT, TextAttribute.WEIGHT_DEMIBOLD);
        map.put(TextAttribute.SIZE, 14);

        mFont = Font.getFont(map);
        mFontMetrics = getFontMetrics(mFont);
        setFont(mFont);

        ConsoleHandler ch = new ConsoleHandler();
        ch.setFormatter(new StickmanLogFormatter());

        mLogger.addHandler(ch);
        mLogger.setUseParentHandlers(false);

        //mAnimationScheduler = new AnimationScheduler(this);
        //mAnimationScheduler.start();
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
        return (new StringBuffer()).append(mName).append(" Animation ").append(mID++).toString();
    }

    @Override
    public String getName() {
        return mName;
    }

    // Sets the orientation of the character, allowed values are: LEFT, RIGHT, FRONT
    public void setOrientation(String orientation) {
        if (orientation.equalsIgnoreCase(ORIENTATION.LEFT.toString())) {
            mOrientation = ORIENTATION.LEFT;
        } else if (orientation.equalsIgnoreCase(ORIENTATION.RIGHT.toString())) {
            mOrientation = ORIENTATION.RIGHT;
        } else {
            mOrientation = ORIENTATION.FRONT;
        }
    }

//    public Animation doEventFeedbackAnimation(String name, int duration, WordTimeMarkSequence wts, boolean block) {
//
//        EventAnimation a = AnimationLoader.getInstance().loadEventAnimation(this, name, duration, block);
//
//        a.setParameter(wts);
//
//        try {
//            mAnimationLaunchControl.acquire();
//            a.start();
//        } catch (InterruptedException ex) {
//            mLogger.severe(ex.getMessage());
//        }
//
//        return a;
//    }

//    public Animation doAnimation(String name, int duration, boolean block) {
//        return doAnimation(name, duration, "", block);
//    }
//
//    public Animation doAnimation(String name, Object param, boolean block) {
//        return doAnimation(name, -1, param, block);
//    }
//
//    public Animation doAnimation(String name, boolean block) {
//        return doAnimation(name, -1, "", block);
//    }

//    public Animation doAnimation(String name, int duration, Object param, boolean block) {
//        Animation a = AnimationLoader.getInstance().loadAnimation(this, name, duration, block);
//
//        a.setParameter(param); // this is for now only used by the Speech Bubble
//
//        try {
//            mAnimationLaunchControl.acquire();
//            a.start();
//        } catch (InterruptedException ex) {
//            mLogger.severe(ex.getMessage());
//        }
//
//        return a;
//    }

    public void playAnimation(Animation a) {
        try {
            //mLogger.info("Waiting for allowance to play animation " + a.toString());
            mAnimationLaunchControl.acquire();
            //mLogger.info("\tgranted!");
            a.start();
        } catch (InterruptedException ex) {
            mLogger.severe(ex.getMessage());
        }
    }
    
    // Control IdleBehavior start(mStart == true) or not(mStart == false).
    
    @Override
    protected void paintComponent(Graphics g) {
        //super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int width = new Float(mSize.width).intValue();
        int height = new Float(mSize.height).intValue();

        if (!mName.equalsIgnoreCase("")) {
            if (mShowBackground) {
                g2.setColor(sFOREGROUND);
                g2.fillRect(0, 0, width, height);
            }
            // draw Stickman's name
            final int hOffset = mFontMetrics.getAscent() + mFontMetrics.getDescent();
            final int wOffset = mFontMetrics.stringWidth(mName);

            if (mShowStage) {
                g2.setColor(sFOREGROUND.darker());
                mLogger.info("" + (height - hOffset * 4) + ", " + height);

                g2.fillRect(0, height - new Float(hOffset * 4 * mScale).intValue(), width, height);
            }

            if (mShowName) {
                //g2.setColor(mBody.mColor.darker());
                g2.drawString(mName, 10, height - hOffset);
            }
        }

        // draw everthing in the middle and scaled
        AffineTransform at = g2.getTransform();
        mGeneralXTranslation = mSize.width / 2 - mHeadFX.mSize.width * mScale;        		
        mGeneralYTranslation = getBounds().height - 477 * mScale;      
        at.translate(mGeneralXTranslation, mGeneralYTranslation);
        
        //at.rotate(Math.toRadians(mWobble), (mBody.getRightLegStartPostion().x + mBody.getLeftLegStartPostion().x)/2, mBody.getRightLegStartPostion().y+mLeftLeg.mLength);
 
        at.scale(mScale, mScale);   
        at.translate(0, leaveSpeed);   // Added by Robbie, GoDown
        
        g2.setTransform(at);

        // draw body parts
        if(starShowControler == true)
        {
            //mStars.update(g);     // Added by Robbie, to show stars or words here.
        }
        
        else{     	
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
//	        mRightUpperArm.update(g);
//	        mRightForeArm.update(g);
//	        mRightHand.update(g);
//	        mLeftLeg.update(g);
//	        mRightLeg.update(g);
	        
//	        if(starShowC == true)
//            	mStars.update(g);     // Added by Robbie, to show stars or words here.
        }

        // draw environment
        //mSpeechBubble.update(g);
    }

    private static class StickmanLogFormatter extends Formatter {

        @Override
        public String format(LogRecord record) {
            return ((new StringBuffer()).append(record.getLevel()).append(": ").append(record.getMessage()).append("\n")).toString();
        }
    }
}
