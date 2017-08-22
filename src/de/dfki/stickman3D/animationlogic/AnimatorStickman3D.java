package de.dfki.stickman3D.animationlogic;

import de.dfki.action.sequence.WordTimeMarkSequence;
import de.dfki.common.agent.Agent;
import de.dfki.common.animationlogic.Animation;
import de.dfki.common.animationlogic.AnimationContent;
import de.dfki.common.animationlogic.Animator3D;

import java.util.ArrayList;

/**
 * @author Beka Aptsiauri
 */
public class AnimatorStickman3D extends Animator3D
{
    public AnimatorStickman3D(Agent agent, Animation animation, ArrayList<AnimationContent> animComps)
    {
        super(agent, animation, animComps);
    }

    public AnimatorStickman3D(Agent agent, Animation animation, ArrayList<AnimationContent> animComps, int duration)
    {
        super(agent, animation, animComps, duration);
    }

    public AnimatorStickman3D(Agent agent, Animation animation, ArrayList<AnimationContent> animComps, WordTimeMarkSequence wts)
    {
        super(agent, animation, animComps, wts);
    }
}
