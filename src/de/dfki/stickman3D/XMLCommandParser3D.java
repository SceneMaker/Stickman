package de.dfki.stickman3D;

import de.dfki.common.XMLCommandParser;
import de.dfki.common.StickmansOnStage;
import de.dfki.stickman3D.animationlogic.Animation3D;
import de.dfki.stickman3D.animationlogic.AnimationLoader3D;
import de.dfki.stickman3D.animationlogic.EventAnimation3D;
import de.dfki.util.xml.XMLUtilities;

import java.io.ByteArrayInputStream;
import java.nio.charset.Charset;

/**
 * Created by alvaro on 11/19/16.
 */
public class XMLCommandParser3D extends XMLCommandParser {

    public XMLCommandParser3D(StickmansOnStage stage) {
        super(stage);
    }

    @Override
    public void parseStickmanXMLCmd(String cmd) {
// TODO cut the crap with the two animation types ...
        Animation3D a = (cmd.contains("StickmanEventAnimation")) ? new EventAnimation3D() : new Animation3D();

        boolean r = XMLUtilities.parseFromXMLStream(a, new ByteArrayInputStream(cmd.getBytes(Charset.forName("UTF-8"))));

        String stickmanname = a.mStickmanName;
        String animationname = a.mName;
        String id = a.getmID();
        int duration = a.mDuration;
        boolean blocking = a.mBlocking;
        Object parameter = a.mParameter;
        if (stickmanname != null) {
            if(a instanceof EventAnimation3D){
              a = AnimationLoader3D.getInstance().loadEventAnimation(onStage.getStickman(stickmanname), animationname, duration, blocking);
            }else if(a.hasExtraParams()){
                a = AnimationLoader3D.getInstance().loadAnimation(onStage.getStickman(stickmanname), animationname, duration, blocking, a.getExtraParams());
            }else{
                a = AnimationLoader3D.getInstance().loadAnimation(onStage.getStickman(stickmanname), animationname, duration, blocking);
            }

            a.setID(id); // give the animation the same id (TODO - This is bad design and caused that the animation has to be "reloaded"
            a.mParameter = parameter;

            a.mStickmanFX.playAnimation(a);
        }
    }
}
