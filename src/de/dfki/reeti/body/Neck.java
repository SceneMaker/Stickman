/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.reeti.body;

import com.interactivemesh.jfx.importer.col.ColModelImporter;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.MeshView;
import javafx.scene.transform.Rotate;

import java.awt.*;
import java.net.URL;
import javafx.scene.transform.Translate;

/**
 *
 * @author Beka
 *
 */
public class Neck extends BodyPartFX {

    Head mHeadFX;

    URL url;
    ColModelImporter imorter;
    public MeshView neckMeshView;

    PhongMaterial material;

    public Neck(Head head) {
        mHeadFX = head;
        mLength = 8;
        mSize = new Dimension(4, mLength);
        mColor = Color.rgb(242, 227, 217, 1);

        material = new PhongMaterial();
        material.setDiffuseColor(mColor);

        url = getClass().getClassLoader().getResource("BodyParts/Reeti/neck.dae");
        imorter = new ColModelImporter();
        imorter.read(url);
        neckMeshView = (MeshView) imorter.getImport()[0];
        neckMeshView.setMaterial(material);

        init();
    }

    public Point getBodyStartPosition() {
        return new Point(mEnd.x, mEnd.y + 10);
    }

    @Override
    public void calculate(int step) {
        mStart = mHeadFX.getNeckStartPosition();
        mEnd = new Point(mStart.x, mStart.y + mLength);

        clearChildren(this);

        neckMeshView.setTranslateX(mStart.x);
        neckMeshView.setTranslateY(mStart.y + 5);
        neckMeshView.setTranslateZ(-105);

        Rotate rx = new Rotate(mXRotation, Rotate.X_AXIS);
        Rotate ry = new Rotate(mYRotation, Rotate.Y_AXIS);
        Rotate rz = new Rotate(mZRotation, Rotate.Z_AXIS);

        Translate translation = new Translate(mXTranslation, mYTranslation, mZTranslation);

        neckMeshView.getTransforms().clear();
        neckMeshView.getTransforms().addAll(rx, ry, rz, translation);

        this.getChildren().add(neckMeshView);
    }
}
