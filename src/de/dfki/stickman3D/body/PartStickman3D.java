/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.body;

import de.dfki.common.part.Part3D;
import javafx.scene.paint.Color;
import javafx.scene.shape.MeshView;
import javafx.scene.transform.Affine;

/**
 * @author Beka Aptsiauri
 */
public abstract class PartStickman3D extends Part3D
{
    public double mXRotatationRecorder;
    public double mYRotatationRecorder;
    public double mZRotatationRecorder;

    @Override
    public void init()
    {
        mColorRecorder = mColor;
        mXRotatationRecorder = mXRotation;
        mYRotatationRecorder = mYRotation;
        mZRotatationRecorder = mZRotation;
        super.init();
    }

    public void update()
    {
        recordColor();
    }

    protected void recordColor()
    {

    }

    @Override
    public void rotatePerlinNoise(double mWobble, int x, int y)
    {
        Affine af = new Affine();
        // Out put perlin noise
        af.appendRotation(Math.toRadians(mWobble), x, y);
        this.getTransforms().clear();
        this.getTransforms().add(af);
    }

    protected void executeFadeInFadeOut(MeshView meshView, SHAPE shape, int step)
    {
        switch (shape)
        {
            case FADEIN:
                if (step == 2)
                {
                    mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), 0.0);
                    update();
                    meshView.setVisible(false);
                } else if (mColor.getOpacity() != 0.0)
                {
                    mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), mColor.getOpacity() - 0.052);
                    update();
                }
                break;

            case FADEOUT:
                meshView.setVisible(true);

                if (step == 2)
                {
                    mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), 1.0);
                    update();
                } else if (mColor.getOpacity() != 1.0)
                {
                    mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), mColor.getOpacity() + 0.052);
                    update();
                }
                break;
        }
    }


    public enum SHAPE
    {
        DEFAULT,
        ANGRYSMALLMOUTH,
        ANGRYSMALLMOUTHEND,
        FEAR,
        FEAREND,
        SMILE,
        SMILEEND,
        FADEIN,
        FADEOUT,
        BLINK,
        BLINKEND,
        LOOKLEFT,
        LOOKLEFTEND,
        LOOKRIGHT,
        LOOKRIGHTEND,
        LOOKDOWN,
        LOOKDOWNEND,
        LOOKUP,
        LOOKUPEND,
        ANGRY,
        ANGRYEND,
        SURPRISED,
        SURPRISEDEND,
        HAPPY,
        HAPPYEND,
        DISGUSTED,
        DISGUSTEDEND,
        CONTEMPT,
        CONTEMPTEND,
        EXCITED,
        EXCITEDEND,
        EMBARRASSED,
        EMBARRASSEDEND,
        SAD,
        SADEND,
        O,
        ONE,
        TWO,
        THREE,
        FOUR,
        FIVE,
        SIX,
        SEVEN,
        EIGHT,
        NINE,
        TEN,
        ELEVEN,
        TWELVE,
        THIRTEEN,
        FOURTEEN,
        NINETEEN,
        TWENTY
    }
}
