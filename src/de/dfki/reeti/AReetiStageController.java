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
//    public static final String PACKAGE_GESTURE = "de.dfki.reeti.animation.gesture";
    public static final String PACKAGE_HEAD = "de.dfki.reeti.animation.head";
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
    Button startCamera;
    @FXML
    Button stopCamera;
    @FXML
    Button resetCamera;
    @FXML
    public ColorPicker leftLedColorPicker;
    @FXML
    public ColorPicker rightLedColorPicker;
    @FXML
    public ColorPicker bothLedColorPicker;
    @FXML
    public Button leftLedOffButton;
    @FXML
    public Button rightLedOffButton;
    @FXML
    public Button bothLedOffButton;
    @FXML
    ScrollPane emotionsScrollPane;
    @FXML
    ScrollPane gestureScrollPane;
    @FXML
    ScrollPane headScrollPane;
    @FXML
    ScrollPane environmentScrollPane;
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
    public TextField headXRotationField;
    @FXML
    public TextField headYRotationField;
    @FXML
    public TextField headZRotationField;
    @FXML
    public Label recCounter0;
    @FXML
    public Button headRotationTest;
    @FXML
    public Button headRotationCreate;

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
