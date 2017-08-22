package de.dfki.stickmanFX.stage;

import de.dfki.common.commonFX3D.ApplicationLauncherImpl;
import de.dfki.common.commonFX3D.FXApplication;
import de.dfki.stickmanFX.StickmanFX;
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

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * @author Robbie. Refactored by: acepero13
 */
public class StickmanStageFX extends FXApplication
{
    private static StickmanStageFX sInstance;

    public StickmanStageFX()
    {
        super();
        sInstance = this;
        generalConfigStageRoot = new StagePaneHandlerStickman2D();
    }

    public static StickmanStageFX getInstance()
    {
        if (sInstance == null)
        {
            sInstance = new StickmanStageFX();
        }
        return sInstance;
    }

    @Override
    public void clearStage(String stageIdentifier)
    {
        try
        {
            HBox pane = getAgentBox(stageIdentifier);
            Platform.runLater(() ->
            {
                pane.getChildren().clear();
                Stage stage = agentStages.get(stageIdentifier);
                stage.close();
//                agentStages.remove(stageIdentifier);
            });

        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }


    public void start(Stage stage) throws Exception
    {
        HBox root = generalConfigStageRoot.getConfigRoot();
        Scene scene = new Scene(root);
        scene.getStylesheets().add("de" + File.separator + "dfki" + File.separator + "stickmanFX" + File.separator + "css" + File.separator + "StickmanCSS.css");
        stage.setTitle("StickmanFX");
        stage.setScene(scene);
        agentStages.put(StageRoomFX.CONFIG_STAGE, stage);
        ApplicationLauncherImpl.setIsRunning();
    }

    public void lauchAgent()
    {
        launch();
    }

    public float getFullScreenScale()
    {
        return getHeight() / (float) StickmanFX.mDefaultSize.height * mScale * AGENT_SIZE_FACTOR;
    }

    public void addAgentToStage(String stageIdentifier) throws Exception
    {
        addAgentName("");
        HBox sStickmanPane;
        sStickmanPane = getAgentBox(stageIdentifier);
        sStickmanPane.getChildren().clear();
        for (String key : agentsOnStage.get(stageIdentifier).getAgentNames())
        {
            sStickmanPane.getChildren().add((Node) agentsOnStage.get(stageIdentifier).getAgentByKey(key));
        }
    }

    public void addAgentToStage(String stageIdentifier, StickmanFX sman) throws Exception
    {
        HBox sStickmanPane;
        sStickmanPane = getAgentBox(stageIdentifier);
        sStickmanPane.getChildren().clear();
        sStickmanPane.getChildren().add(sman);
    }

    public HBox getAgentBox(String stageIdentifier) throws Exception
    {
        HBox box;
        if (agentStages.containsKey(stageIdentifier))
        {
            box = (HBox) ((ScrollPane) agentStages.get(stageIdentifier).getScene().getRoot()
                    .lookup("#stickmanScrollPane")).getContent();
        } else
        {
            throw new Exception("Stage Not found");
        }
        return box;
    }

    public synchronized BufferedImage getStageAsImage(String stageIdentifier) throws Exception
    {
        if (agentStages.containsKey(stageIdentifier))
        {
            Stage stage = agentStages.get(stageIdentifier);
            final CountDownLatch latch = new CountDownLatch(1);
            ImageContainer imageContainer = new ImageContainer();
            Platform.runLater(() ->
            {
                SnapshotParameters sp = new SnapshotParameters();
                sp.setFill(javafx.scene.paint.Color.TRANSPARENT);
                WritableImage snapshot = stage.getScene().getRoot().snapshot(sp, null);
                BufferedImage bi = SwingFXUtils.fromFXImage(snapshot, null);
                imageContainer.setImage(bi);
                latch.countDown();
            });
            latch.await();
            return imageContainer.getImage();

        } else
        {
            throw new Exception("Stage Not found");
        }

    }

    public void showStage(String stageIdentifier)
    {
        if (agentStages.containsKey(stageIdentifier))
        {
            Platform.runLater(() -> agentStages.get(stageIdentifier).show());
        }
    }

    @Override
    public void createStage(String uuid, int x, int y, boolean decoration) throws IOException
    {
        final HBox root = getStageRoot();
        Platform.runLater(() ->
        {
            Scene stageScene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(stageScene);
            stage.setX(x);
            stage.setY(y);
            if (!decoration)
            {
                stage.initStyle(StageStyle.UNDECORATED);
            }
            agentStages.put(uuid, stage);
        });
    }

    private HBox getStageRoot() throws java.io.IOException
    {
        StagePaneHandlerStickman2D stagePaneHandlerFX = new StagePaneHandlerStickman2D();
        return stagePaneHandlerFX.getStageRoot();
    }
}

class ImageContainer
{

    private BufferedImage image;

    public BufferedImage getImage()
    {
        return image;
    }

    public void setImage(BufferedImage image)
    {
        this.image = image;
    }
}
