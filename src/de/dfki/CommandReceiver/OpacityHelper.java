/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.CommandReceiver;

import de.dfki.common.Gender;
import de.dfki.stickman3D.Stickman3D;
import javafx.scene.paint.Color;

/**
 *
 * @author EmpaT
 */
public class OpacityHelper {

    public static void headOpacityChanger(Stickman3D stickman3D, float value) {
        if (value <= 0.1) {
            stickman3D.mHead.getHeadMeshView().setVisible(false);
        } else {
            stickman3D.mHead.getHeadMeshView().setVisible(true);
        }
        Color col = stickman3D.mHead.mColor;
        col = new Color(col.getRed(), col.getGreen(), col.getBlue(), value);
        stickman3D.mHead.mColor = col;
        stickman3D.mHead.update();
    }

    public static void hairOpacityChanger(Stickman3D stickman3D, float value) {
        if (value <= 0.1) {
            if (stickman3D.mType == Gender.TYPE.FEMALE) {
                stickman3D.mFemaleHair.getFemaleHairMeshView().setVisible(false);
            } else {
                stickman3D.mMaleHair.getMaleHairMeshView().setVisible(false);
            }
        } else {
            if (stickman3D.mType == Gender.TYPE.FEMALE) {
                stickman3D.mFemaleHair.getFemaleHairMeshView().setVisible(true);
            } else {
                stickman3D.mMaleHair.getMaleHairMeshView().setVisible(true);
            }
        }

        Color col = null;
        if (stickman3D.mType == Gender.TYPE.FEMALE) {
            col = stickman3D.mFemaleHair.mColor;
            col = new Color(col.getRed(), col.getGreen(), col.getBlue(), value);
            stickman3D.mFemaleHair.mColor = col;
            stickman3D.mFemaleHair.update();
        } else {
            col = stickman3D.mMaleHair.mColor;
            col = new Color(col.getRed(), col.getGreen(), col.getBlue(), value);
            stickman3D.mMaleHair.mColor = col;
            stickman3D.mMaleHair.update();
        }
    }

    public static void bodyOpacityChanger(Stickman3D stickman3D, float value) {
        if (value <= 0.1) {
            stickman3D.mDownBody.getBodyMeshView().setVisible(false);
            stickman3D.mUpperBody.getBodyMeshView().setVisible(false);
        } else {
            stickman3D.mDownBody.getBodyMeshView().setVisible(true);
            stickman3D.mUpperBody.getBodyMeshView().setVisible(true);
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
            stickman3D.mNeck.getNeckMeshView().setVisible(false);

            stickman3D.mLeftUpperLeg.getLeftUpperLegMesh().setVisible(false);
            stickman3D.mLeftForeLeg.getLeftForeLegMesh().setVisible(false);

            stickman3D.mLeftUpperArm.getLeftUpperArmMesh().setVisible(false);
            stickman3D.mLeftForeArm.getLeftForeArmMesh().setVisible(false);
            stickman3D.mLeftWrist.getLeftWristMesh().setVisible(false);

            stickman3D.mLeftFinger1.getLeftFinger1().setVisible(false);
            stickman3D.mLeftFinger2.getLeftFinger2().setVisible(false);
            stickman3D.mLeftFinger3.getLeftFinger3().setVisible(false);
            stickman3D.mLeftFinger4.getLeftFinger4().setVisible(false);

            stickman3D.mRightUpperLeg.getRightUpperLegMesh().setVisible(false);
            stickman3D.mRightForeLeg.mRightForeLegMesh.setVisible(false);

            stickman3D.mRightUpperArm.getRightpperArmMesh().setVisible(false);
            stickman3D.mRightForeArm.getRightForeArmMesh().setVisible(false);
            stickman3D.mRightWrist.getRightWristMesh().setVisible(false);

            stickman3D.mRightFinger1.getRightFinger1().setVisible(false);
            stickman3D.mRightFinger2.getRightFinger2().setVisible(false);
            stickman3D.mRightFinger3.getRightFinger3().setVisible(false);
            stickman3D.mRightFinger4.getRightFinger4().setVisible(false);
        } else {
            stickman3D.mNeck.getNeckMeshView().setVisible(true);

            stickman3D.mLeftUpperLeg.getLeftUpperLegMesh().setVisible(true);
            stickman3D.mLeftForeLeg.getLeftForeLegMesh().setVisible(true);

            stickman3D.mLeftUpperArm.getLeftUpperArmMesh().setVisible(true);
            stickman3D.mLeftForeArm.getLeftForeArmMesh().setVisible(true);
            stickman3D.mLeftWrist.getLeftWristMesh().setVisible(true);

            stickman3D.mLeftFinger1.getLeftFinger1().setVisible(true);
            stickman3D.mLeftFinger2.getLeftFinger2().setVisible(true);
            stickman3D.mLeftFinger3.getLeftFinger3().setVisible(true);
            stickman3D.mLeftFinger4.getLeftFinger4().setVisible(true);

            stickman3D.mRightUpperLeg.getRightUpperLegMesh().setVisible(true);
            stickman3D.mRightForeLeg.mRightForeLegMesh.setVisible(true);

            stickman3D.mRightUpperArm.getRightpperArmMesh().setVisible(true);
            stickman3D.mRightForeArm.getRightForeArmMesh().setVisible(true);
            stickman3D.mRightWrist.getRightWristMesh().setVisible(true);

            stickman3D.mRightFinger1.getRightFinger1().setVisible(true);
            stickman3D.mRightFinger2.getRightFinger2().setVisible(true);
            stickman3D.mRightFinger3.getRightFinger3().setVisible(true);
            stickman3D.mRightFinger4.getRightFinger4().setVisible(true);
        }

        Color col = stickman3D.mNeck.mColor;
        col = new Color(col.getRed(), col.getGreen(), col.getBlue(), value);

        stickman3D.mNeck.mColor = col;

        stickman3D.mLeftUpperLeg.mColor = col;
        stickman3D.mLeftForeLeg.mColor = col;

        stickman3D.mLeftUpperArm.mColor = col;
        stickman3D.mLeftForeArm.mColor = col;
        stickman3D.mLeftWrist.mColor = col;

        stickman3D.mLeftFinger1.mColor = col;
        stickman3D.mLeftFinger2.mColor = col;
        stickman3D.mLeftFinger3.mColor = col;
        stickman3D.mLeftFinger4.mColor = col;

        stickman3D.mRightUpperLeg.mColor = col;
        stickman3D.mRightForeLeg.mColor = col;

        stickman3D.mRightUpperArm.mColor = col;
        stickman3D.mRightForeArm.mColor = col;
        stickman3D.mRightWrist.mColor = col;

        stickman3D.mRightFinger1.mColor = col;
        stickman3D.mRightFinger2.mColor = col;
        stickman3D.mRightFinger3.mColor = col;
        stickman3D.mRightFinger4.mColor = col;

        stickman3D.mNeck.update();

        stickman3D.mLeftUpperLeg.update();
        stickman3D.mLeftForeLeg.update();

        stickman3D.mLeftUpperArm.update();
        stickman3D.mLeftForeArm.update();
        stickman3D.mLeftWrist.update();

        stickman3D.mLeftFinger1.update();
        stickman3D.mLeftFinger2.update();
        stickman3D.mLeftFinger3.update();
        stickman3D.mLeftFinger4.update();

        stickman3D.mRightUpperLeg.update();
        stickman3D.mRightForeLeg.update();

        stickman3D.mRightUpperArm.update();
        stickman3D.mRightForeArm.update();
        stickman3D.mRightWrist.update();

        stickman3D.mRightFinger1.update();
        stickman3D.mRightFinger2.update();
        stickman3D.mRightFinger3.update();
        stickman3D.mRightFinger4.update();
    }

    public static void shoesOpacityChanger(Stickman3D stickman3D, float value) {
        if (value <= 0.1) {
            stickman3D.mLeftFoot.getLeftFootMeshView().setVisible(false);
            stickman3D.mRightFoot.getRightFootMeshView().setVisible(false);
        } else {
            stickman3D.mLeftFoot.getLeftFootMeshView().setVisible(true);
            stickman3D.mRightFoot.getRightFootMeshView().setVisible(true);
        }

        Color col = stickman3D.mLeftFoot.mColor;
        col = new Color(col.getRed(), col.getGreen(), col.getBlue(), value);

        stickman3D.mLeftFoot.mColor = col;
        stickman3D.mRightFoot.mColor = col;

        stickman3D.mLeftFoot.update();
        stickman3D.mRightFoot.update();
    }

    public static void lipsOpacityChanger(Stickman3D stickman3D, float value) {
        if (value <= 0.1) {
            stickman3D.mMouth.currentDownLipPolygon.setVisible(false);
            stickman3D.mMouth.currentUpperLipPolygon.setVisible(false);
        } else {
            stickman3D.mMouth.currentDownLipPolygon.setVisible(true);
            stickman3D.mMouth.currentUpperLipPolygon.setVisible(true);
        }

        Color col = stickman3D.mMouth.mColor;
        col = new Color(col.getRed(), col.getGreen(), col.getBlue(), value);

        stickman3D.mMouth.mColor = col;

        stickman3D.mMouth.update();
    }

    public static void eyeOpacityChanger(Stickman3D stickman3D, float value) {
        if (value <= 0.1) {
            stickman3D.mLeftEye.bigPupile.setVisible(false);
            stickman3D.mLeftEye.smallPupile.setVisible(false);
            stickman3D.mLeftEye.border.setVisible(false);

            stickman3D.mRightEye.bigPupile.setVisible(false);
            stickman3D.mRightEye.smallPupile.setVisible(false);
            stickman3D.mRightEye.border.setVisible(false);
        } else {
            stickman3D.mLeftEye.bigPupile.setVisible(true);
            stickman3D.mLeftEye.smallPupile.setVisible(true);
            stickman3D.mLeftEye.border.setVisible(true);

            stickman3D.mRightEye.bigPupile.setVisible(true);
            stickman3D.mRightEye.smallPupile.setVisible(true);
            stickman3D.mRightEye.border.setVisible(true);
        }

        Color col = stickman3D.mLeftEye.mColor;
        col = new Color(col.getRed(), col.getGreen(), col.getBlue(), value);

        stickman3D.mLeftEye.mColor = col;
        stickman3D.mRightEye.mColor = col;
        stickman3D.mLeftEye.update();
        stickman3D.mRightEye.update();
    }

    public static void browOpacityChanger(Stickman3D stickman3D, float value) {

        Color col = stickman3D.mLeftEyebrow.mColor;
        Color col1 = stickman3D.mNose.mColor;
        col = new Color(col.getRed(), col.getGreen(), col.getBlue(), value);
        col1 = new Color(col1.getRed(), col1.getGreen(), col1.getBlue(), value);

        stickman3D.mLeftEyebrow.mColor = col;
        stickman3D.mRightEyebrow.mColor = col;

        stickman3D.mNose.mColor = col1;

        stickman3D.mLeftEyebrow.update();
        stickman3D.mRightEyebrow.update();

        stickman3D.mNose.update();
    }

    public static void noseOpacityChanger(Stickman3D stickman3D, float value) {
        if (value <= 0.1) {
            stickman3D.mNose.getNose().setVisible(false);
        } else {
            stickman3D.mNose.getNose().setVisible(true);
        }
        Color col = stickman3D.mNose.mColor;
        col = new Color(col.getRed(), col.getGreen(), col.getBlue(), value);

        stickman3D.mNose.mColor = col;
        stickman3D.mNose.update();
    }

}
