/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.reeti.body;

import de.dfki.common.part.Part3D;
import javafx.scene.shape.MeshView;

import java.awt.*;

/**
 * @author Beka
 */
public class Neck extends PartReeti
{
    private MeshView neckMeshView;

    public Neck(Part3D head)
    {
        mStart = ((Head) head).getNeckStartPosition();
        mEnd = new Point(mStart.x, mStart.y + mLength);
    }

    public Point getBodyStartPosition()
    {
        return new Point(mEnd.x, mEnd.y + 10);
    }

    @Override
    public void calculate(int step)
    {

    }

    @Override
    public void setShape(String s)
    {

    }
}
