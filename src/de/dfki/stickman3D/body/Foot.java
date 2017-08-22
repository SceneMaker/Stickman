package de.dfki.stickman3D.body;

import de.dfki.common.part.Part3D;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.MeshView;
import javafx.scene.transform.Rotate;

/**
 * Created by EmpaT on 08.08.2017.
 */
public abstract class Foot extends PartStickman3D
{
    public SHAPE mShape = SHAPE.DEFAULT;
    protected MeshView footMeshView;
    protected PhongMaterial material;

    public Foot(Part3D foreLeg)
    {
        setDefaulRotation(0);
        mXRotation = 0;
    }

    @Override
    public void calculate(int step)
    {
        Rotate rx = new Rotate(mXRotation, Rotate.X_AXIS);
        Rotate ry = new Rotate(mYRotation, Rotate.Y_AXIS);
        Rotate rz = new Rotate(mZRotation, Rotate.Z_AXIS);

        this.getTransforms().clear();
        this.getTransforms().addAll(rx, ry, rz);

        executeFadeInFadeOut(footMeshView, mShape, step);
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
