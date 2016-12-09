package de.dfki.stickman3D;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.ByteArrayInputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.ConsoleHandler;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

import de.dfki.stickman3D.animationlogic.Animation;
import de.dfki.stickman3D.animationlogic.AnimationLoader;
import de.dfki.stickman3D.animationlogic.EventAnimation;
import de.dfki.stickman3D.client.ClientConnectionHandler;
import de.dfki.stickman3D.util.Names;
import de.dfki.util.XMLParser;
import de.dfki.util.xml.XMLUtilities;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.SubScene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author Robbie and Beka
 *
 */
public class StickmanStage extends Application {

	static private final HashMap<String, Stickman3D> sStickmanHashMap = new HashMap<>();
	static public HBox sStickmanHBox;
	static private StickmanStage sInstance;
	ArrayList<String> mStickmanComboList = new ArrayList<>();

	// grahics
	private static float sScale = 1.0f;
	protected static boolean sFullScreen = false;
	protected static int mHeight = 0;
	protected static int mWidth = 0;

	// network interface
	public static ClientConnectionHandler mConnection;
	public static boolean mUseNetwork = false;
	private static String sHost = "127.0.0.1";
	private static int sPort = 7777;

	// logging
	public static final Logger mLogger = Logger.getAnonymousLogger();

	// Camera
	public static SubScene sSubscene;
	public static PerspectiveCamera sCamera;
	
	public static double recordCameraXPosition;
	public static double recordCameraYPosition;
	public static double recordCameraZPosition;

	public StickmanStage() {
		sStickmanHBox = new HBox();
		sStickmanHBox.setAlignment(Pos.CENTER);

		if (sFullScreen) {
			mLogger.info("Full Screen Mode ...");
			Dimension size = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
			mWidth = size.width;
			mHeight = size.height;
		}

		ConsoleHandler ch = new ConsoleHandler();
		ch.setFormatter(new StickmanStageLogFormatter());

		if (mUseNetwork) {
			mConnection = new ClientConnectionHandler();
			mConnection.connect(sHost, sPort);

			while (!mConnection.mConnected) {
				try {
					mLogger.info("Waiting for connection to control application ...");
					Thread.sleep(250);
				} catch (InterruptedException ex) {
					mLogger.severe(ex.getMessage());
				}
			}
		}
	}

	public static StickmanStage getInstance() {
		if (sInstance == null) {
			sInstance = new StickmanStage();
		}
		return sInstance;
	}

	public static StickmanStage getInstanceFullScreen() {
		sFullScreen = true;

		if (sInstance == null) {
			sInstance = new StickmanStage();
		}

		return sInstance;
	}

	public static StickmanStage getNetworkInstance() {
		mUseNetwork = true;

		return getInstance();
	}

	public static StickmanStage getNetworkInstanceFullScreen() {
		sFullScreen = true;

		mUseNetwork = true;

		return getInstance();
	}

	public static StickmanStage getNetworkInstance(String host, int port) {
		sHost = host;
		sPort = port;

		mUseNetwork = true;

		return getInstance();
	}

	public static StickmanStage getNetworkInstanceFullScreen(String host, int port) {
		sHost = host;
		sPort = port;

		mUseNetwork = true;

		sFullScreen = true;

		return getInstance();
	}

	public static void addStickmanFX(String name) {
		Stickman3D.TYPE gender = null;
		if (Names.sFemaleNames.contains(name.toLowerCase())) {
			gender = Stickman3D.TYPE.FEMALE;
		}

		if (Names.sMaleNames.contains(name.toLowerCase())) {
			gender = (gender == null) ? Stickman3D.TYPE.MALE : gender;
		}

		addStickmanFX(name, gender);
	}

	public static void addStickmanFX(String name, Stickman3D.TYPE gender) {
		if (!sStickmanHashMap.containsKey(name.toLowerCase())) {
			if (sFullScreen) {
				sStickmanHashMap.put(name.toLowerCase(),
						new Stickman3D(name, gender, mHeight / (float) Stickman3D.mDefaultSize.height * sScale,
								new Dimension(new Float(mHeight * 1 / 3 * sScale).intValue(),
										new Float(mHeight * sScale).intValue())));

				getStickmanFX(name).mShowName = true;
			} else {
				sStickmanHashMap.put(name.toLowerCase(), new Stickman3D(name, gender, sScale));
			}
			mLogger.info("Create Stickman " + name + ": Done");
		}

	}

	public static Stickman3D getStickmanFX(String name) {
		if (sStickmanHashMap.containsKey(name.toLowerCase())) {
			return sStickmanHashMap.get(name.toLowerCase());
		} else {
			return null;
		}
	}

	public static void clearStage() {
		Set<String> deleteStickman = new HashSet<>();
		sStickmanHashMap.keySet().stream().map((s) -> {
			deleteStickman.add(s);
			return s;
		}).forEach((s) -> {
			getStickmanFX(s).mAnimationSchedulerFX.end();
		});
		deleteStickman.stream().map((s) -> {
			sStickmanHBox.getChildren().remove(getStickmanFX(s));
			return s;
		}).forEach((s) -> {
			sStickmanHashMap.remove(s);
		});

		if (mUseNetwork) {
			mConnection.end();
		}

		sInstance = null;
	}

	public static void showStickmanNameFX(boolean show) {
		for (Stickman3D s : sStickmanHashMap.values()) {
			s.mShowName = show;
		}
	}

	public static void animate(String stickmanname, String type, String name, int duration, String text,
			boolean block) {
		Stickman3D sm = getStickmanFX(stickmanname);
		sm.doAnimation(name, duration, text, block);
	}

	public static void parseStickmanMLCmd(String cmd) {
		// TODO cut the crap with the two animation types ...
		Animation a = (cmd.contains("StickmanEventAnimation")) ? new EventAnimation() : new Animation();

		XMLUtilities.parseFromXMLStream(a, new ByteArrayInputStream(cmd.getBytes(Charset.forName("UTF-8"))));

		String stickmanname = a.mStickmanName;
		String animationname = a.mName;
		String id = a.mID;
		int duration = a.mDuration;
		boolean blocking = a.mBlocking;
		Object parameter = a.mParameter;
		if (stickmanname != null) {
			a = (a instanceof EventAnimation)
					? AnimationLoader.getInstance().loadEventAnimation(getStickmanFX(stickmanname), animationname,
							duration, blocking)
					: AnimationLoader.getInstance().loadAnimation(getStickmanFX(stickmanname), animationname, duration,
							blocking);

			a.setID(id); // give the animation the same id (TODO - This is bad
							// design and caused that the animation has to be
							// "reloaded"
			a.mParameter = parameter;

			a.mStickmanFX.playAnimation(a);
		}
	}

	public static void sendTimeMarkInformation(String timemark) {
		if (mConnection.mConnected) {
			mConnection.sendToServer(timemark);
		}
	}

	public static void sendAnimationUpdate(String state, String id) {
		if (mConnection.mConnected) {
			mConnection.sendToServer("#ANIM#" + state + "#" + id);
		}
	}

	@Override
	public void start(Stage stage) throws Exception {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/de/dfki/stickman3D/View.fxml"));
		HBox root = loader.load();

		Scene scene = new Scene(root, mWidth, mHeight, true, SceneAntialiasing.BALANCED);

		AnchorPane controlPanel = (AnchorPane) scene.lookup("#controlPanel");

		sSubscene = createSubSceneAndCamera(sStickmanHBox, mWidth - controlPanel.getPrefWidth(), mHeight);
		moveStickmanPane(scene);
		root.getChildren().add(sSubscene);

		// Add Stickmans into stickmanHBox
		for (String key : sStickmanHashMap.keySet()) {
			sStickmanHBox.getChildren().add(sStickmanHashMap.get(key));
			mStickmanComboList.add(key.substring(0, 1).toUpperCase() + key.substring(1));
			mLogger.info("Add Stickman " + sStickmanHashMap.get(key).mName + " into Stage: Done");
		}
		StickmanStageController mStickmanStageController = loader.getController();
		mStickmanStageController.getStickmanStageFX(this);
		// mStickmanStageController.setlePerlinNoiseOn();

		stage.setTitle("StickmanFX");
		stage.setScene(scene);
		scene.getStylesheets().add(this.getClass().getResource("StickmanCSS.css").toExternalForm());
		stage.show();

		stage.setFullScreen(true);
		scene.setOnMouseClicked(mouseHandler);

	}

	private void moveStickmanPane(Scene scene) {
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				if (event.getCode() == KeyCode.NUMPAD6) {
					sStickmanHBox.setTranslateX(sStickmanHBox.getTranslateX() + 20);
				} else if (event.getCode() == KeyCode.NUMPAD4) {
					sStickmanHBox.setTranslateX(sStickmanHBox.getTranslateX() - 20);
				} else if (event.getCode() == KeyCode.NUMPAD8) {
					sStickmanHBox.setTranslateY(sStickmanHBox.getTranslateY() - 20);
				} else if (event.getCode() == KeyCode.NUMPAD2) {
					sStickmanHBox.setTranslateY(sStickmanHBox.getTranslateY() + 20);
				}
			}
		});

		scene.setOnScroll(new EventHandler<ScrollEvent>() {

			@Override
			public void handle(ScrollEvent event) {
				if (event.getDeltaY() < 0) {
					sStickmanHBox.setScaleX(sStickmanHBox.getScaleX() - 0.05);
					sStickmanHBox.setScaleY(sStickmanHBox.getScaleY() - 0.05);
					sStickmanHBox.setScaleZ(sStickmanHBox.getScaleZ() - 0.05);
				} else {
					sStickmanHBox.setScaleX(sStickmanHBox.getScaleX() + 0.05);
					sStickmanHBox.setScaleY(sStickmanHBox.getScaleY() + 0.05);
					sStickmanHBox.setScaleZ(sStickmanHBox.getScaleZ() + 0.05);
				}
			}
		});
	}

	private static SubScene createSubSceneAndCamera(HBox root, double width, double height) {

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		sCamera = new PerspectiveCamera(true);
		
		int cameraZPosition = (int) dim.getWidth();
		if(cameraZPosition < 1400)
			cameraZPosition = 1400;
		
		sCamera.setTranslateZ(-cameraZPosition);
		sCamera.setTranslateX(width / 2);
		sCamera.setTranslateY(height / 2 + 50);
		
		recordCameraXPosition = sCamera.getTranslateX();
		recordCameraYPosition = sCamera.getTranslateY();
		recordCameraZPosition = sCamera.getTranslateZ();
		
		sCamera.setNearClip(0.8);
		sCamera.setFarClip(3000.0);
		sCamera.setFieldOfView(30);

		SubScene subScene = new SubScene(root, width, height, true, SceneAntialiasing.BALANCED);
		subScene.setFill(Color.rgb(216, 216, 216));
		return subScene;
	}

	public static void lauchStickman() {
		launch();
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {
		XMLParser.parse();
		getInstanceFullScreen();

		if (XMLParser.getStickmanNames() != null) {
			for (int i = 0; i < XMLParser.getStickmanNames().size(); i++) {
				addStickmanFX(XMLParser.getStickmanNames().get(i));
			}
		} else {
			addStickmanFX("Bob");
			 addStickmanFX("Anna");
		}

		// addStickmanFX("Anna");
		// addStickmanFX("character");

		lauchStickman();

	}

	// emotion: Angry, AngrySmallMouth, Contempt, Disgusted, Embarrassed,
	// Excited, Fear, Happy, Loved, Sad, Smile, Surprised
	// emotionStart: AngryStart, ContemptStart, DisgustedStart, FearStart,
	// AngrySmallMouthStart,
	// HappyStart, LovedStart, SadStart, SmileStart, SurprisedStart,
	// EmbarrassedStart, ExcitedStart
	// emotionEnd: AngryEnd, ContemptEnd, DisgustedEnd, FearEnd, HappyEnd,
	// AngrySmallMouthEnd,
	// LovedEnd, SadEnd, SmileEnd, SurprisedEnd, EmbarrassedEnd, ExcitedEnd
	// action: HeadShake, Nod2

	EventHandler<MouseEvent> mouseHandler = new EventHandler<MouseEvent>() {

		@Override
		public void handle(MouseEvent mouseEvent) {

			if (mouseEvent.getButton() == MouseButton.PRIMARY) {
				// getStickmanFX("Anna").doAnimation("Muster", 1000, true);
				getStickmanFX("Bob").doAnimation("Muster", 10, false);
			}
			// getStickmanFX("Bob").doAnimation("Speaking",3000, "Stell Dir vor,
			// Du kommst nach Hause, und ein Pferd steht in der Küche.",
			// false);
			// getStickmanFX("character").doAnimation("Muster", 1000, true);
			// getStickmanFX("Bob").doAnimation("BombeExplosion", 1000, true);
			// getStickmanFX("Bob").doAnimation("Speaking", 3000, "Stell Dir
			// vor, Du kommst nach Hause, und ein Pferd steht in der Küche.",
			// false);
			// if(mouseEvent.getButton().equals(MouseButton.SECONDARY)){
			// getStickmanFX("Bob").doAnimation("FadeIn", 1000, true);
			// getStickmanFX("Anna").doAnimation("FadeIn", 1000, true);
			// }else{
			// getStickmanFX("Bob").doAnimation("FadeOut", 1000, true);
			// getStickmanFX("Anna").doAnimation("FadeOut", 1000, true);
			// }
			//
		}

	};

	private static class StickmanStageLogFormatter extends Formatter {

		@Override
		public String format(LogRecord record) {
			return ((new StringBuffer()).append(record.getLevel()).append(": ").append(record.getMessage())
					.append("\n")).toString();
		}
	}
}
