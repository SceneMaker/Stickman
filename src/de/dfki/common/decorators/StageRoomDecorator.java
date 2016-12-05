package de.dfki.common.decorators;

import de.dfki.common.interfaces.Stickman;
import de.dfki.common.interfaces.StickmanStage;
import de.dfki.common.interfaces.StageRoom;
import de.dfki.common.StickmansOnStage;

import java.awt.image.BufferedImage;

/**
 * Created by alvaro on 9/17/16.
 */
public abstract class StageRoomDecorator implements StageRoom {

    protected StageRoom controllerFX;

    public StageRoomDecorator(StageRoom wrappedController) {
        controllerFX = wrappedController;
    }

    @Override
    public boolean ismNetwork() {
        return controllerFX.ismNetwork();
    }

    @Override
    public void clearStage() {
        controllerFX.clearStage();
    }

    @Override
    public void sendTimeMarkInformation(String timemark) {
        controllerFX.sendTimeMarkInformation(timemark);
    }

    @Override
    public void sendAnimationUpdate(String state, String id) {
        controllerFX.sendAnimationUpdate(state, id);
    }

    @Override
    public void launchStickmanStage(boolean show) {
        controllerFX.launchStickmanStage(show);
    }

    public void addStickman(String name) {
        controllerFX.addStickman(name);
    }

    public void addStickman(String name, boolean onlyFace) {
        controllerFX.addStickman(name, onlyFace);
    }

    @Override
    public void animate(String stickmanname, String name, int duration, String text, boolean block) {
        controllerFX.animate(stickmanname, name, duration, text, block);
    }

    @Override
    public Stickman getStickman(String name) {
        return controllerFX.getStickman(name);
    }

    public StickmansOnStage getCommonStickmansOnStage() {
        return controllerFX.getCommonStickmansOnStage();
    }

    public StickmanStage getStickmanStage() {
        return controllerFX.getStickmanStage();
    }

    public String getStageIdentifier() {
        return controllerFX.getStageIdentifier();
    }

    public void setFullScreen(boolean fullScreen) {
        controllerFX.setFullScreen(fullScreen);
    }

    @Override
    public BufferedImage getStageAsImage() throws Exception {
        return controllerFX.getStageAsImage();
    }

    @Override
    public void launchStickmanConfiguration() {
    }

    @Override
    public void launchStickmanConfiguration(String filepath) {

    }

    @Override
    public void launchStickmanStage(boolean show, String filepath) {
        controllerFX.launchStickmanStage(show, filepath);
    }

}
