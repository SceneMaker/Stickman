/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.body;

import com.interactivemesh.jfx.importer.col.ColModelImporter;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.MeshView;
import javafx.scene.transform.Rotate;

import java.awt.*;
import java.net.URL;

/**
 * @author Beka
 */
public class LeftForeArm3D extends BodyPartFX
{

    public enum SHAPE
    {
        DEFAULT, FADEIN, FADEOUT
    }

    public LeftForeArm3D.SHAPE mShape = LeftForeArm3D.SHAPE.DEFAULT;

    private LeftUpperArm3D mLeftUpperArm;
    private static final int ARMLENGTH = 80;

    private MeshView mLeftForeArmMesh;
    private PhongMaterial material;
    private Group leftForeArmGroup;

    public LeftForeArm3D(LeftUpperArm3D arm)
    {
        mLeftUpperArm = arm;
        mSize = new Dimension(ARMLENGTH, ARMLENGTH);
        mColor = Color.rgb(242, 227, 217, 1);

        ColModelImporter importer = new ColModelImporter();
        URL url = getClass().getClassLoader().getResource("BodyParts/Stickman3D/ForeArm.dae");

        mXRotation = -15;
        mZRotation = 10;
        mToDegreeX = mDefaultRotation;

        importer.read(url);
        mLeftForeArmMesh = (MeshView) importer.getImport()[0];

        material = new PhongMaterial();
        material.setDiffuseColor(mColor);
        mLeftForeArmMesh.setMaterial(material);

        leftForeArmGroup = new Group();
        leftForeArmGroup.getChildren().add(mLeftForeArmMesh);

        mLeftUpperArm.getLeftUpperArmGroup().getChildren().add(leftForeArmGroup);

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
        mShape = LeftForeArm3D.SHAPE.DEFAULT;
    }

    @Override
    public void calculate(int step)
    {
        Rotate rx = new Rotate(mXRotation, Rotate.X_AXIS);
        Rotate ry = new Rotate(mYRotation, Rotate.Y_AXIS);
        Rotate rz = new Rotate(mZRotation, Rotate.Z_AXIS);

        leftForeArmGroup.setTranslateX(mStart.x);
        leftForeArmGroup.setTranslateY(mStart.y + 60);
        leftForeArmGroup.setTranslateZ(0);

        leftForeArmGroup.getTransforms().clear();
        leftForeArmGroup.getTransforms().addAll(rx, ry, rz);

        switch (mShape)
        {
            case FADEIN:
                if (step == 2)
                {
                    mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), 0.0);
                    update();
                    mLeftForeArmMesh.setVisible(false);
                } else if (mColor.getOpacity() != 0.0)
                {
                    mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), mColor.getOpacity() - 0.052);
                    update();
                }
                break;

            case FADEOUT:
                mLeftForeArmMesh.setVisible(true);

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
        mLeftForeArmMesh.setMaterial(material);
    }

    public LeftUpperArm3D getLeftUpperArm()
    {
        return mLeftUpperArm;
    }

    public MeshView getLeftForeArmMesh()
    {
        return mLeftForeArmMesh;
    }

    public Group getLeftForeArmGroup()
    {
        return leftForeArmGroup;
    }
}
