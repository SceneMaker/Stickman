package de.dfki.common.animationlogic;

import de.dfki.action.sequence.Entry;
import de.dfki.action.sequence.WordTimeMarkSequence;
import de.dfki.common.agent.Agent;
import de.dfki.common.util.TimingInfo;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

/**
 * Created by EmpaT on 28.07.2017.
 */
public abstract class Animator
{
    public static int sMAX_ANIM_STEPS = 20;
    public static String sCurrentAction;
    public Agent mAgent;
    public int mCurrentStep = sMAX_ANIM_STEPS;
    public Animation mAnimation;
    public ArrayList<AnimationContent> mAnimationComponents = new ArrayList<AnimationContent>();
    public String mDescription = "";
    public WordTimeMarkSequence mWTS;
    public int mRenderPauseDuration = 0;
    public Semaphore mRenderingPause = new Semaphore(0);

    protected void renderEventAnimation()
    {
        for (ArrayList<Entry> cluster : mWTS.getClusters())
        {
            if (WordTimeMarkSequence.getClusterType(cluster) == Entry.TYPE.WORD)
            {
                String text = "";

                for (Entry e : cluster)
                {
                    text += e.mContent + " ";
                }
                text = text.trim();

                String currentlySpokenText = "";
                currentlySpokenText = text.replace("oe", "ö").replace("ae", "ä").replace("ue", "ü").replace("Oe", "Ö").replace("Ae", "Ä").replace("Ue", "Ü").replace("ss", "ß").replace("\n", " ").replace("   ", " ").replace("  ", " ");

                String allText = "";
                allText = mWTS.getText().replace("oe", "ö").replace("ae", "ä").replace("ue", "ü").replace("Oe", "Ö").replace("Ae", "Ä").replace("Ue", "Ü").replace("ss", "ß").replace("\n", " ").replace("   ", " ").replace("  ", " ");

                mAgent.getSpeechBubble().mSpeechBubbleText = allText;
                //mAgent.mSpeechBubble.mCurrentlySpokenText = currentlySpokenText;

                // do the rendering ...
                int duration = TimingInfo.spokenStringDuration(text);

                mRenderPauseDuration = new Float(duration / sMAX_ANIM_STEPS).intValue();
                mRenderPauseDuration = (mRenderPauseDuration < 1) ? 1 : mRenderPauseDuration; // minimum delay is 1 millisecond

                render();
            }

            if (WordTimeMarkSequence.getClusterType(cluster) == Entry.TYPE.TIMEMARK)
            {
                // here we have to spread the word that a specific timemark has been reached
                // the interface is the runActionAtTimemark method in the EventActionPlayer
                for (Entry e : cluster)
                {
                    // we have 2 options!
                    // 1) API Call
                    // 2) send to Player

                    mAgent.getStageRoom().sendTimeMarkInformation(e.mContent);
                }
            }
        }
    }

    protected abstract void render();

    protected class WaitThread extends Thread
    {
        int mSleepTime = 0;

        public WaitThread(int time)
        {
            mSleepTime = time;
        }

        @Override
        public void run()
        {
            // directly go to sleep
            try
            {
                sleep(mSleepTime, 0);
            } catch (InterruptedException ex)
            {
                mAgent.mLogger.severe(ex.getMessage());
            }
            // release sempahore
            mRenderingPause.release();
        }
    }
}
