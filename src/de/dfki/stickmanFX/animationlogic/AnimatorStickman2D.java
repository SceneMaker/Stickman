package de.dfki.stickmanFX.animationlogic;

import de.dfki.action.sequence.WordTimeMarkSequence;
import de.dfki.common.agent.Agent;
import de.dfki.common.animationlogic.Animation;
import de.dfki.common.animationlogic.AnimationContent;
import de.dfki.common.animationlogic.Animator2D;

import java.util.ArrayList;

/**
 * @author Beka Aptsiauri
 */
public class AnimatorStickman2D extends Animator2D
{

    public AnimatorStickman2D(Agent agent, Animation animation, ArrayList<AnimationContent> animComps)
    {
        super(agent, animation, animComps);
    }

    public AnimatorStickman2D(Agent agent, Animation animation, ArrayList<AnimationContent> animComps, int duration)
    {
        super(agent, animation, animComps, duration);
    }

    public AnimatorStickman2D(Agent agent, Animation animation, ArrayList<AnimationContent> animComps, WordTimeMarkSequence wts)
    {
        super(agent, animation, animComps, wts);
    }
}
