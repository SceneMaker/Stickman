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
                    controller.currentStickman.mHead.mHeadMeshView.setVisible(false);
                } else {
                    controller.currentStickman.mHead.mHeadMeshView.setVisible(true);
                }
                Color col = controller.currentStickman.mHead.mColor;
                col = new Color(col.getRed(), col.getGreen(), col.getBlue(), newValue.doubleValue());
                controller.currentStickman.mHead.mColor = col;
                controller.currentStickman.mHead.update();
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
                    controller.currentStickman.mBody.mBodyMeshView.setVisible(false);
                } else {
                    controller.currentStickman.mBody.mBodyMeshView.setVisible(true);
                }

                Color col1 = controller.currentStickman.mBody.mColor;
                col1 = new Color(col1.getRed(), col1.getGreen(), col1.getBlue(), newValue.doubleValue());
                controller.currentStickman.mBody.mColor = col1;
                controller.currentStickman.mBody.update();
            }
        });
    }

    public static void limbsOpacityChanger(ReetiStageController controller, Slider limbsOpacitySlider) {
        limbsOpacitySlider.valueProperty().addListener(new ChangeListener<Number>() {

            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                if (newValue.doubleValue() <= 0.1) {
                    controller.currentStickman.mNeck.neckMeshView.setVisible(false);

                } else {
                    controller.currentStickman.mNeck.neckMeshView.setVisible(true);

                }

                Color col = controller.currentStickman.mNeck.mColor;
                col = new Color(col.getRed(), col.getGreen(), col.getBlue(), newValue.doubleValue());

                controller.currentStickman.mNeck.mColor = col;

                controller.currentStickman.mNeck.update();

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

                Color col = controller.currentStickman.mLeftEyelid.mColor;
//                Color col1 = controller.currentStickman.mNose.mColor;
                col = new Color(col.getRed(), col.getGreen(), col.getBlue(), newValue.doubleValue());
//                col1 = new Color(col1.getRed(), col1.getGreen(), col1.getBlue(), newValue.doubleValue());

                controller.currentStickman.mLeftEyelid.mColor = col;
                controller.currentStickman.mRightEyelid.mColor = col;

//                controller.currentStickman.mNose.mColor = col1;
                controller.currentStickman.mLeftEyelid.update();
                controller.currentStickman.mRightEyelid.update();

//                controller.currentStickman.mNose.update();
            }
        });

    }

    public static void noseOpacityChanger(ReetiStageController controller, Slider noseOpacitySlider) {
        noseOpacitySlider.valueProperty().addListener(new ChangeListener<Number>() {

            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                if (newValue.doubleValue() <= 0.1) {
                    controller.currentStickman.mNose.mNose.setVisible(false);
                } else {
                    controller.currentStickman.mNose.mNose.setVisible(true);
                }
                Color col = controller.currentStickman.mNose.mColor;
                col = new Color(col.getRed(), col.getGreen(), col.getBlue(), newValue.doubleValue());

                controller.currentStickman.mNose.mColor = col;
                controller.currentStickman.mNose.update();
            }
        });

    }
}
