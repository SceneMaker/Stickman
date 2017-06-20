/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.body;

import com.interactivemesh.jfx.importer.col.ColModelImporter;
import de.dfki.common.Gender;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.MeshView;
import javafx.scene.transform.Rotate;

import java.net.URL;

/**
 * @author Beka
 */
public class RightFoot3D extends BodyPartFX
{

    public enum SHAPE
    {
        DEFAULT, FADEIN, FADEOUT
    }

    public RightFoot3D.SHAPE mShape = RightFoot3D.SHAPE.DEFAULT;

    private RightForeLeg3D mRightForeLeg;
    private MeshView mRightFootMeshView;
    private PhongMaterial material;

    public RightFoot3D(RightForeLeg3D rightForeLeg)
    {
        mRightForeLeg = rightForeLeg;
        mLength = 20;
        if (mRightForeLeg.getUpperLeg().getDownBody().getUpperBody().getNeck().getHead().getStickman().mType == Gender.TYPE.MALE)
            mColor = Color.rgb(80, 80, 80, 1);
        else
            mColor = Color.rgb(154, 83, 198, 1);
        setDefaulRotation(0);
        mYRotation = 130;
        mXRotation = 0;

        URL url = getClass().getClassLoader().getResource("BodyParts/Stickman3D/foot.dae");
        ColModelImporter im = new ColModelImporter();
        im.read(url);
        mRightFootMeshView = (MeshView) im.getImport()[0];

        material = new PhongMaterial();
        material.setDiffuseColor(mColor.darker());
        mRightFootMeshView.setMaterial(material);

        mRightForeLeg.rightForeLegGroup.getChildren().add(mRightFootMeshView);

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
        mShape = RightFoot3D.SHAPE.DEFAULT;
    }

    @Override
    public void calculate(int step)
    {

        Rotate rx = new Rotate(mXRotation, Rotate.X_AXIS);
        Rotate ry = new Rotate(mYRotation, Rotate.Y_AXIS);
        Rotate rz = new Rotate(mZRotation, Rotate.Z_AXIS);

        mRightFootMeshView.setTranslateX(mStart.x);
        if (mRightForeLeg.getUpperLeg().getDownBody().getUpperBody().getNeck().getHead().getStickman().mType == Gender.TYPE.MALE)
            mRightFootMeshView.setTranslateY(mStart.y + 85);
         else
            mRightFootMeshView.setTranslateY(mStart.y + 80);
        mRightFootMeshView.setTranslateZ(0);

        mRightFootMeshView.getTransforms().clear();
        mRightFootMeshView.getTransforms().addAll(rx, ry, rz);

        switch (mShape)
        {
            case FADEIN:
                if (step == 2)
                {
                    mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), 0.0);
                    update();
                    mRightFootMeshView.setVisible(false);
                } else if (mColor.getOpacity() != 0.0)
                {
                    mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), mColor.getOpacity() - 0.052);
                    update();
                }
                break;

            case FADEOUT:
                mRightFootMeshView.setVisible(true);

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
        mRightFootMeshView.setMaterial(material);
    }

    public MeshView getRightFootMeshView()
    {
        return mRightFootMeshView;
    }
}
