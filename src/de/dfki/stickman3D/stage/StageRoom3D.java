package de.dfki.stickman3D.stage;

import de.dfki.common.commonFX3D.ApplicationLauncherImpl;
import de.dfki.common.commonFX3D.StageRoomImpl;
import de.dfki.stickman3D.ApplicationLauncher3D;
import de.dfki.stickman3D.utils.XmlStickmanLoader;

import java.io.IOException;

/**
 * Created by alvaro on 9/12/16.
 */
public class StageRoom3D extends StageRoomImpl
{

    public static String OldIdentifier;

    public StageRoom3D()
    {
        getStageInstance();
        createNewStage(0, 0, true);
    }

    public StageRoom3D(int x, int y)
    {
        getStageInstance();
        createNewStage(x, y, true);
    }

    public StageRoom3D(int x, int y, boolean decoration)
    {
        getStageInstance();
        createNewStage(x, y, decoration);
    }

    @Override
    public void sendTimeMarkInformation(String timemark)
    {

    }

    @Override
    public void sendAnimationUpdate(String state, String id)
    {

    }

    protected void getStageInstance()
    {
        applicationLauncher = new ApplicationLauncher3D();
        if (ApplicationLauncherImpl.isRunning())
        {
            agentStage = StickmanStage3D.getInstance();
        } else
        {
            applicationLauncher.launchAgentAndWait();
        }
    }

    protected void createNewStage(int x, int y, boolean decoration)
    {
        agentStage = StickmanStage3D.getInstance();
        try
        {
            stageIdentifier = getAgentStage().createNewStage(x, y, decoration);
            OldIdentifier = stageIdentifier;
            init(stageIdentifier);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void init(String stageIdentifier)
    {

        agentsOnStage = new StickmansOnStage3D(getAgentStage(), this, stageIdentifier);
        getAgentStage().setAgentsOnStage(getAgentsOnStage(), stageIdentifier);
        getAgentStage().setAgentsOnStage(getAgentsOnStage(), CONFIG_STAGE);
    }

    public void launchConfiguration()
    {
        StickmanStage3D ss3D;
        try
        {
            ss3D = (StickmanStage3D) getAgentStage();
            ss3D.setShowControlPanel(true);
            ss3D.addAgentToStage(CONFIG_STAGE);
            ss3D.showStage(CONFIG_STAGE);
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
