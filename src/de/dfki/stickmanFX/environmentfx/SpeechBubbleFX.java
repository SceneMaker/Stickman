package de.dfki.stickmanFX.environmentfx;

import de.dfki.stickmanFX.bodyfx.BodyPartFX;
import de.dfki.stickmanFX.bodyfx.HeadFX;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

import java.awt.geom.GeneralPath;

/**
 *
 * @author Beka
 *
 */
public class SpeechBubbleFX extends BodyPartFX {

    public static enum SHAPE {

        DEFAULT, SPEAK, THINK
    };

    HeadFX mHeadFX;
    public SpeechBubbleFX.SHAPE mShape = SpeechBubbleFX.SHAPE.DEFAULT;
    public String mText = "";

    GridPane bubblePane;
    Label message;

    GeneralPath mBubble;

    public SpeechBubbleFX(HeadFX head) {
        mHeadFX = head;
        mColor = Color.rgb(255, 255, 255, (192 * 100 / 255) / 100f);
    }

    @Override
    public void setShape(String s) {
        SpeechBubbleFX.SHAPE shape = SpeechBubbleFX.SHAPE.valueOf(s);
        mShape = (shape != null) ? shape : SpeechBubbleFX.SHAPE.DEFAULT;
    }

    @Override
    public void resetShape() {
        mShape = SpeechBubbleFX.SHAPE.DEFAULT;
    }

    @Override
    public void createShape() {
        mStart = mHeadFX.getSpeechBubbleStartPosition();

        clearChildren(this);

        bubblePane = new GridPane();
        message = new Label();

        switch (mShape) {
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

                this.getChildren().add(bubblePane);

                //if message is Empty
                if (this.getHeight() == 0) {
                    this.setVisible(false);
                } else {
                    this.setVisible(true);
                    this.toFront();
                }

                break;
        }

    }
}
