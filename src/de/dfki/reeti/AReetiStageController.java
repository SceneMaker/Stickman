/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.reeti;

import de.dfki.common.StickmansOnStage;
import de.dfki.reeti.stage.ReetiStage;
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author EmpaT
 */
public abstract class AReetiStageController {

    public static final String PACKAGE_EMOTIONEXPRESSION = "de.dfki.reeti.animation.face";
    public static final String PACKAGE_ENVIRONMENT = "de.dfki.reeti.animation.environment";
    public static final String PACKAGE_DYNAMIC_CLASSES = "de.dfki.stickman3D.dynamic.classes";

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
    public Button leftLedOffButton;
    @FXML
    public Button rightLedOffButton;
    @FXML
    public Button bothLedOffButton;
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
    public Button headRotationTest;
    @FXML
    public Button headRotationCreate;
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
    public Slider cameraXSlider;
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

    public final ArrayList<String> mReetiComboList = new ArrayList<>();

    public boolean isCameraStarted = false;
    public String mReetiComboBox = null;
    public ToggleGroup perlinNoiseGroup;
    public StickmansOnStage mStickmanOnstage;

    double xRotateFactor;
    double yRotateFactor;
    double zRotateFactor;

    public Reeti currentReeti;
    public static RadioButton currentRadioButton;
    public ReetiStage stage3D;
    public String backgroundRecord = null;

    public AnchorPane classNamePane;
    public AnchorPane testView;
}
