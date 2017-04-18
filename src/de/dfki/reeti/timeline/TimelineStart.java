package de.dfki.reeti.timeline;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TimelineStart {

    private Stage timelineStage;


    public void start() throws Exception{
        this.timelineStage = new Stage();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("timeline.fxml"));

        TimelineController controller = new TimelineController();
        loader.setController(controller);

        Parent root = loader.load();
        timelineStage.setTitle("Reeti Timeline");
        timelineStage.setScene(new Scene(root, 300, 275));
        timelineStage.show();
    }

}
