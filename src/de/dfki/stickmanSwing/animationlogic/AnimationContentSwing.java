/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanSwing.animationlogic;

import de.dfki.action.sequence.WordTimeMarkSequence;
import de.dfki.stickmanSwing.body.BodyPart;

/**
 *
 * @author Patrick Gebhard
 *
 */
public class AnimationContentSwing {

    public BodyPart mBodyPart;
    public String mAction;
    public int mParam;
    public String mParamString;
    public WordTimeMarkSequence mWTS;

    public AnimationContentSwing(BodyPart bp, String a, int p) {
        mBodyPart = bp;
        mAction = a;
        mParam = p;
        mParamString = "";
    }

    public AnimationContentSwing(BodyPart bp, String a, String p) {
        mBodyPart = bp;
        mAction = a;
        mParam = 0;
        mParamString = p;
    }

    public AnimationContentSwing(BodyPart bp, String a, String p, WordTimeMarkSequence wts) {
        mBodyPart = bp;
        mAction = a;
        mParam = 0;
        mParamString = p;
        mWTS = wts;
    }
}
