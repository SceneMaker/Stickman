/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.controllerhelper;

import de.dfki.stickman3D.dynamic.classes.Helper;
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

    public static void handleDownBodySlider(StickmanStageController controller, Slider slider, String achse) {
        slider.setMin(-180);
        slider.setMax(180);
        slider.setValue(0);
        slider.valueProperty().addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) -> {
            double newValue = new_val.doubleValue();
            if (achse.equalsIgnoreCase("X")) {
                controller.currentStickman.mDownBody.mXRotation = newValue;
                controller.downBodyXRotationField.setText(Integer.toString((int) newValue));
            } else if (achse.equalsIgnoreCase("Y")) {
                controller.currentStickman.mDownBody.mYRotation = newValue;
                controller.downBodyYRotationField.setText(Integer.toString((int) newValue));
            } else {
                controller.currentStickman.mDownBody.mZRotation = newValue;
                controller.downBodyZRotationField.setText(Integer.toString((int) newValue));
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
                controller.upperBodyXRotationField.setText(Integer.toString((int) newValue - Helper.recordUpperBodySliderXValue));
                controller.currentStickman.mUpperBodyAndHead.calculate(0);
            } else if (achse.equalsIgnoreCase("Y")) {
                controller.currentStickman.mUpperBody.mYRotation = newValue;
                controller.upperBodyYRotationField.setText(Integer.toString((int) newValue - Helper.recordUpperBodySliderYValue));
                controller.currentStickman.mUpperBody.calculate(0);
            } else {
                controller.currentStickman.mUpperBodyAndHead.mZRotation = newValue;
                controller.upperBodyZRotationField.setText(Integer.toString((int) newValue - Helper.recordUpperBodySliderZValue));
                controller.currentStickman.mUpperBodyAndHead.calculate(0);
            }
        });
    }

    public static void handleUpperArmSlider(StickmanStageController controller, Slider slider, String achse, String arm, int startDegree) {
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
                    controller.currentStickman.mLeftUpperArm.mXRotation = newValue;
                    controller.leftUpperArmXRotationField.setText(Integer.toString((int) newValue - Helper.recordLeftUpperArmSliderXValue));
                } else {
                    controller.currentStickman.mRightUpperArm.mXRotation = newValue;
                    controller.rightUpperArmXRotationField.setText(Integer.toString((int) newValue - Helper.recordRightUpperArmSliderXValue));

                }
            } else if (achse.equalsIgnoreCase("Y")) {
                if (arm.equalsIgnoreCase("L")) {
                    controller.currentStickman.mLeftUpperArm.mYRotation = newValue;
                    controller.leftUpperArmYRotationField.setText(Integer.toString((int) newValue - Helper.recordLeftUpperArmSliderYValue));
                } else {
                    controller.currentStickman.mRightUpperArm.mYRotation = newValue;
                    controller.rightUpperArmYRotationField.setText(Integer.toString((int) newValue - Helper.recordRightUpperArmSliderYValue));
                }
            } else {
                if (arm.equalsIgnoreCase("L")) {
                    controller.currentStickman.mLeftUpperArm.mZRotation = newValue;
                    controller.leftUpperArmZRotationField.setText(Integer.toString((int) newValue - Helper.recordLeftUpperArmSliderZValue));
                } else {
                    controller.currentStickman.mRightUpperArm.mZRotation = newValue;
                    controller.rightUpperArmZRotationField.setText(Integer.toString((int) newValue - Helper.recordRightUpperArmSliderZValue));
                }
            }
            if (arm.equalsIgnoreCase("L")) {
                controller.currentStickman.mLeftUpperArm.calculate(0);
            } else {
                controller.currentStickman.mRightUpperArm.calculate(0);
            }
        });
    }

    public static void handleForeArmSlider(StickmanStageController controller, Slider slider, String achse, String arm, int startDegree) {
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
                    controller.currentStickman.mLeftForeArm.mXRotation = newValue;
                    controller.leftForeArmXRotationField.setText(Integer.toString((int) newValue - Helper.recordLeftForeArmSliderXValue));
                } else {
                    controller.currentStickman.mRightForeArm.mXRotation = newValue;
                    controller.rightForeArmXRotationField.setText(Integer.toString((int) newValue - Helper.recordRightForeArmSliderXValue));
                }
            } else if (achse.equalsIgnoreCase("Y")) {
                if (arm.equalsIgnoreCase("L")) {
                    controller.currentStickman.mLeftForeArm.mYRotation = newValue;
                    controller.leftForeArmYRotationField.setText(Integer.toString((int) newValue - Helper.recordLeftForeArmSliderYValue));
                } else {
                    controller.currentStickman.mRightForeArm.mYRotation = newValue;
                    controller.rightForeArmYRotationField.setText(Integer.toString((int) newValue - Helper.recordRightForeArmSliderYValue));
                }
            } else {
                if (arm.equalsIgnoreCase("L")) {
                    controller.currentStickman.mLeftForeArm.mZRotation = newValue;
                    controller.leftForeArmZRotationField.setText(Integer.toString((int) newValue - Helper.recordLeftForeArmSliderZValue));
                } else {
                    controller.currentStickman.mRightForeArm.mZRotation = newValue;
                    controller.rightForeArmZRotationField.setText(Integer.toString((int) newValue - Helper.recordRightForeArmSliderZValue));
                }
            }
            if (arm.equalsIgnoreCase("L")) {
                controller.currentStickman.mLeftForeArm.calculate(0);
            } else {
                controller.currentStickman.mRightForeArm.calculate(0);
            }
        });
    }

    public static void handleWristSlider(StickmanStageController controller, Slider slider, String achse, String arm, int startDegree) {
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
                    controller.currentStickman.mLeftWrist.mXRotation = newValue;
                    controller.leftWristXRotationField.setText(Integer.toString((int) newValue - Helper.recordLeftWristSliderXValue));
                } else {
                    controller.currentStickman.mRightWrist.mXRotation = newValue;
                    controller.rightWristXRotationField.setText(Integer.toString((int) newValue - Helper.recordRightWristSliderXValue));
                }
            } else if (achse.equalsIgnoreCase("Y")) {
                if (arm.equalsIgnoreCase("L")) {
                    controller.currentStickman.mLeftWrist.mYRotation = newValue;
                    controller.leftWristYRotationField.setText(Integer.toString((int) newValue - Helper.recordLeftWristSliderYValue));
                } else {
                    controller.currentStickman.mRightWrist.mYRotation = newValue;
                    controller.rightWristYRotationField.setText(Integer.toString((int) newValue - Helper.recordRightWristSliderYValue));
                }
            } else {
                if (arm.equalsIgnoreCase("L")) {
                    controller.currentStickman.mLeftWrist.mZRotation = newValue;
                    controller.leftWristZRotationField.setText(Integer.toString((int) newValue - Helper.recordLeftWristSliderZValue));
                } else {
                    controller.currentStickman.mRightWrist.mZRotation = newValue;
                    controller.rightWristZRotationField.setText(Integer.toString((int) newValue - Helper.recordRightWristSliderZValue));
                }
            }
            if (arm.equalsIgnoreCase("L")) {
                controller.currentStickman.mLeftWrist.calculate(0);
            } else {
                controller.currentStickman.mRightWrist.calculate(0);
            }
        });
    }

    public static void handleFinger1Slider(StickmanStageController controller, Slider slider, String achse, String arm, int startDegree) {
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
                    controller.currentStickman.mLeftFinger1.mXRotation = newValue;
                    controller.leftFinger1XRotationField.setText(Integer.toString((int) newValue - Helper.recordLeftFinger1SliderXValue));
                } else {
                    controller.currentStickman.mRightFinger1.mXRotation = newValue;
                    controller.rightFinger1XRotationField.setText(Integer.toString((int) newValue - Helper.recordRightFinger1SliderXValue));
                }
            } else if (achse.equalsIgnoreCase("Y")) {
                if (arm.equalsIgnoreCase("L")) {
                    controller.currentStickman.mLeftFinger1.mYRotation = newValue;
                    controller.leftFinger1YRotationField.setText(Integer.toString((int) newValue - Helper.recordLeftFinger1SliderYValue));
                } else {
                    controller.currentStickman.mRightFinger1.mYRotation = newValue;
                    controller.rightFinger1YRotationField.setText(Integer.toString((int) newValue - Helper.recordRightFinger1SliderYValue));
                }
            } else {
                if (arm.equalsIgnoreCase("L")) {
                    controller.currentStickman.mLeftFinger1.mZRotation = newValue;
                    controller.leftFinger1ZRotationField.setText(Integer.toString((int) newValue - Helper.recordLeftFinger1SliderZValue));
                } else {
                    controller.currentStickman.mRightFinger1.mZRotation = newValue;
                    controller.rightFinger1ZRotationField.setText(Integer.toString((int) newValue - Helper.recordRightFinger1SliderZValue));
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
                    controller.leftFinger2XRotationField.setText(Integer.toString((int) newValue - Helper.recordLeftFinger2SliderXValue));
                } else {
                    controller.currentStickman.mRightFinger2.mXRotation = newValue;
                    controller.rightFinger2XRotationField.setText(Integer.toString((int) newValue - Helper.recordRightFinger2SliderXValue));
                }
            } else if (achse.equalsIgnoreCase("Y")) {
                if (arm.equalsIgnoreCase("L")) {
                    controller.currentStickman.mLeftFinger2.mYRotation = newValue;
                    controller.leftFinger2YRotationField.setText(Integer.toString((int) newValue - Helper.recordLeftFinger2SliderYValue));
                } else {
                    controller.currentStickman.mRightFinger2.mYRotation = newValue;
                    controller.rightFinger2YRotationField.setText(Integer.toString((int) newValue - Helper.recordRightFinger2SliderYValue));
                }
            } else {
                if (arm.equalsIgnoreCase("L")) {
                    controller.currentStickman.mLeftFinger2.mZRotation = newValue;
                    controller.leftFinger2ZRotationField.setText(Integer.toString((int) newValue - Helper.recordLeftFinger2SliderZValue));
                } else {
                    controller.currentStickman.mRightFinger2.mZRotation = newValue;
                    controller.rightFinger2ZRotationField.setText(Integer.toString((int) newValue - Helper.recordRightFinger2SliderZValue));
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
                    controller.leftFinger3XRotationField.setText(Integer.toString((int) newValue - Helper.recordLeftFinger3SliderXValue));
                } else {
                    controller.currentStickman.mRightFinger3.mXRotation = newValue;
                    controller.rightFinger3XRotationField.setText(Integer.toString((int) newValue - Helper.recordRightFinger3SliderXValue));
                }
            } else if (achse.equalsIgnoreCase("Y")) {
                if (arm.equalsIgnoreCase("L")) {
                    controller.currentStickman.mLeftFinger3.mYRotation = newValue;
                    controller.leftFinger3YRotationField.setText(Integer.toString((int) newValue - Helper.recordLeftFinger3SliderYValue));
                } else {
                    controller.currentStickman.mRightFinger3.mYRotation = newValue;
                    controller.rightFinger3YRotationField.setText(Integer.toString((int) newValue - Helper.recordRightFinger3SliderYValue));
                }
            } else {
                if (arm.equalsIgnoreCase("L")) {
                    controller.currentStickman.mLeftFinger3.mZRotation = newValue;
                    controller.leftFinger3ZRotationField.setText(Integer.toString((int) newValue - Helper.recordLeftFinger3SliderZValue));
                } else {
                    controller.currentStickman.mRightFinger3.mZRotation = newValue;
                    controller.rightFinger3ZRotationField.setText(Integer.toString((int) newValue - Helper.recordRightFinger3SliderZValue));
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
                    controller.leftFinger1XRotationField.setText(Integer.toString((int) newValue - Helper.recordLeftFinger4SliderXValue));
                } else {
                    controller.currentStickman.mRightFinger4.mXRotation = newValue;
                    controller.rightFinger1XRotationField.setText(Integer.toString((int) newValue - Helper.recordRightFinger4SliderXValue));
                }
            } else if (achse.equalsIgnoreCase("Y")) {
                if (arm.equalsIgnoreCase("L")) {
                    controller.currentStickman.mLeftFinger4.mYRotation = newValue;
                    controller.leftFinger4YRotationField.setText(Integer.toString((int) newValue - Helper.recordLeftFinger4SliderYValue));
                } else {
                    controller.currentStickman.mRightFinger4.mYRotation = newValue;
                    controller.rightFinger4YRotationField.setText(Integer.toString((int) newValue - Helper.recordRightFinger4SliderYValue));
                }
            } else {
                if (arm.equalsIgnoreCase("L")) {
                    controller.currentStickman.mLeftFinger4.mZRotation = newValue;
                    controller.leftFinger4ZRotationField.setText(Integer.toString((int) newValue - Helper.recordLeftFinger4SliderZValue));
                } else {
                    controller.currentStickman.mRightFinger4.mZRotation = newValue;
                    controller.rightFinger4ZRotationField.setText(Integer.toString((int) newValue - Helper.recordRightFinger4SliderZValue));
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
                    controller.currentStickman.mLeftUpperLeg.mXRotation = newValue;
                    controller.leftUpperLegXRotationField.setText(Integer.toString((int) newValue - Helper.recordLeftUpperLegSliderXValue));
                } else {
                    controller.currentStickman.mRightUpperLeg.mXRotation = newValue;
                    controller.rightUpperLegXRotationField.setText(Integer.toString((int) newValue - Helper.recordRightUpperLegSliderXValue));
                }
            } else if (achse.equalsIgnoreCase("Y")) {
                if (arm.equalsIgnoreCase("L")) {
                    controller.currentStickman.mLeftUpperLeg.mYRotation = newValue;
                    controller.leftUpperLegYRotationField.setText(Integer.toString((int) newValue - Helper.recordLeftUpperLegSliderYValue));
                } else {
                    controller.currentStickman.mRightUpperLeg.mYRotation = newValue;
                    controller.rightUpperLegYRotationField.setText(Integer.toString((int) newValue - Helper.recordRightUpperLegSliderYValue));
                }
            } else {
                if (arm.equalsIgnoreCase("L")) {
                    controller.currentStickman.mLeftUpperLeg.mZRotation = newValue;
                    controller.leftUpperLegZRotationField.setText(Integer.toString((int) newValue - Helper.recordLeftUpperLegSliderZValue));
                } else {
                    controller.currentStickman.mRightUpperLeg.mZRotation = newValue;
                    controller.rightUpperLegZRotationField.setText(Integer.toString((int) newValue - Helper.recordRightUpperLegSliderZValue));
                }
            }
            if (arm.equalsIgnoreCase("L")) {
                controller.currentStickman.mLeftUpperLeg.calculate(0);
            } else {
                controller.currentStickman.mRightUpperLeg.calculate(0);
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
                    controller.currentStickman.mLeftForeLeg.mXRotation = newValue;
                    controller.leftForeLegXRotationField.setText(Integer.toString((int) newValue - Helper.recordLeftForeLegSliderXValue));
                } else {
                    controller.currentStickman.mRightForeLeg.mXRotation = newValue;
                    controller.rightForeLegXRotationField.setText(Integer.toString((int) newValue - Helper.recordRightForeLegSliderXValue));
                }
            } else if (achse.equalsIgnoreCase("Y")) {
                if (arm.equalsIgnoreCase("L")) {
                    controller.currentStickman.mLeftForeLeg.mYRotation = newValue;
                    controller.leftForeLegYRotationField.setText(Integer.toString((int) newValue - Helper.recordLeftForeLegSliderYValue));
                } else {
                    controller.currentStickman.mRightForeLeg.mYRotation = newValue;
                    controller.rightForeLegYRotationField.setText(Integer.toString((int) newValue - Helper.recordRightForeLegSliderYValue));
                }
            } else {
                if (arm.equalsIgnoreCase("L")) {
                    controller.currentStickman.mLeftForeLeg.mZRotation = newValue;
                    controller.leftForeLegZRotationField.setText(Integer.toString((int) newValue - Helper.recordLeftForeLegSliderZValue));
                } else {
                    controller.currentStickman.mRightForeLeg.mZRotation = newValue;
                    controller.rightForeLegZRotationField.setText(Integer.toString((int) newValue - Helper.recordRightForeLegSliderZValue));
                }
            }
            if (arm.equalsIgnoreCase("L")) {
                controller.currentStickman.mLeftForeLeg.calculate(0);
            } else {
                controller.currentStickman.mRightForeLeg.calculate(0);
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
