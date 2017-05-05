/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.reeti.controllerhelper;

import de.dfki.reeti.Reeti;
import de.dfki.reeti.ReetiStageController;
import java.awt.Point;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Slider;
import javafx.scene.transform.Rotate;

/**
 *
 * @author EmpaT
 */
public class SliderHelper {

    final static int HEADSTARTPOSITION = 50;

    public static void handleHeadSlider(ReetiStageController controller, Slider slider, String achse) {
        slider.setMin(0);
        slider.setMax(100);
        slider.setValue(50);
        slider.valueProperty().addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) -> {
            Reeti reeti = controller.currentReeti;
            double newValue = new_val.doubleValue();
            if (achse.equalsIgnoreCase("X")) {
                controller.currentReeti.mHead.mXRotation = (-(newValue- 50) * 40) / 100;
                controller.headXRotationField.setText(Integer.toString((int) newValue));
            } else if (achse.equalsIgnoreCase("Y")) {
                controller.currentReeti.mHead.mYRotation = -(newValue- 50);
                controller.headYRotationField.setText(Integer.toString((int) newValue));
            } else {
                controller.currentReeti.mHead.mZRotation =  ((newValue- 50) * 40) / 100;
                controller.headZRotationField.setText(Integer.toString((int) newValue));
            }
            controller.currentReeti.mHead.calculate(0);
        });
    }

    public static void handleLeftEyeXSlider(ReetiStageController controller) {
        controller.leftEyeXSlider.setMin(0);
        controller.leftEyeXSlider.setMax(100);
        controller.leftEyeXSlider.setValue(42);
        controller.leftEyeXSlider.valueProperty().addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) -> {
            double newValue = new_val.doubleValue();
            controller.currentReeti.mLeftEye.mXRotation = (-(newValue- 47) * 90) / 100;
            controller.leftEyeXRotationField.setText(Integer.toString((int) newValue));
            controller.currentReeti.mLeftEye.calculate(0);
        });
    }

    public static void handleLeftEyeYSlider(ReetiStageController controller) {
        controller.leftEyeYSlider.setMin(0);
        controller.leftEyeYSlider.setMax(100);
        controller.leftEyeYSlider.setValue(42);
        controller.leftEyeYSlider.valueProperty().addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) -> {
            Reeti reeti = controller.currentReeti;
            double newValue = new_val.doubleValue();
            controller.currentReeti.mLeftEye.mYRotation = (-(newValue- 42) * 90) / 100;
            controller.leftEyeYRotationField.setText(Integer.toString((int) newValue));
            controller.currentReeti.mLeftEye.calculate(0);
        });
    }

    public static void handleRightEyeXSlider(ReetiStageController controller) {
        controller.rightEyeXSlider.setMin(0);
        controller.rightEyeXSlider.setMax(100);
        controller.rightEyeXSlider.setValue(47);
        controller.rightEyeXSlider.valueProperty().addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) -> {
            Reeti reeti = controller.currentReeti;
            double newValue = new_val.doubleValue();
            controller.currentReeti.mRightEye.mXRotation = (-(newValue- 51) * 90) / 100;
            controller.rightEyeXRotationField.setText(Integer.toString((int) newValue));
            controller.currentReeti.mRightEye.calculate(0);
        });
    }

    public static void handleRightEyeYSlider(ReetiStageController controller) {
        controller.rightEyeYSlider.setMin(0);
        controller.rightEyeYSlider.setMax(100);
        controller.rightEyeYSlider.setValue(65);
        controller.rightEyeYSlider.valueProperty().addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) -> {
            Reeti reeti = controller.currentReeti;
            double newValue = new_val.doubleValue();
            controller.currentReeti.mRightEye.mYRotation = (-(newValue- 65) * 90) / 100;
            controller.rightEyeYRotationField.setText(Integer.toString((int) newValue));
            controller.currentReeti.mRightEye.calculate(0);
        });
    }

    public static void handleLeftEyeLidXSlider(ReetiStageController controller) {
        controller.leftEyeLidXSlider.setMin(0);
        controller.leftEyeLidXSlider.setMax(100);
        controller.leftEyeLidXSlider.setValue(100);
        controller.leftEyeLidXSlider.valueProperty().addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) -> {
            Reeti reeti = controller.currentReeti;
            double newValue = new_val.doubleValue();
            controller.currentReeti.mLeftEyelid.mXRotation = (-(newValue- 100));
            controller.leftEyeLidXRotationField.setText(Integer.toString((int) newValue));
            controller.currentReeti.mLeftEyelid.calculate(0);
        });
    }

    public static void handleRightEyeLidXSlider(ReetiStageController controller) {
        controller.rightEyeLidXSlider.setMin(0);
        controller.rightEyeLidXSlider.setMax(100);
        controller.rightEyeLidXSlider.setValue(100);
        controller.rightEyeLidXSlider.valueProperty().addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) -> {
            Reeti reeti = controller.currentReeti;
            double newValue = new_val.doubleValue();
            controller.currentReeti.mRightEyelid.mXRotation = (-(newValue- 100));
            controller.rightEyeLidXRotationField.setText(Integer.toString((int) newValue));
            controller.currentReeti.mRightEyelid.calculate(0);
        });
    }

    public static void handleLeftEarSlider(ReetiStageController controller) {
        controller.leftEarSlider.setMin(0);
        controller.leftEarSlider.setMax(100);
        controller.leftEarSlider.setValue(50);
        controller.leftEarSlider.valueProperty().addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) -> {
            Reeti reeti = controller.currentReeti;
            double newValue = new_val.doubleValue();
            controller.currentReeti.mLeftEar.mZRotation = (-(newValue- 50));
            controller.leftEarRotationField.setText(Integer.toString((int) newValue));
            controller.currentReeti.mLeftEar.calculate(0);
        });
    }

    public static void handleRightEarSlider(ReetiStageController controller) {
        controller.rightEarSlider.setMin(0);
        controller.rightEarSlider.setMax(100);
        controller.rightEarSlider.setValue(50);
        controller.rightEarSlider.valueProperty().addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) -> {
            Reeti reeti = controller.currentReeti;
            double newValue = new_val.doubleValue();
            controller.currentReeti.mRightEar.mZRotation = (-(newValue- 50));
            controller.rightEarRotationField.setText(Integer.toString((int) newValue));
            controller.currentReeti.mRightEar.calculate(0);
        });
    }

    public static void handleLeftLCSlider(ReetiStageController controller) {
        controller.leftLCSlider.setMin(-100);
        controller.leftLCSlider.setMax(0);
        controller.leftLCSlider.setValue(-50);
        controller.leftLCSlider.valueProperty().addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) -> {
            double newValue = Math.abs(new_val.doubleValue());
            controller.currentReeti.mMouthLeftCorner.setShape("LEFTCORNERACTION");
            double SliderValue = (newValue + 170) * 16 / 100;
            controller.currentReeti.mMouthLeftCorner.setLeftCornerRegulator(SliderValue);
            int fieldValue = (int)Math.abs(newValue - 100);
            controller.leftLCRotationField.setText(Integer.toString(fieldValue));
            controller.currentReeti.mMouthLeftCorner.calculate(0);
        });
    }

    public static void handleRightLCSlider(ReetiStageController controller) {
        controller.rightLCSlider.setMin(-100);
        controller.rightLCSlider.setMax(0);
        controller.rightLCSlider.setValue(-50);
        controller.rightLCSlider.valueProperty().addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) -> {
            double newValue = Math.abs(new_val.doubleValue());
            controller.currentReeti.mMouthRightCorner.setShape("RIGHTCORNERACTION");
            double SliderValue = (newValue + 170) * 16 / 100;
            controller.currentReeti.mMouthRightCorner.setRightCornerRegulator(SliderValue);
            int fieldValue = (int)Math.abs(newValue - 100);
            controller.rightLCRotationField.setText(Integer.toString(fieldValue));
            controller.currentReeti.mMouthRightCorner.calculate(0);
        });
    }

    public static void handleTopLipSlider(ReetiStageController controller) {
        controller.topLipSlider.setMin(-100);
        controller.topLipSlider.setMax(0);
        controller.topLipSlider.setValue(-100);
        controller.topLipSlider.valueProperty().addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) -> {
            double newValue = Math.abs(new_val.doubleValue());
            controller.currentReeti.mMouthUpperLip.setShape("UPPERLIPACTION");
            double SliderValue = (newValue + 107) * 16 / 100;
            controller.currentReeti.mMouthUpperLip.setUpperLipRegulator(SliderValue);
            int fieldValue = (int)Math.abs(newValue - 100);
            controller.topLipRotationField.setText(Integer.toString(fieldValue));
            controller.currentReeti.mMouthUpperLip.calculate(0);
        });
    }

    public static void handleBottomLipSlider(ReetiStageController controller) {
        controller.bottomLipSlider.setMin(0);
        controller.bottomLipSlider.setMax(100);
        controller.bottomLipSlider.setValue(0);
        controller.bottomLipSlider.valueProperty().addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) -> {
            double newValue = Math.abs(new_val.doubleValue());
            controller.currentReeti.mMouthDownLip.setShape("DOWNLIPACTION");
            double SliderValue = (newValue + 217) * 16 / 100;
            controller.currentReeti.mMouthDownLip.setDownLipRegulator(SliderValue);
            int fieldValue = (int) (newValue);
            controller.bottomLipRotationField.setText(Integer.toString(fieldValue));
            controller.currentReeti.mMouthDownLip.calculate(0);
        });
    }

    public static void handleCameraSlider(ReetiStageController controller, Slider slider, String achse) {
        slider.setMin(-180);
        slider.setMax(180);
        slider.setValue(0);
        slider.valueProperty().addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) -> {

            double newValue = new_val.doubleValue();
            double oldValue = old_val.doubleValue();
            if (achse.equalsIgnoreCase("X")) {
                double xRotateFactor = newValue - oldValue;
                Point pivot = controller.currentReeti.mBody.getUpperBodyPosition();
                Rotate rx = new Rotate(xRotateFactor, pivot.x, pivot.y, 1505, Rotate.X_AXIS);
                controller.getStage3D().getCamera().getTransforms().addAll(rx);
            } else if (achse.equalsIgnoreCase("Y")) {
                double yRotateFactor = newValue - oldValue;
                Point pivot = controller.currentReeti.mBody.getUpperBodyPosition();
                Rotate ry = new Rotate(yRotateFactor, pivot.x, pivot.y, 1505, Rotate.Y_AXIS);
                controller.getStage3D().getCamera().getTransforms().addAll(ry);
            } else {
                double zRotateFactor = newValue - oldValue;
                Point pivot = controller.currentReeti.mBody.getUpperBodyPosition();
                Rotate rz = new Rotate(zRotateFactor, pivot.x, pivot.y, 1505, Rotate.Z_AXIS);
                controller.getStage3D().getCamera().getTransforms().addAll(rz);
            }
        });
    }
}
