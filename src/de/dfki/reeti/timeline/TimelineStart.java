package de.dfki.reeti.timeline;

import de.dfki.reeti.Reeti;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class TimelineStart {

    private Reeti reeti = null;
    private Stage ownerStage = null;

    private static final int TIMELINE_X_POSITION = 0;
    private static final int TIMELINE_Y_POSITION = 600;
    private static final int TIMELINEWIDTH = 1900;
    private static final int TIMELINEHEIGHT = 400;

    public TimelineStart(Reeti reeti)
    {
        this.reeti = reeti;
    }

    public void show() throws Exception{
        Stage timelineStage = new Stage();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("timeline.fxml"));

        TimelineController controller = new TimelineController();
        controller.setReeti(reeti);
        loader.setController(controller);

        Parent root = loader.load();
        timelineStage.setTitle("Reeti Timeline");
        timelineStage.setScene(new Scene(root, TIMELINEWIDTH, TIMELINEHEIGHT));
        timelineStage.setX(TIMELINE_X_POSITION);
        timelineStage.setY(TIMELINE_Y_POSITION);
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
