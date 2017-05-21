package de.dfki.stickmanSwing.client;

import de.dfki.common.XMLCommandParser;
import de.dfki.common.StickmansOnStage;
import de.dfki.stickmanSwing.animationlogic.AnimationSwing;
import de.dfki.stickmanSwing.animationlogic.AnimationLoaderSwing;
import de.dfki.stickmanSwing.animationlogic.EventAnimationSwing;
import de.dfki.util.xml.XMLUtilities;

import java.io.ByteArrayInputStream;
import java.nio.charset.Charset;

/**
 * Created by alvaro on 9/19/16.
 */
public class XMLCommandParserSwing extends XMLCommandParser {

    public XMLCommandParserSwing(StickmansOnStage stage) {
        super(stage);
    }

    @Override
    public void parseStickmanXMLCmd(String cmd) {
// TODO cut the crap with the two animation types ...
        AnimationSwing a = (cmd.contains("StickmanEventAnimation")) ? new EventAnimationSwing() : new AnimationSwing();

        boolean r = XMLUtilities.parseFromXMLStream(a, new ByteArrayInputStream(cmd.getBytes(Charset.forName("UTF-8"))));

        String stickmanname = a.mStickmanName;
        String animationname = a.mName;
        String id = a.mID;
        int duration = a.mDuration;
        boolean blocking = a.mBlocking;
        Object parameter = a.mParameter;
        if (stickmanname != null) {
            a = (a instanceof EventAnimationSwing)
                    ? AnimationLoaderSwing.getInstance().loadEventAnimation(onStage.getStickman(stickmanname), animationname, duration, blocking)
                    : AnimationLoaderSwing.getInstance().loadAnimation(onStage.getStickman(stickmanname), animationname, duration, blocking);

            a.setID(id); // give the animation the same id (TODO - This is bad design and caused that the animation has to be "reloaded"
            a.mParameter = parameter;

            a.mStickman.playAnimation(a);
        }
    }
}
