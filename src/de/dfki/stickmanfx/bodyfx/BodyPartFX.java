/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanfx.bodyfx;

import de.dfki.stickman.animationlogic.Animator;
import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Path;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.shape.StrokeLineJoin;
import javafx.scene.transform.Affine;

/**
 *
 * @author Beka Aptsiauri
 *
 */
public abstract class BodyPartFX extends Pane 
{

    public enum SHAPE 
    {
        DEFAULT
    };

    // variables for size and drawing
    public Dimension mSize = new Dimension(10, 10);
    public Point mStart = new Point(0, 0), mEnd = new Point(0, 0);
    public int mLength = 0;

    public double mAnimationStep = 0;
    public int mShapeAnimationStep = 0;

    public int mDefaultTranslation = 0;
    public double mTranslation = mDefaultTranslation;
    public double mToTranslation = mDefaultTranslation;
    public double mTranslationStep = 0.0f;

    public int mDefaultRotation = 0;
    public Point mDefaultRotationPoint = new Point(0, 0);
    public double mRotation = mDefaultRotation;
    public double mToDegree = mDefaultRotation;
    public double mRotationStep = 0.0f;

    List<Path> mGraphicPaths = Collections.synchronizedList(new ArrayList());

    public Color mColor = Color.rgb(0, 0, 0);

    public BasicStroke mStroke = new BasicStroke(3.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);

    public void init() 
    {
        this.prefHeight(mSize.height);
        this.prefWidth(mSize.width);

        calculate(0);
    }

    public void setTranslation(int length) 
    {
        mToTranslation = mTranslation + length;
        mTranslationStep = (double) length / Animator.sMAX_ANIM_STEPS;
    }

    public synchronized void calculateTranslation(int step) 
    {
        mTranslation += mTranslationStep;
        mTranslation = (double) Math.round(mTranslation * 1000d) / 1000d; // the poor man's round method

        calculate(step);
    }

    public void resetTranslation() 
    {
        mTranslationStep = 0.0d;
    }

    public void setDefaulRotation(int degree) 
    {
        mDefaultRotation = degree;
        mRotation = mDefaultRotation;
        mToDegree = mDefaultRotation;
        mRotationStep = 0.0f;
    }

    public void setRotation(int degree) 
    {
        mToDegree = mRotation + degree;
        mRotationStep = (double) degree / Animator.sMAX_ANIM_STEPS;
    }

    public void setTilt(int degree) 
    {
        mToDegree = mRotation + degree;
        mRotationStep = (double) degree / Animator.sMAX_ANIM_STEPS;
    }

    public synchronized void calculateRotation(int step) 
    {
        mRotation += mRotationStep;
        mRotation = (double) Math.round(mRotation * 1000d) / 1000d; // the poor man's round method
        calculate(step);
    }

    public void resetRotation() 
    {
        mTranslationStep = 0.0d;
    }

    public void setShape(String s) 
    {
        // place code for setting shape
    }

    public void createShape() 
    {
        // create the shape
    }

    public synchronized void calculateShape(int step) 
    {
        mShapeAnimationStep = step;

        calculate(step);
    }

    public void resetShape() 
    {
        mShapeAnimationStep = 0;
    }

    public void clearDrawObjects() 
    {
        mGraphicPaths = new ArrayList<>();
    }

    public void clearChildren(BodyPartFX bodyPartFX) 
    {
        bodyPartFX.getChildren().clear();
    }

    public void addToDrawObjects(Path gp) 
    {
        mGraphicPaths.add(gp);
    }

    public synchronized void calculate(int step) 
    {
        createShape();

        Affine af = new Affine();
        af.appendTranslation(0, mToTranslation);
        af.appendRotation(mRotation, mDefaultRotationPoint.x, mDefaultRotationPoint.y);

        for (Path gp : mGraphicPaths) 
        {   
            gp.getTransforms().clear();
            gp.getTransforms().add(af);
        }
    }

    public void update() 
    {
        for (Path gp : mGraphicPaths) 
        {
            gp.setStroke(mColor);
            gp.setStrokeLineCap(StrokeLineCap.ROUND);
            gp.setStrokeLineJoin(StrokeLineJoin.ROUND);
            gp.setStrokeWidth(3);
        }
    }
}
