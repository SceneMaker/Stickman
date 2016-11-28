package de.dfki.stickmanSwing.client;

import de.dfki.common.CommonCommandParser;
import de.dfki.common.CommonStickmansOnStage;
import de.dfki.stickmanSwing.animationlogic.Animation;
import de.dfki.stickmanSwing.animationlogic.AnimationLoader;
import de.dfki.stickmanSwing.animationlogic.EventAnimation;
import de.dfki.util.xml.XMLUtilities;

import java.io.ByteArrayInputStream;
import java.nio.charset.Charset;

/**
 * Created by alvaro on 9/19/16.
 */
public class CommandParser extends CommonCommandParser {
    public CommandParser(CommonStickmansOnStage stage) {
        super(stage);
    }

    @Override
    public void parseStickmanMLCmd(String cmd) {
// TODO cut the crap with the two animation types ...
        Animation a = (cmd.contains("StickmanEventAnimation")) ? new EventAnimation() : new Animation();

        boolean r = XMLUtilities.parseFromXMLStream(a, new ByteArrayInputStream(cmd.getBytes(Charset.forName("UTF-8"))));

        String stickmanname = a.mStickmanName;
        String animationname = a.mName;
        String id = a.mID;
        int duration = a.mDuration;
        boolean blocking = a.mBlocking;
        Object parameter = a.mParameter;
        if(stickmanname != null){
            a = (a instanceof EventAnimation)
                    ? AnimationLoader.getInstance().loadEventAnimation(onStage.getStickman(stickmanname), animationname, duration, blocking)
                    : AnimationLoader.getInstance().loadAnimation(onStage.getStickman(stickmanname), animationname, duration, blocking);

            a.setID(id); // give the animation the same id (TODO - This is bad design and caused that the animation has to be "reloaded"
            a.mParameter = parameter;

            a.mStickman.playAnimation(a);
        }
    }
}
