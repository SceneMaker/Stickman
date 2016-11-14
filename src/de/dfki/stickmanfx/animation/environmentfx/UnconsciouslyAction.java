package de.dfki.stickmanfx.animation.environmentfx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import de.dfki.stickmanfx.StickmanFX;
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
public class UnconsciouslyAction extends Thread 
{
    private StickmanFX mStickmanFX;
    private Timeline timeline;
    private String[] behaviorArray = {"HeadTilt", "CoverMouth", "Nod", "TouchHead",
    								  "HeadLeft", "HeadRight", "Itching", "HeadDown", "HeadDown1"};
    private ArrayList<String> currentBehaviorList;
    
    Random random;
    
    public boolean isBreatheOut = true;

    public UnconsciouslyAction(StickmanFX s) {
    	this.mStickmanFX = s;
    	this.currentBehaviorList = new ArrayList<>();
    	this.currentBehaviorList.addAll(Arrays.asList(behaviorArray));
    	
    	this.random = new Random();
    	startBlinkAktion();
    	startBreathing();
    }

    @Override
    public void run() {
        while (mStickmanFX.mIdleRun) 
        {
        	if(this.currentBehaviorList.isEmpty())
        	{
        		this.currentBehaviorList.addAll(Arrays.asList(behaviorArray));
        	}
        	if(mStickmanFX.mAnimationSchedulerFX.mAnimationQueue.isEmpty())
        	{
        		int index = random.nextInt(currentBehaviorList.size());
            	String action = currentBehaviorList.get(index);
            	currentBehaviorList.remove(index);
            	mStickmanFX.doAnimation(action, 500, true);
        	}
        	try 
        	{
				sleep(10000);
			} 
        	catch (InterruptedException e) 
        	{
				e.printStackTrace();
			}
        }
    }
    
    public void startBlinkAktion()
    {
    	timeline = new Timeline(new KeyFrame(Duration.seconds(5), new EventHandler<ActionEvent>() 
    	{
    	    @Override
    	    public void handle(ActionEvent event) {
    	    	mStickmanFX.doAnimation("Blink", 500, true);
    	    }
    	}));
    	timeline.setCycleCount(Timeline.INDEFINITE);
    	timeline.play();
    }
    
    public void stopBlinkAktion()
    {
    	if(timeline != null)
    		timeline.stop();
    }

    //AtmenAktion
    public void startBreathing()
    {
    	Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(5), new EventHandler<ActionEvent>() 
    	{
    	    @Override
    	    public void handle(ActionEvent event) {
    	    		
    	    	ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(2000), mStickmanFX.mUpperBody.mUpperBodyGroup);
    	        scaleTransition.setToX(1.05f);
    	        scaleTransition.setToZ(1.05f);
    	        scaleTransition.setToY(1.01f);
    	        scaleTransition.setCycleCount(2);
    	        scaleTransition.setAutoReverse(true);
    	        scaleTransition.play();
    	    }
    	}));
    	timeline.setCycleCount(Timeline.INDEFINITE);
    	timeline.play();
    }
}
