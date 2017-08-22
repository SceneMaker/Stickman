package de.dfki.common.interfaces;

import de.dfki.common.AgentsOnStage;
import de.dfki.stickmanFX.StickmanFX;
import javafx.scene.layout.HBox;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by alvaro on 9/4/16.
 */
public interface AgentStage
{

    float getFullScreenScale();

    Dimension getFullScreenDimension();

    void addAgentToStage(String stageIdentifier) throws Exception;

    void setStageFullScreen(String stageIdentifier);

    void setStageNonFullScreen(String stageIdentifier);

    void setAgentsOnStage(AgentsOnStage agentsOnStage, String identifier);

    HBox getAgentBox(String stageIdentifier) throws Exception;

    BufferedImage getStageAsImage(String stageIdentifier) throws Exception;

    //Warum hier StickmanFX? Und wenn hier StickmanFX sein muss, warum wird
    //diese Methode von ReetiStage und StickmanStage3D implementiert?
    //Die Methode wird nur in der Klasse ZoomIO benutzt!!! Frage Robbie!!!
    void addAgentToStage(String mStageIdentifier, StickmanFX mStickmanFX) throws Exception;

    void lauchAgent();

    void clearStage(String stageIdentifier);

    void showStage(String configStage);

    String createNewStage(int x, int y, boolean decoration) throws IOException;
}
