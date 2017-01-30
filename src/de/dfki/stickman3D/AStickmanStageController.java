/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D;

import de.dfki.common.StickmansOnStage;
import de.dfki.stickman3D.stage.StickmanStage3D;
import de.dfki.stickman3D.xmlsettings.StickmanData3D;
import java.util.ArrayList;
import java.util.List;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author EmpaT
 */
public abstract class AStickmanStageController {
    public static final String PACKAGE_EMOTIONEXPRESSION = "de.dfki.stickman3D.animation.face";
    public static final String PACKAGE_GESTURE = "de.dfki.stickman3D.animation.gesture";
    public static final String PACKAGE_HEAD = "de.dfki.stickman3D.animation.head";
    public static final String PACKAGE_ENVIRONMENT = "de.dfki.stickman3D.animation.environment";
    public static final String PACKAGE_POSTURE = "de.dfki.stickman3D.animation.posture";
    public static final String PACKAGE_DYNAMIC_CLASSES = "de.dfki.stickman3D.dynamic.classes";

    @FXML
    public RadioButton WithPerlinNoise;
    @FXML
    public RadioButton WithoutPerlinNoise;
    @FXML
    public ComboBox<String> StickmanComboBox;
    @FXML
    public ComboBox<String> EmotionExpressionComboBox;
    @FXML
    public Button SaveButton;
    @FXML
    public Button ExitButton;
    @FXML
    Button startCamera;
    @FXML
    Button stopCamera;
    @FXML
    Button resetCamera;
    @FXML
    public ColorPicker headColorPicker;
    @FXML
    public ColorPicker hairColorPicker;
    @FXML
    public ColorPicker bodyColorPicker;
    @FXML
    public ColorPicker limbsColorPicker;
    @FXML
    public ColorPicker shoesColorPicker;
    @FXML
    public ColorPicker lipsColorPicker;
    @FXML
    public ColorPicker eyeColorPicker;
    @FXML
    public ColorPicker browColorPicker;
    @FXML
    public ColorPicker noseColorPicker;
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
    public Button headColorReset;
    @FXML
    public Button headColorBrighter;
    @FXML
    public Button headColorDarker;
    @FXML
    public Button hairColorReset;
    @FXML
    public Button hairColorBrighter;
    @FXML
    public Button hairColorDarker;
    @FXML
    public Button bodyColorReset;
    @FXML
    public Button bodyColorBrighter;
    @FXML
    public Button bodyColorDarker;
    @FXML
    public Button limbsColorReset;
    @FXML
    public Button limbsColorBrighter;
    @FXML
    public Button limbsColorDarker;
    @FXML
    public Button shoesColorReset;
    @FXML
    public Button shoesColorBrighter;
    @FXML
    public Button shoesColorDarker;
    @FXML
    public Button lipsColorReset;
    @FXML
    public Button lipsColorBrighter;
    @FXML
    public Button lipsColorDarker;
    @FXML
    public Button eyeColorReset;
    @FXML
    public Button eyeColorBrighter;
    @FXML
    public Button eyeColorDarker;
    @FXML
    public Button browColorReset;
    @FXML
    public Button browColorBrighter;
    @FXML
    public Button browColorDarker;
    @FXML
    public Button noseColorReset;
    @FXML
    public Button noseColorBrighter;
    @FXML
    public Button noseColorDarker;
    @FXML
    public Slider cameraXSlider;
    @FXML
    public Slider cameraYSlider;
    @FXML
    public Slider cameraZSlider;
    @FXML
    public Button cameraXPlusTranslationButton;
    @FXML
    public Button cameraXMinusTranslationButton;
    @FXML
    public TextField cameraXTranslationField;
    @FXML
    public Button cameraYPlusTranslationButton;
    @FXML
    public Button cameraYMinusTranslationButton;
    @FXML
    public TextField cameraYTranslationField;
    @FXML
    public Button cameraZPlusTranslationButton;
    @FXML
    public Button cameraZMinusTranslationButton;
    @FXML
    public TextField cameraZTranslationField;
    @FXML
    public Button nearClipMinusButton;
    @FXML
    public Button nearClipPlusButton;
    @FXML
    public TextField nearClipField;
    @FXML
    public Button farClipMinusButton;
    @FXML
    public Button farClipPlusButton;
    @FXML
    public TextField farClipField;
    @FXML
    public Button fieldOfViewMinusButton;
    @FXML
    public Button fieldOfViewPlusButton;
    @FXML
    public TextField fieldOfViewField;
    @FXML
    public Slider headXSlider;
    @FXML
    public Slider headYSlider;
    @FXML
    public Slider headZSlider;
    @FXML
    public Slider upperBodyXSlider;
    @FXML
    public Slider upperBodyYSlider;
    @FXML
    public Slider upperBodyZSlider;
    @FXML
    public Slider headOpacitySlider;
    @FXML
    public Slider leftUpperArmXSlider;
    @FXML
    public Slider leftUpperArmYSlider;
    @FXML
    public Slider leftUpperArmZSlider;
    @FXML
    public Slider rightUpperArmXSlider;
    @FXML
    public Slider rightUpperArmYSlider;
    @FXML
    public Slider rightUpperArmZSlider;
    @FXML
    public Slider leftForeArmXSlider;
    @FXML
    public Slider leftForeArmYSlider;
    @FXML
    public Slider leftForeArmZSlider;
    @FXML
    public Slider leftWristXSlider;
    @FXML
    public Slider leftWristYSlider;
    @FXML
    public Slider leftWristZSlider;
    @FXML
    public Slider leftFinger1XSlider;
    @FXML
    public Slider leftFinger1YSlider;
    @FXML
    public Slider leftFinger1ZSlider;
    @FXML
    public Slider leftFinger2XSlider;
    @FXML
    public Slider leftFinger2YSlider;
    @FXML
    public Slider leftFinger2ZSlider;
    @FXML
    public Slider leftFinger3XSlider;
    @FXML
    public Slider leftFinger3YSlider;
    @FXML
    public Slider leftFinger3ZSlider;
    @FXML
    public Slider leftFinger4XSlider;
    @FXML
    public Slider leftFinger4YSlider;
    @FXML
    public Slider leftFinger4ZSlider;
    @FXML
    public Slider rightWristXSlider;
    @FXML
    public Slider rightWristYSlider;
    @FXML
    public Slider rightWristZSlider;
    @FXML
    public Slider rightFinger1XSlider;
    @FXML
    public Slider rightFinger1YSlider;
    @FXML
    public Slider rightFinger1ZSlider;
    @FXML
    public Slider rightFinger2XSlider;
    @FXML
    public Slider rightFinger2YSlider;
    @FXML
    public Slider rightFinger2ZSlider;
    @FXML
    public Slider rightFinger3XSlider;
    @FXML
    public Slider rightFinger3YSlider;
    @FXML
    public Slider rightFinger3ZSlider;
    @FXML
    public Slider rightFinger4XSlider;
    @FXML
    public Slider rightFinger4YSlider;
    @FXML
    public Slider rightFinger4ZSlider;
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
    public Slider hairOpacitySlider;
    @FXML
    public Slider bodyOpacitySlider;
    @FXML
    public Slider limbsOpacitySlider;
    @FXML
    public Slider shoesOpacitySlider;
    @FXML
    public Slider lipsOpacitySlider;
    @FXML
    public Slider eyeOpacitySlider;
    @FXML
    public Slider browOpacitySlider;
    @FXML
    public Slider noseOpacitySlider;
    @FXML
    public Slider rightForeArmXSlider;
    @FXML
    public Slider rightForeArmYSlider;
    @FXML
    public Slider rightForeArmZSlider;
    @FXML
    public Slider downBodyYSlider;
    @FXML
    public Slider rightUpperLegXSlider;
    @FXML
    public Slider rightUpperLegYSlider;
    @FXML
    public Slider rightUpperLegZSlider;
    @FXML
    public Slider rightForeLegXSlider;
    @FXML
    public Slider rightForeLegYSlider;
    @FXML
    public Slider rightForeLegZSlider;
    @FXML
    public Slider leftUpperLegXSlider;
    @FXML
    public Slider leftUpperLegYSlider;
    @FXML
    public Slider leftUpperLegZSlider;
    @FXML
    public Slider leftForeLegXSlider;
    @FXML
    public Slider leftForeLegYSlider;
    @FXML
    public Slider leftForeLegZSlider;
    

    @FXML
    public ImageView bg1;
    @FXML
    public ImageView bg2;
    @FXML
    public ImageView bg3;
    @FXML
    public ImageView bg4;
    @FXML
    public ImageView bg5;
    @FXML
    public ImageView bg6;
    
    @FXML
    public Button headRotationTest;
    @FXML 
    public Button headRotationCreate;

    public final ArrayList<String> mStickmanComboList = new ArrayList<>();
    public List<StickmanData3D> mStickmanData3D = new ArrayList<StickmanData3D>();

    public boolean isCameraStarted = false;
    public String mStickmancombobox = null;
    public ToggleGroup perlinNoiseGroup;
    public StickmansOnStage mStickmanOnstage;

    double xRotateFactor;
    double yRotateFactor;
    double zRotateFactor;

    public Stickman3D currentStickman;
    public static RadioButton currentRadioButton;
    public StickmanStage3D stage3D;
    public String backgroundRecord = null;
    
    public AnchorPane classNamePane;
    public AnchorPane testView;  
}
