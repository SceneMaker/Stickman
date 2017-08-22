/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.dynamic.classes;

import de.dfki.common.part.Part3D;
import de.dfki.stickman3D.StickmanStageController;
import de.dfki.stickman3D.body.PartStickman3D;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author EmpaT
 */
public class Helper
{
    public static int recordHeadSliderXValue = 0;
    public static int recordHeadSliderYValue = 0;
    public static int recordHeadSliderZValue = 0;
    public static int recordUpperBodySliderXValue = 0;
    public static int recordUpperBodySliderYValue = 0;
    public static int recordUpperBodySliderZValue = 0;
    public static int recordLeftUpperArmSliderXValue = 0;
    public static int recordLeftUpperArmSliderYValue = 0;
    public static int recordLeftUpperArmSliderZValue = 0;
    public static int recordLeftForeArmSliderXValue = 0;
    public static int recordLeftForeArmSliderYValue = 0;
    public static int recordLeftForeArmSliderZValue = 0;
    public static int recordLeftWristSliderXValue = 0;
    public static int recordLeftWristSliderYValue = 0;
    public static int recordLeftWristSliderZValue = 0;
    public static int recordLeftFinger1SliderXValue = 0;
    public static int recordLeftFinger1SliderYValue = 0;
    public static int recordLeftFinger1SliderZValue = 0;
    public static int recordLeftFinger2SliderXValue = 0;
    public static int recordLeftFinger2SliderYValue = 0;
    public static int recordLeftFinger2SliderZValue = 0;
    public static int recordLeftFinger3SliderXValue = 0;
    public static int recordLeftFinger3SliderYValue = 0;
    public static int recordLeftFinger3SliderZValue = 0;
    public static int recordLeftFinger4SliderXValue = 0;
    public static int recordLeftFinger4SliderYValue = 0;
    public static int recordLeftFinger4SliderZValue = 0;
    public static int recordRightUpperArmSliderXValue = 0;
    public static int recordRightUpperArmSliderYValue = 0;
    public static int recordRightUpperArmSliderZValue = 0;
    public static int recordRightForeArmSliderXValue = 0;
    public static int recordRightForeArmSliderYValue = 0;
    public static int recordRightForeArmSliderZValue = 0;
    public static int recordRightWristSliderXValue = 0;
    public static int recordRightWristSliderYValue = 0;
    public static int recordRightWristSliderZValue = 0;
    public static int recordRightFinger1SliderXValue = 0;
    public static int recordRightFinger1SliderYValue = 0;
    public static int recordRightFinger1SliderZValue = 0;
    public static int recordRightFinger2SliderXValue = 0;
    public static int recordRightFinger2SliderYValue = 0;
    public static int recordRightFinger2SliderZValue = 0;
    public static int recordRightFinger3SliderXValue = 0;
    public static int recordRightFinger3SliderYValue = 0;
    public static int recordRightFinger3SliderZValue = 0;
    public static int recordRightFinger4SliderXValue = 0;
    public static int recordRightFinger4SliderYValue = 0;
    public static int recordRightFinger4SliderZValue = 0;
    public static int recordDownBodySliderXValue = 0;
    public static int recordDownBodySliderYValue = 0;
    public static int recordDownBodySliderZValue = 0;
    public static int recordRightUpperLegSliderXValue = 0;
    public static int recordRightUpperLegSliderYValue = 0;
    public static int recordRightUpperLegSliderZValue = 0;
    public static int recordRightForeLegSliderXValue = 0;
    public static int recordRightForeLegSliderYValue = 0;
    public static int recordRightForeLegSliderZValue = 0;
    public static int recordLeftUpperLegSliderXValue = 0;
    public static int recordLeftUpperLegSliderYValue = 0;
    public static int recordLeftUpperLegSliderZValue = 0;
    public static int recordLeftForeLegSliderXValue = 0;
    public static int recordLeftForeLegSliderYValue = 0;
    public static int recordLeftForeLegSliderZValue = 0;
    public static Stage stage;
    private static int leftUpperArmZOffset = 10;
    private static int leftForeArmXOffset = 15;
    private static int leftForeArmZOffset = -10;
    private static int leftWristYOffset = 50;
    private static int rightUpperArmZOffset = -10;
    private static int rightForeArmXOffset = 15;
    private static int rightForeArmZOffset = 10;
    private static int rightWristYOffset = -50;

    public static void resetBodyPartRotation(PartStickman3D bodyPartFX)
    {
        bodyPartFX.mXRotation = 0;
        bodyPartFX.mYRotation = 0;
        bodyPartFX.mZRotation = 0;
        bodyPartFX.calculate(0);
    }

    public static void createClassAndExecute(String classname, String bodyPart, int x, int y, int z)
    {
        DynamicCompiler.setClassName(classname);
        DynamicCompiler.setPodyPart(bodyPart);
        DynamicCompiler.setXYZ(x, y, z);
        //DynamicCompiler.start();
    }

    public static void showDialog(Stage primaryStage)
    {
        AnchorPane pane = null;
        Button OKButton;
        stage = new Stage();

        try
        {
            pane = FXMLLoader.load(Helper.class.getResource("ClassNameView.fxml"));
        } catch (IOException ex)
        {
            Logger.getLogger(Helper.class.getName()).log(Level.SEVERE, null, ex);
        }

        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initOwner(primaryStage);

        Scene scene = new Scene(pane, 400, 260);
        stage.setScene(scene);
        stage.show();

        OKButton = (Button) pane.getChildren().get(6);
        OKButton.setOnMouseClicked((event) ->
        {
            stage.close();

            DynamicCompiler.create();
        });
    }

    public static void switchRecordID(String ID, StickmanStageController controller)
    {
        int[] XYZ;
        int counter;
        switch (ID)
        {
            case "rec0":
                XYZ = getXYZFromTextField(controller.headXRotationField,
                        controller.headYRotationField,
                        controller.headZRotationField);
                appendMethodCommands("mHead", XYZ[0], XYZ[1], XYZ[2]);
                recordHeadSliderXValue = (int) controller.headXSlider.getValue();
                recordHeadSliderYValue = (int) controller.headYSlider.getValue();
                recordHeadSliderZValue = (int) controller.headZSlider.getValue();
                controller.headXRotationField.setText("0");
                controller.headYRotationField.setText("0");
                controller.headZRotationField.setText("0");
                counter = Integer.parseInt(controller.recCounter0.getText());
                counter++;
                controller.recCounter0.setText(counter + "");
                break;
            case "rec1":
                XYZ = getXYZFromTextField(controller.upperBodyXRotationField,
                        controller.upperBodyYRotationField,
                        controller.upperBodyZRotationField);
                appendMethodCommands("mUpperBody", XYZ[0], XYZ[1], XYZ[2]);
                recordUpperBodySliderXValue = (int) controller.upperBodyXSlider.getValue();
                recordUpperBodySliderYValue = (int) controller.upperBodyYSlider.getValue();
                recordUpperBodySliderZValue = (int) controller.upperBodyZSlider.getValue();
                controller.upperBodyXRotationField.setText("0");
                controller.upperBodyYRotationField.setText("0");
                controller.upperBodyZRotationField.setText("0");
                counter = Integer.parseInt(controller.recCounter1.getText());
                counter++;
                controller.recCounter1.setText(counter + "");
                break;
            case "rec2":
                XYZ = getXYZFromTextField(controller.leftUpperArmXRotationField,
                        controller.leftUpperArmYRotationField,
                        controller.leftUpperArmZRotationField);
                appendMethodCommands("mLeftUpperArm", XYZ[0], XYZ[1], XYZ[2] + leftUpperArmZOffset);
                recordLeftUpperArmSliderXValue = (int) controller.leftUpperArmXSlider.getValue();
                recordLeftUpperArmSliderYValue = (int) controller.leftUpperArmYSlider.getValue();
                recordLeftUpperArmSliderZValue = (int) controller.leftUpperArmZSlider.getValue();
                controller.leftUpperArmXRotationField.setText("0");
                controller.leftUpperArmYRotationField.setText("0");
                controller.leftUpperArmZRotationField.setText("0");
                leftUpperArmZOffset = 0;
                counter = Integer.parseInt(controller.recCounter2.getText());
                counter++;
                controller.recCounter2.setText(counter + "");
                break;
            case "rec3":
                XYZ = getXYZFromTextField(controller.leftForeArmXRotationField,
                        controller.leftForeArmYRotationField,
                        controller.leftForeArmZRotationField);
                appendMethodCommands("mLeftForeArm", XYZ[0] + leftForeArmXOffset, XYZ[1], XYZ[2] + leftForeArmZOffset);
                recordLeftForeArmSliderXValue = (int) controller.leftForeArmXSlider.getValue();
                recordLeftForeArmSliderYValue = (int) controller.leftForeArmYSlider.getValue();
                recordLeftForeArmSliderZValue = (int) controller.leftForeArmZSlider.getValue();
                controller.leftForeArmXRotationField.setText("0");
                controller.leftForeArmYRotationField.setText("0");
                controller.leftForeArmZRotationField.setText("0");
                leftForeArmXOffset = 0;
                leftForeArmZOffset = 0;
                counter = Integer.parseInt(controller.recCounter3.getText());
                counter++;
                controller.recCounter3.setText(counter + "");
                break;
            case "rec4":
                XYZ = getXYZFromTextField(controller.leftWristXRotationField,
                        controller.leftWristYRotationField,
                        controller.leftWristZRotationField);
                appendMethodCommands("mLeftWrist", XYZ[0], XYZ[1] + leftWristYOffset, XYZ[2]);
                recordLeftWristSliderXValue = (int) controller.leftWristXSlider.getValue();
                recordLeftWristSliderYValue = (int) controller.leftWristYSlider.getValue();
                recordLeftWristSliderZValue = (int) controller.leftWristZSlider.getValue();
                controller.leftWristXRotationField.setText("0");
                controller.leftWristYRotationField.setText("0");
                controller.leftWristZRotationField.setText("0");
                leftWristYOffset = 0;
                counter = Integer.parseInt(controller.recCounter4.getText());
                counter++;
                controller.recCounter4.setText(counter + "");
                break;
            case "rec5":
                XYZ = getXYZFromTextField(controller.leftFinger1XRotationField,
                        controller.leftFinger1YRotationField,
                        controller.leftFinger1ZRotationField);
                appendMethodCommands("mLeftFinger1", XYZ[0], XYZ[1], XYZ[2]);
                recordLeftFinger1SliderXValue = (int) controller.leftFinger1XSlider.getValue();
                recordLeftFinger1SliderYValue = (int) controller.leftFinger1YSlider.getValue();
                recordLeftFinger1SliderZValue = (int) controller.leftFinger1ZSlider.getValue();
                controller.leftFinger1XRotationField.setText("0");
                controller.leftFinger1YRotationField.setText("0");
                controller.leftFinger1ZRotationField.setText("0");
                counter = Integer.parseInt(controller.recCounter5.getText());
                counter++;
                controller.recCounter5.setText(counter + "");
                break;
            case "rec6":
                XYZ = getXYZFromTextField(controller.leftFinger2XRotationField,
                        controller.leftFinger2YRotationField,
                        controller.leftFinger2ZRotationField);
                appendMethodCommands("mLeftFinger2", XYZ[0], XYZ[1], XYZ[2]);
                recordLeftFinger2SliderXValue = (int) controller.leftFinger2XSlider.getValue();
                recordLeftFinger2SliderYValue = (int) controller.leftFinger2YSlider.getValue();
                recordLeftFinger2SliderZValue = (int) controller.leftFinger2ZSlider.getValue();
                controller.leftFinger2XRotationField.setText("0");
                controller.leftFinger2YRotationField.setText("0");
                controller.leftFinger2ZRotationField.setText("0");
                counter = Integer.parseInt(controller.recCounter6.getText());
                counter++;
                controller.recCounter6.setText(counter + "");
                break;
            case "rec7":
                XYZ = getXYZFromTextField(controller.leftFinger3XRotationField,
                        controller.leftFinger3YRotationField,
                        controller.leftFinger3ZRotationField);
                appendMethodCommands("mLeftFinger3", XYZ[0], XYZ[1], XYZ[2]);
                recordLeftFinger3SliderXValue = (int) controller.leftFinger3XSlider.getValue();
                recordLeftFinger3SliderYValue = (int) controller.leftFinger3YSlider.getValue();
                recordLeftFinger3SliderZValue = (int) controller.leftFinger3ZSlider.getValue();
                controller.leftFinger3XRotationField.setText("0");
                controller.leftFinger3YRotationField.setText("0");
                controller.leftFinger3ZRotationField.setText("0");
                counter = Integer.parseInt(controller.recCounter7.getText());
                counter++;
                controller.recCounter7.setText(counter + "");
                break;
            case "rec8":
                XYZ = getXYZFromTextField(controller.leftFinger4XRotationField,
                        controller.leftFinger4YRotationField,
                        controller.leftFinger4ZRotationField);
                appendMethodCommands("mLeftFinger4", XYZ[0], XYZ[1], XYZ[2]);
                recordLeftFinger4SliderXValue = (int) controller.leftFinger4XSlider.getValue();
                recordLeftFinger4SliderYValue = (int) controller.leftFinger4YSlider.getValue();
                recordLeftFinger4SliderZValue = (int) controller.leftFinger4ZSlider.getValue();
                controller.leftFinger4XRotationField.setText("0");
                controller.leftFinger4YRotationField.setText("0");
                controller.leftFinger4ZRotationField.setText("0");
                counter = Integer.parseInt(controller.recCounter8.getText());
                counter++;
                controller.recCounter8.setText(counter + "");
                break;
            case "rec9":
                XYZ = getXYZFromTextField(controller.rightUpperArmXRotationField,
                        controller.rightUpperArmYRotationField,
                        controller.rightUpperArmZRotationField);
                appendMethodCommands("mRightUpperArm", XYZ[0], XYZ[1], XYZ[2] + rightUpperArmZOffset);
                recordRightUpperArmSliderXValue = (int) controller.rightUpperArmXSlider.getValue();
                recordRightUpperArmSliderYValue = (int) controller.rightUpperArmYSlider.getValue();
                recordRightUpperArmSliderZValue = (int) controller.rightUpperArmZSlider.getValue();
                controller.rightUpperArmXRotationField.setText("0");
                controller.rightUpperArmYRotationField.setText("0");
                controller.rightUpperArmZRotationField.setText("0");
                rightUpperArmZOffset = 0;
                counter = Integer.parseInt(controller.recCounter9.getText());
                counter++;
                controller.recCounter9.setText(counter + "");
                break;
            case "rec10":
                XYZ = getXYZFromTextField(controller.rightForeArmXRotationField,
                        controller.rightForeArmYRotationField,
                        controller.rightForeArmZRotationField);
                appendMethodCommands("mRightForeArm", XYZ[0] + rightForeArmXOffset, XYZ[1], XYZ[2] + rightForeArmZOffset);
                recordRightForeArmSliderXValue = (int) controller.rightForeArmXSlider.getValue();
                recordRightForeArmSliderYValue = (int) controller.rightForeArmYSlider.getValue();
                recordRightForeArmSliderZValue = (int) controller.rightForeArmZSlider.getValue();
                controller.rightForeArmXRotationField.setText("0");
                controller.rightForeArmYRotationField.setText("0");
                controller.rightForeArmZRotationField.setText("0");
                rightForeArmXOffset = 0;
                rightForeArmZOffset = 0;
                counter = Integer.parseInt(controller.recCounter10.getText());
                counter++;
                controller.recCounter10.setText(counter + "");
                break;
            case "rec11":
                XYZ = getXYZFromTextField(controller.rightWristXRotationField,
                        controller.rightWristYRotationField,
                        controller.rightWristZRotationField);
                appendMethodCommands("mRightWrist", XYZ[0], XYZ[1] + rightWristYOffset, XYZ[2]);
                recordRightWristSliderXValue = (int) controller.rightWristXSlider.getValue();
                recordRightWristSliderYValue = (int) controller.rightWristYSlider.getValue();
                recordRightWristSliderZValue = (int) controller.rightWristZSlider.getValue();
                controller.rightWristXRotationField.setText("0");
                controller.rightWristYRotationField.setText("0");
                controller.rightWristZRotationField.setText("0");
                counter = Integer.parseInt(controller.recCounter11.getText());
                counter++;
                controller.recCounter11.setText(counter + "");
                break;
            case "rec12":
                XYZ = getXYZFromTextField(controller.rightFinger1XRotationField,
                        controller.rightFinger1YRotationField,
                        controller.rightFinger1ZRotationField);
                appendMethodCommands("mRightFinger1", XYZ[0], XYZ[1], XYZ[2]);
                recordRightFinger1SliderXValue = (int) controller.rightFinger1XSlider.getValue();
                recordRightFinger1SliderYValue = (int) controller.rightFinger1YSlider.getValue();
                recordRightFinger1SliderZValue = (int) controller.rightFinger1ZSlider.getValue();
                controller.rightFinger1XRotationField.setText("0");
                controller.rightFinger1YRotationField.setText("0");
                controller.rightFinger1ZRotationField.setText("0");
                counter = Integer.parseInt(controller.recCounter12.getText());
                counter++;
                controller.recCounter12.setText(counter + "");
                break;
            case "rec13":
                XYZ = getXYZFromTextField(controller.rightFinger2XRotationField,
                        controller.rightFinger2YRotationField,
                        controller.rightFinger2ZRotationField);
                appendMethodCommands("mRightFinger2", XYZ[0], XYZ[1], XYZ[2]);
                recordRightFinger2SliderXValue = (int) controller.rightFinger2XSlider.getValue();
                recordRightFinger2SliderYValue = (int) controller.rightFinger2YSlider.getValue();
                recordRightFinger2SliderZValue = (int) controller.rightFinger2ZSlider.getValue();
                controller.rightFinger2XRotationField.setText("0");
                controller.rightFinger2YRotationField.setText("0");
                controller.rightFinger2ZRotationField.setText("0");
                counter = Integer.parseInt(controller.recCounter13.getText());
                counter++;
                controller.recCounter13.setText(counter + "");
                break;
            case "rec14":
                XYZ = getXYZFromTextField(controller.rightFinger3XRotationField,
                        controller.rightFinger3YRotationField,
                        controller.rightFinger3ZRotationField);
                appendMethodCommands("mRightFinger3", XYZ[0], XYZ[1], XYZ[2]);
                recordRightFinger3SliderXValue = (int) controller.rightFinger3XSlider.getValue();
                recordRightFinger3SliderYValue = (int) controller.rightFinger3YSlider.getValue();
                recordRightFinger3SliderZValue = (int) controller.rightFinger3ZSlider.getValue();
                controller.rightFinger3XRotationField.setText("0");
                controller.rightFinger3YRotationField.setText("0");
                controller.rightFinger3ZRotationField.setText("0");
                counter = Integer.parseInt(controller.recCounter14.getText());
                counter++;
                controller.recCounter14.setText(counter + "");
                break;
            case "rec15":
                XYZ = getXYZFromTextField(controller.rightFinger4XRotationField,
                        controller.rightFinger4YRotationField,
                        controller.rightFinger4ZRotationField);
                appendMethodCommands("mRightFinger4", XYZ[0], XYZ[1], XYZ[2]);
                recordRightFinger4SliderXValue = (int) controller.rightFinger4XSlider.getValue();
                recordRightFinger4SliderYValue = (int) controller.rightFinger4YSlider.getValue();
                recordRightFinger4SliderZValue = (int) controller.rightFinger4ZSlider.getValue();
                controller.rightFinger4XRotationField.setText("0");
                controller.rightFinger4YRotationField.setText("0");
                controller.rightFinger4ZRotationField.setText("0");
                counter = Integer.parseInt(controller.recCounter15.getText());
                counter++;
                controller.recCounter15.setText(counter + "");
                break;
            case "rec16":
                XYZ = getXYZFromTextField(controller.downBodyXRotationField,
                        controller.downBodyYRotationField,
                        controller.downBodyZRotationField);
                appendMethodCommands("mDownBody", XYZ[0], XYZ[1], XYZ[2]);
                recordDownBodySliderYValue = (int) controller.downBodyYSlider.getValue();
                controller.downBodyXRotationField.setText("0");
                controller.downBodyYRotationField.setText("0");
                controller.downBodyZRotationField.setText("0");
                counter = Integer.parseInt(controller.recCounter16.getText());
                counter++;
                controller.recCounter16.setText(counter + "");
                break;
            case "rec17":
                XYZ = getXYZFromTextField(controller.rightUpperLegXRotationField,
                        controller.rightUpperLegYRotationField,
                        controller.rightUpperLegZRotationField);
                appendMethodCommands("mRightUpperLeg", XYZ[0], XYZ[1], XYZ[2]);
                recordRightUpperLegSliderXValue = (int) controller.rightUpperLegXSlider.getValue();
                recordRightUpperLegSliderYValue = (int) controller.rightUpperLegYSlider.getValue();
                recordRightUpperLegSliderZValue = (int) controller.rightUpperLegZSlider.getValue();
                controller.rightUpperLegXRotationField.setText("0");
                controller.rightUpperLegYRotationField.setText("0");
                controller.rightUpperLegZRotationField.setText("0");
                counter = Integer.parseInt(controller.recCounter17.getText());
                counter++;
                controller.recCounter17.setText(counter + "");
                break;
            case "rec18":
                XYZ = getXYZFromTextField(controller.rightForeLegXRotationField,
                        controller.rightForeLegYRotationField,
                        controller.rightForeLegZRotationField);
                appendMethodCommands("mRightForeLeg", XYZ[0], XYZ[1], XYZ[2]);
                recordRightForeLegSliderXValue = (int) controller.rightForeLegXSlider.getValue();
                recordRightForeLegSliderYValue = (int) controller.rightForeLegYSlider.getValue();
                recordRightForeLegSliderZValue = (int) controller.rightForeLegZSlider.getValue();
                controller.rightForeLegXRotationField.setText("0");
                controller.rightForeLegYRotationField.setText("0");
                controller.rightForeLegZRotationField.setText("0");
                counter = Integer.parseInt(controller.recCounter18.getText());
                counter++;
                controller.recCounter18.setText(counter + "");
                break;
            case "rec19":
                XYZ = getXYZFromTextField(controller.leftUpperLegXRotationField,
                        controller.leftUpperLegYRotationField,
                        controller.leftUpperLegZRotationField);
                appendMethodCommands("mLeftUpperLeg", XYZ[0], XYZ[1], XYZ[2]);
                recordLeftUpperLegSliderXValue = (int) controller.leftUpperArmXSlider.getValue();
                recordLeftUpperLegSliderYValue = (int) controller.leftUpperArmYSlider.getValue();
                recordLeftUpperLegSliderZValue = (int) controller.leftUpperArmZSlider.getValue();
                controller.leftUpperLegXRotationField.setText("0");
                controller.leftUpperLegYRotationField.setText("0");
                controller.leftUpperLegZRotationField.setText("0");
                counter = Integer.parseInt(controller.recCounter19.getText());
                counter++;
                controller.recCounter19.setText(counter + "");
                break;
            case "rec20":
                XYZ = getXYZFromTextField(controller.leftForeLegXRotationField,
                        controller.leftForeLegYRotationField,
                        controller.leftForeLegZRotationField);
                appendMethodCommands("mLeftForeLeg", XYZ[0], XYZ[1], XYZ[2]);
                recordLeftForeLegSliderXValue = (int) controller.leftForeLegXSlider.getValue();
                recordLeftForeLegSliderYValue = (int) controller.leftForeLegYSlider.getValue();
                recordLeftForeLegSliderZValue = (int) controller.leftForeLegZSlider.getValue();
                controller.leftForeLegXRotationField.setText("0");
                controller.leftForeLegYRotationField.setText("0");
                controller.leftForeLegZRotationField.setText("0");
                counter = Integer.parseInt(controller.recCounter20.getText());
                counter++;
                controller.recCounter20.setText(counter + "");
                break;
        }
    }

    private static int[] getXYZFromTextField(TextField xField, TextField yField, TextField zField)
    {
        int[] XYZ = new int[3];

        int x = Integer.parseInt(xField.getText());
        int y = Integer.parseInt(yField.getText());
        int z = Integer.parseInt(zField.getText());

        XYZ[0] = x;
        XYZ[1] = y;
        XYZ[2] = z;

        return XYZ;
    }

    private static void appendMethodCommands(String bodypart, int x, int y, int z)
    {
        DynamicCompiler.methodContent.append("mAnimationPart = new ArrayList<>(); \n");
        DynamicCompiler.methodContent.append("mAnimationPart.add(new AnimationContent(mStickman.").append(bodypart)
                .append(",\"rotate\",").append(x).append(")); \n");
        DynamicCompiler.methodContent.append("mAnimationPart.add(new AnimationContent(mStickman.").append(bodypart)
                .append(",\"yrotate\",").append(y).append(")); \n");
        DynamicCompiler.methodContent.append("mAnimationPart.add(new AnimationContent(mStickman.").append(bodypart)
                .append(",\"zrotate\",").append(z).append(")); \n");
        DynamicCompiler.methodContent.append("playAnimationPart(mDuration);\n");
    }

    public static void resetAllRotation(StickmanStageController controller)
    {
        reset(controller.currentStickman.mHead);
        reset(controller.currentStickman.mUpperBody);
        reset(controller.currentStickman.mDownBody);
        reset(controller.currentStickman.mLeftUpperArm);
        reset(controller.currentStickman.mLeftForeArm);
        reset(controller.currentStickman.mLeftWrist);
        reset(controller.currentStickman.mLeftFinger1);
        reset(controller.currentStickman.mLeftFinger2);
        reset(controller.currentStickman.mLeftFinger3);
        reset(controller.currentStickman.mLeftFinger4);
        reset(controller.currentStickman.mRightUpperArm);
        reset(controller.currentStickman.mRightForeArm);
        reset(controller.currentStickman.mRightWrist);
        reset(controller.currentStickman.mRightFinger1);
        reset(controller.currentStickman.mRightFinger2);
        reset(controller.currentStickman.mRightFinger3);
        reset(controller.currentStickman.mRightFinger4);
        reset(controller.currentStickman.mLeftUpperLeg);
        reset(controller.currentStickman.mLeftForeLeg);
        reset(controller.currentStickman.mLeftFoot);
        reset(controller.currentStickman.mRightUpperLeg);
        reset(controller.currentStickman.mRightForeLeg);
        reset(controller.currentStickman.mRightFoot);
        reset(controller.currentStickman.mUpperBodyAndHead);
    }

    private static void reset(Part3D bodyPartFX)
    {
        bodyPartFX.mXRotation = ((PartStickman3D) bodyPartFX).mXRotatationRecorder;
        bodyPartFX.mYRotation = ((PartStickman3D) bodyPartFX).mYRotatationRecorder;
        bodyPartFX.mZRotation = ((PartStickman3D) bodyPartFX).mZRotatationRecorder;
        bodyPartFX.calculate(0);
    }

}
