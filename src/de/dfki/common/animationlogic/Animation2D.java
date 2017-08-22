package de.dfki.common.animationlogic;

import de.dfki.action.sequence.WordTimeMarkSequence;
import de.dfki.common.agent.IAgent;
import de.dfki.util.ios.IOSIndentWriter;
import de.dfki.util.xml.XMLParseAction;
import de.dfki.util.xml.XMLParseError;
import de.dfki.util.xml.XMLWriteError;
import org.w3c.dom.Element;

/**
 * Created by EmpaT on 01.08.2017.
 */
public abstract class Animation2D extends Animation
{

    public Animation2D()
    {
        super();
    }

    public Animation2D(IAgent iAgent, int duration, boolean block)
    {
        super(iAgent, duration, block);
    }

    @Override
    public void writeXML(IOSIndentWriter out) throws XMLWriteError
    {
        out.println("<StickmanAnimation stickmanname = \"" + mAgentName
                + "\" name=\"" + mName
                + "\" id=\"" + getID()
                + "\" duration=\"" + mDuration
                + "\" blocking=\"" + mBlocking
                + "\">").push();
        if (mParameter != null)
        {
            if (mParameter instanceof WordTimeMarkSequence)
            {
                ((WordTimeMarkSequence) mParameter).writeXML(out);
            }

            if (mParameter instanceof String)
            {
                out.println((String) mParameter);
            }
        }
        out.pop().println("</StickmanAnimation>");
    }

    @Override
    public void parseXML(final Element element) throws XMLParseError
    {
        mAgentName = element.getAttribute("stickmanname");
        mName = element.getAttribute("name");
        mID = element.getAttribute("id");
        mDuration = Integer.parseInt(element.getAttribute("duration"));
        mBlocking = Boolean.parseBoolean(element.getAttribute("blocking"));
        mParameter = (String) element.getTextContent();

        // Process The Child Nodes
        XMLParseAction.processChildNodes(element, new XMLParseAction()
        {
            @Override
            public void run(final Element element) throws XMLParseError
            {
                // Get The Child Tag Name
                final String name = element.getTagName();

                if (name.equalsIgnoreCase("WordTimeMarkSequence"))
                {
                    mParameter = new WordTimeMarkSequence();

                    ((WordTimeMarkSequence) mParameter).parseXML(element);
                } else
                {
                    mParameter = (String) element.getTextContent();
                }
            }
        });
    }
}
