package de.dfki.stickmanfx.stagecontroller;

import de.dfki.common.CommonStickman;
import de.dfki.common.StageStickman;
import de.dfki.common.StageStickmanController;
import de.dfki.common.StickmansOnStage;
import de.dfki.stickmanfx.StickmanFX;
import de.dfki.stickmanfx.StickmanStageFX;

import java.io.IOException;

/**
 * Created by alvaro on 9/12/16.
 */
public class StageStickmanControllerFX implements StageStickmanController {

    public static final String CONFIG_STAGE = "configStage";
    private final ApplicationFXLauncher applicationFXLauncher = new ApplicationFXLauncher();
    private StageStickman stickmanStageFX;
    private StickmansOnStage stickmansOnStage;
    private String stageIdentifier;
    private boolean fullScreen = false;

    public StageStickmanControllerFX(){
        getStickmanStageInstance();
        createNewStickmanStage();
    }

    protected void getStickmanStageInstance() {
        if(StickmanStageFX.isRunning){
            stickmanStageFX = StickmanStageFX.getInstance();

        }else{
            applicationFXLauncher.launchStickmanAndWait();
        }
    }

    protected void createNewStickmanStage() {
        stickmanStageFX = StickmanStageFX.getInstance();
        init();
        try {
            stageIdentifier = ((StickmanStageFX) getStickmanStageFX()).createNewStage();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void init() {
        stickmansOnStage = new StickmansOnStage(getStickmanStageFX(), this);
        ((StickmanStageFX) getStickmanStageFX()).setStickamnsOnStage(getStickmansOnStage());
    }

    @Override
    public  void clearStage() {
        getStickmansOnStage().clearStage();
    }

    public  void animate(String stickmanname,  String name, int duration, String text, boolean block) {
        StickmanFX sm = (StickmanFX) getStickmansOnStage().getStickmanFX(stickmanname);
        sm.doAnimation(name, duration, text, block);
    }

    @Override
    public boolean ismNetwork() {
        return false;
    }

    @Override
    public  void sendTimeMarkInformation(String timemark) {}

    @Override
    public  void sendAnimationUpdate(String state, String id) {}

    public void launchStickmanConfiguration(){
        try {
            getStickmanStageFX().addStickmanToStage(CONFIG_STAGE);
            ((StickmanStageFX) getStickmanStageFX()).showStage(CONFIG_STAGE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void launchStickmanStage(){
        try {
            getStickmanStageFX().addStickmanToStage(getStageIdentifier());
            ((StickmanStageFX) getStickmanStageFX()).showStage(getStageIdentifier());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void launchStickmanConfiguration(String filepath){}

    public void launchStickmanStage(String filepath){}

    public void addStickman(String name){
        getStickmansOnStage().addStickman(name, fullScreen);
    }
    
    public CommonStickman getStickman(String name){
        return getStickmansOnStage().getStickmanFX(name);
    }

    @Override
    public StickmansOnStage getStickmansOnStage() {
        return stickmansOnStage;
    }

    public StageStickman getStickmanStageFX() {
        return stickmanStageFX;
    }

    public String getStageIdentifier() {
        return stageIdentifier;
    }

    public boolean isFullScreen() {
        return fullScreen;
    }

    public void setFullScreen(boolean fullScreen) {
        this.fullScreen = fullScreen;
    }
}
