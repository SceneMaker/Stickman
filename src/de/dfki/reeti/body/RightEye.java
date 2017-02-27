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
public class RightEye extends BodyPartFX {

    public static enum SHAPE {
        DEFAULT, FADEIN, FADEOUT
    };

    HeadFX mHeadFX;

    URL url;
    ColModelImporter imorter;
    public Group mRightEarMesh;

    public RightEye(HeadFX head) {
        mHeadFX = head;
        mSize = new Dimension(mLength, mLength);

        imorter = new ColModelImporter();

        url = getClass().getClassLoader().getResource("BodyParts/Reeti/ReetiEye.dae");

        imorter.read(url);
        mRightEarMesh = (Group) imorter.getImport()[0];
        mXRotation = 5;
        
        mStart = mHeadFX.getLeftEyebrowPostion();

        init();

        mHeadFX.mHead.getChildren().add(mRightEarMesh);
    }

    @Override
    public void init() {
        super.init();
        mRightEarMesh.setTranslateX(mStart.x - 48);
        mRightEarMesh.setTranslateY(mStart.y + 47);
        mRightEarMesh.setTranslateZ(-62);
    }

    @Override
    public void calculate(int step) {

        Rotate rx = new Rotate(mXRotation, Rotate.X_AXIS);
        Rotate ry = new Rotate(mYRotation, Rotate.Y_AXIS);
        Rotate rz = new Rotate(mZRotation, Rotate.Z_AXIS);

        mRightEarMesh.getTransforms().clear();
        mRightEarMesh.getTransforms().addAll(rz, ry, rx);

    }
}
