package de.dfki.reeti.timeline;

import de.dfki.reeti.Reeti;
import de.dfki.reeti.files.filestystem.FileSystemAble;
import de.dfki.reeti.files.filestystem.rmdl.RMDLFileSystem;
import de.dfki.reeti.files.readers.rmdl.RMDLReader;
import de.dfki.reeti.models.Movement;
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

import java.io.File;
import java.net.URL;
import java.util.ListIterator;
import java.util.ResourceBundle;

/*
1 sec = 100px
 */

public class TimelineController implements Initializable
{

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
    private boolean playButtonON = false;

    private int timelinePos = 0;

    private Animation autoScrollAnimation = null;

    private Reeti reeti = null;
    private SequenceBlock sequenceBlock = null;

    private static final int TIMELINEWIDTH = 5980;
    private static final int AUTOSCROLL_START_POS = 700;



    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        File file = new File("C:\\Users\\EmpaT\\Desktop\\reeti\\ReertiParser\\reeti files\\Arrogant.rmdl");
        FileSystemAble fileSystem = new RMDLFileSystem(file.getAbsolutePath());
        RMDLReader reader = new RMDLReader(fileSystem);
        reader.open();
        reader.read();
        Sequence sequence = reader.getSequence();

        Assert.assertNotNull(sequence.getProperty());

        addSequenceBlocks(sequence);

        ListIterator<Pose> iterator = (ListIterator<Pose>) sequence.getPoses().iterator();
        while (iterator.hasNext())
            sequenceBlock.poseList.add(iterator.next());

        playButton.setOnMouseClicked(event ->
        {
            playButtonON = !playButtonON;
            startTimeline();
        });
    }

    synchronized private void startTimeline()
    {
        Task<Void> task = new Task<Void>()
        {
            @Override
            protected Void call() throws Exception
            {
                //############AUTOSCROLL PLAY/PAUSE BLOCK####################
                if (!playButtonON)
                    autoScrollAnimation.pause();
                else if (autoScrollAnimation != null)
                    autoScrollAnimation.play();
                //############END AUTOSCROLL PLAY/PAUSE BLOCK################

                while (timelinePos <= TIMELINEWIDTH && playButtonON)
                {
                    for(Pose pose : sequenceBlock.poseList)
                    {

                        if(timeline.getTranslateX() == Converter.SecondToPixel(pose.getStartTime()))
                        {
//                            System.out.println();
                            Movement motorMovement = pose.getMotorsMovement();
                            reeti.rightEar((int)motorMovement.getRightEar(), pose.getDuration().getTimeToReachPose());
                            reeti.leftEar((int)motorMovement.getLeftEar(), pose.getDuration().getTimeToReachPose());
                            reeti.rightEyeLid((int)motorMovement.getRightEyeLid(), pose.getDuration().getTimeToReachPose());
                            reeti.leftEyeLid((int)motorMovement.getLeftEyeLid(), pose.getDuration().getTimeToReachPose());
                            reeti.rightEyeTilt((int)motorMovement.getRightEyeTilt(), pose.getDuration().getTimeToReachPose());
                            reeti.leftEyeTilt((int)motorMovement.getLeftEyeTilt(), pose.getDuration().getTimeToReachPose());
                            reeti.rightEyePan((int)motorMovement.getRightEyePan(), pose.getDuration().getTimeToReachPose());
                            reeti.leftEyePan((int)motorMovement.getLeftEyePan(), pose.getDuration().getTimeToReachPose());
                            reeti.neckPan((int)motorMovement.getNeckPan(), pose.getDuration().getTimeToReachPose());
                            reeti.neckRotat((int)motorMovement.getNeckRotat(), pose.getDuration().getTimeToReachPose());
                            reeti.neckTilt((int)motorMovement.getNeckTilt(), pose.getDuration().getTimeToReachPose());
                            reeti.setLedColor(motorMovement.getColor());
                            reeti.leftLC((int)motorMovement.getLeftLC(), pose.getDuration().getTimeToReachPose());
                            reeti.rightLC((int)motorMovement.getRightLC(), pose.getDuration().getTimeToReachPose());
                            reeti.topLip((int)motorMovement.getTopLip(), pose.getDuration().getTimeToReachPose());
                            reeti.bottomLip((int)motorMovement.getBottomLip(), pose.getDuration().getTimeToReachPose());

//                            if(motorMovement.getLeftEar() != -1)
//                            {
//                                System.out.println((int)motorMovement.getLeftEar());
//
//                                reeti.rightEyeLid(50, 30);
//                                reeti.rightEar(0, 30);
//                                reeti.leftEar((int)motorMovement.getLeftEar(), pose.getDuration().getTimeToReachPose() * 1000);
//                            }



                        }
                    }
//                    if (timeline.getTranslateX() == sequenceBlock.getTranslateX())
//                    {
//                        reeti.leftEyeLid(50, 30);
//                        reeti.rightEyeLid(50, 30);
//                    }

                    int c = timelinePos;
                    if (c >= AUTOSCROLL_START_POS && !isAutomaticScrollStarted)
                    {
                        isAutomaticScrollStarted = true;
                        startAutoScroll();
                    }
                    timeline.setTranslateX(c);

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

    public Reeti getReeti()
    {
        return reeti;
    }

    public void setReeti(Reeti reeti)
    {
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
        if (sequence.getProperty().isEarsUsed())
        {
            sequenceBlock = createSequenceBlock(sequence);
            animationGridPane.add(sequenceBlock, 0, 0);
        }
        if (sequence.getProperty().isEyesUsed())
        {
            sequenceBlock = createSequenceBlock(sequence);
            animationGridPane.add(sequenceBlock, 0, 1);
        }
        if (sequence.getProperty().isMouthUsed())
        {
            sequenceBlock = createSequenceBlock(sequence);
            animationGridPane.add(sequenceBlock, 0, 2);
        }
        if (sequence.getProperty().isNeckUsed())
        {
            sequenceBlock = createSequenceBlock(sequence);
            animationGridPane.add(sequenceBlock, 0, 3);
        }
        if (sequence.getProperty().isColorUsed())
        {
            sequenceBlock = createSequenceBlock(sequence);
            animationGridPane.add(sequenceBlock, 0, 4);
        }
    }
}
