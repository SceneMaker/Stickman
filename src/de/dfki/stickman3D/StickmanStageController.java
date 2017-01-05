package de.dfki.stickman3D;

import de.dfki.CommandReceiver.CommandReceiver;
import de.dfki.common.Gender;
import de.dfki.common.StickmansOnStage;
import de.dfki.common.commonFX3D.ViewController;
import de.dfki.stickman3D.controllerhelper.ColorHelper;
import de.dfki.stickman3D.controllerhelper.OpacityHelper;
import de.dfki.stickman3D.controllerhelper.SliderHelper;
import de.dfki.stickman3D.stage.StickmanStage3D;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.*;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 *
 * @author Beka
 */
public class StickmanStageController implements ViewController {

    private static final String PACKAGE_EMOTIONEXPRESSION = "de.dfki.stickman3D.animation.face";
    private static final String PACKAGE_GESTURE = "de.dfki.stickman3D.animation.gesture";
    private static final String PACKAGE_HEAD = "de.dfki.stickman3D.animation.head";
    private static final String PACKAGE_ENVIRONMENT = "de.dfki.stickman3D.animation.environment";
    private static final String PACKAGE_POSTURE = "de.dfki.stickman3D.animation.posture";

    @FXML
    private RadioButton WithPerlinNoise;
    @FXML
    private RadioButton WithoutPerlinNoise;
    @FXML
    private ComboBox<String> StickmanComboBox;
    @FXML
    private ComboBox<String> EmotionExpressionComboBox;
    @FXML
    private Button RestButton;
    @FXML
    private Button ExitButton;
    @FXML
    Button startCamera;
    @FXML
    Button stopCamera;
    @FXML
    Button resetCamera;
    @FXML
    private ColorPicker headColorPicker;
    @FXML
    private ColorPicker hairColorPicker;
    @FXML
    private ColorPicker bodyColorPicker;
    @FXML
    private ColorPicker limbsColorPicker;
    @FXML
    private ColorPicker shoesColorPicker;
    @FXML
    private ColorPicker lipsColorPicker;
    @FXML
    private ColorPicker eyeColorPicker;
    @FXML
    private ColorPicker browColorPicker;
    @FXML
    private ColorPicker noseColorPicker;
    @FXML
    ScrollPane emotionsScrollPane;
    @FXML
    ScrollPane gestureScrollPane;
    @FXML
    ScrollPane headScrollPane;
    @FXML
    ScrollPane environmentScrollPane;
    @FXML
    ScrollPane postureScrollPane;
    @FXML
    private Button headColorReset;
    @FXML
    private Button headColorBrighter;
    @FXML
    private Button headColorDarker;
    @FXML
    private Button hairColorReset;
    @FXML
    private Button hairColorBrighter;
    @FXML
    private Button hairColorDarker;
    @FXML
    private Button bodyColorReset;
    @FXML
    private Button bodyColorBrighter;
    @FXML
    private Button bodyColorDarker;
    @FXML
    private Button limbsColorReset;
    @FXML
    private Button limbsColorBrighter;
    @FXML
    private Button limbsColorDarker;
    @FXML
    private Button shoesColorReset;
    @FXML
    private Button shoesColorBrighter;
    @FXML
    private Button shoesColorDarker;
    @FXML
    private Button lipsColorReset;
    @FXML
    private Button lipsColorBrighter;
    @FXML
    private Button lipsColorDarker;
    @FXML
    private Button eyeColorReset;
    @FXML
    private Button eyeColorBrighter;
    @FXML
    private Button eyeColorDarker;
    @FXML
    private Button browColorReset;
    @FXML
    private Button browColorBrighter;
    @FXML
    private Button browColorDarker;
    @FXML
    private Button noseColorReset;
    @FXML
    private Button noseColorBrighter;
    @FXML
    private Button noseColorDarker;
    @FXML
    private Slider cameraXSlider;
    @FXML
    private Slider cameraYSlider;
    @FXML
    private Slider cameraZSlider;
    @FXML
    private Button cameraXPlusTranslationButton;
    @FXML
    private Button cameraXMinusTranslationButton;
    @FXML
    private TextField cameraXTranslationField;
    @FXML
    private Button cameraYPlusTranslationButton;
    @FXML
    private Button cameraYMinusTranslationButton;
    @FXML
    private TextField cameraYTranslationField;
    @FXML
    private Button cameraZPlusTranslationButton;
    @FXML
    private Button cameraZMinusTranslationButton;
    @FXML
    private TextField cameraZTranslationField;
    @FXML
    private Button nearClipMinusButton;
    @FXML
    private Button nearClipPlusButton;
    @FXML
    private TextField nearClipField;
    @FXML
    private Button farClipMinusButton;
    @FXML
    private Button farClipPlusButton;
    @FXML
    private TextField farClipField;
    @FXML
    private Button fieldOfViewMinusButton;
    @FXML
    private Button fieldOfViewPlusButton;
    @FXML
    private TextField fieldOfViewField;
    @FXML
    private Slider headXSlider;
    @FXML
    private Slider headYSlider;
    @FXML
    private Slider headZSlider;
    @FXML
    private Slider upperBodyXSlider;
    @FXML
    private Slider upperBodyYSlider;
    @FXML
    private Slider upperBodyZSlider;
    @FXML
    private Slider headOpacitySlider;
    @FXML
    private Slider leftUpperArmXSlider;
    @FXML
    private Slider leftUpperArmYSlider;
    @FXML
    private Slider leftUpperArmZSlider;
    @FXML
    private Slider rightUpperArmXSlider;
    @FXML
    private Slider rightUpperArmYSlider;
    @FXML
    private Slider rightUpperArmZSlider;
    @FXML
    private Slider leftForeArmXSlider;
    @FXML
    private Slider leftForeArmYSlider;
    @FXML
    private Slider leftForeArmZSlider;
    @FXML
    private Slider leftWristXSlider;
    @FXML
    private Slider leftWristYSlider;
    @FXML
    private Slider leftWristZSlider;
    @FXML
    private Slider leftFinger1XSlider;
    @FXML
    private Slider leftFinger1YSlider;
    @FXML
    private Slider leftFinger1ZSlider;
    @FXML
    private Slider leftFinger2XSlider;
    @FXML
    private Slider leftFinger2YSlider;
    @FXML
    private Slider leftFinger2ZSlider;
    @FXML
    private Slider leftFinger3XSlider;
    @FXML
    private Slider leftFinger3YSlider;
    @FXML
    private Slider leftFinger3ZSlider;
    @FXML
    private Slider leftFinger4XSlider;
    @FXML
    private Slider leftFinger4YSlider;
    @FXML
    private Slider leftFinger4ZSlider;
    @FXML
    private Slider rightWristXSlider;
    @FXML
    private Slider rightWristYSlider;
    @FXML
    private Slider rightWristZSlider;
    @FXML
    private Slider rightFinger1XSlider;
    @FXML
    private Slider rightFinger1YSlider;
    @FXML
    private Slider rightFinger1ZSlider;
    @FXML
    private Slider rightFinger2XSlider;
    @FXML
    private Slider rightFinger2YSlider;
    @FXML
    private Slider rightFinger2ZSlider;
    @FXML
    private Slider rightFinger3XSlider;
    @FXML
    private Slider rightFinger3YSlider;
    @FXML
    private Slider rightFinger3ZSlider;
    @FXML
    private Slider rightFinger4XSlider;
    @FXML
    private Slider rightFinger4YSlider;
    @FXML
    private Slider rightFinger4ZSlider;
    @FXML
    public TextField headXRotationField;
    @FXML
    public TextField headYRotationField;
    @FXML
    public TextField headZRotationField;
    @FXML
    public TextField upperBodyXRotationField;
    @FXML
    public TextField upperBodyYRotationField;
    @FXML
    public TextField upperBodyZRotationField;
    @FXML
    public TextField leftUpperArmXRotationField;
    @FXML
    public TextField leftUpperArmYRotationField;
    @FXML
    public TextField leftUpperArmZRotationField;
    @FXML
    public TextField rightUpperArmXRotationField;
    @FXML
    public TextField rightUpperArmYRotationField;
    @FXML
    public TextField rightUpperArmZRotationField;
    @FXML
    public TextField leftForeArmXRotationField;
    @FXML
    public TextField leftForeArmYRotationField;
    @FXML
    public TextField leftForeArmZRotationField;
    @FXML
    public TextField rightForeArmXRotationField;
    @FXML
    public TextField rightForeArmYRotationField;
    @FXML
    public TextField rightForeArmZRotationField;
    @FXML
    public TextField leftWristXRotationField;
    @FXML
    public TextField leftWristYRotationField;
    @FXML
    public TextField leftWristZRotationField;
    @FXML
    public TextField rightWristXRotationField;
    @FXML
    public TextField rightWristYRotationField;
    @FXML
    public TextField rightWristZRotationField;
    @FXML
    public TextField leftFinger1XRotationField;
    @FXML
    public TextField leftFinger1YRotationField;
    @FXML
    public TextField leftFinger1ZRotationField;
    @FXML
    public TextField rightFinger1XRotationField;
    @FXML
    public TextField rightFinger1YRotationField;
    @FXML
    public TextField rightFinger1ZRotationField;
    @FXML
    public TextField leftFinger2XRotationField;
    @FXML
    public TextField leftFinger2YRotationField;
    @FXML
    public TextField leftFinger2ZRotationField;
    @FXML
    public TextField rightFinger2XRotationField;
    @FXML
    public TextField rightFinger2YRotationField;
    @FXML
    public TextField rightFinger2ZRotationField;
    @FXML
    public TextField leftFinger3XRotationField;
    @FXML
    public TextField leftFinger3YRotationField;
    @FXML
    public TextField leftFinger3ZRotationField;
    @FXML
    public TextField rightFinger3XRotationField;
    @FXML
    public TextField rightFinger3YRotationField;
    @FXML
    public TextField rightFinger3ZRotationField;
    @FXML
    public TextField leftFinger4XRotationField;
    @FXML
    public TextField leftFinger4YRotationField;
    @FXML
    public TextField leftFinger4ZRotationField;
    @FXML
    public TextField rightFinger4XRotationField;
    @FXML
    public TextField rightFinger4YRotationField;
    @FXML
    public TextField rightFinger4ZRotationField;
    @FXML
    public TextField downBodyXRotationField;
    @FXML
    public TextField downBodyYRotationField;
    @FXML
    public TextField downBodyZRotationField;
    @FXML
    public TextField leftUpperLegXRotationField;
    @FXML
    public TextField leftUpperLegYRotationField;
    @FXML
    public TextField leftUpperLegZRotationField;
    @FXML
    public TextField rightUpperLegXRotationField;
    @FXML
    public TextField rightUpperLegYRotationField;
    @FXML
    public TextField rightUpperLegZRotationField;
    @FXML
    public TextField leftForeLegXRotationField;
    @FXML
    public TextField leftForeLegYRotationField;
    @FXML
    public TextField leftForeLegZRotationField;
    @FXML
    public TextField rightForeLegXRotationField;
    @FXML
    public TextField rightForeLegYRotationField;
    @FXML
    public TextField rightForeLegZRotationField;
    
    @FXML
    private Slider hairOpacitySlider;
    @FXML
    private Slider bodyOpacitySlider;
    @FXML
    private Slider limbsOpacitySlider;
    @FXML
    private Slider shoesOpacitySlider;
    @FXML
    private Slider lipsOpacitySlider;
    @FXML
    private Slider eyeOpacitySlider;
    @FXML
    private Slider browOpacitySlider;
    @FXML
    private Slider noseOpacitySlider;
    @FXML
    private Slider rightForeArmXSlider;
    @FXML
    private Slider rightForeArmYSlider;
    @FXML
    private Slider rightForeArmZSlider;
    @FXML
    private Slider downBodyYSlider;
    @FXML
    private Slider rightUpperLegXSlider;
    @FXML
    private Slider rightUpperLegYSlider;
    @FXML
    private Slider rightUpperLegZSlider;
    @FXML
    private Slider rightForeLegXSlider;
    @FXML
    private Slider rightForeLegYSlider;
    @FXML
    private Slider rightForeLegZSlider;
    @FXML
    private Slider leftUpperLegXSlider;
    @FXML
    private Slider leftUpperLegYSlider;
    @FXML
    private Slider leftUpperLegZSlider;
    @FXML
    private Slider leftForeLegXSlider;
    @FXML
    private Slider leftForeLegYSlider;
    @FXML
    private Slider leftForeLegZSlider;
    

    @FXML
    private ImageView bg1;
    @FXML
    private ImageView bg2;
    @FXML
    private ImageView bg3;
    @FXML
    private ImageView bg4;
    @FXML
    private ImageView bg5;
    @FXML
    private ImageView bg6;

    private final ArrayList<String> mStickmanComboList = new ArrayList<>();

    public boolean isCameraStarted = false;
    private String mStickmancombobox = null;
    private ToggleGroup perlinNoiseGroup;
    private StickmansOnStage mStickmanOnstage;

    double xRotateFactor;
    double yRotateFactor;
    double zRotateFactor;

    public Stickman3D currentStickman;
    public static RadioButton currentRadioButton;
    private StickmanStage3D stage3D;

    @FXML
    public void initialize() {
        //Select a stickmanSwing
        StickmanComboBox.setOnAction((event)
                -> {
            mStickmancombobox = StickmanComboBox.getSelectionModel().getSelectedItem();
            currentStickman = (Stickman3D) mStickmanOnstage.getStickman(mStickmancombobox);
        });

        fillEmotionScrollPane();
        fillGestureScrollPane();
        fillHeadScrollPane();
        fillEnvironmentScrollPane();
        fillPostureScrollPane();

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
        SliderHelper.handleUpperBodySlider(this, upperBodyXSlider, "X");
        SliderHelper.handleUpperBodySlider(this, upperBodyYSlider, "Y");
        SliderHelper.handleUpperBodySlider(this, upperBodyZSlider, "Z");
        SliderHelper.handleUpperArmSlider(this, leftUpperArmXSlider, "X", "L", 0);
        SliderHelper.handleUpperArmSlider(this, leftUpperArmYSlider, "Y", "L", 0);
        SliderHelper.handleUpperArmSlider(this, leftUpperArmZSlider, "Z", "L", -10);
        SliderHelper.handleUpperArmSlider(this, rightUpperArmXSlider, "X", "R", 0);
        SliderHelper.handleUpperArmSlider(this, rightUpperArmYSlider, "Y", "R", 0);
        SliderHelper.handleUpperArmSlider(this, rightUpperArmZSlider, "Z", "R", 10);
        SliderHelper.handleForeArmSlider(this, leftForeArmXSlider, "X", "L", -15);
        SliderHelper.handleForeArmSlider(this, leftForeArmYSlider, "Y", "L", 0);
        SliderHelper.handleForeArmSlider(this, leftForeArmZSlider, "Z", "L", 10);
        SliderHelper.handleForeArmSlider(this, rightForeArmXSlider, "X", "R", -15);
        SliderHelper.handleForeArmSlider(this, rightForeArmYSlider, "Y", "R", 0);
        SliderHelper.handleForeArmSlider(this, rightForeArmZSlider, "Z", "R", -10);
        SliderHelper.handleWristSlider(this, leftWristXSlider, "X", "L", 0);
        SliderHelper.handleWristSlider(this, leftWristYSlider, "Y", "L", -50);
        SliderHelper.handleWristSlider(this, leftWristZSlider, "Z", "L", 0);
        SliderHelper.handleWristSlider(this, rightWristXSlider, "X", "R", 0);
        SliderHelper.handleWristSlider(this, rightWristYSlider, "Y", "R", 50);
        SliderHelper.handleWristSlider(this, rightWristZSlider, "Z", "R", 0);
        SliderHelper.handleFinger1Slider(this, leftFinger1XSlider, "X", "L", 0);
        SliderHelper.handleFinger1Slider(this, leftFinger1YSlider, "Y", "L", 0);
        SliderHelper.handleFinger1Slider(this, leftFinger1ZSlider, "Z", "L", 20);
        SliderHelper.handleFinger1Slider(this, rightFinger1XSlider, "X", "R", 0);
        SliderHelper.handleFinger1Slider(this, rightFinger1YSlider, "Y", "R", 0);
        SliderHelper.handleFinger1Slider(this, rightFinger1ZSlider, "Z", "R", -20);
        SliderHelper.handleFinger2Slider(this, leftFinger2XSlider, "X", "L");
        SliderHelper.handleFinger2Slider(this, leftFinger2YSlider, "Y", "L");
        SliderHelper.handleFinger2Slider(this, leftFinger2ZSlider, "Z", "L");
        SliderHelper.handleFinger2Slider(this, rightFinger2XSlider, "X", "R");
        SliderHelper.handleFinger2Slider(this, rightFinger2YSlider, "Y", "R");
        SliderHelper.handleFinger2Slider(this, rightFinger2ZSlider, "Z", "R");
        SliderHelper.handleFinger3Slider(this, leftFinger3XSlider, "X", "L");
        SliderHelper.handleFinger3Slider(this, leftFinger3YSlider, "Y", "L");
        SliderHelper.handleFinger3Slider(this, leftFinger3ZSlider, "Z", "L");
        SliderHelper.handleFinger3Slider(this, rightFinger3XSlider, "X", "R");
        SliderHelper.handleFinger3Slider(this, rightFinger3YSlider, "Y", "R");
        SliderHelper.handleFinger3Slider(this, rightFinger3ZSlider, "Z", "R");
        SliderHelper.handleFinger4Slider(this, leftFinger4XSlider, "X", "L");
        SliderHelper.handleFinger4Slider(this, leftFinger4YSlider, "Y", "L");
        SliderHelper.handleFinger4Slider(this, leftFinger4ZSlider, "Z", "L");
        SliderHelper.handleFinger4Slider(this, rightFinger4XSlider, "X", "R");
        SliderHelper.handleFinger4Slider(this, rightFinger4YSlider, "Y", "R");
        SliderHelper.handleFinger4Slider(this, rightFinger4ZSlider, "Z", "R");
        SliderHelper.handleDownBodySlider(this, downBodyYSlider, "Y");
        SliderHelper.handleUpperLegSlider(this, rightUpperLegXSlider, "X", "R");
        SliderHelper.handleUpperLegSlider(this, rightUpperLegYSlider, "Y", "R");
        SliderHelper.handleUpperLegSlider(this, rightUpperLegZSlider, "Z", "R");
        SliderHelper.handleUpperLegSlider(this, leftUpperLegXSlider, "X", "L");
        SliderHelper.handleUpperLegSlider(this, leftUpperLegYSlider, "Y", "L");
        SliderHelper.handleUpperLegSlider(this, leftUpperLegZSlider, "Z", "L");
        SliderHelper.handleForeLegSlider(this, rightForeLegXSlider, "X", "R");
        SliderHelper.handleForeLegSlider(this, rightForeLegYSlider, "Y", "R");
        SliderHelper.handleForeLegSlider(this, rightForeLegZSlider, "Z", "R");
        SliderHelper.handleForeLegSlider(this, leftForeLegXSlider, "X", "L");
        SliderHelper.handleForeLegSlider(this, leftForeLegYSlider, "Y", "L");
        SliderHelper.handleForeLegSlider(this, leftForeLegZSlider, "Z", "L");
        
        OpacityHelper.headOpacityChanger(this, headOpacitySlider);
        OpacityHelper.hairOpacityChanger(this, hairOpacitySlider);
        OpacityHelper.bodyOpacityChanger(this, bodyOpacitySlider);
        OpacityHelper.limbsOpacityChanger(this, limbsOpacitySlider);
        OpacityHelper.shoesOpacityChanger(this, shoesOpacitySlider);
        OpacityHelper.lipsOpacityChanger(this, lipsOpacitySlider);
        OpacityHelper.eyeOpacityChanger(this, eyeOpacitySlider);
        OpacityHelper.browOpacityChanger(this, browOpacitySlider);
        OpacityHelper.noseOpacityChanger(this, noseOpacitySlider);

        ExitButton.setOnAction((ActionEvent event) -> {
//            Stage stage = (Stage) ExitButton.getScene().getWindow();
//            stage.close();
//            System.exit(0);
            CommandReceiver cr = new CommandReceiver(currentStickman);
            cr.start();
        });
    }

    public Stickman3D getStickmanAsFx(String mStickmancombobox) {
        return (Stickman3D) mStickmanOnstage.getStickman(mStickmancombobox);
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
    private void handleBG1() {
        String background1 = getClass().getClassLoader().getResource("Images/bg1.jpg").toExternalForm();
        stage3D.getmStickmanHBox().setStyle("-fx-background-image: url('" + background1 + "'); "
                + "-fx-background-position: center center; " + "-fx-background-repeat: stretch;");
    }

    @FXML
    private void handleBG2() {
        String background2 = getClass().getClassLoader().getResource("Images/bg2.jpg").toExternalForm();
        stage3D.getmStickmanHBox().setStyle("-fx-background-image: url('" + background2 + "'); "
                + "-fx-background-position: center center; " + "-fx-background-repeat: stretch;");
    }

    @FXML
    private void handleBG3() {
        String background3 = getClass().getClassLoader().getResource("Images/bg3.jpg").toExternalForm();
        stage3D.getmStickmanHBox().setStyle("-fx-background-image: url('" + background3 + "'); "
                + "-fx-background-position: center center; " + "-fx-background-repeat: stretch;");
    }

    @FXML
    private void handleBG4() {
        String background4 = getClass().getClassLoader().getResource("Images/bg4.jpg").toExternalForm();
        stage3D.getmStickmanHBox().setStyle("-fx-background-image: url('" + background4 + "'); "
                + "-fx-background-position: center center; " + "-fx-background-repeat: stretch;");
    }

    @FXML
    private void handleBG5() {
        String background5 = getClass().getClassLoader().getResource("Images/bg5.jpg").toExternalForm();
        stage3D.getmStickmanHBox().setStyle("-fx-background-image: url('" + background5 + "'); "
                + "-fx-background-position: center center; " + "-fx-background-repeat: stretch;");
    }

    @FXML
    private void handleBG6() {
        String bgDefault = getClass().getClassLoader().getResource("Images/bgDefault.png").toExternalForm();
        stage3D.getmStickmanHBox().setStyle("-fx-background-image: url('" + bgDefault + "'); "
                + "-fx-background-position: center center; " + "-fx-background-repeat: stretch;");
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
    public void handleHeadColor() {
        ColorHelper.headColorChanger(currentStickman, headColorPicker);
    }

    @FXML
    public void handleHairColor() {
        ColorHelper.hairColorChanger(currentStickman, hairColorPicker);
    }

    @FXML
    public void handleBodyColor() {
        ColorHelper.bodyColorChanger(currentStickman, bodyColorPicker);
    }

    @FXML
    public void handleLimbsColor() {
        ColorHelper.limbsColorChanger(currentStickman, limbsColorPicker);
    }

    @FXML
    public void handleShoesColor() {
        ColorHelper.shoesColorChanger(currentStickman, shoesColorPicker);
    }

    @FXML
    public void handleLipsColor() {
        ColorHelper.lipsColorChanger(currentStickman, lipsColorPicker);
    }

    @FXML
    public void handleEyeColor() {
        ColorHelper.eyeColorChanger(currentStickman, eyeColorPicker);
    }

    @FXML
    public void handleBrowColor() {
        ColorHelper.browColorChanger(currentStickman, browColorPicker);
    }

    @FXML
    public void handleNoseColor() {
        ColorHelper.noseColorChanger(currentStickman, noseColorPicker);
    }

    @FXML
    public void handleHeadColorButtons(MouseEvent ev) {
        ColorHelper.handleHeadColorButtons(currentStickman, ev, headColorBrighter, headColorDarker, headColorReset);
    }

    @FXML
    public void handleHairColorButtons(MouseEvent ev) {
        ColorHelper.handleHairColorButtons(currentStickman, ev, hairColorBrighter, hairColorDarker, hairColorReset);
    }

    @FXML
    public void handleBodyColorButtons(MouseEvent ev) {
        ColorHelper.handleBodyColorButtons(currentStickman, ev, bodyColorBrighter, bodyColorDarker, bodyColorReset);
    }

    @FXML
    public void handleLimbsColorButtons(MouseEvent ev) {
        ColorHelper.handlelimbsColorButtons(currentStickman, ev, limbsColorBrighter, limbsColorDarker, limbsColorReset);
    }

    @FXML
    public void handleShoesColorButtons(MouseEvent ev) {
        ColorHelper.handleShoesColorButtons(currentStickman, ev, shoesColorBrighter, shoesColorDarker, shoesColorReset);
    }

    @FXML
    public void handleLipsColorButtons(MouseEvent ev) {
        ColorHelper.handleLipsColorButtons(currentStickman, ev, lipsColorBrighter, lipsColorDarker, lipsColorReset);
    }

    @FXML
    public void handleEyeColorButtons(MouseEvent ev) {
        ColorHelper.handleEyeColorButtons(currentStickman, ev, eyeColorBrighter, eyeColorDarker, eyeColorReset);
    }

    @FXML
    public void handleBrowColorButtons(MouseEvent ev) {
        ColorHelper.handleBrowColorButtons(currentStickman, ev, browColorBrighter, browColorDarker, browColorReset);
    }

    @FXML
    public void handleNoseColorButtons(MouseEvent ev) {
        ColorHelper.handleNoseColorButtons(currentStickman, ev, noseColorBrighter, noseColorDarker, noseColorReset);
    }

    private void fillEmotionScrollPane() {
        ArrayList<String> getClassesNames;
        Packageparser parser = new Packageparser(PACKAGE_EMOTIONEXPRESSION);
        getClassesNames = parser.getClassNameList();
        ObservableList<String> classNames = FXCollections.observableArrayList();
        classNames.addAll(getClassesNames.stream().collect(Collectors.toList()));

        createAndHandleRadioButtons(getClassesNames, emotionsScrollPane);
    }

    private void fillGestureScrollPane() {
        ArrayList<String> getClassesNames;
        Packageparser parser = new Packageparser(PACKAGE_GESTURE);
        getClassesNames = parser.getClassNameList();
        ObservableList<String> classNames = FXCollections.observableArrayList();
        classNames.addAll(getClassesNames.stream().collect(Collectors.toList()));

        createAndHandleRadioButtons(getClassesNames, gestureScrollPane);
    }

    private void fillHeadScrollPane() {
        ArrayList<String> getClassesNames;
        Packageparser parser = new Packageparser(PACKAGE_HEAD);
        getClassesNames = parser.getClassNameList();
        ObservableList<String> classNames = FXCollections.observableArrayList();
        classNames.addAll(getClassesNames.stream().collect(Collectors.toList()));

        createAndHandleRadioButtons(getClassesNames, headScrollPane);
    }

    private void fillEnvironmentScrollPane() {
        ArrayList<String> getClassesNames;
        Packageparser parser = new Packageparser(PACKAGE_ENVIRONMENT);
        getClassesNames = parser.getClassNameList();
        ObservableList<String> classNames = FXCollections.observableArrayList();
        classNames.addAll(getClassesNames.stream().collect(Collectors.toList()));

        createAndHandleRadioButtons(getClassesNames, environmentScrollPane);
    }

    private void fillPostureScrollPane() {
        ArrayList<String> getClassesNames;
        Packageparser parser = new Packageparser(PACKAGE_POSTURE);
        getClassesNames = parser.getClassNameList();
        ObservableList<String> classNames = FXCollections.observableArrayList();
        classNames.addAll(getClassesNames.stream().collect(Collectors.toList()));

        createAndHandleRadioButtons(getClassesNames, postureScrollPane);
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
                currentStickman.doAnimation(button.getText(), 500, true);
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
        StickmanComboBox.getItems().clear();
        StickmanComboBox.getItems().addAll(stickmanNames);
        if (!stickmanNames.isEmpty()) {
            StickmanComboBox.setValue(stickmanNames.get(0));
            currentStickman = (Stickman3D) mStickmanOnstage.getStickman(stickmanNames.get(0));
        }
//        mStickmanComboList.clear();
//        mStickmanComboList.addAll(stickmanNames);
    }

    @FXML
    private void handleWithPerlinNoise() {

        currentStickman.doAnimation("StartIdle", 1000, true);

    }

    @FXML
    private void handleWithoutPerlinNoise() {

        currentStickman.doAnimation("StopIdle", 1000, true);
    }

    public StickmanStage3D getStage3D() {
        return stage3D;
    }

    public void setStage3D(StickmanStage3D stage3D) {
        this.stage3D = stage3D;
    }
}
