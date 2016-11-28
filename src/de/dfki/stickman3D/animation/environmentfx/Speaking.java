	/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.animation.environmentfx;

    import de.dfki.stickman3D.Stickman3D;
    import de.dfki.stickman3D.StickmanStageController;
    import de.dfki.stickman3D.animationlogic.AnimationContent3D;
    import de.dfki.stickman3D.animationlogic.Animation3D;
    import de.dfki.stickman3D.environmentfx.SpeechBubbleFX;

    import java.util.ArrayList;

    /**
     *
     * @author Patrick Gebhard
     *
     */
    public class Speaking extends Animation3D {

        public Speaking() {
            mAnimType = ANIMTYPE.ON;
        }

        public Speaking(Stickman3D sm, int duration, boolean block) {
            super(sm, duration, block);
        }

        @Override
        public void playAnimation() {
            if (mParameter instanceof String) {
                mStickmanFX.mSpeechBubbleFX.mText = (String) mParameter;
            }
            // nur zum Testen. Im Normalfall diese Zeile loeschen
            mStickmanFX.mSpeechBubbleFX.mText = "Ich bin in 3D-Welt geborener und mit JavaFX ausgeruesteter StickmanSwing " + mStickmanFX.mName + ". Deswegen sehe ich so toll aus";

            mAnimationPartFX = new ArrayList<>();
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mSpeechBubbleFX, "shape", SpeechBubbleFX.SHAPE.SPEAK.name()));
            playAnimationPart(mDuration);

            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mSpeechBubbleFX, "shape", SpeechBubbleFX.SHAPE.DEFAULT.name()));
            playAnimationPart(20);

            if(StickmanStageController.currentRadioButton != null) // nur zum Testen. Im Normalfall diese 2 Zeilen loeschen
                StickmanStageController.currentRadioButton.setSelected(false);
        }
    }
