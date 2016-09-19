package de.dfki.test;

import de.dfki.common.StageStickmanController;
import de.dfki.stickman.stagecontroller.StageController;
import de.dfki.stickman.stagecontroller.decorators.StageStickmanFullScreenDecorator;

/**
 * Created by alvaro on 9/13/16.
 */
public class testStickmanFX {
    public static void main(String[] args) {
        /*StageStickmanController stage = new StageStickmanControllerFX();
        StageStickmanController fullScreenStage = new StageStickmanFullScreenControllerFXDecorator(stage);
        StageStickmanController stickmanStage = new CommonStageStickmanNetworkControllerDecorator(fullScreenStage, "127.0.0.1", 8000);
        stickmanStage.addStickman("Bob");
        stickmanStage.addStickman("Anna");
        stickmanStage.launchStickmanStage();*/


       /* StageStickmanController stickmanStage2 = new StageStickmanControllerFX();
        stickmanStage2.addStickman("Baxter");
        ((StageStickmanControllerFX)stickmanStage2).launchStickmanConfiguration();*/

        StageStickmanController stageOld = new StageController();
        StageStickmanController fullScreenStageOld = new StageStickmanFullScreenDecorator(stageOld);
        fullScreenStageOld.addStickman("Bob");
        fullScreenStageOld.addStickman("Anna");
        fullScreenStageOld.launchStickmanStage();;

    }
}
