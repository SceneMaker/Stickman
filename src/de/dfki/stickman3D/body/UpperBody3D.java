package de.dfki.stickman3D.body;

import com.interactivemesh.jfx.importer.col.ColModelImporter;
import de.dfki.common.enums.Gender;
import de.dfki.common.enums.Orientation;
import de.dfki.common.part.Part3D;
import de.dfki.common.util.Preferences;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.MeshView;
import javafx.scene.transform.Affine;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;

import java.awt.*;
import java.net.URL;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author Beka Aptsiauri
 */
public class UpperBody3D extends PartStickman3D
{

    public SHAPE mShape = SHAPE.DEFAULT;
    private Neck3D mNeck;
    private MeshView mBodyMeshView;
    private PhongMaterial material;

    public UpperBody3D(Part3D neck)
    {
        mNeck = (Neck3D) neck;
        mStart = mNeck.getUpperBodyStartPosition();
        init();
    }

    @Override
    public void init()
    {
        super.init();
        this.setTranslateX(mStart.x);
        this.setTranslateY(mStart.y);
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
        return new Point(mStart.x, mStart.y);
    }

    @Override
    public void setShape(String s)
    {
        mShape = SHAPE.valueOf(s);
    }

    @Override
    public void resetShape()
    {
        mShape = UpperBody3D.SHAPE.DEFAULT;
    }

    @Override
    public void calculate(int step)
    {
        float pivotX;
        if(mNeck.getHead().getStickman().mType == Gender.TYPE.MALE)
        {
            pivotX = Preferences.MALE_UPPER_BODY_WIDTH/2;
        }
        else
        {
            pivotX = Preferences.FEMALE_UPPER_BODY_WIDTH/2;
        }
        Rotate rx = new Rotate(mXRotation, pivotX, mYTranslation, 0, Rotate.X_AXIS);
        Rotate ry = new Rotate(mYRotation, pivotX, mYTranslation, 0, Rotate.Y_AXIS);
        Rotate rz = new Rotate(mZRotation, pivotX, mYTranslation, 0, Rotate.Z_AXIS);

        Translate translation = new Translate(mXTranslation, mYTranslation, mZTranslation);

        this.getTransforms().clear();
        this.getTransforms().addAll(rx, ry, rz, translation);

        executeFadeInFadeOut(mBodyMeshView, mShape, step);
    }

    public Point getDownBodyPosition()
    {
        if(mNeck.getHead().getStickman().mType == Gender.TYPE.MALE)
            return new Point(mStart.x - 5, mStart.y + Preferences.MALE_UPPER_BODY_HEIGHT);
        else
            return new Point(mStart.x - 42, mStart.y + Preferences.FEMALE_UPPER_BODY_HEIGHT);
    }

    public Point getLeftArmStartPosition()
    {
        int x;
        int y;
        if(mNeck.getHead().getStickman().mType == Gender.TYPE.MALE)
        {
            x = mStart.x + Preferences.MALE_UPPER_BODY_WIDTH/2 - 7;
            y = mStart.y/22 + 7;
        }
        else
        {
            x = mStart.x - Preferences.FEMALE_UPPER_BODY_WIDTH/2 + 68;
            y = mStart.y/22 + 2;
        }
        return new Point(x,y);
    }

    public Point getRightArmStartPosition()
    {
        int x;
        int y;
        if(mNeck.getHead().getStickman().mType == Gender.TYPE.MALE)
        {
             x = mStart.x - Preferences.MALE_UPPER_BODY_WIDTH/2 + 6;
             y = mStart.y/22 + 7;
        }
        else
        {
            x = mStart.x - Preferences.FEMALE_UPPER_BODY_WIDTH/2 + 32;
            y = mStart.y/22 + 3;
        }
        return new Point(x,y);
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

    @Override
    public MeshView getMeshView()
    {
        return mBodyMeshView;
    }

}
