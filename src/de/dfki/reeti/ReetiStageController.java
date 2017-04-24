package de.dfki.reeti;

import de.dfki.common.StickmansOnStage;
import de.dfki.common.commonFX3D.ViewController;
import de.dfki.reeti.controllerhelper.ColorHelper;
import de.dfki.reeti.controllerhelper.SliderHelper;
import de.dfki.reeti.stage.ReetiStage;
import de.dfki.reeti.timeline.TimelineStart;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.*;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collectors;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;

/**
 *
 * @author Beka
 */
public class ReetiStageController extends AReetiStageController implements ViewController {

    @FXML
    public void initialize() {
        //Select a stickmanSwing
        reetiComboBox.setOnAction((event)
                -> {
            mReetiComboBox = reetiComboBox.getSelectionModel().getSelectedItem();
            currentReeti = (Reeti) mStickmanOnstage.getStickman(mReetiComboBox);
            setComboboxValue((Reeti) mStickmanOnstage.getStickman(mReetiComboBox));
        });

        fillEmotionScrollPane();
        fillEnvironmentScrollPane();

        perlinNoiseGroup = new ToggleGroup();
        WithPerlinNoise.setToggleGroup(perlinNoiseGroup);
        WithoutPerlinNoise.setToggleGroup(perlinNoiseGroup);
        WithoutPerlinNoise.getStylesheets().add(this.getClass().getResource("RadioButtonCSS.css").toExternalForm());
        WithPerlinNoise.getStylesheets().add(this.getClass().getResource("RadioButtonCSS.css").toExternalForm());

        SliderHelper.handleCameraSlider(this, cameraXSlider, "X");
        SliderHelper.handleCameraSlider(this, cameraYSlider, "Y");
        SliderHelper.handleCameraSlider(this, cameraZSlider, "Z");

        SliderHelper.handleHeadSlider(this, headXSlider, "X");
        SliderHelper.handleHeadSlider(this, headYSlider, "Y");
        SliderHelper.handleHeadSlider(this, headZSlider, "Z");
        SliderHelper.handleLeftEyeXSlider(this);
        SliderHelper.handleLeftEyeYSlider(this);
        SliderHelper.handleRightEyeXSlider(this);
        SliderHelper.handleRightEyeYSlider(this);
        SliderHelper.handleLeftEyeLidXSlider(this);
        SliderHelper.handleRightEyeLidXSlider(this);
        SliderHelper.handleLeftEarSlider(this);
        SliderHelper.handleRightEarSlider(this);
        SliderHelper.handleLeftLCSlider(this);
        SliderHelper.handleRightLCSlider(this);
        SliderHelper.handleTopLipSlider(this);
        SliderHelper.handleBottomLipSlider(this);

        ExitButton.setOnAction((ActionEvent event) -> {
            Stage stage = (Stage) ExitButton.getScene().getWindow();
            stage.close();
            System.exit(0);
//            CommandReceiver cr = new CommandReceiver(currentReeti, this);
//            cr.start();

        });
        SaveButton.setOnAction((event) -> {
//            Platform.runLater(() ->
//                {
//                     currentReeti.neckRotat(48);
//                     currentReeti.neckTilt(28);
//                     currentReeti.leftEar(0);
//                    currentReeti.rightEar(0);
//                    currentReeti.leftEyeTilt(46);
//                    currentReeti.rightEyeTilt(46);
//                    currentReeti.leftEyePan(42);
//                    currentReeti.rightEyePan(64);
//                    currentReeti.leftEyeLid(82);
//                    currentReeti.rightEyeLid(77);
//                });
//            TimelineStart timelineStart = new TimelineStart(this.currentReeti);
//            timelineStart.setOwnerStage(this.stage3D.getMainStage());
//            try {
//                timelineStart.show();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
        });
        
        leftLedOffButton.setOnAction((event) ->
        {
            currentReeti.mLeftCheek.getLedGroup().setVisible(false);
        });
        
        rightLedOffButton.setOnAction((event) ->
        {
            currentReeti.mRightCheek.getLedGroup().setVisible(false);
        });
        
        bothLedOffButton.setOnAction((event) ->
        {
            currentReeti.mLeftCheek.getLedGroup().setVisible(false);
            currentReeti.mRightCheek.getLedGroup().setVisible(false);
        });
    }

    public Reeti getStickmanAs3D(String mStickmancombobox) {
        return (Reeti) mStickmanOnstage.getStickman(mStickmancombobox);
    }

    /**
     *
     * @param commonStickmansOnStage
     */
    @Override
    public void setStickamnOnStage(StickmansOnStage commonStickmansOnStage) {
        this.mStickmanOnstage = commonStickmansOnStage;
        fillComboForStickman();

    }

    @FXML
    public void handleStopCamera() {
        if (isCameraStarted) {
            stage3D.getSubScene().setCamera(null);
            isCameraStarted = false;
        }
    }

    @FXML
    public void handleStartCamera() {
        if (!isCameraStarted) {
            stage3D.getSubScene().setCamera(stage3D.getCamera());
            isCameraStarted = true;
        }
    }

    @FXML
    public void handleResetCamera() {

        stage3D.getCamera().setTranslateX(stage3D.getRecordCameraXPosition());
        stage3D.getCamera().setTranslateY(stage3D.getRecordCameraYPosition());
        stage3D.getCamera().setTranslateZ(stage3D.getRecordCameraZPosition());

        cameraXSlider.setValue(0);
        cameraYSlider.setValue(0);
        cameraZSlider.setValue(0);
        cameraXTranslationField.setText("0.0");
        cameraYTranslationField.setText("0.0");
        cameraZTranslationField.setText("0.0");
        stage3D.getCamera().setNearClip(0.8);
        stage3D.getCamera().setFarClip(3000);
        stage3D.getCamera().setFieldOfView(30);
        nearClipField.setText("0.8");
        farClipField.setText("3000");
        fieldOfViewField.setText("30");
        stage3D.getCamera().getTransforms().clear();
    }

    @FXML
    public void handleCameraXTranslation(MouseEvent event) {
        if (event.getSource().equals(cameraXPlusTranslationButton)) {
            double currentValue = Double.parseDouble(cameraXTranslationField.getText());
            currentValue += 50;
            stage3D.getCamera().setTranslateX(stage3D.getCamera().getTranslateX() + 50);
            cameraXTranslationField.setText(Double.toString(currentValue));
        } else if (event.getSource().equals(cameraXMinusTranslationButton)) {
            double currentValue = Double.parseDouble(cameraXTranslationField.getText());
            currentValue -= 50;
            stage3D.getCamera().setTranslateX(stage3D.getCamera().getTranslateX() - 50);
            cameraXTranslationField.setText(Double.toString(currentValue));
        }
    }

    @FXML
    public void handleCameraYTranslation(MouseEvent event) {
        if (event.getSource().equals(cameraYPlusTranslationButton)) {
            double currentValue = Double.parseDouble(cameraYTranslationField.getText());
            currentValue += 50;
            stage3D.getCamera().setTranslateY(stage3D.getCamera().getTranslateY() + 50);
            cameraYTranslationField.setText(Double.toString(currentValue));
        } else if (event.getSource().equals(cameraYMinusTranslationButton)) {
            double currentValue = Double.parseDouble(cameraYTranslationField.getText());
            currentValue -= 50;
            stage3D.getCamera().setTranslateY(stage3D.getCamera().getTranslateY() - 50);
            cameraYTranslationField.setText(Double.toString(currentValue));
        }
    }

    @FXML
    public void handleCameraZTranslation(MouseEvent event) {
        if (event.getSource().equals(cameraZPlusTranslationButton)) {
            double currentValue = Double.parseDouble(cameraZTranslationField.getText());
            currentValue += 10;
            stage3D.getCamera().setTranslateZ(stage3D.getCamera().getTranslateZ() + 10);
            cameraZTranslationField.setText(Double.toString(currentValue));
        } else if (event.getSource().equals(cameraZMinusTranslationButton)) {
            double currentValue = Double.parseDouble(cameraZTranslationField.getText());
            currentValue -= 10;
            stage3D.getCamera().setTranslateZ(stage3D.getCamera().getTranslateZ() - 10);
            cameraZTranslationField.setText(Double.toString(currentValue));
        }
    }

    @FXML
    public void handleNearClip(MouseEvent event) {
        if (event.getSource().equals(nearClipPlusButton)) {
            double currentValue = Double.parseDouble(nearClipField.getText());
            if (currentValue >= 1.0) {
                currentValue = 1.0;
            } else {
                currentValue += 0.1;
                currentValue = Math.round(currentValue * 100.0) / 100.0;
            }
            stage3D.getCamera().setNearClip(currentValue);
            nearClipField.setText(Double.toString(currentValue));
        } else if (event.getSource().equals(nearClipMinusButton)) {
            double currentValue = Double.parseDouble(nearClipField.getText());
            if (currentValue <= 0.0) {
                currentValue = 0.0;
            } else {
                currentValue -= 0.1;
                currentValue = Math.round(currentValue * 100.0) / 100.0;
            }
            stage3D.getCamera().setNearClip(currentValue);
            nearClipField.setText(Double.toString(currentValue));
        }
    }

    @FXML
    public void handleFarClip(MouseEvent event) {
        if (event.getSource().equals(farClipPlusButton)) {
            double currentValue = Double.parseDouble(farClipField.getText());
            currentValue += 50;

            stage3D.getCamera().setFarClip(currentValue);
            farClipField.setText(Double.toString(currentValue));
        } else if (event.getSource().equals(farClipMinusButton)) {
            double currentValue = Double.parseDouble(farClipField.getText());
            currentValue -= 50;

            stage3D.getCamera().setFarClip(currentValue);
            farClipField.setText(Double.toString(currentValue));
        }
    }

    @FXML
    public void handleFieldOfView(MouseEvent event) {
        if (event.getSource().equals(fieldOfViewPlusButton)) {
            double currentValue = Double.parseDouble(fieldOfViewField.getText());
            currentValue += 1;

            stage3D.getCamera().setFieldOfView(currentValue);
            fieldOfViewField.setText(Double.toString(currentValue));
        } else if (event.getSource().equals(fieldOfViewMinusButton)) {
            double currentValue = Double.parseDouble(fieldOfViewField.getText());
            currentValue -= 1;

            stage3D.getCamera().setFieldOfView(currentValue);
            fieldOfViewField.setText(Double.toString(currentValue));
        }
    }

    @FXML
    public void handleLeftLedColor() {
        ColorHelper.leftLedColorChanger(this);
    }

    @FXML
    public void handleRightLedColor() {
        ColorHelper.rightLedColorChanger(this);
    }

    @FXML
    public void handleBothLedColor() {
        ColorHelper.bothLedColorChanger(this);
    }

//    @FXML
//    public void handleHeadColorButtons(MouseEvent ev) {
//        ColorHelper.handleHeadColorButtons(this, ev);
//    }

    private void fillEmotionScrollPane() {
        ArrayList<String> getClassesNames;
        Packageparser parser = new Packageparser(PACKAGE_EMOTIONEXPRESSION);
        getClassesNames = parser.getClassNameList();
        ObservableList<String> classNames = FXCollections.observableArrayList();
        classNames.addAll(getClassesNames.stream().collect(Collectors.toList()));

        createAndHandleRadioButtons(getClassesNames, emotionsScrollPane);
    }

    private void fillEnvironmentScrollPane() {
        ArrayList<String> getClassesNames;
        Packageparser parser = new Packageparser(PACKAGE_ENVIRONMENT);
        getClassesNames = parser.getClassNameList();
        ObservableList<String> classNames = FXCollections.observableArrayList();
        classNames.addAll(getClassesNames.stream().collect(Collectors.toList()));

        createAndHandleRadioButtons(getClassesNames, environmentScrollPane);
    }

    private void createAndHandleRadioButtons(ArrayList<String> getClassesNames, ScrollPane container) {
        GridPane gridPane = new GridPane();
        container.setContent(gridPane);
        ToggleGroup toggleGroup = new ToggleGroup();

        int startIndex = 0;
        int endIndex = 0;

        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(10, 10, 10, 10));

        for (int i = 0; i < getClassesNames.size(); i++) {
            RadioButton button = new RadioButton(getClassesNames.get(i));
            button.setToggleGroup(toggleGroup);
            button.getStylesheets().add(this.getClass().getResource("RadioButtonCSS.css").toExternalForm());
            button.setFont(Font.font("Arial", 15));

            button.setOnAction((event) -> {
                currentRadioButton = (RadioButton) event.getSource();
//                Platform.runLater(() -> currentReeti.rightLC(20));
//                Platform.runLater(() -> currentReeti.leftLC(20));
                currentReeti.doAnimation(button.getText(), 500, true);
            });
            if (i % 3 == 2) {
                gridPane.add(button, startIndex, endIndex);
                endIndex++;
                startIndex = 0;
            } else {
                gridPane.add(button, startIndex, endIndex);
                startIndex++;
            }
        }
    }

    public void fillComboForStickman() {
        ObservableList<String> stickmanNames = FXCollections.observableArrayList();
        stickmanNames.addAll(mStickmanOnstage.getStickmanNames().stream().collect(Collectors.toList()));
        reetiComboBox.getItems().clear();
        reetiComboBox.getItems().addAll(stickmanNames);
        if (!stickmanNames.isEmpty()) {
            reetiComboBox.setValue(stickmanNames.get(0));
            currentReeti = (Reeti) mStickmanOnstage.getStickman(stickmanNames.get(0));
            setComboboxValue((Reeti) mStickmanOnstage.getStickman(stickmanNames.get(0)));
        }
        mReetiComboList.clear();
        mReetiComboList.addAll(stickmanNames);
    }

    // set the setValue of combobox
    private void setComboboxValue(Reeti mStick) {
        bothLedColorPicker.setValue(colorWithoutOpacity(mStick.mBody.mColor));
        leftLedColorPicker.setValue(colorWithoutOpacity(mStick.mHead.mColor));
    }

    @FXML
    private void handleWithPerlinNoise() {

        currentReeti.doAnimation("StartIdle", 1000, true);

    }

    @FXML
    private void handleWithoutPerlinNoise() {

        currentReeti.doAnimation("StopIdle", 1000, true);
    }

    public ReetiStage getStage3D() {
        return stage3D;
    }

    public void setStage3D(ReetiStage stage3D) {
        this.stage3D = stage3D;
    }

    // convert color to hex
    private String toHexCode(Color color) {
        return String.format("#%02X%02X%02X%02X", (int) (color.getRed() * 255), (int) (color.getGreen() * 255),
                (int) (color.getBlue() * 255), (int) (color.getOpacity() * 100));
    }

    private Color colorWithoutOpacity(Color color) {
        return new Color(color.getRed(), color.getGreen(), color.getBlue(), 1);
    }
}
