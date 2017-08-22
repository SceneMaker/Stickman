package de.dfki.stickman3D.stage;

import de.dfki.common.commonFX3D.ApplicationLauncherImpl;
import de.dfki.common.commonFX3D.FXApplication;
import de.dfki.common.util.Preferences;
import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.StickmanStageController;
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
public class StickmanStage3D extends FXApplication
{
    private static final String STICKMAN_STAGE = "StickmanStage3D";
    private static StickmanStage3D sInstance;

    public StickmanStage3D()
    {
        super();
        sInstance = this;
        generalConfigStageRoot = new StagePaneHandlerStickman3D();
    }

    public static StickmanStage3D getInstance()
    {
        if (sInstance == null)
        {
            sInstance = new StickmanStage3D();
        }
        return sInstance;
    }

    @Override
    public void clearStage(String stageIdentifier)
    {
        try
        {
            if (agentStages.containsKey(stageIdentifier))
            {
                Platform.runLater(() ->
                {
                    mAgentBox.getChildren().clear();
                    if (agentStages.containsKey(StageRoom3D.OldIdentifier))
                    {
                        agentStages.get(StageRoom3D.OldIdentifier).getScene().getMnemonics().clear();
                        agentStages.get(StageRoom3D.OldIdentifier).close();
                        agentStages.remove(StageRoom3D.OldIdentifier);
                        for (String key : agentsOnStage.keySet())
                        {
                            agentsOnStage.get(key).clearStage();
                        }
                        agentsOnStage.clear();
                    }
                });
            }

        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void start(Stage stage) throws Exception
    {
        mAgentBox = new HBox();
        mAgentBox.setId("StickmanStage3D");
        mAgentBox.setAlignment(Pos.BOTTOM_CENTER);
        mAgentBox.setSpacing(Preferences.DISTANCE_BETWEEN_AGENTS);
        int mHeight = 0;
        int mWidth = 0;
        mainStage = stage;

        HBox root = generalConfigStageRoot.getConfigRoot();
        Scene scene = new Scene(root, mWidth, mHeight, true, SceneAntialiasing.BALANCED);
        scene.getStylesheets().add("de/dfki/stickman3D/stage/Style.css");

        AnchorPane controlPanel = (AnchorPane) scene.lookup("#controlPanel");

        mSubscene = createSubSceneAndCamera(getAgentBox(), getWidth() - controlPanel.getPrefWidth(), getHeight());
        root.getChildren().add(mSubscene);

        stage.setTitle("Stickman3D");
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
        return getHeight() / Preferences.MALE_HEIGHT * mScale * AGENT_SIZE_FACTOR;
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
                box.setSpacing(Preferences.DISTANCE_BETWEEN_AGENTS);
                for (String key : agentsOnStage.get(stageIdentifier).getAgentNames())
                {
                    Stickman3D sman3D = (Stickman3D) agentsOnStage.get(stageIdentifier).getAgentByKey(key);

                    if (isShowControlPanel())
                    {
//                        sman3D.setScale(1.35f);
                        sman3D.setScale(getFullScreenScale());
                        sman3D.isFullScreen = true;
                        sman3D.update();
                    }
                    box.getChildren().add((Node) sman3D);
                    addAgentName(key);
                    ((StickmanStageController) generalConfigStageRoot.getViewController()).setStage3D(this);
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
        HBox stickmanBox;
        stickmanBox = getAgentBox(stageIdentifier);
        stickmanBox.getChildren().clear();
        stickmanBox.getChildren().add(sman);
    }

    @Override
    public HBox getAgentBox(String stageIdentifier) throws Exception
    {
        HBox box;
//        Stage stage = agentStages.get(stageIdentifier);

        if (agentStages.containsKey(stageIdentifier))
        {
            box = (HBox) agentStages.get(stageIdentifier).getScene().getRoot();
            box.setAlignment(Pos.BOTTOM_CENTER);
            box.setStyle("-fx-background-color: white");

            return (box.getId() != null && box.getId().equals(STICKMAN_STAGE)) ? box : findStageBox(box);
        } else
        {
            throw new Exception("Stage Not found");
        }
    }

    private HBox findStageBox(HBox stickmanBox) throws Exception
    {
        for (Node child : stickmanBox.getChildren())
        {
            if (child instanceof SubScene && ((SubScene) child).getRoot().getId().equals(STICKMAN_STAGE))
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
        if (stageIdentifier.equals(StageRoom3D.CONFIG_STAGE))
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
            root.setAlignment(Pos.BOTTOM_CENTER);
            Scene stageScene = new Scene(root, 650, 600, true, SceneAntialiasing.BALANCED);
            Stage stage = new Stage();
            stage.setScene(stageScene);
            stage.setX(x);
            stage.setY(y);
            stage.setResizable(true);
            if (!decoration)
            {
                stage.initStyle(StageStyle.UNDECORATED);
            }
            agentStages.put(uuid, stage);
        });
    }

    private HBox getStageRoot() throws java.io.IOException
    {
        StagePaneHandlerStickman3D generalStageRoot = new StagePaneHandlerStickman3D();
        HBox box = generalStageRoot.getStageRoot();
        box.setId(STICKMAN_STAGE);
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
}
