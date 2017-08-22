package de.dfki.stickman3D.stage;

import de.dfki.common.commonFX3D.StagePaneHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

import java.io.IOException;

/**
 * Created by alvaro on 11/10/16.
 */
public class StagePaneHandlerStickman3D extends StagePaneHandler
{

    public StagePaneHandlerStickman3D()
    {
        super();
    }

    @Override
    public HBox getConfigRoot() throws IOException
    {
        if (viewController == null)
            invoke();

        return root;
    }

    @Override
    public HBox getStageRoot() throws IOException
    {
        if (viewController == null)
            invoke();
        AnchorPane controlPanel = (AnchorPane) root.lookup("#controlPanel");
        if (controlPanel != null)
        {
            root.getChildren().remove(controlPanel);
        }
        return root;
    }

    @Override
    protected StagePaneHandler invoke() throws IOException
    {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/de/dfki/stickman3D/View.fxml"));
        root = loader.load();
        viewController = loader.getController();
        return this;

    }
}
