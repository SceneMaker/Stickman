/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.reeti.controllerhelper;

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
    private static double headCurrentXPos;
    private static double headCurrentYPos;
    private static double headCurrentZPos;


    public static void handleHeadSlider(ReetiStageController controller, Slider slider, String achse) {
        slider.setMin(0);
        slider.setMax(100);
        slider.setValue(50);
        slider.valueProperty().addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) -> {
            double newValue = new_val.doubleValue();
            if (achse.equalsIgnoreCase("X")) {
                headCurrentXPos = (-(newValue- HEADSTARTPOSITION) * 40) / 100;
                controller.currentReeti.mHead.mXRotation = headCurrentXPos;
                controller.headXRotationField.setText(Integer.toString((int) newValue));
            } else if (achse.equalsIgnoreCase("Y")) {
                headCurrentYPos = -(newValue- HEADSTARTPOSITION);
                controller.currentReeti.mHead.mYRotation = headCurrentYPos;
                controller.headYRotationField.setText(Integer.toString((int) newValue));
            } else {
                headCurrentZPos = ((newValue- HEADSTARTPOSITION) * 40) / 100;
                controller.currentReeti.mHead.mZRotation =  headCurrentZPos;
                controller.headZRotationField.setText(Integer.toString((int) newValue));
            }
            controller.currentReeti.mHead.calculate(0);
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
