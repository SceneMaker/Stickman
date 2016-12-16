package de.dfki.stickman3D.body;

import de.dfki.stickman3D.mimic.util.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

import java.awt.*;

/**
 *
 * @author Beka Aptsiauri
 *
 */
public class MouthFX extends BodyPartFX {

    public static enum SHAPE {
        DEFAULT, FADEIN, FADEOUT, SMILE, SMILEEND, SAD, SADEND, ANGRY, ANGRYEND, ANGRYSMALLMOUTH, ANGRYSMALLMOUTHEND, SURPRISED, SURPRISEDEND, HAPPY, HAPPYEND, DISGUSTED, DISGUSTEDEND, CONTEMPT, CONTEMPTEND, EXCITED, EXCITEDEND, EMBARRASSED, EMBARRASSEDEND, FEAR, FEAREND, O, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, ELEVEN, TWELVE, THIRTEEN, FOURTEEN, NINETEEN, TWENTY,
    };

    HeadFX mHeadFX;

    public Polygon currentDownLipPolygon;
    public Polygon currentUpperLipPolygon;

    public MouthFX.SHAPE mShape = MouthFX.SHAPE.DEFAULT;

    public MouthFX(HeadFX head) {
        mHeadFX = head;
        mSize = new Dimension(mLength * 2, 5);

        mColor = Color.rgb(230, 174, 161, 1.0);

        currentUpperLipPolygon = new Polygon();
        currentDownLipPolygon = new Polygon();
        mStart = mHeadFX.getMouthPostion();

        init();

        mHeadFX.mHead.getChildren().addAll(currentUpperLipPolygon, currentDownLipPolygon);
    }

    @Override
    public void init() {
        super.init();
        currentUpperLipPolygon.setTranslateX(mStart.x - 15);
        currentUpperLipPolygon.setTranslateY(mStart.y + 95);
        currentUpperLipPolygon.setTranslateZ(-17);

        currentDownLipPolygon.setTranslateX(mStart.x - 15);
        currentDownLipPolygon.setTranslateY(mStart.y + 94);
        currentDownLipPolygon.setTranslateZ(-17);
    }

    @Override
    public void setShape(String s) {
        MouthFX.SHAPE shape = MouthFX.SHAPE.valueOf(s);
        mShape = (shape != null) ? shape : MouthFX.SHAPE.DEFAULT;
    }

    @Override
    public void resetShape() {
        mShape = MouthFX.SHAPE.DEFAULT;
    }

    @Override
    public void calculate(int step) {

        boolean isFadeIn = false;

        switch (mShape) {
            case DEFAULT:
                currentUpperLipPolygon = MouthDEFAULT.modifyUpperLip(currentUpperLipPolygon, step);
                currentDownLipPolygon = MouthDEFAULT.modifyDownLip(currentDownLipPolygon, step);
                currentUpperLipPolygon.setFill(mColor);
                currentDownLipPolygon.setFill(mColor);
                break;

            case FADEIN:
                if (step == 2) {
                    mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), 0.0);
                    currentUpperLipPolygon.setVisible(false);
                    currentDownLipPolygon.setVisible(false);
                } else if (mColor.getOpacity() != 0.0) {
                    mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), mColor.getOpacity() - 0.052);
                }
                break;

            case FADEOUT:
                currentUpperLipPolygon.setVisible(true);
                currentDownLipPolygon.setVisible(true);

                if (step == 2) {
                    mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), 1.0);
                    isFadeIn = true;
                } else if (mColor.getOpacity() != 1.0) {
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
                if (step == 2) {
                    currentDownLipPolygon = MouthDEFAULT.modifyDownLip(currentDownLipPolygon, 0);
                    currentUpperLipPolygon = MouthDEFAULT.modifyUpperLip(currentUpperLipPolygon, 0);
                } else {
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
                if (step == 2) {
                    currentDownLipPolygon = MouthDEFAULT.modifyDownLip(currentDownLipPolygon, 0);
                    currentUpperLipPolygon = MouthDEFAULT.modifyUpperLip(currentUpperLipPolygon, 0);
                } else {
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
                if (step == 2) {
                    currentDownLipPolygon = MouthDEFAULT.modifyDownLip(currentDownLipPolygon, 0);
                    currentUpperLipPolygon = MouthDEFAULT.modifyUpperLip(currentUpperLipPolygon, 0);
                } else {
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
                if (step == 2) {
                    currentDownLipPolygon = MouthDEFAULT.modifyDownLip(currentDownLipPolygon, 0);
                    currentUpperLipPolygon = MouthDEFAULT.modifyUpperLip(currentUpperLipPolygon, 0);
                } else {
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
                if (step == 2) {
                    currentDownLipPolygon = MouthDEFAULT.modifyDownLip(currentDownLipPolygon, 0);
                    currentUpperLipPolygon = MouthDEFAULT.modifyUpperLip(currentUpperLipPolygon, 0);
                } else {
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
                if (step == 2) {
                    currentDownLipPolygon = MouthDEFAULT.modifyDownLip(currentDownLipPolygon, 0);
                    currentUpperLipPolygon = MouthDEFAULT.modifyUpperLip(currentUpperLipPolygon, 0);
                } else {
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
                if (step == 2) {
                    currentDownLipPolygon = MouthDEFAULT.modifyDownLip(currentDownLipPolygon, 0);
                    currentUpperLipPolygon = MouthDEFAULT.modifyUpperLip(currentUpperLipPolygon, 0);
                } else {
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
                if (step == 2) {
                    currentDownLipPolygon = MouthDEFAULT.modifyDownLip(currentDownLipPolygon, 0);
                    currentUpperLipPolygon = MouthDEFAULT.modifyUpperLip(currentUpperLipPolygon, 0);
                } else {
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
                if (step == 2) {
                    currentDownLipPolygon = MouthDEFAULT.modifyDownLip(currentDownLipPolygon, 0);
                    currentUpperLipPolygon = MouthDEFAULT.modifyUpperLip(currentUpperLipPolygon, 0);
                } else {
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
                if (step == 2) {
                    currentDownLipPolygon = MouthDEFAULT.modifyDownLip(currentDownLipPolygon, 0);
                    currentUpperLipPolygon = MouthDEFAULT.modifyUpperLip(currentUpperLipPolygon, 0);
                } else {
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
                if (step == 2) {
                    currentDownLipPolygon = MouthDEFAULT.modifyDownLip(currentDownLipPolygon, 0);
                    currentUpperLipPolygon = MouthDEFAULT.modifyUpperLip(currentUpperLipPolygon, 0);
                } else {
                    currentUpperLipPolygon = MouthEMBARRASSED.modifyUpperLip(currentUpperLipPolygon, step, "minus");
                    currentDownLipPolygon = MouthEMBARRASSED.modifyDownLip(currentDownLipPolygon, step, "minus");
                }
                break;
            case O:
                currentUpperLipPolygon = MouthO.modifyUpperLip(currentUpperLipPolygon, step);
                currentDownLipPolygon = MouthO.modifyDownLip(currentDownLipPolygon, step);
                break;

            case ONE:
                currentUpperLipPolygon = MouthONE.modifyUpperLip(currentUpperLipPolygon, step);
                currentDownLipPolygon = MouthONE.modifyDownLip(currentDownLipPolygon, step);
            case SIX:
            case FOURTEEN:
            case NINETEEN:
                break;

            case TWO:
                currentUpperLipPolygon = MouthTWO.modifyUpperLip(currentUpperLipPolygon, step);
                currentDownLipPolygon = MouthTWO.modifyDownLip(currentDownLipPolygon, step);
                break;

            case THREE:
                currentUpperLipPolygon = MouthTREE.modifyUpperLip(currentUpperLipPolygon, step);
                currentDownLipPolygon = MouthTREE.modifyDownLip(currentDownLipPolygon, step);
            case TWENTY:
                break;

            case FOUR:
                currentUpperLipPolygon = MouthFOUR.modifyUpperLip(currentUpperLipPolygon, step);
                currentDownLipPolygon = MouthFOUR.modifyDownLip(currentDownLipPolygon, step);
                break;

            case FIVE:
                currentUpperLipPolygon = MouthFIVE.modifyUpperLip(currentUpperLipPolygon, step);
                currentDownLipPolygon = MouthFIVE.modifyDownLip(currentDownLipPolygon, step);
            case EIGHT:
                currentUpperLipPolygon = MouthFIVE.modifyUpperLip(currentUpperLipPolygon, step);
                currentDownLipPolygon = MouthFIVE.modifyDownLip(currentDownLipPolygon, step);
                break;

            case SEVEN:
                currentUpperLipPolygon = MouthSEVEN.modifyUpperLip(currentUpperLipPolygon, step);
                currentDownLipPolygon = MouthSEVEN.modifyDownLip(currentDownLipPolygon, step);
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
    public void update() {
        currentUpperLipPolygon.setFill(mColor);
        currentDownLipPolygon.setFill(mColor);
    }

    @Override
    protected void recordColor() {
        if (mHeadFX.mStickmanFX.setCharacterInvisible == false) {
            mColorRecorder = mColor;
        }
    }
}
