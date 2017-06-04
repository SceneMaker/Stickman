/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.reeti.body;

import java.net.URL;
import com.interactivemesh.jfx.importer.col.ColModelImporter;
import javafx.scene.Group;
import javafx.scene.transform.Rotate;

/**
 * @author Beka Aptsiauri
 */
public class RightEye extends Parts
{
    private Group mRightEarMesh;

    public RightEye(Head head)
    {
        mXRotation = 5;
        mStart = head.getLeftEyebrowPostion();

        URL url = getClass().getClassLoader().getResource("BodyParts/Reeti/ReetiEye.dae");
        ColModelImporter importer = new ColModelImporter();
        importer.read(url);
        mRightEarMesh = (Group) importer.getImport()[0];

        init();

        head.getHeadGroup().getChildren().add(mRightEarMesh);
    }

    @Override
    public void init()
    {
        super.init();
        mRightEarMesh.setTranslateX(mStart.x - 48);
        mRightEarMesh.setTranslateY(mStart.y + 47);
        mRightEarMesh.setTranslateZ(-62);
    }

    @Override
    public void calculate(int step)
    {

        Rotate rx = new Rotate(mXRotation, Rotate.X_AXIS);
        Rotate ry = new Rotate(mYRotation, Rotate.Y_AXIS);
        Rotate rz = new Rotate(mZRotation, Rotate.Z_AXIS);

        mRightEarMesh.getTransforms().clear();
        mRightEarMesh.getTransforms().addAll(rz, ry, rx);

    }
}
