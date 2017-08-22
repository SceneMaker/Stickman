package de.dfki.stickman3D.controllerhelper;

import de.dfki.common.enums.Gender;
import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.StickmanStageController;
import javafx.scene.input.MouseEvent;

public class ColorHelper
{

    public static void headColorChanger(StickmanStageController controller)
    {
        if (controller.currentStickman != null)
        {
            controller.currentStickman.mHead.mColor = controller.headColorPicker.getValue();
            controller.currentStickman.mHead.update();
            controller.headOpacitySlider.setValue(1);
        }
    }

    public static void hairColorChanger(StickmanStageController controller)
    {
        if (controller.currentStickman != null)
        {
            if (controller.currentStickman.mType == Gender.TYPE.MALE)
            {
                controller.currentStickman.mHair.mColor = controller.hairColorPicker.getValue();
                controller.currentStickman.mHair.update();
            } else
            {
                controller.currentStickman.mHair.mColor = controller.hairColorPicker.getValue();
                controller.currentStickman.mHair.update();
            }
            controller.hairOpacitySlider.setValue(1);
        }
    }

    public static void bodyColorChanger(StickmanStageController controller)
    {
        if (controller.currentStickman != null)
        {
            controller.currentStickman.mUpperBody.mColor = controller.bodyColorPicker.getValue();
            controller.currentStickman.mUpperBody.update();
            //controller.bodyOpacitySlider.setValue(1);
        }
    }

    public static void limbsColorChanger(StickmanStageController controller)
    {
        if (controller.currentStickman != null)
        {
            controller.currentStickman.mNeck.mColor = controller.limbsColorPicker.getValue();
            controller.currentStickman.mLeftUpperArm.mColor = controller.limbsColorPicker.getValue();
            controller.currentStickman.mLeftForeArm.mColor = controller.limbsColorPicker.getValue();
            controller.currentStickman.mLeftWrist.mColor = controller.limbsColorPicker.getValue();
            controller.currentStickman.mLeftFinger1.mColor = controller.limbsColorPicker.getValue();
            controller.currentStickman.mLeftFinger2.mColor = controller.limbsColorPicker.getValue();
            controller.currentStickman.mLeftFinger3.mColor = controller.limbsColorPicker.getValue();
            controller.currentStickman.mLeftFinger4.mColor = controller.limbsColorPicker.getValue();
            controller.currentStickman.mLeftUpperLeg.mColor = controller.limbsColorPicker.getValue();
            controller.currentStickman.mLeftForeLeg.mColor = controller.limbsColorPicker.getValue();

            controller.currentStickman.mRightUpperArm.mColor = controller.limbsColorPicker.getValue();
            controller.currentStickman.mRightForeArm.mColor = controller.limbsColorPicker.getValue();
            controller.currentStickman.mRightWrist.mColor = controller.limbsColorPicker.getValue();
            controller.currentStickman.mRightFinger1.mColor = controller.limbsColorPicker.getValue();
            controller.currentStickman.mRightFinger2.mColor = controller.limbsColorPicker.getValue();
            controller.currentStickman.mRightFinger3.mColor = controller.limbsColorPicker.getValue();
            controller.currentStickman.mRightFinger4.mColor = controller.limbsColorPicker.getValue();
            controller.currentStickman.mRightUpperLeg.mColor = controller.limbsColorPicker.getValue();
            controller.currentStickman.mRightForeLeg.mColor = controller.limbsColorPicker.getValue();


            controller.currentStickman.mNeck.update();
            controller.currentStickman.mLeftUpperArm.update();
            controller.currentStickman.mLeftForeArm.update();
            controller.currentStickman.mLeftWrist.update();
            controller.currentStickman.mLeftFinger1.update();
            controller.currentStickman.mLeftFinger2.update();
            controller.currentStickman.mLeftFinger3.update();
            controller.currentStickman.mLeftFinger4.update();
            controller.currentStickman.mLeftUpperLeg.update();
            controller.currentStickman.mLeftForeLeg.update();

            controller.currentStickman.mRightUpperArm.update();
            controller.currentStickman.mRightForeArm.update();
            controller.currentStickman.mRightWrist.update();
            controller.currentStickman.mRightFinger1.update();
            controller.currentStickman.mRightFinger2.update();
            controller.currentStickman.mRightFinger3.update();
            controller.currentStickman.mRightFinger4.update();
            controller.currentStickman.mRightUpperLeg.update();
            controller.currentStickman.mRightForeLeg.update();
            controller.limbsOpacitySlider.setValue(1);
        }
    }

    public static void shoesColorChanger(StickmanStageController controller)
    {
        if (controller.currentStickman != null)
        {
            controller.currentStickman.mLeftFoot.mColor = controller.shoesColorPicker.getValue();
            controller.currentStickman.mRightFoot.mColor = controller.shoesColorPicker.getValue();
            controller.currentStickman.mLeftFoot.update();
            controller.currentStickman.mRightFoot.update();
            controller.shoesOpacitySlider.setValue(1);
        }
    }

    public static void lipsColorChanger(StickmanStageController controller)
    {
        if (controller.currentStickman != null)
        {
            controller.currentStickman.mMouth.mColor = controller.lipsColorPicker.getValue();
            controller.currentStickman.mMouth.update();
            controller.lipsOpacitySlider.setValue(1);
        }
    }

    public static void eyeColorChanger(StickmanStageController controller)
    {
        if (controller.currentStickman != null)
        {
            controller.currentStickman.mLeftEye.mColor = controller.eyeColorPicker.getValue();
            controller.currentStickman.mRightEye.mColor = controller.eyeColorPicker.getValue();
            controller.currentStickman.mLeftEye.update();
            controller.currentStickman.mRightEye.update();
            controller.eyeOpacitySlider.setValue(1);
        }
    }

    public static void browColorChanger(StickmanStageController controller)
    {
        if (controller.currentStickman != null)
        {
            controller.currentStickman.mLeftEyebrow.mColor = controller.browColorPicker.getValue();
            controller.currentStickman.mRightEyebrow.mColor = controller.browColorPicker.getValue();
            controller.currentStickman.mLeftEyebrow.update();
            controller.currentStickman.mRightEyebrow.update();
            controller.browOpacitySlider.setValue(1);
        }
    }

    public static void noseColorChanger(StickmanStageController controller)
    {
        if (controller.currentStickman != null)
        {
            controller.currentStickman.mNose.mColor = controller.noseColorPicker.getValue();
            controller.currentStickman.mNose.update();
            controller.noseOpacitySlider.setValue(1);
        }
    }

    public static void handleHeadColorButtons(StickmanStageController sSC,
                                              MouseEvent ev)
    {
        if (sSC.currentStickman != null)
        {
            if (ev.getSource().equals(sSC.headColorBrighter))
            {
                sSC.currentStickman.mHead.mColor = sSC.currentStickman.mHead.mColor.brighter();
                sSC.currentStickman.mHead.update();
            } else if (ev.getSource().equals(sSC.headColorDarker))
            {
                sSC.currentStickman.mHead.mColor = sSC.currentStickman.mHead.mColor.darker();
                sSC.currentStickman.mHead.update();
            } else if (ev.getSource().equals(sSC.headColorReset))
            {
                sSC.currentStickman.mHead.mColor = sSC.currentStickman.mHead.mColorRecorder;
                sSC.headOpacitySlider.setValue(1);
                sSC.currentStickman.mHead.update();
            }
        }
    }

    public static void handleHairColorButtons(StickmanStageController sSC,
                                              MouseEvent ev)
    {

        if (sSC.currentStickman != null)
        {
            if (ev.getSource().equals(sSC.hairColorBrighter))
            {
                if (sSC.currentStickman.mType == Gender.TYPE.MALE)
                {
                    sSC.currentStickman.mHair.mColor = sSC.currentStickman.mHair.mColor.brighter();
                    sSC.currentStickman.mHair.update();
                } else
                {
                    sSC.currentStickman.mHair.mColor = sSC.currentStickman.mHair.mColor.brighter();
                    sSC.currentStickman.mHair.update();
                }
            } else if (ev.getSource().equals(sSC.hairColorDarker))
            {
                if (sSC.currentStickman.mType == Gender.TYPE.MALE)
                {
                    sSC.currentStickman.mHair.mColor = sSC.currentStickman.mHair.mColor.darker();
                    sSC.currentStickman.mHair.update();
                } else
                {
                    sSC.currentStickman.mHair.mColor = sSC.currentStickman.mHair.mColor.darker();
                    sSC.currentStickman.mHair.update();
                }
            } else if (ev.getSource().equals(sSC.hairColorReset))
            {
                if (sSC.currentStickman.mType == Gender.TYPE.MALE)
                {
                    sSC.currentStickman.mHair.mColor = sSC.currentStickman.mHair.mColorRecorder;
                    sSC.currentStickman.mHair.update();
                } else
                {
                    sSC.currentStickman.mHair.mColor = sSC.currentStickman.mHair.mColorRecorder;
                    sSC.currentStickman.mHair.update();
                }
                sSC.hairOpacitySlider.setValue(1);
            }
        }
    }

    public static void handleBodyColorButtons(StickmanStageController sSC,
                                              MouseEvent ev)
    {
        if (sSC.currentStickman != null)
        {
            if (ev.getSource().equals(sSC.bodyColorBrighter))
            {
                sSC.currentStickman.mUpperBody.mColor = sSC.currentStickman.mUpperBody.mColor.brighter();
                sSC.currentStickman.mUpperBody.update();
            } else if (ev.getSource().equals(sSC.bodyColorDarker))
            {
                sSC.currentStickman.mUpperBody.mColor = sSC.currentStickman.mUpperBody.mColor.darker();
                sSC.currentStickman.mUpperBody.update();
            } else if (ev.getSource().equals(sSC.bodyColorReset))
            {
                sSC.currentStickman.mUpperBody.mColor = sSC.currentStickman.mUpperBody.mColorRecorder;
                sSC.bodyOpacitySlider.setValue(1);
                sSC.currentStickman.mUpperBody.update();
            }
        }
    }

    public static void handlelimbsColorButtons(StickmanStageController sSC,
                                               MouseEvent ev)
    {
        if (sSC.currentStickman != null)
        {
            if (ev.getSource().equals(sSC.limbsColorBrighter))
            {
                sSC.currentStickman.mNeck.mColor = sSC.currentStickman.mNeck.mColor.brighter();
                sSC.currentStickman.mLeftUpperArm.mColor = sSC.currentStickman.mLeftUpperArm.mColor.brighter();
                sSC.currentStickman.mLeftForeArm.mColor = sSC.currentStickman.mLeftForeArm.mColor.brighter();
                sSC.currentStickman.mLeftWrist.mColor = sSC.currentStickman.mLeftWrist.mColor.brighter();
                sSC.currentStickman.mLeftFinger1.mColor = sSC.currentStickman.mLeftFinger1.mColor.brighter();
                sSC.currentStickman.mLeftFinger2.mColor = sSC.currentStickman.mLeftFinger2.mColor.brighter();
                sSC.currentStickman.mLeftFinger3.mColor = sSC.currentStickman.mLeftFinger3.mColor.brighter();
                sSC.currentStickman.mLeftFinger4.mColor = sSC.currentStickman.mLeftFinger4.mColor.brighter();
                sSC.currentStickman.mLeftUpperLeg.mColor = sSC.currentStickman.mLeftUpperLeg.mColor.brighter();
                sSC.currentStickman.mLeftForeLeg.mColor = sSC.currentStickman.mLeftForeLeg.mColor.brighter();

                sSC.currentStickman.mRightUpperArm.mColor = sSC.currentStickman.mRightUpperArm.mColor.brighter();
                sSC.currentStickman.mRightForeArm.mColor = sSC.currentStickman.mRightForeArm.mColor.brighter();
                sSC.currentStickman.mRightWrist.mColor = sSC.currentStickman.mRightWrist.mColor.brighter();
                sSC.currentStickman.mRightFinger1.mColor = sSC.currentStickman.mRightFinger1.mColor.brighter();
                sSC.currentStickman.mRightFinger2.mColor = sSC.currentStickman.mRightFinger2.mColor.brighter();
                sSC.currentStickman.mRightFinger3.mColor = sSC.currentStickman.mRightFinger3.mColor.brighter();
                sSC.currentStickman.mRightFinger4.mColor = sSC.currentStickman.mRightFinger4.mColor.brighter();
                sSC.currentStickman.mRightUpperLeg.mColor = sSC.currentStickman.mRightUpperLeg.mColor.brighter();
                sSC.currentStickman.mRightForeLeg.mColor = sSC.currentStickman.mRightForeLeg.mColor.brighter();

                sSC.currentStickman.mNeck.update();
                sSC.currentStickman.mLeftUpperArm.update();
                sSC.currentStickman.mLeftForeArm.update();
                sSC.currentStickman.mLeftWrist.update();
                sSC.currentStickman.mLeftFinger1.update();
                sSC.currentStickman.mLeftFinger2.update();
                sSC.currentStickman.mLeftFinger3.update();
                sSC.currentStickman.mLeftFinger4.update();
                sSC.currentStickman.mLeftUpperLeg.update();
                sSC.currentStickman.mLeftForeLeg.update();

                sSC.currentStickman.mRightUpperArm.update();
                sSC.currentStickman.mRightForeArm.update();
                sSC.currentStickman.mRightWrist.update();
                sSC.currentStickman.mRightFinger1.update();
                sSC.currentStickman.mRightFinger2.update();
                sSC.currentStickman.mRightFinger3.update();
                sSC.currentStickman.mRightFinger4.update();
                sSC.currentStickman.mRightUpperLeg.update();
                sSC.currentStickman.mRightForeLeg.update();
            } else if (ev.getSource().equals(sSC.limbsColorDarker))
            {
                sSC.currentStickman.mNeck.mColor = sSC.currentStickman.mNeck.mColor.darker();
                sSC.currentStickman.mLeftUpperArm.mColor = sSC.currentStickman.mLeftUpperArm.mColor.darker();
                sSC.currentStickman.mLeftForeArm.mColor = sSC.currentStickman.mLeftForeArm.mColor.darker();
                sSC.currentStickman.mLeftWrist.mColor = sSC.currentStickman.mLeftWrist.mColor.darker();
                sSC.currentStickman.mLeftFinger1.mColor = sSC.currentStickman.mLeftFinger1.mColor.darker();
                sSC.currentStickman.mLeftFinger2.mColor = sSC.currentStickman.mLeftFinger2.mColor.darker();
                sSC.currentStickman.mLeftFinger3.mColor = sSC.currentStickman.mLeftFinger3.mColor.darker();
                sSC.currentStickman.mLeftFinger4.mColor = sSC.currentStickman.mLeftFinger4.mColor.darker();
                sSC.currentStickman.mLeftUpperLeg.mColor = sSC.currentStickman.mLeftUpperLeg.mColor.darker();
                sSC.currentStickman.mLeftForeLeg.mColor = sSC.currentStickman.mLeftForeLeg.mColor.darker();

                sSC.currentStickman.mRightUpperArm.mColor = sSC.currentStickman.mRightUpperArm.mColor.darker();
                sSC.currentStickman.mRightForeArm.mColor = sSC.currentStickman.mRightForeArm.mColor.darker();
                sSC.currentStickman.mRightWrist.mColor = sSC.currentStickman.mRightWrist.mColor.darker();
                sSC.currentStickman.mRightFinger1.mColor = sSC.currentStickman.mRightFinger1.mColor.darker();
                sSC.currentStickman.mRightFinger2.mColor = sSC.currentStickman.mRightFinger2.mColor.darker();
                sSC.currentStickman.mRightFinger3.mColor = sSC.currentStickman.mRightFinger3.mColor.darker();
                sSC.currentStickman.mRightFinger4.mColor = sSC.currentStickman.mRightFinger4.mColor.darker();
                sSC.currentStickman.mRightUpperLeg.mColor = sSC.currentStickman.mRightUpperLeg.mColor.darker();
                sSC.currentStickman.mRightForeLeg.mColor = sSC.currentStickman.mRightForeLeg.mColor.darker();

                sSC.currentStickman.mNeck.update();
                sSC.currentStickman.mLeftUpperArm.update();
                sSC.currentStickman.mLeftForeArm.update();
                sSC.currentStickman.mLeftWrist.update();
                sSC.currentStickman.mLeftFinger1.update();
                sSC.currentStickman.mLeftFinger2.update();
                sSC.currentStickman.mLeftFinger3.update();
                sSC.currentStickman.mLeftFinger4.update();
                sSC.currentStickman.mLeftUpperLeg.update();
                sSC.currentStickman.mLeftForeLeg.update();

                sSC.currentStickman.mRightUpperArm.update();
                sSC.currentStickman.mRightForeArm.update();
                sSC.currentStickman.mRightWrist.update();
                sSC.currentStickman.mRightFinger1.update();
                sSC.currentStickman.mRightFinger2.update();
                sSC.currentStickman.mRightFinger3.update();
                sSC.currentStickman.mRightFinger4.update();
                sSC.currentStickman.mRightUpperLeg.update();
                sSC.currentStickman.mRightForeLeg.update();
            } else if (ev.getSource().equals(sSC.limbsColorReset))
            {
                sSC.currentStickman.mNeck.mColor = sSC.currentStickman.mNeck.mColorRecorder;
                sSC.currentStickman.mLeftUpperArm.mColor = sSC.currentStickman.mLeftUpperArm.mColorRecorder;
                sSC.currentStickman.mLeftForeArm.mColor = sSC.currentStickman.mLeftForeArm.mColorRecorder;
                sSC.currentStickman.mLeftWrist.mColor = sSC.currentStickman.mLeftWrist.mColorRecorder;
                sSC.currentStickman.mLeftFinger1.mColor = sSC.currentStickman.mLeftFinger1.mColorRecorder;
                sSC.currentStickman.mLeftFinger2.mColor = sSC.currentStickman.mLeftFinger2.mColorRecorder;
                sSC.currentStickman.mLeftFinger3.mColor = sSC.currentStickman.mLeftFinger3.mColorRecorder;
                sSC.currentStickman.mLeftFinger4.mColor = sSC.currentStickman.mLeftFinger4.mColorRecorder;
                sSC.currentStickman.mLeftUpperLeg.mColor = sSC.currentStickman.mLeftUpperLeg.mColorRecorder;
                sSC.currentStickman.mLeftForeLeg.mColor = sSC.currentStickman.mLeftForeLeg.mColorRecorder;

                sSC.currentStickman.mRightUpperArm.mColor = sSC.currentStickman.mRightUpperArm.mColorRecorder;
                sSC.currentStickman.mRightForeArm.mColor = sSC.currentStickman.mRightForeArm.mColorRecorder;
                sSC.currentStickman.mRightWrist.mColor = sSC.currentStickman.mRightWrist.mColorRecorder;
                sSC.currentStickman.mRightFinger1.mColor = sSC.currentStickman.mRightFinger1.mColorRecorder;
                sSC.currentStickman.mRightFinger2.mColor = sSC.currentStickman.mRightFinger2.mColorRecorder;
                sSC.currentStickman.mRightFinger3.mColor = sSC.currentStickman.mRightFinger3.mColorRecorder;
                sSC.currentStickman.mRightFinger4.mColor = sSC.currentStickman.mRightFinger4.mColorRecorder;
                sSC.currentStickman.mRightUpperLeg.mColor = sSC.currentStickman.mRightUpperLeg.mColorRecorder;
                sSC.currentStickman.mRightForeLeg.mColor = sSC.currentStickman.mRightForeLeg.mColorRecorder;

                sSC.limbsOpacitySlider.setValue(1);

                sSC.currentStickman.mNeck.update();
                sSC.currentStickman.mLeftUpperArm.update();
                sSC.currentStickman.mLeftForeArm.update();
                sSC.currentStickman.mLeftWrist.update();
                sSC.currentStickman.mLeftFinger1.update();
                sSC.currentStickman.mLeftFinger2.update();
                sSC.currentStickman.mLeftFinger3.update();
                sSC.currentStickman.mLeftFinger4.update();
                sSC.currentStickman.mLeftUpperLeg.update();
                sSC.currentStickman.mLeftForeLeg.update();

                sSC.currentStickman.mRightUpperArm.update();
                sSC.currentStickman.mRightForeArm.update();
                sSC.currentStickman.mRightWrist.update();
                sSC.currentStickman.mRightFinger1.update();
                sSC.currentStickman.mRightFinger2.update();
                sSC.currentStickman.mRightFinger3.update();
                sSC.currentStickman.mRightFinger4.update();
                sSC.currentStickman.mRightUpperLeg.update();
                sSC.currentStickman.mRightForeLeg.update();
            }
        }
    }

    public static void handleShoesColorButtons(StickmanStageController sSC,
                                               MouseEvent ev)
    {
        if (sSC.currentStickman != null)
        {
            if (ev.getSource().equals(sSC.shoesColorBrighter))
            {
                sSC.currentStickman.mLeftFoot.mColor = sSC.currentStickman.mLeftFoot.mColor.brighter();
                sSC.currentStickman.mRightFoot.mColor = sSC.currentStickman.mRightFoot.mColor.brighter();
                sSC.currentStickman.mLeftFoot.update();
                sSC.currentStickman.mRightFoot.update();
            } else if (ev.getSource().equals(sSC.shoesColorDarker))
            {
                sSC.currentStickman.mLeftFoot.mColor = sSC.currentStickman.mLeftFoot.mColor.darker();
                sSC.currentStickman.mRightFoot.mColor = sSC.currentStickman.mRightFoot.mColor.darker();
                sSC.currentStickman.mLeftFoot.update();
                sSC.currentStickman.mRightFoot.update();
            } else if (ev.getSource().equals(sSC.shoesColorReset))
            {
                sSC.currentStickman.mLeftFoot.mColor = sSC.currentStickman.mLeftFoot.mColorRecorder;
                sSC.currentStickman.mRightFoot.mColor = sSC.currentStickman.mRightFoot.mColorRecorder;
                sSC.shoesOpacitySlider.setValue(1);
                sSC.currentStickman.mLeftFoot.update();
                sSC.currentStickman.mRightFoot.update();
            }
        }
    }

    public static void handleLipsColorButtons(StickmanStageController sSC, MouseEvent ev)
    {
        if (sSC.currentStickman != null)
        {
            if (ev.getSource().equals(sSC.lipsColorBrighter))
            {
                sSC.currentStickman.mMouth.mColor = sSC.currentStickman.mMouth.mColor.brighter();
                sSC.currentStickman.mMouth.update();
            } else if (ev.getSource().equals(sSC.lipsColorDarker))
            {
                sSC.currentStickman.mMouth.mColor = sSC.currentStickman.mMouth.mColor.darker();
                sSC.currentStickman.mMouth.update();
            } else if (ev.getSource().equals(sSC.lipsColorReset))
            {
                sSC.currentStickman.mMouth.mColor = sSC.currentStickman.mMouth.mColorRecorder;
                sSC.lipsOpacitySlider.setValue(1);
                sSC.currentStickman.mMouth.update();
            }
        }
    }

    public static void handleEyeColorButtons(StickmanStageController sSC,
                                             MouseEvent ev)
    {
        if (sSC.currentStickman != null)
        {
            if (ev.getSource().equals(sSC.eyeColorBrighter))
            {
                sSC.currentStickman.mLeftEye.mColor = sSC.currentStickman.mLeftEye.mColor.brighter();
                sSC.currentStickman.mRightEye.mColor = sSC.currentStickman.mRightEye.mColor.brighter();
                sSC.currentStickman.mLeftEye.update();
                sSC.currentStickman.mRightEye.update();
            } else if (ev.getSource().equals(sSC.eyeColorDarker))
            {
                sSC.currentStickman.mLeftEye.mColor = sSC.currentStickman.mLeftEye.mColor.darker();
                sSC.currentStickman.mRightEye.mColor = sSC.currentStickman.mRightEye.mColor.darker();
                sSC.currentStickman.mLeftEye.update();
                sSC.currentStickman.mRightEye.update();
            } else if (ev.getSource().equals(sSC.eyeColorReset))
            {
                sSC.currentStickman.mLeftEye.mColor = sSC.currentStickman.mLeftEye.mColorRecorder;
                sSC.currentStickman.mRightEye.mColor = sSC.currentStickman.mRightEye.mColorRecorder;
                sSC.eyeOpacitySlider.setValue(1);
                sSC.currentStickman.mLeftEye.update();
                sSC.currentStickman.mRightEye.update();
            }
        }
    }

    public static void handleBrowColorButtons(StickmanStageController sSC, MouseEvent ev)
    {
        if (sSC.currentStickman != null)
        {
            if (ev.getSource().equals(sSC.browColorBrighter))
            {
                sSC.currentStickman.mLeftEyebrow.mColor = sSC.currentStickman.mLeftEyebrow.mColor.brighter();
                sSC.currentStickman.mRightEyebrow.mColor = sSC.currentStickman.mRightEyebrow.mColor.brighter();
                sSC.currentStickman.mLeftEyebrow.update();
                sSC.currentStickman.mRightEyebrow.update();
            } else if (ev.getSource().equals(sSC.browColorDarker))
            {
                sSC.currentStickman.mLeftEyebrow.mColor = sSC.currentStickman.mLeftEyebrow.mColor.darker();
                sSC.currentStickman.mRightEyebrow.mColor = sSC.currentStickman.mRightEyebrow.mColor.darker();
                sSC.currentStickman.mLeftEyebrow.update();
                sSC.currentStickman.mRightEyebrow.update();
            } else if (ev.getSource().equals(sSC.browColorReset))
            {
                sSC.currentStickman.mLeftEyebrow.mColor = sSC.currentStickman.mLeftEyebrow.mColorRecorder;
                sSC.currentStickman.mRightEyebrow.mColor = sSC.currentStickman.mRightEyebrow.mColorRecorder;
                sSC.browOpacitySlider.setValue(1);
                sSC.currentStickman.mLeftEyebrow.update();
                sSC.currentStickman.mRightEyebrow.update();
            }
        }
    }

    public static void handleNoseColorButtons(StickmanStageController sSC, MouseEvent ev)
    {
        if (sSC.currentStickman != null)
        {
            if (ev.getSource().equals(sSC.noseColorBrighter))
            {
                sSC.currentStickman.mNose.mColor = sSC.currentStickman.mNose.mColor.brighter();
                sSC.currentStickman.mNose.update();
            } else if (ev.getSource().equals(sSC.noseColorDarker))
            {
                sSC.currentStickman.mNose.mColor = sSC.currentStickman.mNose.mColor.darker();
                sSC.currentStickman.mNose.update();
            } else if (ev.getSource().equals(sSC.noseColorReset))
            {
                sSC.currentStickman.mNose.mColor = sSC.currentStickman.mNose.mColorRecorder;
                sSC.noseOpacitySlider.setValue(1);
                sSC.currentStickman.mNose.update();
            }
        }
    }

    public static void resetAll(Stickman3D currentStickman)
    {
        currentStickman.mHead.mColor = currentStickman.mHead.mColorRecorder;
        currentStickman.mHead.update();

        if (currentStickman.mType == Gender.TYPE.MALE)
        {
            currentStickman.mHair.mColor = currentStickman.mHair.mColorRecorder;
            currentStickman.mHair.update();
        } else
        {
            currentStickman.mHair.mColor = currentStickman.mHair.mColorRecorder;
            currentStickman.mHair.update();
        }
        currentStickman.mUpperBody.mColor = currentStickman.mUpperBody.mColorRecorder;
        currentStickman.mUpperBody.update();
        currentStickman.mNeck.mColor = currentStickman.mNeck.mColorRecorder;
        currentStickman.mLeftUpperArm.mColor = currentStickman.mLeftUpperArm.mColorRecorder;
        currentStickman.mLeftForeArm.mColor = currentStickman.mLeftForeArm.mColorRecorder;
        currentStickman.mLeftWrist.mColor = currentStickman.mLeftWrist.mColorRecorder;
        currentStickman.mLeftFinger1.mColor = currentStickman.mLeftFinger1.mColorRecorder;
        currentStickman.mLeftFinger2.mColor = currentStickman.mLeftFinger2.mColorRecorder;
        currentStickman.mLeftFinger3.mColor = currentStickman.mLeftFinger3.mColorRecorder;
        currentStickman.mLeftFinger4.mColor = currentStickman.mLeftFinger4.mColorRecorder;
        currentStickman.mLeftUpperLeg.mColor = currentStickman.mLeftUpperLeg.mColorRecorder;
        currentStickman.mLeftForeLeg.mColor = currentStickman.mLeftForeLeg.mColorRecorder;
        currentStickman.mRightUpperArm.mColor = currentStickman.mRightUpperArm.mColorRecorder;
        currentStickman.mRightForeArm.mColor = currentStickman.mRightForeArm.mColorRecorder;
        currentStickman.mRightWrist.mColor = currentStickman.mRightWrist.mColorRecorder;
        currentStickman.mRightFinger1.mColor = currentStickman.mRightFinger1.mColorRecorder;
        currentStickman.mRightFinger2.mColor = currentStickman.mRightFinger2.mColorRecorder;
        currentStickman.mRightFinger3.mColor = currentStickman.mRightFinger3.mColorRecorder;
        currentStickman.mRightFinger4.mColor = currentStickman.mRightFinger4.mColorRecorder;
        currentStickman.mRightUpperLeg.mColor = currentStickman.mRightUpperLeg.mColorRecorder;
        currentStickman.mRightForeLeg.mColor = currentStickman.mRightForeLeg.mColorRecorder;
        currentStickman.mNeck.update();
        currentStickman.mLeftUpperArm.update();
        currentStickman.mLeftForeArm.update();
        currentStickman.mLeftWrist.update();
        currentStickman.mLeftFinger1.update();
        currentStickman.mLeftFinger2.update();
        currentStickman.mLeftFinger3.update();
        currentStickman.mLeftFinger4.update();
        currentStickman.mLeftUpperLeg.update();
        currentStickman.mLeftForeLeg.update();
        currentStickman.mRightUpperArm.update();
        currentStickman.mRightForeArm.update();
        currentStickman.mRightWrist.update();
        currentStickman.mRightFinger1.update();
        currentStickman.mRightFinger2.update();
        currentStickman.mRightFinger3.update();
        currentStickman.mRightFinger4.update();
        currentStickman.mRightUpperLeg.update();
        currentStickman.mRightForeLeg.update();
        currentStickman.mLeftFoot.mColor = currentStickman.mLeftFoot.mColorRecorder;
        currentStickman.mRightFoot.mColor = currentStickman.mRightFoot.mColorRecorder;
        currentStickman.mLeftFoot.update();
        currentStickman.mRightFoot.update();
        currentStickman.mMouth.mColor = currentStickman.mMouth.mColorRecorder;
        currentStickman.mMouth.update();
        currentStickman.mLeftEye.mColor = currentStickman.mLeftEye.mColorRecorder;
        currentStickman.mRightEye.mColor = currentStickman.mRightEye.mColorRecorder;
        currentStickman.mLeftEye.update();
        currentStickman.mRightEye.update();
        currentStickman.mLeftEyebrow.mColor = currentStickman.mLeftEyebrow.mColorRecorder;
        currentStickman.mRightEyebrow.mColor = currentStickman.mRightEyebrow.mColorRecorder;
        currentStickman.mLeftEyebrow.update();
        currentStickman.mRightEyebrow.update();
        currentStickman.mNose.mColor = currentStickman.mNose.mColorRecorder;
        currentStickman.mNose.update();
    }
}
