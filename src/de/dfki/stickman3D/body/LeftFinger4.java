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
import javafx.scene.transform.Rotate;

import java.awt.*;
import java.net.URL;

/**
 * @author Beka
 */
public class LeftFinger4 extends BodyPartFX
{

    public enum SHAPE
    {
        DEFAULT, FADEIN, FADEOUT
    }

    public LeftFinger4.SHAPE mShape = LeftFinger4.SHAPE.DEFAULT;

    private static final int ARMLENGTH = 80;

    private MeshView mLeftFinger4;

    private PhongMaterial material;

    public LeftFinger4(LeftWrist3D leftWrist)
    {
        mSize = new Dimension(ARMLENGTH, ARMLENGTH);
        mColor = Color.rgb(242, 227, 217, 1);
        mDefaultRotation = -20;
        mZRotation = 0;
        mToDegreeX = mDefaultRotation;

        ColModelImporter importer = new ColModelImporter();
        URL url = getClass().getClassLoader().getResource("BodyParts/Stickman3D/Finger2_3_4.dae");
        importer.read(url);
        mLeftFinger4 = (MeshView) importer.getImport()[0];

        material = new PhongMaterial();
        material.setDiffuseColor(mColor);
        mLeftFinger4.setMaterial(material);

        leftWrist.getLeftWristGroup().getChildren().add(mLeftFinger4);

        init();
    }

    @Override
    public void setShape(String s)
    {
        SHAPE shape = SHAPE.valueOf(s);
        mShape = (shape != null) ? shape : SHAPE.DEFAULT;
    }

    @Override
    public void resetShape()
    {
        mShape = LeftFinger4.SHAPE.DEFAULT;
    }

    @Override
    public void calculate(int step)
    {
        Rotate rx = new Rotate(mXRotation, Rotate.X_AXIS);
        Rotate ry = new Rotate(mYRotation, Rotate.Y_AXIS);
        Rotate rz = new Rotate(mZRotation, Rotate.Z_AXIS);

        mLeftFinger4.setTranslateX(mStart.x + 6);
        mLeftFinger4.setTranslateY(mStart.y + 17);
        mLeftFinger4.setTranslateZ(0);

        mLeftFinger4.getTransforms().clear();
        mLeftFinger4.getTransforms().addAll(rx, ry, rz);

        switch (mShape)
        {
            case FADEIN:
                if (step == 2)
                {
                    mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), 0.0);
                    update();
                    mLeftFinger4.setVisible(false);
                } else if (mColor.getOpacity() != 0.0)
                {
                    mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), mColor.getOpacity() - 0.052);
                    update();
                }
                break;

            case FADEOUT:
                mLeftFinger4.setVisible(true);

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
        mLeftFinger4.setMaterial(material);
    }

    public MeshView getLeftFinger4()
    {
        return mLeftFinger4;
    }

}
