package de.dfki.reeti.controllerhelper;

import de.dfki.common.Gender;
import de.dfki.reeti.Reeti;
import de.dfki.reeti.ReetiStageController;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.input.MouseEvent;

public class ColorHelper {

    public static void headColorChanger(ReetiStageController controller) {
        if (controller.currentStickman != null) {
            controller.currentStickman.mHeadFX.mColor = controller.headColorPicker.getValue();
            controller.currentStickman.mHeadFX.update();
            controller.headOpacitySlider.setValue(1);
        }
    }

    public static void hairColorChanger(ReetiStageController controller) {
        if (controller.currentStickman != null) {
            if (controller.currentStickman.mType == Gender.TYPE.MALE) {
//                controller.currentStickman.mMaleHairFX.mColor = controller.hairColorPicker.getValue();
//                controller.currentStickman.mMaleHairFX.update();
            } else {
//                controller.currentStickman.mFemaleHairFX.mColor = controller.hairColorPicker.getValue();
//                controller.currentStickman.mFemaleHairFX.update();
            }
            controller.hairOpacitySlider.setValue(1);
        }
    }

    public static void bodyColorChanger(ReetiStageController controller) {
        if (controller.currentStickman != null) {
            controller.currentStickman.mUpperBody.mColor = controller.bodyColorPicker.getValue();
            controller.currentStickman.mUpperBody.update();
            //controller.bodyOpacitySlider.setValue(1);
        }
    }

    public static void limbsColorChanger(ReetiStageController controller) {
        if (controller.currentStickman != null) {
            controller.currentStickman.mNeckFX.mColor = controller.limbsColorPicker.getValue();

            controller.currentStickman.mNeckFX.update();
            controller.limbsOpacitySlider.setValue(1);
        }
    }

    public static void shoesColorChanger(ReetiStageController controller) {
        if (controller.currentStickman != null) {
            controller.shoesOpacitySlider.setValue(1);
        }
    }

    public static void lipsColorChanger(ReetiStageController controller) {
        if (controller.currentStickman != null) {
            controller.currentStickman.mMouthFX.mColor = controller.lipsColorPicker.getValue();
            controller.currentStickman.mMouthFX.update();
            controller.lipsOpacitySlider.setValue(1);
        }
    }

    public static void eyeColorChanger(ReetiStageController controller) {
        if (controller.currentStickman != null) {
            controller.eyeOpacitySlider.setValue(1);
        }
    }

    public static void browColorChanger(ReetiStageController controller) {
        if (controller.currentStickman != null) {
            controller.currentStickman.mLeftEyebrowFX.mColor = controller.browColorPicker.getValue();
            controller.currentStickman.mRightEyebrowFX.mColor = controller.browColorPicker.getValue();
            controller.currentStickman.mLeftEyebrowFX.update();
            controller.currentStickman.mRightEyebrowFX.update();
            controller.browOpacitySlider.setValue(1);
        }
    }

    public static void noseColorChanger(ReetiStageController controller) {
        if (controller.currentStickman != null) {
            controller.currentStickman.mNoseFX.mColor = controller.noseColorPicker.getValue();
            controller.currentStickman.mNoseFX.update();
            controller.noseOpacitySlider.setValue(1);
        }
    }

    public static void handleHeadColorButtons(ReetiStageController sSC,
            MouseEvent ev) {
        if (sSC.currentStickman != null) {
            if (ev.getSource().equals(sSC.headColorBrighter)) {
                sSC.currentStickman.mHeadFX.mColor = sSC.currentStickman.mHeadFX.mColor.brighter();
                sSC.currentStickman.mHeadFX.update();
            } else if (ev.getSource().equals(sSC.headColorDarker)) {
                sSC.currentStickman.mHeadFX.mColor = sSC.currentStickman.mHeadFX.mColor.darker();
                sSC.currentStickman.mHeadFX.update();
            } else if (ev.getSource().equals(sSC.headColorReset)) {
                sSC.currentStickman.mHeadFX.mColor = sSC.currentStickman.mHeadFX.mColorRecorder;
                sSC.headOpacitySlider.setValue(1);
                sSC.currentStickman.mHeadFX.update();
            }
        }
    }

    public static void handleHairColorButtons(ReetiStageController sSC,
            MouseEvent ev) {

        if (sSC.currentStickman != null) {
            if (ev.getSource().equals(sSC.hairColorBrighter)) {
                if (sSC.currentStickman.mType == Gender.TYPE.MALE) {
//                    sSC.currentStickman.mMaleHairFX.mColor = sSC.currentStickman.mMaleHairFX.mColor.brighter();
//                    sSC.currentStickman.mMaleHairFX.update();
                } else {
//                    sSC.currentStickman.mFemaleHairFX.mColor = sSC.currentStickman.mFemaleHairFX.mColor.brighter();
//                    sSC.currentStickman.mFemaleHairFX.update();
                }
            } else if (ev.getSource().equals(sSC.hairColorDarker)) {
                if (sSC.currentStickman.mType == Gender.TYPE.MALE) {
//                    sSC.currentStickman.mMaleHairFX.mColor = sSC.currentStickman.mMaleHairFX.mColor.darker();
//                    sSC.currentStickman.mMaleHairFX.update();
                } else {
//                    sSC.currentStickman.mFemaleHairFX.mColor = sSC.currentStickman.mFemaleHairFX.mColor.darker();
//                    sSC.currentStickman.mFemaleHairFX.update();
                }
            } else if (ev.getSource().equals(sSC.hairColorReset)) {
                if (sSC.currentStickman.mType == Gender.TYPE.MALE) {
//                    sSC.currentStickman.mMaleHairFX.mColor = sSC.currentStickman.mMaleHairFX.mColorRecorder;
//                    sSC.currentStickman.mMaleHairFX.update();
                } else {
//                    sSC.currentStickman.mFemaleHairFX.mColor = sSC.currentStickman.mFemaleHairFX.mColorRecorder;
//                    sSC.currentStickman.mFemaleHairFX.update();
                }
                sSC.hairOpacitySlider.setValue(1);
            }
        }
    }

    public static void handleBodyColorButtons(ReetiStageController sSC,
            MouseEvent ev) {
        if (sSC.currentStickman != null) {
            if (ev.getSource().equals(sSC.bodyColorBrighter)) {
                sSC.currentStickman.mUpperBody.mColor = sSC.currentStickman.mUpperBody.mColor.brighter();
                sSC.currentStickman.mUpperBody.update();
            } else if (ev.getSource().equals(sSC.bodyColorDarker)) {
                sSC.currentStickman.mUpperBody.mColor = sSC.currentStickman.mUpperBody.mColor.darker();
                sSC.currentStickman.mUpperBody.update();
            } else if (ev.getSource().equals(sSC.bodyColorReset)) {
                sSC.currentStickman.mUpperBody.mColor = sSC.currentStickman.mUpperBody.mColorRecorder;
                sSC.bodyOpacitySlider.setValue(1);
                sSC.currentStickman.mUpperBody.update();
            }
        }
    }

    public static void handlelimbsColorButtons(ReetiStageController sSC,
            MouseEvent ev) {
        if (sSC.currentStickman != null) {
            if (ev.getSource().equals(sSC.limbsColorBrighter)) {
                sSC.currentStickman.mNeckFX.mColor = sSC.currentStickman.mNeckFX.mColor.brighter();

                sSC.currentStickman.mNeckFX.update();

            } else if (ev.getSource().equals(sSC.limbsColorDarker)) {
                sSC.currentStickman.mNeckFX.mColor = sSC.currentStickman.mNeckFX.mColor.darker();

                sSC.currentStickman.mNeckFX.update();

            } else if (ev.getSource().equals(sSC.limbsColorReset)) {
                sSC.currentStickman.mNeckFX.mColor = sSC.currentStickman.mNeckFX.mColorRecorder;
                sSC.limbsOpacitySlider.setValue(1);

                sSC.currentStickman.mNeckFX.update();
            }
        }
    }

    public static void handleShoesColorButtons(ReetiStageController sSC,
            MouseEvent ev) {
        if (sSC.currentStickman != null) {
            if (ev.getSource().equals(sSC.shoesColorBrighter)) {
            } else if (ev.getSource().equals(sSC.shoesColorDarker)) {
            } else if (ev.getSource().equals(sSC.shoesColorReset)) {
                sSC.shoesOpacitySlider.setValue(1);
            }
        }
    }

    public static void handleLipsColorButtons(ReetiStageController sSC, MouseEvent ev) {
        if (sSC.currentStickman != null) {
            if (ev.getSource().equals(sSC.lipsColorBrighter)) {
                sSC.currentStickman.mMouthFX.mColor = sSC.currentStickman.mMouthFX.mColor.brighter();
                sSC.currentStickman.mMouthFX.update();
            } else if (ev.getSource().equals(sSC.lipsColorDarker)) {
                sSC.currentStickman.mMouthFX.mColor = sSC.currentStickman.mMouthFX.mColor.darker();
                sSC.currentStickman.mMouthFX.update();
            } else if (ev.getSource().equals(sSC.lipsColorReset)) {
                sSC.currentStickman.mMouthFX.mColor = sSC.currentStickman.mMouthFX.mColorRecorder;
                sSC.lipsOpacitySlider.setValue(1);
                sSC.currentStickman.mMouthFX.update();
            }
        }
    }

    public static void handleEyeColorButtons(ReetiStageController sSC,
            MouseEvent ev) {
        if (sSC.currentStickman != null) {
            if (ev.getSource().equals(sSC.eyeColorBrighter)) {
            } else if (ev.getSource().equals(sSC.eyeColorDarker)) {
            } else if (ev.getSource().equals(sSC.eyeColorReset)) {
                sSC.eyeOpacitySlider.setValue(1);
            }
        }
    }

    public static void handleBrowColorButtons(ReetiStageController sSC, MouseEvent ev) {
        if (sSC.currentStickman != null) {
            if (ev.getSource().equals(sSC.browColorBrighter)) {
                sSC.currentStickman.mLeftEyebrowFX.mColor = sSC.currentStickman.mLeftEyebrowFX.mColor.brighter();
                sSC.currentStickman.mRightEyebrowFX.mColor = sSC.currentStickman.mRightEyebrowFX.mColor.brighter();
                sSC.currentStickman.mLeftEyebrowFX.update();
                sSC.currentStickman.mRightEyebrowFX.update();
            } else if (ev.getSource().equals(sSC.browColorDarker)) {
                sSC.currentStickman.mLeftEyebrowFX.mColor = sSC.currentStickman.mLeftEyebrowFX.mColor.darker();
                sSC.currentStickman.mRightEyebrowFX.mColor = sSC.currentStickman.mRightEyebrowFX.mColor.darker();
                sSC.currentStickman.mLeftEyebrowFX.update();
                sSC.currentStickman.mRightEyebrowFX.update();
            } else if (ev.getSource().equals(sSC.browColorReset)) {
                sSC.currentStickman.mLeftEyebrowFX.mColor = sSC.currentStickman.mLeftEyebrowFX.mColorRecorder;
                sSC.currentStickman.mRightEyebrowFX.mColor = sSC.currentStickman.mRightEyebrowFX.mColorRecorder;
                sSC.browOpacitySlider.setValue(1);
                sSC.currentStickman.mLeftEyebrowFX.update();
                sSC.currentStickman.mRightEyebrowFX.update();
            }
        }
    }

    public static void handleNoseColorButtons(ReetiStageController sSC, MouseEvent ev) {
        if (sSC.currentStickman != null) {
            if (ev.getSource().equals(sSC.noseColorBrighter)) {
                sSC.currentStickman.mNoseFX.mColor = sSC.currentStickman.mNoseFX.mColor.brighter();
                sSC.currentStickman.mNoseFX.update();
            } else if (ev.getSource().equals(sSC.noseColorDarker)) {
                sSC.currentStickman.mNoseFX.mColor = sSC.currentStickman.mNoseFX.mColor.darker();
                sSC.currentStickman.mNoseFX.update();
            } else if (ev.getSource().equals(sSC.noseColorReset)) {
                sSC.currentStickman.mNoseFX.mColor = sSC.currentStickman.mNoseFX.mColorRecorder;
                sSC.noseOpacitySlider.setValue(1);
                sSC.currentStickman.mNoseFX.update();
            }
        }
    }

    public static void resetAll(Reeti currentStickman) {
        currentStickman.mHeadFX.mColor = currentStickman.mHeadFX.mColorRecorder;
        currentStickman.mHeadFX.update();

        if (currentStickman.mType == Gender.TYPE.MALE) {
//            currentStickman.mMaleHairFX.mColor = currentStickman.mMaleHairFX.mColorRecorder;
//            currentStickman.mMaleHairFX.update();
        } else {
//            currentStickman.mFemaleHairFX.mColor = currentStickman.mFemaleHairFX.mColorRecorder;
//            currentStickman.mFemaleHairFX.update();
        }
        currentStickman.mUpperBody.mColor = currentStickman.mUpperBody.mColorRecorder;
        currentStickman.mUpperBody.update();
        currentStickman.mNeckFX.mColor = currentStickman.mNeckFX.mColorRecorder;
        currentStickman.mNeckFX.update();
        currentStickman.mMouthFX.mColor = currentStickman.mMouthFX.mColorRecorder;
        currentStickman.mMouthFX.update();
        currentStickman.mLeftEyebrowFX.mColor = currentStickman.mLeftEyebrowFX.mColorRecorder;
        currentStickman.mRightEyebrowFX.mColor = currentStickman.mRightEyebrowFX.mColorRecorder;
        currentStickman.mLeftEyebrowFX.update();
        currentStickman.mRightEyebrowFX.update();
        currentStickman.mNoseFX.mColor = currentStickman.mNoseFX.mColorRecorder;
        currentStickman.mNoseFX.update();
    }
}
