package de.dfki.stickman3D.body;

import com.interactivemesh.jfx.importer.col.ColModelImporter;
import de.dfki.common.enums.Gender;
import de.dfki.common.part.Part3D;
import de.dfki.common.util.Preferences;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.MeshView;
import javafx.scene.transform.Rotate;

import java.net.URL;

/**
 * Created by EmpaT on 09.08.2017.
 */
public abstract class UpperLeg extends PartStickman3D
{
    public SHAPE mShape = SHAPE.DEFAULT;
    protected DownBody3D mDownBody;
    protected MeshView upperLegMesh;
    protected PhongMaterial material;
    protected VBox upperLegBox;

    public UpperLeg(Part3D downBody)
    {
        mDownBody = (DownBody3D) downBody;
        mColor = Color.rgb(242, 227, 217, 1);

        mDefaultRotation = 0;
        mXRotation = mDefaultRotation;
        mToDegreeX = mDefaultRotation;
        mXRotationStep = 0.0f;

        URL url;
        if (mDownBody.getUpperBody().getNeck().getHead().getStickman().mType == Gender.TYPE.MALE)
        {
            url = getClass().getClassLoader().getResource("BodyParts/Stickman3D/MaleUpperLeg.dae");
        } else
        {
            url = getClass().getClassLoader().getResource("BodyParts/Stickman3D/FemaleUpperLeg.dae");
        }

        ColModelImporter importer = new ColModelImporter();
        importer.read(url);
        upperLegMesh = (MeshView) importer.getImport()[0];

        material = new PhongMaterial();
        material.setDiffuseColor(mColor);
        upperLegMesh.setMaterial(material);

        upperLegBox = new VBox();
        upperLegBox.getChildren().add(upperLegMesh);
        this.getChildren().add(upperLegBox);
        mDownBody.getChildren().add(this);
    }

    @Override
    public void init()
    {
        super.init();
        if (mDownBody.getUpperBody().getNeck().getHead().getStickman().mType == Gender.TYPE.MALE)
        {
            this.setTranslateX(mStart.x);
            this.setTranslateY(mStart.y);
        } else
        {
            this.setTranslateX(mStart.x);
            this.setTranslateY(mStart.y);
        }
        this.setTranslateZ(0);
    }

    @Override
    public void setShape(String s)
    {
        mShape = SHAPE.valueOf(s);
    }

    @Override
    public void resetShape()
    {
        mShape = RightUpperLeg3D.SHAPE.DEFAULT;
    }

    @Override
    public void calculate(int step)
    {
        float pivitX;
        if(mDownBody.getUpperBody().getNeck().getHead().getStickman().mType == Gender.TYPE.MALE)
        {
            pivitX = Preferences.MALE_UPPER_LEG_WIDTH/2;
        }
        else
        {
            pivitX = Preferences.MALE_UPPER_LEG_WIDTH/2;
        }
        Rotate rx = new Rotate(mXRotation, pivitX, 0, 0, Rotate.X_AXIS);
        Rotate ry = new Rotate(mYRotation, pivitX, 0, 0, Rotate.Y_AXIS);
        Rotate rz = new Rotate(mZRotation, pivitX, 0, 0, Rotate.Z_AXIS);

        this.getTransforms().clear();
        this.getTransforms().addAll(rx, ry, rz);

        executeFadeInFadeOut(upperLegMesh, mShape, step);
    }

    public DownBody3D getDownBody()
    {
        return mDownBody;
    }

    public MeshView getMeshView()
    {
        return upperLegMesh;
    }

    public VBox getUpperLegBox()
    {
        return upperLegBox;
    }
}
