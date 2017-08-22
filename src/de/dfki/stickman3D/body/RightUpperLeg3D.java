/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.body;

import de.dfki.common.part.Part3D;

/**
 * @author Beka
 */
public class RightUpperLeg3D extends UpperLeg
{

    public RightUpperLeg3D(Part3D downBody)
    {
        super(downBody);
        mStart = mDownBody.getRightUpperLegStartPosition();

        init();
    }

    @Override
    public void update()
    {
        material.setDiffuseColor(mColor);
        upperLegMesh.setMaterial(material);
    }
}
