package de.dfki.test;

import de.dfki.common.CommonStageStickmanNetworkControllerDecorator;
import de.dfki.common.StageStickmanController;
import de.dfki.stickman.stagecontroller.StageController;
import de.dfki.stickman.stagecontroller.decorators.StageStickmanFullScreenDecorator;
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
        StageStickmanController stickmanStage = new StageStickmanControllerFX();
       // StageStickmanController stickmanStage = new StageStickmanFullScreenControllerFXDecorator(stage);
       

        StageStickmanController stickmanStage2 = new StageStickmanControllerFX();
        stickmanStage2.addStickman("Anna", true);
        stickmanStage2.addStickman("Bob", true);
//        stickmanStage2.addStickman("character", true);
//    	stickmanStage2.addStickman("abbey"); 
//    	stickmanStage2.addStickman("abbie");
        stickmanStage2.launchStickmanStage(true);
//        stickmanStage2.launchStickmanConfiguration();
        BufferedImage bufferedImage = null;
        try
		{
			Thread.sleep(2000);
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        /*try {
            bufferedImage = stickmanStage.getStageAsImage();
        } catch (Exception e) {
            e.printStackTrace();
        }
        File outputfile = new File("/home/alvaro/Pictures/test/image.jpg");
        try {
            ImageIO.write(bufferedImage, "jpg", outputfile);
        } catch (IOException e) {
            e.printStackTrace();
        }*/


       /* StageStickmanController stickmanStage3 = new StageStickmanControllerFX();
        stickmanStage3.addStickman("Baxter");
        ((StageStickmanControllerFX)stickmanStage3).launchStickmanConfiguration();*/
//        stickmanStage2.getStickman("Bob").doAnimation("Speaking", 3000, "Stell Dir vor, Du kommst nach Hause, und ein Pferd steht in der Küche.", false);
//        if(mouseEvent.getButton().equals(MouseButton.SECONDARY)){
//        	stickmanStage2.getStickman("Bob").doAnimation("ZoomIn", 1000, true);
//    	}else{
//    		stickmanStage2.getStickmanFX("Bob").doAnimation("ZoomOut", 1000, true);
//    	}  
        
//        stickmanStage2.getStickman("Bob").doAnimation("ZoomIn", 1000, true);
//        
//        
//        try
//		{
//			Thread.sleep(2000);
//		} catch (InterruptedException e)
//		{
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//        
//        
//        stickmanStage2.getStickman("Bob").doAnimation("ZoomOut", 1000, true);
//        
//        System.out.println("test");
    }
}
