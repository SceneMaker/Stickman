package de.dfki.stickmanFX;

import de.dfki.action.sequence.WordTimeMarkSequence;
import de.dfki.common.agent.Agent2D;
import de.dfki.common.animationlogic.AnimationScheduler;
import de.dfki.common.animationlogic.IAnimation;
import de.dfki.common.enums.Gender;
import de.dfki.common.enums.Orientation;
import de.dfki.common.part.Part2D;
import de.dfki.stickmanFX.animation.environmentfx.IdleBehavior;
import de.dfki.stickmanFX.animation.environmentfx.SimplexNoise;
import de.dfki.stickmanFX.animationlogic.AnimationLoaderFX;
import de.dfki.stickmanFX.animationlogic.AnimationStickman2D;
import de.dfki.stickmanFX.animationlogic.EventAnimationFX;
import de.dfki.stickmanFX.bodyfx.*;
import de.dfki.stickmanFX.environmentfx.SpeechBubbleStickman2D;
import de.dfki.util.observers.AnimationObserver;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.transform.Affine;

import java.awt.*;
import java.awt.font.TextAttribute;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Beka Aptsiauri
 *         <p>
 *         This work is inspired by the stickmans drawn by Sarah Johnson
 *         (www.sarah-johnson.com) in the Valentine music video from Kina Grannis shot
 *         by Ross Ching in 2012
 */
public class StickmanFX extends Agent2D
{
    //Used to change the backgroundRecord(pic) of the stickmanSwing
    public final static ObservableList<String> backgroundList =
            FXCollections.observableArrayList("office", "grassland");
    // Control IdleBehavior start(mStart == true) or not(mStart == false).
    private static boolean isAnimationTimerStartet = false;
    // record the backgroundRecord(pic or color) of the stickmanSwing
    public String backgroundRecord = null;
    public Orientation mOrientation = Orientation.FRONT;
    // Record mScale in DisappearToSmall and ComeBackFromSmall
    public float mScaleOriginal = mScale;
    //control the speed of leaving
    public double hoffset = 0;
    public double voffset = 0;
    //to control the star appear or not
    public boolean starShowControler = false;
    //star with character appear at the same time or not
    public boolean starShowC = false;
    //control the character to fade out or fade in. true: Fade out
    public boolean fadeControler = false;
    //control the character to fade out.
    public boolean setCharacterInvisible = false;
    public double mWobble = 0;
    // the shared variable to decide the while loop in IdleBehavior break or not
    public Boolean mIdleRun = false;
    public IdleBehavior mIdleBehavior = null;
    // Perlin noise
    public SimplexNoise simplexNoise = null;
    public Part2D mMaleHairFX = null;
    public Part2D mFemaleHairFX = null;
    public Part2D mLeftEyebrowFX = null;
    public Part2D mFaceWrinkleFX = null;
    public Part2D mRightEyebrowFX = null;
    public Part2D mLeftShoulderFX = null;
    public Part2D mLeftUpperArmFX = null;
    public Part2D mLeftForeArmFX = null;
    public Part2D mLeftHandFX = null;
    public Part2D mRightShoulderFX = null;
    public Part2D mRightUpperArmFX = null;
    public Part2D mRightForeArmFX = null;
    public Part2D mRightHandFX = null;
    public Part2D mLeftUpperLegFX = null;
    public Part2D mLeftForeLegFX = null;
    public Part2D mLeftFootFX = null;
    public Part2D mStarsFX = null;
    public Part2D mRightUpperLegFX = null;
    public Part2D mRightForeLegFX = null;
    public Part2D mRightFootFX = null;
    public Part2D mNose = null;

    public StickmanFX(String name, Gender.TYPE gender, float scale, Dimension size)
    {
        super(name, gender, scale, size);
        mScaleOriginal = scale;

        init();
        addAllParts();
        update();
    }

    public StickmanFX(String name, Gender.TYPE gender, float scale)
    {
        super(name, gender, scale);
        mScaleOriginal = scale;

        init();
        addAllParts();
        update();
    }

    public StickmanFX(String name, Gender.TYPE gender, float scale, boolean faceOnly)
    {
        super(name, gender, scale, faceOnly);
        mScaleOriginal = scale;

        init();

        if (faceOnly)
        {
            addOnlyHeadParts();
        } else
        {
            addAllParts();
        }
        update();
    }

    public StickmanFX(String name, Gender.TYPE gender)
    {
        super(name, gender);

        init();
        addAllParts();
        update();
    }

    public StickmanFX(String name, Gender.TYPE gender, float scale, Dimension size, boolean faceOnly)
    {
        super(name, gender, scale, size, faceOnly);
        mScaleOriginal = scale;

        init();
        if (faceOnly)
        {
            addOnlyHeadParts();
        } else
        {
            addAllParts();
        }
        update();
    }

    public void initBodyParts()
    {
        mHeadFX = new HeadFX(this);
        mMaleHairFX = new MaleHairFX(this);
        mFemaleHairFX = new FemaleHairFX(this);
        mLeftEyebrowFX = new LeftEyebrowFX(mHeadFX);
        mLeftEyeFX = new LeftEyeFX(mHeadFX);
        mRightEyebrowFX = new RightEyebrowFX(mHeadFX);
        mRightEyeFX = new RightEyeFX(mHeadFX);
        mFaceWrinkleFX = new FaceWrinkleFX(mHeadFX); /// added by Robbie
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
        mLeftUpperLegFX = new LeftUpperLegFX(mBodyFX);
        mLeftForeLegFX = new LeftForeLegFX(mLeftUpperLegFX);
        mLeftFootFX = new LeftFootFX(mLeftForeLegFX);
        mStarsFX = new StarsFX(mBodyFX);
        mRightUpperLegFX = new RightUpperLegFX(mBodyFX);
        mRightForeLegFX = new RightForeLegFX(mRightUpperLegFX);
        mRightFootFX = new RightFootFX(mRightForeLegFX);
        mNose = new NoseFX(mHeadFX);
        mSpeechBubbleFX = new SpeechBubbleStickman2D(mHeadFX);
    }

    public void init()
    {
        initBodyParts();
        super.init();
        agentNameLabel = new Label();

        // font stuff
        Map<TextAttribute, Object> map = new HashMap<>();
        map.put(TextAttribute.KERNING, TextAttribute.KERNING_ON);
        map.put(TextAttribute.FAMILY, Font.SANS_SERIF);
        map.put(TextAttribute.WEIGHT, TextAttribute.WEIGHT_DEMIBOLD);
        map.put(TextAttribute.SIZE, 14);

        animationScheduler = new AnimationScheduler(this);
        animationScheduler.start();

        simplexNoise = new SimplexNoise(8, 0.1, (int) (Math.random() * 100));
        mIdleBehavior = new IdleBehavior(this, simplexNoise);

    }

    // Sets the orientation of the character, allowed values are: LEFT, RIGHT,
    // FRONT
    public void setOrientation(String orientation)
    {
        if (orientation.equalsIgnoreCase(Orientation.LEFT.toString()))
        {
            mOrientation = Orientation.LEFT;
        } else if (orientation.equalsIgnoreCase(Orientation.RIGHT.toString()))
        {
            mOrientation = Orientation.RIGHT;
        } else
        {
            mOrientation = Orientation.FRONT;
        }
    }

    @Override
    public AnimationStickman2D doEventFeedbackAnimation(String name, int duration, WordTimeMarkSequence wts, boolean block)
    {
        EventAnimationFX a = AnimationLoaderFX.getInstance().loadEventAnimation(this, name, duration, block);

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

    public AnimationStickman2D doAnimationAsImage(String name, int duration, boolean block, AnimationObserver obs)
    {
        return doAnimation(name, duration, obs, block);
    }

    @Override
    public IAnimation doAnimation(String name, int frequent, int actionDuration, boolean block)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AnimationStickman2D doAnimation(String name, int duration, Object param, boolean block)
    {
        AnimationStickman2D a = AnimationLoaderFX.getInstance().loadAnimation(this, name, duration, block);

        // this is for now only used by the Speech Bubble
        a.setParameter(param);

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

    public void update()
    {
        float mGeneralXTranslation;
        float mGeneralYTranslation;

        // draw everthing in the middle and scaled
        Affine af = new Affine();
        mGeneralXTranslation = mSize.width / 2 - mHeadFX.mSize.width * mScale;
        mGeneralYTranslation = (float) (mSize.height / 5);
        if (this.faceOnly)
        {
            mGeneralYTranslation = -250;
        }
        af.appendTranslation(mGeneralXTranslation, mGeneralYTranslation);
        af.appendScale(mScale, mScale);
        // Added by Robbie, GoDown
        af.appendTranslation(hoffset, voffset);
        this.getTransforms().clear();
        this.getTransforms().add(af);

        // Out put perlin noise
        Point rightLegStartPostion = ((BodyFX) mBodyFX).getRightLegStartPostion();
        Point leftLegStartPostion = ((BodyFX) mBodyFX).getLeftLegStartPostion();
        implimentPerlinNoise(mWobble, (rightLegStartPostion.x + leftLegStartPostion.x) / 2,
                rightLegStartPostion.y + mLeftUpperLegFX.mLength + mLeftForeLegFX.mLength);

        RightForeLegFX rightForeLegFX = (RightForeLegFX) mRightForeLegFX;
        if (mShowName)
        {
            agentNameLabel.setTranslateY(rightForeLegFX.getLegStartPosition().getY() * 21 / 20);
            agentNameLabel.setText(mName);
        } else
        {
            agentNameLabel.setTranslateY(rightForeLegFX.getLegStartPosition().getY() * 21 / 20);
            agentNameLabel.setText("");
        }

        updateAll();
    }

    private void addOnlyHeadParts()
    {
        this.getChildren().addAll(mHeadFX, mLeftEyebrowFX, mLeftEyeFX, mRightEyebrowFX, mRightEyeFX, mMouthFX,
                mFaceWrinkleFX, mSpeechBubbleFX, mNose);
        if (this.mType == Gender.TYPE.MALE)
        {
            this.getChildren().add(mMaleHairFX);
        } else
        {
            this.getChildren().add(mFemaleHairFX);
        }
    }

    private void addAllParts()
    {
        this.getChildren().addAll(mHeadFX, mLeftEyebrowFX, mLeftEyeFX, mRightEyebrowFX, mRightEyeFX, mMouthFX, mNeckFX,
                mBodyFX, mLeftShoulderFX, mLeftUpperArmFX, mLeftForeArmFX, mLeftHandFX, mRightShoulderFX,
                mRightUpperArmFX, mRightForeArmFX, mRightHandFX, /* mLeftLegFX, */ mLeftUpperLegFX, mLeftForeLegFX,
                mLeftFootFX, /* mRightLegFX, */ mRightUpperLegFX, mRightForeLegFX, mRightFootFX, mFaceWrinkleFX,
                mStarsFX, mSpeechBubbleFX, agentNameLabel);
        if (this.mType == Gender.TYPE.MALE)
        {
            this.getChildren().add(mMaleHairFX);
        } else
        {
            this.getChildren().add(mFemaleHairFX);
        }
    }

    private void updateAll()
    {
        // draw body parts
        if (starShowControler == true)
        {
            // Added by Robbie, to show stars or words here.
            mStarsFX.update();
        } else
        {
            if (starShowC == true)
            {
                mStarsFX.update();
            }
            mHeadFX.update();

            if (this.mType == Gender.TYPE.MALE)
            {
                mMaleHairFX.update();
            } else
            {
                mFemaleHairFX.update();
            }
            mLeftEyebrowFX.update();
            mLeftEyeFX.update();
            mRightEyebrowFX.update();
            mFaceWrinkleFX.update();
            mRightEyeFX.update();
            mMouthFX.update();
            mNeckFX.update();
            mBodyFX.calculate(0);
            mLeftShoulderFX.update();
            mLeftUpperArmFX.update();
            mLeftForeArmFX.update();
            mLeftHandFX.update();
            mRightShoulderFX.update();
            mRightUpperArmFX.update();
            mRightForeArmFX.update();
            mRightHandFX.update();
            mLeftUpperLegFX.update();
            mLeftForeLegFX.update();
            mLeftFootFX.update();
            mRightUpperLegFX.update();
            mRightForeLegFX.update();
            mRightFootFX.update();

            if (starShowC == true) // Added by Robbie, to show stars or words here.
            {
                mStarsFX.update();
            }
        }
    }

    private void implimentPerlinNoise(double mWobble, int x, int y)
    {
        if (starShowControler == true)
        {
            // Added by Robbie, to show stars or words here
            mStarsFX.rotatePerlinNoise(mWobble, x, y);
        } else
        {
            if (starShowC == true)
            {
                mStarsFX.rotatePerlinNoise(mWobble, x, y);
            }
            mHeadFX.rotatePerlinNoise(mWobble, x, y);

            if (this.mType == Gender.TYPE.MALE)
            {
                mMaleHairFX.rotatePerlinNoise(mWobble, x, y);
            } else
            {
                mFemaleHairFX.rotatePerlinNoise(mWobble, x, y);
            }
            mLeftEyebrowFX.rotatePerlinNoise(mWobble, x, y);
            mLeftEyeFX.rotatePerlinNoise(mWobble, x, y);
            mRightEyebrowFX.rotatePerlinNoise(mWobble, x, y);
            mFaceWrinkleFX.rotatePerlinNoise(mWobble, x, y);
            mRightEyeFX.rotatePerlinNoise(mWobble, x, y);
            mMouthFX.rotatePerlinNoise(mWobble, x, y);
            mNeckFX.rotatePerlinNoise(mWobble, x, y);
            mBodyFX.rotatePerlinNoise(mWobble, x, y);
            mLeftShoulderFX.rotatePerlinNoise(mWobble, x, y);
            mLeftUpperArmFX.rotatePerlinNoise(mWobble, x, y);
            mLeftForeArmFX.rotatePerlinNoise(mWobble, x, y);
            mLeftHandFX.rotatePerlinNoise(mWobble, x, y);
            mRightShoulderFX.rotatePerlinNoise(mWobble, x, y);
            mRightUpperArmFX.rotatePerlinNoise(mWobble, x, y);
            mRightForeArmFX.rotatePerlinNoise(mWobble, x, y);
            mRightHandFX.rotatePerlinNoise(mWobble, x, y);
            mLeftUpperLegFX.rotatePerlinNoise(mWobble, x, y);
            mLeftForeLegFX.rotatePerlinNoise(mWobble, x, y);
            mLeftFootFX.rotatePerlinNoise(mWobble, x, y);
            mRightUpperLegFX.rotatePerlinNoise(mWobble, x, y);
            mRightForeLegFX.rotatePerlinNoise(mWobble, x, y);
            mRightFootFX.rotatePerlinNoise(mWobble, x, y);

            if (starShowC == true) // Added by Robbie, to show stars or words here.
            {
                mStarsFX.rotatePerlinNoise(mWobble, x, y);
            }
        }
    }

    public void hideAllPartsWithout(Pane p)
    {
        this.getChildren().forEach(child ->
        {
            if (!child.equals(p))
            {
                child.setVisible(false);
            }
        });
    }

    public void showAllParts()
    {
        this.getChildren().forEach(child ->
        {
            child.setVisible(true);
        });
    }
}
