package de.dfki.stickman3D.controllerhelper;

import de.dfki.common.Gender;
import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.StickmanStageController;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.input.MouseEvent;

public class ColorHelper {

    public static void headColorChanger(StickmanStageController controller) {
        if (controller.currentStickman != null) {
            controller.currentStickman.mHeadFX.mColor = controller.headColorPicker.getValue();
            controller.currentStickman.mHeadFX.update();
            controller.headOpacitySlider.setValue(1);
        }
    }

    public static void hairColorChanger(StickmanStageController controller) {
        if (controller.currentStickman != null) {
            if (controller.currentStickman.mType == Gender.TYPE.MALE) {
                controller.currentStickman.mMaleHairFX.mColor = controller.hairColorPicker.getValue();
                controller.currentStickman.mMaleHairFX.update();
            } else {
                controller.currentStickman.mFemaleHairFX.mColor = controller.hairColorPicker.getValue();
                controller.currentStickman.mFemaleHairFX.update();
            }
            controller.hairOpacitySlider.setValue(1);
        }
    }

    public static void bodyColorChanger(StickmanStageController controller) {
        if (controller.currentStickman != null) {
            controller.currentStickman.mUpperBody.mColor = controller.bodyColorPicker.getValue();
            controller.currentStickman.mUpperBody.update();
            //controller.bodyOpacitySlider.setValue(1);
        }
    }

    public static void limbsColorChanger(StickmanStageController controller) {
        if (controller.currentStickman != null) {
            controller.currentStickman.mNeckFX.mColor = controller.limbsColorPicker.getValue();
            controller.currentStickman.mLeftUpperArmFX.mColor = controller.limbsColorPicker.getValue();
            controller.currentStickman.mLeftForeArmFX.mColor = controller.limbsColorPicker.getValue();
            controller.currentStickman.mLeftWrist.mColor = controller.limbsColorPicker.getValue();
            controller.currentStickman.mLeftFinger1.mColor = controller.limbsColorPicker.getValue();
            controller.currentStickman.mLeftFinger2.mColor = controller.limbsColorPicker.getValue();
            controller.currentStickman.mLeftFinger3.mColor = controller.limbsColorPicker.getValue();
            controller.currentStickman.mLeftFinger4.mColor = controller.limbsColorPicker.getValue();
            controller.currentStickman.mLeftUpperLegFX.mColor = controller.limbsColorPicker.getValue();
            controller.currentStickman.mLeftForeLegFX.mColor = controller.limbsColorPicker.getValue();

            controller.currentStickman.mRightUpperArmFX.mColor = controller.limbsColorPicker.getValue();
            controller.currentStickman.mRightForeArmFX.mColor = controller.limbsColorPicker.getValue();
            controller.currentStickman.mRightWrist.mColor = controller.limbsColorPicker.getValue();
            controller.currentStickman.mRightFinger1.mColor = controller.limbsColorPicker.getValue();
            controller.currentStickman.mRightFinger2.mColor = controller.limbsColorPicker.getValue();
            controller.currentStickman.mRightFinger3.mColor = controller.limbsColorPicker.getValue();
            controller.currentStickman.mRightFinger4.mColor = controller.limbsColorPicker.getValue();
            controller.currentStickman.mRightUpperLegFX.mColor = controller.limbsColorPicker.getValue();
            controller.currentStickman.mRightForeLegFX.mColor = controller.limbsColorPicker.getValue();
            

            controller.currentStickman.mNeckFX.update();
            controller.currentStickman.mLeftUpperArmFX.update();
            controller.currentStickman.mLeftForeArmFX.update();
            controller.currentStickman.mLeftWrist.update();
            controller.currentStickman.mLeftFinger1.update();
            controller.currentStickman.mLeftFinger2.update();
            controller.currentStickman.mLeftFinger3.update();
            controller.currentStickman.mLeftFinger4.update();
            controller.currentStickman.mLeftUpperLegFX.update();
            controller.currentStickman.mLeftForeLegFX.update();

            controller.currentStickman.mRightUpperArmFX.update();
            controller.currentStickman.mRightForeArmFX.update();
            controller.currentStickman.mRightWrist.update();
            controller.currentStickman.mRightFinger1.update();
            controller.currentStickman.mRightFinger2.update();
            controller.currentStickman.mRightFinger3.update();
            controller.currentStickman.mRightFinger4.update();
            controller.currentStickman.mRightUpperLegFX.update();
            controller.currentStickman.mRightForeLegFX.update();
            controller.limbsOpacitySlider.setValue(1);
        }
    }

    public static void shoesColorChanger(StickmanStageController controller) {
        if (controller.currentStickman != null) {
            controller.currentStickman.mLeftFootFX.mColor = controller.shoesColorPicker.getValue();
            controller.currentStickman.mRightFootFX.mColor = controller.shoesColorPicker.getValue();
            controller.currentStickman.mLeftFootFX.update();
            controller.currentStickman.mRightFootFX.update();
            controller.shoesOpacitySlider.setValue(1);
        }
    }

    public static void lipsColorChanger(StickmanStageController controller) {
        if (controller.currentStickman != null) {
            controller.currentStickman.mMouthFX.mColor = controller.lipsColorPicker.getValue();
            controller.currentStickman.mMouthFX.update();
            controller.lipsOpacitySlider.setValue(1);
        }
    }

    public static void eyeColorChanger(StickmanStageController controller) {
        if (controller.currentStickman != null) {
            controller.currentStickman.mLeftEyeFX.mColor = controller.eyeColorPicker.getValue();
            controller.currentStickman.mRightEyeFX.mColor = controller.eyeColorPicker.getValue();
            controller.currentStickman.mLeftEyeFX.update();
            controller.currentStickman.mRightEyeFX.update();
            controller.eyeOpacitySlider.setValue(1);
        }
    }

    public static void browColorChanger(StickmanStageController controller) {
        if (controller.currentStickman != null) {
            controller.currentStickman.mLeftEyebrowFX.mColor = controller.browColorPicker.getValue();
            controller.currentStickman.mRightEyebrowFX.mColor = controller.browColorPicker.getValue();
            controller.currentStickman.mLeftEyebrowFX.update();
            controller.currentStickman.mRightEyebrowFX.update();
            controller.browOpacitySlider.setValue(1);
        }
    }

    public static void noseColorChanger(StickmanStageController controller) {
        if (controller.currentStickman != null) {
            controller.currentStickman.mNoseFX.mColor = controller.noseColorPicker.getValue();
            controller.currentStickman.mNoseFX.update();
            controller.noseOpacitySlider.setValue(1);
        }
    }

    public static void handleHeadColorButtons(StickmanStageController sSC,
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

    public static void handleHairColorButtons(StickmanStageController sSC, 
            MouseEvent ev) {

        if (sSC.currentStickman != null) {
            if (ev.getSource().equals(sSC.hairColorBrighter)) {
                if (sSC.currentStickman.mType == Gender.TYPE.MALE) {
                    sSC.currentStickman.mMaleHairFX.mColor = sSC.currentStickman.mMaleHairFX.mColor.brighter();
                    sSC.currentStickman.mMaleHairFX.update();
                } else {
                    sSC.currentStickman.mFemaleHairFX.mColor = sSC.currentStickman.mFemaleHairFX.mColor.brighter();
                    sSC.currentStickman.mFemaleHairFX.update();
                }
            } else if (ev.getSource().equals(sSC.hairColorDarker)) {
                if (sSC.currentStickman.mType == Gender.TYPE.MALE) {
                    sSC.currentStickman.mMaleHairFX.mColor = sSC.currentStickman.mMaleHairFX.mColor.darker();
                    sSC.currentStickman.mMaleHairFX.update();
                } else {
                    sSC.currentStickman.mFemaleHairFX.mColor = sSC.currentStickman.mFemaleHairFX.mColor.darker();
                    sSC.currentStickman.mFemaleHairFX.update();
                }
            } else if (ev.getSource().equals(sSC.hairColorReset)) {
                if (sSC.currentStickman.mType == Gender.TYPE.MALE) {
                    sSC.currentStickman.mMaleHairFX.mColor = sSC.currentStickman.mMaleHairFX.mColorRecorder;
                    sSC.currentStickman.mMaleHairFX.update();
                } else {
                    sSC.currentStickman.mFemaleHairFX.mColor = sSC.currentStickman.mFemaleHairFX.mColorRecorder;
                    sSC.currentStickman.mFemaleHairFX.update();
                }
                sSC.hairOpacitySlider.setValue(1);
            }
        }
    }

    public static void handleBodyColorButtons(StickmanStageController sSC, 
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

    public static void handlelimbsColorButtons(StickmanStageController sSC, 
            MouseEvent ev) {
        if (sSC.currentStickman != null) {
            if (ev.getSource().equals(sSC.limbsColorBrighter)) {
                sSC.currentStickman.mNeckFX.mColor = sSC.currentStickman.mNeckFX.mColor.brighter();
                sSC.currentStickman.mLeftUpperArmFX.mColor = sSC.currentStickman.mLeftUpperArmFX.mColor.brighter();
                sSC.currentStickman.mLeftForeArmFX.mColor = sSC.currentStickman.mLeftForeArmFX.mColor.brighter();
                sSC.currentStickman.mLeftWrist.mColor = sSC.currentStickman.mLeftWrist.mColor.brighter();
                sSC.currentStickman.mLeftFinger1.mColor = sSC.currentStickman.mLeftFinger1.mColor.brighter();
                sSC.currentStickman.mLeftFinger2.mColor = sSC.currentStickman.mLeftFinger2.mColor.brighter();
                sSC.currentStickman.mLeftFinger3.mColor = sSC.currentStickman.mLeftFinger3.mColor.brighter();
                sSC.currentStickman.mLeftFinger4.mColor = sSC.currentStickman.mLeftFinger4.mColor.brighter();
                sSC.currentStickman.mLeftUpperLegFX.mColor = sSC.currentStickman.mLeftUpperLegFX.mColor.brighter();
                sSC.currentStickman.mLeftForeLegFX.mColor = sSC.currentStickman.mLeftForeLegFX.mColor.brighter();

                sSC.currentStickman.mRightUpperArmFX.mColor = sSC.currentStickman.mRightUpperArmFX.mColor.brighter();
                sSC.currentStickman.mRightForeArmFX.mColor = sSC.currentStickman.mRightForeArmFX.mColor.brighter();
                sSC.currentStickman.mRightWrist.mColor = sSC.currentStickman.mRightWrist.mColor.brighter();
                sSC.currentStickman.mRightFinger1.mColor = sSC.currentStickman.mRightFinger1.mColor.brighter();
                sSC.currentStickman.mRightFinger2.mColor = sSC.currentStickman.mRightFinger2.mColor.brighter();
                sSC.currentStickman.mRightFinger3.mColor = sSC.currentStickman.mRightFinger3.mColor.brighter();
                sSC.currentStickman.mRightFinger4.mColor = sSC.currentStickman.mRightFinger4.mColor.brighter();
                sSC.currentStickman.mRightUpperLegFX.mColor = sSC.currentStickman.mRightUpperLegFX.mColor.brighter();
                sSC.currentStickman.mRightForeLegFX.mColor = sSC.currentStickman.mRightForeLegFX.mColor.brighter();

                sSC.currentStickman.mNeckFX.update();
                sSC.currentStickman.mLeftUpperArmFX.update();
                sSC.currentStickman.mLeftForeArmFX.update();
                sSC.currentStickman.mLeftWrist.update();
                sSC.currentStickman.mLeftFinger1.update();
                sSC.currentStickman.mLeftFinger2.update();
                sSC.currentStickman.mLeftFinger3.update();
                sSC.currentStickman.mLeftFinger4.update();
                sSC.currentStickman.mLeftUpperLegFX.update();
                sSC.currentStickman.mLeftForeLegFX.update();

                sSC.currentStickman.mRightUpperArmFX.update();
                sSC.currentStickman.mRightForeArmFX.update();
                sSC.currentStickman.mRightWrist.update();
                sSC.currentStickman.mRightFinger1.update();
                sSC.currentStickman.mRightFinger2.update();
                sSC.currentStickman.mRightFinger3.update();
                sSC.currentStickman.mRightFinger4.update();
                sSC.currentStickman.mRightUpperLegFX.update();
                sSC.currentStickman.mRightForeLegFX.update();
            } else if (ev.getSource().equals(sSC.limbsColorDarker)) {
                sSC.currentStickman.mNeckFX.mColor = sSC.currentStickman.mNeckFX.mColor.darker();
                sSC.currentStickman.mLeftUpperArmFX.mColor = sSC.currentStickman.mLeftUpperArmFX.mColor.darker();
                sSC.currentStickman.mLeftForeArmFX.mColor = sSC.currentStickman.mLeftForeArmFX.mColor.darker();
                sSC.currentStickman.mLeftWrist.mColor = sSC.currentStickman.mLeftWrist.mColor.darker();
                sSC.currentStickman.mLeftFinger1.mColor = sSC.currentStickman.mLeftFinger1.mColor.darker();
                sSC.currentStickman.mLeftFinger2.mColor = sSC.currentStickman.mLeftFinger2.mColor.darker();
                sSC.currentStickman.mLeftFinger3.mColor = sSC.currentStickman.mLeftFinger3.mColor.darker();
                sSC.currentStickman.mLeftFinger4.mColor = sSC.currentStickman.mLeftFinger4.mColor.darker();
                sSC.currentStickman.mLeftUpperLegFX.mColor = sSC.currentStickman.mLeftUpperLegFX.mColor.darker();
                sSC.currentStickman.mLeftForeLegFX.mColor = sSC.currentStickman.mLeftForeLegFX.mColor.darker();

                sSC.currentStickman.mRightUpperArmFX.mColor = sSC.currentStickman.mRightUpperArmFX.mColor.darker();
                sSC.currentStickman.mRightForeArmFX.mColor = sSC.currentStickman.mRightForeArmFX.mColor.darker();
                sSC.currentStickman.mRightWrist.mColor = sSC.currentStickman.mRightWrist.mColor.darker();
                sSC.currentStickman.mRightFinger1.mColor = sSC.currentStickman.mRightFinger1.mColor.darker();
                sSC.currentStickman.mRightFinger2.mColor = sSC.currentStickman.mRightFinger2.mColor.darker();
                sSC.currentStickman.mRightFinger3.mColor = sSC.currentStickman.mRightFinger3.mColor.darker();
                sSC.currentStickman.mRightFinger4.mColor = sSC.currentStickman.mRightFinger4.mColor.darker();
                sSC.currentStickman.mRightUpperLegFX.mColor = sSC.currentStickman.mRightUpperLegFX.mColor.darker();
                sSC.currentStickman.mRightForeLegFX.mColor = sSC.currentStickman.mRightForeLegFX.mColor.darker();

                sSC.currentStickman.mNeckFX.update();
                sSC.currentStickman.mLeftUpperArmFX.update();
                sSC.currentStickman.mLeftForeArmFX.update();
                sSC.currentStickman.mLeftWrist.update();
                sSC.currentStickman.mLeftFinger1.update();
                sSC.currentStickman.mLeftFinger2.update();
                sSC.currentStickman.mLeftFinger3.update();
                sSC.currentStickman.mLeftFinger4.update();
                sSC.currentStickman.mLeftUpperLegFX.update();
                sSC.currentStickman.mLeftForeLegFX.update();

                sSC.currentStickman.mRightUpperArmFX.update();
                sSC.currentStickman.mRightForeArmFX.update();
                sSC.currentStickman.mRightWrist.update();
                sSC.currentStickman.mRightFinger1.update();
                sSC.currentStickman.mRightFinger2.update();
                sSC.currentStickman.mRightFinger3.update();
                sSC.currentStickman.mRightFinger4.update();
                sSC.currentStickman.mRightUpperLegFX.update();
                sSC.currentStickman.mRightForeLegFX.update();
            } else if (ev.getSource().equals(sSC.limbsColorReset)) {
                sSC.currentStickman.mNeckFX.mColor = sSC.currentStickman.mNeckFX.mColorRecorder;
                sSC.currentStickman.mLeftUpperArmFX.mColor = sSC.currentStickman.mLeftUpperArmFX.mColorRecorder;
                sSC.currentStickman.mLeftForeArmFX.mColor = sSC.currentStickman.mLeftForeArmFX.mColorRecorder;
                sSC.currentStickman.mLeftWrist.mColor = sSC.currentStickman.mLeftWrist.mColorRecorder;
                sSC.currentStickman.mLeftFinger1.mColor = sSC.currentStickman.mLeftFinger1.mColorRecorder;
                sSC.currentStickman.mLeftFinger2.mColor = sSC.currentStickman.mLeftFinger2.mColorRecorder;
                sSC.currentStickman.mLeftFinger3.mColor = sSC.currentStickman.mLeftFinger3.mColorRecorder;
                sSC.currentStickman.mLeftFinger4.mColor = sSC.currentStickman.mLeftFinger4.mColorRecorder;
                sSC.currentStickman.mLeftUpperLegFX.mColor = sSC.currentStickman.mLeftUpperLegFX.mColorRecorder;
                sSC.currentStickman.mLeftForeLegFX.mColor = sSC.currentStickman.mLeftForeLegFX.mColorRecorder;

                sSC.currentStickman.mRightUpperArmFX.mColor = sSC.currentStickman.mRightUpperArmFX.mColorRecorder;
                sSC.currentStickman.mRightForeArmFX.mColor = sSC.currentStickman.mRightForeArmFX.mColorRecorder;
                sSC.currentStickman.mRightWrist.mColor = sSC.currentStickman.mRightWrist.mColorRecorder;
                sSC.currentStickman.mRightFinger1.mColor = sSC.currentStickman.mRightFinger1.mColorRecorder;
                sSC.currentStickman.mRightFinger2.mColor = sSC.currentStickman.mRightFinger2.mColorRecorder;
                sSC.currentStickman.mRightFinger3.mColor = sSC.currentStickman.mRightFinger3.mColorRecorder;
                sSC.currentStickman.mRightFinger4.mColor = sSC.currentStickman.mRightFinger4.mColorRecorder;
                sSC.currentStickman.mRightUpperLegFX.mColor = sSC.currentStickman.mRightUpperLegFX.mColorRecorder;
                sSC.currentStickman.mRightForeLegFX.mColor = sSC.currentStickman.mRightForeLegFX.mColorRecorder;
                
                sSC.limbsOpacitySlider.setValue(1);

                sSC.currentStickman.mNeckFX.update();
                sSC.currentStickman.mLeftUpperArmFX.update();
                sSC.currentStickman.mLeftForeArmFX.update();
                sSC.currentStickman.mLeftWrist.update();
                sSC.currentStickman.mLeftFinger1.update();
                sSC.currentStickman.mLeftFinger2.update();
                sSC.currentStickman.mLeftFinger3.update();
                sSC.currentStickman.mLeftFinger4.update();
                sSC.currentStickman.mLeftUpperLegFX.update();
                sSC.currentStickman.mLeftForeLegFX.update();

                sSC.currentStickman.mRightUpperArmFX.update();
                sSC.currentStickman.mRightForeArmFX.update();
                sSC.currentStickman.mRightWrist.update();
                sSC.currentStickman.mRightFinger1.update();
                sSC.currentStickman.mRightFinger2.update();
                sSC.currentStickman.mRightFinger3.update();
                sSC.currentStickman.mRightFinger4.update();
                sSC.currentStickman.mRightUpperLegFX.update();
                sSC.currentStickman.mRightForeLegFX.update();
            }
        }
    }

    public static void handleShoesColorButtons(StickmanStageController sSC, 
            MouseEvent ev) {
        if (sSC.currentStickman != null) {
            if (ev.getSource().equals(sSC.shoesColorBrighter)) {
                sSC.currentStickman.mLeftFootFX.mColor = sSC.currentStickman.mLeftFootFX.mColor.brighter();
                sSC.currentStickman.mRightFootFX.mColor = sSC.currentStickman.mRightFootFX.mColor.brighter();
                sSC.currentStickman.mLeftFootFX.update();
                sSC.currentStickman.mRightFootFX.update();
            } else if (ev.getSource().equals(sSC.shoesColorDarker)) {
                sSC.currentStickman.mLeftFootFX.mColor = sSC.currentStickman.mLeftFootFX.mColor.darker();
                sSC.currentStickman.mRightFootFX.mColor = sSC.currentStickman.mRightFootFX.mColor.darker();
                sSC.currentStickman.mLeftFootFX.update();
                sSC.currentStickman.mRightFootFX.update();
            } else if (ev.getSource().equals(sSC.shoesColorReset)) {
                sSC.currentStickman.mLeftFootFX.mColor = sSC.currentStickman.mLeftFootFX.mColorRecorder;
                sSC.currentStickman.mRightFootFX.mColor = sSC.currentStickman.mRightFootFX.mColorRecorder;
                sSC.shoesOpacitySlider.setValue(1);
                sSC.currentStickman.mLeftFootFX.update();
                sSC.currentStickman.mRightFootFX.update();
            }
        }
    }

    public static void handleLipsColorButtons(StickmanStageController sSC, MouseEvent ev) {
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

    public static void handleEyeColorButtons(StickmanStageController sSC,  
            MouseEvent ev) {
        if (sSC.currentStickman != null) {
            if (ev.getSource().equals(sSC.eyeColorBrighter)) {
                sSC.currentStickman.mLeftEyeFX.mColor = sSC.currentStickman.mLeftEyeFX.mColor.brighter();
                sSC.currentStickman.mRightEyeFX.mColor = sSC.currentStickman.mRightEyeFX.mColor.brighter();
                sSC.currentStickman.mLeftEyeFX.update();
                sSC.currentStickman.mRightEyeFX.update();
            } else if (ev.getSource().equals(sSC.eyeColorDarker)) {
                sSC.currentStickman.mLeftEyeFX.mColor = sSC.currentStickman.mLeftEyeFX.mColor.darker();
                sSC.currentStickman.mRightEyeFX.mColor = sSC.currentStickman.mRightEyeFX.mColor.darker();
                sSC.currentStickman.mLeftEyeFX.update();
                sSC.currentStickman.mRightEyeFX.update();
            } else if (ev.getSource().equals(sSC.eyeColorReset)) {
                sSC.currentStickman.mLeftEyeFX.mColor = sSC.currentStickman.mLeftEyeFX.mColorRecorder;
                sSC.currentStickman.mRightEyeFX.mColor = sSC.currentStickman.mRightEyeFX.mColorRecorder;
                sSC.eyeOpacitySlider.setValue(1);
                sSC.currentStickman.mLeftEyeFX.update();
                sSC.currentStickman.mRightEyeFX.update();
            }
        }
    }

    public static void handleBrowColorButtons(StickmanStageController sSC, MouseEvent ev) {
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

    public static void handleNoseColorButtons(StickmanStageController sSC, MouseEvent ev) {
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
    
    public static void resetAll(Stickman3D currentStickman)
    {
        currentStickman.mHeadFX.mColor = currentStickman.mHeadFX.mColorRecorder;
        currentStickman.mHeadFX.update();
        
        if (currentStickman.mType == Gender.TYPE.MALE) {
            currentStickman.mMaleHairFX.mColor = currentStickman.mMaleHairFX.mColorRecorder;
            currentStickman.mMaleHairFX.update();
        } else {
            currentStickman.mFemaleHairFX.mColor = currentStickman.mFemaleHairFX.mColorRecorder;
            currentStickman.mFemaleHairFX.update();
                }
        currentStickman.mUpperBody.mColor = currentStickman.mUpperBody.mColorRecorder;
        currentStickman.mUpperBody.update();
        currentStickman.mNeckFX.mColor = currentStickman.mNeckFX.mColorRecorder;
        currentStickman.mLeftUpperArmFX.mColor = currentStickman.mLeftUpperArmFX.mColorRecorder;
        currentStickman.mLeftForeArmFX.mColor = currentStickman.mLeftForeArmFX.mColorRecorder;
        currentStickman.mLeftWrist.mColor = currentStickman.mLeftWrist.mColorRecorder;
        currentStickman.mLeftFinger1.mColor = currentStickman.mLeftFinger1.mColorRecorder;
        currentStickman.mLeftFinger2.mColor = currentStickman.mLeftFinger2.mColorRecorder;
        currentStickman.mLeftFinger3.mColor = currentStickman.mLeftFinger3.mColorRecorder;
        currentStickman.mLeftFinger4.mColor = currentStickman.mLeftFinger4.mColorRecorder;
        currentStickman.mLeftUpperLegFX.mColor = currentStickman.mLeftUpperLegFX.mColorRecorder;
        currentStickman.mLeftForeLegFX.mColor = currentStickman.mLeftForeLegFX.mColorRecorder;
        currentStickman.mRightUpperArmFX.mColor = currentStickman.mRightUpperArmFX.mColorRecorder;
        currentStickman.mRightForeArmFX.mColor = currentStickman.mRightForeArmFX.mColorRecorder;
        currentStickman.mRightWrist.mColor = currentStickman.mRightWrist.mColorRecorder;
        currentStickman.mRightFinger1.mColor = currentStickman.mRightFinger1.mColorRecorder;
        currentStickman.mRightFinger2.mColor = currentStickman.mRightFinger2.mColorRecorder;
        currentStickman.mRightFinger3.mColor = currentStickman.mRightFinger3.mColorRecorder;
        currentStickman.mRightFinger4.mColor = currentStickman.mRightFinger4.mColorRecorder;
        currentStickman.mRightUpperLegFX.mColor = currentStickman.mRightUpperLegFX.mColorRecorder;
        currentStickman.mRightForeLegFX.mColor = currentStickman.mRightForeLegFX.mColorRecorder;
        currentStickman.mNeckFX.update();
        currentStickman.mLeftUpperArmFX.update();
        currentStickman.mLeftForeArmFX.update();
        currentStickman.mLeftWrist.update();
        currentStickman.mLeftFinger1.update();
        currentStickman.mLeftFinger2.update();
        currentStickman.mLeftFinger3.update();
        currentStickman.mLeftFinger4.update();
        currentStickman.mLeftUpperLegFX.update();
        currentStickman.mLeftForeLegFX.update();
        currentStickman.mRightUpperArmFX.update();
        currentStickman.mRightForeArmFX.update();
        currentStickman.mRightWrist.update();
        currentStickman.mRightFinger1.update();
        currentStickman.mRightFinger2.update();
        currentStickman.mRightFinger3.update();
        currentStickman.mRightFinger4.update();
        currentStickman.mRightUpperLegFX.update();
        currentStickman.mRightForeLegFX.update();
        currentStickman.mLeftFootFX.mColor = currentStickman.mLeftFootFX.mColorRecorder;
        currentStickman.mRightFootFX.mColor = currentStickman.mRightFootFX.mColorRecorder;
        currentStickman.mLeftFootFX.update();
        currentStickman.mRightFootFX.update();
        currentStickman.mMouthFX.mColor = currentStickman.mMouthFX.mColorRecorder;
        currentStickman.mMouthFX.update();
        currentStickman.mLeftEyeFX.mColor = currentStickman.mLeftEyeFX.mColorRecorder;
        currentStickman.mRightEyeFX.mColor = currentStickman.mRightEyeFX.mColorRecorder;
        currentStickman.mLeftEyeFX.update();
        currentStickman.mRightEyeFX.update();
        currentStickman.mLeftEyebrowFX.mColor = currentStickman.mLeftEyebrowFX.mColorRecorder;
        currentStickman.mRightEyebrowFX.mColor = currentStickman.mRightEyebrowFX.mColorRecorder;
        currentStickman.mLeftEyebrowFX.update();
        currentStickman.mRightEyebrowFX.update();
        currentStickman.mNoseFX.mColor = currentStickman.mNoseFX.mColorRecorder;
        currentStickman.mNoseFX.update();
    }
}
