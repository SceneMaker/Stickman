package de.dfki.stickmanFX.environmentfx;

import de.dfki.common.part.Part2D;
import de.dfki.stickmanFX.bodyfx.HeadFX;
import de.dfki.stickmanFX.bodyfx.PartStickman2D;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

import java.awt.geom.GeneralPath;

/**
 * @author Beka
 */
public class SpeechBubbleStickman2D extends PartStickman2D
{

    public SpeechBubbleStickman2D.SHAPE mShape = SpeechBubbleStickman2D.SHAPE.DEFAULT;

    ;
    HeadFX mHeadFX;
    GridPane bubblePane;
    Label message;
    GeneralPath mBubble;

    public SpeechBubbleStickman2D(Part2D head)
    {
        mHeadFX = (HeadFX) head;
        mColor = Color.rgb(255, 255, 255, (192 * 100 / 255) / 100f);
    }

    @Override
    public void setShape(String s)
    {
        SpeechBubbleStickman2D.SHAPE shape = SpeechBubbleStickman2D.SHAPE.valueOf(s);
        mShape = (shape != null) ? shape : SpeechBubbleStickman2D.SHAPE.DEFAULT;
    }

    @Override
    public void resetShape()
    {
        mShape = SpeechBubbleStickman2D.SHAPE.DEFAULT;
    }

    @Override
    public void calculate(int step)
    {
        mStart = mHeadFX.getSpeechBubbleStartPosition();

        this.getChildren().clear();
        ;

        bubblePane = new GridPane();
        message = new Label();

        switch (mShape)
        {
            case DEFAULT:
                break;

            case SPEAK:
                message.setMaxWidth(200);
                message.setText(mSpeechBubbleText);
                message.setWrapText(true);
                message.getStyleClass().add("message-bubble");
                this.bubblePane.addRow(0, message);

                this.getStylesheets().add(getClass().getResource("bubbleCSS.css").toExternalForm());
                this.setLayoutX(mStart.x + 20);
                this.setLayoutY(mStart.y - this.getHeight());

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

    public static enum SHAPE
    {

        DEFAULT, SPEAK, THINK
    }
}
