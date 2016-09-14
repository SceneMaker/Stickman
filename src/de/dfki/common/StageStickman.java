package de.dfki.common;

import java.awt.*;

/**
 * Created by alvaro on 9/4/16.
 */
public interface StageStickman {
    public float getFullScreenScale();
    public Dimension getFullScreenDimension();
    public  void addStickmanToStage(String stageIdentifier) throws Exception;
}
