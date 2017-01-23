package de.dfki.stickman3D.controllerhelper;

import de.dfki.common.Gender;
import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.StickmanStageController;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.input.MouseEvent;

public class ColorHelper {

    public static void headColorChanger(Stickman3D currentStickman, ColorPicker headColorPicker) {
        if (currentStickman != null) {
            currentStickman.mHeadFX.mColor = headColorPicker.getValue();
            currentStickman.mHeadFX.update();
        }
    }

    public static void hairColorChanger(Stickman3D currentStickman, ColorPicker hairColorPicker) {
        if (currentStickman != null) {
            if (currentStickman.mType == Gender.TYPE.MALE) {
                currentStickman.mMaleHairFX.mColor = hairColorPicker.getValue();
                currentStickman.mMaleHairFX.update();
            } else {
                currentStickman.mFemaleHairFX.mColor = hairColorPicker.getValue();
                currentStickman.mFemaleHairFX.update();
            }
        }
    }

    public static void bodyColorChanger(Stickman3D currentStickman, ColorPicker bodyColorPicker) {
        if (currentStickman != null) {
            currentStickman.mUpperBody.mColor = bodyColorPicker.getValue();
            currentStickman.mUpperBody.update();
        }
    }

    public static void limbsColorChanger(Stickman3D currentStickman, ColorPicker limbsColorPicker) {
        if (currentStickman != null) {
            currentStickman.mNeckFX.mColor = limbsColorPicker.getValue();
            currentStickman.mLeftUpperArmFX.mColor = limbsColorPicker.getValue();
            currentStickman.mLeftForeArmFX.mColor = limbsColorPicker.getValue();
            currentStickman.mLeftWrist.mColor = limbsColorPicker.getValue();
            currentStickman.mLeftFinger1.mColor = limbsColorPicker.getValue();
            currentStickman.mLeftFinger2.mColor = limbsColorPicker.getValue();
            currentStickman.mLeftFinger3.mColor = limbsColorPicker.getValue();
            currentStickman.mLeftFinger4.mColor = limbsColorPicker.getValue();
            currentStickman.mLeftUpperLegFX.mColor = limbsColorPicker.getValue();
            currentStickman.mLeftForeLegFX.mColor = limbsColorPicker.getValue();

            currentStickman.mRightUpperArmFX.mColor = limbsColorPicker.getValue();
            currentStickman.mRightForeArmFX.mColor = limbsColorPicker.getValue();
            currentStickman.mRightWrist.mColor = limbsColorPicker.getValue();
            currentStickman.mRightFinger1.mColor = limbsColorPicker.getValue();
            currentStickman.mRightFinger2.mColor = limbsColorPicker.getValue();
            currentStickman.mRightFinger3.mColor = limbsColorPicker.getValue();
            currentStickman.mRightFinger4.mColor = limbsColorPicker.getValue();
            currentStickman.mRightUpperLegFX.mColor = limbsColorPicker.getValue();
            currentStickman.mRightForeLegFX.mColor = limbsColorPicker.getValue();

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
        }
    }

    public static void shoesColorChanger(Stickman3D currentStickman, ColorPicker shoesColorPicker) {
        if (currentStickman != null) {
            currentStickman.mLeftFootFX.mColor = shoesColorPicker.getValue();
            currentStickman.mRightFootFX.mColor = shoesColorPicker.getValue();
            currentStickman.mLeftFootFX.update();
            currentStickman.mRightFootFX.update();
        }
    }

    public static void lipsColorChanger(Stickman3D currentStickman, ColorPicker lipsColorPicker) {
        if (currentStickman != null) {
            currentStickman.mMouthFX.mColor = lipsColorPicker.getValue();
            currentStickman.mMouthFX.update();
        }
    }

    public static void eyeColorChanger(Stickman3D currentStickman, ColorPicker eyeColorPicker) {
        if (currentStickman != null) {
            currentStickman.mLeftEyeFX.mColor = eyeColorPicker.getValue();
            currentStickman.mRightEyeFX.mColor = eyeColorPicker.getValue();
            currentStickman.mLeftEyeFX.update();
            currentStickman.mRightEyeFX.update();
        }
    }

    public static void browColorChanger(Stickman3D currentStickman, ColorPicker browColorPicker) {
        if (currentStickman != null) {
            currentStickman.mLeftEyebrowFX.mColor = browColorPicker.getValue();
            currentStickman.mRightEyebrowFX.mColor = browColorPicker.getValue();
            currentStickman.mLeftEyebrowFX.update();
            currentStickman.mRightEyebrowFX.update();
        }
    }

    public static void noseColorChanger(Stickman3D currentStickman, ColorPicker noseColorPicker) {
        if (currentStickman != null) {
            currentStickman.mNoseFX.mColor = noseColorPicker.getValue();
            currentStickman.mNoseFX.update();
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
