package de.dfki.reeti;

import de.dfki.action.sequence.WordTimeMarkSequence;
import de.dfki.common.agent.Agent3D;
import de.dfki.common.animationlogic.AnimationScheduler;
import de.dfki.common.enums.Gender;
import de.dfki.common.enums.Led;
import de.dfki.common.part.Part3D;
import de.dfki.common.util.Preferences;
import de.dfki.reeti.animation.environment.Blinking;
import de.dfki.reeti.animationlogic.AnimationLoaderReeti;
import de.dfki.reeti.animationlogic.AnimationReeti;
import de.dfki.reeti.animationlogic.EventAnimationReeti;
import de.dfki.reeti.body.*;
import de.dfki.reeti.environment.SpeechBubbleReeti;
import javafx.scene.control.Control;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.transform.Affine;
import javafx.scene.transform.Scale;

import java.awt.*;

/**
 * @author Beka Aptsiauri
 *         <p>
 *         This work is inspired by the stickmans drawn by Sarah Johnson
 *         (www.sarah-johnson.com) in the Valentine music video from Kina Grannis shot
 *         by Ross Ching in 2012
 */
public class Reeti extends Agent3D
{
    private static Reeti sReeti;

    // amimation stuff
    public Blinking mBlinking;
    public Part3D mLeftEyelid;
    public Part3D mRightEyelid;
    public Part3D mLeftEar;
    public Part3D mRightEar;
    public Part3D mLeftCheek;
    public Part3D mRightCheek;
    public Part3D mMouthLeftCorner;
    public Part3D mMouthRightCorner;
    public Part3D mMouthUpperLip;
    public Part3D mMouthDownLip;
    public Part3D mBody;
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
        super(name, gender, scale, size);
        isFullScreen = true;

        init();
        update();
    }

    public Reeti(String name, Gender.TYPE gender, float scale, double height)
    {
        super(name, gender, scale, height);
        isFullScreen = false;

        init();
        update();
    }

    public Reeti(String name, Gender.TYPE gender)
    {
        super(name, gender);
        isFullScreen = true;

        init();
        update();
    }

    ///////////////////////////////////////////////////////////////
    ///////////////////////VSM STATIC STUFF////////////////////////
    ///////////////////////////////////////////////////////////////
    public static void vsm_ledOn(String color)
    {
        sReeti.setLedColor(color);
    }

    public static void vsm_ledOf()
    {
        sReeti.ledOFF("B");
    }

    public static void vsm_rightLC(int pos, int duration)
    {
        sReeti.rightLC(pos, duration);
    }

    public static void vsm_leftLC(int pos, int duration)
    {
        sReeti.leftLC(pos, duration);
    }

    public static void vsm_topLip(int pos, int duration)
    {
        sReeti.topLip(pos, duration);
    }

    public static void vsm_bottomLip(int pos, int duration)
    {
        sReeti.bottomLip(pos, duration);
    }

    public static void vsm_leftEyeTilt(int pos, int duration)
    {
        sReeti.leftEyeTilt(pos, duration);
    }

    public static void vsm_rightEyeTilt(int pos, int duration)
    {
        sReeti.rightEyeTilt(pos, duration);
    }

    public static void vsm_leftEyePan(int pos, int duration)
    {
        sReeti.leftEyePan(pos, duration);
    }

    public static void vsm_rightEyePan(int pos, int duration)
    {
        sReeti.rightEyePan(pos, duration);
    }

    public static void vsm_leftEyeLid(int pos, int duration)
    {
        sReeti.leftEyeLid(pos, duration);
    }

    public static void vsm_rightEyeLid(int pos, int duration)
    {
        sReeti.rightEyeLid(pos, duration);
    }

    public static void vsm_leftEar(int pos, int duration)
    {
        sReeti.leftEar(pos, duration);
    }

    public static void vsm_rightEar(int pos, int duration)
    {
        sReeti.rightEar(pos, duration);
    }

    public static void vsm_neckRotat(int pos, int duration)
    {
        sReeti.neckRotat(pos, duration);
    }

    public static void vsm_neckPan(int pos, int duration)
    {
        sReeti.neckPan(pos, duration);
    }

    public static void vsm_neckTilt(int pos, int duration)
    {
        sReeti.neckTilt(pos, duration);
    }

    public static void vsm_defaultPose()
    {
        sReeti.defaultPose();
    }
    ///////////////////////////////////////////////////////////////
    ///////////////////////END VSM STATIC STUFF////////////////////
    ///////////////////////////////////////////////////////////////

    @Override
    public void init()
    {
        this.setMaxHeight(Preferences.REETI_HEIGHT);
        this.setMinHeight(Preferences.REETI_HEIGHT);
        this.setPrefWidth(Control.USE_COMPUTED_SIZE);
        super.init();
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
//        mNeck = new Neck(mHead);
        mBody = new Body(mHead);
        mSpeechBubble = new SpeechBubbleReeti(mHead);
        sReeti = this;

        animationScheduler = new AnimationScheduler(this);
        animationScheduler.start();

        this.addAllParts();
    }

    @Override
    public AnimationReeti doEventFeedbackAnimation(String name, int duration, WordTimeMarkSequence wts, boolean block)
    {
        EventAnimationReeti a = AnimationLoaderReeti.getInstance().loadEventAnimation(this, name, duration, block);

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
    public AnimationReeti doAnimation(String name, int frequent, int actionDuration, boolean block)
    {
        AnimationReeti a = AnimationLoaderReeti.getInstance().loadAnimation(this, name, frequent, actionDuration, block);

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

    public AnimationReeti doAnimation(String name, int duration, Object param, boolean block)
    {
        AnimationReeti a = AnimationLoaderReeti.getInstance().loadAnimation(this, name, duration, block);

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

    public void update()
    {
        int scale_X_Pivot = (int) (Preferences.REETI_BODY_WIDTH/2);

        Scale scale = new Scale(mScale, mScale, scale_X_Pivot, Preferences.REETI_HEIGHT);

        this.getTransforms().add(scale);
    }

    private void addAllParts()
    {
        this.getChildren().addAll(mHead, mBody);
    }

    /**
     * @param color red, green, lightGreen, blue, darkBlue, turquoise, yellow, violer, white, swop
     */
    public void setLedColor(String color)
    {
        Color ledColor = checkColor(color);
        if (ledColor.equals(Color.BLACK))
        {
            ledOFF("B");
        } else
        {
            ledON(ledColor, ledColor, ledColor, 0.3f, 0.9f, 0.1f, "B");
        }
    }

    ///////////////////////////////////////////////////////////////
    /////////////////////////REETI METHODS/////////////////////////
    ///////////////////////////////////////////////////////////////

    /**
     * @param color red, green, lightGreen, blue, darkBlue, turquoise, yellow, violer, white, swop
     * @param led   left, right, both
     */
    public void setLedColor(String color, Led led)
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
        } else
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

    public void setLedColor(Color color, Led led)
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

        int size = ((LeftCheek) mLeftCheek).getSize();

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
            ((LeftCheek) mLeftCheek).getLed().setEffect(ledOnShadow);
            ((LeftCheek) mLeftCheek).getLed().setFill(highlightGradient);
            ((LeftCheek) mLeftCheek).getLedGroup().setVisible(true);
        } else if (cheek.equalsIgnoreCase("R"))
        {
            ((RightCheek) mRightCheek).getLed().setEffect(ledOnShadow);
            ((RightCheek) mRightCheek).getLed().setFill(highlightGradient);
            ((RightCheek) mRightCheek).getLedGroup().setVisible(true);
        } else if (cheek.equalsIgnoreCase("B"))
        {
            ((LeftCheek) mLeftCheek).getLed().setEffect(ledOnShadow);
            ((LeftCheek) mLeftCheek).getLed().setFill(highlightGradient);
            ((RightCheek) mRightCheek).getLed().setEffect(ledOnShadow);
            ((RightCheek) mRightCheek).getLed().setFill(highlightGradient);
            ((LeftCheek) mLeftCheek).getLedGroup().setVisible(true);
            ((RightCheek) mRightCheek).getLedGroup().setVisible(true);
        }
    }

    public void ledOFF(String cheek)
    {
        if (cheek.equalsIgnoreCase("R"))
        {
            ((RightCheek) mRightCheek).getLedGroup().setVisible(false);
        } else if (cheek.equalsIgnoreCase("L"))
        {
            ((LeftCheek) mLeftCheek).getLedGroup().setVisible(false);
        } else if (cheek.equalsIgnoreCase("B"))
        {
            ((RightCheek) mRightCheek).getLedGroup().setVisible(false);
            ((LeftCheek) mLeftCheek).getLedGroup().setVisible(false);
        }
    }

    /**
     * @param pos a int between 0 and 100 (default value is 50)
     */

    public void rightLC(int pos, double... duration)
    {
        double dur = (duration.length == 0) ? 500 : duration[0];
        if (pos > 100)
        {
            pos = 100;
        }
        pos = (pos * 16) / 100;
        double distance = mRightCornerOldPos - pos;
        ((MouthRightCorner) mMouthRightCorner).setRightCornerRegulator(distance);
        mRightCornerOldPos = pos;
        AnimationReeti a = AnimationLoaderReeti.getInstance().loadAnimation(this, "RightLC", (int) dur, pos, false);
        try
        {
            mAnimationLaunchControl.acquire();
            a.start();
        } catch (InterruptedException ex)
        {
            mLogger.severe(ex.getMessage());
        }
    }

    /**
     * @param pos a int between 0 and 100 (default value is 50)
     */
    public void leftLC(int pos, double... duration)
    {
        if (pos == -1)
            return;
        double dur = (duration.length == 0) ? 500 : duration[0];
        if (pos > 100)
        {
            pos = 100;
        }
        pos = (pos * 16) / 100;
        double distance = mLeftCornerOldPos - pos;
        ((MouthLeftCorner) mMouthLeftCorner).setLeftCornerRegulator(distance);
        mLeftCornerOldPos = pos;
        AnimationReeti a = AnimationLoaderReeti.getInstance().loadAnimation(this, "LeftLC", (int) dur, pos, false);
        try
        {
            mAnimationLaunchControl.acquire();
            a.start();
        } catch (InterruptedException ex)
        {
            mLogger.severe(ex.getMessage());
        }
    }

    /**
     * @param pos a int between 0 and 100 (default value is 0)
     */
    public void topLip(int pos, double... duration)
    {
        if (pos == -1)
            return;
        double dur = (duration.length == 0) ? 500 : duration[0];
        if (pos > 100)
        {
            pos = 100;
        }

        pos = (pos * 25) / 100;

        double distance = mUpperLipOldPos - pos;
        ((MouthUpperLip) mMouthUpperLip).setUpperLipRegulator(distance);
        mUpperLipOldPos = pos;

        AnimationReeti a = AnimationLoaderReeti.getInstance().loadAnimation(this, "UpperLip", (int) dur, pos, false);
        try
        {
            mAnimationLaunchControl.acquire();
            a.start();
        } catch (InterruptedException ex)
        {
            mLogger.severe(ex.getMessage());
        }
    }

    /**
     * @param pos a int between 0 and 100 (default value is 100)
     */
    public void bottomLip(int pos, double... duration)
    {
        if (pos == -1)
            return;
        double dur = (duration.length == 0) ? 500 : duration[0];
        if (pos > 100)
        {
            pos = 100;
        }

        pos = (pos * 20) / 100;

        double distance = pos - mDownLipOldPos;
        ((MouthDownLip) mMouthDownLip).setDownLipRegulator(-distance);
        mDownLipOldPos = pos;

        AnimationReeti a = AnimationLoaderReeti.getInstance().loadAnimation(this, "DownLip", (int) dur, pos, false);
        try
        {
            mAnimationLaunchControl.acquire();
            a.start();
        } catch (InterruptedException ex)
        {
            mLogger.severe(ex.getMessage());
        }
    }

    /**
     * @param pos a int between 0 and 100 (default value is 30)
     */
    public void leftEyeTilt(int pos, double... duration)
    {
        if (pos == -1)
            return;
        double dur = (duration.length == 0) ? 500 : duration[0];

        if (pos > 100)
            pos = 100;
        else if (pos < 20)
            pos = 20;

        double rot = mLeftEye_Y_OldPos - pos;
        mLeftEye_Y_OldPos = pos;

        AnimationReeti a = AnimationLoaderReeti.getInstance().loadAnimation(this, "LeftEye_X", (int) dur, (int) rot, false);
        try
        {
            mAnimationLaunchControl.acquire();
            a.start();
        } catch (InterruptedException ex)
        {
            mLogger.severe(ex.getMessage());
        }
    }

    /**
     * @param pos a int between 0 and 100 (default value is 40)
     */
    public void leftEyePan(int pos, double... duration)
    {
        if (pos == -1)
            return;
        double dur = (duration.length == 0) ? 500 : duration[0];
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
        } catch (InterruptedException ex)
        {
            mLogger.severe(ex.getMessage());
        }
    }

    /**
     * @param pos a int between 0 and 100 (default value is 30)
     */
    public void rightEyeTilt(int pos, double... duration)
    {
        if (pos == -1)
            return;
        double dur = (duration.length == 0) ? 500 : duration[0];

        if (pos > 100)
            pos = 100;
        else if (pos < 23)
            pos = 23;

        double rot = mRightEye_Y_OldPos - pos;
        mRightEye_Y_OldPos = pos;

        AnimationReeti a = AnimationLoaderReeti.getInstance().loadAnimation(this, "RightEye_X", (int) dur, (int) rot, false);
        try
        {
            mAnimationLaunchControl.acquire();
            a.start();
        } catch (InterruptedException ex)
        {
            mLogger.severe(ex.getMessage());
        }
    }

    /**
     * @param pos a int between 0 and 100 (default value is 60)
     */
    public void rightEyePan(int pos, double... duration)
    {
        if (pos == -1)
            return;
        double dur = (duration.length == 0) ? 500 : duration[0];
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
        } catch (InterruptedException ex)
        {
            mLogger.severe(ex.getMessage());
        }
    }

    /**
     * @param pos a int between 0 and 100 (default value is 100)
     */
    public void leftEyeLid(int pos, double... duration)
    {
        if (pos == -1)
            return;
        double dur = (duration.length == 0) ? 500 : duration[0];
        if (pos > 100)
        {
            pos = 100;
        }
        double rot = mLeftEyelidOldPos - pos;
        mLeftEyelidOldPos = pos;

        AnimationReeti a = AnimationLoaderReeti.getInstance().loadAnimation(this, "BlinkLeftEyelid", (int) dur, (int) rot, false);
        try
        {
            mAnimationLaunchControl.acquire();
            a.start();
        } catch (InterruptedException ex)
        {
            mLogger.severe(ex.getMessage());
        }
    }

    /**
     * @param pos a int between 0 and 100 (default value is 100)
     */
    public void rightEyeLid(int pos, double... duration)
    {
        if (pos == -1)
            return;
        double dur = (duration.length == 0) ? 500 : duration[0];
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
        } catch (InterruptedException ex)
        {
            mLogger.severe(ex.getMessage());
        }
    }

    /**
     * @param pos a int between 0 and 100 (default value is 50)
     */
    public void leftEar(int pos, double... duration)
    {
        if (pos == -1)
            return;
        double dur = (duration.length == 0) ? 500 : duration[0];
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
        } catch (InterruptedException ex)
        {
            mLogger.severe(ex.getMessage());
        }
    }

    /**
     * @param pos a int between 0 and 100 (default value is 50)
     */
    public void rightEar(int pos, double... duration)
    {
        if (pos == -1)
            return;
        double dur = (duration.length == 0) ? 500 : duration[0];
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
        } catch (InterruptedException ex)
        {
            mLogger.severe(ex.getMessage());
        }
    }

    /**
     * @param pos a int between 0 and 100 (default value is 50)
     */
    public void neckRotat(int pos, double... duration)
    {
        if (pos == -1)
            return;
        double dur = (duration.length == 0) ? 500 : duration[0];
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
        } catch (InterruptedException ex)
        {
            mLogger.severe(ex.getMessage());
        }
    }

    /**
     * @param pos a int between 0 and 100 (default value is 50)
     */
    public void neckTilt(int pos, double... duration)
    {
        if (pos == -1)
            return;

        double dur = (duration.length == 0) ? 500 : duration[0];
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
        } catch (InterruptedException ex)
        {
            mLogger.severe(ex.getMessage());
        }
    }

    /**
     * @param pos a int between 0 and 100 (default value is 50)
     */
    public void neckPan(int pos, double... duration)
    {
        if (pos == -1)
            return;
        double dur = (duration.length == 0) ? 500 : duration[0];
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
        } catch (InterruptedException ex)
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
        } catch (InterruptedException ex)
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

    ///////////////////////////////////////////////////////////////
    /////////////////////////END REETI METHODS/////////////////////
    ///////////////////////////////////////////////////////////////

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
