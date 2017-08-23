package de.dfki.reeti.body;

import com.interactivemesh.jfx.importer.col.ColModelImporter;
import de.dfki.common.part.Part3D;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.MeshView;

import java.awt.*;
import java.net.URL;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author Beka Aptsiauri
 */
public class Body extends PartReeti
{
    public Body(Part3D head)
    {
        mStart = ((Head) head).getBodyStartPosition();
        mSize = new Dimension(120, 300);
        mColor = Color.WHITE;

        init();
    }

    @Override
    public void init()
    {
        super.init();
        ColModelImporter importer = new ColModelImporter();
        URL url = getClass().getClassLoader().getResource("BodyParts/Reeti/ReetiBody.dae");

        importer.read(url);
        MeshView mBodyMeshView = (MeshView) importer.getImport()[0];
        this.setTranslateX(mStart.x);
        this.setTranslateY(mStart.y);
        this.setTranslateZ(-105);
        this.getChildren().add(mBodyMeshView);
    }

    @Override
    public void calculate(int step)
    {

    }

    @Override
    public void setShape(String s)
    {

    }

    public Point getUpperBodyPosition()
    {
        return new Point(mStart.x, mStart.y + 135);
    }

}
