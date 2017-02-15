/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.reeti.body;

import com.interactivemesh.jfx.importer.col.ColModelImporter;
import java.awt.Dimension;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.MeshView;

import java.net.URL;
import javafx.scene.image.Image;
import javafx.scene.transform.Rotate;

/**
 *
 * @author Beka Aptsiauri
 *
 */
public class NoseFX extends BodyPartFX {

    HeadFX mHeadFX;

    URL url;
    ColModelImporter imorter;
    public MeshView mNose;
    PhongMaterial material;

    URL imageUrl;
    Image image;

    public NoseFX(HeadFX head) {
        mHeadFX = head;
        mSize = new Dimension(mLength, mLength);
        mXRotation = -20;

        imorter = new ColModelImporter();
        mColor = Color.WHITE;

        url = getClass().getClassLoader().getResource("BodyParts/nose.dae");
        imageUrl = getClass().getClassLoader().getResource("Images/difuseMap2.png");
        image = new javafx.scene.image.Image(imageUrl.toExternalForm());

        imorter.read(url);
        mNose = (MeshView) imorter.getImport()[0];

        material = new PhongMaterial();
        material.setDiffuseColor(mColor);
        material.setDiffuseMap(image);
        material.setSelfIlluminationMap(image);
        mNose.setMaterial(material);

        mStart = mHeadFX.getLeftEyebrowPostion();

        init();

        mHeadFX.mHead.getChildren().add(mNose);
    }

    @Override
    public void init() {
        super.init();
        mNose.setTranslateX(mStart.x);
        mNose.setTranslateY(mStart.y + 70);
        mNose.setTranslateZ(-120);
    }

    @Override
    public void calculate(int step) {

        Rotate rx = new Rotate(mXRotation, Rotate.X_AXIS);
        Rotate ry = new Rotate(mYRotation, Rotate.Y_AXIS);
        Rotate rz = new Rotate(mZRotation, Rotate.Z_AXIS);

        mNose.getTransforms().clear();
        mNose.getTransforms().addAll(rz, ry, rx);
    }
}
