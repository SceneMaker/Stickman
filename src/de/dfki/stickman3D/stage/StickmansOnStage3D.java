package de.dfki.stickman3D.stage;

import de.dfki.common.AgentsOnStage;
import de.dfki.common.agent.IAgent;
import de.dfki.common.enums.Gender;
import de.dfki.common.interfaces.AgentStage;
import de.dfki.common.interfaces.StageRoom;
import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.xmlsettings.XmlTransform3D;
import javafx.scene.layout.HBox;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by alvaro on 9/19/16.
 */
public class StickmansOnStage3D extends AgentsOnStage
{
    private XmlTransform3D mXmlTransform = new XmlTransform3D();

    public StickmansOnStage3D(AgentStage stickmanStage)
    {
        super(stickmanStage);
    }

    public StickmansOnStage3D(AgentStage stickmanStageFX, StageRoom controllerFX)
    {
        super(stickmanStageFX, controllerFX);
    }

    public StickmansOnStage3D(AgentStage stickmanStageFX, StageRoom controllerFX, String identifier)
    {
        super(stickmanStageFX, controllerFX);
        this.identifier = identifier;
    }

    @Override
    protected void addAgentToStage(String name, boolean fullScreen, Gender.TYPE gender)
    {
        if (fullScreen)
        {
            IAgent stickman = new Stickman3D(name, gender, agentStage.getFullScreenScale(), agentStage.getFullScreenDimension());
            putFullAgentOnStage(name, stickman);
        } else
        {

            createNonFullStickman(name, gender, DEFAULT_SCALE);
        }
    }

    @Override
    protected void addAgentToStage(String name, boolean fullScreen, Gender.TYPE gender, boolean onlyFace)
    {
        if (fullScreen)
        {
            IAgent stickman = new Stickman3D(name, gender, agentStage.getFullScreenScale(), agentStage.getFullScreenDimension());
            putFullAgentOnStage(name, stickman);
        } else
        {
            float scale = DEFAULT_SCALE;
            if (onlyFace)
            {
                scale = 1.0f;
            }
            createNonFullStickman(name, gender, scale);

        }
    }

    private void createNonFullStickman(String name, Gender.TYPE gender, float scale)
    {
        if (!identifier.equals(""))
        {
            try
            {
                HBox h = agentStage.getAgentBox(identifier);

                IAgent stickman = new Stickman3D(name, gender, scale, h.getPrefHeight());
                putFullAgentOnStage(name, stickman);
            } catch (Exception ex)
            {
                Logger.getLogger(StickmansOnStage3D.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public XmlTransform3D getXmlTransform()
    {
        return this.mXmlTransform;
    }
}
