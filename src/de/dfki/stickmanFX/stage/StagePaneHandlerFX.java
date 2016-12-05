package de.dfki.stickmanFX.stage;

import de.dfki.common.StickmansOnStage;
import de.dfki.common.commonFX3D.ApplicationLauncherImpl;
import de.dfki.stickmanFX.StickmanStageController;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.HBox;

import java.io.IOException;

public class StagePaneHandlerFX {

    private HBox root;
    private ScrollPane stickmanScrollPane;
    private SplitPane mSplitPane;
    private HBox sStickmanPane;
    private StickmanStageController mStickmanStageController;

    public StagePaneHandlerFX() {
        if (ApplicationLauncherImpl.isRunning()) {
            try {
                invoke();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public HBox getConfigRoot() throws IOException {
        invoke();
        if (!root.getChildren().contains(mSplitPane)) {
            root.getChildren().remove(stickmanScrollPane);
            root.getChildren().add(mSplitPane);
            root.getChildren().add(stickmanScrollPane);
        }
        sStickmanPane.setAlignment(Pos.CENTER_LEFT);
        return root;
    }

    public HBox getStageRoot() throws IOException {
        invoke();
        if (root.getChildren().contains(mSplitPane)) {
            root.getChildren().remove(mSplitPane);
        }
        sStickmanPane.setAlignment(Pos.CENTER); //CENTER_LEFT
        return root;
    }

    private StagePaneHandlerFX invoke() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/de/dfki/stickmanFX/StickmanStageView.fxml"));
        root = loader.load();
        root.getWidth();
        stickmanScrollPane = (ScrollPane) root.lookup("#stickmanScrollPane");
        mSplitPane = (SplitPane) root.lookup("#mSplitPane");
        sStickmanPane = new HBox();
        stickmanScrollPane.setContent(sStickmanPane);
        mStickmanStageController = loader.getController();
        getmStickmanStageController().setlePerlinNoiseOn();
        sStickmanPane.prefWidthProperty().bind(root.widthProperty());
        sStickmanPane.prefHeightProperty().bind(root.heightProperty());
        return this;
    }

    public StickmanStageController getmStickmanStageController() {
        return mStickmanStageController;
    }

    public void setStickmansOnStage(StickmansOnStage stickmans) {
        mStickmanStageController.setStickamnOnStage(stickmans);
    }

}
