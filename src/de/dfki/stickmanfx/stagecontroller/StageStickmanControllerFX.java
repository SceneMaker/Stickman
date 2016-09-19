package de.dfki.stickmanfx.stagecontroller;

import de.dfki.common.CommonStickman;
import de.dfki.common.StageStickman;
import de.dfki.common.StageStickmanController;
import de.dfki.common.CommonStickmansOnStage;
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
    private CommonStickmansOnStage commonStickmansOnStage;
    private String stageIdentifier;
    private boolean fullScreen = false;

    public StageStickmanControllerFX(){
        getStickmanStageInstance();
        createNewStickmanStage();
    }


    @Override
    public  void clearStage() {
        getCommonStickmansOnStage().clearStage();
    }

    public  void animate(String stickmanname,  String name, int duration, String text, boolean block) {
        StickmanFX sm = (StickmanFX) getCommonStickmansOnStage().getStickman(stickmanname);
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
            getStickmanStage().addStickmanToStage(CONFIG_STAGE);
            ((StickmanStageFX) getStickmanStage()).showStage(CONFIG_STAGE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void launchStickmanStage(){
        try {
            getStickmanStage().addStickmanToStage(getStageIdentifier());
            ((StickmanStageFX) getStickmanStage()).showStage(getStageIdentifier());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void launchStickmanConfiguration(String filepath){}

    public void launchStickmanStage(String filepath){}

    @Override
    public void addStickman(String name){
        getCommonStickmansOnStage().addStickman(name, fullScreen);
    }

    public void addStickman(String name, boolean onlyFace){
        getCommonStickmansOnStage().addStickman(name, fullScreen, onlyFace);
    }
    
    @Override
    public CommonStickman getStickman(String name){
        return getCommonStickmansOnStage().getStickman(name);
    }

    public CommonStickmansOnStage getCommonStickmansOnStage() {
        return commonStickmansOnStage;
    }

    @Override
    public StageStickman getStickmanStage() {
        return stickmanStageFX;
    }

    @Override
    public String getStageIdentifier() {
        return stageIdentifier;
    }

    @Override
    public void setFullScreen(boolean fullScreen) {
        this.fullScreen = fullScreen;
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
            stageIdentifier = ((StickmanStageFX) getStickmanStage()).createNewStage();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void init() {
        commonStickmansOnStage = new StickmansOnStageFX(getStickmanStage(), this);
        getStickmanStage().setStickamnsOnStage(getCommonStickmansOnStage());
    }

}
