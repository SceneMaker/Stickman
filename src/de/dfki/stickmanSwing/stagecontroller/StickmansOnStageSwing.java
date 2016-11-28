package de.dfki.stickmanSwing.stagecontroller;

import de.dfki.common.interfaces.Stickman;
import de.dfki.common.StickmansOnStage;
import de.dfki.common.interfaces.StageStickman;
import de.dfki.common.interfaces.StageStickmanController;
import de.dfki.stickmanSwing.StickmanSwing;

/**
 * Created by alvaro on 9/19/16.
 */
public class StickmansOnStageSwing extends StickmansOnStage {
    public StickmansOnStageSwing(StageStickman stageStickman) {
        super(stageStickman);
    }

    public StickmansOnStageSwing(StageStickman stickmanStage, StageStickmanController controller) {
        super(stickmanStage, controller);
    }
    @Override
    protected void addStickmanToStage(String name, boolean fullScreen, StickmanSwing.TYPE gender) {
        if (fullScreen) {
            Stickman stickman = new StickmanSwing(name, gender, stickmanStage.getFullScreenScale(), stickmanStage.getFullScreenDimension());
            putFullStickmanOnStage(name, stickman);
        }else{
            Stickman stickman = new StickmanSwing(name, gender, DEFAULT_SCALE);
            putFullStickmanOnStage(name, stickman);
        }
    }

    @Override
    protected void addStickmanToStage(String name, boolean fullScreen, StickmanSwing.TYPE gender, boolean onlyFace) {
        addStickmanToStage(name, fullScreen, gender);
    }
}
