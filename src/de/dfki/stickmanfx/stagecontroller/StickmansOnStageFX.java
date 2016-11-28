package de.dfki.stickmanfx.stagecontroller;

import de.dfki.common.*;
import de.dfki.common.interfaces.Stickman;
import de.dfki.common.interfaces.StageStickman;
import de.dfki.common.interfaces.StageStickmanController;
import de.dfki.stickmanSwing.StickmanSwing;
import de.dfki.stickmanfx.StickmanFX;
import de.dfki.stickmanfx.xmlsettings.XmlTransform;

/**
 * Created by alvaro on 9/19/16.
 */
public class StickmansOnStageFX extends StickmansOnStage {
    public StickmansOnStageFX(StageStickman stageStickman) {
        super(stageStickman);
    }
    private  XmlTransform mXmlTransform = new XmlTransform();
    public StickmansOnStageFX(StageStickman stickmanStageFX, StageStickmanController controllerFX) {
        super(stickmanStageFX, controllerFX);
    }

    @Override
    protected void addStickmanToStage(String name, boolean fullScreen, StickmanSwing.TYPE gender) {
        if (fullScreen) {
            Stickman stickman = new StickmanFX(name, StickmanSwing.TYPE.MALE, stickmanStage.getFullScreenScale(), stickmanStage.getFullScreenDimension());
            putFullStickmanOnStage(name, stickman);
        }else{
            Stickman stickman = new StickmanFX(name, StickmanSwing.TYPE.MALE, DEFAULT_SCALE);
            putFullStickmanOnStage(name, stickman);
        }
    }

    @Override
    protected void addStickmanToStage(String name, boolean fullScreen, StickmanSwing.TYPE gender, boolean onlyFace) {
        if (fullScreen) {
            Stickman stickman = new StickmanFX(name, StickmanSwing.TYPE.MALE, stickmanStage.getFullScreenScale(), stickmanStage.getFullScreenDimension());
            putFullStickmanOnStage(name, stickman);
        }else{
            float scale = DEFAULT_SCALE;
            if(onlyFace){
                scale = 1.0f;
            }
            Stickman stickman = new StickmanFX(name, StickmanSwing.TYPE.MALE, scale);
            putFullStickmanOnStage(name, stickman);
        }
    }

    public XmlTransform getmXmlTransform(){
        return this.mXmlTransform;
    }
}
