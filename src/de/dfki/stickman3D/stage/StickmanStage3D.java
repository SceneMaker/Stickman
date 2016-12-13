package de.dfki.stickman3D.stage;

import de.dfki.common.commonFX3D.ApplicationLauncherImpl;
import de.dfki.common.StickmansOnStage;
import de.dfki.common.interfaces.StickmanStage;
import de.dfki.stickmanFX.stage.StageRoomFX;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.input.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.*;
import java.util.logging.ConsoleHandler;
import java.util.logging.Logger;

/**
 *
 * @author Robbie and Beka
 *
 */
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
public class StickmanStage3D extends Application implements StickmanStage {

    public static final float STICKMAN_SIZE_FACTOR = 0.8f;
    public static final float HEIGHT_ADJUSTMENT = 3 / 5.0f;
    public static final float STICKMAN_IN_BETWEEN_DISTANCE_FACTOR = 0.9f;
    public static final String STICKMAN_STAGE = "StickmanStageSwing";

    // grahics
    protected int mHeight = 0;
    protected int mWidth = 0;

    static private StickmanStage3D sInstance;
    Stage configStage;
    private HashMap<String, StickmansOnStage> stickamnsOnStage = new HashMap<>();
    private float sScale = 1.0f;
    private Map<String, Stage> stickmanFXStages = new HashMap<>();
    private StagePaneHandler3D generalConfigStageRoot;

    // logging
    public final Logger mLogger = Logger.getAnonymousLogger();

    // Camera
    public SubScene sSubscene;
    public PerspectiveCamera sCamera;

    public StickmanStage3D() {
        Platform.setImplicitExit(false);
        ConsoleHandler ch = new ConsoleHandler();
        sInstance = this;
        generalConfigStageRoot = new StagePaneHandler3D();
    }

    public static StickmanStage3D getInstance() {
        if (sInstance == null) {
            sInstance = new StickmanStage3D();
        }
        return sInstance;
    }

    public void clearStage(String stageIdentifier) {
        try {
            HBox pane = getStickmanPane(stageIdentifier);
            Platform.runLater(() -> {
                pane.getChildren().clear();
                Stage stage = stickmanFXStages.get(stageIdentifier);
                stage.close();
                stickmanFXStages.remove(stageIdentifier);
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
        sInstance = null;
    }

    @Override
    public void start(Stage stage) throws Exception {

        HBox sStickmanHBox = new HBox();
        sStickmanHBox.setId("StickmanStage3D");
        sStickmanHBox.setAlignment(Pos.CENTER);
//        sStickmanHBox.setPadding(new javafx.geometry.Insets(580, 0, 150, 0));

        HBox root = generalConfigStageRoot.getConfigRoot();
        Scene scene = new Scene(root, mWidth, mHeight, true, SceneAntialiasing.BALANCED);

        configStage = stage;
        AnchorPane controlPanel = (AnchorPane) scene.lookup("#controlPanel");

        sSubscene = createSubSceneAndCamera(sStickmanHBox, 1940, 1080);
        moveStickmanPane(scene, sStickmanHBox);
        root.getChildren().add(sSubscene);

        scene.getStylesheets().add("de.dfki.stickman3D.css.StickmanCSS.css");
        stage.setTitle("Stickman3D");
        stage.setScene(scene);
        // sStickmanHBox.setMouseTransparent(true);
        stickmanFXStages.put(StageRoomFX.CONFIG_STAGE, stage);

        ApplicationLauncherImpl.setIsRunning();
        //stage.show();

        //stage.setFullScreen(true);
        //scene.setOnMouseClicked(mouseHandler);
    }

    private void moveStickmanPane(Scene scene, HBox sStickmanHBox) {
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

    private SubScene createSubSceneAndCamera(HBox root, double width, double height) {

        sCamera = new PerspectiveCamera(true);
        sCamera.setTranslateZ(-1400);
        sCamera.setTranslateX(width - 450);
        sCamera.setTranslateY(height / 2 + 50);
        sCamera.setNearClip(0.8);
        sCamera.setFarClip(3000.0);
        sCamera.setFieldOfView(30);

//		root.setStyle("-fx-background-color: red");
        SubScene subScene = new SubScene(root, width, height, true, SceneAntialiasing.BALANCED);
        return subScene;
    }

    public void lauchStickman() {
        launch();
    }

    @Override
    public float getFullScreenScale() {
        return getHeight() / (float) de.dfki.stickmanFX.StickmanFX.mDefaultSize.height * sScale * STICKMAN_SIZE_FACTOR;
    }

    @Override
    public Dimension getFullScreenDimension() {
        return new Dimension(new Float(getHeight() * HEIGHT_ADJUSTMENT * sScale).intValue(),
                new Float(getHeight() * sScale * STICKMAN_IN_BETWEEN_DISTANCE_FACTOR).intValue());
    }

    private float getHeight() {
        Dimension size = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        return size.height;
    }

    @Override
    public void addStickmanToStage(String stageIdentifier) throws Exception {
        HBox sStickmanPane;
        Platform.runLater(() -> {
            final HBox pane;
            try {
                pane = getStickmanPane(stageIdentifier);
                //pane.getChildren().clear();
                for (String key : stickamnsOnStage.get(stageIdentifier).getStickmanNames()) {
                    pane.getChildren().add((Node) stickamnsOnStage.get(stageIdentifier).getStickmanByKey(key));
                    addStickmanName(key);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        });

    }

    @Override
    public void setStageFullScreen(String stageIdentifier) {
        setFullScreen(stageIdentifier, true);
    }

    @Override
    public void setStageNonFullScreen(String stageIdentifier) {
        setFullScreen(stageIdentifier, false);
    }

    private void setFullScreen(String stageIdentifier, boolean value) {
        if (stickmanFXStages.containsKey(stageIdentifier)) {
            int a = 0;
            Platform.runLater(() -> stickmanFXStages.get(stageIdentifier).setFullScreen(value));
        }
    }

    @Override
    public void setStickamnsOnStage(StickmansOnStage stickamnsOnStage, String identifier) {
        this.stickamnsOnStage.put(identifier, stickamnsOnStage);
        generalConfigStageRoot.setStickmansOnStage(stickamnsOnStage);
    }

    @Override
    public HBox getStickmanPane(String stageIdentifier) throws Exception {
        HBox sStickmanPane;
        Stage stage = stickmanFXStages.get(stageIdentifier);

        if (stickmanFXStages.containsKey(stageIdentifier)) {
            sStickmanPane = (HBox) stickmanFXStages.get(stageIdentifier).getScene().getRoot();
            sStickmanPane.setAlignment(Pos.CENTER);
            sStickmanPane.setStyle("-fx-background-color: white");
            sStickmanPane.setOnKeyPressed(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent event) {
                    System.out.println(".handle()");
                }

            });

            stage.getScene().setOnKeyPressed(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent event) {
                    if (event.getCode() == KeyCode.RIGHT) {
                        sStickmanPane.setTranslateX(sStickmanPane.getTranslateX() + 20);
                    } else if (event.getCode() == KeyCode.LEFT) {
                        sStickmanPane.setTranslateX(sStickmanPane.getTranslateX() - 20);
                    } else if (event.getCode() == KeyCode.UP) {
                        sStickmanPane.setTranslateY(sStickmanPane.getTranslateY() - 20);
                    } else if (event.getCode() == KeyCode.DOWN) {
                        sStickmanPane.setTranslateY(sStickmanPane.getTranslateY() + 20);
                    }
                }
            });

            stage.getScene().setOnScroll(new EventHandler<ScrollEvent>() {

                @Override
                public void handle(ScrollEvent event) {
                    if (event.getDeltaY() < 0) {
                        sStickmanPane.setScaleX(sStickmanPane.getScaleX() - 0.05);
                        sStickmanPane.setScaleY(sStickmanPane.getScaleY() - 0.05);
                        sStickmanPane.setScaleZ(sStickmanPane.getScaleZ() - 0.05);
                    } else {
                        sStickmanPane.setScaleX(sStickmanPane.getScaleX() + 0.05);
                        sStickmanPane.setScaleY(sStickmanPane.getScaleY() + 0.05);
                        sStickmanPane.setScaleZ(sStickmanPane.getScaleZ() + 0.05);
                    }
                }
            });

            return (sStickmanPane.getId() != null && sStickmanPane.getId().equals(STICKMAN_STAGE)) ? sStickmanPane : findStagePane(sStickmanPane);
        } else {
            throw new Exception("Stage Not found");
        }
    }

    private HBox findStagePane(HBox sStickmanPane) throws Exception {
        //((HBox)((SubScene)pane.getChildren().get(1)).getRoot()).getChildren().add((Node) stickamnsOnStage.getStickmanByKey(key));
        for (Node child : sStickmanPane.getChildren()) {
            if (child instanceof SubScene && ((SubScene) child).getRoot().getId().equals(STICKMAN_STAGE)) {
                return (HBox) ((SubScene) child).getRoot();
            }
        }
        throw new Exception("Stage Not found");
    }

    @Override
    public BufferedImage getStageAsImage(String stageIdentifier) throws Exception {
        return null;
    }

    @Override
    public void addStickmanToStage(String stageIdentifier, de.dfki.stickmanFX.StickmanFX sman) throws Exception {
        HBox sStickmanPane;
        sStickmanPane = getStickmanPane(stageIdentifier);
        sStickmanPane.getChildren().clear();
        sStickmanPane.getChildren().add(sman);
    }

    private void addStickmanName(String key) {
        generalConfigStageRoot.getmStickmanStageController().fillComboForStickman();
    }

    public void showStage(String stageIdentifier) {
        if (stickmanFXStages.containsKey(stageIdentifier)) {
            Platform.runLater(() -> stickmanFXStages.get(stageIdentifier).show());
        }
    }

    public PerspectiveCamera getCamera() {
        return sCamera;
    }

    public SubScene getSubScene() {
        return sSubscene;
    }

    public String createNewStage(int x, int y, boolean decoration) throws IOException {
        String uuid = UUID.randomUUID().toString();
        try {
            createStage(uuid, x, y, decoration);
            waitForCreatingStage(uuid);
        } catch (IOException e) {
            throw e;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return uuid;
    }

    public void waitForCreatingStage(String uuid) throws InterruptedException {
        while (!stickmanFXStages.containsKey(uuid)) {
            Thread.sleep(200);
        }
    }

    // public void createStage(String uuid) throws IOException {
    public void createStage(String uuid, int x, int y, boolean decoration) throws IOException {
        final HBox root = getStageRoot();
        Platform.runLater(() -> {
            root.setAlignment(Pos.BASELINE_CENTER);
            root.getHeight();
            Scene stageScene = new Scene(root, mWidth, mHeight, true, SceneAntialiasing.BALANCED);
            Stage stage = new Stage();
            stage.setScene(stageScene);
            stage.setX(x);
            stage.setY(y);
            if (!decoration) {
                stage.initStyle(StageStyle.UNDECORATED);
            }
            stickmanFXStages.put(uuid, stage);

            /// added by R
            //stageScene.setOnMouseClicked(mouseHandler);
        });
    }

    public void runLater(Runnable function) {
        Platform.runLater(function);
    }

    private HBox getStageRoot() throws java.io.IOException {
        StagePaneHandler3D generalStageRoot = new StagePaneHandler3D();
        HBox pane = generalStageRoot.getStageRoot();
        pane.setId(STICKMAN_STAGE);
        return pane;
    }

}
