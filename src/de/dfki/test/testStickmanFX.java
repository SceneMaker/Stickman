package de.dfki.test;

import de.dfki.common.StageStickmanController;
import de.dfki.stickmanfx.StageStickmanControllerFX;

/**
 * Created by alvaro on 9/13/16.
 */
public class testStickmanFX {
    public static void main(String[] args) {
        StageStickmanController stickmanStage = new StageStickmanControllerFX();
        stickmanStage.addStickman("Bob");
        stickmanStage.addStickman("Anna");
        ((StageStickmanControllerFX)stickmanStage).launchStickmanStage();


        StageStickmanController stickmanStage2 = new StageStickmanControllerFX();
        stickmanStage2.addStickman("Baxter");
        ((StageStickmanControllerFX)stickmanStage2).launchStickmanStage();

    }
}
