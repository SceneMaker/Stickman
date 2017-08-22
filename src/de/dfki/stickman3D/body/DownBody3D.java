package de.dfki.stickman3D.body;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.interactivemesh.jfx.importer.col.ColModelImporter;
import de.dfki.common.enums.Gender;
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

/**
 * @author Beka Aptsiauri
 */
public class DownBody3D extends PartStickman3D
{

    public SHAPE mShape = SHAPE.DEFAULT;

    private UpperBody3D mUpperBody;
    private MeshView mBodyMeshView;
    private PhongMaterial material;

    public DownBody3D(Part3D upperBody)
    {
        mUpperBody = (UpperBody3D) upperBody;
        mStart = mUpperBody.getDownBodyPosition();

        init();
    }

    @Override
    public void init()
    {
        super.init();
        this.setTranslateX(mStart.x);
        this.setTranslateY(mStart.y);
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
        mShape = SHAPE.valueOf(s);
    }

    @Override
    public void resetShape()
    {
        mShape = DownBody3D.SHAPE.DEFAULT;
    }

    public void calculate(int step)
    {
        double pivotX;
        double pivotY = 0;
        double pivotZ = 0;
        if(mUpperBody.getNeck().getHead().getStickman().mType == Gender.TYPE.MALE)
        {
            pivotX = Preferences.MALE_DOWN_BODY_WIDTH/2;
        }
        else
        {
            pivotX = Preferences.FEMALE_DOWN_BODY_WIDTH/2;
        }

        Translate translation = new Translate(mXTranslation, mYTranslation, mZTranslation);
        Rotate rx = new Rotate(mXRotation, pivotX, pivotY, pivotZ, Rotate.X_AXIS);
        Rotate ry = new Rotate(mYRotation, pivotX, pivotY, pivotZ, Rotate.Y_AXIS);
        Rotate rz = new Rotate(mZRotation, pivotX, pivotY, pivotZ, Rotate.Z_AXIS);

        this.getTransforms().clear();
        this.getTransforms().addAll(rx, ry, rz, translation);

        executeFadeInFadeOut(mBodyMeshView, mShape, step);
    }

    public Point getRightUpperLegStartPosition()
    {
        if(mUpperBody.getNeck().getHead().getStickman().mType == Gender.TYPE.MALE)
        {
            return new Point(Preferences.MALE_DOWN_BODY_WIDTH / 12,
                    Preferences.MALE_DOWN_BODY_HEIGHT - 4);
        }
        else
        {
            return new Point(Preferences.FEMALE_DOWN_BODY_WIDTH / 3,
                    Preferences.FEMALE_DOWN_BODY_HEIGHT - 10);
        }

    }

    public Point getLeftUpperLegStartPosition()
    {
        if(mUpperBody.getNeck().getHead().getStickman().mType == Gender.TYPE.MALE)
        {
            return new Point(Preferences.MALE_DOWN_BODY_WIDTH - Preferences.MALE_DOWN_BODY_WIDTH / 4,
                    Preferences.MALE_DOWN_BODY_HEIGHT - 4);
        }
        else
        {
            return new Point(Preferences.FEMALE_DOWN_BODY_WIDTH - Preferences.FEMALE_DOWN_BODY_WIDTH / 3 - 10,
                    Preferences.FEMALE_DOWN_BODY_HEIGHT - 10);
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

    @Override
    public MeshView getMeshView()
    {
        return mBodyMeshView;
    }
}
