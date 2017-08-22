/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.reeti;

import de.dfki.common.AgentsOnStage;
import de.dfki.reeti.stage.ReetiStage;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;

/**
 * @author EmpaT
 */
public abstract class AReetiStageController
{

    public static final String PACKAGE_EMOTIONEXPRESSION = "de.dfki.reeti.animation.face";
    public static final String PACKAGE_ENVIRONMENT = "de.dfki.reeti.animation.environment";
    public static final String PACKAGE_DYNAMIC_CLASSES = "de.dfki.stickman3D.dynamic.classes";
    public static RadioButton currentRadioButton;
    public final ArrayList<String> mReetiComboList = new ArrayList<>();
    @FXML
    public RadioButton WithPerlinNoise;
    @FXML
    public RadioButton WithoutPerlinNoise;
    @FXML
    public ComboBox<String> reetiComboBox;
    @FXML
    public ComboBox<String> EmotionExpressionComboBox;
    @FXML
    public Button SaveButton;
    @FXML
    public Button ExitButton;
    @FXML
    public Button ledOff;
    @FXML
    public Button cameraXPlusTranslationButton;
    @FXML
    public Button cameraXMinusTranslationButton;
    @FXML
    public Button nearClipMinusButton;
    @FXML
    public Button nearClipPlusButton;
    @FXML
    public Button cameraYPlusTranslationButton;
    @FXML
    public Button cameraYMinusTranslationButton;
    @FXML
    public Button cameraZMinusTranslationButton;
    @FXML
    public Button cameraZPlusTranslationButton;
    @FXML
    public Button farClipMinusButton;
    @FXML
    public Button farClipPlusButton;
    @FXML
    public Button fieldOfViewMinusButton;
    @FXML
    public Button fieldOfViewPlusButton;
    @FXML
    public Button startCamera;
    @FXML
    public Button stopCamera;
    @FXML
    public Button resetCamera;
    @FXML
    public Button btnTimeline;
    @FXML
    public ColorPicker leftLedColorPicker;
    @FXML
    public ColorPicker rightLedColorPicker;
    @FXML
    public ColorPicker bothLedColorPicker;
    @FXML
    public ScrollPane emotionsScrollPane;
    @FXML
    public ScrollPane environmentScrollPane;
    @FXML
    public TextField cameraXTranslationField;
    @FXML
    public TextField cameraYTranslationField;
    @FXML
    public TextField cameraZTranslationField;
    @FXML
    public TextField nearClipField;
    @FXML
    public TextField farClipField;
    @FXML
    public TextField fieldOfViewField;
    @FXML
    public TextField headXRotationField;
    @FXML
    public TextField headYRotationField;
    @FXML
    public TextField headZRotationField;
    @FXML
    public TextField leftEyeXRotationField;
    @FXML
    public TextField leftEyeYRotationField;
    @FXML
    public TextField rightEyeXRotationField;
    @FXML
    public TextField rightEyeYRotationField;
    @FXML
    public TextField leftEyeLidXRotationField;
    @FXML
    public TextField rightEyeLidXRotationField;
    @FXML
    public TextField rightEarRotationField;
    @FXML
    public TextField leftLCRotationField;
    @FXML
    public TextField rightLCRotationField;
    @FXML
    public TextField topLipRotationField;
    @FXML
    public TextField bottomLipRotationField;
    @FXML
    public Slider cameraXSlider;
    @FXML
    public TextField leftEarRotationField;
    @FXML
    public Slider cameraYSlider;
    @FXML
    public Slider cameraZSlider;
    @FXML
    public Slider headXSlider;
    @FXML
    public Slider headYSlider;
    @FXML
    public Slider headZSlider;
    @FXML
    public Slider leftEyeXSlider;
    @FXML
    public Slider leftEyeYSlider;
    @FXML
    public Slider rightEyeXSlider;
    @FXML
    public Slider rightEyeYSlider;
    @FXML
    public Slider leftEyeLidXSlider;
    @FXML
    public Slider rightEyeLidXSlider;
    @FXML
    public Slider leftEarSlider;
    @FXML
    public Slider rightEarSlider;
    @FXML
    public Slider leftLCSlider;
    @FXML
    public Slider rightLCSlider;
    @FXML
    public Slider topLipSlider;
    @FXML
    public Slider bottomLipSlider;
    public boolean isCameraStarted = false;
    public String mReetiComboBox = null;
    public ToggleGroup perlinNoiseGroup;
    public AgentsOnStage mStickmanOnstage;
    public Reeti currentReeti;
    public ReetiStage stage3D;

}
