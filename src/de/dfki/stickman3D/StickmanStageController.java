package de.dfki.stickman3D;

import java.awt.Point;
import java.util.ArrayList;
import java.util.stream.Collectors;

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
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

/**
 *
 * @author Robbie
 */
public class StickmanStageController {

	private static String packEmotionExpression = "de.dfki.stickman3D.animation.face";
	private static String packGesture = "de.dfki.stickman3D.animation.gesture";
	private static String packHead = "de.dfki.stickman3D.animation.head";
	private static String packEnvironment = "de.dfki.stickman3D.animation.environment";
	private static String packPosture = "de.dfki.stickman3D.animation.posture";

	private StickmanStage mStickmanstage;
	private String mStickmancombobox = null;

	@FXML
	private RadioButton WithPerlinNoise;
	@FXML
	private RadioButton WithoutPerlinNoise;
	private ToggleGroup perlinNoiseGroup;

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
	Button startCamera;
	@FXML
	Button stopCamera;
	@FXML
	Button resetCamera;
	public static boolean isCameraStarted = false;

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
	@FXML
	private Slider cameraXSlider;
	@FXML
	private Slider cameraYSlider;
	@FXML
	private Slider cameraZSlider;
	@FXML
	private Slider headOpacitySlider;
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

	double xRotateFactor;
	double yRotateFactor;
	double zRotateFactor;

	private Stickman3D currentStickman;
	public static RadioButton currentRadioButton;

	@FXML
	public void initialize() {
		// Select a stickman
		StickmanComboBox.setOnAction((event) -> {
			mStickmancombobox = StickmanComboBox.getSelectionModel().getSelectedItem();
			currentStickman = StickmanStage.getStickmanFX(mStickmancombobox);
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

		cameraXSlider.setMin(-180);
		cameraXSlider.setMax(180);
		cameraXSlider.setValue(0);
		cameraXSlider.valueProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> ov, Number old_val, Number new_val) {
				if (isCameraStarted) {
					double newValue = new_val.doubleValue();
					double oldValue = old_val.doubleValue();
					xRotateFactor = newValue - oldValue;
					Point pivot = currentStickman.mUpperBody.getUpperBodyPosition();
					Rotate rx = new Rotate(xRotateFactor, pivot.x, pivot.y, 1505, Rotate.X_AXIS);
					StickmanStage.sCamera.getTransforms().addAll(rx);
				}
			}
		});
		
		headOpacitySlider.valueProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) 
			{
				if(newValue.doubleValue() <= 0.1)
					currentStickman.mHeadFX.mHeadMeshView.setVisible(false);
				else
					currentStickman.mHeadFX.mHeadMeshView.setVisible(true);
				Color col = currentStickman.mHeadFX.mColor;
				col = new Color(col.getRed(), col.getGreen(), col.getBlue(), newValue.doubleValue());
				currentStickman.mHeadFX.mColor = col;
				currentStickman.mHeadFX.update();
			}
		});
		
		hairOpacitySlider.valueProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) 
			{
				if(newValue.doubleValue() <= 0.1)
				{
					if(currentStickman.mType == Stickman3D.TYPE.FEMALE)
						currentStickman.mFemaleHairFX.femaleHairMeshView.setVisible(false);
					else
						currentStickman.mMaleHairFX.maleHairMeshView.setVisible(false);
				}
				else
				{
					if(currentStickman.mType == Stickman3D.TYPE.FEMALE)
						currentStickman.mFemaleHairFX.femaleHairMeshView.setVisible(true);
					else
						currentStickman.mMaleHairFX.maleHairMeshView.setVisible(true);
				}
				
				Color col = null;
				if(currentStickman.mType == Stickman3D.TYPE.FEMALE)
				{
					col = currentStickman.mFemaleHairFX.mColor;
					col = new Color(col.getRed(), col.getGreen(), col.getBlue(), newValue.doubleValue());
					currentStickman.mFemaleHairFX.mColor = col;
					currentStickman.mFemaleHairFX.update();
				}
				else
				{
					col = currentStickman.mMaleHairFX.mColor;
					col = new Color(col.getRed(), col.getGreen(), col.getBlue(), newValue.doubleValue());
					currentStickman.mMaleHairFX.mColor = col;
					currentStickman.mMaleHairFX.update();
				}
				
			}
		});
		
		bodyOpacitySlider.valueProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) 
			{
				if(newValue.doubleValue() <= 0.1)
				{
					currentStickman.mDownBody.mBodyMeshView.setVisible(false);
					currentStickman.mUpperBody.mBodyMeshView.setVisible(false);
				}
				else
				{
					currentStickman.mDownBody.mBodyMeshView.setVisible(true);
					currentStickman.mUpperBody.mBodyMeshView.setVisible(true);
				}
					
					Color col = currentStickman.mDownBody.mColor;
					Color col1 = currentStickman.mUpperBody.mColor;
					col = new Color(col.getRed(), col.getGreen(), col.getBlue(), newValue.doubleValue());
					col1 = new Color(col1.getRed(), col1.getGreen(), col1.getBlue(), newValue.doubleValue());
					currentStickman.mDownBody.mColor = col;
					currentStickman.mDownBody.update();
					currentStickman.mUpperBody.mColor = col;
					currentStickman.mUpperBody.update();
			}
		});
		
		limbsOpacitySlider.valueProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) 
			{
				if(newValue.doubleValue() <= 0.1)
				{
					currentStickman.mNeckFX.neckMeshView.setVisible(false);
					
					currentStickman.mLeftUpperLegFX.mLeftUpperLegMesh.setVisible(false);
					currentStickman.mLeftForeLegFX.mLeftForeLegMesh.setVisible(false);
					
					currentStickman.mLeftUpperArmFX.mLeftUpperArmMesh.setVisible(false);
					currentStickman.mLeftForeArmFX.mLeftForeArmMesh.setVisible(false);
					currentStickman.mLeftWrist.mLeftWristMesh.setVisible(false);
					
					currentStickman.mLeftFinger1.mLeftFinger1.setVisible(false);
					currentStickman.mLeftFinger2.mLeftFinger2.setVisible(false);
					currentStickman.mLeftFinger3.mLeftFinger3.setVisible(false);
					currentStickman.mLeftFinger4.mLeftFinger4.setVisible(false);
					
					currentStickman.mRightUpperLegFX.mRightUpperLegMesh.setVisible(false);
					currentStickman.mRightForeLegFX.mRightForeLegMesh.setVisible(false);
					
					currentStickman.mRightUpperArmFX.mRightpperArmMesh.setVisible(false);
					currentStickman.mRightForeArmFX.mRightForeArmMesh.setVisible(false);
					currentStickman.mRightWrist.mRightWristMesh.setVisible(false);
					
					currentStickman.mRightFinger1.mRightFinger1.setVisible(false);
					currentStickman.mRightFinger2.mRightFinger2.setVisible(false);
					currentStickman.mRightFinger3.mRightFinger3.setVisible(false);
					currentStickman.mRightFinger4.mRightFinger4.setVisible(false);
				}
				else
				{
					currentStickman.mNeckFX.neckMeshView.setVisible(true);
					
					currentStickman.mLeftUpperLegFX.mLeftUpperLegMesh.setVisible(true);
					currentStickman.mLeftForeLegFX.mLeftForeLegMesh.setVisible(true);
					
					currentStickman.mLeftUpperArmFX.mLeftUpperArmMesh.setVisible(true);
					currentStickman.mLeftForeArmFX.mLeftForeArmMesh.setVisible(true);
					currentStickman.mLeftWrist.mLeftWristMesh.setVisible(true);
					
					currentStickman.mLeftFinger1.mLeftFinger1.setVisible(true);
					currentStickman.mLeftFinger2.mLeftFinger2.setVisible(true);
					currentStickman.mLeftFinger3.mLeftFinger3.setVisible(true);
					currentStickman.mLeftFinger4.mLeftFinger4.setVisible(true);
					
					currentStickman.mRightUpperLegFX.mRightUpperLegMesh.setVisible(true);
					currentStickman.mRightForeLegFX.mRightForeLegMesh.setVisible(true);
					
					currentStickman.mRightUpperArmFX.mRightpperArmMesh.setVisible(true);
					currentStickman.mRightForeArmFX.mRightForeArmMesh.setVisible(true);
					currentStickman.mRightWrist.mRightWristMesh.setVisible(true);
					
					currentStickman.mRightFinger1.mRightFinger1.setVisible(true);
					currentStickman.mRightFinger2.mRightFinger2.setVisible(true);
					currentStickman.mRightFinger3.mRightFinger3.setVisible(true);
					currentStickman.mRightFinger4.mRightFinger4.setVisible(true);
				}
					
					Color col = currentStickman.mNeckFX.mColor;
					col = new Color(col.getRed(), col.getGreen(), col.getBlue(), newValue.doubleValue());
					
					currentStickman.mNeckFX.mColor = col;
					
					currentStickman.mLeftUpperLegFX.mColor = col;
					currentStickman.mLeftForeLegFX.mColor = col;
					
					currentStickman.mLeftUpperArmFX.mColor = col;
					currentStickman.mLeftForeArmFX.mColor = col;
					currentStickman.mLeftWrist.mColor = col;
					
					currentStickman.mLeftFinger1.mColor = col;
					currentStickman.mLeftFinger2.mColor = col;
					currentStickman.mLeftFinger3.mColor = col;
					currentStickman.mLeftFinger4.mColor = col;
					
					currentStickman.mRightUpperLegFX.mColor = col;
					currentStickman.mRightForeLegFX.mColor = col;
					
					currentStickman.mRightUpperArmFX.mColor = col;
					currentStickman.mRightForeArmFX.mColor = col;
					currentStickman.mRightWrist.mColor = col;
					
					currentStickman.mRightFinger1.mColor = col;
					currentStickman.mRightFinger2.mColor = col;
					currentStickman.mRightFinger3.mColor = col;
					currentStickman.mRightFinger4.mColor = col;
					
					currentStickman.mNeckFX.update();
					
					currentStickman.mLeftUpperLegFX.update();
					currentStickman.mLeftForeLegFX.update();
					
					currentStickman.mLeftUpperArmFX.update();
					currentStickman.mLeftForeArmFX.update();
					currentStickman.mLeftWrist.update();
					
					currentStickman.mLeftFinger1.update();
					currentStickman.mLeftFinger2.update();
					currentStickman.mLeftFinger3.update();
					currentStickman.mLeftFinger4.update();
					
					currentStickman.mRightUpperLegFX.update();
					currentStickman.mRightForeLegFX.update();
					
					currentStickman.mRightUpperArmFX.update();
					currentStickman.mRightForeArmFX.update();
					currentStickman.mRightWrist.update();
					
					currentStickman.mRightFinger1.update();
					currentStickman.mRightFinger2.update();
					currentStickman.mRightFinger3.update();
					currentStickman.mRightFinger4.update();
			}
		});
		
		shoesOpacitySlider.valueProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) 
			{
				if(newValue.doubleValue() <= 0.1)
				{
					currentStickman.mLeftFootFX.mLeftFootMeshView.setVisible(false);
					currentStickman.mRightFootFX.mRightFootMeshView.setVisible(false);
				}
				else
				{
					currentStickman.mLeftFootFX.mLeftFootMeshView.setVisible(true);
					currentStickman.mRightFootFX.mRightFootMeshView.setVisible(true);
				}
					
					Color col = currentStickman.mLeftFootFX.mColor;
					col = new Color(col.getRed(), col.getGreen(), col.getBlue(), newValue.doubleValue());
					
					currentStickman.mLeftFootFX.mColor = col;
					currentStickman.mRightFootFX.mColor = col;

					currentStickman.mLeftFootFX.update();
					currentStickman.mRightFootFX.update();
			}
		});
		
		lipsOpacitySlider.valueProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) 
			{
				if(newValue.doubleValue() <= 0.1)
				{
					currentStickman.mMouthFX.currentDownLipPolygon.setVisible(false);
					currentStickman.mMouthFX.currentUpperLipPolygon.setVisible(false);
				}
				else
				{
					currentStickman.mMouthFX.currentDownLipPolygon.setVisible(true);
					currentStickman.mMouthFX.currentUpperLipPolygon.setVisible(true);
				}
					
					Color col = currentStickman.mMouthFX.mColor;
					col = new Color(col.getRed(), col.getGreen(), col.getBlue(), newValue.doubleValue());
					
					currentStickman.mMouthFX.mColor = col;

					currentStickman.mMouthFX.update();
			}
		});
		
		eyeOpacitySlider.valueProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) 
			{
				if(newValue.doubleValue() <= 0.1)
				{
					currentStickman.mLeftEyeFX.bigPupile.setVisible(false);
					currentStickman.mLeftEyeFX.smallPupile.setVisible(false);
					currentStickman.mLeftEyeFX.border.setVisible(false);
					
					currentStickman.mRightEyeFX.bigPupile.setVisible(false);
					currentStickman.mRightEyeFX.smallPupile.setVisible(false);
					currentStickman.mRightEyeFX.border.setVisible(false);
				}
				else
				{
					currentStickman.mLeftEyeFX.bigPupile.setVisible(true);
					currentStickman.mLeftEyeFX.smallPupile.setVisible(true);
					currentStickman.mLeftEyeFX.border.setVisible(true);
					
					currentStickman.mRightEyeFX.bigPupile.setVisible(true);
					currentStickman.mRightEyeFX.smallPupile.setVisible(true);
					currentStickman.mRightEyeFX.border.setVisible(true);
				}
					
					Color col = currentStickman.mLeftEyeFX.mColor;
					col = new Color(col.getRed(), col.getGreen(), col.getBlue(), newValue.doubleValue());
					
					currentStickman.mLeftEyeFX.mColor = col;
					currentStickman.mRightEyeFX.mColor = col;
					currentStickman.mLeftEyeFX.update();
					currentStickman.mRightEyeFX.update();
			}
		});
		
		browOpacitySlider.valueProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) 
			{
					
				Color col = currentStickman.mLeftEyebrowFX.mColor;
				Color col1 = currentStickman.mNoseFX.mColor;
				col = new Color(col.getRed(), col.getGreen(), col.getBlue(), newValue.doubleValue());
				col1 = new Color(col1.getRed(), col1.getGreen(), col1.getBlue(), newValue.doubleValue());
				
				currentStickman.mLeftEyebrowFX.mColor = col;
				currentStickman.mRightEyebrowFX.mColor = col;
				
				currentStickman.mNoseFX.mColor = col1;
				
				currentStickman.mLeftEyebrowFX.update();
				currentStickman.mRightEyebrowFX.update();
				
				currentStickman.mNoseFX.update();
			}
		});

		cameraYSlider.setMin(-180);
		cameraYSlider.setMax(180);
		cameraYSlider.setValue(0);
		cameraYSlider.valueProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> ov, Number old_val, Number new_val) {
				if (isCameraStarted) {
					double newValue = new_val.doubleValue();
					double oldValue = old_val.doubleValue();
					yRotateFactor = newValue - oldValue;
					Point pivot = currentStickman.mUpperBody.getUpperBodyPosition();
					Rotate ry = new Rotate(yRotateFactor, pivot.x, pivot.y, 1505, Rotate.Y_AXIS);
					StickmanStage.sCamera.getTransforms().addAll(ry);
				}
			}
		});

		cameraZSlider.setMin(-180);
		cameraZSlider.setMax(180);
		cameraZSlider.setValue(0);
		cameraZSlider.valueProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> ov, Number old_val, Number new_val) {
				if (isCameraStarted) {
					double newValue = new_val.doubleValue();
					double oldValue = old_val.doubleValue();
					zRotateFactor = newValue - oldValue;
					Point pivot = currentStickman.mUpperBody.getUpperBodyPosition();
					Rotate rz = new Rotate(zRotateFactor, pivot.x, pivot.y, 1505, Rotate.Z_AXIS);
					StickmanStage.sCamera.getTransforms().addAll(rz);
				}
			}
		});

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
	private void handleBG1() {
		String bg1 = getClass().getClassLoader().getResource("Images/bg1.jpg").toExternalForm();
		StickmanStage.sStickmanHBox.setStyle("-fx-background-image: url('" + bg1 + "'); "
				+ "-fx-background-position: center center; " + "-fx-background-repeat: stretch;");
	}

	@FXML
	private void handleBG2() {
		String bg2 = getClass().getClassLoader().getResource("Images/bg2.jpg").toExternalForm();
		StickmanStage.sStickmanHBox.setStyle("-fx-background-image: url('" + bg2 + "'); "
				+ "-fx-background-position: center center; " + "-fx-background-repeat: stretch;");
	}

	@FXML
	private void handleBG3() {
		String bg3 = getClass().getClassLoader().getResource("Images/bg3.jpg").toExternalForm();
		StickmanStage.sStickmanHBox.setStyle("-fx-background-image: url('" + bg3 + "'); "
				+ "-fx-background-position: center center; " + "-fx-background-repeat: stretch;");
	}

	@FXML
	private void handleBG4() {
		String bg4 = getClass().getClassLoader().getResource("Images/bg4.jpg").toExternalForm();
		StickmanStage.sStickmanHBox.setStyle("-fx-background-image: url('" + bg4 + "'); "
				+ "-fx-background-position: center center; " + "-fx-background-repeat: stretch;");
	}

	@FXML
	private void handleBG5() {
		String bg5 = getClass().getClassLoader().getResource("Images/bg5.jpg").toExternalForm();
		StickmanStage.sStickmanHBox.setStyle("-fx-background-image: url('" + bg5 + "'); "
				+ "-fx-background-position: center center; " + "-fx-background-repeat: stretch;");
	}

	@FXML
	private void handleBG6() {
		String bgDefault = getClass().getClassLoader().getResource("Images/bgDefault.png").toExternalForm();
		// StickmanStageFX.sStickmanHBox.setStyle("-fx-background-color:
		// transparent");
		StickmanStage.sStickmanHBox.setStyle("-fx-background-image: url('" + bgDefault + "'); "
				+ "-fx-background-position: center center; " + "-fx-background-repeat: stretch;");
	}

	@FXML
	public void handleStopCamera() {
		if (isCameraStarted) {
			StickmanStage.sSubscene.setCamera(null);
			isCameraStarted = false;
		}
	}

	@FXML
	public void handleStartCamera() {
		if (!isCameraStarted) {
			StickmanStage.sSubscene.setCamera(StickmanStage.sCamera);
			isCameraStarted = true;
		}
	}

	@FXML
	public void handleResetCamera() {

		StickmanStage.sCamera.setTranslateX(StickmanStage.recordCameraXPosition);
		StickmanStage.sCamera.setTranslateY(StickmanStage.recordCameraYPosition);
		StickmanStage.sCamera.setTranslateZ(StickmanStage.recordCameraZPosition);

		cameraXSlider.setValue(0);
		cameraYSlider.setValue(0);
		cameraZSlider.setValue(0);
		StickmanStage.sCamera.getTransforms().clear();

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
			if (currentStickman.mType == Stickman3D.TYPE.MALE) {
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
				if (currentStickman.mType == Stickman3D.TYPE.MALE) {
					currentStickman.mMaleHairFX.mColor = currentStickman.mMaleHairFX.mColor.brighter();
					currentStickman.mMaleHairFX.update();
				} else {
					currentStickman.mFemaleHairFX.mColor = currentStickman.mFemaleHairFX.mColor.brighter();
					currentStickman.mFemaleHairFX.update();
				}
			} else if (ev.getSource().equals(hairColorDarker)) {
				if (currentStickman.mType == Stickman3D.TYPE.MALE) {
					currentStickman.mMaleHairFX.mColor = currentStickman.mMaleHairFX.mColor.darker();
					currentStickman.mMaleHairFX.update();
				} else {
					currentStickman.mFemaleHairFX.mColor = currentStickman.mFemaleHairFX.mColor.darker();
					currentStickman.mFemaleHairFX.update();
				}
			} else if (ev.getSource().equals(hairColorReset)) {
				if (currentStickman.mType == Stickman3D.TYPE.MALE) {
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

	public void getStickmanStageFX(StickmanStage Stickmanstage) {
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
				currentStickman.doAnimation(button.getText(), 500, false);
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
		currentStickman = StickmanStage.getStickmanFX(stickmanNames.get(0));
	}

	@FXML
	private void handleWithPerlinNoise() {

		for (String key : mStickmanstage.mStickmanComboList) {
			StickmanStage.getStickmanFX(key).doAnimation("StartIdle", 1000, true);
		}

	}

	@FXML
	private void handleWithoutPerlinNoise() {

		for (String key : mStickmanstage.mStickmanComboList) {
			StickmanStage.getStickmanFX(key).doAnimation("StopIdle", 1000, true);
		}
	}

}
