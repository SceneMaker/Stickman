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
public class RightWrist3D extends BodyPartFX
{

    public enum SHAPE
    {
        DEFAULT, FADEIN, FADEOUT
    }

    public RightWrist3D.SHAPE mShape = RightWrist3D.SHAPE.DEFAULT;

    private static final int ARMLENGTH = 80;

    private MeshView mRightWristMesh;
    private PhongMaterial material;
    private Group rightWristGroup;

    public RightWrist3D(RightForeArm3D rightForeArmFX)
    {
        mSize = new Dimension(ARMLENGTH, ARMLENGTH);
        mColor = Color.rgb(242, 227, 217, 1);
        mToDegreeX = mDefaultRotation;
        mZRotation = 0;
        mYRotation = 50;

        ColModelImporter importer = new ColModelImporter();
        URL url = getClass().getClassLoader().getResource("BodyParts/Stickman3D/RightWrist.dae");
        importer.read(url);
        mRightWristMesh = (MeshView) importer.getImport()[0];

        material = new PhongMaterial();
        material.setDiffuseColor(mColor);
        mRightWristMesh.setMaterial(material);

        rightWristGroup = new Group();
        rightWristGroup.getChildren().add(mRightWristMesh);

        rightForeArmFX.getRightForeArmGroup().getChildren().add(rightWristGroup);

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
        mShape = RightWrist3D.SHAPE.DEFAULT;
    }

    @Override
    public void calculate(int step)
    {
        Rotate rx = new Rotate(mXRotation, Rotate.X_AXIS);
        Rotate ry = new Rotate(mYRotation, Rotate.Y_AXIS);
        Rotate rz = new Rotate(mZRotation, Rotate.Z_AXIS);

        rightWristGroup.setTranslateX(mStart.x);
        rightWristGroup.setTranslateY(mStart.y + 70);
        rightWristGroup.setTranslateZ(0);

        rightWristGroup.getTransforms().clear();
        rightWristGroup.getTransforms().addAll(rx, ry, rz);

        switch (mShape)
        {
            case FADEIN:
                if (step == 2)
                {
                    mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), 0.0);
                    update();
                    mRightWristMesh.setVisible(false);
                } else if (mColor.getOpacity() != 0.0)
                {
                    mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), mColor.getOpacity() - 0.052);
                    update();
                }
                break;

            case FADEOUT:
                mRightWristMesh.setVisible(true);

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
        mRightWristMesh.setMaterial(material);
    }

    public MeshView getRightWristMesh()
    {
        return mRightWristMesh;
    }

    public Group getRightWristGroup()
    {
        return rightWristGroup;
    }

}
