package de.dfki.common;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import de.dfki.stickmanfx.StickmanFX;
import javafx.scene.layout.HBox;

/**
 * Created by alvaro on 9/4/16.
 */
public interface StageStickman {
    float getFullScreenScale();
    Dimension getFullScreenDimension();
    void addStickmanToStage(String stageIdentifier) throws Exception;
    void setStageFullScreen(String stageIdentifier);
    void setStageNonFullScreen(String stageIdentifier);
    void setStickamnsOnStage(CommonStickmansOnStage stickamnsOnStage);
    public HBox getStickmanPane(String stageIdentifier) throws Exception;
    BufferedImage getStageAsImage(String stageIdentifier) throws Exception;
    void addStickmanToStage(String mStageIdentifier, StickmanFX mStickmanFX) throws Exception;
}
