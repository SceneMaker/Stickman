package de.dfki.test;

import de.dfki.common.interfaces.StageStickmanController;
import de.dfki.stickman3D.StageStickmanController3D;
import de.dfki.stickmanSwing.stagecontroller.StageController;

/**
 * Created by alvaro on 9/13/16.
 */
public class testStickmanFX {
    public static void main(String[] args) {


        StageStickmanController stickmanStage = new StageController();
        stickmanStage.addStickman("Patrick");
        //stickmanStage.addStickman("Bob");
        stickmanStage.launchStickmanStage(true);
        stickmanStage.getStickman("Patrick").doAnimation("Smile", 2000, "", true);

        StageStickmanController stickmanStage3D1 = new StageStickmanController3D(500,0, true);
        stickmanStage3D1.addStickman("Robbie");
        //stickmanStage3D.launchStickmanStage(true)
        stickmanStage3D1.launchStickmanStage(true);
        stickmanStage3D1.getStickman("Robbie").doAnimation("Smile", 2000, "", true);

        /*StageStickmanController stickmanStage = new StageStickmanControllerFX(0,0, true);
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
        stickmanStage3D.launchStickmanStage(true);*/

        /*StageStickmanController stickmanStage3D1 = new StageStickmanController3D(0,0, true);
        stickmanStage3D1.addStickman("Robbie");
        //stickmanStage3D.launchStickmanStage(true)
        stickmanStage3D1.launchStickmanConfiguration();*/

       /* StageStickmanController stickmanStage = new StageStickmanControllerFX(0,0, true);
        StageStickmanController stickmanStageFull = new StageStickmanFullScreenControllerFXDecorator(stickmanStage);
        stickmanStage.addStickman("Patrick");
        //stickmanStage.addStickman("Bob");
        stickmanStage.launchStickmanConfiguration();*/


        /*StageStickmanController oldStage = new StageController();
        oldStage.addStickman("Anna");
*/
    }
}
