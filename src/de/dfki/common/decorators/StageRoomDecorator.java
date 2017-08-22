package de.dfki.common.decorators;

import de.dfki.common.AgentsOnStage;
import de.dfki.common.agent.IAgent;
import de.dfki.common.interfaces.AgentStage;
import de.dfki.common.interfaces.StageRoom;

import java.awt.image.BufferedImage;

/**
 * Created by alvaro on 9/17/16.
 */
public abstract class StageRoomDecorator implements StageRoom
{

    protected StageRoom stageRoom;

    public StageRoomDecorator(StageRoom wrappedController)
    {
        stageRoom = wrappedController;
    }

    @Override
    public boolean ismNetwork()
    {
        return stageRoom.ismNetwork();
    }

    @Override
    public void clearStage()
    {
        stageRoom.clearStage();
    }

    @Override
    public void sendTimeMarkInformation(String timemark)
    {
        stageRoom.sendTimeMarkInformation(timemark);
    }

    @Override
    public void sendAnimationUpdate(String state, String id)
    {
        stageRoom.sendAnimationUpdate(state, id);
    }

    @Override
    public void launchAgentStage(boolean show)
    {
        stageRoom.launchAgentStage(show);
    }

    public void addAgent(String name)
    {
        stageRoom.addAgent(name);
    }

    public void addAgent(String name, boolean onlyFace)
    {
        stageRoom.addAgent(name, onlyFace);
    }

    @Override
    public void animate(String agentName, String name, int duration, String text, boolean block)
    {
        stageRoom.animate(agentName, name, duration, text, block);
    }

    @Override
    public IAgent getAgent(String name)
    {
        return stageRoom.getAgent(name);
    }

    public AgentsOnStage getAgentsOnStage()
    {
        return stageRoom.getAgentsOnStage();
    }

    public AgentStage getAgentStage()
    {
        return stageRoom.getAgentStage();
    }

    public String getStageIdentifier()
    {
        return stageRoom.getStageIdentifier();
    }

    public void setFullScreen(boolean fullScreen)
    {
        stageRoom.setFullScreen(fullScreen);
    }

    @Override
    public BufferedImage getStageAsImage() throws Exception
    {
        return stageRoom.getStageAsImage();
    }

    @Override
    public void launchConfiguration()
    {
    }

    @Override
    public void launchConfiguration(String filepath)
    {

    }

    @Override
    public void launchStage(boolean show, String filepath)
    {
        stageRoom.launchStage(show, filepath);
    }

}
