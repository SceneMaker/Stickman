package de.dfki.common.part;

import de.dfki.common.animationlogic.Animator;
import de.dfki.common.enums.Axis;
import javafx.application.Platform;
import javafx.scene.paint.Color;
import javafx.scene.shape.Path;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by EmpaT on 27.07.2017.
 */
public abstract class Part2D extends Part
{
    public int mDefaultTranslation = 0;
    public double mTranslation = mDefaultTranslation;
    public double mToTranslation = mDefaultTranslation;
    public double mTranslationStep = 0.0f;
    public double mRotation = mDefaultRotation;
    public double mToDegree = mDefaultRotation;
    public double mRotationStep = 0.0f;
    public float mColoropacity = 1.0f;
    //The color is changed in paintComponent
    public Color mFemaleColor;
    public Color mMaleColor;

    public float mColoropacityRest = 1.0f;
    public Color mFemaleColorRest;
    public Color mMaleColorRest;

    public Color mColorRest = Color.rgb(0, 0, 0);

    public List<Path> mGraphicPaths = Collections.synchronizedList(new ArrayList());
    public BasicStroke mStroke = new BasicStroke(3.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);

    public abstract void update();

    @Override
    public void setTranslation(int length, Axis... axis)
    {
        mToTranslation = mTranslation + length;
        mTranslationStep = (double) length / Animator.sMAX_ANIM_STEPS;
    }

    @Override
    public synchronized void calculateTranslation(int step, Axis... axis)
    {
        mTranslation += mTranslationStep;
        mTranslation = (double) Math.round(mTranslation * 1000d) / 1000d; // the poor man's round method
        Platform.runLater(() -> calculate(step));
    }

    @Override
    public void resetTranslation()
    {
        mTranslationStep = 0.0d;
    }

    @Override
    public void setDefaulRotation(int degree)
    {
        super.setDefaulRotation(degree);
        mRotation = mDefaultRotation;
        mToDegree = mDefaultRotation;
        mRotationStep = 0.0f;
    }

    @Override
    public void setRotation(int degree, Axis... axis)
    {
        mToDegree = mRotation + degree;
        mRotationStep = (double) degree / Animator.sMAX_ANIM_STEPS;
    }

    @Override
    public void setTilt(int degree)
    {
        mToDegree = mRotation + degree;
        mRotationStep = (double) degree / Animator.sMAX_ANIM_STEPS;
    }

    @Override
    public synchronized void calculateRotation(int step, Axis... axis)
    {
        mRotation += mRotationStep;
        mRotation = (double) Math.round(mRotation * 1000d) / 1000d; // the poor man's round method
        Platform.runLater(() -> calculate(step));
    }

    @Override
    public void resetRotation(Axis... axis)
    {
        mTranslationStep = 0.0d;
    }

    public void clearDrawObjects()
    {
        mGraphicPaths = new ArrayList<>();
    }

    public void addToDrawObjects(Path gp)
    {
        mGraphicPaths.add(gp);
    }

}
