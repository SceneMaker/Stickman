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
 *1 sec = 100px
 */

public class TimelineController implements Initializable
{

    @FXML
    private AnchorPane root;

    @FXML
    private ComboBox<String> animationCombo;

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
    private Sequence sequence = null;
    private SequenceBlock sequenceBlock = null;

    private static final int TIMELINEWIDTH = 5980;
    private static final int AUTOSCROLL_START_POS = 700;
    private static int sOffset = 0;



    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        File rmdlFolder = new File("rmdl_files");
        File[] listOfRmdlFiles = rmdlFolder.listFiles();
        final File[] selectedFile = {null};
        for(int i = 0; i < listOfRmdlFiles.length; i++)
        {
            animationCombo.getItems().add(listOfRmdlFiles[i].getName());
        }

        animationCombo.setOnAction(event ->
        {
            int index = animationCombo.getSelectionModel().getSelectedIndex();
            selectedFile[0] = new File(listOfRmdlFiles[index].getAbsolutePath());

            FileSystemAble fileSystem = new RMDLFileSystem(selectedFile[0].getAbsolutePath());
            RMDLReader reader = new RMDLReader(fileSystem);
            reader.open();
            reader.read();
            sequence = reader.getSequence();
            Assert.assertNotNull(sequence.getProperty());

            animationGridPane.getChildren().clear();

            if(sequence.getPoses().getFirst().getStartTime() < 2)
                sOffset = 2;
            else
                sOffset = 0;
            addSequenceBlocks(sequence);

            ListIterator<Pose> iterator = (ListIterator<Pose>) sequence.getPoses().iterator();
            while (iterator.hasNext())
                sequenceBlock.poseList.add(iterator.next());
        });



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
                if (!playButtonON && autoScrollAnimation != null)
                    autoScrollAnimation.pause();
                else if (autoScrollAnimation != null)
                    autoScrollAnimation.play();
                //############END AUTOSCROLL PLAY/PAUSE BLOCK################

                while (timelinePos <= TIMELINEWIDTH && playButtonON)
                {
                    for(Pose pose : sequenceBlock.poseList)
                    {

                        if(timeline.getTranslateX() == Converter.SecondToPixel(pose.getStartTime() + sOffset))
                        {
                            startMotors(pose);
                        }

                        //Back to neutral
                        if(timeline.getTranslateX()
                                == Converter.SecondToPixel(pose.getStartTime() + pose.getDuration().getTimeToReachPose())
                                && pose.isBackToNeutralOn())
                        {
                            reeti.defaultPose();
                        }

                        //stop and reset timeline and autoscroll
                        if(timeline.getTranslateX() >= Converter.SecondToPixel(sequence.getProperty().getDuration() + 2))
                        {
                            timeline.setTranslateX(0);
                            timelinePos = 0;
                            playButtonON = false;
                            autoScrollAnimation.stop();
                            autoScrollAnimation = null;
                            animationScrollPane.setHvalue(0.0);
                            isAutomaticScrollStarted = false;
                        }
                        else
                        {
                            if (timelinePos >= AUTOSCROLL_START_POS && !isAutomaticScrollStarted)
                            {
                                isAutomaticScrollStarted = true;
                                startAutoScroll();
                            }
                            timeline.setTranslateX(timelinePos);

                            timelinePos++;
                            Thread.sleep(10);
                        }
                    }
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
        sBlock.setTranslateX(Converter.SecondToPixel(startTime + sOffset));
        sBlock.setMinWidth(Converter.SecondToPixel(sequenceDuration + sOffset));

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

    private void startMotors(Pose pose)
    {
        Movement motorMovement = pose.getMotorsMovement();
        reeti.rightEar((int)motorMovement.getRightEar(), pose.getDuration().getTimeToReachPose() + sOffset);
        reeti.leftEar((int)motorMovement.getLeftEar(), pose.getDuration().getTimeToReachPose() + sOffset);
        reeti.rightEyeLid((int)motorMovement.getRightEyeLid(), pose.getDuration().getTimeToReachPose() + sOffset);
        reeti.leftEyeLid((int)motorMovement.getLeftEyeLid(), pose.getDuration().getTimeToReachPose() + sOffset);
        reeti.rightEyeTilt((int)motorMovement.getRightEyeTilt(), pose.getDuration().getTimeToReachPose() + sOffset);
        reeti.leftEyeTilt((int)motorMovement.getLeftEyeTilt(), pose.getDuration().getTimeToReachPose() + sOffset);
        reeti.rightEyePan((int)motorMovement.getRightEyePan(), pose.getDuration().getTimeToReachPose() + sOffset);
        reeti.leftEyePan((int)motorMovement.getLeftEyePan(), pose.getDuration().getTimeToReachPose() + sOffset);
        reeti.neckPan((int)motorMovement.getNeckPan(), pose.getDuration().getTimeToReachPose() + sOffset);
        reeti.neckRotat((int)motorMovement.getNeckRotat(), pose.getDuration().getTimeToReachPose() + sOffset);
        reeti.neckTilt((int)motorMovement.getNeckTilt(), pose.getDuration().getTimeToReachPose() + sOffset);
        reeti.setLedColor(motorMovement.getColor());
        reeti.leftLC((int)motorMovement.getLeftLC(), pose.getDuration().getTimeToReachPose() + sOffset);
        reeti.rightLC((int)motorMovement.getRightLC(), pose.getDuration().getTimeToReachPose() + sOffset);
        reeti.topLip((int)motorMovement.getTopLip(), pose.getDuration().getTimeToReachPose() + sOffset);
        reeti.bottomLip((int)motorMovement.getBottomLip(), pose.getDuration().getTimeToReachPose() + sOffset);
    }
}
