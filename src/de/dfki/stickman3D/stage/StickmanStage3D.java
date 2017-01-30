package de.dfki.stickman3D.stage;

import de.dfki.common.commonFX3D.ApplicationLauncherImpl;
import de.dfki.common.StickmansOnStage;
import de.dfki.common.interfaces.StickmanStage;
import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.StickmanStageController;
import de.dfki.stickmanFX.stage.StageRoomFX;
import javafx.application.Application;
import javafx.application.Platform;
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
public class StickmanStage3D extends Application implements StickmanStage {

    private static final float STICKMAN_SIZE_FACTOR = 0.8f;
    private static final float HEIGHT_ADJUSTMENT = 3 / 5.0f;
    private static final float STICKMAN_IN_BETWEEN_DISTANCE_FACTOR = 0.9f;
    private static final String STICKMAN_STAGE = "StickmanStage3D";

    private final int mHeight = 0;
    private final int mWidth = 0;

    static private StickmanStage3D sInstance;
    private final HashMap<String, StickmansOnStage> stickamnsOnStage = new HashMap<>();
    private final float sScale;
    private final Map<String, Stage> stickmanStages = new HashMap<>();
    private final StagePaneHandler3D generalConfigStageRoot;

    //logging
    public static final Logger LOGGER = Logger.getAnonymousLogger();

    private boolean showControlPanel = false;

    // Camera
    private SubScene sSubscene;
    private PerspectiveCamera mCamera;
    private HBox mStickmanHBox;
    private double recordCameraXPosition;
    private double recordCameraYPosition;
    private double recordCameraZPosition;

    public StickmanStage3D() {
        this.sScale = 1.0f;
        Platform.setImplicitExit(false);
        ConsoleHandler ch = new ConsoleHandler();
        sInstance = this;
        generalConfigStageRoot = new StagePaneHandler3D();
    }

    /**
     *
     * @return StickmanStage3D
     */
    public static StickmanStage3D getInstance() {
        if (sInstance == null) {
            sInstance = new StickmanStage3D();
        }
        return sInstance;
    }

    /**
     *
     * @param stageIdentifier
     */
    @Override
    public void clearStage(String stageIdentifier) {
        try {
            HBox box = getStickmanBox(stageIdentifier);
            Platform.runLater(() -> {
                box.getChildren().clear();
                Stage stage = stickmanStages.get(stageIdentifier);
                stage.close();
                stickmanStages.remove(stageIdentifier);
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
        sInstance = null;
    }

    @Override
    public void start(Stage stage) throws Exception {

        mStickmanHBox = new HBox();
        mStickmanHBox.setId("StickmanStage3D");
        mStickmanHBox.setAlignment(Pos.CENTER);

        HBox root = generalConfigStageRoot.getConfigRoot();
        Scene scene = new Scene(root, mWidth, mHeight, true, SceneAntialiasing.BALANCED);
        scene.getStylesheets().add("de/dfki/stickman3D/stage/Style.css");

        AnchorPane controlPanel = (AnchorPane) scene.lookup("#controlPanel");

        sSubscene = createSubSceneAndCamera(getmStickmanHBox(), getWidth() - controlPanel.getPrefWidth(), getHeight());
        root.getChildren().add(sSubscene);

        stage.setTitle("Stickman3D");
        stage.setScene(scene);
        stickmanStages.put(StageRoomFX.CONFIG_STAGE, stage);

        ApplicationLauncherImpl.setIsRunning();
    }

    private SubScene createSubSceneAndCamera(HBox root, double width, double height) {

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        mCamera = new PerspectiveCamera(true);

        int cameraZPosition = (int) dim.getWidth();
        if (cameraZPosition < 1400) {
            cameraZPosition = 1400;
        }

        mCamera.setTranslateZ(-cameraZPosition);
        mCamera.setTranslateX(width / 2);
        mCamera.setTranslateY(height / 2 + 50);

        recordCameraXPosition = mCamera.getTranslateX();
        recordCameraYPosition = mCamera.getTranslateY();
        recordCameraZPosition = mCamera.getTranslateZ();

        mCamera.setNearClip(0.8);
        mCamera.setFarClip(3000.0);
        mCamera.setFieldOfView(30);

        SubScene subScene = new SubScene(root, width, height, true, SceneAntialiasing.BALANCED);
        subScene.setFill(javafx.scene.paint.Color.rgb(216, 216, 216));
        return subScene;
    }

    @Override
    public void lauchStickman() {
        launch();
    }

    /**
     *
     * @return FullScreenScale
     */
    @Override
    public float getFullScreenScale() {
        return getHeight() / (float) de.dfki.stickmanFX.StickmanFX.mDefaultSize.height * sScale * STICKMAN_SIZE_FACTOR;
    }

    /**
     *
     * @return FullScreenDimension
     */
    @Override
    public Dimension getFullScreenDimension() {
        return new Dimension(new Float(getHeight() * HEIGHT_ADJUSTMENT * sScale).intValue(),
                new Float(getHeight() * sScale * STICKMAN_IN_BETWEEN_DISTANCE_FACTOR).intValue());
    }

    private float getHeight() {
        Dimension size = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        return size.height;
    }

    private float getWidth() {
        Dimension size = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        return size.width;
    }

    /**
     *
     * @param stageIdentifier
     * @throws Exception
     */
    @Override
    public void addStickmanToStage(String stageIdentifier) throws Exception {
        Platform.runLater(() -> {
            final HBox box;
            try {
                box = getStickmanBox(stageIdentifier);
                for (String key : stickamnsOnStage.get(stageIdentifier).getStickmanNames()) {
                    Stickman3D sman3D = (Stickman3D) stickamnsOnStage.get(stageIdentifier).getStickmanByKey(key);

                    if (isShowControlPanel()) {
                        sman3D.setScale(1.35f);
                        sman3D.isFullScreen = true;
                        sman3D.update();
                    }
                    box.getChildren().add((Node) sman3D);
                    addStickmanName(key);
                    ((StickmanStageController) generalConfigStageRoot.getmStickmanStageController()).setStage3D(this);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        });

    }

    /**
     *
     * @param stageIdentifier
     */
    @Override
    public void setStageFullScreen(String stageIdentifier) {
        setFullScreen(stageIdentifier, true);
    }

    /**
     *
     * @param stageIdentifier
     */
    @Override
    public void setStageNonFullScreen(String stageIdentifier) {
        setFullScreen(stageIdentifier, false);
    }

    private void setFullScreen(String stageIdentifier, boolean value) {
        if (stickmanStages.containsKey(stageIdentifier)) {
            int a = 0;
            Platform.runLater(() -> stickmanStages.get(stageIdentifier).setFullScreen(value));
        }
    }

    /**
     *
     * @param stickamnsOnStage
     * @param identifier
     */
    @Override
    public void setStickamnsOnStage(StickmansOnStage stickamnsOnStage, String identifier) {
        this.stickamnsOnStage.put(identifier, stickamnsOnStage);
        generalConfigStageRoot.setStickmansOnStage(stickamnsOnStage);
    }

    /**
     *
     * @param stageIdentifier
     * @return
     * @throws Exception
     */
    @Override
    public HBox getStickmanBox(String stageIdentifier) throws Exception {
        HBox box;
        Stage stage = stickmanStages.get(stageIdentifier);

        if (stickmanStages.containsKey(stageIdentifier)) {
            box = (HBox) stickmanStages.get(stageIdentifier).getScene().getRoot();
            box.setAlignment(Pos.CENTER);
            box.setStyle("-fx-background-color: white");

            stage.getScene().setOnKeyPressed((KeyEvent event) -> {
                if (null != event.getCode()) {
                    switch (event.getCode()) {
                        case RIGHT:
                            mStickmanHBox.setTranslateX(getmStickmanHBox().getTranslateX() + 20);
                            break;
                        case LEFT:
                            mStickmanHBox.setTranslateX(getmStickmanHBox().getTranslateX() - 20);
                            break;
                        case UP:
                            mStickmanHBox.setTranslateY(getmStickmanHBox().getTranslateY() - 20);
                            break;
                        case DOWN:
                            mStickmanHBox.setTranslateY(getmStickmanHBox().getTranslateY() + 20);
                            break;
                        default:
                            break;
                    }
                }
            });

            stage.getScene().setOnScroll((ScrollEvent event) -> {
                if (event.getDeltaY() < 0) {
                    mStickmanHBox.setScaleX(getmStickmanHBox().getScaleX() - 0.05);
                    mStickmanHBox.setScaleY(getmStickmanHBox().getScaleY() - 0.05);
                    mStickmanHBox.setScaleZ(getmStickmanHBox().getScaleZ() - 0.05);
                } else {
                    mStickmanHBox.setScaleX(getmStickmanHBox().getScaleX() + 0.05);
                    mStickmanHBox.setScaleY(getmStickmanHBox().getScaleY() + 0.05);
                    mStickmanHBox.setScaleZ(getmStickmanHBox().getScaleZ() + 0.05);
                }
            });

            return (box.getId() != null && box.getId().equals(STICKMAN_STAGE)) ? box : findStageBox(box);
        } else {
            throw new Exception("Stage Not found");
        }
    }

    private HBox findStageBox(HBox stickmanBox) throws Exception {
        for (Node child : stickmanBox.getChildren()) {
            if (child instanceof SubScene && ((SubScene) child).getRoot().getId().equals(STICKMAN_STAGE)) {
                return (HBox) ((SubScene) child).getRoot();
            }
        }
        throw new Exception("Stage Not found");
    }

    /**
     *
     * @param stageIdentifier
     * @return
     * @throws Exception
     */
    @Override
    public BufferedImage getStageAsImage(String stageIdentifier) throws Exception {
        return null;
    }

    /**
     *
     * @param stageIdentifier
     * @param sman
     * @throws Exception
     */
    @Override
    public void addStickmanToStage(String stageIdentifier, de.dfki.stickmanFX.StickmanFX sman) throws Exception {
        HBox stickmanBox;
        stickmanBox = getStickmanBox(stageIdentifier);
        stickmanBox.getChildren().clear();
        stickmanBox.getChildren().add(sman);
    }

    private void addStickmanName(String key) {
        generalConfigStageRoot.getmStickmanStageController().fillComboForStickman();
    }

    /**
     *
     * @param stageIdentifier
     */
    @Override
    public void showStage(String stageIdentifier) {
        if (stageIdentifier.equals(StageRoom3D.CONFIG_STAGE)) {
            Platform.runLater(() -> stickmanStages.get(stageIdentifier).setFullScreen(true));
        }
        if (stickmanStages.containsKey(stageIdentifier)) {
            Platform.runLater(() -> stickmanStages.get(stageIdentifier).show());
        }
    }

    /**
     *
     * @param x
     * @param y
     * @param decoration
     * @return
     * @throws IOException
     */
    @Override
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

    /**
     *
     * @param uuid
     * @throws InterruptedException
     */
    public void waitForCreatingStage(String uuid) throws InterruptedException {
        while (!stickmanStages.containsKey(uuid)) {
            Thread.sleep(200);
        }
    }

    /**
     *
     * @param uuid
     * @param x
     * @param y
     * @param decoration
     * @throws IOException
     */
    public void createStage(String uuid, int x, int y, boolean decoration) throws IOException {
        final HBox root = getStageRoot();
        Platform.runLater(() -> {
            root.setAlignment(Pos.BASELINE_CENTER);
            root.getHeight();
            Scene stageScene = new Scene(root, 600, 600, true, SceneAntialiasing.BALANCED);
            Stage stage = new Stage();
            stage.setScene(stageScene);
            stage.setX(x);
            stage.setY(y);
            stage.setResizable(false);
            if (!decoration) {
                stage.initStyle(StageStyle.UNDECORATED);
            }
            stickmanStages.put(uuid, stage);
        });
    }

    /**
     *
     * @param function
     */
    public void runLater(Runnable function) {
        Platform.runLater(function);
    }

    private HBox getStageRoot() throws java.io.IOException {
        StagePaneHandler3D generalStageRoot = new StagePaneHandler3D();
        HBox box = generalStageRoot.getStageRoot();
        box.setId(STICKMAN_STAGE);
        return box;
    }

    /**
     * @return the showControlPanel
     */
    public boolean isShowControlPanel() {
        return showControlPanel;
    }

    /**
     * @param showControlPanel the showControlPanel to set
     */
    public void setShowControlPanel(boolean showControlPanel) {
        this.showControlPanel = showControlPanel;
    }

    /**
     * @return the mStickmanHBox
     */
    public HBox getmStickmanHBox() {
        return mStickmanHBox;
    }

    /**
     * @param mStickmanHBox the mStickmanHBox to set
     */
    public void setmStickmanHBox(HBox mStickmanHBox) {
        this.mStickmanHBox = mStickmanHBox;
    }

    /**
     * @return the recordCameraXPosition
     */
    public double getRecordCameraXPosition() {
        return recordCameraXPosition;
    }

    /**
     * @param recordCameraXPosition the recordCameraXPosition to set
     */
    public void setRecordCameraXPosition(double recordCameraXPosition) {
        this.recordCameraXPosition = recordCameraXPosition;
    }

    /**
     * @return the recordCameraYPosition
     */
    public double getRecordCameraYPosition() {
        return recordCameraYPosition;
    }

    /**
     * @return the recordCameraZPosition
     */
    public double getRecordCameraZPosition() {
        return recordCameraZPosition;
    }
    
     public PerspectiveCamera getCamera() {
        return mCamera;
    }

    public SubScene getSubScene() {
        return sSubscene;
    }
}
