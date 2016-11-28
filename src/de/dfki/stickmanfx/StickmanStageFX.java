package de.dfki.stickmanfx;

import de.dfki.common.ApplicationLauncherImpl;
import de.dfki.common.StickmansOnStage;
import de.dfki.common.GeneralStageRoot;
import de.dfki.common.interfaces.StageStickman;
import de.dfki.stickmanfx.stagecontroller.StageStickmanControllerFX;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.logging.ConsoleHandler;

/**
 * @author Robbie. Refactored by: acepero13
 */
public class StickmanStageFX extends Application implements StageStickman {
    public static final float STICKMAN_SIZE_FACTOR = 0.8f;
    public static final float HEIGHT_ADJUSTMENT = 3 / 5.0f;
    public static final float STICKMAN_IN_BETWEEN_DISTANCE_FACTOR = 0.9f;
    static private StickmanStageFX sInstance;
    Stage configStage;
    private HashMap<String,StickmansOnStage> stickamnsOnStage = new HashMap<>();
    private float sScale = 1.0f;
    private Map<String, Stage> stickmanFXStages = new HashMap<>();
    private LinkedList<String> stickmanNames = new LinkedList<>();
    private GeneralStageRoot generalConfigStageRoot;

    public StickmanStageFX() { // This cannot be private because of
        // ApplicationFX
        Platform.setImplicitExit(false);
        ConsoleHandler ch = new ConsoleHandler();
        sInstance = this;
        generalConfigStageRoot = new GeneralStageRoot();
    }

    public static StickmanStageFX getInstance() {
        return sInstance;
    }

    public float getFullScreenScale() {
        return getHeight() / (float) StickmanFX.mDefaultSize.height * sScale * STICKMAN_SIZE_FACTOR;
    }

    public Dimension getFullScreenDimension() {
        return new Dimension(new Float(getHeight() * HEIGHT_ADJUSTMENT * sScale).intValue(),
                new Float(getHeight() * sScale * STICKMAN_IN_BETWEEN_DISTANCE_FACTOR).intValue());
    }

    private float getHeight() {
        Dimension size = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        return size.height;
    }

    public void start(Stage stage) throws Exception {
        configStage = stage;
        HBox root = generalConfigStageRoot.getConfigRoot();
        Scene scene = new Scene(root);
        scene.getStylesheets().add(this.getClass().getResource("StickmanCSS.css").toExternalForm());
        stage.setTitle("Stickman3D");
        stage.setScene(scene);
        stickmanFXStages.put(StageStickmanControllerFX.CONFIG_STAGE, stage);
        ApplicationLauncherImpl.setIsRunning();
    }

    private HBox getStageRoot() throws java.io.IOException {
        GeneralStageRoot generalStageRoot = new GeneralStageRoot();
        return generalStageRoot.getStageRoot();
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
            Scene stageScene = new Scene(root);
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

    public void lauchStickman() {
        launch();
    }

    public void setStickamnsOnStage(StickmansOnStage stickamnsOnStage, String identifier) {
        this.stickamnsOnStage.put(identifier,stickamnsOnStage);
        generalConfigStageRoot.setStickmansOnStage(stickamnsOnStage);
    }

    public void addStickmanToStage(String stageIdentifier) throws Exception {
        HBox sStickmanPane;
        sStickmanPane = getStickmanPane(stageIdentifier);
        sStickmanPane.getChildren().clear();
        for (String key : stickamnsOnStage.get(stageIdentifier).getStickmanNames()) {
            sStickmanPane.getChildren().add((Node) stickamnsOnStage.get(stageIdentifier).getStickmanByKey(key));
            addStickmanName(key);
        }
    }

    public void addStickmanToStage(String stageIdentifier, StickmanFX sman) throws Exception {
        HBox sStickmanPane;
        sStickmanPane = getStickmanPane(stageIdentifier);
        sStickmanPane.getChildren().clear();
        sStickmanPane.getChildren().add(sman);
    }

    public HBox getStickmanPane(String stageIdentifier) throws Exception {
        HBox sStickmanPane;
        if (stickmanFXStages.containsKey(stageIdentifier)) {
            sStickmanPane = (HBox) ((ScrollPane) stickmanFXStages.get(stageIdentifier).getScene().getRoot()
                    .lookup("#stickmanScrollPane")).getContent();
        } else {
            throw new Exception("Stage Not found");
        }
        return sStickmanPane;
    }

    private void addStickmanName(String key) {
        generalConfigStageRoot.getmStickmanStageController().fillComboForStickman();
    }

    public void showStage(String stageIdentifier) {
        if (stickmanFXStages.containsKey(stageIdentifier)) {
            Platform.runLater(() -> stickmanFXStages.get(stageIdentifier).show());
        }
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

    public BufferedImage getStageAsImage(String stageIdentifier) throws Exception {
        if (stickmanFXStages.containsKey(stageIdentifier)) {
            Stage stage = stickmanFXStages.get(stageIdentifier);
            final CountDownLatch latch = new CountDownLatch(1);
            ImageContainer imageContainer = new ImageContainer();
            Platform.runLater(() -> {
                WritableImage snapshot = stage.getScene().getRoot().snapshot(new SnapshotParameters(), null);
                BufferedImage bi = SwingFXUtils.fromFXImage(snapshot, null);
                BufferedImage imageRGB = new BufferedImage(bi.getWidth(), bi.getHeight(), BufferedImage.OPAQUE);
                Graphics2D graphics = imageRGB.createGraphics();
                graphics.drawImage(bi, 0, 0, null);
                imageContainer.setImage(imageRGB);
                latch.countDown();
            });
            latch.await();
            return imageContainer.getImage();

        } else {
            throw new Exception("Stage Not found");
        }

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
    }
}

class ImageContainer {
    private BufferedImage image;

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }
}