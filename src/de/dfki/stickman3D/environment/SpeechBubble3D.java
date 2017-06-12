package de.dfki.stickman3D.environment;

import de.dfki.stickman3D.body.BodyPartFX;
import de.dfki.stickman3D.body.Head3D;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

import java.awt.geom.GeneralPath;

/**
 * @author Beka
 */
public class SpeechBubble3D extends BodyPartFX
{

    public enum SHAPE
    {

        DEFAULT, SPEAK, THINK
    }

    public SpeechBubble3D.SHAPE mShape = SpeechBubble3D.SHAPE.DEFAULT;
    public String mText = "";

    private GridPane bubblePane;
    private Label message;

    public SpeechBubble3D(Head3D head)
    {
        mStart = head.getSpeechBubbleStartPosition();
        mColor = Color.rgb(255, 255, 255, (192 * 100 / 255) / 100f);
    }

    @Override
    public void setShape(String s)
    {
        SpeechBubble3D.SHAPE shape = SpeechBubble3D.SHAPE.valueOf(s);
        mShape = (shape != null) ? shape : SpeechBubble3D.SHAPE.DEFAULT;
    }

    @Override
    public void resetShape()
    {
        mShape = SpeechBubble3D.SHAPE.DEFAULT;
    }

    @Override
    public void createShape()
    {

        clearChildren(this);

        bubblePane = new GridPane();
        message = new Label();

        switch (mShape)
        {
            case DEFAULT:
                break;

            case SPEAK:
                message.setMaxWidth(200);
                message.setText(mText);
                message.setWrapText(true);
                message.getStyleClass().add("message-bubble");
                this.bubblePane.addRow(0, message);

                this.getStylesheets().add(getClass().getResource("bubbleCSS.css").toExternalForm());
                this.setLayoutX(mStart.x + 20);
                this.setLayoutY(mStart.y - this.getHeight());
                this.setTranslateZ(-120);

                this.getChildren().add(bubblePane);

                //if message is Empty
                if (this.getHeight() == 0)
                {
                    this.setVisible(false);
                } else
                {
                    this.setVisible(true);
                    this.toFront();
                }

                break;
        }

    }
}
