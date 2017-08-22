package de.dfki.stickman3D.body;

import de.dfki.common.part.Part3D;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.MeshView;

/**
 * Created by EmpaT on 08.08.2017.
 */
public abstract class Finger extends PartStickman3D
{
    public SHAPE mShape = SHAPE.DEFAULT;
    protected MeshView finger;
    protected PhongMaterial material;

    public Finger(Part3D leftWrist)
    {
        mColor = Color.rgb(242, 227, 217, 1);
        mDefaultRotation = -20;
        mZRotation = 0;
        mToDegreeX = mDefaultRotation;
    }

    @Override
    public void setShape(String s)
    {
        mShape = SHAPE.valueOf(s);
    }

    @Override
    public void resetShape()
    {
        mShape = SHAPE.DEFAULT;
    }
}
