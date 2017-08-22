package de.dfki.common.animationlogic;

import de.dfki.action.sequence.WordTimeMarkSequence;
import de.dfki.common.agent.Agent;
import de.dfki.common.part.Part;
import de.dfki.util.observers.AnimationObserver;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by EmpaT on 31.07.2017.
 */
public abstract class Animator2D extends Animator
{
    protected static LinkedList<AnimationObserver> observers = new LinkedList<>();

    public Animator2D(Agent agent, Animation animation, ArrayList<AnimationContent> animComps)
    {
        mAgent = agent;
        mAnimation = animation;
        mAnimationComponents = animComps;
        mDescription = mAnimation.getClass().getSimpleName() + " (" + mAnimation.getID() + "), " + mAnimation.toString();
        mRenderPauseDuration = 40; // 40 milliseconds equals 25fps - resulting that by default an animation takes 500ms

        render();
    }

    public Animator2D(Agent agent, Animation animation, ArrayList<AnimationContent> animComps, int duration)
    {
        mAgent = agent;
        mAnimation = animation;
        mAnimationComponents = animComps;
        mDescription = mAnimation.getClass().getSimpleName() + " (" + mAnimation.getID() + "), " + mAnimation.toString();

        mRenderPauseDuration = new Float(duration / sMAX_ANIM_STEPS).intValue();
        mRenderPauseDuration = (mRenderPauseDuration < 1) ? 1 : mRenderPauseDuration; // minimum delay is 1 millisecond
        render();
    }

    public Animator2D(Agent agent, Animation animation, ArrayList<AnimationContent> animComps, WordTimeMarkSequence wts)
    {
        mAgent = agent;
        mAnimation = animation;
        mAnimationComponents = animComps;
        mWTS = wts;
        mDescription = mAnimation.getClass().getSimpleName() + " (" + mAnimation.getID() + "), " + mAnimation.toString();

        renderEventAnimation();
    }

    public static void register(AnimationObserver obj)
    {
        observers.add(obj);
    }

    public static void unregister(AnimationObserver obj)
    {
        observers.remove(obj);
    }

    public static void notifyAllObservers(Object obj)
    {
        for (AnimationObserver observer : observers)
        {
            observer.update(obj);
        }
    }

    @Override
    protected void render()
    {
        mCurrentStep = sMAX_ANIM_STEPS;
        while (mCurrentStep > 0)
        {
            if (mCurrentStep == sMAX_ANIM_STEPS)
            {
                // renderEventAnimatione animation components
                mAnimationComponents.stream().forEach((comp)
                        ->
                {
                    Part bodyPart = comp.mBodyPartFX;
                    String action = comp.mAction;
                    int param = comp.mParam;
                    String paramString = comp.mParamString;
                    if (action.equalsIgnoreCase("rotate"))
                    {
                        bodyPart.setRotation(param);
                    }
                    if (action.equalsIgnoreCase("tilt"))
                    {
                        bodyPart.setTilt(param);
                    }
                    if (action.equalsIgnoreCase("translate"))
                    {
                        bodyPart.setTranslation(param);
                    }
                    if (action.equalsIgnoreCase("shape"))
                    {
                        bodyPart.setShape(paramString);
                    }
                });
            }

            if (mCurrentStep > 1)
            {
                for (AnimationContent ba : mAnimationComponents)
                {
                    Part bodyPart = ba.mBodyPartFX;
                    String action = ba.mAction;

                    if (action.equalsIgnoreCase("rotate"))
                    {
                        bodyPart.calculateRotation(mCurrentStep);
                    }

                    if (action.equalsIgnoreCase("tilt"))
                    {
                        bodyPart.calculateRotation(mCurrentStep);
                    }

                    if (action.equalsIgnoreCase("translate"))
                    {
                        bodyPart.calculateTranslation(mCurrentStep);
                    }

                    if (action.equalsIgnoreCase("shape"))
                    {
                        bodyPart.calculateShape(mCurrentStep);
                    }
                }

                new WaitThread(mRenderPauseDuration).start();
                // block this until WaitThread will unblock
                try
                {
                    mRenderingPause.acquire(1);
                } catch (InterruptedException ex)
                {
                    mAgent.mLogger.severe(ex.getMessage());
                }
            }

            if (mCurrentStep == 1)
            {
                for (AnimationContent ba : mAnimationComponents)
                {
                    String action = ba.mAction;
                    Part bodyPart = ba.mBodyPartFX;

                    if (action.equalsIgnoreCase("rotate"))
                    {
                        bodyPart.resetRotation();
                    }

                    if (action.equalsIgnoreCase("tilt"))
                    {
                        bodyPart.resetRotation();
                    }

                    if (action.equalsIgnoreCase("translate"))
                    {
                        bodyPart.resetTranslation();
                    }
                }

                new WaitThread(mRenderPauseDuration).start();
                // block this until WaitThread will unblock
                try
                {
                    mRenderingPause.acquire(1);
                } catch (InterruptedException ex)
                {
                    mAgent.mLogger.severe(ex.getMessage());
                }
                mAnimation.mAnimationPartStart.release();
                if (mAnimation.mParameter instanceof AnimationObserver)
                {
                    try
                    {
                        BufferedImage image = mAgent.getStageRoom().getStageAsImage();
                        notifyAllObservers(image);
                    } catch (Exception e)
                    {
                        e.printStackTrace();
                    }

                }
                return;
            }

            mCurrentStep -= 1;
        }
    }

    public void notifyOnIdentifier(String image)
    {
        notifyAllObservers(image);
    }
}
