/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.reeti.body;

import com.interactivemesh.jfx.importer.col.ColModelImporter;
import de.dfki.common.part.Part3D;
import de.dfki.common.util.Preferences;
import javafx.scene.Group;
import javafx.scene.transform.Rotate;

import java.awt.*;
import java.net.URL;

/**
 * @author Beka Aptsiauri
 */
public class RightEye extends PartReeti
{
    public RightEye(Part3D head)
    {
        mXRotation = 5;
        mStart = ((Head) head).getRightEyeStartPosition();

        URL url = getClass().getClassLoader().getResource("BodyParts/Reeti/ReetiEye.dae");
        ColModelImporter importer = new ColModelImporter();
        importer.read(url);
        Group rightEyeGroup = (Group) importer.getImport()[0];

        init();

        this.getChildren().add(rightEyeGroup);
        head.getChildren().add(this);
    }

    @Override
    public void init()
    {
        super.init();
        this.setTranslateX(mStart.x);
        this.setTranslateY(mStart.y);
        this.setTranslateZ(-37);
    }

    @Override
    public void calculate(int step)
    {
        double pivotX = Preferences.REETI_EYE_WIDTH/2;
        double pivotY = Preferences.REETI_EYE_HEIGHT/2;

        Rotate rx = new Rotate(mXRotation, pivotX, pivotY, 0, Rotate.X_AXIS);
        Rotate ry = new Rotate(mYRotation, pivotX, pivotY, 0, Rotate.Y_AXIS);
        Rotate rz = new Rotate(mZRotation, pivotX, pivotY, 0, Rotate.Z_AXIS);

        this.getTransforms().clear();
        this.getTransforms().addAll(rz, ry, rx);

    }

    @Override
    public void setShape(String s)
    {

    }
}
