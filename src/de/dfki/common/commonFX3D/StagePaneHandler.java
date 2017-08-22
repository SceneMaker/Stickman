package de.dfki.common.commonFX3D;

import de.dfki.common.AgentsOnStage;
import javafx.scene.layout.HBox;

import java.io.IOException;

/**
 * Created by EmpaT on 04.08.2017.
 */
public abstract class StagePaneHandler
{
    protected HBox root;
    protected ViewController viewController;

    public StagePaneHandler()
    {
        if (ApplicationLauncherImpl.isRunning())
        {
            try
            {
                if (viewController == null)
                {
                    invoke();
                }
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    public ViewController getViewController()
    {
        return viewController;
    }

    public void setAgentsOnStage(AgentsOnStage agentsOnStage)
    {
        viewController.setAgentOnStage(agentsOnStage);
    }

    protected abstract StagePaneHandler invoke() throws IOException;

    public abstract HBox getConfigRoot() throws IOException;

    public abstract HBox getStageRoot() throws IOException;
}
