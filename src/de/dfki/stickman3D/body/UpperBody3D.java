package de.dfki.stickman3D.body;

import com.interactivemesh.jfx.importer.col.ColModelImporter;
import de.dfki.common.Gender;
import de.dfki.stickman3D.Stickman3D;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.MeshView;
import javafx.scene.transform.Affine;
import javafx.scene.transform.Rotate;

import java.awt.*;
import java.net.URL;

import javafx.scene.transform.Translate;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author Beka Aptsiauri
 */
public class UpperBody3D extends BodyPartFX
{

    public enum SHAPE
    {
        DEFAULT, FADEIN, FADEOUT
    }

    public UpperBody3D.SHAPE mShape = UpperBody3D.SHAPE.DEFAULT;

    private Neck3D mNeck;


    private Dimension mSize;

    private int mHalfSizeX;
    private static final int DRAWOFFSET = 20;

    private MeshView mBodyMeshView;
    private PhongMaterial material;

    public UpperBody3D(Neck3D neck)
    {
        mNeck = neck;
        mSize = new Dimension(120, 300);
        mStart = mNeck.getBodyStartPosition();
        mHalfSizeX = mSize.width / 2;

        init();
    }

    @Override
    public void init()
    {
        super.init();
        this.setTranslateX(mStart.x);
        if (mNeck.getHead().getStickman().mType == Gender.TYPE.MALE)
            this.setTranslateY(mStart.y + 155);
         else
            this.setTranslateY(mStart.y + 135);
        this.setTranslateZ(-105);

        ColModelImporter importer = new ColModelImporter();
        URL url;
        if (mNeck.getHead().getStickman().mType == Gender.TYPE.FEMALE)
        {
            url = getClass().getClassLoader().getResource("BodyParts/Stickman3D/UpperFemaleBody.dae");
            mColor = Color.rgb(154, 83, 198, 1);
        } else
        {
            url = getClass().getClassLoader().getResource("BodyParts/Stickman3D/UpperMaleBody.dae");
            mColor = Color.rgb(14, 134, 122, 1);
        }

        importer.read(url);
        mBodyMeshView = (MeshView) importer.getImport()[0];
        material = new PhongMaterial();
        material.setDiffuseColor(mColor);
        mBodyMeshView.setMaterial(material);
        this.getChildren().addAll(mBodyMeshView);
    }

    public Point getUpperBodyPosition()
    {
        return new Point(mStart.x, mStart.y + 135);
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
        mShape = UpperBody3D.SHAPE.DEFAULT;
    }

    @Override
    public void calculate(int step)
    {

        // Setze PivotElement entsprechend der Y-Translation
        Rotate rx = new Rotate(mXRotation, 0, mYTranslation, 0, Rotate.X_AXIS);
        Rotate ry = new Rotate(mYRotation, 0, mYTranslation, 0, Rotate.Y_AXIS);
        Rotate rz = new Rotate(mZRotation, 0, mYTranslation, 0, Rotate.Z_AXIS);

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

    public Point getLeftArmStartPostion()
    {
        return new Point(mStart.x - 39, mStart.y - 178);
    }

    public Point getDownBodyPosition()
    {
        return new Point(mStart.x, mStart.y);
    }

    public Point getRightArmStartPostion()
    {
        return new Point(mStart.x - 90, mStart.y - 178);
    }

    public Point getLeftLegStartPostion()
    {
        if (mNeck.getHead().getStickman().mOrientation == Stickman3D.ORIENTATION.LEFT)
        {
            return new Point(mStart.x + mHalfSizeX - DRAWOFFSET, mSize.height);
        } else
        {
            return new Point(mStart.x + mHalfSizeX - DRAWOFFSET - 20,
                    (mNeck.getHead().getStickman().mType == Gender.TYPE.FEMALE) ? mSize.height + 3 : mSize.height);
        }
    }

    public Point getRightLegStartPostion()
    {
        if (mNeck.getHead().getStickman().mOrientation == Stickman3D.ORIENTATION.RIGHT)
        {
            return new Point(mStart.x, mSize.height);
        } else
        {
            return new Point(mStart.x - mHalfSizeX + DRAWOFFSET + 20,
                    (mNeck.getHead().getStickman().mType == Gender.TYPE.FEMALE) ? mSize.height + 5 : mSize.height);
        }
    }

    @Override
    public void update()
    {
        material.setDiffuseColor(mColor);
        mBodyMeshView.setMaterial(material);
    }

    @Override
    public void rotatePerlinNoise(double mWobble, int x, int y)
    {
        Affine af = new Affine();
        // Out put perlin noise
        af.appendRotation(Math.toRadians(mWobble), x, y);
        this.getTransforms().clear();
        this.getTransforms().add(af);

    }

    public Neck3D getNeck()
    {
        return mNeck;
    }

    public MeshView getBodyMeshView()
    {
        return mBodyMeshView;
    }
}
