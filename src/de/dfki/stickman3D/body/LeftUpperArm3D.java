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
import javafx.scene.shape.MeshView;

import java.net.URL;

/**
 * @author Beka
 */
public class LeftUpperArm3D extends UpperArm
{
    public LeftUpperArm3D(Part3D upperBody)
    {
        super(upperBody);
        mStart = mUpperBody.getLeftArmStartPosition();

        ColModelImporter importer = new ColModelImporter();
        URL url = getClass().getClassLoader().getResource("BodyParts/Stickman3D/UpperArm.dae");
        if (mUpperBody.getNeck().getHead().getStickman().mType == Gender.TYPE.MALE)
            mDefaultRotation = -10;
        else
            mDefaultRotation = -15;

        mZRotation = mDefaultRotation;
        mToDegreeX = mDefaultRotation;
        mXRotationStep = 0.0f;

        importer.read(url);
        upperArmMesh = (MeshView) importer.getImport()[0];

        upperArmMesh.setMaterial(material);

        upperArmBox.getChildren().add(upperArmMesh);
        this.getChildren().add(upperArmBox);
        mUpperBody.getChildren().add(this);

        init();
    }

    @Override
    public void update()
    {
        material.setDiffuseColor(mColor);
        upperArmMesh.setMaterial(material);
    }


    @Override
    public MeshView getMeshView()
    {
        return upperArmMesh;
    }

    public VBox getUpperArmBox()
    {
        return upperArmBox;
    }
}
