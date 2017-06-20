package de.dfki.stickman3D.controllerhelper;

import de.dfki.common.Gender;
import de.dfki.stickman3D.StickmanStageController;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Slider;
import javafx.scene.paint.Color;

public class OpacityHelper {

    public static void headOpacityChanger(StickmanStageController controller, Slider headOpacitySlider) {
        headOpacitySlider.valueProperty().addListener(new ChangeListener<Number>() {

            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                if (newValue.doubleValue() <= 0.1) {
                    controller.currentStickman.mHead.getHeadMeshView().setVisible(false);
                } else {
                    controller.currentStickman.mHead.getHeadMeshView().setVisible(true);
                }
                Color col = controller.currentStickman.mHead.mColor;
                col = new Color(col.getRed(), col.getGreen(), col.getBlue(), newValue.doubleValue());
                controller.currentStickman.mHead.mColor = col;
                controller.currentStickman.mHead.update();
            }
        });
    }

    public static void hairOpacityChanger(StickmanStageController controller, Slider hairOpacitySlider) {
        hairOpacitySlider.valueProperty().addListener(new ChangeListener<Number>() {

            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                if (newValue.doubleValue() <= 0.1) {
                    if (controller.currentStickman.mType == Gender.TYPE.FEMALE) {
                        controller.currentStickman.mFemaleHair.getFemaleHairMeshView().setVisible(false);
                    } else {
                        controller.currentStickman.mMaleHair.getMaleHairMeshView().setVisible(false);
                    }
                } else {
                    if (controller.currentStickman.mType == Gender.TYPE.FEMALE) {
                        controller.currentStickman.mFemaleHair.getFemaleHairMeshView().setVisible(true);
                    } else {
                        controller.currentStickman.mMaleHair.getMaleHairMeshView().setVisible(true);
                    }
                }

                Color col = null;
                if (controller.currentStickman.mType == Gender.TYPE.FEMALE) {
                    col = controller.currentStickman.mFemaleHair.mColor;
                    col = new Color(col.getRed(), col.getGreen(), col.getBlue(), newValue.doubleValue());
                    controller.currentStickman.mFemaleHair.mColor = col;
                    controller.currentStickman.mFemaleHair.update();
                } else {
                    col = controller.currentStickman.mMaleHair.mColor;
                    col = new Color(col.getRed(), col.getGreen(), col.getBlue(), newValue.doubleValue());
                    controller.currentStickman.mMaleHair.mColor = col;
                    controller.currentStickman.mMaleHair.update();
                }

            }
        });
    }

    public static void bodyOpacityChanger(StickmanStageController controller, Slider bodyOpacitySlider) {
        bodyOpacitySlider.valueProperty().addListener(new ChangeListener<Number>() {

            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                if (newValue.doubleValue() <= 0.1) {
                    controller.currentStickman.mDownBody.getBodyMeshView().setVisible(false);
                    controller.currentStickman.mUpperBody.getBodyMeshView().setVisible(false);
                } else {
                    controller.currentStickman.mDownBody.getBodyMeshView().setVisible(true);
                    controller.currentStickman.mUpperBody.getBodyMeshView().setVisible(true);
                }

                Color col = controller.currentStickman.mDownBody.mColor;
                Color col1 = controller.currentStickman.mUpperBody.mColor;
                col = new Color(col.getRed(), col.getGreen(), col.getBlue(), newValue.doubleValue());
                col1 = new Color(col1.getRed(), col1.getGreen(), col1.getBlue(), newValue.doubleValue());
                controller.currentStickman.mDownBody.mColor = col;
                controller.currentStickman.mDownBody.update();
                controller.currentStickman.mUpperBody.mColor = col1;
                controller.currentStickman.mUpperBody.update();
            }
        });
    }

    public static void limbsOpacityChanger(StickmanStageController controller, Slider limbsOpacitySlider) {
        limbsOpacitySlider.valueProperty().addListener(new ChangeListener<Number>() {

            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                if (newValue.doubleValue() <= 0.1) {
                    controller.currentStickman.mNeck.getNeckMeshView().setVisible(false);

                    controller.currentStickman.mLeftUpperLeg.getLeftUpperLegMesh().setVisible(false);
                    controller.currentStickman.mLeftForeLeg.getLeftForeLegMesh().setVisible(false);

                    controller.currentStickman.mLeftUpperArm.getLeftUpperArmMesh().setVisible(false);
                    controller.currentStickman.mLeftForeArm.getLeftForeArmMesh().setVisible(false);
                    controller.currentStickman.mLeftWrist.getLeftWristMesh().setVisible(false);

                    controller.currentStickman.mLeftFinger1.getLeftFinger1().setVisible(false);
                    controller.currentStickman.mLeftFinger2.getLeftFinger2().setVisible(false);
                    controller.currentStickman.mLeftFinger3.getLeftFinger3().setVisible(false);
                    controller.currentStickman.mLeftFinger4.getLeftFinger4().setVisible(false);

                    controller.currentStickman.mRightUpperLeg.getRightUpperLegMesh().setVisible(false);
                    controller.currentStickman.mRightForeLeg.mRightForeLegMesh.setVisible(false);

                    controller.currentStickman.mRightUpperArm.getRightpperArmMesh().setVisible(false);
                    controller.currentStickman.mRightForeArm.getRightForeArmMesh().setVisible(false);
                    controller.currentStickman.mRightWrist.getRightWristMesh().setVisible(false);

                    controller.currentStickman.mRightFinger1.getRightFinger1().setVisible(false);
                    controller.currentStickman.mRightFinger2.getRightFinger2().setVisible(false);
                    controller.currentStickman.mRightFinger3.getRightFinger3().setVisible(false);
                    controller.currentStickman.mRightFinger4.getRightFinger4().setVisible(false);
                } else {
                    controller.currentStickman.mNeck.getNeckMeshView().setVisible(true);

                    controller.currentStickman.mLeftUpperLeg.getLeftUpperLegMesh().setVisible(true);
                    controller.currentStickman.mLeftForeLeg.getLeftForeLegMesh().setVisible(true);

                    controller.currentStickman.mLeftUpperArm.getLeftUpperArmMesh().setVisible(true);
                    controller.currentStickman.mLeftForeArm.getLeftForeArmMesh().setVisible(true);
                    controller.currentStickman.mLeftWrist.getLeftWristMesh().setVisible(true);

                    controller.currentStickman.mLeftFinger1.getLeftFinger1().setVisible(true);
                    controller.currentStickman.mLeftFinger2.getLeftFinger2().setVisible(true);
                    controller.currentStickman.mLeftFinger3.getLeftFinger3().setVisible(true);
                    controller.currentStickman.mLeftFinger4.getLeftFinger4().setVisible(true);

                    controller.currentStickman.mRightUpperLeg.getRightUpperLegMesh().setVisible(true);
                    controller.currentStickman.mRightForeLeg.mRightForeLegMesh.setVisible(true);

                    controller.currentStickman.mRightUpperArm.getRightpperArmMesh().setVisible(true);
                    controller.currentStickman.mRightForeArm.getRightForeArmMesh().setVisible(true);
                    controller.currentStickman.mRightWrist.getRightWristMesh().setVisible(true);

                    controller.currentStickman.mRightFinger1.getRightFinger1().setVisible(true);
                    controller.currentStickman.mRightFinger2.getRightFinger2().setVisible(true);
                    controller.currentStickman.mRightFinger3.getRightFinger3().setVisible(true);
                    controller.currentStickman.mRightFinger4.getRightFinger4().setVisible(true);
                }

                Color col = controller.currentStickman.mNeck.mColor;
                col = new Color(col.getRed(), col.getGreen(), col.getBlue(), newValue.doubleValue());

                controller.currentStickman.mNeck.mColor = col;

                controller.currentStickman.mLeftUpperLeg.mColor = col;
                controller.currentStickman.mLeftForeLeg.mColor = col;

                controller.currentStickman.mLeftUpperArm.mColor = col;
                controller.currentStickman.mLeftForeArm.mColor = col;
                controller.currentStickman.mLeftWrist.mColor = col;

                controller.currentStickman.mLeftFinger1.mColor = col;
                controller.currentStickman.mLeftFinger2.mColor = col;
                controller.currentStickman.mLeftFinger3.mColor = col;
                controller.currentStickman.mLeftFinger4.mColor = col;

                controller.currentStickman.mRightUpperLeg.mColor = col;
                controller.currentStickman.mRightForeLeg.mColor = col;

                controller.currentStickman.mRightUpperArm.mColor = col;
                controller.currentStickman.mRightForeArm.mColor = col;
                controller.currentStickman.mRightWrist.mColor = col;

                controller.currentStickman.mRightFinger1.mColor = col;
                controller.currentStickman.mRightFinger2.mColor = col;
                controller.currentStickman.mRightFinger3.mColor = col;
                controller.currentStickman.mRightFinger4.mColor = col;

                controller.currentStickman.mNeck.update();

                controller.currentStickman.mLeftUpperLeg.update();
                controller.currentStickman.mLeftForeLeg.update();

                controller.currentStickman.mLeftUpperArm.update();
                controller.currentStickman.mLeftForeArm.update();
                controller.currentStickman.mLeftWrist.update();

                controller.currentStickman.mLeftFinger1.update();
                controller.currentStickman.mLeftFinger2.update();
                controller.currentStickman.mLeftFinger3.update();
                controller.currentStickman.mLeftFinger4.update();

                controller.currentStickman.mRightUpperLeg.update();
                controller.currentStickman.mRightForeLeg.update();

                controller.currentStickman.mRightUpperArm.update();
                controller.currentStickman.mRightForeArm.update();
                controller.currentStickman.mRightWrist.update();

                controller.currentStickman.mRightFinger1.update();
                controller.currentStickman.mRightFinger2.update();
                controller.currentStickman.mRightFinger3.update();
                controller.currentStickman.mRightFinger4.update();
            }
        });
    }

    public static void shoesOpacityChanger(StickmanStageController controller, Slider shoesOpacitySlider) {
        shoesOpacitySlider.valueProperty().addListener(new ChangeListener<Number>() {

            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                if (newValue.doubleValue() <= 0.1) {
                    controller.currentStickman.mLeftFoot.getLeftFootMeshView().setVisible(false);
                    controller.currentStickman.mRightFoot.getRightFootMeshView().setVisible(false);
                } else {
                    controller.currentStickman.mLeftFoot.getLeftFootMeshView().setVisible(true);
                    controller.currentStickman.mRightFoot.getRightFootMeshView().setVisible(true);
                }

                Color col = controller.currentStickman.mLeftFoot.mColor;
                col = new Color(col.getRed(), col.getGreen(), col.getBlue(), newValue.doubleValue());

                controller.currentStickman.mLeftFoot.mColor = col;
                controller.currentStickman.mRightFoot.mColor = col;

                controller.currentStickman.mLeftFoot.update();
                controller.currentStickman.mRightFoot.update();
            }
        });
    }

    public static void lipsOpacityChanger(StickmanStageController controller, Slider lipsOpacitySlider) {
        lipsOpacitySlider.valueProperty().addListener(new ChangeListener<Number>() {

            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                if (newValue.doubleValue() <= 0.1) {
                    controller.currentStickman.mMouth.currentDownLipPolygon.setVisible(false);
                    controller.currentStickman.mMouth.currentUpperLipPolygon.setVisible(false);
                } else {
                    controller.currentStickman.mMouth.currentDownLipPolygon.setVisible(true);
                    controller.currentStickman.mMouth.currentUpperLipPolygon.setVisible(true);
                }

                Color col = controller.currentStickman.mMouth.mColor;
                col = new Color(col.getRed(), col.getGreen(), col.getBlue(), newValue.doubleValue());

                controller.currentStickman.mMouth.mColor = col;

                controller.currentStickman.mMouth.update();
            }
        });
    }

    public static void eyeOpacityChanger(StickmanStageController controller, Slider eyeOpacitySlider) {
        eyeOpacitySlider.valueProperty().addListener(new ChangeListener<Number>() {

            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                if (newValue.doubleValue() <= 0.1) {
                    controller.currentStickman.mLeftEye.bigPupile.setVisible(false);
                    controller.currentStickman.mLeftEye.smallPupile.setVisible(false);
                    controller.currentStickman.mLeftEye.border.setVisible(false);

                    controller.currentStickman.mRightEye.bigPupile.setVisible(false);
                    controller.currentStickman.mRightEye.smallPupile.setVisible(false);
                    controller.currentStickman.mRightEye.border.setVisible(false);
                } else {
                    controller.currentStickman.mLeftEye.bigPupile.setVisible(true);
                    controller.currentStickman.mLeftEye.smallPupile.setVisible(true);
                    controller.currentStickman.mLeftEye.border.setVisible(true);

                    controller.currentStickman.mRightEye.bigPupile.setVisible(true);
                    controller.currentStickman.mRightEye.smallPupile.setVisible(true);
                    controller.currentStickman.mRightEye.border.setVisible(true);
                }

                Color col = controller.currentStickman.mLeftEye.mColor;
                col = new Color(col.getRed(), col.getGreen(), col.getBlue(), newValue.doubleValue());

                controller.currentStickman.mLeftEye.mColor = col;
                controller.currentStickman.mRightEye.mColor = col;
                controller.currentStickman.mLeftEye.update();
                controller.currentStickman.mRightEye.update();
            }
        });
    }

    public static void browOpacityChanger(StickmanStageController controller, Slider browOpacitySlider) {
        browOpacitySlider.valueProperty().addListener(new ChangeListener<Number>() {

            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {

                Color col = controller.currentStickman.mLeftEyebrow.mColor;
//                Color col1 = controller.currentStickman.mNose.mColor;
                col = new Color(col.getRed(), col.getGreen(), col.getBlue(), newValue.doubleValue());
//                col1 = new Color(col1.getRed(), col1.getGreen(), col1.getBlue(), newValue.doubleValue());

                controller.currentStickman.mLeftEyebrow.mColor = col;
                controller.currentStickman.mRightEyebrow.mColor = col;

//                controller.currentStickman.mNose.mColor = col1;

                controller.currentStickman.mLeftEyebrow.update();
                controller.currentStickman.mRightEyebrow.update();

//                controller.currentStickman.mNose.update();
            }
        });

    }

    public static void noseOpacityChanger(StickmanStageController controller, Slider noseOpacitySlider) {
        noseOpacitySlider.valueProperty().addListener(new ChangeListener<Number>() {

            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                if (newValue.doubleValue() <= 0.1) {
                    controller.currentStickman.mNose.getNose().setVisible(false);
                } else {
                    controller.currentStickman.mNose.getNose().setVisible(true);
                }
                Color col = controller.currentStickman.mNose.mColor;
                col = new Color(col.getRed(), col.getGreen(), col.getBlue(), newValue.doubleValue());

                controller.currentStickman.mNose.mColor = col;
                controller.currentStickman.mNose.update();
            }
        });

    }
}
