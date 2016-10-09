package de.dfki.common;

import java.awt.image.BufferedImage;

/**
 * Created by alvaro on 9/12/16.
 */
public interface StageStickmanController {
    void clearStage();
    void animate(String stickmanname,  String name, int duration, String text, boolean block);
    boolean ismNetwork();
    void sendTimeMarkInformation(String timemark);
    void sendAnimationUpdate(String state, String id);
    void addStickman(String name);
    CommonStickman getStickman(String name);
    void launchStickmanStage(boolean show);
    StageStickman getStickmanStage();
    CommonStickmansOnStage getCommonStickmansOnStage();
    String getStageIdentifier();
    void setFullScreen(boolean fullScreen);
    void addStickman(String name, boolean onlyFace);
    BufferedImage getStageAsImage() throws Exception;
    void launchStickmanConfiguration();
}
