package de.dfki.stickman3D.body;

import de.dfki.common.Gender;
import de.dfki.stickman3D.mimic.util.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

import java.awt.*;

/**
 * @author Beka Aptsiauri
 */
public class RightEyebrow3D extends BodyPartFX
{

    public enum SHAPE
    {
        DEFAULT, FADEIN, FADEOUT, ANGRY, HAPPY, HAPPYEND, ANGRYEND, DISGUSTED, DISGUSTEDEND, SURPRISED, SURPRISEDEND, EXCITED, EXCITEDEND, EMBARRASSED, EMBARRASSEDEND, SAD, SADEND
    }

    private Head3D mHead;
    private Polygon currentPolygon;

    public RightEyebrow3D.SHAPE mShape = RightEyebrow3D.SHAPE.DEFAULT;

    public RightEyebrow3D(Head3D head)
    {
        mHead = head;
        mSize = new Dimension(mLength, 5);

        if (mHead.getStickman().mType == Gender.TYPE.MALE)
            mColor = Color.rgb(88, 44, 13, 1);
         else
            mColor = Color.rgb(204, 163, 0, 1);

        currentPolygon = new Polygon();

        mStart = mHead.getRightEyebrowPostion();

        init();

        mHead.getChildren().add(currentPolygon);
    }

    @Override
    public void init()
    {
        super.init();
        currentPolygon.setTranslateX(mStart.x - 9);
        currentPolygon.setTranslateY(mStart.y + 38);
        currentPolygon.setTranslateZ(-17);
    }

    @Override
    public void setShape(String s)
    {
        RightEyebrow3D.SHAPE shape = RightEyebrow3D.SHAPE.valueOf(s);
        mShape = (shape != null) ? shape : RightEyebrow3D.SHAPE.DEFAULT;
    }

    @Override
    public void resetShape()
    {
        mShape = RightEyebrow3D.SHAPE.DEFAULT;
    }

    @Override
    public void calculate(int step)
    {

        switch (mShape)
        {
            case DEFAULT:
                if (mHead.getStickman().mType == Gender.TYPE.MALE)
                {
                    currentPolygon = RightBrowDEFAULT.createMaleBrow(currentPolygon, step);
                } else
                {
                    currentPolygon = RightBrowDEFAULT.createFemaleBrow(currentPolygon, step);
                }
                currentPolygon.setFill(mColor);
                break;

            case FADEIN:
                if (step == 2)
                {
                    mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), 0.0);
                } else if (mColor.getOpacity() != 0.0)
                {
                    mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), mColor.getOpacity() - 0.052);
                }
                currentPolygon.setFill(mColor);
                break;

            case FADEOUT:
                if (step == 2)
                {
                    mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), 1.0);
                } else if (mColor.getOpacity() != 1.0)
                {
                    mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), mColor.getOpacity() + 0.052);
                }
                currentPolygon.setFill(mColor);
                break;

            case ANGRY:
                if (step == 20)
                {
                    if (mHead.getStickman().mType == Gender.TYPE.MALE)
                    {
                        currentPolygon = RightBrowDEFAULT.createMaleBrow(currentPolygon, step);
                    } else
                    {
                        currentPolygon = RightBrowDEFAULT.createFemaleBrow(currentPolygon, step);
                    }
                }
                currentPolygon = RightBrowANGRY.getANGRY(currentPolygon, step, "PLUS");
                break;

            case ANGRYEND:
                currentPolygon = RightBrowANGRY.getANGRY(currentPolygon, step, "MINUS");
                break;

            case DISGUSTED:
                if (step == 20)
                {
                    if (mHead.getStickman().mType == Gender.TYPE.MALE)
                    {
                        currentPolygon = RightBrowDEFAULT.createMaleBrow(currentPolygon, step);
                    } else
                    {
                        currentPolygon = RightBrowDEFAULT.createFemaleBrow(currentPolygon, step);
                    }
                }
                currentPolygon = RightBrowDISGUSTED.getANGRY(currentPolygon, step, "PLUS");
                break;

            case DISGUSTEDEND:
                currentPolygon = RightBrowDISGUSTED.getANGRY(currentPolygon, step, "MINUS");
                break;

            case SURPRISED:
                if (step == 20)
                {
                    if (mHead.getStickman().mType == Gender.TYPE.MALE)
                    {
                        currentPolygon = RightBrowDEFAULT.createMaleBrow(currentPolygon, step);
                    } else
                    {
                        currentPolygon = RightBrowDEFAULT.createFemaleBrow(currentPolygon, step);
                    }
                }
                currentPolygon = RightBrowSURPRISED.getANGRY(currentPolygon, step, "PLUS");
                break;

            case SURPRISEDEND:
                currentPolygon = RightBrowSURPRISED.getANGRY(currentPolygon, step, "MINUS");
                break;

            case EXCITED:
                if (step == 20)
                {
                    if (mHead.getStickman().mType == Gender.TYPE.MALE)
                    {
                        currentPolygon = RightBrowDEFAULT.createMaleBrow(currentPolygon, step);
                    } else
                    {
                        currentPolygon = RightBrowDEFAULT.createFemaleBrow(currentPolygon, step);
                    }
                }
                currentPolygon = RightBrowEXCITED.getANGRY(currentPolygon, step, "PLUS");
                break;

            case EXCITEDEND:
                currentPolygon = RightBrowEXCITED.getANGRY(currentPolygon, step, "MINUS");
                break;

            case EMBARRASSED:
                if (step == 20)
                {
                    if (mHead.getStickman().mType == Gender.TYPE.MALE)
                    {
                        currentPolygon = RightBrowDEFAULT.createMaleBrow(currentPolygon, step);
                    } else
                    {
                        currentPolygon = RightBrowDEFAULT.createFemaleBrow(currentPolygon, step);
                    }
                }
                if (mHead.getStickman().mType == Gender.TYPE.MALE)
                {
                    currentPolygon = LeftBrowEMBARRASSED.getEMBARRASSED(currentPolygon, step, "PLUS", true);
                } else
                {
                    currentPolygon = LeftBrowEMBARRASSED.getEMBARRASSED(currentPolygon, step, "PLUS", false);
                }
                break;

            case EMBARRASSEDEND:
                if (mHead.getStickman().mType == Gender.TYPE.MALE)
                {
                    currentPolygon = LeftBrowEMBARRASSED.getEMBARRASSED(currentPolygon, step, "minus", true);
                } else
                {
                    currentPolygon = LeftBrowEMBARRASSED.getEMBARRASSED(currentPolygon, step, "minus", false);
                }
                break;

            case HAPPY:
                if (step == 20)
                {
                    if (mHead.getStickman().mType == Gender.TYPE.MALE)
                    {
                        currentPolygon = RightBrowDEFAULT.createMaleBrow(currentPolygon, step);
                    } else
                    {
                        currentPolygon = RightBrowDEFAULT.createFemaleBrow(currentPolygon, step);
                    }
                }
                currentPolygon = RightBrowHAPPY.getANGRY(currentPolygon, step, "PLUS");
                break;

            case HAPPYEND:
                currentPolygon = RightBrowHAPPY.getANGRY(currentPolygon, step, "MINUS");
                break;

            case SAD:
                if (step == 20)
                {
                    if (mHead.getStickman().mType == Gender.TYPE.MALE)
                    {
                        currentPolygon = RightBrowDEFAULT.createMaleBrow(currentPolygon, step);
                    } else
                    {
                        currentPolygon = RightBrowDEFAULT.createFemaleBrow(currentPolygon, step);
                    }
                }
                currentPolygon = RightBrowSAD.getANGRY(currentPolygon, step, "PLUS");
                break;

            case SADEND:
                currentPolygon = RightBrowSAD.getANGRY(currentPolygon, step, "MINUS");
                break;

        }
    }

    public void update()
    {
        currentPolygon.setFill(mColor);
    }

    protected void recordColor()
    {
        if (mHead.getStickman().setCharacterInvisible == false)
        {
            mColorRecorder = mColor;
        }
    }
}
