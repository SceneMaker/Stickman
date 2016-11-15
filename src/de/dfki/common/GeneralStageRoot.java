package de.dfki.common;

import de.dfki.stickmanfx.StickmanStageController;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

import java.io.IOException;

public class GeneralStageRoot {
    private HBox root;
    private ScrollPane stickmanScrollPane;
    private SplitPane mSplitPane;
    private HBox sStickmanPane;
    private StickmanStageController mStickmanStageController;

    public HBox getConfigRoot() throws IOException {
        invoke();
        if(!root.getChildren().contains(mSplitPane)){
            root.getChildren().remove(stickmanScrollPane);
            root.getChildren().add(mSplitPane);
            root.getChildren().add(stickmanScrollPane);       
        }
        sStickmanPane.setAlignment(Pos.CENTER_LEFT);
        return root;
    }

    public HBox getStageRoot() throws IOException {
        invoke();
        if(root.getChildren().contains(mSplitPane)){
            root.getChildren().remove(mSplitPane);       
        }      
        sStickmanPane.setAlignment(Pos.CENTER); //CENTER_LEFT
        return root;
    }

    private GeneralStageRoot invoke() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/de/dfki/stickmanfx/StickmanStageView.fxml"));
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
//        sStickmanPane.setAlignment(Pos.CENTER_LEFT);
//        sStickmanPane.setStyle("-fx-background-color: #7FFFD4;");
//            sStickmanPane.setStyle("-fx-background-image: url('/de/dfki/stickmanfx/image/office4.jpg');-fx-background-repeat: repeat;-fx-background-position: center center; -fx-background-size: contain;");
        return this;
    }

    public StickmanStageController getmStickmanStageController() {
        return mStickmanStageController;
    }

    public void setStickmansOnStage(CommonStickmansOnStage stickmans){
        mStickmanStageController.setStickamnOnStage(stickmans);
    }


}