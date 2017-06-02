package de.dfki.reeti.body;

import com.interactivemesh.jfx.importer.col.ColModelImporter;

import java.awt.Dimension;
import java.awt.Point;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.MeshView;
import javafx.scene.transform.Rotate;

import java.net.URL;

import javafx.scene.image.Image;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author Beka Aptsiauri
 */
public class Body extends BodyPart
{
    public Body(Neck neck)
    {
        mStart = neck.getBodyStartPosition();
        mSize = new Dimension(120, 300);
        mColor = Color.WHITE;

        init();
    }

    @Override
    public void init()
    {
        super.init();
        ColModelImporter importer = new ColModelImporter();
        URL url = getClass().getClassLoader().getResource("BodyParts/Reeti/ReetiBody.dae");

        importer.read(url);
        Group mBodyGroup = new Group();
        MeshView mBodyMeshView = (MeshView) importer.getImport()[0];
        mBodyGroup.getChildren().add(mBodyMeshView);
        mBodyGroup.setTranslateX(mStart.x);
        mBodyGroup.setTranslateY(mStart.y + 290);
        mBodyGroup.setTranslateZ(-105);
        this.getChildren().addAll(mBodyGroup);
    }

    public Point getUpperBodyPosition()
    {
        return new Point(mStart.x, mStart.y + 135);
    }

}
