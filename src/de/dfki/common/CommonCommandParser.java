package de.dfki.common;

import de.dfki.stickmanfx.StickmanFX;
import de.dfki.stickmanfx.animationlogic.AnimationFX;
import de.dfki.stickmanfx.animationlogic.AnimationLoaderFX;
import de.dfki.stickmanfx.animationlogic.EventAnimationFX;
import de.dfki.util.xml.XMLUtilities;

import java.io.ByteArrayInputStream;
import java.nio.charset.Charset;

/**
 * Created by alvaro on 9/12/16.
 */
public abstract class CommonCommandParser {

    protected CommonStickmansOnStage onStage;
    public CommonCommandParser(CommonStickmansOnStage stage){
        onStage = stage;
    }
    public  abstract void parseStickmanMLCmd(String cmd);
}
