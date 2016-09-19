package de.dfki.common;

import java.awt.*;
import java.io.IOException;

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
}
