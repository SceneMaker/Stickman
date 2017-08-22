package de.dfki.stickman3D.body;

import de.dfki.common.enums.Gender;
import de.dfki.common.part.Part3D;
import de.dfki.common.util.Preferences;
import de.dfki.stickman3D.mimic.util.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

import java.awt.*;

/**
 * @author Beka Aptsiauri
 */
public class RightEyebrow3D extends Brow
{
    public RightEyebrow3D(Part3D head)
    {
        super(head);
        mStart = mHead.getRightEyebrowPosition();
        currentPolygon.setTranslateX(Preferences.LEFT_BROW_X_POS + 9);

        this.getChildren().add(currentPolygon);
        mHead.getChildren().add(this);
        init();
    }

    @Override
    public void setShape(String s)
    {
        mShape = SHAPE.valueOf(s);
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
        if (!mHead.getStickman().setCharacterInvisible)
        {
            mColorRecorder = mColor;
        }
    }
}
