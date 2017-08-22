/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.body;

import com.interactivemesh.jfx.importer.col.ColModelImporter;
import de.dfki.common.part.Part3D;
import javafx.scene.layout.VBox;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.MeshView;

import java.net.URL;

/**
 * @author Beka
 */
public class RightForeArm3D extends ForeArm
{
    public RightForeArm3D(Part3D arm)
    {
        super(arm);
        mZRotation = -10;

        ColModelImporter importer = new ColModelImporter();
        URL url = getClass().getClassLoader().getResource("BodyParts/Stickman3D/ForeArm.dae");
        importer.read(url);
        foreArmMeshView = (MeshView) importer.getImport()[0];

        material = new PhongMaterial();
        material.setDiffuseColor(mColor);
        foreArmMeshView.setMaterial(material);

        foreArmBox = new VBox();
        foreArmBox.getChildren().add(foreArmMeshView);
        this.getChildren().add(foreArmBox);
        ((RightUpperArm3D)arm).getUpperArmBox().getChildren().add(this);

        init();
    }

    @Override
    public void update()
    {
        material.setDiffuseColor(mColor);
        foreArmMeshView.setMaterial(material);
    }

    public MeshView getMeshView()
    {
        return foreArmMeshView;
    }

    public VBox getForeArmBox()
    {
        return foreArmBox;
    }
}
