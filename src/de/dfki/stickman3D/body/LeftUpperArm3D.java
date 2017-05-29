/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.body;

import com.interactivemesh.jfx.importer.col.ColModelImporter;
import de.dfki.common.Gender;
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
public class LeftUpperArm3D extends BodyPartFX
{
    public enum SHAPE
    {
        DEFAULT, FADEIN, FADEOUT
    }

    public LeftUpperArm3D.SHAPE mShape = LeftUpperArm3D.SHAPE.DEFAULT;

    private UpperBody3D mUpperBody;

    private static final int ARMLENGTH = 70;

    private MeshView mLeftUpperArmMesh;
    private PhongMaterial material;

    private Group leftUpperArmGroup;

    public LeftUpperArm3D(UpperBody3D bodyFX)
    {
        mUpperBody = bodyFX;
        mSize = new Dimension(ARMLENGTH, ARMLENGTH);
        mColor = Color.rgb(242, 227, 217, 1);

        ColModelImporter importer = new ColModelImporter();
        URL url = getClass().getClassLoader().getResource("BodyParts/Stickman3D/UpperArm.dae");

        if (mUpperBody.getNeck().getHead().getStickman().mType == Gender.TYPE.MALE)
            mDefaultRotation = -10;
         else
            mDefaultRotation = -15;

        mZRotation = mDefaultRotation;
        mToDegreeX = mDefaultRotation;
        mXRotationStep = 0.0f;

        importer.read(url);
        mLeftUpperArmMesh = (MeshView) importer.getImport()[0];

        material = new PhongMaterial();
        material.setDiffuseColor(mColor);
        mLeftUpperArmMesh.setMaterial(material);

        leftUpperArmGroup = new Group();
        leftUpperArmGroup.getChildren().add(mLeftUpperArmMesh);

        mUpperBody.getChildren().add(leftUpperArmGroup);

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
        mShape = LeftUpperArm3D.SHAPE.DEFAULT;
    }

    @Override
    public void calculate(int step)
    {
        mStart = mUpperBody.getLeftArmStartPostion();

        Rotate rx = new Rotate(mXRotation, Rotate.X_AXIS);
        Rotate ry = new Rotate(mYRotation, Rotate.Y_AXIS);
        Rotate rz = new Rotate(mZRotation, Rotate.Z_AXIS);

        if (mUpperBody.getNeck().getHead().getStickman().mType == Gender.TYPE.MALE)
        {
            leftUpperArmGroup.setTranslateX(mStart.x);
            leftUpperArmGroup.setTranslateY(mStart.y - 105);
            leftUpperArmGroup.setTranslateZ(0);
        } else
        {
            leftUpperArmGroup.setTranslateX(mStart.x - 10);
            leftUpperArmGroup.setTranslateY(mStart.y - 90);
            leftUpperArmGroup.setTranslateZ(0);
        }
        leftUpperArmGroup.getTransforms().clear();
        leftUpperArmGroup.getTransforms().addAll(rx, ry, rz);

        switch (mShape)
        {
            case FADEIN:
                if (step == 2)
                {
                    mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), 0.0);
                    update();
                    mLeftUpperArmMesh.setVisible(false);
                } else if (mColor.getOpacity() != 0.0)
                {
                    mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), mColor.getOpacity() - 0.052);
                    update();
                }
                break;

            case FADEOUT:
                mLeftUpperArmMesh.setVisible(true);

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
        mLeftUpperArmMesh.setMaterial(material);
    }

    public UpperBody3D getUpperBody()
    {
        return mUpperBody;
    }

    public MeshView getLeftUpperArmMesh()
    {
        return mLeftUpperArmMesh;
    }

    public Group getLeftUpperArmGroup()
    {
        return leftUpperArmGroup;
    }
}
