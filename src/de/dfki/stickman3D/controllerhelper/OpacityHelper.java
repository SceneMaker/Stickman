package de.dfki.stickman3D.controllerhelper;

import de.dfki.common.enums.Gender;
import de.dfki.stickman3D.StickmanStageController;
import de.dfki.stickman3D.body.Head3D;
import de.dfki.stickman3D.body.LeftEye3D;
import de.dfki.stickman3D.body.Mouth3D;
import de.dfki.stickman3D.body.RightEye3D;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Slider;
import javafx.scene.paint.Color;

public class OpacityHelper
{

    public static void headOpacityChanger(StickmanStageController controller, Slider headOpacitySlider)
    {
        headOpacitySlider.valueProperty().addListener(new ChangeListener<Number>()
        {

            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue)
            {
                if (newValue.doubleValue() <= 0.1)
                {
                    controller.currentStickman.mHead.getMeshView().setVisible(false);
                } else
                {
                    controller.currentStickman.mHead.getMeshView().setVisible(true);
                }
                Color col = controller.currentStickman.mHead.mColor;
                col = new Color(col.getRed(), col.getGreen(), col.getBlue(), newValue.doubleValue());
                controller.currentStickman.mHead.mColor = col;
                ((Head3D) controller.currentStickman.mHead).update();
            }
        });
    }

    public static void hairOpacityChanger(StickmanStageController controller, Slider hairOpacitySlider)
    {
        hairOpacitySlider.valueProperty().addListener(new ChangeListener<Number>()
        {

            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue)
            {
                if (newValue.doubleValue() <= 0.1)
                {
                    if (controller.currentStickman.mType == Gender.TYPE.FEMALE)
                    {
                        controller.currentStickman.mHair.getMeshView().setVisible(false);
                    } else
                    {
                        controller.currentStickman.mHair.getMeshView().setVisible(false);
                    }
                } else
                {
                    if (controller.currentStickman.mType == Gender.TYPE.FEMALE)
                    {
                        controller.currentStickman.mHair.getMeshView().setVisible(true);
                    } else
                    {
                        controller.currentStickman.mHair.getMeshView().setVisible(true);
                    }
                }

                Color col = null;
                if (controller.currentStickman.mType == Gender.TYPE.FEMALE)
                {
                    col = controller.currentStickman.mHair.mColor;
                    col = new Color(col.getRed(), col.getGreen(), col.getBlue(), newValue.doubleValue());
                    controller.currentStickman.mHair.mColor = col;
                    controller.currentStickman.mHair.update();
                } else
                {
                    col = controller.currentStickman.mHair.mColor;
                    col = new Color(col.getRed(), col.getGreen(), col.getBlue(), newValue.doubleValue());
                    controller.currentStickman.mHair.mColor = col;
                    controller.currentStickman.mHair.update();
                }

            }
        });
    }

    public static void bodyOpacityChanger(StickmanStageController controller, Slider bodyOpacitySlider)
    {
        bodyOpacitySlider.valueProperty().addListener(new ChangeListener<Number>()
        {

            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue)
            {
                if (newValue.doubleValue() <= 0.1)
                {
                    controller.currentStickman.mDownBody.getMeshView().setVisible(false);
                    controller.currentStickman.mUpperBody.getMeshView().setVisible(false);
                } else
                {
                    controller.currentStickman.mDownBody.getMeshView().setVisible(true);
                    controller.currentStickman.mUpperBody.getMeshView().setVisible(true);
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

    public static void limbsOpacityChanger(StickmanStageController controller, Slider limbsOpacitySlider)
    {
        limbsOpacitySlider.valueProperty().addListener(new ChangeListener<Number>()
        {

            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue)
            {
                if (newValue.doubleValue() <= 0.1)
                {
                    controller.currentStickman.mNeck.getMeshView().setVisible(false);

                    controller.currentStickman.mLeftUpperLeg.getMeshView().setVisible(false);
                    controller.currentStickman.mLeftForeLeg.getMeshView().setVisible(false);
                    controller.currentStickman.mLeftUpperArm.getMeshView().setVisible(false);
                    controller.currentStickman.mLeftForeArm.getMeshView().setVisible(false);
                    controller.currentStickman.mLeftWrist.getMeshView().setVisible(false);

                    controller.currentStickman.mLeftFinger1.getMeshView().setVisible(false);
                    controller.currentStickman.mLeftFinger2.getMeshView().setVisible(false);
                    controller.currentStickman.mLeftFinger3.getMeshView().setVisible(false);
                    controller.currentStickman.mLeftFinger4.getMeshView().setVisible(false);

                    controller.currentStickman.mRightUpperLeg.getMeshView().setVisible(false);
                    controller.currentStickman.mRightForeLeg.getMeshView().setVisible(false);

                    controller.currentStickman.mRightUpperArm.getMeshView().setVisible(false);
                    controller.currentStickman.mRightForeArm.getMeshView().setVisible(false);
                    controller.currentStickman.mRightWrist.getMeshView().setVisible(false);

                    controller.currentStickman.mRightFinger1.getMeshView().setVisible(false);
                    controller.currentStickman.mRightFinger2.getMeshView().setVisible(false);
                    controller.currentStickman.mRightFinger3.getMeshView().setVisible(false);
                    controller.currentStickman.mRightFinger4.getMeshView().setVisible(false);
                } else
                {
                    controller.currentStickman.mNeck.getMeshView().setVisible(true);

                    controller.currentStickman.mLeftUpperLeg.getMeshView().setVisible(true);
                    controller.currentStickman.mLeftForeLeg.getMeshView().setVisible(true);

                    controller.currentStickman.mLeftUpperArm.getMeshView().setVisible(true);
                    controller.currentStickman.mLeftForeArm.getMeshView().setVisible(true);
                    controller.currentStickman.mLeftWrist.getMeshView().setVisible(true);

                    controller.currentStickman.mLeftFinger1.getMeshView().setVisible(true);
                    controller.currentStickman.mLeftFinger2.getMeshView().setVisible(true);
                    controller.currentStickman.mLeftFinger3.getMeshView().setVisible(true);
                    controller.currentStickman.mLeftFinger4.getMeshView().setVisible(true);

                    controller.currentStickman.mRightUpperLeg.getMeshView().setVisible(true);
                    controller.currentStickman.mRightForeLeg.getMeshView().setVisible(true);

                    controller.currentStickman.mRightUpperArm.getMeshView().setVisible(true);
                    controller.currentStickman.mRightForeArm.getMeshView().setVisible(true);
                    controller.currentStickman.mRightWrist.getMeshView().setVisible(true);

                    controller.currentStickman.mRightFinger1.getMeshView().setVisible(true);
                    controller.currentStickman.mRightFinger2.getMeshView().setVisible(true);
                    controller.currentStickman.mRightFinger3.getMeshView().setVisible(true);
                    controller.currentStickman.mRightFinger4.getMeshView().setVisible(true);
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

    public static void shoesOpacityChanger(StickmanStageController controller, Slider shoesOpacitySlider)
    {
        shoesOpacitySlider.valueProperty().addListener(new ChangeListener<Number>()
        {

            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue)
            {
                if (newValue.doubleValue() <= 0.1)
                {
                    controller.currentStickman.mLeftFoot.getMeshView().setVisible(false);
                    controller.currentStickman.mRightFoot.getMeshView().setVisible(false);
                } else
                {
                    controller.currentStickman.mLeftFoot.getMeshView().setVisible(true);
                    controller.currentStickman.mRightFoot.getMeshView().setVisible(true);
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

    public static void lipsOpacityChanger(StickmanStageController controller, Slider lipsOpacitySlider)
    {
        lipsOpacitySlider.valueProperty().addListener(new ChangeListener<Number>()
        {

            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue)
            {
                Mouth3D mouth3D = (Mouth3D) controller.currentStickman.mMouth;
                if (newValue.doubleValue() <= 0.1)
                {
                    mouth3D.currentDownLipPolygon.setVisible(false);
                    mouth3D.currentUpperLipPolygon.setVisible(false);
                } else
                {
                    mouth3D.currentDownLipPolygon.setVisible(true);
                    mouth3D.currentUpperLipPolygon.setVisible(true);
                }

                Color col = controller.currentStickman.mMouth.mColor;
                col = new Color(col.getRed(), col.getGreen(), col.getBlue(), newValue.doubleValue());

                controller.currentStickman.mMouth.mColor = col;

                controller.currentStickman.mMouth.update();
            }
        });
    }

    public static void eyeOpacityChanger(StickmanStageController controller, Slider eyeOpacitySlider)
    {
        eyeOpacitySlider.valueProperty().addListener(new ChangeListener<Number>()
        {

            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue)
            {
                LeftEye3D leftEye3D = (LeftEye3D) controller.currentStickman.mLeftEye;
                RightEye3D rightEye3D = (RightEye3D) controller.currentStickman.mRightEye;
                if (newValue.doubleValue() <= 0.1)
                {
                    leftEye3D.bigPupile.setVisible(false);
                    leftEye3D.smallPupile.setVisible(false);
                    leftEye3D.border.setVisible(false);

                    rightEye3D.bigPupile.setVisible(false);
                    rightEye3D.smallPupile.setVisible(false);
                    rightEye3D.border.setVisible(false);
                } else
                {
                    leftEye3D.bigPupile.setVisible(true);
                    leftEye3D.smallPupile.setVisible(true);
                    leftEye3D.border.setVisible(true);

                    rightEye3D.bigPupile.setVisible(true);
                    rightEye3D.smallPupile.setVisible(true);
                    rightEye3D.border.setVisible(true);
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

    public static void browOpacityChanger(StickmanStageController controller, Slider browOpacitySlider)
    {
        browOpacitySlider.valueProperty().addListener(new ChangeListener<Number>()
        {

            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue)
            {

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

    public static void noseOpacityChanger(StickmanStageController controller, Slider noseOpacitySlider)
    {
        noseOpacitySlider.valueProperty().addListener(new ChangeListener<Number>()
        {

            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue)
            {
                if (newValue.doubleValue() <= 0.1)
                {
                    controller.currentStickman.mNose.getMeshView().setVisible(false);
                } else
                {
                    controller.currentStickman.mNose.getMeshView().setVisible(true);
                }
                Color col = controller.currentStickman.mNose.mColor;
                col = new Color(col.getRed(), col.getGreen(), col.getBlue(), newValue.doubleValue());

                controller.currentStickman.mNose.mColor = col;
                controller.currentStickman.mNose.update();
            }
        });

    }
}
