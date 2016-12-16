package de.dfki.common.interfaces;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import de.dfki.common.StickmansOnStage;
import de.dfki.stickmanFX.StickmanFX;
import javafx.scene.layout.HBox;

/**
 * Created by alvaro on 9/4/16.
 */
public interface StickmanStage {

    float getFullScreenScale();

    Dimension getFullScreenDimension();

    void addStickmanToStage(String stageIdentifier) throws Exception;

    void setStageFullScreen(String stageIdentifier);

    void setStageNonFullScreen(String stageIdentifier);

    void setStickamnsOnStage(StickmansOnStage stickamnsOnStage, String identifier);

    HBox getStickmanBox(String stageIdentifier) throws Exception;

    BufferedImage getStageAsImage(String stageIdentifier) throws Exception;

    void addStickmanToStage(String mStageIdentifier, StickmanFX mStickmanFX) throws Exception;

    void lauchStickman();

    void clearStage(String stageIdentifier);

    void showStage(String configStage);

    String createNewStage(int x, int y, boolean decoration) throws IOException;
}
