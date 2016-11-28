package de.dfki.stickmanSwing.stagecontroller;

import de.dfki.common.interfaces.Stickman;
import de.dfki.common.interfaces.StageStickman;
import de.dfki.common.interfaces.StageStickmanController;
import de.dfki.common.CommonStickmansOnStage;
import de.dfki.stickmanSwing.StickmanSwing;
import de.dfki.stickmanSwing.StickmanStage;

import java.awt.image.BufferedImage;

/**
 * Created by alvaro on 9/19/16.
 */
public class StageController implements StageStickmanController {
    private CommonStickmansOnStage commonStickmansOnStage;
    private StageStickman stickmanStage;
    private boolean fullScreen = false;

    public StageController(){
        stickmanStage = new StickmanStage();
        commonStickmansOnStage = new StickmansOnStage(stickmanStage, this);
        //stickmanStage.setStickamnsOnStage(commonStickmansOnStage);
    }

    @Override
    public void clearStage() {
        commonStickmansOnStage.clearStage();
        ((StickmanStage)stickmanStage).clearStage();
    }

    @Override
    public void animate(String stickmanname, String name, int duration, String text, boolean block) {
        StickmanSwing sm = (StickmanSwing) commonStickmansOnStage.getStickman(stickmanname);
        sm.doAnimation(name, duration, text, block);
    }

    @Override
    public boolean ismNetwork() {
        return false;
    }

    @Override
    public void sendTimeMarkInformation(String timemark) {}

    @Override
    public void sendAnimationUpdate(String state, String id) {}

    @Override
    public void addStickman(String name) {
        commonStickmansOnStage.addStickman(name, fullScreen);
        ((StickmanStage)stickmanStage).addStickmanToPanel((StickmanSwing) commonStickmansOnStage.getStickman(name));
        ((StickmanStage)stickmanStage).pack();
        ((StickmanStage)stickmanStage).setVisible(true);
    }

    @Override
    public Stickman getStickman(String name) {
        return commonStickmansOnStage.getStickman(name);
    }

    @Override
    public void launchStickmanStage(boolean show) {}

    @Override
    public StageStickman getStickmanStage() {
        return stickmanStage;
    }

    public CommonStickmansOnStage getCommonStickmansOnStage() {
        return commonStickmansOnStage;
    }

    @Override
    public String getStageIdentifier() {
        return "";
    }

    @Override
    public void setFullScreen(boolean fullS) {
        fullScreen = fullS;
        ((StickmanStage)stickmanStage).setFullScreenSize();
    }

    @Override
    public void addStickman(String name, boolean onlyFace) {
        addStickman(name);
    }

    @Override
    public BufferedImage getStageAsImage() {
        return null;
    }

    @Override
    public void launchStickmanConfiguration() {
	
    }

    @Override
    public void launchStickmanConfiguration(String filepath) {

    }

    @Override
    public void launchStickmanStage(boolean show, String filepath) {

    }
}
