/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.reeti.body;

import com.interactivemesh.jfx.importer.col.ColModelImporter;
import de.dfki.common.part.Part3D;
import javafx.scene.Group;
import javafx.scene.transform.Rotate;

import java.net.URL;

/**
 * @author Beka Aptsiauri
 */
public class LeftEye extends PartReeti
{
    private Group mLeftEarMesh;

    public LeftEye(Part3D head)
    {
        mXRotation = 5;
        mStart = ((Head) head).getLeftEyebrowPostion();

        URL url = getClass().getClassLoader().getResource("BodyParts/Reeti/ReetiEye.dae");
        ColModelImporter importer = new ColModelImporter();
        importer.read(url);
        mLeftEarMesh = (Group) importer.getImport()[0];

        init();

        ((Head) head).getHeadGroup().getChildren().add(mLeftEarMesh);
    }

    @Override
    public void init()
    {
        super.init();
        mLeftEarMesh.setTranslateX(mStart.x + 55);
        mLeftEarMesh.setTranslateY(mStart.y + 47);
        mLeftEarMesh.setTranslateZ(-62);
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
