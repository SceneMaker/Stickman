package de.dfki.stickmanSwing.stage;

import de.dfki.common.interfaces.Stickman;
import de.dfki.common.interfaces.StickmanStage;
import de.dfki.common.interfaces.StageRoom;
import de.dfki.common.StickmansOnStage;
import de.dfki.stickmanSwing.StickmanSwing;

import java.awt.image.BufferedImage;

/**
 * Created by alvaro on 9/19/16.
 */
public class StageRoomSwing implements StageRoom {
    private StickmansOnStage commonStickmansOnStage;
    private StickmanStage stickmanStage;
    private boolean fullScreen = false;

    public StageRoomSwing(){
        stickmanStage = new StickmanStageSwing();
        commonStickmansOnStage = new StickmansOnStageSwing(stickmanStage, this);
        //stickmanStage.setStickamnsOnStage(commonStickmansOnStage);
    }

    @Override
    public void clearStage() {
        commonStickmansOnStage.clearStage();
        ((StickmanStageSwing)stickmanStage).clearStage();
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
        ((StickmanStageSwing)stickmanStage).addStickmanToPanel((StickmanSwing) commonStickmansOnStage.getStickman(name));
        ((StickmanStageSwing)stickmanStage).pack();
        ((StickmanStageSwing)stickmanStage).setVisible(true);
    }

    @Override
    public Stickman getStickman(String name) {
        return commonStickmansOnStage.getStickman(name);
    }

    @Override
    public void launchStickmanStage(boolean show) {}

    @Override
    public StickmanStage getStickmanStage() {
        return stickmanStage;
    }

    public StickmansOnStage getCommonStickmansOnStage() {
        return commonStickmansOnStage;
    }

    @Override
    public String getStageIdentifier() {
        return "";
    }

    @Override
    public void setFullScreen(boolean fullS) {
        fullScreen = fullS;
        ((StickmanStageSwing)stickmanStage).setFullScreenSize();
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
