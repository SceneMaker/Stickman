package de.dfki.reeti.stage;

import de.dfki.common.commonFX3D.ApplicationLauncherImpl;
import de.dfki.common.StickmansOnStage;
import de.dfki.common.interfaces.StickmanStage;
import de.dfki.reeti.Reeti;
import de.dfki.reeti.ReetiStageController;
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

/**
 *
 * @author Robbie and Beka
 *
 */
public class ReetiStage extends Application implements StickmanStage {

    private static final float REETI_SIZE_FACTOR = 0.8f;
    private static final float HEIGHT_ADJUSTMENT = 3 / 5.0f;
    private static final float REETI_IN_BETWEEN_DISTANCE_FACTOR = 0.9f;
    private static final String REETI_STAGE = "ReetiStage3D"; //?????????????

    private boolean showControlPanel = false;
    private final float mScale;

    private Stage mainStage = null;
    static private ReetiStage sInstance = null;
    private final Map<String, StickmansOnStage> reetisOnStage = new HashMap<>();
    private final Map<String, Stage> reetiStages = new HashMap<>();

    private final StagePaneHandlerReeti generalConfigStageRoot;

    // Camera
    private SubScene mSubscene = null;
    private PerspectiveCamera mCamera = null;
    private HBox mReetiHBox = null;
    private double recordCameraXPosition = 0;
    private double recordCameraYPosition = 0;
    private double recordCameraZPosition = 0;

    public ReetiStage() {
        this.mScale = 1.0f;
        Platform.setImplicitExit(false);
        ConsoleHandler ch = new ConsoleHandler(); //????????????????
        sInstance = this;
        generalConfigStageRoot = new StagePaneHandlerReeti();
    }

    /**
     *
     * @return ReetiStage
     */
    public static ReetiStage getInstance() {
        if (null == sInstance) {
            sInstance = new ReetiStage();
        }
        return sInstance;
    }

    /**
     *
     * @param stageIdentifier Stage ID
     */
    @Override
    public void clearStage(String stageIdentifier) {
        try {
            HBox box = getStickmanBox(stageIdentifier);
            Platform.runLater(() -> {
                box.getChildren().clear();
                Stage stage = reetiStages.get(stageIdentifier);
                stage.close();
                reetiStages.remove(stageIdentifier);
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
        sInstance = null;
    }

    @Override
    public void start(Stage stage) throws Exception {

        int height = 0;
        int width = 0;
        mReetiHBox = new HBox();
        mReetiHBox.setId("ReetiStage3D");
        mReetiHBox.setAlignment(Pos.CENTER);
        mainStage = stage;

        HBox root = generalConfigStageRoot.getConfigRoot();
        Scene scene = new Scene(root, width, height, true, SceneAntialiasing.BALANCED);
        scene.getStylesheets().add("de/dfki/reeti/stage/Style.css");

        AnchorPane controlPanel = (AnchorPane) scene.lookup("#controlPanel");

        mSubscene = createSubSceneAndCamera(getmReetiHBox(), getWidth() - controlPanel.getPrefWidth(), getHeight());
        root.getChildren().add(mSubscene);

        stage.setTitle("Reeti");
        stage.setScene(scene);
        reetiStages.put(StageRoomFX.CONFIG_STAGE, stage);

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
        return getHeight() / (float) de.dfki.stickmanFX.StickmanFX.mDefaultSize.height * mScale * REETI_SIZE_FACTOR;
    }

    /**
     *
     * @return FullScreenDimension
     */
    @Override
    public Dimension getFullScreenDimension() {
        return new Dimension(new Float(getHeight() * HEIGHT_ADJUSTMENT * mScale).intValue(),
                new Float(getHeight() * mScale * REETI_IN_BETWEEN_DISTANCE_FACTOR).intValue());
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
     * @param stageIdentifier Stage ID
     */
    @Override
    public void addStickmanToStage(String stageIdentifier) throws Exception {
        Platform.runLater(() -> {
            final HBox box;
            try {
                box = getStickmanBox(stageIdentifier);
                for (String key : reetisOnStage.get(stageIdentifier).getStickmanNames()) {
                    Reeti sman3D = (Reeti) reetisOnStage.get(stageIdentifier).getStickmanByKey(key);

                    if (isShowControlPanel()) {
                        sman3D.setScale(1.35f);
                        sman3D.isFullScreen = true;
                        sman3D.update();
                    }
                    box.getChildren().add((Node) sman3D);
                    addStickmanName(key);
                    ((ReetiStageController) generalConfigStageRoot.getmStickmanStageController()).setStage3D(this);
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
        if (reetiStages.containsKey(stageIdentifier)) {
            Platform.runLater(() -> reetiStages.get(stageIdentifier).setFullScreen(value));
        }
    }

    /**
     *
     * @param stickamnsOnStage
     * @param identifier
     *
     */
    @Override
    public void setStickamnsOnStage(StickmansOnStage stickamnsOnStage, String identifier) {
        this.reetisOnStage.put(identifier, stickamnsOnStage);
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
        Stage stage = reetiStages.get(stageIdentifier);

        if (reetiStages.containsKey(stageIdentifier)) {
            box = (HBox) reetiStages.get(stageIdentifier).getScene().getRoot();
            box.setAlignment(Pos.CENTER);
            box.setStyle("-fx-background-color: white");

            stage.getScene().setOnKeyPressed((KeyEvent event) -> {
                if (null != event.getCode()) {
                    switch (event.getCode()) {
                        case RIGHT:
                            mReetiHBox.setTranslateX(getmReetiHBox().getTranslateX() + 20);
                            break;
                        case LEFT:
                            mReetiHBox.setTranslateX(getmReetiHBox().getTranslateX() - 20);
                            break;
                        case UP:
                            mReetiHBox.setTranslateY(getmReetiHBox().getTranslateY() - 20);
                            break;
                        case DOWN:
                            mReetiHBox.setTranslateY(getmReetiHBox().getTranslateY() + 20);
                            break;
                        default:
                            break;
                    }
                }
            });

            stage.getScene().setOnScroll((ScrollEvent event) -> {
                if (event.getDeltaY() < 0) {
                    mReetiHBox.setScaleX(getmReetiHBox().getScaleX() - 0.05);
                    mReetiHBox.setScaleY(getmReetiHBox().getScaleY() - 0.05);
                    mReetiHBox.setScaleZ(getmReetiHBox().getScaleZ() - 0.05);
                } else {
                    mReetiHBox.setScaleX(getmReetiHBox().getScaleX() + 0.05);
                    mReetiHBox.setScaleY(getmReetiHBox().getScaleY() + 0.05);
                    mReetiHBox.setScaleZ(getmReetiHBox().getScaleZ() + 0.05);
                }
            });

            return (box.getId() != null && box.getId().equals(REETI_STAGE)) ? box : findStageBox(box);
        } else {
            throw new Exception("Stage Not found");
        }
    }

    private HBox findStageBox(HBox stickmanBox) throws Exception {
        for (Node child : stickmanBox.getChildren()) {
            if (child instanceof SubScene && ((SubScene) child).getRoot().getId().equals(REETI_STAGE)) {
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
        if (stageIdentifier.equals(StageRoomReeti.CONFIG_STAGE)) {
            Platform.runLater(() -> reetiStages.get(stageIdentifier).setFullScreen(true));
        }
        if (reetiStages.containsKey(stageIdentifier)) {
            Platform.runLater(() -> reetiStages.get(stageIdentifier).show());
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
        while (!reetiStages.containsKey(uuid)) {
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
            stage.setResizable(true);
            if (!decoration) {
                stage.initStyle(StageStyle.UNDECORATED);
            }
            reetiStages.put(uuid, stage);
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
        StagePaneHandlerReeti generalStageRoot = new StagePaneHandlerReeti();
        HBox box = generalStageRoot.getStageRoot();
        box.setId(REETI_STAGE);
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
     * @return the mReetiHBox
     */
    public HBox getmReetiHBox() {
        return mReetiHBox;
    }

    /**
     * @param mReetiHBox the mReetiHBox to set
     */
    public void setmReetiHBox(HBox mReetiHBox) {
        this.mReetiHBox = mReetiHBox;
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
        return mSubscene;
    }

    public Stage getMainStage() {
        return mainStage;
    }
}
