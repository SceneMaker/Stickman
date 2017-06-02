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
 * @author Beka
 */
public class Neck extends BodyPart
{
    private MeshView neckMeshView;

    public Neck(Head head)
    {
        mStart = head.getNeckStartPosition();
        mEnd = new Point(mStart.x, mStart.y + mLength);
    }

    public Point getBodyStartPosition()
    {
        return new Point(mEnd.x, mEnd.y + 10);
    }
}
