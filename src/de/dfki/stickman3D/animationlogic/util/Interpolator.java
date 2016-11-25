package de.dfki.stickman3D.animationlogic.util;

import de.dfki.stickman3D.animationlogic.Animator;

/**
 *
 * @author Patrick Gebhard
 *
 */
public class Interpolator {

	// The singelton Interpolator
	public static Interpolator sInstance = null;

	// Construct the Interpolator
	private Interpolator() {
	}

	// Get the default Interpolator
	public static synchronized Interpolator getInstance() {
		if (sInstance == null) {
			sInstance = new Interpolator();
		}
		return sInstance;
	}

	public static double linearOffset(double start, double end, int currentStep) {
		// System.out.println("Math.abs(start) - Math.abs(end))" +
		// (Math.abs(start) - Math.abs(end)));
		// System.out.println("end - start " + (end - start));

		return (end - start) / Animator.sMAX_ANIM_STEPS * currentStep;
	}

	public static double linear(double start, double end, int currentStep) {
		// System.out.println("Math.abs(start) - Math.abs(end))" +
		// (Math.abs(start) - Math.abs(end)));
		// System.out.println("end - start " + (end - start));
		double offset = (end - start) / Animator.sMAX_ANIM_STEPS * (Animator.sMAX_ANIM_STEPS - currentStep + 1);

		return start + offset;
	}
}
