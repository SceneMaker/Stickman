package de.dfki.common.animationlogic;

import de.dfki.action.sequence.WordTimeMarkSequence;
import de.dfki.common.agent.IAgent;
import de.dfki.util.ios.IOSIndentWriter;
import de.dfki.util.xml.XMLParseAction;
import de.dfki.util.xml.XMLParseError;
import de.dfki.util.xml.XMLWriteError;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by EmpaT on 01.08.2017.
 */
public abstract class Animation3D extends Animation
{
    public Animation3D()
    {
        super();
    }

    public Animation3D(IAgent iAgent, int duration, boolean block)
    {
        super(iAgent, duration, block);
    }

    public Animation3D(IAgent iAgent, int frequent, int actionDuration, boolean block)
    {
        this(iAgent, frequent, block);
        this.actionDuration = actionDuration;
    }

    public Animation3D(IAgent iAgent, int frequent, int actionDuration, boolean block, HashMap<String, String> extraParams)
    {
        this(iAgent, frequent, actionDuration, block);
        this.extraParams = extraParams;
    }

    @Override
    public void parseXML(final Element element) throws XMLParseError
    {
        mAgentName = element.getAttribute("stickmanname");
        mName = element.getAttribute("name");
        mID = element.getAttribute("id");
        mDuration = Integer.parseInt(element.getAttribute("duration"));
        mBlocking = Boolean.parseBoolean(element.getAttribute("blocking"));
        extraParams = new HashMap<>();

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
                } else if (name.equals("Params"))
                {
                    NodeList nodes = element.getChildNodes();
                    for (int i = 0; i < nodes.getLength(); i++)
                    {
                        Node node = nodes.item(i);
                        if (!node.hasAttributes())
                        {
                            continue;
                        }
                        String key = node.getAttributes().getNamedItem("key").getNodeValue();
                        String value = node.getTextContent();
                        extraParams.put(key, value);
                    }
                } else
                {
                    mParameter = (String) element.getTextContent();
                }
            }
        });
    }

    @Override
    public void writeXML(IOSIndentWriter out) throws XMLWriteError
    {
        out.println("<StickmanAnimation stickmanname = \"" + mAgentName
                + "\" name=\"" + mName
                + "\" id=\"" + mID
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
        addExtraParamsToXML(out);
        out.pop().println("</StickmanAnimation>");
    }

    private void addExtraParamsToXML(IOSIndentWriter out)
    {
        if (extraParams.size() > 0)
        {
            out.println("<Params>").push();
            for (Map.Entry<String, String> entry : extraParams.entrySet())
            {
                out.println("<Param key=\"" + entry.getKey() + "\">" + entry.getValue() + "</Param>").push();
            }
            out.pop().println("</Params>");
        }
    }

    public boolean hasExtraParams()
    {
        return extraParams.size() > 0;
    }

    public HashMap<String, String> getExtraParams()
    {
        return extraParams;
    }

}
