package de.dfki.reeti.timeline;

import de.dfki.reeti.Reeti;
import de.dfki.reeti.files.filestystem.FileSystemAble;
import de.dfki.reeti.files.filestystem.rmdl.RMDLFileSystem;
import de.dfki.reeti.files.readers.rmdl.RMDLReader;
import de.dfki.reeti.models.Pose;
import de.dfki.reeti.models.Sequence;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Line;
import javafx.util.Duration;
import org.junit.Assert;

import java.awt.*;
import java.io.File;
import java.net.URL;
import java.util.ListIterator;
import java.util.ResourceBundle;

/*
1 sec = 100px
 */

public class TimelineController implements Initializable {

    @FXML
    private AnchorPane root;

    @FXML
    private ComboBox<?> animationCombo;

    @FXML
    private Button playButton;

    @FXML
    private ScrollPane animationScrollPane;

    @FXML
    private GridPane animationGridPane;

    @FXML
    private Line timeline;

    private boolean isAutomaticScrollStarted = false;
    private boolean isPlayed = false;

    private int timelinePos = 0;

    private Animation autoScrollAnimation;

    private Reeti reeti;
    private SequenceBlock s = null;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        File file = new File("C:\\Users\\EmpaT\\Desktop\\reeti\\ReertiParser\\reeti files\\goodBye.rmdl");
        FileSystemAble fileSystem = new RMDLFileSystem(file.getAbsolutePath());
        RMDLReader reader = new RMDLReader(fileSystem);
        reader.open();
        reader.read();
        Sequence sequence = ((RMDLReader)reader).getSequence();

        Assert.assertNotNull(sequence.getProperty());
        ListIterator<Pose> iterator = (ListIterator<Pose>) sequence.getPoses().iterator();
//        while (iterator.hasNext())
//        {
//            System.out.println(iterator.next().);
//        }

        double startTime = iterator.next().getStartTime();


        s = new SequenceBlock();
        s.setId("1");
        String sequenceName = sequence.getProperty().getName();
        double sequenceDuration = sequence.getProperty().getDuration();
        s.setText(sequenceName);
        s.setTranslateX(Converter.SecondToPixel(startTime));
        s.setMinWidth(Converter.SecondToPixel(sequenceDuration));

        SequenceBlock s1 = (SequenceBlock) s.clone();
        SequenceBlock s2 = (SequenceBlock) s.clone();
        SequenceBlock s3 = (SequenceBlock) s.clone();
        SequenceBlock s4 = (SequenceBlock) s.clone();

        animationGridPane.add(s, 0, 0);
        animationGridPane.add(s1, 0, 1);
        animationGridPane.add(s2, 0, 2);
        animationGridPane.add(s3, 0, 3);
        animationGridPane.add(s4, 0, 4);
        playButton.setOnMouseClicked(event ->
        {
            isPlayed = !isPlayed;
            startTimeline();
        });
    }

    synchronized public void startTimeline() {
        Task<Void> task = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                //############AUTOSCROLL PLAY/PAUSE BLOCK####################
                if(!isPlayed)
                    autoScrollAnimation.pause();
                else if(isPlayed && autoScrollAnimation != null)
                    autoScrollAnimation.play();
                //############END AUTOSCROLL PLAY/PAUSE BLOCK################

                while (timelinePos <= 5980 && isPlayed) {

                    if(timeline.getTranslateX() == s.getTranslateX())
                    {
                        reeti.leftEyeLid(50, 30);
                    }

                    int c = timelinePos;
                    if (c >= 700 && !isAutomaticScrollStarted) {
                        isAutomaticScrollStarted = true;
                        startAutoScroll();
                    }
                    Platform.runLater(() -> timeline.setTranslateX(c));

                    timelinePos++;
                    Thread.sleep(10);
                }
                return null;
            }
        };

        Thread th = new Thread(task);
        th.start();
    }

    private void startAutoScroll()
    {
        autoScrollAnimation = new Timeline(
                new KeyFrame(Duration.seconds(10000),
                        new KeyValue(animationScrollPane.hvalueProperty(), 230)));
        autoScrollAnimation.play();
    }

    public Reeti getReeti() {
        return reeti;
    }

    public void setReeti(Reeti reeti) {
        this.reeti = reeti;
    }
}
