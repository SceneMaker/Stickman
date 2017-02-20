/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.reeti.controllerhelper;

import de.dfki.reeti.dynamic.classes.Helper;
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

    public static void handleHeadSlider(ReetiStageController controller, Slider slider, String achse) {
        slider.setMin(-180);
        slider.setMax(180);
        slider.setValue(0);
        slider.valueProperty().addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) -> {
            double newValue = new_val.doubleValue();
            if (achse.equalsIgnoreCase("X")) {
                controller.currentStickman.mHead.mXRotation = newValue;
                controller.headXRotationField.setText(Integer.toString((int) newValue - Helper.recordHeadSliderXValue));
            } else if (achse.equalsIgnoreCase("Y")) {
                controller.currentStickman.mHead.mYRotation = newValue;
                controller.headYRotationField.setText(Integer.toString((int) newValue - Helper.recordHeadSliderYValue));
            } else {
                controller.currentStickman.mHead.mZRotation = newValue;
                controller.headZRotationField.setText(Integer.toString((int) newValue - Helper.recordHeadSliderZValue));
            }

            controller.currentStickman.mHead.calculate(0);
        });
    }

    public static void handleDownBodySlider(ReetiStageController controller, Slider slider, String achse) {
        slider.setMin(-180);
        slider.setMax(180);
        slider.setValue(0);
        slider.valueProperty().addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) -> {
            double newValue = new_val.doubleValue();
            if (achse.equalsIgnoreCase("X")) {
                controller.downBodyXRotationField.setText(Integer.toString((int) newValue));
            } else if (achse.equalsIgnoreCase("Y")) {
                controller.downBodyYRotationField.setText(Integer.toString((int) newValue));
            } else {
                controller.downBodyZRotationField.setText(Integer.toString((int) newValue));
            }

        });
    }

    public static void handleUpperBodySlider(ReetiStageController controller, Slider slider, String achse) {
        slider.setMin(-180);
        slider.setMax(180);
        slider.setValue(0);
        slider.valueProperty().addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) -> {
            double newValue = new_val.doubleValue();
            if (achse.equalsIgnoreCase("X")) {
                controller.upperBodyXRotationField.setText(Integer.toString((int) newValue - Helper.recordUpperBodySliderXValue));
            } else if (achse.equalsIgnoreCase("Y")) {
                controller.currentStickman.mBody.mYRotation = newValue;
                controller.upperBodyYRotationField.setText(Integer.toString((int) newValue - Helper.recordUpperBodySliderYValue));
                controller.currentStickman.mBody.calculate(0);
            } else {
                controller.upperBodyZRotationField.setText(Integer.toString((int) newValue - Helper.recordUpperBodySliderZValue));
            }
        });
    }

    public static void handleUpperArmSlider(ReetiStageController controller, Slider slider, String achse, String arm, int startDegree) {
        slider.setMin(-180);
        slider.setMax(180);
        slider.setValue(startDegree);
        if (arm.equalsIgnoreCase("L") && achse.equalsIgnoreCase("Z")) {
            controller.leftUpperArmZRotationField.setText("" + startDegree);
        } else if (arm.equalsIgnoreCase("R") && achse.equalsIgnoreCase("Z")) {
            controller.rightUpperArmZRotationField.setText("" + startDegree);
        }

        slider.valueProperty().addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) -> {
            double newValue = new_val.doubleValue();
            if (achse.equalsIgnoreCase("X")) {
                if (arm.equalsIgnoreCase("L")) {
                    controller.leftUpperArmXRotationField.setText(Integer.toString((int) newValue - Helper.recordLeftUpperArmSliderXValue));
                } else {
                    controller.rightUpperArmXRotationField.setText(Integer.toString((int) newValue - Helper.recordRightUpperArmSliderXValue));

                }
            } else if (achse.equalsIgnoreCase("Y")) {
                if (arm.equalsIgnoreCase("L")) {
                    controller.leftUpperArmYRotationField.setText(Integer.toString((int) newValue - Helper.recordLeftUpperArmSliderYValue));
                } else {
                    controller.rightUpperArmYRotationField.setText(Integer.toString((int) newValue - Helper.recordRightUpperArmSliderYValue));
                }
            } else {
                if (arm.equalsIgnoreCase("L")) {
                    controller.leftUpperArmZRotationField.setText(Integer.toString((int) newValue - Helper.recordLeftUpperArmSliderZValue));
                } else {
                    controller.rightUpperArmZRotationField.setText(Integer.toString((int) newValue - Helper.recordRightUpperArmSliderZValue));
                }
            }
            if (arm.equalsIgnoreCase("L")) {
            } else {
            }
        });
    }

    public static void handleForeArmSlider(ReetiStageController controller, Slider slider, String achse, String arm, int startDegree) {
        slider.setMin(-180);
        slider.setMax(180);
        slider.setValue(startDegree);
        if (arm.equalsIgnoreCase("L") && achse.equalsIgnoreCase("X")) {
            controller.leftForeArmXRotationField.setText("" + startDegree);
        } else if (arm.equalsIgnoreCase("L") && achse.equalsIgnoreCase("Z")) {
            controller.leftForeArmZRotationField.setText("" + startDegree);
        } else if (arm.equalsIgnoreCase("R") && achse.equalsIgnoreCase("X")) {
            controller.rightForeArmXRotationField.setText("" + startDegree);
        } else if (arm.equalsIgnoreCase("R") && achse.equalsIgnoreCase("Z")) {
            controller.rightForeArmZRotationField.setText("" + startDegree);
        }

        slider.valueProperty().addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) -> {
            double newValue = new_val.doubleValue();
            if (achse.equalsIgnoreCase("X")) {
                if (arm.equalsIgnoreCase("L")) {
                    controller.leftForeArmXRotationField.setText(Integer.toString((int) newValue - Helper.recordLeftForeArmSliderXValue));
                } else {
                    controller.rightForeArmXRotationField.setText(Integer.toString((int) newValue - Helper.recordRightForeArmSliderXValue));
                }
            } else if (achse.equalsIgnoreCase("Y")) {
                if (arm.equalsIgnoreCase("L")) {
                    controller.leftForeArmYRotationField.setText(Integer.toString((int) newValue - Helper.recordLeftForeArmSliderYValue));
                } else {
                    controller.rightForeArmYRotationField.setText(Integer.toString((int) newValue - Helper.recordRightForeArmSliderYValue));
                }
            } else {
                if (arm.equalsIgnoreCase("L")) {
                    controller.leftForeArmZRotationField.setText(Integer.toString((int) newValue - Helper.recordLeftForeArmSliderZValue));
                } else {
                    controller.rightForeArmZRotationField.setText(Integer.toString((int) newValue - Helper.recordRightForeArmSliderZValue));
                }
            }
            if (arm.equalsIgnoreCase("L")) {
            } else {
            }
        });
    }

    public static void handleWristSlider(ReetiStageController controller, Slider slider, String achse, String arm, int startDegree) {
        slider.setMin(-180);
        slider.setMax(180);
        slider.setValue(startDegree);
        slider.setValue(startDegree);
        if (arm.equalsIgnoreCase("L") && achse.equalsIgnoreCase("Y")) {
            controller.leftWristYRotationField.setText("" + startDegree);
        } else if (arm.equalsIgnoreCase("R") && achse.equalsIgnoreCase("Y")) {
            controller.rightWristYRotationField.setText("" + startDegree);
        }

        slider.valueProperty().addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) -> {
            double newValue = new_val.doubleValue();
            if (achse.equalsIgnoreCase("X")) {
                if (arm.equalsIgnoreCase("L")) {
                    controller.leftWristXRotationField.setText(Integer.toString((int) newValue - Helper.recordLeftWristSliderXValue));
                } else {
                    controller.rightWristXRotationField.setText(Integer.toString((int) newValue - Helper.recordRightWristSliderXValue));
                }
            } else if (achse.equalsIgnoreCase("Y")) {
                if (arm.equalsIgnoreCase("L")) {
                    controller.leftWristYRotationField.setText(Integer.toString((int) newValue - Helper.recordLeftWristSliderYValue));
                } else {
                    controller.rightWristYRotationField.setText(Integer.toString((int) newValue - Helper.recordRightWristSliderYValue));
                }
            } else {
                if (arm.equalsIgnoreCase("L")) {
                    controller.leftWristZRotationField.setText(Integer.toString((int) newValue - Helper.recordLeftWristSliderZValue));
                } else {
                    controller.rightWristZRotationField.setText(Integer.toString((int) newValue - Helper.recordRightWristSliderZValue));
                }
            }
            if (arm.equalsIgnoreCase("L")) {
            } else {
            }
        });
    }

    public static void handleFinger1Slider(ReetiStageController controller, Slider slider, String achse, String arm, int startDegree) {
        slider.setMin(-180);
        slider.setMax(180);
        slider.setValue(startDegree);
        if (arm.equalsIgnoreCase("L") && achse.equalsIgnoreCase("Z")) {
            controller.leftFinger1ZRotationField.setText("" + startDegree);
        } else if (arm.equalsIgnoreCase("R") && achse.equalsIgnoreCase("Z")) {
            controller.rightFinger1ZRotationField.setText("" + (startDegree));
        }

        slider.valueProperty().addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) -> {
            double newValue = new_val.doubleValue();
            if (achse.equalsIgnoreCase("X")) {
                if (arm.equalsIgnoreCase("L")) {
                    controller.leftFinger1XRotationField.setText(Integer.toString((int) newValue - Helper.recordLeftFinger1SliderXValue));
                } else {
                    controller.rightFinger1XRotationField.setText(Integer.toString((int) newValue - Helper.recordRightFinger1SliderXValue));
                }
            } else if (achse.equalsIgnoreCase("Y")) {
                if (arm.equalsIgnoreCase("L")) {
                    controller.leftFinger1YRotationField.setText(Integer.toString((int) newValue - Helper.recordLeftFinger1SliderYValue));
                } else {
                    controller.rightFinger1YRotationField.setText(Integer.toString((int) newValue - Helper.recordRightFinger1SliderYValue));
                }
            } else {
                if (arm.equalsIgnoreCase("L")) {
                    controller.leftFinger1ZRotationField.setText(Integer.toString((int) newValue - Helper.recordLeftFinger1SliderZValue));
                } else {
                    controller.rightFinger1ZRotationField.setText(Integer.toString((int) newValue - Helper.recordRightFinger1SliderZValue));
                }
            }
            if (arm.equalsIgnoreCase("L")) {
            } else {
            }
        });
    }

    public static void handleFinger2Slider(ReetiStageController controller, Slider slider, String achse, String arm) {
        slider.setMin(-180);
        slider.setMax(180);
        slider.setValue(0);
        slider.valueProperty().addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) -> {
            double newValue = new_val.doubleValue();
            if (achse.equalsIgnoreCase("X")) {
                if (arm.equalsIgnoreCase("L")) {
                    controller.leftFinger2XRotationField.setText(Integer.toString((int) newValue - Helper.recordLeftFinger2SliderXValue));
                } else {
                    controller.rightFinger2XRotationField.setText(Integer.toString((int) newValue - Helper.recordRightFinger2SliderXValue));
                }
            } else if (achse.equalsIgnoreCase("Y")) {
                if (arm.equalsIgnoreCase("L")) {
                    controller.leftFinger2YRotationField.setText(Integer.toString((int) newValue - Helper.recordLeftFinger2SliderYValue));
                } else {
                    controller.rightFinger2YRotationField.setText(Integer.toString((int) newValue - Helper.recordRightFinger2SliderYValue));
                }
            } else {
                if (arm.equalsIgnoreCase("L")) {
                    controller.leftFinger2ZRotationField.setText(Integer.toString((int) newValue - Helper.recordLeftFinger2SliderZValue));
                } else {
                    controller.rightFinger2ZRotationField.setText(Integer.toString((int) newValue - Helper.recordRightFinger2SliderZValue));
                }
            }
            if (arm.equalsIgnoreCase("L")) {
            } else {
            }
        });
    }

    public static void handleFinger3Slider(ReetiStageController controller, Slider slider, String achse, String arm) {
        slider.setMin(-180);
        slider.setMax(180);
        slider.setValue(0);
        slider.valueProperty().addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) -> {
            double newValue = new_val.doubleValue();
            if (achse.equalsIgnoreCase("X")) {
                if (arm.equalsIgnoreCase("L")) {
                    controller.leftFinger3XRotationField.setText(Integer.toString((int) newValue - Helper.recordLeftFinger3SliderXValue));
                } else {
                    controller.rightFinger3XRotationField.setText(Integer.toString((int) newValue - Helper.recordRightFinger3SliderXValue));
                }
            } else if (achse.equalsIgnoreCase("Y")) {
                if (arm.equalsIgnoreCase("L")) {
                    controller.leftFinger3YRotationField.setText(Integer.toString((int) newValue - Helper.recordLeftFinger3SliderYValue));
                } else {
                    controller.rightFinger3YRotationField.setText(Integer.toString((int) newValue - Helper.recordRightFinger3SliderYValue));
                }
            } else {
                if (arm.equalsIgnoreCase("L")) {
                    controller.leftFinger3ZRotationField.setText(Integer.toString((int) newValue - Helper.recordLeftFinger3SliderZValue));
                } else {
                    controller.rightFinger3ZRotationField.setText(Integer.toString((int) newValue - Helper.recordRightFinger3SliderZValue));
                }
            }
            if (arm.equalsIgnoreCase("L")) {
            } else {
            }
        });
    }

    public static void handleFinger4Slider(ReetiStageController controller, Slider slider, String achse, String arm) {
        slider.setMin(-180);
        slider.setMax(180);
        slider.setValue(0);
        slider.valueProperty().addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) -> {
            double newValue = new_val.doubleValue();
            if (achse.equalsIgnoreCase("X")) {
                if (arm.equalsIgnoreCase("L")) {
                    controller.leftFinger1XRotationField.setText(Integer.toString((int) newValue - Helper.recordLeftFinger4SliderXValue));
                } else {
                    controller.rightFinger1XRotationField.setText(Integer.toString((int) newValue - Helper.recordRightFinger4SliderXValue));
                }
            } else if (achse.equalsIgnoreCase("Y")) {
                if (arm.equalsIgnoreCase("L")) {
                    controller.leftFinger4YRotationField.setText(Integer.toString((int) newValue - Helper.recordLeftFinger4SliderYValue));
                } else {
                    controller.rightFinger4YRotationField.setText(Integer.toString((int) newValue - Helper.recordRightFinger4SliderYValue));
                }
            } else {
                if (arm.equalsIgnoreCase("L")) {
                    controller.leftFinger4ZRotationField.setText(Integer.toString((int) newValue - Helper.recordLeftFinger4SliderZValue));
                } else {
                    controller.rightFinger4ZRotationField.setText(Integer.toString((int) newValue - Helper.recordRightFinger4SliderZValue));
                }
            }
            if (arm.equalsIgnoreCase("L")) {
            } else {
            }
        });
    }

    public static void handleUpperLegSlider(ReetiStageController controller, Slider slider, String achse, String arm) {
        slider.setMin(-180);
        slider.setMax(180);
        slider.setValue(0);
        slider.valueProperty().addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) -> {
            double newValue = new_val.doubleValue();
            if (achse.equalsIgnoreCase("X")) {
                if (arm.equalsIgnoreCase("L")) {
                    controller.leftUpperLegXRotationField.setText(Integer.toString((int) newValue - Helper.recordLeftUpperLegSliderXValue));
                } else {
                    controller.rightUpperLegXRotationField.setText(Integer.toString((int) newValue - Helper.recordRightUpperLegSliderXValue));
                }
            } else if (achse.equalsIgnoreCase("Y")) {
                if (arm.equalsIgnoreCase("L")) {
                    controller.leftUpperLegYRotationField.setText(Integer.toString((int) newValue - Helper.recordLeftUpperLegSliderYValue));
                } else {
                    controller.rightUpperLegYRotationField.setText(Integer.toString((int) newValue - Helper.recordRightUpperLegSliderYValue));
                }
            } else {
                if (arm.equalsIgnoreCase("L")) {
                    controller.leftUpperLegZRotationField.setText(Integer.toString((int) newValue - Helper.recordLeftUpperLegSliderZValue));
                } else {
                    controller.rightUpperLegZRotationField.setText(Integer.toString((int) newValue - Helper.recordRightUpperLegSliderZValue));
                }
            }
            if (arm.equalsIgnoreCase("L")) {
            } else {
            }
        });
    }

    public static void handleForeLegSlider(ReetiStageController controller, Slider slider, String achse, String arm) {
        slider.setMin(-180);
        slider.setMax(180);
        slider.setValue(0);
        slider.valueProperty().addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) -> {
            double newValue = new_val.doubleValue();
            if (achse.equalsIgnoreCase("X")) {
                if (arm.equalsIgnoreCase("L")) {
                    controller.leftForeLegXRotationField.setText(Integer.toString((int) newValue - Helper.recordLeftForeLegSliderXValue));
                } else {
                    controller.rightForeLegXRotationField.setText(Integer.toString((int) newValue - Helper.recordRightForeLegSliderXValue));
                }
            } else if (achse.equalsIgnoreCase("Y")) {
                if (arm.equalsIgnoreCase("L")) {
                    controller.leftForeLegYRotationField.setText(Integer.toString((int) newValue - Helper.recordLeftForeLegSliderYValue));
                } else {
                    controller.rightForeLegYRotationField.setText(Integer.toString((int) newValue - Helper.recordRightForeLegSliderYValue));
                }
            } else {
                if (arm.equalsIgnoreCase("L")) {
                    controller.leftForeLegZRotationField.setText(Integer.toString((int) newValue - Helper.recordLeftForeLegSliderZValue));
                } else {
                    controller.rightForeLegZRotationField.setText(Integer.toString((int) newValue - Helper.recordRightForeLegSliderZValue));
                }
            }
            if (arm.equalsIgnoreCase("L")) {
            } else {
            }
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
                Point pivot = controller.currentStickman.mBody.getUpperBodyPosition();
                Rotate rx = new Rotate(xRotateFactor, pivot.x, pivot.y, 1505, Rotate.X_AXIS);
                controller.getStage3D().getCamera().getTransforms().addAll(rx);
            } else if (achse.equalsIgnoreCase("Y")) {
                double yRotateFactor = newValue - oldValue;
                Point pivot = controller.currentStickman.mBody.getUpperBodyPosition();
                Rotate ry = new Rotate(yRotateFactor, pivot.x, pivot.y, 1505, Rotate.Y_AXIS);
                controller.getStage3D().getCamera().getTransforms().addAll(ry);
            } else {
                double zRotateFactor = newValue - oldValue;
                Point pivot = controller.currentStickman.mBody.getUpperBodyPosition();
                Rotate rz = new Rotate(zRotateFactor, pivot.x, pivot.y, 1505, Rotate.Z_AXIS);
                controller.getStage3D().getCamera().getTransforms().addAll(rz);
            }
        });
    }
}
