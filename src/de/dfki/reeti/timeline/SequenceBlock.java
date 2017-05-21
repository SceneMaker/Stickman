package de.dfki.reeti.timeline;


import de.dfki.reeti.models.Pose;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.text.TextAlignment;

import java.util.ArrayList;

/**
 * Created by EmpaT on 20.04.2017.
 */
public class SequenceBlock extends Label implements Cloneable{

    private double startTime = -1;
    private double duration = -1;
    private double startPosition = -1;
    private double endPosition = -1;

    private static final int HEIGHT = 35;

    protected ArrayList<Pose> poseList = null;

    public SequenceBlock()
    {
        super();
        this.setStyle("-fx-background-color: #07CAFA");
        this.setTextAlignment(TextAlignment.LEFT);
        this.setMinHeight(HEIGHT);
        this.setMaxHeight(HEIGHT);
        this.setPadding(new Insets(0, 0, 0, 10));
        this.poseList = new ArrayList<>();
    }

    public double getStartTime() {
        return startTime;
    }

    public void setStartTime(double startTime) {
        this.startTime = startTime;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public double getStartPosition() {
        return startPosition;
    }

    public void setStartPosition(double startPosition) {
        this.startPosition = startPosition;
    }

    public double getEndPosition() {
        return endPosition;
    }

    public void setEndPosition(double endPosition) {
        this.endPosition = endPosition;
    }

    @Override
    public Object clone(){
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
