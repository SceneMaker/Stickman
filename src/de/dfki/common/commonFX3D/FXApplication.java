package de.dfki.common.commonFX3D;

import de.dfki.common.AgentsOnStage;
import de.dfki.common.interfaces.AgentStage;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.PerspectiveCamera;
import javafx.scene.SceneAntialiasing;
import javafx.scene.SubScene;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.logging.ConsoleHandler;

/**
 * Created by EmpaT on 04.08.2017.
 */
public abstract class FXApplication extends Application implements AgentStage
{
    protected static final float AGENT_SIZE_FACTOR = 0.8f;
    protected static final float HEIGHT_ADJUSTMENT = 3 / 5.0f;
    protected static final float AGENT_IN_BETWEEN_DISTANCE_FACTOR = 0.9f;

    protected final HashMap<String, AgentsOnStage> agentsOnStage = new HashMap<>();
    protected final Map<String, Stage> agentStages = new HashMap<>();

    protected StagePaneHandler generalConfigStageRoot;
    protected Stage mainStage = null;

    protected float mScale;
    protected boolean showControlPanel = false;

    //CAMERA STUFF
    protected SubScene mSubscene = null;
    protected PerspectiveCamera mCamera = null;
    protected HBox mAgentBox = null;
    protected double recordCameraXPosition = 0;
    protected double recordCameraYPosition = 0;
    protected double recordCameraZPosition = 0;

    public FXApplication()
    {
        this.mScale = 1.0f;
        Platform.setImplicitExit(false);
        ConsoleHandler ch = new ConsoleHandler(); //????????????????
    }

    protected SubScene createSubSceneAndCamera(HBox root, double width, double height)
    {

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        mCamera = new PerspectiveCamera(true);

        int cameraZPosition = (int) dim.getWidth();
        if (cameraZPosition < 1400)
        {
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

    protected float getHeight()
    {
        Dimension size = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        return size.height;
    }

    protected float getWidth()
    {
        Dimension size = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        return size.width;
    }

    public Dimension getFullScreenDimension()
    {
        return new Dimension(new Float(getHeight() * HEIGHT_ADJUSTMENT * mScale).intValue(),
                new Float(getHeight() * mScale * AGENT_IN_BETWEEN_DISTANCE_FACTOR).intValue());
    }

    @Override
    public void setStageFullScreen(String stageIdentifier)
    {
        setFullScreen(stageIdentifier, true);
    }

    @Override
    public void setStageNonFullScreen(String stageIdentifier)
    {
        setFullScreen(stageIdentifier, false);
    }

    @Override
    public void setAgentsOnStage(AgentsOnStage agentsOnStage, String identifier)
    {
        this.agentsOnStage.put(identifier, agentsOnStage);
        generalConfigStageRoot.setAgentsOnStage(agentsOnStage);
    }

    private void setFullScreen(String stageIdentifier, boolean value)
    {
        if (agentStages.containsKey(stageIdentifier))
        {
            Platform.runLater(() -> agentStages.get(stageIdentifier).setFullScreen(value));
        }
    }

    public String createNewStage(int x, int y, boolean decoration) throws IOException
    {
        String uuid = UUID.randomUUID().toString();
        try
        {
            createStage(uuid, x, y, decoration);
            waitForCreatingStage(uuid);
        } catch (IOException e)
        {
            throw e;
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        return uuid;
    }

    public void waitForCreatingStage(String uuid) throws InterruptedException
    {
        while (!agentStages.containsKey(uuid))
        {
            Thread.sleep(200);
        }
    }

    public boolean isShowControlPanel()
    {
        return showControlPanel;
    }

    public void setShowControlPanel(boolean showControlPanel)
    {
        this.showControlPanel = showControlPanel;
    }

    public abstract void createStage(String uuid, int x, int y, boolean decoration) throws IOException;

    public void runLater(Runnable function)
    {
        Platform.runLater(function);
    }

    protected void createScroll(Stage stage, Node node)
    {
        stage.getScene().setOnScroll((ScrollEvent event) ->
        {
            if (event.getDeltaY() < 0)
            {
                node.setScaleX(node.getScaleX() - 0.05);
                node.setScaleY(node.getScaleY() - 0.05);
                node.setScaleZ(node.getScaleZ() - 0.05);
            } else
            {
                node.setScaleX(node.getScaleX() + 0.05);
                node.setScaleY(node.getScaleY() + 0.05);
                node.setScaleZ(node.getScaleZ() + 0.05);
            }
        });
    }

    protected void addAgentName(String key)
    {
        generalConfigStageRoot.getViewController().fillComboForAgent();
    }
}
