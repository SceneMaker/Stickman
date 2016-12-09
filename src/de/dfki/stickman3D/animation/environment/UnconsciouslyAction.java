package de.dfki.stickman3D.animation.environment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import de.dfki.stickman3D.Stickman3D;
import de.dfki.util.XMLParser;
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
	
	private ArrayList<String> currentBehaviorList;

	Random random;

	public UnconsciouslyAction(Stickman3D s) {
		this.mStickmanFX = s;
		this.currentBehaviorList = new ArrayList<>();
		ArrayList<String> tmpList;
		// parse config.xml
		tmpList = XMLParser.getBehaviorList(mStickmanFX.mName);
		// Wenn config file leer ist, benutze default BehaviorArray
		if (tmpList == null)
			this.currentBehaviorList.addAll(Arrays.asList(behaviorArray));
		else {
			int length = tmpList.size();
			behaviorArray = new String[length];
			behaviorArray = tmpList.toArray(behaviorArray);
		}

		this.random = new Random();
	}

	@Override
	public void run() {
		while (mStickmanFX.mIdleRun) {
			if (this.currentBehaviorList.isEmpty()) {
				this.currentBehaviorList.addAll(Arrays.asList(behaviorArray));
			}
			if (mStickmanFX.mAnimationSchedulerFX.mAnimationQueue.isEmpty()) {
				int index = random.nextInt(currentBehaviorList.size());
				String action = currentBehaviorList.get(index);
				currentBehaviorList.remove(index);
				mStickmanFX.doAnimation(action, 500, true);
			}
			try {
				sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
