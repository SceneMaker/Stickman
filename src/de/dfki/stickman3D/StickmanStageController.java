package de.dfki.stickman3D;

import de.dfki.common.Gender;
import de.dfki.common.StickmansOnStage;
import de.dfki.common.commonFX3D.ViewController;
import de.dfki.stickman3D.controllerhelper.ColorHelper;
import de.dfki.stickman3D.controllerhelper.OpacityHelper;
import de.dfki.stickman3D.controllerhelper.SliderHelper;
import de.dfki.stickman3D.dynamic.classes.DynamicCompiler;
import de.dfki.stickman3D.dynamic.classes.Helper;
import de.dfki.stickman3D.stage.StickmanStage3D;
import de.dfki.stickman3D.stage.StickmansOnStage3D;
import de.dfki.stickman3D.xmlsettings.StickmanData3D;
import javafx.application.Platform;
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
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;

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
    private static final String PACKAGE_DYNAMIC_CLASSES = "de.dfki.stickman3D.dynamic.classes";

    @FXML
    private RadioButton WithPerlinNoise;
    @FXML
    private RadioButton WithoutPerlinNoise;
    @FXML
    private ComboBox<String> StickmanComboBox;
    @FXML
    private ComboBox<String> EmotionExpressionComboBox;
    @FXML
    private Button SaveButton;
    @FXML
    private Button ExitButton;
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
    
    @FXML
    private Button headRotationTest;
    @FXML 
    private Button headRotationCreate;

    private final ArrayList<String> mStickmanComboList = new ArrayList<>();
    private List<StickmanData3D> mStickmanData3D = new ArrayList<StickmanData3D>();

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
    private String backgroundRecord = null;
    
    private AnchorPane classNamePane;
    private AnchorPane testView;

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
        
        String background1 = getClass().getClassLoader().getResource("Images/bg1.jpg").toExternalForm();
        bg1.setImage(new Image(background1));
        
        String background2 = getClass().getClassLoader().getResource("Images/bg2.jpg").toExternalForm();
        bg2.setImage(new Image(background2));
        
        String background3 = getClass().getClassLoader().getResource("Images/bg3.jpg").toExternalForm();
        bg3.setImage(new Image(background3));
        
        String background4 = getClass().getClassLoader().getResource("Images/bg4.jpg").toExternalForm();
        bg4.setImage(new Image(background4));
        
        String background5 = getClass().getClassLoader().getResource("Images/bg5.jpg").toExternalForm();
        bg5.setImage(new Image(background5));
        
        String background6 = getClass().getClassLoader().getResource("Images/bg6.jpg").toExternalForm();
        bg6.setImage(new Image(background6));

        ExitButton.setOnAction((ActionEvent event) -> {
            Stage stage = (Stage) ExitButton.getScene().getWindow();
            stage.close();
            System.exit(0);
//            CommandReceiver cr = new CommandReceiver(currentStickman, this);
//            cr.start();
        });
        
        SaveButton.setOnAction((ActionEvent event) -> {
	    if (((null != mStickmanComboList) && (!mStickmanComboList.isEmpty()))) {
		Platform.runLater(() -> {
		    mStickmanData3D.clear();
		    for (String key : mStickmanComboList) {
			String name = key;
			String bodyColor;
			String hairColor;
			String headColor;
			String limbsColor;
			String shoesColor;
			String lipsColor;
			String eyesColor;
			String browsColor;
			String nosesColor;
			Stickman3D mStick = getStickmanAs3D(key);
			bodyColor = toHexCode(mStick.mUpperBody.mColor);

			if (mStick.mType == Gender.TYPE.MALE) {
			    hairColor = toHexCode(mStick.mMaleHairFX.mColor);
			} else {
			    hairColor = toHexCode(mStick.mFemaleHairFX.mColor);
			}

			headColor = toHexCode(mStick.mHeadFX.mColor);
			shoesColor = toHexCode(mStick.mLeftFootFX.mColor);
			lipsColor = toHexCode(mStick.mMouthFX.mColor);
			eyesColor = toHexCode(mStick.mLeftEyeFX.mColor);
			browsColor = toHexCode(mStick.mLeftEyebrowFX.mColor);
			nosesColor = toHexCode(mStick.mNoseFX.mColor);
			limbsColor = toHexCode(mStick.mLeftUpperArmFX.mColor);

			mStickmanData3D.add(new StickmanData3D(name, hairColor, headColor, bodyColor, limbsColor,
				shoesColor, lipsColor, eyesColor, browsColor, nosesColor, backgroundRecord));
		    }
		    ((StickmansOnStage3D) mStickmanOnstage).getmXmlTransform().loadStickmanData3DList(mStickmanData3D);
		    // StickmanOnstage.getmXmlTransform().loadStickmanDataFXList(mStickmanDataFX);
		    handleSave();
		});
	    }
	});
    }
    
    @FXML
    private void handleRecord(MouseEvent event)
    {
        Helper.switchRecordID(((Button)event.getSource()).getId(), this);
        System.out.println(DynamicCompiler.methodContent);
    }
    
    @FXML
    private void handleCreate()
    {
        Stage stage = new Stage();
         
        try {
            classNamePane = FXMLLoader.load(Helper.class.getResource("ClassNameView.fxml"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initOwner(ExitButton.getScene().getWindow());
        
        Scene scene = new Scene(classNamePane, 400, 140);
        stage.setScene(scene);
        stage.show();
        
        Button OKButton = (Button) classNamePane.getChildren().get(2);
        OKButton.setOnMouseClicked((event) -> {
            String name = ((TextField)classNamePane.getChildren().get(0)).getText();
            
            DynamicCompiler.currentStickman = this.currentStickman;
            DynamicCompiler.setClassName(name);
            DynamicCompiler.create();
            stage.close();
        });
    }
    
    @FXML
    private void handleTest() throws IOException
    {
        Helper.resetAllRotation(this);
        Packageparser parser = new Packageparser(PACKAGE_DYNAMIC_CLASSES);
        ArrayList<String> list = parser.getClassNameList();
        
        Stage stage = new Stage();
        testView = FXMLLoader.load(Helper.class.getResource("testView.fxml"));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initOwner(ExitButton.getScene().getWindow());
        
        Scene scene = new Scene(testView, 400, 140);
        stage.setScene(scene);
        
        
        ComboBox<String> existClasses = (ComboBox<String>) testView.getChildren().get(1);
        
        
        for(int i = 0; i<list.size(); i++)
        {
            existClasses.getItems().add(list.get(i));
        }
        
        existClasses.valueProperty().addListener((observable, oldValue, newValue) -> {
            DynamicCompiler.currentStickman = currentStickman;
            DynamicCompiler.runIt(newValue);
            stage.close();
            
        });
        stage.show(); 
    }

    public Stickman3D getStickmanAs3D(String mStickmancombobox) {
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
    public void handleBG1() {
        String background1 = getClass().getClassLoader().getResource("Images/bg1.jpg").toExternalForm();
        stage3D.getmStickmanHBox().setStyle("-fx-background-image: url('" + background1 + "'); "
                + "-fx-background-position: center center; " + "-fx-background-repeat: stretch;");
        backgroundRecord= "Images/bg1.jpg";
    }

    @FXML
    public void handleBG2() {
        String background2 = getClass().getClassLoader().getResource("Images/bg2.jpg").toExternalForm();
        stage3D.getmStickmanHBox().setStyle("-fx-background-image: url('" + background2 + "'); "
                + "-fx-background-position: center center; " + "-fx-background-repeat: stretch;");
        backgroundRecord= "Images/bg2.jpg";
    }

    @FXML
    public void handleBG3() {
        String background3 = getClass().getClassLoader().getResource("Images/bg3.jpg").toExternalForm();
        stage3D.getmStickmanHBox().setStyle("-fx-background-image: url('" + background3 + "'); "
                + "-fx-background-position: center center; " + "-fx-background-repeat: stretch;");
        backgroundRecord= "Images/bg3.jpg";
    }

    @FXML
    public void handleBG4() {
        String background4 = getClass().getClassLoader().getResource("Images/bg4.jpg").toExternalForm();
        stage3D.getmStickmanHBox().setStyle("-fx-background-image: url('" + background4 + "'); "
                + "-fx-background-position: center center; " + "-fx-background-repeat: stretch;");
        backgroundRecord= "Images/bg4.jpg";
    }

    @FXML
    public void handleBG5() {
        String background5 = getClass().getClassLoader().getResource("Images/bg5.jpg").toExternalForm();
        stage3D.getmStickmanHBox().setStyle("-fx-background-image: url('" + background5 + "'); "
                + "-fx-background-position: center center; " + "-fx-background-repeat: stretch;");
        backgroundRecord= "Images/bg5.jpg";
    }

    @FXML
    public void handleBG6() {
        String bgDefault = getClass().getClassLoader().getResource("Images/bgDefault.png").toExternalForm();
        stage3D.getmStickmanHBox().setStyle("-fx-background-image: url('" + bgDefault + "'); "
                + "-fx-background-position: center center; " + "-fx-background-repeat: stretch;");
        backgroundRecord= "Images/bgDefault.png";
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
        ColorHelper.headColorChanger(this);
    }

    @FXML
    public void handleHairColor() {
        ColorHelper.hairColorChanger(this);
    }

    @FXML
    public void handleBodyColor() {
        ColorHelper.bodyColorChanger(this);
    }

    @FXML
    public void handleLimbsColor() {
        ColorHelper.limbsColorChanger(this);
    }

    @FXML
    public void handleShoesColor() {
        ColorHelper.shoesColorChanger(this);
    }

    @FXML
    public void handleLipsColor() {
        ColorHelper.lipsColorChanger(this);
    }

    @FXML
    public void handleEyeColor() {
        ColorHelper.eyeColorChanger(this);
    }

    @FXML
    public void handleBrowColor() {
        ColorHelper.browColorChanger(this);
    }

    @FXML
    public void handleNoseColor() {
        ColorHelper.noseColorChanger(this);
    }

    @FXML
    public void handleHeadColorButtons(MouseEvent ev) {
        ColorHelper.handleHeadColorButtons(this, ev);
    }

    @FXML
    public void handleHairColorButtons(MouseEvent ev) {
        ColorHelper.handleHairColorButtons(this, ev);
    }

    @FXML
    public void handleBodyColorButtons(MouseEvent ev) {
        ColorHelper.handleBodyColorButtons(this, ev);
    }

    @FXML
    public void handleLimbsColorButtons(MouseEvent ev) {
        ColorHelper.handlelimbsColorButtons(this,  ev);
    }

    @FXML
    public void handleShoesColorButtons(MouseEvent ev) {
        ColorHelper.handleShoesColorButtons(this, ev);
    }

    @FXML
    public void handleLipsColorButtons(MouseEvent ev) {
        ColorHelper.handleLipsColorButtons(this, ev);
    }

    @FXML
    public void handleEyeColorButtons(MouseEvent ev) {
        ColorHelper.handleEyeColorButtons(this, ev);
    }

    @FXML
    public void handleBrowColorButtons(MouseEvent ev) {
        ColorHelper.handleBrowColorButtons(this, ev);
    }

    @FXML
    public void handleNoseColorButtons(MouseEvent ev) {
        ColorHelper.handleNoseColorButtons(this, ev);
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
        mStickmanComboList.clear();
        mStickmanComboList.addAll(stickmanNames);
    }

   
    
    // set the setValue of combobox
    private void setComboboxValue(Stickman3D mStick) {
	bodyColorPicker.setValue(colorWithoutOpacity(mStick.mUpperBody.mColor));
	bodyOpacitySlider.setValue(mStick.mUpperBody.mColor.getOpacity());

	if (mStick.mType == Gender.TYPE.MALE) {
	    hairColorPicker.setValue(colorWithoutOpacity(mStick.mMaleHairFX.mColor));
	    hairOpacitySlider.setValue(mStick.mMaleHairFX.mColor.getOpacity());
	} else {
	    hairColorPicker.setValue(colorWithoutOpacity(mStick.mFemaleHairFX.mColor));
	    hairOpacitySlider.setValue(mStick.mFemaleHairFX.mColor.getOpacity());
	}

	headColorPicker.setValue(colorWithoutOpacity(mStick.mHeadFX.mColor));
	headOpacitySlider.setValue(mStick.mHeadFX.mColor.getOpacity());

	noseColorPicker.setValue(colorWithoutOpacity(mStick.mNoseFX.mColor));
	noseOpacitySlider.setValue(mStick.mNoseFX.mColor.getOpacity());
	System.out.println("NoseOpacity: " + mStick.mNoseFX.mColor.getOpacity());

	browColorPicker.setValue(colorWithoutOpacity(mStick.mLeftEyebrowFX.mColor));
	browOpacitySlider.setValue(mStick.mLeftEyebrowFX.mColor.getOpacity());

	eyeColorPicker.setValue(colorWithoutOpacity(mStick.mLeftEyeFX.mColor));
	eyeOpacitySlider.setValue(mStick.mLeftEyeFX.mColor.getOpacity());

	lipsColorPicker.setValue(colorWithoutOpacity(mStick.mMouthFX.mColor));
	lipsOpacitySlider.setValue(mStick.mMouthFX.mColor.getOpacity());

	shoesColorPicker.setValue(colorWithoutOpacity(mStick.mLeftFootFX.mColor));
	shoesOpacitySlider.setValue(mStick.mLeftFootFX.mColor.getOpacity());

	limbsColorPicker.setValue(colorWithoutOpacity(mStick.mLeftUpperLegFX.mColor));
	limbsOpacitySlider.setValue(mStick.mLeftUpperLegFX.mColor.getOpacity());
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
    
    private void handleSave() {
	File filexml = null;
	if (mStickmanOnstage.getmFilePath() != null) {
	    filexml = new File(mStickmanOnstage.getmFilePath() + File.separator + "stickman3d" + File.separator
		    + "stickman3d.xml");
	} else {
	    try {
		filexml = new File(new File(".").getCanonicalPath() + File.separator + "stickman3d" + File.separator
			+ "stickman3d.xml");
	    } catch (IOException e) {
		e.printStackTrace();
	    }
	}

	if (!filexml.exists()) {
	    filexml.getParentFile().mkdir();
	}

	// Make sure it has the correct extension
	if (!filexml.getPath().endsWith(".xml")) {
	    filexml = new File(filexml.getPath() + ".xml");
	}
	((StickmansOnStage3D) mStickmanOnstage).getmXmlTransform().saveStickmanDataToFile(filexml);
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
