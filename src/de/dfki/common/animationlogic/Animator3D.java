package de.dfki.common.animationlogic;

import de.dfki.action.sequence.WordTimeMarkSequence;
import de.dfki.common.agent.Agent;
import de.dfki.common.enums.Axis;
import de.dfki.common.part.Part;

import java.util.ArrayList;

/**
 * Created by EmpaT on 31.07.2017.
 */
public abstract class Animator3D extends Animator
{

    public Animator3D(Agent agent, Animation animation, ArrayList<AnimationContent> animComps)
    {
        mAgent = agent;
        mAnimation = animation;
        mAnimationComponents = animComps;
        mDescription = mAnimation.getClass().getSimpleName() + " (" + mAnimation.mID + "), " + mAnimation.toString();
        mRenderPauseDuration = 40; // 40 milliseconds equals 25fps - resulting that by default an animation takes 500ms

        render();
    }

    public Animator3D(Agent agent, Animation animation, ArrayList<AnimationContent> animComps, int duration)
    {
        mAgent = agent;
        mAnimation = animation;
        mAnimationComponents = animComps;
        mDescription = mAnimation.getClass().getSimpleName() + " (" + mAnimation.mID + "), " + mAnimation.toString();

        mRenderPauseDuration = new Float(duration / sMAX_ANIM_STEPS).intValue();
        mRenderPauseDuration = (mRenderPauseDuration < 1) ? 1 : mRenderPauseDuration; // minimum delay is 1 millisecond
        render();
    }

    public Animator3D(Agent agent, Animation animation, ArrayList<AnimationContent> animComps, WordTimeMarkSequence wts)
    {
        mAgent = agent;
        mAnimation = animation;
        mAnimationComponents = animComps;
        mWTS = wts;
        mDescription = mAnimation.getClass().getSimpleName() + " (" + mAnimation.mID + "), " + mAnimation.toString();

        renderEventAnimation();
    }

    @Override
    protected void render()
    {
        mCurrentStep = sMAX_ANIM_STEPS;
        while (mCurrentStep > 0)
        {
            if (mCurrentStep == sMAX_ANIM_STEPS)
            {
                mAnimationComponents.stream().forEach((comp) ->
                {
                    Part bodyPart = comp.mBodyPartFX;
                    String action = comp.mAction;
                    sCurrentAction = action;
                    int param = comp.mParam;
                    String paramString = comp.mParamString;
                    if (action.equalsIgnoreCase("rotate"))
                    {
                        bodyPart.setRotation(param, Axis.X);
                    }
                    if (action.equalsIgnoreCase("yRotate"))
                    {
                        bodyPart.setRotation(param, Axis.Y);
                    }
                    if (action.equalsIgnoreCase("zRotate"))
                    {
                        bodyPart.setRotation(param, Axis.Z);
                    }
                    if (action.equalsIgnoreCase("tilt"))
                    {
                        bodyPart.setTilt(param);
                    }
                    if (action.equalsIgnoreCase("translate"))
                    {
                        bodyPart.setTranslation(param, Axis.X);
                    }
                    if (action.equalsIgnoreCase("ytranslate"))
                    {
                        bodyPart.setTranslation(param, Axis.Y);
                    }
                    if (action.equalsIgnoreCase("ztranslate"))
                    {
                        bodyPart.setTranslation(param, Axis.Z);
                    }
                    if (action.equalsIgnoreCase("shape"))
                    {
                        bodyPart.setShape(paramString);
                    }
                });
            }

            if (mCurrentStep > 1)
            {
                for (AnimationContent content : mAnimationComponents)
                {
                    Part bodyPart = content.mBodyPartFX;
                    String action = content.mAction;

                    if (action.equalsIgnoreCase("rotate"))
                    {
                        bodyPart.calculateRotation(mCurrentStep, Axis.X);
                    }
                    if (action.equalsIgnoreCase("yrotate"))
                    {
                        bodyPart.calculateRotation(mCurrentStep, Axis.Y);
                    }
                    if (action.equalsIgnoreCase("zrotate"))
                    {
                        bodyPart.calculateRotation(mCurrentStep, Axis.Z);
                    }
                    if (action.equalsIgnoreCase("tilt"))
                    {
                        bodyPart.calculateRotation(mCurrentStep, Axis.X);
                    }

                    if (action.equalsIgnoreCase("translate"))
                    {
                        bodyPart.calculateTranslation(mCurrentStep, Axis.X);
                    }
                    if (action.equalsIgnoreCase("ytranslate"))
                    {
                        bodyPart.calculateTranslation(mCurrentStep, Axis.Y);
                    }
                    if (action.equalsIgnoreCase("ztranslate"))
                    {
                        bodyPart.calculateTranslation(mCurrentStep, Axis.Z);
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
                for (AnimationContent content : mAnimationComponents)
                {
                    String action = content.mAction;
                    Part bodyPart = content.mBodyPartFX;

                    if (action.equalsIgnoreCase("rotate"))
                    {
                        bodyPart.resetRotation(Axis.X);
                    }
                    if (action.equalsIgnoreCase("yrotate"))
                    {
                        bodyPart.resetRotation(Axis.Y);
                    }
                    if (action.equalsIgnoreCase("zrotate"))
                    {
                        bodyPart.resetRotation(Axis.Z);
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
                return;
            }

            mCurrentStep -= 1;
        }
    }
}
