package de.dfki.stickmanFX.client;

import de.dfki.common.AgentsOnStage;
import de.dfki.common.XMLCommandParser;
import de.dfki.stickmanFX.animationlogic.AnimationLoaderFX;
import de.dfki.stickmanFX.animationlogic.AnimationStickman2D;
import de.dfki.stickmanFX.animationlogic.EventAnimationFX;
import de.dfki.util.xml.XMLUtilities;

import java.io.ByteArrayInputStream;
import java.nio.charset.Charset;

/**
 * Created by alvaro on 9/19/16.
 */
public class XMLCommandParserFX extends XMLCommandParser
{

    public XMLCommandParserFX(AgentsOnStage stage)
    {
        super(stage);
    }

    @Override
    public void parseAgentXMLCmd(String cmd)
    {
        // TODO cut the crap with the two animation types ...
        AnimationStickman2D a = (cmd.contains("StickmanEventAnimation")) ? new EventAnimationFX() : new AnimationStickman2D();

        boolean r = XMLUtilities.parseFromXMLStream(a, new ByteArrayInputStream(cmd.getBytes(Charset.forName("UTF-8"))));

        String stickmanname = a.mAgentName;
        String animationname = a.mName;
        String id = a.getID();
        int duration = a.mDuration;
        boolean blocking = a.mBlocking;
        Object parameter = a.mParameter;
        if (stickmanname != null)
        {
            a = (a instanceof EventAnimationFX)
                    ? AnimationLoaderFX.getInstance().loadEventAnimation(onStage.getAgent(stickmanname), animationname, duration, blocking)
                    : AnimationLoaderFX.getInstance().loadAnimation(onStage.getAgent(stickmanname), animationname, duration, blocking);

            a.setID(id); // give the animation the same id (TODO - This is bad design and caused that the animation has to be "reloaded"
            a.mParameter = parameter;

            a.agent.playAnimation(a);
        }
    }
}
