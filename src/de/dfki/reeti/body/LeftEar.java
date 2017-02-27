/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.reeti.body;

import java.awt.Dimension;
import java.net.URL;

import com.interactivemesh.jfx.importer.col.ColModelImporter;
import javafx.scene.Group;

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
public class LeftEar extends BodyPartFX {

    Head mHeadFX;

    URL url;
    ColModelImporter imorter;
    public MeshView mLeftEarMesh;
    PhongMaterial material;
    URL imageUrl;
    Image image;

    Image im;

    public LeftEar(Head head) {
        mHeadFX = head;
        mSize = new Dimension(mLength, mLength);

        imorter = new ColModelImporter();
        mColor = Color.WHITE;

        url = getClass().getClassLoader().getResource("BodyParts/Reeti/ReetiLeftEar.dae");
        imageUrl = getClass().getClassLoader().getResource("Images/difuseMap2.png");
        image = new Image(imageUrl.toExternalForm());

        imorter.read(url);
        mLeftEarMesh = (MeshView) imorter.getImport()[0];
        material = new PhongMaterial();
        material.setDiffuseColor(mColor);
        material.setDiffuseMap(image);
        material.setSelfIlluminationMap(image);
        mLeftEarMesh.setMaterial(material);

        mStart = mHeadFX.getLeftEyebrowPostion();

        init();

        mHeadFX.mHead.getChildren().add(mLeftEarMesh);
    }

    @Override
    public void init() {
        super.init();
        mLeftEarMesh.setTranslateX(mStart.x + 80);
        mLeftEarMesh.setTranslateY(mStart.y + 57);
        mLeftEarMesh.setTranslateZ(0);
    }

    @Override
    public void calculate(int step) {
        Rotate rx = new Rotate(mXRotation, Rotate.X_AXIS);
        Rotate ry = new Rotate(mYRotation, Rotate.Y_AXIS);
        Rotate rz = new Rotate(mZRotation, Rotate.Z_AXIS);

        mLeftEarMesh.getTransforms().clear();
        mLeftEarMesh.getTransforms().addAll(rz, ry, rx);
    }
}
