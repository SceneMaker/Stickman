package de.dfki.stickmanFX.stage;

import de.dfki.common.AgentsOnStage;
import de.dfki.common.agent.IAgent;
import de.dfki.common.enums.Gender;
import de.dfki.common.interfaces.AgentStage;
import de.dfki.common.interfaces.StageRoom;
import de.dfki.stickmanFX.StickmanFX;
import de.dfki.stickmanFX.xmlsettings.XmlTransformFX;

/**
 * Created by alvaro on 9/19/16.
 */
public class StickmansOnStageFX extends AgentsOnStage
{
    private XmlTransformFX mXmlTransform = new XmlTransformFX();

    public StickmansOnStageFX(AgentStage stickmanStage)
    {
        super(stickmanStage);
    }

    public StickmansOnStageFX(AgentStage stickmanStageFX, StageRoom controllerFX)
    {
        super(stickmanStageFX, controllerFX);
    }

    @Override
    protected void addAgentToStage(String name, boolean fullScreen, Gender.TYPE gender)
    {
        if (fullScreen)
        {
            IAgent stickman = new StickmanFX(name, gender, agentStage.getFullScreenScale(), agentStage.getFullScreenDimension());
            putFullAgentOnStage(name, stickman);
        } else
        {
            IAgent stickman = new StickmanFX(name, gender, DEFAULT_SCALE);
            putFullAgentOnStage(name, stickman);
        }
    }

    @Override
    protected void addAgentToStage(String name, boolean fullScreen, Gender.TYPE gender, boolean onlyFace)
    {
        if (fullScreen)
        {
            IAgent stickman = new StickmanFX(name, gender, agentStage.getFullScreenScale(), agentStage.getFullScreenDimension());
            putFullAgentOnStage(name, stickman);
        } else
        {
            float scale = DEFAULT_SCALE;
            if (onlyFace)
            {
                scale = 9.0f;
            }
            IAgent stickman = new StickmanFX(name, gender, scale, onlyFace);
            putFullAgentOnStage(name, stickman);
        }
    }

    public XmlTransformFX getXmlTransform()
    {
        return this.mXmlTransform;
    }
}
