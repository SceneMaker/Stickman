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
public class LeftFinger3 extends Finger
{
    public LeftFinger3(Part3D leftWrist)
    {
        super(leftWrist);

        ColModelImporter importer = new ColModelImporter();
        URL url = getClass().getClassLoader().getResource("BodyParts/Stickman3D/Finger2_3_4.dae");
        importer.read(url);
        finger = (MeshView) importer.getImport()[0];

        material = new PhongMaterial();
        material.setDiffuseColor(mColor);
        finger.setMaterial(material);

        ((LeftWrist3D) leftWrist).getWristPane().getChildren().add(finger);

        init();
    }


    @Override
    public void calculate(int step)
    {
        Rotate rx = new Rotate(mXRotation, Rotate.X_AXIS);
        Rotate ry = new Rotate(mYRotation, Rotate.Y_AXIS);
        Rotate rz = new Rotate(mZRotation, Rotate.Z_AXIS);

        finger.setTranslateX(mStart.x + 1);
        finger.setTranslateY(mStart.y + 17);
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
