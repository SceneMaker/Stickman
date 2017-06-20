/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.body;

import com.interactivemesh.jfx.importer.col.ColModelImporter;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.MeshView;

import java.awt.*;
import java.net.URL;

/**
 * @author Beka Aptsiauri
 */
public class Nose3D extends BodyPartFX
{

    public enum SHAPE
    {
        DEFAULT, FADEIN, FADEOUT
    }

    private Head3D mHead;
    private MeshView mNose;
    private PhongMaterial material;

    public Nose3D.SHAPE mShape = Nose3D.SHAPE.DEFAULT;

    public Nose3D(Head3D head)
    {
        mHead = head;
        mSize = new Dimension(mLength, mLength);
        mColor = Color.rgb(242, 227, 217, 1);

        ColModelImporter importer = new ColModelImporter();
        URL url = getClass().getClassLoader().getResource("BodyParts/Stickman3D/nose.dae");
        importer.read(url);
        mNose = (MeshView) importer.getImport()[0];

        material = new PhongMaterial();
        material.setDiffuseColor(mColor);
        mNose.setMaterial(material);

        mStart = mHead.getLeftEyebrowPostion();

        init();

        mHead.getChildren().add(mNose);
    }

    @Override
    public void init()
    {
        super.init();
        mNose.setTranslateX(mStart.x);
        mNose.setTranslateY(mStart.y + 110);
        mNose.setTranslateZ(-15);
    }

    @Override
    public void setShape(String s)
    {
        SHAPE shape = Nose3D.SHAPE.valueOf(s);
        mShape = (shape != null) ? shape : Nose3D.SHAPE.DEFAULT;
    }

    @Override
    public void resetShape()
    {
        mShape = Nose3D.SHAPE.DEFAULT;
    }

    @Override
    public void calculate(int step)
    {

        switch (mShape)
        {
            case FADEIN:
                if (step == 2)
                {
                    mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), 0.0);
                    update();
                    mNose.setVisible(false);
                } else if (mColor.getOpacity() != 0.0)
                {
                    mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), mColor.getOpacity() - 0.052);
                    update();
                }
                break;

            case FADEOUT:
                mNose.setVisible(true);

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

    @Override
    public void update()
    {
        material.setDiffuseColor(mColor);
        mNose.setMaterial(material);
    }

    @Override
    protected void recordColor()
    {
        if (mHead.getStickman().setCharacterInvisible == false)
        {
            mColorRecorder = mColor;
        }
    }

    public MeshView getNose()
    {
        return mNose;
    }
}
