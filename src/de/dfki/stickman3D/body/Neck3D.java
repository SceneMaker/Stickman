/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.body;

import com.interactivemesh.jfx.importer.col.ColModelImporter;
import de.dfki.common.enums.Gender;
import de.dfki.common.part.Part3D;
import de.dfki.common.util.Preferences;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.MeshView;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;

import java.awt.*;
import java.net.URL;

/**
 * @author Beka
 */
public class Neck3D extends PartStickman3D
{

    public SHAPE mShape = SHAPE.DEFAULT;
    private Head3D mHead;
    private MeshView neckMeshView;
    private PhongMaterial material;

    public Neck3D(Part3D head)
    {
        mHead = (Head3D) head;
        mColor = Color.rgb(242, 227, 217, 1);
        mStart = mHead.getNeckStartPosition();
        if(((Head3D) head).getStickman().mType == Gender.TYPE.MALE)
        {
            mEnd = new Point(mStart.x - Preferences.MALE_UPPER_BODY_WIDTH / 2 + 3,
                    mStart.y + Preferences.NECK_HEIGHT - 3);
        }
        else
        {
            mEnd = new Point(mStart.x - Preferences.FEMALE_UPPER_BODY_WIDTH / 2 + 3,
                    mStart.y + Preferences.NECK_HEIGHT - 3);
        }

        material = new PhongMaterial();
        material.setDiffuseColor(mColor);

        URL url = getClass().getClassLoader().getResource("BodyParts/Stickman3D/neck.dae");
        ColModelImporter imorter = new ColModelImporter();
        imorter.read(url);
        neckMeshView = (MeshView) imorter.getImport()[0];
        neckMeshView.setMaterial(material);
        this.getChildren().add(neckMeshView);

        init();
    }

    @Override
    public void init()
    {
        super.init();
        this.setTranslateX(mStart.x);
        this.setTranslateY(mStart.y);
        neckMeshView.setTranslateZ(-105);
    }

    @Override
    public void setShape(String s)
    {
        mShape = SHAPE.valueOf(s);
    }

    @Override
    public void resetShape()
    {
        mShape = Neck3D.SHAPE.DEFAULT;
    }

    public Point getUpperBodyStartPosition()
    {
        return new Point(mEnd.x, mEnd.y);
    }

    @Override
    public void calculate(int step)
    {
        Rotate rx = new Rotate(mXRotation, Rotate.X_AXIS);
        Rotate ry = new Rotate(mYRotation, Rotate.Y_AXIS);
        Rotate rz = new Rotate(mZRotation, Rotate.Z_AXIS);

        Translate translation = new Translate(mXTranslation, mYTranslation, mZTranslation);

        neckMeshView.getTransforms().clear();
        neckMeshView.getTransforms().addAll(rx, ry, rz, translation);

        executeFadeInFadeOut(neckMeshView, mShape, step);
    }

    @Override
    public void update()
    {
        material.setDiffuseColor(mColor);
        neckMeshView.setMaterial(material);
    }

    @Override
    protected void recordColor()
    {
        if (!mHead.getStickman().setCharacterInvisible)
        {
            mColorRecorder = mColor;
        }
    }

    public Head3D getHead()
    {
        return mHead;
    }

    @Override
    public MeshView getMeshView()
    {
        return neckMeshView;
    }
}
