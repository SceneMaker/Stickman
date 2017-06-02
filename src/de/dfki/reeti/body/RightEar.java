/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.reeti.body;

import java.awt.Dimension;
import java.net.URL;

import com.interactivemesh.jfx.importer.col.ColModelImporter;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.MeshView;
import javafx.scene.transform.Rotate;

/**
 * @author Beka Aptsiauri
 */
public class RightEar extends BodyPart
{

    private MeshView mRightEarMesh;

    private int regulator;

    public RightEar(Head head)
    {
        mColor = Color.WHITE;

        ColModelImporter importer = new ColModelImporter();
        URL url = getClass().getClassLoader().getResource("BodyParts/Reeti/ReetiRightEar.dae");

        importer.read(url);
        mRightEarMesh = (MeshView) importer.getImport()[0];
        mRightEarMesh.setMaterial(getMaterial());

        mStart = head.getLeftEyebrowPostion();

        init();

        head.getHeadGroup().getChildren().add(mRightEarMesh);
    }

    @Override
    public void init()
    {
        super.init();
        mRightEarMesh.setTranslateX(mStart.x - 80);
        mRightEarMesh.setTranslateY(mStart.y + 57);
        mRightEarMesh.setTranslateZ(0);
    }

    @Override
    public void calculate(int step)
    {
        Rotate rx = new Rotate(mXRotation, Rotate.X_AXIS);
        Rotate ry = new Rotate(mYRotation, Rotate.Y_AXIS);
        Rotate rz = new Rotate(mZRotation, Rotate.Z_AXIS);

        mRightEarMesh.getTransforms().clear();
        mRightEarMesh.getTransforms().addAll(rz, ry, rx);
    }
}
