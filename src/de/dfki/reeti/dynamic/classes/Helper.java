/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.reeti.dynamic.classes;

import de.dfki.reeti.ReetiStageController;
import de.dfki.reeti.body.BodyPartFX;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author EmpaT
 */
public class Helper {

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

    public static void resetBodyPartRotation(BodyPartFX bodyPartFX) {
        bodyPartFX.mXRotation = 0;
        bodyPartFX.mYRotation = 0;
        bodyPartFX.mZRotation = 0;
        bodyPartFX.calculate(0);
    }

    public static void createClassAndExecute(String classname, String bodyPart, int x, int y, int z) {
        DynamicCompiler.setClassName(classname);
        DynamicCompiler.setPodyPart(bodyPart);
        DynamicCompiler.setXYZ(x, y, z);
        //DynamicCompiler.start();
    }

    public static Stage stage;

    public static void showDialog(Stage primaryStage) {
        AnchorPane pane = null;
        Button OKButton;
        stage = new Stage();

        try {
            pane = FXMLLoader.load(Helper.class.getResource("ClassNameView.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(Helper.class.getName()).log(Level.SEVERE, null, ex);
        }

        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initOwner(primaryStage);

        Scene scene = new Scene(pane, 400, 260);
        stage.setScene(scene);
        stage.show();

        OKButton = (Button) pane.getChildren().get(6);
        OKButton.setOnMouseClicked((event) -> {
            stage.close();

            DynamicCompiler.create();
        });
    }

    private static int leftUpperArmZOffset = 10;
    private static int leftForeArmXOffset = 15;
    private static int leftForeArmZOffset = -10;
    private static int leftWristYOffset = 50;
    private static int rightUpperArmZOffset = -10;
    private static int rightForeArmXOffset = 15;
    private static int rightForeArmZOffset = 10;
    private static int rightWristYOffset = -50;

    public static void switchRecordID(String ID, ReetiStageController controller) {
        int[] XYZ;
        int counter;
        switch (ID) {
            case "rec0":
                XYZ = getXYZFromTextField(controller.headXRotationField,
                        controller.headYRotationField,
                        controller.headZRotationField);
                appendMethodCommands("mHeadFX", XYZ[0], XYZ[1], XYZ[2]);
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
        }
    }

    private static int[] getXYZFromTextField(TextField xField, TextField yField, TextField zField) {
        int[] XYZ = new int[3];

        int x = Integer.parseInt(xField.getText());
        int y = Integer.parseInt(yField.getText());
        int z = Integer.parseInt(zField.getText());

        XYZ[0] = x;
        XYZ[1] = y;
        XYZ[2] = z;

        return XYZ;
    }

    private static void appendMethodCommands(String bodypart, int x, int y, int z) {
        DynamicCompiler.methodContent.append("mAnimationPartFX = new ArrayList<>(); \n");
        DynamicCompiler.methodContent.append("mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.").append(bodypart)
                .append(",\"rotate\",").append(x).append(")); \n");
        DynamicCompiler.methodContent.append("mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.").append(bodypart)
                .append(",\"yrotate\",").append(y).append(")); \n");
        DynamicCompiler.methodContent.append("mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.").append(bodypart)
                .append(",\"zrotate\",").append(z).append(")); \n");
        DynamicCompiler.methodContent.append("playAnimationPart(mDuration);\n");
    }

    public static void resetAllRotation(ReetiStageController controller) {
        reset(controller.currentReeti.mHead);
        reset(controller.currentReeti.mBody);

    }

    private static void reset(BodyPartFX bodyPartFX) {
        bodyPartFX.mXRotation = bodyPartFX.mXRotatationRecorder;
        bodyPartFX.mYRotation = bodyPartFX.mYRotatationRecorder;
        bodyPartFX.mZRotation = bodyPartFX.mZRotatationRecorder;
        bodyPartFX.calculate(0);
    }

}
