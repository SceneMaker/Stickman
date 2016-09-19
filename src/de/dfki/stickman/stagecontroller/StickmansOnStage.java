package de.dfki.stickman.stagecontroller;

import de.dfki.common.CommonStickman;
import de.dfki.common.CommonStickmansOnStage;
import de.dfki.common.StageStickman;
import de.dfki.common.StageStickmanController;
import de.dfki.stickman.Stickman;

/**
 * Created by alvaro on 9/19/16.
 */
public class StickmansOnStage extends CommonStickmansOnStage {
    public StickmansOnStage(StageStickman stageStickman) {
        super(stageStickman);
    }

    public StickmansOnStage(StageStickman stickmanStage, StageStickmanController controller) {
        super(stickmanStage, controller);
    }
    @Override
    protected void addStickmanToStage(String name, boolean fullScreen, Stickman.TYPE gender) {
        if (fullScreen) {
            CommonStickman stickman = new Stickman(name, gender, stickmanStage.getFullScreenScale(), stickmanStage.getFullScreenDimension());
            putFullStickmanOnStage(name, stickman);
        }else{
            CommonStickman stickman = new Stickman(name, gender, DEFAULT_SCALE);
            putFullStickmanOnStage(name, stickman);
        }
    }
}
