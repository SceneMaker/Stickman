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
 *
 * @author Beka Aptsiauri
 *
 */
public class LeftEyelid extends BodyPart
{

    private MeshView mLeftEyeMesh;

    public LeftEyelid(Head head) {
        mStart = head.getLeftEyebrowPostion();
        mZRotation = 30;
        mYRotation = -10;
        mColor = Color.WHITE;

        URL url = getClass().getClassLoader().getResource("BodyParts/Reeti/ReetiEyelid.dae");
        ColModelImporter importer = new ColModelImporter();
        importer.read(url);
        mLeftEyeMesh = (MeshView) importer.getImport()[0];

        mLeftEyeMesh.setMaterial(getMaterial());

        init();

        head.getHeadGroup().getChildren().add(mLeftEyeMesh);
    }

    @Override
    public void init() {
        super.init();
        mLeftEyeMesh.setTranslateX(mStart.x + 55);
        mLeftEyeMesh.setTranslateY(mStart.y + 45);
        mLeftEyeMesh.setTranslateZ(-65);
    }

    @Override
    public void calculate(int step) {

        Rotate rx = new Rotate(mXRotation, Rotate.X_AXIS);
        Rotate ry = new Rotate(mYRotation, Rotate.Y_AXIS);
        Rotate rz = new Rotate(mZRotation, Rotate.Z_AXIS);

        mLeftEyeMesh.getTransforms().clear();
        mLeftEyeMesh.getTransforms().addAll(rz, ry, rx);

    }
}
