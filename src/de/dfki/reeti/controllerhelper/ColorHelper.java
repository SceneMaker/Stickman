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
            controller.currentStickman.mHead.mColor = controller.headColorPicker.getValue();
            controller.currentStickman.mHead.update();
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
            controller.currentStickman.mBody.mColor = controller.bodyColorPicker.getValue();
            controller.currentStickman.mBody.update();
            //controller.bodyOpacitySlider.setValue(1);
        }
    }

    public static void limbsColorChanger(ReetiStageController controller) {
        if (controller.currentStickman != null) {
            controller.currentStickman.mNeck.mColor = controller.limbsColorPicker.getValue();

            controller.currentStickman.mNeck.update();
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
            controller.currentStickman.mMouth.mColor = controller.lipsColorPicker.getValue();
            controller.currentStickman.mMouth.update();
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
            controller.currentStickman.mLeftEyelid.mColor = controller.browColorPicker.getValue();
            controller.currentStickman.mRightEyelid.mColor = controller.browColorPicker.getValue();
            controller.currentStickman.mLeftEyelid.update();
            controller.currentStickman.mRightEyelid.update();
            controller.browOpacitySlider.setValue(1);
        }
    }

    public static void noseColorChanger(ReetiStageController controller) {
        if (controller.currentStickman != null) {
            controller.noseOpacitySlider.setValue(1);
        }
    }

    public static void handleHeadColorButtons(ReetiStageController sSC,
            MouseEvent ev) {
        if (sSC.currentStickman != null) {
            if (ev.getSource().equals(sSC.headColorBrighter)) {
                sSC.currentStickman.mHead.mColor = sSC.currentStickman.mHead.mColor.brighter();
                sSC.currentStickman.mHead.update();
            } else if (ev.getSource().equals(sSC.headColorDarker)) {
                sSC.currentStickman.mHead.mColor = sSC.currentStickman.mHead.mColor.darker();
                sSC.currentStickman.mHead.update();
            } else if (ev.getSource().equals(sSC.headColorReset)) {
                sSC.currentStickman.mHead.mColor = sSC.currentStickman.mHead.mColorRecorder;
                sSC.headOpacitySlider.setValue(1);
                sSC.currentStickman.mHead.update();
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
                sSC.currentStickman.mBody.mColor = sSC.currentStickman.mBody.mColor.brighter();
                sSC.currentStickman.mBody.update();
            } else if (ev.getSource().equals(sSC.bodyColorDarker)) {
                sSC.currentStickman.mBody.mColor = sSC.currentStickman.mBody.mColor.darker();
                sSC.currentStickman.mBody.update();
            } else if (ev.getSource().equals(sSC.bodyColorReset)) {
                sSC.currentStickman.mBody.mColor = sSC.currentStickman.mBody.mColorRecorder;
                sSC.bodyOpacitySlider.setValue(1);
                sSC.currentStickman.mBody.update();
            }
        }
    }

    public static void handlelimbsColorButtons(ReetiStageController sSC,
            MouseEvent ev) {
        if (sSC.currentStickman != null) {
            if (ev.getSource().equals(sSC.limbsColorBrighter)) {
                sSC.currentStickman.mNeck.mColor = sSC.currentStickman.mNeck.mColor.brighter();

                sSC.currentStickman.mNeck.update();

            } else if (ev.getSource().equals(sSC.limbsColorDarker)) {
                sSC.currentStickman.mNeck.mColor = sSC.currentStickman.mNeck.mColor.darker();

                sSC.currentStickman.mNeck.update();

            } else if (ev.getSource().equals(sSC.limbsColorReset)) {
                sSC.currentStickman.mNeck.mColor = sSC.currentStickman.mNeck.mColorRecorder;
                sSC.limbsOpacitySlider.setValue(1);

                sSC.currentStickman.mNeck.update();
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
                sSC.currentStickman.mMouth.mColor = sSC.currentStickman.mMouth.mColor.brighter();
                sSC.currentStickman.mMouth.update();
            } else if (ev.getSource().equals(sSC.lipsColorDarker)) {
                sSC.currentStickman.mMouth.mColor = sSC.currentStickman.mMouth.mColor.darker();
                sSC.currentStickman.mMouth.update();
            } else if (ev.getSource().equals(sSC.lipsColorReset)) {
                sSC.currentStickman.mMouth.mColor = sSC.currentStickman.mMouth.mColorRecorder;
                sSC.lipsOpacitySlider.setValue(1);
                sSC.currentStickman.mMouth.update();
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
                sSC.currentStickman.mLeftEyelid.mColor = sSC.currentStickman.mLeftEyelid.mColor.brighter();
                sSC.currentStickman.mRightEyelid.mColor = sSC.currentStickman.mRightEyelid.mColor.brighter();
                sSC.currentStickman.mLeftEyelid.update();
                sSC.currentStickman.mRightEyelid.update();
            } else if (ev.getSource().equals(sSC.browColorDarker)) {
                sSC.currentStickman.mLeftEyelid.mColor = sSC.currentStickman.mLeftEyelid.mColor.darker();
                sSC.currentStickman.mRightEyelid.mColor = sSC.currentStickman.mRightEyelid.mColor.darker();
                sSC.currentStickman.mLeftEyelid.update();
                sSC.currentStickman.mRightEyelid.update();
            } else if (ev.getSource().equals(sSC.browColorReset)) {
                sSC.currentStickman.mLeftEyelid.mColor = sSC.currentStickman.mLeftEyelid.mColorRecorder;
                sSC.currentStickman.mRightEyelid.mColor = sSC.currentStickman.mRightEyelid.mColorRecorder;
                sSC.browOpacitySlider.setValue(1);
                sSC.currentStickman.mLeftEyelid.update();
                sSC.currentStickman.mRightEyelid.update();
            }
        }
    }

    public static void handleNoseColorButtons(ReetiStageController sSC, MouseEvent ev) {
        if (sSC.currentStickman != null) {
            if (ev.getSource().equals(sSC.noseColorBrighter)) {
            } else if (ev.getSource().equals(sSC.noseColorDarker)) {
            } else if (ev.getSource().equals(sSC.noseColorReset)) {
                sSC.noseOpacitySlider.setValue(1);
            }
        }
    }

    public static void resetAll(Reeti currentStickman) {
        currentStickman.mHead.mColor = currentStickman.mHead.mColorRecorder;
        currentStickman.mHead.update();

        if (currentStickman.mType == Gender.TYPE.MALE) {
//            currentStickman.mMaleHairFX.mColor = currentStickman.mMaleHairFX.mColorRecorder;
//            currentStickman.mMaleHairFX.update();
        } else {
//            currentStickman.mFemaleHairFX.mColor = currentStickman.mFemaleHairFX.mColorRecorder;
//            currentStickman.mFemaleHairFX.update();
        }
        currentStickman.mBody.mColor = currentStickman.mBody.mColorRecorder;
        currentStickman.mBody.update();
        currentStickman.mNeck.mColor = currentStickman.mNeck.mColorRecorder;
        currentStickman.mNeck.update();
        currentStickman.mMouth.mColor = currentStickman.mMouth.mColorRecorder;
        currentStickman.mMouth.update();
        currentStickman.mLeftEyelid.mColor = currentStickman.mLeftEyelid.mColorRecorder;
        currentStickman.mRightEyelid.mColor = currentStickman.mRightEyelid.mColorRecorder;
        currentStickman.mLeftEyelid.update();
        currentStickman.mRightEyelid.update();
    }
}
