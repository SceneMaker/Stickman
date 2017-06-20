package de.dfki.stickman3D.body;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.interactivemesh.jfx.importer.col.ColModelImporter;
import de.dfki.common.Gender;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.MeshView;
import javafx.scene.transform.Affine;
import javafx.scene.transform.Rotate;

import java.awt.*;
import java.net.URL;

import javafx.scene.transform.Translate;

/**
 * @author Beka Aptsiauri
 */
public class DownBody3D extends BodyPartFX
{

    public enum SHAPE
    {
        DEFAULT, FADEIN, FADEOUT
    }

    public DownBody3D.SHAPE mShape = DownBody3D.SHAPE.DEFAULT;

    private UpperBody3D mUpperBody;
    private Dimension mSize;

    private int mHalfSizeX;
    private static final int DRAWOFFSET = 20;

    private MeshView mBodyMeshView;
    private PhongMaterial material;

    public DownBody3D(UpperBody3D upperBody)
    {
        mUpperBody = upperBody;
        mSize = new Dimension(120, 300);
        mHalfSizeX = mSize.width / 2;
        mStart = mUpperBody.getDownBodyPosition();

        init();
    }

    @Override
    public void init()
    {
        super.init();
        this.setTranslateX(mStart.x);
        this.setTranslateY(mStart.y + 135);
        this.setTranslateZ(-105);

        URL url;
        ColModelImporter importer = new ColModelImporter();
        if (mUpperBody.getNeck().getHead().getStickman().mType == Gender.TYPE.FEMALE)
        {
            url = getClass().getClassLoader().getResource("BodyParts/Stickman3D/DownFemaleBody.dae");
            mColor = Color.rgb(154, 83, 198, 1);
        } else
        {
            url = getClass().getClassLoader().getResource("BodyParts/Stickman3D/DownMaleBody.dae");
            mColor = Color.rgb(14, 134, 122, 1);
        }

        importer.read(url);
        mBodyMeshView = (MeshView) importer.getImport()[0];
        material = new PhongMaterial();
        material.setDiffuseColor(mColor);
        mBodyMeshView.setMaterial(material);
        this.getChildren().addAll(mBodyMeshView);
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
        mShape = DownBody3D.SHAPE.DEFAULT;
    }

    public void calculate(int step)
    {

        Rotate rx = new Rotate(mXRotation, Rotate.X_AXIS);
        Rotate ry = new Rotate(mYRotation, Rotate.Y_AXIS);
        Rotate rz = new Rotate(mZRotation, Rotate.Z_AXIS);

        Translate translation = new Translate(mXTranslation, mYTranslation, mZTranslation);

        this.getTransforms().clear();
        this.getTransforms().addAll(rx, ry, rz, translation);

        switch (mShape)
        {
            case FADEIN:
                if (step == 2)
                {
                    mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), 0.0);
                    update();
                    mBodyMeshView.setVisible(false);
                } else if (mColor.getOpacity() != 0.0)
                {
                    mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), mColor.getOpacity() - 0.052);
                    update();
                }
                break;

            case FADEOUT:
                mBodyMeshView.setVisible(true);

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


    public void update()
    {
        material.setDiffuseColor(mColor);
        mBodyMeshView.setMaterial(material);
    }

    public void rotatePerlinNoise(double mWobble, int x, int y)
    {
        Affine af = new Affine();
        // Out put perlin noise
        af.appendRotation(Math.toRadians(mWobble), x, y);
        this.getTransforms().clear();
        this.getTransforms().add(af);

    }

    public UpperBody3D getUpperBody()
    {
        return mUpperBody;
    }

    public MeshView getBodyMeshView()
    {
        return mBodyMeshView;
    }
}
