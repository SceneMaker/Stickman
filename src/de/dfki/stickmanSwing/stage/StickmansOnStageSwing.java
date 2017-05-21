package de.dfki.stickmanSwing.stage;

import de.dfki.common.Gender;
import de.dfki.common.interfaces.Stickman;
import de.dfki.common.StickmansOnStage;
import de.dfki.common.interfaces.StickmanStage;
import de.dfki.stickmanFX.xmlsettings.XmlTransformFX;
import de.dfki.common.interfaces.StageRoom;
import de.dfki.stickmanSwing.StickmanSwing;

/**
 * Created by alvaro on 9/19/16.
 */
public class StickmansOnStageSwing extends StickmansOnStage {

    public StickmansOnStageSwing(StickmanStage stickmanStage) {
        super(stickmanStage);
    }

    public StickmansOnStageSwing(StickmanStage stickmanStage, StageRoom controller) {
        super(stickmanStage, controller);
    }

    @Override
    protected void addStickmanToStage(String name, boolean fullScreen, Gender.TYPE gender) {
        if (fullScreen) {
            Stickman stickman = new StickmanSwing(name, gender, stickmanStage.getFullScreenScale(), stickmanStage.getFullScreenDimension());
            putFullStickmanOnStage(name, stickman);
        } else {
            Stickman stickman = new StickmanSwing(name, gender, DEFAULT_SCALE);
            putFullStickmanOnStage(name, stickman);
        }
    }

    @Override
    protected void addStickmanToStage(String name, boolean fullScreen, Gender.TYPE gender, boolean onlyFace) {
        addStickmanToStage(name, fullScreen, gender);
    }

    public XmlTransformFX getmXmlTransform() {
        return null;
    }
}
