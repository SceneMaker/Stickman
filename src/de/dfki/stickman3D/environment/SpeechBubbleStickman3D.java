package de.dfki.stickman3D.environment;

import de.dfki.common.part.Part3D;
import de.dfki.stickman3D.body.Head3D;
import de.dfki.stickman3D.body.PartStickman3D;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.text.Font;

/**
 * @author Beka
 */
public class SpeechBubbleStickman3D extends PartStickman3D
{

    public SpeechBubbleStickman3D.SHAPE mShape = SpeechBubbleStickman3D.SHAPE.DEFAULT;
    private Head3D mHead;
    Path face;
    private Label message;
    private HBox bubbleBox;

    public SpeechBubbleStickman3D(Part3D head)
    {
        mHead = (Head3D) head;
        mStart = mHead.getSpeechBubbleStartPosition();
        bubbleBox = new HBox();
        bubbleBox.setVisible(false);
        message = new Label();
        face = createLeftFace(Color.rgb(222, 222, 222));
        this.getChildren().add(bubbleBox);
        mHead.getChildren().add(this);
    }

    @Override
    public void setShape(String s)
    {
        SpeechBubbleStickman3D.SHAPE shape = SpeechBubbleStickman3D.SHAPE.valueOf(s);
        mShape = (shape != null) ? shape : SpeechBubbleStickman3D.SHAPE.DEFAULT;
    }

    @Override
    public void resetShape()
    {
        mShape = SpeechBubbleStickman3D.SHAPE.DEFAULT;
    }

    @Override
    public void calculate(int step)
    {

        bubbleBox.setVisible(false);
        message = new Label();


        switch (mShape)
        {
            case DEFAULT:
                break;

            case SPEAK:
                bubbleBox.setAlignment(Pos.TOP_CENTER);
                message.setText(mSpeechBubbleText);
                message.setMaxWidth(200);
                message.setMinHeight(70);
                message.setPadding(new Insets(5, 5, 5, 5));
                message.setWrapText(true);
                createMessageStyle(message);
                this.setTranslateZ(-200);
                this.setTranslateY(mStart.y);
                this.setTranslateX(mStart.x);
                bubbleBox.getChildren().clear();
                bubbleBox.getChildren().addAll(face, message);

                bubbleBox.setVisible(true);
                break;
        }

    }

    private Path createLeftFace(Color color)
    {
        Path p = new Path();
        p.setStroke(Color.GRAY.darker());
        p.setStrokeWidth(2);
        p.getElements().add(new MoveTo(2, 0));
        p.getElements().add(new CubicCurveTo(-10, 15, -50, 10, -90, -5));
        p.getElements().add(new LineTo(2, 50));
        p.setTranslateX(4);
        p.setTranslateZ(-1);
        p.setFill(color);

        return p;
    }

    private void createMessageStyle(Label message)
    {
        message.setStyle("-fx-background-color: #DEDEDE; "
                + "-fx-border-color: #585858;  " +
                "-fx-border-width: 2;"
                + "-fx-border-radius: 10 10 10 10;\n"
                + "-fx-background-radius: 10 10 10 10;");
        message.setFont(new Font("Comic Sans MS", 16));
    }

    public enum SHAPE
    {

        DEFAULT, SPEAK, THINK
    }
}
