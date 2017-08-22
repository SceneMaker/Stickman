package de.dfki.reeti.environment;

import de.dfki.common.part.Part3D;
import de.dfki.reeti.body.Head;
import de.dfki.reeti.body.PartReeti;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.text.Font;

import java.awt.geom.GeneralPath;

/**
 * @author Beka
 */
public class SpeechBubbleReeti extends PartReeti
{

    public SpeechBubbleReeti.SHAPE mShape = SpeechBubbleReeti.SHAPE.DEFAULT;
    private Head mHeadFX;
    private Label message;
    private HBox bubbleBox;

    public SpeechBubbleReeti(Part3D head)
    {
        mHeadFX = (Head) head;
    }

    @Override
    public void setShape(String s)
    {
        SpeechBubbleReeti.SHAPE shape = SpeechBubbleReeti.SHAPE.valueOf(s);
        mShape = (shape != null) ? shape : SpeechBubbleReeti.SHAPE.DEFAULT;
    }

    @Override
    public void resetShape()
    {
        mShape = SpeechBubbleReeti.SHAPE.DEFAULT;
    }

    @Override
    public void calculate(int step)
    {
        this.getChildren().clear();

        message = new Label();
        Path face;

        switch (mShape)
        {
            case DEFAULT:
                break;

            case SPEAK:
                bubbleBox = new HBox();
                bubbleBox.setAlignment(Pos.TOP_CENTER);
                face = createLeftFace(Color.rgb(222, 222, 222));
                message.setText(mSpeechBubbleText);
                message.setMaxWidth(200);
                message.setMinHeight(70);
                message.setPadding(new Insets(5, 5, 5, 5));
                message.setWrapText(true);
                createMessageStyle(message);
                bubbleBox.getChildren().addAll(face, message);
                bubbleBox.setTranslateZ(-200);
                bubbleBox.setTranslateY(-150);
                bubbleBox.setTranslateX(150);

                this.getChildren().add(bubbleBox);
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

    public static enum SHAPE
    {

        DEFAULT, SPEAK, THINK
    }
}
