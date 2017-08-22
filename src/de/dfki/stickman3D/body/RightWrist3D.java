/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.body;

import com.interactivemesh.jfx.importer.col.ColModelImporter;
import de.dfki.common.part.Part3D;
import javafx.scene.layout.Pane;
import javafx.scene.shape.MeshView;

import java.net.URL;

/**
 * @author Beka
 */
public class RightWrist3D extends Wrist
{

    public RightWrist3D(Part3D leftForeArm)
    {
        super(leftForeArm);
        mYRotation = 50;

        ColModelImporter importer = new ColModelImporter();
        URL url = getClass().getClassLoader().getResource("BodyParts/Stickman3D/RightWrist.dae");
        importer.read(url);
        wristMesh = (MeshView) importer.getImport()[0];

        wristMesh.setMaterial(material);
        wristPane.getChildren().add(wristMesh);

        ((RightForeArm3D) leftForeArm).getForeArmBox().getChildren().add(wristPane);

        init();
    }

    @Override
    public void update()
    {
        material.setDiffuseColor(mColor);
        wristMesh.setMaterial(material);
    }

    public MeshView getMeshView()
    {
        return wristMesh;
    }

    public Pane getWristPane()
    {
        return wristPane;
    }

}
