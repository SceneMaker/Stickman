/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.CommandReceiver;

import de.dfki.common.Gender;
import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.StickmanStageController;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.paint.Color;

/**
 *
 * @author EmpaT
 */
public class OpacityHelper {

    public static void headOpacityChanger(Stickman3D stickman3D, float value) {
        if (value <= 0.1) {
            stickman3D.mHeadFX.mHeadMeshView.setVisible(false);
        } else {
            stickman3D.mHeadFX.mHeadMeshView.setVisible(true);
        }
        Color col = stickman3D.mHeadFX.mColor;
        col = new Color(col.getRed(), col.getGreen(), col.getBlue(), value);
        stickman3D.mHeadFX.mColor = col;
        stickman3D.mHeadFX.update();
    }

    public static void hairOpacityChanger(Stickman3D stickman3D, float value) {
        if (value <= 0.1) {
            if (stickman3D.mType == Gender.TYPE.FEMALE) {
                stickman3D.mFemaleHairFX.femaleHairMeshView.setVisible(false);
            } else {
                stickman3D.mMaleHairFX.maleHairMeshView.setVisible(false);
            }
        } else {
            if (stickman3D.mType == Gender.TYPE.FEMALE) {
                stickman3D.mFemaleHairFX.femaleHairMeshView.setVisible(true);
            } else {
                stickman3D.mMaleHairFX.maleHairMeshView.setVisible(true);
            }
        }

        Color col = null;
        if (stickman3D.mType == Gender.TYPE.FEMALE) {
            col = stickman3D.mFemaleHairFX.mColor;
            col = new Color(col.getRed(), col.getGreen(), col.getBlue(), value);
            stickman3D.mFemaleHairFX.mColor = col;
            stickman3D.mFemaleHairFX.update();
        } else {
            col = stickman3D.mMaleHairFX.mColor;
            col = new Color(col.getRed(), col.getGreen(), col.getBlue(), value);
            stickman3D.mMaleHairFX.mColor = col;
            stickman3D.mMaleHairFX.update();
        }
    }

    public static void bodyOpacityChanger(Stickman3D stickman3D, float value) {
        if (value <= 0.1) {
            stickman3D.mDownBody.mBodyMeshView.setVisible(false);
            stickman3D.mUpperBody.mBodyMeshView.setVisible(false);
        } else {
            stickman3D.mDownBody.mBodyMeshView.setVisible(true);
            stickman3D.mUpperBody.mBodyMeshView.setVisible(true);
        }

        Color col = stickman3D.mDownBody.mColor;
        Color col1 = stickman3D.mUpperBody.mColor;
        col = new Color(col.getRed(), col.getGreen(), col.getBlue(), value);
        col1 = new Color(col1.getRed(), col1.getGreen(), col1.getBlue(), value);
        stickman3D.mDownBody.mColor = col;
        stickman3D.mDownBody.update();
        stickman3D.mUpperBody.mColor = col;
        stickman3D.mUpperBody.update();
    }

    public static void limbsOpacityChanger(Stickman3D stickman3D, float value) {
        if (value <= 0.1) {
            stickman3D.mNeckFX.neckMeshView.setVisible(false);

            stickman3D.mLeftUpperLegFX.mLeftUpperLegMesh.setVisible(false);
            stickman3D.mLeftForeLegFX.mLeftForeLegMesh.setVisible(false);

            stickman3D.mLeftUpperArmFX.mLeftUpperArmMesh.setVisible(false);
            stickman3D.mLeftForeArmFX.mLeftForeArmMesh.setVisible(false);
            stickman3D.mLeftWrist.mLeftWristMesh.setVisible(false);

            stickman3D.mLeftFinger1.mLeftFinger1.setVisible(false);
            stickman3D.mLeftFinger2.mLeftFinger2.setVisible(false);
            stickman3D.mLeftFinger3.mLeftFinger3.setVisible(false);
            stickman3D.mLeftFinger4.mLeftFinger4.setVisible(false);

            stickman3D.mRightUpperLegFX.mRightUpperLegMesh.setVisible(false);
            stickman3D.mRightForeLegFX.mRightForeLegMesh.setVisible(false);

            stickman3D.mRightUpperArmFX.mRightpperArmMesh.setVisible(false);
            stickman3D.mRightForeArmFX.mRightForeArmMesh.setVisible(false);
            stickman3D.mRightWrist.mRightWristMesh.setVisible(false);

            stickman3D.mRightFinger1.mRightFinger1.setVisible(false);
            stickman3D.mRightFinger2.mRightFinger2.setVisible(false);
            stickman3D.mRightFinger3.mRightFinger3.setVisible(false);
            stickman3D.mRightFinger4.mRightFinger4.setVisible(false);
        } else {
            stickman3D.mNeckFX.neckMeshView.setVisible(true);

            stickman3D.mLeftUpperLegFX.mLeftUpperLegMesh.setVisible(true);
            stickman3D.mLeftForeLegFX.mLeftForeLegMesh.setVisible(true);

            stickman3D.mLeftUpperArmFX.mLeftUpperArmMesh.setVisible(true);
            stickman3D.mLeftForeArmFX.mLeftForeArmMesh.setVisible(true);
            stickman3D.mLeftWrist.mLeftWristMesh.setVisible(true);

            stickman3D.mLeftFinger1.mLeftFinger1.setVisible(true);
            stickman3D.mLeftFinger2.mLeftFinger2.setVisible(true);
            stickman3D.mLeftFinger3.mLeftFinger3.setVisible(true);
            stickman3D.mLeftFinger4.mLeftFinger4.setVisible(true);

            stickman3D.mRightUpperLegFX.mRightUpperLegMesh.setVisible(true);
            stickman3D.mRightForeLegFX.mRightForeLegMesh.setVisible(true);

            stickman3D.mRightUpperArmFX.mRightpperArmMesh.setVisible(true);
            stickman3D.mRightForeArmFX.mRightForeArmMesh.setVisible(true);
            stickman3D.mRightWrist.mRightWristMesh.setVisible(true);

            stickman3D.mRightFinger1.mRightFinger1.setVisible(true);
            stickman3D.mRightFinger2.mRightFinger2.setVisible(true);
            stickman3D.mRightFinger3.mRightFinger3.setVisible(true);
            stickman3D.mRightFinger4.mRightFinger4.setVisible(true);
        }

        Color col = stickman3D.mNeckFX.mColor;
        col = new Color(col.getRed(), col.getGreen(), col.getBlue(), value);

        stickman3D.mNeckFX.mColor = col;

        stickman3D.mLeftUpperLegFX.mColor = col;
        stickman3D.mLeftForeLegFX.mColor = col;

        stickman3D.mLeftUpperArmFX.mColor = col;
        stickman3D.mLeftForeArmFX.mColor = col;
        stickman3D.mLeftWrist.mColor = col;

        stickman3D.mLeftFinger1.mColor = col;
        stickman3D.mLeftFinger2.mColor = col;
        stickman3D.mLeftFinger3.mColor = col;
        stickman3D.mLeftFinger4.mColor = col;

        stickman3D.mRightUpperLegFX.mColor = col;
        stickman3D.mRightForeLegFX.mColor = col;

        stickman3D.mRightUpperArmFX.mColor = col;
        stickman3D.mRightForeArmFX.mColor = col;
        stickman3D.mRightWrist.mColor = col;

        stickman3D.mRightFinger1.mColor = col;
        stickman3D.mRightFinger2.mColor = col;
        stickman3D.mRightFinger3.mColor = col;
        stickman3D.mRightFinger4.mColor = col;

        stickman3D.mNeckFX.update();

        stickman3D.mLeftUpperLegFX.update();
        stickman3D.mLeftForeLegFX.update();

        stickman3D.mLeftUpperArmFX.update();
        stickman3D.mLeftForeArmFX.update();
        stickman3D.mLeftWrist.update();

        stickman3D.mLeftFinger1.update();
        stickman3D.mLeftFinger2.update();
        stickman3D.mLeftFinger3.update();
        stickman3D.mLeftFinger4.update();

        stickman3D.mRightUpperLegFX.update();
        stickman3D.mRightForeLegFX.update();

        stickman3D.mRightUpperArmFX.update();
        stickman3D.mRightForeArmFX.update();
        stickman3D.mRightWrist.update();

        stickman3D.mRightFinger1.update();
        stickman3D.mRightFinger2.update();
        stickman3D.mRightFinger3.update();
        stickman3D.mRightFinger4.update();
    }

    public static void shoesOpacityChanger(Stickman3D stickman3D, float value) {
        if (value <= 0.1) {
            stickman3D.mLeftFootFX.mLeftFootMeshView.setVisible(false);
            stickman3D.mRightFootFX.mRightFootMeshView.setVisible(false);
        } else {
            stickman3D.mLeftFootFX.mLeftFootMeshView.setVisible(true);
            stickman3D.mRightFootFX.mRightFootMeshView.setVisible(true);
        }

        Color col = stickman3D.mLeftFootFX.mColor;
        col = new Color(col.getRed(), col.getGreen(), col.getBlue(), value);

        stickman3D.mLeftFootFX.mColor = col;
        stickman3D.mRightFootFX.mColor = col;

        stickman3D.mLeftFootFX.update();
        stickman3D.mRightFootFX.update();
    }

    public static void lipsOpacityChanger(Stickman3D stickman3D, float value) {
        if (value <= 0.1) {
            stickman3D.mMouthFX.currentDownLipPolygon.setVisible(false);
            stickman3D.mMouthFX.currentUpperLipPolygon.setVisible(false);
        } else {
            stickman3D.mMouthFX.currentDownLipPolygon.setVisible(true);
            stickman3D.mMouthFX.currentUpperLipPolygon.setVisible(true);
        }

        Color col = stickman3D.mMouthFX.mColor;
        col = new Color(col.getRed(), col.getGreen(), col.getBlue(), value);

        stickman3D.mMouthFX.mColor = col;

        stickman3D.mMouthFX.update();
    }

    public static void eyeOpacityChanger(Stickman3D stickman3D, float value) {
        if (value <= 0.1) {
            stickman3D.mLeftEyeFX.bigPupile.setVisible(false);
            stickman3D.mLeftEyeFX.smallPupile.setVisible(false);
            stickman3D.mLeftEyeFX.border.setVisible(false);

            stickman3D.mRightEyeFX.bigPupile.setVisible(false);
            stickman3D.mRightEyeFX.smallPupile.setVisible(false);
            stickman3D.mRightEyeFX.border.setVisible(false);
        } else {
            stickman3D.mLeftEyeFX.bigPupile.setVisible(true);
            stickman3D.mLeftEyeFX.smallPupile.setVisible(true);
            stickman3D.mLeftEyeFX.border.setVisible(true);

            stickman3D.mRightEyeFX.bigPupile.setVisible(true);
            stickman3D.mRightEyeFX.smallPupile.setVisible(true);
            stickman3D.mRightEyeFX.border.setVisible(true);
        }

        Color col = stickman3D.mLeftEyeFX.mColor;
        col = new Color(col.getRed(), col.getGreen(), col.getBlue(), value);

        stickman3D.mLeftEyeFX.mColor = col;
        stickman3D.mRightEyeFX.mColor = col;
        stickman3D.mLeftEyeFX.update();
        stickman3D.mRightEyeFX.update();
    }

    public static void browOpacityChanger(Stickman3D stickman3D, float value) {

        Color col = stickman3D.mLeftEyebrowFX.mColor;
        Color col1 = stickman3D.mNoseFX.mColor;
        col = new Color(col.getRed(), col.getGreen(), col.getBlue(), value);
        col1 = new Color(col1.getRed(), col1.getGreen(), col1.getBlue(), value);

        stickman3D.mLeftEyebrowFX.mColor = col;
        stickman3D.mRightEyebrowFX.mColor = col;

        stickman3D.mNoseFX.mColor = col1;

        stickman3D.mLeftEyebrowFX.update();
        stickman3D.mRightEyebrowFX.update();

        stickman3D.mNoseFX.update();
    }

    public static void noseOpacityChanger(Stickman3D stickman3D, float value) {
        if (value <= 0.1) {
            stickman3D.mNoseFX.mNose.setVisible(false);
        } else {
            stickman3D.mNoseFX.mNose.setVisible(true);
        }
        Color col = stickman3D.mNoseFX.mColor;
        col = new Color(col.getRed(), col.getGreen(), col.getBlue(), value);

        stickman3D.mNoseFX.mColor = col;
        stickman3D.mNoseFX.update();
    }

}
