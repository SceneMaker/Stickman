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
public class RightUpperLeg3D extends BodyPartFX
{

    public enum SHAPE
    {
        DEFAULT, FADEIN, FADEOUT
    }

    public RightUpperLeg3D.SHAPE mShape = RightUpperLeg3D.SHAPE.DEFAULT;

    private DownBody3D mDownBody;
    private MeshView mRightUpperLegMesh;
    private PhongMaterial material;
    private Group rightUpperLegGroup;

    public RightUpperLeg3D(DownBody3D downBody)
    {
        mDownBody = downBody;
        mSize = new Dimension(10, mLength);
        mColor = Color.rgb(242, 227, 217, 1);
        mDefaultRotation = 0;
        mXRotation = mDefaultRotation;
        mToDegreeX = mDefaultRotation;
        mXRotationStep = 0.0f;

        URL url;
        if (mDownBody.getUpperBody().getNeck().getHead().getStickman().mType == Gender.TYPE.MALE)
        {
            mLength = 60;
            url = getClass().getClassLoader().getResource("BodyParts/Stickman3D/MaleUpperLeg.dae");
        } else
        {
            mLength = 50;
            url = getClass().getClassLoader().getResource("BodyParts/Stickman3D/FemaleUpperLeg.dae");
        }

        ColModelImporter imorter = new ColModelImporter();
        imorter.read(url);
        mRightUpperLegMesh = (MeshView) imorter.getImport()[0];

        material = new PhongMaterial();
        material.setDiffuseColor(mColor);
        mRightUpperLegMesh.setMaterial(material);

        rightUpperLegGroup = new Group();
        rightUpperLegGroup.getChildren().add(mRightUpperLegMesh);

        mDownBody.getChildren().add(rightUpperLegGroup);

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
        mShape = RightUpperLeg3D.SHAPE.DEFAULT;
    }

    @Override
    public void calculate(int step)
    {
        mStart = mDownBody.getUpperBody().getRightLegStartPostion();

        Rotate rx = new Rotate(mXRotation, Rotate.X_AXIS);
        Rotate ry = new Rotate(mYRotation, Rotate.Y_AXIS);
        Rotate rz = new Rotate(mZRotation, Rotate.Z_AXIS);

        rightUpperLegGroup.setTranslateX(mStart.x - 70);
        if (mDownBody.getUpperBody().getNeck().getHead().getStickman().mType == Gender.TYPE.MALE)
            rightUpperLegGroup.setTranslateY(mStart.y - 256);
        else
            rightUpperLegGroup.setTranslateY(mStart.y - 246);
        rightUpperLegGroup.setTranslateZ(0);

        rightUpperLegGroup.getTransforms().clear();
        rightUpperLegGroup.getTransforms().addAll(rx, ry, rz);

        switch (mShape)
        {
            case FADEIN:
                if (step == 2)
                {
                    mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), 0.0);
                    update();
                    mRightUpperLegMesh.setVisible(false);
                } else if (mColor.getOpacity() != 0.0)
                {
                    mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), mColor.getOpacity() - 0.052);
                    update();
                }
                break;

            case FADEOUT:
                mRightUpperLegMesh.setVisible(true);

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
        mRightUpperLegMesh.setMaterial(material);
    }

    public DownBody3D getDownBody()
    {
        return mDownBody;
    }

    public MeshView getRightUpperLegMesh()
    {
        return mRightUpperLegMesh;
    }

    public Group getRightUpperLegGroup()
    {
        return rightUpperLegGroup;
    }
}
