package de.dfki.stickmanFX.stage;

import de.dfki.common.commonFX3D.ApplicationLauncherImpl;
import de.dfki.common.commonFX3D.StageRoomImpl;
import de.dfki.stickmanFX.ApplicationLauncherFX;
import de.dfki.stickmanFX.utils.XmlStickmanLoader;

import java.io.IOException;

/**
 * Created by alvaro on 9/12/16.
 */
public class StageRoomFX extends StageRoomImpl
{

    public StageRoomFX()
    {
        getStageInstance();
        createNewStage(0, 0, true);
    }

    public StageRoomFX(int x, int y)
    {
        getStageInstance();
        createNewStage(x, y, true);
    }

    public StageRoomFX(int x, int y, boolean decoration)
    {
        getStageInstance();
        createNewStage(x, y, decoration);
    }

    @Override
    protected void getStageInstance()
    {
        applicationLauncher = new ApplicationLauncherFX();
        if (ApplicationLauncherImpl.isRunning())
        {
            agentStage = StickmanStageFX.getInstance();

        } else
        {
            applicationLauncher.launchAgentAndWait();
        }
    }

    @Override
    protected void createNewStage(int x, int y, boolean decoration)
    {
        agentStage = StickmanStageFX.getInstance();

        try
        {
            stageIdentifier = getAgentStage().createNewStage(x, y, decoration);
            init(stageIdentifier);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void init(String stageIdentifier)
    {
        agentsOnStage = new StickmansOnStageFX(getAgentStage(), this);
        getAgentStage().setAgentsOnStage(getAgentsOnStage(), stageIdentifier);
        getAgentStage().setAgentsOnStage(getAgentsOnStage(), CONFIG_STAGE);
    }

    @Override
    public void sendTimeMarkInformation(String timemark)
    {

    }

    @Override
    public void sendAnimationUpdate(String state, String id)
    {

    }

    @Override
    public void launchConfiguration()
    {
        try
        {
            getAgentStage().addAgentToStage(CONFIG_STAGE);
            getAgentStage().showStage(CONFIG_STAGE);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void launchConfiguration(String filepath)
    {
        agentsOnStage.setFilePath(filepath);
        XmlStickmanLoader loader = new XmlStickmanLoader(agentsOnStage);
        loader.initialStickmanWithXml();
        launchConfiguration();
//        loader.initialStickmanWithXml();
    }

    @Override
    public void launchStage(boolean show, String filepath)
    {
        agentsOnStage.setFilePath(filepath);
        XmlStickmanLoader loader = new XmlStickmanLoader(agentsOnStage);
        loader.initialStickmanWithXml();
        launchAgentStage(show);
//        loader.initialStickmanWithXml();
    }
}
