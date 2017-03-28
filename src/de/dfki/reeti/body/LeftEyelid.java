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
public class LeftEyelid extends BodyPartFX {

    Head mHeadFX;

    URL url;
    URL imageUrl;
    Image image;
    ColModelImporter imorter;
    public MeshView mLeftEyeMesh;
    PhongMaterial material;

    public LeftEyelid(Head head) {
        mHeadFX = head;
        mSize = new Dimension(mLength, mLength);

        mZRotation = 30;
        mYRotation = -10;

        imorter = new ColModelImporter();
        mColor = Color.WHITE;

        url = getClass().getClassLoader().getResource("BodyParts/Reeti/ReetiEyelid.dae");
        imageUrl = getClass().getClassLoader().getResource("Images/difuseMap2.png");
        image = new javafx.scene.image.Image(imageUrl.toExternalForm());

        imorter.read(url);
        mLeftEyeMesh = (MeshView) imorter.getImport()[0];

        material = new PhongMaterial();
        material.setDiffuseColor(mColor);
        material.setDiffuseMap(image);
        material.setSelfIlluminationMap(image);
        mLeftEyeMesh.setMaterial(material);

        mStart = mHeadFX.getLeftEyebrowPostion();

        init();

        mHeadFX.mHead.getChildren().add(mLeftEyeMesh);
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
