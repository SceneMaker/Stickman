/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.reeti.body;

import java.net.URL;

import com.interactivemesh.jfx.importer.col.ColModelImporter;

import javafx.scene.paint.Color;
import javafx.scene.shape.MeshView;
import javafx.scene.transform.Rotate;

/**
 *
 * @author Beka Aptsiauri
 *
 */
public class RightEyelid extends Parts
{
    private MeshView mLeftEyeMesh;

    public RightEyelid(Head head) {
        mStart = head.getLeftEyebrowPostion();
        mZRotation = -30;
        mYRotation = 15;
        mColor = Color.WHITE;

        URL url = getClass().getClassLoader().getResource("BodyParts/Reeti/ReetiEyelid.dae");
        ColModelImporter imorter = new ColModelImporter();
        imorter.read(url);
        mLeftEyeMesh = (MeshView) imorter.getImport()[0];

        mLeftEyeMesh.setMaterial(getMaterial());

        init();

        head.getHeadGroup().getChildren().add(mLeftEyeMesh);
    }

    @Override
    public void init() {
        super.init();
        mLeftEyeMesh.setTranslateX(mStart.x - 50);
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
