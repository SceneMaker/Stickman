package de.dfki.stickman3D.stage;

import de.dfki.common.commonFX3D.StageRoomImpl;
import de.dfki.stickman3D.utils.XmlStickmanLoader;
import de.dfki.common.commonFX3D.ApplicationLauncherImpl;
import de.dfki.stickman3D.ApplicationLauncher3D;

import java.io.IOException;

/**
 * Created by alvaro on 9/12/16.
 */
public class StageRoom3D extends StageRoomImpl {

    public StageRoom3D() {
        getStageInstance();
        createNewStage(0, 0, true);
    }

    public StageRoom3D(int x, int y) {
        getStageInstance();
        createNewStage(x, y, true);
    }

    public StageRoom3D(int x, int y, boolean decoration) {
        getStageInstance();
        createNewStage(x, y, decoration);
    }

    @Override
    public void sendTimeMarkInformation(String timemark) {

    }

    @Override
    public void sendAnimationUpdate(String state, String id) {

    }

    protected void getStageInstance() {
        applicationFXLauncher = new ApplicationLauncher3D();
        if (ApplicationLauncherImpl.isRunning()) {
            stickmanStageFX = StickmanStage3D.getInstance();
        } else {
            applicationFXLauncher.launchStickmanAndWait();
        }
    }

    protected void createNewStage(int x, int y, boolean decoration) {
        stickmanStageFX = StickmanStage3D.getInstance();
        try {
            stageIdentifier = getStickmanStage().createNewStage(x, y, decoration);
            init(stageIdentifier);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void init(String stageIdentifier) {

        commonStickmansOnStage = new StickmansOnStage3D(getStickmanStage(), this, stageIdentifier);
        getStickmanStage().setStickamnsOnStage(getCommonStickmansOnStage(), stageIdentifier);
        getStickmanStage().setStickamnsOnStage(getCommonStickmansOnStage(), CONFIG_STAGE);
    }

    public void launchConfiguration() {
        StickmanStage3D ss3D;
        try {
            ss3D = (StickmanStage3D) getStickmanStage();
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
        XmlStickmanLoader loader = new XmlStickmanLoader(commonStickmansOnStage);
        loader.initialStickmanWithXml();
        launchConfiguration();
//        loader.initialStickmanWithXml();
    }
    
    @Override
    public void launchStage(boolean show, String filepath) {
        commonStickmansOnStage.setmFilePath(filepath);
        XmlStickmanLoader loader = new XmlStickmanLoader(commonStickmansOnStage);
        loader.initialStickmanWithXml();
        launchStickmanStage(show);
//        loader.initialStickmanWithXml();
    }
}
