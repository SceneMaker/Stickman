package de.dfki.reeti.controllerhelper;

import de.dfki.common.Gender;
import de.dfki.reeti.Reeti;
import de.dfki.reeti.ReetiStageController;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Slider;
import javafx.scene.paint.Color;

public class OpacityHelper {

    public static void headOpacityChanger(ReetiStageController controller, Slider headOpacitySlider) {
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

    public static void hairOpacityChanger(ReetiStageController controller, Slider hairOpacitySlider) {
        hairOpacitySlider.valueProperty().addListener(new ChangeListener<Number>() {

            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                if (newValue.doubleValue() <= 0.1) {
                    if (controller.currentStickman.mType == Gender.TYPE.FEMALE) {
//                        controller.currentStickman.mFemaleHairFX.femaleHairMeshView.setVisible(false);
                    } else {
//                        controller.currentStickman.mMaleHairFX.maleHairMeshView.setVisible(false);
                    }
                } else {
                    if (controller.currentStickman.mType == Gender.TYPE.FEMALE) {
//                        controller.currentStickman.mFemaleHairFX.femaleHairMeshView.setVisible(true);
                    } else {
//                        controller.currentStickman.mMaleHairFX.maleHairMeshView.setVisible(true);
                    }
                }

                Color col = null;
                if (controller.currentStickman.mType == Gender.TYPE.FEMALE) {
//                    col = controller.currentStickman.mFemaleHairFX.mColor;
                    col = new Color(col.getRed(), col.getGreen(), col.getBlue(), newValue.doubleValue());
//                    controller.currentStickman.mFemaleHairFX.mColor = col;
//                    controller.currentStickman.mFemaleHairFX.update();
                } else {
//                    col = controller.currentStickman.mMaleHairFX.mColor;
                    col = new Color(col.getRed(), col.getGreen(), col.getBlue(), newValue.doubleValue());
//                    controller.currentStickman.mMaleHairFX.mColor = col;
//                    controller.currentStickman.mMaleHairFX.update();
                }

            }
        });
    }

    public static void bodyOpacityChanger(ReetiStageController controller, Slider bodyOpacitySlider) {
        bodyOpacitySlider.valueProperty().addListener(new ChangeListener<Number>() {

            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                if (newValue.doubleValue() <= 0.1) {
                    controller.currentStickman.mUpperBody.mBodyMeshView.setVisible(false);
                } else {
                    controller.currentStickman.mUpperBody.mBodyMeshView.setVisible(true);
                }

                Color col1 = controller.currentStickman.mUpperBody.mColor;
                col1 = new Color(col1.getRed(), col1.getGreen(), col1.getBlue(), newValue.doubleValue());
                controller.currentStickman.mUpperBody.mColor = col1;
                controller.currentStickman.mUpperBody.update();
            }
        });
    }

    public static void limbsOpacityChanger(ReetiStageController controller, Slider limbsOpacitySlider) {
        limbsOpacitySlider.valueProperty().addListener(new ChangeListener<Number>() {

            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                if (newValue.doubleValue() <= 0.1) {
                    controller.currentStickman.mNeckFX.neckMeshView.setVisible(false);

                } else {
                    controller.currentStickman.mNeckFX.neckMeshView.setVisible(true);

                }

                Color col = controller.currentStickman.mNeckFX.mColor;
                col = new Color(col.getRed(), col.getGreen(), col.getBlue(), newValue.doubleValue());

                controller.currentStickman.mNeckFX.mColor = col;

                controller.currentStickman.mNeckFX.update();

            }
        });
    }

    public static void shoesOpacityChanger(ReetiStageController controller, Slider shoesOpacitySlider) {
        shoesOpacitySlider.valueProperty().addListener(new ChangeListener<Number>() {

            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                if (newValue.doubleValue() <= 0.1) {
                } else {
                }

            }
        });
    }

    public static void lipsOpacityChanger(ReetiStageController controller, Slider lipsOpacitySlider) {
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

    public static void eyeOpacityChanger(ReetiStageController controller, Slider eyeOpacitySlider) {
        eyeOpacitySlider.valueProperty().addListener(new ChangeListener<Number>() {

            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                if (newValue.doubleValue() <= 0.1) {

                } else {

                }

            }
        });
    }

    public static void browOpacityChanger(ReetiStageController controller, Slider browOpacitySlider) {
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

    public static void noseOpacityChanger(ReetiStageController controller, Slider noseOpacitySlider) {
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
