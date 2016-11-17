package de.dfki.test;

import de.dfki.common.CommonStageStickmanNetworkControllerDecorator;
import de.dfki.common.StageStickmanController;
import de.dfki.stickman.stagecontroller.StageController;
import de.dfki.stickman.stagecontroller.decorators.StageStickmanFullScreenDecorator;
import de.dfki.stickman3D.StageStickmanController3D;
import de.dfki.stickmanfx.stagecontroller.StageStickmanControllerFX;
import de.dfki.stickmanfx.stagecontroller.decorators.StageStickmanFullScreenControllerFXDecorator;
import de.dfki.stickmanfx.stagecontroller.decorators.StageStickmanNetworkControllerDecoratorFX;
import javafx.scene.input.MouseButton;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by alvaro on 9/13/16.
 */
public class testStickmanFX {
    public static void main(String[] args) {



        StageStickmanController stickmanStage = new StageStickmanControllerFX(0,0, true);
        StageStickmanController stickmanStageFull = new StageStickmanFullScreenControllerFXDecorator(stickmanStage);
        stickmanStage.addStickman("Patrick");
        //stickmanStage.addStickman("Bob");
        stickmanStage.launchStickmanStage(true);


        StageStickmanController stickmanStage2 = new StageStickmanControllerFX(1921, 0, true);
        StageStickmanController stickmanStageFull2 = new StageStickmanFullScreenControllerFXDecorator(stickmanStage2);
        stickmanStageFull2.addStickman("Martin");
        stickmanStageFull2.addStickman("Sarah");
        stickmanStageFull2.launchStickmanStage(true);
        //stickmanStage2.launchStickmanStage(true);
        BufferedImage bufferedImage = null;


        StageStickmanController stickmanStage3D = new StageStickmanController3D(991,0, true);
        stickmanStage3D.addStickman("Martin");
        stickmanStage3D.addStickman("Bob");
        //stickmanStage3D.launchStickmanStage(true);
        stickmanStage3D.launchStickmanStage(true);

        StageStickmanController stickmanStage3D1 = new StageStickmanController3D(0,0, true);
        stickmanStage3D1.addStickman("Robbie");
        //stickmanStage3D.launchStickmanStage(true)
        stickmanStage3D1.launchStickmanStage(true);


        /*StageStickmanController oldStage = new StageController();
        oldStage.addStickman("Anna");
*/
    }
}
