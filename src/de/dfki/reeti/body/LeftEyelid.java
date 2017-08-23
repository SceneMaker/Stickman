/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.reeti.body;

import com.interactivemesh.jfx.importer.col.ColModelImporter;
import de.dfki.common.part.Part3D;
import de.dfki.common.util.Preferences;
import javafx.scene.paint.Color;
import javafx.scene.shape.MeshView;
import javafx.scene.transform.Rotate;

import java.awt.*;
import java.net.URL;

/**
 * @author Beka Aptsiauri
 */
public class LeftEyelid extends PartReeti
{
    public LeftEyelid(Part3D head)
    {
        mStart = ((Head) head).getLeftEyeLidStartPosition();
        mZRotation = 30;
        mYRotation = -5;
        mXRotation = 20;
        mColor = Color.WHITE;

        URL url = getClass().getClassLoader().getResource("BodyParts/Reeti/ReetiEyelid1.dae");
        ColModelImporter importer = new ColModelImporter();
        importer.read(url);
        MeshView mLeftEyeMesh = (MeshView) importer.getImport()[0];

        mLeftEyeMesh.setMaterial(getMaterial());

        init();

        this.getChildren().add(mLeftEyeMesh);
        head.getChildren().add(this);
    }

    @Override
    public void init()
    {
        super.init();
        this.setTranslateX(mStart.x);
        this.setTranslateY(mStart.y);
        this.setTranslateZ(-60);
    }

    @Override
    public void calculate(int step)
    {
        double pivotX = Preferences.REETI_LID_WIDTH/2;
        double pivotY = Preferences.REETI_LID_HEIGHT/2;
        double pivotZ = 17;

        Rotate rx = new Rotate(mXRotation, pivotX, pivotY, pivotZ, Rotate.X_AXIS);
        Rotate ry = new Rotate(mYRotation, pivotX, pivotY, pivotZ, Rotate.Y_AXIS);
        Rotate rz = new Rotate(mZRotation, pivotX, pivotY, pivotZ, Rotate.Z_AXIS);

        this.getTransforms().clear();
        this.getTransforms().addAll(rz, ry, rx);

    }

    @Override
    public void setShape(String s)
    {

    }
}
