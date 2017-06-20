/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.body;

import com.interactivemesh.jfx.importer.col.ColModelImporter;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.MeshView;
import javafx.scene.transform.Rotate;

import java.awt.*;
import java.net.URL;

import javafx.scene.transform.Translate;

/**
 * @author Beka
 */
public class Neck3D extends BodyPartFX
{

    public enum SHAPE
    {
        DEFAULT, FADEIN, FADEOUT
    }

    private Head3D mHead;
    private MeshView neckMeshView;
    private PhongMaterial material;

    public Neck3D.SHAPE mShape = Neck3D.SHAPE.DEFAULT;

    public Neck3D(Head3D head)
    {
        mHead = head;
        mLength = 8;
        mSize = new Dimension(4, mLength);
        mColor = Color.rgb(242, 227, 217, 1);

        material = new PhongMaterial();
        material.setDiffuseColor(mColor);

        URL url = getClass().getClassLoader().getResource("BodyParts/Stickman3D/neck.dae");
        ColModelImporter imorter = new ColModelImporter();
        imorter.read(url);
        neckMeshView = (MeshView) imorter.getImport()[0];
        neckMeshView.setMaterial(material);

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
        mShape = Neck3D.SHAPE.DEFAULT;
    }

    public Point getBodyStartPosition()
    {
        return new Point(mEnd.x, mEnd.y + 10);
    }

    @Override
    public void calculate(int step)
    {
        mStart = mHead.getNeckStartPosition();
        mEnd = new Point(mStart.x, mStart.y + mLength);

        clearChildren(this);

        neckMeshView.setTranslateX(mStart.x);
        neckMeshView.setTranslateY(mStart.y + 5);
        neckMeshView.setTranslateZ(-105);

        Rotate rx = new Rotate(mXRotation, Rotate.X_AXIS);
        Rotate ry = new Rotate(mYRotation, Rotate.Y_AXIS);
        Rotate rz = new Rotate(mZRotation, Rotate.Z_AXIS);

        Translate translation = new Translate(mXTranslation, mYTranslation, mZTranslation);

        neckMeshView.getTransforms().clear();
        neckMeshView.getTransforms().addAll(rx, ry, rz, translation);

        switch (mShape)
        {
            case FADEIN:
                if (step == 2)
                {
                    mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), 0.0);
                    update();
                    neckMeshView.setVisible(false);
                } else if (mColor.getOpacity() != 0.0)
                {
                    mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), mColor.getOpacity() - 0.052);
                    update();
                }
                break;

            case FADEOUT:
                neckMeshView.setVisible(true);

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

        this.getChildren().add(neckMeshView);
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
        if (mHead.getStickman().setCharacterInvisible == false)
        {
            mColorRecorder = mColor;
        }
    }

    public Head3D getHead()
    {
        return mHead;
    }

    public MeshView getNeckMeshView()
    {
        return neckMeshView;
    }
}
