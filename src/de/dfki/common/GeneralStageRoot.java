package de.dfki.common;

import de.dfki.stickmanfx.StickmanStageController;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.HBox;

import java.io.IOException;

public class GeneralStageRoot {
    private HBox root;
    private ScrollPane stickmanScrollPane;
    private SplitPane mSplitPane;
    private HBox sStickmanPane;
    private  StickmansOnStage stickmansOnStage;

    public GeneralStageRoot(StickmansOnStage stage){
        stickmansOnStage = stage;
    }

    public HBox getRoot() {
        return root;
    }

    public ScrollPane getStickmanScrollPane() {
        return stickmanScrollPane;
    }

    public SplitPane getmSplitPane() {
        return mSplitPane;
    }

    public HBox getsStickmanPane() {
        return sStickmanPane;
    }

    public HBox getConfigRoot() throws IOException {
        invoke();
        if(!root.getChildren().contains(mSplitPane)){
            root.getChildren().add(mSplitPane);
            root.getChildren().add(stickmanScrollPane);
            sStickmanPane.setAlignment(Pos.CENTER_LEFT);
        }
        return root;
    }

    public HBox getStageRoot() throws IOException {
        invoke();
        if(root.getChildren().contains(mSplitPane)){
            root.getChildren().remove(mSplitPane);
            sStickmanPane.setAlignment(Pos.CENTER);
        }
        return root;
    }

    private GeneralStageRoot invoke() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/de/dfki/stickmanfx/StickmanStageView.fxml"));
        root = loader.load();
        stickmanScrollPane = (ScrollPane) root.lookup("#stickmanScrollPane");
        mSplitPane = (SplitPane) root.lookup("#mSplitPane");
        sStickmanPane = new HBox();
        stickmanScrollPane.setContent(sStickmanPane);
        StickmanStageController mStickmanStageController = loader.getController();
        mStickmanStageController.setStickamnOnStage(stickmansOnStage);
        mStickmanStageController.setlePerlinNoiseOn();
        sStickmanPane.prefWidthProperty().bind(root.widthProperty());
        sStickmanPane.setAlignment(Pos.CENTER);
        return this;
    }


}