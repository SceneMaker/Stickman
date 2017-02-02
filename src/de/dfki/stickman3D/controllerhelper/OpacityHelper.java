package de.dfki.stickman3D.controllerhelper;

import de.dfki.common.Gender;
import de.dfki.stickman3D.Stickman3D;
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
                    controller.currentStickman.mHeadFX.mHeadMeshView.setVisible(false);
                } else {
                    controller.currentStickman.mHeadFX.mHeadMeshView.setVisible(true);
                }
                Color col = controller.currentStickman.mHeadFX.mColor;
                col = new Color(col.getRed(), col.getGreen(), col.getBlue(), newValue.doubleValue());
                controller.currentStickman.mHeadFX.mColor = col;
                controller.currentStickman.mHeadFX.update();
            }
        });
    }

    public static void hairOpacityChanger(StickmanStageController controller, Slider hairOpacitySlider) {
        hairOpacitySlider.valueProperty().addListener(new ChangeListener<Number>() {

            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                if (newValue.doubleValue() <= 0.1) {
                    if (controller.currentStickman.mType == Gender.TYPE.FEMALE) {
                        controller.currentStickman.mFemaleHairFX.femaleHairMeshView.setVisible(false);
                    } else {
                        controller.currentStickman.mMaleHairFX.maleHairMeshView.setVisible(false);
                    }
                } else {
                    if (controller.currentStickman.mType == Gender.TYPE.FEMALE) {
                        controller.currentStickman.mFemaleHairFX.femaleHairMeshView.setVisible(true);
                    } else {
                        controller.currentStickman.mMaleHairFX.maleHairMeshView.setVisible(true);
                    }
                }

                Color col = null;
                if (controller.currentStickman.mType == Gender.TYPE.FEMALE) {
                    col = controller.currentStickman.mFemaleHairFX.mColor;
                    col = new Color(col.getRed(), col.getGreen(), col.getBlue(), newValue.doubleValue());
                    controller.currentStickman.mFemaleHairFX.mColor = col;
                    controller.currentStickman.mFemaleHairFX.update();
                } else {
                    col = controller.currentStickman.mMaleHairFX.mColor;
                    col = new Color(col.getRed(), col.getGreen(), col.getBlue(), newValue.doubleValue());
                    controller.currentStickman.mMaleHairFX.mColor = col;
                    controller.currentStickman.mMaleHairFX.update();
                }

            }
        });
    }

    public static void bodyOpacityChanger(StickmanStageController controller, Slider bodyOpacitySlider) {
        bodyOpacitySlider.valueProperty().addListener(new ChangeListener<Number>() {

            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                if (newValue.doubleValue() <= 0.1) {
                    controller.currentStickman.mDownBody.mBodyMeshView.setVisible(false);
                    controller.currentStickman.mUpperBody.mBodyMeshView.setVisible(false);
                } else {
                    controller.currentStickman.mDownBody.mBodyMeshView.setVisible(true);
                    controller.currentStickman.mUpperBody.mBodyMeshView.setVisible(true);
                }

                Color col = controller.currentStickman.mDownBody.mColor;
                Color col1 = controller.currentStickman.mUpperBody.mColor;
                col = new Color(col.getRed(), col.getGreen(), col.getBlue(), newValue.doubleValue());
                col1 = new Color(col1.getRed(), col1.getGreen(), col1.getBlue(), newValue.doubleValue());
                controller.currentStickman.mDownBody.mColor = col;
                controller.currentStickman.mDownBody.update();
                controller.currentStickman.mUpperBody.mColor = col;
                controller.currentStickman.mUpperBody.update();
            }
        });
    }

    public static void limbsOpacityChanger(StickmanStageController controller, Slider limbsOpacitySlider) {
        limbsOpacitySlider.valueProperty().addListener(new ChangeListener<Number>() {

            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                if (newValue.doubleValue() <= 0.1) {
                    controller.currentStickman.mNeckFX.neckMeshView.setVisible(false);

                    controller.currentStickman.mLeftUpperLegFX.mLeftUpperLegMesh.setVisible(false);
                    controller.currentStickman.mLeftForeLegFX.mLeftForeLegMesh.setVisible(false);

                    controller.currentStickman.mLeftUpperArmFX.mLeftUpperArmMesh.setVisible(false);
                    controller.currentStickman.mLeftForeArmFX.mLeftForeArmMesh.setVisible(false);
                    controller.currentStickman.mLeftWrist.mLeftWristMesh.setVisible(false);

                    controller.currentStickman.mLeftFinger1.mLeftFinger1.setVisible(false);
                    controller.currentStickman.mLeftFinger2.mLeftFinger2.setVisible(false);
                    controller.currentStickman.mLeftFinger3.mLeftFinger3.setVisible(false);
                    controller.currentStickman.mLeftFinger4.mLeftFinger4.setVisible(false);

                    controller.currentStickman.mRightUpperLegFX.mRightUpperLegMesh.setVisible(false);
                    controller.currentStickman.mRightForeLegFX.mRightForeLegMesh.setVisible(false);

                    controller.currentStickman.mRightUpperArmFX.mRightpperArmMesh.setVisible(false);
                    controller.currentStickman.mRightForeArmFX.mRightForeArmMesh.setVisible(false);
                    controller.currentStickman.mRightWrist.mRightWristMesh.setVisible(false);

                    controller.currentStickman.mRightFinger1.mRightFinger1.setVisible(false);
                    controller.currentStickman.mRightFinger2.mRightFinger2.setVisible(false);
                    controller.currentStickman.mRightFinger3.mRightFinger3.setVisible(false);
                    controller.currentStickman.mRightFinger4.mRightFinger4.setVisible(false);
                } else {
                    controller.currentStickman.mNeckFX.neckMeshView.setVisible(true);

                    controller.currentStickman.mLeftUpperLegFX.mLeftUpperLegMesh.setVisible(true);
                    controller.currentStickman.mLeftForeLegFX.mLeftForeLegMesh.setVisible(true);

                    controller.currentStickman.mLeftUpperArmFX.mLeftUpperArmMesh.setVisible(true);
                    controller.currentStickman.mLeftForeArmFX.mLeftForeArmMesh.setVisible(true);
                    controller.currentStickman.mLeftWrist.mLeftWristMesh.setVisible(true);

                    controller.currentStickman.mLeftFinger1.mLeftFinger1.setVisible(true);
                    controller.currentStickman.mLeftFinger2.mLeftFinger2.setVisible(true);
                    controller.currentStickman.mLeftFinger3.mLeftFinger3.setVisible(true);
                    controller.currentStickman.mLeftFinger4.mLeftFinger4.setVisible(true);

                    controller.currentStickman.mRightUpperLegFX.mRightUpperLegMesh.setVisible(true);
                    controller.currentStickman.mRightForeLegFX.mRightForeLegMesh.setVisible(true);

                    controller.currentStickman.mRightUpperArmFX.mRightpperArmMesh.setVisible(true);
                    controller.currentStickman.mRightForeArmFX.mRightForeArmMesh.setVisible(true);
                    controller.currentStickman.mRightWrist.mRightWristMesh.setVisible(true);

                    controller.currentStickman.mRightFinger1.mRightFinger1.setVisible(true);
                    controller.currentStickman.mRightFinger2.mRightFinger2.setVisible(true);
                    controller.currentStickman.mRightFinger3.mRightFinger3.setVisible(true);
                    controller.currentStickman.mRightFinger4.mRightFinger4.setVisible(true);
                }

                Color col = controller.currentStickman.mNeckFX.mColor;
                col = new Color(col.getRed(), col.getGreen(), col.getBlue(), newValue.doubleValue());

                controller.currentStickman.mNeckFX.mColor = col;

                controller.currentStickman.mLeftUpperLegFX.mColor = col;
                controller.currentStickman.mLeftForeLegFX.mColor = col;

                controller.currentStickman.mLeftUpperArmFX.mColor = col;
                controller.currentStickman.mLeftForeArmFX.mColor = col;
                controller.currentStickman.mLeftWrist.mColor = col;

                controller.currentStickman.mLeftFinger1.mColor = col;
                controller.currentStickman.mLeftFinger2.mColor = col;
                controller.currentStickman.mLeftFinger3.mColor = col;
                controller.currentStickman.mLeftFinger4.mColor = col;

                controller.currentStickman.mRightUpperLegFX.mColor = col;
                controller.currentStickman.mRightForeLegFX.mColor = col;

                controller.currentStickman.mRightUpperArmFX.mColor = col;
                controller.currentStickman.mRightForeArmFX.mColor = col;
                controller.currentStickman.mRightWrist.mColor = col;

                controller.currentStickman.mRightFinger1.mColor = col;
                controller.currentStickman.mRightFinger2.mColor = col;
                controller.currentStickman.mRightFinger3.mColor = col;
                controller.currentStickman.mRightFinger4.mColor = col;

                controller.currentStickman.mNeckFX.update();

                controller.currentStickman.mLeftUpperLegFX.update();
                controller.currentStickman.mLeftForeLegFX.update();

                controller.currentStickman.mLeftUpperArmFX.update();
                controller.currentStickman.mLeftForeArmFX.update();
                controller.currentStickman.mLeftWrist.update();

                controller.currentStickman.mLeftFinger1.update();
                controller.currentStickman.mLeftFinger2.update();
                controller.currentStickman.mLeftFinger3.update();
                controller.currentStickman.mLeftFinger4.update();

                controller.currentStickman.mRightUpperLegFX.update();
                controller.currentStickman.mRightForeLegFX.update();

                controller.currentStickman.mRightUpperArmFX.update();
                controller.currentStickman.mRightForeArmFX.update();
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
                    controller.currentStickman.mLeftFootFX.mLeftFootMeshView.setVisible(false);
                    controller.currentStickman.mRightFootFX.mRightFootMeshView.setVisible(false);
                } else {
                    controller.currentStickman.mLeftFootFX.mLeftFootMeshView.setVisible(true);
                    controller.currentStickman.mRightFootFX.mRightFootMeshView.setVisible(true);
                }

                Color col = controller.currentStickman.mLeftFootFX.mColor;
                col = new Color(col.getRed(), col.getGreen(), col.getBlue(), newValue.doubleValue());

                controller.currentStickman.mLeftFootFX.mColor = col;
                controller.currentStickman.mRightFootFX.mColor = col;

                controller.currentStickman.mLeftFootFX.update();
                controller.currentStickman.mRightFootFX.update();
            }
        });
    }

    public static void lipsOpacityChanger(StickmanStageController controller, Slider lipsOpacitySlider) {
        lipsOpacitySlider.valueProperty().addListener(new ChangeListener<Number>() {

            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                if (newValue.doubleValue() <= 0.1) {
                    controller.currentStickman.mMouthFX.currentDownLipPolygon.setVisible(false);
                    controller.currentStickman.mMouthFX.currentUpperLipPolygon.setVisible(false);
                } else {
                    controller.currentStickman.mMouthFX.currentDownLipPolygon.setVisible(true);
                    controller.currentStickman.mMouthFX.currentUpperLipPolygon.setVisible(true);
                }

                Color col = controller.currentStickman.mMouthFX.mColor;
                col = new Color(col.getRed(), col.getGreen(), col.getBlue(), newValue.doubleValue());

                controller.currentStickman.mMouthFX.mColor = col;

                controller.currentStickman.mMouthFX.update();
            }
        });
    }

    public static void eyeOpacityChanger(StickmanStageController controller, Slider eyeOpacitySlider) {
        eyeOpacitySlider.valueProperty().addListener(new ChangeListener<Number>() {

            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                if (newValue.doubleValue() <= 0.1) {
                    controller.currentStickman.mLeftEyeFX.bigPupile.setVisible(false);
                    controller.currentStickman.mLeftEyeFX.smallPupile.setVisible(false);
                    controller.currentStickman.mLeftEyeFX.border.setVisible(false);

                    controller.currentStickman.mRightEyeFX.bigPupile.setVisible(false);
                    controller.currentStickman.mRightEyeFX.smallPupile.setVisible(false);
                    controller.currentStickman.mRightEyeFX.border.setVisible(false);
                } else {
                    controller.currentStickman.mLeftEyeFX.bigPupile.setVisible(true);
                    controller.currentStickman.mLeftEyeFX.smallPupile.setVisible(true);
                    controller.currentStickman.mLeftEyeFX.border.setVisible(true);

                    controller.currentStickman.mRightEyeFX.bigPupile.setVisible(true);
                    controller.currentStickman.mRightEyeFX.smallPupile.setVisible(true);
                    controller.currentStickman.mRightEyeFX.border.setVisible(true);
                }

                Color col = controller.currentStickman.mLeftEyeFX.mColor;
                col = new Color(col.getRed(), col.getGreen(), col.getBlue(), newValue.doubleValue());

                controller.currentStickman.mLeftEyeFX.mColor = col;
                controller.currentStickman.mRightEyeFX.mColor = col;
                controller.currentStickman.mLeftEyeFX.update();
                controller.currentStickman.mRightEyeFX.update();
            }
        });
    }

    public static void browOpacityChanger(StickmanStageController controller, Slider browOpacitySlider) {
        browOpacitySlider.valueProperty().addListener(new ChangeListener<Number>() {

            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {

                Color col = controller.currentStickman.mLeftEyebrowFX.mColor;
//                Color col1 = controller.currentStickman.mNoseFX.mColor;
                col = new Color(col.getRed(), col.getGreen(), col.getBlue(), newValue.doubleValue());
//                col1 = new Color(col1.getRed(), col1.getGreen(), col1.getBlue(), newValue.doubleValue());

                controller.currentStickman.mLeftEyebrowFX.mColor = col;
                controller.currentStickman.mRightEyebrowFX.mColor = col;

//                controller.currentStickman.mNoseFX.mColor = col1;

                controller.currentStickman.mLeftEyebrowFX.update();
                controller.currentStickman.mRightEyebrowFX.update();

//                controller.currentStickman.mNoseFX.update();
            }
        });

    }

    public static void noseOpacityChanger(StickmanStageController controller, Slider noseOpacitySlider) {
        noseOpacitySlider.valueProperty().addListener(new ChangeListener<Number>() {

            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                if (newValue.doubleValue() <= 0.1) {
                    controller.currentStickman.mNoseFX.mNose.setVisible(false);
                } else {
                    controller.currentStickman.mNoseFX.mNose.setVisible(true);
                }
                Color col = controller.currentStickman.mNoseFX.mColor;
                col = new Color(col.getRed(), col.getGreen(), col.getBlue(), newValue.doubleValue());

                controller.currentStickman.mNoseFX.mColor = col;
                controller.currentStickman.mNoseFX.update();
            }
        });

    }
}
