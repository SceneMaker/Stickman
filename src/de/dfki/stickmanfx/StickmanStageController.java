package de.dfki.stickmanfx;

import java.util.ArrayList;
import java.util.stream.Collectors;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author Robbie
 */
public class StickmanStageController {

	private static String packEmotionExpression = "de.dfki.stickmanfx.animation.facefx";
	private static String packGesture = "de.dfki.stickmanfx.animation.gesturefx";
	private static String packHead = "de.dfki.stickmanfx.animation.headfx";
	private static String packEnvironment = "de.dfki.stickmanfx.animation.environmentfx";
	private static String packPosture = "de.dfki.stickmanfx.animation.posturefx";

	private static StickmanFX sStickman;
	private StickmanStageFX mStickmanstage;
	private String mStickmancombobox = null;
	final private ToggleGroup groupPerlin = new ToggleGroup();

	@FXML
	private RadioButton WithPerlinNoise;
	@FXML
	private RadioButton WithoutPerlinNoise;

	@FXML
	private ComboBox<String> StickmanComboBox;
	@FXML
	private ComboBox<String> EmotionExpressionComboBox;

	@FXML
	private HBox StickmanFlowPane;

	@FXML
	private Button RestButton;
	@FXML
	private Button ExitButton;

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

	private StickmanFX currentStickman;
	public static RadioButton currentRadioButton;

	@FXML
	public void initialize() {
		setIdForLabel();
		// Default show
		handleStickman();

		// Select a stickman
		StickmanComboBox.setOnAction((event) -> {
			mStickmancombobox = StickmanComboBox.getSelectionModel().getSelectedItem();
			currentStickman = StickmanStageFX.getStickmanFX(mStickmancombobox);
		});

		fillEmotionScrollPane();
		fillGestureScrollPane();
		fillHeadScrollPane();
		fillEnvironmentScrollPane();
		fillPostureScrollPane();

		ExitButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Stage stage = (Stage) ExitButton.getScene().getWindow();
				stage.close();
				System.exit(0);
			}
		});
	}

	@FXML
	public void handleHeadColor() {
		if (currentStickman != null) {
			currentStickman.mHeadFX.mColor = headColorPicker.getValue();
			currentStickman.mHeadFX.update();
		}
	}

	@FXML
	public void handleHairColor() {
		if (currentStickman != null) {
			if (currentStickman.mType == StickmanFX.TYPE.MALE) {
				currentStickman.mMaleHairFX.mColor = hairColorPicker.getValue();
				currentStickman.mMaleHairFX.update();
			} else {
				currentStickman.mFemaleHairFX.mColor = hairColorPicker.getValue();
				currentStickman.mFemaleHairFX.update();
			}
		}
	}

	@FXML
	public void handleBodyColor() {
		if (currentStickman != null) {
			currentStickman.mUpperBody.mColor = bodyColorPicker.getValue();
			currentStickman.mUpperBody.update();
		}
	}

	@FXML
	public void handleLimbsColor() {
		if (currentStickman != null) {
			currentStickman.mNeckFX.mColor = limbsColorPicker.getValue();
			currentStickman.mLeftUpperArmFX.mColor = limbsColorPicker.getValue();
			currentStickman.mLeftForeArmFX.mColor = limbsColorPicker.getValue();
			currentStickman.mLeftWrist.mColor = limbsColorPicker.getValue();
			currentStickman.mLeftFinger1.mColor = limbsColorPicker.getValue();
			currentStickman.mLeftFinger2.mColor = limbsColorPicker.getValue();
			currentStickman.mLeftFinger3.mColor = limbsColorPicker.getValue();
			currentStickman.mLeftFinger4.mColor = limbsColorPicker.getValue();
			currentStickman.mLeftUpperLegFX.mColor = limbsColorPicker.getValue();
			currentStickman.mLeftForeLegFX.mColor = limbsColorPicker.getValue();

			currentStickman.mRightUpperArmFX.mColor = limbsColorPicker.getValue();
			currentStickman.mRightForeArmFX.mColor = limbsColorPicker.getValue();
			currentStickman.mRightWrist.mColor = limbsColorPicker.getValue();
			currentStickman.mRightFinger1.mColor = limbsColorPicker.getValue();
			currentStickman.mRightFinger2.mColor = limbsColorPicker.getValue();
			currentStickman.mRightFinger3.mColor = limbsColorPicker.getValue();
			currentStickman.mRightFinger4.mColor = limbsColorPicker.getValue();
			currentStickman.mRightUpperLegFX.mColor = limbsColorPicker.getValue();
			currentStickman.mRightForeLegFX.mColor = limbsColorPicker.getValue();

			currentStickman.mNeckFX.update();
			currentStickman.mLeftUpperArmFX.update();
			currentStickman.mLeftForeArmFX.update();
			currentStickman.mLeftWrist.update();
			currentStickman.mLeftFinger1.update();
			currentStickman.mLeftFinger2.update();
			currentStickman.mLeftFinger3.update();
			currentStickman.mLeftFinger4.update();
			currentStickman.mLeftUpperLegFX.update();
			currentStickman.mLeftForeLegFX.update();

			currentStickman.mRightUpperArmFX.update();
			currentStickman.mRightForeArmFX.update();
			currentStickman.mRightWrist.update();
			currentStickman.mRightFinger1.update();
			currentStickman.mRightFinger2.update();
			currentStickman.mRightFinger3.update();
			currentStickman.mRightFinger4.update();
			currentStickman.mRightUpperLegFX.update();
			currentStickman.mRightForeLegFX.update();
		}
	}

	@FXML
	public void handleShoesColor() {
		if (currentStickman != null) {
			currentStickman.mLeftFootFX.mColor = shoesColorPicker.getValue();
			currentStickman.mRightFootFX.mColor = shoesColorPicker.getValue();
			currentStickman.mLeftFootFX.update();
			currentStickman.mRightFootFX.update();
		}
	}

	@FXML
	public void handleLipsColor() {
		if (currentStickman != null) {
			currentStickman.mMouthFX.mColor = lipsColorPicker.getValue();
			currentStickman.mMouthFX.update();
		}
	}

	@FXML
	public void handleEyeColor() {
		if (currentStickman != null) {
			currentStickman.mLeftEyeFX.mColor = eyeColorPicker.getValue();
			currentStickman.mRightEyeFX.mColor = eyeColorPicker.getValue();
			currentStickman.mLeftEyeFX.update();
			currentStickman.mRightEyeFX.update();
		}
	}

	@FXML
	public void handleBrowColor() {
		if (currentStickman != null) {
			currentStickman.mLeftEyebrowFX.mColor = browColorPicker.getValue();
			currentStickman.mRightEyebrowFX.mColor = browColorPicker.getValue();
			currentStickman.mLeftEyebrowFX.update();
			currentStickman.mRightEyebrowFX.update();
		}
	}

	@FXML
	public void handleHeadColorButtons(MouseEvent ev) {
		if (currentStickman != null) {
			if (ev.getSource().equals(headColorBrighter)) {
				currentStickman.mHeadFX.mColor = currentStickman.mHeadFX.mColor.brighter();
				currentStickman.mHeadFX.update();
			} else if (ev.getSource().equals(headColorDarker)) {
				currentStickman.mHeadFX.mColor = currentStickman.mHeadFX.mColor.darker();
				currentStickman.mHeadFX.update();
			} else if (ev.getSource().equals(headColorReset)) {
				currentStickman.mHeadFX.mColor = currentStickman.mHeadFX.mColorRecorder;
				currentStickman.mHeadFX.update();
			}
		}
	}

	@FXML
	public void handleHairColorButtons(MouseEvent ev) {
		if (currentStickman != null) {
			if (ev.getSource().equals(hairColorBrighter)) {
				if (currentStickman.mType == StickmanFX.TYPE.MALE) {
					currentStickman.mMaleHairFX.mColor = currentStickman.mMaleHairFX.mColor.brighter();
					currentStickman.mMaleHairFX.update();
				} else {
					currentStickman.mFemaleHairFX.mColor = currentStickman.mFemaleHairFX.mColor.brighter();
					currentStickman.mFemaleHairFX.update();
				}
			} else if (ev.getSource().equals(hairColorDarker)) {
				if (currentStickman.mType == StickmanFX.TYPE.MALE) {
					currentStickman.mMaleHairFX.mColor = currentStickman.mMaleHairFX.mColor.darker();
					currentStickman.mMaleHairFX.update();
				} else {
					currentStickman.mFemaleHairFX.mColor = currentStickman.mFemaleHairFX.mColor.darker();
					currentStickman.mFemaleHairFX.update();
				}
			} else if (ev.getSource().equals(hairColorReset)) {
				if (currentStickman.mType == StickmanFX.TYPE.MALE) {
					currentStickman.mMaleHairFX.mColor = currentStickman.mMaleHairFX.mColorRecorder;
					currentStickman.mMaleHairFX.update();
				} else {
					currentStickman.mFemaleHairFX.mColor = currentStickman.mFemaleHairFX.mColorRecorder;
					currentStickman.mFemaleHairFX.update();
				}
			}
		}
	}

	@FXML
	public void handleBodyColorButtons(MouseEvent ev) {
		if (currentStickman != null) {
			if (ev.getSource().equals(bodyColorBrighter)) {
				currentStickman.mUpperBody.mColor = currentStickman.mUpperBody.mColor.brighter();
				currentStickman.mUpperBody.update();
			} else if (ev.getSource().equals(bodyColorDarker)) {
				currentStickman.mUpperBody.mColor = currentStickman.mUpperBody.mColor.darker();
				currentStickman.mUpperBody.update();
			} else if (ev.getSource().equals(bodyColorReset)) {
				currentStickman.mUpperBody.mColor = currentStickman.mUpperBody.mColorRecorder;
				currentStickman.mUpperBody.update();
			}
		}
	}

	@FXML
	public void handleLimbsColorButtons(MouseEvent ev) {
		if (currentStickman != null) {
			if (ev.getSource().equals(limbsColorBrighter)) {
				currentStickman.mNeckFX.mColor = currentStickman.mNeckFX.mColor.brighter();
				currentStickman.mLeftUpperArmFX.mColor = currentStickman.mLeftUpperArmFX.mColor.brighter();
				currentStickman.mLeftForeArmFX.mColor = currentStickman.mLeftForeArmFX.mColor.brighter();
				currentStickman.mLeftWrist.mColor = currentStickman.mLeftWrist.mColor.brighter();
				currentStickman.mLeftFinger1.mColor = currentStickman.mLeftFinger1.mColor.brighter();
				currentStickman.mLeftFinger2.mColor = currentStickman.mLeftFinger2.mColor.brighter();
				currentStickman.mLeftFinger3.mColor = currentStickman.mLeftFinger3.mColor.brighter();
				currentStickman.mLeftFinger4.mColor = currentStickman.mLeftFinger4.mColor.brighter();
				currentStickman.mLeftUpperLegFX.mColor = currentStickman.mLeftUpperLegFX.mColor.brighter();
				currentStickman.mLeftForeLegFX.mColor = currentStickman.mLeftForeLegFX.mColor.brighter();

				currentStickman.mRightUpperArmFX.mColor = currentStickman.mRightUpperArmFX.mColor.brighter();
				currentStickman.mRightForeArmFX.mColor = currentStickman.mRightForeArmFX.mColor.brighter();
				currentStickman.mRightWrist.mColor = currentStickman.mRightWrist.mColor.brighter();
				currentStickman.mRightFinger1.mColor = currentStickman.mRightFinger1.mColor.brighter();
				currentStickman.mRightFinger2.mColor = currentStickman.mRightFinger2.mColor.brighter();
				currentStickman.mRightFinger3.mColor = currentStickman.mRightFinger3.mColor.brighter();
				currentStickman.mRightFinger4.mColor = currentStickman.mRightFinger4.mColor.brighter();
				currentStickman.mRightUpperLegFX.mColor = currentStickman.mRightUpperLegFX.mColor.brighter();
				currentStickman.mRightForeLegFX.mColor = currentStickman.mRightForeLegFX.mColor.brighter();

				currentStickman.mNeckFX.update();
				currentStickman.mLeftUpperArmFX.update();
				currentStickman.mLeftForeArmFX.update();
				currentStickman.mLeftWrist.update();
				currentStickman.mLeftFinger1.update();
				currentStickman.mLeftFinger2.update();
				currentStickman.mLeftFinger3.update();
				currentStickman.mLeftFinger4.update();
				currentStickman.mLeftUpperLegFX.update();
				currentStickman.mLeftForeLegFX.update();

				currentStickman.mRightUpperArmFX.update();
				currentStickman.mRightForeArmFX.update();
				currentStickman.mRightWrist.update();
				currentStickman.mRightFinger1.update();
				currentStickman.mRightFinger2.update();
				currentStickman.mRightFinger3.update();
				currentStickman.mRightFinger4.update();
				currentStickman.mRightUpperLegFX.update();
				currentStickman.mRightForeLegFX.update();
			} else if (ev.getSource().equals(limbsColorDarker)) {
				currentStickman.mNeckFX.mColor = currentStickman.mNeckFX.mColor.darker();
				currentStickman.mLeftUpperArmFX.mColor = currentStickman.mLeftUpperArmFX.mColor.darker();
				currentStickman.mLeftForeArmFX.mColor = currentStickman.mLeftForeArmFX.mColor.darker();
				currentStickman.mLeftWrist.mColor = currentStickman.mLeftWrist.mColor.darker();
				currentStickman.mLeftFinger1.mColor = currentStickman.mLeftFinger1.mColor.darker();
				currentStickman.mLeftFinger2.mColor = currentStickman.mLeftFinger2.mColor.darker();
				currentStickman.mLeftFinger3.mColor = currentStickman.mLeftFinger3.mColor.darker();
				currentStickman.mLeftFinger4.mColor = currentStickman.mLeftFinger4.mColor.darker();
				currentStickman.mLeftUpperLegFX.mColor = currentStickman.mLeftUpperLegFX.mColor.darker();
				currentStickman.mLeftForeLegFX.mColor = currentStickman.mLeftForeLegFX.mColor.darker();

				currentStickman.mRightUpperArmFX.mColor = currentStickman.mRightUpperArmFX.mColor.darker();
				currentStickman.mRightForeArmFX.mColor = currentStickman.mRightForeArmFX.mColor.darker();
				currentStickman.mRightWrist.mColor = currentStickman.mRightWrist.mColor.darker();
				currentStickman.mRightFinger1.mColor = currentStickman.mRightFinger1.mColor.darker();
				currentStickman.mRightFinger2.mColor = currentStickman.mRightFinger2.mColor.darker();
				currentStickman.mRightFinger3.mColor = currentStickman.mRightFinger3.mColor.darker();
				currentStickman.mRightFinger4.mColor = currentStickman.mRightFinger4.mColor.darker();
				currentStickman.mRightUpperLegFX.mColor = currentStickman.mRightUpperLegFX.mColor.darker();
				currentStickman.mRightForeLegFX.mColor = currentStickman.mRightForeLegFX.mColor.darker();

				currentStickman.mNeckFX.update();
				currentStickman.mLeftUpperArmFX.update();
				currentStickman.mLeftForeArmFX.update();
				currentStickman.mLeftWrist.update();
				currentStickman.mLeftFinger1.update();
				currentStickman.mLeftFinger2.update();
				currentStickman.mLeftFinger3.update();
				currentStickman.mLeftFinger4.update();
				currentStickman.mLeftUpperLegFX.update();
				currentStickman.mLeftForeLegFX.update();

				currentStickman.mRightUpperArmFX.update();
				currentStickman.mRightForeArmFX.update();
				currentStickman.mRightWrist.update();
				currentStickman.mRightFinger1.update();
				currentStickman.mRightFinger2.update();
				currentStickman.mRightFinger3.update();
				currentStickman.mRightFinger4.update();
				currentStickman.mRightUpperLegFX.update();
				currentStickman.mRightForeLegFX.update();
			} else if (ev.getSource().equals(limbsColorReset)) {
				currentStickman.mNeckFX.mColor = currentStickman.mNeckFX.mColorRecorder;
				currentStickman.mLeftUpperArmFX.mColor = currentStickman.mLeftUpperArmFX.mColorRecorder;
				currentStickman.mLeftForeArmFX.mColor = currentStickman.mLeftForeArmFX.mColorRecorder;
				currentStickman.mLeftWrist.mColor = currentStickman.mLeftWrist.mColorRecorder;
				currentStickman.mLeftFinger1.mColor = currentStickman.mLeftFinger1.mColorRecorder;
				currentStickman.mLeftFinger2.mColor = currentStickman.mLeftFinger2.mColorRecorder;
				currentStickman.mLeftFinger3.mColor = currentStickman.mLeftFinger3.mColorRecorder;
				currentStickman.mLeftFinger4.mColor = currentStickman.mLeftFinger4.mColorRecorder;
				currentStickman.mLeftUpperLegFX.mColor = currentStickman.mLeftUpperLegFX.mColorRecorder;
				currentStickman.mLeftForeLegFX.mColor = currentStickman.mLeftForeLegFX.mColorRecorder;

				currentStickman.mRightUpperArmFX.mColor = currentStickman.mRightUpperArmFX.mColorRecorder;
				currentStickman.mRightForeArmFX.mColor = currentStickman.mRightForeArmFX.mColorRecorder;
				currentStickman.mRightWrist.mColor = currentStickman.mRightWrist.mColorRecorder;
				currentStickman.mRightFinger1.mColor = currentStickman.mRightFinger1.mColorRecorder;
				currentStickman.mRightFinger2.mColor = currentStickman.mRightFinger2.mColorRecorder;
				currentStickman.mRightFinger3.mColor = currentStickman.mRightFinger3.mColorRecorder;
				currentStickman.mRightFinger4.mColor = currentStickman.mRightFinger4.mColorRecorder;
				currentStickman.mRightUpperLegFX.mColor = currentStickman.mRightUpperLegFX.mColorRecorder;
				currentStickman.mRightForeLegFX.mColor = currentStickman.mRightForeLegFX.mColorRecorder;

				currentStickman.mNeckFX.update();
				currentStickman.mLeftUpperArmFX.update();
				currentStickman.mLeftForeArmFX.update();
				currentStickman.mLeftWrist.update();
				currentStickman.mLeftFinger1.update();
				currentStickman.mLeftFinger2.update();
				currentStickman.mLeftFinger3.update();
				currentStickman.mLeftFinger4.update();
				currentStickman.mLeftUpperLegFX.update();
				currentStickman.mLeftForeLegFX.update();

				currentStickman.mRightUpperArmFX.update();
				currentStickman.mRightForeArmFX.update();
				currentStickman.mRightWrist.update();
				currentStickman.mRightFinger1.update();
				currentStickman.mRightFinger2.update();
				currentStickman.mRightFinger3.update();
				currentStickman.mRightFinger4.update();
				currentStickman.mRightUpperLegFX.update();
				currentStickman.mRightForeLegFX.update();
			}
		}
	}

	@FXML
	public void handleShoesColorButtons(MouseEvent ev) {
		if (currentStickman != null) {
			if (ev.getSource().equals(shoesColorBrighter)) {
				currentStickman.mLeftFootFX.mColor = currentStickman.mLeftFootFX.mColor.brighter();
				currentStickman.mRightFootFX.mColor = currentStickman.mRightFootFX.mColor.brighter();
				currentStickman.mLeftFootFX.update();
				currentStickman.mRightFootFX.update();
			} else if (ev.getSource().equals(shoesColorDarker)) {
				currentStickman.mLeftFootFX.mColor = currentStickman.mLeftFootFX.mColor.darker();
				currentStickman.mRightFootFX.mColor = currentStickman.mRightFootFX.mColor.darker();
				currentStickman.mLeftFootFX.update();
				currentStickman.mRightFootFX.update();
			} else if (ev.getSource().equals(shoesColorReset)) {
				currentStickman.mLeftFootFX.mColor = currentStickman.mLeftFootFX.mColorRecorder;
				currentStickman.mRightFootFX.mColor = currentStickman.mRightFootFX.mColorRecorder;
				currentStickman.mLeftFootFX.update();
				currentStickman.mRightFootFX.update();
			}
		}
	}

	@FXML
	public void handleLipsColorButtons(MouseEvent ev) {
		if (currentStickman != null) {
			if (ev.getSource().equals(lipsColorBrighter)) {
				currentStickman.mMouthFX.mColor = currentStickman.mMouthFX.mColor.brighter();
				currentStickman.mMouthFX.update();
			} else if (ev.getSource().equals(lipsColorDarker)) {
				currentStickman.mMouthFX.mColor = currentStickman.mMouthFX.mColor.darker();
				currentStickman.mMouthFX.update();
			} else if (ev.getSource().equals(lipsColorReset)) {
				currentStickman.mMouthFX.mColor = currentStickman.mMouthFX.mColorRecorder;
				currentStickman.mMouthFX.update();
			}
		}
	}

	@FXML
	public void handleEyeColorButtons(MouseEvent ev) {
		if (currentStickman != null) {
			if (ev.getSource().equals(eyeColorBrighter)) {
				currentStickman.mLeftEyeFX.mColor = currentStickman.mLeftEyeFX.mColor.brighter();
				currentStickman.mRightEyeFX.mColor = currentStickman.mRightEyeFX.mColor.brighter();
				currentStickman.mLeftEyeFX.update();
				currentStickman.mRightEyeFX.update();
			} else if (ev.getSource().equals(eyeColorDarker)) {
				currentStickman.mLeftEyeFX.mColor = currentStickman.mLeftEyeFX.mColor.darker();
				currentStickman.mRightEyeFX.mColor = currentStickman.mRightEyeFX.mColor.darker();
				currentStickman.mLeftEyeFX.update();
				currentStickman.mRightEyeFX.update();
			} else if (ev.getSource().equals(eyeColorReset)) {
				currentStickman.mLeftEyeFX.mColor = currentStickman.mLeftEyeFX.mColorRecorder;
				currentStickman.mRightEyeFX.mColor = currentStickman.mRightEyeFX.mColorRecorder;
				currentStickman.mLeftEyeFX.update();
				currentStickman.mRightEyeFX.update();
			}
		}
	}

	@FXML
	public void handleBrowColorButtons(MouseEvent ev) {
		if (currentStickman != null) {
			if (ev.getSource().equals(browColorBrighter)) {
				currentStickman.mLeftEyebrowFX.mColor = currentStickman.mLeftEyebrowFX.mColor.brighter();
				currentStickman.mRightEyebrowFX.mColor = currentStickman.mRightEyebrowFX.mColor.brighter();
				currentStickman.mLeftEyebrowFX.update();
				currentStickman.mRightEyebrowFX.update();
			} else if (ev.getSource().equals(browColorDarker)) {
				currentStickman.mLeftEyebrowFX.mColor = currentStickman.mLeftEyebrowFX.mColor.darker();
				currentStickman.mRightEyebrowFX.mColor = currentStickman.mRightEyebrowFX.mColor.darker();
				currentStickman.mLeftEyebrowFX.update();
				currentStickman.mRightEyebrowFX.update();
			} else if (ev.getSource().equals(browColorReset)) {
				currentStickman.mLeftEyebrowFX.mColor = currentStickman.mLeftEyebrowFX.mColorRecorder;
				currentStickman.mRightEyebrowFX.mColor = currentStickman.mRightEyebrowFX.mColorRecorder;
				currentStickman.mLeftEyebrowFX.update();
				currentStickman.mRightEyebrowFX.update();
			}
		}
	}

	public void getStickmanStageFX(StickmanStageFX Stickmanstage) {
		this.mStickmanstage = Stickmanstage;
		fillComboForStickman();

	}

	private void fillEmotionScrollPane() {
		ArrayList<String> getClassesNames;
		Packageparser parser = new Packageparser(packEmotionExpression);
		getClassesNames = parser.getClassNameList();
		ObservableList<String> classNames = FXCollections.observableArrayList();
		classNames.addAll(getClassesNames.stream().collect(Collectors.toList()));

		createAndHandleRadioButtons(getClassesNames, emotionsScrollPane);
	}

	private void fillGestureScrollPane() {
		ArrayList<String> getClassesNames;
		Packageparser parser = new Packageparser(packGesture);
		getClassesNames = parser.getClassNameList();
		ObservableList<String> classNames = FXCollections.observableArrayList();
		classNames.addAll(getClassesNames.stream().collect(Collectors.toList()));

		createAndHandleRadioButtons(getClassesNames, gestureScrollPane);
	}

	private void fillHeadScrollPane() {
		ArrayList<String> getClassesNames;
		Packageparser parser = new Packageparser(packHead);
		getClassesNames = parser.getClassNameList();
		ObservableList<String> classNames = FXCollections.observableArrayList();
		classNames.addAll(getClassesNames.stream().collect(Collectors.toList()));

		createAndHandleRadioButtons(getClassesNames, headScrollPane);
	}

	private void fillEnvironmentScrollPane() {
		ArrayList<String> getClassesNames;
		Packageparser parser = new Packageparser(packEnvironment);
		getClassesNames = parser.getClassNameList();
		ObservableList<String> classNames = FXCollections.observableArrayList();
		classNames.addAll(getClassesNames.stream().collect(Collectors.toList()));

		createAndHandleRadioButtons(getClassesNames, environmentScrollPane);
	}
	
	private void fillPostureScrollPane() {
		ArrayList<String> getClassesNames;
		Packageparser parser = new Packageparser(packPosture);
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
				currentStickman.doAnimation(button.getText(), 70, true);
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

	private void fillComboForStickman() {
		ObservableList<String> stickmanNames = FXCollections.observableArrayList();
		stickmanNames.addAll(mStickmanstage.mStickmanComboList.stream().collect(Collectors.toList()));
		StickmanComboBox.getItems().addAll(stickmanNames);
		StickmanComboBox.setValue(stickmanNames.get(0));
		currentStickman = mStickmanstage.getStickmanFX(stickmanNames.get(0));
	}

	private Color switchColor(String color) {
		Color c = null;
		switch (color) {
		case "Beige":
			c = Color.BEIGE;
			break;
		case "Yellow":
			c = Color.YELLOW;
			break;
		case "White":
			c = Color.WHITE;
			break;
		case "Black":
			// c = Color.BLACK;
			c = Color.rgb(80, 80, 80);
			break;
		case "Blue":
			c = Color.BLUE;
			break;
		case "Red":
			c = Color.RED;
			break;
		case "Gold":
			c = Color.GOLD;
			break;
		case "Brown":
			c = Color.rgb(97, 58, 0, 1);
			break;
		case "Saffron Yellow":
			c = Color.rgb(240, 212, 0, 1);
			break;
		case "Festucine":
			c = Color.rgb(242, 227, 217, 1);
			break;
		case "Green":
			c = Color.rgb(14, 134, 122, (240 * 100 / 255) / 100f);
			break;
		case "Purple":
			c = Color.rgb(154, 83, 198, (240 * 100 / 255) / 100f);
			break;
		default:
			c = null;
			break;
		}
		return c;
	}

	private String switchColorToString(Color color) {
		String s = null;
		if (color.equals(Color.BEIGE))
			s = "Beige";
		if (color.equals(Color.YELLOW))
			s = "Yellow";
		if (color.equals(Color.WHITE))
			s = "White";
		// if (color.equals(Color.BLACK))
		if (color.equals(Color.rgb(80, 80, 80)))
			s = "Black";
		if (color.equals(Color.BLUE))
			s = "Blue";
		if (color.equals(Color.RED))
			s = "Red";
		if (color.equals(Color.GOLD))
			s = "Gold";
		if (color.equals(Color.rgb(97, 58, 0, 1)))
			s = "Brown";
		if (color.equals(Color.rgb(240, 212, 0, 1)))
			s = "Saffron Yellow";
		if (color.equals(Color.rgb(242, 227, 217, 1)))
			s = "Festucine";
		if (color.equals(Color.rgb(14, 134, 122, (240 * 100 / 255) / 100f)))
			s = "Green";
		if (color.equals(Color.rgb(154, 83, 198, (240 * 100 / 255) / 100f)))
			s = "Purple";
		return s;
	}

	// set the setValue of combobox
	private void setComboboxValue(StickmanFX mStick) {
		if (mStick.mType == StickmanFX.TYPE.MALE) {
			// String sBodyComboBoxColor =
			// switchColorToString(mStick.mBodyFX.mMaleColor);
			// if(sBodyComboBoxColor!=null)
			// BodyComboBoxColor.setValue(sBodyComboBoxColor);
		} else {
			// String sBodyComboBoxColor =
			// switchColorToString(mStick.mBodyFX.mFemaleColor );
			// if(sBodyComboBoxColor!=null)
			// BodyComboBoxColor.setValue(sBodyComboBoxColor);
		}

		if (mStick.mType == StickmanFX.TYPE.MALE) {
			String sHairComboBoxColor = switchColorToString(mStick.mMaleHairFX.mColor);
			// if(sHairComboBoxColor!=null)
			// HairComboBoxColor.setValue(sHairComboBoxColor);
		} else {
			String sHairComboBoxColor = switchColorToString(mStick.mFemaleHairFX.mColor);
			// if(sHairComboBoxColor!=null)
			// HairComboBoxColor.setValue(sHairComboBoxColor);

		}

		String sHeadComboBoxColor = switchColorToString(mStick.mHeadFX.mColor);
		// if(sHeadComboBoxColor!=null)
		// HeadComboBoxColor.setValue(sHeadComboBoxColor);

		String sLimbsComboBoxColor = switchColorToString(mStick.mLeftUpperLegFX.mColor);
		// if(sLimbsComboBoxColor!=null)
		// LimbsComboBoxColor.setValue(sLimbsComboBoxColor);
	}

	@FXML
	private void handleStickman() {
	}

	@FXML
	private void handleBodyColour() {
	}

	@FXML
	private void handleEmotionExpression() {
	}

	@FXML
	private void handleIdleSection() {
	}

	@FXML
	private void handleEnvironment() {
	}

	@FXML
	private void handlePosture() {
	}

	private void setIdForLabel() {
	}

	private void handlePerlinNoise() {
		WithPerlinNoise.setUserData("With Perlin Noise");
		WithoutPerlinNoise.setUserData("Without Perlin Noise");
		WithPerlinNoise.setToggleGroup(groupPerlin);
		WithoutPerlinNoise.setToggleGroup(groupPerlin);

		groupPerlin.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
			public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {
				if ((groupPerlin.getSelectedToggle() != null) && ((null != mStickmanstage.mStickmanComboList)
						&& (!mStickmanstage.mStickmanComboList.isEmpty()))) {
					if (groupPerlin.getSelectedToggle().getUserData().toString() == "With Perlin Noise") {
						Platform.runLater(() -> {
							for (String key : mStickmanstage.mStickmanComboList)
								mStickmanstage.getStickmanFX(key).doAnimation("StartIdle", 1000, true);
						});
					} else {
						Platform.runLater(() -> {
							for (String key : mStickmanstage.mStickmanComboList)
								mStickmanstage.getStickmanFX(key).doAnimation("StopIdle", 1000, true);
						});
					}
				}
			}
		});
	}

	public void setlePerlinNoiseOn() {
		WithPerlinNoise.setSelected(true);
	}
}
