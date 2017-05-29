package de.dfki.stickman3D.body;

import de.dfki.stickman3D.mimic.util.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

import java.awt.*;

import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.QuadCurveTo;

/**
 * @author Beka Aptsiauri
 */
public class Mouth3D extends BodyPartFX
{

    public enum SHAPE
    {
        DEFAULT, FADEIN, FADEOUT, SMILE, SMILEEND, SAD, SADEND, ANGRY, ANGRYEND, ANGRYSMALLMOUTH, ANGRYSMALLMOUTHEND, SURPRISED, SURPRISEDEND, HAPPY, HAPPYEND, DISGUSTED, DISGUSTEDEND, CONTEMPT, CONTEMPTEND, EXCITED, EXCITEDEND, EMBARRASSED, EMBARRASSEDEND, FEAR, FEAREND, O, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, ELEVEN, TWELVE, THIRTEEN, FOURTEEN, NINETEEN, TWENTY,
    }

    private Head3D mHead;

    public Polygon currentDownLipPolygon;
    public Polygon currentUpperLipPolygon;

    public Mouth3D.SHAPE mShape = Mouth3D.SHAPE.DEFAULT;

    public Mouth3D(Head3D head)
    {
        mHead = head;
        mSize = new Dimension(mLength * 2, 5);
        mColor = Color.rgb(230, 174, 161, 1.0);

        currentUpperLipPolygon = new Polygon();
        currentDownLipPolygon = new Polygon();
        mStart = mHead.getMouthPostion();

        init();

        mHead.getChildren().addAll(currentUpperLipPolygon, currentDownLipPolygon);
    }

    @Override
    public void init()
    {
        super.init();
        currentUpperLipPolygon.setTranslateX(mStart.x - 15);
        currentUpperLipPolygon.setTranslateY(mStart.y + 95);
        currentUpperLipPolygon.setTranslateZ(-17);

        currentDownLipPolygon.setTranslateX(mStart.x - 15);
        currentDownLipPolygon.setTranslateY(mStart.y + 94);
        currentDownLipPolygon.setTranslateZ(-17);
    }

    @Override
    public void setShape(String s)
    {
        Mouth3D.SHAPE shape = Mouth3D.SHAPE.valueOf(s);
        mShape = (shape != null) ? shape : Mouth3D.SHAPE.DEFAULT;
    }

    @Override
    public void resetShape()
    {
        mShape = Mouth3D.SHAPE.DEFAULT;
    }

    @Override
    public void calculate(int step)
    {

        boolean isFadeIn = false;
        Path upperLip;
        Path downLip;
        int x;
        int y;

        switch (mShape)
        {
            case DEFAULT:
                currentUpperLipPolygon = MouthDEFAULT.modifyUpperLip(currentUpperLipPolygon, step);
                currentDownLipPolygon = MouthDEFAULT.modifyDownLip(currentDownLipPolygon, step);
                currentUpperLipPolygon.setFill(mColor);
                currentDownLipPolygon.setFill(mColor);
                if (mHead.getChildren().size() >= 10)
                {
                    mHead.getChildren().set(9, currentUpperLipPolygon);
                    mHead.getChildren().set(10, currentDownLipPolygon);
                }

                break;

            case FADEIN:
                if (step == 2)
                {
                    mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), 0.0);
                    currentUpperLipPolygon.setVisible(false);
                    currentDownLipPolygon.setVisible(false);
                } else if (mColor.getOpacity() != 0.0)
                {
                    mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), mColor.getOpacity() - 0.052);
                }
                break;

            case FADEOUT:
                currentUpperLipPolygon.setVisible(true);
                currentDownLipPolygon.setVisible(true);

                if (step == 2)
                {
                    mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), 1.0);
                    isFadeIn = true;
                } else if (mColor.getOpacity() != 1.0)
                {
                    mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), mColor.getOpacity() + 0.052);
                }
                break;

            case SMILE:
                currentUpperLipPolygon = MouthDEFAULT.modifyUpperLip(currentUpperLipPolygon, step);
                currentDownLipPolygon = MouthDEFAULT.modifyDownLip(currentDownLipPolygon, step);
                currentUpperLipPolygon = MouthSMILE.modifyUpperLip(currentUpperLipPolygon, step, "plus");
                currentDownLipPolygon = MouthSMILE.modifyDownLip(currentDownLipPolygon, step, "plus");
                break;

            case SMILEEND:
                if (step == 2)
                {
                    currentDownLipPolygon = MouthDEFAULT.modifyDownLip(currentDownLipPolygon, 0);
                    currentUpperLipPolygon = MouthDEFAULT.modifyUpperLip(currentUpperLipPolygon, 0);
                } else
                {
                    currentUpperLipPolygon = MouthSMILE.modifyUpperLip(currentUpperLipPolygon, step, "minus");
                    currentDownLipPolygon = MouthSMILE.modifyDownLip(currentDownLipPolygon, step, "minus");
                }
                break;

            case SAD:
                currentUpperLipPolygon = MouthDEFAULT.modifyUpperLip(currentUpperLipPolygon, step);
                currentDownLipPolygon = MouthDEFAULT.modifyDownLip(currentDownLipPolygon, step);
                currentUpperLipPolygon = MouthSAD.modifyUpperLip(currentUpperLipPolygon, step, "plus");
                currentDownLipPolygon = MouthSAD.modifyDownLip(currentDownLipPolygon, step, "plus");
                break;
            case SADEND:
                if (step == 2)
                {
                    currentDownLipPolygon = MouthDEFAULT.modifyDownLip(currentDownLipPolygon, 0);
                    currentUpperLipPolygon = MouthDEFAULT.modifyUpperLip(currentUpperLipPolygon, 0);
                } else
                {
                    currentUpperLipPolygon = MouthSAD.modifyUpperLip(currentUpperLipPolygon, step, "minus");
                    currentDownLipPolygon = MouthSAD.modifyDownLip(currentDownLipPolygon, step, "minus");
                }
                break;
            case ANGRY:
                currentUpperLipPolygon = MouthDEFAULT.modifyUpperLip(currentUpperLipPolygon, step);
                currentDownLipPolygon = MouthDEFAULT.modifyDownLip(currentDownLipPolygon, step);
                currentUpperLipPolygon = MouthANGRY.modifyUpperLip(currentUpperLipPolygon, step, "plus");
                currentDownLipPolygon = MouthANGRY.modifyDownLip(currentDownLipPolygon, step, "plus");
                break;
            case ANGRYEND:
                if (step == 2)
                {
                    currentDownLipPolygon = MouthDEFAULT.modifyDownLip(currentDownLipPolygon, 0);
                    currentUpperLipPolygon = MouthDEFAULT.modifyUpperLip(currentUpperLipPolygon, 0);
                } else
                {
                    currentUpperLipPolygon = MouthANGRY.modifyUpperLip(currentUpperLipPolygon, step, "minus");
                    currentDownLipPolygon = MouthANGRY.modifyDownLip(currentDownLipPolygon, step, "minus");
                }
                break;
            case ANGRYSMALLMOUTH:
                currentUpperLipPolygon = MouthDEFAULT.modifyUpperLip(currentUpperLipPolygon, step);
                currentDownLipPolygon = MouthDEFAULT.modifyDownLip(currentDownLipPolygon, step);
                currentUpperLipPolygon = MouthANGRYSMALLMOUTH.modifyUpperLip(currentUpperLipPolygon, step, "plus");
                currentDownLipPolygon = MouthANGRYSMALLMOUTH.modifyDownLip(currentDownLipPolygon, step, "plus");
                break;
            case ANGRYSMALLMOUTHEND:
                if (step == 2)
                {
                    currentDownLipPolygon = MouthDEFAULT.modifyDownLip(currentDownLipPolygon, 0);
                    currentUpperLipPolygon = MouthDEFAULT.modifyUpperLip(currentUpperLipPolygon, 0);
                } else
                {
                    currentUpperLipPolygon = MouthANGRYSMALLMOUTH.modifyUpperLip(currentUpperLipPolygon, step, "minus");
                    currentDownLipPolygon = MouthANGRYSMALLMOUTH.modifyDownLip(currentDownLipPolygon, step, "minus");
                }
                break;
            case SURPRISED:
                currentUpperLipPolygon = MouthDEFAULT.modifyUpperLip(currentUpperLipPolygon, step);
                currentDownLipPolygon = MouthDEFAULT.modifyDownLip(currentDownLipPolygon, step);
                currentUpperLipPolygon = MouthSURPRISED.modifyUpperLip(currentUpperLipPolygon, step, "plus");
                currentDownLipPolygon = MouthSURPRISED.modifyDownLip(currentDownLipPolygon, step, "plus");
                break;
            case SURPRISEDEND:
                if (step == 2)
                {
                    currentDownLipPolygon = MouthDEFAULT.modifyDownLip(currentDownLipPolygon, 0);
                    currentUpperLipPolygon = MouthDEFAULT.modifyUpperLip(currentUpperLipPolygon, 0);
                } else
                {
                    currentUpperLipPolygon = MouthSURPRISED.modifyUpperLip(currentUpperLipPolygon, step, "minus");
                    currentDownLipPolygon = MouthSURPRISED.modifyDownLip(currentDownLipPolygon, step, "minus");
                }
                break;

            case HAPPY:
                currentUpperLipPolygon = MouthDEFAULT.modifyUpperLip(currentUpperLipPolygon, step);
                currentDownLipPolygon = MouthDEFAULT.modifyDownLip(currentDownLipPolygon, step);
                currentUpperLipPolygon = MouthHAPPY.modifyUpperLip(currentUpperLipPolygon, step, "plus");
                currentDownLipPolygon = MouthHAPPY.modifyDownLip(currentDownLipPolygon, step, "plus");
                break;

            case HAPPYEND:
                if (step == 2)
                {
                    currentDownLipPolygon = MouthDEFAULT.modifyDownLip(currentDownLipPolygon, 0);
                    currentUpperLipPolygon = MouthDEFAULT.modifyUpperLip(currentUpperLipPolygon, 0);
                } else
                {
                    currentUpperLipPolygon = MouthHAPPY.modifyUpperLip(currentUpperLipPolygon, step, "minus");
                    currentDownLipPolygon = MouthHAPPY.modifyDownLip(currentDownLipPolygon, step, "minus");
                }
                break;
            case DISGUSTED:
                currentUpperLipPolygon = MouthDEFAULT.modifyUpperLip(currentUpperLipPolygon, step);
                currentDownLipPolygon = MouthDEFAULT.modifyDownLip(currentDownLipPolygon, step);
                currentUpperLipPolygon = MouthDISGUSTED.modifyUpperLip(currentUpperLipPolygon, step, "plus");
                currentDownLipPolygon = MouthDISGUSTED.modifyDownLip(currentDownLipPolygon, step, "plus");
                break;

            case DISGUSTEDEND:
                if (step == 2)
                {
                    currentDownLipPolygon = MouthDEFAULT.modifyDownLip(currentDownLipPolygon, 0);
                    currentUpperLipPolygon = MouthDEFAULT.modifyUpperLip(currentUpperLipPolygon, 0);
                } else
                {
                    currentUpperLipPolygon = MouthDISGUSTED.modifyUpperLip(currentUpperLipPolygon, step, "minus");
                    currentDownLipPolygon = MouthDISGUSTED.modifyDownLip(currentDownLipPolygon, step, "minus");
                }
                break;
            case CONTEMPT:
                currentUpperLipPolygon = MouthDEFAULT.modifyUpperLip(currentUpperLipPolygon, step);
                currentDownLipPolygon = MouthDEFAULT.modifyDownLip(currentDownLipPolygon, step);
                currentUpperLipPolygon = MouthCONTEMPT.modifyUpperLip(currentUpperLipPolygon, step, "plus");
                currentDownLipPolygon = MouthCONTEMPT.modifyDownLip(currentDownLipPolygon, step, "plus");
                break;

            case CONTEMPTEND:
                if (step == 2)
                {
                    currentDownLipPolygon = MouthDEFAULT.modifyDownLip(currentDownLipPolygon, 0);
                    currentUpperLipPolygon = MouthDEFAULT.modifyUpperLip(currentUpperLipPolygon, 0);
                } else
                {
                    currentUpperLipPolygon = MouthCONTEMPT.modifyUpperLip(currentUpperLipPolygon, step, "minus");
                    currentDownLipPolygon = MouthCONTEMPT.modifyDownLip(currentDownLipPolygon, step, "minus");
                }
                break;

            case FEAR:
                currentUpperLipPolygon = MouthDEFAULT.modifyUpperLip(currentUpperLipPolygon, step);
                currentDownLipPolygon = MouthDEFAULT.modifyDownLip(currentDownLipPolygon, step);
                currentUpperLipPolygon = MouthFEAR.modifyUpperLip(currentUpperLipPolygon, step, "plus");
                currentDownLipPolygon = MouthFEAR.modifyDownLip(currentDownLipPolygon, step, "plus");
                break;

            case FEAREND:
                if (step == 2)
                {
                    currentDownLipPolygon = MouthDEFAULT.modifyDownLip(currentDownLipPolygon, 0);
                    currentUpperLipPolygon = MouthDEFAULT.modifyUpperLip(currentUpperLipPolygon, 0);
                } else
                {
                    currentUpperLipPolygon = MouthFEAR.modifyUpperLip(currentUpperLipPolygon, step, "minus");
                    currentDownLipPolygon = MouthFEAR.modifyDownLip(currentDownLipPolygon, step, "minus");
                }
                break;
            case EXCITED:
                currentUpperLipPolygon = MouthDEFAULT.modifyUpperLip(currentUpperLipPolygon, step);
                currentDownLipPolygon = MouthDEFAULT.modifyDownLip(currentDownLipPolygon, step);
                currentUpperLipPolygon = MouthEXCITED.modifyUpperLip(currentUpperLipPolygon, step, "plus");
                currentDownLipPolygon = MouthEXCITED.modifyDownLip(currentDownLipPolygon, step, "plus");
                break;

            case EXCITEDEND:
                if (step == 2)
                {
                    currentDownLipPolygon = MouthDEFAULT.modifyDownLip(currentDownLipPolygon, 0);
                    currentUpperLipPolygon = MouthDEFAULT.modifyUpperLip(currentUpperLipPolygon, 0);
                } else
                {
                    currentUpperLipPolygon = MouthEXCITED.modifyUpperLip(currentUpperLipPolygon, step, "minus");
                    currentDownLipPolygon = MouthEXCITED.modifyDownLip(currentDownLipPolygon, step, "minus");
                }
                break;

            case EMBARRASSED:
                currentUpperLipPolygon = MouthDEFAULT.modifyUpperLip(currentUpperLipPolygon, step);
                currentDownLipPolygon = MouthDEFAULT.modifyDownLip(currentDownLipPolygon, step);
                currentUpperLipPolygon = MouthEMBARRASSED.modifyUpperLip(currentUpperLipPolygon, step, "plus");
                currentDownLipPolygon = MouthEMBARRASSED.modifyDownLip(currentDownLipPolygon, step, "plus");
                break;
            case EMBARRASSEDEND:
                if (step == 2)
                {
                    currentDownLipPolygon = MouthDEFAULT.modifyDownLip(currentDownLipPolygon, 0);
                    currentUpperLipPolygon = MouthDEFAULT.modifyUpperLip(currentUpperLipPolygon, 0);
                } else
                {
                    currentUpperLipPolygon = MouthEMBARRASSED.modifyUpperLip(currentUpperLipPolygon, step, "minus");
                    currentDownLipPolygon = MouthEMBARRASSED.modifyDownLip(currentDownLipPolygon, step, "minus");
                }
                break;
            case O:
                currentUpperLipPolygon = MouthO.modifyUpperLip(currentUpperLipPolygon, step);
                currentDownLipPolygon = MouthO.modifyDownLip(currentDownLipPolygon, step);
                break;

            case ONE:
                upperLip = new Path();
                x = mStart.x - 11;
                y = mStart.y + 95;
                upperLip.setStrokeWidth(3);
                upperLip.setStroke(mColor);
                upperLip.getElements().add(new MoveTo(x, y));
                upperLip.getElements().add(new QuadCurveTo(x + 12, y - 5, x + 24, y));
                upperLip.setTranslateZ(-18);

                downLip = new Path();
                downLip.setStrokeWidth(3);
                downLip.setStroke(mColor);
                downLip.getElements().add(new MoveTo(x + 24, y));
                downLip.getElements().add(new QuadCurveTo(x + 12, y + 5, x, y));
                downLip.setTranslateZ(-18);

                mHead.getChildren().set(9, upperLip);
                mHead.getChildren().set(10, downLip);
            case SIX:
            case FOURTEEN:
            case NINETEEN:
                break;

            case TWO:
                upperLip = new Path();
                x = mStart.x - 11;
                y = mStart.y + 95;
                upperLip.setStrokeWidth(3);
                upperLip.setStroke(mColor);
                upperLip.getElements().add(new MoveTo(x, y));
                upperLip.getElements().add(new QuadCurveTo(x + 12, y - 15, x + 24, y));
                upperLip.setTranslateZ(-18);

                downLip = new Path();
                downLip.setStrokeWidth(3);
                downLip.setStroke(mColor);
                downLip.getElements().add(new MoveTo(x + 24, y));
                downLip.getElements().add(new QuadCurveTo(x + 12, y + 15, x, y));
                downLip.setTranslateZ(-18);

                mHead.getChildren().set(9, upperLip);
                mHead.getChildren().set(10, downLip);
                break;

            case THREE:
                upperLip = new Path();
                x = mStart.x - 8;
                y = mStart.y + 95;
                upperLip.setStrokeWidth(3);
                upperLip.setStroke(mColor);
                upperLip.getElements().add(new MoveTo(x, y));
                upperLip.getElements().add(new QuadCurveTo(x + 9, y - 12, x + 18, y));
                upperLip.setTranslateZ(-18);

                downLip = new Path();
                downLip.setStrokeWidth(3);
                downLip.setStroke(mColor);
                downLip.getElements().add(new MoveTo(x + 18, y));
                downLip.getElements().add(new QuadCurveTo(x + 9, y + 12, x, y));
                downLip.setTranslateZ(-18);

                mHead.getChildren().set(9, upperLip);
                mHead.getChildren().set(10, downLip);
            case TWENTY:
                break;

            case FOUR:
                upperLip = new Path();
                x = mStart.x - 11;
                y = mStart.y + 95;
                upperLip.setStrokeWidth(3);
                upperLip.setStroke(mColor);
                upperLip.getElements().add(new MoveTo(x, y));
                upperLip.getElements().add(new QuadCurveTo(x + 12, y - 4, x + 24, y));
                upperLip.setTranslateZ(-18);

                downLip = new Path();
                downLip.setStrokeWidth(3);
                downLip.setStroke(mColor);
                downLip.getElements().add(new MoveTo(x + 24, y));
                downLip.getElements().add(new QuadCurveTo(x + 12, y + 10, x, y));
                downLip.setTranslateZ(-18);

                mHead.getChildren().set(9, upperLip);
                mHead.getChildren().set(10, downLip);
                break;

            case FIVE:
                upperLip = new Path();
                x = mStart.x - 11;
                y = mStart.y + 95;
                upperLip.setStrokeWidth(3);
                upperLip.setStroke(mColor);
                upperLip.getElements().add(new MoveTo(x, y));
                upperLip.getElements().add(new QuadCurveTo(x + 12, y - 10, x + 24, y));
                upperLip.setTranslateZ(-18);

                downLip = new Path();
                downLip.setStrokeWidth(3);
                downLip.setStroke(mColor);
                downLip.getElements().add(new MoveTo(x + 24, y));
                downLip.getElements().add(new QuadCurveTo(x + 12, y + 10, x, y));
                downLip.setTranslateZ(-18);

                mHead.getChildren().set(9, upperLip);
                mHead.getChildren().set(10, downLip);
            case EIGHT:
                upperLip = new Path();
                x = mStart.x - 11;
                y = mStart.y + 95;
                upperLip.setStrokeWidth(3);
                upperLip.setStroke(mColor);
                upperLip.getElements().add(new MoveTo(x, y));
                upperLip.getElements().add(new QuadCurveTo(x + 12, y - 10, x + 24, y));
                upperLip.setTranslateZ(-18);

                downLip = new Path();
                downLip.setStrokeWidth(3);
                downLip.setStroke(mColor);
                downLip.getElements().add(new MoveTo(x + 24, y));
                downLip.getElements().add(new QuadCurveTo(x + 12, y + 10, x, y));
                downLip.setTranslateZ(-18);

                mHead.getChildren().set(9, upperLip);
                mHead.getChildren().set(10, downLip);
                break;

            case SEVEN:
                upperLip = new Path();
                x = mStart.x - 8;
                y = mStart.y + 95;
                upperLip.setStrokeWidth(3);
                upperLip.setStroke(mColor);
                upperLip.getElements().add(new MoveTo(x, y));
                upperLip.getElements().add(new QuadCurveTo(x + 9, y - 3, x + 18, y));
                upperLip.setTranslateZ(-18);

                downLip = new Path();
                downLip.setStrokeWidth(3);
                downLip.setStroke(mColor);
                downLip.getElements().add(new MoveTo(x + 18, y));
                downLip.getElements().add(new QuadCurveTo(x + 9, y + 3, x, y));
                downLip.setTranslateZ(-18);

                mHead.getChildren().set(9, upperLip);
                mHead.getChildren().set(10, downLip);
                break;

            case NINE:
                currentDownLipPolygon = MouthFOUR.modifyDownLip(currentDownLipPolygon, step);
                break;

            case TEN:
                currentDownLipPolygon = MouthFOUR.modifyDownLip(currentDownLipPolygon, step);
                break;

        }
    }

    @Override
    public void update()
    {
        currentUpperLipPolygon.setFill(mColor);
        currentDownLipPolygon.setFill(mColor);
    }

    @Override
    protected void recordColor()
    {
        if (mHead.getStickman().setCharacterInvisible == false)
        {
            mColorRecorder = mColor;
        }
    }
}
