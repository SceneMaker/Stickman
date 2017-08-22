package de.dfki.reeti.stage;

import de.dfki.common.commonFX3D.ApplicationLauncherImpl;
import de.dfki.common.commonFX3D.FXApplication;
import de.dfki.reeti.Reeti;
import de.dfki.reeti.ReetiStageController;
import de.dfki.stickmanFX.stage.StageRoomFX;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author Robbie and Beka
 */
public class ReetiStage extends FXApplication
{
    private static final String REETI_STAGE = "ReetiStage3D"; //?????????????
    private static ReetiStage sInstance = null;

    public ReetiStage()
    {
        super();
        sInstance = this;
        generalConfigStageRoot = new StagePaneHandlerReeti();
    }

    public static ReetiStage getInstance()
    {
        if (null == sInstance)
        {
            sInstance = new ReetiStage();
        }
        return sInstance;
    }

    @Override
    public void clearStage(String stageIdentifier)
    {
        try
        {
            HBox box = getAgentBox(stageIdentifier);
            Platform.runLater(() ->
            {
                box.getChildren().clear();
                Stage stage = agentStages.get(stageIdentifier);
                stage.close();
                agentStages.remove(stageIdentifier);
            });

        } catch (Exception e)
        {
            e.printStackTrace();
        }
        sInstance = null;
    }

    @Override
    public void start(Stage stage) throws Exception
    {
        int height = 0;
        int width = 0;
        mAgentBox = new HBox();
        mAgentBox.setId("ReetiStage3D");
        mAgentBox.setAlignment(Pos.CENTER);
        mainStage = stage;

        HBox root = generalConfigStageRoot.getConfigRoot();
        Scene scene = new Scene(root, width, height, true, SceneAntialiasing.BALANCED);
        scene.getStylesheets().add("de/dfki/reeti/stage/Style.css");

        AnchorPane controlPanel = (AnchorPane) scene.lookup("#controlPanel");

        mSubscene = createSubSceneAndCamera(getAgentBox(), getWidth() - controlPanel.getPrefWidth(), getHeight());
        root.getChildren().add(mSubscene);

        stage.setTitle("Reeti");
        stage.setScene(scene);
        agentStages.put(StageRoomFX.CONFIG_STAGE, stage);

        ApplicationLauncherImpl.setIsRunning();
        createScroll(mainStage, mAgentBox);
    }

    @Override
    public void lauchAgent()
    {
        launch();
    }

    @Override
    public float getFullScreenScale()
    {
        return getHeight() / (float) de.dfki.stickmanFX.StickmanFX.mDefaultSize.height * mScale * AGENT_SIZE_FACTOR;
    }

    @Override
    public void addAgentToStage(String stageIdentifier) throws Exception
    {
        Platform.runLater(() ->
        {
            final HBox box;
            try
            {
                box = getAgentBox(stageIdentifier);
                for (String key : agentsOnStage.get(stageIdentifier).getAgentNames())
                {
                    Reeti reeti = (Reeti) agentsOnStage.get(stageIdentifier).getAgentByKey(key);

                    if (isShowControlPanel())
                    {
                        reeti.setScale(1.35f);
                        reeti.isFullScreen = true;
                        reeti.update();
                    }
                    box.getChildren().add(reeti);
                    addAgentName(key);
                    ((ReetiStageController) generalConfigStageRoot.getViewController()).setStage3D(this);
                }
            } catch (Exception e)
            {
                e.printStackTrace();
            }

        });

    }

    @Override
    public void addAgentToStage(String stageIdentifier, de.dfki.stickmanFX.StickmanFX sman) throws Exception
    {
        HBox agentBox;
        agentBox = getAgentBox(stageIdentifier);
        agentBox.getChildren().clear();
        agentBox.getChildren().add(sman);
    }

    @Override
    public HBox getAgentBox(String stageIdentifier) throws Exception
    {
        HBox box;
//        Stage stage = agentStages.get(stageIdentifier);
        if (agentStages.containsKey(stageIdentifier))
        {
            box = (HBox) agentStages.get(stageIdentifier).getScene().getRoot();
            box.setAlignment(Pos.CENTER);
            box.setStyle("-fx-background-color: white");

            return (box.getId() != null && box.getId().equals(REETI_STAGE)) ? box : findStageBox(box);
        } else
        {
            throw new Exception("Stage Not found");
        }
    }

    private HBox findStageBox(HBox hBox) throws Exception
    {
        for (Node child : hBox.getChildren())
        {
            if (child instanceof SubScene && ((SubScene) child).getRoot().getId().equals(REETI_STAGE))
            {
                return (HBox) ((SubScene) child).getRoot();
            }
        }
        throw new Exception("Stage Not found");
    }

    @Override
    public BufferedImage getStageAsImage(String stageIdentifier) throws Exception
    {
        return null;
    }

    @Override
    public void showStage(String stageIdentifier)
    {
        if (stageIdentifier.equals(StageRoomReeti.CONFIG_STAGE))
        {
            Platform.runLater(() -> agentStages.get(stageIdentifier).setFullScreen(true));
        }
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
            root.setAlignment(Pos.BASELINE_CENTER);
            Scene stageScene = new Scene(root, 600, 600, true, SceneAntialiasing.BALANCED);
            Stage stage = new Stage();
            stage.setScene(stageScene);
            stage.setX(x);
            stage.setY(y);
            stage.setResizable(false);
            if (!decoration)
            {
                stage.initStyle(StageStyle.UNDECORATED);
            }
            agentStages.put(uuid, stage);
        });
    }

    private HBox getStageRoot() throws java.io.IOException
    {
        StagePaneHandlerReeti generalStageRoot = new StagePaneHandlerReeti();
        HBox box = generalStageRoot.getStageRoot();
        box.setId(REETI_STAGE);
        return box;
    }


    public HBox getAgentBox()
    {
        return mAgentBox;
    }

    public void setAgentBox(HBox mAgentBox)
    {
        this.mAgentBox = mAgentBox;
    }

    public double getRecordCameraXPosition()
    {
        return recordCameraXPosition;
    }

    public void setRecordCameraXPosition(double recordCameraXPosition)
    {
        this.recordCameraXPosition = recordCameraXPosition;
    }

    public double getRecordCameraYPosition()
    {
        return recordCameraYPosition;
    }

    public double getRecordCameraZPosition()
    {
        return recordCameraZPosition;
    }

    public PerspectiveCamera getCamera()
    {
        return mCamera;
    }

    public SubScene getSubScene()
    {
        return mSubscene;
    }

    public Stage getMainStage()
    {
        return mainStage;
    }
}
