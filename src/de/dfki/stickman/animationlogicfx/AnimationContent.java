/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman.animationlogicfx;

import de.dfki.action.sequence.WordTimeMarkSequence;
import de.dfki.stickman.bodyfx.BodyPartFX;

/**
 *
 * @author Patrick Gebhard
 *
 */
public class AnimationContent {

	public BodyPartFX mBodyPartfx;
	public String mAction;
	public int mParam;
	public String mParamString;
	public WordTimeMarkSequence mWTS;

	public AnimationContent(BodyPartFX bp, String a, int p) {
		mBodyPartfx = bp;
		mAction = a;
		mParam = p;
		mParamString = "";
	}

	public AnimationContent(BodyPartFX bp, String a, String p) {
		mBodyPartfx = bp;
		mAction = a;
		mParam = 0;
		mParamString = p;
	}

	public AnimationContent(BodyPartFX bp, String a, String p, WordTimeMarkSequence wts) {
		mBodyPartfx = bp;
		mAction = a;
		mParam = 0;
		mParamString = p;
		mWTS = wts;
	}
}
