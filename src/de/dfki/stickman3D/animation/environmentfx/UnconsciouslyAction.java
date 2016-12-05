package de.dfki.stickman3D.animation.environmentfx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import de.dfki.stickman3D.Stickman3D;
import static java.lang.Thread.sleep;
import javafx.animation.KeyFrame;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;

/**
 *
 * @author Beka Aptsiauri
 *
 */
public class UnconsciouslyAction extends Thread {
	private Stickman3D mStickmanFX;
	private Timeline blinkTimeline;
	private Timeline breathTimeline;

	// Behavior Default Array
	private String[] behaviorArray = { "HeadTilt", "CoverMouth", "Nod", "TouchHead", "HeadLeft", "HeadRight", "Itching",
			"HeadDown", "HeadDown1" };
	//
	private ArrayList<String> currentBehaviorList;

	Random random;

	public UnconsciouslyAction(Stickman3D s) {
		this.mStickmanFX = s;
		this.currentBehaviorList = new ArrayList<>();
		ArrayList<String> tmpList;
		this.currentBehaviorList.addAll(Arrays.asList(behaviorArray));

		this.random = new Random();
//		startBlinkAktion();
		startBreathing(5);
	}
        
        public UnconsciouslyAction(Stickman3D s, int breathFrequent) {
		this.mStickmanFX = s;
		this.currentBehaviorList = new ArrayList<>();
		ArrayList<String> tmpList;
		this.currentBehaviorList.addAll(Arrays.asList(behaviorArray));

		this.random = new Random();
//		startBlinkAktion();
		startBreathing(breathFrequent);
	}

	@Override
	public void run() {
//		while (mStickmanFX.mIdleRun) {
//			if (this.currentBehaviorList.isEmpty()) {
//				this.currentBehaviorList.addAll(Arrays.asList(behaviorArray));
//			}
//			if (mStickmanFX.mAnimationSchedulerFX.mAnimationQueue.isEmpty()) {
//				int index = random.nextInt(currentBehaviorList.size());
//				String action = currentBehaviorList.get(index);
//				currentBehaviorList.remove(index);
//				mStickmanFX.doAnimation(action, 500, true);
//			}
//			try {
//				sleep(10000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
	}

//	public void startBlinkAktion() {
//		blinkTimeline = new Timeline(new KeyFrame(Duration.seconds(5), new EventHandler<ActionEvent>() {
//			@Override
//			public void handle(ActionEvent event) {
//				mStickmanFX.doAnimation("Blink", 500, true);
//			}
//		}));
//		blinkTimeline.setCycleCount(Timeline.INDEFINITE);
//		blinkTimeline.play();
//	}

//	public void stopBlinkAktion() {
//		if (blinkTimeline != null)
//			blinkTimeline.stop();
//	}

	// AtmenAktion
	public void startBreathing(int seconds) {
		breathTimeline = new Timeline(new KeyFrame(Duration.seconds(seconds), new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {

				ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(500),
						mStickmanFX.mUpperBody.mUpperBodyGroup);
				scaleTransition.setToX(1.05f);
				scaleTransition.setToZ(1.05f);
				scaleTransition.setToY(1.01f);
				scaleTransition.setCycleCount(2);
				scaleTransition.setAutoReverse(true);
				scaleTransition.play();
			}
		}));
		breathTimeline.setCycleCount(Timeline.INDEFINITE);
		breathTimeline.play();
	}

	public void stopBreathAktion() {
		if (breathTimeline != null)
			breathTimeline.stop();
	}
}
