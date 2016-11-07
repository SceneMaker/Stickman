package de.dfki.stickmanfx.animation.environmentfx;

import de.dfki.stickmanfx.StickmanFX;
import de.dfki.stickmanfx.animationlogic.AnimationFX;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

/**
 *
 * @author Robbie
 *
 */
public class ZoomIn extends AnimationFX {
    public ZoomIn(StickmanFX sm, int duration, boolean block) {
	super(sm, duration, block);
    }

    @Override
    public void playAnimation() {
	// make Stickman to become 4 times big. Focus on Stickman's face.
	mStickmanFX.mScale = 4f;
	String mStageIdentifier = mStickmanFX.getStickmanStageController().getStageIdentifier();
	HBox mStickmanPane;
	try {
	    mStickmanPane = mStickmanFX.getStickmanStageController().getStickmanStage()
		    .getStickmanPane(mStageIdentifier);
	    Platform.runLater(() ->mStickmanPane.getChildren().clear());
	    Platform.runLater(() -> {
		try {
		    mStickmanFX.getStickmanStageController().getStickmanStage().addStickmanToStage(mStageIdentifier,
			    mStickmanFX);
		    mStickmanPane.setAlignment(Pos.CENTER);
		} catch (Exception e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		}

	    });

	} catch (Exception e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

	Platform.runLater(() -> mStickmanFX.update());
    }
}