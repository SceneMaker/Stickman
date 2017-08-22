/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.body;

import com.interactivemesh.jfx.importer.col.ColModelImporter;
import de.dfki.common.enums.Gender;
import de.dfki.common.part.Part3D;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.MeshView;

import java.net.URL;

/**
 * @author Beka
 */
public class RightForeLeg3D extends ForeLeg
{
    public RightForeLeg3D(Part3D rightUpperLeg)
    {
        super(rightUpperLeg);
        mUpperLeg = (RightUpperLeg3D) rightUpperLeg;
        mColor = Color.rgb(242, 227, 217, 1);

        URL url;
        if (mUpperLeg.getDownBody().getUpperBody().getNeck().getHead().getStickman().mType == Gender.TYPE.MALE)
        {
            url = getClass().getClassLoader().getResource("BodyParts/Stickman3D/MaleForeLeg.dae");
        } else
        {
            url = getClass().getClassLoader().getResource("BodyParts/Stickman3D/FemaleForeLeg.dae");
        }

        ColModelImporter importer = new ColModelImporter();
        importer.read(url);
        foreLegMesh = (MeshView) importer.getImport()[0];

        material = new PhongMaterial();
        material.setDiffuseColor(mColor);
        foreLegMesh.setMaterial(material);

        foreLegBox = new VBox();
        foreLegBox.getChildren().add(foreLegMesh);
        this.getChildren().add(foreLegBox);
        mUpperLeg.getUpperLegBox().getChildren().add(this);

        init();
    }

    @Override
    public void update()
    {
        material.setDiffuseColor(mColor);
        foreLegMesh.setMaterial(material);
    }

    public UpperLeg getUpperLeg()
    {
        return mUpperLeg;
    }

    @Override
    public MeshView getMeshView()
    {
        return foreLegMesh;
    }
}
