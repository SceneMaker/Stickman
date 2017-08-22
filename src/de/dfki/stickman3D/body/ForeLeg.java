package de.dfki.stickman3D.body;

import de.dfki.common.enums.Gender;
import de.dfki.common.part.Part3D;
import de.dfki.common.util.Preferences;
import javafx.scene.layout.VBox;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.MeshView;
import javafx.scene.transform.Rotate;

/**
 * Created by EmpaT on 09.08.2017.
 */
public abstract class ForeLeg extends PartStickman3D
{
    public SHAPE mShape = SHAPE.DEFAULT;
    protected MeshView foreLegMesh;
    protected PhongMaterial material;
    protected VBox foreLegBox;
    protected UpperLeg mUpperLeg;

    public ForeLeg(Part3D upperLeg)
    {
        mDefaultRotation = -2;
        mXRotation = mDefaultRotation;
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

    public void calculate(int step)
    {
        float pivotX;
        if(mUpperLeg.getDownBody().getUpperBody().getNeck().getHead().getStickman().mType == Gender.TYPE.MALE)
        {
            pivotX = Preferences.MALE_FORE_LEG_WIDTH/2;
        }
        else
        {
            pivotX = Preferences.MALE_FORE_LEG_WIDTH/2;
        }
        Rotate rx = new Rotate(mXRotation, pivotX, 0, 0, Rotate.X_AXIS);
        Rotate ry = new Rotate(mYRotation, pivotX, 0, 0, Rotate.Y_AXIS);
        Rotate rz = new Rotate(mZRotation, pivotX, 0, 0, Rotate.Z_AXIS);

        this.getTransforms().clear();
        this.getTransforms().addAll(rx, ry, rz);

        executeFadeInFadeOut(foreLegMesh, mShape, step);
    }
}
