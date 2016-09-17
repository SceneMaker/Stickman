package de.dfki.stickmanfx.stagecontroller;

import de.dfki.common.CommandParser;
import de.dfki.common.CommonStickman;
import de.dfki.common.StageStickman;
import de.dfki.common.StageStickmanController;
import de.dfki.common.StickmansOnStage;
import de.dfki.stickmanfx.StickmanFX;
import de.dfki.stickmanfx.StickmanStageFX;
import de.dfki.stickmanfx.client.ClientConnectionHandlerFX;
import java.io.IOException;

/**
 * Created by alvaro on 9/12/16.
 */
public class StageStickmanControllerFX implements StageStickmanController {
    public static final String CONFIG_STAGE = "configStage";
    private final ApplicationFXLauncher applicationFXLauncher = new ApplicationFXLauncher();
    private StageStickman stickmanStageFX;

    protected StickmansOnStage stickmansOnStage;
    private String stageIdentifier;

    public StageStickmanControllerFX(){
        getStickmanStageInstance();
        createNewStickmanStage();
    }

    protected void getStickmanStageInstance() {
        if(StickmanStageFX.isRunning){
            stickmanStageFX = (StageStickman) StickmanStageFX.getInstance();

        }else{
            applicationFXLauncher.launchStickmanAndWait();
        }
    }

    protected void createNewStickmanStage() {
        stickmanStageFX = (StageStickman) StickmanStageFX.getInstance();
        init();
        try {
            stageIdentifier = ((StickmanStageFX)stickmanStageFX).createNewStage();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void init() {
        stickmansOnStage = new StickmansOnStage(stickmanStageFX, this);
        ((StickmanStageFX) stickmanStageFX).setStickamnsOnStage(stickmansOnStage);
    }

    @Override
    public  void clearStage() {
        stickmansOnStage.clearStage();
    }

    public  void animate(String stickmanname,  String name, int duration, String text, boolean block) {
        StickmanFX sm = (StickmanFX) stickmansOnStage.getStickmanFX(stickmanname);
        sm.doAnimation(name, duration, text, block);
    }

    @Override
    public boolean ismNetwork() {
        return false;
    }

    @Override
    public  void sendTimeMarkInformation(String timemark) {
        System.out.println("SEND TIME MAR");
    }

    @Override
    public  void sendAnimationUpdate(String state, String id) {}

    public void launchStickmanConfiguration(){
        try {
            stickmanStageFX.addStickmanToStage(CONFIG_STAGE);
            ((StickmanStageFX)stickmanStageFX).showStage(CONFIG_STAGE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void launchStickmanStage(){
        try {
            stickmanStageFX.addStickmanToStage(stageIdentifier);
            ((StickmanStageFX)stickmanStageFX).showStage(stageIdentifier);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void launchStickmanConfiguration(String filepath){}

    public void launchStickmanStage(String filepath){}

    public void addStickman(String name){
        stickmansOnStage.addStickman(name, false);
    }
    
    public CommonStickman getStickman(String name){
        return stickmansOnStage.getStickmanFX(name);
    }
}
