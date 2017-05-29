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
public class RightUpperArm3D extends BodyPartFX
{

    public enum SHAPE
    {
        DEFAULT, FADEIN, FADEOUT
    }

    public RightUpperArm3D.SHAPE mShape = RightUpperArm3D.SHAPE.DEFAULT;

    private UpperBody3D mUpperBody;

    private static final int ARMLENGTH = 70;

    private MeshView mRightpperArmMesh;
    private PhongMaterial material;

    private Group rightUpperArmGroup;

    public RightUpperArm3D(UpperBody3D bodyFX)
    {
        mUpperBody = bodyFX;
        mSize = new Dimension(ARMLENGTH, ARMLENGTH);
        mColor = Color.rgb(242, 227, 217, 1);

        ColModelImporter importer = new ColModelImporter();
        URL url = getClass().getClassLoader().getResource("BodyParts/Stickman3D/UpperArm.dae");
        if (mUpperBody.getNeck().getHead().getStickman().mType == Gender.TYPE.MALE)
            mDefaultRotation = 10;
         else
            mDefaultRotation = 15;

        mZRotation = mDefaultRotation;
        mToDegreeX = mDefaultRotation;
        mXRotationStep = 0.0f;

        importer.read(url);
        mRightpperArmMesh = (MeshView) importer.getImport()[0];

        material = new PhongMaterial();
        material.setDiffuseColor(mColor);
        mRightpperArmMesh.setMaterial(material);

        rightUpperArmGroup = new Group();
        rightUpperArmGroup.getChildren().add(mRightpperArmMesh);

        mUpperBody.getChildren().add(rightUpperArmGroup);

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
        mShape = RightUpperArm3D.SHAPE.DEFAULT;
    }

    @Override
    public void calculate(int step)
    {
        mStart = mUpperBody.getRightArmStartPostion();

        Rotate rx = new Rotate(mXRotation, Rotate.X_AXIS);
        Rotate ry = new Rotate(mYRotation, Rotate.Y_AXIS);
        Rotate rz = new Rotate(mZRotation, Rotate.Z_AXIS);

        if (mUpperBody.getNeck().getHead().getStickman().mType == Gender.TYPE.MALE)
        {
            rightUpperArmGroup.setTranslateX(mStart.x);
            rightUpperArmGroup.setTranslateY(mStart.y - 105);
            rightUpperArmGroup.setTranslateZ(0);
        } else
        {
            rightUpperArmGroup.setTranslateX(mStart.x + 10);
            rightUpperArmGroup.setTranslateY(mStart.y - 90);
            rightUpperArmGroup.setTranslateZ(0);
        }
        rightUpperArmGroup.getTransforms().clear();
        rightUpperArmGroup.getTransforms().addAll(rx, ry, rz);

        switch (mShape)
        {
            case FADEIN:
                if (step == 2)
                {
                    mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), 0.0);
                    update();
                    mRightpperArmMesh.setVisible(false);
                } else if (mColor.getOpacity() != 0.0)
                {
                    mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), mColor.getOpacity() - 0.052);
                    update();
                }
                break;

            case FADEOUT:
                mRightpperArmMesh.setVisible(true);

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
        mRightpperArmMesh.setMaterial(material);
    }

    public UpperBody3D getUpperBody()
    {
        return mUpperBody;
    }

    public MeshView getRightpperArmMesh()
    {
        return mRightpperArmMesh;
    }

    public Group getRightUpperArmGroup()
    {
        return rightUpperArmGroup;
    }
}
