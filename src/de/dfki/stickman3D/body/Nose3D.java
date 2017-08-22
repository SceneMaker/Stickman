/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.body;

import com.interactivemesh.jfx.importer.col.ColModelImporter;
import de.dfki.common.part.Part3D;
import de.dfki.common.util.Preferences;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.MeshView;

import java.awt.*;
import java.net.URL;

/**
 * @author Beka Aptsiauri
 */
public class Nose3D extends PartStickman3D
{

    public SHAPE mShape = SHAPE.DEFAULT;
    private Head3D mHead;
    private MeshView mNose;
    private PhongMaterial material;

    public Nose3D(Part3D head)
    {
        mHead = (Head3D) head;
        mStart = mHead.getNoseStartPosition();
        mColor = Color.rgb(242, 227, 217, 1);

        ColModelImporter importer = new ColModelImporter();
        URL url = getClass().getClassLoader().getResource("BodyParts/Stickman3D/nose.dae");
        importer.read(url);
        mNose = (MeshView) importer.getImport()[0];

        material = new PhongMaterial();
        material.setDiffuseColor(mColor);
        mNose.setMaterial(material);

        this.getChildren().add(mNose);
        mHead.getChildren().add(this);
        init();
    }

    @Override
    public void init()
    {
        super.init();
        this.setTranslateX(mStart.x);
        this.setTranslateY(mStart.y);
        this.setTranslateZ(Preferences.FACE_PARTS_Z_POS);
    }

    @Override
    public void setShape(String s)
    {
        mShape = SHAPE.valueOf(s);
    }

    @Override
    public void resetShape()
    {
        mShape = Nose3D.SHAPE.DEFAULT;
    }

    @Override
    public void calculate(int step)
    {
        executeFadeInFadeOut(mNose, mShape, step);
    }

    @Override
    public void update()
    {
        material.setDiffuseColor(mColor);
        mNose.setMaterial(material);
    }

    @Override
    protected void recordColor()
    {
        if (!mHead.getStickman().setCharacterInvisible)
        {
            mColorRecorder = mColor;
        }
    }

    @Override
    public MeshView getMeshView()
    {
        return mNose;
    }
}
