/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.reeti.body;

import de.dfki.reeti.animationlogic.AnimatorReeti;
import javafx.application.Platform;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import java.awt.*;
import java.net.URL;

/**
 * @author Beka Aptsiauri
 */
public abstract class Parts extends Pane
{
    public enum SHAPE
    {
        DEFAULT
    }

    // variables for size and drawing
    public Dimension mSize = new Dimension(10, 10);
    public Point mStart = new Point(0, 0), mEnd = new Point(0, 0);
    public int mLength = 0;

    public int mShapeAnimationStep = 0;

    private int mDefaultTranslation = 0;
    private double mXTranslation = mDefaultTranslation;
    private double mYTranslation = mDefaultTranslation;
    private double mZTranslation = mDefaultTranslation;

    private double mXTranslationStep = 0.0f;
    private double mYTranslationStep = 0.0f;
    private double mZTranslationStep = 0.0f;

    public int mDefaultRotation = 0;
    public Point mDefaultRotationPoint = new Point(0, 0);

    public double mXRotation = mDefaultRotation;
    public double mYRotation = mDefaultRotation;
    public double mZRotation = mDefaultRotation;
    public double mToDegreeX = mDefaultRotation;
    private double mXRotationStep = 0.0f;
    private double mYRotationStep = 0.0f;
    private double mZRotationStep = 0.0f;

    public Color mColor = Color.rgb(0, 0, 0);

    private static PhongMaterial material = null;

    public void init()
    {
        this.setPrefHeight(mSize.height);
        this.setPrefWidth(mSize.width);
        calculate(0);
    }

    public void set_X_Translation(int length)
    {
        mXTranslationStep = (double) length / AnimatorReeti.sMAX_ANIM_STEPS;
    }

    public void set_Y_Translation(int length)
    {
        mYTranslationStep = (double) length / AnimatorReeti.sMAX_ANIM_STEPS;
    }

    public void set_Z_Translation(int length)
    {
        mZTranslationStep = (double) length / AnimatorReeti.sMAX_ANIM_STEPS;
    }

    public synchronized void calculate_X_Translation(int step)
    {
        mXTranslation += mXTranslationStep;
        mXTranslation = Math.round(mXTranslation * 1000d) / 1000d;

        Platform.runLater(() -> calculate(step));
    }

    public synchronized void calculate_Y_Translation(int step)
    {
        mYTranslation += mYTranslationStep;
        mYTranslation = Math.round(mYTranslation * 1000d) / 1000d;

        Platform.runLater(() -> calculate(step));
    }

    public synchronized void calculate_Z_Translation(int step)
    {
        mZTranslation += mZTranslationStep;
        mZTranslation = Math.round(mZTranslation * 1000d) / 1000d;

        Platform.runLater(() -> calculate(step));
    }

    public void resetTranslation()
    {
        mXTranslationStep = 0.0d;
        mYTranslationStep = 0.0d;
        mZTranslationStep = 0.0d;
    }

    public void setDefaulRotation(int degree)
    {
        mDefaultRotation = degree;
        mXRotation = mDefaultRotation;
        mYRotation = mDefaultRotation;
        mZRotation = mDefaultRotation;

        mToDegreeX = mDefaultRotation;
        mXRotationStep = 0.0f;
    }

    public void set_X_Rotation(int degree)
    {
        mToDegreeX = mXRotation + degree;
        mXRotationStep = (double) degree / AnimatorReeti.sMAX_ANIM_STEPS;
    }

    public void set_Y_Rotation(int degree)
    {
        mYRotationStep = (double) degree / AnimatorReeti.sMAX_ANIM_STEPS;
    }

    public void set_Z_Rotation(int degree)
    {
        mZRotationStep = (double) degree / AnimatorReeti.sMAX_ANIM_STEPS;
    }

    public void setTilt(int degree)
    {
        mToDegreeX = mXRotation + degree;
        mXRotationStep = (double) degree / AnimatorReeti.sMAX_ANIM_STEPS;
    }

    public synchronized void calculate_X_Rotation(int step)
    {
        mXRotation += mXRotationStep;
        mXRotation = (double) Math.round(mXRotation * 1000d) / 1000d;

        Platform.runLater(() -> calculate(step));
    }

    public synchronized void calculate_Y_Rotation(int step)
    {
        mYRotation += mYRotationStep;
        mYRotation = (double) Math.round(mYRotation * 1000d) / 1000d;

        Platform.runLater(() -> calculate(step));
    }

    public synchronized void calculate_Z_Rotation(int step)
    {
        mZRotation += mZRotationStep;
        mZRotation = (double) Math.round(mZRotation * 1000d) / 1000d;

        Platform.runLater(() -> calculate(step));

    }

    public void resetRotation()
    {
//        mTranslationStep = 0.0d;
    }

    public void reset_X_Rotation()
    {
        mXRotation += mXRotationStep;
        Platform.runLater(() -> calculate(1));
        mXRotationStep = 0;
    }

    public void reset_Y_Rotation()
    {
        mYRotation += mYRotationStep;
        Platform.runLater(() -> calculate(1));
        mYRotationStep = 0;
    }

    public void reset_Z_Rotation()
    {
        mZRotation += mZRotationStep;
        Platform.runLater(() -> calculate(1));
        mZRotationStep = 0;
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

        Platform.runLater(() -> calculate(step));
    }

    public void resetShape()
    {
        mShapeAnimationStep = 0;
    }

    public void clearChildren(Parts bodyPartFX)
    {
        bodyPartFX.getChildren().clear();
    }

    public synchronized void calculate(int step)
    {
        createShape();
    }

    protected PhongMaterial getMaterial()
    {
        if (material == null)
        {
            URL imageUrl = getClass().getClassLoader().getResource("Images/difuseMap2.png");
            javafx.scene.image.Image image = new javafx.scene.image.Image(imageUrl.toExternalForm());
            material = new PhongMaterial();
            material.setDiffuseColor(mColor);
            material.setDiffuseMap(image);
            material.setSelfIlluminationMap(image);
        }
        return material;
    }


}
