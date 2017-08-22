package de.dfki.reeti.stage;

import de.dfki.common.commonFX3D.ApplicationLauncherImpl;
import de.dfki.common.commonFX3D.StageRoomImpl;
import de.dfki.reeti.ApplicationLauncherReeti;

import java.io.IOException;

/**
 * Created by alvaro on 9/12/16.
 */
public class StageRoomReeti extends StageRoomImpl
{

    public StageRoomReeti()
    {
        getStageInstance();
        createNewStage(0, 0, true);
    }

    public StageRoomReeti(int x, int y)
    {
        getStageInstance();
        createNewStage(x, y, true);
    }

    public StageRoomReeti(int x, int y, boolean decoration)
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

    @Override
    protected void getStageInstance()
    {
        applicationLauncher = new ApplicationLauncherReeti();
        if (ApplicationLauncherImpl.isRunning())
        {
            agentStage = ReetiStage.getInstance();
        } else
        {
            applicationLauncher.launchAgentAndWait();
        }
    }

    @Override
    protected void createNewStage(int x, int y, boolean decoration)
    {
        agentStage = ReetiStage.getInstance();
        try
        {
            stageIdentifier = getAgentStage().createNewStage(x, y, decoration);
            init(stageIdentifier);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void init(String stageIdentifier)
    {

        agentsOnStage = new ReetiOnStage(getAgentStage(), this, stageIdentifier);
        getAgentStage().setAgentsOnStage(getAgentsOnStage(), stageIdentifier);
        getAgentStage().setAgentsOnStage(getAgentsOnStage(), CONFIG_STAGE);
    }

    @Override
    public void launchConfiguration()
    {
        ReetiStage ss3D;
        try
        {
            ss3D = (ReetiStage) getAgentStage();
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
        StageRoomReeti.this.launchConfiguration();
//        loader.initialStickmanWithXml();
    }

    @Override
    public void launchStage(boolean show, String filepath)
    {
        agentsOnStage.setFilePath(filepath);
        launchAgentStage(show);
//        loader.initialStickmanWithXml();
    }
}
