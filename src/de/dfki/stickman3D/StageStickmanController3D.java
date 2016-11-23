package de.dfki.stickman3D;

import de.dfki.StageFX.StageStickmanControllerImpl;
import de.dfki.common.ApplicationFXLauncherImpl;

import java.io.IOException;

/**
 * Created by alvaro on 9/12/16.
 */
public class StageStickmanController3D extends StageStickmanControllerImpl {

    public StageStickmanController3D(){
        getStickmanStageInstance();
        createNewStickmanStage(0,0, true);
    }

    public StageStickmanController3D(int x, int y){
        getStickmanStageInstance();
        createNewStickmanStage(x, y, true);
    }

    public StageStickmanController3D(int x, int y, boolean decoration){
        getStickmanStageInstance();
        createNewStickmanStage(x, y, decoration);
    }


    @Override
    public void sendTimeMarkInformation(String timemark) {

    }

    @Override
    public void sendAnimationUpdate(String state, String id) {

    }

    protected void getStickmanStageInstance() {
        applicationFXLauncher = new ApplicationLauncher3DFx();
        if(ApplicationFXLauncherImpl.isRunning()){
            stickmanStageFX = StickmanStage3D.getInstance();
        }else{
            applicationFXLauncher.launchStickmanAndWait();
        }
    }

    protected void createNewStickmanStage(int x, int y, boolean decoration) {
        stickmanStageFX = StickmanStage3D.getInstance();
        try {
            stageIdentifier =  getStickmanStage().createNewStage(x, y, decoration);
            init(stageIdentifier);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void init(String stageIdentifier) {

        commonStickmansOnStage = new StickmansOnStage3DFX(getStickmanStage(), this);
        getStickmanStage().setStickamnsOnStage(getCommonStickmansOnStage(), stageIdentifier);
        getStickmanStage().setStickamnsOnStage(getCommonStickmansOnStage(), CONFIG_STAGE);
    }
}
