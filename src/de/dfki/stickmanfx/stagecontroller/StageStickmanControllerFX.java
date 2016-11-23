package de.dfki.stickmanfx.stagecontroller;

import de.dfki.StageFX.StageStickmanControllerImpl;
import de.dfki.common.ApplicationFXLauncherImpl;
import de.dfki.stickmanfx.StickmanStageFX;

import java.io.IOException;

/**
 * Created by alvaro on 9/12/16.
 */
public class StageStickmanControllerFX extends StageStickmanControllerImpl {

    public StageStickmanControllerFX(){
        getStickmanStageInstance();
        createNewStickmanStage(0,0, true);
    }

    public StageStickmanControllerFX(int x, int y){
        getStickmanStageInstance();
        createNewStickmanStage(x, y, true);
    }

    public StageStickmanControllerFX(int x, int y, boolean decoration){
        getStickmanStageInstance();
        createNewStickmanStage(x, y, decoration);
    }


    @Override
    protected void getStickmanStageInstance() {
        applicationFXLauncher = new ApplicationLauncher2DFx();
        if(ApplicationFXLauncherImpl.isRunning()){
            stickmanStageFX = StickmanStageFX.getInstance();

        }else{
            applicationFXLauncher.launchStickmanAndWait();
        }
    }


    @Override
    protected void createNewStickmanStage(int x, int y, boolean decoration) {
        stickmanStageFX = StickmanStageFX.getInstance();

        try {
            stageIdentifier = getStickmanStage().createNewStage(x, y, decoration);
            init(stageIdentifier);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void init(String stageIdentifier) {
        commonStickmansOnStage = new StickmansOnStageFX(getStickmanStage(), this);
        getStickmanStage().setStickamnsOnStage(getCommonStickmansOnStage(), stageIdentifier);
        getStickmanStage().setStickamnsOnStage(getCommonStickmansOnStage(), CONFIG_STAGE);
    }

    @Override
    public void sendTimeMarkInformation(String timemark) {

    }

    @Override
    public void sendAnimationUpdate(String state, String id) {

    }
}
