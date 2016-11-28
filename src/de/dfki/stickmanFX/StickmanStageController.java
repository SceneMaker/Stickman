package de.dfki.stickmanFX;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import de.dfki.common.StickmansOnStage;
import de.dfki.common.commonFX3D.ViewController;
import de.dfki.stickmanFX.stage.StickmanStageFX;
import de.dfki.stickmanFX.stage.StageRoomFX;
import de.dfki.stickmanFX.stage.StickmansOnStageFX;
import de.dfki.stickmanSwing.StickmanSwing;
import de.dfki.stickmanFX.xmlsettings.StickmanDataFX;
import de.dfki.util.HandleColor;
import de.dfki.util.StickmanFillCombo;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

/**
 *
 * @author Robbie
 */
public class StickmanStageController implements ViewController {

    private static String packEmotionExpression = "de.dfki.stickmanFX.animation.facefx";
    private static String packGesture = "de.dfki.stickmanFX.animation.esturefx";
    private ArrayList<String> mStickmanComboList = new ArrayList<>();
    private static StickmanFX sStickman;
    private StickmansOnStage mStickmanOnstage;
    private String mStickmancombobox = null;
    final private ToggleGroup groupPerlin = new ToggleGroup();
    final private ToggleGroup groupEnvironmentRadioButton = new ToggleGroup();
    private String backgroundRecord = null;
    private List<StickmanDataFX> mStickmanDataFX = new ArrayList<StickmanDataFX>();
//    private final static ObservableList<String> backgroundList = FXCollections.observableArrayList("office",
//	    "grassland");

    @FXML
    private Label Stickman;
    @FXML
    private Label BodyColour;
    @FXML
    private Label Environment;
    @FXML
    private Label EmotionExpression;
    @FXML
    private Label IdleSection;
    @FXML
    private Label Posture;
    @FXML
    private Label Background;
    @FXML
    private ColorPicker BackgroundColorPicker;
    @FXML
    private Label ShowEmotionName;

    @FXML
    private RadioButton FadeIn;
    @FXML
    private RadioButton FadeOut;
    @FXML
    private RadioButton GoDown;
    @FXML
    private RadioButton ComeUp;
    @FXML
    private RadioButton DisappearToSmall;
    @FXML
    private RadioButton ComeBackFromSmall;
    @FXML
    private RadioButton Speaking;

    @FXML
    private RadioButton CoverMouth;
    @FXML
    private RadioButton TouchHead;
    @FXML
    private RadioButton WaveLeft;
    @FXML
    private RadioButton WaveRight;

    @FXML
    private RadioButton WithPerlinNoise;
    @FXML
    private RadioButton WithoutPerlinNoise;

    @FXML
    private ComboBox<String> StickmanComboBox;
    @FXML
    private ComboBox<String> HeadComboBoxColor;
    @FXML
    private ComboBox<String> HairComboBoxColor;
    @FXML
    private ComboBox<String> BodyComboBoxColor;
    @FXML
    private ComboBox<String> LimbsComboBoxColor;
    @FXML
    private ComboBox<String> EmotionExpressionComboBox;
    @FXML
    private ComboBox<String> BackgroundComboBoxPic;

    @FXML
    private GridPane gridPaneControlStickman;
    @FXML
    private GridPane gridPaneControlColor;
    @FXML
    private GridPane gridPaneControlEmotion;
    @FXML
    private GridPane gridPaneControlIdleSection;
    @FXML
    private GridPane gridPaneControlEnvironment;
    @FXML
    private GridPane gridPaneControlPosture;
    @FXML
    private GridPane gridPaneControlBackground;
    @FXML
    private HBox StickmanFlowPane;

    @FXML
    private ScrollPane stickmanScrollPane;

    @FXML
    private Button RestButton;
    @FXML
    private Button ExitButton;
    @FXML
    private Button SaveButton;

    @FXML
    public void initialize() {
	setIdForLabel();
	handleGroupForEnvironmentRadioButton();
	HeadComboBoxColor.getItems().addAll("Festucine", "Beige", "Blue", "Black", "Red");
	HairComboBoxColor.getItems().addAll("Saffron Yellow", "Brown", "Yellow", "Beige", "Blue", "Black", "Red",
		"Gold");
	BodyComboBoxColor.getItems().addAll("Purple", "Green", "Beige", "Black", "Yellow", "White");
	LimbsComboBoxColor.getItems().addAll("Black", "Yellow", "White");
	BackgroundComboBoxPic.getItems().addAll(StickmanFX.backgroundList);
	
	// Default show
//	handleStickman();
	handleBodyColour();

	fillComboForEmotionExpression();
	// Select a stickmanSwing
	StickmanComboBox.setOnAction((event) -> {
	    mStickmancombobox = StickmanComboBox.getSelectionModel().getSelectedItem();
	    // set the setValue of combobox
	    setComboboxValue(getStickmanAsFx(mStickmancombobox));
	});
	
	// Show emotion
	EmotionExpressionComboBox.setOnAction((event) -> {
	    String mEmotion = EmotionExpressionComboBox.getSelectionModel().getSelectedItem();

	    if ((mEmotion != null) && (mStickmancombobox != null)) {
		Platform.runLater(() -> {
		    getStickmanAsFx(mStickmancombobox).doAnimation(mEmotion, 70, true);
		    EmotionExpressionComboBox.getSelectionModel().clearSelection();
		    ShowEmotionName.setText(mEmotion);
		});
	    }
	});

	// change bodyColor
	BodyComboBoxColor.setOnAction((event) -> {
	    String color = BodyComboBoxColor.getSelectionModel().getSelectedItem();
	    if ((color != null) && (mStickmancombobox != null)) {
		Platform.runLater(() -> {
		    if (getStickmanAsFx(mStickmancombobox).mType == StickmanSwing.TYPE.MALE) {
			getStickmanAsFx(mStickmancombobox).mBodyFX.mMaleColor = HandleColor.switchColor(color);
			getStickmanAsFx(mStickmancombobox).update();
		    } else {
			getStickmanAsFx(mStickmancombobox).mBodyFX.mFemaleColor = HandleColor.switchColor(color);
			getStickmanAsFx(mStickmancombobox).update();
		    }
		});
	    }

	});

	// change bodyColor
	HairComboBoxColor.setOnAction((event) -> {
	    String color = HairComboBoxColor.getSelectionModel().getSelectedItem();
	    if ((color != null) && (mStickmancombobox != null)) {
		Platform.runLater(() -> {
		    if (getStickmanAsFx(mStickmancombobox).mType == StickmanSwing.TYPE.MALE) {
			getStickmanAsFx(mStickmancombobox).mMaleHairFX.mColor = HandleColor.switchColor(color);
			getStickmanAsFx(mStickmancombobox).update();
		    } else {
			getStickmanAsFx(mStickmancombobox).mFemaleHairFX.mColor = HandleColor.switchColor(color);
			getStickmanAsFx(mStickmancombobox).update();
		    }
		});
	    }

	});

	// change head Color
	HeadComboBoxColor.setOnAction((event) -> {
	    String color = HeadComboBoxColor.getSelectionModel().getSelectedItem();
	    if ((color != null) && (mStickmancombobox != null)) {
		Platform.runLater(() -> {
		    getStickmanAsFx(mStickmancombobox).mHeadFX.mColor = HandleColor.switchColor(color);
		    if (getStickmanAsFx(mStickmancombobox).mHeadFX.mColor != null)
			getStickmanAsFx(mStickmancombobox).update();
		});
	    }
	});

	// change background PICTURE
	BackgroundComboBoxPic.setOnAction((event) -> {
	    String pic = BackgroundComboBoxPic.getSelectionModel().getSelectedItem();
	    if (pic != null) {
		if (StickmanFX.backgroundList.contains(pic)) {
		    Platform.runLater(() -> {
			try {
			    HBox mStickmanPane = ((StickmanStageFX) mStickmanOnstage.getStageStickman())
				    .getStickmanPane((((StageRoomFX) mStickmanOnstage
					    .getStageRoom()).CONFIG_STAGE));
			    mStickmanPane.setStyle("-fx-background-image: url('/de/dfki/stickmanFX/image/" + pic
				    + ".jpg');"
				    + "-fx-background-repeat: repeat;-fx-background-position: center center; -fx-background-size: contain;");
			    backgroundRecord = pic;
			} catch (Exception e) {
			    // TODO Auto-generated catch block
			    e.printStackTrace();
			}
		    });
		}
	    }
	});
	
	// change background COLOUR
	BackgroundColorPicker.setOnAction((event) -> {
	    Color backgroundColor = BackgroundColorPicker.getValue();
		    Platform.runLater(() -> {
			try {
			    HBox mStickmanPane = ((StickmanStageFX) mStickmanOnstage.getStageStickman())
				    .getStickmanPane((((StageRoomFX) mStickmanOnstage
					    .getStageRoom()).CONFIG_STAGE));
			    String hex = toHexCode(backgroundColor);
		            mStickmanPane.setStyle("-fx-background-color: " + hex + ";");
		            backgroundRecord = hex;
			} catch (Exception e) {
			    // TODO Auto-generated catch block
			    e.printStackTrace();
			}
		    });
	});

	// change limbs Color
	LimbsComboBoxColor.setOnAction((event) -> {
	    String color = LimbsComboBoxColor.getSelectionModel().getSelectedItem();
	    if ((color != null) && (mStickmancombobox != null)) {
		Platform.runLater(() -> {
		    // mStickmanOnstage.getStickman(mStickmancombobox).mLeftLegFX.mColor
		    // = switchColor(color);
		    getStickmanAsFx(mStickmancombobox).mLeftUpperLegFX.mColor = HandleColor.switchColor(color);
		    getStickmanAsFx(mStickmancombobox).mLeftForeLegFX.mColor = HandleColor.switchColor(color);
		    getStickmanAsFx(mStickmancombobox).mLeftFootFX.mColor = HandleColor.switchColor(color);
		    // mStickmanOnstage.getStickman(mStickmancombobox).mRightLegFX.mColor
		    // = switchColor(color);
		    getStickmanAsFx(mStickmancombobox).mRightUpperLegFX.mColor = HandleColor.switchColor(color);
		    getStickmanAsFx(mStickmancombobox).mRightForeLegFX.mColor = HandleColor.switchColor(color);
		    getStickmanAsFx(mStickmancombobox).mRightFootFX.mColor = HandleColor.switchColor(color);
		    getStickmanAsFx(mStickmancombobox).mLeftHandFX.mColor = HandleColor.switchColor(color);
		    getStickmanAsFx(mStickmancombobox).mRightHandFX.mColor = HandleColor.switchColor(color);
		    getStickmanAsFx(mStickmancombobox).mLeftShoulderFX.mColor = HandleColor.switchColor(color);
		    getStickmanAsFx(mStickmancombobox).mRightShoulderFX.mColor = HandleColor.switchColor(color);
		    getStickmanAsFx(mStickmancombobox).mLeftUpperArmFX.mColor = HandleColor.switchColor(color);
		    getStickmanAsFx(mStickmancombobox).mLeftForeArmFX.mColor = HandleColor.switchColor(color);
		    getStickmanAsFx(mStickmancombobox).mRightUpperArmFX.mColor = HandleColor.switchColor(color);
		    getStickmanAsFx(mStickmancombobox).mRightForeArmFX.mColor = HandleColor.switchColor(color);
		    getStickmanAsFx(mStickmancombobox).mNeckFX.mColor = HandleColor.switchColor(color);
		    getStickmanAsFx(mStickmancombobox).update();
		});
	    }
	});

	// set the color to default value
	RestButton.setOnAction(new EventHandler<ActionEvent>() {
	    @Override
	    public void handle(ActionEvent event) {
		if ((mStickmancombobox != null)) {
		    Platform.runLater(() -> {
			if (getStickmanAsFx(mStickmancombobox).mType == StickmanSwing.TYPE.MALE) {
			    HeadComboBoxColor.setValue("Festucine");
			    HairComboBoxColor.setValue("Brown");
			    BodyComboBoxColor.setValue("Green");
			    LimbsComboBoxColor.setValue("Black");
			} else {
			    HeadComboBoxColor.setValue("Festucine");
			    HairComboBoxColor.setValue("Saffron Yellow");
			    BodyComboBoxColor.setValue("Purple");
			    LimbsComboBoxColor.setValue("Black");
			}
		    });

		    if ((groupEnvironmentRadioButton.getSelectedToggle() != null)) {
			String action = groupEnvironmentRadioButton.getSelectedToggle().getUserData().toString();
			Platform.runLater(() -> {
			    switch (action) {
			    case "FadeOut":
				getStickmanAsFx(mStickmancombobox).doAnimation("FadeIn", 1000, true);
				break;
			    case "GoDown":
				getStickmanAsFx(mStickmancombobox).doAnimation("ComeUp", 1000, true);
				break;
			    case "DisappearToSmall":
				getStickmanAsFx(mStickmancombobox).doAnimation("ComeBackFromSmall", 1000, true);
				break;
			    default:
				break;
			    }
			});
		    }
		    
		    setBackgroundFunction();
		}

		EnvironmentRadioButtonNotSelected();
		WithPerlinNoise.setSelected(true);
	    }
	});

	ExitButton.setOnAction(new EventHandler<ActionEvent>() {
	    @Override
	    public void handle(ActionEvent event) {
		mStickmanOnstage.clearStage();
		((StickmanStageFX) mStickmanOnstage.getStageStickman()).clearStage(
			((StageRoomFX) mStickmanOnstage.getStageRoom()).CONFIG_STAGE);
	    }
	});

	saveToXml();
	handlePerlinNoise();
    }

    public StickmanFX getStickmanAsFx(String mStickmancombobox) {
	return (StickmanFX) mStickmanOnstage.getStickman(mStickmancombobox);
    }

    public void setStickamnOnStage(StickmansOnStage commonStickmansOnStage) {
	this.mStickmanOnstage = commonStickmansOnStage;
//	fillComboForStickman();
    }

    private void fillComboForEmotionExpression() {
	ArrayList<String> getClassesNames;
	StickmanFillCombo mStickmanFillCombo = new StickmanFillCombo(packEmotionExpression);
	getClassesNames = mStickmanFillCombo.getComboList();
	ObservableList<String> classNames = FXCollections.observableArrayList();
	classNames.addAll(getClassesNames.stream().collect(Collectors.toList()));
	EmotionExpressionComboBox.getItems().addAll(classNames);
    }

    public void fillComboForStickman() {
	ObservableList<String> stickmanNames = FXCollections.observableArrayList();
	stickmanNames.addAll(mStickmanOnstage.getStickmanNames().stream().collect(Collectors.toList()));
	StickmanComboBox.getItems().clear();
	StickmanComboBox.getItems().addAll(stickmanNames);
	mStickmanComboList.clear();
	mStickmanComboList.addAll(stickmanNames);
	if(!stickmanNames.isEmpty()){
	    mStickmancombobox = stickmanNames.get(0);
	}
	StickmanComboBox.setValue(mStickmancombobox);	
	setComboboxValue(getStickmanAsFx(mStickmancombobox));
	
	setBackgroundFunction();
    }

    private void setBackgroundFunction() {
	this.backgroundRecord = getStickmanAsFx(mStickmancombobox).backgroundRecord;
	if (this.backgroundRecord != null) {
	    HBox mStickmanPane;
	    try {
		mStickmanPane = ((StickmanStageFX) mStickmanOnstage.getStageStickman())
			    .getStickmanPane((((StageRoomFX) mStickmanOnstage
				    .getStageRoom()).CONFIG_STAGE));
		// Upload the picture
		if (StickmanFX.backgroundList.contains(this.backgroundRecord)) {
		    mStickmanPane.setStyle("-fx-background-image: url('/de/dfki/stickmanFX/image/"
			    + this.backgroundRecord + ".jpg');"
			    + "-fx-background-repeat: repeat;-fx-background-position: center center; -fx-background-size: contain;");
		} else {
		    // change the color of the background
		    mStickmanPane.setStyle("-fx-background-color: " + this.backgroundRecord + ";");
		}
	    } catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	}
    }

    // set the setValue of combobox
    private void setComboboxValue(StickmanFX mStick) {
	if (mStick.mType == StickmanSwing.TYPE.MALE) {
	    String sBodyComboBoxColor = HandleColor.switchColorToString(mStick.mBodyFX.mMaleColor);
	    if (sBodyComboBoxColor != null)
		BodyComboBoxColor.setValue(sBodyComboBoxColor);
	} else {
	    String sBodyComboBoxColor = HandleColor.switchColorToString(mStick.mBodyFX.mFemaleColor);
	    if (sBodyComboBoxColor != null)
		BodyComboBoxColor.setValue(sBodyComboBoxColor);
	}

	if (mStick.mType == StickmanSwing.TYPE.MALE) {
	    String sHairComboBoxColor = HandleColor.switchColorToString(mStick.mMaleHairFX.mColor);
	    if (sHairComboBoxColor != null)
		HairComboBoxColor.setValue(sHairComboBoxColor);
	} else {
	    String sHairComboBoxColor = HandleColor.switchColorToString(mStick.mFemaleHairFX.mColor);
	    if (sHairComboBoxColor != null)
		HairComboBoxColor.setValue(sHairComboBoxColor);

	}

	String sHeadComboBoxColor = HandleColor.switchColorToString(mStick.mHeadFX.mColor);
	if (sHeadComboBoxColor != null)
	    HeadComboBoxColor.setValue(sHeadComboBoxColor);

	String sLimbsComboBoxColor = HandleColor.switchColorToString(mStick.mLeftUpperLegFX.mColor);
	if (sLimbsComboBoxColor != null)
	    LimbsComboBoxColor.setValue(sLimbsComboBoxColor);
    }

    @FXML
    private void handleStickman() {
	gridPaneControlStickman.setVisible(true);
	gridPaneControlColor.setVisible(false);
	gridPaneControlEmotion.setVisible(false);
	gridPaneControlIdleSection.setVisible(false);
	gridPaneControlEnvironment.setVisible(false);
	gridPaneControlPosture.setVisible(false);
	gridPaneControlBackground.setVisible(false);
    }

    @FXML
    private void handleBodyColour() {
	gridPaneControlStickman.setVisible(false);
	gridPaneControlColor.setVisible(true);
	gridPaneControlEmotion.setVisible(false);
	gridPaneControlIdleSection.setVisible(false);
	gridPaneControlEnvironment.setVisible(false);
	gridPaneControlPosture.setVisible(false);
	gridPaneControlBackground.setVisible(false);
    }

    @FXML
    private void handleEmotionExpression() {
	gridPaneControlStickman.setVisible(false);
	gridPaneControlColor.setVisible(false);
	gridPaneControlEmotion.setVisible(true);
	gridPaneControlIdleSection.setVisible(false);
	gridPaneControlEnvironment.setVisible(false);
	gridPaneControlPosture.setVisible(false);
	gridPaneControlBackground.setVisible(false);
	ShowEmotionName.setText("");
    }

    @FXML
    private void handleIdleSection() {
	gridPaneControlStickman.setVisible(false);
	gridPaneControlColor.setVisible(false);
	gridPaneControlEmotion.setVisible(false);
	gridPaneControlIdleSection.setVisible(true);
	gridPaneControlEnvironment.setVisible(false);
	gridPaneControlPosture.setVisible(false);
	gridPaneControlBackground.setVisible(false);
    }

    @FXML
    private void handleEnvironment() {
	gridPaneControlStickman.setVisible(false);
	gridPaneControlColor.setVisible(false);
	gridPaneControlEmotion.setVisible(false);
	gridPaneControlIdleSection.setVisible(false);
	gridPaneControlEnvironment.setVisible(true);
	gridPaneControlPosture.setVisible(false);
	gridPaneControlBackground.setVisible(false);
    }

    @FXML
    private void handlePosture() {
	gridPaneControlStickman.setVisible(false);
	gridPaneControlColor.setVisible(false);
	gridPaneControlEmotion.setVisible(false);
	gridPaneControlIdleSection.setVisible(false);
	gridPaneControlEnvironment.setVisible(false);
	gridPaneControlPosture.setVisible(true);
	gridPaneControlBackground.setVisible(false);
    }

    @FXML
    private void handleBackground() {
	gridPaneControlStickman.setVisible(false);
	gridPaneControlColor.setVisible(false);
	gridPaneControlEmotion.setVisible(false);
	gridPaneControlIdleSection.setVisible(false);
	gridPaneControlEnvironment.setVisible(false);
	gridPaneControlPosture.setVisible(false);
	gridPaneControlBackground.setVisible(true);
    }

    private void setIdForLabel() {
	BodyColour.setId("Menu");
	Environment.setId("Menu");
	EmotionExpression.setId("Menu");
	IdleSection.setId("Menu");
	Posture.setId("Menu");
	Stickman.setId("Menu");
	Background.setId("Menu");
    }

    private void handlePerlinNoise() {
	WithPerlinNoise.setUserData("With Perlin Noise");
	WithoutPerlinNoise.setUserData("Without Perlin Noise");
	WithPerlinNoise.setToggleGroup(groupPerlin);
	WithoutPerlinNoise.setToggleGroup(groupPerlin);

	groupPerlin.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
	    public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {
		if ((groupPerlin.getSelectedToggle() != null)
			&& ((null != mStickmanComboList) && (!mStickmanComboList.isEmpty()))) {
		    if (groupPerlin.getSelectedToggle().getUserData().toString() == "With Perlin Noise") {
			Platform.runLater(() -> {
			    for (String key : mStickmanComboList)
				getStickmanAsFx(key).doAnimation("StartIdle", 1000, true);
			});
		    } else {
			Platform.runLater(() -> {
			    for (String key : mStickmanComboList)
				getStickmanAsFx(key).doAnimation("StopIdle", 1000, true);
			});
		    }
		}
	    }
	});
    }

    public void setlePerlinNoiseOn() {
	WithPerlinNoise.setSelected(true);
	WithoutPerlinNoise.setSelected(false);
    }

    public void setlePerlinNoiseOff() {
	WithPerlinNoise.setSelected(false);
	WithoutPerlinNoise.setSelected(true);

    }

    private void handleGroupForEnvironmentRadioButton() {
	FadeIn.setUserData("FadeIn");
	FadeOut.setUserData("FadeOut");
	GoDown.setUserData("GoDown");
	ComeUp.setUserData("ComeUp");
	DisappearToSmall.setUserData("DisappearToSmall");
	ComeBackFromSmall.setUserData("ComeBackFromSmall");
	Speaking.setUserData("Speaking");

	FadeIn.setToggleGroup(groupEnvironmentRadioButton);
	FadeOut.setToggleGroup(groupEnvironmentRadioButton);
	GoDown.setToggleGroup(groupEnvironmentRadioButton);
	ComeUp.setToggleGroup(groupEnvironmentRadioButton);
	DisappearToSmall.setToggleGroup(groupEnvironmentRadioButton);
	ComeBackFromSmall.setToggleGroup(groupEnvironmentRadioButton);
	Speaking.setToggleGroup(groupEnvironmentRadioButton);

	groupEnvironmentRadioButton.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
	    public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {
		if ((groupEnvironmentRadioButton.getSelectedToggle() != null) && (mStickmancombobox != null)) {
		    String action = groupEnvironmentRadioButton.getSelectedToggle().getUserData().toString();
		    if (!action.equals("Speaking")) {
			Platform.runLater(() -> {
			    getStickmanAsFx(mStickmancombobox).doAnimation(action, 1000, true);
			});
		    } else {
			Platform.runLater(() -> {
			    getStickmanAsFx(mStickmancombobox).doAnimation(action, 3000,
				    "Stell Dir vor, Du kommst nach Hause, und ein Pferd steht in der Küche.", false);
			    Speaking.setSelected(false);
			});
		    }
		}

		if ((groupEnvironmentRadioButton.getSelectedToggle() != null) && (mStickmancombobox == null)) {
		    String action = groupEnvironmentRadioButton.getSelectedToggle().getUserData().toString();
		    Platform.runLater(() -> {
			groupEnvironmentRadioButton.getSelectedToggle().setSelected(false);
		    });
		}
	    }
	});
    }

    private void EnvironmentRadioButtonNotSelected() {
	FadeIn.setSelected(false);
	FadeOut.setSelected(false);
	GoDown.setSelected(false);
	ComeUp.setSelected(false);
	DisappearToSmall.setSelected(false);
	ComeBackFromSmall.setSelected(false);
	Speaking.setSelected(false);
    }

    private void saveToXml() {
	SaveButton.setOnAction(new EventHandler<ActionEvent>() {
	    @Override
	    public void handle(ActionEvent event) {
		if (((null != mStickmanComboList) && (!mStickmanComboList.isEmpty()))) {
		    Platform.runLater(() -> {
			mStickmanDataFX.clear();
			for (String key : mStickmanComboList) {
			    String name = key;
			    String bodyColor;
			    String hairColor;
			    StickmanFX mStick = getStickmanAsFx(key);
			    if (mStick.mType == StickmanSwing.TYPE.MALE) {
				bodyColor = HandleColor.switchColorToString(mStick.mBodyFX.mMaleColor);
			    } else {
				bodyColor = HandleColor.switchColorToString(mStick.mBodyFX.mFemaleColor);
			    }

			    if (mStick.mType == StickmanSwing.TYPE.MALE) {
				hairColor = HandleColor.switchColorToString(mStick.mMaleHairFX.mColor);
			    } else {
				hairColor = HandleColor.switchColorToString(mStick.mFemaleHairFX.mColor);
			    }

			    String headColor = HandleColor.switchColorToString(mStick.mHeadFX.mColor);
			    String limbsColor = HandleColor.switchColorToString(mStick.mLeftUpperLegFX.mColor);

			    mStickmanDataFX.add(new StickmanDataFX(name, hairColor, headColor, bodyColor, limbsColor, backgroundRecord));
			}
			((StickmansOnStageFX) mStickmanOnstage).getmXmlTransform()
				.loadStickmanDataFXList(mStickmanDataFX);
			// StickmanOnstage.getmXmlTransform().loadStickmanDataFXList(mStickmanDataFX);
			handleSave();
		    });
		}
	    }
	});
    }

    private void handleSave() {

	File filexml = null;
	if (mStickmanOnstage.getmFilePath() != null)
	    filexml = new File(
		    mStickmanOnstage.getmFilePath() + File.separator + "stickmanSwing" + File.separator + "stickmanSwing.xml");
	else {
	    try {
		filexml = new File(new File(".").getCanonicalPath() + File.separator + "stickmanSwing" + File.separator
			+ "stickmanSwing.xml");
	    } catch (IOException e) {
		e.printStackTrace();
	    }
	}

	if (!filexml.exists())
	    filexml.getParentFile().mkdir();

	// Make sure it has the correct extension
	if (!filexml.getPath().endsWith(".xml")) {
	    filexml = new File(filexml.getPath() + ".xml");
	}
	((StickmansOnStageFX) mStickmanOnstage).getmXmlTransform().saveStickmanDataToFile(filexml);
    }
    
  //convert color to hex
    private String toHexCode(Color color) {
        return String.format("#%02X%02X%02X",
                (int) (color.getRed() * 255),
                (int) (color.getGreen() * 255),
                (int) (color.getBlue() * 255));
    }
}
