package de.dfki.common.interfaces;

import de.dfki.common.AgentsOnStage;
import de.dfki.common.agent.IAgent;

import java.awt.image.BufferedImage;

/**
 * Created by alvaro on 9/12/16.
 */
public interface StageRoom
{

    void clearStage();

    void animate(String agentName, String name, int duration, String text, boolean block);

    boolean ismNetwork();

    void sendTimeMarkInformation(String timemark);

    void sendAnimationUpdate(String state, String id);

    void addAgent(String name);

    IAgent getAgent(String name);

    void launchAgentStage(boolean show);

    AgentStage getAgentStage();

    AgentsOnStage getAgentsOnStage();

    String getStageIdentifier();

    void setFullScreen(boolean fullScreen);

    void addAgent(String name, boolean onlyFace);

    BufferedImage getStageAsImage() throws Exception;

    void launchConfiguration();

    void launchConfiguration(String filepath);

    void launchStage(boolean show, String filepath);
}
