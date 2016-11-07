package de.dfki.stickmanfx.stagecontroller.decorators;

import de.dfki.common.CommonStickman;
import de.dfki.common.StageStickman;
import de.dfki.common.StageStickmanController;
import de.dfki.common.CommonStickmansOnStage;

import java.awt.image.BufferedImage;

/**
 * Created by alvaro on 9/17/16.
 */
public abstract class StageStickmanDecorator implements StageStickmanController {
    protected StageStickmanController controllerFX;

    public StageStickmanDecorator(StageStickmanController wrappedController){
        controllerFX = wrappedController;
    }

    @Override
    public boolean ismNetwork(){
        return controllerFX.ismNetwork();
    }

    @Override
    public void clearStage(){
        controllerFX.clearStage();
    }

    @Override
    public  void sendTimeMarkInformation(String timemark) {
        controllerFX.sendTimeMarkInformation(timemark);
    }

    @Override
    public  void sendAnimationUpdate(String state, String id) {
        controllerFX.sendAnimationUpdate(state, id);
    }

    @Override
    public void launchStickmanStage(boolean show){
       controllerFX.launchStickmanStage(show);
    }

    public void addStickman(String name){
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
    public CommonStickman getStickman(String name) {
        return controllerFX.getStickman(name);
    }

    public CommonStickmansOnStage getCommonStickmansOnStage(){
        return controllerFX.getCommonStickmansOnStage();
    }

    public StageStickman getStickmanStage(){
        return controllerFX.getStickmanStage();
    }

    public String getStageIdentifier(){
        return controllerFX.getStageIdentifier();
    }
    public void setFullScreen(boolean fullScreen){
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
    public void launchStickmanConfiguration(String filepath){

    }

    @Override
    public void launchStickmanStage(boolean show, String filepath) {
        controllerFX.launchStickmanStage(show, filepath);
    }

}
