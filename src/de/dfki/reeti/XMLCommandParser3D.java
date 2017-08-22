package de.dfki.reeti;

import de.dfki.common.AgentsOnStage;
import de.dfki.common.XMLCommandParser;
import de.dfki.reeti.animationlogic.AnimationLoaderReeti;
import de.dfki.reeti.animationlogic.AnimationReeti;
import de.dfki.reeti.animationlogic.EventAnimationReeti;
import de.dfki.util.xml.XMLUtilities;

import java.io.ByteArrayInputStream;
import java.nio.charset.Charset;

/**
 * Created by alvaro on 11/19/16.
 */
public class XMLCommandParser3D extends XMLCommandParser
{

    public XMLCommandParser3D(AgentsOnStage stage)
    {
        super(stage);
    }

    @Override
    public void parseAgentXMLCmd(String cmd)
    {
// TODO cut the crap with the two animation types ...
        AnimationReeti a = (cmd.contains("StickmanEventAnimation")) ? new EventAnimationReeti() : new AnimationReeti();

        boolean r = XMLUtilities.parseFromXMLStream(a, new ByteArrayInputStream(cmd.getBytes(Charset.forName("UTF-8"))));

        String stickmanname = a.mAgentName;
        String animationname = a.mName;
        String id = a.getID();
        int duration = a.mDuration;
        boolean blocking = a.mBlocking;
        Object parameter = a.mParameter;
        if (stickmanname != null)
        {
            if (a instanceof EventAnimationReeti)
            {
                a = AnimationLoaderReeti.getInstance().loadEventAnimation(onStage.getAgent(stickmanname), animationname, duration, blocking);
            } else if (a.hasExtraParams())
            {
                a = AnimationLoaderReeti.getInstance().loadAnimation(onStage.getAgent(stickmanname), animationname, duration, blocking, a.getExtraParams());
            } else
            {
                a = AnimationLoaderReeti.getInstance().loadAnimation(onStage.getAgent(stickmanname), animationname, duration, blocking);
            }

            a.setID(id); // give the animation the same id (TODO - This is bad design and caused that the animation has to be "reloaded"
            a.mParameter = parameter;

            a.agent.playAnimation(a);
        }
    }
}
