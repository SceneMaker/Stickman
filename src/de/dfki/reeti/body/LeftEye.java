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
import javafx.scene.transform.Rotate;

/**
 *
 * @author Beka Aptsiauri
 *
 */
public class LeftEye extends BodyPart
{

    Head mHeadFX;

    URL url;
    ColModelImporter imorter;
    public Group mLeftEarMesh;

    Image im;

    public LeftEye(Head head) {
        mHeadFX = head;
        mSize = new Dimension(mLength, mLength);

        imorter = new ColModelImporter();
        mColor = Color.WHITE;

        url = getClass().getClassLoader().getResource("BodyParts/Reeti/ReetiEye.dae");

        imorter.read(url);
        mLeftEarMesh = (Group) imorter.getImport()[0];
        mXRotation = 5;

        mStart = mHeadFX.getLeftEyebrowPostion();

        init();

        mHeadFX.mHead.getChildren().add(mLeftEarMesh);
    }

    @Override
    public void init() {
        super.init();
        mLeftEarMesh.setTranslateX(mStart.x + 55);
        mLeftEarMesh.setTranslateY(mStart.y + 47);
        mLeftEarMesh.setTranslateZ(-62);
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
