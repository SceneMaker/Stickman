package de.dfki.test;

import de.dfki.common.decorators.StageRoomFullScreenDecorator;
import de.dfki.common.interfaces.StageRoom;
import de.dfki.stickman3D.stage.StageRoom3D;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

/**
 * Created by alvaro on 9/13/16.
 */
public class testStickmanFX
{

    public static void main(String[] args)
    {

//        StageRoom agentStage = new StageRoomSwing();
//        agentStage.addAgent("Patrick");
//        //agentStage.addAgent("Bob");
//        agentStage.launchStage(true);
//        agentStage.getAgent("Patrick").doAnimation("Smile", 2000, "", true);
        StageRoom reeti = new StageRoom3D(0, 0, true);
        StageRoom stickmanStage3DFull = new StageRoomFullScreenDecorator(reeti);
//        reeti.addAgent("Anna");
        stickmanStage3DFull.addAgent("Anna");
//        stickmanStage3DFull.addAgent("Anna");
//        reeti.addAgent("Bob1");
//        reeti.addAgent("Reeti1");
//        reeti.addAgent("Reeti2");

//        stickmanStage3D1.addAgent("Bob");
//        stickmanStage3D1.launchStage(true);
//        reeti.launchConfiguration();
        stickmanStage3DFull.launchAgentStage(true);
//        stickmanStage3D1.getAgent("Anna").doAnimation("StartBreathing", 1200, 600, true);
//        stickmanStage3D1.getAgent("Anna").doAnimation("StartBlinking", 3000, 20, true);
        //stickmanStage3D1.getAgent("Bob").doAnimation("TiltRightStart", 500, true);
//        stickmanStage3D1.getAgent("Anna").doAnimation("StartIdle", 500, true);
//        stickmanStage3D1.getAgent("Anna").doAnimation("HeadDown1", 500, true);
        Timeline timeline = new Timeline(new KeyFrame(
                Duration.millis(1000),
                ae ->
                {
//                    stickmanStage3D1.getAgent("Anna").doAnimation("StopBreathing", 200, true);
//                    stickmanStage3D1.getAgent("Anna").doAnimation("StartBreathing", 1200, 600, true);
                    //stickmanStage3D1.getAgent("Anna").doAnimation("StopIdle", 500, true);
                    //stickmanStage3D1.getAgent("Anna").doAnimation("WaveLeft", 500, true);
                }
        ));
//        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

//       

//        StageRoom stickmanStage2 = new StageRoomFX(0, 500, true);
//        stickmanStage2.addAgent("Sarah");
//        stickmanStage2.launchStage(true);
        //stickmanStage2.launchStage(true);

        /*StageRoom stickmanStageFx = new StageRoomFX(0,500, true);
        //StageRoom stickmanStageFull = new StageRoomFullScreenDecorator(stickmanStageFx);
        stickmanStageFx.addAgent("Anna");
        //agentStage.addAgent("Bob");
        stickmanStageFx.launchStage(true);*/
 /*
        StageRoom stickmanStage2 = new StageRoomFX(1921, 0, true);
        StageRoom stickmanStageFull2 = new StageRoomFullScreenDecorator(stickmanStage2);
        stickmanStageFull2.addAgent("Martin");
        stickmanStageFull2.addAgent("Sarah");
        stickmanStageFull2.launchStage(true);
        //stickmanStage2.launchStage(true);
        BufferedImage bufferedImage = null;


        StageRoom stickmanStage3D = new StageRoom3D(991,0, true);
        stickmanStage3D.addAgent("Martin");
        stickmanStage3D.addAgent("Bob");
        //stickmanStage3D.launchStage(true);
        stickmanStage3D.launchStage(true);*/

 /*StageRoom stickmanStage3D1 = new StageRoom3D(0,0, true);
        stickmanStage3D1.addAgent("Robbie");
        //stickmanStage3D.launchStage(true)
        stickmanStage3D1.launchConfiguration();*/

 /* StageRoom agentStage = new StageRoomFX(0,0, true);
        StageRoom stickmanStageFull = new StageRoomFullScreenDecorator(agentStage);
        agentStage.addAgent("Patrick");
        //agentStage.addAgent("Bob");
        agentStage.launchConfiguration();*/
 /*StageRoom oldStage = new StageRoomSwing();
        oldStage.addAgent("Anna");
         */
    }
}
