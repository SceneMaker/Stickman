package de.dfki.stickman3D.stage;

import de.dfki.common.*;
import de.dfki.common.commonFX3D.ApplicationLauncherImpl;
import de.dfki.common.commonFX3D.ViewController;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

import java.io.IOException;

/**
 * Created by alvaro on 11/10/16.
 */
public class StagePaneHandler3D {

    private HBox root;
    private ScrollPane stickmanScrollPane;
    private SplitPane mSplitPane;
    private HBox sStickmanPane;
    private ViewController mStickmanStageController;

    public StagePaneHandler3D() {
        if (ApplicationLauncherImpl.isRunning()) {
            try {
                if(mStickmanStageController == null)
                    invoke();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public HBox getConfigRoot() throws IOException {
        if(mStickmanStageController == null)
            invoke();

        return root;
    }

    public HBox getStageRoot() throws IOException {
        if(mStickmanStageController == null)
            invoke();
        AnchorPane controlPanel = (AnchorPane) root.lookup("#controlPanel");
        if (controlPanel != null) {
            root.getChildren().remove(controlPanel);
        }
        return root;
    }

    private StagePaneHandler3D invoke() throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/de/dfki/stickman3D/View.fxml"));
        root = loader.load();
        mStickmanStageController = loader.getController();
        //mStickmanStageController.setlePerlinNoiseOn();
        return this;

    }

    public ViewController getmStickmanStageController() {
        return mStickmanStageController;
    }

    public void setStickmansOnStage(StickmansOnStage stickmans) {
        mStickmanStageController.setStickamnOnStage(stickmans);
    }

}
