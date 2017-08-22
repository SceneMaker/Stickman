package de.dfki.stickman3D.body;

import de.dfki.common.part.Part3D;
import de.dfki.common.util.Preferences;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.MeshView;
import javafx.scene.transform.Rotate;

/**
 * Created by EmpaT on 09.08.2017.
 */
public abstract class Wrist extends PartStickman3D
{
    public SHAPE mShape = SHAPE.DEFAULT;
    protected MeshView wristMesh;
    protected PhongMaterial material;
    protected Pane wristPane;

    public Wrist(Part3D foreArm)
    {
        material = new PhongMaterial();
        wristPane = new Pane();
        mColor = Color.rgb(242, 227, 217, 1);
        mToDegreeX = mDefaultRotation;
        mZRotation = 0;

        material.setDiffuseColor(mColor);
    }

    @Override
    public void init()
    {
        super.init();
        wristPane.setTranslateX(-Preferences.FORE_ARM_WIDTH/2 + 12);
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
        Rotate rx = new Rotate(mXRotation, Rotate.X_AXIS);
        Rotate ry = new Rotate(mYRotation, Rotate.Y_AXIS);
        Rotate rz = new Rotate(mZRotation, Rotate.Z_AXIS);

        wristPane.getTransforms().clear();
        wristPane.getTransforms().addAll(rx, ry, rz);

        executeFadeInFadeOut(wristMesh, mShape, step);
    }
}
