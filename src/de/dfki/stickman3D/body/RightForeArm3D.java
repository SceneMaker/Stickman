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
public class RightForeArm3D extends BodyPartFX
{

    public enum SHAPE
    {
        DEFAULT, FADEIN, FADEOUT
    }

    public RightForeArm3D.SHAPE mShape = RightForeArm3D.SHAPE.DEFAULT;

    private RightUpperArm3D mUpperArm;

    private static final int ARMLENGTH = 80;

    private MeshView mRightForeArmMesh;
    private PhongMaterial material;
    private Group rightForeArmGroup;

    public RightForeArm3D(RightUpperArm3D arm)
    {
        mUpperArm = arm;
        mSize = new Dimension(ARMLENGTH, ARMLENGTH);
        mColor = Color.rgb(242, 227, 217, 1);
        mXRotation = -15;
        mZRotation = -10;
        mToDegreeX = mDefaultRotation;

        ColModelImporter importer = new ColModelImporter();
        URL url = getClass().getClassLoader().getResource("BodyParts/Stickman3D/ForeArm.dae");
        importer.read(url);
        mRightForeArmMesh = (MeshView) importer.getImport()[0];

        material = new PhongMaterial();
        material.setDiffuseColor(mColor);
        mRightForeArmMesh.setMaterial(material);

        rightForeArmGroup = new Group();
        rightForeArmGroup.getChildren().add(mRightForeArmMesh);

        mUpperArm.getRightUpperArmGroup().getChildren().add(rightForeArmGroup);

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
        mShape = RightForeArm3D.SHAPE.DEFAULT;
    }

    @Override
    public void calculate(int step)
    {
        Rotate rx = new Rotate(mXRotation, Rotate.X_AXIS);
        Rotate ry = new Rotate(mYRotation, Rotate.Y_AXIS);
        Rotate rz = new Rotate(mZRotation, Rotate.Z_AXIS);

        if (mUpperArm.getUpperBody().getNeck().getHead().getStickman().mType == Gender.TYPE.MALE)
        {
            rightForeArmGroup.setTranslateX(mStart.x);
            rightForeArmGroup.setTranslateY(mStart.y + 60);
            rightForeArmGroup.setTranslateZ(0);
        } else
        {
            rightForeArmGroup.setTranslateX(mStart.x);
            rightForeArmGroup.setTranslateY(mStart.y + 60);
            rightForeArmGroup.setTranslateZ(0);
        }

        rightForeArmGroup.getTransforms().clear();
        rightForeArmGroup.getTransforms().addAll(rx, ry, rz);

        switch (mShape)
        {
            case FADEIN:
                if (step == 2)
                {
                    mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), 0.0);
                    update();
                    mRightForeArmMesh.setVisible(false);
                } else if (mColor.getOpacity() != 0.0)
                {
                    mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), mColor.getOpacity() - 0.052);
                    update();
                }
                break;

            case FADEOUT:
                mRightForeArmMesh.setVisible(true);

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
        mRightForeArmMesh.setMaterial(material);
    }

    public RightUpperArm3D getUpperArm()
    {
        return mUpperArm;
    }

    public MeshView getRightForeArmMesh()
    {
        return mRightForeArmMesh;
    }

    public Group getRightForeArmGroup()
    {
        return rightForeArmGroup;
    }
}
