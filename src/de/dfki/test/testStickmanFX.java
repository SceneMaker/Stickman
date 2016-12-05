package de.dfki.test;

import de.dfki.common.decorators.StageRoomFullScreenDecorator;
import de.dfki.common.interfaces.StageRoom;
import de.dfki.stickman3D.stage.StageRoom3D;
import de.dfki.stickmanFX.stage.StageRoomFX;
import de.dfki.stickmanSwing.stage.StageRoomSwing;

/**
 * Created by alvaro on 9/13/16.
 */
public class testStickmanFX {

    public static void main(String[] args) {

//        StageRoom stickmanStage = new StageRoomSwing();
//        stickmanStage.addStickman("Patrick");
//        //stickmanStage.addStickman("Bob");
//        stickmanStage.launchStickmanStage(true);
//        stickmanStage.getStickman("Patrick").doAnimation("Smile", 2000, "", true);
        StageRoom stickmanStage3D1 = new StageRoom3D(500, 0, true);
        StageRoom stickmanStage3DFull = new StageRoomFullScreenDecorator(stickmanStage3D1);
        stickmanStage3DFull.addStickman("Anna");
        stickmanStage3DFull.launchStickmanStage(true);
        stickmanStage3DFull.getStickman("Anna").doAnimation("StartIdle", 1000, true);

//        StageRoom stickmanStage2 = new StageRoomFX(0, 500, true);
//        stickmanStage2.addStickman("Sarah");
//        stickmanStage2.launchStickmanStage(true);
        //stickmanStage2.launchStickmanStage(true);

        /*StageRoom stickmanStageFx = new StageRoomFX(0,500, true);
        //StageRoom stickmanStageFull = new StageRoomFullScreenDecorator(stickmanStageFx);
        stickmanStageFx.addStickman("Anna");
        //stickmanStage.addStickman("Bob");
        stickmanStageFx.launchStickmanStage(true);*/
 /*
        StageRoom stickmanStage2 = new StageRoomFX(1921, 0, true);
        StageRoom stickmanStageFull2 = new StageRoomFullScreenDecorator(stickmanStage2);
        stickmanStageFull2.addStickman("Martin");
        stickmanStageFull2.addStickman("Sarah");
        stickmanStageFull2.launchStickmanStage(true);
        //stickmanStage2.launchStickmanStage(true);
        BufferedImage bufferedImage = null;


        StageRoom stickmanStage3D = new StageRoom3D(991,0, true);
        stickmanStage3D.addStickman("Martin");
        stickmanStage3D.addStickman("Bob");
        //stickmanStage3D.launchStickmanStage(true);
        stickmanStage3D.launchStickmanStage(true);*/

 /*StageRoom stickmanStage3D1 = new StageRoom3D(0,0, true);
        stickmanStage3D1.addStickman("Robbie");
        //stickmanStage3D.launchStickmanStage(true)
        stickmanStage3D1.launchStickmanConfiguration();*/

 /* StageRoom stickmanStage = new StageRoomFX(0,0, true);
        StageRoom stickmanStageFull = new StageRoomFullScreenDecorator(stickmanStage);
        stickmanStage.addStickman("Patrick");
        //stickmanStage.addStickman("Bob");
        stickmanStage.launchStickmanConfiguration();*/
 /*StageRoom oldStage = new StageRoomSwing();
        oldStage.addStickman("Anna");
         */
    }
}
