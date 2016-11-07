package de.dfki.stickmanfx.animation.environmentfx;

import de.dfki.stickmanfx.StickmanFX;
import de.dfki.stickmanfx.animationlogic.AnimationFX;
import javafx.scene.layout.HBox;

/**
 *
 * @author Robbie
 *
 *Set background for StickmanFX
 */
public class SetBackground extends AnimationFX {
    public SetBackground(StickmanFX sm, int duration, boolean block) {
	super(sm, duration, block);
    }

    @Override
    public void playAnimation() {
	
//	mParameter = (Object)"office";
	String sParameter = (String) mParameter;
	
	String mStageIdentifier = mStickmanFX.getStickmanStageController().getStageIdentifier();
	HBox mStickmanPane;
	try {
	    mStickmanPane = mStickmanFX.getStickmanStageController().getStickmanStage()
		    .getStickmanPane(mStageIdentifier);
	    
	    //Upload the picture
	    mStickmanPane.setStyle("-fx-background-image: url('/de/dfki/stickmanfx/image/"+ sParameter + ".jpg');"
	    	+ "-fx-background-repeat: repeat;-fx-background-position: center center; -fx-background-size: contain;");
	
	} catch (Exception e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }
}
