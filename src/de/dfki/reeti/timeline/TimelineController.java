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
    private SequenceBlock sequenceBlock = null;

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

        addSequenceBlocks(sequence);
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

                    if(timeline.getTranslateX() == sequenceBlock.getTranslateX())
                    {
                        reeti.leftEyeLid(50, 30);
                        reeti.rightEyeLid(50,30);
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

    private SequenceBlock createSequenceBlock(Sequence sequence)
    {
        SequenceBlock sBlock = new SequenceBlock();
        String sequenceName = sequence.getProperty().getName();
        double startTime = sequence.getPoses().getFirst().getStartTime();
        double sequenceDuration = sequence.getProperty().getDuration();

        sBlock.setText(sequenceName);
        sBlock.setTranslateX(Converter.SecondToPixel(startTime));
        sBlock.setMinWidth(Converter.SecondToPixel(sequenceDuration));

        return sBlock;
    }

    private void addSequenceBlocks(Sequence sequence)
    {
        if(sequence.getProperty().isEarsUsed())
        {
            sequenceBlock = createSequenceBlock(sequence);
            animationGridPane.add(sequenceBlock, 0, 0);
        }
        if(sequence.getProperty().isEyesUsed())
        {
            sequenceBlock = createSequenceBlock(sequence);
            animationGridPane.add(sequenceBlock, 0, 1);
        }
        if(sequence.getProperty().isMouthUsed())
        {
            sequenceBlock = createSequenceBlock(sequence);
            animationGridPane.add(sequenceBlock, 0, 2);
        }
        if(sequence.getProperty().isNeckUsed())
        {
            sequenceBlock = createSequenceBlock(sequence);
            animationGridPane.add(sequenceBlock, 0, 3);
        }
        if(sequence.getProperty().isColorUsed())
        {
            sequenceBlock = createSequenceBlock(sequence);
            animationGridPane.add(sequenceBlock, 0, 4);
        }
    }
}
