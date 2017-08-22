package de.dfki.common.util;

import java.awt.*;

/**
 * Created by EmpaT on 05.08.2017.
 */
public class Preferences
{
    public static final int HEAD_WIDTH = 120;
    public static final int HEAD_HEIGHT = 120;
    public static final int NECK_WIDTH = 4;
    public static final int NECK_HEIGHT = 10;
    public static final int MALE_UPPER_BODY_HEIGHT = 171;
    public static final int MALE_UPPER_BODY_WIDTH = 66;
    public static final int FEMALE_UPPER_BODY_HEIGHT = 153;
    public static final int FEMALE_UPPER_BODY_WIDTH = 78;
    public static final int MALE_DOWN_BODY_HEIGHT = 25;
    public static final int MALE_DOWN_BODY_WIDTH = 76;
    public static final int FEMALE_DOWN_BODY_HEIGHT = 69;
    public static final int FEMALE_DOWN_BODY_WIDTH = 162;
    public static final int MALE_UPPER_LEG_HEIGHT = 60;
    public static final int MALE_UPPER_LEG_WIDTH = 13;
    public static final int MALE_FORE_LEG_HEIGHT = 90;
    public static final int MALE_FORE_LEG_WIDTH = 13;
    public static final int FOOT_HEIGHT = 14;
    public static final int FOOT_WIDTH = 40;
    public static final int BROW_HEIGHT = 11;
    public static final int BROW_WIDTH = 30;
    public static final int EYE_HEIGHT = 15;
    public static final int EYE_WIDTH = 22;
    public static final int NOSE_HEIGHT = 22;
    public static final int NOSE_WIDTH = 14;
    public static final int MOUTH_HEIGHT = 5;
    public static final int MOUTH_WIDTH = 32;
    public static final int UPPER_ARM_HEIGHT = 60;
    public static final int UPPER_ARM_WIDTH = 12;
    public static final int FORE_ARM_HEIGHT = 70;
    public static final int FORE_ARM_WIDTH = 12;
    public static final int EAR_HEIGHT = 27;
    public static final int EAR_WIDTH = 12;

    public static final float FACEWRINKLE_BOX_SPACING = 5;

    /////////////////////////////////////////////////////////
    /////////////////////AGENT HEIGHTS///////////////////////
    /////////////////////////////////////////////////////////
    public static final int MALE_HEIGHT = HEAD_HEIGHT
            + NECK_HEIGHT
            + MALE_UPPER_BODY_HEIGHT
            + MALE_DOWN_BODY_HEIGHT
            + MALE_UPPER_LEG_HEIGHT + MALE_FORE_LEG_HEIGHT;

    /////////////////////////////////////////////////////////
    /////////////////////AGENT POSITION ON SCREEN////////////
    /////////////////////////////////////////////////////////
    public static final int MALE_POSITION_ON_SCREEN = (int) (Toolkit
                .getDefaultToolkit()
                .getScreenSize()
                .getHeight() - MALE_HEIGHT);

    /////////////////////////////////////////////////////////
    /////////////////////DISTANCE BETWEEN AGENTS/////////////
    /////////////////////////////////////////////////////////
    public static final int DISTANCE_BETWEEN_AGENTS  =300;

    /////////////////////////////////////////////////////////
    /////////////////////EYE POSITIONS///////////////////////
    /////////////////////////////////////////////////////////
    public static final int RIGHT_EYE_X_POS = -20;
    public static final int LEFT_EYE_X_POS = -RIGHT_EYE_X_POS;
    public static final double SMALL_PUPILE_X_POS = 0.2;
    public static final int EYE_Y_POS = -10;
    public static final double FACE_PARTS_Z_POS = -15.5;

    /////////////////////////////////////////////////////////
    /////////////////////BROW POSITIONS//////////////////////
    /////////////////////////////////////////////////////////
    public final static int HEAD_Y_POS = MALE_POSITION_ON_SCREEN/5;

    public static final int RIGHT_BROW_X_POS = -21;
    public static final int BROW_Y_POS = -21;
    public static final int LEFT_BROW_X_POS = -RIGHT_BROW_X_POS;

    public static final int MALE_HAIR_X_POS = 2;
    public static final int MALE_HAIR_Y_POS = -21;
    public static final double MALE_HAIR_Z_POS = -14;
    public static final int FEMALE_HAIR_X_POS = 60;
    public static final int FEMALE_HAIR_Y_POS = 60;
    public static final int FEMALE_HAIR_Z_POS = 0;
}
