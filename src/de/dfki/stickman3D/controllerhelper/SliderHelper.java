/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.controllerhelper;

import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.StickmanStageController;
import java.awt.Point;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Slider;
import javafx.scene.transform.Rotate;

/**
 *
 * @author EmpaT
 */
public class SliderHelper {

    public static void handleHeadSlider(StickmanStageController controller, Slider slider, String achse) {
        slider.setMin(-180);
        slider.setMax(180);
        slider.setValue(0);
        slider.valueProperty().addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) -> {
            double newValue = new_val.doubleValue();
            if (achse.equalsIgnoreCase("X")) {
                controller.currentStickman.mHeadFX.mXRotation = newValue;
            } else if (achse.equalsIgnoreCase("Y")) {
                controller.currentStickman.mHeadFX.mYRotation = newValue;
            } else {
                controller.currentStickman.mHeadFX.mZRotation = newValue;
            }

            controller.currentStickman.mHeadFX.calculate(0);
        });
    }

    public static void handleDownBodySlider(StickmanStageController controller, Slider slider, String achse) {
        slider.setMin(-180);
        slider.setMax(180);
        slider.setValue(0);
        slider.valueProperty().addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) -> {
            double newValue = new_val.doubleValue();
            if (achse.equalsIgnoreCase("X")) {
                controller.currentStickman.mDownBody.mXRotation = newValue;
            } else if (achse.equalsIgnoreCase("Y")) {
                controller.currentStickman.mDownBody.mYRotation = newValue;
            } else {
                controller.currentStickman.mDownBody.mZRotation = newValue;
            }

            controller.currentStickman.mDownBody.calculate(0);
        });
    }

    public static void handleUpperBodySlider(StickmanStageController controller, Slider slider, String achse) {
        slider.setMin(-180);
        slider.setMax(180);
        slider.setValue(0);
        slider.valueProperty().addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) -> {
            double newValue = new_val.doubleValue();
            if (achse.equalsIgnoreCase("X")) {
                controller.currentStickman.mUpperBodyAndHead.mXRotation = newValue;
                controller.currentStickman.mUpperBodyAndHead.calculate(0);
            } else if (achse.equalsIgnoreCase("Y")) {
                controller.currentStickman.mUpperBody.mYRotation = newValue;
                controller.currentStickman.mUpperBody.calculate(0);
            } else {
                controller.currentStickman.mUpperBodyAndHead.mZRotation = newValue;
                controller.currentStickman.mUpperBodyAndHead.calculate(0);
            }
        });
    }

    public static void handleUpperArmSlider(StickmanStageController controller, Slider slider, String achse, String arm) {
        slider.setMin(-180);
        slider.setMax(180);
        slider.setValue(0);
        slider.valueProperty().addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) -> {
            double newValue = new_val.doubleValue();
            if (achse.equalsIgnoreCase("X")) {
                if (arm.equalsIgnoreCase("L")) {
                    controller.currentStickman.mLeftUpperArmFX.mXRotation = newValue;
                } else {
                    controller.currentStickman.mRightUpperArmFX.mXRotation = newValue;
                }
            } else if (achse.equalsIgnoreCase("Y")) {
                if (arm.equalsIgnoreCase("L")) {
                    controller.currentStickman.mLeftUpperArmFX.mYRotation = newValue;
                } else {
                    controller.currentStickman.mRightUpperArmFX.mYRotation = newValue;
                }
            } else {
                if (arm.equalsIgnoreCase("L")) {
                    controller.currentStickman.mLeftUpperArmFX.mZRotation = newValue;
                } else {
                    controller.currentStickman.mRightUpperArmFX.mZRotation = newValue;
                }
            }
            if (arm.equalsIgnoreCase("L")) {
                controller.currentStickman.mLeftUpperArmFX.calculate(0);
            } else {
                controller.currentStickman.mRightUpperArmFX.calculate(0);
            }
        });
    }

    public static void handleForeArmSlider(StickmanStageController controller, Slider slider, String achse, String arm) {
        slider.setMin(-180);
        slider.setMax(180);
        slider.setValue(0);
        slider.valueProperty().addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) -> {
            double newValue = new_val.doubleValue();
            if (achse.equalsIgnoreCase("X")) {
                if (arm.equalsIgnoreCase("L")) {
                    controller.currentStickman.mLeftForeArmFX.mXRotation = newValue;
                } else {
                    controller.currentStickman.mRightForeArmFX.mXRotation = newValue;
                }
            } else if (achse.equalsIgnoreCase("Y")) {
                if (arm.equalsIgnoreCase("L")) {
                    controller.currentStickman.mLeftForeArmFX.mYRotation = newValue;
                } else {
                    controller.currentStickman.mRightForeArmFX.mYRotation = newValue;
                }
            } else {
                if (arm.equalsIgnoreCase("L")) {
                    controller.currentStickman.mLeftForeArmFX.mZRotation = newValue;
                } else {
                    controller.currentStickman.mRightForeArmFX.mZRotation = newValue;
                }
            }
            if (arm.equalsIgnoreCase("L")) {
                controller.currentStickman.mLeftForeArmFX.calculate(0);
            } else {
                controller.currentStickman.mRightForeArmFX.calculate(0);
            }
        });
    }

    public static void handleWristSlider(StickmanStageController controller, Slider slider, String achse, String arm) {
        slider.setMin(-180);
        slider.setMax(180);
        slider.setValue(0);
        slider.valueProperty().addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) -> {
            double newValue = new_val.doubleValue();
            if (achse.equalsIgnoreCase("X")) {
                if (arm.equalsIgnoreCase("L")) {
                    controller.currentStickman.mLeftWrist.mXRotation = newValue;
                } else {
                    controller.currentStickman.mRightWrist.mXRotation = newValue;
                }
            } else if (achse.equalsIgnoreCase("Y")) {
                if (arm.equalsIgnoreCase("L")) {
                    controller.currentStickman.mLeftWrist.mYRotation = newValue;
                } else {
                    controller.currentStickman.mRightWrist.mYRotation = newValue;
                }
            } else {
                if (arm.equalsIgnoreCase("L")) {
                    controller.currentStickman.mLeftWrist.mZRotation = newValue;
                } else {
                    controller.currentStickman.mRightWrist.mZRotation = newValue;
                }
            }
            if (arm.equalsIgnoreCase("L")) {
                controller.currentStickman.mLeftWrist.calculate(0);
            } else {
                controller.currentStickman.mRightWrist.calculate(0);
            }
        });
    }

    public static void handleFinger1Slider(StickmanStageController controller, Slider slider, String achse, String arm) {
        slider.setMin(-180);
        slider.setMax(180);
        slider.setValue(0);
        slider.valueProperty().addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) -> {
            double newValue = new_val.doubleValue();
            if (achse.equalsIgnoreCase("X")) {
                if (arm.equalsIgnoreCase("L")) {
                    controller.currentStickman.mLeftFinger1.mXRotation = newValue;
                } else {
                    controller.currentStickman.mRightFinger1.mXRotation = newValue;
                }
            } else if (achse.equalsIgnoreCase("Y")) {
                if (arm.equalsIgnoreCase("L")) {
                    controller.currentStickman.mLeftFinger1.mYRotation = newValue;
                } else {
                    controller.currentStickman.mRightFinger1.mYRotation = newValue;
                }
            } else {
                if (arm.equalsIgnoreCase("L")) {
                    controller.currentStickman.mLeftFinger1.mZRotation = newValue;
                } else {
                    controller.currentStickman.mRightFinger1.mZRotation = newValue;
                }
            }
            if (arm.equalsIgnoreCase("L")) {
                controller.currentStickman.mLeftFinger1.calculate(0);
            } else {
                controller.currentStickman.mRightFinger1.calculate(0);
            }
        });
    }

    public static void handleFinger2Slider(StickmanStageController controller, Slider slider, String achse, String arm) {
        slider.setMin(-180);
        slider.setMax(180);
        slider.setValue(0);
        slider.valueProperty().addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) -> {
            double newValue = new_val.doubleValue();
            if (achse.equalsIgnoreCase("X")) {
                if (arm.equalsIgnoreCase("L")) {
                    controller.currentStickman.mLeftFinger2.mXRotation = newValue;
                } else {
                    controller.currentStickman.mRightFinger2.mXRotation = newValue;
                }
            } else if (achse.equalsIgnoreCase("Y")) {
                if (arm.equalsIgnoreCase("L")) {
                    controller.currentStickman.mLeftFinger2.mYRotation = newValue;
                } else {
                    controller.currentStickman.mRightFinger2.mYRotation = newValue;
                }
            } else {
                if (arm.equalsIgnoreCase("L")) {
                    controller.currentStickman.mLeftFinger2.mZRotation = newValue;
                } else {
                    controller.currentStickman.mRightFinger2.mZRotation = newValue;
                }
            }
            if (arm.equalsIgnoreCase("L")) {
                controller.currentStickman.mLeftFinger2.calculate(0);
            } else {
                controller.currentStickman.mRightFinger2.calculate(0);
            }
        });
    }

    public static void handleFinger3Slider(StickmanStageController controller, Slider slider, String achse, String arm) {
        slider.setMin(-180);
        slider.setMax(180);
        slider.setValue(0);
        slider.valueProperty().addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) -> {
            double newValue = new_val.doubleValue();
            if (achse.equalsIgnoreCase("X")) {
                if (arm.equalsIgnoreCase("L")) {
                    controller.currentStickman.mLeftFinger3.mXRotation = newValue;
                } else {
                    controller.currentStickman.mRightFinger3.mXRotation = newValue;
                }
            } else if (achse.equalsIgnoreCase("Y")) {
                if (arm.equalsIgnoreCase("L")) {
                    controller.currentStickman.mLeftFinger3.mYRotation = newValue;
                } else {
                    controller.currentStickman.mRightFinger3.mYRotation = newValue;
                }
            } else {
                if (arm.equalsIgnoreCase("L")) {
                    controller.currentStickman.mLeftFinger3.mZRotation = newValue;
                } else {
                    controller.currentStickman.mRightFinger3.mZRotation = newValue;
                }
            }
            if (arm.equalsIgnoreCase("L")) {
                controller.currentStickman.mLeftFinger3.calculate(0);
            } else {
                controller.currentStickman.mRightFinger3.calculate(0);
            }
        });
    }

    public static void handleFinger4Slider(StickmanStageController controller, Slider slider, String achse, String arm) {
        slider.setMin(-180);
        slider.setMax(180);
        slider.setValue(0);
        slider.valueProperty().addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) -> {
            double newValue = new_val.doubleValue();
            if (achse.equalsIgnoreCase("X")) {
                if (arm.equalsIgnoreCase("L")) {
                    controller.currentStickman.mLeftFinger4.mXRotation = newValue;
                } else {
                    controller.currentStickman.mRightFinger4.mXRotation = newValue;
                }
            } else if (achse.equalsIgnoreCase("Y")) {
                if (arm.equalsIgnoreCase("L")) {
                    controller.currentStickman.mLeftFinger4.mYRotation = newValue;
                } else {
                    controller.currentStickman.mRightFinger4.mYRotation = newValue;
                }
            } else {
                if (arm.equalsIgnoreCase("L")) {
                    controller.currentStickman.mLeftFinger4.mZRotation = newValue;
                } else {
                    controller.currentStickman.mRightFinger4.mZRotation = newValue;
                }
            }
            if (arm.equalsIgnoreCase("L")) {
                controller.currentStickman.mLeftFinger4.calculate(0);
            } else {
                controller.currentStickman.mRightFinger4.calculate(0);
            }
        });
    }

    public static void handleUpperLegSlider(StickmanStageController controller, Slider slider, String achse, String arm) {
        slider.setMin(-180);
        slider.setMax(180);
        slider.setValue(0);
        slider.valueProperty().addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) -> {
            double newValue = new_val.doubleValue();
            if (achse.equalsIgnoreCase("X")) {
                if (arm.equalsIgnoreCase("L")) {
                    controller.currentStickman.mLeftUpperLegFX.mXRotation = newValue;
                } else {
                    controller.currentStickman.mRightUpperLegFX.mXRotation = newValue;
                }
            } else if (achse.equalsIgnoreCase("Y")) {
                if (arm.equalsIgnoreCase("L")) {
                    controller.currentStickman.mLeftUpperLegFX.mYRotation = newValue;
                } else {
                    controller.currentStickman.mRightUpperLegFX.mYRotation = newValue;
                }
            } else {
                if (arm.equalsIgnoreCase("L")) {
                    controller.currentStickman.mLeftUpperLegFX.mZRotation = newValue;
                } else {
                    controller.currentStickman.mRightUpperLegFX.mZRotation = newValue;
                }
            }
            if (arm.equalsIgnoreCase("L")) {
                controller.currentStickman.mLeftUpperLegFX.calculate(0);
            } else {
                controller.currentStickman.mRightUpperLegFX.calculate(0);
            }
        });
    }

    public static void handleForeLegSlider(StickmanStageController controller, Slider slider, String achse, String arm) {
        slider.setMin(-180);
        slider.setMax(180);
        slider.setValue(0);
        slider.valueProperty().addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) -> {
            double newValue = new_val.doubleValue();
            if (achse.equalsIgnoreCase("X")) {
                if (arm.equalsIgnoreCase("L")) {
                    controller.currentStickman.mLeftForeLegFX.mXRotation = newValue;
                } else {
                    controller.currentStickman.mRightForeLegFX.mXRotation = newValue;
                }
            } else if (achse.equalsIgnoreCase("Y")) {
                if (arm.equalsIgnoreCase("L")) {
                    controller.currentStickman.mLeftForeLegFX.mYRotation = newValue;
                } else {
                    controller.currentStickman.mRightForeLegFX.mYRotation = newValue;
                }
            } else {
                if (arm.equalsIgnoreCase("L")) {
                    controller.currentStickman.mLeftForeLegFX.mZRotation = newValue;
                } else {
                    controller.currentStickman.mRightForeLegFX.mZRotation = newValue;
                }
            }
            if (arm.equalsIgnoreCase("L")) {
                controller.currentStickman.mLeftForeLegFX.calculate(0);
            } else {
                controller.currentStickman.mRightForeLegFX.calculate(0);
            }
        });
    }

    public static void handleCameraSlider(StickmanStageController controller, Slider slider, String achse) {
        slider.setMin(-180);
        slider.setMax(180);
        slider.setValue(0);
        slider.valueProperty().addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) -> {

            double newValue = new_val.doubleValue();
            double oldValue = old_val.doubleValue();
            if (achse.equalsIgnoreCase("X")) {
                double xRotateFactor = newValue - oldValue;
                Point pivot = controller.currentStickman.mUpperBody.getUpperBodyPosition();
                Rotate rx = new Rotate(xRotateFactor, pivot.x, pivot.y, 1505, Rotate.X_AXIS);
                controller.getStage3D().getCamera().getTransforms().addAll(rx);
            } else if (achse.equalsIgnoreCase("Y")) {
                double yRotateFactor = newValue - oldValue;
                Point pivot = controller.currentStickman.mUpperBody.getUpperBodyPosition();
                Rotate ry = new Rotate(yRotateFactor, pivot.x, pivot.y, 1505, Rotate.Y_AXIS);
                controller.getStage3D().getCamera().getTransforms().addAll(ry);
            } else {
                double zRotateFactor = newValue - oldValue;
                Point pivot = controller.currentStickman.mUpperBody.getUpperBodyPosition();
                Rotate rz = new Rotate(zRotateFactor, pivot.x, pivot.y, 1505, Rotate.Z_AXIS);
                controller.getStage3D().getCamera().getTransforms().addAll(rz);
            }
        });
    }
}
