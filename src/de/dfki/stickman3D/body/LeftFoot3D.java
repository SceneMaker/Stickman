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
public class LeftFoot3D extends BodyPartFX
{

    public enum SHAPE
    {
        DEFAULT, FADEIN, FADEOUT
    }

    public LeftFoot3D.SHAPE mShape = LeftFoot3D.SHAPE.DEFAULT;

    private LeftForeLeg3D mLeftForeLeg;
    private MeshView mLeftFootMeshView;
    private PhongMaterial material;

    public LeftFoot3D(LeftForeLeg3D leftForeLeg)
    {
        mLeftForeLeg = leftForeLeg;
        mLength = 20;
        if (mLeftForeLeg.getUpperLeg().getDownBody().getUpperBody().getNeck().getHead().getStickman().mType == Gender.TYPE.MALE)
            mColor = Color.rgb(80, 80, 80, 1);
         else
            mColor = Color.rgb(154, 83, 198, 1);
        setDefaulRotation(0);
        mYRotation = 50;
        mXRotation = 0;

        URL url = getClass().getClassLoader().getResource("BodyParts/Stickman3D/foot.dae");
        ColModelImporter im = new ColModelImporter();
        im.read(url);
        mLeftFootMeshView = (MeshView) im.getImport()[0];

        material = new PhongMaterial();
        material.setDiffuseColor(mColor.darker());
        mLeftFootMeshView.setMaterial(material);

        mLeftForeLeg.getLeftForeLegGroup().getChildren().add(mLeftFootMeshView);

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
        mShape = LeftFoot3D.SHAPE.DEFAULT;
    }

    @Override
    public void calculate(int step)
    {
        Rotate rx = new Rotate(mXRotation, Rotate.X_AXIS);
        Rotate ry = new Rotate(mYRotation, Rotate.Y_AXIS);
        Rotate rz = new Rotate(mZRotation, Rotate.Z_AXIS);

        mLeftFootMeshView.setTranslateX(mStart.x + 3);
        if (mLeftForeLeg.getUpperLeg().getDownBody().getUpperBody().getNeck().getHead().getStickman().mType == Gender.TYPE.MALE)
            mLeftFootMeshView.setTranslateY(mStart.y + 85);
         else
            mLeftFootMeshView.setTranslateY(mStart.y + 79);
        mLeftFootMeshView.setTranslateZ(0);

        mLeftFootMeshView.getTransforms().clear();
        mLeftFootMeshView.getTransforms().addAll(rx, ry, rz);

        switch (mShape)
        {
            case FADEIN:
                if (step == 2)
                {
                    mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), 0.0);
                    update();
                    mLeftFootMeshView.setVisible(false);
                } else if (mColor.getOpacity() != 0.0)
                {
                    mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), mColor.getOpacity() - 0.052);
                    update();
                }
                break;

            case FADEOUT:
                mLeftFootMeshView.setVisible(true);

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
        mLeftFootMeshView.setMaterial(material);
    }

    public MeshView getLeftFootMeshView()
    {
        return mLeftFootMeshView;
    }
}
