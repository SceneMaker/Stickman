package de.dfki.test;

import de.dfki.common.interfaces.StageRoom;
import de.dfki.stickman3D.StageRoom3D;
import de.dfki.stickmanSwing.stagecontroller.StageRoomSwing;

/**
 * Created by alvaro on 9/13/16.
 */
public class testStickmanFX {
    public static void main(String[] args) {


        StageRoom stickmanStage = new StageRoomSwing();
        stickmanStage.addStickman("Patrick");
        //stickmanStage.addStickman("Bob");
        stickmanStage.launchStickmanStage(true);
        stickmanStage.getStickman("Patrick").doAnimation("Smile", 2000, "", true);

        StageRoom stickmanStage3D1 = new StageRoom3D(500,0, true);
        stickmanStage3D1.addStickman("Robbie");
        //stickmanStage3D.launchStickmanStage(true)
        stickmanStage3D1.launchStickmanStage(true);
        stickmanStage3D1.getStickman("Robbie").doAnimation("Smile", 2000, "", true);

        /*StageRoom stickmanStage = new StageRoomFX(0,0, true);
        StageRoom stickmanStageFull = new StageRoomFullScreenDecorator(stickmanStage);
        stickmanStage.addStickman("Patrick");
        //stickmanStage.addStickman("Bob");
        stickmanStage.launchStickmanStage(true);


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
