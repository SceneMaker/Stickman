package de.dfki.stickmanfx.stagecontroller;

import de.dfki.common.*;
import de.dfki.stickman.Stickman;
import de.dfki.stickmanfx.StickmanFX;
import de.dfki.stickmanfx.xmlsettings.XmlTransform;

/**
 * Created by alvaro on 9/19/16.
 */
public class StickmansOnStageFX extends CommonStickmansOnStage{
    public StickmansOnStageFX(StageStickman stageStickman) {
        super(stageStickman);
    }
    private  XmlTransform mXmlTransform = new XmlTransform();
    public StickmansOnStageFX(StageStickman stickmanStageFX, StageStickmanController controllerFX) {
        super(stickmanStageFX, controllerFX);
    }

    @Override
    protected void addStickmanToStage(String name, boolean fullScreen, Stickman.TYPE gender) {
        if (fullScreen) {
            CommonStickman stickman = new StickmanFX(name, Stickman.TYPE.MALE, stickmanStage.getFullScreenScale(), stickmanStage.getFullScreenDimension());
            putFullStickmanOnStage(name, stickman);
        }else{
            CommonStickman stickman = new StickmanFX(name, Stickman.TYPE.MALE, DEFAULT_SCALE);
            putFullStickmanOnStage(name, stickman);
        }
    }

    @Override
    protected void addStickmanToStage(String name, boolean fullScreen, Stickman.TYPE gender, boolean onlyFace) {
        if (fullScreen) {
            CommonStickman stickman = new StickmanFX(name, Stickman.TYPE.MALE, stickmanStage.getFullScreenScale(), stickmanStage.getFullScreenDimension());
            putFullStickmanOnStage(name, stickman);
        }else{
            float scale = DEFAULT_SCALE;
            if(onlyFace){
                scale = 1.0f;
            }
            CommonStickman stickman = new StickmanFX(name, Stickman.TYPE.MALE, scale);
            putFullStickmanOnStage(name, stickman);
        }
    }

    public XmlTransform getmXmlTransform(){
        return this.mXmlTransform;
    }
}
