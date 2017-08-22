package de.dfki.stickman3D.body;

import de.dfki.common.part.Part3D;
import de.dfki.common.util.Preferences;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.MeshView;
import javafx.scene.transform.Rotate;

/**
 * Created by EmpaT on 09.08.2017.
 */
public abstract class ForeArm extends PartStickman3D
{
    public SHAPE mShape = SHAPE.DEFAULT;
    protected MeshView foreArmMeshView;
    protected PhongMaterial material;
    protected VBox foreArmBox;

    public ForeArm(Part3D arm)
    {
        mColor = Color.rgb(242, 227, 217, 1);
        mXRotation = -15;
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

    @Override
    public void calculate(int step)
    {
        Rotate rx = new Rotate(mXRotation, Preferences.FORE_ARM_WIDTH/2, 0, 0, Rotate.X_AXIS);
        Rotate ry = new Rotate(mYRotation, Preferences.FORE_ARM_WIDTH/2, 0, 0, Rotate.Y_AXIS);
        Rotate rz = new Rotate(mZRotation, Preferences.FORE_ARM_WIDTH/2, 0, 0, Rotate.Z_AXIS);

        this.getTransforms().clear();
        this.getTransforms().addAll(rx, ry, rz);

        executeFadeInFadeOut(foreArmMeshView, mShape, step);
    }
}
