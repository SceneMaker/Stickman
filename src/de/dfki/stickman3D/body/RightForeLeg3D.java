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
public class RightForeLeg3D extends BodyPartFX
{

    public enum SHAPE
    {
        DEFAULT, FADEIN, FADEOUT
    }

    public RightForeLeg3D.SHAPE mShape = RightForeLeg3D.SHAPE.DEFAULT;

    private RightUpperLeg3D mUpperLeg;

    private static int LEGLENGTH = 90;

    public MeshView mRightForeLegMesh;
    PhongMaterial material;
    Group rightForeLegGroup;

    public RightForeLeg3D(RightUpperLeg3D rightUpperLegFX)
    {
        mUpperLeg = rightUpperLegFX;
        mSize = new Dimension(10, LEGLENGTH);
        mDefaultRotation = -2;
        mXRotation = mDefaultRotation;
        mToDegreeX = mDefaultRotation;
        mColor = Color.rgb(242, 227, 217, 1);

        URL url;
        if (mUpperLeg.getDownBody().getUpperBody().getNeck().getHead().getStickman().mType == Gender.TYPE.MALE)
        {
            LEGLENGTH = 90;
            url = getClass().getClassLoader().getResource("BodyParts/Stickman3D/MaleForeLeg.dae");
        } else
        {
            LEGLENGTH = 80;
            url = getClass().getClassLoader().getResource("BodyParts/Stickman3D/FemaleForeLeg.dae");
        }

        ColModelImporter importer = new ColModelImporter();
        importer.read(url);
        mRightForeLegMesh = (MeshView) importer.getImport()[0];

        material = new PhongMaterial();
        material.setDiffuseColor(mColor);
        mRightForeLegMesh.setMaterial(material);

        rightForeLegGroup = new Group();
        rightForeLegGroup.getChildren().add(mRightForeLegMesh);

        mUpperLeg.getRightUpperLegGroup().getChildren().add(rightForeLegGroup);

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
        mShape = RightForeLeg3D.SHAPE.DEFAULT;
    }

    @Override
    public void calculate(int step)
    {

        Rotate rx = new Rotate(mXRotation, Rotate.X_AXIS);
        Rotate ry = new Rotate(mYRotation, Rotate.Y_AXIS);
        Rotate rz = new Rotate(mZRotation, Rotate.Z_AXIS);

        rightForeLegGroup.setTranslateX(mStart.x);
        if (mUpperLeg.getDownBody().getUpperBody().getNeck().getHead().getStickman().mType == Gender.TYPE.MALE)
            rightForeLegGroup.setTranslateY(mStart.y + 59);
         else
            rightForeLegGroup.setTranslateY(mStart.y + 49);
        rightForeLegGroup.setTranslateZ(0);

        rightForeLegGroup.getTransforms().clear();
        rightForeLegGroup.getTransforms().addAll(rx, ry, rz);

        switch (mShape)
        {
            case FADEIN:
                if (step == 2)
                {
                    mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), 0.0);
                    update();
                    mRightForeLegMesh.setVisible(false);
                } else if (mColor.getOpacity() != 0.0)
                {
                    mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), mColor.getOpacity() - 0.052);
                    update();
                }
                break;

            case FADEOUT:
                mRightForeLegMesh.setVisible(true);

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
        mRightForeLegMesh.setMaterial(material);
    }

    public RightUpperLeg3D getUpperLeg()
    {
        return mUpperLeg;
    }
}
