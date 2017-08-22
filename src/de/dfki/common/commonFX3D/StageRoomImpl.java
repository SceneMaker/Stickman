package de.dfki.common.commonFX3D;

import de.dfki.common.AgentsOnStage;
import de.dfki.common.agent.IAgent;
import de.dfki.common.interfaces.AgentStage;
import de.dfki.common.interfaces.ApplicationLauncher;
import de.dfki.common.interfaces.StageRoom;

import java.awt.image.BufferedImage;

//import de.dfki.stickmanFX.utils.XmlStickmanLoader;

/**
 * Created by alvaro on 11/13/16.
 */
public abstract class StageRoomImpl implements StageRoom
{

    public static final String CONFIG_STAGE = "configStage";
    protected ApplicationLauncher applicationLauncher;
    protected AgentStage agentStage;
    protected AgentsOnStage agentsOnStage;
    protected String stageIdentifier;
    private boolean fullScreen = false;
    private int x;
    private int y;

    public abstract void init(String stageIdentifier);

    protected abstract void getStageInstance();

    protected abstract void createNewStage(int x, int y, boolean decoration);

    @Override
    public void clearStage()
    {
        getAgentsOnStage().clearStage();
        agentStage.clearStage(stageIdentifier);
    }

    @Override
    public void animate(String agentName, String name, int duration, String text, boolean block)
    {
        IAgent agent = getAgentsOnStage().getAgent(agentName);
        agent.doAnimation(name, duration, text, block);
    }

    @Override
    public boolean ismNetwork()
    {
        return false;
    }

    @Override
    public void launchConfiguration()
    {
    }

    @Override
    public void launchAgentStage(boolean show)
    {
        try
        {
            getAgentStage().addAgentToStage(getStageIdentifier());
            if (show)
            {
                getAgentStage().showStage(getStageIdentifier());
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void launchConfiguration(String filepath)
    {
//        agentsOnStage.setFilePath(filepath);
//        XmlStickmanLoader loader = new XmlStickmanLoader(agentsOnStage);
//        loader.initialStickmanWithXml();
//        launchConfiguration();
//        loader.initialStickmanWithXml();
    }

    public void launchStage(boolean show, String filepath)
    {
//        agentsOnStage.setFilePath(filepath);
//        XmlStickmanLoader loader = new XmlStickmanLoader(agentsOnStage);
//        loader.initialStickmanWithXml();
//        launchStage(show);
//        loader.initialStickmanWithXml();
    }

    @Override
    public void addAgent(String name)
    {
        getAgentsOnStage().addAgent(name, fullScreen);
    }

    @Override
    public void addAgent(String name, boolean onlyFace)
    {
        getAgentsOnStage().addAgent(name, fullScreen, onlyFace);
    }

    @Override
    public BufferedImage getStageAsImage() throws Exception
    {
        return getAgentStage().getStageAsImage(stageIdentifier);
    }

    @Override
    public IAgent getAgent(String name)
    {
        return getAgentsOnStage().getAgent(name);
    }

    @Override
    public AgentsOnStage getAgentsOnStage()
    {
        return agentsOnStage;
    }

    @Override
    public AgentStage getAgentStage()
    {
        return agentStage;
    }

    @Override
    public String getStageIdentifier()
    {
        return stageIdentifier;
    }

    @Override
    public void setFullScreen(boolean fullScreen)
    {
        this.fullScreen = fullScreen;
    }

}
