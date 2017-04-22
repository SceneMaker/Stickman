package de.dfki.reeti.timeline;

import de.dfki.reeti.Reeti;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class TimelineStart {

    private Stage timelineStage = null;
    private Reeti reeti = null;
    private Stage ownerStage;

    public TimelineStart()
    {

    }

    public TimelineStart(Reeti reeti)
    {
        this.reeti = reeti;
    }

    public void start() throws Exception{
        this.timelineStage = new Stage();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("timeline.fxml"));

        TimelineController controller = new TimelineController();
        controller.setReeti(reeti);
        loader.setController(controller);

        Parent root = loader.load();
        timelineStage.setTitle("Reeti Timeline");
        timelineStage.setScene(new Scene(root, 1900, 400));
        timelineStage.setX(0);
        timelineStage.setY(600);
        timelineStage.initModality(Modality.APPLICATION_MODAL);
        timelineStage.initOwner(ownerStage);
        timelineStage.setResizable(false);
        timelineStage.show();
    }

    public Reeti getReeti() {
        return reeti;
    }

    public void setReeti(Reeti reeti) {
        this.reeti = reeti;
    }

    public void setOwnerStage(Stage ownerStage) {
        this.ownerStage = ownerStage;
    }
}
