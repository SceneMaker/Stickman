/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.body;

import com.interactivemesh.jfx.importer.col.ColModelImporter;
import de.dfki.common.part.Part3D;
import de.dfki.common.util.Preferences;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.MeshView;

import java.awt.*;
import java.net.URL;

/**
 * @author Beka Aptsiauri
 */
public class LeftEar3D extends Ear
{

    public LeftEar3D(Part3D head)
    {
        super(head);
        mStart = mHead.getLeftEarStartPosition();

        ColModelImporter importer = new ColModelImporter();
        URL url = getClass().getClassLoader().getResource("BodyParts/Stickman3D/leftEar.dae");
        URL imageUrl = getClass().getClassLoader().getResource("Images/difuseMap1.png");
        Image image = new Image(imageUrl.toExternalForm());

        importer.read(url);
        earMesh = (MeshView) importer.getImport()[0];

        material.setDiffuseColor(mColor);
        material.setDiffuseMap(image);
        earMesh.setMaterial(material);

        this.getChildren().add(earMesh);
        mHead.getChildren().add(this);

        init();

    }

    @Override
    public void update()
    {
        material.setDiffuseColor(mColor);
        earMesh.setMaterial(material);
    }

    @Override
    protected void recordColor()
    {
        if (!mHead.getStickman().setCharacterInvisible)
            mColorRecorder = mColor;
    }
}
