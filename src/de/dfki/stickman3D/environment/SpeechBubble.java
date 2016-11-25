package de.dfki.stickman3D.environment;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import java.awt.geom.GeneralPath;
import de.dfki.stickman3D.body.BodyPart;
import de.dfki.stickman3D.body.Head;

/**
 *
 * @author Beka
 *
 */
public class SpeechBubble extends BodyPart {

	public static enum SHAPE {

		DEFAULT, SPEAK, THINK
	};

	Head mHeadFX;
	public SpeechBubble.SHAPE mShape = SpeechBubble.SHAPE.DEFAULT;
	public String mText = "";

	GridPane bubblePane;
	Label message;

	GeneralPath mBubble;

	public SpeechBubble(Head head) {
		mHeadFX = head;
		mColor = Color.rgb(255, 255, 255, (192 * 100 / 255) / 100f);
	}

	@Override
	public void setShape(String s) {
		SpeechBubble.SHAPE shape = SpeechBubble.SHAPE.valueOf(s);
		mShape = (shape != null) ? shape : SpeechBubble.SHAPE.DEFAULT;
	}

	@Override
	public void resetShape() {
		mShape = SpeechBubble.SHAPE.DEFAULT;
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
			this.setTranslateZ(-120);

			this.getChildren().add(bubblePane);

			// if message is Empty
			if (this.getHeight() == 0)
				this.setVisible(false);
			else {
				this.setVisible(true);
				this.toFront();
			}

			break;
		}

	}
}
