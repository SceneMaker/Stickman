package de.dfki.reeti.body;

import com.interactivemesh.jfx.importer.col.ColModelImporter;
import de.dfki.common.Gender;
import de.dfki.reeti.Reeti;
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
 *
 * @author Beka Aptsiauri
 *
 */
public class Body extends BodyPartFX {

    NeckFX mNeckFX;
    Rotate rx;
    Rotate ry;
    Rotate rz;

    Dimension mSize = new Dimension(120, 300);

    int mHalfSizeX = mSize.width / 2;
    int mHalfSizeY = mSize.height / 2;
    int mDrawOffset = 20;

    public Group mUpperBodyGroup;

    URL url;
    ColModelImporter imorter;
    public MeshView mBodyMeshView;
    PhongMaterial material;

    URL imageUrl;
    Image image;

    public Body(NeckFX neck) {
        mNeckFX = neck;
        mStart = mNeckFX.getBodyStartPosition();
        imorter = new ColModelImporter();

        url = getClass().getClassLoader().getResource("BodyParts/Reeti/ReetiBody.dae");
        imageUrl = getClass().getClassLoader().getResource("Images/difuseMap2.png");
        image = new javafx.scene.image.Image(imageUrl.toExternalForm());
        mColor = Color.WHITE;

        imorter.read(url);
        mUpperBodyGroup = new Group();
        mBodyMeshView = (MeshView) imorter.getImport()[0];
        mBodyMeshView.setId("uppeBody");
        material = new PhongMaterial();
        material.setDiffuseColor(mColor);
        material.setDiffuseMap(image);
        material.setSelfIlluminationMap(image);
//        mBodyMeshView.setMaterial(material);
        mUpperBodyGroup.getChildren().add(mBodyMeshView);

        mStart = mNeckFX.getBodyStartPosition();
        init();
        this.getChildren().addAll(mUpperBodyGroup);
    }

    @Override
    public void init() {
        super.init();
        mUpperBodyGroup.setTranslateX(mStart.x);
        mUpperBodyGroup.setTranslateY(mStart.y + 290);
        mUpperBodyGroup.setTranslateZ(-105);
    }

    public Point getUpperBodyPosition() {
        return new Point(mStart.x, mStart.y + 135);
    }

    @Override
    public void calculate(int step) {

        rx = new Rotate(mXRotation, Rotate.X_AXIS);
        ry = new Rotate(mYRotation, Rotate.Y_AXIS);
        rz = new Rotate(mZRotation, Rotate.Z_AXIS);

        mUpperBodyGroup.getTransforms().clear();
        mUpperBodyGroup.getTransforms().addAll(rx, ry, rz);

    }

}
