/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.reeti.animationlogic;

import de.dfki.action.sequence.WordTimeMarkSequence;
import de.dfki.reeti.body.BodyPartFX;

/**
 *
 * @author Beka Aptsiauri
 *
 */
public class AnimationContentReeti {

    public BodyPartFX mBodyPartFX;
    public String mAction;
    public int mParam;
    public String mParamString;
    public WordTimeMarkSequence mWTS;

    public AnimationContentReeti(BodyPartFX bp, String a, int p) {
        mBodyPartFX = bp;
        mAction = a;
        mParam = p;
        mParamString = "";
    }

    public AnimationContentReeti(BodyPartFX bp, String a, String p) {
        mBodyPartFX = bp;
        mAction = a;
        mParam = 0;
        mParamString = p;
    }

    public AnimationContentReeti(BodyPartFX bp, String a, String p, WordTimeMarkSequence wts) {
        mBodyPartFX = bp;
        mAction = a;
        mParam = 0;
        mParamString = p;
        mWTS = wts;
    }
}
