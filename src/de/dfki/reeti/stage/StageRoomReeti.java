package de.dfki.reeti.stage;

import de.dfki.common.commonFX3D.StageRoomImpl;
import de.dfki.common.commonFX3D.ApplicationLauncherImpl;
import de.dfki.reeti.ApplicationLauncherReeti;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by alvaro on 9/12/16.
 */
public class StageRoomReeti extends StageRoomImpl {

    public StageRoomReeti() {
        getStageInstance();
        createNewStage(0, 0, true);
    }

    public StageRoomReeti(int x, int y) {
        getStageInstance();
        createNewStage(x, y, true);
    }

    public StageRoomReeti(int x, int y, boolean decoration) {
        getStageInstance();
        createNewStage(x, y, decoration);
    }

    @Override
    public void sendTimeMarkInformation(String timemark) {

    }

    @Override
    public void sendAnimationUpdate(String state, String id) {

    }

    @Override
    protected void getStageInstance() {
        applicationFXLauncher = new ApplicationLauncherReeti();
        if (ApplicationLauncherImpl.isRunning()) {
            stickmanStageFX = ReetiStage.getInstance();
        } else {
            applicationFXLauncher.launchStickmanAndWait();
        }
    }

    @Override
    protected void createNewStage(int x, int y, boolean decoration) {
        stickmanStageFX = ReetiStage.getInstance();
        try {
            stageIdentifier = getStickmanStage().createNewStage(x, y, decoration);
            init(stageIdentifier);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void init(String stageIdentifier) {

        commonStickmansOnStage = new ReetiOnStage(getStickmanStage(), this, stageIdentifier);
        getStickmanStage().setStickamnsOnStage(getCommonStickmansOnStage(), stageIdentifier);
        getStickmanStage().setStickamnsOnStage(getCommonStickmansOnStage(), CONFIG_STAGE);
    }

    @Override
    public void launchConfiguration() {
        ReetiStage ss3D;
        try {
            ss3D = (ReetiStage) getStickmanStage();
            ss3D.setShowControlPanel(true);
            ss3D.addStickmanToStage(CONFIG_STAGE);
            ss3D.showStage(CONFIG_STAGE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void launchConfiguration(String filepath) {
        commonStickmansOnStage.setmFilePath(filepath);
        StageRoomReeti.this.launchConfiguration();
//        loader.initialStickmanWithXml();
    }

    @Override
    public void launchStage(boolean show, String filepath) {
        commonStickmansOnStage.setmFilePath(filepath);
        launchStickmanStage(show);
//        loader.initialStickmanWithXml();
    }
    
    @Override
    public ArrayList<String> getAnimations() {
        return new ArrayList<>();
    }
    
}
