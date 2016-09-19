package de.dfki.test;

import de.dfki.common.CommonStageStickmanNetworkControllerDecorator;
import de.dfki.common.StageStickmanController;
import de.dfki.stickman.stagecontroller.StageController;
import de.dfki.stickman.stagecontroller.decorators.StageStickmanFullScreenDecorator;
import de.dfki.stickmanfx.stagecontroller.StageStickmanControllerFX;
import de.dfki.stickmanfx.stagecontroller.decorators.StageStickmanFullScreenControllerFXDecorator;
import de.dfki.stickmanfx.stagecontroller.decorators.StageStickmanNetworkControllerDecoratorFX;

/**
 * Created by alvaro on 9/13/16.
 */
public class testStickmanFX {
    public static void main(String[] args) {
        StageStickmanController stage = new StageStickmanControllerFX();
        StageStickmanController stickmanStage = new StageStickmanFullScreenControllerFXDecorator(stage);
        stickmanStage.addStickman("Bob");
        stickmanStage.addStickman("Anna", true);
        stickmanStage.launchStickmanStage();


       /* StageStickmanController stickmanStage2 = new StageStickmanControllerFX();
        stickmanStage2.addStickman("Baxter");
        ((StageStickmanControllerFX)stickmanStage2).launchStickmanConfiguration();*/

        /*StageStickmanController stageOld = new StageController();
        StageStickmanController fullScreenStageOld = new StageStickmanFullScreenDecorator(stageOld);
        fullScreenStageOld.addStickman("Bob");
        fullScreenStageOld.addStickman("Anna");
        fullScreenStageOld.launchStickmanStage();;*/

    }
}
