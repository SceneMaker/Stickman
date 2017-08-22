package de.dfki.reeti.stage;

import de.dfki.common.AgentsOnStage;
import de.dfki.common.XmlTransform;
import de.dfki.common.agent.IAgent;
import de.dfki.common.enums.Gender;
import de.dfki.common.interfaces.AgentStage;
import de.dfki.common.interfaces.StageRoom;
import de.dfki.reeti.Reeti;
import javafx.scene.layout.HBox;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by alvaro on 9/19/16.
 */
public class ReetiOnStage extends AgentsOnStage
{
    public ReetiOnStage(AgentStage agentStage)
    {
        super(agentStage);
    }

    public ReetiOnStage(AgentStage agentStage, StageRoom stageRoom)
    {
        super(agentStage, stageRoom);
    }

    public ReetiOnStage(AgentStage agentStage, StageRoom stageRoom, String identifier)
    {
        super(agentStage, stageRoom);
        this.identifier = identifier;
    }

    @Override
    protected void addAgentToStage(String name, boolean fullScreen, Gender.TYPE gender)
    {
        if (fullScreen)
        {
            IAgent agent = new Reeti(name, gender, agentStage.getFullScreenScale(), agentStage.getFullScreenDimension());
            putFullAgentOnStage(name, agent);
        } else
        {
            createNonFullAgent(name, gender, DEFAULT_SCALE);
        }
    }

    @Override
    protected void addAgentToStage(String name, boolean fullScreen, Gender.TYPE gender, boolean onlyFace)
    {
        if (fullScreen)
        {
            IAgent agent = new Reeti(name, gender, agentStage.getFullScreenScale(), agentStage.getFullScreenDimension());
            putFullAgentOnStage(name, agent);
        } else
        {
            float scale = DEFAULT_SCALE;
            if (onlyFace)
            {
                scale = 1.0f;
            }
            createNonFullAgent(name, gender, scale);

        }
    }

    private void createNonFullAgent(String name, Gender.TYPE gender, float scale)
    {
        if (!identifier.equals(""))
        {
            try
            {
                HBox h = agentStage.getAgentBox(identifier);

                IAgent agent = new Reeti(name, gender, scale, h.getPrefHeight());
                putFullAgentOnStage(name, agent);
            } catch (Exception ex)
            {
                Logger.getLogger(ReetiOnStage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public XmlTransform getXmlTransform()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
