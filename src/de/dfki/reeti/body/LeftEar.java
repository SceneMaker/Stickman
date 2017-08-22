/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.reeti.body;

import com.interactivemesh.jfx.importer.col.ColModelImporter;
import de.dfki.common.part.Part3D;
import javafx.scene.paint.Color;
import javafx.scene.shape.MeshView;
import javafx.scene.transform.Rotate;

import java.net.URL;

/**
 * @author Beka Aptsiauri
 */
public class LeftEar extends PartReeti
{
    private MeshView mLeftEarMesh;

    public LeftEar(Part3D head)
    {
        mColor = Color.WHITE;

        ColModelImporter importer = new ColModelImporter();
        URL url = getClass().getClassLoader().getResource("BodyParts/Reeti/ReetiLeftEar.dae");

        importer.read(url);
        mLeftEarMesh = (MeshView) importer.getImport()[0];
        mLeftEarMesh.setMaterial(getMaterial());

        mStart = ((Head) head).getLeftEyebrowPostion();

        init();

        ((Head) head).getHeadGroup().getChildren().add(mLeftEarMesh);
    }

    @Override
    public void init()
    {
        super.init();
        mLeftEarMesh.setTranslateX(mStart.x + 80);
        mLeftEarMesh.setTranslateY(mStart.y + 57);
        mLeftEarMesh.setTranslateZ(0);
    }

    @Override
    public void calculate(int step)
    {
        Rotate rx = new Rotate(mXRotation, Rotate.X_AXIS);
        Rotate ry = new Rotate(mYRotation, Rotate.Y_AXIS);
        Rotate rz = new Rotate(mZRotation, Rotate.Z_AXIS);

        mLeftEarMesh.getTransforms().clear();
        mLeftEarMesh.getTransforms().addAll(rz, ry, rx);
    }

    @Override
    public void setShape(String s)
    {

    }
}
