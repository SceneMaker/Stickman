package de.dfki.stickmanFX.stage;

import de.dfki.common.commonFX3D.StagePaneHandler;
import de.dfki.stickmanFX.StickmanStageController;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.HBox;

import java.io.IOException;

public class StagePaneHandlerStickman2D extends StagePaneHandler
{

    private ScrollPane stickmanScrollPane;
    private SplitPane mSplitPane;
    private HBox sStickmanPane;

    public StagePaneHandlerStickman2D()
    {
        super();
    }

    @Override
    public HBox getConfigRoot() throws IOException
    {
        invoke();
        if (!root.getChildren().contains(mSplitPane))
        {
            root.getChildren().remove(stickmanScrollPane);
            root.getChildren().add(mSplitPane);
            root.getChildren().add(stickmanScrollPane);
        }
        sStickmanPane.setAlignment(Pos.CENTER_LEFT);
        return root;
    }

    @Override
    public HBox getStageRoot() throws IOException
    {
        invoke();
        if (root.getChildren().contains(mSplitPane))
        {
            root.getChildren().remove(mSplitPane);
        }
        sStickmanPane.setAlignment(Pos.CENTER); //CENTER_LEFT
        return root;
    }

    @Override
    protected StagePaneHandler invoke() throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/de/dfki/stickmanFX/StickmanStageView.fxml"));
        root = loader.load();
        root.getWidth();
        stickmanScrollPane = (ScrollPane) root.lookup("#stickmanScrollPane");
        mSplitPane = (SplitPane) root.lookup("#mSplitPane");
        sStickmanPane = new HBox();
        stickmanScrollPane.setContent(sStickmanPane);
        viewController = loader.getController();
        ((StickmanStageController) getViewController()).setlePerlinNoiseOn();
        sStickmanPane.prefWidthProperty().bind(root.widthProperty());
        sStickmanPane.prefHeightProperty().bind(root.heightProperty());
        return this;
    }
}
