/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.body;

import com.interactivemesh.jfx.importer.col.ColModelImporter;
import de.dfki.common.part.Part3D;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.MeshView;
import javafx.scene.transform.Rotate;

import java.net.URL;

/**
 * @author Beka
 */
public class RightFinger1 extends Finger
{

    public RightFinger1(Part3D rightWrist)
    {
        super(rightWrist);
        mZRotation = -20;

        ColModelImporter importer = new ColModelImporter();
        URL url = getClass().getClassLoader().getResource("BodyParts/Stickman3D/Finger1.dae");
        importer.read(url);
        finger = (MeshView) importer.getImport()[0];

        material = new PhongMaterial();
        material.setDiffuseColor(mColor);
        finger.setMaterial(material);

        ((RightWrist3D)rightWrist).getWristPane().getChildren().add(finger);

        init();
    }

    @Override
    public void calculate(int step)
    {
        Rotate rx = new Rotate(mXRotation, Rotate.X_AXIS);
        Rotate ry = new Rotate(mYRotation, Rotate.Y_AXIS);
        Rotate rz = new Rotate(mZRotation, Rotate.Z_AXIS);

        finger.setTranslateX(mStart.x + 9);
        finger.setTranslateY(mStart.y + 7);
        finger.setTranslateZ(0);

        finger.getTransforms().clear();
        finger.getTransforms().addAll(rx, ry, rz);

        executeFadeInFadeOut(finger, mShape, step);
    }

    @Override
    public void update()
    {
        material.setDiffuseColor(mColor);
        finger.setMaterial(material);
    }

    public MeshView getMeshView()
    {
        return finger;
    }
}
