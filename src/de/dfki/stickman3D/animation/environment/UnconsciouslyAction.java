package de.dfki.stickman3D.animation.environment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import de.dfki.stickman3D.Stickman3D;
import static java.lang.Thread.sleep;
import javafx.animation.Timeline;

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
    private String[] behaviorArray = {"HeadTilt", "CoverMouth", "Nod", "TouchHead", "HeadLeft", "HeadRight", "Itching",
        "TiltDownStart", "HeadDown1"};
    //
    private ArrayList<String> currentBehaviorList;

    Random random;

    public UnconsciouslyAction(Stickman3D s) {
        this.mStickmanFX = s;
        this.currentBehaviorList = new ArrayList<>();
        this.currentBehaviorList.addAll(Arrays.asList(behaviorArray));

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
                System.out.println(action);
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
