package de.dfki.common.part;

import de.dfki.common.animationlogic.Animator;
import de.dfki.common.enums.Axis;
import javafx.application.Platform;
import javafx.scene.shape.MeshView;

/**
 * Created by EmpaT on 27.07.2017.
 */
public abstract class Part3D extends Part
{
    public double mXTranslation = 0;
    public double mYTranslation = 0;
    public double mZTranslation = 0;

    public double mXTranslationStep = 0.0f;
    public double mYTranslationStep = 0.0f;
    public double mZTranslationStep = 0.0f;

    public double mXRotation = mDefaultRotation;
    public double mYRotation = mDefaultRotation;
    public double mZRotation = mDefaultRotation;
    public double mToDegreeX = mDefaultRotation;

    public double mXRotationStep = 0.0f;
    public double mYRotationStep = 0.0f;
    public double mZRotationStep = 0.0f;

    @Override
    public void setTranslation(int length, Axis... axis)
    {
        switch (axis[0])
        {
            case X:
                mXTranslationStep = (double) length / Animator.sMAX_ANIM_STEPS;
                break;
            case Y:
                mYTranslationStep = (double) length / Animator.sMAX_ANIM_STEPS;
                break;
            case Z:
                mZTranslationStep = (double) length / Animator.sMAX_ANIM_STEPS;
                break;
        }
    }

    @Override
    public synchronized void calculateTranslation(int step, Axis... axis)
    {
        switch (axis[0])
        {
            case X:
                mXTranslation += mXTranslationStep;
                mXTranslation = Math.round(mXTranslation * 1000d) / 1000d;
                break;
            case Y:
                mYTranslation += mYTranslationStep;
                mYTranslation = Math.round(mYTranslation * 1000d) / 1000d;
                break;
            case Z:
                mZTranslation += mZTranslationStep;
                mZTranslation = Math.round(mZTranslation * 1000d) / 1000d;
                break;
        }
        Platform.runLater(() -> calculate(step));
    }

    @Override
    public void resetTranslation()
    {
        mXTranslationStep = 0.0d;
        mYTranslationStep = 0.0d;
        mZTranslationStep = 0.0d;
    }

    @Override
    public void setDefaulRotation(int degree)
    {
        super.setDefaulRotation(degree);
        mXRotation = mDefaultRotation;
        mYRotation = mDefaultRotation;
        mZRotation = mDefaultRotation;

        mToDegreeX = mDefaultRotation;
        mXRotationStep = 0.0f;
    }

    @Override
    public void setRotation(int degree, Axis... axis)
    {
        switch (axis[0])
        {
            case X:
                mToDegreeX = mXRotation + degree;
                mXRotationStep = (double) degree / Animator.sMAX_ANIM_STEPS;
                break;
            case Y:
                mYRotationStep = (double) degree / Animator.sMAX_ANIM_STEPS;
                break;
            case Z:
                mZRotationStep = (double) degree / Animator.sMAX_ANIM_STEPS;
                break;
        }
    }

    @Override
    public void setTilt(int degree)
    {
        mToDegreeX = mXRotation + degree;
        mXRotationStep = (double) degree / Animator.sMAX_ANIM_STEPS;
    }

    @Override
    public synchronized void calculateRotation(int step, Axis... axis)
    {
        switch (axis[0])
        {
            case X:
                mXRotation += mXRotationStep;
                mXRotation = (double) Math.round(mXRotation * 1000d) / 1000d;
                break;
            case Y:
                mYRotation += mYRotationStep;
                mYRotation = (double) Math.round(mYRotation * 1000d) / 1000d;
                break;
            case Z:
                mZRotation += mZRotationStep;
                mZRotation = (double) Math.round(mZRotation * 1000d) / 1000d;
                break;
        }
        Platform.runLater(() -> calculate(step));
    }

    @Override
    public void resetRotation(Axis... axis)
    {
        switch (axis[0])
        {
            case X:
                mXRotation += mXRotationStep;
                Platform.runLater(() -> calculate(1));
                mXRotationStep = 0;
                break;
            case Y:
                mYRotation += mYRotationStep;
                Platform.runLater(() -> calculate(1));
                mYRotationStep = 0;
                break;
            case Z:
                mZRotation += mZRotationStep;
                Platform.runLater(() -> calculate(1));
                mZRotationStep = 0;
                break;
        }
    }

    public MeshView getMeshView()
    {
        return null;
    }

    public abstract void update();
}
