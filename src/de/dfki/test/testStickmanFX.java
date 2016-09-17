package de.dfki.test;

import de.dfki.common.StageStickmanController;
import de.dfki.stickmanfx.stagecontroller.StageStickmanControllerFX;
import de.dfki.stickmanfx.stagecontroller.decorators.StageStickmanFullScreenControllerFXDecorator;
import de.dfki.stickmanfx.stagecontroller.decorators.StageStickmanNetworkControllerFXDecorator;

/**
 * Created by alvaro on 9/13/16.
 */
public class testStickmanFX {
    public static void main(String[] args) {
        StageStickmanController stage = new StageStickmanControllerFX();
        StageStickmanController fullScreenStage = new StageStickmanFullScreenControllerFXDecorator(stage);
        StageStickmanController stickmanStage = new StageStickmanNetworkControllerFXDecorator(fullScreenStage, "127.0.0.1", 8000);
        stickmanStage.addStickman("Bob");
        stickmanStage.addStickman("Anna");
        stickmanStage.launchStickmanStage();


       /* StageStickmanController stickmanStage2 = new StageStickmanControllerFX();
        stickmanStage2.addStickman("Baxter");
        ((StageStickmanControllerFX)stickmanStage2).launchStickmanConfiguration();*/

    }
}
