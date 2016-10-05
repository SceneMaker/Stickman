package de.dfki.stickmanfx.animation.environmentfx;

import java.awt.Dimension;
import java.util.ArrayList;

import de.dfki.stickmanfx.StickmanFX;
import de.dfki.stickmanfx.animationlogic.AnimationContentFX;
import de.dfki.stickmanfx.animationlogic.AnimationFX;
import javafx.application.Platform;
import javafx.scene.layout.HBox;

/**
 *
 * @author Robbie
 *
 */
public class ZoomOut extends AnimationFX 
{
	public ZoomOut(StickmanFX sm, int duration, boolean block) 
	{
		super(sm, duration, block);
	}

	@Override
	public void playAnimation() {
		// make Stickman to become original size
		mStickmanFX.mScale = mStickmanFX.mScaleOriginal;
//		Dimension size = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
//		int mWidth = size.width;
//		int mHeight = size.height;
//		mStickmanFX.mSize = new Dimension(new Float(mHeight * 3 / 5 ).intValue(), new Float(mHeight * 0.9f).intValue());
		
		String mStageIdentifier = mStickmanFX.getStickmanStageController().getStageIdentifier();
		HBox mStickmanPane;
		
			try
			{
				mStickmanPane = mStickmanFX.getStickmanStageController().getStickmanStage().getStickmanPane(mStageIdentifier);
//				Platform.runLater(() ->mStickmanPane.getChildren().clear());
				
					Platform.runLater(() ->
					
					{
					
					try
					{
					mStickmanFX.getStickmanStageController().getStickmanStage().addStickmanToStage(mStageIdentifier);
					
					} catch (Exception e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
							
					}
					);
				
				
				
			} catch (Exception e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		Platform.runLater(() -> mStickmanFX.update());
	}
}