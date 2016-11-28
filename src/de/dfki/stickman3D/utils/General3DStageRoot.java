package de.dfki.stickman3D.utils;

import de.dfki.common.*;
import de.dfki.common.interfaces.FXViewController;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

import java.io.IOException;

/**
 * Created by alvaro on 11/10/16.
 */
public class General3DStageRoot {
    private HBox root;
    private ScrollPane stickmanScrollPane;
    private SplitPane mSplitPane;
    private HBox sStickmanPane;
    private FXViewController mStickmanStageController;

    public General3DStageRoot(){
        if(ApplicationFXLauncherImpl.isRunning()) {
            try {
                invoke();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public HBox getConfigRoot() throws IOException {
        invoke();

        return root;
    }

    public HBox getStageRoot() throws IOException {
        invoke();
        AnchorPane controlPanel = (AnchorPane) root.lookup("#controlPanel");
        if(controlPanel != null){
            root.getChildren().remove(controlPanel);
        }
        return root;
    }

    private General3DStageRoot invoke() throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/de/dfki/stickman3D/View.fxml"));
        root = loader.load();
        mStickmanStageController = loader.getController();
        //mStickmanStageController.setlePerlinNoiseOn();
        return  this;

    }

    public FXViewController getmStickmanStageController() {
        return mStickmanStageController;
    }

    public void setStickmansOnStage(CommonStickmansOnStage stickmans){
        mStickmanStageController.setStickamnOnStage(stickmans);
    }

}
